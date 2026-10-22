package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.resources.R$drawable;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.ContextCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class ResourceManagerInternal {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f863h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static ResourceManagerInternal f864i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f865j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap f866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SimpleArrayMap f867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.collection.e f868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap f869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ResourceManagerHooks f872g;

    public interface InflateDelegate {
        Drawable createFromXmlInner(@NonNull Context r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ResourceManagerHooks {
        @Nullable
        Drawable createDrawableFor(@NonNull ResourceManagerInternal r10, @NonNull Context r11, @DrawableRes int r12);

        @Nullable
        ColorStateList getTintListForDrawableRes(@NonNull Context r10, @DrawableRes int r11);

        @Nullable
        PorterDuff.Mode getTintModeForDrawableRes(int r10);

        boolean tintDrawable(@NonNull Context r10, @DrawableRes int r11, @NonNull Drawable r12);

        boolean tintDrawableUsingColorFilter(@NonNull Context r10, @DrawableRes int r11, @NonNull Drawable r12);
    }

    public static class a extends androidx.collection.d {
        public a(int r10) {
            super(r10);
        }

        public static int h(int r10, PorterDuff.Mode r11) {
            return ((r10 + 31) * 31) + r11.hashCode();
        }

        public PorterDuffColorFilter i(int r10, PorterDuff.Mode r11) {
            return (PorterDuffColorFilter) c(Integer.valueOf(h(r10, r11)));
        }

        public PorterDuffColorFilter j(int r10, PorterDuff.Mode r11, PorterDuffColorFilter r12) {
            return (PorterDuffColorFilter) d(Integer.valueOf(h(r10, r11)), r12);
        }
    }

    static {
        f863h = PorterDuff.Mode.SRC_IN;
        f865j = new a(6);
    }

    public ResourceManagerInternal() {
        this.f869d = new WeakHashMap(0);
    }

    public static long d(TypedValue r10) {
        return (((long) r10.assetCookie) << 32) | ((long) r10.data);
    }

    public static PorterDuffColorFilter f(ColorStateList r10, PorterDuff.Mode r11, int[] r12) {
        if (r10 == null) goto L7;
        if (r11 != null) goto L6;
        return null;
    L6:
        return k(r10.getColorForState(r12, 0), r11);
    L7:
        return null;
    }

    public static synchronized ResourceManagerInternal g() {
        monitor-enter(ResourceManagerInternal.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f864i != null) goto L9;
        ResourceManagerInternal r10 = new ResourceManagerInternal();     // Catch: Throwable -> L7
        f864i = r10;     // Catch: Throwable -> L7
        o(r10);     // Catch: Throwable -> L7
    L9:
        ResourceManagerInternal r11 = f864i;     // Catch: Throwable -> L7
        monitor-exit(ResourceManagerInternal.class);
        return r11;
    }

    public static synchronized PorterDuffColorFilter k(int r10, PorterDuff.Mode r11) {
        monitor-enter(ResourceManagerInternal.class);
        a r12 = f865j;     // Catch: Throwable -> L8
        PorterDuffColorFilter r13 = r12.i(r10, r11);     // Catch: Throwable -> L8
        if (r13 != null) goto L10;
        r13 = new PorterDuffColorFilter(r10, r11);     // Catch: Throwable -> L8
        r12.j(r10, r11, r13);     // Catch: Throwable -> L8
    L10:
        monitor-exit(ResourceManagerInternal.class);
        return r13;
    L8:
        th = move-exception;
        throw th;
    }

    public static void o(ResourceManagerInternal r10) {
    }

    public static boolean p(Drawable r10) {
        if ((r10 instanceof androidx.vectordrawable.graphics.drawable.c) == false) goto L5;
    L8:
        return true;
    L5:
        if ("android.graphics.drawable.VectorDrawable".equals(r10.getClass().getName()) == true) goto L8;
        return false;
    }

    public static void v(Drawable r10, z r11, int[] r12) {
        int[] r13 = r10.getState();
        if (r.a(r10) == false) goto L10;
        if (r10.mutate() == r10) goto L10;
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
        return;
    L10:
        if ((r10 instanceof LayerDrawable) == true) goto L12;
    L14:
        boolean r14 = r11.f1164d;
        if (r14 == false) goto L17;
    L20:
        if (r14 == false) goto L22;
        ColorStateList r15 = r11.f1161a;
    L24:
        if (r11.f1163c == false) goto L26;
        PorterDuff.Mode r16 = r11.f1162b;
    L27:
        r10.setColorFilter(f(r15, r16, r12));
        return;
    L26:
        r16 = f863h;
        goto L27
    L22:
        r15 = null;
        goto L24
    L17:
        if (r11.f1163c == true) goto L20;
        r10.clearColorFilter();
        return;
    L12:
        if (r10.isStateful() == false) goto L14;
        r10.setState(new int[0]);
        r10.setState(r13);
        goto L14
    }

    public final synchronized boolean a(Context r10, long r11, Drawable r12) {
        monitor-enter(this);
        Drawable.ConstantState r13 = r12.getConstantState();     // Catch: Throwable -> L8
        if (r13 == null) goto L14;
        androidx.collection.c r14 = (androidx.collection.c) this.f869d.get(r10);     // Catch: Throwable -> L8
        if (r14 != null) goto L10;
        r14 = new androidx.collection.c();     // Catch: Throwable -> L8
        this.f869d.put(r10, r14);     // Catch: Throwable -> L8
    L10:
        r14.j(r11, new WeakReference(r13));     // Catch: Throwable -> L8
        monitor-exit(this);
        return true;
    L14:
        monitor-exit(this);
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    public final void b(Context r10, int r11, ColorStateList r12) {
        if (this.f866a != null) goto L5;
        this.f866a = new WeakHashMap();
    L5:
        androidx.collection.e r13 = (androidx.collection.e) this.f866a.get(r10);
        if (r13 != null) goto L8;
        r13 = new androidx.collection.e();
        this.f866a.put(r10, r13);
    L8:
        r13.a(r11, r12);
    }

    public final void c(Context r10) {
        if (this.f871f == false) goto L5;
        return;
    L5:
        this.f871f = true;
        Drawable r11 = i(r10, R$drawable.abc_vector_test);
        if (r11 != null) goto L8;
    L10:
        this.f871f = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    L8:
        if (p(r11) == false) goto L10;
    }

    public final Drawable e(Context r10, int r11) {
        if (this.f870e != null) goto L5;
        this.f870e = new TypedValue();
    L5:
        TypedValue r12 = this.f870e;
        r10.getResources().getValue(r11, r12, true);
        long r13 = d(r12);
        Drawable r14 = h(r10, r13);
        if (r14 == null) goto L8;
        return r14;
    L8:
        ResourceManagerHooks r15 = this.f872g;
        if (r15 != null) goto L11;
        Drawable r16 = null;
    L12:
        if (r16 == null) goto L14;
        r16.setChangingConfigurations(r12.changingConfigurations);
        a(r10, r13, r16);
    L14:
        return r16;
    L11:
        r16 = r15.createDrawableFor(this, r10, r11);
        goto L12
    }

    public final synchronized Drawable h(Context r10, long r11) {
        monitor-enter(this);
        androidx.collection.c r12 = (androidx.collection.c) this.f869d.get(r10);     // Catch: Throwable -> L15
        if (r12 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        WeakReference r13 = (WeakReference) r12.e(r11);     // Catch: Throwable -> L15
        if (r13 == null) goto L18;
        Drawable.ConstantState r14 = (Drawable.ConstantState) r13.get();     // Catch: Throwable -> L15
        if (r14 == null) goto L17;
        Drawable r15 = r14.newDrawable(r10.getResources());     // Catch: Throwable -> L15
        monitor-exit(this);
        return r15;
    L17:
        r12.k(r11);     // Catch: Throwable -> L15
    L18:
        monitor-exit(this);
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized Drawable i(Context r10, int r11) {
        monitor-enter(this);
        Drawable r12 = j(r10, r11, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized Drawable j(Context r10, int r11, boolean r12) {
        monitor-enter(this);
        c(r10);     // Catch: Throwable -> L6
        Drawable r13 = q(r10, r11);     // Catch: Throwable -> L6
        if (r13 != null) goto L8;
        r13 = e(r10, r11);     // Catch: Throwable -> L6
    L8:
        if (r13 != null) goto L10;
        r13 = ContextCompat.d(r10, r11);     // Catch: Throwable -> L6
    L10:
        if (r13 == null) goto L12;
        r13 = u(r10, r11, r12, r13);     // Catch: Throwable -> L6
    L12:
        if (r13 == null) goto L14;
        r.b(r13);     // Catch: Throwable -> L6
    L14:
        monitor-exit(this);
        return r13;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ColorStateList l(Context r10, int r11) {
        monitor-enter(this);
        ColorStateList r12 = m(r10, r11);     // Catch: Throwable -> L12
        if (r12 != null) goto L14;
        ResourceManagerHooks r13 = this.f872g;     // Catch: Throwable -> L12
        if (r13 != null) goto L8;
        r12 = null;
    L9:
        if (r12 == null) goto L14;
        b(r10, r11, r12);     // Catch: Throwable -> L12
        goto L14
    L8:
        r12 = r13.getTintListForDrawableRes(r10, r11);     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
        return r12;
    L12:
        th = move-exception;
        throw th;
    }

    public final ColorStateList m(Context r10, int r11) {
        WeakHashMap r12 = this.f866a;
        if (r12 == null) goto L8;
        androidx.collection.e r13 = (androidx.collection.e) r12.get(r10);
        if (r13 != null) goto L7;
        return null;
    L7:
        return (ColorStateList) r13.f(r11);
    L8:
        return null;
    }

    public PorterDuff.Mode n(int r10) {
        ResourceManagerHooks r11 = this.f872g;
        if (r11 != null) goto L6;
        return null;
    L6:
        return r11.getTintModeForDrawableRes(r10);
    }

    public final Drawable q(Context r11, int r12) {
        SimpleArrayMap r10 = this.f867b;
        if (r10 != null) goto L5;
    L44:
        return null;
    L5:
        if (r10.isEmpty() == true) goto L44;
        androidx.collection.e r13 = this.f868c;
        if (r13 == null) goto L14;
        String r14 = (String) r13.f(r12);
        if ("appcompat_skip_skip".equals(r14) == true) goto L13;
        if (r14 == null) goto L16;
        if (this.f867b.get(r14) == null) goto L13;
    L16:
        if (this.f870e != null) goto L18;
        this.f870e = new TypedValue();
    L18:
        TypedValue r15 = this.f870e;
        Resources r16 = r11.getResources();
        r16.getValue(r12, r15, true);
        long r17 = d(r15);
        Drawable r18 = h(r11, r17);
        if (r18 == null) goto L21;
        return r18;
    L21:
        CharSequence r19 = r15.string;
        if (r19 != null) goto L24;
    L41:
        if (r18 != null) goto L43;
        this.f868c.a(r12, "appcompat_skip_skip");
    L43:
        return r18;
    L24:
        if (r19.toString().endsWith(".xml") == false) goto L41;
        XmlResourceParser r20 = r16.getXml(r12);     // Catch: Exception -> L34
        AttributeSet r21 = Xml.asAttributeSet(r20);     // Catch: Exception -> L34
    L26:
        int r22 = r20.next();     // Catch: Exception -> L34
        if (r22 == 2) goto L30;
        if (r22 != 1) goto L26;
    L30:
        if (r22 != 2) goto L39;
        String r23 = r20.getName();     // Catch: Exception -> L34
        this.f868c.a(r12, r23);     // Catch: Exception -> L34
        InflateDelegate r24 = (InflateDelegate) this.f867b.get(r23);     // Catch: Exception -> L34
        if (r24 == null) goto L36;
        r18 = r24.createFromXmlInner(r11, r20, r21, r11.getTheme());     // Catch: Exception -> L34
    L36:
        if (r18 == null) goto L41;
        r18.setChangingConfigurations(r15.changingConfigurations);     // Catch: Exception -> L34
        a(r11, r17, r18);     // Catch: Exception -> L34
        goto L41
    L39:
        throw new XmlPullParserException("No start tag found");     // Catch: Exception -> L34
    L34:
        e = move-exception;
        Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
    L13:
        return null;
    L14:
        this.f868c = new androidx.collection.e();
        goto L16
    }

    public synchronized void r(Context r10) {
        monitor-enter(this);
        androidx.collection.c r11 = (androidx.collection.c) this.f869d.get(r10);     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        r11.a();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized Drawable s(Context r10, h0 r11, int r12) {
        monitor-enter(this);
        Drawable r13 = q(r10, r12);     // Catch: Throwable -> L6
        if (r13 != null) goto L8;
        r13 = r11.a(r12);     // Catch: Throwable -> L6
    L8:
        if (r13 == null) goto L12;
        Drawable r14 = u(r10, r12, false, r13);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r14;
    L12:
        monitor-exit(this);
        return null;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void t(ResourceManagerHooks r10) {
        monitor-enter(this);
        this.f872g = r10;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final Drawable u(Context r10, int r11, boolean r12, Drawable r13) {
        ColorStateList r14 = l(r10, r11);
        if (r14 != null) goto L5;
        ResourceManagerHooks r15 = this.f872g;
        if (r15 == null) goto L16;
        if (r15.tintDrawable(r10, r11, r13) == false) goto L16;
        return r13;
    L16:
        if (w(r10, r11, r13) == true) goto L22;
        if (r12 == false) goto L23;
        return null;
    L23:
        return r13;
    L22:
        return r13;
    L5:
        if (r.a(r13) == false) goto L7;
        r13 = r13.mutate();
    L7:
        Drawable r16 = o.a.l(r13);
        o.a.i(r16, r14);
        PorterDuff.Mode r17 = n(r11);
        if (r17 == null) goto L20;
        o.a.j(r16, r17);
        return r16;
    L20:
        return r16;
    }

    public boolean w(Context r10, int r11, Drawable r12) {
        ResourceManagerHooks r13 = this.f872g;
        if (r13 != null) goto L5;
    L7:
        return false;
    L5:
        if (r13.tintDrawableUsingColorFilter(r10, r11, r12) == false) goto L7;
        return true;
    }
}
