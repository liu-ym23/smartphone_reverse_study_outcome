package com.bytedance.android.gamecp.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100B\u001d\b\u0016\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\b\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b/\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\r8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR$\u0010(\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00028B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR\u0013\u0010,\u001a\u0004\u0018\u00010)8F¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u00064"}, d2 = {"Lcom/bytedance/android/gamecp/business/view/CustomViewAnimator;", "Landroid/widget/FrameLayout;", "", "getBaseline", "", "getAccessibilityClassName", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getMWhichChild", "()I", "setMWhichChild", "(I)V", "mWhichChild", "", "b", "Z", "getMFirstTime", "()Z", "setMFirstTime", "(Z)V", "mFirstTime", "c", "getAnimateFirstView", "setAnimateFirstView", "animateFirstView", "Landroid/view/animation/Animation;", "d", "Landroid/view/animation/Animation;", "getInAnimation", "()Landroid/view/animation/Animation;", "setInAnimation", "(Landroid/view/animation/Animation;)V", "inAnimation", "e", "getOutAnimation", "setOutAnimation", "outAnimation", "whichChild", "getDisplayedChild", "setDisplayedChild", "displayedChild", "Landroid/view/View;", "getCurrentView", "()Landroid/view/View;", "currentView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CustomViewAnimator extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f56455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f56456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f56457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Animation f56458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Animation f56459e;

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "com.bytedance.android.gamecp.business.view.CustomViewAnimator";
    }

    public final View getCurrentView() {
        return getChildAt(this.f56455a);
    }

    @Override // android.view.View
    public int getBaseline() {
        View r100 = getCurrentView();     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        int r101 = r100.getBaseline();     // Catch: Throwable -> L7
    L9:
        return r101;
    L5:
        r101 = super.getBaseline();     // Catch: Throwable -> L7
    L12:
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        this.f56455a = 0;
        this.f56456b = true;
    }

    private final int getDisplayedChild() {
        return this.f56455a;
    }

    public final boolean getAnimateFirstView() {
        return this.f56457c;
    }

    public final Animation getInAnimation() {
        return this.f56458d;
    }

    public final boolean getMFirstTime() {
        return this.f56456b;
    }

    public final int getMWhichChild() {
        return this.f56455a;
    }

    public final Animation getOutAnimation() {
        return this.f56459e;
    }

    public CustomViewAnimator(Context r100) {
        Intrinsics.checkNotNull(r100);
        super(r100);
        this.f56456b = true;
        this.f56457c = true;
    }

    private final void setDisplayedChild(int r100) {
        this.f56455a = r100;
        boolean r101 = true;
        if (r100 < getChildCount()) goto L5;
        this.f56455a = 0;
    L8:
        if (getFocusedChild() == null) goto L10;
        boolean r102 = true;
    L11:
        int r103 = this.f56455a;
        if (this.f56456b == true) goto L14;
    L17:
        int r104 = getChildCount();
        int r105 = 0;
    L18:
        if (r105 >= r104) goto L37;
        View r106 = getChildAt(r105);
        if (r105 != r103) goto L26;
        if (r101 == false) goto L25;
        Animation r107 = this.f56458d;
        if (r107 == null) goto L25;
        r106.startAnimation(r107);
    L25:
        r106.setVisibility(0);
        this.f56456b = false;
    L36:
        r105 = r105 + 1;
        goto L18
    L26:
        if (r101 == false) goto L33;
        if (this.f56459e == null) goto L33;
        if (r106.getVisibility() != 0) goto L33;
        r106.startAnimation(this.f56459e);
    L35:
        r106.setVisibility(8);
    L33:
        if (r106.getAnimation() != this.f56458d) goto L35;
        r106.clearAnimation();
        goto L35
    L37:
        if (r102 == false) goto L43;
        requestFocus(2);
        return;
    L43:
        return;
    L14:
        if (this.f56457c == true) goto L17;
        r101 = false;
        goto L17
    L10:
        r102 = false;
        goto L11
    L5:
        if (r100 >= 0) goto L8;
        this.f56455a = getChildCount() - 1;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int r101 = indexOfChild(r100);
        if (r101 < 0) goto L6;
        removeViewAt(r101);
        return;
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int r100) {
        super.removeViewAt(r100);
        int r101 = getChildCount();
        if (r101 != 0) goto L5;
        this.f56455a = 0;
        this.f56456b = true;
        return;
    L5:
        int r102 = this.f56455a;
        if (r102 < r101) goto L8;
        setDisplayedChild(r101 - 1);
        return;
    L8:
        if (r102 != r100) goto L13;
        setDisplayedChild(r102);
        return;
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        removeView(r100);
    }

    public final void setAnimateFirstView(boolean r100) {
        this.f56457c = r100;
    }

    public final void setInAnimation(Animation r100) {
        this.f56458d = r100;
    }

    public final void setMFirstTime(boolean r100) {
        this.f56456b = r100;
    }

    public final void setMWhichChild(int r100) {
        this.f56455a = r100;
    }

    public final void setOutAnimation(Animation r100) {
        this.f56459e = r100;
    }

    public CustomViewAnimator(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNull(r100);
        super(r100, r101);
        this.f56456b = true;
        this.f56457c = true;
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int r100, int r101) {
        super.removeViews(r100, r101);
        if (getChildCount() != 0) goto L5;
        this.f56455a = 0;
        this.f56456b = true;
        return;
    L5:
        int r102 = this.f56455a;
        if (r102 >= r100) goto L8;
        return;
    L8:
        if (r102 >= (r100 + r101)) goto L13;
        setDisplayedChild(r102);
        return;
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int r100, int r101) {
        removeViews(r100, r101);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "params");
        super.addView(r100, r101, r102);
        if (getChildCount() != 1) goto L5;
        r100.setVisibility(0);
    L6:
        if (r101 < 0) goto L11;
        int r103 = this.f56455a;
        if (r103 < r101) goto L12;
        setDisplayedChild(r103 + 1);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r100.setVisibility(8);
        goto L6
    }
}
