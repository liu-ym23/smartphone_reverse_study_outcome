package X;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public final class D implements Spannable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2042a = false;

    /* renamed from: b, reason: collision with root package name */
    public Spannable f2043b;

    public D(Spannable spannable) {
        this.f2043b = spannable;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i4) {
        return this.f2043b.charAt(i4);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f2043b.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f2043b.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f2043b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f2043b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f2043b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i4, int i5, Class cls) {
        return this.f2043b.getSpans(i4, i5, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f2043b.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i4, int i5, Class cls) {
        return this.f2043b.nextSpanTransition(i4, i5, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        Spannable spannable = this.f2043b;
        if (!this.f2042a && (spannable instanceof PrecomputedText)) {
            this.f2043b = new SpannableString(spannable);
        }
        this.f2042a = true;
        this.f2043b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i4, int i5, int i6) {
        Spannable spannable = this.f2043b;
        if (!this.f2042a && (spannable instanceof PrecomputedText)) {
            this.f2043b = new SpannableString(spannable);
        }
        this.f2042a = true;
        this.f2043b.setSpan(obj, i4, i5, i6);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i4, int i5) {
        return this.f2043b.subSequence(i4, i5);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f2043b.toString();
    }
}
