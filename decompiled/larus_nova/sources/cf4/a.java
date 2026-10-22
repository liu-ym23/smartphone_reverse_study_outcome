package cf4;

import cd4.g;
import com.bytedance.caijing.sdk.infra.base.api.container.IJsbService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ve4.b;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23507a = null;

    static {
        f23507a = new a();
    }

    public a() {
    }

    @Override // cd4.g
    public final void c(kd4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        IJsbService r101 = (IJsbService) b.a(IJsbService.class);
        if (r101 == null) goto L8;
        g r102 = r101.getEventHelper();
        if (r102 == null) goto L9;
        r102.c(r100);
        return;
    L9:
        return;
    }

    @Override // cd4.g
    public final void a(String r100, Function1<? super kd4.b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "onReceiveJsEvent");
        IJsbService r102 = (IJsbService) b.a(IJsbService.class);
        if (r102 == null) goto L8;
        g r103 = r102.getEventHelper();
        if (r103 == null) goto L9;
        r103.a(r100, r101);
        return;
    L9:
        return;
    }

    @Override // cd4.g
    public final void b(String r100, Function1<? super kd4.b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "onReceiveJsEvent");
        IJsbService r102 = (IJsbService) b.a(IJsbService.class);
        if (r102 == null) goto L8;
        g r103 = r102.getEventHelper();
        if (r103 == null) goto L9;
        r103.b(r100, r101);
        return;
    L9:
        return;
    }
}
