package E;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;
import com.stepos.alphame.awareness.AwarenessDataItem;

/* loaded from: classes.dex */
public abstract class c {
    @Nullable
    @DoNotInline
    public static Uri a(@NonNull Object obj) {
        return e.d(obj);
    }

    @DoNotInline
    public static Drawable b(Icon icon, Context context) {
        return icon.loadDrawable(context);
    }

    @DoNotInline
    public static Icon c(IconCompat iconCompat, Context context) {
        Icon iconCreateWithBitmap;
        String strB;
        Uri uriA;
        int i4 = iconCompat.f3314a;
        switch (i4) {
            case -1:
                return (Icon) iconCompat.f3315b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f3315b);
                break;
            case 2:
                if (i4 == -1) {
                    strB = e.b(iconCompat.f3315b);
                } else {
                    if (i4 != 2) {
                        throw new IllegalStateException("called getResPackage() on " + iconCompat);
                    }
                    String str = iconCompat.f3323j;
                    strB = (str == null || TextUtils.isEmpty(str)) ? ((String) iconCompat.f3315b).split(AwarenessDataItem.USERID_SPLITTER, -1)[0] : iconCompat.f3323j;
                }
                iconCreateWithBitmap = Icon.createWithResource(strB, iconCompat.f3318e);
                break;
            case 3:
                iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f3315b, iconCompat.f3318e, iconCompat.f3319f);
                break;
            case 4:
                iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f3315b);
                break;
            case 5:
                iconCreateWithBitmap = d.b((Bitmap) iconCompat.f3315b);
                break;
            case 6:
                if (i4 == -1) {
                    uriA = a(iconCompat.f3315b);
                } else {
                    if (i4 != 4 && i4 != 6) {
                        throw new IllegalStateException("called getUri() on " + iconCompat);
                    }
                    uriA = Uri.parse((String) iconCompat.f3315b);
                }
                iconCreateWithBitmap = f.a(uriA);
                break;
        }
        ColorStateList colorStateList = iconCompat.f3320g;
        if (colorStateList != null) {
            iconCreateWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = iconCompat.f3321h;
        if (mode != IconCompat.f3313k) {
            iconCreateWithBitmap.setTintMode(mode);
        }
        return iconCreateWithBitmap;
    }
}
