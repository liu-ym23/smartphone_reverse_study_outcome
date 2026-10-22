package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b0 implements Spannable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f596a = false;

    /* renamed from: b, reason: collision with root package name */
    public Spannable f597b;

    public b0(Spannable spannable) {
        this.f597b = spannable;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i8) {
        return this.f597b.charAt(i8);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f597b.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f597b.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f597b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f597b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f597b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i8, int i9, Class cls) {
        return this.f597b.getSpans(i8, i9, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f597b.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i8, int i9, Class cls) {
        return this.f597b.nextSpanTransition(i8, i9, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        Spannable spannable = this.f597b;
        if (!this.f596a && (spannable instanceof PrecomputedText)) {
            this.f597b = new SpannableString(spannable);
        }
        this.f596a = true;
        this.f597b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i8, int i9, int i10) {
        Spannable spannable = this.f597b;
        if (!this.f596a && (spannable instanceof PrecomputedText)) {
            this.f597b = new SpannableString(spannable);
        }
        this.f596a = true;
        this.f597b.setSpan(obj, i8, i9, i10);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i8, int i9) {
        return this.f597b.subSequence(i8, i9);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f597b.toString();
    }
}
