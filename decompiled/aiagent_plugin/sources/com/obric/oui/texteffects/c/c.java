package com.obric.oui.texteffects.c;

import android.graphics.LinearGradient;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: TextLayoutCache.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f36445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f36446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char[] f36447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f36448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f36449e;
    private final TextUtils.TruncateAt f;
    private final float g;
    private float h;
    private float i;
    private LinearGradient j;

    public String toString() {
        return "TextLayoutCache(text=" + this.f36445a + ", displayText=" + this.f36446b + ", chars=" + Arrays.toString(this.f36447c) + ", widths=" + Arrays.toString(this.f36448d) + ", contentWidth=" + this.f36449e + ", ellipsize=" + this.f + ", textSizePx=" + this.g + ", baseTotalWidth=" + this.h + ", baseStartX=" + this.i + ", gradientShader=" + this.j + ')';
    }

    public c(CharSequence r3, CharSequence r4, char[] r5, float[] r6, float r7, TextUtils.TruncateAt r8, float r9, float r10, float r11, LinearGradient r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r13, "text");
        o.e(r14, "displayText");
        o.e(r5, "chars");
        o.e(r6, "widths");
        this.f36445a = r13;
        this.f36446b = r14;
        this.f36447c = r5;
        this.f36448d = r6;
        this.f36449e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
    }

    public final CharSequence a() {
        return this.f36445a;
    }

    public final char[] b() {
        return this.f36447c;
    }

    public final float c() {
        return this.f36449e;
    }

    public final TextUtils.TruncateAt d() {
        return this.f;
    }

    public final float e() {
        return this.g;
    }

    public final void a(float r1) {
        this.h = r1;
    }

    public final float f() {
        return this.h;
    }

    public final void b(float r1) {
        this.i = r1;
    }

    public final float g() {
        return this.i;
    }

    public final void a(LinearGradient r1) {
        this.j = r1;
    }

    public final LinearGradient h() {
        return this.j;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L9;
        return false;
    L9:
        if (o.a(this.f36445a, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f36445a) == false) goto L42;
        if (o.a(this.f36446b, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f36446b) == false) goto L42;
        if (Arrays.equals(this.f36447c, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f36447c) == false) goto L42;
        if (Arrays.equals(this.f36448d, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f36448d) == false) goto L42;
        if (this.f36449e != ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f36449e) goto L19;
        boolean r2 = true;
    L20:
        if (r2 == false) goto L42;
        if (this.f != ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).f) goto L42;
        if (this.g != ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).g) goto L26;
        boolean r3 = true;
    L27:
        if (r3 == false) goto L42;
        if (this.h != ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).h) goto L31;
        boolean r4 = true;
    L32:
        if (r4 == false) goto L42;
        if (this.i != ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).i) goto L36;
        boolean r5 = true;
    L37:
        if (r5 == false) goto L42;
        if (o.a(this.j, ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).j) == false) goto L42;
        return true;
    L36:
        r5 = false;
        goto L37
    L31:
        r4 = false;
        goto L32
    L26:
        r3 = false;
        goto L27
    L19:
        r2 = false;
    L42:
        return false;
    }

    public int hashCode() {
        int r0 = ((((((((this.f36445a.hashCode() * 31) + this.f36446b.hashCode()) * 31) + Arrays.hashCode(this.f36447c)) * 31) + Arrays.hashCode(this.f36448d)) * 31) + Float.hashCode(this.f36449e)) * 31;
        TextUtils.TruncateAt r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((r0 + r3) * 31) + Float.hashCode(this.g)) * 31) + Float.hashCode(this.h)) * 31) + Float.hashCode(this.i)) * 31;
        LinearGradient r5 = this.j;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }
}
