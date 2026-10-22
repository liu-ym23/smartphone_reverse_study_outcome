package stepos.support.v7.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
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
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.data.base.Content;
import com.stepos.core.ota.crypto.FekEnvelope;
import fe.b;
import java.util.WeakHashMap;
import stepos.support.v7.view.menu.b;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.g0;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class AppCompatDelegateImplV7 extends i implements c.a {
    public TextView A;
    public View B;
    public boolean C;
    public boolean D;
    public boolean E;
    public PanelFeatureState[] F;
    public PanelFeatureState G;
    public boolean H;
    public boolean I;
    public int J;
    public final a K;
    public boolean L;
    public Rect M;
    public Rect N;
    public final b O;
    public final c P;

    /* renamed from: q, reason: collision with root package name */
    public stepos.support.v7.widget.j f11990q;
    public d r;

    /* renamed from: s, reason: collision with root package name */
    public g f11991s;

    /* renamed from: t, reason: collision with root package name */
    public fe.b f11992t;

    /* renamed from: u, reason: collision with root package name */
    public ActionBarContextView f11993u;

    /* renamed from: v, reason: collision with root package name */
    public PopupWindow f11994v;

    /* renamed from: w, reason: collision with root package name */
    public n f11995w;

    /* renamed from: x, reason: collision with root package name */
    public v0.h0 f11996x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f11997y;
    public ViewGroup z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class PanelFeatureState {

        /* renamed from: a, reason: collision with root package name */
        public int f11998a;

        /* renamed from: b, reason: collision with root package name */
        public int f11999b;

        /* renamed from: c, reason: collision with root package name */
        public int f12000c;

        /* renamed from: d, reason: collision with root package name */
        public int f12001d;

        /* renamed from: e, reason: collision with root package name */
        public f f12002e;

        /* renamed from: f, reason: collision with root package name */
        public View f12003f;

        /* renamed from: g, reason: collision with root package name */
        public View f12004g;
        public stepos.support.v7.view.menu.c h;

        /* renamed from: i, reason: collision with root package name */
        public stepos.support.v7.view.menu.b f12005i;

        /* renamed from: j, reason: collision with root package name */
        public k.c f12006j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f12007k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f12008l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f12009m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f12010n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f12011o;

        /* renamed from: p, reason: collision with root package name */
        public Bundle f12012p;

        /* renamed from: q, reason: collision with root package name */
        public stepos.support.v7.view.menu.c f12013q;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new r0.g(new a());
            int featureId;
            boolean isOpen;
            Bundle menuState;

            /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
            public class a {
                public final Object a(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.readFromParcel(parcel, classLoader);
                }

                public final Object[] b(int i10) {
                    return new SavedState[i10];
                }
            }

            private SavedState() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static SavedState readFromParcel(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.featureId = parcel.readInt();
                boolean z = parcel.readInt() == 1;
                savedState.isOpen = z;
                if (z) {
                    savedState.menuState = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.featureId);
                parcel.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }

            public /* synthetic */ SavedState(a aVar) {
                this();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if ((appCompatDelegateImplV7.J & 1) != 0) {
                AppCompatDelegateImplV7.n(appCompatDelegateImplV7, 0);
            }
            if ((appCompatDelegateImplV7.J & 4096) != 0) {
                AppCompatDelegateImplV7.n(appCompatDelegateImplV7, Content.Types.TYPE_DOUBLE_ARRAY);
            }
            appCompatDelegateImplV7.I = false;
            appCompatDelegateImplV7.J = 0;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements View.OnClickListener {
        public c() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, stepos.support.v7.app.g] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            ?? r12 = appCompatDelegateImplV7.f12129e;
            if (appCompatDelegateImplV7.f12138o) {
                return;
            }
            r12.onBackTopTouch();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class d implements g.a {
        public d() {
        }

        @Override // stepos.support.v7.view.menu.g.a
        public final void a(stepos.support.v7.view.menu.c cVar, boolean z) {
            AppCompatDelegateImplV7.this.p(cVar);
        }

        @Override // stepos.support.v7.view.menu.g.a
        public final boolean b(stepos.support.v7.view.menu.c cVar) {
            Window.Callback callback = AppCompatDelegateImplV7.this.f12126b.getCallback();
            if (callback == null) {
                return true;
            }
            callback.onMenuOpened(Content.Types.TYPE_DOUBLE_ARRAY, cVar);
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e implements b.InterfaceC0082b {

        /* renamed from: a, reason: collision with root package name */
        public final b.InterfaceC0082b f12018a;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a extends mb.y {
            public a() {
            }

            @Override // mb.y, v0.i0
            public final void d(View view) {
                AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
                appCompatDelegateImplV7.f11993u.setVisibility(8);
                PopupWindow popupWindow = appCompatDelegateImplV7.f11994v;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImplV7.f11993u.getParent() instanceof View) {
                    View view2 = (View) appCompatDelegateImplV7.f11993u.getParent();
                    WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
                    e0.c.b(view2);
                }
                appCompatDelegateImplV7.f11993u.removeAllViews();
                appCompatDelegateImplV7.f11996x.e(null);
                appCompatDelegateImplV7.f11996x = null;
            }
        }

        public e(b.InterfaceC0082b interfaceC0082b) {
            this.f12018a = interfaceC0082b;
        }

        @Override // fe.b.InterfaceC0082b
        public final boolean a(fe.b bVar, MenuItem menuItem) {
            return this.f12018a.a(bVar, menuItem);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, stepos.support.v7.app.g] */
        @Override // fe.b.InterfaceC0082b
        public final void b(fe.b bVar) {
            this.f12018a.b(bVar);
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if (appCompatDelegateImplV7.f11994v != null) {
                appCompatDelegateImplV7.f12126b.getDecorView().removeCallbacks(appCompatDelegateImplV7.f11995w);
            }
            if (appCompatDelegateImplV7.f11993u != null) {
                appCompatDelegateImplV7.r();
                v0.h0 h0VarA = v0.e0.a(appCompatDelegateImplV7.f11993u);
                h0VarA.a(0.0f);
                appCompatDelegateImplV7.f11996x = h0VarA;
                h0VarA.e(new a());
            }
            appCompatDelegateImplV7.f12129e.onSupportActionModeFinished(appCompatDelegateImplV7.f11992t);
            appCompatDelegateImplV7.f11992t = null;
        }

        @Override // fe.b.InterfaceC0082b
        public final boolean c(fe.b bVar, Menu menu) {
            return this.f12018a.c(bVar, menu);
        }

        @Override // fe.b.InterfaceC0082b
        public final boolean d(fe.b bVar, Menu menu) {
            return this.f12018a.d(bVar, menu);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class f extends ContentFrameLayout {
        public f(k.c cVar) {
            super(cVar);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplV7.this.k(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x3 = (int) motionEvent.getX();
                int y3 = (int) motionEvent.getY();
                if (x3 < -5 || y3 < -5 || x3 > getWidth() + 5 || y3 > getHeight() + 5) {
                    AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
                    appCompatDelegateImplV7.q(appCompatDelegateImplV7.t(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public final void setBackgroundResource(int i10) {
            setBackgroundDrawable(androidx.appcompat.widget.j.a().b(i10, getContext()));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class g implements g.a {
        public g() {
        }

        @Override // stepos.support.v7.view.menu.g.a
        public final void a(stepos.support.v7.view.menu.c cVar, boolean z) {
            PanelFeatureState panelFeatureState;
            stepos.support.v7.view.menu.c cVarK = cVar.k();
            int i10 = 0;
            boolean z3 = cVarK != cVar;
            if (z3) {
                cVar = cVarK;
            }
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            PanelFeatureState[] panelFeatureStateArr = appCompatDelegateImplV7.F;
            int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
            while (true) {
                if (i10 < length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                    if (panelFeatureState != null && panelFeatureState.h == cVar) {
                        break;
                    } else {
                        i10++;
                    }
                } else {
                    panelFeatureState = null;
                    break;
                }
            }
            if (panelFeatureState != null) {
                if (!z3) {
                    appCompatDelegateImplV7.q(panelFeatureState, z);
                } else {
                    appCompatDelegateImplV7.o(panelFeatureState.f11998a, panelFeatureState, cVarK);
                    appCompatDelegateImplV7.q(panelFeatureState, true);
                }
            }
        }

        @Override // stepos.support.v7.view.menu.g.a
        public final boolean b(stepos.support.v7.view.menu.c cVar) {
            Window.Callback callback;
            if (cVar != null) {
                return true;
            }
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if (!appCompatDelegateImplV7.h || (callback = appCompatDelegateImplV7.f12126b.getCallback()) == null || appCompatDelegateImplV7.f12138o) {
                return true;
            }
            callback.onMenuOpened(Content.Types.TYPE_DOUBLE_ARRAY, cVar);
            return true;
        }
    }

    public AppCompatDelegateImplV7(Context context, Window window, stepos.support.v7.app.g gVar) {
        super(context, window, gVar);
        this.f11996x = null;
        this.K = new a();
        this.O = new b();
        this.P = new c();
    }

    public static void n(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i10) {
        PanelFeatureState panelFeatureStateT = appCompatDelegateImplV7.t(i10);
        if (panelFeatureStateT.h != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateT.h.s(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateT.f12012p = bundle;
            }
            panelFeatureStateT.h.v();
            panelFeatureStateT.h.clear();
        }
        panelFeatureStateT.f12011o = true;
        panelFeatureStateT.f12010n = true;
        if ((i10 == 108 || i10 == 0) && appCompatDelegateImplV7.f11990q != null) {
            PanelFeatureState panelFeatureStateT2 = appCompatDelegateImplV7.t(0);
            panelFeatureStateT2.f12007k = false;
            appCompatDelegateImplV7.z(panelFeatureStateT2, null);
        }
    }

    public final void A() {
        if (this.f11997y) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    @Override // stepos.support.v7.view.menu.c.a
    public final void a(stepos.support.v7.view.menu.c cVar) {
        stepos.support.v7.widget.j jVar = this.f11990q;
        if (jVar == null || !jVar.a() || (ViewConfiguration.get(this.f12125a).hasPermanentMenuKey() && !this.f11990q.f())) {
            PanelFeatureState panelFeatureStateT = t(0);
            panelFeatureStateT.f12010n = true;
            q(panelFeatureStateT, false);
            w(panelFeatureStateT, null);
            return;
        }
        Window window = this.f12126b;
        Window.Callback callback = window.getCallback();
        if (this.f11990q.d()) {
            this.f11990q.b();
            if (this.f12138o) {
                return;
            }
            callback.onPanelClosed(Content.Types.TYPE_DOUBLE_ARRAY, t(0).h);
            return;
        }
        if (callback == null || this.f12138o) {
            return;
        }
        if (this.I && (1 & this.J) != 0) {
            View decorView = window.getDecorView();
            a aVar = this.K;
            decorView.removeCallbacks(aVar);
            aVar.run();
        }
        PanelFeatureState panelFeatureStateT2 = t(0);
        stepos.support.v7.view.menu.c cVar2 = panelFeatureStateT2.h;
        if (cVar2 == null || panelFeatureStateT2.f12011o || !callback.onPreparePanel(0, panelFeatureStateT2.f12004g, cVar2)) {
            return;
        }
        callback.onMenuOpened(Content.Types.TYPE_DOUBLE_ARRAY, panelFeatureStateT2.h);
        this.f11990q.c();
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, stepos.support.v7.app.g] */
    @Override // stepos.support.v7.view.menu.c.a
    public final boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
        PanelFeatureState panelFeatureState;
        Window.Callback callback = this.f12126b.getCallback();
        if (callback != null && !this.f12138o) {
            stepos.support.v7.view.menu.c cVarK = cVar.k();
            PanelFeatureState[] panelFeatureStateArr = this.F;
            int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                    if (panelFeatureState != null && panelFeatureState.h == cVarK) {
                        break;
                    }
                    i10++;
                } else {
                    panelFeatureState = null;
                    break;
                }
            }
            if (panelFeatureState != null) {
                int i11 = panelFeatureState.f11998a;
                boolean zOnMenuItemSelected = callback.onMenuItemSelected(i11, menuItem);
                return (zOnMenuItemSelected || !(menuItem instanceof ge.g)) ? zOnMenuItemSelected : this.f12129e.onMenuItemSelected(i11, (ge.g) menuItem);
            }
        }
        return false;
    }

    @Override // stepos.support.v7.app.h
    public final void d() {
        l();
        stepos.support.v7.app.a aVar = this.f12130f;
        if (aVar == null || !aVar.e()) {
            u(0);
        }
    }

    @Override // stepos.support.v7.app.h
    public void e(Bundle bundle) {
        int i10;
        if ((stepos.support.v7.widget.g0.f12796a == null || stepos.support.v7.widget.g0.f12797b == null) && ((i10 = stepos.support.v7.widget.g0.f12798c) == 2 || i10 == 0)) {
            new g0.a().start();
            stepos.support.v7.widget.g0.f12798c = 1;
        }
        Window.Callback callback = this.f12127c;
        if (callback instanceof Activity) {
            if (androidx.core.app.e.c((Activity) callback) != null) {
                stepos.support.v7.app.a aVar = this.f12130f;
                if (aVar == null) {
                    this.L = true;
                } else {
                    aVar.i(true);
                }
            }
            Window window = this.f12126b;
            window.getDecorView().getSystemUiVisibility();
            window.setDecorFitsSystemWindows(false);
        }
    }

    @Override // stepos.support.v7.app.h
    public final boolean g(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i10 = 108;
        } else if (i10 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i10 = 109;
        }
        if (this.f12135l && i10 == 108) {
            return false;
        }
        if (this.h && i10 == 1) {
            this.h = false;
        }
        if (i10 == 1) {
            A();
            this.f12135l = true;
            return true;
        }
        if (i10 == 2) {
            A();
            this.C = true;
            return true;
        }
        if (i10 == 5) {
            A();
            this.D = true;
            return true;
        }
        if (i10 == 10) {
            A();
            this.f12133j = true;
            return true;
        }
        if (i10 == 1001) {
            A();
            this.f12136m = true;
            return true;
        }
        if (i10 == 108) {
            A();
            this.h = true;
            return true;
        }
        if (i10 != 109) {
            return this.f12126b.requestFeature(i10);
        }
        A();
        this.f12132i = true;
        return true;
    }

    @Override // stepos.support.v7.app.h
    public final void h(int i10) {
        s();
        ViewGroup viewGroup = (ViewGroup) this.z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f12125a).inflate(i10, viewGroup);
        this.f12127c.onContentChanged();
    }

    @Override // stepos.support.v7.app.h
    public final fe.b i(b.InterfaceC0082b interfaceC0082b) {
        if (interfaceC0082b == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        fe.b bVar = this.f11992t;
        if (bVar != null) {
            bVar.c();
        }
        e eVar = new e(interfaceC0082b);
        l();
        stepos.support.v7.app.a aVar = this.f12130f;
        if (aVar != null) {
            this.f11992t = aVar.s(eVar);
        }
        return this.f11992t;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x016f  */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, stepos.support.v7.app.g] */
    @Override // stepos.support.v7.app.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final fe.b j(fe.b.InterfaceC0082b r10) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.AppCompatDelegateImplV7.j(fe.b$b):fe.b");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b2  */
    @Override // stepos.support.v7.app.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.AppCompatDelegateImplV7.k(android.view.KeyEvent):boolean");
    }

    @Override // stepos.support.v7.app.i
    public final void l() {
        s();
        if (this.h && this.f12130f == null) {
            Window.Callback callback = this.f12127c;
            if (callback instanceof Activity) {
                if (this.f12136m) {
                    this.f12130f = new x((Activity) callback);
                } else {
                    this.f12130f = new o0((Activity) callback, this.f12132i);
                }
            } else if (callback instanceof Dialog) {
                this.f12130f = new o0((Dialog) callback);
            }
            stepos.support.v7.app.a aVar = this.f12130f;
            if (aVar != null) {
                aVar.i(this.L);
            }
        }
    }

    public final void o(int i10, PanelFeatureState panelFeatureState, stepos.support.v7.view.menu.c cVar) {
        if (cVar == null) {
            if (panelFeatureState == null && i10 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.F;
                if (i10 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                }
            }
            if (panelFeatureState != null) {
                cVar = panelFeatureState.h;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f12009m) && !this.f12138o) {
            this.f12127c.onPanelClosed(i10, cVar);
        }
    }

    public final void p(stepos.support.v7.view.menu.c cVar) {
        if (this.E) {
            return;
        }
        this.E = true;
        this.f11990q.n();
        Window.Callback callback = this.f12126b.getCallback();
        if (callback != null && !this.f12138o) {
            callback.onPanelClosed(Content.Types.TYPE_DOUBLE_ARRAY, cVar);
        }
        this.E = false;
    }

    public final void q(PanelFeatureState panelFeatureState, boolean z) {
        f fVar;
        stepos.support.v7.widget.j jVar;
        if (z && panelFeatureState.f11998a == 0 && (jVar = this.f11990q) != null && jVar.d()) {
            p(panelFeatureState.h);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f12125a.getSystemService("window");
        if (windowManager != null && panelFeatureState.f12009m && (fVar = panelFeatureState.f12002e) != null) {
            if (fVar.getParent() != null) {
                windowManager.removeView(panelFeatureState.f12002e);
            }
            if (z) {
                o(panelFeatureState.f11998a, panelFeatureState, null);
            }
        }
        panelFeatureState.f12007k = false;
        panelFeatureState.f12008l = false;
        panelFeatureState.f12009m = false;
        panelFeatureState.f12003f = null;
        panelFeatureState.f12010n = true;
        if (this.G == panelFeatureState) {
            this.G = null;
        }
    }

    public final void r() {
        v0.h0 h0Var = this.f11996x;
        if (h0Var != null) {
            h0Var.b();
        }
    }

    public final void s() {
        ViewGroup viewGroup;
        if (this.f11997y) {
            return;
        }
        Context context = this.f12125a;
        int[] iArr = g.a.f8929j;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(121)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(130, false)) {
            g(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(121, false)) {
            g(Content.Types.TYPE_DOUBLE_ARRAY);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(FekEnvelope.EXPECTED_EPK_CHARS, false)) {
            g(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(123, false)) {
            g(10);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(Content.Types.TYPE_DOUBLE, false)) {
            g(1001);
        }
        this.f12134k = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        Window window = this.f12126b;
        window.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.f12135l) {
            viewGroup = this.f12133j ? (ViewGroup) layoutInflaterFrom.inflate(com.stepos.aiengine.R.layout.stepos_abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.stepos.aiengine.R.layout.stepos_abc_screen_simple, (ViewGroup) null);
            stepos.support.v7.app.palette.b bVar = new stepos.support.v7.app.palette.b(this, 11);
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            e0.d.k(viewGroup, bVar);
        } else if (this.f12134k) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.stepos.aiengine.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.f12132i = false;
            this.h = false;
        } else if (this.h) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.stepos.aiengine.R.attr.actionBarTheme, typedValue, true);
            Context cVar = typedValue.resourceId != 0 ? new k.c(context, typedValue.resourceId) : context;
            if (this.f12136m) {
                TypedValue typedValue2 = new TypedValue();
                cVar.getTheme().resolveAttribute(com.stepos.aiengine.R.attr.steposNestedScrollActionBarTheme, typedValue2, true);
                if (typedValue2.resourceId != 0) {
                    cVar = new k.c(cVar, typedValue2.resourceId);
                }
                viewGroup = (ViewGroup) LayoutInflater.from(cVar).inflate(com.stepos.aiengine.R.layout.stepos_nested_scroll_toolbar, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) LayoutInflater.from(cVar).inflate(com.stepos.aiengine.R.layout.stepos_abc_screen_toolbar_full_screen, (ViewGroup) null);
            }
            stepos.support.v7.widget.j jVar = (stepos.support.v7.widget.j) viewGroup.findViewById(com.stepos.aiengine.R.id.decor_content_parent);
            this.f11990q = jVar;
            jVar.setWindowCallback(window.getCallback());
            if (this.f12132i) {
                this.f11990q.g(109);
            }
            if (this.C) {
                this.f11990q.g(2);
            }
            if (this.D) {
                this.f11990q.g(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            StringBuilder sb2 = new StringBuilder("AppCompat does not support the current theme features: { windowActionBar: ");
            sb2.append(this.h);
            sb2.append(", windowActionBarOverlay: ");
            sb2.append(this.f12132i);
            sb2.append(", android:windowIsFloating: ");
            sb2.append(this.f12134k);
            sb2.append(", windowActionModeOverlay: ");
            sb2.append(this.f12133j);
            sb2.append(", windowNoTitle: ");
            throw new IllegalArgumentException(a0.a.m(sb2, this.f12135l, " }"));
        }
        if (this.f11990q == null) {
            this.A = (TextView) viewGroup.findViewById(com.stepos.aiengine.R.id.title);
        }
        stepos.support.v7.widget.g0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.stepos.aiengine.R.id.action_bar_activity_content);
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
        contentFrameLayout.setAttachListener(new m(this));
        this.z = viewGroup;
        Window.Callback callback = this.f12127c;
        CharSequence title = callback instanceof Activity ? ((Activity) callback).getTitle() : this.f12137n;
        if (!TextUtils.isEmpty(title)) {
            stepos.support.v7.widget.j jVar2 = this.f11990q;
            if (jVar2 != null) {
                jVar2.setWindowTitle(title);
            } else {
                stepos.support.v7.app.a aVar = this.f12130f;
                if (aVar != null) {
                    aVar.q(title);
                } else {
                    TextView textView = this.A;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.z.findViewById(R.id.content);
        View decorView = window.getDecorView();
        contentFrameLayout2.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes2.getValue(TraceIdKeys.MAX_LENGTH, contentFrameLayout2.getMinWidthMajor());
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
        v(this.z);
        this.f11997y = true;
        PanelFeatureState panelFeatureStateT = t(0);
        if (!this.f12138o && panelFeatureStateT.h == null) {
            u(Content.Types.TYPE_DOUBLE_ARRAY);
        }
        l();
        if (this.f12130f != null) {
            l();
            this.f12130f.p(this.f12139p);
        }
    }

    public final PanelFeatureState t(int i10) {
        PanelFeatureState[] panelFeatureStateArr = this.F;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i10) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i10 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.F = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState();
        panelFeatureState2.f11998a = i10;
        panelFeatureState2.f12010n = false;
        panelFeatureStateArr[i10] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final void u(int i10) {
        this.J = (1 << i10) | this.J;
        if (this.I) {
            return;
        }
        View decorView = this.f12126b.getDecorView();
        WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
        decorView.postOnAnimation(this.K);
        this.I = true;
    }

    public void v(ViewGroup viewGroup) {
        throw null;
    }

    public final void w(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        boolean z = panelFeatureState.f12009m;
        int i10 = panelFeatureState.f11998a;
        if (z || this.f12138o) {
            return;
        }
        Context context = this.f12125a;
        if (i10 == 0) {
            boolean z3 = (context.getResources().getConfiguration().screenLayout & 15) == 4;
            boolean z10 = context.getApplicationInfo().targetSdkVersion >= 11;
            if (z3 && z10) {
                return;
            }
        }
        Window.Callback callback = this.f12126b.getCallback();
        if (callback != null && !callback.onMenuOpened(i10, panelFeatureState.h)) {
            q(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null && z(panelFeatureState, keyEvent)) {
            f fVar = panelFeatureState.f12002e;
            int i11 = -2;
            if (fVar == null || panelFeatureState.f12010n) {
                if (fVar == null) {
                    l();
                    stepos.support.v7.app.a aVar = this.f12130f;
                    Context contextD = aVar != null ? aVar.d() : null;
                    if (contextD != null) {
                        context = contextD;
                    }
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(context.getTheme());
                    themeNewTheme.resolveAttribute(com.stepos.aiengine.R.attr.actionBarPopupTheme, typedValue, true);
                    int i12 = typedValue.resourceId;
                    if (i12 != 0) {
                        themeNewTheme.applyStyle(i12, true);
                    }
                    themeNewTheme.resolveAttribute(com.stepos.aiengine.R.attr.panelMenuListTheme, typedValue, true);
                    int i13 = typedValue.resourceId;
                    if (i13 != 0) {
                        themeNewTheme.applyStyle(i13, true);
                    } else {
                        themeNewTheme.applyStyle(com.stepos.aiengine.R.style.Theme_AppCompat_CompactMenu, true);
                    }
                    k.c cVar = new k.c(context, 0);
                    cVar.getTheme().setTo(themeNewTheme);
                    panelFeatureState.f12006j = cVar;
                    TypedArray typedArrayObtainStyledAttributes = cVar.obtainStyledAttributes(g.a.f8929j);
                    panelFeatureState.f11999b = typedArrayObtainStyledAttributes.getResourceId(86, 0);
                    panelFeatureState.f12001d = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                    typedArrayObtainStyledAttributes.recycle();
                    panelFeatureState.f12002e = new f(panelFeatureState.f12006j);
                    panelFeatureState.f12000c = 81;
                } else if (panelFeatureState.f12010n && fVar.getChildCount() > 0) {
                    panelFeatureState.f12002e.removeAllViews();
                }
                View view = panelFeatureState.f12004g;
                if (view != null) {
                    panelFeatureState.f12003f = view;
                } else {
                    if (panelFeatureState.h == null) {
                        return;
                    }
                    if (this.f11991s == null) {
                        this.f11991s = new g();
                    }
                    g gVar = this.f11991s;
                    if (panelFeatureState.f12005i == null) {
                        stepos.support.v7.view.menu.b bVar = new stepos.support.v7.view.menu.b(panelFeatureState.f12006j);
                        panelFeatureState.f12005i = bVar;
                        bVar.f12371e = gVar;
                        stepos.support.v7.view.menu.c cVar2 = panelFeatureState.h;
                        cVar2.b(bVar, cVar2.f12374a);
                    }
                    View view2 = (View) panelFeatureState.f12005i.i(panelFeatureState.f12002e);
                    panelFeatureState.f12003f = view2;
                    if (view2 == null) {
                        return;
                    }
                }
                if (panelFeatureState.f12003f == null) {
                    return;
                }
                if (panelFeatureState.f12004g == null && ((b.a) panelFeatureState.f12005i.h()).getCount() <= 0) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = panelFeatureState.f12003f.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-2, -2);
                }
                panelFeatureState.f12002e.setBackgroundResource(panelFeatureState.f11999b);
                ViewParent parent = panelFeatureState.f12003f.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(panelFeatureState.f12003f);
                }
                panelFeatureState.f12002e.addView(panelFeatureState.f12003f, layoutParams);
                if (!panelFeatureState.f12003f.hasFocus()) {
                    panelFeatureState.f12003f.requestFocus();
                }
            } else {
                View view3 = panelFeatureState.f12004g;
                if (view3 != null) {
                    ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
                    if (layoutParams2 != null && layoutParams2.width == -1) {
                        i11 = -1;
                    }
                } else {
                    if (panelFeatureState.f12003f == null) {
                        return;
                    }
                    if (view3 == null && ((b.a) panelFeatureState.f12005i.h()).getCount() <= 0) {
                        return;
                    }
                }
            }
            int i14 = i11;
            panelFeatureState.f12008l = false;
            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i14, -2, 0, 0, 1002, 8519680, -3);
            layoutParams3.gravity = panelFeatureState.f12000c;
            layoutParams3.windowAnimations = panelFeatureState.f12001d;
            windowManager.addView(panelFeatureState.f12002e, layoutParams3);
            panelFeatureState.f12009m = true;
        }
    }

    public final boolean x(PanelFeatureState panelFeatureState, int i10, KeyEvent keyEvent) {
        stepos.support.v7.view.menu.c cVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f12007k || z(panelFeatureState, keyEvent)) && (cVar = panelFeatureState.h) != null) {
            return cVar.performShortcut(i10, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, stepos.support.v7.app.g] */
    public final void y(PanelFeatureState panelFeatureState) {
        stepos.support.v7.view.menu.c cVar = new stepos.support.v7.view.menu.c(this.f12125a);
        cVar.f12377d = this.O;
        if (cVar != panelFeatureState.f12013q) {
            panelFeatureState.f12013q = cVar;
        }
        stepos.support.v7.widget.j jVar = this.f11990q;
        if (jVar != null) {
            if (this.r == null) {
                this.r = new d();
            }
            jVar.q(panelFeatureState.f12013q, this.r);
        }
        panelFeatureState.f12013q.v();
        if (this.f12129e.onCreateBottomMenu(panelFeatureState.f12013q)) {
            panelFeatureState.f12013q.u();
            return;
        }
        if (panelFeatureState.f12013q != null) {
            panelFeatureState.f12013q = null;
        }
        stepos.support.v7.widget.j jVar2 = this.f11990q;
        if (jVar2 != null) {
            jVar2.q(null, this.r);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d0  */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, stepos.support.v7.app.g] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean z(stepos.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.AppCompatDelegateImplV7.z(stepos.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState, android.view.KeyEvent):boolean");
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements c.a {
        public b() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, stepos.support.v7.app.g] */
        @Override // stepos.support.v7.view.menu.c.a
        public final boolean b(stepos.support.v7.view.menu.c cVar, MenuItem menuItem) {
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            ?? r12 = appCompatDelegateImplV7.f12129e;
            if (appCompatDelegateImplV7.f12138o || !(menuItem instanceof ge.g)) {
                return false;
            }
            return r12.onBottomItemSelected((ge.g) menuItem);
        }

        @Override // stepos.support.v7.view.menu.c.a
        public final void a(stepos.support.v7.view.menu.c cVar) {
        }
    }
}
