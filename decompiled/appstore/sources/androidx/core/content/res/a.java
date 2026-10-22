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
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.h;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f2533a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f2534b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f2535c = null;

    /* JADX INFO: renamed from: androidx.core.content.res.a$a, reason: collision with other inner class name */
    public static class C0014a {
        @DoNotInline
        public static Drawable a(Resources r10, int r11, Resources.Theme r12) {
            return r10.getDrawable(r11, r12);
        }

        @DoNotInline
        public static Drawable b(Resources r10, int r11, int r12, Resources.Theme r13) {
            return r10.getDrawableForDensity(r11, r12, r13);
        }
    }

    public static class b {
        @DoNotInline
        public static int a(Resources r10, int r11, Resources.Theme r12) {
            return r10.getColor(r11, r12);
        }

        @NonNull
        @DoNotInline
        public static ColorStateList b(@NonNull Resources r10, @ColorRes int r11, @Nullable Resources.Theme r12) {
            return r10.getColorStateList(r11, r12);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ColorStateList f2536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Configuration f2537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2538c;

        public c(ColorStateList r10, Configuration r11, Resources.Theme r12) {
            this.f2536a = r10;
            this.f2537b = r11;
            if (r12 != null) goto L5;
            int r13 = 0;
        L6:
            this.f2538c = r13;
            return;
        L5:
            r13 = r12.hashCode();
            goto L6
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f2539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Resources.Theme f2540b;

        public d(Resources r10, Resources.Theme r11) {
            this.f2539a = r10;
            this.f2540b = r11;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (r10 != null) goto L8;
        L17:
            return false;
        L8:
            if (d.class != r10.getClass()) goto L17;
            d r11 = (d) r10;
            if (this.f2539a.equals(r11.f2539a) == false) goto L16;
            if (androidx.core.util.b.a(this.f2540b, r11.f2540b) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return androidx.core.util.b.b(new Object[]{this.f2539a, this.f2540b});
        }
    }

    public static abstract class e {
        public e() {
        }

        public static /* synthetic */ void a(e r10, Typeface r11) {
            r10.d(r11);
        }

        public static /* synthetic */ void b(e r10, int r11) {
            r10.c(r11);
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Handler getHandler(@Nullable Handler r10) {
            if (r10 == null) goto L4;
            return r10;
        L4:
            return new Handler(Looper.getMainLooper());
        }

        public final /* synthetic */ void c(int r10) {
            onFontRetrievalFailed(r10);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(final int r10, @Nullable Handler r11) {
            getHandler(r11).post(new n.f(this, r10));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(@NonNull final Typeface r10, @Nullable Handler r11) {
            getHandler(r11).post(new n.e(this, r10));
        }

        public final /* synthetic */ void d(Typeface r10) {
            onFontRetrieved(r10);
        }

        public abstract void onFontRetrievalFailed(int r10);

        public abstract void onFontRetrieved(Typeface r10);
    }

    public static final class f {

        /* JADX INFO: renamed from: androidx.core.content.res.a$f$a, reason: collision with other inner class name */
        public static class C0015a {
            @DoNotInline
            public static void a(@NonNull Resources.Theme r10) {
                r10.rebase();
            }
        }

        public static void a(Resources.Theme r10) {
            C0015a.a(r10);
        }
    }

    static {
        f2533a = new ThreadLocal();
        f2534b = new WeakHashMap(0);
        f2535c = new Object();
    }

    public static void a(d r10, int r11, ColorStateList r12, Resources.Theme r13) {
        Object r14 = f2535c;
        monitor-enter(r14);
        WeakHashMap r15 = f2534b;     // Catch: Throwable -> L7
        SparseArray r16 = (SparseArray) r15.get(r10);     // Catch: Throwable -> L7
        if (r16 != null) goto L9;
        r16 = new SparseArray();     // Catch: Throwable -> L7
        r15.put(r10, r16);     // Catch: Throwable -> L7
    L9:
        r16.append(r11, new c(r12, r10.f2539a.getConfiguration(), r13));     // Catch: Throwable -> L7
        monitor-exit(r14);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static ColorStateList b(d r10, int r11) {
        Object r12 = f2535c;
        monitor-enter(r12);
        SparseArray r13 = (SparseArray) f2534b.get(r10);     // Catch: Throwable -> L17
        if (r13 != null) goto L7;
    L26:
        monitor-exit(r12);     // Catch: Throwable -> L17
        return null;
    L7:
        if (r13.size() <= 0) goto L26;
        c r14 = (c) r13.get(r11);     // Catch: Throwable -> L17
        if (r14 == null) goto L26;
        if (r14.f2537b.equals(r10.f2539a.getConfiguration()) == false) goto L25;
        Resources.Theme r15 = r10.f2540b;     // Catch: Throwable -> L17
        if (r15 == null) goto L15;
    L19:
        if (r15 == null) goto L25;
        if (r14.f2538c != r15.hashCode()) goto L25;
    L22:
        ColorStateList r16 = r14.f2536a;     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        return r16;
    L15:
        if (r14.f2538c == 0) goto L22;
    L25:
        r13.remove(r11);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static Typeface c(Context r10, int r11) {
        if (r10.isRestricted() == false) goto L7;
        return null;
    L7:
        return n(r10, r11, new TypedValue(), 0, null, null, false, true);
    }

    public static int d(Resources r10, int r11, Resources.Theme r12) {
        return b.a(r10, r11, r12);
    }

    public static ColorStateList e(Resources r10, int r11, Resources.Theme r12) {
        d r13 = new d(r10, r12);
        ColorStateList r14 = b(r13, r11);
        if (r14 == null) goto L5;
        return r14;
    L5:
        ColorStateList r15 = l(r10, r11, r12);
        if (r15 == null) goto L10;
        a(r13, r11, r15, r12);
        return r15;
    L10:
        return b.b(r10, r11, r12);
    }

    public static Drawable f(Resources r10, int r11, Resources.Theme r12) {
        return C0014a.a(r10, r11, r12);
    }

    public static Drawable g(Resources r10, int r11, int r12, Resources.Theme r13) {
        return C0014a.b(r10, r11, r12, r13);
    }

    public static Typeface h(Context r10, int r11) {
        if (r10.isRestricted() == false) goto L7;
        return null;
    L7:
        return n(r10, r11, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface i(Context r10, int r11, TypedValue r12, int r13, e r14) {
        if (r10.isRestricted() == false) goto L7;
        return null;
    L7:
        return n(r10, r11, r12, r13, r14, null, true, false);
    }

    public static void j(Context r10, int r11, e r12, Handler r13) {
        androidx.core.util.e.g(r12);
        if (r10.isRestricted() == false) goto L6;
        r12.callbackFailAsync(-4, r13);
        return;
    L6:
        n(r10, r11, new TypedValue(), 0, r12, r13, false, false);
    }

    public static TypedValue k() {
        ThreadLocal r10 = f2533a;
        TypedValue r11 = (TypedValue) r10.get();
        if (r11 != null) goto L6;
        TypedValue r12 = new TypedValue();
        r10.set(r12);
        return r12;
    L6:
        return r11;
    }

    public static ColorStateList l(Resources r10, int r11, Resources.Theme r12) {
        if (m(r10, r11) == false) goto L11;
        return null;
    L11:
        return n.c.a(r10, r10.getXml(r11), r12);
    L8:
        e = move-exception;
        Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
        return null;
    }

    public static boolean m(Resources r10, int r11) {
        TypedValue r12 = k();
        r10.getValue(r11, r12, true);
        int r13 = r12.type;
        if (r13 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r13 > 31) goto L7;
        return true;
    }

    public static Typeface n(Context r10, int r11, TypedValue r12, int r13, e r14, Handler r15, boolean r16, boolean r17) {
        Resources r18 = r10.getResources();
        r18.getValue(r11, r12, true);
        Typeface r19 = o(r10, r18, r12, r11, r13, r14, r15, r16, r17);
        if (r19 != null) goto L9;
        if (r14 != null) goto L9;
        if (r17 == true) goto L9;
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(r11) + " could not be retrieved.");
    L9:
        return r19;
    }

    public static Typeface o(Context r16, Resources r17, TypedValue r18, int r19, int r20, e r21, Handler r22, boolean r23, boolean r24) {
        CharSequence r10 = r18.string;
        if (r10 == null) goto L49;
        String r14 = r10.toString();
        int r15 = 0;
        if (r14.startsWith("res/") == true) goto L9;
        if (r21 == null) goto L8;
        r21.callbackFailAsync(-3, r22);
    L8:
        return null;
    L9:
        Typeface r11 = h.f(r17, r19, r14, r18.assetCookie, r20);
        if (r11 == null) goto L14;
        if (r21 == null) goto L13;
        r21.callbackSuccessAsync(r11, r22);
    L13:
        return r11;
    L14:
        if (r24 == false) goto L50;
        return null;
    L50:
    L23:
        e = e;
        r15 = -3;
    L42:
        Log.e("ResourcesCompat", "Failed to read xml resource " + r14, e);
    L44:
        if (r21 == null) goto L52;
        r21.callbackFailAsync(r15, r22);
        return null;
    L52:
        return null;
    L25:
        e = e;
        r15 = -3;
    L43:
        Log.e("ResourcesCompat", "Failed to parse xml resource " + r14, e);
        goto L44
    L51:
        if (r14.toLowerCase().endsWith(".xml") == false) goto L36;
        FontResourcesParserCompat.FamilyResourceEntry r12 = FontResourcesParserCompat.b(r17.getXml(r19), r17);     // Catch: IOException -> L23 XmlPullParserException -> L25
        if (r12 != null) goto L31;
        Log.e("ResourcesCompat", "Failed to find font-family tag");     // Catch: IOException -> L23 XmlPullParserException -> L25
        if (r21 == null) goto L27;
        r21.callbackFailAsync(-3, r22);     // Catch: IOException -> L23 XmlPullParserException -> L25
    L27:
        return null;
    L31:
        return h.c(r16, r12, r17, r19, r14, r18.assetCookie, r20, r21, r22, r23);
    L36:
        Typeface r13 = h.d(r16, r17, r19, r14, r18.assetCookie, r20);     // Catch: IOException -> L32 XmlPullParserException -> L34
        if (r21 == null) goto L41;
        if (r13 == null) goto L40;
        r21.callbackSuccessAsync(r13, r22);     // Catch: IOException -> L32 XmlPullParserException -> L34
        goto L41
    L40:
        r21.callbackFailAsync(-3, r22);     // Catch: IOException -> L32 XmlPullParserException -> L34
    L41:
        return r13;
    L32:
        e = e;
    L34:
        e = e;
        goto L43
    L49:
        throw new Resources.NotFoundException("Resource \"" + r17.getResourceName(r19) + "\" (" + Integer.toHexString(r19) + ") is not a Font: " + r18);
    }
}
