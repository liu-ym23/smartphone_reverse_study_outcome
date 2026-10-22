package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.Menu;
import android.view.MenuInflater;
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
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C1295h;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.InterfaceC1312z;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.b0;
import androidx.collection.t;
import androidx.core.view.A;
import androidx.core.view.C1322j;
import androidx.core.view.C1323k;
import androidx.core.view.N;
import androidx.core.view.U;
import androidx.core.view.W;
import androidx.core.view.a0;
import f.C4027a;
import i.AbstractC4156b;
import i.f;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import s0.h;

/* loaded from: classes.dex */
public class AppCompatDelegateImpl extends androidx.appcompat.app.g implements e.a, LayoutInflater.Factory2 {

    /* renamed from: j0, reason: collision with root package name */
    public static final t<String, Integer> f8316j0 = new t<>();

    /* renamed from: k0, reason: collision with root package name */
    public static final boolean f8317k0 = false;

    /* renamed from: t0, reason: collision with root package name */
    public static final int[] f8318t0 = {R.attr.windowBackground};

    /* renamed from: u0, reason: collision with root package name */
    public static final boolean f8319u0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: A, reason: collision with root package name */
    public boolean f8320A;

    /* renamed from: B, reason: collision with root package name */
    public ViewGroup f8321B;

    /* renamed from: C, reason: collision with root package name */
    public TextView f8322C;

    /* renamed from: D, reason: collision with root package name */
    public View f8323D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f8324E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f8325F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f8326G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f8327H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f8328I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f8329J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f8330K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f8331L;

    /* renamed from: M, reason: collision with root package name */
    public PanelFeatureState[] f8332M;

    /* renamed from: N, reason: collision with root package name */
    public PanelFeatureState f8333N;

    /* renamed from: O, reason: collision with root package name */
    public boolean f8334O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f8335P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f8336Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f8337R;

    /* renamed from: S, reason: collision with root package name */
    public Configuration f8338S;

    /* renamed from: T, reason: collision with root package name */
    public int f8339T;

    /* renamed from: U, reason: collision with root package name */
    public int f8340U;

    /* renamed from: V, reason: collision with root package name */
    public int f8341V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f8342W;

    /* renamed from: X, reason: collision with root package name */
    public p f8343X;

    /* renamed from: Y, reason: collision with root package name */
    public p f8344Y;

    /* renamed from: Z, reason: collision with root package name */
    public boolean f8345Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f8346a0;

    /* renamed from: b0, reason: collision with root package name */
    public final Runnable f8347b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f8348c0;

    /* renamed from: d0, reason: collision with root package name */
    public Rect f8349d0;

    /* renamed from: e0, reason: collision with root package name */
    public Rect f8350e0;

    /* renamed from: f0, reason: collision with root package name */
    public androidx.appcompat.app.m f8351f0;

    /* renamed from: g0, reason: collision with root package name */
    public androidx.appcompat.app.o f8352g0;

    /* renamed from: h0, reason: collision with root package name */
    public OnBackInvokedDispatcher f8353h0;

    /* renamed from: i0, reason: collision with root package name */
    public OnBackInvokedCallback f8354i0;

    /* renamed from: j, reason: collision with root package name */
    public final Object f8355j;

    /* renamed from: k, reason: collision with root package name */
    public final Context f8356k;

    /* renamed from: l, reason: collision with root package name */
    public Window f8357l;

    /* renamed from: m, reason: collision with root package name */
    public n f8358m;

    /* renamed from: n, reason: collision with root package name */
    public final androidx.appcompat.app.e f8359n;

    /* renamed from: o, reason: collision with root package name */
    public androidx.appcompat.app.a f8360o;

    /* renamed from: p, reason: collision with root package name */
    public MenuInflater f8361p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f8362q;

    /* renamed from: r, reason: collision with root package name */
    public InterfaceC1312z f8363r;

    /* renamed from: s, reason: collision with root package name */
    public h f8364s;

    /* renamed from: t, reason: collision with root package name */
    public s f8365t;

    /* renamed from: u, reason: collision with root package name */
    public AbstractC4156b f8366u;

    /* renamed from: v, reason: collision with root package name */
    public ActionBarContextView f8367v;

    /* renamed from: w, reason: collision with root package name */
    public PopupWindow f8368w;

    /* renamed from: x, reason: collision with root package name */
    public Runnable f8369x;

    /* renamed from: y, reason: collision with root package name */
    public U f8370y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f8371z;

    public static final class PanelFeatureState {

        /* renamed from: a, reason: collision with root package name */
        public int f8372a;

        /* renamed from: b, reason: collision with root package name */
        public int f8373b;

        /* renamed from: c, reason: collision with root package name */
        public int f8374c;

        /* renamed from: d, reason: collision with root package name */
        public int f8375d;

        /* renamed from: e, reason: collision with root package name */
        public int f8376e;

        /* renamed from: f, reason: collision with root package name */
        public int f8377f;

        /* renamed from: g, reason: collision with root package name */
        public ViewGroup f8378g;

        /* renamed from: h, reason: collision with root package name */
        public View f8379h;

        /* renamed from: i, reason: collision with root package name */
        public View f8380i;

        /* renamed from: j, reason: collision with root package name */
        public androidx.appcompat.view.menu.e f8381j;

        /* renamed from: k, reason: collision with root package name */
        public androidx.appcompat.view.menu.c f8382k;

        /* renamed from: l, reason: collision with root package name */
        public Context f8383l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f8384m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f8385n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f8386o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f8387p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f8388q = false;

        /* renamed from: r, reason: collision with root package name */
        public boolean f8389r;

        /* renamed from: s, reason: collision with root package name */
        public Bundle f8390s;

        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            int featureId;
            boolean isOpen;
            Bundle menuState;

            public class a implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.readFromParcel(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.readFromParcel(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i10) {
                    return new SavedState[i10];
                }
            }

            public static SavedState readFromParcel(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.featureId = parcel.readInt();
                boolean z10 = parcel.readInt() == 1;
                savedState.isOpen = z10;
                if (z10) {
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

        public PanelFeatureState(int i10) {
            this.f8372a = i10;
        }

        public androidx.appcompat.view.menu.j a(i.a aVar) {
            if (this.f8381j == null) {
                return null;
            }
            if (this.f8382k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.f8383l, R$layout.abc_list_menu_item_layout);
                this.f8382k = cVar;
                cVar.e(aVar);
                this.f8381j.b(this.f8382k);
            }
            return this.f8382k.l(this.f8378g);
        }

        public boolean b() {
            if (this.f8379h == null) {
                return false;
            }
            return this.f8380i != null || this.f8382k.k().getCount() > 0;
        }

        public void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.f8381j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.R(this.f8382k);
            }
            this.f8381j = eVar;
            if (eVar == null || (cVar = this.f8382k) == null) {
                return;
            }
            eVar.b(cVar);
        }

        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                themeNewTheme.applyStyle(i10, true);
            }
            themeNewTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                themeNewTheme.applyStyle(i11, true);
            } else {
                themeNewTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            i.d dVar = new i.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.f8383l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.f8373b = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f8377f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.f8346a0 & 1) != 0) {
                appCompatDelegateImpl.l0(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.f8346a0 & 4096) != 0) {
                appCompatDelegateImpl2.l0(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.f8345Z = false;
            appCompatDelegateImpl3.f8346a0 = 0;
        }
    }

    public class b implements A {
        public b() {
        }

        @Override // androidx.core.view.A
        public a0 a(View view, a0 a0Var) {
            int iM = a0Var.m();
            int iH1 = AppCompatDelegateImpl.this.h1(a0Var, null);
            if (iM != iH1) {
                a0Var = a0Var.s(a0Var.k(), iH1, a0Var.l(), a0Var.j());
            }
            return N.U(view, a0Var);
        }
    }

    public class c implements ContentFrameLayout.a {
        public c() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.j0();
        }
    }

    public class d implements Runnable {

        public class a extends W {
            public a() {
            }

            @Override // androidx.core.view.W, androidx.core.view.V
            public void d(View view) {
                AppCompatDelegateImpl.this.f8367v.setAlpha(1.0f);
                AppCompatDelegateImpl.this.f8370y.h(null);
                AppCompatDelegateImpl.this.f8370y = null;
            }

            @Override // androidx.core.view.W, androidx.core.view.V
            public void e(View view) {
                AppCompatDelegateImpl.this.f8367v.setVisibility(0);
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.f8368w.showAtLocation(appCompatDelegateImpl.f8367v, 55, 0, 0);
            AppCompatDelegateImpl.this.m0();
            if (!AppCompatDelegateImpl.this.X0()) {
                AppCompatDelegateImpl.this.f8367v.setAlpha(1.0f);
                AppCompatDelegateImpl.this.f8367v.setVisibility(0);
            } else {
                AppCompatDelegateImpl.this.f8367v.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f8370y = N.d(appCompatDelegateImpl2.f8367v).b(1.0f);
                AppCompatDelegateImpl.this.f8370y.h(new a());
            }
        }
    }

    public class e extends W {
        public e() {
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void d(View view) {
            AppCompatDelegateImpl.this.f8367v.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f8370y.h(null);
            AppCompatDelegateImpl.this.f8370y = null;
        }

        @Override // androidx.core.view.W, androidx.core.view.V
        public void e(View view) {
            AppCompatDelegateImpl.this.f8367v.setVisibility(0);
            if (AppCompatDelegateImpl.this.f8367v.getParent() instanceof View) {
                N.e0((View) AppCompatDelegateImpl.this.f8367v.getParent());
            }
        }
    }

    public class f implements androidx.appcompat.app.b {
        public f() {
        }
    }

    public interface g {
        boolean a(int i10);

        View onCreatePanelView(int i10);
    }

    public final class h implements i.a {
        public h() {
        }

        @Override // androidx.appcompat.view.menu.i.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z10) {
            AppCompatDelegateImpl.this.c0(eVar);
        }

        @Override // androidx.appcompat.view.menu.i.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackY0 = AppCompatDelegateImpl.this.y0();
            if (callbackY0 == null) {
                return true;
            }
            callbackY0.onMenuOpened(108, eVar);
            return true;
        }
    }

    public class i implements AbstractC4156b.a {

        /* renamed from: a, reason: collision with root package name */
        public AbstractC4156b.a f8399a;

        public class a extends W {
            public a() {
            }

            @Override // androidx.core.view.W, androidx.core.view.V
            public void d(View view) {
                AppCompatDelegateImpl.this.f8367v.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.f8368w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f8367v.getParent() instanceof View) {
                    N.e0((View) AppCompatDelegateImpl.this.f8367v.getParent());
                }
                AppCompatDelegateImpl.this.f8367v.k();
                AppCompatDelegateImpl.this.f8370y.h(null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f8370y = null;
                N.e0(appCompatDelegateImpl2.f8321B);
            }
        }

        public i(AbstractC4156b.a aVar) {
            this.f8399a = aVar;
        }

        @Override // i.AbstractC4156b.a
        public boolean a(AbstractC4156b abstractC4156b, MenuItem menuItem) {
            return this.f8399a.a(abstractC4156b, menuItem);
        }

        @Override // i.AbstractC4156b.a
        public void b(AbstractC4156b abstractC4156b) {
            this.f8399a.b(abstractC4156b);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f8368w != null) {
                appCompatDelegateImpl.f8357l.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f8369x);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f8367v != null) {
                appCompatDelegateImpl2.m0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f8370y = N.d(appCompatDelegateImpl3.f8367v).b(0.0f);
                AppCompatDelegateImpl.this.f8370y.h(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            androidx.appcompat.app.e eVar = appCompatDelegateImpl4.f8359n;
            if (eVar != null) {
                eVar.onSupportActionModeFinished(appCompatDelegateImpl4.f8366u);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.f8366u = null;
            N.e0(appCompatDelegateImpl5.f8321B);
            AppCompatDelegateImpl.this.f1();
        }

        @Override // i.AbstractC4156b.a
        public boolean c(AbstractC4156b abstractC4156b, Menu menu) {
            N.e0(AppCompatDelegateImpl.this.f8321B);
            return this.f8399a.c(abstractC4156b, menu);
        }

        @Override // i.AbstractC4156b.a
        public boolean d(AbstractC4156b abstractC4156b, Menu menu) {
            return this.f8399a.d(abstractC4156b, menu);
        }
    }

    public static class j {
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        public static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    public static class k {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        public static x0.g b(Configuration configuration) {
            return x0.g.b(configuration.getLocales().toLanguageTags());
        }

        public static void c(x0.g gVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(gVar.g()));
        }

        public static void d(Configuration configuration, x0.g gVar) {
            configuration.setLocales(LocaleList.forLanguageTags(gVar.g()));
        }
    }

    public static class l {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10 = configuration.colorMode & 3;
            int i11 = configuration2.colorMode;
            if (i10 != (i11 & 3)) {
                configuration3.colorMode |= i11 & 3;
            }
            int i12 = configuration.colorMode & 12;
            int i13 = configuration2.colorMode;
            if (i12 != (i13 & 12)) {
                configuration3.colorMode |= i13 & 12;
            }
        }
    }

    public static class m {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Object obj, final AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.i
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    appCompatDelegateImpl.G0();
                }
            };
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public class n extends i.i {

        /* renamed from: b, reason: collision with root package name */
        public g f8402b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f8403c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f8404d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f8405e;

        public n(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f8404d = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f8404d = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f8403c = true;
                callback.onContentChanged();
            } finally {
                this.f8403c = false;
            }
        }

        public void d(Window.Callback callback, int i10, Menu menu) {
            try {
                this.f8405e = true;
                callback.onPanelClosed(i10, menu);
            } finally {
                this.f8405e = false;
            }
        }

        @Override // i.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f8404d ? a().dispatchKeyEvent(keyEvent) : AppCompatDelegateImpl.this.k0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // i.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.J0(keyEvent.getKeyCode(), keyEvent);
        }

        public void e(g gVar) {
            this.f8402b = gVar;
        }

        public final ActionMode f(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.f8356k, callback);
            AbstractC4156b abstractC4156bS = AppCompatDelegateImpl.this.S(aVar);
            if (abstractC4156bS != null) {
                return aVar.e(abstractC4156bS);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f8403c) {
                a().onContentChanged();
            }
        }

        @Override // i.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        @Override // i.i, android.view.Window.Callback
        public View onCreatePanelView(int i10) {
            View viewOnCreatePanelView;
            g gVar = this.f8402b;
            return (gVar == null || (viewOnCreatePanelView = gVar.onCreatePanelView(i10)) == null) ? super.onCreatePanelView(i10) : viewOnCreatePanelView;
        }

        @Override // i.i, android.view.Window.Callback
        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            AppCompatDelegateImpl.this.M0(i10);
            return true;
        }

        @Override // i.i, android.view.Window.Callback
        public void onPanelClosed(int i10, Menu menu) {
            if (this.f8405e) {
                a().onPanelClosed(i10, menu);
            } else {
                super.onPanelClosed(i10, menu);
                AppCompatDelegateImpl.this.N0(i10);
            }
        }

        @Override // i.i, android.view.Window.Callback
        public boolean onPreparePanel(int i10, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i10 == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.f0(true);
            }
            g gVar = this.f8402b;
            boolean zOnPreparePanel = gVar != null && gVar.a(i10);
            if (!zOnPreparePanel) {
                zOnPreparePanel = super.onPreparePanel(i10, view, menu);
            }
            if (eVar != null) {
                eVar.f0(false);
            }
            return zOnPreparePanel;
        }

        @Override // i.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i10) {
            androidx.appcompat.view.menu.e eVar;
            PanelFeatureState panelFeatureStateW0 = AppCompatDelegateImpl.this.w0(0, true);
            if (panelFeatureStateW0 == null || (eVar = panelFeatureStateW0.f8381j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i10);
            }
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // i.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            return (AppCompatDelegateImpl.this.E0() && i10 == 0) ? f(callback) : super.onWindowStartingActionMode(callback, i10);
        }
    }

    public class o extends p {

        /* renamed from: c, reason: collision with root package name */
        public final PowerManager f8407c;

        public o(Context context) {
            super();
            this.f8407c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public int c() {
            return j.a(this.f8407c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public void d() {
            AppCompatDelegateImpl.this.f();
        }
    }

    public abstract class p {

        /* renamed from: a, reason: collision with root package name */
        public BroadcastReceiver f8409a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                p.this.d();
            }
        }

        public p() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f8409a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f8356k.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f8409a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f8409a == null) {
                this.f8409a = new a();
            }
            AppCompatDelegateImpl.this.f8356k.registerReceiver(this.f8409a, intentFilterB);
        }
    }

    public class q extends p {

        /* renamed from: c, reason: collision with root package name */
        public final androidx.appcompat.app.r f8412c;

        public q(androidx.appcompat.app.r rVar) {
            super();
            this.f8412c = rVar;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public int c() {
            return this.f8412c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public void d() {
            AppCompatDelegateImpl.this.f();
        }
    }

    public class r extends ContentFrameLayout {
        public r(Context context) {
            super(context);
        }

        public final boolean a(int i10, int i11) {
            return i10 < -5 || i11 < -5 || i10 > getWidth() + 5 || i11 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.k0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.e0(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(C4027a.b(getContext(), i10));
        }
    }

    public final class s implements i.a {
        public s() {
        }

        @Override // androidx.appcompat.view.menu.i.a
        public void a(androidx.appcompat.view.menu.e eVar, boolean z10) {
            androidx.appcompat.view.menu.e eVarF = eVar.F();
            boolean z11 = eVarF != eVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z11) {
                eVar = eVarF;
            }
            PanelFeatureState panelFeatureStateP0 = appCompatDelegateImpl.p0(eVar);
            if (panelFeatureStateP0 != null) {
                if (!z11) {
                    AppCompatDelegateImpl.this.f0(panelFeatureStateP0, z10);
                } else {
                    AppCompatDelegateImpl.this.b0(panelFeatureStateP0.f8372a, panelFeatureStateP0, eVarF);
                    AppCompatDelegateImpl.this.f0(panelFeatureStateP0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.i.a
        public boolean b(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackY0;
            if (eVar != eVar.F()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.f8326G || (callbackY0 = appCompatDelegateImpl.y0()) == null || AppCompatDelegateImpl.this.f8337R) {
                return true;
            }
            callbackY0.onMenuOpened(108, eVar);
            return true;
        }
    }

    public AppCompatDelegateImpl(Activity activity, androidx.appcompat.app.e eVar) {
        this(activity, null, eVar, activity);
    }

    public static Configuration q0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f10 = configuration.fontScale;
            float f11 = configuration2.fontScale;
            if (f10 != f11) {
                configuration3.fontScale = f11;
            }
            int i10 = configuration.mcc;
            int i11 = configuration2.mcc;
            if (i10 != i11) {
                configuration3.mcc = i11;
            }
            int i12 = configuration.mnc;
            int i13 = configuration2.mnc;
            if (i12 != i13) {
                configuration3.mnc = i13;
            }
            k.a(configuration, configuration2, configuration3);
            int i14 = configuration.touchscreen;
            int i15 = configuration2.touchscreen;
            if (i14 != i15) {
                configuration3.touchscreen = i15;
            }
            int i16 = configuration.keyboard;
            int i17 = configuration2.keyboard;
            if (i16 != i17) {
                configuration3.keyboard = i17;
            }
            int i18 = configuration.keyboardHidden;
            int i19 = configuration2.keyboardHidden;
            if (i18 != i19) {
                configuration3.keyboardHidden = i19;
            }
            int i20 = configuration.navigation;
            int i21 = configuration2.navigation;
            if (i20 != i21) {
                configuration3.navigation = i21;
            }
            int i22 = configuration.navigationHidden;
            int i23 = configuration2.navigationHidden;
            if (i22 != i23) {
                configuration3.navigationHidden = i23;
            }
            int i24 = configuration.orientation;
            int i25 = configuration2.orientation;
            if (i24 != i25) {
                configuration3.orientation = i25;
            }
            int i26 = configuration.screenLayout & 15;
            int i27 = configuration2.screenLayout;
            if (i26 != (i27 & 15)) {
                configuration3.screenLayout |= i27 & 15;
            }
            int i28 = configuration.screenLayout & 192;
            int i29 = configuration2.screenLayout;
            if (i28 != (i29 & 192)) {
                configuration3.screenLayout |= i29 & 192;
            }
            int i30 = configuration.screenLayout & 48;
            int i31 = configuration2.screenLayout;
            if (i30 != (i31 & 48)) {
                configuration3.screenLayout |= i31 & 48;
            }
            int i32 = configuration.screenLayout & 768;
            int i33 = configuration2.screenLayout;
            if (i32 != (i33 & 768)) {
                configuration3.screenLayout |= i33 & 768;
            }
            l.a(configuration, configuration2, configuration3);
            int i34 = configuration.uiMode & 15;
            int i35 = configuration2.uiMode;
            if (i34 != (i35 & 15)) {
                configuration3.uiMode |= i35 & 15;
            }
            int i36 = configuration.uiMode & 48;
            int i37 = configuration2.uiMode;
            if (i36 != (i37 & 48)) {
                configuration3.uiMode |= i37 & 48;
            }
            int i38 = configuration.screenWidthDp;
            int i39 = configuration2.screenWidthDp;
            if (i38 != i39) {
                configuration3.screenWidthDp = i39;
            }
            int i40 = configuration.screenHeightDp;
            int i41 = configuration2.screenHeightDp;
            if (i40 != i41) {
                configuration3.screenHeightDp = i41;
            }
            int i42 = configuration.smallestScreenWidthDp;
            int i43 = configuration2.smallestScreenWidthDp;
            if (i42 != i43) {
                configuration3.smallestScreenWidthDp = i43;
            }
            int i44 = configuration.densityDpi;
            int i45 = configuration2.densityDpi;
            if (i44 != i45) {
                configuration3.densityDpi = i45;
            }
        }
        return configuration3;
    }

    @Override // androidx.appcompat.app.g
    public void A(Bundle bundle) {
        n0();
    }

    public final boolean A0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f8380i;
        if (view != null) {
            panelFeatureState.f8379h = view;
            return true;
        }
        if (panelFeatureState.f8381j == null) {
            return false;
        }
        if (this.f8365t == null) {
            this.f8365t = new s();
        }
        View view2 = (View) panelFeatureState.a(this.f8365t);
        panelFeatureState.f8379h = view2;
        return view2 != null;
    }

    @Override // androidx.appcompat.app.g
    public void B() {
        androidx.appcompat.app.a aVarT = t();
        if (aVarT != null) {
            aVarT.u(true);
        }
    }

    public final boolean B0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(r0());
        panelFeatureState.f8378g = new r(panelFeatureState.f8383l);
        panelFeatureState.f8374c = 81;
        return true;
    }

    @Override // androidx.appcompat.app.g
    public void C(Bundle bundle) {
    }

    public final boolean C0(PanelFeatureState panelFeatureState) {
        Resources.Theme themeNewTheme;
        Context context = this.f8356k;
        int i10 = panelFeatureState.f8372a;
        if ((i10 == 0 || i10 == 108) && this.f8363r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                themeNewTheme = null;
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                i.d dVar = new i.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.W(this);
        panelFeatureState.c(eVar);
        return true;
    }

    @Override // androidx.appcompat.app.g
    public void D() throws PackageManager.NameNotFoundException {
        W(true, false);
    }

    public final void D0(int i10) {
        this.f8346a0 = (1 << i10) | this.f8346a0;
        if (this.f8345Z) {
            return;
        }
        N.Z(this.f8357l.getDecorView(), this.f8347b0);
        this.f8345Z = true;
    }

    @Override // androidx.appcompat.app.g
    public void E() {
        androidx.appcompat.app.a aVarT = t();
        if (aVarT != null) {
            aVarT.u(false);
        }
    }

    public boolean E0() {
        return this.f8371z;
    }

    public int F0(Context context, int i10) {
        if (i10 == -100) {
            return -1;
        }
        if (i10 != -1) {
            if (i10 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return u0(context).c();
            }
            if (i10 != 1 && i10 != 2) {
                if (i10 == 3) {
                    return t0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i10;
    }

    public boolean G0() {
        boolean z10 = this.f8334O;
        this.f8334O = false;
        PanelFeatureState panelFeatureStateW0 = w0(0, false);
        if (panelFeatureStateW0 != null && panelFeatureStateW0.f8386o) {
            if (!z10) {
                f0(panelFeatureStateW0, true);
            }
            return true;
        }
        AbstractC4156b abstractC4156b = this.f8366u;
        if (abstractC4156b != null) {
            abstractC4156b.c();
            return true;
        }
        androidx.appcompat.app.a aVarT = t();
        return aVarT != null && aVarT.g();
    }

    @Override // androidx.appcompat.app.g
    public boolean H(int i10) {
        int iU0 = U0(i10);
        if (this.f8330K && iU0 == 108) {
            return false;
        }
        if (this.f8326G && iU0 == 1) {
            this.f8326G = false;
        }
        if (iU0 == 1) {
            b1();
            this.f8330K = true;
            return true;
        }
        if (iU0 == 2) {
            b1();
            this.f8324E = true;
            return true;
        }
        if (iU0 == 5) {
            b1();
            this.f8325F = true;
            return true;
        }
        if (iU0 == 10) {
            b1();
            this.f8328I = true;
            return true;
        }
        if (iU0 == 108) {
            b1();
            this.f8326G = true;
            return true;
        }
        if (iU0 != 109) {
            return this.f8357l.requestFeature(iU0);
        }
        b1();
        this.f8327H = true;
        return true;
    }

    public boolean H0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            this.f8334O = (keyEvent.getFlags() & 128) != 0;
        } else if (i10 == 82) {
            I0(0, keyEvent);
            return true;
        }
        return false;
    }

    public final boolean I0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState panelFeatureStateW0 = w0(i10, true);
        if (panelFeatureStateW0.f8386o) {
            return false;
        }
        return S0(panelFeatureStateW0, keyEvent);
    }

    @Override // androidx.appcompat.app.g
    public void J(int i10) {
        n0();
        ViewGroup viewGroup = (ViewGroup) this.f8321B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f8356k).inflate(i10, viewGroup);
        this.f8358m.c(this.f8357l.getCallback());
    }

    public boolean J0(int i10, KeyEvent keyEvent) {
        androidx.appcompat.app.a aVarT = t();
        if (aVarT != null && aVarT.o(i10, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.f8333N;
        if (panelFeatureState != null && R0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.f8333N;
            if (panelFeatureState2 != null) {
                panelFeatureState2.f8385n = true;
            }
            return true;
        }
        if (this.f8333N == null) {
            PanelFeatureState panelFeatureStateW0 = w0(0, true);
            S0(panelFeatureStateW0, keyEvent);
            boolean zR0 = R0(panelFeatureStateW0, keyEvent.getKeyCode(), keyEvent, 1);
            panelFeatureStateW0.f8384m = false;
            if (zR0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.g
    public void K(View view) {
        n0();
        ViewGroup viewGroup = (ViewGroup) this.f8321B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f8358m.c(this.f8357l.getCallback());
    }

    public boolean K0(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            if (i10 == 82) {
                L0(0, keyEvent);
                return true;
            }
        } else if (G0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.g
    public void L(View view, ViewGroup.LayoutParams layoutParams) {
        n0();
        ViewGroup viewGroup = (ViewGroup) this.f8321B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f8358m.c(this.f8357l.getCallback());
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean L0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            i.b r0 = r4.f8366u
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r4.w0(r5, r0)
            if (r5 != 0) goto L43
            androidx.appcompat.widget.z r5 = r4.f8363r
            if (r5 == 0) goto L43
            boolean r5 = r5.a()
            if (r5 == 0) goto L43
            android.content.Context r5 = r4.f8356k
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L43
            androidx.appcompat.widget.z r5 = r4.f8363r
            boolean r5 = r5.d()
            if (r5 != 0) goto L3c
            boolean r5 = r4.f8337R
            if (r5 != 0) goto L62
            boolean r5 = r4.S0(r2, r6)
            if (r5 == 0) goto L62
            androidx.appcompat.widget.z r5 = r4.f8363r
            boolean r0 = r5.c()
            goto L68
        L3c:
            androidx.appcompat.widget.z r5 = r4.f8363r
            boolean r0 = r5.b()
            goto L68
        L43:
            boolean r5 = r2.f8386o
            if (r5 != 0) goto L64
            boolean r3 = r2.f8385n
            if (r3 == 0) goto L4c
            goto L64
        L4c:
            boolean r5 = r2.f8384m
            if (r5 == 0) goto L62
            boolean r5 = r2.f8389r
            if (r5 == 0) goto L5b
            r2.f8384m = r1
            boolean r5 = r4.S0(r2, r6)
            goto L5c
        L5b:
            r5 = r0
        L5c:
            if (r5 == 0) goto L62
            r4.P0(r2, r6)
            goto L68
        L62:
            r0 = r1
            goto L68
        L64:
            r4.f0(r2, r0)
            r0 = r5
        L68:
            if (r0 == 0) goto L85
            android.content.Context r4 = r4.f8356k
            android.content.Context r4 = r4.getApplicationContext()
            java.lang.String r5 = "audio"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.media.AudioManager r4 = (android.media.AudioManager) r4
            if (r4 == 0) goto L7e
            r4.playSoundEffect(r1)
            return r0
        L7e:
            java.lang.String r4 = "AppCompatDelegate"
            java.lang.String r5 = "Couldn't get audio manager"
            android.util.Log.w(r4, r5)
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.L0(int, android.view.KeyEvent):boolean");
    }

    public void M0(int i10) {
        androidx.appcompat.app.a aVarT;
        if (i10 != 108 || (aVarT = t()) == null) {
            return;
        }
        aVarT.h(true);
    }

    @Override // androidx.appcompat.app.g
    public void N(int i10) {
        if (this.f8339T != i10) {
            this.f8339T = i10;
            if (this.f8335P) {
                f();
            }
        }
    }

    public void N0(int i10) {
        if (i10 == 108) {
            androidx.appcompat.app.a aVarT = t();
            if (aVarT != null) {
                aVarT.h(false);
                return;
            }
            return;
        }
        if (i10 == 0) {
            PanelFeatureState panelFeatureStateW0 = w0(i10, true);
            if (panelFeatureStateW0.f8386o) {
                f0(panelFeatureStateW0, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    @Override // androidx.appcompat.app.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void O(android.window.OnBackInvokedDispatcher r3) {
        /*
            r2 = this;
            super.O(r3)
            android.window.OnBackInvokedDispatcher r0 = r2.f8353h0
            if (r0 == 0) goto L11
            android.window.OnBackInvokedCallback r1 = r2.f8354i0
            if (r1 == 0) goto L11
            androidx.appcompat.app.AppCompatDelegateImpl.m.c(r0, r1)
            r0 = 0
            r2.f8354i0 = r0
        L11:
            if (r3 != 0) goto L2c
            java.lang.Object r0 = r2.f8355j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L2c
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L2c
            java.lang.Object r3 = r2.f8355j
            android.app.Activity r3 = (android.app.Activity) r3
            android.window.OnBackInvokedDispatcher r3 = androidx.appcompat.app.AppCompatDelegateImpl.m.a(r3)
            r2.f8353h0 = r3
            goto L2e
        L2c:
            r2.f8353h0 = r3
        L2e:
            r2.f1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.O(android.window.OnBackInvokedDispatcher):void");
    }

    public void O0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.g
    public void P(Toolbar toolbar) {
        if (this.f8355j instanceof Activity) {
            androidx.appcompat.app.a aVarT = t();
            if (aVarT instanceof androidx.appcompat.app.s) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f8361p = null;
            if (aVarT != null) {
                aVarT.n();
            }
            this.f8360o = null;
            if (toolbar != null) {
                androidx.appcompat.app.p pVar = new androidx.appcompat.app.p(toolbar, x0(), this.f8358m);
                this.f8360o = pVar;
                this.f8358m.e(pVar.f8455c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.f8358m.e(null);
            }
            v();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P0(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.P0(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    @Override // androidx.appcompat.app.g
    public void Q(int i10) {
        this.f8340U = i10;
    }

    public final androidx.appcompat.app.a Q0() {
        return this.f8360o;
    }

    @Override // androidx.appcompat.app.g
    public final void R(CharSequence charSequence) {
        this.f8362q = charSequence;
        InterfaceC1312z interfaceC1312z = this.f8363r;
        if (interfaceC1312z != null) {
            interfaceC1312z.setWindowTitle(charSequence);
            return;
        }
        if (Q0() != null) {
            Q0().v(charSequence);
            return;
        }
        TextView textView = this.f8322C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final boolean R0(PanelFeatureState panelFeatureState, int i10, KeyEvent keyEvent, int i11) {
        androidx.appcompat.view.menu.e eVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f8384m || S0(panelFeatureState, keyEvent)) && (eVar = panelFeatureState.f8381j) != null) {
            zPerformShortcut = eVar.performShortcut(i10, keyEvent, i11);
        }
        if (zPerformShortcut && (i11 & 1) == 0 && this.f8363r == null) {
            f0(panelFeatureState, true);
        }
        return zPerformShortcut;
    }

    @Override // androidx.appcompat.app.g
    public AbstractC4156b S(AbstractC4156b.a aVar) {
        androidx.appcompat.app.e eVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        AbstractC4156b abstractC4156b = this.f8366u;
        if (abstractC4156b != null) {
            abstractC4156b.c();
        }
        i iVar = new i(aVar);
        androidx.appcompat.app.a aVarT = t();
        if (aVarT != null) {
            AbstractC4156b abstractC4156bW = aVarT.w(iVar);
            this.f8366u = abstractC4156bW;
            if (abstractC4156bW != null && (eVar = this.f8359n) != null) {
                eVar.onSupportActionModeStarted(abstractC4156bW);
            }
        }
        if (this.f8366u == null) {
            this.f8366u = a1(iVar);
        }
        f1();
        return this.f8366u;
    }

    public final boolean S0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        InterfaceC1312z interfaceC1312z;
        InterfaceC1312z interfaceC1312z2;
        InterfaceC1312z interfaceC1312z3;
        if (this.f8337R) {
            return false;
        }
        if (panelFeatureState.f8384m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.f8333N;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            f0(panelFeatureState2, false);
        }
        Window.Callback callbackY0 = y0();
        if (callbackY0 != null) {
            panelFeatureState.f8380i = callbackY0.onCreatePanelView(panelFeatureState.f8372a);
        }
        int i10 = panelFeatureState.f8372a;
        boolean z10 = i10 == 0 || i10 == 108;
        if (z10 && (interfaceC1312z3 = this.f8363r) != null) {
            interfaceC1312z3.e();
        }
        if (panelFeatureState.f8380i == null && (!z10 || !(Q0() instanceof androidx.appcompat.app.p))) {
            androidx.appcompat.view.menu.e eVar = panelFeatureState.f8381j;
            if (eVar == null || panelFeatureState.f8389r) {
                if (eVar == null && (!C0(panelFeatureState) || panelFeatureState.f8381j == null)) {
                    return false;
                }
                if (z10 && this.f8363r != null) {
                    if (this.f8364s == null) {
                        this.f8364s = new h();
                    }
                    this.f8363r.q(panelFeatureState.f8381j, this.f8364s);
                }
                panelFeatureState.f8381j.i0();
                if (!callbackY0.onCreatePanelMenu(panelFeatureState.f8372a, panelFeatureState.f8381j)) {
                    panelFeatureState.c(null);
                    if (z10 && (interfaceC1312z = this.f8363r) != null) {
                        interfaceC1312z.q(null, this.f8364s);
                    }
                    return false;
                }
                panelFeatureState.f8389r = false;
            }
            panelFeatureState.f8381j.i0();
            Bundle bundle = panelFeatureState.f8390s;
            if (bundle != null) {
                panelFeatureState.f8381j.S(bundle);
                panelFeatureState.f8390s = null;
            }
            if (!callbackY0.onPreparePanel(0, panelFeatureState.f8380i, panelFeatureState.f8381j)) {
                if (z10 && (interfaceC1312z2 = this.f8363r) != null) {
                    interfaceC1312z2.q(null, this.f8364s);
                }
                panelFeatureState.f8381j.h0();
                return false;
            }
            boolean z11 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f8387p = z11;
            panelFeatureState.f8381j.setQwertyMode(z11);
            panelFeatureState.f8381j.h0();
        }
        panelFeatureState.f8384m = true;
        panelFeatureState.f8385n = false;
        this.f8333N = panelFeatureState;
        return true;
    }

    public final void T0(boolean z10) {
        InterfaceC1312z interfaceC1312z = this.f8363r;
        if (interfaceC1312z == null || !interfaceC1312z.a() || (ViewConfiguration.get(this.f8356k).hasPermanentMenuKey() && !this.f8363r.f())) {
            PanelFeatureState panelFeatureStateW0 = w0(0, true);
            panelFeatureStateW0.f8388q = true;
            f0(panelFeatureStateW0, false);
            P0(panelFeatureStateW0, null);
            return;
        }
        Window.Callback callbackY0 = y0();
        if (this.f8363r.d() && z10) {
            this.f8363r.b();
            if (this.f8337R) {
                return;
            }
            callbackY0.onPanelClosed(108, w0(0, true).f8381j);
            return;
        }
        if (callbackY0 == null || this.f8337R) {
            return;
        }
        if (this.f8345Z && (this.f8346a0 & 1) != 0) {
            this.f8357l.getDecorView().removeCallbacks(this.f8347b0);
            this.f8347b0.run();
        }
        PanelFeatureState panelFeatureStateW02 = w0(0, true);
        androidx.appcompat.view.menu.e eVar = panelFeatureStateW02.f8381j;
        if (eVar == null || panelFeatureStateW02.f8389r || !callbackY0.onPreparePanel(0, panelFeatureStateW02.f8380i, eVar)) {
            return;
        }
        callbackY0.onMenuOpened(108, panelFeatureStateW02.f8381j);
        this.f8363r.c();
    }

    public final int U0(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i10 != 9) {
            return i10;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    public final boolean V(boolean z10) {
        return W(z10, true);
    }

    public void V0(Configuration configuration, x0.g gVar) {
        k.d(configuration, gVar);
    }

    public final boolean W(boolean z10, boolean z11) throws PackageManager.NameNotFoundException {
        if (this.f8337R) {
            return false;
        }
        int iA0 = a0();
        boolean zE1 = e1(F0(this.f8356k, iA0), null, z10);
        if (iA0 == 0) {
            u0(this.f8356k).e();
        } else {
            p pVar = this.f8343X;
            if (pVar != null) {
                pVar.a();
            }
        }
        if (iA0 == 3) {
            t0(this.f8356k).e();
            return zE1;
        }
        p pVar2 = this.f8344Y;
        if (pVar2 != null) {
            pVar2.a();
        }
        return zE1;
    }

    public void W0(x0.g gVar) {
        k.c(gVar);
    }

    public final void X() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f8321B.findViewById(R.id.content);
        View decorView = this.f8357l.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f8356k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i10 = R$styleable.AppCompatTheme_windowFixedWidthMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            typedArrayObtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedWidthMajor());
        }
        int i11 = R$styleable.AppCompatTheme_windowFixedWidthMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            typedArrayObtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMinor());
        }
        int i12 = R$styleable.AppCompatTheme_windowFixedHeightMajor;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            typedArrayObtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedHeightMajor());
        }
        int i13 = R$styleable.AppCompatTheme_windowFixedHeightMinor;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            typedArrayObtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public final boolean X0() {
        ViewGroup viewGroup;
        return this.f8320A && (viewGroup = this.f8321B) != null && viewGroup.isLaidOut();
    }

    public final void Y(Window window) {
        if (this.f8357l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof n) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        n nVar = new n(callback);
        this.f8358m = nVar;
        window.setCallback(nVar);
        androidx.appcompat.widget.U u10 = androidx.appcompat.widget.U.u(this.f8356k, null, f8318t0);
        Drawable drawableH = u10.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        u10.x();
        this.f8357l = window;
        if (this.f8353h0 == null) {
            O(null);
        }
    }

    public final boolean Y0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f8357l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ((View) viewParent).isAttachedToWindow()) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public x0.g Z(Context context) {
        return null;
    }

    public boolean Z0() {
        if (this.f8353h0 == null) {
            return false;
        }
        PanelFeatureState panelFeatureStateW0 = w0(0, false);
        return (panelFeatureStateW0 != null && panelFeatureStateW0.f8386o) || this.f8366u != null;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        PanelFeatureState panelFeatureStateP0;
        Window.Callback callbackY0 = y0();
        if (callbackY0 == null || this.f8337R || (panelFeatureStateP0 = p0(eVar.F())) == null) {
            return false;
        }
        return callbackY0.onMenuItemSelected(panelFeatureStateP0.f8372a, menuItem);
    }

    public final int a0() {
        int i10 = this.f8339T;
        return i10 != -100 ? i10 : androidx.appcompat.app.g.o();
    }

    public AbstractC4156b a1(AbstractC4156b.a aVar) {
        AbstractC4156b abstractC4156bOnWindowStartingSupportActionMode;
        Context dVar;
        androidx.appcompat.app.e eVar;
        m0();
        AbstractC4156b abstractC4156b = this.f8366u;
        if (abstractC4156b != null) {
            abstractC4156b.c();
        }
        if (!(aVar instanceof i)) {
            aVar = new i(aVar);
        }
        androidx.appcompat.app.e eVar2 = this.f8359n;
        if (eVar2 == null || this.f8337R) {
            abstractC4156bOnWindowStartingSupportActionMode = null;
        } else {
            try {
                abstractC4156bOnWindowStartingSupportActionMode = eVar2.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError unused) {
            }
        }
        if (abstractC4156bOnWindowStartingSupportActionMode != null) {
            this.f8366u = abstractC4156bOnWindowStartingSupportActionMode;
        } else {
            if (this.f8367v == null) {
                if (this.f8329J) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f8356k.getTheme();
                    theme.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f8356k.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new i.d(this.f8356k, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f8356k;
                    }
                    this.f8367v = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, R$attr.actionModePopupWindowStyle);
                    this.f8368w = popupWindow;
                    androidx.core.widget.g.b(popupWindow, 2);
                    this.f8368w.setContentView(this.f8367v);
                    this.f8368w.setWidth(-1);
                    dVar.getTheme().resolveAttribute(R$attr.actionBarSize, typedValue, true);
                    this.f8367v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.f8368w.setHeight(-2);
                    this.f8369x = new d();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f8321B.findViewById(R$id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(r0()));
                        this.f8367v = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.f8367v != null) {
                m0();
                this.f8367v.k();
                i.e eVar3 = new i.e(this.f8367v.getContext(), this.f8367v, aVar, this.f8368w == null);
                if (aVar.d(eVar3, eVar3.e())) {
                    eVar3.k();
                    this.f8367v.h(eVar3);
                    this.f8366u = eVar3;
                    if (X0()) {
                        this.f8367v.setAlpha(0.0f);
                        U uB = N.d(this.f8367v).b(1.0f);
                        this.f8370y = uB;
                        uB.h(new e());
                    } else {
                        this.f8367v.setAlpha(1.0f);
                        this.f8367v.setVisibility(0);
                        if (this.f8367v.getParent() instanceof View) {
                            N.e0((View) this.f8367v.getParent());
                        }
                    }
                    if (this.f8368w != null) {
                        this.f8357l.getDecorView().post(this.f8369x);
                    }
                } else {
                    this.f8366u = null;
                }
            }
        }
        AbstractC4156b abstractC4156b2 = this.f8366u;
        if (abstractC4156b2 != null && (eVar = this.f8359n) != null) {
            eVar.onSupportActionModeStarted(abstractC4156b2);
        }
        f1();
        return this.f8366u;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        T0(true);
    }

    public void b0(int i10, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i10 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.f8332M;
                if (i10 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f8381j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f8386o) && !this.f8337R) {
            this.f8358m.d(this.f8357l.getCallback(), i10, menu);
        }
    }

    public final void b1() {
        if (this.f8320A) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public void c0(androidx.appcompat.view.menu.e eVar) {
        if (this.f8331L) {
            return;
        }
        this.f8331L = true;
        this.f8363r.r();
        Window.Callback callbackY0 = y0();
        if (callbackY0 != null && !this.f8337R) {
            callbackY0.onPanelClosed(108, eVar);
        }
        this.f8331L = false;
    }

    public final androidx.appcompat.app.d c1() {
        for (Context baseContext = this.f8356k; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof androidx.appcompat.app.d) {
                return (androidx.appcompat.app.d) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    public final void d0() {
        p pVar = this.f8343X;
        if (pVar != null) {
            pVar.a();
        }
        p pVar2 = this.f8344Y;
        if (pVar2 != null) {
            pVar2.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d1(Configuration configuration) {
        Activity activity = (Activity) this.f8355j;
        if (activity instanceof LifecycleOwner) {
            if (((LifecycleOwner) activity).getLifecycle().getState().isAtLeast(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.f8336Q || this.f8337R) {
                return;
            }
            activity.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.appcompat.app.g
    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        n0();
        ((ViewGroup) this.f8321B.findViewById(R.id.content)).addView(view, layoutParams);
        this.f8358m.c(this.f8357l.getCallback());
    }

    public void e0(int i10) {
        f0(w0(i10, true), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e1(int r10, x0.g r11, boolean r12) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r9 = this;
            android.content.Context r1 = r9.f8356k
            r4 = 0
            r5 = 0
            r0 = r9
            r2 = r10
            r3 = r11
            android.content.res.Configuration r9 = r0.g0(r1, r2, r3, r4, r5)
            android.content.Context r10 = r0.f8356k
            int r10 = r0.s0(r10)
            android.content.res.Configuration r11 = r0.f8338S
            if (r11 != 0) goto L1f
            android.content.Context r11 = r0.f8356k
            android.content.res.Resources r11 = r11.getResources()
            android.content.res.Configuration r11 = r11.getConfiguration()
        L1f:
            int r1 = r11.uiMode
            r1 = r1 & 48
            int r4 = r9.uiMode
            r4 = r4 & 48
            x0.g r11 = r0.v0(r11)
            r5 = 0
            if (r3 != 0) goto L30
            r6 = r5
            goto L34
        L30:
            x0.g r6 = r0.v0(r9)
        L34:
            r7 = 0
            if (r1 == r4) goto L3a
            r1 = 512(0x200, float:7.17E-43)
            goto L3b
        L3a:
            r1 = r7
        L3b:
            if (r6 == 0) goto L45
            boolean r11 = r11.equals(r6)
            if (r11 != 0) goto L45
            r1 = r1 | 8196(0x2004, float:1.1485E-41)
        L45:
            int r11 = ~r10
            r11 = r11 & r1
            r8 = 1
            if (r11 == 0) goto L86
            if (r12 == 0) goto L86
            boolean r11 = r0.f8335P
            if (r11 == 0) goto L86
            boolean r11 = androidx.appcompat.app.AppCompatDelegateImpl.f8319u0
            if (r11 != 0) goto L58
            boolean r11 = r0.f8336Q
            if (r11 == 0) goto L86
        L58:
            java.lang.Object r11 = r0.f8355j
            boolean r12 = r11 instanceof android.app.Activity
            if (r12 == 0) goto L86
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r11 = r11.isChild()
            if (r11 != 0) goto L86
            r11 = r1 & 8192(0x2000, float:1.148E-41)
            if (r11 == 0) goto L7d
            java.lang.Object r11 = r0.f8355j
            android.app.Activity r11 = (android.app.Activity) r11
            android.view.Window r11 = r11.getWindow()
            android.view.View r11 = r11.getDecorView()
            int r9 = r9.getLayoutDirection()
            r11.setLayoutDirection(r9)
        L7d:
            java.lang.Object r9 = r0.f8355j
            android.app.Activity r9 = (android.app.Activity) r9
            androidx.core.app.a.q(r9)
            r9 = r8
            goto L87
        L86:
            r9 = r7
        L87:
            if (r9 != 0) goto L94
            if (r1 == 0) goto L94
            r9 = r1 & r10
            if (r9 != r1) goto L90
            r7 = r8
        L90:
            r0.g1(r4, r6, r7, r5)
            goto L95
        L94:
            r8 = r9
        L95:
            if (r8 == 0) goto Lb1
            java.lang.Object r9 = r0.f8355j
            boolean r10 = r9 instanceof androidx.appcompat.app.d
            if (r10 == 0) goto Lb1
            r10 = r1 & 512(0x200, float:7.17E-43)
            if (r10 == 0) goto La6
            androidx.appcompat.app.d r9 = (androidx.appcompat.app.d) r9
            r9.onNightModeChanged(r2)
        La6:
            r9 = r1 & 4
            if (r9 == 0) goto Lb1
            java.lang.Object r9 = r0.f8355j
            androidx.appcompat.app.d r9 = (androidx.appcompat.app.d) r9
            r9.onLocalesChanged(r3)
        Lb1:
            if (r6 == 0) goto Lc4
            android.content.Context r9 = r0.f8356k
            android.content.res.Resources r9 = r9.getResources()
            android.content.res.Configuration r9 = r9.getConfiguration()
            x0.g r9 = r0.v0(r9)
            r0.W0(r9)
        Lc4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.e1(int, x0.g, boolean):boolean");
    }

    @Override // androidx.appcompat.app.g
    public boolean f() {
        return V(true);
    }

    public void f0(PanelFeatureState panelFeatureState, boolean z10) {
        ViewGroup viewGroup;
        InterfaceC1312z interfaceC1312z;
        if (z10 && panelFeatureState.f8372a == 0 && (interfaceC1312z = this.f8363r) != null && interfaceC1312z.d()) {
            c0(panelFeatureState.f8381j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f8356k.getSystemService("window");
        if (windowManager != null && panelFeatureState.f8386o && (viewGroup = panelFeatureState.f8378g) != null) {
            windowManager.removeView(viewGroup);
            if (z10) {
                b0(panelFeatureState.f8372a, panelFeatureState, null);
            }
        }
        panelFeatureState.f8384m = false;
        panelFeatureState.f8385n = false;
        panelFeatureState.f8386o = false;
        panelFeatureState.f8379h = null;
        panelFeatureState.f8388q = true;
        if (this.f8333N == panelFeatureState) {
            this.f8333N = null;
        }
        if (panelFeatureState.f8372a == 0) {
            f1();
        }
    }

    public void f1() {
        OnBackInvokedCallback onBackInvokedCallback;
        boolean zZ0 = Z0();
        if (zZ0 && this.f8354i0 == null) {
            this.f8354i0 = m.b(this.f8353h0, this);
        } else {
            if (zZ0 || (onBackInvokedCallback = this.f8354i0) == null) {
                return;
            }
            m.c(this.f8353h0, onBackInvokedCallback);
            this.f8354i0 = null;
        }
    }

    public final Configuration g0(Context context, int i10, x0.g gVar, Configuration configuration, boolean z10) {
        int i11 = i10 != 1 ? i10 != 2 ? z10 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & (-49));
        if (gVar != null) {
            V0(configuration2, gVar);
        }
        return configuration2;
    }

    public final void g1(int i10, x0.g gVar, boolean z10, Configuration configuration) {
        Resources resources = this.f8356k.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i10 | (resources.getConfiguration().uiMode & (-49));
        if (gVar != null) {
            V0(configuration2, gVar);
        }
        resources.updateConfiguration(configuration2, null);
        int i11 = this.f8340U;
        if (i11 != 0) {
            this.f8356k.setTheme(i11);
            this.f8356k.getTheme().applyStyle(this.f8340U, true);
        }
        if (z10 && (this.f8355j instanceof Activity)) {
            d1(configuration2);
        }
    }

    public final ViewGroup h0() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f8356k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        int i10 = R$styleable.AppCompatTheme_windowActionBar;
        if (!typedArrayObtainStyledAttributes.hasValue(i10)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
            H(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(i10, false)) {
            H(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            H(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            H(10);
        }
        this.f8329J = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        o0();
        this.f8357l.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f8356k);
        if (this.f8330K) {
            viewGroup = this.f8328I ? (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.f8329J) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
            this.f8327H = false;
            this.f8326G = false;
        } else if (this.f8326G) {
            TypedValue typedValue = new TypedValue();
            this.f8356k.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new i.d(this.f8356k, typedValue.resourceId) : this.f8356k).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
            InterfaceC1312z interfaceC1312z = (InterfaceC1312z) viewGroup.findViewById(R$id.decor_content_parent);
            this.f8363r = interfaceC1312z;
            interfaceC1312z.setWindowCallback(y0());
            if (this.f8327H) {
                this.f8363r.g(109);
            }
            if (this.f8324E) {
                this.f8363r.g(2);
            }
            if (this.f8325F) {
                this.f8363r.g(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f8326G + ", windowActionBarOverlay: " + this.f8327H + ", android:windowIsFloating: " + this.f8329J + ", windowActionModeOverlay: " + this.f8328I + ", windowNoTitle: " + this.f8330K + " }");
        }
        N.u0(viewGroup, new b());
        if (this.f8363r == null) {
            this.f8322C = (TextView) viewGroup.findViewById(R$id.title);
        }
        b0.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f8357l.findViewById(R.id.content);
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
        this.f8357l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new c());
        return viewGroup;
    }

    public final int h1(a0 a0Var, Rect rect) {
        boolean z10;
        boolean z11;
        int iM = a0Var != null ? a0Var.m() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f8367v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f8367v.getLayoutParams();
            if (this.f8367v.isShown()) {
                if (this.f8349d0 == null) {
                    this.f8349d0 = new Rect();
                    this.f8350e0 = new Rect();
                }
                Rect rect2 = this.f8349d0;
                Rect rect3 = this.f8350e0;
                if (a0Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(a0Var.k(), a0Var.m(), a0Var.l(), a0Var.j());
                }
                b0.a(this.f8321B, rect2, rect3);
                int i10 = rect2.top;
                int i11 = rect2.left;
                int i12 = rect2.right;
                a0 a0VarB = N.B(this.f8321B);
                int iK = a0VarB == null ? 0 : a0VarB.k();
                int iL = a0VarB == null ? 0 : a0VarB.l();
                if (marginLayoutParams.topMargin == i10 && marginLayoutParams.leftMargin == i11 && marginLayoutParams.rightMargin == i12) {
                    z11 = false;
                } else {
                    marginLayoutParams.topMargin = i10;
                    marginLayoutParams.leftMargin = i11;
                    marginLayoutParams.rightMargin = i12;
                    z11 = true;
                }
                if (i10 <= 0 || this.f8323D != null) {
                    View view = this.f8323D;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i13 = marginLayoutParams2.height;
                        int i14 = marginLayoutParams.topMargin;
                        if (i13 != i14 || marginLayoutParams2.leftMargin != iK || marginLayoutParams2.rightMargin != iL) {
                            marginLayoutParams2.height = i14;
                            marginLayoutParams2.leftMargin = iK;
                            marginLayoutParams2.rightMargin = iL;
                            this.f8323D.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f8356k);
                    this.f8323D = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iK;
                    layoutParams.rightMargin = iL;
                    this.f8321B.addView(this.f8323D, -1, layoutParams);
                }
                View view3 = this.f8323D;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    i1(this.f8323D);
                }
                if (!this.f8328I && z) {
                    iM = 0;
                }
                z10 = z;
                z = z11;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                z = false;
            }
            if (z) {
                this.f8367v.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.f8323D;
        if (view4 != null) {
            view4.setVisibility(z10 ? 0 : 8);
        }
        return iM;
    }

    @Override // androidx.appcompat.app.g
    public Context i(Context context) {
        AppCompatDelegateImpl appCompatDelegateImpl;
        Context context2;
        this.f8335P = true;
        int iF0 = F0(context, a0());
        if (androidx.appcompat.app.g.w(context)) {
            androidx.appcompat.app.g.U(context);
        }
        x0.g gVarZ = Z(context);
        if (context instanceof ContextThemeWrapper) {
            appCompatDelegateImpl = this;
            context2 = context;
            try {
                ((ContextThemeWrapper) context2).applyOverrideConfiguration(appCompatDelegateImpl.g0(context2, iF0, gVarZ, null, false));
                return context2;
            } catch (IllegalStateException unused) {
            }
        } else {
            appCompatDelegateImpl = this;
            context2 = context;
        }
        if (context2 instanceof i.d) {
            try {
                ((i.d) context2).a(appCompatDelegateImpl.g0(context2, iF0, gVarZ, null, false));
                return context2;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f8319u0) {
            return super.i(context2);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = context2.createConfigurationContext(configuration).getResources().getConfiguration();
        Configuration configuration3 = context2.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationG0 = appCompatDelegateImpl.g0(context2, iF0, gVarZ, !configuration2.equals(configuration3) ? q0(configuration2, configuration3) : null, true);
        i.d dVar = new i.d(context2, R$style.Theme_AppCompat_Empty);
        dVar.a(configurationG0);
        try {
            if (context2.getTheme() != null) {
                h.g.a(dVar.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.i(dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View i0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z10;
        if (this.f8351f0 == null) {
            TypedArray typedArrayObtainStyledAttributes = this.f8356k.obtainStyledAttributes(R$styleable.AppCompatTheme);
            String string = typedArrayObtainStyledAttributes.getString(R$styleable.AppCompatTheme_viewInflaterClass);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                this.f8351f0 = new androidx.appcompat.app.m();
            } else {
                try {
                    this.f8351f0 = (androidx.appcompat.app.m) this.f8356k.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f8351f0 = new androidx.appcompat.app.m();
                }
            }
        }
        boolean z11 = f8317k0;
        boolean zY0 = false;
        if (z11) {
            if (this.f8352g0 == null) {
                this.f8352g0 = new androidx.appcompat.app.o();
            }
            if (this.f8352g0.a(attributeSet)) {
                z10 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zY0 = Y0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zY0 = true;
                }
                z10 = zY0;
            }
        } else {
            z10 = zY0;
        }
        return this.f8351f0.r(view, str, context, attributeSet, z10, z11, true, androidx.appcompat.widget.a0.d());
    }

    public final void i1(View view) {
        view.setBackgroundColor((N.H(view) & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? androidx.core.content.a.c(this.f8356k, R$color.abc_decor_view_status_guard_light) : androidx.core.content.a.c(this.f8356k, R$color.abc_decor_view_status_guard));
    }

    public void j0() {
        androidx.appcompat.view.menu.e eVar;
        InterfaceC1312z interfaceC1312z = this.f8363r;
        if (interfaceC1312z != null) {
            interfaceC1312z.r();
        }
        if (this.f8368w != null) {
            this.f8357l.getDecorView().removeCallbacks(this.f8369x);
            if (this.f8368w.isShowing()) {
                try {
                    this.f8368w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f8368w = null;
        }
        m0();
        PanelFeatureState panelFeatureStateW0 = w0(0, false);
        if (panelFeatureStateW0 == null || (eVar = panelFeatureStateW0.f8381j) == null) {
            return;
        }
        eVar.close();
    }

    public boolean k0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f8355j;
        if (((obj instanceof C1322j.a) || (obj instanceof androidx.appcompat.app.k)) && (decorView = this.f8357l.getDecorView()) != null && C1322j.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f8358m.b(this.f8357l.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? H0(keyCode, keyEvent) : K0(keyCode, keyEvent);
    }

    @Override // androidx.appcompat.app.g
    public <T extends View> T l(int i10) {
        n0();
        return (T) this.f8357l.findViewById(i10);
    }

    public void l0(int i10) {
        PanelFeatureState panelFeatureStateW0;
        PanelFeatureState panelFeatureStateW02 = w0(i10, true);
        if (panelFeatureStateW02.f8381j != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateW02.f8381j.U(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateW02.f8390s = bundle;
            }
            panelFeatureStateW02.f8381j.i0();
            panelFeatureStateW02.f8381j.clear();
        }
        panelFeatureStateW02.f8389r = true;
        panelFeatureStateW02.f8388q = true;
        if ((i10 != 108 && i10 != 0) || this.f8363r == null || (panelFeatureStateW0 = w0(0, false)) == null) {
            return;
        }
        panelFeatureStateW0.f8384m = false;
        S0(panelFeatureStateW0, null);
    }

    public void m0() {
        U u10 = this.f8370y;
        if (u10 != null) {
            u10.c();
        }
    }

    @Override // androidx.appcompat.app.g
    public Context n() {
        return this.f8356k;
    }

    public final void n0() {
        if (this.f8320A) {
            return;
        }
        this.f8321B = h0();
        CharSequence charSequenceX0 = x0();
        if (!TextUtils.isEmpty(charSequenceX0)) {
            InterfaceC1312z interfaceC1312z = this.f8363r;
            if (interfaceC1312z != null) {
                interfaceC1312z.setWindowTitle(charSequenceX0);
            } else if (Q0() != null) {
                Q0().v(charSequenceX0);
            } else {
                TextView textView = this.f8322C;
                if (textView != null) {
                    textView.setText(charSequenceX0);
                }
            }
        }
        X();
        O0(this.f8321B);
        this.f8320A = true;
        PanelFeatureState panelFeatureStateW0 = w0(0, false);
        if (this.f8337R) {
            return;
        }
        if (panelFeatureStateW0 == null || panelFeatureStateW0.f8381j == null) {
            D0(108);
        }
    }

    public final void o0() {
        if (this.f8357l == null) {
            Object obj = this.f8355j;
            if (obj instanceof Activity) {
                Y(((Activity) obj).getWindow());
            }
        }
        if (this.f8357l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return i0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.g
    public final androidx.appcompat.app.b p() {
        return new f();
    }

    public PanelFeatureState p0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f8332M;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i10 = 0; i10 < length; i10++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
            if (panelFeatureState != null && panelFeatureState.f8381j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.g
    public int q() {
        return this.f8339T;
    }

    public final Context r0() {
        androidx.appcompat.app.a aVarT = t();
        Context contextJ = aVarT != null ? aVarT.j() : null;
        return contextJ == null ? this.f8356k : contextJ;
    }

    @Override // androidx.appcompat.app.g
    public MenuInflater s() {
        if (this.f8361p == null) {
            z0();
            androidx.appcompat.app.a aVar = this.f8360o;
            this.f8361p = new i.g(aVar != null ? aVar.j() : this.f8356k);
        }
        return this.f8361p;
    }

    public final int s0(Context context) throws PackageManager.NameNotFoundException {
        if (!this.f8342W && (this.f8355j instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f8355j.getClass()), 269221888);
                if (activityInfo != null) {
                    this.f8341V = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e10) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e10);
                this.f8341V = 0;
            }
        }
        this.f8342W = true;
        return this.f8341V;
    }

    @Override // androidx.appcompat.app.g
    public androidx.appcompat.app.a t() {
        z0();
        return this.f8360o;
    }

    public final p t0(Context context) {
        if (this.f8344Y == null) {
            this.f8344Y = new o(context);
        }
        return this.f8344Y;
    }

    @Override // androidx.appcompat.app.g
    public void u() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f8356k);
        if (layoutInflaterFrom.getFactory() == null) {
            C1323k.a(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final p u0(Context context) {
        if (this.f8343X == null) {
            this.f8343X = new q(androidx.appcompat.app.r.a(context));
        }
        return this.f8343X;
    }

    @Override // androidx.appcompat.app.g
    public void v() {
        if (Q0() == null || t().l()) {
            return;
        }
        D0(0);
    }

    public x0.g v0(Configuration configuration) {
        return k.b(configuration);
    }

    public PanelFeatureState w0(int i10, boolean z10) {
        PanelFeatureState[] panelFeatureStateArr = this.f8332M;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i10) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i10 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f8332M = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i10);
        panelFeatureStateArr[i10] = panelFeatureState2;
        return panelFeatureState2;
    }

    @Override // androidx.appcompat.app.g
    public void x(Configuration configuration) throws PackageManager.NameNotFoundException {
        androidx.appcompat.app.a aVarT;
        if (this.f8326G && this.f8320A && (aVarT = t()) != null) {
            aVarT.m(configuration);
        }
        C1295h.b().g(this.f8356k);
        this.f8338S = new Configuration(this.f8356k.getResources().getConfiguration());
        W(false, false);
    }

    public final CharSequence x0() {
        Object obj = this.f8355j;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f8362q;
    }

    @Override // androidx.appcompat.app.g
    public void y(Bundle bundle) {
        String strC;
        this.f8335P = true;
        V(false);
        o0();
        Object obj = this.f8355j;
        if (obj instanceof Activity) {
            try {
                strC = androidx.core.app.h.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                androidx.appcompat.app.a aVarQ0 = Q0();
                if (aVarQ0 == null) {
                    this.f8348c0 = true;
                } else {
                    aVarQ0.r(true);
                }
            }
            androidx.appcompat.app.g.d(this);
        }
        this.f8338S = new Configuration(this.f8356k.getResources().getConfiguration());
        this.f8336Q = true;
    }

    public final Window.Callback y0() {
        return this.f8357l.getCallback();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    @Override // androidx.appcompat.app.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f8355j
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.g.F(r3)
        L9:
            boolean r0 = r3.f8345Z
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f8357l
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f8347b0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.f8337R = r0
            int r0 = r3.f8339T
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.f8355j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            androidx.collection.t<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.f8316j0
            java.lang.Object r1 = r3.f8355j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f8339T
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            androidx.collection.t<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.f8316j0
            java.lang.Object r1 = r3.f8355j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.a r0 = r3.f8360o
            if (r0 == 0) goto L5b
            r0.n()
        L5b:
            r3.d0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.z():void");
    }

    public final void z0() {
        n0();
        if (this.f8326G && this.f8360o == null) {
            Object obj = this.f8355j;
            if (obj instanceof Activity) {
                this.f8360o = new androidx.appcompat.app.s((Activity) this.f8355j, this.f8327H);
            } else if (obj instanceof Dialog) {
                this.f8360o = new androidx.appcompat.app.s((Dialog) this.f8355j);
            }
            androidx.appcompat.app.a aVar = this.f8360o;
            if (aVar != null) {
                aVar.r(this.f8348c0);
            }
        }
    }

    public AppCompatDelegateImpl(Dialog dialog, androidx.appcompat.app.e eVar) {
        this(dialog.getContext(), dialog.getWindow(), eVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public AppCompatDelegateImpl(Context context, Window window, androidx.appcompat.app.e eVar, Object obj) {
        t<String, Integer> tVar;
        Integer num;
        androidx.appcompat.app.d dVarC1;
        this.f8370y = null;
        this.f8371z = true;
        this.f8339T = -100;
        this.f8347b0 = new a();
        this.f8356k = context;
        this.f8359n = eVar;
        this.f8355j = obj;
        if (this.f8339T == -100 && (obj instanceof Dialog) && (dVarC1 = c1()) != null) {
            this.f8339T = dVarC1.getDelegate().q();
        }
        if (this.f8339T == -100 && (num = (tVar = f8316j0).get(obj.getClass().getName())) != null) {
            this.f8339T = num.intValue();
            tVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            Y(window);
        }
        C1295h.h();
    }
}
