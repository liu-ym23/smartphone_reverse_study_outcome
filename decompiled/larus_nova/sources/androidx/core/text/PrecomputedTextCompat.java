package androidx.core.text;

import android.os.Build;
import android.os.Trace;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.alipay.sdk.m.u.i;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes17.dex */
public class PrecomputedTextCompat implements Spannable {
    private static final char LINE_FEED = '\n';
    private static Executor sExecutor;
    private static final Object sLock = null;
    private final int[] mParagraphEnds;
    private final Params mParams;
    private final Spannable mText;
    private final PrecomputedText mWrapped;

    public static class Api28Impl {
        public static Spannable castToSpannable(PrecomputedText r100) {
            return r100;
        }

        private Api28Impl() {
        }
    }

    public static final class Params {
        private final int mBreakStrategy;
        private final int mHyphenationFrequency;
        private final TextPaint mPaint;
        private final TextDirectionHeuristic mTextDir;
        final PrecomputedText.Params mWrapped;

        public static class Builder {
            private int mBreakStrategy;
            private int mHyphenationFrequency;
            private final TextPaint mPaint;
            private TextDirectionHeuristic mTextDir;

            public Params build() {
                return new Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
            }

            public Builder(TextPaint r100) {
                this.mPaint = r100;
                if (Build.VERSION.SDK_INT < 23) goto L5;
                this.mBreakStrategy = 1;
                this.mHyphenationFrequency = 1;
            L6:
                this.mTextDir = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                return;
            L5:
                this.mHyphenationFrequency = 0;
                this.mBreakStrategy = 0;
                goto L6
            }

            public Builder setBreakStrategy(int r100) {
                this.mBreakStrategy = r100;
                return this;
            }

            public Builder setHyphenationFrequency(int r100) {
                this.mHyphenationFrequency = r100;
                return this;
            }

            public Builder setTextDirection(TextDirectionHeuristic r100) {
                this.mTextDir = r100;
                return this;
            }
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT < 24) goto L7;
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        L7:
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("{");
            r100.append("textSize=" + this.mPaint.getTextSize());
            r100.append(", textScaleX=" + this.mPaint.getTextScaleX());
            r100.append(", textSkewX=" + this.mPaint.getTextSkewX());
            int r101 = Build.VERSION.SDK_INT;
            r100.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
            r100.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
            if (r101 < 24) goto L5;
            r100.append(", textLocale=" + this.mPaint.getTextLocales());
        L6:
            r100.append(", typeface=" + this.mPaint.getTypeface());
            if (r101 < 26) goto L9;
            r100.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
        L9:
            r100.append(", textDir=" + this.mTextDir);
            r100.append(", breakStrategy=" + this.mBreakStrategy);
            r100.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            r100.append(i.f25855d);
            return r100.toString();
        L5:
            r100.append(", textLocale=" + this.mPaint.getTextLocale());
            goto L6
        }

        public int getBreakStrategy() {
            return this.mBreakStrategy;
        }

        public int getHyphenationFrequency() {
            return this.mHyphenationFrequency;
        }

        public TextDirectionHeuristic getTextDirection() {
            return this.mTextDir;
        }

        public TextPaint getTextPaint() {
            return this.mPaint;
        }

        public Params(PrecomputedText.Params r100) {
            this.mPaint = r100.getTextPaint();
            this.mTextDir = r100.getTextDirection();
            this.mBreakStrategy = r100.getBreakStrategy();
            this.mHyphenationFrequency = r100.getHyphenationFrequency();
            if (Build.VERSION.SDK_INT >= 29) goto L6;
            r100 = null;
        L6:
            this.mWrapped = r100;
        }

        public boolean equals(Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof Params) == true) goto L8;
            return false;
        L8:
            Params r101 = (Params) r100;
            if (equalsWithoutTextDirection(r101) == true) goto L12;
            return false;
        L12:
            if (this.mTextDir == r101.getTextDirection()) goto L16;
            return false;
        L16:
            return true;
        }

        public boolean equalsWithoutTextDirection(Params r100) {
            int r101 = Build.VERSION.SDK_INT;
            if (r101 < 23) goto L11;
            if (this.mBreakStrategy == r100.getBreakStrategy()) goto L8;
            return false;
        L8:
            if (this.mHyphenationFrequency == r100.getHyphenationFrequency()) goto L11;
            return false;
        L11:
            if (this.mPaint.getTextSize() == r100.getTextPaint().getTextSize()) goto L14;
            return false;
        L14:
            if (this.mPaint.getTextScaleX() == r100.getTextPaint().getTextScaleX()) goto L17;
            return false;
        L17:
            if (this.mPaint.getTextSkewX() == r100.getTextPaint().getTextSkewX()) goto L20;
            return false;
        L20:
            if (this.mPaint.getLetterSpacing() == r100.getTextPaint().getLetterSpacing()) goto L23;
            return false;
        L23:
            if (TextUtils.equals(this.mPaint.getFontFeatureSettings(), r100.getTextPaint().getFontFeatureSettings()) == true) goto L26;
            return false;
        L26:
            if (this.mPaint.getFlags() == r100.getTextPaint().getFlags()) goto L29;
            return false;
        L29:
            if (r101 < 24) goto L34;
            if (this.mPaint.getTextLocales().equals(r100.getTextPaint().getTextLocales()) == true) goto L37;
            return false;
        L37:
            if (this.mPaint.getTypeface() != null) goto L42;
            if (r100.getTextPaint().getTypeface() == null) goto L44;
            return false;
        L44:
            return true;
        L42:
            if (this.mPaint.getTypeface().equals(r100.getTextPaint().getTypeface()) == true) goto L46;
            return false;
        L46:
            return true;
        L34:
            if (this.mPaint.getTextLocale().equals(r100.getTextPaint().getTextLocale()) == true) goto L37;
            return false;
        }

        public Params(TextPaint r100, TextDirectionHeuristic r101, int r102, int r103) {
            if (Build.VERSION.SDK_INT < 29) goto L5;
            this.mWrapped = new PrecomputedText.Params.Builder(r100).setBreakStrategy(r102).setHyphenationFrequency(r103).setTextDirection(r101).build();
        L6:
            this.mPaint = r100;
            this.mTextDir = r101;
            this.mBreakStrategy = r102;
            this.mHyphenationFrequency = r103;
            return;
        L5:
            this.mWrapped = null;
            goto L6
        }
    }

    public static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        public static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
            private Params mParams;
            private CharSequence mText;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PrecomputedTextCompat call() throws Exception {
                return PrecomputedTextCompat.create(this.mText, this.mParams);
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ PrecomputedTextCompat call() throws Exception {
                return call();
            }

            public PrecomputedTextCallback(Params r100, CharSequence r101) {
                this.mParams = r100;
                this.mText = r101;
            }
        }

        public PrecomputedTextFutureTask(Params r100, CharSequence r101) {
            super(new PrecomputedTextCallback(r100, r101));
        }
    }

    static {
        sLock = new Object();
        sExecutor = null;
    }

    public int getParagraphCount() {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return this.mWrapped.getParagraphCount();
    L7:
        return this.mParagraphEnds.length;
    }

    public PrecomputedText getPrecomputedText() {
        Spannable r100 = this.mText;
        if ((r100 instanceof PrecomputedText) == true) goto L5;
        return null;
    L5:
        return (PrecomputedText) r100;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mText.length();
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.mText.toString();
    }

    public Params getParams() {
        return this.mParams;
    }

    @Override // java.lang.CharSequence
    public char charAt(int r100) {
        return this.mText.charAt(r100);
    }

    public int getParagraphEnd(int r100) {
        Preconditions.checkArgumentInRange(r100, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return this.mWrapped.getParagraphEnd(r100);
    L7:
        return this.mParagraphEnds[r100];
    }

    public int getParagraphStart(int r100) {
        Preconditions.checkArgumentInRange(r100, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        if (r100 != 0) goto L9;
        return 0;
    L9:
        return this.mParagraphEnds[r100 - 1];
    L5:
        return this.mWrapped.getParagraphStart(r100);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object r100) {
        return this.mText.getSpanEnd(r100);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object r100) {
        return this.mText.getSpanFlags(r100);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object r100) {
        return this.mText.getSpanStart(r100);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object r100) {
        if ((r100 instanceof MetricAffectingSpan) == true) goto L10;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        this.mWrapped.removeSpan(r100);
        return;
    L7:
        this.mText.removeSpan(r100);
        return;
    L10:
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    private PrecomputedTextCompat(PrecomputedText r100, Params r101) {
        this.mText = Api28Impl.castToSpannable(r100);
        this.mParams = r101;
        this.mParagraphEnds = null;
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        r100 = null;
    L6:
        this.mWrapped = r100;
    }

    public static PrecomputedTextCompat create(CharSequence r110, Params r111) {
        Preconditions.checkNotNull(r110);
        Preconditions.checkNotNull(r111);
        Trace.beginSection("PrecomputedText");     // Catch: Throwable -> L28
        if (Build.VERSION.SDK_INT < 29) goto L10;
        PrecomputedText.Params r100 = r111.mWrapped;     // Catch: Throwable -> L28
        if (r100 == null) goto L10;
        PrecomputedTextCompat r101 = new PrecomputedTextCompat(PrecomputedText.create(r110, r100), r111);     // Catch: Throwable -> L28
        Trace.endSection();
        return r101;
    L10:
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L28
        int r103 = r110.length();     // Catch: Throwable -> L28
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L17;
        int r105 = TextUtils.indexOf(r110, LINE_FEED, r104, r103);     // Catch: Throwable -> L28
        if (r105 >= 0) goto L15;
        r104 = r103;
    L16:
        r102.add(Integer.valueOf(r104));     // Catch: Throwable -> L28
        goto L11
    L15:
        r104 = r105 + 1;     // Catch: Throwable -> L28
        goto L16
    L17:
        int[] r106 = new int[r102.size()];     // Catch: Throwable -> L28
        int r107 = 0;
    L19:
        if (r107 >= r102.size()) goto L22;
        r106[r107] = ((Integer) r102.get(r107)).intValue();     // Catch: Throwable -> L28
        r107 = r107 + 1;     // Catch: Throwable -> L28
        goto L19
    L22:
        if (Build.VERSION.SDK_INT < 23) goto L24;
        StaticLayout.Builder.obtain(r110, 0, r110.length(), r111.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(r111.getBreakStrategy()).setHyphenationFrequency(r111.getHyphenationFrequency()).setTextDirection(r111.getTextDirection()).build();     // Catch: Throwable -> L28
    L25:
        PrecomputedTextCompat r108 = new PrecomputedTextCompat(r110, r111, r106);     // Catch: Throwable -> L28
        Trace.endSection();
        return r108;
    L24:
        new StaticLayout(r110, r111.getTextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r100, int r101) {
        return this.mText.subSequence(r100, r101);
    }

    private PrecomputedTextCompat(CharSequence r100, Params r101, int[] r102) {
        this.mText = new SpannableString(r100);
        this.mParams = r101;
        this.mParagraphEnds = r102;
        this.mWrapped = null;
    }

    public static Future<PrecomputedTextCompat> getTextFuture(CharSequence r100, Params r101, Executor r102) {
        PrecomputedTextFutureTask r103 = new PrecomputedTextFutureTask(r101, r100);
        if (r102 != null) goto L15;
        Object r104 = sLock;
        monitor-enter(r104);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (sExecutor != null) goto L9;
        sExecutor = PThreadExecutorsUtils.newFixedThreadPool(1, new DefaultThreadFactory("PrecomputedTextCompat"));     // Catch: Throwable -> L12
    L9:
        r102 = sExecutor;     // Catch: Throwable -> L12
        monitor-exit(r104);     // Catch: Throwable -> L12
    L15:
        r102.execute(r103);
        return r103;
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int r100, int r101, Class<T> r102) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return (T[]) this.mWrapped.getSpans(r100, r101, r102);
    L7:
        return (T[]) this.mText.getSpans(r100, r101, r102);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int r100, int r101, Class r102) {
        return this.mText.nextSpanTransition(r100, r101, r102);
    }

    @Override // android.text.Spannable
    public void setSpan(Object r100, int r101, int r102, int r103) {
        if ((r100 instanceof MetricAffectingSpan) == true) goto L10;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        this.mWrapped.setSpan(r100, r101, r102, r103);
        return;
    L7:
        this.mText.setSpan(r100, r101, r102, r103);
        return;
    L10:
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }
}
