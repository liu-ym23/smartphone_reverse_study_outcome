package bc2;

import com.bytedance.android.live.core.log.g;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.log.b0;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tlc.f;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18575a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        if (v.a() == false) goto L6;
        b0.o().getClass();
        g.i("LiveMessageTracer", r100);
        return;
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        b0.o().getClass();
        g.i("LiveMessageTracer", r100);
    }

    @JvmStatic
    public static final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        b("fetch message failed with http, reason: " + r100);
    }

    @JvmStatic
    public static final void f(f r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadItem");
        b("host ws packet received, payload type is " + r100.f546762c + ", logId: " + r100.f546766g);
    }

    @JvmStatic
    public static final void c(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        b("decode message: " + r100 + ", method: " + r101 + " but base message is null");
    }

    @JvmStatic
    public static final void d(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        b("try decode message: " + r100 + ", method: " + r101 + " but payload is null");
    }
}
