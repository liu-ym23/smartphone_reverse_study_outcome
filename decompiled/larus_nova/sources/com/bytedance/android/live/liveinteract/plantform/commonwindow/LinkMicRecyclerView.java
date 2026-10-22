package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/LinkMicRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "noTouch", "", "setNoTouch", "", LiveDegradeFpsAnimator.TRANSLATION_X, "setTranslationX", LiveDegradeFpsAnimator.TRANSLATION_Y, "setTranslationY", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class LinkMicRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f75571e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f75572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f75573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f75574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Function1<Rect, Unit>> f75575d;

    public LinkMicRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LinkMicRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f75572a == false) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r100);
    }

    public final void setNoTouch(boolean r100) {
        this.f75572a = r100;
    }

    @Override // android.view.View
    public void setTranslationX(float r100) {
        super.setTranslationX(r100);
        int r101 = (int) r100;
        r(getLeft() + r101, getTop() + ((int) getTranslationY()), getRight() + r101, getBottom() + ((int) getTranslationY()));
    }

    @Override // android.view.View
    public void setTranslationY(float r100) {
        super.setTranslationY(r100);
        int r101 = (int) r100;
        r(getLeft() + ((int) getTranslationX()), getTop() + r101, getRight() + ((int) getTranslationX()), getBottom() + r101);
    }

    public LinkMicRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f75573b = new Rect(0, 0, 0, 0);
        this.f75575d = new ArrayList();
    }

    public /* synthetic */ LinkMicRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void r(int r100, int r101, int r102, int r103) {
        Rect r104 = this.f75573b;
        Intrinsics.checkNotNullParameter(r104, "$this$equals");
        if (r104.left == r100) goto L5;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == true) goto L14;
    L17:
        Rect r106 = this.f75573b;
        int r107 = r106.left;
        int r108 = r106.top;
        int r109 = r106.right;
        int r110 = r106.bottom;
        this.f75573b = new Rect(r100, r101, r102, r103);
        this.f75574c = getChildCount();
        List<Function1<Rect, Unit>> r111 = this.f75575d;
        if (r111 == null) goto L26;
        Iterator<T> r112 = r111.iterator();
    L21:
        if (r112.hasNext() == false) goto L27;
        ((Function1) r112.next()).invoke(this.f75573b);
        goto L21
    L27:
        return;
    L26:
        return;
    L14:
        if (getChildCount() != this.f75574c) goto L16;
        return;
    L16:
        if (getChildCount() != 0) goto L17;
        return;
    L5:
        if (r104.top != r101) goto L11;
        if (r104.right != r102) goto L11;
        if (r104.bottom != r103) goto L11;
        r105 = true;
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        r(getLeft() + ((int) getTranslationX()), getTop() + ((int) getTranslationY()), getRight() + ((int) getTranslationX()), getBottom() + ((int) getTranslationY()));
    }
}
