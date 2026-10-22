package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.l;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BaseProgressIndicatorSpec.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f13508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13510e;
    public int f;

    abstract void c();

    public b(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        this.f13508c = new int[0];
        int r0 = ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_progress_track_thickness, "dimen", "mtrl_progress_track_thickness"));
        TypedArray r14 = l.a(r13, r3, R.styleable.BaseProgressIndicator, r11, r12, new int[0]);
        this.f13506a = com.google.android.material.g.c.a(r13, r14, ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_trackThickness, "styleable", "BaseProgressIndicator_trackThickness"), r0);
        this.f13507b = Math.min(com.google.android.material.g.c.a(r13, r14, ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_trackCornerRadius, "styleable", "BaseProgressIndicator_trackCornerRadius"), 0), this.f13506a / 2);
        this.f13510e = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_showAnimationBehavior, "styleable", "BaseProgressIndicator_showAnimationBehavior"), 0);
        this.f = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_hideAnimationBehavior, "styleable", "BaseProgressIndicator_hideAnimationBehavior"), 0);
        a(r13, r14);
        b(r13, r14);
        r14.recycle();
    }

    private void a(Context r8, TypedArray r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_indicatorColor, "styleable", "BaseProgressIndicator_indicatorColor")) == true) goto L7;
        this.f13508c = new int[]{com.google.android.material.color.b.a(r10, ZeusTransformUtils.mapRes(R.attr.colorPrimary, "attr", "colorPrimary"), -1)};
        return;
    L7:
        if (r9.peekValue(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_indicatorColor, "styleable", "BaseProgressIndicator_indicatorColor")).type == 1) goto L10;
        this.f13508c = new int[]{r9.getColor(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_indicatorColor, "styleable", "BaseProgressIndicator_indicatorColor"), -1)};
        return;
    L10:
        int[] r11 = ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getIntArray(r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_indicatorColor, "styleable", "BaseProgressIndicator_indicatorColor"), -1));
        this.f13508c = r11;
        if (r11.length == 0) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
    }

    private void b(Context r4, TypedArray r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_trackColor, "styleable", "BaseProgressIndicator_trackColor")) == false) goto L6;
        this.f13509d = r5.getColor(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_trackColor, "styleable", "BaseProgressIndicator_trackColor"), -1);
        return;
    L6:
        this.f13509d = this.f13508c[0];
        TypedArray r7 = r6.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float r8 = r7.getFloat(0, 0.2f);
        r7.recycle();
        this.f13509d = com.google.android.material.color.b.b(this.f13509d, (int) (r8 * 255.0f));
    }

    public boolean a() {
        if (this.f13510e == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean b() {
        if (this.f == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
