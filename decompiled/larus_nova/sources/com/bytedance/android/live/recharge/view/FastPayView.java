package com.bytedance.android.live.recharge.view;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.a0;
import com.bytedance.android.live.recharge.deal.f;
import com.bytedance.android.live.recharge.model.d;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.business.model.diamond.a;
import com.bytedance.android.live.recharge.platform.business.model.diamond.g;
import com.bytedance.android.live.recharge.service.e;
import com.bytedance.android.live.recharge.utils.m;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rw0.b;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010G\u001a\u00020F¢\u0006\u0004\bH\u0010IB\u001b\b\u0016\u0012\u0006\u0010G\u001a\u00020F\u0012\b\u0010K\u001a\u0004\u0018\u00010J¢\u0006\u0004\bH\u0010LB#\b\u0016\u0012\u0006\u0010G\u001a\u00020F\u0012\b\u0010K\u001a\u0004\u0018\u00010J\u0012\u0006\u0010N\u001a\u00020M¢\u0006\u0004\bH\u0010OR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00101\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R$\u00109\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010=\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010(\u001a\u0004\b;\u0010*\"\u0004\b<\u0010,R.\u0010E\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006P"}, d2 = {"Lcom/bytedance/android/live/recharge/view/FastPayView;", "Landroid/widget/FrameLayout;", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getMFastMsg", "()Landroid/widget/TextView;", "setMFastMsg", "(Landroid/widget/TextView;)V", "mFastMsg", "b", "getMFastOtherPayHint", "setMFastOtherPayHint", "mFastOtherPayHint", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "getMFastOtherPayArrow", "()Landroid/widget/ImageView;", "setMFastOtherPayArrow", "(Landroid/widget/ImageView;)V", "mFastOtherPayArrow", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "getMActivity", "()Landroid/app/Activity;", "setMActivity", "(Landroid/app/Activity;)V", "mActivity", "", "e", "J", "getMRoomId", "()J", "setMRoomId", "(J)V", "mRoomId", "", "f", "Ljava/lang/String;", "getMRequestPage", "()Ljava/lang/String;", "setMRequestPage", "(Ljava/lang/String;)V", "mRequestPage", ce.f26391f, "getMChargeScene", "setMChargeScene", "mChargeScene", "Lcom/bytedance/android/live/recharge/deal/f;", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/live/recharge/deal/f;", "getMChargeDeal", "()Lcom/bytedance/android/live/recharge/deal/f;", "setMChargeDeal", "(Lcom/bytedance/android/live/recharge/deal/f;)V", "mChargeDeal", ce.f26395j, "getMChargeReason", "setMChargeReason", "mChargeReason", "Ljava/util/HashMap;", ce.f26396k, "Ljava/util/HashMap;", "getMExtraData", "()Ljava/util/HashMap;", "setMExtraData", "(Ljava/util/HashMap;)V", "mExtraData", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FastPayView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f90535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f90536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f90537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Activity f90538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f90539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f90540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f90541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RechargeDialogContext f90542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f90543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f90544j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HashMap<String, String> f90545k;

    public final void b() {
        View r100 = FrameLayout.inflate(getContext(), R.layout.ttlive_recharge_fastpay_layout, this);
        this.f90535a = (TextView) r100.findViewById(R.id.fastpay_msg);
        this.f90536b = (TextView) r100.findViewById(R.id.fastpay_other_pay);
        this.f90537c = (ImageView) r100.findViewById(R.id.fastpay_other_pay_arrow);
    }

    public final Activity getMActivity() {
        return this.f90538d;
    }

    public final f getMChargeDeal() {
        return this.f90543i;
    }

    public final String getMChargeReason() {
        return this.f90544j;
    }

    public final String getMChargeScene() {
        return this.f90541g;
    }

    public final HashMap<String, String> getMExtraData() {
        return this.f90545k;
    }

    public final TextView getMFastMsg() {
        return this.f90535a;
    }

    public final ImageView getMFastOtherPayArrow() {
        return this.f90537c;
    }

    public final TextView getMFastOtherPayHint() {
        return this.f90536b;
    }

    public final String getMRequestPage() {
        return this.f90540f;
    }

    public final long getMRoomId() {
        return this.f90539e;
    }

    public FastPayView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f90540f = "";
        this.f90541g = "";
        this.f90545k = new HashMap();
        b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(FastPayView r110) {
        Activity r100 = r110.f90538d;
        f r101 = r110.f90543i;
        if (r100 == null) goto L54;
        if (r101 == null) goto L55;
        g r102 = com.bytedance.android.live.recharge.deal.g.c(r101);
        HashMap<String, String> r103 = r110.f90545k;
        if (r102 == null) goto L9;
        String r104 = r102.getDiamondDesc();
        if (r104 == null) goto L9;
    L10:
        r103.put("giving_diamond_badge", r104);
        HashMap<String, String> r105 = r110.f90545k;
        String r106 = "";
        if (r102 == null) goto L16;
        a r107 = r102.getCouponBarInfo();
        if (r107 == null) goto L16;
        String r108 = r107.getDesc();
        if (r108 == null) goto L16;
    L17:
        r105.put("giving_diamond_bar", r108);
        HashMap<String, String> r109 = r110.f90545k;
        if (r102 == null) goto L23;
        String r111 = r102.getPreCalcInfo();
        if (r111 == null) goto L23;
        r106 = r111;
    L23:
        r109.put("pre_calc_info", r106);
        Context r112 = r110.getContext();
        HashMap<String, String> r113 = r110.f90545k;
        RechargeDialogContext r114 = r110.f90542h;
        if (r114 == null) goto L26;
        d r115 = r114.getMDialogEntranceParams();
    L27:
        d r116 = r115;
        RechargeDialogContext r117 = r110.f90542h;
        if (r117 == null) goto L36;
        a0 r118 = r117.getRepository();
        if (r118 == null) goto L36;
        PropertyOwner r119 = r118.f89599c;
        if (r119 == null) goto L36;
        Long r120 = (Long) r119.f64752a;
        if (r120 == null) goto L36;
        long r121 = r120.longValue();
    L37:
        Order r122 = e.b(r101, r112, r113, r116, false, 0, false, false, r121, null, null, 7920);
        RechargeDialogContext r123 = r110.f90542h;
        if (r123 == null) goto L42;
        n<Order> r124 = r123.getOrder();
        if (r124 == null) goto L42;
        r124.setValue(r122);
    L42:
        HashMap r125 = new HashMap();
        int r126 = m.f90492a;
        RechargeDialogContext r127 = r110.f90542h;
        if (r127 == null) goto L46;
        d r128 = r127.getMDialogEntranceParams();
        if (r128 == null) goto L46;
    L47:
        m.b(r125, r128, new Object[]{b.class});
        RechargeDialogContext r129 = r110.f90542h;
        if (r129 == null) goto L51;
        Map<String, String> r130 = r129.getReportExtraInfo("livesdk_recharge_page_pay_click");
        if (r130 == null) goto L51;
    L52:
        r125.putAll(r130);
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r131 = com.bytedance.android.live.recharge.utils.f.f90457a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_rd_fast_pay_other_click", r125, new Class[]{IRoom.class, x.class});
        return;
    L51:
        r130 = MapsKt.emptyMap();
    L46:
        r128 = d.f90011p;
    L36:
        r121 = -1;
        goto L37
    L26:
        r115 = null;
    L16:
        r108 = "";
    L9:
        r104 = r101.d();
        goto L10
    L55:
        return;
    }

    public final void setMActivity(Activity r100) {
        this.f90538d = r100;
    }

    public final void setMChargeDeal(f r100) {
        this.f90543i = r100;
    }

    public final void setMChargeReason(String r100) {
        this.f90544j = r100;
    }

    public final void setMChargeScene(String r100) {
        this.f90541g = r100;
    }

    public final void setMExtraData(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f90545k = r100;
    }

    public final void setMFastMsg(TextView r100) {
        this.f90535a = r100;
    }

    public final void setMFastOtherPayArrow(ImageView r100) {
        this.f90537c = r100;
    }

    public final void setMFastOtherPayHint(TextView r100) {
        this.f90536b = r100;
    }

    public final void setMRequestPage(String r100) {
        this.f90540f = r100;
    }

    public final void setMRoomId(long r100) {
        this.f90539e = r100;
    }

    public FastPayView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f90540f = "";
        this.f90541g = "";
        this.f90545k = new HashMap();
        b();
    }

    public FastPayView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f90540f = "";
        this.f90541g = "";
        this.f90545k = new HashMap();
        b();
    }
}
