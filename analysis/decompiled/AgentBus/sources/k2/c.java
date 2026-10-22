package k2;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import h4.n;
import java.io.IOException;
import java.util.Objects;
import m2.d;

/* loaded from: classes.dex */
public final class c extends n {
    @Override // h4.n
    public final Font o(d dVar) {
        Font fontB;
        Uri uri = dVar.f6141a;
        boolean zEquals = Objects.equals(uri.getScheme(), "systemfont");
        String str = dVar.f6145e;
        String authority = zEquals ? uri.getAuthority() : null;
        if (authority != null) {
            Typeface typefaceCreate = Typeface.create(authority, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
                typefaceCreate = null;
            }
            if (typefaceCreate != null && (fontB = b.b(typefaceCreate)) != null) {
                if (TextUtils.isEmpty(str)) {
                    return fontB;
                }
                try {
                    return new Font.Builder(fontB).setFontVariationSettings(str).build();
                } catch (IOException unused) {
                    Log.e("TypefaceCompatApi31Impl", "Failed to clone Font instance. Fall back to provider font.");
                    return null;
                }
            }
        }
        return null;
    }
}
