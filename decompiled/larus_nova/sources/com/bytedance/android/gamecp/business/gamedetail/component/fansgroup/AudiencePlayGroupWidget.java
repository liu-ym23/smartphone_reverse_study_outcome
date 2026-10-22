package com.bytedance.android.gamecp.business.gamedetail.component.fansgroup;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_list.RecyclerViewItemWidget;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yt.o;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/fansgroup/AudiencePlayGroupWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/fansgroup/a;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudiencePlayGroupWidget extends BaseGameDetailWidget<a> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f54300u = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Button f54301o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f54302p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f54303q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f54304r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public HSImageView f54305s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f54306t;

    public AudiencePlayGroupWidget() {
        this(null);
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_audience_game_promote_detail_item_play_group;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        this.f54301o = (Button) this.contentView.findViewById(R.id.btn_confirm);
        this.f54302p = (TextView) this.contentView.findViewById(R.id.tv_group_name);
        this.f54303q = (TextView) this.contentView.findViewById(R.id.tv_group_des);
        this.f54304r = (TextView) this.contentView.findViewById(R.id.tv_group_num);
        this.f54305s = (HSImageView) this.containerView.findViewById(R.id.group_portrait);
        o.a((TextView) this.contentView.findViewById(R.id.tv_item_title), 600);
    }

    public AudiencePlayGroupWidget(Function1<? super RecyclerViewItemWidget<a>, ? extends Object> r100) {
        super(null, r100, null, 4);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        dr((a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        dr((a) r100);
    }

    public final void dr(final a r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_PROPS);
        super.br(r110);
        Object r100 = r110.f54311e;
        boolean r101 = true;
        if (this.f54306t == true) goto L12;
        HashMap<String, String> r102 = GamecpTracker.f56755a;
        View r103 = this.contentView;
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        GamecpTracker.r(r103, "groupchat_area", MapsKt.mapOf(TuplesKt.to("group_ucnt", r100.toString())), new e(), false, 112);
        Button r111 = this.f54301o;
        if (r111 == null) goto L11;
        GamecpTracker.r(r111, "groupchat_join", MapsKt.emptyMap(), new d(this), false, 112);
    L11:
        this.f54306t = true;
    L12:
        TextView r104 = this.f54302p;
        if (r104 == null) goto L15;
        r104.setText(r110.f54309c);
    L15:
        TextView r105 = this.f54304r;
        if (r105 == null) goto L18;
        r105.setText("(" + r110.f54311e + ')');
    L18:
        TextView r106 = this.f54303q;
        if (r106 == null) goto L30;
        String r107 = r110.f54312f;
        if (r107 != null) goto L23;
    L26:
        if (r101 == false) goto L28;
        String r108 = y0.i(R.string.ttlive_game_promote_join_group_tip);
    L29:
        r106.setText(r108);
        goto L30
    L28:
        r108 = r110.f54312f;
        goto L29
    L23:
        if (StringsKt.isBlank(r107) == true) goto L26;
        r101 = false;
    L30:
        r.a.c(this, r110, AudiencePlayGroupWidget$onUpdate$1.INSTANCE, new AudiencePlayGroupWidget$onUpdate$2(this, r110));
        r.a.c(this, r110, AudiencePlayGroupWidget$onUpdate$3.INSTANCE, new AudiencePlayGroupWidget$onUpdate$4(this));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(p r100) {
        dr((a) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        Intrinsics.checkNotNullParameter((a) r101, "data");
    }
}
