package f3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Trace;
import android.util.Log;
import com.stepos.statsrpk.h;
import f7.f;
import java.util.concurrent.ConcurrentHashMap;
import p.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final f f3906a;

    /* renamed from: b, reason: collision with root package name */
    public static final p f3907b;

    /* renamed from: c, reason: collision with root package name */
    public static Paint f3908c;

    static {
        Trace.beginSection(h.J("TypefaceCompat static init"));
        f fVar = new f(29);
        new ConcurrentHashMap();
        f3906a = fVar;
        f3907b = new p(16);
        f3908c = null;
        Trace.endSection();
    }

    public static Typeface a(Context context, k3.h[] hVarArr, int i) {
        Trace.beginSection(h.J("TypefaceCompat.createFromFontInfo"));
        try {
            f3906a.getClass();
            Typeface typefaceBuild = null;
            try {
                FontFamily fontFamilyM = f.m(hVarArr, context.getContentResolver());
                if (fontFamilyM != null) {
                    typefaceBuild = new Typeface.CustomFallbackBuilder(fontFamilyM).setStyle(f.j(fontFamilyM, i).getStyle()).build();
                }
            } catch (Exception e10) {
                Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
            }
            return typefaceBuild;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d6, code lost:
    
        r6 = r9.build();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface b(android.content.Context r14, e3.d r15, android.content.res.Resources r16, int r17, java.lang.String r18, int r19, int r20, m.o0 r21, boolean r22) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 732
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.d.b(android.content.Context, e3.d, android.content.res.Resources, int, java.lang.String, int, int, m.o0, boolean):android.graphics.Typeface");
    }

    public static Typeface c(Resources resources, int i, String str, int i3, int i10) {
        Typeface typefaceBuild;
        f3906a.getClass();
        try {
            Font fontBuild = new Font.Builder(resources, i).build();
            typefaceBuild = new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception e10) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
            typefaceBuild = null;
        }
        if (typefaceBuild != null) {
            f3907b.c(d(resources, i, str, i3, i10), typefaceBuild);
        }
        return typefaceBuild;
    }

    public static String d(Resources resources, int i, String str, int i3, int i10) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i3 + '-' + i + '-' + i10;
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
        if (f3908c == null) {
            f3908c = new Paint();
        }
        f3908c.setTextSize(10.0f);
        f3908c.setTypeface(typeface);
        PositionedGlyphs positionedGlyphsShapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f, 0.0f, false, f3908c);
        if (positionedGlyphsShapeTextRun.glyphCount() == 0) {
            return null;
        }
        return positionedGlyphsShapeTextRun.getFont(0);
    }
}
