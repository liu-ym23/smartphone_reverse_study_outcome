package com.obric.oui.popover.v2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OPopoverLandscapeWrapper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OPopoverLandscapeWrapper extends ViewGroup {
    private float orientationAngle;
    private final FrameLayout rotationLayer;

    public OPopoverLandscapeWrapper(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        super(r4);
        FrameLayout r0 = new FrameLayout(r4);
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        this.rotationLayer = r0;
        setClipChildren(false);
        setClipToPadding(false);
        super.addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), -1, new ViewGroup.LayoutParams(-2, -2));
    }

    public final float getOrientationAngle() {
        return this.orientationAngle;
    }

    public final void setOrientationAngle(float r2) {
        this.orientationAngle = r2;
        this.rotationLayer.setRotation(r2);
        requestLayout();
    }

    public final FrameLayout getRotationLayer() {
        return this.rotationLayer;
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        o.e(r2, "child");
        this.rotationLayer.addView(r2, r3, r4);
    }

    @Override // android.view.View
    public void onMeasure(int r4, int r5) {
        if ((this.orientationAngle % 180) != 0.0f) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
        measureChild((View) ZeusTransformUtils.preCheckCast(this.rotationLayer, View.class, "com.obric.aiagent.plugin"), r5, r4);
        setMeasuredDimension(this.rotationLayer.getMeasuredHeight(), this.rotationLayer.getMeasuredWidth());
        return;
    L9:
        measureChild((View) ZeusTransformUtils.preCheckCast(this.rotationLayer, View.class, "com.obric.aiagent.plugin"), r4, r5);
        setMeasuredDimension(this.rotationLayer.getMeasuredWidth(), this.rotationLayer.getMeasuredHeight());
        return;
    L5:
        r0 = false;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = r6 - r4;
        int r9 = this.rotationLayer.getMeasuredWidth();
        int r10 = this.rotationLayer.getMeasuredHeight();
        int r11 = (r8 - r9) / 2;
        int r12 = ((r7 - r5) - r10) / 2;
        this.rotationLayer.layout(r11, r12, r11 + r9, r12 + r10);
        this.rotationLayer.setPivotX(r9 / 2.0f);
        this.rotationLayer.setPivotY(r10 / 2.0f);
    }
}
