package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
/* JADX INFO: loaded from: classes2.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f13466a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f13467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Constructor<StaticLayout> f13468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Object f13469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f13470e;
    private final TextPaint f;
    private final int g;
    private int h;
    private int i;
    private Layout.Alignment j;
    private int k;
    private float l;
    private float m;
    private int n;
    private boolean o;
    private boolean p;
    private TextUtils.TruncateAt q;

    /* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
    static class a extends Exception {
        a(Throwable r3) {
            super("Error thrown initializing StaticLayout " + r3.getMessage(), r3);
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r0 = 1;
    L6:
        f13466a = r0;
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private i(CharSequence r3, TextPaint r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.f13470e = r6;
        this.f = r4;
        this.g = r5;
        this.h = 0;
        this.i = r6.length();
        this.j = Layout.Alignment.ALIGN_NORMAL;
        this.k = Integer.MAX_VALUE;
        this.l = 0.0f;
        this.m = 1.0f;
        this.n = f13466a;
        this.o = true;
        this.q = null;
    }

    public static i a(CharSequence r2, TextPaint r3, int r4) {
        return new i((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    public i a(Layout.Alignment r1) {
        this.j = r1;
        return this;
    }

    public i a(boolean r1) {
        this.o = r1;
        return this;
    }

    public i a(int r1) {
        this.k = r1;
        return this;
    }

    public i a(float r1, float r2) {
        this.l = r1;
        this.m = r2;
        return this;
    }

    public i b(int r1) {
        this.n = r1;
        return this;
    }

    public i a(TextUtils.TruncateAt r1) {
        this.q = r1;
        return this;
    }

    public StaticLayout a() {
        if (this.f13470e != null) goto L5;
        this.f13470e = "";
    L5:
        int r1 = Math.max(0, this.g);
        CharSequence r3 = this.f13470e;
        if (this.k != 1) goto L8;
        r3 = TextUtils.ellipsize(r3, this.f, r1, this.q);
    L8:
        this.i = Math.min(r3.length(), this.i);
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        b();
        return (StaticLayout) ZeusTransformUtils.preCheckCast(((Constructor) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(f13468c), Constructor.class, "com.obric.aiagent.plugin")).newInstance(new Object[]{r3, Integer.valueOf(this.h), Integer.valueOf(this.i), this.f, Integer.valueOf(r1), this.j, androidx.core.util.g.a(f13469d), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.o), null, Integer.valueOf(r1), Integer.valueOf(this.k)}), StaticLayout.class, "com.obric.aiagent.plugin");
    L35:
        e = move-exception;
        throw new a(e);
    L11:
        if (this.p == true) goto L13;
    L15:
        StaticLayout.Builder r0 = StaticLayout.Builder.obtain(r3, this.h, this.i, this.f, r1);
        r0.setAlignment(this.j);
        r0.setIncludePad(this.o);
        if (this.p == false) goto L18;
        TextDirectionHeuristic r2 = TextDirectionHeuristics.RTL;
    L19:
        r0.setTextDirection(r2);
        TextUtils.TruncateAt r4 = this.q;
        if (r4 == null) goto L22;
        r0.setEllipsize(r4);
    L22:
        r0.setMaxLines(this.k);
        float r5 = this.l;
        if (r5 == 0.0f) goto L25;
    L26:
        r0.setLineSpacing(r5, this.m);
    L28:
        if (this.k <= 1) goto L31;
        r0.setHyphenationFrequency(this.n);
    L31:
        return r0.build();
    L25:
        if (this.m == 1.0f) goto L28;
    L18:
        r2 = TextDirectionHeuristics.LTR;
        goto L19
    L13:
        if (this.k != 1) goto L15;
        this.j = Layout.Alignment.ALIGN_OPPOSITE;
        goto L15
    }

    private void b() {
        if (f13467b == false) goto L28;
        return;
    L28:
    L25:
        e = move-exception;
        throw new a(e);
    L6:
        if (this.p == true) goto L8;
    L10:
        boolean r0 = false;
    L12:
        if (Build.VERSION.SDK_INT < 18) goto L18;
        Class<?> r5 = TextDirectionHeuristic.class;
        if (r0 == false) goto L16;
        TextDirectionHeuristic r1 = TextDirectionHeuristics.RTL;     // Catch: Exception -> L25
    L17:
        f13469d = r1;     // Catch: Exception -> L25
    L23:
        Constructor<StaticLayout> r6 = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, r5, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE});     // Catch: Exception -> L25
        f13468c = r6;     // Catch: Exception -> L25
        r6.setAccessible(true);     // Catch: Exception -> L25
        f13467b = true;     // Catch: Exception -> L25
        return;
    L16:
        r1 = TextDirectionHeuristics.LTR;     // Catch: Exception -> L25
        goto L17
    L18:
        ClassLoader r2 = i.class.getClassLoader();     // Catch: Exception -> L25
        if (this.p == false) goto L21;
        String r7 = "RTL";
    L22:
        Class<?> r3 = r2.loadClass("android.text.TextDirectionHeuristic");     // Catch: Exception -> L25
        Class<?> r4 = r2.loadClass("android.text.TextDirectionHeuristics");     // Catch: Exception -> L25
        f13469d = r4.getField(r7).get(r4);     // Catch: Exception -> L25
        r5 = r3;
        goto L23
    L21:
        r7 = "LTR";
        goto L22
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r0 = true;
        goto L12
    }

    public i b(boolean r1) {
        this.p = r1;
        return this;
    }
}
