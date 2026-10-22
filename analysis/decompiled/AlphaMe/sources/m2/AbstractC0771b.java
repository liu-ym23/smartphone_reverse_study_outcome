package m2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: m2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0771b {

    /* renamed from: a, reason: collision with root package name */
    public static final Bitmap.Config f13562a = Bitmap.Config.ARGB_8888;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f13563b = {-148165, -435152, -1169103, -10464278, -14315542, -14565170, -12402834};

    /* renamed from: c, reason: collision with root package name */
    public static Method f13564c;

    public static Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            boolean z4 = drawable instanceof ColorDrawable;
            Bitmap.Config config = f13562a;
            return z4 ? Bitmap.createBitmap(2, 2, config) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), config);
        } catch (OutOfMemoryError unused) {
            Log.e("ContactHeaderUtils ", "getBitmapFromDrawable  OutOfMemoryError !");
            return null;
        }
    }

    public static int b(String str) {
        int i4 = 0;
        while (Pattern.compile("[一-龥]").matcher(str).find()) {
            i4++;
        }
        return i4;
    }

    public static int c(String str) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        int[] iArr = f13563b;
        int iAbs = !zIsEmpty ? Math.abs(str.hashCode()) % iArr.length : 5;
        if (iAbs < iArr.length) {
            return iArr[iAbs];
        }
        return -11227562;
    }

    public static String d(String str) {
        Matcher matcher = Pattern.compile("\\b[a-zA-Z]").matcher(Pattern.compile("\\d").matcher(str).replaceAll(AwarenessDataItem.PERMISSION_SPLITTER));
        String strP = "";
        while (matcher.find()) {
            strP = AbstractC0351g.p(strP, matcher.group());
        }
        return strP.toUpperCase();
    }
}
