package e2;

import android.text.BoringLayout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f3423a;

    /* renamed from: b, reason: collision with root package name */
    public TextPaint f3424b;

    /* renamed from: c, reason: collision with root package name */
    public int f3425c;

    /* renamed from: d, reason: collision with root package name */
    public float f3426d;

    /* renamed from: e, reason: collision with root package name */
    public float f3427e;

    /* renamed from: f, reason: collision with root package name */
    public BoringLayout.Metrics f3428f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3429g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f3430h;

    public final CharSequence a() {
        CharacterStyle[] characterStyleArr;
        CharSequence charSequence = this.f3430h;
        if (charSequence == null) {
            charSequence = this.f3423a;
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                if (id.c.v(spanned, CharacterStyle.class) && (characterStyleArr = (CharacterStyle[]) spanned.getSpans(0, charSequence.length(), CharacterStyle.class)) != null && characterStyleArr.length != 0) {
                    kb.b bVarD = k.d(characterStyleArr);
                    SpannableString spannableString = null;
                    while (bVarD.hasNext()) {
                        CharacterStyle characterStyle = (CharacterStyle) bVarD.next();
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
            this.f3430h = charSequence;
        }
        return charSequence;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float b() {
        /*
            r6 = this;
            java.lang.CharSequence r0 = r6.f3423a
            android.text.TextPaint r1 = r6.f3424b
            float r2 = r6.f3426d
            boolean r2 = java.lang.Float.isNaN(r2)
            if (r2 != 0) goto Lf
            float r6 = r6.f3426d
            return r6
        Lf:
            boolean r2 = r6.f3429g
            if (r2 != 0) goto L23
            int r2 = r6.f3425c
            android.text.TextDirectionHeuristic r2 = e2.j.a(r2)
            r3 = 0
            r4 = 1
            android.text.BoringLayout$Metrics r2 = android.text.BoringLayout.isBoring(r0, r1, r2, r4, r3)
            r6.f3428f = r2
            r6.f3429g = r4
        L23:
            android.text.BoringLayout$Metrics r2 = r6.f3428f
            if (r2 == 0) goto L2a
            int r2 = r2.width
            goto L2b
        L2a:
            r2 = -1
        L2b:
            float r2 = (float) r2
            r3 = 0
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 >= 0) goto L48
            java.lang.CharSequence r2 = r6.a()
            int r2 = r2.length()
            java.lang.CharSequence r4 = r6.a()
            r5 = 0
            float r2 = android.text.Layout.getDesiredWidth(r4, r5, r2, r1)
            double r4 = (double) r2
            double r4 = java.lang.Math.ceil(r4)
            float r2 = (float) r4
        L48:
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 != 0) goto L4d
            goto L6f
        L4d:
            boolean r4 = r0 instanceof android.text.Spanned
            if (r4 == 0) goto L63
            android.text.Spanned r0 = (android.text.Spanned) r0
            java.lang.Class<f2.f> r4 = f2.f.class
            boolean r4 = id.c.v(r0, r4)
            if (r4 != 0) goto L6c
            java.lang.Class<f2.e> r4 = f2.e.class
            boolean r0 = id.c.v(r0, r4)
            if (r0 != 0) goto L6c
        L63:
            float r0 = r1.getLetterSpacing()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L6c
            goto L6f
        L6c:
            r0 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r0
        L6f:
            r6.f3426d = r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.e.b():float");
    }
}
