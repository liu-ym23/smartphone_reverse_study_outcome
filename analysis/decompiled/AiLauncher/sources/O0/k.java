package O0;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public class k implements Spannable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5155a = false;

    /* renamed from: b, reason: collision with root package name */
    public Spannable f5156b;

    public static class a {
        public static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        public static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    public static class b {
        public boolean a(CharSequence charSequence) {
            throw null;
        }
    }

    public static class c extends b {
        @Override // O0.k.b
        public boolean a(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof z0.c);
        }
    }

    public k(Spannable spannable) {
        this.f5156b = spannable;
    }

    public static b c() {
        return new c();
    }

    public final void a() {
        Spannable spannable = this.f5156b;
        if (!this.f5155a && c().a(spannable)) {
            this.f5156b = new SpannableString(spannable);
        }
        this.f5155a = true;
    }

    public Spannable b() {
        return this.f5156b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f5156b.charAt(i10);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f5156b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f5156b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f5156b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f5156b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f5156b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return (T[]) this.f5156b.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f5156b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f5156b.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f5156b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        a();
        this.f5156b.setSpan(obj, i10, i11, i12);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f5156b.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f5156b.toString();
    }

    public k(CharSequence charSequence) {
        this.f5156b = new SpannableString(charSequence);
    }
}
