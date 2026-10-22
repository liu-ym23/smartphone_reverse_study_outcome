package i1;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i implements Spannable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9447a = false;

    /* renamed from: b, reason: collision with root package name */
    public Spannable f9448b;

    public i(Spannable spannable) {
        this.f9448b = spannable;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i10) {
        return this.f9448b.charAt(i10);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f9448b.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f9448b.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f9448b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f9448b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f9448b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return (T[]) this.f9448b.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f9448b.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f9448b.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        Spannable spannable = this.f9448b;
        if (!this.f9447a && ((spannable instanceof PrecomputedText) || (spannable instanceof t0.b))) {
            this.f9448b = new SpannableString(spannable);
        }
        this.f9447a = true;
        this.f9448b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i10, int i11, int i12) {
        Spannable spannable = this.f9448b;
        if (!this.f9447a && ((spannable instanceof PrecomputedText) || (spannable instanceof t0.b))) {
            this.f9448b = new SpannableString(spannable);
        }
        this.f9447a = true;
        this.f9448b.setSpan(obj, i10, i11, i12);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i10, int i11) {
        return this.f9448b.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f9448b.toString();
    }
}
