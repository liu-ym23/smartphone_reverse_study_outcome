package com.bytedance.android.gamecp.business.gamedetail.component.minigameplay;

import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.ItemViewLayoutStyle;
import com.bytedance.android.gamecp.base.gamedetail.c0;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.business.gamedetail.GamePromoteDetailDialogManager;
import com.bytedance.android.gamecp.business.gamedetail.base.config.ImmediatePlayBtnConfig$Type;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.g0;
import com.bytedance.android.gamecp.common.utils.n;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_list.RecyclerViewItemWidget;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt.l;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/minigameplay/MiniGamePlayLaunchButtonWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDetailWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/minigameplay/h;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniGamePlayLaunchButtonWidget extends BaseGameDetailWidget<h> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f54569x = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f54570o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f54571p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f54572q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f54573r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f54574s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f54575t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c0 f54576u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final bt.a f54577v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f54578w;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MiniGamePlayLaunchButtonWidget f54579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f54580b;

        public b(MiniGamePlayLaunchButtonWidget r100, h r101) {
            this.f54579a = r100;
            this.f54580b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (n.c("MiniGamePlayLaunchButtonWidget") == false) goto L6;
            yr.c.e("MiniGamePlayLaunchButtonWidget", "MiniGamePlayLaunchButton double click");
            return;
        L6:
            GamePromoteDetailDialogManager.c(GamePromoteDetailDialogManager.f53445d);
            if (l.a() == false) goto L9;
            com.bytedance.android.gamecp.host_api.a.b().getBrowserService().closeWebDialog();
        L9:
            com.bytedance.android.gamecp.business.gamedetail.component.minigameplay.a r101 = this.f54580b.f54602b;
            if (r101 == null) goto L15;
            com.bytedance.android.gamecp.host_api.model.g r102 = r101.miniGameMeta;
            if (r102 == null) goto L16;
            MiniGamePlayLauncher.f54583a.c(this.f54579a.context, r102);
            return;
        L16:
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MiniGamePlayLaunchButtonWidget f54581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f54582b;

        public c(MiniGamePlayLaunchButtonWidget r100, h r101) {
            this.f54581a = r100;
            this.f54582b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (n.c("MiniGamePlayLaunchButtonWidget") == false) goto L6;
            yr.c.e("MiniGamePlayLaunchButtonWidget", "MiniGamePlayLaunchButton double click");
            return;
        L6:
            GamePromoteDetailDialogManager.c(GamePromoteDetailDialogManager.f53445d);
            if (l.a() == false) goto L9;
            com.bytedance.android.gamecp.host_api.a.b().getBrowserService().closeWebDialog();
        L9:
            com.bytedance.android.gamecp.business.gamedetail.component.minigameplay.a r101 = this.f54582b.f54602b;
            if (r101 == null) goto L15;
            com.bytedance.android.gamecp.host_api.model.g r102 = r101.miniGameMeta;
            if (r102 == null) goto L16;
            MiniGamePlayLauncher.f54583a.c(this.f54581a.context, r102);
            return;
        L16:
            return;
        }
    }

    static {
    }

    public final LinearLayout dr() {
        return (LinearLayout) this.f54570o.getValue();
    }

    public final TextView er() {
        return (TextView) this.f54572q.getValue();
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_game_detail_minigameplay_launch_button;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        c0 r100 = this.f54576u;
        if (r100 == null) goto L5;
        ItemViewLayoutStyle r101 = r100.f51563a;
    L7:
        if (r101 == null) goto L22;
        int r102 = d.f54598a[r101.ordinal()];
        if (r102 != 1) goto L12;
        g0.f(dr(), UtilityKotlinExtentionsKt.c(20));
        g0.g(dr(), UtilityKotlinExtentionsKt.c(20));
        goto L22
    L12:
        if (r102 != 2) goto L14;
        g0.f(dr(), 0);
        g0.g(dr(), 0);
        goto L22
    L14:
        if (r102 != 3) goto L16;
        g0.f(dr(), 0);
        g0.g(dr(), 0);
        goto L22
    L16:
        if (r102 != 4) goto L22;
        g0.f(dr(), 0);
        g0.g(dr(), 0);
    L22:
        ImmediatePlayBtnConfig$Type r103 = ImmediatePlayBtnConfig$Type.MiniPlay;
        bt.a r104 = this.f54577v;
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r104, "btnUIStyle");
        LinearLayout r105 = dr();
        if (r105 == null) goto L25;
        r105.setBackgroundResource(r104.a(r103));
    L25:
        TextView r106 = er();
        if (r106 == null) goto L28;
        r106.setTextColor(y0.c(r104.b(r103)));
    L28:
        LinearLayout r107 = (LinearLayout) this.f54573r.getValue();
        if (r107 == null) goto L31;
        r107.setBackgroundResource(r104.a(r103));
    L31:
        TextView r108 = (TextView) this.f54575t.getValue();
        if (r108 == null) goto L34;
        r108.setTextColor(y0.c(r104.b(r103)));
    L34:
        ImageView r109 = (ImageView) this.f54574s.getValue();
        if (r109 == null) goto L38;
        r109.setImageResource(r104.c(r103));
    L38:
        if (this.f54578w == false) goto L50;
        TextView r110 = (TextView) this.f54575t.getValue();
        if (r110 == null) goto L44;
        TextPaint r111 = r110.getPaint();
        if (r111 == null) goto L44;
        r111.setFakeBoldText(true);
    L44:
        TextView r112 = er();
        if (r112 == null) goto L51;
        TextPaint r113 = r112.getPaint();
        if (r113 == null) goto L52;
        r113.setFakeBoldText(true);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        fr((h) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        fr((h) r100);
    }

    public final void fr(final h r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.br(r100);
        r.a.c(this, r100, MiniGamePlayLaunchButtonWidget$onUpdate$1.INSTANCE, new MiniGamePlayLaunchButtonWidget$onUpdate$2(this, r100));
        r.a.c(this, r100, MiniGamePlayLaunchButtonWidget$onUpdate$3.INSTANCE, new MiniGamePlayLaunchButtonWidget$onUpdate$4(this, r100));
        dr().setOnClickListener(new b(this, r100));
        ((LinearLayout) this.f54573r.getValue()).setOnClickListener(new c(this, r100));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(p r100) {
        fr((h) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        Intrinsics.checkNotNullParameter((h) r101, "data");
    }

    public MiniGamePlayLaunchButtonWidget(c0 r100, bt.a r101, boolean r102, Function1<? super RecyclerViewItemWidget<h>, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r101, "buttonUIStyle");
        super(null, r103, null, 4);
        this.f54576u = r100;
        this.f54577v = r101;
        this.f54578w = r102;
        this.f54570o = LazyKt.lazy(new MiniGamePlayLaunchButtonWidget$container$2(this));
        this.f54571p = LazyKt.lazy(new MiniGamePlayLaunchButtonWidget$icon$2(this));
        this.f54572q = LazyKt.lazy(new MiniGamePlayLaunchButtonWidget$launchText$2(this));
        this.f54573r = LazyKt.lazy(new MiniGamePlayLaunchButtonWidget$playWithDownloadBtn$2(this));
        this.f54574s = LazyKt.lazy(new MiniGamePlayLaunchButtonWidget$playWithDownloadIcon$2(this));
        this.f54575t = LazyKt.lazy(new MiniGamePlayLaunchButtonWidget$playWithDownloadText$2(this));
    }
}
