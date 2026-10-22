package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.view.GameDetailCommonButton;
import com.bytedance.android.gamecp.business.i0;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.e1;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/convertbtn/betadownload/NewBetaDownloadPCWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/convertbtn/betadownload/t;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewBetaDownloadPCWidget extends BaseGameDetailWidget<t> {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f53928z = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public GameDetailCommonButton f53929o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f53930p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f53931q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f53932r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f53933s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Disposable f53934t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f53935u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f53936v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f53937w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f53938x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.gamedetail.base.model.h f53939y;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewBetaDownloadPCWidget f53940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f53941b;

        public b(NewBetaDownloadPCWidget r100, String r101) {
            this.f53940a = r100;
            this.f53941b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (com.bytedance.android.gamecp.common.utils.n.c("NewBetaDownloadButtonPCWidget") == false) goto L6;
            yr.c.e("NewBetaDownloadButtonPCWidget", "NewBetaDownloadButtonPCWidget double click");
            return;
        L6:
            NewBetaDownloadPCWidget r101 = this.f53940a;
            r101.ki(new f(r101.context, this.f53941b));
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_detail_new_beta_download_button_for_pc_widget;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        this.f53929o = (GameDetailCommonButton) this.contentView.findViewById(R.id.btn_beta_apply_download);
    }

    @Override // com.bytedance.ies.sve_core.PureWidget, com.bytedance.ies.sve_core.r
    public final void Zm() {
        super.Zm();
        Disposable r100 = this.f53932r;
        if (r100 != null) goto L5;
    L9:
        Disposable r101 = this.f53934t;
        if (r101 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("qualificationSuccessDispose");
    L13:
        if (r101.isDisposed() == true) goto L19;
        Disposable r102 = this.f53934t;
        if (r102 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("qualificationSuccessDispose");
    L17:
        r102.dispose();
        return;
    L19:
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        Disposable r103 = this.f53932r;
        if (r103 == null) goto L9;
        r103.dispose();
        goto L9
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
        com.bytedance.ies.sve_core.r.a.c(this, r100, NewBetaDownloadPCWidget$onUpdate$1.INSTANCE, new NewBetaDownloadPCWidget$onUpdate$2(this, r100));
    }

    public final void er(t r110) {
        int r100 = i0.f56003a;
        if (i0.i(Long.valueOf(r110.f54047e)) == true) goto L6;
        ToastUtil.b(y0.i(R.string.gamecp_game_detail_beta_apply_download_un_support), 0);
        return;
    L6:
        String r101 = this.f53933s;
        if (TextUtils.isEmpty(r101) == true) goto L12;
        String r102 = UriProtector.parse(UriProtector.getQueryParameter(UriProtector.parse(this.f53933s), "url")).buildUpon().build().toString();
        Uri.Builder r103 = w36.a.b(UriProtector.parse(this.f53933s), "url").buildUpon();
        com.bytedance.android.gamecp.business.gamedetail.util.e.f55635a.getClass();
        String r104 = null;
        Uri.Builder r105 = r103.appendQueryParameter("detailPageInitialData", com.bytedance.android.gamecp.business.gamedetail.util.e.a(this, null).toString());
        com.bytedance.android.gamecp.business.gamedetail.base.model.h r106 = this.f53939y;
        if (r106 == null) goto L11;
        r104 = e1.a(r106);
    L11:
        r101 = r105.appendQueryParameter("gameDetailCommonParams", r104).appendQueryParameter("is_from_get_qualified_button", String.valueOf(true)).appendQueryParameter("url", r102).build().toString();
    L12:
        String r107 = r101;
        int r108 = r110.f54052j;
        if (r108 != 1) goto L18;
        GameDetailCommonButton r111 = this.f53929o;
        if (r111 == null) goto L22;
        com.bytedance.android.gamecp.business.gamedetail.component.b.a(r111, this, new b(this, r107));
        return;
    L22:
        return;
    L18:
        if (r108 != 2) goto L20;
        ki(new d(this.context, r107));
        return;
    L20:
        ki(new c(this.context, r110.f54046d, r110.f54047e, r107, r110.f54053k, r110.f54044b));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(com.bytedance.ies.sve_core.p r100) {
        dr((t) r100);
    }

    public NewBetaDownloadPCWidget(com.bytedance.android.gamecp.business.gamedetail.base.model.h r100, Function1<? super PureWidget<t>, Unit> r101) {
        super(null, r101, null, 4);
        this.f53939y = r100;
        this.f53930p = "";
        this.f53931q = "";
        this.f53933s = "";
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        t r102 = (t) r101;
        Intrinsics.checkNotNullParameter(r102, SlcElement.KEY_PROPS);
        if (r100 == false) goto L13;
        int r103 = i0.f56003a;
        if (i0.i(Long.valueOf(r102.f54047e)) == true) goto L8;
        return;
    L8:
        if (r102.f54049g == true) goto L10;
        return;
    L10:
        if (this.f53938x == true) goto L15;
        er(r102);
        this.f53938x = true;
        return;
    L15:
        return;
    }
}
