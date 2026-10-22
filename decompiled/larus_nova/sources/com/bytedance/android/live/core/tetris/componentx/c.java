package com.bytedance.android.live.core.tetris.componentx;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager;
import com.bytedance.android.live.core.tetris.componentx.schedule.InnerComponentListener;
import com.bytedance.android.live.core.tetris.componentx.schedule.m;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements ComponentSchedulingManager.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentManager f65518a;

    public c(ComponentManager r100) {
        this.f65518a = r100;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentSchedulingManager.b
    public final void a(final int r100, final m r110, final boolean r111) {
        if (r110 == null) goto L14;
        ComponentManager r101 = this.f65518a;
        r101.f65507n = r100;
        ALogger.i(r101.f65494a, "Execute load batch " + r100);
        ComponentManagerABHelper r102 = ComponentManagerABHelper.INSTANCE;
        if (r102.enableWhenLoadCheckCanLoad() == false) goto L10;
        InnerComponentListener r103 = this.f65518a.f65501h;
        if (r103 == null) goto L15;
        long r104 = r102.schedulerLoadResultTimeout();
        Intrinsics.checkNotNullParameter(r110, "components");
        r103.f65578c = r100;
        r103.p(r110);
        r103.q(r104);
        ALogger.i(r103.f65580e, "批次" + r100 + " 一共有 " + r103.f65583h.size() + 20010);
        LayerDescriptorList r105 = r103.m(r110);
        if (r105 == null) goto L16;
        this.f65518a.L3(r105, true, true, r111);
        return;
    L16:
        return;
    L15:
        return;
    L10:
        InnerComponentListener r106 = this.f65518a.f65501h;
        if (r106 == null) goto L18;
        long r107 = r102.schedulerLoadResultTimeout();
        Function0<Unit> r108 = new ComponentManager$getLoadNotifyListener$1$onExecutorNotify$$inlined$let$lambda$1(r110, this, r100, r111);
        Intrinsics.checkNotNullParameter(r110, "components");
        Intrinsics.checkNotNullParameter(r108, "function");
        r106.f65578c = r100;
        r106.p(r110);
        r106.q(r107);
        r106.m(r110);
        ALogger.i(r106.f65580e, "批次" + r100 + " 一共有 " + r106.f65583h.size() + 20010);
        Unit r109 = r108.invoke();
        return;
    L18:
        return;
    }
}
