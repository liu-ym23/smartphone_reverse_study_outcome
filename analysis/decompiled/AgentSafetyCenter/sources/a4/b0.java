package a4;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 implements Spannable {

    /* renamed from: c, reason: collision with root package name */
    public boolean f159c = false;

    /* renamed from: f, reason: collision with root package name */
    public Spannable f160f;

    public b0(Spannable spannable) {
        this.f160f = spannable;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f160f.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f160f.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f160f.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f160f.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f160f.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f160f.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i, int i3, Class cls) {
        return this.f160f.getSpans(i, i3, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f160f.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i, int i3, Class cls) {
        return this.f160f.nextSpanTransition(i, i3, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        Spannable spannable = this.f160f;
        if (!this.f159c && (spannable instanceof PrecomputedText)) {
            this.f160f = new SpannableString(spannable);
        }
        this.f159c = true;
        this.f160f.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i, int i3, int i10) {
        Spannable spannable = this.f160f;
        if (!this.f159c && (spannable instanceof PrecomputedText)) {
            this.f160f = new SpannableString(spannable);
        }
        this.f159c = true;
        this.f160f.setSpan(obj, i, i3, i10);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i3) {
        return this.f160f.subSequence(i, i3);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f160f.toString();
    }
}
