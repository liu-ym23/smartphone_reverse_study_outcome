package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.home.view.TopSheetLayout;
import com.bytedance.android.shopping.store.home.view.x;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECNestedWebViewWrapper;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "getChildWebView", "Lcom/bytedance/android/shopping/store/home/view/x;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/store/home/view/x;", "getTopSheetLayoutHelper", "()Lcom/bytedance/android/shopping/store/home/view/x;", "topSheetLayoutHelper", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECNestedWebViewWrapper extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f48720a;

    public ECNestedWebViewWrapper(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECNestedWebViewWrapper(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final View getChildWebView() {
        Lazy r100 = ECAppInfoService.f48110a;
        if (we.a.f559330a == true) goto L10;
        ViewGroup r101 = (ViewGroup) qc3.a.c(this, 0);
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.getChildAt(0);
    L10:
        return getChildAt(0);
    }

    public final x getTopSheetLayoutHelper() {
        return this.f48720a;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        View r101 = getChildWebView();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.canScrollVertically(r100) != true) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        x r101 = this.f48720a;
        r101.getClass();
        if (r100 == null) goto L10;
        if (r100.getAction() != 0) goto L10;
        TopSheetLayout r102 = x.a(r101.f184754a);
        if (r102 == null) goto L10;
        r102.setTargetChild(r101.f184754a);
    L10:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final void scrollBy(int r100, int r101) {
        View r102 = getChildWebView();
        if (r102 == null) goto L6;
        r102.scrollBy(r100, r101);
        return;
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        View r102 = getChildWebView();
        if (r102 == null) goto L6;
        r102.scrollTo(r100, r101);
        return;
    }

    public ECNestedWebViewWrapper(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f48720a = new x(this);
    }

    public /* synthetic */ ECNestedWebViewWrapper(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
