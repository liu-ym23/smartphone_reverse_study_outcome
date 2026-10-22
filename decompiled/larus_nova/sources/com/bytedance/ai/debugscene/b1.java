package com.bytedance.ai.debugscene;

import com.bytedance.debugrouter.DebugRouter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class b1 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f36315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h1.c f36316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2 f36317c;

    public /* synthetic */ b1(long r100, h1.c r101, Function2 r102) {
        this.f36315a = r100;
        this.f36316b = r101;
        this.f36317c = r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        long r101 = this.f36315a;
        h1.c r102 = this.f36316b;
        Function2 r103 = this.f36317c;
        Throwable r104 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r104, "error");
        h1 r105 = h1.f36379a;
        Long r106 = Long.valueOf(r101);
        r105.getClass();
        h1.l(r106);
        DebugRouter.getInstance().disableDebugChannel();
        com.bytedance.ai.utils.g.f37637a.e("AppletDebugTool", "failed to open debug channel for " + r102.f36394a + ": " + r104.getMessage());
        if (r103 == null) goto L9;
        Boolean r107 = Boolean.FALSE;
        String r108 = r104.getMessage();
        if (r108 != null) goto L7;
        r108 = "failed to open debug channel";
    L7:
        r103.invoke(r107, r108);
    L9:
        return Unit.INSTANCE;
    }
}
