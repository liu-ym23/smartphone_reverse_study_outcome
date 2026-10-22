package androidx.core.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes.dex */
public class d implements Spannable {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f9693c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Spannable f9694a;

    /* renamed from: b, reason: collision with root package name */
    private final PrecomputedText f9695b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final TextPaint f9696a;

        /* renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f9697b;

        /* renamed from: c, reason: collision with root package name */
        private final int f9698c;

        /* renamed from: d, reason: collision with root package name */
        private final int f9699d;

        /* renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f9700e;

        public a(PrecomputedText.Params params) {
            this.f9696a = params.getTextPaint();
            this.f9697b = params.getTextDirection();
            this.f9698c = params.getBreakStrategy();
            this.f9699d = params.getHyphenationFrequency();
            this.f9700e = params;
        }

        public boolean a(a aVar) {
            if (this.f9698c == aVar.b() && this.f9699d == aVar.c() && this.f9696a.getTextSize() == aVar.e().getTextSize() && this.f9696a.getTextScaleX() == aVar.e().getTextScaleX() && this.f9696a.getTextSkewX() == aVar.e().getTextSkewX() && this.f9696a.getLetterSpacing() == aVar.e().getLetterSpacing() && TextUtils.equals(this.f9696a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) && this.f9696a.getFlags() == aVar.e().getFlags() && this.f9696a.getTextLocales().equals(aVar.e().getTextLocales())) {
                return this.f9696a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f9696a.getTypeface().equals(aVar.e().getTypeface());
            }
            return false;
        }

        public int b() {
            return this.f9698c;
        }

        public int c() {
            return this.f9699d;
        }

        public TextDirectionHeuristic d() {
            return this.f9697b;
        }

        public TextPaint e() {
            return this.f9696a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f9697b == aVar.d();
        }

        public int hashCode() {
            return D.c.b(Float.valueOf(this.f9696a.getTextSize()), Float.valueOf(this.f9696a.getTextScaleX()), Float.valueOf(this.f9696a.getTextSkewX()), Float.valueOf(this.f9696a.getLetterSpacing()), Integer.valueOf(this.f9696a.getFlags()), this.f9696a.getTextLocales(), this.f9696a.getTypeface(), Boolean.valueOf(this.f9696a.isElegantTextHeight()), this.f9697b, Integer.valueOf(this.f9698c), Integer.valueOf(this.f9699d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f9696a.getTextSize());
            sb.append(", textScaleX=" + this.f9696a.getTextScaleX());
            sb.append(", textSkewX=" + this.f9696a.getTextSkewX());
            sb.append(", letterSpacing=" + this.f9696a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f9696a.isElegantTextHeight());
            sb.append(", textLocale=" + this.f9696a.getTextLocales());
            sb.append(", typeface=" + this.f9696a.getTypeface());
            sb.append(", variationSettings=" + this.f9696a.getFontVariationSettings());
            sb.append(", textDir=" + this.f9697b);
            sb.append(", breakStrategy=" + this.f9698c);
            sb.append(", hyphenationFrequency=" + this.f9699d);
            sb.append("}");
            return sb.toString();
        }
    }

    public PrecomputedText a() {
        Spannable spannable = this.f9694a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i5) {
        return this.f9694a.charAt(i5);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f9694a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f9694a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f9694a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i5, int i6, Class<T> cls) {
        return (T[]) this.f9695b.getSpans(i5, i6, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f9694a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i5, int i6, Class cls) {
        return this.f9694a.nextSpanTransition(i5, i6, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        this.f9695b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i5, int i6, int i7) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        this.f9695b.setSpan(obj, i5, i6, i7);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i5, int i6) {
        return this.f9694a.subSequence(i5, i6);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f9694a.toString();
    }
}
