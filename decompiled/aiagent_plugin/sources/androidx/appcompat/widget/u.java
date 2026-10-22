package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ResourceManagerInternal.java */
/* JADX INFO: loaded from: classes.dex */
public final class u {
    private static final String TAG = "ResourceManagerInternal";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PorterDuff.Mode f478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static u f479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f480c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakHashMap<Context, androidx.b.h<ColorStateList>> f481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private androidx.b.g<String, e> f482e;
    private androidx.b.h<String> f;
    private final WeakHashMap<Context, androidx.b.d<WeakReference<Drawable.ConstantState>>> g;
    private TypedValue h;
    private boolean i;
    private f j;

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    static class a implements e {
        a() {
        }

        @Override // androidx.appcompat.widget.u.e
        public Drawable a(Context r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
            return AnimatedStateListDrawableCompat.createFromXmlInner(r1, ZeusTransformUtils.getResources(r1, "com.obric.aiagent.plugin"), r6, r7, r5);
        L5:
            e = move-exception;
            a("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
            return null;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private static class b implements e {
        b() {
        }

        @Override // androidx.appcompat.widget.u.e
        public Drawable a(Context r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
            return AnimatedVectorDrawableCompat.createFromXmlInner(r1, ZeusTransformUtils.getResources(r1, "com.obric.aiagent.plugin"), r6, r7, r5);
        L5:
            e = move-exception;
            a("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
            return null;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private static class c extends androidx.b.e<Integer, PorterDuffColorFilter> {
        public c(int r1) {
            super(r1);
        }

        PorterDuffColorFilter a(int r1, PorterDuff.Mode r2) {
            return (PorterDuffColorFilter) ZeusTransformUtils.preCheckCast(a(Integer.valueOf(b(r1, r2))), PorterDuffColorFilter.class, "com.obric.aiagent.plugin");
        }

        PorterDuffColorFilter a(int r1, PorterDuff.Mode r2, PorterDuffColorFilter r3) {
            return (PorterDuffColorFilter) ZeusTransformUtils.preCheckCast(a(Integer.valueOf(b(r1, r2)), r3), PorterDuffColorFilter.class, "com.obric.aiagent.plugin");
        }

        private static int b(int r1, PorterDuff.Mode r2) {
            return ((r1 + 31) * 31) + r2.hashCode();
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    static class d implements e {
        d() {
        }

        @Override // androidx.appcompat.widget.u.e
        public Drawable a(Context r5, XmlPullParser r6, AttributeSet r7, Resources.Theme r8) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r9 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r6, XmlPullParser.class, "com.obric.aiagent.plugin");
            AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
            String r11 = r10.getClassAttribute();
            if (r11 != null) goto L12;
        L11:
            return null;
        L12:
            Drawable r12 = (Drawable) ZeusTransformUtils.preCheckCast(d.class.getClassLoader().loadClass(r11).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), Drawable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
            if (Build.VERSION.SDK_INT < 21) goto L7;
            androidx.appcompat.b.a.c.a(r12, ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin"), r9, r10, r8);     // Catch: Exception -> L9
        L8:
            return r12;
        L7:
            r12.inflate(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin"), r9, r10);     // Catch: Exception -> L9
        L9:
            e = move-exception;
            a("DrawableDelegate", "Exception while inflating <drawable>", e);
            goto L11
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private interface e {
        Drawable a(Context r1, XmlPullParser r2, AttributeSet r3, Resources.Theme r4);
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    public interface f {
        ColorStateList a(Context r1, int r2);

        PorterDuff.Mode a(int r1);

        Drawable a(u r1, Context r2, int r3);

        boolean a(Context r1, int r2, Drawable r3);

        boolean b(Context r1, int r2, Drawable r3);
    }

    /* JADX INFO: compiled from: ResourceManagerInternal.java */
    private static class g implements e {
        g() {
        }

        @Override // androidx.appcompat.widget.u.e
        public Drawable a(Context r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.aiagent.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
            return VectorDrawableCompat.createFromXmlInner(ZeusTransformUtils.getResources(r1, "com.obric.aiagent.plugin"), r6, r7, r5);
        L5:
            e = move-exception;
            a("VdcInflateDelegate", "Exception while inflating <vector>", e);
            return null;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    public u() {
        this.g = new WeakHashMap(0);
    }

    static {
        f478a = PorterDuff.Mode.SRC_IN;
        f480c = new c(6);
    }

    public static synchronized u a() {
        monitor-enter(u.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f479b != null) goto L7;
        u r1 = new u();     // Catch: Throwable -> L10
        f479b = r1;     // Catch: Throwable -> L10
        a(r1);     // Catch: Throwable -> L10
    L7:
        u r2 = f479b;     // Catch: Throwable -> L10
        monitor-exit(u.class);
        return r2;
    }

    private static void a(u r2) {
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        r2.a("vector", new g());
        r2.a("animated-vector", new b());
        r2.a("animated-selector", new a());
        r2.a("drawable", new d());
        return;
    }

    public synchronized void a(f r3) {
        monitor-enter(this);
        this.j = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Drawable a(Context r3, int r4) {
        monitor-enter(this);
        Drawable r5 = a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, false);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized Drawable a(Context r3, int r4, boolean r5) {
        monitor-enter(this);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        b(r6);     // Catch: Throwable -> L14
        Drawable r0 = d(r6, r4);     // Catch: Throwable -> L14
        if (r0 != null) goto L6;
        r0 = c(r6, r4);     // Catch: Throwable -> L14
    L6:
        if (r0 != null) goto L8;
        r0 = androidx.core.content.a.a(r6, r4);     // Catch: Throwable -> L14
    L8:
        if (r0 == null) goto L10;
        r0 = a(r6, r4, r5, r0);     // Catch: Throwable -> L14
    L10:
        if (r0 == null) goto L12;
        q.b(r0);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized void a(Context r3) {
        monitor-enter(this);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        androidx.b.d r5 = (androidx.b.d) ZeusTransformUtils.preCheckCast(this.g.get(r4), androidx.b.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        if (r5 == null) goto L6;
        r5.d();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static long a(TypedValue r4) {
        return (((long) r4.assetCookie) << 32) | ((long) r4.data);
    }

    private Drawable c(Context r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (this.h != null) goto L5;
        this.h = new TypedValue();
    L5:
        TypedValue r0 = this.h;
        ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getValue(r6, r0, true);
        long r1 = a(r0);
        Drawable r3 = a(r7, r1);
        if (r3 == null) goto L8;
        return r3;
    L8:
        f r4 = this.j;
        if (r4 != null) goto L11;
        Drawable r8 = null;
    L12:
        if (r8 == null) goto L14;
        r8.setChangingConfigurations(r0.changingConfigurations);
        a(r7, r1, r8);
    L14:
        return r8;
    L11:
        r8 = r4.a(this, r7, r6);
        goto L12
    }

    private Drawable a(Context r3, int r4, boolean r5, Drawable r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ColorStateList r0 = b(r7, r4);
        if (r0 != null) goto L5;
        f r1 = this.j;
        if (r1 == null) goto L16;
        if (r1.a(r7, r4, r6) == false) goto L16;
        return r6;
    L16:
        if (a(r7, r4, r6) == true) goto L22;
        if (r5 == false) goto L23;
        return null;
    L23:
        return r6;
    L22:
        return r6;
    L5:
        if (q.c(r6) == false) goto L7;
        r6 = r6.mutate();
    L7:
        Drawable r8 = androidx.core.graphics.drawable.a.g(r6);
        androidx.core.graphics.drawable.a.a(r8, r0);
        PorterDuff.Mode r2 = a(r4);
        if (r2 == null) goto L20;
        androidx.core.graphics.drawable.a.a(r8, r2);
        return r8;
    L20:
        return r8;
    }

    private Drawable d(Context r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        androidx.b.g<String, e> r0 = this.f482e;
        if (r0 != null) goto L5;
    L43:
        return null;
    L5:
        if (r0.isEmpty() == true) goto L43;
        androidx.b.h<String> r1 = this.f;
        if (r1 == null) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.a(r13), String.class, "com.obric.aiagent.plugin");
        if ("appcompat_skip_skip".equals(r2) == true) goto L13;
        if (r2 == null) goto L16;
        if (this.f482e.get(r2) == null) goto L13;
    L16:
        if (this.h != null) goto L18;
        this.h = new TypedValue();
    L18:
        TypedValue r3 = this.h;
        Resources r4 = ZeusTransformUtils.getResources(r14, "com.obric.aiagent.plugin");
        r4.getValue(r13, r3, true);
        long r5 = a(r3);
        Drawable r7 = a(r14, r5);
        if (r7 == null) goto L22;
        return r7;
    L22:
        if (r3.string != null) goto L24;
    L40:
        if (r7 != null) goto L42;
        this.f.c(r13, "appcompat_skip_skip");
    L42:
        return r7;
    L24:
        if (r3.string.toString().endsWith(".xml") == false) goto L40;
        XmlResourceParser r6 = r4.getXml(r13);     // Catch: Exception -> L38
        AttributeSet r8 = Xml.asAttributeSet(r6);     // Catch: Exception -> L38
    L26:
        int r9 = r6.next();     // Catch: Exception -> L38
        if (r9 == 2) goto L30;
        if (r9 != 1) goto L26;
    L30:
        if (r9 != 2) goto L37;
        String r10 = r6.getName();     // Catch: Exception -> L38
        this.f.c(r13, r10);     // Catch: Exception -> L38
        e r11 = (e) ZeusTransformUtils.preCheckCast(this.f482e.get(r10), e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L38
        if (r11 == null) goto L34;
        r7 = r11.a(r14, r6, r8, r14.getTheme());     // Catch: Exception -> L38
    L34:
        if (r7 == null) goto L40;
        r7.setChangingConfigurations(r3.changingConfigurations);     // Catch: Exception -> L38
        a(r14, r5, r7);     // Catch: Exception -> L38
        goto L40
    L37:
        throw new XmlPullParserException("No start tag found");     // Catch: Exception -> L38
    L38:
        e = move-exception;
        a(TAG, "Exception while inflating drawable", e);
    L13:
        return null;
    L14:
        this.f = new androidx.b.h();
        goto L16
    }

    private synchronized Drawable a(Context r6, long r7) {
        monitor-enter(this);
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        androidx.b.d r0 = (androidx.b.d) ZeusTransformUtils.preCheckCast(this.g.get(r8), androidx.b.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (r0 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.a(r7), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (r2 == null) goto L16;
        Drawable.ConstantState r3 = (Drawable.ConstantState) ZeusTransformUtils.preCheckCast(r2.get(), Drawable.ConstantState.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (r3 == null) goto L15;
        Drawable r9 = r3.newDrawable(ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
        monitor-exit(this);
        return r9;
    L15:
        r0.b(r7);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return null;
    L18:
        th = move-exception;
        throw th;
    }

    private synchronized boolean a(Context r4, long r5, Drawable r7) {
        monitor-enter(this);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        Drawable.ConstantState r8 = r7.getConstantState();     // Catch: Throwable -> L15
        if (r8 == null) goto L13;
        androidx.b.d<WeakReference<Drawable.ConstantState>> r0 = (androidx.b.d) ZeusTransformUtils.preCheckCast(this.g.get(r6), androidx.b.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r0 != null) goto L8;
        r0 = new androidx.b.d();     // Catch: Throwable -> L15
        this.g.put(r6, r0);     // Catch: Throwable -> L15
    L8:
        r0.b(r5, new WeakReference(r8));     // Catch: Throwable -> L15
        monitor-exit(this);
        return true;
    L13:
        monitor-exit(this);
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    synchronized Drawable a(Context r3, VectorEnabledTintResources r4, int r5) {
        monitor-enter(this);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        Drawable r0 = d(r6, r5);     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
        r0 = r4.getDrawableCanonical(r5);     // Catch: Throwable -> L13
    L6:
        if (r0 == null) goto L11;
        Drawable r7 = a(r6, r5, false, r0);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r7;
    L11:
        monitor-exit(this);
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    boolean a(Context r3, int r4, Drawable r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        f r2 = this.j;
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.b(r6, r4, r5) == false) goto L7;
        return true;
    }

    private void a(String r3, e r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.aiagent.plugin");
        if (this.f482e != null) goto L5;
        this.f482e = new androidx.b.g();
    L5:
        this.f482e.put(r3, r5);
    }

    PorterDuff.Mode a(int r1) {
        f r0 = this.j;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a(r1);
    }

    synchronized ColorStateList b(Context r3, int r4) {
        monitor-enter(this);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        ColorStateList r0 = e(r5, r4);     // Catch: Throwable -> L13
        if (r0 != null) goto L11;
        f r1 = this.j;     // Catch: Throwable -> L13
        if (r1 != null) goto L8;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
        a(r5, r4, r0);     // Catch: Throwable -> L13
        goto L11
    L8:
        r0 = r1.a(r5, r4);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return r0;
    L13:
        th = move-exception;
        throw th;
    }

    private ColorStateList e(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        WeakHashMap<Context, androidx.b.h<ColorStateList>> r2 = this.f481d;
        if (r2 == null) goto L8;
        androidx.b.h r6 = (androidx.b.h) ZeusTransformUtils.preCheckCast(r2.get(r5), androidx.b.h.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        return null;
    L7:
        return (ColorStateList) ZeusTransformUtils.preCheckCast(r6.a(r4), ColorStateList.class, "com.obric.aiagent.plugin");
    L8:
        return null;
    }

    private void a(Context r4, int r5, ColorStateList r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (this.f481d != null) goto L5;
        this.f481d = new WeakHashMap();
    L5:
        androidx.b.h<ColorStateList> r0 = (androidx.b.h) ZeusTransformUtils.preCheckCast(this.f481d.get(r7), androidx.b.h.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        r0 = new androidx.b.h();
        this.f481d.put(r7, r0);
    L8:
        r0.c(r5, r6);
    }

    static void a(Drawable r3, x r4, int[] r5) {
        int[] r0 = r3.getState();
        if (q.c(r3) == false) goto L12;
        if (r3.mutate() != r3) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        a(TAG, "Mutated drawable is not the same instance as the input.");
        return;
    L7:
        r1 = false;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, LayerDrawable.class) == false) goto L17;
        if (r3.isStateful() == false) goto L17;
        r3.setState(new int[0]);
        r3.setState(r0);
    L17:
        if (r4.f496d == true) goto L23;
        if (r4.f495c == true) goto L23;
        r3.clearColorFilter();
    L32:
        if (Build.VERSION.SDK_INT > 23) goto L35;
        r3.invalidateSelf();
        return;
    L35:
        return;
    L23:
        if (r4.f496d == false) goto L25;
        ColorStateList r2 = r4.f493a;
    L27:
        if (r4.f495c == false) goto L29;
        PorterDuff.Mode r6 = r4.f494b;
    L30:
        r3.setColorFilter(a(r2, r6, r5));
        goto L32
    L29:
        r6 = f478a;
        goto L30
    L25:
        r2 = null;
        goto L27
    }

    private static PorterDuffColorFilter a(ColorStateList r1, PorterDuff.Mode r2, int[] r3) {
        if (r1 == null) goto L7;
        if (r2 != null) goto L6;
        return null;
    L6:
        return a(r1.getColorForState(r3, 0), r2);
    L7:
        return null;
    }

    public static synchronized PorterDuffColorFilter a(int r3, PorterDuff.Mode r4) {
        monitor-enter(u.class);
        c r1 = f480c;     // Catch: Throwable -> L9
        PorterDuffColorFilter r2 = r1.a(r3, r4);     // Catch: Throwable -> L9
        if (r2 != null) goto L7;
        r2 = new PorterDuffColorFilter(r3, r4);     // Catch: Throwable -> L9
        r1.a(r3, r4, r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(u.class);
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    private void b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (this.i == false) goto L5;
        return;
    L5:
        this.i = true;
        Drawable r6 = a(r5, ZeusTransformUtils.mapRes(R.drawable.abc_vector_test, "drawable", "abc_vector_test"));
        if (r6 != null) goto L8;
    L10:
        this.i = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    L8:
        if (a(r6) == false) goto L10;
    }

    private static boolean a(Drawable r1) {
        if (ZeusTransformUtils.instanceOf(r1, VectorDrawableCompat.class) == false) goto L5;
    L8:
        return true;
    L5:
        if ("android.graphics.drawable.VectorDrawable".equals(r1.getClass().getName()) == true) goto L8;
        return false;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
