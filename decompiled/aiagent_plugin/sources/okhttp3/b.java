package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Authenticator.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39734a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f39735b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f39736c = null;

    /* JADX INFO: compiled from: Authenticator.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f39737a = null;

        /* JADX INFO: renamed from: okhttp3.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Authenticator.kt */
        private static final class C1070a implements b {
            @Override // okhttp3.b
            public ab authenticate(af r1, ad r2) {
                d.h.b.o.e(r2, "response");
                return null;
            }

            public C1070a() {
            }
        }

        static {
            f39737a = new a();
        }

        private a() {
        }
    }

    ab authenticate(af r1, ad r2);

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f39734a = a.f39737a;
        f39735b = (b) ZeusTransformUtils.preCheckCast(new a.C1070a(), b.class, "com.obric.aiagent.plugin");
        f39736c = (b) ZeusTransformUtils.preCheckCast(new okhttp3.internal.a.a(null, 1, 0 == true ? 1 : 0), b.class, "com.obric.aiagent.plugin");
    }
}
