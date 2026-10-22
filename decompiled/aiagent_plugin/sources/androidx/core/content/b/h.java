package androidx.core.content.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ResourcesCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    private static final String TAG = "ResourcesCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f1176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<e, SparseArray<d>> f1177b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f1178c = null;

    /* JADX INFO: compiled from: ResourcesCompat.java */
    static class a {
        static Drawable a(Resources r0, int r1, int r2) {
            return r0.getDrawableForDensity(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ResourcesCompat.java */
    static class b {
        static Drawable a(Resources r0, int r1, Resources.Theme r2) {
            return r0.getDrawable(r1, r2);
        }

        static Drawable a(Resources r0, int r1, int r2, Resources.Theme r3) {
            return r0.getDrawableForDensity(r1, r2, r3);
        }
    }

    /* JADX INFO: compiled from: ResourcesCompat.java */
    static class c {
        static ColorStateList a(Resources r0, int r1, Resources.Theme r2) {
            return r0.getColorStateList(r1, r2);
        }

        static int b(Resources r0, int r1, Resources.Theme r2) {
            return r0.getColor(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ResourcesCompat.java */
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ColorStateList f1179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Configuration f1180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f1181c;

        d(ColorStateList r1, Configuration r2, Resources.Theme r3) {
            this.f1179a = r1;
            this.f1180b = r2;
            if (r3 != null) goto L5;
            int r4 = 0;
        L6:
            this.f1181c = r4;
            return;
        L5:
            r4 = r3.hashCode();
            goto L6
        }
    }

    /* JADX INFO: compiled from: ResourcesCompat.java */
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Resources f1182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Resources.Theme f1183b;

        e(Resources r1, Resources.Theme r2) {
            this.f1182a = r1;
            this.f1183b = r2;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L17:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L17;
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (this.f1182a.equals(r6.f1182a) == false) goto L16;
            if (androidx.core.util.d.a(this.f1183b, r6.f1183b) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return androidx.core.util.d.a(new Object[]{this.f1182a, this.f1183b});
        }
    }

    /* JADX INFO: compiled from: ResourcesCompat.java */
    public static abstract class f {
        public static /* synthetic */ void lambda$0JI2oHa4sEvDK5qBTDqPIMgtZ8I(f r0, int r1) {
            r0.b(r1);
        }

        public static /* synthetic */ void lambda$afYWfNs8eg2zxgLrgqE95p6ljf0(f r0, Typeface r1) {
            r0.b(r1);
        }

        public abstract void a(int r1);

        public abstract void a(Typeface r1);

        public f() {
        }

        private /* synthetic */ void b(Typeface r1) {
            a(r1);
        }

        public final void a(final Typeface r2, Handler r3) {
            a(r3).post(new $$Lambda$h$f$afYWfNs8eg2zxgLrgqE95p6ljf0(this, r2));
        }

        private /* synthetic */ void b(int r1) {
            a(r1);
        }

        public final void a(final int r2, Handler r3) {
            a(r3).post(new $$Lambda$h$f$0JI2oHa4sEvDK5qBTDqPIMgtZ8I(this, r2));
        }

        public static Handler a(Handler r1) {
            if (r1 == null) goto L4;
            return r1;
        L4:
            return new Handler(Looper.getMainLooper());
        }
    }

    /* JADX INFO: compiled from: ResourcesCompat.java */
    public static final class g {

        /* JADX INFO: compiled from: ResourcesCompat.java */
        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final Object f1184a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static Method f1185b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static boolean f1186c;

            static {
                f1184a = new Object();
            }

            static void a(Resources.Theme r6) {
                Object r0 = f1184a;
                monitor-enter(r0);
            L21:
                th = move-exception;
                throw th;
            L6:
                if (f1186c == false) goto L24;
            L13:
                Method r1 = f1185b;     // Catch: Throwable -> L21
                if (r1 != null) goto L26;
            L19:
                monitor-exit(r0);     // Catch: Throwable -> L21
                return;
            L26:
                r1.invoke(r6, new Object[0]);     // Catch: Throwable -> L17 Throwable -> L21
            L17:
                e = move-exception;
                a(h.TAG, "Failed to invoke rebase() method via reflection", e);     // Catch: Throwable -> L21
                f1185b = null;     // Catch: Throwable -> L21
                goto L19
            L24:
                Method r3 = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);     // Catch: NoSuchMethodException -> L10 Throwable -> L21
                f1185b = r3;     // Catch: NoSuchMethodException -> L10 Throwable -> L21
                r3.setAccessible(true);     // Catch: NoSuchMethodException -> L10 Throwable -> L21
            L12:
                f1186c = true;     // Catch: Throwable -> L21
                goto L13
            L10:
                e = move-exception;
                a(h.TAG, "Failed to retrieve rebase() method", e);     // Catch: Throwable -> L21
                goto L12
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int a(String r1, String r2, Throwable r3) {
                if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
                return 0;
            L5:
                return Log.i(r1, r2, r3);
            }
        }

        /* JADX INFO: compiled from: ResourcesCompat.java */
        static class b {
            static void a(Resources.Theme r0) {
                r0.rebase();
            }
        }

        public static void a(Resources.Theme r2) {
            if (Build.VERSION.SDK_INT < 29) goto L6;
            b.a(r2);
            return;
        L6:
            if (Build.VERSION.SDK_INT < 23) goto L10;
            a.a(r2);
            return;
        }
    }

    static {
        f1176a = new ThreadLocal();
        f1177b = new WeakHashMap(0);
        f1178c = new Object();
    }

    public static Drawable a(Resources r2, int r3, Resources.Theme r4) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return b.a(r2, r3, r4);
    L7:
        return r2.getDrawable(r3);
    }

    public static Drawable a(Resources r2, int r3, int r4, Resources.Theme r5) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return b.a(r2, r3, r4, r5);
    L7:
        if (Build.VERSION.SDK_INT < 15) goto L11;
        return a.a(r2, r3, r4);
    L11:
        return r2.getDrawable(r3);
    }

    public static int b(Resources r2, int r3, Resources.Theme r4) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return c.b(r2, r3, r4);
    L7:
        return r2.getColor(r3);
    }

    public static ColorStateList c(Resources r2, int r3, Resources.Theme r4) {
        e r0 = new e(r2, r4);
        ColorStateList r1 = a(r0, r3);
        if (r1 == null) goto L5;
        return r1;
    L5:
        ColorStateList r5 = d(r2, r3, r4);
        if (r5 == null) goto L10;
        a(r0, r3, r5, r4);
        return r5;
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        return c.a(r2, r3, r4);
    L14:
        return r2.getColorStateList(r3);
    }

    private static ColorStateList d(Resources r2, int r3, Resources.Theme r4) {
        if (a(r2, r3) == false) goto L11;
        return null;
    L11:
        return androidx.core.content.b.c.a(r2, r2.getXml(r3), r4);
    L8:
        e = move-exception;
        a(TAG, "Failed to inflate ColorStateList, leaving it to the framework", e);
        return null;
    }

    private static ColorStateList a(e r5, int r6) {
        Object r0 = f1178c;
        monitor-enter(r0);
        SparseArray r1 = (SparseArray) ZeusTransformUtils.preCheckCast(f1177b.get(r5), SparseArray.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r1 != null) goto L7;
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L27
        return null;
    L7:
        if (r1.size() <= 0) goto L24;
        d r2 = (d) ZeusTransformUtils.preCheckCast(r1.get(r6), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r2 == null) goto L24;
        if (r2.f1180b.equals(r5.f1182a.getConfiguration()) == true) goto L13;
    L23:
        r1.remove(r6);     // Catch: Throwable -> L27
        goto L24
    L13:
        if (r5.f1183b != null) goto L17;
        if (r2.f1181c != 0) goto L17;
    L20:
        ColorStateList r7 = r2.f1179a;     // Catch: Throwable -> L27
        monitor-exit(r0);     // Catch: Throwable -> L27
        return r7;
    L17:
        if (r5.f1183b == null) goto L23;
        if (r2.f1181c != r5.f1183b.hashCode()) goto L23;
    L27:
        th = move-exception;
        throw th;
    }

    private static void a(e r5, int r6, ColorStateList r7, Resources.Theme r8) {
        Object r0 = f1178c;
        monitor-enter(r0);
        WeakHashMap<e, SparseArray<d>> r1 = f1177b;     // Catch: Throwable -> L10
        SparseArray<d> r2 = (SparseArray) ZeusTransformUtils.preCheckCast(r1.get(r5), SparseArray.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r2 != null) goto L7;
        r2 = new SparseArray();     // Catch: Throwable -> L10
        r1.put(r5, r2);     // Catch: Throwable -> L10
    L7:
        r2.append(r6, new d(r7, r5.f1182a.getConfiguration(), r8));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static boolean a(Resources r2, int r3) {
        TypedValue r0 = a();
        r2.getValue(r3, r0, true);
        if (r0.type >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r0.type > 31) goto L7;
        return true;
    }

    private static TypedValue a() {
        ThreadLocal<TypedValue> r0 = f1176a;
        TypedValue r1 = (TypedValue) ZeusTransformUtils.preCheckCast(r0.get(), TypedValue.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        TypedValue r2 = new TypedValue();
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }

    public static Typeface a(Context r8, int r9) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        if (r0.isRestricted() == false) goto L7;
        return null;
    L7:
        return a(r0, r9, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface b(Context r8, int r9) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        if (r0.isRestricted() == false) goto L7;
        return null;
    L7:
        return a(r0, r9, new TypedValue(), 0, null, null, false, true);
    }

    public static void a(Context r8, int r9, f r10, Handler r11) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        androidx.core.util.g.a(r10);
        if (r0.isRestricted() == false) goto L6;
        r10.a(-4, r11);
        return;
    L6:
        a(r0, r9, new TypedValue(), 0, r10, r11, false, false);
    }

    public static Typeface a(Context r8, int r9, TypedValue r10, int r11, f r12) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        if (r0.isRestricted() == false) goto L7;
        return null;
    L7:
        return a(r0, r9, r10, r11, r12, null, true, false);
    }

    private static Typeface a(Context r11, int r12, TypedValue r13, int r14, f r15, Handler r16, boolean r17, boolean r18) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        Resources r3 = ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin");
        r3.getValue(r12, r13, true);
        Typeface r0 = a(r2, r3, r13, r12, r14, r15, r16, r17, r18);
        if (r0 != null) goto L9;
        if (r15 != null) goto L9;
        if (r18 == true) goto L9;
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(r12) + " could not be retrieved.");
    L9:
        return r0;
    }

    private static Typeface a(Context r17, Resources r18, TypedValue r19, int r20, int r21, f r22, Handler r23, boolean r24, boolean r25) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        if (r19.string == null) goto L40;
        String r14 = r19.string.toString();
        if (r14.startsWith("res/") == true) goto L9;
        if (r22 == null) goto L8;
        r22.a(-3, r23);
    L8:
        return null;
    L9:
        Typeface r3 = androidx.core.graphics.j.a(r18, r20, r14, r19.assetCookie, r21);
        if (r3 == null) goto L14;
        if (r22 == null) goto L13;
        r22.a(r3, r23);
    L13:
        return r3;
    L14:
        if (r25 == false) goto L41;
        return null;
    L41:
    L32:
        e = move-exception;
        b(TAG, "Failed to read xml resource " + r14, e);
    L36:
        if (r22 == null) goto L38;
        r22.a(-3, r23);
    L38:
        return null;
    L34:
        e = move-exception;
        b(TAG, "Failed to parse xml resource " + r14, e);
        goto L36
    L17:
        if (r14.toLowerCase().endsWith(".xml") == false) goto L26;
        androidx.core.content.b.e.b r4 = androidx.core.content.b.e.a(r18.getXml(r20), r18);     // Catch: IOException -> L32 XmlPullParserException -> L34
        if (r4 != null) goto L25;
        a(TAG, "Failed to find font-family tag");     // Catch: IOException -> L32 XmlPullParserException -> L34
        if (r22 == null) goto L23;
        r22.a(-3, r23);     // Catch: IOException -> L32 XmlPullParserException -> L34
    L23:
        return null;
    L25:
        return androidx.core.graphics.j.a(r2, r4, r18, r20, r14, r19.assetCookie, r21, r22, r23, r24);
    L26:
        Typeface r0 = androidx.core.graphics.j.a(r2, r18, r20, r14, r19.assetCookie, r21);     // Catch: IOException -> L32 XmlPullParserException -> L34
        if (r22 == null) goto L31;
        if (r0 == null) goto L30;
        r22.a(r0, r23);     // Catch: IOException -> L32 XmlPullParserException -> L34
        goto L31
    L30:
        r22.a(-3, r23);     // Catch: IOException -> L32 XmlPullParserException -> L34
    L31:
        return r0;
    L40:
        throw new Resources.NotFoundException("Resource \"" + r18.getResourceName(r20) + "\" (" + Integer.toHexString(r20) + ") is not a Font: " + r19);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
