package com.bytedance.android.annie.business.lynx;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.business.container.AnnieXLiveFlowLoaderControl;
import com.bytedance.android.annie.business.container.AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1;
import com.bytedance.android.annie.business.container.AnnieXLiveHybridComponent;
import com.bytedance.android.annie.business.latch.l;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.lynx.h;
import com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import q26.j;
import y36.p;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends DefaultLynxDelegate {

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate, com.bytedance.ies.bullet.lynx.a
    public final List<com.lynx.tasm.behavior.a> l() {
        List<com.lynx.tasm.behavior.a> r100 = super.l();
        BulletContext r101 = this.f247296f;
        if (r101 != null) goto L37;
    L36:
        return r100;
    L37:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl((z8.b) Annie.getService$default(z8.b.class, null, 2, null));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r103) == false) goto L12;
        r103 = null;
    L12:
        z8.b r104 = (z8.b) r103;
        if (r104 == null) goto L36;
        t36.d r105 = r101.f246437e;
        if (r105 == null) goto L17;
        String r106 = (String) new p(r105, "annie_x_url", "").f565862b;
    L18:
        if (r106 != null) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == true) goto L36;
        Iterator<T> r108 = r104.M(r101.getContext(), r106).iterator();
    L27:
        if (r108.hasNext() == false) goto L36;
        Object r109 = r108.next();
        if ((r109 instanceof com.lynx.tasm.behavior.a) == false) goto L27;
        HybridLogger r110 = HybridLogger.f246343a;
        HybridLogger.m("AnnieXLiveLynxDelegate", "add new custom behavior, name is " + r109 + ", url is " + r106, null, null, 12);
        if (TypeIntrinsics.isMutableList(r100) == false) goto L33;
        List r111 = r100;
    L34:
        if (r111 == null) goto L27;
        r111.add(r109);
        goto L27
    L33:
        r111 = null;
        goto L34
    L20:
        if (r106.length() == 0) goto L23;
        r107 = false;
        goto L24
    L17:
        r106 = null;
    L7:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate, com.bytedance.ies.bullet.lynx.a
    public final h m() {
        h r100 = s();
        r100.f247274m = new com.bytedance.android.annie.business.lynx.a(m8363getContext());
        return r100;
    }

    @Override // com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate, com.bytedance.ies.bullet.lynx.a
    public final void g(LynxViewBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "viewBuilder");
        super.g(r100);
        Map<String, m16.b> r101 = c36.a.f22277a;
        BulletContext r102 = this.f247296f;
        l.a r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getSessionId();
    L6:
        m16.b r105 = c36.a.a(r104);
        Object r106 = r105.c(IHybridComponent.class);
        if ((r106 instanceof AnnieXLiveHybridComponent) == false) goto L9;
        AnnieXLiveHybridComponent r107 = (AnnieXLiveHybridComponent) r106;
    L10:
        if (r107 != null) goto L12;
    L13:
        new CopyOnWriteArrayList();
    L14:
        AnnieXLiveContext r108 = (AnnieXLiveContext) r105.c(AnnieXLiveContext.class);
        if (r108 == null) goto L30;
        IAnnieBusinessLatchService.b r109 = r108.getLatchProcess();
        if ((r109 instanceof l.a) == false) goto L19;
        l.a r110 = (l.a) r109;
    L20:
        if (r110 == null) goto L28;
        List<com.bytedance.android.latch.a.c> r111 = r110.a();
        if (r111 == null) goto L28;
        Iterator<T> r112 = r111.iterator();
    L25:
        if (r112.hasNext() == false) goto L27;
        com.bytedance.android.latch.a.c r113 = (com.bytedance.android.latch.a.c) r112.next();
        r100.registerModule(r113.getName(), r113.a(), r113.getParams());
        goto L25
    L27:
        Unit r114 = Unit.INSTANCE;
    L29:
        if (r114 == null) goto L30;
        return;
    L28:
        r114 = null;
        goto L29
    L19:
        r110 = null;
    L30:
        AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1 r115 = AnnieXLiveFlowLoaderControl.f38916a;
        BulletContext r116 = this.f247296f;
        if (r116 == null) goto L33;
        String r117 = r116.getSessionId();
    L34:
        IAnnieBusinessLatchService.b r118 = AnnieXLiveFlowLoaderControl.a(String.valueOf(r117));
        if (r118 != null) goto L37;
        return;
    L37:
        if ((r118 instanceof l.a) == false) goto L39;
        r103 = (l.a) r118;
    L39:
        if (r103 == null) goto L52;
        List<com.bytedance.android.latch.a.c> r119 = r103.a();
        if (r119 == null) goto L53;
        Iterator<T> r120 = r119.iterator();
    L44:
        if (r120.hasNext() == false) goto L46;
        com.bytedance.android.latch.a.c r121 = (com.bytedance.android.latch.a.c) r120.next();
        r100.registerModule(r121.getName(), r121.a(), r121.getParams());
        goto L44
    L46:
        Unit r122 = Unit.INSTANCE;
        return;
    L53:
        return;
    L52:
        return;
    L33:
        r117 = null;
        goto L34
    L12:
        if (r107.f38954q != null) goto L14;
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.ies.bullet.lynx.impl.DefaultLynxDelegate, com.bytedance.ies.bullet.lynx.a
    public final void j(LynxView r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        super.j(r100);
        BulletContext r101 = this.f247296f;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.G != true) goto L7;
    L8:
        if (r102 == false) goto L32;
        Map<String, m16.b> r103 = c36.a.f22277a;
        l.a r104 = null;
        if (r101 == null) goto L12;
        String r105 = r101.getSessionId();
    L13:
        AnnieXLiveContext r106 = (AnnieXLiveContext) c36.a.a(r105).c(AnnieXLiveContext.class);
        if (r106 == null) goto L20;
        IAnnieBusinessLatchService.b r107 = r106.getLatchProcess();
        if (r107 == null) goto L18;
        r107.Y0(r100);
        Unit r108 = Unit.INSTANCE;
    L19:
        if (r108 == null) goto L20;
        return;
    L18:
        r108 = null;
    L20:
        AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1 r109 = AnnieXLiveFlowLoaderControl.f38916a;
        BulletContext r110 = this.f247296f;
        if (r110 == null) goto L23;
        String r111 = r110.getSessionId();
    L24:
        IAnnieBusinessLatchService.b r112 = AnnieXLiveFlowLoaderControl.a(String.valueOf(r111));
        if (r112 != null) goto L27;
        return;
    L27:
        if ((r112 instanceof l.a) == false) goto L29;
        r104 = (l.a) r112;
    L29:
        if (r104 == null) goto L35;
        r104.Y0(r100);
        Unit r113 = Unit.INSTANCE;
        return;
    L35:
        return;
    L23:
        r111 = null;
        goto L24
    L12:
        r105 = null;
        goto L13
    L32:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public d(s26.a r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public d(s26.a r100, j r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        super(r100, r101, r102);
    }
}
