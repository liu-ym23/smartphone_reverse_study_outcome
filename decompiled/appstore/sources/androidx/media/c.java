package androidx.media;

import android.media.session.MediaSessionManager;

/* JADX INFO: loaded from: classes.dex */
public final class c implements MediaSessionManager$RemoteUserInfoImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaSessionManager.RemoteUserInfo f3719a;

    public c(String r10, int r11, int r12) {
        this.f3719a = new MediaSessionManager.RemoteUserInfo(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L10;
        return false;
    L10:
        return this.f3719a.equals(((c) r10).f3719a);
    }

    @Override // androidx.media.MediaSessionManager$RemoteUserInfoImpl
    public String getPackageName() {
        return this.f3719a.getPackageName();
    }

    @Override // androidx.media.MediaSessionManager$RemoteUserInfoImpl
    public int getPid() {
        return this.f3719a.getPid();
    }

    @Override // androidx.media.MediaSessionManager$RemoteUserInfoImpl
    public int getUid() {
        return this.f3719a.getUid();
    }

    public int hashCode() {
        return androidx.core.util.b.b(new Object[]{this.f3719a});
    }

    public c(MediaSessionManager.RemoteUserInfo r10) {
        this.f3719a = r10;
    }
}
