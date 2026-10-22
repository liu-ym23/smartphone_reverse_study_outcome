package com.google.android.material.g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.b.h;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TextAppearance.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static final String TAG = "TextAppearance";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f13409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f13410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f13411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13413e;
    public final int f;
    public final boolean g;
    public final float h;
    public final float i;
    public final float j;
    public final boolean k;
    public final float l;
    private ColorStateList m;
    private float n;
    private final int o;
    private boolean p;
    private Typeface q;

    static /* synthetic */ Typeface a(d r0) {
        return r0.q;
    }

    static /* synthetic */ Typeface a(d r0, Typeface r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ boolean a(d r0, boolean r1) {
        r0.p = r1;
        return r1;
    }

    public d(Context r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        this.p = false;
        TypedArray r1 = r10.obtainStyledAttributes(r9, R.styleable.TextAppearance);
        a(r1.getDimension(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize"), 0.0f));
        a(c.a(r10, r1, ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor")));
        this.f13409a = c.a(r10, r1, ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorHint, "styleable", "TextAppearance_android_textColorHint"));
        this.f13410b = c.a(r10, r1, ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textColorLink, "styleable", "TextAppearance_android_textColorLink"));
        this.f13413e = r1.getInt(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_textStyle, "styleable", "TextAppearance_android_textStyle"), 0);
        this.f = r1.getInt(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_typeface, "styleable", "TextAppearance_android_typeface"), 1);
        int r2 = c.a(r1, ZeusTransformUtils.mapRes(R.styleable.TextAppearance_fontFamily, "styleable", "TextAppearance_fontFamily"), ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_fontFamily, "styleable", "TextAppearance_android_fontFamily"));
        this.o = r1.getResourceId(r2, 0);
        this.f13412d = r1.getString(r2);
        this.g = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps"), false);
        this.f13411c = c.a(r10, r1, ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_shadowColor, "styleable", "TextAppearance_android_shadowColor"));
        this.h = r1.getFloat(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_shadowDx, "styleable", "TextAppearance_android_shadowDx"), 0.0f);
        this.i = r1.getFloat(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_shadowDy, "styleable", "TextAppearance_android_shadowDy"), 0.0f);
        this.j = r1.getFloat(ZeusTransformUtils.mapRes(R.styleable.TextAppearance_android_shadowRadius, "styleable", "TextAppearance_android_shadowRadius"), 0.0f);
        r1.recycle();
        if (Build.VERSION.SDK_INT < 21) goto L5;
        TypedArray r11 = r10.obtainStyledAttributes(r9, R.styleable.MaterialTextAppearance);
        this.k = r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.MaterialTextAppearance_android_letterSpacing, "styleable", "MaterialTextAppearance_android_letterSpacing"));
        this.l = r11.getFloat(ZeusTransformUtils.mapRes(R.styleable.MaterialTextAppearance_android_letterSpacing, "styleable", "MaterialTextAppearance_android_letterSpacing"), 0.0f);
        r11.recycle();
        return;
    L5:
        this.k = false;
        this.l = 0.0f;
    }

    public Typeface a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (this.p == false) goto L7;
        return this.q;
    L7:
        if (r4.isRestricted() == false) goto L17;
    L14:
        d();
        this.p = true;
        return this.q;
    L17:
        Typeface r5 = h.a(r4, this.o);     // Catch: Exception -> L12 Throwable -> L16
        this.q = r5;     // Catch: Exception -> L12 Throwable -> L16
        if (r5 == null) goto L14;
        this.q = Typeface.create(r5, this.f13413e);     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        a(TAG, "Error loading font " + this.f13412d, e);
        goto L14
    }

    public void a(Context r5, final f r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (b(r7) == false) goto L5;
        a(r7);
    L6:
        int r0 = this.o;
        if (r0 != 0) goto L10;
        this.p = true;
    L10:
        if (this.p == false) goto L19;
        r6.a(this.q, true);
        return;
    L19:
        h.a(r7, r0, new AnonymousClass1(this, r6), null);     // Catch: Exception -> L15 Resources.NotFoundException -> L17
    L22:
        return;
    L17:
        this.p = true;
        r6.a(1);
        return;
    L15:
        e = move-exception;
        a(TAG, "Error loading font " + this.f13412d, e);
        this.p = true;
        r6.a(-3);
        return;
    L5:
        d();
        goto L6
    }

    public void a(Context r3, final TextPaint r4, final f r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        a(r6, r4, a());
        a(r6, new AnonymousClass2(this, r6, r4, r5));
    }

    public Typeface a() {
        d();
        return this.q;
    }

    private void d() {
        if (this.q != null) goto L8;
        String r0 = this.f13412d;
        if (r0 == null) goto L8;
        this.q = Typeface.create(r0, this.f13413e);
    L8:
        if (this.q != null) goto L21;
        int r1 = this.f;
        if (r1 != 1) goto L12;
        this.q = Typeface.SANS_SERIF;
    L19:
        this.q = Typeface.create(this.q, this.f13413e);
        return;
    L12:
        if (r1 != 2) goto L14;
        this.q = Typeface.SERIF;
        goto L19
    L14:
        if (r1 == 3) goto L16;
        this.q = Typeface.DEFAULT;
        goto L19
    L16:
        this.q = Typeface.MONOSPACE;
        goto L19
    }

    public void b(Context r4, TextPaint r5, f r6) {
        c((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), r5, r6);
        ColorStateList r7 = this.m;
        if (r7 == null) goto L5;
        int r8 = r7.getColorForState(r5.drawableState, this.m.getDefaultColor());
    L6:
        r5.setColor(r8);
        float r9 = this.j;
        float r10 = this.h;
        float r0 = this.i;
        ColorStateList r1 = this.f13411c;
        if (r1 == null) goto L9;
        int r3 = r1.getColorForState(r5.drawableState, this.f13411c.getDefaultColor());
    L10:
        r5.setShadowLayer(r9, r10, r0, r3);
        return;
    L9:
        r3 = 0;
        goto L10
    L5:
        r8 = -16777216;
        goto L6
    }

    public void c(Context r3, TextPaint r4, f r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (b(r6) == false) goto L5;
        a(r6, r4, a(r6));
        return;
    L5:
        a(r6, r4, r5);
    }

    public void a(Context r3, TextPaint r4, Typeface r5) {
        Typeface r6 = g.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r5);
        if (r6 == null) goto L5;
        r5 = r6;
    L5:
        r4.setTypeface(r5);
        int r7 = this.f13413e & (~r5.getStyle());
        if ((r7 & 1) == 0) goto L8;
        boolean r8 = true;
    L9:
        r4.setFakeBoldText(r8);
        if ((r7 & 2) == 0) goto L12;
        float r9 = -0.25f;
    L13:
        r4.setTextSkewX(r9);
        r4.setTextSize(this.n);
        if (Build.VERSION.SDK_INT >= 21) goto L16;
        return;
    L16:
        if (this.k == false) goto L20;
        r4.setLetterSpacing(this.l);
        return;
    L20:
        return;
    L12:
        r9 = 0.0f;
        goto L13
    L8:
        r8 = false;
        goto L9
    }

    public ColorStateList b() {
        return this.m;
    }

    public void a(ColorStateList r1) {
        this.m = r1;
    }

    public float c() {
        return this.n;
    }

    public void a(float r1) {
        this.n = r1;
    }

    private boolean b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (e.a() == false) goto L5;
        return true;
    L5:
        int r2 = this.o;
        if (r2 == 0) goto L8;
        Typeface r5 = h.b(r4, r2);
    L9:
        if (r5 != null) goto L13;
        return false;
    L13:
        return true;
    L8:
        r5 = null;
        goto L9
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }
}
