package com.google.android.material.button;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* loaded from: classes3.dex */
public final class f extends AccessibilityDelegateCompat {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialButtonToggleGroup f2376a;

    public f(MaterialButtonToggleGroup materialButtonToggleGroup) {
        this.f2376a = materialButtonToggleGroup;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int i;
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        int i6 = MaterialButtonToggleGroup.f2364q;
        if (view instanceof MaterialButton) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                MaterialButtonToggleGroup materialButtonToggleGroup = this.f2376a;
                if (i10 >= materialButtonToggleGroup.getChildCount()) {
                    break;
                }
                if (materialButtonToggleGroup.getChildAt(i10) == view) {
                    i = i11;
                    break;
                }
                if ((materialButtonToggleGroup.getChildAt(i10) instanceof MaterialButton) && materialButtonToggleGroup.getChildAt(i10).getVisibility() != 8) {
                    i11++;
                }
                i10++;
            }
        } else {
            i = -1;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, i, 1, false, ((MaterialButton) view).l));
    }
}
