package O6;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.util.Log;
import android.util.SparseArray;
import java.io.IOException;

/* loaded from: classes3.dex */
public class g {
    private static final String TAG = "FontLoader";
    private static final int WEIGHT_BLACK = 900;
    private static final int WEIGHT_BOLD = 700;
    private static final int WEIGHT_DIVIDER = 50;
    private static final int WEIGHT_EXTRA_BOLD = 800;
    public static final int WEIGHT_EXTRA_LIGHT = 200;
    public static final int WEIGHT_LIGHT = 300;
    private static final int WEIGHT_MEDIUM = 500;
    private static final int WEIGHT_REGULAR = 400;
    private static final int WEIGHT_SEMI_BOLD = 600;
    public static final int WEIGHT_THIN = 100;
    private static final SparseArray<Typeface> typefaceArray = new SparseArray<>();

    public static Typeface a(Context context, String str, int i10) {
        try {
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(context.getAssets(), str).build()).build()).setStyle(new FontStyle(i10, 0)).build();
        } catch (IOException e10) {
            Log.e(TAG, "has an error:" + e10);
            return Typeface.createFromAsset(context.getAssets(), str);
        }
    }

    public static Typeface b(Context context, String str, int i10) {
        SparseArray<Typeface> sparseArray = typefaceArray;
        if (sparseArray.get(i10) != null) {
            return sparseArray.get(i10);
        }
        Typeface typefaceA = a(context, str, i10);
        sparseArray.put(i10, typefaceA);
        return typefaceA;
    }

    public static int c(int i10) {
        if (i10 < 150) {
            return 100;
        }
        if (i10 < 250) {
            return 200;
        }
        if (i10 < 350) {
            return 300;
        }
        if (i10 < 450) {
            return 400;
        }
        if (i10 < 550) {
            return 500;
        }
        return i10 < 650 ? WEIGHT_SEMI_BOLD : i10 < 750 ? WEIGHT_BOLD : i10 < 850 ? WEIGHT_EXTRA_BOLD : WEIGHT_BLACK;
    }
}
