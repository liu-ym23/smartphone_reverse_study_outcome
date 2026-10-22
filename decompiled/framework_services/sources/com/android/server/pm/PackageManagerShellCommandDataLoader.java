package com.android.server.pm;

import android.content.ComponentName;
import android.content.pm.ArchivedPackageParcel;
import android.content.pm.DataLoaderParams;
import android.content.pm.InstallationFile;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ShellCommand;
import android.service.dataloader.DataLoaderService;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.wm.ActivityTaskManagerService;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerShellCommandDataLoader extends DataLoaderService {
    private static final char ARGS_DELIM = '&';
    private static final String CLASS = null;
    private static final int INVALID_SHELL_COMMAND_ID = -1;
    private static final String PACKAGE = "android";
    private static final String SHELL_COMMAND_ID_PREFIX = "shellCommandId=";
    private static final String STDIN_PATH = "-";
    public static final String TAG = "PackageManagerShellCommandDataLoader";
    private static final int TOO_MANY_PENDING_SHELL_COMMANDS = 10;
    static final SecureRandom sRandom = null;
    static final SparseArray<WeakReference<ShellCommand>> sShellCommands = null;

    private static class DataLoader implements DataLoaderService.DataLoader {
        private DataLoaderService.FileSystemConnector mConnector;
        private DataLoaderParams mParams;

        /* synthetic */ DataLoader(PackageManagerShellCommandDataLoaderIA r1) {
            this();
        }

        private DataLoader() {
            this.mParams = null;
            this.mConnector = null;
        }

        public boolean onCreate(DataLoaderParams dataLoaderParams, DataLoaderService.FileSystemConnector connector) {
            this.mParams = dataLoaderParams;
            this.mConnector = connector;
            return true;
        }

        public boolean onPrepareImage(Collection<InstallationFile> addedFiles, Collection<String> removedFiles) {
            ShellCommand shellCommand = PackageManagerShellCommandDataLoader.lookupShellCommand(this.mParams.getArguments());
            Iterator<InstallationFile> r0 = addedFiles.iterator();     // Catch: IOException -> L10
        L5:
            if (r0.hasNext() == false) goto L35;
            InstallationFile file = r0.next();     // Catch: IOException -> L10
            Metadata metadata = Metadata.fromByteArray(file.getMetadata());     // Catch: IOException -> L10
            if (metadata == null) goto L8;
            switch(metadata.getMode()) {
                case 0: goto L30;
                case 1: goto L17;
                case 2: goto L14;
                case 3: goto L14;
                case 4: goto L5;
                default: goto L14;
            };     // Catch: IOException -> L10
        L14:
            Slog.e(PackageManagerShellCommandDataLoader.TAG, "Unsupported metadata mode: " + metadata.getMode());     // Catch: IOException -> L10
            return false;
        L17:
            if (shellCommand == null) goto L18;
            ParcelFileDescriptor incomingFd = null;
            String filePath = new String(metadata.getData(), StandardCharsets.UTF_8);     // Catch: Throwable -> L27
            ParcelFileDescriptor incomingFd2 = PackageManagerShellCommandDataLoader.getLocalFilePFD(shellCommand, filePath);     // Catch: Throwable -> L27
            this.mConnector.writeData(file.getName(), 0, incomingFd2.getStatSize(), incomingFd2);     // Catch: Throwable -> L25
            IoUtils.closeQuietly(incomingFd2);     // Catch: IOException -> L10
        L25:
            th = th;
            incomingFd = incomingFd2;
        L28:
            IoUtils.closeQuietly(incomingFd);     // Catch: IOException -> L10
            throw th;     // Catch: IOException -> L10
        L27:
            th = th;
            goto L28
        L18:
            Slog.e(PackageManagerShellCommandDataLoader.TAG, "Missing shell command for Metadata.LOCAL_FILE.");     // Catch: IOException -> L10
            return false;
        L30:
            if (shellCommand == null) goto L31;
            ParcelFileDescriptor inFd = PackageManagerShellCommandDataLoader.getStdInPFD(shellCommand);     // Catch: IOException -> L10
            this.mConnector.writeData(file.getName(), 0, file.getLengthBytes(), inFd);     // Catch: IOException -> L10
            goto L5
        L31:
            Slog.e(PackageManagerShellCommandDataLoader.TAG, "Missing shell command for Metadata.STDIN.");     // Catch: IOException -> L10
            return false;
        L8:
            Slog.e(PackageManagerShellCommandDataLoader.TAG, "Invalid metadata for file: " + file.getName());     // Catch: IOException -> L10
            return false;
        L35:
            return true;
        L10:
            e = move-exception;
            Slog.e(PackageManagerShellCommandDataLoader.TAG, "Exception while streaming files", e);
            return false;
        }
    }

    public static class Metadata {
        static final byte ARCHIVED = 4;
        static final byte DATA_ONLY_STREAMING = 2;
        static final byte LOCAL_FILE = 1;
        static final byte STDIN = 0;
        static final byte STREAMING = 3;
        private static final AtomicLong sGlobalSalt = null;
        private final byte[] mData;
        private final byte mMode;
        private final String mSalt;

        static {
            sGlobalSalt = new AtomicLong(new SecureRandom().nextLong());
        }

        private static Long nextGlobalSalt() {
            return Long.valueOf(sGlobalSalt.incrementAndGet());
        }

        static Metadata forStdIn(String fileId) {
            return new Metadata((byte) 0, fileId);
        }

        public static Metadata forLocalFile(String filePath) {
            return new Metadata((byte) 1, filePath, nextGlobalSalt().toString());
        }

        public static Metadata forArchived(ArchivedPackageParcel archivedPackage) {
            return new Metadata((byte) 4, writeArchivedPackageParcel(archivedPackage), null);
        }

        static Metadata forDataOnlyStreaming(String fileId) {
            return new Metadata((byte) 2, fileId);
        }

        static Metadata forStreaming(String fileId) {
            return new Metadata((byte) 3, fileId);
        }

        private Metadata(byte mode, String data) {
            this(mode, data, null);
        }

        private Metadata(byte mode, String data, String salt) {
            if (data == null) goto L4;
            String r0 = data;
        L5:
            this(mode, r0.getBytes(StandardCharsets.UTF_8), salt);
            return;
        L4:
            r0 = "";
            goto L5
        }

        private Metadata(byte mode, byte[] data, String salt) {
            this.mMode = mode;
            this.mData = data;
            this.mSalt = salt;
        }

        static Metadata fromByteArray(byte[] bytes) throws IOException {
            if (bytes != null) goto L4;
            return null;
        L4:
            if (bytes.length < 5) goto L14;
            byte mode = bytes[0];
            int offset = 0 + 1;
            switch(mode) {
                case 1: goto L9;
                default: goto L8;
            };
        L8:
            byte[] data = Arrays.copyOfRange(bytes, offset, bytes.length);
            String salt = null;
        L11:
            return new Metadata(mode, data, salt);
        L9:
            int dataSize = ByteBuffer.wrap(bytes, offset, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();
            int offset2 = offset + 4;
            byte[] data2 = Arrays.copyOfRange(bytes, offset2, offset2 + dataSize);
            int offset3 = offset2 + dataSize;
            String salt2 = new String(bytes, offset3, bytes.length - offset3, StandardCharsets.UTF_8);
            data = data2;
            salt = salt2;
            goto L11
        L14:
            return null;
        }

        public byte[] toByteArray() {
            byte[] dataBytes = this.mData;
            switch(this.mMode) {
                case 1: goto L5;
                default: goto L4;
            };
        L4:
            byte[] result = new byte[dataBytes.length + 1];
            result[0] = this.mMode;
            System.arraycopy(dataBytes, 0, result, 1, dataBytes.length);
            return result;
        L5:
            int dataSize = dataBytes.length;
            byte[] saltBytes = this.mSalt.getBytes(StandardCharsets.UTF_8);
            byte[] result2 = new byte[(dataSize + 5) + saltBytes.length];
            result2[0] = this.mMode;
            int offset = 0 + 1;
            ByteBuffer.wrap(result2, offset, 4).order(ByteOrder.LITTLE_ENDIAN).putInt(dataSize);
            int offset2 = offset + 4;
            System.arraycopy(dataBytes, 0, result2, offset2, dataSize);
            System.arraycopy(saltBytes, 0, result2, offset2 + dataSize, saltBytes.length);
            return result2;
        }

        byte getMode() {
            return this.mMode;
        }

        byte[] getData() {
            return this.mData;
        }

        ArchivedPackageParcel getArchivedPackage() {
            if (getMode() != 4) goto L7;
            return readArchivedPackageParcel(this.mData);
        L7:
            throw new IllegalStateException("Not an archived package metadata.");
        }

        static ArchivedPackageParcel readArchivedPackageParcel(byte[] bytes) {
            Parcel parcel = Parcel.obtain();
            parcel.unmarshall(bytes, 0, bytes.length);     // Catch: Throwable -> L6
            parcel.setDataPosition(0);     // Catch: Throwable -> L6
            ArchivedPackageParcel result = parcel.readParcelable(ArchivedPackageParcel.class.getClassLoader());     // Catch: Throwable -> L6
            parcel.recycle();
            return result;
        L6:
            th = move-exception;
            parcel.recycle();
            throw th;
        }

        static byte[] writeArchivedPackageParcel(ArchivedPackageParcel archivedPackage) {
            Parcel parcel = Parcel.obtain();
            parcel.writeParcelable(archivedPackage, 0);     // Catch: Throwable -> L6
            byte[] r1 = parcel.marshall();     // Catch: Throwable -> L6
            parcel.recycle();
            return r1;
        L6:
            th = move-exception;
            parcel.recycle();
            throw th;
        }
    }

    private static native void nativeInitialize();

    public PackageManagerShellCommandDataLoader() {
    }

    static {
        CLASS = PackageManagerShellCommandDataLoader.class.getName();
        sRandom = new SecureRandom();
        sShellCommands = new SparseArray();
    }

    private static String getDataLoaderParamsArgs(ShellCommand shellCommand) {
        nativeInitialize();
        SparseArray<WeakReference<ShellCommand>> r0 = sShellCommands;
        monitor-enter(r0);
        int i = sShellCommands.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        WeakReference<ShellCommand> oldRef = sShellCommands.valueAt(i);     // Catch: Throwable -> L9
        if (oldRef.get() != null) goto L11;
        sShellCommands.removeAt(i);     // Catch: Throwable -> L9
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        if (sShellCommands.size() <= 10) goto L15;
        Slog.e(TAG, "Too many pending shell commands: " + sShellCommands.size());     // Catch: Throwable -> L9
    L15:
        int commandId = sRandom.nextInt(2147483646) + 1;     // Catch: Throwable -> L9
        if (sShellCommands.contains(commandId) == true) goto L15;
        sShellCommands.put(commandId, new WeakReference(shellCommand));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return SHELL_COMMAND_ID_PREFIX + commandId;
    L9:
        th = move-exception;
        throw th;
    }

    static DataLoaderParams getStreamingDataLoaderParams(ShellCommand shellCommand) {
        return DataLoaderParams.forStreaming(new ComponentName("android", CLASS), getDataLoaderParamsArgs(shellCommand));
    }

    static DataLoaderParams getIncrementalDataLoaderParams(ShellCommand shellCommand) {
        return DataLoaderParams.forIncremental(new ComponentName("android", CLASS), getDataLoaderParamsArgs(shellCommand));
    }

    private static int extractShellCommandId(String args) {
        int sessionIdIdx = args.indexOf(SHELL_COMMAND_ID_PREFIX);
        if (sessionIdIdx >= 0) goto L6;
        Slog.e(TAG, "Missing shell command id param.");
        return -1;
    L6:
        int sessionIdIdx2 = sessionIdIdx + SHELL_COMMAND_ID_PREFIX.length();
        int delimIdx = args.indexOf(38, sessionIdIdx2);
        if (delimIdx >= 0) goto L13;
        return Integer.parseInt(args.substring(sessionIdIdx2));
    L13:
        return Integer.parseInt(args.substring(sessionIdIdx2, delimIdx));
    L10:
        e = move-exception;
        Slog.e(TAG, "Incorrect shell command id format.", e);
        return -1;
    }

    static ShellCommand lookupShellCommand(String args) {
        int commandId = extractShellCommandId(args);
        if (commandId != (-1)) goto L5;
        return null;
    L5:
        SparseArray<WeakReference<ShellCommand>> r1 = sShellCommands;
        monitor-enter(r1);
        WeakReference<ShellCommand> shellCommandRef = sShellCommands.get(commandId, null);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        if (shellCommandRef == null) goto L17;
        ShellCommand shellCommand = shellCommandRef.get();
        return shellCommand;
    L17:
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    static ParcelFileDescriptor getStdInPFD(ShellCommand shellCommand) {
        return ParcelFileDescriptor.dup(shellCommand.getInFileDescriptor());
    L4:
        e = move-exception;
        Slog.e(TAG, "Exception while obtaining STDIN fd", e);
        return null;
    }

    static ParcelFileDescriptor getLocalFilePFD(ShellCommand shellCommand, String filePath) {
        return shellCommand.openFileForSystem(filePath, ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD);
    }

    static int getStdIn(ShellCommand shellCommand) {
        ParcelFileDescriptor pfd = getStdInPFD(shellCommand);
        if (pfd != null) goto L6;
        return -1;
    L6:
        return pfd.detachFd();
    }

    static int getLocalFile(ShellCommand shellCommand, String filePath) {
        ParcelFileDescriptor pfd = getLocalFilePFD(shellCommand, filePath);
        if (pfd != null) goto L6;
        return -1;
    L6:
        return pfd.detachFd();
    }

    public DataLoaderService.DataLoader onCreateDataLoader(DataLoaderParams dataLoaderParams) {
        PackageManagerShellCommandDataLoaderIA r2 = null;
        if (dataLoaderParams.getType() == 1) goto L5;
        return null;
    L5:
        return new DataLoader(r2);
    }
}
