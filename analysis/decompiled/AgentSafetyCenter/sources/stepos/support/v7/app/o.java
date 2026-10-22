package stepos.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ContentFrameLayout;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.FitsWindowsContentLayout;
import stepos.support.v7.widget.StepOSAppBarLayout;
import stepos.support.v7.widget.StepOSCollapsingToolbarLayout;
import stepos.support.v7.widget.Toolbar;
import stepos.support.v7.widget.x1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class o extends l implements te.j {
    public static r2.i Y;
    public p A;
    public n3.o0 B;
    public boolean C;
    public ViewGroup D;
    public TextView E;
    public View F;
    public boolean G;
    public boolean H;
    public boolean I;
    public r[] J;
    public r K;
    public boolean L;
    public boolean M;
    public int N;
    public p O;
    public boolean P;
    public Rect Q;
    public Rect R;
    public q S;
    public h.b T;
    public int U;
    public boolean V;
    public m W;
    public UiModeManager X;

    /* renamed from: c, reason: collision with root package name */
    public Context f12387c;

    /* renamed from: f, reason: collision with root package name */
    public Window f12388f;

    /* renamed from: g, reason: collision with root package name */
    public Window.Callback f12389g;

    /* renamed from: h, reason: collision with root package name */
    public n f12390h;
    public Object i;

    /* renamed from: j, reason: collision with root package name */
    public c f12391j;

    /* renamed from: k, reason: collision with root package name */
    public se.j f12392k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12393l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12394m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12395n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12396o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12397p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12398q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f12399r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f12400s;

    /* renamed from: t, reason: collision with root package name */
    public int f12401t;

    /* renamed from: u, reason: collision with root package name */
    public stepos.support.v7.widget.b0 f12402u;

    /* renamed from: v, reason: collision with root package name */
    public q f12403v;

    /* renamed from: w, reason: collision with root package name */
    public m f12404w;

    /* renamed from: x, reason: collision with root package name */
    public se.b f12405x;

    /* renamed from: y, reason: collision with root package name */
    public ActionBarContextView f12406y;

    /* renamed from: z, reason: collision with root package name */
    public PopupWindow f12407z;

    public static void k(o oVar, int i) {
        r rVarR = oVar.r(i);
        if (rVarR.f12467h != null) {
            Bundle bundle = new Bundle();
            rVarR.f12467h.s(bundle);
            if (bundle.size() > 0) {
                rVarR.f12474p = bundle;
            }
            rVarR.f12467h.v();
            rVarR.f12467h.clear();
        }
        rVarR.f12473o = true;
        rVarR.f12472n = true;
        if ((i == 108 || i == 0) && oVar.f12402u != null) {
            r rVarR2 = oVar.r(0);
            rVarR2.f12469k = false;
            oVar.x(rVarR2, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    @Override // stepos.support.v7.app.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a() {
        /*
            r10 = this;
            android.content.Context r0 = r10.f12387c
            int r1 = r10.U
            r2 = -1
            r3 = -100
            if (r1 != r3) goto La
            r1 = r2
        La:
            r4 = 2
            r5 = 1
            if (r1 != 0) goto L18
            android.app.UiModeManager r10 = r10.X
            int r10 = r10.getNightMode()
            if (r10 != 0) goto L18
        L16:
            r1 = r2
            goto L59
        L18:
            if (r1 == r3) goto L16
            if (r1 == 0) goto L1d
            goto L59
        L1d:
            r2.i r10 = stepos.support.v7.app.o.Y
            if (r10 != 0) goto L2d
            r2.i r10 = new r2.i
            r0.getApplicationContext()
            r1 = 8
            r10.<init>(r1)
            stepos.support.v7.app.o.Y = r10
        L2d:
            r2.i r10 = stepos.support.v7.app.o.Y
            r10.getClass()
            r6 = 0
            long r8 = java.lang.System.currentTimeMillis()
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L3d
            goto L56
        L3d:
            java.lang.String r10 = "TwilightManager"
            java.lang.String r1 = "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values."
            android.util.Log.i(r10, r1)
            java.util.Calendar r10 = java.util.Calendar.getInstance()
            r1 = 11
            int r10 = r10.get(r1)
            r1 = 6
            if (r10 < r1) goto L58
            r1 = 22
            if (r10 < r1) goto L56
            goto L58
        L56:
            r1 = r5
            goto L59
        L58:
            r1 = r4
        L59:
            if (r1 == r2) goto L81
            android.content.res.Resources r10 = r0.getResources()
            android.content.res.Configuration r0 = r10.getConfiguration()
            int r2 = r0.uiMode
            r2 = r2 & 48
            if (r1 != r4) goto L6c
            r1 = 32
            goto L6e
        L6c:
            r1 = 16
        L6e:
            if (r2 == r1) goto L81
            android.content.res.Configuration r2 = new android.content.res.Configuration
            r2.<init>(r0)
            int r0 = r2.uiMode
            r0 = r0 & (-49)
            r0 = r0 | r1
            r2.uiMode = r0
            r0 = 0
            r10.updateConfiguration(r2, r0)
            return r5
        L81:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.o.a():boolean");
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, stepos.support.v7.app.k] */
    @Override // te.j
    public final boolean c(te.l lVar, MenuItem menuItem) {
        r rVar;
        Window.Callback callback = this.f12388f.getCallback();
        if (callback != null && !this.f12400s) {
            te.l lVarK = lVar.k();
            r[] rVarArr = this.J;
            int length = rVarArr != null ? rVarArr.length : 0;
            int i = 0;
            while (true) {
                if (i < length) {
                    rVar = rVarArr[i];
                    if (rVar != null && rVar.f12467h == lVarK) {
                        break;
                    }
                    i++;
                } else {
                    rVar = null;
                    break;
                }
            }
            if (rVar != null) {
                int i3 = rVar.f12460a;
                boolean zOnMenuItemSelected = callback.onMenuItemSelected(i3, menuItem);
                return (zOnMenuItemSelected || !(menuItem instanceof te.h)) ? zOnMenuItemSelected : this.i.onMenuItemSelected(i3, (te.h) menuItem);
            }
        }
        return false;
    }

    @Override // te.j
    public final void d(te.l lVar) {
        p pVar = this.O;
        Window window = this.f12388f;
        stepos.support.v7.widget.b0 b0Var = this.f12402u;
        if (b0Var == null || !b0Var.d() || (ViewConfiguration.get(this.f12387c).hasPermanentMenuKey() && !this.f12402u.e())) {
            r rVarR = r(0);
            rVarR.f12472n = true;
            n(rVarR, false);
            u(rVarR, null);
            return;
        }
        Window.Callback callback = window.getCallback();
        if (this.f12402u.a()) {
            this.f12402u.f();
            if (this.f12400s) {
                return;
            }
            callback.onPanelClosed(108, r(0).f12467h);
            return;
        }
        if (callback == null || this.f12400s) {
            return;
        }
        if (this.M && (1 & this.N) != 0) {
            window.getDecorView().removeCallbacks(pVar);
            pVar.run();
        }
        r rVarR2 = r(0);
        te.l lVar2 = rVarR2.f12467h;
        if (lVar2 == null || rVarR2.f12473o || !callback.onPreparePanel(0, rVarR2.f12466g, lVar2)) {
            return;
        }
        callback.onMenuOpened(108, rVarR2.f12467h);
        this.f12402u.g();
    }

    @Override // stepos.support.v7.app.l
    public final void e() {
        s();
        c cVar = this.f12391j;
        if (cVar == null || !cVar.e()) {
            t(0);
        }
    }

    @Override // stepos.support.v7.app.l
    public final void f(Bundle bundle) {
        int i;
        Window window = this.f12388f;
        if ((x1.f12901a == null || x1.f12902b == null) && ((i = x1.f12903c) == 2 || i == 0)) {
            new j6.h().start();
            x1.f12903c = 1;
        }
        Window.Callback callback = this.f12389g;
        if (callback instanceof Activity) {
            if (d3.a.d((Activity) callback) != null) {
                c cVar = this.f12391j;
                if (cVar == null) {
                    this.P = true;
                } else {
                    cVar.i(true);
                }
            }
            window.getDecorView().getSystemUiVisibility();
            window.setDecorFitsSystemWindows(false);
        }
        if (bundle == null || this.U != -100) {
            return;
        }
        this.U = bundle.getInt("appcompat:local_night_mode", -100);
    }

    @Override // stepos.support.v7.app.l
    public final boolean g(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.f12397p && i == 108) {
            return false;
        }
        if (this.f12393l && i == 1) {
            this.f12393l = false;
        }
        if (i == 1) {
            y();
            this.f12397p = true;
            return true;
        }
        if (i == 2) {
            y();
            this.G = true;
            return true;
        }
        if (i == 5) {
            y();
            this.H = true;
            return true;
        }
        if (i == 10) {
            y();
            this.f12395n = true;
            return true;
        }
        if (i == 1001) {
            y();
            this.f12398q = true;
            return true;
        }
        if (i == 108) {
            y();
            this.f12393l = true;
            return true;
        }
        if (i != 109) {
            return this.f12388f.requestFeature(i);
        }
        y();
        this.f12394m = true;
        return true;
    }

    @Override // stepos.support.v7.app.l
    public final void h(int i) {
        q();
        ViewGroup viewGroup = (ViewGroup) this.D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f12387c).inflate(i, viewGroup);
        this.f12389g.onContentChanged();
    }

    @Override // stepos.support.v7.app.l
    public final se.b i(se.a aVar) {
        if (aVar == null) {
            g5.f.s("ActionMode callback can not be null.");
            return null;
        }
        se.b bVar = this.f12405x;
        if (bVar != null) {
            bVar.a();
        }
        p5.c cVar = new p5.c(this, aVar);
        s();
        c cVar2 = this.f12391j;
        if (cVar2 != null) {
            this.f12405x = cVar2.s(cVar);
        }
        return this.f12405x;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, stepos.support.v7.app.k] */
    @Override // stepos.support.v7.app.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final se.b j(se.a r10) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.o.j(se.a):se.b");
    }

    public final void l(int i, r rVar, te.l lVar) {
        if (lVar == null) {
            if (rVar == null && i >= 0) {
                r[] rVarArr = this.J;
                if (i < rVarArr.length) {
                    rVar = rVarArr[i];
                }
            }
            if (rVar != null) {
                lVar = rVar.f12467h;
            }
        }
        if ((rVar == null || rVar.f12471m) && !this.f12400s) {
            this.f12389g.onPanelClosed(i, lVar);
        }
    }

    public final void m(te.l lVar) {
        if (this.I) {
            return;
        }
        this.I = true;
        this.f12402u.i();
        Window.Callback callback = this.f12388f.getCallback();
        if (callback != null && !this.f12400s) {
            callback.onPanelClosed(108, lVar);
        }
        this.I = false;
    }

    public final void n(r rVar, boolean z10) {
        h.c0 c0Var;
        stepos.support.v7.widget.b0 b0Var;
        if (z10 && rVar.f12460a == 0 && (b0Var = this.f12402u) != null && b0Var.a()) {
            m(rVar.f12467h);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f12387c.getSystemService("window");
        if (windowManager != null && rVar.f12471m && (c0Var = rVar.f12464e) != null) {
            if (c0Var.getParent() != null) {
                windowManager.removeView(rVar.f12464e);
            }
            if (z10) {
                l(rVar.f12460a, rVar, null);
            }
        }
        rVar.f12469k = false;
        rVar.f12470l = false;
        rVar.f12471m = false;
        rVar.f12465f = null;
        rVar.f12472n = true;
        if (this.K == rVar) {
            this.K = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.o.o(android.view.KeyEvent):boolean");
    }

    public final void p() {
        n3.o0 o0Var = this.B;
        if (o0Var != null) {
            o0Var.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q() {
        ViewGroup viewGroup;
        Context context = this.f12387c;
        Window window = this.f12388f;
        if (this.C) {
            return;
        }
        int[] iArr = g.a.f4106j;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(121)) {
            typedArrayObtainStyledAttributes.recycle();
            od.f.e("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
            return;
        }
        int i = 1;
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
        if (typedArrayObtainStyledAttributes.getBoolean(103, false)) {
            g(1001);
        }
        this.f12396o = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        window.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.f12397p) {
            viewGroup = this.f12395n ? (ViewGroup) layoutInflaterFrom.inflate(com.stepos.agentsafetycenter.R.layout.stepos_abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.stepos.agentsafetycenter.R.layout.stepos_abc_screen_simple, (ViewGroup) null);
            m mVar = new m();
            mVar.f12342c = this;
            VarHandle.storeStoreFence();
            WeakHashMap weakHashMap = n3.k0.f8724a;
            n3.e0.b(viewGroup, mVar);
        } else if (this.f12396o) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.stepos.agentsafetycenter.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.f12394m = false;
            this.f12393l = false;
        } else if (this.f12393l) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.stepos.agentsafetycenter.R.attr.actionBarTheme, typedValue, true);
            Context cVar = typedValue.resourceId != 0 ? new k.c(context, typedValue.resourceId) : context;
            if (this.f12398q) {
                TypedValue typedValue2 = new TypedValue();
                cVar.getTheme().resolveAttribute(com.stepos.agentsafetycenter.R.attr.steposNestedScrollActionBarTheme, typedValue2, true);
                if (typedValue2.resourceId != 0) {
                    cVar = new k.c(cVar, typedValue2.resourceId);
                }
                viewGroup = (ViewGroup) LayoutInflater.from(cVar).inflate(com.stepos.agentsafetycenter.R.layout.stepos_nested_scroll_toolbar, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) LayoutInflater.from(cVar).inflate(com.stepos.agentsafetycenter.R.layout.stepos_abc_screen_toolbar_full_screen, (ViewGroup) null);
            }
            stepos.support.v7.widget.b0 b0Var = (stepos.support.v7.widget.b0) viewGroup.findViewById(com.stepos.agentsafetycenter.R.id.decor_content_parent);
            this.f12402u = b0Var;
            b0Var.setWindowCallback(window.getCallback());
            if (this.f12394m) {
                this.f12402u.h(109);
            }
            if (this.G) {
                this.f12402u.h(2);
            }
            if (this.H) {
                this.f12402u.h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            g5.f.c(this.f12393l ? 1 : 0, this.f12394m ? 1 : 0, this.f12396o ? 1 : 0, this.f12395n ? 1 : 0, this.f12397p ? 1 : 0);
            return;
        }
        if (this.f12402u == null) {
            this.E = (TextView) viewGroup.findViewById(com.stepos.agentsafetycenter.R.id.title);
        }
        x1.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.stepos.agentsafetycenter.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) window.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                viewGroup2.setForeground(null);
            }
        }
        window.setContentView(viewGroup);
        h.t tVar = new h.t(i);
        tVar.f4894b = this;
        VarHandle.storeStoreFence();
        contentFrameLayout.setAttachListener(tVar);
        this.D = viewGroup;
        Window.Callback callback = this.f12389g;
        CharSequence title = callback instanceof Activity ? ((Activity) callback).getTitle() : this.f12399r;
        if (!TextUtils.isEmpty(title)) {
            stepos.support.v7.widget.b0 b0Var2 = this.f12402u;
            if (b0Var2 != null) {
                b0Var2.setWindowTitle(title);
            } else {
                c cVar2 = this.f12391j;
                if (cVar2 != null) {
                    cVar2.q(title);
                } else {
                    TextView textView = this.E;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.D.findViewById(R.id.content);
        View decorView = window.getDecorView();
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
        View viewFindViewById = this.D.findViewById(R.id.content);
        if (viewFindViewById != null && (viewFindViewById instanceof FitsWindowsContentLayout)) {
            ((FitsWindowsContentLayout) viewFindViewById).setOnStartActionModeListener(this.W);
        }
        this.C = true;
        r rVarR = r(0);
        if (!this.f12400s && rVarR.f12467h == null) {
            t(108);
        }
        s();
        if (this.f12391j != null) {
            s();
            this.f12391j.p(this.f12401t);
        }
    }

    public final r r(int i) {
        r[] rVarArr = this.J;
        if (rVarArr == null || rVarArr.length <= i) {
            r[] rVarArr2 = new r[i + 1];
            if (rVarArr != null) {
                System.arraycopy(rVarArr, 0, rVarArr2, 0, rVarArr.length);
            }
            this.J = rVarArr2;
            rVarArr = rVarArr2;
        }
        r rVar = rVarArr[i];
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r();
        rVar2.f12460a = i;
        rVar2.f12472n = false;
        rVarArr[i] = rVar2;
        return rVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s() {
        stepos.support.v7.widget.c0 wrapper;
        Window.Callback callback = this.f12389g;
        q();
        if (this.f12393l && this.f12391j == null) {
            int i = 3;
            char c9 = 1;
            char c10 = 1;
            boolean z10 = false;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (callback instanceof Activity) {
                if (this.f12398q) {
                    a0 a0Var = new a0();
                    new ArrayList();
                    a0Var.f12278n = new ArrayList();
                    a0Var.f12280p = true;
                    y yVar = new y();
                    yVar.f12520h = a0Var;
                    VarHandle.storeStoreFence();
                    a0Var.f12285u = yVar;
                    sa.c cVar = new sa.c(2, z10);
                    cVar.f12170f = a0Var;
                    VarHandle.storeStoreFence();
                    a0Var.f12286v = cVar;
                    a0Var.f12287w = 288;
                    View decorView = ((Activity) callback).getWindow().getDecorView();
                    a0Var.f12268c = (ActionBarCoordinatorLayout) decorView.findViewById(com.stepos.agentsafetycenter.R.id.decor_content_parent);
                    a0Var.f12272g = (ActionBarContextView) decorView.findViewById(com.stepos.agentsafetycenter.R.id.action_context_bar);
                    a0Var.f12271f = (StepOSCollapsingToolbarLayout) decorView.findViewById(com.stepos.agentsafetycenter.R.id.action_bar_container);
                    a0Var.f12270e = (StepOSAppBarLayout) decorView.findViewById(com.stepos.agentsafetycenter.R.id.app_bar_layout);
                    a0Var.f12273h = (ActionBarContainer) decorView.findViewById(com.stepos.agentsafetycenter.R.id.split_action_bar);
                    StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = a0Var.f12271f;
                    View viewFindViewById = decorView.findViewById(com.stepos.agentsafetycenter.R.id.action_bar);
                    if (viewFindViewById instanceof stepos.support.v7.widget.c0) {
                        wrapper = (stepos.support.v7.widget.c0) viewFindViewById;
                    } else {
                        if (!(viewFindViewById instanceof Toolbar)) {
                            Objects.toString(viewFindViewById);
                            od.f.e(viewFindViewById.getClass().getSimpleName());
                            return;
                        }
                        wrapper = ((Toolbar) viewFindViewById).getWrapper();
                    }
                    if (stepOSCollapsingToolbarLayout.B == null) {
                        stepos.support.v7.widget.z zVar = new stepos.support.v7.widget.z();
                        zVar.f12928a = stepOSCollapsingToolbarLayout;
                        zVar.f12929b = wrapper;
                        zVar.f12930c = wrapper.A();
                        stepOSCollapsingToolbarLayout.B = zVar;
                    }
                    stepos.support.v7.widget.z zVar2 = stepOSCollapsingToolbarLayout.B;
                    a0Var.f12269d = zVar2;
                    if (zVar2 == null || a0Var.f12272g == null || a0Var.f12271f == null) {
                        od.f.e(a0.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
                        return;
                    }
                    r2.i iVar = new r2.i(5);
                    VarHandle.storeStoreFence();
                    zVar2.z(iVar);
                    Context context = a0Var.f12269d.f12929b.getContext();
                    a0Var.f12266a = context;
                    int i3 = a0Var.f12269d.f12930c;
                    Object[] objArr3 = (i3 & 4) != 0;
                    if (objArr3 != false) {
                        a0Var.i = true;
                    }
                    a0Var.m(a4.n.c(context).f190a.getApplicationInfo().targetSdkVersion < 14 || objArr3 == true);
                    boolean z11 = (i3 & 32) != 0;
                    a0Var.f12283s = z11;
                    if ((i3 & 8) != 0 && z11) {
                        od.f.e("nested scroll actionbar can't display title and tabs in the same time");
                        return;
                    }
                    a0Var.v(z11);
                    TypedArray typedArrayObtainStyledAttributes = a0Var.f12266a.obtainStyledAttributes(null, g.a.f4098a, com.stepos.agentsafetycenter.R.attr.steposActionBarStyleFullScreen, 0);
                    int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
                    if (dimensionPixelSize != 0) {
                        float f5 = dimensionPixelSize;
                        StepOSAppBarLayout stepOSAppBarLayout = a0Var.f12270e;
                        WeakHashMap weakHashMap = n3.k0.f8724a;
                        stepOSAppBarLayout.setElevation(f5);
                        ActionBarContainer actionBarContainer = a0Var.f12273h;
                        if (actionBarContainer != null) {
                            actionBarContainer.setElevation(f5);
                        }
                    }
                    typedArrayObtainStyledAttributes.recycle();
                    a0Var.f12284t = a0Var.f12280p && a0Var.f12271f.getHeight() == 0;
                    VarHandle.storeStoreFence();
                    this.f12391j = a0Var;
                } else {
                    boolean z12 = this.f12394m;
                    t0 t0Var = new t0();
                    new ArrayList();
                    t0Var.f12491n = new ArrayList();
                    t0Var.f12493p = 0;
                    t0Var.f12494q = true;
                    t0Var.f12497t = true;
                    t0Var.f12502y = true;
                    t0Var.A = new s0(t0Var, objArr2 == true ? 1 : 0);
                    t0Var.B = new s0(t0Var, c10 == true ? 1 : 0);
                    t0Var.C = new sa.c(t0Var, i);
                    t0Var.D = 288;
                    View decorView2 = ((Activity) callback).getWindow().getDecorView();
                    t0Var.u(decorView2);
                    if (!z12) {
                        t0Var.f12486h = (FitsWindowsContentLayout) decorView2.findViewById(R.id.content);
                    }
                    VarHandle.storeStoreFence();
                    this.f12391j = t0Var;
                }
            } else if (callback instanceof Dialog) {
                t0 t0Var2 = new t0();
                new ArrayList();
                t0Var2.f12491n = new ArrayList();
                t0Var2.f12493p = 0;
                t0Var2.f12494q = true;
                t0Var2.f12497t = true;
                t0Var2.f12502y = true;
                t0Var2.A = new s0(t0Var2, objArr == true ? 1 : 0);
                t0Var2.B = new s0(t0Var2, c9 == true ? 1 : 0);
                t0Var2.C = new sa.c(t0Var2, i);
                t0Var2.D = 288;
                t0Var2.u(((Dialog) callback).getWindow().getDecorView());
                VarHandle.storeStoreFence();
                this.f12391j = t0Var2;
            }
            c cVar2 = this.f12391j;
            if (cVar2 != null) {
                cVar2.i(this.P);
            }
        }
    }

    public final void t(int i) {
        this.N = (1 << i) | this.N;
        if (this.M) {
            return;
        }
        View decorView = this.f12388f.getDecorView();
        p pVar = this.O;
        WeakHashMap weakHashMap = n3.k0.f8724a;
        decorView.postOnAnimation(pVar);
        this.M = true;
    }

    public final void u(r rVar, KeyEvent keyEvent) {
        Context context = this.f12387c;
        boolean z10 = rVar.f12471m;
        int i = rVar.f12460a;
        if (z10 || this.f12400s) {
            return;
        }
        int i3 = 1;
        if (i == 0) {
            boolean z11 = (context.getResources().getConfiguration().screenLayout & 15) == 4;
            boolean z12 = context.getApplicationInfo().targetSdkVersion >= 11;
            if (z11 && z12) {
                return;
            }
        }
        Window.Callback callback = this.f12388f.getCallback();
        if (callback != null && !callback.onMenuOpened(i, rVar.f12467h)) {
            n(rVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null && x(rVar, keyEvent)) {
            h.c0 c0Var = rVar.f12464e;
            int i10 = -2;
            if (c0Var == null || rVar.f12472n) {
                if (c0Var == null) {
                    s();
                    c cVar = this.f12391j;
                    Context contextD = cVar != null ? cVar.d() : null;
                    if (contextD != null) {
                        context = contextD;
                    }
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(context.getTheme());
                    themeNewTheme.resolveAttribute(com.stepos.agentsafetycenter.R.attr.actionBarPopupTheme, typedValue, true);
                    int i11 = typedValue.resourceId;
                    if (i11 != 0) {
                        themeNewTheme.applyStyle(i11, true);
                    }
                    themeNewTheme.resolveAttribute(com.stepos.agentsafetycenter.R.attr.panelMenuListTheme, typedValue, true);
                    int i12 = typedValue.resourceId;
                    if (i12 != 0) {
                        themeNewTheme.applyStyle(i12, true);
                    } else {
                        themeNewTheme.applyStyle(com.stepos.agentsafetycenter.R.style.Theme_AppCompat_CompactMenu, true);
                    }
                    k.c cVar2 = new k.c(context, 0);
                    cVar2.getTheme().setTo(themeNewTheme);
                    rVar.f12468j = cVar2;
                    TypedArray typedArrayObtainStyledAttributes = cVar2.obtainStyledAttributes(g.a.f4106j);
                    rVar.f12461b = typedArrayObtainStyledAttributes.getResourceId(86, 0);
                    rVar.f12463d = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                    typedArrayObtainStyledAttributes.recycle();
                    rVar.f12464e = new h.c0(this, rVar.f12468j, i3);
                    rVar.f12462c = 81;
                } else if (rVar.f12472n && c0Var.getChildCount() > 0) {
                    rVar.f12464e.removeAllViews();
                }
                View view = rVar.f12466g;
                if (view != null) {
                    rVar.f12465f = view;
                } else {
                    if (rVar.f12467h == null) {
                        return;
                    }
                    if (this.f12404w == null) {
                        m mVar = new m();
                        mVar.f12342c = this;
                        VarHandle.storeStoreFence();
                        this.f12404w = mVar;
                    }
                    m mVar2 = this.f12404w;
                    if (rVar.i == null) {
                        te.i iVar = new te.i(rVar.f12468j);
                        rVar.i = iVar;
                        iVar.i = mVar2;
                        te.l lVar = rVar.f12467h;
                        lVar.b(iVar, lVar.f13343a);
                    }
                    View view2 = (View) rVar.i.i(rVar.f12464e);
                    rVar.f12465f = view2;
                    if (view2 == null) {
                        return;
                    }
                }
                if (rVar.f12465f == null) {
                    return;
                }
                if (rVar.f12466g == null && ((l.g) rVar.i.h()).getCount() <= 0) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = rVar.f12465f.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -2);
                }
                rVar.f12464e.setBackgroundResource(rVar.f12461b);
                ViewParent parent = rVar.f12465f.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(rVar.f12465f);
                }
                rVar.f12464e.addView(rVar.f12465f, layoutParams);
                if (!rVar.f12465f.hasFocus()) {
                    rVar.f12465f.requestFocus();
                }
            } else {
                View view3 = rVar.f12466g;
                if (view3 != null) {
                    ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
                    if (layoutParams2 != null && layoutParams2.width == -1) {
                        i10 = -1;
                    }
                } else {
                    if (rVar.f12465f == null) {
                        return;
                    }
                    if (view3 == null && ((l.g) rVar.i.h()).getCount() <= 0) {
                        return;
                    }
                }
            }
            int i13 = i10;
            rVar.f12470l = false;
            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i13, -2, 0, 0, 1002, 8519680, -3);
            layoutParams3.gravity = rVar.f12462c;
            layoutParams3.windowAnimations = rVar.f12463d;
            windowManager.addView(rVar.f12464e, layoutParams3);
            rVar.f12471m = true;
        }
    }

    public final boolean v(r rVar, int i, KeyEvent keyEvent) {
        te.l lVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((rVar.f12469k || x(rVar, keyEvent)) && (lVar = rVar.f12467h) != null) {
            return lVar.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, stepos.support.v7.app.k] */
    public final void w(r rVar) {
        te.l lVar = new te.l(this.f12387c);
        lVar.f13346d = this.S;
        if (lVar != rVar.f12475q) {
            rVar.f12475q = lVar;
        }
        stepos.support.v7.widget.b0 b0Var = this.f12402u;
        if (b0Var != null) {
            if (this.f12403v == null) {
                this.f12403v = new q(this);
            }
            b0Var.p(rVar.f12475q, this.f12403v);
        }
        rVar.f12475q.v();
        boolean zOnCreateBottomMenu = this.i.onCreateBottomMenu(rVar.f12475q);
        te.l lVar2 = rVar.f12475q;
        if (zOnCreateBottomMenu) {
            lVar2.u();
            return;
        }
        if (lVar2 != null) {
            rVar.f12475q = null;
        }
        stepos.support.v7.widget.b0 b0Var2 = this.f12402u;
        if (b0Var2 != null) {
            b0Var2.p(null, this.f12403v);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d0  */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, stepos.support.v7.app.k] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x(stepos.support.v7.app.r r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.o.x(stepos.support.v7.app.r, android.view.KeyEvent):boolean");
    }

    public final void y() {
        if (this.C) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }
}
