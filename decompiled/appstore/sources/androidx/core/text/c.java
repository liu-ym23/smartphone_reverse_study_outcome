package androidx.core.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Spannable {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextPaint f2639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f2640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f2642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PrecomputedText.Params f2643e;

        public a(PrecomputedText.Params r10) {
            this.f2639a = r10.getTextPaint();
            this.f2640b = r10.getTextDirection();
            this.f2641c = r10.getBreakStrategy();
            this.f2642d = r10.getHyphenationFrequency();
            this.f2643e = r10;
        }

        public boolean a(a r10) {
            if (this.f2641c == r10.b()) goto L6;
            return false;
        L6:
            if (this.f2642d == r10.c()) goto L9;
            return false;
        L9:
            if (this.f2639a.getTextSize() == r10.e().getTextSize()) goto L12;
            return false;
        L12:
            if (this.f2639a.getTextScaleX() == r10.e().getTextScaleX()) goto L15;
            return false;
        L15:
            if (this.f2639a.getTextSkewX() == r10.e().getTextSkewX()) goto L18;
            return false;
        L18:
            if (this.f2639a.getLetterSpacing() == r10.e().getLetterSpacing()) goto L21;
            return false;
        L21:
            if (TextUtils.equals(this.f2639a.getFontFeatureSettings(), r10.e().getFontFeatureSettings()) == true) goto L24;
            return false;
        L24:
            if (this.f2639a.getFlags() == r10.e().getFlags()) goto L27;
            return false;
        L27:
            if (this.f2639a.getTextLocales().equals(r10.e().getTextLocales()) == true) goto L30;
            return false;
        L30:
            if (this.f2639a.getTypeface() != null) goto L35;
            if (r10.e().getTypeface() == null) goto L37;
            return false;
        L37:
            return true;
        L35:
            if (this.f2639a.getTypeface().equals(r10.e().getTypeface()) == true) goto L39;
            return false;
        L39:
            return true;
        }

        public int b() {
            return this.f2641c;
        }

        public int c() {
            return this.f2642d;
        }

        public TextDirectionHeuristic d() {
            return this.f2640b;
        }

        public TextPaint e() {
            return this.f2639a;
        }

        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (a(r11) == true) goto L12;
            return false;
        L12:
            if (this.f2640b == r11.d()) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return androidx.core.util.b.b(new Object[]{Float.valueOf(this.f2639a.getTextSize()), Float.valueOf(this.f2639a.getTextScaleX()), Float.valueOf(this.f2639a.getTextSkewX()), Float.valueOf(this.f2639a.getLetterSpacing()), Integer.valueOf(this.f2639a.getFlags()), this.f2639a.getTextLocales(), this.f2639a.getTypeface(), Boolean.valueOf(this.f2639a.isElegantTextHeight()), this.f2640b, Integer.valueOf(this.f2641c), Integer.valueOf(this.f2642d)});
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder("{");
            r10.append("textSize=" + this.f2639a.getTextSize());
            r10.append(", textScaleX=" + this.f2639a.getTextScaleX());
            r10.append(", textSkewX=" + this.f2639a.getTextSkewX());
            r10.append(", letterSpacing=" + this.f2639a.getLetterSpacing());
            r10.append(", elegantTextHeight=" + this.f2639a.isElegantTextHeight());
            r10.append(", textLocale=" + this.f2639a.getTextLocales());
            r10.append(", typeface=" + this.f2639a.getTypeface());
            r10.append(", variationSettings=" + this.f2639a.getFontVariationSettings());
            r10.append(", textDir=" + this.f2640b);
            r10.append(", breakStrategy=" + this.f2641c);
            r10.append(", hyphenationFrequency=" + this.f2642d);
            r10.append("}");
            return r10.toString();
        }
    }
}
