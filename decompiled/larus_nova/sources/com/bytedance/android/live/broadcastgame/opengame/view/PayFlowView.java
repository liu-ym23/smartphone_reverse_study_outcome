package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.common.utility.Logger;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0014B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/PayFlowView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "f", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getWholeItem", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "wholeItem", "", ce.f26391f, "I", "getTextWidth", "()I", "setTextWidth", "(I)V", "textWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PayFlowView extends ConstraintLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f61235i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f61236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f61237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f61238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f61239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f61240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f61241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f61242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PayFlowView$startHideCountdown$2 f61243h;

    public static final class a {
    }

    static {
    }

    public final boolean T5() {
        if (this.f61238c.getVisibility() != 0) goto L5;
        boolean r100 = true;
    L7:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L9;
        Logger.d("PayFlowView", "PayFlowView, isFlowShowing: " + r100);
    L9:
        return r100;
    L5:
        r100 = false;
        goto L7
    }

    public final void S5() {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "PayFlowView, fetchPayMsg");
    L5:
        f r100 = this.f61237b;
        if (r100 == null) goto L48;
        com.bytedance.android.live.broadcastgame.opengame.message.r r101 = r100.poll();
        if (r101 == null) goto L49;
        Function1<? super Boolean, Unit> r102 = this.f61240e;
        if (r102 == null) goto L13;
        Unit r103 = r102.invoke(Boolean.TRUE);
    L13:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L16;
        Logger.d("PayFlowView", "PayFlowView, onNewPayMsg");
    L16:
        if (T5() == false) goto L37;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L20;
        Logger.d("PayFlowView", "PayFlowView, 已有老流水，新流水替换老流水");
    L20:
        KeyEvent.Callback r104 = this.f61238c;
        if (r104 == null) goto L35;
        ((d) r104).k(new PayFlowView$onNewPayMsg$3(this));
        KeyEvent.Callback r105 = this.f61239d;
        if (r105 == null) goto L33;
        ((d) r105).y(r101.f60273c, new PayFlowView$onNewPayMsg$4(this));
        KeyEvent.Callback r106 = this.f61239d;
        if (r106 == null) goto L31;
        ((d) r106).o(new PayFlowView$onNewPayMsg$5(this));
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L29;
        Logger.d("PayFlowView", "PayFlowView, 新老 Item 互换");
    L29:
        View r107 = this.f61238c;
        this.f61238c = this.f61239d;
        this.f61239d = r107;
        return;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IFlowItemView");
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IFlowItemView");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IFlowItemView");
    L37:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L39;
        Logger.d("PayFlowView", "PayFlowView,  没有老流水，新流水直接展示");
    L39:
        z.b(_$_findCachedViewById(R.id.pay_msg_bg));
        z.b(_$_findCachedViewById(R.id.pay_icon));
        KeyEvent.Callback r108 = this.f61238c;
        if (r108 == null) goto L47;
        ((d) r108).y(r101.f60273c, new PayFlowView$onNewPayMsg$8(this));
        KeyEvent.Callback r109 = this.f61238c;
        if (r109 == null) goto L45;
        ((d) r109).j(new PayFlowView$onNewPayMsg$9(this));
        return;
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IFlowItemView");
    L47:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IFlowItemView");
    L49:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        Logger.d("PayFlowView", "PayFlowView, onDetachedFromWindow");
    L6:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L8;
        Logger.d("PayFlowView", "PayFlowView, cancelHideCountdown");
    L8:
        PayFlowView$startHideCountdown$2 r100 = this.f61243h;
        if (r100 == null) goto L12;
        removeCallbacks(r100);
        return;
    }

    public final int getTextWidth() {
        return this.f61242g;
    }

    public final ConstraintLayout getWholeItem() {
        return this.f61241f;
    }

    public PayFlowView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f61236a = new LinkedHashMap();
        this.f61238c = new c(r100);
        this.f61239d = new c(r100);
        View r101 = LayoutInflater.from(r100).inflate(R.layout.ttlive_open_platform_anchor_panel_pay_msg_view, this);
        if (r101 == null) goto L7;
        this.f61241f = (ConstraintLayout) r101;
        ((ImageView) _$_findCachedViewById(R.id.pay_icon)).setId(View.generateViewId());
        ImageUtil.loadImage((ImageView) _$_findCachedViewById(R.id.pay_icon), r3.a(), 0);
        ((ConstraintLayout) _$_findCachedViewById(R.id.pay_amount_placeholder)).addView(this.f61238c);
        ((ConstraintLayout) _$_findCachedViewById(R.id.pay_amount_placeholder)).addView(this.f61239d);
        ((ConstraintLayout) _$_findCachedViewById(R.id.pay_msg_bg)).setVisibility(4);
        ((ImageView) _$_findCachedViewById(R.id.pay_icon)).setVisibility(4);
        this.f61238c.setVisibility(4);
        this.f61239d.setVisibility(4);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.android.live.broadcastgame.opengame.view.PayFlowView$startHideCountdown$2] */
    public static final void R5(final PayFlowView r100) {
        r100.getClass();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        Logger.d("PayFlowView", "PayFlowView, startHideCountdown");
    L6:
        if (r100.f61243h != null) goto L8;
        r100.f61243h = new PayFlowView$startHideCountdown$2(r100);
    L8:
        PayFlowView$startHideCountdown$2 r101 = r100.f61243h;
        if (r101 == null) goto L11;
        r100.removeCallbacks(r101);
    L11:
        r100.postDelayed(r100.f61243h, 5000);
    }

    public final View _$_findCachedViewById(int r100) {
        if (this.f61236a != null) goto L5;
        this.f61236a = new LinkedHashMap();
    L5:
        View r101 = this.f61236a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f61236a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setTextWidth(int r100) {
        this.f61242g = r100;
    }
}
