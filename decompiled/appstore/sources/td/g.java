package td;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.ArrayMap;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f24800a = null;

    static {
        f24800a = new g();
    }

    public g() {
    }

    public final void a(VectorDrawable r10, String r11, int r12) {
        Field r13 = VectorDrawable.class.getDeclaredField("mVectorState");
        r13.setAccessible(true);
        Object r14 = r13.get(r10);
        Field r15 = r14.getClass().getDeclaredField("mVGTargetsMap");
        r15.setAccessible(true);
        Object r16 = r15.get(r14);
        if (r16 == null) goto L15;
        Object r17 = ((ArrayMap) r16).get(r11);
        if (r17 != null) goto L7;
        return;
    L7:
        if (q.b(r17.getClass().getSimpleName(), "VFullPath") == false) goto L16;
        Field r18 = Class.forName("android.graphics.drawable.VectorDrawable$VFullPath").getDeclaredField("mNativePtr");
        r18.setAccessible(true);
        Object r19 = r18.get(r17);
        if (r19 == null) goto L12;
        Method r20 = Class.forName("android.graphics.drawable.VectorDrawable").getDeclaredMethod("nSetFillColor", new Class[]{Long.TYPE, Integer.TYPE});
        r20.setAccessible(true);
        r20.invoke(null, new Object[]{(Long) r19, Integer.valueOf(r12)});
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L16:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.util.ArrayMap<kotlin.String, kotlin.Any>");
    }

    public final void b(AnimatedVectorDrawable r10, String r11, int r12) {
        Field r13 = AnimatedVectorDrawable.class.getDeclaredField("mAnimatedVectorState");
        r13.setAccessible(true);
        Object r14 = r13.get(r10);
        Field r15 = r14.getClass().getDeclaredField("mVectorDrawable");
        if (r15 == null) goto L16;
        r15.setAccessible(true);
        c r16 = c.f24796a;
        Object r17 = r15.get(r14);
        if (r17 != null) goto L8;
    L6:
        r17 = null;
    L9:
        VectorDrawable r18 = (VectorDrawable) r17;
        if (r18 == null) goto L14;
        a(r18, r11, r12);
        return;
    L14:
        throw new IllegalStateException("mVectorDrawable is null");
    L8:
        if ((r17 instanceof VectorDrawable) == false) goto L6;
    L16:
        throw new IllegalStateException("mVectorDrawable Field is null");
    }

    public final void c(StateListDrawable r10, String r11, int r12) {
        q.g(r10, "drawable");
        q.g(r11, "pathName");
        int r13 = r10.getStateCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L11;
        int r15 = r14 + 1;
        Drawable r16 = r10.getStateDrawable(r14);
        if ((r16 instanceof VectorDrawable) == false) goto L8;
        d((VectorDrawable) r16, r11, r12);
    L10:
        r14 = r15;
        goto L3
    L8:
        if ((r16 instanceof AnimatedVectorDrawable) == false) goto L10;
        e((AnimatedVectorDrawable) r16, r11, r12);
        goto L10
    }

    public final void d(VectorDrawable r10, String r11, int r12) {
        a(r10, r11, r12);     // Catch: Exception -> L4
        r10.invalidateSelf();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("VectorBreaker", "Color injection failed", e);
    }

    public final void e(AnimatedVectorDrawable r10, String r11, int r12) {
        b(r10, r11, r12);     // Catch: Exception -> L4
        r10.invalidateSelf();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("VectorBreaker", "setPathColor2, Color injection failed", e);
    }
}
