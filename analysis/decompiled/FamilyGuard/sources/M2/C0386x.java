package M2;

import L2.e;
import V3.n;
import android.content.res.ColorStateList;
import android.graphics.Path;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import i4.InterfaceC0772l;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: M2.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0386x implements K2.s {

    /* renamed from: t, reason: collision with root package name */
    public static final a f4095t = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final e.c f4096a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f4097b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakReference<View> f4098c;

    /* renamed from: d, reason: collision with root package name */
    private A f4099d;

    /* renamed from: e, reason: collision with root package name */
    private final Path f4100e;

    /* renamed from: f, reason: collision with root package name */
    private Object f4101f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4102g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4103h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<ViewTreeObserver> f4104i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4105j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4106k;

    /* renamed from: l, reason: collision with root package name */
    private int f4107l;

    /* renamed from: m, reason: collision with root package name */
    private ColorStateList f4108m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4109n;

    /* renamed from: o, reason: collision with root package name */
    private final View.OnLayoutChangeListener f4110o;

    /* renamed from: p, reason: collision with root package name */
    private final d f4111p;

    /* renamed from: q, reason: collision with root package name */
    private final c f4112q;

    /* renamed from: r, reason: collision with root package name */
    private final b f4113r;

    /* renamed from: s, reason: collision with root package name */
    private final Class<?> f4114s;

    /* renamed from: M2.x$a */
    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: M2.x$b */
    public static final class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            j4.k.g(view, "v");
            if (C0386x.this.f4105j) {
                C0386x.this.f4105j = false;
                C0386x.this.x();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            j4.k.g(view, "v");
            C0386x.this.n();
        }
    }

    /* renamed from: M2.x$c */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() throws IllegalArgumentException {
            A a6;
            C0386x.this.n();
            if (((View) C0386x.this.f4098c.get()) == null || (a6 = C0386x.this.f4099d) == null) {
                return true;
            }
            C0386x.this.z(C0388z.a(a6));
            return true;
        }
    }

    /* renamed from: M2.x$d */
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            C0386x.this.f4107l = 0;
            C0386x.this.x();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }
    }

    public C0386x(View view, e.c cVar, boolean z5) {
        Object objA;
        j4.k.g(view, "view");
        j4.k.g(cVar, "token");
        this.f4096a = cVar;
        this.f4097b = z5;
        this.f4098c = new WeakReference<>(view);
        this.f4100e = new Path();
        this.f4110o = new View.OnLayoutChangeListener() { // from class: M2.s
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) throws IllegalArgumentException {
                C0386x.p(this.f4086a, view2, i5, i6, i7, i8, i9, i10, i11, i12);
            }
        };
        this.f4111p = new d();
        this.f4112q = new c();
        this.f4113r = new b();
        try {
            n.a aVar = V3.n.f5531a;
            objA = V3.n.a(Class.forName("com.android.internal.graphics.backdrop.BackdropLayerDrawable$PathProvider"));
        } catch (Throwable th) {
            n.a aVar2 = V3.n.f5531a;
            objA = V3.n.a(V3.o.a(th));
        }
        this.f4114s = (Class) (V3.n.c(objA) ? null : objA);
        view.addOnLayoutChangeListener(this.f4110o);
        view.addOnAttachStateChangeListener(this.f4113r);
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView != null) {
            textView.addTextChangedListener(this.f4111p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        ViewTreeObserver viewTreeObserver;
        WeakReference<ViewTreeObserver> weakReference = this.f4104i;
        if (weakReference != null && (viewTreeObserver = weakReference.get()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f4112q);
        }
        this.f4104i = null;
        this.f4103h = false;
    }

    private final void o(View view) {
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView == null) {
            return;
        }
        if (!this.f4109n) {
            this.f4108m = textView.getTextColors();
            this.f4109n = true;
        } else if (textView.getCurrentTextColor() == 0) {
            return;
        }
        textView.setTextColor(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(C0386x c0386x, View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) throws IllegalArgumentException {
        A a6;
        if ((view.getWidth() == i11 - i9 && view.getHeight() == i12 - i10 && !c0386x.f4106k) || (a6 = c0386x.f4099d) == null) {
            return;
        }
        c0386x.z(C0388z.a(a6));
    }

    private final Object q(Class<?> cls) throws IllegalArgumentException {
        Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: M2.w
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return C0386x.r(this.f4094a, obj, method, objArr);
            }
        });
        j4.k.f(objNewProxyInstance, "newProxyInstance(...)");
        return objNewProxyInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object r(C0386x c0386x, Object obj, Method method, Object[] objArr) {
        if (j4.k.b(method.getName(), "providePath")) {
            return c0386x.f4100e;
        }
        if (j4.k.b(method.getName(), "hashCode")) {
            return Integer.valueOf(System.identityHashCode(obj));
        }
        boolean z5 = false;
        if (j4.k.b(method.getName(), "equals")) {
            if (objArr != null) {
                if (!(objArr.length == 0) && objArr[0] == obj) {
                    z5 = true;
                }
            }
            return Boolean.valueOf(z5);
        }
        if (j4.k.b(method.getName(), "toString")) {
            return "GlyphPathProvider";
        }
        if (method.getReturnType().isArray()) {
            return Array.newInstance(method.getReturnType().getComponentType(), 0);
        }
        return null;
    }

    private final void s(Path path, final A a6) throws IllegalArgumentException {
        final Class<?> cls = this.f4114s;
        if (cls == null) {
            return;
        }
        this.f4100e.rewind();
        this.f4100e.addPath(path);
        this.f4100e.setFillType(Path.FillType.WINDING);
        final Object objQ = this.f4101f;
        if (objQ == null) {
            objQ = q(cls);
            this.f4101f = objQ;
        }
        this.f4096a.b(new InterfaceC0772l() { // from class: M2.u
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C0386x.t(this.f4089a, cls, a6, objQ, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v t(C0386x c0386x, Class cls, A a6, Object obj, Object obj2) {
        View view;
        j4.k.g(obj2, "d");
        if (c0386x.f4102g) {
            L2.e.f3817a.g(obj2, "setPathProvider", new Class[]{cls}, null);
        }
        if (c0386x.f4097b) {
            L2.e eVar = L2.e.f3817a;
            eVar.g(obj2, "setColor", new Class[]{eVar.l()}, 0);
        }
        L2.e eVar2 = L2.e.f3817a;
        eVar2.g(obj2, "setGlassText", new Class[]{eVar2.j(), eVar2.k(), eVar2.k()}, Boolean.valueOf(!c0386x.f4097b), Float.valueOf(a6.g()), Float.valueOf(a6.f()));
        eVar2.g(obj2, "setPathProvider", new Class[]{cls}, obj);
        c0386x.f4102g = true;
        if (c0386x.f4097b && (view = c0386x.f4098c.get()) != null) {
            c0386x.o(view);
        }
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v v(Class cls, C0386x c0386x, Object obj) {
        j4.k.g(obj, "d");
        if (cls != null) {
            L2.e.f3817a.g(obj, "setPathProvider", new Class[]{cls}, null);
        }
        L2.e eVar = L2.e.f3817a;
        eVar.g(obj, "setGlassText", new Class[]{eVar.j(), eVar.k(), eVar.k()}, Boolean.FALSE, Float.valueOf(96.0f), Float.valueOf(0.0f));
        if (c0386x.f4097b) {
            eVar.g(obj, "setColor", new Class[]{eVar.l()}, -1);
        }
        return V3.v.f5542a;
    }

    private final void w(View view) {
        if (this.f4109n) {
            this.f4109n = false;
            ColorStateList colorStateList = this.f4108m;
            this.f4108m = null;
            TextView textView = view instanceof TextView ? (TextView) view : null;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        View view = this.f4098c.get();
        if (view == null || this.f4103h) {
            return;
        }
        if (!view.isAttachedToWindow()) {
            this.f4105j = true;
            return;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            view.post(new Runnable() { // from class: M2.v
                @Override // java.lang.Runnable
                public final void run() throws IllegalArgumentException {
                    C0386x.y(this.f4093a);
                }
            });
            return;
        }
        this.f4103h = true;
        this.f4104i = new WeakReference<>(viewTreeObserver);
        viewTreeObserver.addOnPreDrawListener(this.f4112q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(C0386x c0386x) throws IllegalArgumentException {
        c0386x.u();
    }

    @Override // K2.s
    public void a() {
        View view = this.f4098c.get();
        if (view != null) {
            view.removeOnLayoutChangeListener(this.f4110o);
        }
        if (view != null) {
            view.removeOnAttachStateChangeListener(this.f4113r);
        }
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView != null) {
            textView.removeTextChangedListener(this.f4111p);
        }
        w(view);
        n();
        this.f4105j = false;
        this.f4106k = false;
        this.f4107l = 0;
        this.f4099d = null;
        this.f4101f = null;
        this.f4102g = false;
        this.f4100e.reset();
        final Class<?> cls = this.f4114s;
        this.f4096a.c(new InterfaceC0772l() { // from class: M2.t
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C0386x.v(cls, this, obj);
            }
        });
    }

    public final void u() throws IllegalArgumentException {
        A a6 = this.f4099d;
        if (a6 == null) {
            return;
        }
        z(C0388z.a(a6));
    }

    public void z(K2.E e6) throws IllegalArgumentException {
        j4.k.g(e6, "params");
        A a6 = e6 instanceof A ? (A) e6 : null;
        if (a6 == null) {
            return;
        }
        this.f4099d = a6;
        View view = this.f4098c.get();
        if (view == null) {
            return;
        }
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView == null) {
            return;
        }
        Path pathB = C0388z.b(textView);
        if (!pathB.isEmpty()) {
            this.f4106k = false;
            this.f4107l = 0;
            s(pathB, a6);
            if (!this.f4097b && this.f4114s != null) {
                o(view);
            }
            view.invalidate();
            return;
        }
        CharSequence text = textView.getText();
        if (text == null || text.length() == 0) {
            Log.w("MotionKit.GlassText", "glass text path empty (no text); clearing prior outline");
            s(pathB, a6);
            return;
        }
        if (textView.getLayout() == null) {
            this.f4106k = true;
            Log.w("MotionKit.GlassText", "glass text path empty (layout null); waiting for next layout pass");
            return;
        }
        int i5 = this.f4107l;
        if (i5 < 3) {
            this.f4107l = i5 + 1;
            Log.w("MotionKit.GlassText", "glass text path empty (outline outside view); retry on next pre-draw");
            x();
        } else {
            Log.w("MotionKit.GlassText", "glass text path empty (outline outside view); gave up after " + i5 + " retries");
        }
    }
}
