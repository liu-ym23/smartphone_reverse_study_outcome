package H4;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"LH4/a;", "", "<init>", "()V", "", "color", "", "cornerRadiusPx", "Landroid/graphics/drawable/Drawable;", Const.INTENT_KEY_APIKEY, "(IF)Landroid/graphics/drawable/Drawable;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a {
    public static final a INSTANCE = new a();

    public final Drawable a(int color, float cornerRadiusPx) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(cornerRadiusPx);
        return gradientDrawable;
    }
}
