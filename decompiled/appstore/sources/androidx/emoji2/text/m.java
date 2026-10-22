package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
public class m implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Spannable f3110b;

    public static class a {
        public static IntStream a(CharSequence r10) {
            return r10.chars();
        }

        public static IntStream b(CharSequence r10) {
            return r10.codePoints();
        }
    }

    public static class b {
        public b() {
        }

        public abstract boolean a(CharSequence r10);
    }

    public static class c extends b {
        public c() {
        }

        @Override // androidx.emoji2.text.m.b
        public boolean a(CharSequence r10) {
            return r10 instanceof PrecomputedText;
        }
    }

    public m(Spannable r10) {
        this.f3109a = false;
        this.f3110b = r10;
    }

    public static b c() {
        return new c();
    }

    public final void a() {
        Spannable r10 = this.f3110b;
        if (this.f3109a == false) goto L5;
    L7:
        this.f3109a = true;
        return;
    L5:
        if (c().a(r10) == false) goto L7;
        this.f3110b = new SpannableString(r10);
        goto L7
    }

    public Spannable b() {
        return this.f3110b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int r10) {
        return this.f3110b.charAt(r10);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f3110b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f3110b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object r10) {
        return this.f3110b.getSpanEnd(r10);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object r10) {
        return this.f3110b.getSpanFlags(r10);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object r10) {
        return this.f3110b.getSpanStart(r10);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int r10, int r11, Class r12) {
        return this.f3110b.getSpans(r10, r11, r12);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f3110b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int r10, int r11, Class r12) {
        return this.f3110b.nextSpanTransition(r10, r11, r12);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object r10) {
        a();
        this.f3110b.removeSpan(r10);
    }

    @Override // android.text.Spannable
    public void setSpan(Object r10, int r11, int r12, int r13) {
        a();
        this.f3110b.setSpan(r10, r11, r12, r13);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r10, int r11) {
        return this.f3110b.subSequence(r10, r11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f3110b.toString();
    }

    public m(CharSequence r10) {
        this.f3109a = false;
        this.f3110b = new SpannableString(r10);
    }
}
