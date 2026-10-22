package com.bytedance.android.livesdk.chatroom.tetris.vr.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tetris/vr/ui/RecenterGuideView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecenterGuideView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LottieAnimationView f111951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f111952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f111953c;

    /* JADX WARN: Multi-variable type inference failed */
    public RecenterGuideView() {
        Context r100 = null;
        Object[] r101 = 0 == true ? 1 : 0;
        this(r100, r101, 7, 0);
    }

    public RecenterGuideView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RecenterGuideView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        Disposable r100 = this.f111953c;
        LottieAnimationView r101 = null;
        if (r100 != null) goto L5;
    L10:
        LottieAnimationView r102 = this.f111951a;
        if (r102 != null) goto L13;
    L17:
        UtilityKotlinExtentionsKt.t(this);
        return;
    L13:
        if (r102.isAnimating() == false) goto L15;
        r101 = r102;
    L15:
        if (r101 == null) goto L17;
        r101.cancelAnimation();
        goto L17
    L5:
        if ((!r100.isDisposed()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.dispose();
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public RecenterGuideView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNull(r100);
        super(r100, r101, r102);
        this.f111952b = "ttlive_vr_recenter_guide.zip";
        LayoutInflater.from(r100).inflate(R.layout.ttlive_vr_recenter_guide_view, this, true);
        this.f111951a = (LottieAnimationView) findViewById(R.id.lavGuide);
    }

    public /* synthetic */ RecenterGuideView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101, 0);
    }
}
