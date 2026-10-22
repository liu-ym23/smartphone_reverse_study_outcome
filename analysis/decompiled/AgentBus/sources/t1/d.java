package t1;

import android.os.Build;
import android.text.BoringLayout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import q7.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f9676a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f9677b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9678c;

    /* renamed from: d, reason: collision with root package name */
    public float f9679d = Float.NaN;

    /* renamed from: e, reason: collision with root package name */
    public float f9680e = Float.NaN;

    /* renamed from: f, reason: collision with root package name */
    public BoringLayout.Metrics f9681f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9682g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f9683h;

    public d(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.f9676a = charSequence;
        this.f9677b = textPaint;
        this.f9678c = i2;
    }

    public final BoringLayout.Metrics a() {
        if (!this.f9682g) {
            TextDirectionHeuristic textDirectionHeuristicA = i.a(this.f9678c);
            int i2 = Build.VERSION.SDK_INT;
            CharSequence charSequence = this.f9676a;
            TextPaint textPaint = this.f9677b;
            this.f9681f = i2 >= 33 ? BoringLayout.isBoring(charSequence, textPaint, textDirectionHeuristicA, true, null) : !textDirectionHeuristicA.isRtl(charSequence, 0, charSequence.length()) ? BoringLayout.isBoring(charSequence, textPaint, null) : null;
            this.f9682g = true;
        }
        return this.f9681f;
    }

    public final CharSequence b() {
        CharacterStyle[] characterStyleArr;
        CharSequence charSequence = this.f9683h;
        if (charSequence == null) {
            charSequence = this.f9676a;
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                if (e.c(spanned, CharacterStyle.class) && (characterStyleArr = (CharacterStyle[]) spanned.getSpans(0, charSequence.length(), CharacterStyle.class)) != null && characterStyleArr.length != 0) {
                    d7.c cVarH = k.h(characterStyleArr);
                    SpannableString spannableString = null;
                    while (cVarH.hasNext()) {
                        CharacterStyle characterStyle = (CharacterStyle) cVarH.next();
                        if (!(characterStyle instanceof MetricAffectingSpan)) {
                            if (spannableString == null) {
                                spannableString = new SpannableString(charSequence);
                            }
                            spannableString.removeSpan(characterStyle);
                        }
                    }
                    if (spannableString != null) {
                        charSequence = spannableString;
                    }
                }
            }
            this.f9683h = charSequence;
        }
        return charSequence;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float c() {
        /*
            r6 = this;
            float r0 = r6.f9679d
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto Lb
            float r6 = r6.f9679d
            return r6
        Lb:
            android.text.BoringLayout$Metrics r0 = r6.a()
            if (r0 == 0) goto L14
            int r0 = r0.width
            goto L15
        L14:
            r0 = -1
        L15:
            float r0 = (float) r0
            r1 = 0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            android.text.TextPaint r3 = r6.f9677b
            if (r2 >= 0) goto L34
            java.lang.CharSequence r0 = r6.b()
            int r0 = r0.length()
            java.lang.CharSequence r2 = r6.b()
            r4 = 0
            float r0 = android.text.Layout.getDesiredWidth(r2, r4, r0, r3)
            double r4 = (double) r0
            double r4 = java.lang.Math.ceil(r4)
            float r0 = (float) r4
        L34:
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 != 0) goto L39
            goto L5d
        L39:
            java.lang.CharSequence r2 = r6.f9676a
            boolean r4 = r2 instanceof android.text.Spanned
            if (r4 == 0) goto L51
            android.text.Spanned r2 = (android.text.Spanned) r2
            java.lang.Class<u1.f> r4 = u1.f.class
            boolean r4 = t1.e.c(r2, r4)
            if (r4 != 0) goto L5a
            java.lang.Class<u1.e> r4 = u1.e.class
            boolean r2 = t1.e.c(r2, r4)
            if (r2 != 0) goto L5a
        L51:
            float r2 = r3.getLetterSpacing()
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 != 0) goto L5a
            goto L5d
        L5a:
            r1 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r1
        L5d:
            r6.f9679d = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.d.c():float");
    }
}
