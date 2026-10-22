package com.bytedance.android.shopping.anchorv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u0010R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/BottomSheetViewPager;", "Landroidx/viewpager/widget/ViewPager;", "", "b", "Z", "getMDisableScroll", "()Z", "setMDisableScroll", "(Z)V", "mDisableScroll", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomSheetViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f165498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f165499b;

    public final boolean getMDisableScroll() {
        return this.f165499b;
    }

    public BottomSheetViewPager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final View getChildAt(int r100) {
        StackTraceElement r101 = (StackTraceElement) ArraysKt.getOrNull(new Throwable().getStackTrace(), 1);
        if (r101 != null) goto L5;
        Boolean r102 = null;
    L13:
        if ((!Intrinsics.areEqual(r102, Boolean.TRUE)) == false) goto L17;
        return super.getChildAt(r100);
    L17:
        return super.getChildAt(this.f165498a);
    L5:
        if (Intrinsics.areEqual(r101.getClassName(), "com.google.android.material.bottomsheet.BottomSheetBehavior") == true) goto L7;
    L9:
        boolean r103 = false;
    L10:
        r102 = Boolean.valueOf(r103);
        goto L13
    L7:
        if (Intrinsics.areEqual(r101.getMethodName(), "findScrollingChild") == false) goto L9;
        r103 = true;
        goto L10
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f165499b == true) goto L11;
        return super.onInterceptTouchEvent(r100);
    L12:
        return false;
    L11:
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f165499b == true) goto L11;
        return super.onTouchEvent(r100);
    L12:
        return false;
    L11:
        return false;
    }

    public final void setMDisableScroll(boolean r100) {
        this.f165499b = r100;
    }

    public BottomSheetViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        addOnPageChangeListener(new AnonymousClass1(this));
        this.f165499b = true;
    }
}
