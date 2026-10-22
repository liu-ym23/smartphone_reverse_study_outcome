package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.t6;
import com.bytedance.android.livesdk.link.model.x2;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w20.v9;

/* JADX INFO: loaded from: classes47.dex */
public final class BackgroundComponent implements com.bytedance.android.live.revlink.link.biz.service.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f97828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f97829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v9 f97830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f97831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BackgroundComponent$onPartnerEnableObserver$1 f97832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d f97833f;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.BackgroundComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lf31/f;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lf31/f;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<f31.f, Unit> {
        public AnonymousClass1(BackgroundComponent r100) {
            super(1, r100, BackgroundComponent.class, "onLayoutStatusChange", "onLayoutStatusChange(Lcom/bytedance/android/live/revlink/impl/multianchor/model/LayoutStatus;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(f31.f r100) {
            BackgroundComponent r101 = (BackgroundComponent) this.receiver;
            if (r100 != null) goto L5;
            r101.getClass();
            return;
        L5:
            r101.getContext().getCommonService().j(r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(f31.f r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    public final void c() {
        if (this.f97831d == true) goto L6;
        getContext().getCommonService().g();
    L6:
        if (getContext().r9() == false) goto L8;
    L11:
        Function0 r100 = new BackgroundComponent$refreshBg$refreshBgFn$1(this);
    L12:
        r100.invoke();
        return;
    L8:
        if (this.f97831d == true) goto L11;
        r100 = new BackgroundComponent$refreshBg$refreshBgFn$2(this);
        goto L12
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(getContext().hh(), new AnonymousClass1(this)), this.f97829b);
        RevLinkWindowRegionContext r100 = com.bytedance.android.live.revlink.link.biz.service.i.c0(this);
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r101 = r100.getPartnerService();
        if (r101 == null) goto L7;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r102 = r101.getValue();
    L8:
        if (r102 == null) goto L12;
        NextLiveData<Boolean> r103 = r102.g();
        if (r103 == null) goto L12;
        r103.observeForever(this.f97832e);
    L12:
        c();
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final com.bytedance.android.live.revlink.link.domain.anchorimpl.b b() {
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r100 = com.bytedance.android.live.revlink.link.biz.service.i.M(this);
        if (r100 == null) goto L8;
        v9 r101 = r100.getBattleBgImage();
        if (r101 == null) goto L8;
        v9 r102 = r101;
    L9:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r103 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        if (r103 == null) goto L14;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r104 = r103.getPkSkinConfig();
        if (r104 == null) goto L14;
        x2 r105 = r104.f92698b;
    L15:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r106 = com.bytedance.android.live.revlink.link.biz.service.i.S(this);
        if (r106 == null) goto L20;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r107 = r106.getPkSkinConfig();
        if (r107 == null) goto L20;
        Long r108 = Long.valueOf(r107.f92697a);
    L21:
        t6 r109 = com.bytedance.android.live.revlink.link.biz.service.i.t(this).f97369k;
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "parseBgConfig with battleBgImage: " + r102 + ", skinConfig: " + r105 + ", skinType: " + r108 + ", linkMicUIConfig: " + r109, null, 4);
        if (r102 == null) goto L28;
        String r110 = r102.f557978a;
        if (r110 == null) goto L28;
        if ((!StringsKt.isBlank(r110)) != true) goto L28;
        Pair r111 = TuplesKt.to(r102.f557980c, r102.f557978a);
    L61:
        if (r111 == null) goto L65;
        Boolean r112 = (Boolean) r111.getFirst();
        if (r112 == null) goto L65;
        boolean r113 = r112.booleanValue();
    L66:
        if (r113 == false) goto L72;
        if (r111 == null) goto L69;
        String r114 = (String) r111.getSecond();
    L70:
        if (r114 == null) goto L72;
        boolean r115 = true;
    L73:
        if (r111 == null) goto L76;
        String r116 = (String) r111.getSecond();
        if (r116 == null) goto L76;
    L77:
        String r117 = r116;
        if (r102 == null) goto L84;
        String r118 = r102.f557979b;
        if (r118 == null) goto L84;
        if ((!StringsKt.isBlank(r118)) != true) goto L84;
        Pair r119 = TuplesKt.to(r102.f557980c, r102.f557979b);
    L119:
        if (r119 == null) goto L123;
        Boolean r120 = (Boolean) r119.getFirst();
        if (r120 == null) goto L123;
        boolean r121 = r120.booleanValue();
    L124:
        if (r121 == false) goto L130;
        if (r119 == null) goto L127;
        String r122 = (String) r119.getSecond();
    L128:
        if (r122 == null) goto L130;
        boolean r123 = true;
    L131:
        if (r119 == null) goto L134;
        String r124 = (String) r119.getSecond();
        if (r124 == null) goto L134;
    L135:
        String r125 = r124;
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == false) goto L142;
        b03.a r126 = b03.a.f16857a;
        if (b03.a.b() == false) goto L142;
        if (getContext().r9() == true) goto L142;
        boolean r127 = true;
    L143:
        com.bytedance.android.live.revlink.link.domain.anchorimpl.b r128 = new com.bytedance.android.live.revlink.link.domain.anchorimpl.b(r117, r125, r115, r123, r127, r127);
        jy0.b.c(com.bytedance.android.live.revlink.link.biz.service.e.a.a(this), "parseBgConfig done with " + r128, null, 4);
        return r128;
    L142:
        r127 = false;
    L134:
        r124 = d51.c.A0.j();
        goto L135
    L127:
        r122 = null;
    L130:
        r123 = false;
    L123:
        r121 = false;
    L84:
        if (r105 == null) goto L86;
        py.k r129 = r105.getRoomBgBottomImage();
    L87:
        if (r129 == null) goto L92;
        py.k r130 = r105.getRoomBgBottomImage();
        if (r130 == null) goto L114;
        r119 = a(r130);
    L114:
        r119 = null;
        goto L119
    L92:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == false) goto L104;
        d51.c r131 = d51.c.A0;
        r41.d r132 = r131.p().get(r108);
        if (r132 == null) goto L96;
        String r133 = r132.a();
    L97:
        if (r133 == null) goto L104;
        Boolean r134 = Boolean.FALSE;
        r41.d r135 = r131.p().get(r108);
        if (r135 == null) goto L101;
        String r136 = r135.a();
    L102:
        r119 = TuplesKt.to(r134, r136);
        goto L119
    L101:
        r136 = null;
        goto L102
    L96:
        r133 = null;
    L104:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == true) goto L116;
        if (r109 == null) goto L107;
        py.k r137 = r109.getRoomBgBottomImage();
    L108:
        if (r137 == null) goto L116;
        if (y41.f.N.g() == false) goto L116;
        py.k r138 = r109.getRoomBgBottomImage();
        if (r138 == null) goto L114;
        r119 = a(r138);
        goto L119
    L107:
        r137 = null;
    L116:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == false) goto L118;
        r119 = TuplesKt.to(Boolean.FALSE, d51.c.A0.j());
        goto L119
    L118:
        r119 = TuplesKt.to(Boolean.FALSE, d51.c.A0.j());
        goto L119
    L86:
        r129 = null;
    L76:
        r116 = d51.c.A0.k();
        goto L77
    L69:
        r114 = null;
    L72:
        r115 = false;
    L65:
        r113 = false;
    L28:
        if (r105 == null) goto L30;
        py.k r139 = r105.getRoomBgTopImage();
    L31:
        if (r139 == null) goto L36;
        py.k r140 = r105.getRoomBgTopImage();
        if (r140 == null) goto L58;
        r111 = a(r140);
    L58:
        r111 = null;
        goto L61
    L36:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == false) goto L48;
        d51.c r141 = d51.c.A0;
        r41.d r142 = r141.p().get(r108);
        if (r142 == null) goto L40;
        String r143 = r142.b();
    L41:
        if (r143 == null) goto L48;
        Boolean r144 = Boolean.FALSE;
        r41.d r145 = r141.p().get(r108);
        if (r145 == null) goto L45;
        String r146 = r145.b();
    L46:
        r111 = TuplesKt.to(r144, r146);
        goto L61
    L45:
        r146 = null;
        goto L46
    L40:
        r143 = null;
    L48:
        if (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.j.a(getContext()) == true) goto L59;
        if (r109 == null) goto L51;
        py.k r147 = r109.getRoomBgTopImage();
    L52:
        if (r147 == null) goto L59;
        if (y41.f.N.g() == false) goto L59;
        py.k r148 = r109.getRoomBgTopImage();
        if (r148 == null) goto L58;
        r111 = a(r148);
        goto L61
    L51:
        r147 = null;
    L59:
        r111 = TuplesKt.to(Boolean.FALSE, d51.c.A0.k());
        goto L61
    L30:
        r139 = null;
    L20:
        r108 = null;
    L14:
        r105 = null;
    L8:
        r102 = this.f97830c;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        RevLinkWindowRegionContext r100 = com.bytedance.android.live.revlink.link.biz.service.i.c0(this);
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r101 = r100.getPartnerService();
        if (r101 == null) goto L7;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r102 = r101.getValue();
    L8:
        if (r102 == null) goto L12;
        NextLiveData<Boolean> r103 = r102.g();
        if (r103 == null) goto L12;
        r103.removeObserver(this.f97832e);
    L12:
        this.f97829b.clear();
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.f97828a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.f97833f;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.revlink.link.biz.component.BackgroundComponent$onPartnerEnableObserver$1] */
    public BackgroundComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f97833f = r100;
        this.f97828a = "BackgroundComponent";
        this.f97829b = new CompositeDisposable();
        this.f97832e = new BackgroundComponent$onPartnerEnableObserver$1(this);
    }

    public static Pair a(py.k r100) {
        Iterator<T> r101 = r100.getUrls().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if ((!StringsKt.isBlank((String) r102)) == false) goto L4;
    L9:
        String r103 = (String) r102;
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        return TuplesKt.to(Boolean.valueOf(r100.isAnimated()), r103);
    L8:
        r102 = null;
        goto L9
    }
}
