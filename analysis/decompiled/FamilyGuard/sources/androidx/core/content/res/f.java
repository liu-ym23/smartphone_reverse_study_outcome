package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import z.C1334f;

/* loaded from: classes.dex */
final class f {
    private static a a(a aVar, int i5, int i6, boolean z5, int i7) {
        return aVar != null ? aVar : z5 ? new a(i5, i7, i6) : new a(i5, i6);
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayQ = k.q(resources, theme, attributeSet, C1334f.f23988A);
        float fJ = k.j(typedArrayQ, xmlPullParser, "startX", C1334f.f23997J, 0.0f);
        float fJ2 = k.j(typedArrayQ, xmlPullParser, "startY", C1334f.f23998K, 0.0f);
        float fJ3 = k.j(typedArrayQ, xmlPullParser, "endX", C1334f.f23999L, 0.0f);
        float fJ4 = k.j(typedArrayQ, xmlPullParser, "endY", C1334f.f24000M, 0.0f);
        float fJ5 = k.j(typedArrayQ, xmlPullParser, "centerX", C1334f.f23992E, 0.0f);
        float fJ6 = k.j(typedArrayQ, xmlPullParser, "centerY", C1334f.f23993F, 0.0f);
        int iK = k.k(typedArrayQ, xmlPullParser, "type", C1334f.f23991D, 0);
        int iF = k.f(typedArrayQ, xmlPullParser, "startColor", C1334f.f23989B, 0);
        boolean zP = k.p(xmlPullParser, "centerColor");
        int iF2 = k.f(typedArrayQ, xmlPullParser, "centerColor", C1334f.f23996I, 0);
        int iF3 = k.f(typedArrayQ, xmlPullParser, "endColor", C1334f.f23990C, 0);
        int iK2 = k.k(typedArrayQ, xmlPullParser, "tileMode", C1334f.f23995H, 0);
        float fJ7 = k.j(typedArrayQ, xmlPullParser, "gradientRadius", C1334f.f23994G, 0.0f);
        typedArrayQ.recycle();
        a aVarA = a(c(resources, xmlPullParser, attributeSet, theme), iF, iF3, zP, iF2);
        if (iK != 1) {
            return iK != 2 ? new LinearGradient(fJ, fJ2, fJ3, fJ4, aVarA.f9615a, aVarA.f9616b, d(iK2)) : new SweepGradient(fJ5, fJ6, aVarA.f9615a, aVarA.f9616b);
        }
        if (fJ7 > 0.0f) {
            return new RadialGradient(fJ5, fJ6, fJ7, aVarA.f9615a, aVarA.f9616b, d(iK2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
    
        if (r4.size() <= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
    
        return new androidx.core.content.res.f.a(r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static androidx.core.content.res.f.a c(android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r10.next()
            if (r3 == r1) goto L81
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L81
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = z.C1334f.f24001N
            android.content.res.TypedArray r3 = androidx.core.content.res.k.q(r9, r12, r11, r3)
            int r5 = z.C1334f.f24002O
            boolean r6 = r3.hasValue(r5)
            int r7 = z.C1334f.f24003P
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L66
            if (r8 == 0) goto L66
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L66:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L81:
            int r9 = r4.size()
            if (r9 <= 0) goto L8d
            androidx.core.content.res.f$a r9 = new androidx.core.content.res.f$a
            r9.<init>(r4, r2)
            return r9
        L8d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.f.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.res.f$a");
    }

    private static Shader.TileMode d(int i5) {
        return i5 != 1 ? i5 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        final int[] f9615a;

        /* renamed from: b, reason: collision with root package name */
        final float[] f9616b;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f9615a = new int[size];
            this.f9616b = new float[size];
            for (int i5 = 0; i5 < size; i5++) {
                this.f9615a[i5] = list.get(i5).intValue();
                this.f9616b[i5] = list2.get(i5).floatValue();
            }
        }

        a(int i5, int i6) {
            this.f9615a = new int[]{i5, i6};
            this.f9616b = new float[]{0.0f, 1.0f};
        }

        a(int i5, int i6, int i7) {
            this.f9615a = new int[]{i5, i6, i7};
            this.f9616b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
