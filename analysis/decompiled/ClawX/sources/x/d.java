package x;

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
import b0.k;
import j.i;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final e f6237a;

    /* renamed from: b, reason: collision with root package name */
    public static final i f6238b;

    /* renamed from: c, reason: collision with root package name */
    public static Paint f6239c;

    static {
        e.k("TypefaceCompat static init");
        e eVar = new e();
        new ConcurrentHashMap();
        f6237a = eVar;
        f6238b = new i(16);
        f6239c = null;
        Trace.endSection();
    }

    public static Typeface a(Context context, k[] kVarArr, int i8) {
        e.k("TypefaceCompat.createFromFontInfo");
        try {
            e eVar = f6237a;
            eVar.getClass();
            Typeface typefaceBuild = null;
            try {
                FontFamily fontFamilyL = eVar.L(kVarArr, context.getContentResolver());
                if (fontFamilyL != null) {
                    typefaceBuild = new Typeface.CustomFallbackBuilder(fontFamilyL).setStyle(e.F(fontFamilyL, i8).getStyle()).build();
                }
            } catch (Exception e9) {
                Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
            }
            return typefaceBuild;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d8, code lost:
    
        r5 = r10.build();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface b(android.content.Context r16, w.d r17, android.content.res.Resources r18, int r19, java.lang.String r20, int r21, int r22, w.b r23, boolean r24) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 712
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.d.b(android.content.Context, w.d, android.content.res.Resources, int, java.lang.String, int, int, w.b, boolean):android.graphics.Typeface");
    }

    public static Typeface c(Resources resources, int i8, String str, int i9, int i10) throws IOException {
        Typeface typefaceBuild;
        f6237a.getClass();
        try {
            Font fontBuild = new Font.Builder(resources, i8).build();
            typefaceBuild = new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception e9) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
            typefaceBuild = null;
        }
        if (typefaceBuild != null) {
            f6238b.f(d(resources, i8, str, i9, i10), typefaceBuild);
        }
        return typefaceBuild;
    }

    public static String d(Resources resources, int i8, String str, int i9, int i10) {
        return resources.getResourcePackageName(i8) + '-' + str + '-' + i9 + '-' + i8 + '-' + i10;
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
        if (f6239c == null) {
            f6239c = new Paint();
        }
        f6239c.setTextSize(10.0f);
        f6239c.setTypeface(typeface);
        PositionedGlyphs positionedGlyphsShapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f, 0.0f, false, f6239c);
        if (positionedGlyphsShapeTextRun.glyphCount() == 0) {
            return null;
        }
        return positionedGlyphsShapeTextRun.getFont(0);
    }
}
