package n0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import m0.f;
import s0.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final f f10595a;

    /* renamed from: b, reason: collision with root package name */
    public static final p.g<String, Typeface> f10596b;

    /* renamed from: c, reason: collision with root package name */
    public static Paint f10597c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends jd.b {

        /* renamed from: c, reason: collision with root package name */
        public f.c f10598c;
    }

    static {
        Trace.beginSection(c2.a.a("TypefaceCompat static init"));
        if (Build.VERSION.SDK_INT >= 31) {
            f10595a = new g();
        } else {
            f10595a = new f();
        }
        f10596b = new p.g<>(16);
        f10597c = null;
        Trace.endSection();
    }

    public static Typeface a(Context context, l[] lVarArr, int i10) {
        Trace.beginSection(c2.a.a("TypefaceCompat.createFromFontInfo"));
        try {
            f fVar = f10595a;
            fVar.getClass();
            Typeface typefaceBuild = null;
            try {
                FontFamily fontFamilyC = fVar.c(lVarArr, context.getContentResolver());
                if (fontFamilyC != null) {
                    typefaceBuild = new Typeface.CustomFallbackBuilder(fontFamilyC).setStyle(f.b(fontFamilyC, i10).getStyle()).build();
                }
            } catch (Exception e10) {
                Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
            }
            return typefaceBuild;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e3, code lost:
    
        r9 = r12.build();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface b(android.content.Context r16, m0.e.a r17, android.content.res.Resources r18, int r19, java.lang.String r20, int r21, int r22, m0.f.c r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 709
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.e.b(android.content.Context, m0.e$a, android.content.res.Resources, int, java.lang.String, int, int, m0.f$c, boolean):android.graphics.Typeface");
    }

    public static Typeface c(Resources resources, int i10, String str, int i11, int i12) {
        Typeface typefaceBuild;
        f10595a.getClass();
        try {
            Font fontBuild = new Font.Builder(resources, i10).build();
            typefaceBuild = new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception e10) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
            typefaceBuild = null;
        }
        if (typefaceBuild != null) {
            f10596b.b(d(resources, i10, str, i11, i12), typefaceBuild);
        }
        return typefaceBuild;
    }

    public static String d(Resources resources, int i10, String str, int i11, int i12) {
        return resources.getResourcePackageName(i10) + '-' + str + '-' + i11 + '-' + i10 + '-' + i12;
    }

    public static Typeface e(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }

    public static Font f(Typeface typeface) {
        if (f10597c == null) {
            f10597c = new Paint();
        }
        f10597c.setTextSize(10.0f);
        f10597c.setTypeface(typeface);
        PositionedGlyphs positionedGlyphsShapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f, 0.0f, false, f10597c);
        if (positionedGlyphsShapeTextRun.glyphCount() == 0) {
            return null;
        }
        return positionedGlyphsShapeTextRun.getFont(0);
    }
}
