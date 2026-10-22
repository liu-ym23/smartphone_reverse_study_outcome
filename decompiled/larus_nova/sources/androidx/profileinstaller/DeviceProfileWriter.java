package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
public class DeviceProfileWriter {
    private final String mApkName;
    private final AssetManager mAssetManager;
    private final File mCurProfile;
    private final byte[] mDesiredVersion;
    private boolean mDeviceSupportsAotProfile;
    private final ProfileInstaller.DiagnosticsCallback mDiagnostics;
    private final Executor mExecutor;
    private DexProfileData[] mProfile;
    private final String mProfileMetaSourceLocation;
    private final String mProfileSourceLocation;
    private byte[] mTranscodedProfile;

    public static /* synthetic */ void a(DeviceProfileWriter r100, int r101, Object r102) {
        r100.lambda$result$0(r101, r102);
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (this.mDeviceSupportsAotProfile == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    }

    private static byte[] desiredVersion() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 24) goto L6;
        return null;
    L6:
        if (r100 >= 31) goto L8;
        switch(r100) {
            case 24: goto L18;
            case 25: goto L18;
            case 26: goto L16;
            case 27: goto L14;
            case 28: goto L12;
            case 29: goto L12;
            case 30: goto L12;
            default: goto L10;
        };
    L10:
        return null;
    L12:
        return ProfileVersion.V010_P;
    L14:
        return ProfileVersion.V009_O_MR1;
    L16:
        return ProfileVersion.V005_O;
    L18:
        return ProfileVersion.V001_N;
    L8:
        return ProfileVersion.V015_S;
    }

    private static boolean requiresMetadata() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 24) goto L6;
        return false;
    L6:
        if (r100 < 31) goto L8;
        return true;
    L8:
        if (r100 != 24) goto L10;
    L12:
        return true;
    L10:
        if (r100 == 25) goto L12;
        return false;
    }

    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion != null) goto L7;
        result(3, Integer.valueOf(Build.VERSION.SDK_INT));
        return false;
    L7:
        if (this.mCurProfile.exists() == true) goto L9;
    L18:
        result(4, null);
        return false;
    L13:
        if (this.mCurProfile.createNewFile() == true) goto L16;
        result(4, null);     // Catch: IOException -> L18
        return false;
    L16:
        this.mDeviceSupportsAotProfile = true;
        return true;
    L9:
        if (this.mCurProfile.canWrite() == true) goto L16;
        result(4, null);
        return false;
    }

    public DeviceProfileWriter transcodeIfNeeded() {
        DexProfileData[] r100 = this.mProfile;
        byte[] r101 = this.mDesiredVersion;
        if (r100 == null) goto L27;
        if (r101 == null) goto L27;
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: IllegalStateException -> L22 IOException -> L24
        ProfileTranscoder.writeHeader(r102, r101);     // Catch: Throwable -> L16
        if (ProfileTranscoder.transcodeAndWriteBody(r102, r101, r100) == true) goto L13;
        this.mDiagnostics.onResultReceived(5, null);     // Catch: Throwable -> L16
        this.mProfile = null;     // Catch: Throwable -> L16
        r102.close();     // Catch: IllegalStateException -> L22 IOException -> L24
        return this;
    L13:
        this.mTranscodedProfile = r102.toByteArray();     // Catch: Throwable -> L16
        r102.close();     // Catch: IllegalStateException -> L22 IOException -> L24
    L26:
        this.mProfile = null;
    L16:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IllegalStateException -> L22 IOException -> L24
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L22 IOException -> L24
    L24:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
    L22:
        e = move-exception;
        this.mDiagnostics.onResultReceived(8, e);
    L27:
        return this;
    }

    public boolean write() {
        byte[] r100 = this.mTranscodedProfile;
        if (r100 != null) goto L5;
        return false;
    L5:
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        ByteArrayInputStream r101 = new ByteArrayInputStream(r100);     // Catch: Throwable -> L44 IOException -> L46 FileNotFoundException -> L49
        FileOutputStream r102 = new FileOutputStream(this.mCurProfile);     // Catch: Throwable -> L38
        FileChannel r103 = r102.getChannel();     // Catch: Throwable -> L32
        FileLock r104 = r103.tryLock();     // Catch: Throwable -> L25
        Encoding.writeAll(r101, r102, r104);     // Catch: Throwable -> L18
        result(1, null);     // Catch: Throwable -> L18
        if (r104 == null) goto L13;
        r104.close();     // Catch: Throwable -> L25
    L13:
        r103.close();     // Catch: Throwable -> L32
        r102.close();     // Catch: Throwable -> L38
        r101.close();     // Catch: Throwable -> L44 IOException -> L46 FileNotFoundException -> L49
        this.mTranscodedProfile = null;
        this.mProfile = null;
        return true;
    L18:
        th = move-exception;
        if (r104 != null) goto L67;
    L24:
        throw th;     // Catch: Throwable -> L25
    L67:
        r104.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        if (r103 != null) goto L63;
    L31:
        throw th;     // Catch: Throwable -> L32
    L63:
        r103.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L35
    L37:
        throw th;     // Catch: Throwable -> L38
    L35:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L41
    L43:
        throw th;     // Catch: Throwable -> L44 IOException -> L46 FileNotFoundException -> L49
    L41:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L44 IOException -> L46 FileNotFoundException -> L49
    L44:
        th = move-exception;
        this.mTranscodedProfile = null;
        this.mProfile = null;
        throw th;
    L46:
        e = move-exception;
        result(7, e);     // Catch: Throwable -> L44
    L51:
        this.mTranscodedProfile = null;
        this.mProfile = null;
        return false;
    L49:
        e = move-exception;
        result(6, e);     // Catch: Throwable -> L44
        goto L51
    }

    public DeviceProfileWriter read() {
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion != null) goto L5;
        return this;
    L5:
        InputStream r100 = getProfileInputStream(this.mAssetManager);
        if (r100 == null) goto L8;
        this.mProfile = readProfileInternal(r100);
    L8:
        DexProfileData[] r101 = this.mProfile;
        if (r101 != null) goto L11;
    L15:
        return this;
    L11:
        if (requiresMetadata() == false) goto L15;
        DeviceProfileWriter r102 = addMetadata(r101, this.mDesiredVersion);
        if (r102 == null) goto L15;
        return r102;
    }

    private InputStream getProfileInputStream(AssetManager r100) {
    L12:
        return openStreamFromAssets(r100, this.mProfileSourceLocation);
    L6:
        e = move-exception;
        this.mDiagnostics.onResultReceived(6, e);
    L8:
        return null;
    L4:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
        goto L8
    }

    private DexProfileData[] readProfileInternal(InputStream r100) {
        DexProfileData[] r101 = ProfileTranscoder.readProfile(r100, ProfileTranscoder.readHeader(r100, ProfileTranscoder.MAGIC_PROF), this.mApkName);     // Catch: Throwable -> L8 IllegalStateException -> L10 IOException -> L14
        r100.close();     // Catch: IOException -> L6
        return r101;
    L6:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
        return r101;
    L8:
        th = move-exception;
        r100.close();     // Catch: IOException -> L24
    L26:
        throw th;
    L24:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
    L14:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);     // Catch: Throwable -> L8
        r100.close();     // Catch: IOException -> L18
    L30:
    L20:
        return null;
    L10:
        e = move-exception;
        this.mDiagnostics.onResultReceived(8, e);     // Catch: Throwable -> L8
        r100.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
        goto L20
    }

    private DeviceProfileWriter addMetadata(DexProfileData[] r100, byte[] r101) {
        InputStream r102 = openStreamFromAssets(this.mAssetManager, this.mProfileMetaSourceLocation);     // Catch: IllegalStateException -> L17 IOException -> L19 FileNotFoundException -> L21
        if (r102 != null) goto L26;
        if (r102 == null) goto L23;
        r102.close();     // Catch: IllegalStateException -> L17 IOException -> L19 FileNotFoundException -> L21
    L23:
        return null;
    L26:
        this.mProfile = ProfileTranscoder.readMeta(r102, ProfileTranscoder.readHeader(r102, ProfileTranscoder.MAGIC_PROFM), r101, r100);     // Catch: Throwable -> L8
        r102.close();     // Catch: IllegalStateException -> L17 IOException -> L19 FileNotFoundException -> L21
        return this;
    L8:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: IllegalStateException -> L17 IOException -> L19 FileNotFoundException -> L21
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L17 IOException -> L19 FileNotFoundException -> L21
    L21:
        e = move-exception;
        this.mDiagnostics.onResultReceived(9, e);
    L19:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
    L17:
        e = move-exception;
        this.mProfile = null;
        this.mDiagnostics.onResultReceived(8, e);
        goto L23
    }

    private /* synthetic */ void lambda$result$0(int r100, Object r101) {
        this.mDiagnostics.onResultReceived(r100, r101);
    }

    private InputStream openStreamFromAssets(AssetManager r100, String r101) throws IOException {
        return r100.openFd(r101).createInputStream();
    L4:
        e = move-exception;
        String r102 = e.getMessage();
        if (r102 == null) goto L11;
        if (r102.contains("compressed") == false) goto L11;
        this.mDiagnostics.onDiagnosticReceived(5, null);
    L11:
        return null;
    }

    private void result(final int r100, final Object r101) {
        this.mExecutor.execute(new a(this, r100, r101));
    }

    public DeviceProfileWriter(AssetManager r100, Executor r101, ProfileInstaller.DiagnosticsCallback r102, String r103, String r104, String r105, File r106) {
        this.mDeviceSupportsAotProfile = false;
        this.mAssetManager = r100;
        this.mExecutor = r101;
        this.mDiagnostics = r102;
        this.mApkName = r103;
        this.mProfileSourceLocation = r104;
        this.mProfileMetaSourceLocation = r105;
        this.mCurProfile = r106;
        this.mDesiredVersion = desiredVersion();
    }
}
