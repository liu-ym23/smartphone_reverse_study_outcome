package axa;

import com.ss.android.lark.http.netstate.NetworkUtils;
import com.ss.android.lark.http.netstate.c;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends wwa.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0243a f16642b;

    /* JADX INFO: renamed from: axa.a$a, reason: collision with other inner class name */
    public class C0243a implements com.ss.android.lark.http.netstate.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f16643a;

        public C0243a(a r100) {
            this.f16643a = r100;
        }

        @Override // com.ss.android.lark.http.netstate.a
        public final void a(NetworkUtils.NetworkType r100) {
            a r101 = this.f16643a;
            NetworkUtils.NetworkType r102 = NetworkUtils.NetworkType.NONE;
            r101.getClass();
            r101.c();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f16644a = null;

        static {
            f16644a = new a();
        }
    }

    @Override // wwa.a
    public final void b() {
        if (this.f16642b != null) goto L5;
        this.f16642b = new C0243a(this);
    L5:
        c.a.f425872a.a(this.f16642b);
    }

    public a() {
    }
}
