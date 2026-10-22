package com.google.android.material.timepicker;

import K.C0069b;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class c extends C0069b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f11163a;

    public c(ClockFaceView clockFaceView) {
        this.f11163a = clockFaceView;
    }

    @Override // K.C0069b
    public final void onInitializeAccessibilityNodeInfo(View view, L.g gVar) {
        super.onInitializeAccessibilityNodeInfo(view, gVar);
        int iIntValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f1142a;
        if (iIntValue > 0) {
            accessibilityNodeInfo.setTraversalAfter((View) this.f11163a.f11140z.get(iIntValue - 1));
        }
        accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, iIntValue, 1, false, view.isSelected()));
        accessibilityNodeInfo.setClickable(true);
        gVar.b(L.b.f1129e);
    }

    @Override // K.C0069b
    public final boolean performAccessibilityAction(View view, int i4, Bundle bundle) {
        if (i4 != 16) {
            return super.performAccessibilityAction(view, i4, bundle);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        ClockFaceView clockFaceView = this.f11163a;
        view.getHitRect(clockFaceView.f11137w);
        float fCenterX = clockFaceView.f11137w.centerX();
        float fCenterY = clockFaceView.f11137w.centerY();
        clockFaceView.f11136v.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
        clockFaceView.f11136v.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
        return true;
    }
}
