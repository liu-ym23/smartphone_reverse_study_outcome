package g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f2814b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static r f2815c;

    /* renamed from: a, reason: collision with root package name */
    public l1 f2816a;

    public static synchronized PorterDuffColorFilter b(int i8, PorterDuff.Mode mode) {
        return l1.e(i8, mode);
    }

    public static synchronized void c() {
        if (f2815c == null) {
            r rVar = new r();
            f2815c = rVar;
            rVar.f2816a = l1.b();
            l1 l1Var = f2815c.f2816a;
            f2.p pVar = new f2.p(1);
            synchronized (l1Var) {
                l1Var.f2777e = pVar;
            }
        }
    }

    public static void d(Drawable drawable, s1 s1Var, int[] iArr) {
        PorterDuff.Mode mode = l1.f2771f;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = s1Var.f2823b;
        if (!z && !s1Var.f2822a) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilterE = null;
        ColorStateList colorStateList = z ? (ColorStateList) s1Var.f2824c : null;
        PorterDuff.Mode mode2 = s1Var.f2822a ? (PorterDuff.Mode) s1Var.d : l1.f2771f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilterE = l1.e(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilterE);
    }

    public final synchronized Drawable a(Context context, int i8) {
        return this.f2816a.c(context, i8);
    }
}
