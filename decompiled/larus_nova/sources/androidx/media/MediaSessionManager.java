package androidx.media;

import android.content.Context;
import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes17.dex */
public final class MediaSessionManager {
    static final boolean DEBUG = false;
    static final String TAG = "MediaSessionManager";
    private static final Object sLock = null;
    private static volatile MediaSessionManager sSessionManager;
    MediaSessionManagerImpl mImpl;

    public interface MediaSessionManagerImpl {
        Context getContext();

        boolean isTrustedForMediaControl(RemoteUserInfoImpl r100);
    }

    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
        RemoteUserInfoImpl mImpl;

        public String getPackageName() {
            return this.mImpl.getPackageName();
        }

        public int getPid() {
            return this.mImpl.getPid();
        }

        public int getUid() {
            return this.mImpl.getUid();
        }

        public int hashCode() {
            return this.mImpl.hashCode();
        }

        public RemoteUserInfo(android.media.session.MediaSessionManager.RemoteUserInfo r100) {
            this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RemoteUserInfo) == true) goto L10;
            return false;
        L10:
            return this.mImpl.equals(((RemoteUserInfo) r100).mImpl);
        }

        public RemoteUserInfo(String r100, int r101, int r102) {
            if (Build.VERSION.SDK_INT < 28) goto L5;
            this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(r100, r101, r102);
            return;
        L5:
            this.mImpl = new MediaSessionManagerImplBase.RemoteUserInfoImplBase(r100, r101, r102);
        }
    }

    public interface RemoteUserInfoImpl {
        String getPackageName();

        int getPid();

        int getUid();
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        sLock = new Object();
    }

    public Context getContext() {
        return this.mImpl.getContext();
    }

    private MediaSessionManager(Context r100) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mImpl = new MediaSessionManagerImplApi28(r100);
        return;
    L5:
        this.mImpl = new MediaSessionManagerImplApi21(r100);
    }

    public static MediaSessionManager getSessionManager(Context r100) {
        MediaSessionManager r101 = sSessionManager;
        if (r101 != null) goto L14;
        Object r102 = sLock;
        monitor-enter(r102);
        r101 = sSessionManager;     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        sSessionManager = new MediaSessionManager(r100.getApplicationContext());     // Catch: Throwable -> L11
        r101 = sSessionManager;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r101;
    }

    public boolean isTrustedForMediaControl(RemoteUserInfo r100) {
        if (r100 == null) goto L6;
        return this.mImpl.isTrustedForMediaControl(r100.mImpl);
    L6:
        throw new IllegalArgumentException("userInfo should not be null");
    }
}
