package h;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m.c1;
import m.q2;
import m.v2;
import p.p0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 extends q implements l.j, LayoutInflater.Factory2 {

    /* renamed from: j0, reason: collision with root package name */
    public static final p0 f4783j0 = new p0(0);

    /* renamed from: k0, reason: collision with root package name */
    public static final int[] f4784k0 = {R.attr.windowBackground};

    /* renamed from: l0, reason: collision with root package name */
    public static final boolean f4785l0 = !"robolectric".equals(Build.FINGERPRINT);
    public boolean B;
    public ViewGroup C;
    public TextView D;
    public View E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public d0[] N;
    public d0 O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public Configuration T;
    public final int U;
    public int V;
    public int W;
    public boolean X;
    public z Y;
    public z Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f4786a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f4787b0;

    /* renamed from: c0, reason: collision with root package name */
    public final r f4788c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f4789d0;
    public Rect e0;
    public Rect f0;

    /* renamed from: g0, reason: collision with root package name */
    public h0 f4790g0;

    /* renamed from: h0, reason: collision with root package name */
    public OnBackInvokedDispatcher f4791h0;

    /* renamed from: i0, reason: collision with root package name */
    public OnBackInvokedCallback f4792i0;

    /* renamed from: k, reason: collision with root package name */
    public final Object f4793k;

    /* renamed from: l, reason: collision with root package name */
    public final Context f4794l;

    /* renamed from: m, reason: collision with root package name */
    public Window f4795m;

    /* renamed from: n, reason: collision with root package name */
    public y f4796n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f4797o;

    /* renamed from: p, reason: collision with root package name */
    public o0 f4798p;

    /* renamed from: q, reason: collision with root package name */
    public k.i f4799q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f4800r;

    /* renamed from: s, reason: collision with root package name */
    public ActionBarOverlayLayout f4801s;

    /* renamed from: t, reason: collision with root package name */
    public a1.g f4802t;

    /* renamed from: u, reason: collision with root package name */
    public s f4803u;

    /* renamed from: v, reason: collision with root package name */
    public k.a f4804v;

    /* renamed from: w, reason: collision with root package name */
    public ActionBarContextView f4805w;

    /* renamed from: x, reason: collision with root package name */
    public PopupWindow f4806x;

    /* renamed from: y, reason: collision with root package name */
    public r f4807y;

    /* renamed from: z, reason: collision with root package name */
    public n3.o0 f4808z = null;
    public final boolean A = true;

    public e0(Context context, Window window, l lVar, Object obj) {
        k kVar = null;
        this.U = -100;
        r rVar = new r(0);
        rVar.f4891f = this;
        VarHandle.storeStoreFence();
        this.f4788c0 = rVar;
        this.f4794l = context;
        this.f4797o = lVar;
        this.f4793k = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof k)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    } else {
                        kVar = (k) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (kVar != null) {
                this.U = ((e0) kVar.c()).U;
            }
        }
        if (this.U == -100) {
            String name = this.f4793k.getClass().getName();
            p0 p0Var = f4783j0;
            Integer num = (Integer) p0Var.get(name);
            if (num != null) {
                this.U = num.intValue();
                p0Var.remove(this.f4793k.getClass().getName());
            }
        }
        if (window != null) {
            n(window);
        }
        m.s.c();
    }

    public static Configuration r(Context context, int i, Configuration configuration, boolean z10) {
        int i3 = i != 1 ? i != 2 ? z10 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    public final int A(int i, Context context) {
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            od.f.e("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                            return 0;
                        }
                        if (this.Z == null) {
                            this.Z = new z(this, context);
                        }
                        return this.Z.f();
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return w(context).f();
                }
            }
            return i;
        }
        return -1;
    }

    public final boolean B() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        c1 c1Var;
        q2 q2Var;
        boolean z10 = this.P;
        this.P = false;
        d0 d0VarX = x(0);
        if (!d0VarX.f4777m) {
            k.a aVar = this.f4804v;
            if (aVar != null) {
                aVar.a();
                return true;
            }
            y();
            o0 o0Var = this.f4798p;
            if (o0Var == null || (c1Var = o0Var.f4866e) == null || (q2Var = ((v2) c1Var).f8097a.P) == null || q2Var.f8052f == null) {
                return false;
            }
            q2 q2Var2 = ((v2) c1Var).f8097a.P;
            l.n nVar = q2Var2 == null ? null : q2Var2.f8052f;
            if (nVar != null) {
                nVar.collapseActionView();
            }
        } else if (!z10) {
            q(d0VarX, true);
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x017a, code lost:
    
        if (r2.f7575j.getCount() > 0) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(h.d0 r18, android.view.KeyEvent r19) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e0.C(h.d0, android.view.KeyEvent):void");
    }

    public final boolean D(d0 d0Var, int i, KeyEvent keyEvent) {
        l.l lVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((d0Var.f4775k || E(d0Var, keyEvent)) && (lVar = d0Var.f4773h) != null) {
            return lVar.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean E(h.d0 r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e0.E(h.d0, android.view.KeyEvent):boolean");
    }

    public final void F() {
        if (this.B) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void G() {
        OnBackInvokedCallback onBackInvokedCallback;
        boolean z10 = false;
        if (this.f4791h0 != null && (x(0).f4777m || this.f4804v != null)) {
            z10 = true;
        }
        if (z10 && this.f4792i0 == null) {
            this.f4792i0 = x.b(this.f4791h0, this);
        } else {
            if (z10 || (onBackInvokedCallback = this.f4792i0) == null) {
                return;
            }
            x.c(this.f4791h0, onBackInvokedCallback);
            this.f4792i0 = null;
        }
    }

    @Override // h.q
    public final void a() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f4794l);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof e0) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // h.q
    public final void c() throws PackageManager.NameNotFoundException {
        String strD;
        this.Q = true;
        m(false);
        v();
        Object obj = this.f4793k;
        if (obj instanceof Activity) {
            try {
                strD = d3.a.d((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strD = null;
            }
            if (strD != null) {
                o0 o0Var = this.f4798p;
                if (o0Var == null) {
                    this.f4789d0 = true;
                } else {
                    o0Var.d(true);
                }
            }
            synchronized (q.f4889j) {
                q.e(this);
                q.i.add(new WeakReference(this));
            }
        }
        this.T = new Configuration(this.f4794l.getResources().getConfiguration());
        this.R = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // h.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f4793k
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = h.q.f4889j
            monitor-enter(r0)
            h.q.e(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r3
        L11:
            boolean r0 = r3.f4786a0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f4795m
            android.view.View r0 = r0.getDecorView()
            h.r r1 = r3.f4788c0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.S = r0
            int r0 = r3.U
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f4793k
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            p.p0 r0 = h.e0.f4783j0
            java.lang.Object r1 = r3.f4793k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.U
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            p.p0 r0 = h.e0.f4783j0
            java.lang.Object r1 = r3.f4793k
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            h.z r0 = r3.Y
            if (r0 == 0) goto L63
            r0.c()
        L63:
            h.z r3 = r3.Z
            if (r3 == 0) goto L6a
            r3.c()
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e0.d():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        if (r6.h() != false) goto L20;
     */
    @Override // l.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(l.l r6) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e0.f(l.l):void");
    }

    @Override // h.q
    public final boolean g(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.L && i == 108) {
            return false;
        }
        if (this.H && i == 1) {
            this.H = false;
        }
        if (i == 1) {
            F();
            this.L = true;
            return true;
        }
        if (i == 2) {
            F();
            this.F = true;
            return true;
        }
        if (i == 5) {
            F();
            this.G = true;
            return true;
        }
        if (i == 10) {
            F();
            this.J = true;
            return true;
        }
        if (i == 108) {
            F();
            this.H = true;
            return true;
        }
        if (i != 109) {
            return this.f4795m.requestFeature(i);
        }
        F();
        this.I = true;
        return true;
    }

    @Override // h.q
    public final void h(int i) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        u();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f4794l).inflate(i, viewGroup);
        this.f4796n.a(this.f4795m.getCallback());
    }

    @Override // h.q
    public final void i(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        u();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f4796n.a(this.f4795m.getCallback());
    }

    @Override // l.j
    public final boolean j(l.l lVar, MenuItem menuItem) {
        d0 d0Var;
        Window.Callback callback = this.f4795m.getCallback();
        if (callback != null && !this.S) {
            l.l lVarK = lVar.k();
            d0[] d0VarArr = this.N;
            int length = d0VarArr != null ? d0VarArr.length : 0;
            int i = 0;
            while (true) {
                if (i < length) {
                    d0Var = d0VarArr[i];
                    if (d0Var != null && d0Var.f4773h == lVarK) {
                        break;
                    }
                    i++;
                } else {
                    d0Var = null;
                    break;
                }
            }
            if (d0Var != null) {
                return callback.onMenuItemSelected(d0Var.f4766a, menuItem);
            }
        }
        return false;
    }

    @Override // h.q
    public final void k(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        u();
        ViewGroup viewGroup = (ViewGroup) this.C.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f4796n.a(this.f4795m.getCallback());
    }

    @Override // h.q
    public final void l(CharSequence charSequence) {
        this.f4800r = charSequence;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f4801s;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setWindowTitle(charSequence);
            return;
        }
        o0 o0Var = this.f4798p;
        if (o0Var == null) {
            TextView textView = this.D;
            if (textView != null) {
                textView.setText(charSequence);
                return;
            }
            return;
        }
        v2 v2Var = (v2) o0Var.f4866e;
        if (v2Var.f8103g) {
            return;
        }
        Toolbar toolbar = v2Var.f8097a;
        v2Var.f8104h = charSequence;
        if ((v2Var.f8098b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (v2Var.f8103g) {
                n3.k0.h(toolbar.getRootView(), charSequence);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(boolean r11) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e0.m(boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(android.view.Window r8) {
        /*
            r7 = this;
            java.lang.String r0 = "AppCompat has already installed itself into the Window"
            android.view.Window r1 = r7.f4795m
            if (r1 != 0) goto L78
            android.view.Window$Callback r1 = r8.getCallback()
            boolean r2 = r1 instanceof h.y
            if (r2 != 0) goto L74
            h.y r0 = new h.y
            r0.<init>(r7, r1)
            r7.f4796n = r0
            r8.setCallback(r0)
            android.content.Context r0 = r7.f4794l
            int[] r1 = h.e0.f4784k0
            r2 = 0
            android.content.res.TypedArray r1 = r0.obtainStyledAttributes(r2, r1)
            r3 = 0
            boolean r4 = r1.hasValue(r3)
            if (r4 == 0) goto L3f
            int r3 = r1.getResourceId(r3, r3)
            if (r3 == 0) goto L3f
            m.s r4 = m.s.a()
            monitor-enter(r4)
            m.d2 r5 = r4.f8062a     // Catch: java.lang.Throwable -> L3c
            r6 = 1
            android.graphics.drawable.Drawable r0 = r5.e(r0, r3, r6)     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r4)
            goto L40
        L3c:
            r7 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3c
            throw r7
        L3f:
            r0 = r2
        L40:
            if (r0 == 0) goto L45
            r8.setBackgroundDrawable(r0)
        L45:
            r1.recycle()
            r7.f4795m = r8
            android.window.OnBackInvokedDispatcher r8 = r7.f4791h0
            if (r8 != 0) goto L73
            java.lang.Object r0 = r7.f4793k
            if (r8 == 0) goto L5b
            android.window.OnBackInvokedCallback r1 = r7.f4792i0
            if (r1 == 0) goto L5b
            h.x.c(r8, r1)
            r7.f4792i0 = r2
        L5b:
            boolean r8 = r0 instanceof android.app.Activity
            if (r8 == 0) goto L6e
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r8 = r0.getWindow()
            if (r8 == 0) goto L6e
            android.window.OnBackInvokedDispatcher r8 = h.x.a(r0)
            r7.f4791h0 = r8
            goto L70
        L6e:
            r7.f4791h0 = r2
        L70:
            r7.G()
        L73:
            return
        L74:
            od.f.e(r0)
            return
        L78:
            od.f.e(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e0.n(android.view.Window):void");
    }

    public final void o(int i, d0 d0Var, l.l lVar) {
        if (lVar == null) {
            if (d0Var == null && i >= 0) {
                d0[] d0VarArr = this.N;
                if (i < d0VarArr.length) {
                    d0Var = d0VarArr[i];
                }
            }
            if (d0Var != null) {
                lVar = d0Var.f4773h;
            }
        }
        if ((d0Var == null || d0Var.f4777m) && !this.S) {
            y yVar = this.f4796n;
            Window.Callback callback = this.f4795m.getCallback();
            yVar.getClass();
            try {
                yVar.f4899h = true;
                callback.onPanelClosed(i, lVar);
            } finally {
                yVar.f4899h = false;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(android.view.View r18, java.lang.String r19, android.content.Context r20, android.util.AttributeSet r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 966
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e0.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final void p(l.l lVar) {
        m.k kVar;
        if (this.M) {
            return;
        }
        this.M = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f4801s;
        actionBarOverlayLayout.e();
        ActionMenuView actionMenuView = ((v2) actionBarOverlayLayout.i).f8097a.f804c;
        if (actionMenuView != null && (kVar = actionMenuView.f796x) != null) {
            kVar.f();
            m.g gVar = kVar.f7962x;
            if (gVar != null && gVar.b()) {
                gVar.i.dismiss();
            }
        }
        Window.Callback callback = this.f4795m.getCallback();
        if (callback != null && !this.S) {
            callback.onPanelClosed(108, lVar);
        }
        this.M = false;
    }

    public final void q(d0 d0Var, boolean z10) {
        c0 c0Var;
        ActionBarOverlayLayout actionBarOverlayLayout;
        m.k kVar;
        if (z10 && d0Var.f4766a == 0 && (actionBarOverlayLayout = this.f4801s) != null) {
            actionBarOverlayLayout.e();
            ActionMenuView actionMenuView = ((v2) actionBarOverlayLayout.i).f8097a.f804c;
            if (actionMenuView != null && (kVar = actionMenuView.f796x) != null && kVar.h()) {
                p(d0Var.f4773h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f4794l.getSystemService("window");
        if (windowManager != null && d0Var.f4777m && (c0Var = d0Var.f4770e) != null) {
            windowManager.removeView(c0Var);
            if (z10) {
                o(d0Var.f4766a, d0Var, null);
            }
        }
        d0Var.f4775k = false;
        d0Var.f4776l = false;
        d0Var.f4777m = false;
        d0Var.f4771f = null;
        d0Var.f4778n = true;
        if (this.O == d0Var) {
            this.O = null;
        }
        if (d0Var.f4766a == 0) {
            G();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s(android.view.KeyEvent r7) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.e0.s(android.view.KeyEvent):boolean");
    }

    public final void t(int i) {
        d0 d0VarX = x(i);
        if (d0VarX.f4773h != null) {
            Bundle bundle = new Bundle();
            d0VarX.f4773h.t(bundle);
            if (bundle.size() > 0) {
                d0VarX.f4780p = bundle;
            }
            d0VarX.f4773h.w();
            d0VarX.f4773h.clear();
        }
        d0VarX.f4779o = true;
        d0VarX.f4778n = true;
        if ((i == 108 || i == 0) && this.f4801s != null) {
            d0 d0VarX2 = x(0);
            d0VarX2.f4775k = false;
            E(d0VarX2, null);
        }
    }

    public final void u() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        if (this.B) {
            return;
        }
        Context context = this.f4794l;
        int[] iArr = g.a.f4106j;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(121)) {
            typedArrayObtainStyledAttributes.recycle();
            od.f.e("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
            return;
        }
        int i = 0;
        if (typedArrayObtainStyledAttributes.getBoolean(130, false)) {
            g(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(121, false)) {
            g(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(122, false)) {
            g(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(123, false)) {
            g(10);
        }
        this.K = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        v();
        this.f4795m.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.L) {
            viewGroup = this.J ? (ViewGroup) layoutInflaterFrom.inflate(com.stepos.agentsafetycenter.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.stepos.agentsafetycenter.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.K) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.stepos.agentsafetycenter.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.I = false;
            this.H = false;
        } else if (this.H) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.stepos.agentsafetycenter.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new k.c(context, typedValue.resourceId) : context).inflate(com.stepos.agentsafetycenter.R.layout.abc_screen_toolbar, (ViewGroup) null);
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) viewGroup.findViewById(com.stepos.agentsafetycenter.R.id.decor_content_parent);
            this.f4801s = actionBarOverlayLayout;
            actionBarOverlayLayout.setWindowCallback(this.f4795m.getCallback());
            if (this.I) {
                this.f4801s.d(109);
            }
            if (this.F) {
                this.f4801s.d(2);
            }
            if (this.G) {
                this.f4801s.d(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            g5.f.c(this.H ? 1 : 0, this.I ? 1 : 0, this.K ? 1 : 0, this.J ? 1 : 0, this.L ? 1 : 0);
            return;
        }
        s sVar = new s();
        sVar.f4892c = this;
        VarHandle.storeStoreFence();
        WeakHashMap weakHashMap = n3.k0.f8724a;
        n3.e0.b(viewGroup, sVar);
        if (this.f4801s == null) {
            this.D = (TextView) viewGroup.findViewById(com.stepos.agentsafetycenter.R.id.title);
        }
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, null);
        } catch (IllegalAccessException e10) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e10);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e11) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e11);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.stepos.agentsafetycenter.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f4795m.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f4795m.setContentView(viewGroup);
        t tVar = new t(i);
        tVar.f4894b = this;
        VarHandle.storeStoreFence();
        contentFrameLayout.setAttachListener(tVar);
        this.C = viewGroup;
        Object obj = this.f4793k;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f4800r;
        if (!TextUtils.isEmpty(title)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4801s;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setWindowTitle(title);
            } else {
                o0 o0Var = this.f4798p;
                if (o0Var != null) {
                    v2 v2Var = (v2) o0Var.f4866e;
                    if (!v2Var.f8103g) {
                        Toolbar toolbar = v2Var.f8097a;
                        v2Var.f8104h = title;
                        if ((v2Var.f8098b & 8) != 0) {
                            toolbar.setTitle(title);
                            if (v2Var.f8103g) {
                                n3.k0.h(toolbar.getRootView(), title);
                            }
                        }
                    }
                } else {
                    TextView textView = this.D;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.C.findViewById(R.id.content);
        View decorView = this.f4795m.getDecorView();
        contentFrameLayout2.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes2.getValue(128, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(129, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(126)) {
            typedArrayObtainStyledAttributes2.getValue(126, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(127)) {
            typedArrayObtainStyledAttributes2.getValue(127, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(124)) {
            typedArrayObtainStyledAttributes2.getValue(124, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(125)) {
            typedArrayObtainStyledAttributes2.getValue(125, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.B = true;
        d0 d0VarX = x(0);
        if (this.S || d0VarX.f4773h != null) {
            return;
        }
        z(108);
    }

    public final void v() {
        if (this.f4795m == null) {
            Object obj = this.f4793k;
            if (obj instanceof Activity) {
                n(((Activity) obj).getWindow());
            }
        }
        if (this.f4795m != null) {
            return;
        }
        od.f.e("We have not been given a Window");
    }

    public final b0 w(Context context) {
        if (this.Y == null) {
            if (p5.m.i == null) {
                Context applicationContext = context.getApplicationContext();
                LocationManager locationManager = (LocationManager) applicationContext.getSystemService("location");
                p5.m mVar = new p5.m(9);
                mVar.f9743h = new l0();
                mVar.f9741f = applicationContext;
                mVar.f9742g = locationManager;
                VarHandle.storeStoreFence();
                p5.m.i = mVar;
            }
            this.Y = new z(this, p5.m.i);
        }
        return this.Y;
    }

    public final d0 x(int i) {
        d0[] d0VarArr = this.N;
        if (d0VarArr == null || d0VarArr.length <= i) {
            d0[] d0VarArr2 = new d0[i + 1];
            if (d0VarArr != null) {
                System.arraycopy(d0VarArr, 0, d0VarArr2, 0, d0VarArr.length);
            }
            this.N = d0VarArr2;
            d0VarArr = d0VarArr2;
        }
        d0 d0Var = d0VarArr[i];
        if (d0Var != null) {
            return d0Var;
        }
        d0 d0Var2 = new d0();
        d0Var2.f4766a = i;
        d0Var2.f4778n = false;
        d0VarArr[i] = d0Var2;
        return d0Var2;
    }

    public final void y() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        u();
        if (this.H && this.f4798p == null) {
            Object obj = this.f4793k;
            int i = 12;
            int i3 = 1;
            int i10 = 0;
            if (obj instanceof Activity) {
                boolean z10 = this.I;
                o0 o0Var = new o0();
                new ArrayList();
                o0Var.f4873m = new ArrayList();
                o0Var.f4874n = 0;
                o0Var.f4875o = true;
                o0Var.f4878r = true;
                o0Var.f4882v = new m0(o0Var, i10);
                o0Var.f4883w = new m0(o0Var, i3);
                o0Var.f4884x = new a1.g(o0Var, i);
                View decorView = ((Activity) obj).getWindow().getDecorView();
                o0Var.c(decorView);
                if (!z10) {
                    o0Var.f4868g = decorView.findViewById(R.id.content);
                }
                VarHandle.storeStoreFence();
                this.f4798p = o0Var;
            } else if (obj instanceof Dialog) {
                o0 o0Var2 = new o0();
                new ArrayList();
                o0Var2.f4873m = new ArrayList();
                o0Var2.f4874n = 0;
                o0Var2.f4875o = true;
                o0Var2.f4878r = true;
                o0Var2.f4882v = new m0(o0Var2, i10);
                o0Var2.f4883w = new m0(o0Var2, i3);
                o0Var2.f4884x = new a1.g(o0Var2, i);
                o0Var2.c(((Dialog) obj).getWindow().getDecorView());
                VarHandle.storeStoreFence();
                this.f4798p = o0Var2;
            }
            o0 o0Var3 = this.f4798p;
            if (o0Var3 != null) {
                o0Var3.d(this.f4789d0);
            }
        }
    }

    public final void z(int i) {
        this.f4787b0 = (1 << i) | this.f4787b0;
        if (this.f4786a0) {
            return;
        }
        View decorView = this.f4795m.getDecorView();
        WeakHashMap weakHashMap = n3.k0.f8724a;
        decorView.postOnAnimation(this.f4788c0);
        this.f4786a0 = true;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
