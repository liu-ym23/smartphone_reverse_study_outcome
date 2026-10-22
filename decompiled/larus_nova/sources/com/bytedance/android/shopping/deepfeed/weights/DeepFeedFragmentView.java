package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedFragmentView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "", "observer", "setTouchObserver", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedFragmentView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super MotionEvent, Unit> f174025a;

    public DeepFeedFragmentView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepFeedFragmentView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        Function1<? super MotionEvent, Unit> r101 = this.f174025a;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(r100);
    L6:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return super.onInterceptTouchEvent(r100);
    }

    public final void setTouchObserver(Function1<? super MotionEvent, Unit> r100) {
        this.f174025a = r100;
    }

    public DeepFeedFragmentView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ DeepFeedFragmentView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
