package M0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.h;
import h.C0744a;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f3993a = true;

    public static Drawable a(Context context, int i5, Resources.Theme theme) {
        return c(context, context, i5, theme);
    }

    public static Drawable b(Context context, Context context2, int i5) {
        return c(context, context2, i5, null);
    }

    private static Drawable c(Context context, Context context2, int i5, Resources.Theme theme) {
        try {
            if (f3993a) {
                return e(context2, i5, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e6) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e6;
            }
            return androidx.core.content.a.e(context2, i5);
        } catch (NoClassDefFoundError unused2) {
            f3993a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i5, theme);
    }

    private static Drawable d(Context context, int i5, Resources.Theme theme) {
        return h.f(context.getResources(), i5, theme);
    }

    private static Drawable e(Context context, int i5, Resources.Theme theme) {
        if (theme != null) {
            context = new androidx.appcompat.view.d(context, theme);
        }
        return C0744a.b(context, i5);
    }
}
