package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import android.view.View;
import android.widget.Button;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes11.dex */
public final class f extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f159955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f159956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LivePagerTabsStrip f159957c;

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
        super.onInitializeAccessibilityNodeInfo(r100, r101);
        r101.setContentDescription(this.f159955a);
        r101.setClassName(Button.class.getName());
        ViewPager r102 = this.f159957c.f159808i;
        if (r102 != null) goto L5;
        return;
    L5:
        if (this.f159956b != r102.getCurrentItem()) goto L7;
        boolean r103 = true;
    L8:
        r101.setSelected(r103);
        return;
    L7:
        r103 = false;
        goto L8
    }

    public f(LivePagerTabsStrip r100, String r101, int r102) {
        this.f159957c = r100;
        this.f159955a = r101;
        this.f159956b = r102;
    }
}
