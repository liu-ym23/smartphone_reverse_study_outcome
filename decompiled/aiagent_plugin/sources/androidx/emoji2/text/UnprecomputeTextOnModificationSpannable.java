package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.core.text.PrecomputedTextCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
class UnprecomputeTextOnModificationSpannable implements Spannable {
    private Spannable mDelegate;
    private boolean mSafeToWrite;

    private static class a {
        static IntStream a(CharSequence r2) {
            return ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin")).codePoints();
        }

        static IntStream b(CharSequence r2) {
            return ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin")).chars();
        }
    }

    static class b {
        b() {
        }

        boolean a(CharSequence r2) {
            return ZeusTransformUtils.instanceOf((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin"), PrecomputedTextCompat.class);
        }
    }

    static class c extends b {
        c() {
        }

        @Override // androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.b
        boolean a(CharSequence r2) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r1, PrecomputedText.class) == false) goto L5;
        L8:
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r1, PrecomputedTextCompat.class) == true) goto L8;
            return false;
        }
    }

    UnprecomputeTextOnModificationSpannable(Spannable r3) {
        Spannable r4 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r3, Spannable.class, "com.obric.aiagent.plugin");
        this.mSafeToWrite = false;
        this.mDelegate = r4;
    }

    UnprecomputeTextOnModificationSpannable(Spanned r3) {
        Spanned r4 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r3, Spanned.class, "com.obric.aiagent.plugin");
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(r4);
    }

    UnprecomputeTextOnModificationSpannable(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(r4);
    }

    private void ensureSafeWrites() {
        Spannable r0 = this.mDelegate;
        if (this.mSafeToWrite == false) goto L5;
    L7:
        this.mSafeToWrite = true;
        return;
    L5:
        if (precomputedTextDetector().a(r0) == false) goto L7;
        this.mDelegate = new SpannableString(r0);
        goto L7
    }

    Spannable getUnwrappedSpannable() {
        return this.mDelegate;
    }

    @Override // android.text.Spannable
    public void setSpan(Object r1, int r2, int r3, int r4) {
        ensureSafeWrites();
        this.mDelegate.setSpan(r1, r2, r3, r4);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object r1) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(r1);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int r1, int r2, Class<T> r3) {
        return (T[]) this.mDelegate.getSpans(r1, r2, r3);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object r1) {
        return this.mDelegate.getSpanStart(r1);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object r1) {
        return this.mDelegate.getSpanEnd(r1);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object r1) {
        return this.mDelegate.getSpanFlags(r1);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int r1, int r2, Class r3) {
        return this.mDelegate.nextSpanTransition(r1, r2, r3);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mDelegate.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int r1) {
        return this.mDelegate.charAt(r1);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r1, int r2) {
        return this.mDelegate.subSequence(r1, r2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.mDelegate.toString();
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.b(this.mDelegate);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.a(this.mDelegate);
    }

    static b precomputedTextDetector() {
        if (Build.VERSION.SDK_INT >= 28) goto L6;
        return new b();
    L6:
        return new c();
    }
}
