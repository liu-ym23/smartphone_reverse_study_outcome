package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.ec.widget.loading.ECDuxLoadingAnimationView;
import com.bytedance.android.ui.ec.widget.loading.ECLoadingConfig;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/core/widget/DoubleColorBallStatusView;", "Landroid/widget/FrameLayout;", "", "status", "", "setECStatus", "", "Landroid/view/View;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/Map;", "getStatusViews", "()Ljava/util/Map;", "setStatusViews", "(Ljava/util/Map;)V", "statusViews", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DoubleColorBallStatusView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f45886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45887b;

    public static final class a {
    }

    static {
    }

    public DoubleColorBallStatusView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DoubleColorBallStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (this.f45887b != (-1)) goto L5;
        return;
    L5:
        setVisibility(8);
        View r100 = this.f45886a.get(Integer.valueOf(this.f45887b));
        if (r100 == null) goto L8;
        r100.setVisibility(4);
    L8:
        this.f45887b = -1;
    }

    public final Map<Integer, View> getStatusViews() {
        return this.f45886a;
    }

    public final void setECStatus(int r100) {
        int r101 = this.f45887b;
        if (r101 < 0) goto L7;
        View r102 = this.f45886a.get(Integer.valueOf(r101));
        if (r102 == null) goto L7;
        r102.setVisibility(4);
    L7:
        View r103 = this.f45886a.get(Integer.valueOf(r100));
        if (r103 == null) goto L20;
        r103.setVisibility(0);
        this.f45887b = r100;
        if (r100 != 0) goto L21;
        ECDuxLoadingAnimationView r104 = (ECDuxLoadingAnimationView) r103.findViewById(R.id.shopping_view_double_loading);
        if (r104 != null) goto L14;
        return;
    L14:
        if ((!r104.isAnimating()) == true) goto L17;
        r104 = null;
    L17:
        if (r104 == null) goto L23;
        r104.startAnimate();
        return;
    L23:
        return;
    L21:
        return;
    }

    public final void setStatusViews(Map<Integer, View> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f45886a = r100;
    }

    public DoubleColorBallStatusView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        LinkedHashMap r113 = new LinkedHashMap();
        this.f45886a = r113;
        this.f45887b = -1;
        r113.clear();
        Map<Integer, View> r114 = this.f45886a;
        ECLoadingConfig r100 = ECLoadingConfig.INSTANCE;
        if (r100.isDecided() == true) goto L5;
        r100.decideUsePersistentCache(ECSettingKeys.E());
    L5:
        View r101 = th.a.c(getContext(), R.layout.shopping_layout_double_color_ball_status_view_loading, this, false);
        Lazy r102 = ECAppInfoService.f48110a;
        if (ECAppInfoService.h() == false) goto L9;
        ((ECDuxLoadingAnimationView) r101.findViewById(R.id.shopping_view_double_loading)).setVisibility(0);
    L11:
        r114.put(0, r101);
        this.f45886a.put(1, null);
        this.f45886a.put(2, null);
        removeAllViews();
        Iterator<Integer> r115 = this.f45886a.keySet().iterator();
    L13:
        if (r115.hasNext() == false) goto L18;
        int r116 = r115.next().intValue();
        View r117 = this.f45886a.get(Integer.valueOf(r116));
        if (r117 == null) goto L13;
        r117.setVisibility(4);
        addView(r117);
        goto L13
    L18:
        return;
    L9:
        if (we.a.f559330a == false) goto L11;
        ((FrameLayout) r101.findViewById(R.id.shopping_fl_xg_or_tt_loading_lottie)).setVisibility(0);
        ImageView r118 = (ImageView) r101.findViewById(R.id.shopping_iv_xg_or_tt_loading_lottie);
        RotateAnimation r103 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r103.setInterpolator(new LinearInterpolator());
        r103.setDuration(1000);
        r103.setRepeatCount(-1);
        r103.setFillAfter(true);
        r103.setStartOffset(0);
        Unit r119 = Unit.INSTANCE;
        r118.startAnimation(r103);
        goto L11
    }

    public /* synthetic */ DoubleColorBallStatusView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
