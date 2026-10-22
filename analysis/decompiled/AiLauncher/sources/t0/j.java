package t0;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import y0.g;

/* loaded from: classes.dex */
public class j extends i {
    public static Typeface k(String str) {
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }

    @Override // t0.i
    public Font i(g.b bVar) {
        Typeface typefaceK;
        Font fontJ;
        String strC = bVar.c();
        if (strC == null || (typefaceK = k(strC)) == null || (fontJ = h.j(typefaceK)) == null) {
            return null;
        }
        if (TextUtils.isEmpty(bVar.f())) {
            return fontJ;
        }
        try {
            return new Font.Builder(fontJ).setFontVariationSettings(bVar.f()).build();
        } catch (IOException unused) {
            Log.e("TypefaceCompatApi31Impl", "Failed to clone Font instance. Fall back to provider font.");
            return null;
        }
    }
}
