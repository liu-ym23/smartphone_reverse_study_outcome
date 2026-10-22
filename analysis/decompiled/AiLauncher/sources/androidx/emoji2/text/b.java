package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.c;

/* loaded from: classes.dex */
public class b implements c.e {

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<StringBuilder> f13742b = new ThreadLocal<>();

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f13743a;

    public b() {
        TextPaint textPaint = new TextPaint();
        this.f13743a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    public static StringBuilder b() {
        ThreadLocal<StringBuilder> threadLocal = f13742b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    @Override // androidx.emoji2.text.c.e
    public boolean a(CharSequence charSequence, int i10, int i11, int i12) {
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i10 < i11) {
            sbB.append(charSequence.charAt(i10));
            i10++;
        }
        return t0.f.a(this.f13743a, sbB.toString());
    }
}
