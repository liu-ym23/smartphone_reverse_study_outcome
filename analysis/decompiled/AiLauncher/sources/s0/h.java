package s0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f40030a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<e, SparseArray<d>> f40031b = new WeakHashMap<>(0);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f40032c = new Object();

    public static class a {
        public static Drawable a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getDrawable(i10, theme);
        }

        public static Drawable b(Resources resources, int i10, int i11, Resources.Theme theme) {
            return resources.getDrawableForDensity(i10, i11, theme);
        }
    }

    public static class b {
        public static ColorStateList a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColorStateList(i10, theme);
        }
    }

    public static class c {
        public static float a(Resources resources, int i10) {
            return resources.getFloat(i10);
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final ColorStateList f40033a;

        /* renamed from: b, reason: collision with root package name */
        public final Configuration f40034b;

        /* renamed from: c, reason: collision with root package name */
        public final int f40035c;

        public d(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f40033a = colorStateList;
            this.f40034b = configuration;
            this.f40035c = theme == null ? 0 : theme.hashCode();
        }
    }

    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f40036a;

        /* renamed from: b, reason: collision with root package name */
        public final Resources.Theme f40037b;

        public e(Resources resources, Resources.Theme theme) {
            this.f40036a = resources;
            this.f40037b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && e.class == obj.getClass()) {
                e eVar = (e) obj;
                if (this.f40036a.equals(eVar.f40036a) && B0.c.a(this.f40037b, eVar.f40037b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return B0.c.b(this.f40036a, this.f40037b);
        }
    }

    public static abstract class f {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(final int i10, Handler handler) {
            e(handler).post(new Runnable() { // from class: s0.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f40040a.f(i10);
                }
            });
        }

        public final void d(final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: s0.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f40038a.g(typeface);
                }
            });
        }

        public abstract void f(int i10);

        public abstract void g(Typeface typeface);
    }

    public static final class g {

        public static class a {
            public static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            a.a(theme);
        }
    }

    public static void a(e eVar, int i10, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f40032c) {
            try {
                WeakHashMap<e, SparseArray<d>> weakHashMap = f40031b;
                SparseArray<d> sparseArray = weakHashMap.get(eVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                    weakHashMap.put(eVar, sparseArray);
                }
                sparseArray.append(i10, new d(colorStateList, eVar.f40036a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2.f40035c == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList b(s0.h.e r5, int r6) {
        /*
            java.lang.Object r0 = s0.h.f40032c
            monitor-enter(r0)
            java.util.WeakHashMap<s0.h$e, android.util.SparseArray<s0.h$d>> r1 = s0.h.f40031b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            s0.h$d r2 = (s0.h.d) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.f40034b     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.f40036a     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.f40037b     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.f40035c     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.f40035c     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.f40033a     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return r5
        L42:
            r1.remove(r6)     // Catch: java.lang.Throwable -> L32
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r5 = 0
            return r5
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.h.b(s0.h$e, int):android.content.res.ColorStateList");
    }

    public static Typeface c(Context context, int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i10, new TypedValue(), 0, null, null, false, true);
    }

    public static ColorStateList d(Resources resources, int i10, Resources.Theme theme) throws Resources.NotFoundException {
        e eVar = new e(resources, theme);
        ColorStateList colorStateListB = b(eVar, i10);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListL = l(resources, i10, theme);
        if (colorStateListL == null) {
            return b.a(resources, i10, theme);
        }
        a(eVar, i10, colorStateListL, theme);
        return colorStateListL;
    }

    public static Drawable e(Resources resources, int i10, Resources.Theme theme) throws Resources.NotFoundException {
        return a.a(resources, i10, theme);
    }

    public static Drawable f(Resources resources, int i10, int i11, Resources.Theme theme) throws Resources.NotFoundException {
        return a.b(resources, i10, i11, theme);
    }

    public static float g(Resources resources, int i10) {
        return c.a(resources, i10);
    }

    public static Typeface h(Context context, int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i10, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface i(Context context, int i10, TypedValue typedValue, int i11, f fVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i10, typedValue, i11, fVar, null, true, false);
    }

    public static void j(Context context, int i10, f fVar, Handler handler) throws Resources.NotFoundException {
        B0.h.f(fVar);
        if (context.isRestricted()) {
            fVar.c(-4, handler);
        } else {
            n(context, i10, new TypedValue(), 0, fVar, handler, false, false);
        }
    }

    public static TypedValue k() {
        ThreadLocal<TypedValue> threadLocal = f40030a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList l(Resources resources, int i10, Resources.Theme theme) {
        if (m(resources, i10)) {
            return null;
        }
        try {
            return s0.c.a(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e10);
            return null;
        }
    }

    public static boolean m(Resources resources, int i10) throws Resources.NotFoundException {
        TypedValue typedValueK = k();
        resources.getValue(i10, typedValueK, true);
        int i11 = typedValueK.type;
        return i11 >= 28 && i11 <= 31;
    }

    public static Typeface n(Context context, int i10, TypedValue typedValue, int i11, f fVar, Handler handler, boolean z10, boolean z11) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        Typeface typefaceO = o(context, resources, typedValue, i10, i11, fVar, handler, z10, z11);
        if (typefaceO != null || fVar != null || z11) {
            return typefaceO;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i10) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface o(android.content.Context r13, android.content.res.Resources r14, android.util.TypedValue r15, int r16, int r17, s0.h.f r18, android.os.Handler r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.h.o(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, s0.h$f, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
