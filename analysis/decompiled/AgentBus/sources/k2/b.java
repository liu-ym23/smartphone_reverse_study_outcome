package k2;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.lifecycle.s0;
import h4.n;
import m2.d;
import nb.i;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final n f5579a;

    /* renamed from: b, reason: collision with root package name */
    public static Paint f5580b;

    static {
        i.f("TypefaceCompat static init");
        if (Build.VERSION.SDK_INT >= 31) {
            f5579a = new c(4);
        } else {
            f5579a = new n(4);
        }
        new s0(2);
        f5580b = null;
        Trace.endSection();
    }

    public static Typeface a(Context context, d[] dVarArr) {
        i.f("TypefaceCompat.createFromFontInfo");
        try {
            n nVar = f5579a;
            nVar.getClass();
            Typeface typefaceBuild = null;
            try {
                FontFamily fontFamilyN = nVar.n(dVarArr, context.getContentResolver());
                if (fontFamilyN != null) {
                    typefaceBuild = new Typeface.CustomFallbackBuilder(fontFamilyN).setStyle(n.k(fontFamilyN).getStyle()).build();
                }
            } catch (Exception e10) {
                Log.w("TypefaceCompatApi29Impl", "Font load failed", e10);
            }
            return typefaceBuild;
        } finally {
            Trace.endSection();
        }
    }

    public static Font b(Typeface typeface) {
        if (f5580b == null) {
            f5580b = new Paint();
        }
        f5580b.setTextSize(10.0f);
        f5580b.setTypeface(typeface);
        PositionedGlyphs positionedGlyphsShapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f, 0.0f, false, f5580b);
        if (positionedGlyphsShapeTextRun.glyphCount() == 0) {
            return null;
        }
        return positionedGlyphsShapeTextRun.getFont(0);
    }
}
