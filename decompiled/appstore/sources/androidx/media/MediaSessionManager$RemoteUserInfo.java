package androidx.media;

import android.media.session.MediaSessionManager;

/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionManager$RemoteUserInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaSessionManager$RemoteUserInfoImpl f3711a;

    public MediaSessionManager$RemoteUserInfo(String r10, int r11, int r12) {
        this.f3711a = new c(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MediaSessionManager$RemoteUserInfo) == true) goto L10;
        return false;
    L10:
        return this.f3711a.equals(((MediaSessionManager$RemoteUserInfo) r10).f3711a);
    }

    public int hashCode() {
        return this.f3711a.hashCode();
    }

    public MediaSessionManager$RemoteUserInfo(MediaSessionManager.RemoteUserInfo r10) {
        this.f3711a = new c(r10);
    }
}
