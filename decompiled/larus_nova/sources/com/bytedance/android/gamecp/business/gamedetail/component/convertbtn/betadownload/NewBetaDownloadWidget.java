package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.view.NewBottomDetailDownloadView;
import com.bytedance.android.gamecp.business.i0;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.ies.sve_core.PureWidget;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/convertbtn/betadownload/NewBetaDownloadWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/convertbtn/betadownload/t;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewBetaDownloadWidget extends BaseGameDetailWidget<t> {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f53947y = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public NewBottomDetailDownloadView f53948o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f53949p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f53950q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f53951r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.bytedance.android.gamecp.business.download.p f53952s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f53953t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f53954u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Disposable f53955v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f53956w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.h f53957x;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.gamecp.base.core.service.depend.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewBetaDownloadWidget f53958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f53959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f53960c;

        @Override // com.bytedance.android.gamecp.base.core.service.depend.o
        public final void onDownloadStart() {
            NewBetaDownloadWidget r100 = this.f53958a;
            Context r101 = r100.context;
            t r102 = this.f53959b;
            r100.ki(new com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload.b(r101, r102.f54046d, r102.f54052j, r102.f54047e, this.f53960c, r102.f54053k, r102.f54059q));
        }

        public b(NewBetaDownloadWidget r100, t r101, String r102) {
            this.f53958a = r100;
            this.f53959b = r101;
            this.f53960c = r102;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_detail_new_beta_download_button_widget;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        this.f53948o = (NewBottomDetailDownloadView) this.contentView.findViewById(R.id.btn_beta_apply_download);
        ConstraintLayout r100 = (ConstraintLayout) this.contentView.findViewById(R.id.cl_download_template_container);
        if (r100 == null) goto L6;
        r100.setBackgroundResource(R.drawable.shape_bg_f8f8f8_corner_8);
        return;
    }

    @Override // com.bytedance.ies.sve_core.PureWidget, com.bytedance.ies.sve_core.r
    public final void Zm() {
        super.Zm();
        Disposable r100 = this.f53955v;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f53955v;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        dr((t) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        dr((t) r100);
    }

    public final void dr(final t r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        com.bytedance.ies.sve_core.r.a.c(this, r100, NewBetaDownloadWidget$onUpdate$1.INSTANCE, new NewBetaDownloadWidget$onUpdate$2(this));
        com.bytedance.ies.sve_core.r.a.c(this, r100, NewBetaDownloadWidget$onUpdate$3.INSTANCE, new NewBetaDownloadWidget$onUpdate$4(this, r100));
        com.bytedance.ies.sve_core.r.a.c(this, r100, NewBetaDownloadWidget$onUpdate$5.INSTANCE, new NewBetaDownloadWidget$onUpdate$6(this));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(com.bytedance.ies.sve_core.p r100) {
        dr((t) r100);
    }

    public NewBetaDownloadWidget(com.bytedance.android.gamecp.business.gamedetail.base.model.h r100, Function1<? super PureWidget<t>, Unit> r101) {
        super(null, r101, null, 4);
        this.f53957x = r100;
        this.f53949p = "";
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        t r102 = (t) r101;
        Intrinsics.checkNotNullParameter(r102, SlcElement.KEY_PROPS);
        if (r100 == false) goto L31;
        int r103 = i0.f56003a;
        if (i0.i(Long.valueOf(r102.f54047e)) == false) goto L39;
        int r104 = r102.f54052j;
        if (r104 == 3) goto L19;
        if (r104 == 2) goto L19;
        if (r104 == 1) goto L19;
        if (r102.f54049g == true) goto L16;
        return;
    L16:
        if (this.f53951r == true) goto L33;
        er(r102, true);
        this.f53951r = true;
        return;
    L33:
        return;
    L19:
        if (r102.f54048f == true) goto L21;
        return;
    L21:
        if (this.f53953t == true) goto L36;
        com.bytedance.android.gamecp.business.download.p r105 = this.f53952s;
        if (r105 == null) goto L37;
        this.f53953t = true;
        xr.f r106 = (xr.f) xr.s.a(xr.f.class);
        if (r106 == null) goto L38;
        Context r107 = this.context;
        String r108 = r105.f52855k;
        if (r108 != null) goto L29;
        r108 = "";
    L29:
        r106.g2(r107, r108, new v(this, r102));
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L39:
        return;
    }

    public final void er(t r210, boolean r211) {
        Integer r100 = r210.f54061s;
        boolean r101 = false;
        int r102 = -1;
        if (r100 != null) goto L6;
    L7:
        Integer r103 = r210.f54061s;
        if (r103 != null) goto L11;
    L12:
        ToastUtil.b(r210.f54062t, 0);
        return;
    L11:
        if (r103.intValue() != 0) goto L12;
    L14:
        int r104 = i0.f56003a;
        if (i0.i(Long.valueOf(r210.f54047e)) == true) goto L18;
        ToastUtil.b(y0.i(R.string.gamecp_game_detail_beta_apply_download_un_support), 0);
        return;
    L18:
        String r105 = r210.f54045c;
        if (TextUtils.isEmpty(r105) == true) goto L21;
        dt.b r106 = (dt.b) Kq(dt.e.f469988b);
        String r107 = UriProtector.parse(UriProtector.getQueryParameter(UriProtector.parse(r105), "url")).buildUpon().build().toString();
        r105 = w36.a.b(UriProtector.parse(r105), "url").buildUpon().appendQueryParameter("enter_from", r106.G).appendQueryParameter("report_params", r106.f469961k0).appendQueryParameter("is_from_get_qualified_button", String.valueOf(true)).appendQueryParameter("support_platform", String.valueOf(this.f53954u)).appendQueryParameter("url", r107).build().toString();
    L21:
        String r110 = r105;
        int r108 = r210.f54052j;
        if (r108 != 3) goto L42;
        NewBottomDetailDownloadView r109 = this.f53948o;
        if (r109 == null) goto L28;
        Integer r111 = r109.getDownloadStatus();
        if (r111 == null) goto L28;
        r102 = r111.intValue();
    L28:
        if (r102 < 1) goto L34;
        if (r102 > 7) goto L34;
        NewBottomDetailDownloadView r112 = this.f53948o;
        if (r112 == null) goto L79;
        r112.o6();
        return;
    L79:
        return;
    L34:
        boolean r113 = r210.f54044b;
        if (r113 == false) goto L40;
        NewBottomDetailDownloadView r114 = this.f53948o;
        if (r114 == null) goto L80;
        r114.o6();
        return;
    L80:
        return;
    L40:
        ki(new com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload.a(this.context, r210.f54046d, r210.f54052j, r210.f54047e, r110, r210.f54053k, r113, r210.f54054l, r210.f54055m, r210.f54059q));
        return;
    L42:
        if (r108 != 2) goto L60;
        NewBottomDetailDownloadView r115 = this.f53948o;
        if (r115 == null) goto L48;
        Integer r116 = r115.getDownloadStatus();
        if (r116 == null) goto L48;
        r102 = r116.intValue();
    L48:
        if (r102 < 1) goto L54;
        if (r102 > 7) goto L54;
        NewBottomDetailDownloadView r117 = this.f53948o;
        if (r117 == null) goto L81;
        r117.o6();
        return;
    L81:
        return;
    L54:
        NewBottomDetailDownloadView r118 = this.f53948o;
        if (r118 == null) goto L57;
        r118.setDownloadStartListener(new b(this, r210, r110));
    L57:
        NewBottomDetailDownloadView r119 = this.f53948o;
        if (r119 == null) goto L83;
        r119.o6();
        return;
    L83:
        return;
    L60:
        if (r108 != 1) goto L73;
        NewBottomDetailDownloadView r120 = this.f53948o;
        if (r120 == null) goto L64;
        r120.o6();
    L64:
        NewBottomDetailDownloadView r121 = this.f53948o;
        if (r121 == null) goto L69;
        Integer r122 = r121.getDownloadStatus();
        if (r122 == null) goto L69;
        r102 = r122.intValue();
    L69:
        if (r102 < 1) goto L72;
        if (r102 > 7) goto L72;
        return;
    L72:
        ki(new e(this.context, r210.f54046d, r210.f54052j, r210.f54047e, r110, r210.f54054l, r210.f54055m, r210.f54053k, r210.f54059q));
        return;
    L73:
        Context r123 = this.context;
        String r124 = r210.f54045c;
        if (r210.f54048f == false) goto L77;
        if (r211 == false) goto L77;
        r101 = true;
    L77:
        ki(new com.bytedance.android.gamecp.business.gamedetail.component.betaapply.download.d(r123, r124, r101, i0.i(Long.valueOf(r210.f54047e))));
        return;
    L6:
        if (r100.intValue() == (-1)) goto L14;
        goto L7
    }
}
