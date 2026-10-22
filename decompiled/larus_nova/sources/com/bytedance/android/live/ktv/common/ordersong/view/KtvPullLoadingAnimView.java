package com.bytedance.android.live.ktv.common.ordersong.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/view/KtvPullLoadingAnimView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "", "text", "setText", "color", "setTextColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvPullLoadingAnimView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f70221a;

    public static final class a {
    }

    static {
    }

    public KtvPullLoadingAnimView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvPullLoadingAnimView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void R5() {
        LiveDoubleColorBallAnimationView r100 = (LiveDoubleColorBallAnimationView) _$_findCachedViewById(R.id.douyin_loading_view);
        if (r100 == null) goto L5;
        r100.setVisibility(0);
    L5:
        TextView r101 = (TextView) _$_findCachedViewById(R.id.loading_tv);
        if (r101 == null) goto L9;
        r101.setVisibility(0);
        return;
    }

    public final void S5() {
        LiveDoubleColorBallAnimationView r100 = (LiveDoubleColorBallAnimationView) _$_findCachedViewById(R.id.douyin_loading_view);
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        TextView r101 = (TextView) _$_findCachedViewById(R.id.loading_tv);
        if (r101 == null) goto L9;
        r101.setVisibility(8);
        return;
    }

    public final View _$_findCachedViewById(int r100) {
        if (this.f70221a != null) goto L5;
        this.f70221a = new LinkedHashMap();
    L5:
        View r101 = this.f70221a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f70221a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = (TextView) _$_findCachedViewById(R.id.loading_tv);
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setTextColor(int r100) {
        TextView r101 = (TextView) _$_findCachedViewById(R.id.loading_tv);
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        LiveDoubleColorBallAnimationView r101 = (LiveDoubleColorBallAnimationView) _$_findCachedViewById(R.id.douyin_loading_view);
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        TextView r102 = (TextView) _$_findCachedViewById(R.id.loading_tv);
        if (r102 == null) goto L9;
        r102.setVisibility(r100);
        return;
    }

    public KtvPullLoadingAnimView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f70221a = new LinkedHashMap();
        View.inflate(r100, R.layout.ttlive_layout_ktv_loading, this);
        LiveDoubleColorBallAnimationView r103 = (LiveDoubleColorBallAnimationView) _$_findCachedViewById(R.id.douyin_loading_view);
        if (r103 == null) goto L5;
        r103.setVisibility(0);
    L5:
        LottieAnimationView r104 = (LottieAnimationView) _$_findCachedViewById(R.id.hotsoon_loading_view);
        if (r104 == null) goto L9;
        r104.setVisibility(8);
        return;
    }

    public /* synthetic */ KtvPullLoadingAnimView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
