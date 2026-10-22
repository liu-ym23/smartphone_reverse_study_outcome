package com.bytedance.android.livesdk.arch.comp;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.livesdk.arch.plugin.biz.BehaviorPlugin;
import com.bytedance.android.livesdk.arch.plugin.biz.PreloadContentPlugin;
import com.bytedance.android.livesdk.arch.plugin.biz.Unfold2MorePanelPlugin;
import com.bytedance.android.livesdk.arch.strategy.TbDoubleCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarService;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f103737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a0 f103738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ToolbarMatchInterface f103739i;

    @Override // com.bytedance.android.livesdk.arch.comp.b
    public final void i() {
        this.f103725d = false;
        this.f103737g.clear();
    }

    @Override // com.bytedance.android.livesdk.arch.comp.b
    public final void j() {
    }

    @Override // com.bytedance.android.livesdk.arch.comp.b
    public final a0 c() {
        a0 r100 = this.f103738h;
        if (r100 != null) goto L14;
        IToolbarService r101 = (IToolbarService) k.f(IToolbarService.class);
        if (r101 == null) goto L13;
        com.bytedance.android.livesdk.arch.context.a r102 = r101.getTbContext(this.f103727f.a(), this.f103727f.getDataCenter());
        if (r102 == null) goto L13;
        o r103 = r102.configRegister();
        if (r103 == null) goto L13;
        r100 = r103.getToolbarConfig(this.f103739i.getComponentId());
        if (r100 == null) goto L13;
        this.f103738h = r100;
    L13:
        r100 = null;
    L14:
        if (r100 != null) goto L45;
        ke1.a.f502996a.getClass();
        ke1.a r104 = ke1.a.C6543a.a();
        if (r104 == null) goto L48;
        ToolbarMatchInterface r105 = this.f103739i;
        if (r105 == null) goto L20;
        String r106 = r105.compInfo();
    L21:
        Map r107 = MapsKt.mapOf(TuplesKt.to("comp", r106.toString()));
        SimpleAlogArgsBuilder r108 = new SimpleAlogArgsBuilder();
        r108.c("findConfig null,compConfig is not register");
        if (r107 != null) goto L24;
    L32:
        Unit r109 = Unit.INSTANCE;
        r104.c(r108.b());
        ke1.f.a r110 = new ke1.f.a("findConfig null,compConfig is not register");
        if (r107 != null) goto L35;
    L43:
        Unit r111 = Unit.INSTANCE;
        r104.a(new ke1.f(r110));
        return null;
    L35:
        if ((!r107.isEmpty()) == true) goto L38;
        r107 = null;
    L38:
        if (r107 == null) goto L43;
        Iterator r112 = r107.entrySet().iterator();
    L41:
        if (r112.hasNext() == false) goto L43;
        Map.Entry r113 = (Map.Entry) r112.next();
        r110.a((String) r113.getKey(), String.valueOf(r113.getValue()));
        goto L41
    L24:
        if ((!r107.isEmpty()) == false) goto L26;
        Map r114 = r107;
    L27:
        if (r114 == null) goto L32;
        Iterator r115 = r114.entrySet().iterator();
    L30:
        if (r115.hasNext() == false) goto L32;
        Map.Entry r116 = (Map.Entry) r115.next();
        r108.a((String) r116.getKey(), String.valueOf(r116.getValue()));
        goto L30
    L26:
        r114 = null;
        goto L27
    L20:
        r106 = null;
        goto L21
    L48:
        return null;
    L45:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.arch.comp.b
    public final void h() {
        IToolbarService r100 = (IToolbarService) k.f(IToolbarService.class);
        List<je1.b> r101 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.arch.context.a r102 = r100.getTbContext(this.f103727f.a(), this.f103727f.getDataCenter());
    L6:
        if (r102 == null) goto L10;
        m r103 = r102.getCompactTbLoader();
        if (r103 == null) goto L10;
        n r104 = r103.getCheckManager();
    L12:
        if ((r104 instanceof TbDoubleCheckManager) == true) goto L14;
        r104 = null;
    L14:
        TbDoubleCheckManager r105 = (TbDoubleCheckManager) r104;
        if (r105 == null) goto L24;
        List<je1.b> r106 = r105.f(this);
        if ((!((ArrayList) r106).isEmpty()) == false) goto L19;
        r101 = r106;
    L19:
        if (r101 == null) goto L24;
        Iterator<T> r107 = r101.iterator();
    L22:
        if (r107.hasNext() == false) goto L24;
        RxUtilKt.c(k((je1.b) r107.next()), this.f103737g);
    L24:
        RxUtilKt.c(k(new com.bytedance.android.livesdk.arch.strategy.a()), this.f103737g);
        final com.bytedance.android.livesdk.arch.container.d r108 = p();
        RxUtilKt.c(m(new BehaviorPlugin.Unfold(this.f103727f.getDataCenter()), new RoomTbComp$tryRegisterPlugins$1(r108)), this.f103737g);
        RxUtilKt.c(m(new BehaviorPlugin.Fold(this.f103727f.getDataCenter()), new RoomTbComp$tryRegisterPlugins$2(r108)), this.f103737g);
        RxUtilKt.c(m(new Unfold2MorePanelPlugin(this.f103727f.getDataCenter()), new RoomTbComp$tryRegisterPlugins$3(this, r108)), this.f103737g);
        RxUtilKt.c(m(new PreloadContentPlugin(), new RoomTbComp$tryRegisterPlugins$4(this)), this.f103737g);
        return;
    L10:
        r104 = null;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public final com.bytedance.android.livesdk.arch.container.d p() {
        ToolbarMatchInterface r100 = this.f103739i;
        if (r100 == null) goto L8;
        if (r100.isInMore() != true) goto L8;
        return com.bytedance.android.livesdk.arch.container.d.c.f103757c;
    L8:
        return com.bytedance.android.livesdk.arch.container.d.a.f103756c;
    }

    public final ie1.a.C6256a q() {
        a0 r100 = c();
        if (r100 == null) goto L10;
        boolean r101 = false;
        boolean r102 = gb2.a.a(this.f103727f.getDataCenter(), false);
        ToolbarMatchInterface r103 = this.f103739i;
        if (r103 != null) goto L7;
    L9:
        ToolbarButton r104 = r100.l(r102, r101);
    L11:
        ie1.b.a r105 = ie1.b.f489465a;
        if (r104 == null) goto L14;
        int r106 = r104.getLayoutId();
    L15:
        r105.getClass();
        return new ie1.a.C6256a(r106);
    L14:
        r106 = R.layout.ttlive_view_toolbar_common;
        goto L15
    L7:
        if (r103.isInMore() != true) goto L9;
        r101 = true;
        goto L9
    L10:
        r104 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.arch.comp.b
    public final ToolbarMatchInterface d() {
        return this.f103739i;
    }

    @Override // com.bytedance.android.livesdk.arch.comp.b
    public final void o(ToolbarMatchInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "toolbarMatchInterface");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f103739i = r100;
    }

    public h(i r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, "env");
        Intrinsics.checkNotNullParameter(r101, "compModel");
        super(r100);
        this.f103739i = r101;
        this.f103737g = new CompositeDisposable();
    }
}
