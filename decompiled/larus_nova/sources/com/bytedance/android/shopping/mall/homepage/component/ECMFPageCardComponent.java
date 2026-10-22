package com.bytedance.android.shopping.mall.homepage.component;

import aa3.i;
import af3.f;
import af3.g;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.shopping.api.mall.IECNativeHomeArgument;
import com.bytedance.android.shopping.api.mall.ability.MallAbilityManager;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.api.mall.model.SingleCardData;
import com.bytedance.android.shopping.mall.homepage.ECMallFragment;
import com.bytedance.android.shopping.mall.homepage.pagecard.PageCard;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.bytedance.android.shopping.mall.homepage.tools.PageCardTimer;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMFPageCardComponent extends com.bytedance.android.shopping.mall.homepage.component.b implements bf3.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PageCardTimer f178130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f178131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f178132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f178133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final jf3.d f178134f;

    public static final class a implements af3.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECMFPageCardComponent f178135a;

        @Override // af3.c
        public final boolean a() {
            return this.f178135a.p().f178111l;
        }

        @Override // af3.c
        public final void b() {
            ECFMiddleware r100 = this.f178135a.p();
        }

        @Override // af3.c
        public Context getContext() {
            return this.f178135a.o().getContext();
        }

        public a(ECMFPageCardComponent r100) {
            this.f178135a = r100;
        }
    }

    public static final class b extends rj.a {
        public b() {
            super(null, 3);
        }
    }

    public ECMFPageCardComponent() {
        this.f178130b = new PageCardTimer();
        this.f178134f = new jf3.d(new ECMFPageCardComponent$pageCardLifeCycle$1(this), new ECMFPageCardComponent$pageCardLifeCycle$2(this));
    }

    @Override // u93.b, u93.c
    public final void onDestroy() {
        com.bytedance.android.shopping.mall.homepage.pagecard.c r100 = p().m();
        if (r100 == null) goto L6;
        r100.onDestroy();
        return;
    }

    public final com.bytedance.android.shopping.mall.homepage.pagecard.d r() {
        return p().f178120u;
    }

    @Override // u93.b, u93.c
    public final void f(HomePageDTO r100) {
        HomePageBffDTO r101 = r100.getBff();
        if (r101 == null) goto L7;
        SingleCardData r102 = r101.getPopup();
        if (r102 == null) goto L7;
        String r103 = r102.getLynxData();
    L9:
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        return;
    L17:
        if (this.f178133e == true) goto L23;
        this.f178133e = true;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r105 = r().a();
        if (r105 == null) goto L24;
        r105.f(r103);
        return;
    L24:
        return;
    L23:
        return;
    L11:
        if (r103.length() == 0) goto L14;
        r104 = false;
    L7:
        r103 = null;
        goto L9
    }

    @Override // u93.b, u93.c
    public final void g(boolean r100) {
        IECNativeHomeArgument r101 = q();
        if (r101 != null) goto L5;
    L7:
        com.bytedance.android.shopping.mall.homepage.pagecard.c r102 = p().m();
        if (r102 == null) goto L11;
        r102.a(r100, false);
        return;
    L11:
        return;
    L5:
        if (r101.getEnableTopBar() != true) goto L7;
    }

    @Override // u93.b, u93.c
    public final void j(HomePageDTO r100) {
        com.bytedance.android.shopping.mall.homepage.pagecard.c r101 = r().a();
        if (r101 != null) goto L5;
    L17:
        p().f178106g.h(this.f178134f);
        this.f178133e = true;
        HomePageBffDTO r102 = r100.getBff();
        if (r102 == null) goto L23;
        SingleCardData r103 = r102.getPopup();
        if (r103 == null) goto L23;
        String r104 = r103.getLynxData();
        if (r104 == null) goto L23;
    L24:
        s(r104);
        return;
    L23:
        r104 = "";
        goto L24
    L5:
        if (r101.f178305b != true) goto L17;
        if (this.f178133e == true) goto L26;
        this.f178133e = true;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r105 = r().a();
        if (r105 == null) goto L27;
        HomePageBffDTO r106 = r100.getBff();
        if (r106 == null) goto L15;
        SingleCardData r107 = r106.getPopup();
        if (r107 == null) goto L15;
        String r108 = r107.getLynxData();
    L16:
        r105.f(r108);
        return;
    L15:
        r108 = null;
        goto L16
    L27:
        return;
    }

    @Override // u93.b, u93.c
    public final void l(String r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        if (this.f178132d == false) goto L5;
        return;
    L5:
        final long r100 = System.currentTimeMillis();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L52
        af3.a r102 = new af3.a(r110);     // Catch: Throwable -> L52
        int r103 = 0;
        int r104 = JSONObjectProtectorUtils.getInt(r102.f3145c, "native_open_ab");     // Catch: Exception -> L10 Throwable -> L52
    L12:
        if (r104 != 1) goto L62;
        a r105 = new a(this);     // Catch: Throwable -> L52
        ck.a r106 = p().g();     // Catch: Throwable -> L52
        ECFMiddleware r111 = p();     // Catch: Throwable -> L52
        af3.e r107 = new af3.e(r105, r102, r106, new g(MapsKt.emptyMap()));     // Catch: Throwable -> L52
        r107.a();     // Catch: Throwable -> L52
        p().f178117r = r107;     // Catch: Throwable -> L52
    L62:
        boolean r108 = JSONObjectProtectorUtils.getBoolean(r102.f3145c, "popup_data_is_valid");     // Catch: Exception -> L17 Throwable -> L52
    L18:
        if (r108 == true) goto L68;
        return;
    L68:
        int r109 = JSONObjectProtectorUtils.getInt(r102.f3145c, "popup_optimize_ab");     // Catch: Exception -> L22 Throwable -> L52
    L23:
        if (r109 != 1) goto L72;
        this.f178132d = true;     // Catch: Throwable -> L52
        com.bytedance.android.shopping.mall.homepage.pagecard.c r112 = r().a();     // Catch: Throwable -> L52
        f r113 = null;
        f r114 = null;
        Unit r115 = null;
        r115 = null;
        if (r112 != null) goto L28;
    L41:
        p().f178106g.h(this.f178134f);     // Catch: Throwable -> L52
        r103 = JSONObjectProtectorUtils.getInt(r102.f3145c, "native_open_ab");     // Catch: Exception -> L59 Throwable -> L52
    L43:
        if (r103 != 1) goto L48;
        af3.e r116 = p().f178117r;     // Catch: Throwable -> L52
        if (r116 == null) goto L47;
        r113 = r116.f3158d;     // Catch: Throwable -> L52
    L47:
        s(r102.c(r113));     // Catch: Throwable -> L52
        r115 = Unit.INSTANCE;     // Catch: Throwable -> L52
    L49:
        Result.m9449constructorimpl(r115);     // Catch: Throwable -> L52
    L54:
        ECMallFragment r117 = p().f178125z;
        Function1<y93.a, y93.a> r118 = new ECMFPageCardComponent$apiMarketingResourceGet$2(r100);
        r117.getClass();
        Intrinsics.checkNotNullParameter(r118, OnekeyLoginConstants.CU_KEY_OPERATOR);
        DataEngineWrapper r119 = r117.L0;
        if (r119 == null) goto L73;
        r119.L(r118);
        return;
    L73:
        return;
    L48:
        s(r110);     // Catch: Throwable -> L52
        r115 = Unit.INSTANCE;     // Catch: Throwable -> L52
        goto L49
    L28:
        if (r112.f178305b != true) goto L41;
        r103 = JSONObjectProtectorUtils.getInt(r102.f3145c, "native_open_ab");     // Catch: Exception -> L58 Throwable -> L52
    L31:
        if (r103 != 1) goto L38;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r120 = r().a();     // Catch: Throwable -> L52
        if (r120 == null) goto L49;
        af3.e r121 = p().f178117r;     // Catch: Throwable -> L52
        if (r121 == null) goto L37;
        r114 = r121.f3158d;     // Catch: Throwable -> L52
    L37:
        r120.f(r102.c(r114));     // Catch: Throwable -> L52
        r115 = Unit.INSTANCE;     // Catch: Throwable -> L52
        goto L49
    L38:
        com.bytedance.android.shopping.mall.homepage.pagecard.c r122 = r().a();     // Catch: Throwable -> L52
        if (r122 == null) goto L49;
        r122.f(r110);     // Catch: Throwable -> L52
        r115 = Unit.INSTANCE;     // Catch: Throwable -> L52
        goto L49
    L72:
        return;
    L22:
        r109 = 0;
    L17:
        r108 = false;
    L10:
        r104 = 0;
    L52:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L54
    }

    @Override // u93.b, u93.c
    public final void onCreate(Bundle r100) {
        ConcurrentHashMap<Class<? extends e93.d>, Map<String, MallAbilityManager.a<? extends e93.d>>> r101 = MallAbilityManager.f170215a;
        MallAbilityManager.a(bf3.b.class, this, o());
        com.bytedance.android.shopping.mall.homepage.pagecard.d r102 = r();
        IECNativeHomeArgument r103 = q();
        Long r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getPageCardSchema();
    L6:
        IECNativeHomeArgument r106 = q();
        if (r106 == null) goto L9;
        r104 = Long.valueOf(r106.getPageCardDynamicParamTimeout());
    L9:
        r102.b(r105, r104);
        com.bytedance.android.shopping.mall.homepage.pagecard.c r107 = p().m();
        if (r107 == null) goto L15;
        r107.c((String) p().f178110k.getValue());
        PageCard r108 = r107.f178304a;
        if (r108 == null) goto L16;
        b r109 = new b();
        Intrinsics.checkNotNullParameter(r109, NewBroadcastMonitor.STAGE.LIFECYCLE);
        ((ArrayList) r108.f178274l).add(r109);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public final void s(String r110) {
        FragmentActivity r100 = o().getActivity();
        Context r101 = o().getContext();
        if (this.f178131c != null) goto L9;
        View r102 = o().getView();
        if (r102 == null) goto L7;
        FrameLayout r103 = (FrameLayout) r102.findViewById(R.id.page_card_container);
    L8:
        this.f178131c = r103;
        goto L9
    L7:
        r103 = null;
    L9:
        FrameLayout r104 = this.f178131c;
        if (r101 == null) goto L23;
        if (r100 != null) goto L13;
    L14:
        if (r104 == null) goto L26;
        ECFMiddleware r105 = p();
        Map r106 = MapsKt.toMutableMap(MapsKt.emptyMap());
        r106.put("page_card_load_start_time", Long.valueOf(System.currentTimeMillis()));
        if (HybridAppInfoService.f47545p.isLocalTest() == false) goto L19;
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(200, 200);
        r107.gravity = 8388691;
        Unit r108 = Unit.INSTANCE;
        r104.setLayoutParams(r107);
    L19:
        com.bytedance.android.shopping.mall.homepage.pagecard.c r109 = p().m();
        if (r109 == null) goto L25;
        mf3.b.a.a(r109, r101, o().getLifecycle(), r104, r106, b0.f(), p().l(), p().d(), r110, false, 256);
        return;
    L25:
        return;
    L26:
        return;
    L13:
        if (r100.isFinishing() != true) goto L14;
        return;
    }

    @Override // u93.b, u93.c
    public final void b(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        IECNativeHomeArgument r102 = q();
        if (r102 == null) goto L27;
        boolean r103 = true;
        if (r102.getPageCardDelayInit() != 1) goto L27;
        PageCardTimer r104 = this.f178130b;
        IECNativeHomeArgument r105 = q();
        if (r105 == null) goto L11;
        Map<String, String> r106 = r105.getLandingInfo();
        if (r106 == null) goto L11;
        String r107 = r106.get("schema");
    L13:
        if (r107 != null) goto L15;
        r104.getClass();
    L23:
        r103 = false;
    L24:
        if (r103 == false) goto L26;
        s("");
        return;
    L26:
        jf3.c r108 = p().f178106g;
        jf3.d r109 = this.f178134f;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "lifeCycle");
        r108.f498876a.add(r109);
        return;
    L15:
        List<String> r110 = ((i) r104.f178510a.getValue()).a();
        if (r110 == null) goto L23;
        Iterator<T> r111 = r110.iterator();
    L19:
        if (r111.hasNext() == false) goto L23;
        if (StringsKt.contains$default(r107, (String) r111.next(), false, 2, null) == false) goto L19;
    L11:
        r107 = null;
    L27:
        s("");
    }
}
