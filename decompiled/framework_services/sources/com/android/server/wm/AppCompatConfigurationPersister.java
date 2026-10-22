package com.android.server.wm;

import android.os.Environment;
import android.util.AtomicFile;
import android.util.Slog;
import com.android.server.wm.nano.WindowManagerProtos;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatConfigurationPersister {
    private static final String LETTERBOX_CONFIGURATION_FILENAME = "letterbox_config";
    private static final String TAG = "WindowManager";
    private final Consumer<String> mCompletionCallback;
    private final AtomicFile mConfigurationFile;
    private final Supplier<Integer> mDefaultBookModeReachabilitySupplier;
    private final Supplier<Integer> mDefaultHorizontalReachabilitySupplier;
    private final Supplier<Integer> mDefaultTabletopModeReachabilitySupplier;
    private final Supplier<Integer> mDefaultVerticalReachabilitySupplier;
    private volatile int mLetterboxPositionForBookModeReachability;
    private volatile int mLetterboxPositionForHorizontalReachability;
    private volatile int mLetterboxPositionForTabletopModeReachability;
    private volatile int mLetterboxPositionForVerticalReachability;
    private final PersisterQueue mPersisterQueue;

    private static class UpdateValuesCommand implements PersisterQueue.WriteQueueItem<UpdateValuesCommand> {
        private final int mBookModeReachability;
        private final AtomicFile mFileToUpdate;
        private final int mHorizontalReachability;
        private final Consumer<String> mOnComplete;
        private final int mTabletopModeReachability;
        private final int mVerticalReachability;

        UpdateValuesCommand(AtomicFile fileToUpdate, int horizontalReachability, int verticalReachability, int bookModeReachability, int tabletopModeReachability, Consumer<String> onComplete) {
            this.mFileToUpdate = fileToUpdate;
            this.mHorizontalReachability = horizontalReachability;
            this.mVerticalReachability = verticalReachability;
            this.mBookModeReachability = bookModeReachability;
            this.mTabletopModeReachability = tabletopModeReachability;
            this.mOnComplete = onComplete;
        }

        @Override // com.android.server.wm.PersisterQueue.WriteQueueItem
        public void process() {
            WindowManagerProtos.LetterboxProto letterboxData = new WindowManagerProtos.LetterboxProto();
            letterboxData.letterboxPositionForHorizontalReachability = this.mHorizontalReachability;
            letterboxData.letterboxPositionForVerticalReachability = this.mVerticalReachability;
            letterboxData.letterboxPositionForBookModeReachability = this.mBookModeReachability;
            letterboxData.letterboxPositionForTabletopModeReachability = this.mTabletopModeReachability;
            byte[] bytes = WindowManagerProtos.LetterboxProto.toByteArray(letterboxData);
            FileOutputStream fos = null;
            fos = this.mFileToUpdate.startWrite();     // Catch: Throwable -> L7 IOException -> L9
            fos.write(bytes);     // Catch: Throwable -> L7 IOException -> L9
            this.mFileToUpdate.finishWrite(fos);     // Catch: Throwable -> L7 IOException -> L9
        L5:
            if (this.mOnComplete == null) goto L14;
        L6:
            this.mOnComplete.accept("UpdateValuesCommand");
            return;
        L14:
            return;
        L9:
            ioe = move-exception;
            this.mFileToUpdate.failWrite(fos);     // Catch: Throwable -> L7
            Slog.e(AppCompatConfigurationPersister.TAG, "Error writing to AppCompatConfigurationPersister. Using default values!", ioe);     // Catch: Throwable -> L7
            if (this.mOnComplete != null) goto L6;
            return;
        L7:
            th = move-exception;
            if (this.mOnComplete == null) goto L18;
            this.mOnComplete.accept("UpdateValuesCommand");
        L18:
            throw th;
        }
    }

    AppCompatConfigurationPersister(Supplier<Integer> defaultHorizontalReachabilitySupplier, Supplier<Integer> defaultVerticalReachabilitySupplier, Supplier<Integer> defaultBookModeReachabilitySupplier, Supplier<Integer> defaultTabletopModeReachabilitySupplier) {
        this(defaultHorizontalReachabilitySupplier, defaultVerticalReachabilitySupplier, defaultBookModeReachabilitySupplier, defaultTabletopModeReachabilitySupplier, Environment.getDataSystemDirectory(), new PersisterQueue(), null, LETTERBOX_CONFIGURATION_FILENAME);
    }

    AppCompatConfigurationPersister(Supplier<Integer> defaultHorizontalReachabilitySupplier, Supplier<Integer> defaultVerticalReachabilitySupplier, Supplier<Integer> defaultBookModeReachabilitySupplier, Supplier<Integer> defaultTabletopModeReachabilitySupplier, File configFolder, PersisterQueue persisterQueue, Consumer<String> completionCallback, String letterboxConfigurationFileName) {
        this.mDefaultHorizontalReachabilitySupplier = defaultHorizontalReachabilitySupplier;
        this.mDefaultVerticalReachabilitySupplier = defaultVerticalReachabilitySupplier;
        this.mDefaultBookModeReachabilitySupplier = defaultBookModeReachabilitySupplier;
        this.mDefaultTabletopModeReachabilitySupplier = defaultTabletopModeReachabilitySupplier;
        this.mCompletionCallback = completionCallback;
        File prefFiles = new File(configFolder, letterboxConfigurationFileName);
        this.mConfigurationFile = new AtomicFile(prefFiles);
        this.mPersisterQueue = persisterQueue;
        readCurrentConfiguration();
    }

    void start() {
        this.mPersisterQueue.startPersisting();
    }

    int getLetterboxPositionForHorizontalReachability(boolean forBookMode) {
        if (forBookMode == false) goto L6;
        return this.mLetterboxPositionForBookModeReachability;
    L6:
        return this.mLetterboxPositionForHorizontalReachability;
    }

    int getLetterboxPositionForVerticalReachability(boolean forTabletopMode) {
        if (forTabletopMode == false) goto L6;
        return this.mLetterboxPositionForTabletopModeReachability;
    L6:
        return this.mLetterboxPositionForVerticalReachability;
    }

    void setLetterboxPositionForHorizontalReachability(boolean forBookMode, int letterboxPositionForHorizontalReachability) {
        if (forBookMode == false) goto L7;
        if (this.mLetterboxPositionForBookModeReachability == letterboxPositionForHorizontalReachability) goto L10;
        this.mLetterboxPositionForBookModeReachability = letterboxPositionForHorizontalReachability;
        updateConfiguration();
        return;
    L10:
        return;
    L7:
        if (this.mLetterboxPositionForHorizontalReachability == letterboxPositionForHorizontalReachability) goto L12;
        this.mLetterboxPositionForHorizontalReachability = letterboxPositionForHorizontalReachability;
        updateConfiguration();
        return;
    }

    void setLetterboxPositionForVerticalReachability(boolean forTabletopMode, int letterboxPositionForVerticalReachability) {
        if (forTabletopMode == false) goto L7;
        if (this.mLetterboxPositionForTabletopModeReachability == letterboxPositionForVerticalReachability) goto L10;
        this.mLetterboxPositionForTabletopModeReachability = letterboxPositionForVerticalReachability;
        updateConfiguration();
        return;
    L10:
        return;
    L7:
        if (this.mLetterboxPositionForVerticalReachability == letterboxPositionForVerticalReachability) goto L12;
        this.mLetterboxPositionForVerticalReachability = letterboxPositionForVerticalReachability;
        updateConfiguration();
        return;
    }

    void useDefaultValue() {
        this.mLetterboxPositionForHorizontalReachability = this.mDefaultHorizontalReachabilitySupplier.get().intValue();
        this.mLetterboxPositionForVerticalReachability = this.mDefaultVerticalReachabilitySupplier.get().intValue();
        this.mLetterboxPositionForBookModeReachability = this.mDefaultBookModeReachabilitySupplier.get().intValue();
        this.mLetterboxPositionForTabletopModeReachability = this.mDefaultTabletopModeReachabilitySupplier.get().intValue();
    }

    private void readCurrentConfiguration() {
        if (this.mConfigurationFile.exists() == true) goto L6;
        useDefaultValue();
        return;
    L6:
        FileInputStream fis = null;
        fis = this.mConfigurationFile.openRead();     // Catch: Throwable -> L13 IOException -> L15
        byte[] protoData = readInputStream(fis);     // Catch: Throwable -> L13 IOException -> L15
        WindowManagerProtos.LetterboxProto letterboxData = WindowManagerProtos.LetterboxProto.parseFrom(protoData);     // Catch: Throwable -> L13 IOException -> L15
        this.mLetterboxPositionForHorizontalReachability = letterboxData.letterboxPositionForHorizontalReachability;     // Catch: Throwable -> L13 IOException -> L15
        this.mLetterboxPositionForVerticalReachability = letterboxData.letterboxPositionForVerticalReachability;     // Catch: Throwable -> L13 IOException -> L15
        this.mLetterboxPositionForBookModeReachability = letterboxData.letterboxPositionForBookModeReachability;     // Catch: Throwable -> L13 IOException -> L15
        this.mLetterboxPositionForTabletopModeReachability = letterboxData.letterboxPositionForTabletopModeReachability;     // Catch: Throwable -> L13 IOException -> L15
        if (fis == null) goto L27;
        fis.close();     // Catch: IOException -> L11
    L27:
        return;
    L11:
        e = move-exception;
        useDefaultValue();
        Slog.e(TAG, "Error reading from AppCompatConfigurationPersister ", e);
        return;
    L15:
        ioe = move-exception;
        Slog.e(TAG, "Error reading from AppCompatConfigurationPersister. Using default values!", ioe);     // Catch: Throwable -> L13
        useDefaultValue();     // Catch: Throwable -> L13
        if (fis == null) goto L34;
        fis.close();     // Catch: IOException -> L11
        goto L27
    L34:
        return;
    L13:
        th = move-exception;
        if (fis != null) goto L30;
    L26:
        throw th;
    L30:
        fis.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        useDefaultValue();
        Slog.e(TAG, "Error reading from AppCompatConfigurationPersister ", e);
        goto L26
    }

    private void updateConfiguration() {
        this.mPersisterQueue.addItem(new UpdateValuesCommand(this.mConfigurationFile, this.mLetterboxPositionForHorizontalReachability, this.mLetterboxPositionForVerticalReachability, this.mLetterboxPositionForBookModeReachability, this.mLetterboxPositionForTabletopModeReachability, this.mCompletionCallback), true);
    }

    private static byte[] readInputStream(InputStream in) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];     // Catch: Throwable -> L6
        int size = in.read(buffer);     // Catch: Throwable -> L6
    L4:
        if (size <= 0) goto L8;
        outputStream.write(buffer, 0, size);     // Catch: Throwable -> L6
        size = in.read(buffer);     // Catch: Throwable -> L6
        goto L4
    L8:
        byte[] r3 = outputStream.toByteArray();     // Catch: Throwable -> L6
        outputStream.close();
        return r3;
    L6:
        th = move-exception;
        outputStream.close();
        throw th;
    }
}
