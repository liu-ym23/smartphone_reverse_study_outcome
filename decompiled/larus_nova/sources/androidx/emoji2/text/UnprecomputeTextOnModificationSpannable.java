package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes17.dex */
class UnprecomputeTextOnModificationSpannable implements Spannable {
    private Spannable mDelegate;
    private boolean mSafeToWrite;

    public static class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
        }

        public static IntStream chars(CharSequence r100) {
            return r100.chars();
        }

        public static IntStream codePoints(CharSequence r100) {
            return r100.codePoints();
        }
    }

    public static class PrecomputedTextDetector {
        public PrecomputedTextDetector() {
        }

        public boolean isPrecomputedText(CharSequence r100) {
            return r100 instanceof PrecomputedTextCompat;
        }
    }

    public static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        public PrecomputedTextDetector_28() {
        }

        @Override // androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector
        public boolean isPrecomputedText(CharSequence r100) {
            if ((r100 instanceof PrecomputedText) == false) goto L5;
        L8:
            return true;
        L5:
            if ((r100 instanceof PrecomputedTextCompat) == true) goto L8;
            return false;
        }
    }

    private void ensureSafeWrites() {
        Spannable r100 = this.mDelegate;
        if (this.mSafeToWrite == false) goto L5;
    L7:
        this.mSafeToWrite = true;
        return;
    L5:
        if (precomputedTextDetector().isPrecomputedText(r100) == false) goto L7;
        this.mDelegate = new SpannableString(r100);
        goto L7
    }

    public static PrecomputedTextDetector precomputedTextDetector() {
        if (Build.VERSION.SDK_INT >= 28) goto L6;
        return new PrecomputedTextDetector();
    L6:
        return new PrecomputedTextDetector_28();
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return CharSequenceHelper_API24.chars(this.mDelegate);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return CharSequenceHelper_API24.codePoints(this.mDelegate);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mDelegate.length();
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.mDelegate.toString();
    }

    public Spannable getUnwrappedSpannable() {
        return this.mDelegate;
    }

    public UnprecomputeTextOnModificationSpannable(Spanned r100) {
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(r100);
    }

    @Override // java.lang.CharSequence
    public char charAt(int r100) {
        return this.mDelegate.charAt(r100);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object r100) {
        return this.mDelegate.getSpanEnd(r100);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object r100) {
        return this.mDelegate.getSpanFlags(r100);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object r100) {
        return this.mDelegate.getSpanStart(r100);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object r100) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(r100);
    }

    public UnprecomputeTextOnModificationSpannable(CharSequence r100) {
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(r100);
    }

    public UnprecomputeTextOnModificationSpannable(Spannable r100) {
        this.mSafeToWrite = false;
        this.mDelegate = r100;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r100, int r101) {
        return this.mDelegate.subSequence(r100, r101);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int r100, int r101, Class<T> r102) {
        return (T[]) this.mDelegate.getSpans(r100, r101, r102);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int r100, int r101, Class r102) {
        return this.mDelegate.nextSpanTransition(r100, r101, r102);
    }

    @Override // android.text.Spannable
    public void setSpan(Object r100, int r101, int r102, int r103) {
        ensureSafeWrites();
        this.mDelegate.setSpan(r100, r101, r102, r103);
    }
}
