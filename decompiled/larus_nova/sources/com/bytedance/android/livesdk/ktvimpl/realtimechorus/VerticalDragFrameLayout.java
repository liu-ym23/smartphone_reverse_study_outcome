package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/VerticalDragFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VerticalDragFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f146467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f146468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f146469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f146470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f146471e;

    public VerticalDragFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VerticalDragFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.getActionMasked();
        float r102 = r100.getY();
        if (r101 == 0) goto L18;
        if (r101 != 1) goto L9;
    L17:
        this.f146468b = false;
        getParent().requestDisallowInterceptTouchEvent(false);
    L29:
        return false;
    L9:
        if (r101 == 2) goto L14;
        if (r101 == 3) goto L17;
    L14:
        if (Math.abs(r102 - this.f146467a) <= this.f146469c) goto L29;
        this.f146468b = true;
        return true;
    L18:
        getParent().requestDisallowInterceptTouchEvent(true);
        ViewParent r103 = getParent();
    L19:
        boolean r104 = r103 instanceof cs1.a;
        if (r104 == true) goto L26;
        if (r103 == null) goto L23;
        ViewParent r105 = r103.getParent();
    L24:
        if (r105 == null) goto L26;
        r103 = r103.getParent();
        goto L19
    L23:
        r105 = null;
    L26:
        if (r104 == false) goto L28;
        ((cs1.a) r103).setDisallowInterceptOnce(true);
    L28:
        this.f146467a = r102;
        this.f146468b = false;
        goto L29
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f146468b == false) goto L16;
        if (r100 == null) goto L16;
        float r101 = r100.getY();
        if (r100.getActionMasked() != 2) goto L19;
        float r102 = (getY() + r101) - this.f146467a;
        if (r102 > this.f146470d) goto L11;
        return true;
    L11:
        if (r102 >= this.f146471e) goto L18;
        setY(r102);
        return true;
    L18:
        return true;
    L19:
        return true;
    L16:
        return super.onTouchEvent(r100);
    }

    public VerticalDragFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f146469c = 3.0f;
    }

    public /* synthetic */ VerticalDragFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
