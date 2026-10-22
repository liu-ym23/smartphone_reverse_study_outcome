package androidx.core.content.res;

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
    private static final ThreadLocal<TypedValue> f9617a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<d, SparseArray<c>> f9618b = new WeakHashMap<>(0);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f9619c = new Object();

    static class a {
        static Drawable a(Resources resources, int i5, Resources.Theme theme) {
            return resources.getDrawable(i5, theme);
        }

        static Drawable b(Resources resources, int i5, int i6, Resources.Theme theme) {
            return resources.getDrawableForDensity(i5, i6, theme);
        }
    }

    static class b {
        static int a(Resources resources, int i5, Resources.Theme theme) {
            return resources.getColor(i5, theme);
        }

        static ColorStateList b(Resources resources, int i5, Resources.Theme theme) {
            return resources.getColorStateList(i5, theme);
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        final ColorStateList f9620a;

        /* renamed from: b, reason: collision with root package name */
        final Configuration f9621b;

        /* renamed from: c, reason: collision with root package name */
        final int f9622c;

        c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f9620a = colorStateList;
            this.f9621b = configuration;
            this.f9622c = theme == null ? 0 : theme.hashCode();
        }
    }

    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        final Resources f9623a;

        /* renamed from: b, reason: collision with root package name */
        final Resources.Theme f9624b;

        d(Resources resources, Resources.Theme theme) {
            this.f9623a = resources;
            this.f9624b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && d.class == obj.getClass()) {
                d dVar = (d) obj;
                if (this.f9623a.equals(dVar.f9623a) && D.c.a(this.f9624b, dVar.f9624b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return D.c.b(this.f9623a, this.f9624b);
        }
    }

    public static abstract class e {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(final int i5, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9627a.f(i5);
                }
            });
        }

        public final void d(final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f9625a.g(typeface);
                }
            });
        }

        public abstract void f(int i5);

        public abstract void g(Typeface typeface);
    }

    public static final class f {

        static class a {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            a.a(theme);
        }
    }

    private static void a(d dVar, int i5, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f9619c) {
            try {
                WeakHashMap<d, SparseArray<c>> weakHashMap = f9618b;
                SparseArray<c> sparseArray = weakHashMap.get(dVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                    weakHashMap.put(dVar, sparseArray);
                }
                sparseArray.append(i5, new c(colorStateList, dVar.f9623a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2.f9622c == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.content.res.ColorStateList b(androidx.core.content.res.h.d r5, int r6) {
        /*
            java.lang.Object r0 = androidx.core.content.res.h.f9619c
            monitor-enter(r0)
            java.util.WeakHashMap<androidx.core.content.res.h$d, android.util.SparseArray<androidx.core.content.res.h$c>> r1 = androidx.core.content.res.h.f9618b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            androidx.core.content.res.h$c r2 = (androidx.core.content.res.h.c) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.f9621b     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.f9623a     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.f9624b     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.f9622c     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.f9622c     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.f9620a     // Catch: java.lang.Throwable -> L32
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.h.b(androidx.core.content.res.h$d, int):android.content.res.ColorStateList");
    }

    public static Typeface c(Context context, int i5) {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i5, new TypedValue(), 0, null, null, false, true);
    }

    public static int d(Resources resources, int i5, Resources.Theme theme) {
        return b.a(resources, i5, theme);
    }

    public static ColorStateList e(Resources resources, int i5, Resources.Theme theme) {
        d dVar = new d(resources, theme);
        ColorStateList colorStateListB = b(dVar, i5);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListL = l(resources, i5, theme);
        if (colorStateListL == null) {
            return b.b(resources, i5, theme);
        }
        a(dVar, i5, colorStateListL, theme);
        return colorStateListL;
    }

    public static Drawable f(Resources resources, int i5, Resources.Theme theme) {
        return a.a(resources, i5, theme);
    }

    public static Drawable g(Resources resources, int i5, int i6, Resources.Theme theme) {
        return a.b(resources, i5, i6, theme);
    }

    public static Typeface h(Context context, int i5) {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i5, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface i(Context context, int i5, TypedValue typedValue, int i6, e eVar) {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i5, typedValue, i6, eVar, null, true, false);
    }

    public static void j(Context context, int i5, e eVar, Handler handler) throws Resources.NotFoundException {
        D.h.e(eVar);
        if (context.isRestricted()) {
            eVar.c(-4, handler);
        } else {
            n(context, i5, new TypedValue(), 0, eVar, handler, false, false);
        }
    }

    private static TypedValue k() {
        ThreadLocal<TypedValue> threadLocal = f9617a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList l(Resources resources, int i5, Resources.Theme theme) {
        if (m(resources, i5)) {
            return null;
        }
        try {
            return androidx.core.content.res.c.a(resources, resources.getXml(i5), theme);
        } catch (Exception e6) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e6);
            return null;
        }
    }

    private static boolean m(Resources resources, int i5) throws Resources.NotFoundException {
        TypedValue typedValueK = k();
        resources.getValue(i5, typedValueK, true);
        int i6 = typedValueK.type;
        return i6 >= 28 && i6 <= 31;
    }

    private static Typeface n(Context context, int i5, TypedValue typedValue, int i6, e eVar, Handler handler, boolean z5, boolean z6) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        resources.getValue(i5, typedValue, true);
        Typeface typefaceO = o(context, resources, typedValue, i5, i6, eVar, handler, z5, z6);
        if (typefaceO != null || eVar != null || z6) {
            return typefaceO;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i5) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Typeface o(android.content.Context r13, android.content.res.Resources r14, android.util.TypedValue r15, int r16, int r17, androidx.core.content.res.h.e r18, android.os.Handler r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.h.o(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.h$e, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
