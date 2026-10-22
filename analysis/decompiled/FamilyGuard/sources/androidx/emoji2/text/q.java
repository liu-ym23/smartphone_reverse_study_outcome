package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
class q implements Spannable {

    /* renamed from: a, reason: collision with root package name */
    private boolean f10383a = false;

    /* renamed from: b, reason: collision with root package name */
    private Spannable f10384b;

    private static class a {
        static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    static class b {
        b() {
        }

        boolean a(CharSequence charSequence) {
            throw null;
        }
    }

    static class c extends b {
        c() {
        }

        @Override // androidx.emoji2.text.q.b
        boolean a(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof androidx.core.text.d);
        }
    }

    q(Spannable spannable) {
        this.f10384b = spannable;
    }

    private void a() {
        Spannable spannable = this.f10384b;
        if (!this.f10383a && c().a(spannable)) {
            this.f10384b = new SpannableString(spannable);
        }
        this.f10383a = true;
    }

    static b c() {
        return new c();
    }

    Spannable b() {
        return this.f10384b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i5) {
        return this.f10384b.charAt(i5);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f10384b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f10384b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f10384b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f10384b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f10384b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i5, int i6, Class<T> cls) {
        return (T[]) this.f10384b.getSpans(i5, i6, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f10384b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i5, int i6, Class cls) {
        return this.f10384b.nextSpanTransition(i5, i6, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f10384b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i5, int i6, int i7) {
        a();
        this.f10384b.setSpan(obj, i5, i6, i7);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i5, int i6) {
        return this.f10384b.subSequence(i5, i6);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f10384b.toString();
    }

    q(CharSequence charSequence) {
        this.f10384b = new SpannableString(charSequence);
    }
}
