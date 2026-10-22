package s5;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v5.C5659a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000e8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Ls5/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "selected", "Landroid/graphics/drawable/Drawable;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Z)Landroid/graphics/drawable/Drawable;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)V", "", "color", "", "cornerPx", "Landroid/graphics/drawable/GradientDrawable;", Const.INTENT_KEY_UMID, "(IF)Landroid/graphics/drawable/GradientDrawable;", "", "SELECTED_BG_COLOR_HEX", "Ljava/lang/String;", "UNSELECTED_BG_COLOR_HEX", "CORNER_RADIUS_DP", "I", "FOREGROUND_COLOR", "c", "()I", "cachedSelected", "Landroid/graphics/drawable/GradientDrawable;", "cachedUnselected", "cachedDensity", "F", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: s5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5444a {
    private static final int CORNER_RADIUS_DP = 8;
    private static final String SELECTED_BG_COLOR_HEX = "#206CFF";
    private static final String UNSELECTED_BG_COLOR_HEX = "#1FFFFFFF";
    private static float cachedDensity;
    private static GradientDrawable cachedSelected;
    private static GradientDrawable cachedUnselected;
    public static final C5444a INSTANCE = new C5444a();
    private static final int FOREGROUND_COLOR = -1;

    public final Drawable a(Context context, boolean selected) {
        p.i(context, "context");
        b(context);
        GradientDrawable gradientDrawable = selected ? cachedSelected : cachedUnselected;
        p.f(gradientDrawable);
        return gradientDrawable;
    }

    public final void b(Context context) {
        float f10 = context.getResources().getDisplayMetrics().density;
        if (cachedSelected == null || cachedUnselected == null || cachedDensity != f10) {
            cachedDensity = f10;
            float fA = C5659a.INSTANCE.a(context, 8);
            cachedSelected = d(Color.parseColor(SELECTED_BG_COLOR_HEX), fA);
            cachedUnselected = d(Color.parseColor(UNSELECTED_BG_COLOR_HEX), fA);
        }
    }

    public final int c() {
        return FOREGROUND_COLOR;
    }

    public final GradientDrawable d(int color, float cornerPx) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(cornerPx);
        gradientDrawable.setColor(color);
        return gradientDrawable;
    }
}
