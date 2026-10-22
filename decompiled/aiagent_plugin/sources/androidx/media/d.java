package androidx.media;

import android.media.session.MediaSessionManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MediaSessionManagerImplApi28.java */
/* JADX INFO: loaded from: classes.dex */
class d extends c {

    /* JADX INFO: compiled from: MediaSessionManagerImplApi28.java */
    static final class a implements b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MediaSessionManager.RemoteUserInfo f2223a;

        a(String r2, int r3, int r4) {
            this.f2223a = new MediaSessionManager.RemoteUserInfo(r2, r3, r4);
        }

        a(MediaSessionManager.RemoteUserInfo r1) {
            this.f2223a = r1;
        }

        public int hashCode() {
            return androidx.core.util.d.a(new Object[]{this.f2223a});
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L7;
            return true;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L10;
            return false;
        L10:
            a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
            return this.f2223a.equals(r4.f2223a);
        }
    }
}
