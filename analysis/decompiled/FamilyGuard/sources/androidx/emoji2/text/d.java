package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.e;

/* loaded from: classes.dex */
class d implements e.InterfaceC0131e {

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f10292b = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    private final TextPaint f10293a;

    d() {
        TextPaint textPaint = new TextPaint();
        this.f10293a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal<StringBuilder> threadLocal = f10292b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    @Override // androidx.emoji2.text.e.InterfaceC0131e
    public boolean a(CharSequence charSequence, int i5, int i6, int i7) {
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i5 < i6) {
            sbB.append(charSequence.charAt(i5));
            i5++;
        }
        return androidx.core.graphics.c.a(this.f10293a, sbB.toString());
    }
}
