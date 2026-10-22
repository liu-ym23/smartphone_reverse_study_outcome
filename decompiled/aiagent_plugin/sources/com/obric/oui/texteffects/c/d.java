package com.obric.oui.texteffects.c;

import android.graphics.LinearGradient;
import android.text.TextPaint;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.o;

/* JADX INFO: compiled from: TextLayoutCache.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f36450a = null;

    static {
        f36450a = new d();
    }

    private d() {
    }

    public final c a(CharSequence r16, TextPaint r17, float r18, TextUtils.TruncateAt r19, d.h.a.b<? super Float, Float> r20, d.h.a.b<? super c, ? extends LinearGradient> r21) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r16, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r1, "text");
        o.e(r17, "paint");
        o.e(r2, "startXForWidth");
        o.e(r12, "gradientFactory");
        if (r19 != null) goto L5;
    L7:
        CharSequence r3 = r1;
    L8:
        char[] r4 = r3.toString().toCharArray();
        o.c(r4, "this as java.lang.String).toCharArray()");
        float[] r7 = new float[r4.length];
        if (r4.length != 0) goto L11;
        boolean r8 = true;
    L13:
        if ((!r8) == false) goto L15;
        r17.getTextWidths(r4, 0, r4.length, r7);
    L15:
        float r9 = i.f(r7);
        o.c(r3, "displayText");
        c r13 = new c(r1, r3, r4, r7, r18, r19, r17.getTextSize(), r9, ((Number) ZeusTransformUtils.preCheckCast(r2.invoke(Float.valueOf(r9)), Number.class, "com.obric.aiagent.plugin")).floatValue(), null);
        r13.a((LinearGradient) ZeusTransformUtils.preCheckCast(r12.invoke(r13), LinearGradient.class, "com.obric.aiagent.plugin"));
        return r13;
    L11:
        r8 = false;
        goto L13
    L5:
        if (r18 <= 0.0f) goto L7;
        r3 = TextUtils.ellipsize(r1, r17, r18, r19);
        goto L8
    }
}
