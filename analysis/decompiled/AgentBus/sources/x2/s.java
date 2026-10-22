package x2;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public final class s implements Spannable {

    /* renamed from: f, reason: collision with root package name */
    public boolean f11154f = false;

    /* renamed from: g, reason: collision with root package name */
    public Spannable f11155g;

    public s(Spannable spannable) {
        this.f11155g = spannable;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i2) {
        return this.f11155g.charAt(i2);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f11155g.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f11155g.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f11155g.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f11155g.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f11155g.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i2, int i10, Class cls) {
        return this.f11155g.getSpans(i2, i10, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f11155g.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i2, int i10, Class cls) {
        return this.f11155g.nextSpanTransition(i2, i10, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        Spannable spannable = this.f11155g;
        if (!this.f11154f && (spannable instanceof PrecomputedText)) {
            this.f11155g = new SpannableString(spannable);
        }
        this.f11154f = true;
        this.f11155g.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i2, int i10, int i11) {
        Spannable spannable = this.f11155g;
        if (!this.f11154f && (spannable instanceof PrecomputedText)) {
            this.f11155g = new SpannableString(spannable);
        }
        this.f11154f = true;
        this.f11155g.setSpan(obj, i2, i10, i11);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i2, int i10) {
        return this.f11155g.subSequence(i2, i10);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f11155g.toString();
    }
}
