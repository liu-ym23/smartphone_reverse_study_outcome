package androidx.core.text;

import android.os.Build;
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
import androidx.core.os.n;
import androidx.core.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class PrecomputedTextCompat implements Spannable {
    private static final char LINE_FEED = '\n';
    private static Executor sExecutor;
    private static final Object sLock = null;
    private final int[] mParagraphEnds;
    private final b mParams;
    private final Spannable mText;
    private final PrecomputedText mWrapped;

    static class a {
        static Spannable a(PrecomputedText r0) {
            return r0;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final PrecomputedText.Params f1333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextPaint f1334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TextDirectionHeuristic f1335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f1336d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f1337e;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final TextPaint f1338a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f1339b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f1340c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f1341d;

            public a(TextPaint r2) {
                this.f1338a = r2;
                if (Build.VERSION.SDK_INT < 23) goto L5;
                this.f1340c = 1;
                this.f1341d = 1;
            L7:
                if (Build.VERSION.SDK_INT < 18) goto L9;
                this.f1339b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                return;
            L9:
                this.f1339b = null;
                return;
            L5:
                this.f1341d = 0;
                this.f1340c = 0;
                goto L7
            }

            public a a(int r1) {
                this.f1340c = r1;
                return this;
            }

            public a b(int r1) {
                this.f1341d = r1;
                return this;
            }

            public a a(TextDirectionHeuristic r3) {
                this.f1339b = (TextDirectionHeuristic) ZeusTransformUtils.wrapperContextForParams(r3, TextDirectionHeuristic.class, "com.obric.aiagent.plugin");
                return this;
            }

            public b a() {
                return new b(this.f1338a, this.f1339b, this.f1340c, this.f1341d);
            }
        }

        b(TextPaint r3, TextDirectionHeuristic r4, int r5, int r6) {
            TextDirectionHeuristic r7 = (TextDirectionHeuristic) ZeusTransformUtils.wrapperContextForParams(r4, TextDirectionHeuristic.class, "com.obric.aiagent.plugin");
            if (Build.VERSION.SDK_INT < 29) goto L5;
            this.f1333a = new PrecomputedText.Params.Builder(r3).setBreakStrategy(r5).setHyphenationFrequency(r6).setTextDirection(r7).build();
        L6:
            this.f1334b = r3;
            this.f1335c = r7;
            this.f1336d = r5;
            this.f1337e = r6;
            return;
        L5:
            this.f1333a = null;
            goto L6
        }

        public b(PrecomputedText.Params r3) {
            this.f1334b = r3.getTextPaint();
            this.f1335c = r3.getTextDirection();
            this.f1336d = r3.getBreakStrategy();
            this.f1337e = r3.getHyphenationFrequency();
            if (Build.VERSION.SDK_INT >= 29) goto L6;
            r3 = null;
        L6:
            this.f1333a = r3;
        }

        public TextPaint a() {
            return this.f1334b;
        }

        public TextDirectionHeuristic b() {
            return this.f1335c;
        }

        public int c() {
            return this.f1336d;
        }

        public int d() {
            return this.f1337e;
        }

        public boolean a(b r4) {
            if (Build.VERSION.SDK_INT < 23) goto L11;
            if (this.f1336d == r4.c()) goto L8;
            return false;
        L8:
            if (this.f1337e == r4.d()) goto L11;
            return false;
        L11:
            if (this.f1334b.getTextSize() == r4.a().getTextSize()) goto L14;
            return false;
        L14:
            if (this.f1334b.getTextScaleX() == r4.a().getTextScaleX()) goto L17;
            return false;
        L17:
            if (this.f1334b.getTextSkewX() == r4.a().getTextSkewX()) goto L20;
            return false;
        L20:
            if (Build.VERSION.SDK_INT < 21) goto L28;
            if (this.f1334b.getLetterSpacing() == r4.a().getLetterSpacing()) goto L25;
            return false;
        L25:
            if (TextUtils.equals(this.f1334b.getFontFeatureSettings(), r4.a().getFontFeatureSettings()) == true) goto L28;
            return false;
        L28:
            if (this.f1334b.getFlags() == r4.a().getFlags()) goto L31;
            return false;
        L31:
            if (Build.VERSION.SDK_INT < 24) goto L36;
            if (this.f1334b.getTextLocales().equals(r4.a().getTextLocales()) == true) goto L41;
            return false;
        L41:
            if (this.f1334b.getTypeface() != null) goto L46;
            if (r4.a().getTypeface() == null) goto L48;
            return false;
        L48:
            return true;
        L46:
            if (this.f1334b.getTypeface().equals(r4.a().getTypeface()) == true) goto L50;
            return false;
        L50:
            return true;
        L36:
            if (Build.VERSION.SDK_INT < 17) goto L41;
            if (this.f1334b.getTextLocale().equals(r4.a().getTextLocale()) == true) goto L41;
            return false;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (a(r6) == true) goto L12;
            return false;
        L12:
            if (Build.VERSION.SDK_INT >= 18) goto L14;
        L16:
            return true;
        L14:
            if (this.f1335c == r6.b()) goto L16;
            return false;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT < 24) goto L7;
            return androidx.core.util.d.a(new Object[]{Float.valueOf(this.f1334b.getTextSize()), Float.valueOf(this.f1334b.getTextScaleX()), Float.valueOf(this.f1334b.getTextSkewX()), Float.valueOf(this.f1334b.getLetterSpacing()), Integer.valueOf(this.f1334b.getFlags()), this.f1334b.getTextLocales(), this.f1334b.getTypeface(), Boolean.valueOf(this.f1334b.isElegantTextHeight()), this.f1335c, Integer.valueOf(this.f1336d), Integer.valueOf(this.f1337e)});
        L7:
            if (Build.VERSION.SDK_INT < 21) goto L11;
            return androidx.core.util.d.a(new Object[]{Float.valueOf(this.f1334b.getTextSize()), Float.valueOf(this.f1334b.getTextScaleX()), Float.valueOf(this.f1334b.getTextSkewX()), Float.valueOf(this.f1334b.getLetterSpacing()), Integer.valueOf(this.f1334b.getFlags()), this.f1334b.getTextLocale(), this.f1334b.getTypeface(), Boolean.valueOf(this.f1334b.isElegantTextHeight()), this.f1335c, Integer.valueOf(this.f1336d), Integer.valueOf(this.f1337e)});
        L11:
            if (Build.VERSION.SDK_INT < 18) goto L15;
            return androidx.core.util.d.a(new Object[]{Float.valueOf(this.f1334b.getTextSize()), Float.valueOf(this.f1334b.getTextScaleX()), Float.valueOf(this.f1334b.getTextSkewX()), Integer.valueOf(this.f1334b.getFlags()), this.f1334b.getTextLocale(), this.f1334b.getTypeface(), this.f1335c, Integer.valueOf(this.f1336d), Integer.valueOf(this.f1337e)});
        L15:
            if (Build.VERSION.SDK_INT < 17) goto L19;
            return androidx.core.util.d.a(new Object[]{Float.valueOf(this.f1334b.getTextSize()), Float.valueOf(this.f1334b.getTextScaleX()), Float.valueOf(this.f1334b.getTextSkewX()), Integer.valueOf(this.f1334b.getFlags()), this.f1334b.getTextLocale(), this.f1334b.getTypeface(), this.f1335c, Integer.valueOf(this.f1336d), Integer.valueOf(this.f1337e)});
        L19:
            return androidx.core.util.d.a(new Object[]{Float.valueOf(this.f1334b.getTextSize()), Float.valueOf(this.f1334b.getTextScaleX()), Float.valueOf(this.f1334b.getTextSkewX()), Integer.valueOf(this.f1334b.getFlags()), this.f1334b.getTypeface(), this.f1335c, Integer.valueOf(this.f1336d), Integer.valueOf(this.f1337e)});
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("{");
            r0.append("textSize=" + this.f1334b.getTextSize());
            r0.append(", textScaleX=" + this.f1334b.getTextScaleX());
            r0.append(", textSkewX=" + this.f1334b.getTextSkewX());
            if (Build.VERSION.SDK_INT < 21) goto L6;
            r0.append(", letterSpacing=" + this.f1334b.getLetterSpacing());
            r0.append(", elegantTextHeight=" + this.f1334b.isElegantTextHeight());
        L6:
            if (Build.VERSION.SDK_INT < 24) goto L9;
            r0.append(", textLocale=" + this.f1334b.getTextLocales());
        L11:
            r0.append(", typeface=" + this.f1334b.getTypeface());
            if (Build.VERSION.SDK_INT < 26) goto L14;
            r0.append(", variationSettings=" + this.f1334b.getFontVariationSettings());
        L14:
            r0.append(", textDir=" + this.f1335c);
            r0.append(", breakStrategy=" + this.f1336d);
            r0.append(", hyphenationFrequency=" + this.f1337e);
            r0.append("}");
            return r0.toString();
        L9:
            if (Build.VERSION.SDK_INT < 17) goto L11;
            r0.append(", textLocale=" + this.f1334b.getTextLocale());
            goto L11
        }
    }

    private static class c extends FutureTask<PrecomputedTextCompat> {

        private static class a implements Callable<PrecomputedTextCompat> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private b f1342a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private CharSequence f1343b;

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ PrecomputedTextCompat call() {
                return call();
            }

            a(b r3, CharSequence r4) {
                CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
                this.f1342a = r3;
                this.f1343b = r5;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PrecomputedTextCompat call() {
                return PrecomputedTextCompat.create(this.f1343b, this.f1342a);
            }
        }

        c(b r3, CharSequence r4) {
            super(new a(r3, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin")));
        }
    }

    static {
        sLock = new Object();
    }

    public static PrecomputedTextCompat create(CharSequence r11, b r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.aiagent.plugin");
        g.a(r13);
        g.a(r12);
        n.a("PrecomputedText");     // Catch: Throwable -> L30
        if (Build.VERSION.SDK_INT >= 29) goto L6;
    L10:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L30
        int r2 = r13.length();     // Catch: Throwable -> L30
        int r4 = 0;
    L11:
        if (r4 >= r2) goto L17;
        int r5 = TextUtils.indexOf(r13, LINE_FEED, r4, r2);     // Catch: Throwable -> L30
        if (r5 >= 0) goto L15;
        r4 = r2;
    L16:
        r0.add(Integer.valueOf(r4));     // Catch: Throwable -> L30
        goto L11
    L15:
        r4 = r5 + 1;     // Catch: Throwable -> L30
        goto L16
    L17:
        int[] r10 = new int[r0.size()];     // Catch: Throwable -> L30
        int r3 = 0;
    L19:
        if (r3 >= r0.size()) goto L22;
        r10[r3] = ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r3), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L30
        r3 = r3 + 1;     // Catch: Throwable -> L30
        goto L19
    L22:
        if (Build.VERSION.SDK_INT < 23) goto L25;
        StaticLayout.Builder.obtain(r13, 0, r13.length(), r12.a(), Integer.MAX_VALUE).setBreakStrategy(r12.c()).setHyphenationFrequency(r12.d()).setTextDirection(r12.b()).build();     // Catch: Throwable -> L30
    L27:
        PrecomputedTextCompat r1 = new PrecomputedTextCompat(r13, r12, r10);     // Catch: Throwable -> L30
        n.a();
        return r1;
    L25:
        if (Build.VERSION.SDK_INT < 21) goto L27;
        new StaticLayout(r13, r12.a(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);     // Catch: Throwable -> L30
        goto L27
    L6:
        if (r12.f1333a == null) goto L10;
        PrecomputedTextCompat r6 = new PrecomputedTextCompat(PrecomputedText.create(r13, r12.f1333a), r12);     // Catch: Throwable -> L30
        n.a();
        return r6;
    L30:
        th = move-exception;
        n.a();
        throw th;
    }

    private PrecomputedTextCompat(CharSequence r3, b r4, int[] r5) {
        this.mText = new SpannableString((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        this.mParams = r4;
        this.mParagraphEnds = r5;
        this.mWrapped = null;
    }

    private PrecomputedTextCompat(PrecomputedText r3, b r4) {
        this.mText = a.a(r3);
        this.mParams = r4;
        this.mParagraphEnds = null;
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        r3 = null;
    L6:
        this.mWrapped = r3;
    }

    public PrecomputedText getPrecomputedText() {
        if (ZeusTransformUtils.instanceOf(this.mText, PrecomputedText.class) == true) goto L5;
        return null;
    L5:
        return (PrecomputedText) ZeusTransformUtils.preCheckCast(this.mText, PrecomputedText.class, "com.obric.aiagent.plugin");
    }

    public b getParams() {
        return this.mParams;
    }

    public int getParagraphCount() {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return this.mWrapped.getParagraphCount();
    L7:
        return this.mParagraphEnds.length;
    }

    public int getParagraphStart(int r4) {
        g.a(r4, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        if (r4 != 0) goto L9;
        return 0;
    L9:
        return this.mParagraphEnds[r4 - 1];
    L5:
        return this.mWrapped.getParagraphStart(r4);
    }

    public int getParagraphEnd(int r4) {
        g.a(r4, 0, getParagraphCount(), "paraIndex");
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return this.mWrapped.getParagraphEnd(r4);
    L7:
        return this.mParagraphEnds[r4];
    }

    public static Future<PrecomputedTextCompat> getTextFuture(CharSequence r2, b r3, Executor r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        c r0 = new c(r3, r5);
        if (r6 != null) goto L15;
        Object r7 = sLock;
        monitor-enter(r7);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (sExecutor != null) goto L9;
        sExecutor = Executors.newFixedThreadPool(1);     // Catch: Throwable -> L12
    L9:
        r6 = sExecutor;     // Catch: Throwable -> L12
        monitor-exit(r7);     // Catch: Throwable -> L12
    L15:
        r6.execute(r0);
        return r0;
    }

    @Override // android.text.Spannable
    public void setSpan(Object r3, int r4, int r5, int r6) {
        if (ZeusTransformUtils.instanceOf(r3, MetricAffectingSpan.class) == true) goto L10;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        this.mWrapped.setSpan(r3, r4, r5, r6);
        return;
    L7:
        this.mText.setSpan(r3, r4, r5, r6);
        return;
    L10:
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void removeSpan(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, MetricAffectingSpan.class) == true) goto L10;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        this.mWrapped.removeSpan(r3);
        return;
    L7:
        this.mText.removeSpan(r3);
        return;
    L10:
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int r3, int r4, Class<T> r5) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return (T[]) this.mWrapped.getSpans(r3, r4, r5);
    L7:
        return (T[]) this.mText.getSpans(r3, r4, r5);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object r1) {
        return this.mText.getSpanStart(r1);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object r1) {
        return this.mText.getSpanEnd(r1);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object r1) {
        return this.mText.getSpanFlags(r1);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int r1, int r2, Class r3) {
        return this.mText.nextSpanTransition(r1, r2, r3);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.mText.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int r1) {
        return this.mText.charAt(r1);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r1, int r2) {
        return this.mText.subSequence(r1, r2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.mText.toString();
    }
}
