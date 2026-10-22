package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: CookieJar.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f40179b = null;

    /* JADX INFO: compiled from: CookieJar.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f40180a = null;

        /* JADX INFO: renamed from: okhttp3.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CookieJar.kt */
        private static final class C1089a implements n {
            @Override // okhttp3.n
            public void a(v r2, List<m> r3) {
                List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r2, "url");
                d.h.b.o.e(r1, "cookies");
            }

            public C1089a() {
            }

            @Override // okhttp3.n
            public List<m> a(v r1) {
                d.h.b.o.e(r1, "url");
                return d.a.p.b();
            }
        }

        static {
            f40180a = new a();
        }

        private a() {
        }
    }

    List<m> a(v r1);

    void a(v r1, List<m> r2);

    static {
        f40178a = a.f40180a;
        f40179b = (n) ZeusTransformUtils.preCheckCast(new a.C1089a(), n.class, "com.obric.aiagent.plugin");
    }
}
