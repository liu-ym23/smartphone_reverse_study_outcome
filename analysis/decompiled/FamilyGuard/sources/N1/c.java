package N1;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.util.Log;
import android.util.SparseArray;
import java.io.IOException;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray<Typeface> f4189a = new SparseArray<>();

    private static Typeface a(Context context, String str, int i5) {
        try {
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(context.getAssets(), str).build()).build()).setStyle(new FontStyle(i5, 0)).build();
        } catch (IOException e6) {
            Log.e("FontLoader", "has an error:" + e6);
            return Typeface.createFromAsset(context.getAssets(), str);
        }
    }

    public static Typeface b(Context context, String str, int i5) {
        SparseArray<Typeface> sparseArray = f4189a;
        if (sparseArray.get(i5) != null) {
            return sparseArray.get(i5);
        }
        Typeface typefaceA = a(context, str, i5);
        sparseArray.put(i5, typefaceA);
        return typefaceA;
    }

    public static int c(int i5) {
        if (i5 < 150) {
            return 100;
        }
        if (i5 < 250) {
            return 200;
        }
        if (i5 < 350) {
            return 300;
        }
        if (i5 < 450) {
            return 400;
        }
        if (i5 < 550) {
            return 500;
        }
        if (i5 < 650) {
            return 600;
        }
        if (i5 < 750) {
            return 700;
        }
        return i5 < 850 ? 800 : 900;
    }
}
