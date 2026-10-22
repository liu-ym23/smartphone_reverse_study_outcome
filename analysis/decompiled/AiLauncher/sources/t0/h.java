package t0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.CancellationSignal;
import android.os.Handler;
import java.util.List;
import o1.C4996a;
import s0.e;
import s0.h;
import y0.g;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final k f41986a;

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.collection.l<String, Typeface> f41987b;

    /* renamed from: c, reason: collision with root package name */
    public static Paint f41988c;

    public static class a extends g.c {

        /* renamed from: a, reason: collision with root package name */
        public h.f f41989a;

        public a(h.f fVar) {
            this.f41989a = fVar;
        }

        @Override // y0.g.c
        public void a(int i10) {
            h.f fVar = this.f41989a;
            if (fVar != null) {
                fVar.f(i10);
            }
        }

        @Override // y0.g.c
        public void b(Typeface typeface) {
            h.f fVar = this.f41989a;
            if (fVar != null) {
                fVar.g(typeface);
            }
        }
    }

    static {
        C4996a.a("TypefaceCompat static init");
        f41986a = new j();
        f41987b = new androidx.collection.l<>(16);
        f41988c = null;
        C4996a.b();
    }

    public static Typeface a(Context context, Typeface typeface, int i10) {
        if (context != null) {
            return Typeface.create(typeface, i10);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i10) {
        C4996a.a("TypefaceCompat.createFromFontInfo");
        try {
            return f41986a.b(context, cancellationSignal, bVarArr, i10);
        } finally {
            C4996a.b();
        }
    }

    public static Typeface c(Context context, CancellationSignal cancellationSignal, List<g.b[]> list, int i10) {
        C4996a.a("TypefaceCompat.createFromFontInfoWithFallback");
        try {
            return f41986a.c(context, cancellationSignal, list, i10);
        } finally {
            C4996a.b();
        }
    }

    public static Typeface d(Context context, e.b bVar, Resources resources, int i10, String str, int i11, int i12, h.f fVar, Handler handler, boolean z10) {
        Typeface typefaceA;
        if (bVar instanceof e.C0519e) {
            e.C0519e c0519e = (e.C0519e) bVar;
            Typeface typefaceI = i(c0519e);
            if (typefaceI != null) {
                if (fVar != null) {
                    fVar.d(typefaceI, handler);
                }
                f41987b.put(f(resources, i10, str, i11, i12), typefaceI);
                return typefaceI;
            }
            typefaceA = y0.g.c(context, c0519e.b(), i12, !z10 ? fVar != null : c0519e.a() != 0, z10 ? c0519e.d() : -1, h.f.e(handler), new a(fVar));
        } else {
            typefaceA = f41986a.a(context, (e.c) bVar, resources, i12);
            if (fVar != null) {
                if (typefaceA != null) {
                    fVar.d(typefaceA, handler);
                } else {
                    fVar.c(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f41987b.put(f(resources, i10, str, i11, i12), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface e(Context context, Resources resources, int i10, String str, int i11, int i12) {
        Typeface typefaceD = f41986a.d(context, resources, i10, str, i12);
        if (typefaceD != null) {
            f41987b.put(f(resources, i10, str, i11, i12), typefaceD);
        }
        return typefaceD;
    }

    public static String f(Resources resources, int i10, String str, int i11, int i12) {
        return resources.getResourcePackageName(i10) + '-' + str + '-' + i11 + '-' + i10 + '-' + i12;
    }

    public static Typeface g(Resources resources, int i10, String str, int i11, int i12) {
        return f41987b.get(f(resources, i10, str, i11, i12));
    }

    public static Typeface h(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e3, code lost:
    
        return r0.build();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface i(s0.e.C0519e r9) {
        /*
            java.lang.String r0 = r9.c()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L11
            android.graphics.Typeface r0 = h(r0)
            if (r0 == 0) goto L11
            return r0
        L11:
            java.util.List r9 = r9.b()
            int r0 = r9.size()
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L2c
            java.lang.Object r9 = r9.get(r1)
            y0.e r9 = (y0.e) r9
            java.lang.String r9 = r9.h()
            android.graphics.Typeface r9 = h(r9)
            return r9
        L2c:
            r0 = r1
        L2d:
            int r3 = r9.size()
            r4 = 0
            if (r0 >= r3) goto L48
            java.lang.Object r3 = r9.get(r0)
            y0.e r3 = (y0.e) r3
            java.lang.String r3 = r3.h()
            android.graphics.Typeface r3 = h(r3)
            if (r3 != 0) goto L45
            return r4
        L45:
            int r0 = r0 + 1
            goto L2d
        L48:
            r0 = r4
        L49:
            int r3 = r9.size()
            if (r1 >= r3) goto Ldf
            java.lang.Object r3 = r9.get(r1)
            y0.e r3 = (y0.e) r3
            int r5 = r9.size()
            int r5 = r5 - r2
            if (r1 != r5) goto L6e
            java.lang.String r5 = r3.i()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L6e
            java.lang.String r9 = r3.h()
            r0.setSystemFallback(r9)
            goto Ldf
        L6e:
            java.lang.String r5 = r3.h()
            android.graphics.Typeface r5 = h(r5)
            android.graphics.fonts.Font r5 = j(r5)
            java.lang.String r6 = "TypefaceCompat"
            if (r5 != 0) goto L9c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Unable identify the primary font for "
            r9.append(r0)
            java.lang.String r0 = r3.h()
            r9.append(r0)
            java.lang.String r0 = ". Falling back to provider font."
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            android.util.Log.w(r6, r9)
            return r4
        L9c:
            java.lang.String r7 = r3.i()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto Lc7
            android.graphics.fonts.FontFamily$Builder r7 = new android.graphics.fonts.FontFamily$Builder     // Catch: java.io.IOException -> Lc1
            android.graphics.fonts.Font$Builder r8 = new android.graphics.fonts.Font$Builder     // Catch: java.io.IOException -> Lc1
            r8.<init>(r5)     // Catch: java.io.IOException -> Lc1
            java.lang.String r3 = r3.i()     // Catch: java.io.IOException -> Lc1
            android.graphics.fonts.Font$Builder r3 = r8.setFontVariationSettings(r3)     // Catch: java.io.IOException -> Lc1
            android.graphics.fonts.Font r3 = r3.build()     // Catch: java.io.IOException -> Lc1
            r7.<init>(r3)     // Catch: java.io.IOException -> Lc1
            android.graphics.fonts.FontFamily r3 = r7.build()     // Catch: java.io.IOException -> Lc1
            goto Ld0
        Lc1:
            java.lang.String r9 = "Failed to clone Font instance. Fall back to provider font."
            android.util.Log.e(r6, r9)
            return r4
        Lc7:
            android.graphics.fonts.FontFamily$Builder r3 = new android.graphics.fonts.FontFamily$Builder
            r3.<init>(r5)
            android.graphics.fonts.FontFamily r3 = r3.build()
        Ld0:
            if (r0 != 0) goto Ld8
            android.graphics.Typeface$CustomFallbackBuilder r0 = new android.graphics.Typeface$CustomFallbackBuilder
            r0.<init>(r3)
            goto Ldb
        Ld8:
            r0.addCustomFallback(r3)
        Ldb:
            int r1 = r1 + 1
            goto L49
        Ldf:
            android.graphics.Typeface r9 = r0.build()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.h.i(s0.e$e):android.graphics.Typeface");
    }

    public static Font j(Typeface typeface) {
        if (f41988c == null) {
            f41988c = new Paint();
        }
        f41988c.setTextSize(10.0f);
        f41988c.setTypeface(typeface);
        PositionedGlyphs positionedGlyphsShapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f, 0.0f, false, f41988c);
        if (positionedGlyphsShapeTextRun.glyphCount() == 0) {
            return null;
        }
        return positionedGlyphsShapeTextRun.getFont(0);
    }
}
