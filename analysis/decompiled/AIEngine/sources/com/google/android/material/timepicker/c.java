package com.google.android.material.timepicker;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.stepos.aiengine.R;
import w0.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends v0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f5383a;

    public c(ClockFaceView clockFaceView) {
        this.f5383a = clockFaceView;
    }

    @Override // v0.a
    public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
        super.onInitializeAccessibilityNodeInfo(view, bVar);
        int iIntValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
        if (iIntValue > 0) {
            bVar.f13532a.setTraversalAfter(this.f5383a.A.get(iIntValue - 1));
        }
        bVar.j(b.d.a(0, 1, iIntValue, 1, view.isSelected()));
        bVar.f13532a.setClickable(true);
        bVar.b(b.a.f13535e);
    }

    @Override // v0.a
    public final boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        if (i10 != 16) {
            return super.performAccessibilityAction(view, i10, bundle);
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        ClockFaceView clockFaceView = this.f5383a;
        view.getHitRect(clockFaceView.f5349x);
        float fCenterX = clockFaceView.f5349x.centerX();
        float fCenterY = clockFaceView.f5349x.centerY();
        clockFaceView.f5348w.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
        clockFaceView.f5348w.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
        return true;
    }
}
