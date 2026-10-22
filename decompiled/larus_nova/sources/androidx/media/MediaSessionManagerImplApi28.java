package androidx.media;

import android.content.Context;
import androidx.core.util.ObjectsCompat;

/* JADX INFO: loaded from: classes17.dex */
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
    android.media.session.MediaSessionManager mObject;

    public static final class RemoteUserInfoImplApi28 implements MediaSessionManager.RemoteUserInfoImpl {
        final android.media.session.MediaSessionManager.RemoteUserInfo mObject;

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mObject});
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            return this.mObject.getPackageName();
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            return this.mObject.getPid();
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            return this.mObject.getUid();
        }

        public RemoteUserInfoImplApi28(android.media.session.MediaSessionManager.RemoteUserInfo r100) {
            this.mObject = r100;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RemoteUserInfoImplApi28) == true) goto L10;
            return false;
        L10:
            return this.mObject.equals(((RemoteUserInfoImplApi28) r100).mObject);
        }

        public RemoteUserInfoImplApi28(String r100, int r101, int r102) {
            this.mObject = new android.media.session.MediaSessionManager.RemoteUserInfo(r100, r101, r102);
        }
    }

    public MediaSessionManagerImplApi28(Context r100) {
        super(r100);
        this.mObject = (android.media.session.MediaSessionManager) r100.getSystemService("media_session");
    }

    @Override // androidx.media.MediaSessionManagerImplApi21, androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl r100) {
        if ((r100 instanceof RemoteUserInfoImplApi28) == true) goto L5;
        return false;
    L5:
        return this.mObject.isTrustedForMediaControl(((RemoteUserInfoImplApi28) r100).mObject);
    }
}
