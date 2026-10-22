package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieTask;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/LiveSkeletonScreenLoadingView;", "Landroid/widget/FrameLayout;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSkeletonScreenLoadingView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LottieAnimationView f112345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LottieTask<LottieComposition> f112346b;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f112346b == null) goto L5;
        this.f112346b = null;
    L5:
        LottieAnimationView r100 = this.f112345a;
        if (r100 == null) goto L9;
        r100.cancelAnimation();
        return;
    }

    public LiveSkeletonScreenLoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L17;
        LottieAnimationView r101 = this.f112345a;
        if (r101 == null) goto L7;
        LottieComposition r102 = r101.getComposition();
    L8:
        if (r102 != null) goto L10;
        this.f112346b = LottieCompositionFactory.fromAsset(getContext(), "loading_data.json").addListener(new v7(this)).addFailureListener(w7.f114291a);
        return;
    L10:
        LottieAnimationView r103 = this.f112345a;
        if (r103 != null) goto L13;
        return;
    L13:
        if (r103.isAnimating() == true) goto L23;
        LottieAnimationView r104 = this.f112345a;
        if (r104 == null) goto L24;
        r104.playAnimation();
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r102 = null;
        goto L8
    L17:
        LottieAnimationView r105 = this.f112345a;
        if (r105 == null) goto L26;
        r105.cancelAnimation();
        return;
    }

    public LiveSkeletonScreenLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public LiveSkeletonScreenLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LottieAnimationView r103 = (LottieAnimationView) LayoutInflater.from(r100).inflate(R.layout.ttlive_layout_skeleton_screen_loading_view, this, true).findViewById(R.id.view_loading_anim);
        this.f112345a = r103;
        if (r103 == null) goto L6;
        r103.loop(true);
        return;
    }
}
