package com.bytedance.android.livesdk.interactivity.comment.mention;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/mention/MentionListSearchingView;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getView", "()Landroid/view/View;", "view", "Landroid/animation/ObjectAnimator;", "b", "getLoadingAnimator", "()Landroid/animation/ObjectAnimator;", "loadingAnimator", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MentionListSearchingView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f135269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f135270b;

    public static final class a {
    }

    static {
    }

    public MentionListSearchingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MentionListSearchingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final ObjectAnimator getLoadingAnimator() {
        return (ObjectAnimator) this.f135270b.getValue();
    }

    private final View getView() {
        return (View) this.f135269a.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getLoadingAnimator().cancel();
    }

    public static final /* synthetic */ View a(MentionListSearchingView r100) {
        return r100.getView();
    }

    public final void b(boolean r100) {
        if (r100 == getLoadingAnimator().isRunning()) goto L8;
        if (r100 == false) goto L6;
        getLoadingAnimator().setDuration(1000);
        getLoadingAnimator().setRepeatCount(-1);
        getLoadingAnimator().setInterpolator(new LinearInterpolator());
        getLoadingAnimator().start();
        return;
    L6:
        getLoadingAnimator().cancel();
        return;
    }

    public MentionListSearchingView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f135269a = LazyKt.lazy(new MentionListSearchingView$view$2(this, r100));
        this.f135270b = LazyKt.lazy(new MentionListSearchingView$loadingAnimator$2(this));
    }

    public /* synthetic */ MentionListSearchingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
