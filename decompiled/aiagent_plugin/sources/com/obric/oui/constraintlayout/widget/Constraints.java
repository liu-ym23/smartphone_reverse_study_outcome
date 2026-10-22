package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class Constraints extends ViewGroup {
    public static final String TAG = "Constraints";
    c mConstraintSet;

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float alpha;
        public boolean applyElevation;
        public float elevation;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.alpha = 1.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
        }

        public LayoutParams(Context r6, AttributeSet r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
            super(r8, r9);
            this.alpha = 1.0f;
            int r1 = 0;
            this.applyElevation = false;
            this.elevation = 0.0f;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = 0.0f;
            this.transformPivotY = 0.0f;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.ConstraintSet);
            int r11 = r10.getIndexCount();
        L3:
            if (r1 >= r11) goto L41;
            int r0 = r10.getIndex(r1);
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_alpha, "styleable", "ConstraintSet_android_alpha")) goto L8;
            this.alpha = r10.getFloat(r0, this.alpha);
        L40:
            r1 = r1 + 1;
            goto L3
        L8:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_elevation, "styleable", "ConstraintSet_android_elevation")) goto L11;
            this.elevation = r10.getFloat(r0, this.elevation);
            this.applyElevation = true;
            goto L40
        L11:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_rotationX, "styleable", "ConstraintSet_android_rotationX")) goto L14;
            this.rotationX = r10.getFloat(r0, this.rotationX);
            goto L40
        L14:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_rotationY, "styleable", "ConstraintSet_android_rotationY")) goto L17;
            this.rotationY = r10.getFloat(r0, this.rotationY);
            goto L40
        L17:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_rotation, "styleable", "ConstraintSet_android_rotation")) goto L20;
            this.rotation = r10.getFloat(r0, this.rotation);
            goto L40
        L20:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_scaleX, "styleable", "ConstraintSet_android_scaleX")) goto L23;
            this.scaleX = r10.getFloat(r0, this.scaleX);
            goto L40
        L23:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_scaleY, "styleable", "ConstraintSet_android_scaleY")) goto L26;
            this.scaleY = r10.getFloat(r0, this.scaleY);
            goto L40
        L26:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_transformPivotX, "styleable", "ConstraintSet_android_transformPivotX")) goto L29;
            this.transformPivotX = r10.getFloat(r0, this.transformPivotX);
            goto L40
        L29:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_transformPivotY, "styleable", "ConstraintSet_android_transformPivotY")) goto L32;
            this.transformPivotY = r10.getFloat(r0, this.transformPivotY);
            goto L40
        L32:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_translationX, "styleable", "ConstraintSet_android_translationX")) goto L35;
            this.translationX = r10.getFloat(r0, this.translationX);
            goto L40
        L35:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_translationY, "styleable", "ConstraintSet_android_translationY")) goto L38;
            this.translationY = r10.getFloat(r0, this.translationY);
            goto L40
        L38:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_translationZ, "styleable", "ConstraintSet_android_translationZ")) goto L40;
            this.translationZ = r10.getFloat(r0, this.translationZ);
            goto L40
        L41:
            r10.recycle();
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.v(r0, r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public Constraints(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
        super.setVisibility(8);
    }

    public Constraints(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        init();
        super.setVisibility(8);
    }

    public Constraints(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        init();
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    private void init() {
        INVOKESTATIC_com_obric_oui_constraintlayout_widget_Constraints_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v("Constraints", " ################# init");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new ConstraintLayout.LayoutParams(r1);
    }

    public c getConstraintSet() {
        if (this.mConstraintSet != null) goto L5;
        this.mConstraintSet = new c();
    L5:
        this.mConstraintSet.a(this);
        return this.mConstraintSet;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_constraintlayout_widget_Constraints_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
