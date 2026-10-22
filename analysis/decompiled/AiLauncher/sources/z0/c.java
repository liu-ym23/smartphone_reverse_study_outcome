package z0;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
public class c implements Spannable {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f44543c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Spannable f44544a;

    /* renamed from: b, reason: collision with root package name */
    public final PrecomputedText f44545b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextPaint f44546a;

        /* renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f44547b;

        /* renamed from: c, reason: collision with root package name */
        public final int f44548c;

        /* renamed from: d, reason: collision with root package name */
        public final int f44549d;

        /* renamed from: e, reason: collision with root package name */
        public final PrecomputedText.Params f44550e;

        public a(PrecomputedText.Params params) {
            this.f44546a = params.getTextPaint();
            this.f44547b = params.getTextDirection();
            this.f44548c = params.getBreakStrategy();
            this.f44549d = params.getHyphenationFrequency();
            this.f44550e = params;
        }

        public boolean a(a aVar) {
            if (this.f44548c == aVar.b() && this.f44549d == aVar.c() && this.f44546a.getTextSize() == aVar.e().getTextSize() && this.f44546a.getTextScaleX() == aVar.e().getTextScaleX() && this.f44546a.getTextSkewX() == aVar.e().getTextSkewX() && this.f44546a.getLetterSpacing() == aVar.e().getLetterSpacing() && TextUtils.equals(this.f44546a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) && this.f44546a.getFlags() == aVar.e().getFlags() && this.f44546a.getTextLocales().equals(aVar.e().getTextLocales())) {
                return this.f44546a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f44546a.getTypeface().equals(aVar.e().getTypeface());
            }
            return false;
        }

        public int b() {
            return this.f44548c;
        }

        public int c() {
            return this.f44549d;
        }

        public TextDirectionHeuristic d() {
            return this.f44547b;
        }

        public TextPaint e() {
            return this.f44546a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f44547b == aVar.d();
        }

        public int hashCode() {
            return B0.c.b(Float.valueOf(this.f44546a.getTextSize()), Float.valueOf(this.f44546a.getTextScaleX()), Float.valueOf(this.f44546a.getTextSkewX()), Float.valueOf(this.f44546a.getLetterSpacing()), Integer.valueOf(this.f44546a.getFlags()), this.f44546a.getTextLocales(), this.f44546a.getTypeface(), Boolean.valueOf(this.f44546a.isElegantTextHeight()), this.f44547b, Integer.valueOf(this.f44548c), Integer.valueOf(this.f44549d));
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(Const.STR_MART_JSON_BEGIN);
            sb2.append("textSize=" + this.f44546a.getTextSize());
            sb2.append(", textScaleX=" + this.f44546a.getTextScaleX());
            sb2.append(", textSkewX=" + this.f44546a.getTextSkewX());
            sb2.append(", letterSpacing=" + this.f44546a.getLetterSpacing());
            sb2.append(", elegantTextHeight=" + this.f44546a.isElegantTextHeight());
            sb2.append(", textLocale=" + this.f44546a.getTextLocales());
            sb2.append(", typeface=" + this.f44546a.getTypeface());
            sb2.append(", variationSettings=" + this.f44546a.getFontVariationSettings());
            sb2.append(", textDir=" + this.f44547b);
            sb2.append(", breakStrategy=" + this.f44548c);
            sb2.append(", hyphenationFrequency=" + this.f44549d);
            sb2.append("}");
            return sb2.toString();
        }
    }

    public PrecomputedText a() {
        Spannable spannable = this.f44544a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f44544a.charAt(i10);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f44544a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f44544a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f44544a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return (T[]) this.f44545b.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f44544a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f44544a.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        this.f44545b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        this.f44545b.setSpan(obj, i10, i11, i12);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f44544a.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f44544a.toString();
    }
}
