package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.MiniAppHotAtmosphereView;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfSupplementInfoContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.MiniAppExplainCard;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> extends LinearLayout implements com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a<T>, com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f84880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f84881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f84882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f84883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f84884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.wrds.syncdata.openplatform.a f84885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OpenPlatformContext f84886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a<T> f84887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MiniAppHotAtmosphereView f84888i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public View getExplainCardView() {
        return this.f84887h.getExplainCardView();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public Function0<Unit> getOnBtnClickBlock() {
        return this.f84887h.getOnBtnClickBlock();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public Function0<Unit> getOnClickBlock() {
        return this.f84887h.getOnClickBlock();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public Function0<Unit> getOnCloseBlock() {
        return this.f84887h.getOnCloseBlock();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setData(T r100) {
        this.f84887h.setData(r100);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setOnBtnClickBlock(Function0<Unit> r100) {
        this.f84887h.setOnBtnClickBlock(r100);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setOnClickBlock(Function0<Unit> r100) {
        this.f84887h.setOnClickBlock(r100);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setOnCloseBlock(Function0<Unit> r100) {
        this.f84887h.setOnCloseBlock(r100);
    }

    public final void f() {
        if (this.f84880a == true) goto L5;
        return;
    L5:
        qo0.a.c("AudienceExplainCard", "show hot atmosphere");
        this.f84881b = true;
        MiniAppDataContext.Companion.getClass();
        ShelfCardInfo r100 = com.bytedance.android.live.openplatform.api.model.shelf.g.a(MiniAppDataContext.a.b());
        if (r100 == null) goto L8;
        long r101 = r100.getCardId();
    L10:
        if (this.f84888i.f84865o.isEmpty() == false) goto L18;
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r102 = (com.bytedance.android.livesdk.wrds.syncdata.openplatform.b) ((LinkedHashMap) ((AudienceShelfSupplementInfoContextService) this.f84886g.getService(AudienceShelfSupplementInfoContextService.class)).f84919a).get(Long.valueOf(r101));
        if (r102 == null) goto L14;
        setHotAtmosphereData(r102);
    L15:
        if (r102 != null) goto L18;
        boolean r103 = false;
    L19:
        if (r103 == true) goto L21;
        return;
    L21:
        this.f84884e = r101;
        MiniAppHotAtmosphereView r104 = this.f84888i;
        if (r104.f84864n == true) goto L33;
        r104.animate().cancel();
        r104.f84864n = true;
        r104.setAlpha(1.0f);
        r104.setVisibility(0);
        if (r104.f84865o.isEmpty() == true) goto L28;
        r104.d();
    L28:
        com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a r105 = r104.f84868r;
        if (r105 == null) goto L31;
        r105.b(r104.f84866p);
    L31:
        r104.f84856f = 0.0f;
        r104.removeCallbacks(r104.f84858h);
        r104.post(r104.f84858h);
    L33:
        if (this.f84882c == (-1)) goto L36;
        qo0.a.c("AudienceExplainCard", "dispatch hide hot atmosphere runnable, duration: " + this.f84882c);
        removeCallbacks(this.f84883d);
        postDelayed(this.f84883d, this.f84882c * ((long) 1000));
        return;
    L36:
        return;
    L14:
        r102 = null;
    L18:
        r103 = true;
        goto L19
    L8:
        r101 = 0;
        goto L10
    }

    public com.bytedance.android.livesdk.wrds.syncdata.openplatform.b getCurrentHotAtmosphereData() {
        MiniAppHotAtmosphereView r100 = this.f84888i;
        if (r100.f84864n == true) goto L7;
        return null;
    L7:
        return r100.getCurrentItem();
    }

    public final void d() {
        if (getCurrentSupplementInfo() == null) goto L15;
        AudienceMiniAppAppLogContextService r100 = (AudienceMiniAppAppLogContextService) this.f84886g.getService(AudienceMiniAppAppLogContextService.class);
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r101 = getCurrentSupplementInfo();
        if (r101 == null) goto L8;
        String r102 = r101.type;
        if (r102 == null) goto L8;
    L9:
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r103 = getCurrentSupplementInfo();
        if (r103 == null) goto L12;
        long r104 = r103.amount;
    L13:
        r100.reportSupplementInfoVisibilityChanged(false, r102, r104);
        return;
    L12:
        r104 = 0;
    L8:
        r102 = "";
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e(false);
    }

    public com.bytedance.android.livesdk.wrds.syncdata.openplatform.a getCurrentSupplementInfo() {
        return this.f84885f;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a
    public final void a(com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r100) {
        AudienceMiniAppAppLogContextService r101 = (AudienceMiniAppAppLogContextService) this.f84886g.getService(AudienceMiniAppAppLogContextService.class);
        if (r100 == null) goto L5;
        long r102 = r100.d();
    L6:
        r101.reportHotAtmosphereVisibilityChanged(false, "hot_sale", r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a
    public final void b(com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r100) {
        AudienceMiniAppAppLogContextService r101 = (AudienceMiniAppAppLogContextService) this.f84886g.getService(AudienceMiniAppAppLogContextService.class);
        if (r100 == null) goto L5;
        long r102 = r100.d();
    L6:
        r101.reportHotAtmosphereVisibilityChanged(true, "hot_sale", r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void c(boolean r100) {
        qo0.a.c("AudienceExplainCard", "hide hot atmosphere");
        this.f84881b = false;
        MiniAppHotAtmosphereView r101 = this.f84888i;
        if (r101.f84864n == false) goto L18;
        r101.f84864n = false;
        Animator r102 = r101.f84855e;
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        Animator r103 = r101.f84857g;
        if (r103 == null) goto L11;
        r103.cancel();
    L11:
        r101.removeCallbacks(r101.f84858h);
        com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.a r104 = r101.f84868r;
        if (r104 == null) goto L15;
        r104.a(r101.f84866p);
    L15:
        if (r100 == false) goto L17;
        r101.setAlpha(1.0f);
        r101.animate().alpha(0.0f).setDuration(120).setListener(new com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard.atmosphere.hot.c(r101)).start();
        goto L18
    L17:
        r101.setAlpha(1.0f);
        r101.setVisibility(4);
    L18:
        this.f84882c = -1;
        removeCallbacks(this.f84883d);
    }

    public final void e(boolean r100) {
        if (this.f84880a == true) goto L5;
        return;
    L5:
        qo0.a.c("AudienceExplainCard", "reset hot atmosphere status");
        c(r100);
        MiniAppHotAtmosphereView r101 = this.f84888i;
        r101.f84865o.clear();
        r101.f84866p = null;
        r101.f84867q = null;
        r101.animate().cancel();
        Animator r102 = r101.f84855e;
        if (r102 == null) goto L8;
        r102.cancel();
    L8:
        Animator r103 = r101.f84857g;
        if (r103 == null) goto L11;
        r103.cancel();
    L11:
        r101.removeCallbacks(r101.f84858h);
        this.f84884e = -1;
    }

    public void setHotAtmosphereData(com.bytedance.android.livesdk.wrds.syncdata.openplatform.b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if (this.f84880a == true) goto L6;
        return;
    L6:
        if (this.f84884e == r100.a()) goto L8;
    L11:
        qo0.a.c("AudienceExplainCard", "do set hot atmosphere data");
        long r101 = -1;
        if (this.f84882c != (-1)) goto L23;
        Long r102 = Long.valueOf(r100.b());
        if (r102.longValue() <= 0) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == true) goto L20;
        r102 = null;
    L20:
        if (r102 == null) goto L22;
        r101 = r102.longValue();
    L22:
        this.f84882c = r101;
        goto L23
    L16:
        r103 = false;
    L23:
        this.f84888i.setHotAtmosphereData(r100);
        if (this.f84881b == true) goto L26;
        return;
    L26:
        if (this.f84888i.f84864n == true) goto L30;
        f();
        return;
    L30:
        return;
    L8:
        if (this.f84888i.f84864n == true) goto L11;
        int r104 = qo0.a.f534145a;
        qo0.a.c("AudienceExplainCard", "already shown hot atmosphere, intercept repeat show, cardId: " + this.f84884e);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public void setSupplementInfo(com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r100) {
        com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r101 = getCurrentSupplementInfo();
        if (r101 != null) goto L9;
        if (r100 == null) goto L9;
        AudienceMiniAppAppLogContextService r102 = (AudienceMiniAppAppLogContextService) this.f84886g.getService(AudienceMiniAppAppLogContextService.class);
        String r103 = r100.type;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r102.reportSupplementInfoVisibilityChanged(true, r103, r100.amount);
    L9:
        if (r101 == null) goto L14;
        if (r100 != null) goto L12;
    L13:
        d();
        goto L14
    L12:
        if ((!Intrinsics.areEqual(r101.type, r100.type)) == true) goto L13;
    L14:
        this.f84885f = r100;
        this.f84887h.setSupplementInfo(r100);
    }

    public f(OpenPlatformContext r100, MiniAppExplainCard r101, MiniAppHotAtmosphereView r102) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r101, "explainCard");
        Intrinsics.checkNotNullParameter(r102, "hotAtmosphere");
        super(r100.getContext());
        this.f84886g = r100;
        this.f84887h = r101;
        this.f84888i = r102;
        this.f84882c = -1;
        this.f84883d = new g(this);
        this.f84884e = -1;
        setOrientation(1);
        uc1 r103 = ee0.f120119a.getValue();
        if (r103 != null) goto L5;
    L7:
        addView(r101.getExplainCardView(), new ViewGroup.LayoutParams(-2, -2));
        return;
    L5:
        if (r103.v() != true) goto L7;
        qo0.a.c("AudienceExplainCard", "support hot atmosphere show, do init");
        this.f84880a = true;
        r102.setVisibility(4);
        ViewGroup.MarginLayoutParams r104 = new ViewGroup.MarginLayoutParams(-2, -2);
        r104.bottomMargin = (int) fm3.e.a(getContext(), 11.0f);
        Unit r105 = Unit.INSTANCE;
        addView(r102, r104);
        r102.c();
        r102.setMaxWidth(UtilityKotlinExtentionsKt.i(112));
        r102.setCallback(this);
        goto L7
    }
}
