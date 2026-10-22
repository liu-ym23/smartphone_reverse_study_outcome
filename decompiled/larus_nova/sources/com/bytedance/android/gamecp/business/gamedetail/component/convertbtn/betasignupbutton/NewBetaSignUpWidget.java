package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.GamePlatformV2Type;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.view.GameDetailCommonButton;
import com.bytedance.android.gamecp.common.utils.e1;
import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.ies.sve_core.o;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_core.s;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/convertbtn/betasignupbutton/NewBetaSignUpWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/convertbtn/betasignupbutton/e;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewBetaSignUpWidget extends BaseGameDetailWidget<e> {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f54076z = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public GameDetailCommonButton f54077o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f54078p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f54079q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f54080r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f54081s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Disposable f54082t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f54083u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f54084v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f54085w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f54086x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.h f54087y;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_detail_new_beta_sign_up_button_widget;
    }

    public final String fr() {
        String r100 = this.f54085w;
        if (TextUtils.isEmpty(r100) == true) goto L6;
        String r101 = UriProtector.parse(UriProtector.getQueryParameter(UriProtector.parse(this.f54085w), "url")).buildUpon().build().toString();
        return w36.a.b(UriProtector.parse(this.f54085w), "url").buildUpon().appendQueryParameter("click_from", "native_bottom_signup_btn").appendQueryParameter("url", r101).build().toString();
    L6:
        return r100;
    }

    public final String gr() {
        String r100 = this.f54084v;
        if (TextUtils.isEmpty(r100) == true) goto L9;
        String r101 = UriProtector.parse(UriProtector.getQueryParameter(UriProtector.parse(this.f54084v), "url")).buildUpon().build().toString();
        Uri.Builder r102 = w36.a.b(UriProtector.parse(this.f54084v), "url").buildUpon();
        com.bytedance.android.gamecp.business.gamedetail.util.e.f55635a.getClass();
        String r103 = null;
        Uri.Builder r104 = r102.appendQueryParameter("detailPageInitialData", com.bytedance.android.gamecp.business.gamedetail.util.e.a(this, null).toString());
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r105 = this.f54087y;
        if (r105 == null) goto L8;
        r103 = e1.a(r105);
    L8:
        return r104.appendQueryParameter("gameDetailCommonParams", r103).appendQueryParameter("url", r101).build().toString();
    L9:
        return r100;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        this.f54077o = (GameDetailCommonButton) this.contentView.findViewById(R.id.btn_beta_apply);
    }

    @Override // com.bytedance.ies.sve_core.PureWidget, com.bytedance.ies.sve_core.r
    public final void Zm() {
        super.Zm();
        Disposable r100 = this.f54082t;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f54082t;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    public static final Map dr(NewBetaSignUpWidget r100) {
        r100.getClass();
        dt.b r101 = (dt.b) r100.Kq(dt.e.f469988b);
        Pair[] r102 = new Pair[4];
        int r103 = com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup.f.f53819b;
        Pair<o<S>, Function1<s, Unit>> r104 = r100.Mq(com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup.f.a.a(), null);
        o r105 = (o) r104.component1();
        Function1<s, Unit> r106 = r104.component2();
        com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup.f r107 = (com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup.f) r105.b();
        if (r107 != null) goto L5;
    L7:
        boolean r108 = false;
    L8:
        if (r108 == false) goto L10;
        String r109 = "signed_up";
    L11:
        r102[0] = TuplesKt.to("status", r109);
        r102[1] = TuplesKt.to("test_id", r100.f54078p);
        r102[2] = TuplesKt.to("is_fullscreen", r101.f469945c0);
        r102[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "bottom");
        return MapsKt.mapOf(r102);
    L10:
        r109 = "sign_up";
        goto L11
    L5:
        if (r107.f53820a != true) goto L7;
        r108 = true;
        goto L8
    }

    public static final Map er(NewBetaSignUpWidget r100) {
        r100.getClass();
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("status", "gray"), TuplesKt.to("test_id", r100.f54078p), TuplesKt.to("is_fullscreen", ((dt.b) r100.Kq(dt.e.f469988b)).f469945c0), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "bottom")});
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        hr((e) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        hr((e) r100);
    }

    public final void hr(final e r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        JSONArray r101 = r100.f54125q;
        Integer r102 = null;
        boolean r103 = true;
        if (r101 != null) goto L5;
    L15:
        boolean r104 = false;
    L16:
        GamePlatformV2Type.a r105 = GamePlatformV2Type.Companion;
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r106 = this.f54087y;
        if (r106 == null) goto L23;
        com.bytedance.android.gamecp.business.gamedetail.base.model.c r107 = r106.e();
        if (r107 == null) goto L23;
        Long r108 = r107.h();
        if (r108 == null) goto L23;
        r102 = Integer.valueOf((int) r108.longValue());
    L23:
        r105.getClass();
        if (GamePlatformV2Type.a.a(r102) == true) goto L28;
        if (r104 == true) goto L28;
        r103 = false;
    L28:
        this.f54083u = r103;
        r.a.c(this, r100, NewBetaSignUpWidget$onUpdate$3.INSTANCE, new NewBetaSignUpWidget$onUpdate$4(this, r100));
        return;
    L5:
        if (r101.length() == 1) goto L7;
    L9:
        boolean r109 = false;
    L10:
        if (r109 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L15;
        r104 = true;
        goto L16
    L7:
        if (Intrinsics.areEqual(r101.get(0), 2) == false) goto L9;
        r109 = true;
        goto L10
    }

    public final void jr(e r110) {
        Context r100 = this.context;
        String r101 = fr();
        long r102 = r110.f54113e;
        boolean r103 = r110.f54114f;
        boolean r104 = r110.f54110b;
        String r105 = r110.f54112d;
        String r106 = r110.f54119k;
        String r111 = r110.f54120l;
        int r112 = r110.f54121m;
        if (this.f54083u == false) goto L5;
        String r113 = gr();
    L6:
        ki(new d(r100, r101, r102, r103, r104, r105, r106, r111, r112, r113, r110.f54124p, this.f54083u));
        return;
    L5:
        r113 = r110.f54122n;
        goto L6
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(p r100) {
        hr((e) r100);
    }

    public NewBetaSignUpWidget(com.bytedance.android.gamecp.business.gamedetail.base.model.h r100, Function1<? super PureWidget<e>, Unit> r101) {
        super(null, r101, null, 4);
        this.f54087y = r100;
        this.f54078p = "";
        this.f54079q = "";
        this.f54084v = "";
        this.f54085w = "";
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        e r102 = (e) r101;
        Intrinsics.checkNotNullParameter(r102, "data");
        if (r100 == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("auto_apply", r102.f54123o) == true) goto L7;
        return;
    L7:
        if (this.f54081s == true) goto L12;
        yr.c.a("NewBetaSignUpWidget", "auto apply");
        jr(r102);
        this.f54081s = true;
        return;
    }
}
