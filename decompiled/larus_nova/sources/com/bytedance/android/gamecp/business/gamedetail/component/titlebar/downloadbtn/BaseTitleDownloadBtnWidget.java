package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.downloadbtn;

import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.base.gamedetail.e0;
import com.bytedance.android.gamecp.base.gamedetail.f0;
import com.bytedance.android.gamecp.business.download.p;
import com.bytedance.android.gamecp.business.download.y0;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import com.bytedance.android.gamecp.business.gamedetail.base.model.j;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.business.gamedetail.component.titlebar.downloadbtn.a;
import com.bytedance.android.gamecp.business.gamedetail.view.TitleDownloadView;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_list.RecyclerViewItemWidget;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/titlebar/downloadbtn/BaseTitleDownloadBtnWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/titlebar/downloadbtn/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseTitleDownloadBtnWidget<T extends a> extends BaseGameDetailWidget<T> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f55167v = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TitleDownloadView f55168o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public p f55169p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f55170q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f0 f55171r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final h f55172s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f55173t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function1<? super RecyclerViewItemWidget<T>, ? extends Object> f55174u;

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_game_detail_title_download_btn;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        View r100 = this.contentView;
        if (r100 == null) goto L5;
        TitleDownloadView r101 = (TitleDownloadView) r100.findViewById(R.id.game_detail_title_game_download);
    L6:
        this.f55168o = r101;
        e0 r102 = this.f55171r.f51578b;
        int r103 = r102.f51572e;
        int r104 = r102.f51573f;
        if (this.f55173t == false) goto L27;
        h r105 = this.f55172s;
        if (r105 == null) goto L15;
        j r106 = r105.c();
        if (r106 == null) goto L15;
        if (r106.i() != true) goto L15;
        int r107 = R.color.gamecp_game_57161823;
        int r108 = R.drawable.shape_border_33161823_corner_4;
    L16:
        TitleDownloadView r109 = this.f55168o;
        if (r109 == null) goto L26;
        TextView r110 = r109.getDownloadTv();
        if (r110 == null) goto L21;
        r110.setTextSize(1, 13.0f);
    L21:
        TextView r111 = r109.getDownloadTv();
        if (r111 == null) goto L26;
        TextPaint r112 = r111.getPaint();
        if (r112 == null) goto L26;
        r112.setFakeBoldText(true);
    L26:
        int r113 = R.drawable.gamecp_transparent;
        int r114 = r107;
        int r115 = r108;
    L28:
        this.contentView.setBackgroundResource(r113);
        TitleDownloadView r116 = this.f55168o;
        if (r116 == null) goto L32;
        e0 r117 = this.f55171r.f51578b;
        r116.setUIStyle(new e0(r117.f51568a, r117.f51569b, r117.f51570c, r117.f51571d, r115, r114, r117.f51574g));
        return;
    L32:
        return;
    L15:
        r107 = R.color.gamecp_57FFFFFF;
        r108 = R.drawable.shape_border_33ffffff_corner_4;
        goto L16
    L27:
        r114 = r104;
        r115 = r103;
        r113 = R.drawable.shape_bg_f8f8f8_corner_4;
        goto L28
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Gq() {
        super.Gq();
        p r100 = this.f55169p;
        if (r100 == null) goto L6;
        y0.f52963a.i(this.context, r100);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        dr((a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public /* bridge */ /* synthetic */ void br(d0 r100) {
        dr((a) r100);
    }

    public void dr(final T r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        r.a.c(this, r100, BaseTitleDownloadBtnWidget$onUpdate$1.INSTANCE, new BaseTitleDownloadBtnWidget$onUpdate$2(this));
        r.a.c(this, r100, BaseTitleDownloadBtnWidget$onUpdate$3.INSTANCE, new BaseTitleDownloadBtnWidget$onUpdate$4(this, r100));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public /* bridge */ /* synthetic */ void wj(com.bytedance.ies.sve_core.p r100) {
        dr((a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        Intrinsics.checkNotNullParameter((a) r101, "data");
    }

    public BaseTitleDownloadBtnWidget(f0 r100, h r101, boolean r102, Function1<? super RecyclerViewItemWidget<T>, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "uiStyle");
        super(null, r103, null, 4);
        this.f55171r = r100;
        this.f55172s = r101;
        this.f55173t = r102;
        this.f55174u = r103;
        this.f55170q = LazyKt.lazy(new BaseTitleDownloadBtnWidget$launchParams$2(this));
    }
}
