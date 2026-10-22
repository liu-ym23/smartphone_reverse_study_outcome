package okhttp3.internal.g;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: PushObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40081a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f40082b = null;

    /* JADX INFO: compiled from: PushObserver.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f40083a = null;

        /* JADX INFO: renamed from: okhttp3.internal.g.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PushObserver.kt */
        private static final class C1080a implements l {
            @Override // okhttp3.internal.g.l
            public void a(int r1, b r2) {
                o.e(r2, "errorCode");
            }

            @Override // okhttp3.internal.g.l
            public boolean a(int r1, List<c> r2) {
                o.e((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), "requestHeaders");
                return true;
            }

            @Override // okhttp3.internal.g.l
            public boolean a(int r1, List<c> r2, boolean r3) {
                o.e((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), "responseHeaders");
                return true;
            }

            public C1080a() {
            }

            @Override // okhttp3.internal.g.l
            public boolean a(int r1, e.g r2, int r3, boolean r4) {
                e.g r0 = (e.g) ZeusTransformUtils.wrapperContextForParams(r2, e.g.class, "com.obric.aiagent.plugin");
                o.e(r0, DBHelper.BATTERY_COL_SOURCE);
                r0.h(r3);
                return true;
            }
        }

        static {
            f40083a = new a();
        }

        private a() {
        }
    }

    void a(int r1, b r2);

    boolean a(int r1, e.g r2, int r3, boolean r4);

    boolean a(int r1, List<c> r2);

    boolean a(int r1, List<c> r2, boolean r3);

    static {
        f40081a = a.f40083a;
        f40082b = (l) ZeusTransformUtils.preCheckCast(new a.C1080a(), l.class, "com.obric.aiagent.plugin");
    }
}
