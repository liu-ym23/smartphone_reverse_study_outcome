package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.v;
import androidx.appcompat.app.w;
import androidx.appcompat.app.w.d;
import androidx.appcompat.view.menu.f;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.d0;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.data.base.Content;
import com.stepos.core.ota.crypto.FekEnvelope;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.WeakHashMap;
import k.e;
import k.h;
import mb.y;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AppCompatDelegateImpl extends androidx.appcompat.app.k implements f.a, LayoutInflater.Factory2 {

    /* renamed from: l0, reason: collision with root package name */
    public static final p.o<String, Integer> f258l0 = new p.o<>();

    /* renamed from: m0, reason: collision with root package name */
    public static final int[] f259m0 = {R.attr.windowBackground};

    /* renamed from: n0, reason: collision with root package name */
    public static final boolean f260n0 = !"robolectric".equals(Build.FINGERPRINT);
    public n A;
    public boolean D;
    public ViewGroup E;
    public TextView F;
    public View G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public PanelFeatureState[] P;
    public PanelFeatureState Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public Configuration V;
    public final int W;
    public int X;
    public int Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public j f261a0;
    public h b0;
    public boolean c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f262d0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f264f0;

    /* renamed from: g0, reason: collision with root package name */
    public Rect f265g0;

    /* renamed from: h0, reason: collision with root package name */
    public Rect f266h0;

    /* renamed from: i0, reason: collision with root package name */
    public s f267i0;

    /* renamed from: j0, reason: collision with root package name */
    public OnBackInvokedDispatcher f268j0;

    /* renamed from: k0, reason: collision with root package name */
    public OnBackInvokedCallback f269k0;

    /* renamed from: m, reason: collision with root package name */
    public final Object f270m;

    /* renamed from: n, reason: collision with root package name */
    public final Context f271n;

    /* renamed from: o, reason: collision with root package name */
    public Window f272o;

    /* renamed from: p, reason: collision with root package name */
    public g f273p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f274q;
    public w r;

    /* renamed from: s, reason: collision with root package name */
    public k.f f275s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f276t;

    /* renamed from: u, reason: collision with root package name */
    public d0 f277u;

    /* renamed from: v, reason: collision with root package name */
    public b f278v;

    /* renamed from: w, reason: collision with root package name */
    public l f279w;

    /* renamed from: x, reason: collision with root package name */
    public k.a f280x;

    /* renamed from: y, reason: collision with root package name */
    public ActionBarContextView f281y;
    public PopupWindow z;
    public h0 B = null;
    public final boolean C = true;

    /* renamed from: e0, reason: collision with root package name */
    public final a f263e0 = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class PanelFeatureState {

        /* renamed from: a, reason: collision with root package name */
        public int f282a;

        /* renamed from: b, reason: collision with root package name */
        public int f283b;

        /* renamed from: c, reason: collision with root package name */
        public int f284c;

        /* renamed from: d, reason: collision with root package name */
        public int f285d;

        /* renamed from: e, reason: collision with root package name */
        public k f286e;

        /* renamed from: f, reason: collision with root package name */
        public View f287f;

        /* renamed from: g, reason: collision with root package name */
        public View f288g;
        public androidx.appcompat.view.menu.f h;

        /* renamed from: i, reason: collision with root package name */
        public androidx.appcompat.view.menu.d f289i;

        /* renamed from: j, reason: collision with root package name */
        public k.c f290j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f291k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f292l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f293m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f294n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f295o;

        /* renamed from: p, reason: collision with root package name */
        public Bundle f296p;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            int featureId;
            boolean isOpen;
            Bundle menuState;

            /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
            public class a implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.ClassLoaderCreator
                public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.readFromParcel(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public final Object[] newArray(int i10) {
                    return new SavedState[i10];
                }

                @Override // android.os.Parcelable.Creator
                public final Object createFromParcel(Parcel parcel) {
                    return SavedState.readFromParcel(parcel, null);
                }
            }

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
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.f262d0 & 1) != 0) {
                appCompatDelegateImpl.A(0);
            }
            if ((appCompatDelegateImpl.f262d0 & 4096) != 0) {
                appCompatDelegateImpl.A(Content.Types.TYPE_DOUBLE_ARRAY);
            }
            appCompatDelegateImpl.c0 = false;
            appCompatDelegateImpl.f262d0 = 0;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class b implements j.a {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z) {
            AppCompatDelegateImpl.this.w(fVar);
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f fVar) {
            Window.Callback callback = AppCompatDelegateImpl.this.f272o.getCallback();
            if (callback == null) {
                return true;
            }
            callback.onMenuOpened(Content.Types.TYPE_DOUBLE_ARRAY, fVar);
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public final e.a f299a;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a extends y {
            public a() {
            }

            @Override // mb.y, v0.i0
            public final void d(View view) {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.f281y.setVisibility(8);
                PopupWindow popupWindow = appCompatDelegateImpl.z;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f281y.getParent() instanceof View) {
                    View view2 = (View) appCompatDelegateImpl.f281y.getParent();
                    WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                    e0.c.b(view2);
                }
                appCompatDelegateImpl.f281y.h();
                appCompatDelegateImpl.B.e(null);
                appCompatDelegateImpl.B = null;
                ViewGroup viewGroup = appCompatDelegateImpl.E;
                WeakHashMap<View, h0> weakHashMap2 = e0.f13274a;
                e0.c.b(viewGroup);
            }
        }

        public c(e.a aVar) {
            this.f299a = aVar;
        }

        public final void a(k.a aVar) {
            e.a aVar2 = this.f299a;
            aVar2.f9786a.onDestroyActionMode(aVar2.a(aVar));
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.z != null) {
                appCompatDelegateImpl.f272o.getDecorView().removeCallbacks(appCompatDelegateImpl.A);
            }
            if (appCompatDelegateImpl.f281y != null) {
                h0 h0Var = appCompatDelegateImpl.B;
                if (h0Var != null) {
                    h0Var.b();
                }
                h0 h0VarA = e0.a(appCompatDelegateImpl.f281y);
                h0VarA.a(0.0f);
                appCompatDelegateImpl.B = h0VarA;
                h0VarA.e(new a());
            }
            appCompatDelegateImpl.f280x = null;
            ViewGroup viewGroup = appCompatDelegateImpl.E;
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            e0.c.b(viewGroup);
            appCompatDelegateImpl.N();
        }

        public final boolean b(k.a aVar, Menu menu) {
            ViewGroup viewGroup = AppCompatDelegateImpl.this.E;
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            e0.c.b(viewGroup);
            e.a aVar2 = this.f299a;
            ActionMode.Callback callback = aVar2.f9786a;
            k.e eVarA = aVar2.a(aVar);
            p.o<Menu, Menu> oVar = aVar2.f9789d;
            Menu eVar = oVar.get(menu);
            if (eVar == null) {
                eVar = new l.e(aVar2.f9787b, (p0.a) menu);
                oVar.put(menu, eVar);
            }
            return callback.onPrepareActionMode(eVarA, eVar);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d {
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        public static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        public static r0.d b(Configuration configuration) {
            return r0.d.a(configuration.getLocales().toLanguageTags());
        }

        public static void c(r0.d dVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(dVar.f11677a.f11679a.toLanguageTags()));
        }

        public static void d(Configuration configuration, r0.d dVar) {
            configuration.setLocales(LocaleList.forLanguageTags(dVar.f11677a.f11679a.toLanguageTags()));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class f {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Object obj, AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            p pVar = new p(appCompatDelegateImpl, 0);
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, pVar);
            return pVar;
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class g extends k.h {

        /* renamed from: b, reason: collision with root package name */
        public boolean f302b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f303c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f304d;

        public g(Window.Callback callback) {
            super(callback);
        }

        public final void a(Window.Callback callback) {
            try {
                this.f302b = true;
                callback.onContentChanged();
            } finally {
                this.f302b = false;
            }
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            boolean z = this.f303c;
            Window.Callback callback = this.f9831a;
            return z ? callback.dispatchKeyEvent(keyEvent) : AppCompatDelegateImpl.this.z(keyEvent) || callback.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x006e A[RETURN] */
        @Override // android.view.Window.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r6) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            /*
                r5 = this;
                android.view.Window$Callback r0 = r5.f9831a
                boolean r0 = r0.dispatchKeyShortcutEvent(r6)
                r1 = 1
                if (r0 != 0) goto L6f
                int r0 = r6.getKeyCode()
                androidx.appcompat.app.AppCompatDelegateImpl r5 = androidx.appcompat.app.AppCompatDelegateImpl.this
                r5.F()
                androidx.appcompat.app.w r2 = r5.r
                r3 = 0
                if (r2 == 0) goto L3d
                androidx.appcompat.app.w$d r2 = r2.f380i
                if (r2 != 0) goto L1d
            L1b:
                r0 = r3
                goto L39
            L1d:
                androidx.appcompat.view.menu.f r2 = r2.f399d
                if (r2 == 0) goto L1b
                int r4 = r6.getDeviceId()
                android.view.KeyCharacterMap r4 = android.view.KeyCharacterMap.load(r4)
                int r4 = r4.getKeyboardType()
                if (r4 == r1) goto L31
                r4 = r1
                goto L32
            L31:
                r4 = r3
            L32:
                r2.setQwertyMode(r4)
                boolean r0 = r2.performShortcut(r0, r6, r3)
            L39:
                if (r0 == 0) goto L3d
            L3b:
                r5 = r1
                goto L6b
            L3d:
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r5.Q
                if (r0 == 0) goto L52
                int r2 = r6.getKeyCode()
                boolean r0 = r5.K(r0, r2, r6)
                if (r0 == 0) goto L52
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r5 = r5.Q
                if (r5 == 0) goto L3b
                r5.f292l = r1
                goto L3b
            L52:
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r5.Q
                if (r0 != 0) goto L6a
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r5.E(r3)
                r5.L(r0, r6)
                int r2 = r6.getKeyCode()
                boolean r5 = r5.K(r0, r2, r6)
                r0.f291k = r3
                if (r5 == 0) goto L6a
                goto L3b
            L6a:
                r5 = r3
            L6b:
                if (r5 == 0) goto L6e
                goto L6f
            L6e:
                return r3
            L6f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.g.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
            if (this.f302b) {
                this.f9831a.onContentChanged();
            }
        }

        @Override // k.h, android.view.Window.Callback
        public final boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof androidx.appcompat.view.menu.f)) {
                return this.f9831a.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        @Override // k.h, android.view.Window.Callback
        public final View onCreatePanelView(int i10) {
            return this.f9831a.onCreatePanelView(i10);
        }

        @Override // k.h, android.view.Window.Callback
        public final boolean onMenuOpened(int i10, Menu menu) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            super.onMenuOpened(i10, menu);
            if (i10 == 108) {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.F();
                w wVar = appCompatDelegateImpl.r;
                if (wVar != null) {
                    wVar.b(true);
                }
            }
            return true;
        }

        @Override // k.h, android.view.Window.Callback
        public final void onPanelClosed(int i10, Menu menu) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (this.f304d) {
                this.f9831a.onPanelClosed(i10, menu);
                return;
            }
            super.onPanelClosed(i10, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i10 == 108) {
                appCompatDelegateImpl.F();
                w wVar = appCompatDelegateImpl.r;
                if (wVar != null) {
                    wVar.b(false);
                    return;
                }
                return;
            }
            if (i10 == 0) {
                PanelFeatureState panelFeatureStateE = appCompatDelegateImpl.E(i10);
                if (panelFeatureStateE.f293m) {
                    appCompatDelegateImpl.x(panelFeatureStateE, false);
                }
            }
        }

        @Override // k.h, android.view.Window.Callback
        public final boolean onPreparePanel(int i10, View view, Menu menu) {
            androidx.appcompat.view.menu.f fVar = menu instanceof androidx.appcompat.view.menu.f ? (androidx.appcompat.view.menu.f) menu : null;
            if (i10 == 0 && fVar == null) {
                return false;
            }
            if (fVar != null) {
                fVar.B = true;
            }
            boolean zOnPreparePanel = this.f9831a.onPreparePanel(i10, view, menu);
            if (fVar != null) {
                fVar.B = false;
            }
            return zOnPreparePanel;
        }

        @Override // k.h, android.view.Window.Callback
        public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i10) {
            androidx.appcompat.view.menu.f fVar = AppCompatDelegateImpl.this.E(0).h;
            if (fVar != null) {
                super.onProvideKeyboardShortcuts(list, fVar, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            }
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // android.view.Window.Callback
        public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            ViewGroup viewGroup;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.C || i10 != 0) {
                return h.a.b(this.f9831a, callback, i10);
            }
            Context context = appCompatDelegateImpl.f271n;
            e.a aVar = new e.a(context, callback);
            Object obj = appCompatDelegateImpl.f274q;
            k.a aVar2 = appCompatDelegateImpl.f280x;
            if (aVar2 != null) {
                aVar2.c();
            }
            c cVar = appCompatDelegateImpl.new c(aVar);
            appCompatDelegateImpl.F();
            w wVar = appCompatDelegateImpl.r;
            if (wVar != null) {
                w.d dVar = wVar.f380i;
                if (dVar != null) {
                    dVar.c();
                }
                wVar.f375c.setHideOnContentScrollEnabled(false);
                wVar.f378f.h();
                w.d dVar2 = wVar.new d(wVar.f378f.getContext(), cVar);
                androidx.appcompat.view.menu.f fVar = dVar2.f399d;
                fVar.w();
                try {
                    if (dVar2.f400e.f299a.c(dVar2, fVar)) {
                        wVar.f380i = dVar2;
                        dVar2.i();
                        wVar.f378f.f(dVar2);
                        wVar.a(true);
                    } else {
                        dVar2 = null;
                    }
                    appCompatDelegateImpl.f280x = dVar2;
                } finally {
                    fVar.v();
                }
            }
            if (appCompatDelegateImpl.f280x == null) {
                h0 h0Var = appCompatDelegateImpl.B;
                if (h0Var != null) {
                    h0Var.b();
                }
                k.a aVar3 = appCompatDelegateImpl.f280x;
                if (aVar3 != null) {
                    aVar3.c();
                }
                if (obj != null) {
                    boolean z = appCompatDelegateImpl.U;
                }
                if (appCompatDelegateImpl.f281y == null) {
                    if (appCompatDelegateImpl.M) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(com.stepos.aiengine.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Resources.Theme themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            k.c cVar2 = new k.c(context, 0);
                            cVar2.getTheme().setTo(themeNewTheme);
                            context = cVar2;
                        }
                        appCompatDelegateImpl.f281y = new ActionBarContextView(context, null);
                        PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, com.stepos.aiengine.R.attr.actionModePopupWindowStyle);
                        appCompatDelegateImpl.z = popupWindow;
                        popupWindow.setWindowLayoutType(2);
                        appCompatDelegateImpl.z.setContentView(appCompatDelegateImpl.f281y);
                        appCompatDelegateImpl.z.setWidth(-1);
                        context.getTheme().resolveAttribute(com.stepos.aiengine.R.attr.actionBarSize, typedValue, true);
                        appCompatDelegateImpl.f281y.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                        appCompatDelegateImpl.z.setHeight(-2);
                        appCompatDelegateImpl.A = new n(appCompatDelegateImpl);
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) appCompatDelegateImpl.E.findViewById(com.stepos.aiengine.R.id.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            appCompatDelegateImpl.F();
                            w wVar2 = appCompatDelegateImpl.r;
                            Context contextC = wVar2 != null ? wVar2.c() : null;
                            if (contextC != null) {
                                context = contextC;
                            }
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(context));
                            appCompatDelegateImpl.f281y = (ActionBarContextView) viewStubCompat.a();
                        }
                    }
                }
                if (appCompatDelegateImpl.f281y != null) {
                    h0 h0Var2 = appCompatDelegateImpl.B;
                    if (h0Var2 != null) {
                        h0Var2.b();
                    }
                    appCompatDelegateImpl.f281y.h();
                    Context context2 = appCompatDelegateImpl.f281y.getContext();
                    ActionBarContextView actionBarContextView = appCompatDelegateImpl.f281y;
                    k.d dVar3 = new k.d();
                    dVar3.f9779c = context2;
                    dVar3.f9780d = actionBarContextView;
                    dVar3.f9781e = cVar;
                    androidx.appcompat.view.menu.f fVar2 = new androidx.appcompat.view.menu.f(actionBarContextView.getContext());
                    fVar2.f488o = 1;
                    dVar3.f9783k = fVar2;
                    fVar2.f482e = dVar3;
                    if (aVar.c(dVar3, fVar2)) {
                        dVar3.i();
                        appCompatDelegateImpl.f281y.f(dVar3);
                        appCompatDelegateImpl.f280x = dVar3;
                        if (appCompatDelegateImpl.D && (viewGroup = appCompatDelegateImpl.E) != null && viewGroup.isLaidOut()) {
                            appCompatDelegateImpl.f281y.setAlpha(0.0f);
                            h0 h0VarA = e0.a(appCompatDelegateImpl.f281y);
                            h0VarA.a(1.0f);
                            appCompatDelegateImpl.B = h0VarA;
                            h0VarA.e(new o(appCompatDelegateImpl));
                        } else {
                            appCompatDelegateImpl.f281y.setAlpha(1.0f);
                            appCompatDelegateImpl.f281y.setVisibility(0);
                            if (appCompatDelegateImpl.f281y.getParent() instanceof View) {
                                View view = (View) appCompatDelegateImpl.f281y.getParent();
                                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                                e0.c.b(view);
                            }
                        }
                        if (appCompatDelegateImpl.z != null) {
                            appCompatDelegateImpl.f272o.getDecorView().post(appCompatDelegateImpl.A);
                        }
                    } else {
                        appCompatDelegateImpl.f280x = null;
                    }
                }
                appCompatDelegateImpl.N();
                appCompatDelegateImpl.f280x = appCompatDelegateImpl.f280x;
            }
            appCompatDelegateImpl.N();
            k.a aVar4 = appCompatDelegateImpl.f280x;
            if (aVar4 != null) {
                return aVar.a(aVar4);
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class h extends i {

        /* renamed from: c, reason: collision with root package name */
        public final PowerManager f306c;

        public h(Context context) {
            super();
            this.f306c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.i
        public final IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.i
        public final int c() {
            return d.a(this.f306c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.i
        public final void d() throws PackageManager.NameNotFoundException {
            AppCompatDelegateImpl.this.s(true, true);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public abstract class i {

        /* renamed from: a, reason: collision with root package name */
        public a f308a;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                i.this.d();
            }
        }

        public i() {
        }

        public final void a() {
            a aVar = this.f308a;
            if (aVar != null) {
                try {
                    AppCompatDelegateImpl.this.f271n.unregisterReceiver(aVar);
                } catch (IllegalArgumentException unused) {
                }
                this.f308a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public final void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f308a == null) {
                this.f308a = new a();
            }
            AppCompatDelegateImpl.this.f271n.registerReceiver(this.f308a, intentFilterB);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class j extends i {

        /* renamed from: c, reason: collision with root package name */
        public final v f311c;

        public j(v vVar) {
            super();
            this.f311c = vVar;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.i
        public final IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.i
        public final int c() {
            Location location;
            boolean z;
            long j10;
            v vVar = this.f311c;
            v.a aVar = vVar.f369c;
            LocationManager locationManager = vVar.f368b;
            if (aVar.f371b > System.currentTimeMillis()) {
                z = aVar.f370a;
            } else {
                Context context = vVar.f367a;
                Location lastKnownLocation = null;
                if (a4.a.g(context, PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION) == 0) {
                    try {
                    } catch (Exception e10) {
                        Log.d("TwilightManager", "Failed to get last known location", e10);
                    }
                    Location lastKnownLocation2 = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                    location = lastKnownLocation2;
                } else {
                    location = null;
                }
                if (a4.a.g(context, PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) == 0) {
                    try {
                        if (locationManager.isProviderEnabled("gps")) {
                            lastKnownLocation = locationManager.getLastKnownLocation("gps");
                        }
                    } catch (Exception e11) {
                        Log.d("TwilightManager", "Failed to get last known location", e11);
                    }
                }
                if (lastKnownLocation == null || location == null ? lastKnownLocation != null : lastKnownLocation.getTime() > location.getTime()) {
                    location = lastKnownLocation;
                }
                if (location != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (u.f362d == null) {
                        u.f362d = new u();
                    }
                    u uVar = u.f362d;
                    uVar.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis - 86400000);
                    uVar.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis);
                    z = uVar.f365c == 1;
                    long j11 = uVar.f364b;
                    long j12 = uVar.f363a;
                    uVar.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis + 86400000);
                    long j13 = uVar.f364b;
                    if (j11 == -1 || j12 == -1) {
                        j10 = jCurrentTimeMillis + 43200000;
                    } else {
                        if (jCurrentTimeMillis > j12) {
                            j11 = j13;
                        } else if (jCurrentTimeMillis > j11) {
                            j11 = j12;
                        }
                        j10 = j11 + HysteresisStrategy.DEFAULT_DWELL_MS;
                    }
                    aVar.f370a = z;
                    aVar.f371b = j10;
                } else {
                    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                    int i10 = Calendar.getInstance().get(11);
                    if (i10 < 6 || i10 >= 22) {
                        z = true;
                    }
                }
            }
            return z ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.i
        public final void d() throws PackageManager.NameNotFoundException {
            AppCompatDelegateImpl.this.s(true, true);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class k extends ContentFrameLayout {
        public k(k.c cVar) {
            super(cVar);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.z(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x3 = (int) motionEvent.getX();
                int y3 = (int) motionEvent.getY();
                if (x3 < -5 || y3 < -5 || x3 > getWidth() + 5 || y3 > getHeight() + 5) {
                    AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                    appCompatDelegateImpl.x(appCompatDelegateImpl.E(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public final void setBackgroundResource(int i10) {
            setBackgroundDrawable(b1.L(i10, getContext()));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class l implements j.a {
        public l() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final void a(androidx.appcompat.view.menu.f fVar, boolean z) {
            PanelFeatureState panelFeatureState;
            androidx.appcompat.view.menu.f fVarK = fVar.k();
            int i10 = 0;
            boolean z3 = fVarK != fVar;
            if (z3) {
                fVar = fVarK;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            PanelFeatureState[] panelFeatureStateArr = appCompatDelegateImpl.P;
            int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
            while (true) {
                if (i10 < length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                    if (panelFeatureState != null && panelFeatureState.h == fVar) {
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
                    appCompatDelegateImpl.x(panelFeatureState, z);
                } else {
                    appCompatDelegateImpl.v(panelFeatureState.f282a, panelFeatureState, fVarK);
                    appCompatDelegateImpl.x(panelFeatureState, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public final boolean b(androidx.appcompat.view.menu.f fVar) {
            Window.Callback callback;
            if (fVar != fVar.k()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.J || (callback = appCompatDelegateImpl.f272o.getCallback()) == null || appCompatDelegateImpl.U) {
                return true;
            }
            callback.onMenuOpened(Content.Types.TYPE_DOUBLE_ARRAY, fVar);
            return true;
        }
    }

    public AppCompatDelegateImpl(Context context, Window window, androidx.appcompat.app.j jVar, Object obj) {
        androidx.appcompat.app.i iVar = null;
        this.W = -100;
        this.f271n = context;
        this.f274q = jVar;
        this.f270m = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof androidx.appcompat.app.i)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    } else {
                        iVar = (androidx.appcompat.app.i) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (iVar != null) {
                this.W = iVar.q().f();
            }
        }
        if (this.W == -100) {
            String name = this.f270m.getClass().getName();
            p.o<String, Integer> oVar = f258l0;
            Integer num = oVar.get(name);
            if (num != null) {
                this.W = num.intValue();
                oVar.remove(this.f270m.getClass().getName());
            }
        }
        if (window != null) {
            t(window);
        }
        androidx.appcompat.widget.j.d();
    }

    public static r0.d u(Context context) {
        r0.d dVar;
        r0.d dVar2;
        if (Build.VERSION.SDK_INT >= 33 || (dVar = androidx.appcompat.app.k.f330c) == null) {
            return null;
        }
        r0.d dVarB = e.b(context.getApplicationContext().getResources().getConfiguration());
        LocaleList localeList = dVar.f11677a.f11679a;
        if (localeList.isEmpty()) {
            dVar2 = r0.d.f11676b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i10 = 0;
            while (i10 < dVarB.f11677a.f11679a.size() + localeList.size()) {
                Locale locale = i10 < localeList.size() ? localeList.get(i10) : dVarB.f11677a.f11679a.get(i10 - localeList.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i10++;
            }
            dVar2 = new r0.d(new r0.f(new LocaleList((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        return dVar2.f11677a.f11679a.isEmpty() ? dVarB : dVar2;
    }

    public static Configuration y(Context context, int i10, r0.d dVar, Configuration configuration, boolean z) {
        int i11 = i10 != 1 ? i10 != 2 ? z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & (-49));
        if (dVar != null) {
            e.d(configuration2, dVar);
        }
        return configuration2;
    }

    public final void A(int i10) {
        PanelFeatureState panelFeatureStateE = E(i10);
        if (panelFeatureStateE.h != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateE.h.t(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateE.f296p = bundle;
            }
            panelFeatureStateE.h.w();
            panelFeatureStateE.h.clear();
        }
        panelFeatureStateE.f295o = true;
        panelFeatureStateE.f294n = true;
        if ((i10 == 108 || i10 == 0) && this.f277u != null) {
            PanelFeatureState panelFeatureStateE2 = E(0);
            panelFeatureStateE2.f291k = false;
            L(panelFeatureStateE2, null);
        }
    }

    public final void B() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        if (this.D) {
            return;
        }
        Context context = this.f271n;
        int[] iArr = g.a.f8929j;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(121)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        int i10 = 1;
        if (typedArrayObtainStyledAttributes.getBoolean(130, false)) {
            n(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(121, false)) {
            n(Content.Types.TYPE_DOUBLE_ARRAY);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(FekEnvelope.EXPECTED_EPK_CHARS, false)) {
            n(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(123, false)) {
            n(10);
        }
        this.M = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        C();
        this.f272o.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.N) {
            viewGroup = this.L ? (ViewGroup) layoutInflaterFrom.inflate(com.stepos.aiengine.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.stepos.aiengine.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.M) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.stepos.aiengine.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.K = false;
            this.J = false;
        } else if (this.J) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.stepos.aiengine.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new k.c(context, typedValue.resourceId) : context).inflate(com.stepos.aiengine.R.layout.abc_screen_toolbar, (ViewGroup) null);
            d0 d0Var = (d0) viewGroup.findViewById(com.stepos.aiengine.R.id.decor_content_parent);
            this.f277u = d0Var;
            d0Var.setWindowCallback(this.f272o.getCallback());
            if (this.K) {
                this.f277u.g(109);
            }
            if (this.H) {
                this.f277u.g(2);
            }
            if (this.I) {
                this.f277u.g(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            StringBuilder sb2 = new StringBuilder("AppCompat does not support the current theme features: { windowActionBar: ");
            sb2.append(this.J);
            sb2.append(", windowActionBarOverlay: ");
            sb2.append(this.K);
            sb2.append(", android:windowIsFloating: ");
            sb2.append(this.M);
            sb2.append(", windowActionModeOverlay: ");
            sb2.append(this.L);
            sb2.append(", windowNoTitle: ");
            throw new IllegalArgumentException(a0.a.m(sb2, this.N, " }"));
        }
        stepos.support.v7.app.palette.b bVar = new stepos.support.v7.app.palette.b(this, i10);
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        e0.d.k(viewGroup, bVar);
        if (this.f277u == null) {
            this.F = (TextView) viewGroup.findViewById(com.stepos.aiengine.R.id.title);
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
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.stepos.aiengine.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f272o.findViewById(R.id.content);
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
        this.f272o.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new m(this));
        this.E = viewGroup;
        Object obj = this.f270m;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f276t;
        if (!TextUtils.isEmpty(title)) {
            d0 d0Var2 = this.f277u;
            if (d0Var2 != null) {
                d0Var2.setWindowTitle(title);
            } else {
                w wVar = this.r;
                if (wVar != null) {
                    wVar.f377e.setWindowTitle(title);
                } else {
                    TextView textView = this.F;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.E.findViewById(R.id.content);
        View decorView = this.f272o.getDecorView();
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
        this.D = true;
        PanelFeatureState panelFeatureStateE = E(0);
        if (this.U || panelFeatureStateE.h != null) {
            return;
        }
        G(Content.Types.TYPE_DOUBLE_ARRAY);
    }

    public final void C() {
        if (this.f272o == null) {
            Object obj = this.f270m;
            if (obj instanceof Activity) {
                t(((Activity) obj).getWindow());
            }
        }
        if (this.f272o == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final i D(Context context) {
        if (this.f261a0 == null) {
            if (v.f366d == null) {
                Context applicationContext = context.getApplicationContext();
                v.f366d = new v(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f261a0 = new j(v.f366d);
        }
        return this.f261a0;
    }

    public final PanelFeatureState E(int i10) {
        PanelFeatureState[] panelFeatureStateArr = this.P;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i10) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i10 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.P = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState();
        panelFeatureState2.f282a = i10;
        panelFeatureState2.f294n = false;
        panelFeatureStateArr[i10] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final void F() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        B();
        if (this.J && this.r == null) {
            Object obj = this.f270m;
            if (obj instanceof Activity) {
                this.r = new w((Activity) obj, this.K);
            } else if (obj instanceof Dialog) {
                this.r = new w((Dialog) obj);
            }
            w wVar = this.r;
            if (wVar != null) {
                wVar.e(this.f264f0);
            }
        }
    }

    public final void G(int i10) {
        this.f262d0 = (1 << i10) | this.f262d0;
        if (this.c0) {
            return;
        }
        View decorView = this.f272o.getDecorView();
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        decorView.postOnAnimation(this.f263e0);
        this.c0 = true;
    }

    public final int H(int i10, Context context) {
        if (i10 != -100) {
            if (i10 != -1) {
                if (i10 != 0) {
                    if (i10 != 1 && i10 != 2) {
                        if (i10 != 3) {
                            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        }
                        if (this.b0 == null) {
                            this.b0 = new h(context);
                        }
                        return this.b0.c();
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return D(context).c();
                }
            }
            return i10;
        }
        return -1;
    }

    public final boolean I() {
        androidx.appcompat.widget.e0 e0Var;
        boolean z = this.R;
        this.R = false;
        PanelFeatureState panelFeatureStateE = E(0);
        if (panelFeatureStateE.f293m) {
            if (!z) {
                x(panelFeatureStateE, true);
            }
            return true;
        }
        k.a aVar = this.f280x;
        if (aVar != null) {
            aVar.c();
            return true;
        }
        F();
        w wVar = this.r;
        if (wVar == null || (e0Var = wVar.f377e) == null || !e0Var.g()) {
            return false;
        }
        wVar.f377e.collapseActionView();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0175, code lost:
    
        if (r2.h.getCount() > 0) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r18, android.view.KeyEvent r19) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.J(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    public final boolean K(PanelFeatureState panelFeatureState, int i10, KeyEvent keyEvent) {
        androidx.appcompat.view.menu.f fVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f291k || L(panelFeatureState, keyEvent)) && (fVar = panelFeatureState.h) != null) {
            return fVar.performShortcut(i10, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean L(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.L(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):boolean");
    }

    public final void M() {
        if (this.D) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void N() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.f268j0 != null && (E(0).f293m || this.f280x != null)) {
                z = true;
            }
            if (z && this.f269k0 == null) {
                this.f269k0 = f.b(this.f268j0, this);
            } else {
                if (z || (onBackInvokedCallback = this.f269k0) == null) {
                    return;
                }
                f.c(this.f268j0, onBackInvokedCallback);
                this.f269k0 = null;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final boolean a(androidx.appcompat.view.menu.f fVar, MenuItem menuItem) {
        PanelFeatureState panelFeatureState;
        Window.Callback callback = this.f272o.getCallback();
        if (callback != null && !this.U) {
            androidx.appcompat.view.menu.f fVarK = fVar.k();
            PanelFeatureState[] panelFeatureStateArr = this.P;
            int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                    if (panelFeatureState != null && panelFeatureState.h == fVarK) {
                        break;
                    }
                    i10++;
                } else {
                    panelFeatureState = null;
                    break;
                }
            }
            if (panelFeatureState != null) {
                return callback.onMenuItemSelected(panelFeatureState.f282a, menuItem);
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final void b(androidx.appcompat.view.menu.f fVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        d0 d0Var = this.f277u;
        if (d0Var == null || !d0Var.a() || (ViewConfiguration.get(this.f271n).hasPermanentMenuKey() && !this.f277u.f())) {
            PanelFeatureState panelFeatureStateE = E(0);
            panelFeatureStateE.f294n = true;
            x(panelFeatureStateE, false);
            J(panelFeatureStateE, null);
            return;
        }
        Window.Callback callback = this.f272o.getCallback();
        if (this.f277u.d()) {
            this.f277u.b();
            if (this.U) {
                return;
            }
            callback.onPanelClosed(Content.Types.TYPE_DOUBLE_ARRAY, E(0).h);
            return;
        }
        if (callback == null || this.U) {
            return;
        }
        if (this.c0 && (1 & this.f262d0) != 0) {
            View decorView = this.f272o.getDecorView();
            a aVar = this.f263e0;
            decorView.removeCallbacks(aVar);
            aVar.run();
        }
        PanelFeatureState panelFeatureStateE2 = E(0);
        androidx.appcompat.view.menu.f fVar2 = panelFeatureStateE2.h;
        if (fVar2 == null || panelFeatureStateE2.f295o || !callback.onPreparePanel(0, panelFeatureStateE2.f288g, fVar2)) {
            return;
        }
        callback.onMenuOpened(Content.Types.TYPE_DOUBLE_ARRAY, panelFeatureStateE2.h);
        this.f277u.c();
    }

    @Override // androidx.appcompat.app.k
    public final void c(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        B();
        ((ViewGroup) this.E.findViewById(R.id.content)).addView(view, layoutParams);
        this.f273p.a(this.f272o.getCallback());
    }

    @Override // androidx.appcompat.app.k
    public final <T extends View> T d(int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        B();
        return (T) this.f272o.findViewById(i10);
    }

    @Override // androidx.appcompat.app.k
    public final Context e() {
        return this.f271n;
    }

    @Override // androidx.appcompat.app.k
    public final int f() {
        return this.W;
    }

    @Override // androidx.appcompat.app.k
    public final void g() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f271n);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.k
    public final void h() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.r != null) {
            F();
            this.r.getClass();
            G(0);
        }
    }

    @Override // androidx.appcompat.app.k
    public final void j() throws PackageManager.NameNotFoundException {
        String strC;
        this.S = true;
        s(false, true);
        C();
        Object obj = this.f270m;
        if (obj instanceof Activity) {
            try {
                strC = androidx.core.app.e.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                w wVar = this.r;
                if (wVar == null) {
                    this.f264f0 = true;
                } else {
                    wVar.e(true);
                }
            }
            synchronized (androidx.appcompat.app.k.f334k) {
                androidx.appcompat.app.k.m(this);
                androidx.appcompat.app.k.f333j.add(new WeakReference<>(this));
            }
        }
        this.V = new Configuration(this.f271n.getResources().getConfiguration());
        this.T = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // androidx.appcompat.app.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f270m
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = androidx.appcompat.app.k.f334k
            monitor-enter(r0)
            androidx.appcompat.app.k.m(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r3
        L11:
            boolean r0 = r3.c0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f272o
            android.view.View r0 = r0.getDecorView()
            androidx.appcompat.app.AppCompatDelegateImpl$a r1 = r3.f263e0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.U = r0
            int r0 = r3.W
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f270m
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            p.o<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.f258l0
            java.lang.Object r1 = r3.f270m
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.W
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            p.o<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.f258l0
            java.lang.Object r1 = r3.f270m
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            androidx.appcompat.app.AppCompatDelegateImpl$j r0 = r3.f261a0
            if (r0 == 0) goto L63
            r0.a()
        L63:
            androidx.appcompat.app.AppCompatDelegateImpl$h r3 = r3.b0
            if (r3 == 0) goto L6a
            r3.a()
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.k():void");
    }

    @Override // androidx.appcompat.app.k
    public final void l() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        F();
        w wVar = this.r;
        if (wVar != null) {
            wVar.f390t = false;
            k.g gVar = wVar.f389s;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    @Override // androidx.appcompat.app.k
    public final boolean n(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i10 = 108;
        } else if (i10 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i10 = 109;
        }
        if (this.N && i10 == 108) {
            return false;
        }
        if (this.J && i10 == 1) {
            this.J = false;
        }
        if (i10 == 1) {
            M();
            this.N = true;
            return true;
        }
        if (i10 == 2) {
            M();
            this.H = true;
            return true;
        }
        if (i10 == 5) {
            M();
            this.I = true;
            return true;
        }
        if (i10 == 10) {
            M();
            this.L = true;
            return true;
        }
        if (i10 == 108) {
            M();
            this.J = true;
            return true;
        }
        if (i10 != 109) {
            return this.f272o.requestFeature(i10);
        }
        M();
        this.K = true;
        return true;
    }

    @Override // androidx.appcompat.app.k
    public final void o(int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        B();
        ViewGroup viewGroup = (ViewGroup) this.E.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f271n).inflate(i10, viewGroup);
        this.f273p.a(this.f272o.getCallback());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(android.view.View r8, java.lang.String r9, android.content.Context r10, android.util.AttributeSet r11) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    @Override // androidx.appcompat.app.k
    public final void p(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        B();
        ViewGroup viewGroup = (ViewGroup) this.E.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f273p.a(this.f272o.getCallback());
    }

    @Override // androidx.appcompat.app.k
    public final void q(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        B();
        ViewGroup viewGroup = (ViewGroup) this.E.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f273p.a(this.f272o.getCallback());
    }

    @Override // androidx.appcompat.app.k
    public final void r(CharSequence charSequence) {
        this.f276t = charSequence;
        d0 d0Var = this.f277u;
        if (d0Var != null) {
            d0Var.setWindowTitle(charSequence);
            return;
        }
        w wVar = this.r;
        if (wVar != null) {
            wVar.f377e.setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s(boolean r13, boolean r14) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.s(boolean, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(android.view.Window r8) {
        /*
            r7 = this;
            java.lang.String r0 = "AppCompat has already installed itself into the Window"
            android.view.Window r1 = r7.f272o
            if (r1 != 0) goto L80
            android.view.Window$Callback r1 = r8.getCallback()
            boolean r2 = r1 instanceof androidx.appcompat.app.AppCompatDelegateImpl.g
            if (r2 != 0) goto L7a
            androidx.appcompat.app.AppCompatDelegateImpl$g r0 = new androidx.appcompat.app.AppCompatDelegateImpl$g
            r0.<init>(r1)
            r7.f273p = r0
            r8.setCallback(r0)
            android.content.Context r0 = r7.f271n
            int[] r1 = androidx.appcompat.app.AppCompatDelegateImpl.f259m0
            r2 = 0
            android.content.res.TypedArray r1 = r0.obtainStyledAttributes(r2, r1)
            r3 = 0
            boolean r4 = r1.hasValue(r3)
            if (r4 == 0) goto L3f
            int r3 = r1.getResourceId(r3, r3)
            if (r3 == 0) goto L3f
            androidx.appcompat.widget.j r4 = androidx.appcompat.widget.j.a()
            monitor-enter(r4)
            androidx.appcompat.widget.n0 r5 = r4.f848a     // Catch: java.lang.Throwable -> L3c
            r6 = 1
            android.graphics.drawable.Drawable r0 = r5.d(r0, r3, r6)     // Catch: java.lang.Throwable -> L3c
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
            r7.f272o = r8
            int r8 = android.os.Build.VERSION.SDK_INT
            r0 = 33
            if (r8 < r0) goto L79
            android.window.OnBackInvokedDispatcher r8 = r7.f268j0
            if (r8 != 0) goto L79
            java.lang.Object r0 = r7.f270m
            if (r8 == 0) goto L61
            android.window.OnBackInvokedCallback r1 = r7.f269k0
            if (r1 == 0) goto L61
            androidx.appcompat.app.AppCompatDelegateImpl.f.c(r8, r1)
            r7.f269k0 = r2
        L61:
            boolean r8 = r0 instanceof android.app.Activity
            if (r8 == 0) goto L74
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r8 = r0.getWindow()
            if (r8 == 0) goto L74
            android.window.OnBackInvokedDispatcher r8 = androidx.appcompat.app.AppCompatDelegateImpl.f.a(r0)
            r7.f268j0 = r8
            goto L76
        L74:
            r7.f268j0 = r2
        L76:
            r7.N()
        L79:
            return
        L7a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>(r0)
            throw r7
        L80:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.t(android.view.Window):void");
    }

    public final void v(int i10, PanelFeatureState panelFeatureState, androidx.appcompat.view.menu.f fVar) {
        if (fVar == null) {
            if (panelFeatureState == null && i10 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.P;
                if (i10 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                }
            }
            if (panelFeatureState != null) {
                fVar = panelFeatureState.h;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f293m) && !this.U) {
            g gVar = this.f273p;
            Window.Callback callback = this.f272o.getCallback();
            gVar.getClass();
            try {
                gVar.f304d = true;
                callback.onPanelClosed(i10, fVar);
            } finally {
                gVar.f304d = false;
            }
        }
    }

    public final void w(androidx.appcompat.view.menu.f fVar) {
        if (this.O) {
            return;
        }
        this.O = true;
        this.f277u.n();
        Window.Callback callback = this.f272o.getCallback();
        if (callback != null && !this.U) {
            callback.onPanelClosed(Content.Types.TYPE_DOUBLE_ARRAY, fVar);
        }
        this.O = false;
    }

    public final void x(PanelFeatureState panelFeatureState, boolean z) {
        k kVar;
        d0 d0Var;
        if (z && panelFeatureState.f282a == 0 && (d0Var = this.f277u) != null && d0Var.d()) {
            w(panelFeatureState.h);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f271n.getSystemService("window");
        if (windowManager != null && panelFeatureState.f293m && (kVar = panelFeatureState.f286e) != null) {
            windowManager.removeView(kVar);
            if (z) {
                v(panelFeatureState.f282a, panelFeatureState, null);
            }
        }
        panelFeatureState.f291k = false;
        panelFeatureState.f292l = false;
        panelFeatureState.f293m = false;
        panelFeatureState.f287f = null;
        panelFeatureState.f294n = true;
        if (this.Q == panelFeatureState) {
            this.Q = null;
        }
        if (panelFeatureState.f282a == 0) {
            N();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean z(android.view.KeyEvent r7) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.z(android.view.KeyEvent):boolean");
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
