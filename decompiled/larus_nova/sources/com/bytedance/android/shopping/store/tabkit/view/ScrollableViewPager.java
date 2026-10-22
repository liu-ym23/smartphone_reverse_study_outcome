package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/ScrollableViewPager;", "Landroidx/viewpager/widget/ViewPager;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getScrollable", "()Z", "setScrollable", "(Z)V", "scrollable", "b", "isSlidingByDrag", "setSlidingByDrag", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ScrollableViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f186884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f186885b;

    public final boolean getScrollable() {
        return this.f186884a;
    }

    public ScrollableViewPager(Context r100) {
        this(r100, null);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f186884a == false) goto L12;
        if (super.onInterceptTouchEvent(r100) == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    L4:
        e = move-exception;
        EnsureManager.ensureNotNull(e);
        return false;
    }

    public final void setScrollable(boolean r100) {
        this.f186884a = r100;
    }

    public final void setSlidingByDrag(boolean r100) {
        this.f186885b = r100;
    }

    public ScrollableViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f186884a = true;
        addOnPageChangeListener(new AnonymousClass1(this));
    }
}
