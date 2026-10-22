package qd;

import android.graphics.LinearGradient;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f23654a = null;

    static {
        f23654a = new d();
    }

    public d() {
    }

    public final c a(CharSequence r16, TextPaint r17, float r18, TextUtils.TruncateAt r19, Function1 r20, Function1 r21) {
        q.g(r16, "text");
        q.g(r17, "paint");
        q.g(r20, "startXForWidth");
        q.g(r21, "gradientFactory");
        if (r19 != null) goto L5;
    L7:
        CharSequence r10 = r16;
    L8:
        char[] r11 = r10.toString().toCharArray();
        q.f(r11, "this as java.lang.String).toCharArray()");
        float[] r12 = new float[r11.length];
        if (r11.length != 0) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == true) goto L14;
        r17.getTextWidths(r11, 0, r11.length, r12);
    L14:
        float r14 = n.F(r12);
        q.f(r10, "displayText");
        c r15 = new c(r16, r10, r11, r12, r18, r19, r17.getTextSize(), r14, ((Number) r20.invoke(Float.valueOf(r14))).floatValue(), null);
        r15.k((LinearGradient) r21.invoke(r15));
        return r15;
    L11:
        r13 = false;
        goto L12
    L5:
        if (r18 <= 0.0f) goto L7;
        r10 = TextUtils.ellipsize(r16, r17, r18, r19);
        goto L8
    }
}
