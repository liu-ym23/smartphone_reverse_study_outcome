package androidx.media;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MediaSessionManagerImplBase.java */
/* JADX INFO: loaded from: classes.dex */
class e implements b.a {
    private static final String TAG = "MediaSessionManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f2224b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f2225a;

    /* JADX INFO: compiled from: MediaSessionManagerImplBase.java */
    static class a implements b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2228c;

        a(String r1, int r2, int r3) {
            this.f2226a = r1;
            this.f2227b = r2;
            this.f2228c = r3;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (TextUtils.equals(this.f2226a, r6.f2226a) == false) goto L16;
            if (this.f2227b != r6.f2227b) goto L16;
            if (this.f2228c != r6.f2228c) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return androidx.core.util.d.a(new Object[]{this.f2226a, Integer.valueOf(this.f2227b), Integer.valueOf(this.f2228c)});
        }
    }

    static {
        f2224b = b.f2219a;
    }

    @Override // androidx.media.b.a
    public Context getContext() {
        return this.f2225a;
    }
}
