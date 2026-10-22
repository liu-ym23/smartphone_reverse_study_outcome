package A7;

import android.content.res.ColorStateList;
import android.graphics.Path;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;
import z7.C6370e;

@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0007*\u0003NQT\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0014B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\fJ\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\fJ\u001f\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010$\u001a\u00020#2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030!H\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010&R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010-\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00020\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010(R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010(R\u001e\u0010=\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010,R\u0016\u0010?\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010(R\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010(R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010(R\u0014\u0010M\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010LR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010OR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010RR\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010UR\u001a\u0010Y\u001a\b\u0012\u0002\b\u0003\u0018\u00010!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006Z"}, d2 = {"LA7/w;", "Ly7/s;", "Landroid/view/View;", "view", "Lz7/e$c;", M5.b.CREDENTIAL_TOKEN, "", "blendOnly", "<init>", "(Landroid/view/View;Lz7/e$c;Z)V", "LY8/t;", "v", "()V", "Lkotlin/Function1;", "LA7/z;", "block", "q", "(Lp9/l;)V", "Ly7/F;", "params", Const.INTENT_KEY_APIKEY, "(Ly7/F;)V", "release", "o", "(Landroid/view/View;)V", "x", "n", "y", "Landroid/graphics/Path;", "glyph", "p", "t", "(Landroid/graphics/Path;LA7/z;)V", "Ljava/lang/Class;", "ppClass", "", "r", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lz7/e$c;", Const.INTENT_KEY_PKGNAME, "Z", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "c", "Ljava/lang/ref/WeakReference;", "viewRef", Const.INTENT_KEY_UMID, "LA7/z;", "lastParams", "e", "Landroid/graphics/Path;", "livePath", "f", "Ljava/lang/Object;", "pathProvider", Const.INTENT_KEY_BACKGROUND_COMMAND, "glassTextOn", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "preDrawPending", "Landroid/view/ViewTreeObserver;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "preDrawObs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "refreshPendingOnAttach", "k", "awaitingLayout", "", "l", "I", "scrollRetry", "Landroid/content/res/ColorStateList;", "m", "Landroid/content/res/ColorStateList;", "savedTextColors", "hostTextHidden", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "layoutListener", "A7/w$d", "LA7/w$d;", "textWatcher", "A7/w$c", "LA7/w$c;", "preDrawListener", "A7/w$b", "LA7/w$b;", "attachListener", "s", "Ljava/lang/Class;", "pathProviderClass", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: A7.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0754w implements y7.s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6370e.c token;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean blendOnly;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final WeakReference<View> viewRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public C0757z lastParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Path livePath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Object pathProvider;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean glassTextOn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public boolean preDrawPending;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public WeakReference<ViewTreeObserver> preDrawObs;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean refreshPendingOnAttach;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public boolean awaitingLayout;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public int scrollRetry;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public ColorStateList savedTextColors;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public boolean hostTextHidden;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final View.OnLayoutChangeListener layoutListener;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public final d textWatcher;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final c preDrawListener;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final b attachListener;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final Class<?> pathProviderClass;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"A7/w$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: A7.w$b */
    public static final class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            if (C0754w.this.refreshPendingOnAttach) {
                C0754w.this.refreshPendingOnAttach = false;
                C0754w.this.y();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            C0754w.this.n();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"A7/w$c", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "()Z", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: A7.w$c */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            C0757z c0757z;
            C0754w.this.n();
            if (((View) C0754w.this.viewRef.get()) == null || (c0757z = C0754w.this.lastParams) == null) {
                return true;
            }
            C0754w.this.a(C0756y.a(c0757z));
            return true;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"A7/w$d", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "LY8/t;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: A7.w$d */
    public static final class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            C0754w.this.scrollRetry = 0;
            C0754w.this.y();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
        }
    }

    public C0754w(View view, C6370e.c token, boolean z10) {
        Object objB;
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(token, "token");
        this.token = token;
        this.blendOnly = z10;
        this.viewRef = new WeakReference<>(view);
        this.livePath = new Path();
        this.layoutListener = new View.OnLayoutChangeListener() { // from class: A7.r
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                C0754w.p(this.f1203a, view2, i10, i11, i12, i13, i14, i15, i16, i17);
            }
        };
        this.textWatcher = new d();
        this.preDrawListener = new c();
        this.attachListener = new b();
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Class.forName("com.android.internal.graphics.backdrop.BackdropLayerDrawable$PathProvider"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        this.pathProviderClass = (Class) (Result.g(objB) ? null : objB);
        view.addOnLayoutChangeListener(this.layoutListener);
        view.addOnAttachStateChangeListener(this.attachListener);
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView != null) {
            textView.addTextChangedListener(this.textWatcher);
        }
    }

    public static final void p(C0754w c0754w, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        C0757z c0757z;
        if ((view.getWidth() == i16 - i14 && view.getHeight() == i17 - i15 && !c0754w.awaitingLayout) || (c0757z = c0754w.lastParams) == null) {
            return;
        }
        c0754w.a(C0756y.a(c0757z));
    }

    public static final Object s(C0754w c0754w, Object obj, Method method, Object[] objArr) {
        if (kotlin.jvm.internal.p.d(method.getName(), "providePath")) {
            return c0754w.livePath;
        }
        if (kotlin.jvm.internal.p.d(method.getName(), "hashCode")) {
            return Integer.valueOf(System.identityHashCode(obj));
        }
        boolean z10 = false;
        if (kotlin.jvm.internal.p.d(method.getName(), "equals")) {
            if (objArr != null) {
                if (!(objArr.length == 0) && objArr[0] == obj) {
                    z10 = true;
                }
            }
            return Boolean.valueOf(z10);
        }
        if (kotlin.jvm.internal.p.d(method.getName(), "toString")) {
            return "GlyphPathProvider";
        }
        if (method.getReturnType().isArray()) {
            return Array.newInstance(method.getReturnType().getComponentType(), 0);
        }
        return null;
    }

    public static final Y8.t u(C0754w c0754w, Class cls, C0757z c0757z, Object obj, Object d10) {
        View view;
        kotlin.jvm.internal.p.i(d10, "d");
        if (c0754w.glassTextOn) {
            C6370e.f45191a.g(d10, "setPathProvider", new Class[]{cls}, null);
        }
        if (c0754w.blendOnly) {
            C6370e c6370e = C6370e.f45191a;
            c6370e.g(d10, "setColor", new Class[]{c6370e.l()}, 0);
        }
        C6370e c6370e2 = C6370e.f45191a;
        c6370e2.g(d10, "setGlassText", new Class[]{c6370e2.j(), c6370e2.k(), c6370e2.k()}, Boolean.valueOf(!c0754w.blendOnly), Float.valueOf(c0757z.getSdfScale()), Float.valueOf(c0757z.getErode()));
        c6370e2.g(d10, "setPathProvider", new Class[]{cls}, obj);
        c0754w.glassTextOn = true;
        if (c0754w.blendOnly && (view = c0754w.viewRef.get()) != null) {
            c0754w.o(view);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t w(Class cls, C0754w c0754w, Object d10) {
        kotlin.jvm.internal.p.i(d10, "d");
        if (cls != null) {
            C6370e.f45191a.g(d10, "setPathProvider", new Class[]{cls}, null);
        }
        C6370e c6370e = C6370e.f45191a;
        c6370e.g(d10, "setGlassText", new Class[]{c6370e.j(), c6370e.k(), c6370e.k()}, Boolean.FALSE, Float.valueOf(96.0f), Float.valueOf(0.0f));
        if (c0754w.blendOnly) {
            c6370e.g(d10, "setColor", new Class[]{c6370e.l()}, -1);
        }
        return Y8.t.f7040a;
    }

    public static final void z(C0754w c0754w) {
        c0754w.v();
    }

    @Override // y7.s
    public void a(y7.F params) {
        kotlin.jvm.internal.p.i(params, "params");
        C0757z c0757z = params instanceof C0757z ? (C0757z) params : null;
        if (c0757z == null) {
            return;
        }
        this.lastParams = c0757z;
        View view = this.viewRef.get();
        if (view == null) {
            return;
        }
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView == null) {
            return;
        }
        Path pathB = C0756y.b(textView);
        if (!pathB.isEmpty()) {
            this.awaitingLayout = false;
            this.scrollRetry = 0;
            t(pathB, c0757z);
            if (!this.blendOnly && this.pathProviderClass != null) {
                o(view);
            }
            view.invalidate();
            return;
        }
        CharSequence text = textView.getText();
        if (text == null || text.length() == 0) {
            Log.w("MotionKit.GlassText", "glass text path empty (no text); clearing prior outline");
            t(pathB, c0757z);
            return;
        }
        if (textView.getLayout() == null) {
            this.awaitingLayout = true;
            Log.w("MotionKit.GlassText", "glass text path empty (layout null); waiting for next layout pass");
            return;
        }
        int i10 = this.scrollRetry;
        if (i10 < 3) {
            this.scrollRetry = i10 + 1;
            Log.w("MotionKit.GlassText", "glass text path empty (outline outside view); retry on next pre-draw");
            y();
        } else {
            Log.w("MotionKit.GlassText", "glass text path empty (outline outside view); gave up after " + i10 + " retries");
        }
    }

    public final void n() {
        ViewTreeObserver viewTreeObserver;
        WeakReference<ViewTreeObserver> weakReference = this.preDrawObs;
        if (weakReference != null && (viewTreeObserver = weakReference.get()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.preDrawListener);
        }
        this.preDrawObs = null;
        this.preDrawPending = false;
    }

    public final void o(View v10) {
        TextView textView = v10 instanceof TextView ? (TextView) v10 : null;
        if (textView == null) {
            return;
        }
        if (!this.hostTextHidden) {
            this.savedTextColors = textView.getTextColors();
            this.hostTextHidden = true;
        } else if (textView.getCurrentTextColor() == 0) {
            return;
        }
        textView.setTextColor(0);
    }

    public final void q(InterfaceC5074l<? super C0757z, Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        C0757z c0757z = this.lastParams;
        if (c0757z == null) {
            return;
        }
        C0757z c0757zA = C0756y.a(c0757z);
        block.invoke(c0757zA);
        a(c0757zA);
    }

    public final Object r(Class<?> ppClass) throws IllegalArgumentException {
        Object objNewProxyInstance = Proxy.newProxyInstance(ppClass.getClassLoader(), new Class[]{ppClass}, new InvocationHandler() { // from class: A7.v
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return C0754w.s(this.f1211a, obj, method, objArr);
            }
        });
        kotlin.jvm.internal.p.h(objNewProxyInstance, "newProxyInstance(...)");
        return objNewProxyInstance;
    }

    @Override // y7.s
    public void release() {
        View view = this.viewRef.get();
        if (view != null) {
            view.removeOnLayoutChangeListener(this.layoutListener);
        }
        if (view != null) {
            view.removeOnAttachStateChangeListener(this.attachListener);
        }
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView != null) {
            textView.removeTextChangedListener(this.textWatcher);
        }
        x(view);
        n();
        this.refreshPendingOnAttach = false;
        this.awaitingLayout = false;
        this.scrollRetry = 0;
        this.lastParams = null;
        this.pathProvider = null;
        this.glassTextOn = false;
        this.livePath.reset();
        final Class<?> cls = this.pathProviderClass;
        this.token.c(new InterfaceC5074l() { // from class: A7.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C0754w.w(cls, this, obj);
            }
        });
    }

    public final void t(Path glyph, final C0757z p10) throws IllegalArgumentException {
        final Class<?> cls = this.pathProviderClass;
        if (cls == null) {
            return;
        }
        this.livePath.rewind();
        this.livePath.addPath(glyph);
        this.livePath.setFillType(Path.FillType.WINDING);
        final Object objR = this.pathProvider;
        if (objR == null) {
            objR = r(cls);
            this.pathProvider = objR;
        }
        this.token.b(new InterfaceC5074l() { // from class: A7.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C0754w.u(this.f1206a, cls, p10, objR, obj);
            }
        });
    }

    public final void v() {
        C0757z c0757z = this.lastParams;
        if (c0757z == null) {
            return;
        }
        a(C0756y.a(c0757z));
    }

    public final void x(View v10) {
        if (this.hostTextHidden) {
            this.hostTextHidden = false;
            ColorStateList colorStateList = this.savedTextColors;
            this.savedTextColors = null;
            TextView textView = v10 instanceof TextView ? (TextView) v10 : null;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public final void y() {
        View view = this.viewRef.get();
        if (view == null || this.preDrawPending) {
            return;
        }
        if (!view.isAttachedToWindow()) {
            this.refreshPendingOnAttach = true;
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            view.post(new Runnable() { // from class: A7.u
                @Override // java.lang.Runnable
                public final void run() {
                    C0754w.z(this.f1210a);
                }
            });
            return;
        }
        this.preDrawPending = true;
        this.preDrawObs = new WeakReference<>(viewTreeObserver);
        viewTreeObserver.addOnPreDrawListener(this.preDrawListener);
    }
}
