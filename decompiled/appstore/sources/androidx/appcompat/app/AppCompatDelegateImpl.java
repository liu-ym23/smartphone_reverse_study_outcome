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
import android.media.AudioManager;
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
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
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
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.h0;
import androidx.appcompat.widget.i0;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final SimpleArrayMap f295j0 = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final boolean f296k0 = false;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final int[] f297l0 = null;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final boolean f298m0 = false;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final boolean f299n0 = false;
    public boolean A;
    public ViewGroup B;
    public TextView C;
    public View D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f300J;
    public boolean K;
    public boolean L;
    public PanelFeatureState[] M;
    public PanelFeatureState N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public Configuration S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public p X;
    public p Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f301a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final Runnable f302b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f303c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public Rect f304d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public Rect f305e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public androidx.appcompat.app.g f306f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public androidx.appcompat.app.j f307g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public OnBackInvokedDispatcher f308h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public OnBackInvokedCallback f309i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f310j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f311k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Window f312l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public n f313m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AppCompatCallback f314n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ActionBar f315o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MenuInflater f316p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f317q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DecorContentParent f318r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public g f319s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public t f320t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ActionMode f321u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ActionBarContextView f322v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public PopupWindow f323w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Runnable f324x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public androidx.core.view.r f325y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f326z;

    public interface ActionBarMenuCallback {
        @Nullable
        View onCreatePanelView(int r10);

        boolean onPreparePanel(int r10);
    }

    public static final class PanelFeatureState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f330d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f331e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f332f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ViewGroup f333g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View f334h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public View f335i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public MenuBuilder f336j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public androidx.appcompat.view.menu.d f337k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Context f338l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f339m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f340n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f341o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f342p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f343q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f344r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Bundle f345s;

        @SuppressLint({"BanParcelableUsage"})
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = null;
            int featureId;
            boolean isOpen;
            Bundle menuState;

            public class a implements Parcelable.ClassLoaderCreator {
                public a() {
                }

                public SavedState a(Parcel r10) {
                    return SavedState.readFromParcel(r10, null);
                }

                public SavedState b(Parcel r10, ClassLoader r11) {
                    return SavedState.readFromParcel(r10, r11);
                }

                public SavedState[] c(int r10) {
                    return new SavedState[r10];
                }

                @Override // android.os.Parcelable.Creator
                public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                    return a(r10);
                }

                @Override // android.os.Parcelable.Creator
                public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                    return c(r10);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10, ClassLoader r11) {
                    return b(r10, r11);
                }
            }

            static {
                CREATOR = new a();
            }

            public SavedState() {
            }

            public static SavedState readFromParcel(Parcel r10, ClassLoader r11) {
                SavedState r12 = new SavedState();
                r12.featureId = r10.readInt();
                boolean r13 = true;
                if (r10.readInt() == 1) goto L6;
                r13 = false;
            L6:
                r12.isOpen = r13;
                if (r13 == false) goto L9;
                r12.menuState = r10.readBundle(r11);
            L9:
                return r12;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel r10, int r11) {
                r10.writeInt(this.featureId);
                r10.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen == false) goto L6;
                r10.writeBundle(this.menuState);
                return;
            }
        }

        public PanelFeatureState(int r10) {
            this.f327a = r10;
            this.f343q = false;
        }

        public MenuView a(MenuPresenter.Callback r10) {
            if (this.f336j != null) goto L7;
            return null;
        L7:
            if (this.f337k != null) goto L10;
            androidx.appcompat.view.menu.d r11 = new androidx.appcompat.view.menu.d(this.f338l, R$layout.abc_list_menu_item_layout);
            this.f337k = r11;
            r11.setCallback(r10);
            this.f336j.addMenuPresenter(this.f337k);
        L10:
            return this.f337k.getMenuView(this.f333g);
        }

        public boolean b() {
            if (this.f334h != null) goto L6;
            return false;
        L6:
            if (this.f335i == null) goto L9;
            return true;
        L9:
            if (this.f337k.a().getCount() > 0) goto L11;
            return false;
        L11:
            return true;
        }

        public void c(MenuBuilder r10) {
            MenuBuilder r11 = this.f336j;
            if (r10 != r11) goto L5;
            return;
        L5:
            if (r11 == null) goto L7;
            r11.removeMenuPresenter(this.f337k);
        L7:
            this.f336j = r10;
            if (r10 == null) goto L13;
            androidx.appcompat.view.menu.d r12 = this.f337k;
            if (r12 == null) goto L14;
            r10.addMenuPresenter(r12);
            return;
        L14:
            return;
        }

        public void d(Context r10) {
            TypedValue r11 = new TypedValue();
            Resources.Theme r12 = r10.getResources().newTheme();
            r12.setTo(r10.getTheme());
            r12.resolveAttribute(R$attr.actionBarPopupTheme, r11, true);
            int r13 = r11.resourceId;
            if (r13 == 0) goto L5;
            r12.applyStyle(r13, true);
        L5:
            r12.resolveAttribute(R$attr.panelMenuListTheme, r11, true);
            int r14 = r11.resourceId;
            if (r14 == 0) goto L8;
            r12.applyStyle(r14, true);
        L9:
            g.b r15 = new g.b(r10, 0);
            r15.getTheme().setTo(r12);
            this.f338l = r15;
            TypedArray r16 = r15.obtainStyledAttributes(R$styleable.AppCompatTheme);
            this.f328b = r16.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f332f = r16.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            r16.recycle();
            return;
        L8:
            r12.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            goto L9
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f346a;

        public a(AppCompatDelegateImpl r10) {
            this.f346a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl r10 = this.f346a;
            if ((r10.f301a0 & 1) == 0) goto L5;
            r10.f0(0);
        L5:
            AppCompatDelegateImpl r11 = this.f346a;
            if ((r11.f301a0 & 4096) == 0) goto L8;
            r11.f0(108);
        L8:
            AppCompatDelegateImpl r12 = this.f346a;
            r12.Z = false;
            r12.f301a0 = 0;
        }
    }

    public class b implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f347a;

        public b(AppCompatDelegateImpl r10) {
            this.f347a = r10;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View r10, WindowInsetsCompat r11) {
            int r12 = r11.m();
            int r13 = this.f347a.c1(r11, null);
            if (r12 == r13) goto L6;
            r11 = r11.t(r11.k(), r13, r11.l(), r11.j());
        L6:
            return ViewCompat.b0(r10, r11);
        }
    }

    public class c implements ContentFrameLayout.OnAttachListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f348a;

        public c(AppCompatDelegateImpl r10) {
            this.f348a = r10;
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
        public void onAttachedFromWindow() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
        public void onDetachedFromWindow() {
            this.f348a.d0();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f349a;

        public class a extends androidx.core.view.s {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f350a;

            public a(d r10) {
                this.f350a = r10;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View r10) {
                this.f350a.f349a.f322v.setAlpha(1.0f);
                this.f350a.f349a.f325y.h(null);
                this.f350a.f349a.f325y = null;
            }

            @Override // androidx.core.view.s, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View r10) {
                this.f350a.f349a.f322v.setVisibility(0);
            }
        }

        public d(AppCompatDelegateImpl r10) {
            this.f349a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl r10 = this.f349a;
            r10.f323w.showAtLocation(r10.f322v, 55, 0, 0);
            this.f349a.g0();
            if (this.f349a.R0() == false) goto L5;
            this.f349a.f322v.setAlpha(0.0f);
            AppCompatDelegateImpl r11 = this.f349a;
            r11.f325y = ViewCompat.e(r11.f322v).b(1.0f);
            this.f349a.f325y.h(new a(this));
            return;
        L5:
            this.f349a.f322v.setAlpha(1.0f);
            this.f349a.f322v.setVisibility(0);
        }
    }

    public class e extends androidx.core.view.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f351a;

        public e(AppCompatDelegateImpl r10) {
            this.f351a = r10;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View r10) {
            this.f351a.f322v.setAlpha(1.0f);
            this.f351a.f325y.h(null);
            this.f351a.f325y = null;
        }

        @Override // androidx.core.view.s, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View r10) {
            this.f351a.f322v.setVisibility(0);
            if ((this.f351a.f322v.getParent() instanceof View) == false) goto L6;
            ViewCompat.m0((View) this.f351a.f322v.getParent());
            return;
        }
    }

    public class f implements ActionBarDrawerToggle$Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f352a;

        public f(AppCompatDelegateImpl r10) {
            this.f352a = r10;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
        public Context getActionBarThemedContext() {
            return this.f352a.l0();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
        public Drawable getThemeUpIndicator() {
            b0 r10 = b0.u(getActionBarThemedContext(), null, new int[]{R$attr.homeAsUpIndicator});
            Drawable r11 = r10.g(0);
            r10.w();
            return r11;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
        public boolean isNavigationVisible() {
            ActionBar r10 = this.f352a.q();
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if ((r10.d() & 4) == 0) goto L7;
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
        public void setActionBarDescription(int r10) {
            ActionBar r11 = this.f352a.q();
            if (r11 == null) goto L6;
            r11.m(r10);
            return;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle$Delegate
        public void setActionBarUpIndicator(Drawable r10, int r11) {
            ActionBar r12 = this.f352a.q();
            if (r12 == null) goto L6;
            r12.n(r10);
            r12.m(r11);
            return;
        }
    }

    public final class g implements MenuPresenter.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f353a;

        public g(AppCompatDelegateImpl r10) {
            this.f353a = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r10, boolean r11) {
            this.f353a.W(r10);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r10) {
            Window.Callback r11 = this.f353a.s0();
            if (r11 == null) goto L7;
            r11.onMenuOpened(108, r10);
            return true;
        L7:
            return true;
        }
    }

    public class h implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ActionMode.Callback f354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f355b;

        public class a extends androidx.core.view.s {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f356a;

            public a(h r10) {
                this.f356a = r10;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View r10) {
                this.f356a.f355b.f322v.setVisibility(8);
                AppCompatDelegateImpl r11 = this.f356a.f355b;
                PopupWindow r12 = r11.f323w;
                if (r12 == null) goto L6;
                r12.dismiss();
            L8:
                this.f356a.f355b.f322v.k();
                this.f356a.f355b.f325y.h(null);
                AppCompatDelegateImpl r13 = this.f356a.f355b;
                r13.f325y = null;
                ViewCompat.m0(r13.B);
                return;
            L6:
                if ((r11.f322v.getParent() instanceof View) == false) goto L8;
                ViewCompat.m0((View) this.f356a.f355b.f322v.getParent());
                goto L8
            }
        }

        public h(AppCompatDelegateImpl r10, ActionMode.Callback r11) {
            this.f355b = r10;
            this.f354a = r11;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r10, MenuItem r11) {
            return this.f354a.onActionItemClicked(r10, r11);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r10, Menu r11) {
            return this.f354a.onCreateActionMode(r10, r11);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r10) {
            this.f354a.onDestroyActionMode(r10);
            AppCompatDelegateImpl r11 = this.f355b;
            if (r11.f323w == null) goto L5;
            r11.f312l.getDecorView().removeCallbacks(this.f355b.f324x);
        L5:
            AppCompatDelegateImpl r12 = this.f355b;
            if (r12.f322v == null) goto L8;
            r12.g0();
            AppCompatDelegateImpl r13 = this.f355b;
            r13.f325y = ViewCompat.e(r13.f322v).b(0.0f);
            this.f355b.f325y.h(new a(this));
        L8:
            AppCompatDelegateImpl r14 = this.f355b;
            AppCompatCallback r15 = r14.f314n;
            if (r15 == null) goto L11;
            r15.onSupportActionModeFinished(r14.f321u);
        L11:
            AppCompatDelegateImpl r16 = this.f355b;
            r16.f321u = null;
            ViewCompat.m0(r16.B);
            this.f355b.a1();
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r10, Menu r11) {
            ViewCompat.m0(this.f355b.B);
            return this.f354a.onPrepareActionMode(r10, r11);
        }
    }

    public static class i {
        public static Context a(Context r10, Configuration r11) {
            return r10.createConfigurationContext(r11);
        }

        public static void b(Configuration r10, Configuration r11, Configuration r12) {
            int r13 = r10.densityDpi;
            int r14 = r11.densityDpi;
            if (r13 == r14) goto L6;
            r12.densityDpi = r14;
            return;
        }

        @DoNotInline
        public static void c(Configuration r10, Locale r11) {
            r10.setLayoutDirection(r11);
        }

        @DoNotInline
        public static void d(Configuration r10, Locale r11) {
            r10.setLocale(r11);
        }
    }

    public static class j {
        public static boolean a(PowerManager r10) {
            return r10.isPowerSaveMode();
        }

        @DoNotInline
        public static String b(Locale r10) {
            return r10.toLanguageTag();
        }
    }

    public static class k {
        @DoNotInline
        public static void a(@NonNull Configuration r10, @NonNull Configuration r11, @NonNull Configuration r12) {
            LocaleList r13 = r10.getLocales();
            LocaleList r14 = r11.getLocales();
            if (r13.equals(r14) == true) goto L6;
            r12.setLocales(r14);
            r12.locale = r11.locale;
            return;
        }

        @DoNotInline
        public static androidx.core.os.e b(Configuration r10) {
            return androidx.core.os.e.b(r10.getLocales().toLanguageTags());
        }

        @DoNotInline
        public static void c(androidx.core.os.e r10) {
            LocaleList.setDefault(LocaleList.forLanguageTags(r10.g()));
        }

        @DoNotInline
        public static void d(Configuration r10, androidx.core.os.e r11) {
            r10.setLocales(LocaleList.forLanguageTags(r11.g()));
        }
    }

    public static class l {
        public static void a(Configuration r10, Configuration r11, Configuration r12) {
            int r13 = r10.colorMode & 3;
            int r14 = r11.colorMode;
            if (r13 == (r14 & 3)) goto L5;
            r12.colorMode |= r14 & 3;
        L5:
            int r15 = r10.colorMode & 12;
            int r16 = r11.colorMode;
            if (r15 == (r16 & 12)) goto L9;
            r12.colorMode |= r16 & 12;
            return;
        }
    }

    public static class m {
        @DoNotInline
        public static OnBackInvokedDispatcher a(Activity r10) {
            return r10.getOnBackInvokedDispatcher();
        }

        @DoNotInline
        public static OnBackInvokedCallback b(Object r10, final AppCompatDelegateImpl r11) {
            Objects.requireNonNull(r11);
            OnBackInvokedCallback r12 = new androidx.appcompat.app.c(r11);
            ((OnBackInvokedDispatcher) r10).registerOnBackInvokedCallback(1000000, r12);
            return r12;
        }

        @DoNotInline
        public static void c(Object r10, Object r11) {
            OnBackInvokedDispatcher r12 = (OnBackInvokedDispatcher) r10;
            r12.unregisterOnBackInvokedCallback((OnBackInvokedCallback) r11);
        }
    }

    public class n extends g.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ActionBarMenuCallback f357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f359d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f360e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f361f;

        public n(AppCompatDelegateImpl r10, Window.Callback r11) {
            this.f361f = r10;
            super(r11);
        }

        public boolean b(Window.Callback r10, KeyEvent r11) {
            this.f359d = true;     // Catch: Throwable -> L6
            boolean r12 = r10.dispatchKeyEvent(r11);     // Catch: Throwable -> L6
            this.f359d = false;
            return r12;
        L6:
            th = move-exception;
            this.f359d = false;
            throw th;
        }

        public void c(Window.Callback r10) {
            this.f358c = true;     // Catch: Throwable -> L6
            r10.onContentChanged();     // Catch: Throwable -> L6
            this.f358c = false;
            return;
        L6:
            th = move-exception;
            this.f358c = false;
            throw th;
        }

        public void d(Window.Callback r10, int r11, Menu r12) {
            this.f360e = true;     // Catch: Throwable -> L6
            r10.onPanelClosed(r11, r12);     // Catch: Throwable -> L6
            this.f360e = false;
            return;
        L6:
            th = move-exception;
            this.f360e = false;
            throw th;
        }

        @Override // g.e, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent r10) {
            if (this.f359d == false) goto L7;
            return a().dispatchKeyEvent(r10);
        L7:
            if (this.f361f.e0(r10) == false) goto L9;
        L12:
            return true;
        L9:
            if (super.dispatchKeyEvent(r10) == true) goto L12;
            return false;
        }

        @Override // g.e, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent r10) {
            if (super.dispatchKeyShortcutEvent(r10) == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f361f.D0(r10.getKeyCode(), r10) == true) goto L8;
            return false;
        }

        public final android.view.ActionMode e(android.view.ActionMode.Callback r10) {
            androidx.appcompat.view.b.a r11 = new androidx.appcompat.view.b.a(this.f361f.f311k, r10);
            ActionMode r12 = this.f361f.U0(r11);
            if (r12 != null) goto L5;
            return null;
        L5:
            return r11.a(r12);
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f358c == false) goto L6;
            a().onContentChanged();
            return;
        }

        @Override // g.e, android.view.Window.Callback
        public boolean onCreatePanelMenu(int r10, Menu r11) {
            if (r10 != 0) goto L8;
            if ((r11 instanceof MenuBuilder) == true) goto L8;
            return false;
        L8:
            return super.onCreatePanelMenu(r10, r11);
        }

        @Override // g.e, android.view.Window.Callback
        public View onCreatePanelView(int r10) {
            ActionBarMenuCallback r11 = this.f357b;
            if (r11 == null) goto L8;
            View r12 = r11.onCreatePanelView(r10);
            if (r12 == null) goto L8;
            return r12;
        L8:
            return super.onCreatePanelView(r10);
        }

        @Override // g.e, android.view.Window.Callback
        public boolean onMenuOpened(int r10, Menu r11) {
            super.onMenuOpened(r10, r11);
            this.f361f.G0(r10);
            return true;
        }

        @Override // g.e, android.view.Window.Callback
        public void onPanelClosed(int r10, Menu r11) {
            if (this.f360e == false) goto L6;
            a().onPanelClosed(r10, r11);
            return;
        L6:
            super.onPanelClosed(r10, r11);
            this.f361f.H0(r10);
        }

        @Override // g.e, android.view.Window.Callback
        public boolean onPreparePanel(int r10, View r11, Menu r12) {
            if ((r12 instanceof MenuBuilder) == false) goto L5;
            MenuBuilder r13 = (MenuBuilder) r12;
        L7:
            if (r10 != 0) goto L10;
            if (r13 != null) goto L10;
            return false;
        L10:
            boolean r14 = true;
            if (r13 == null) goto L13;
            r13.setOverrideVisibleItems(true);
        L13:
            ActionBarMenuCallback r15 = this.f357b;
            if (r15 != null) goto L16;
        L18:
            r14 = false;
        L19:
            if (r14 == true) goto L21;
            r14 = super.onPreparePanel(r10, r11, r12);
        L21:
            if (r13 == null) goto L23;
            r13.setOverrideVisibleItems(false);
        L23:
            return r14;
        L16:
            if (r15.onPreparePanel(r10) == false) goto L18;
        L5:
            r13 = null;
            goto L7
        }

        @Override // g.e, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List r10, Menu r11, int r12) {
            PanelFeatureState r13 = this.f361f.q0(0, true);
            if (r13 == null) goto L7;
            MenuBuilder r14 = r13.f336j;
            if (r14 == null) goto L7;
            super.onProvideKeyboardShortcuts(r10, r14, r12);
            return;
        L7:
            super.onProvideKeyboardShortcuts(r10, r11, r12);
        }

        @Override // android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r10) {
            return null;
        }

        @Override // g.e, android.view.Window.Callback
        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r10, int r11) {
            if (this.f361f.y0() == false) goto L9;
            if (r11 != 0) goto L9;
            return e(r10);
        L9:
            return super.onWindowStartingActionMode(r10, r11);
        }
    }

    public class o extends p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PowerManager f362c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f363d;

        public o(AppCompatDelegateImpl r10, Context r11) {
            this.f363d = r10;
            super(r10);
            this.f362c = (PowerManager) r11.getApplicationContext().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public IntentFilter b() {
            IntentFilter r10 = new IntentFilter();
            r10.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return r10;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public int c() {
            if (j.a(this.f362c) == false) goto L5;
            return 2;
        L5:
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public void d() {
            this.f363d.Q();
        }
    }

    public abstract class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BroadcastReceiver f364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f365b;

        public class a extends BroadcastReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f366a;

            public a(p r10) {
                this.f366a = r10;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context r10, Intent r11) {
                this.f366a.d();
            }
        }

        public p(AppCompatDelegateImpl r10) {
            this.f365b = r10;
        }

        public void a() {
            BroadcastReceiver r10 = this.f364a;
            if (r10 == null) goto L10;
            this.f365b.f311k.unregisterReceiver(r10);     // Catch: IllegalArgumentException -> L7
        L5:
            this.f364a = null;
            return;
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter r10 = b();
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.countActions() != 0) goto L8;
            return;
        L8:
            if (this.f364a != null) goto L10;
            this.f364a = new a(this);
        L10:
            this.f365b.f311k.registerReceiver(this.f364a, r10);
        }
    }

    public class q extends p {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.appcompat.app.m f367c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f368d;

        public q(AppCompatDelegateImpl r10, androidx.appcompat.app.m r11) {
            this.f368d = r10;
            super(r10);
            this.f367c = r11;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public IntentFilter b() {
            IntentFilter r10 = new IntentFilter();
            r10.addAction("android.intent.action.TIME_SET");
            r10.addAction("android.intent.action.TIMEZONE_CHANGED");
            r10.addAction("android.intent.action.TIME_TICK");
            return r10;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public int c() {
            if (this.f367c.d() == false) goto L5;
            return 2;
        L5:
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public void d() {
            this.f368d.Q();
        }
    }

    public static class r {
        public static void a(ContextThemeWrapper r10, Configuration r11) {
            r10.applyOverrideConfiguration(r11);
        }
    }

    public class s extends ContentFrameLayout {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f369i;

        public s(AppCompatDelegateImpl r10, Context r11) {
            this.f369i = r10;
            super(r11);
        }

        public final boolean b(int r10, int r11) {
            if (r10 < (-5)) goto L11;
            if (r11 < (-5)) goto L11;
            if (r10 > (getWidth() + 5)) goto L11;
            if (r11 > (getHeight() + 5)) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent r10) {
            if (this.f369i.e0(r10) == false) goto L5;
        L8:
            return true;
        L5:
            if (super.dispatchKeyEvent(r10) == true) goto L8;
            return false;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r10) {
            if (r10.getAction() != 0) goto L9;
            if (b((int) r10.getX(), (int) r10.getY()) == false) goto L9;
            this.f369i.Y(0);
            return true;
        L9:
            return super.onInterceptTouchEvent(r10);
        }

        @Override // android.view.View
        public void setBackgroundResource(int r10) {
            setBackgroundDrawable(c.a.b(getContext(), r10));
        }
    }

    public final class t implements MenuPresenter.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatDelegateImpl f370a;

        public t(AppCompatDelegateImpl r10) {
            this.f370a = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r10, boolean r11) {
            MenuBuilder r12 = r10.getRootMenu();
            if (r12 == r10) goto L5;
            boolean r13 = true;
        L6:
            AppCompatDelegateImpl r14 = this.f370a;
            if (r13 == false) goto L9;
            r10 = r12;
        L9:
            PanelFeatureState r15 = r14.j0(r10);
            if (r15 == null) goto L15;
            if (r13 == false) goto L13;
            this.f370a.V(r15.f327a, r15, r12);
            this.f370a.Z(r15, true);
            return;
        L13:
            this.f370a.Z(r15, r11);
            return;
        L15:
            return;
        L5:
            r13 = false;
            goto L6
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r10) {
            if (r10 != r10.getRootMenu()) goto L13;
            AppCompatDelegateImpl r11 = this.f370a;
            if (r11.G == false) goto L14;
            Window.Callback r12 = r11.s0();
            if (r12 != null) goto L9;
            return true;
        L9:
            if (this.f370a.R == true) goto L16;
            r12.onMenuOpened(108, r10);
            return true;
        L16:
            return true;
        L14:
            return true;
        L13:
            return true;
        }
    }

    static {
        f295j0 = new SimpleArrayMap();
        f296k0 = false;
        f297l0 = new int[]{R.attr.windowBackground};
        f298m0 = !"robolectric".equals(Build.FINGERPRINT);
        f299n0 = true;
    }

    public AppCompatDelegateImpl(Activity r10, AppCompatCallback r11) {
        this(r10, null, r11, r10);
    }

    public static Configuration k0(Configuration r10, Configuration r11) {
        Configuration r12 = new Configuration();
        r12.fontScale = 0.0f;
        if (r11 != null) goto L5;
    L62:
        return r12;
    L5:
        if (r10.diff(r11) == 0) goto L62;
        float r13 = r10.fontScale;
        float r14 = r11.fontScale;
        if (r13 == r14) goto L10;
        r12.fontScale = r14;
    L10:
        int r15 = r10.mcc;
        int r16 = r11.mcc;
        if (r15 == r16) goto L13;
        r12.mcc = r16;
    L13:
        int r17 = r10.mnc;
        int r18 = r11.mnc;
        if (r17 == r18) goto L16;
        r12.mnc = r18;
    L16:
        k.a(r10, r11, r12);
        int r19 = r10.touchscreen;
        int r20 = r11.touchscreen;
        if (r19 == r20) goto L19;
        r12.touchscreen = r20;
    L19:
        int r21 = r10.keyboard;
        int r22 = r11.keyboard;
        if (r21 == r22) goto L22;
        r12.keyboard = r22;
    L22:
        int r23 = r10.keyboardHidden;
        int r24 = r11.keyboardHidden;
        if (r23 == r24) goto L25;
        r12.keyboardHidden = r24;
    L25:
        int r25 = r10.navigation;
        int r26 = r11.navigation;
        if (r25 == r26) goto L28;
        r12.navigation = r26;
    L28:
        int r27 = r10.navigationHidden;
        int r28 = r11.navigationHidden;
        if (r27 == r28) goto L31;
        r12.navigationHidden = r28;
    L31:
        int r29 = r10.orientation;
        int r30 = r11.orientation;
        if (r29 == r30) goto L34;
        r12.orientation = r30;
    L34:
        int r31 = r10.screenLayout & 15;
        int r32 = r11.screenLayout;
        if (r31 == (r32 & 15)) goto L37;
        r12.screenLayout |= r32 & 15;
    L37:
        int r33 = r10.screenLayout & 192;
        int r34 = r11.screenLayout;
        if (r33 == (r34 & 192)) goto L40;
        r12.screenLayout |= r34 & 192;
    L40:
        int r35 = r10.screenLayout & 48;
        int r36 = r11.screenLayout;
        if (r35 == (r36 & 48)) goto L43;
        r12.screenLayout |= r36 & 48;
    L43:
        int r37 = r10.screenLayout & 768;
        int r38 = r11.screenLayout;
        if (r37 == (r38 & 768)) goto L46;
        r12.screenLayout |= r38 & 768;
    L46:
        l.a(r10, r11, r12);
        int r39 = r10.uiMode & 15;
        int r40 = r11.uiMode;
        if (r39 == (r40 & 15)) goto L49;
        r12.uiMode |= r40 & 15;
    L49:
        int r41 = r10.uiMode & 48;
        int r42 = r11.uiMode;
        if (r41 == (r42 & 48)) goto L52;
        r12.uiMode |= r42 & 48;
    L52:
        int r43 = r10.screenWidthDp;
        int r44 = r11.screenWidthDp;
        if (r43 == r44) goto L55;
        r12.screenWidthDp = r44;
    L55:
        int r45 = r10.screenHeightDp;
        int r46 = r11.screenHeightDp;
        if (r45 == r46) goto L58;
        r12.screenHeightDp = r46;
    L58:
        int r47 = r10.smallestScreenWidthDp;
        int r48 = r11.smallestScreenWidthDp;
        if (r47 == r48) goto L61;
        r12.smallestScreenWidthDp = r48;
    L61:
        i.b(r10, r11, r12);
        goto L62
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void A(Bundle r10) {
    }

    public boolean A0() {
        boolean r10 = this.O;
        this.O = false;
        PanelFeatureState r11 = q0(0, false);
        if (r11 != null) goto L5;
    L9:
        ActionMode r12 = this.f321u;
        if (r12 == null) goto L13;
        r12.a();
        return true;
    L13:
        ActionBar r13 = q();
        if (r13 != null) goto L16;
    L18:
        return false;
    L16:
        if (r13.b() == false) goto L18;
        return true;
    L5:
        if (r11.f341o == false) goto L9;
        if (r10 == true) goto L8;
        Z(r11, true);
    L8:
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void B() {
        P(true, false);
    }

    public boolean B0(int r10, KeyEvent r11) {
        boolean r12 = true;
        if (r10 == 4) goto L10;
        if (r10 != 82) goto L14;
        C0(0, r11);
        return true;
    L14:
        return false;
    L10:
        if ((r11.getFlags() & 128) != 0) goto L13;
        r12 = false;
    L13:
        this.O = r12;
        goto L14
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void C() {
        ActionBar r10 = q();
        if (r10 == null) goto L6;
        r10.o(false);
        return;
    }

    public final boolean C0(int r10, KeyEvent r11) {
        if (r11.getRepeatCount() != 0) goto L8;
        PanelFeatureState r12 = q0(r10, true);
        if (r12.f341o == false) goto L7;
        return false;
    L7:
        return M0(r12, r11);
    L8:
        return false;
    }

    public boolean D0(int r10, KeyEvent r11) {
        ActionBar r12 = q();
        if (r12 != null) goto L5;
    L7:
        PanelFeatureState r13 = this.N;
        if (r13 == null) goto L16;
        if (L0(r13, r11.getKeyCode(), r11, 1) == false) goto L16;
        PanelFeatureState r14 = this.N;
        if (r14 == null) goto L14;
        r14.f340n = true;
    L14:
        return true;
    L16:
        if (this.N != null) goto L20;
        PanelFeatureState r15 = q0(0, true);
        M0(r15, r11);
        boolean r16 = L0(r15, r11.getKeyCode(), r11, 1);
        r15.f339m = false;
        if (r16 == false) goto L20;
        return true;
    L20:
        return false;
    L5:
        if (r12.i(r10, r11) == false) goto L7;
        return true;
    }

    public boolean E0(int r10, KeyEvent r11) {
        if (r10 == 4) goto L10;
        if (r10 != 82) goto L12;
        F0(0, r11);
        return true;
    L12:
        return false;
    L10:
        if (A0() == false) goto L12;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public boolean F(int r10) {
        int r11 = O0(r10);
        if (this.K == false) goto L7;
        if (r11 != 108) goto L7;
        return false;
    L7:
        if (this.G == false) goto L10;
        if (r11 != 1) goto L10;
        this.G = false;
    L10:
        if (r11 != 1) goto L12;
        W0();
        this.K = true;
        return true;
    L12:
        if (r11 != 2) goto L14;
        W0();
        this.E = true;
        return true;
    L14:
        if (r11 != 5) goto L16;
        W0();
        this.F = true;
        return true;
    L16:
        if (r11 == 10) goto L26;
        if (r11 != 108) goto L19;
        W0();
        this.G = true;
        return true;
    L19:
        if (r11 != 109) goto L21;
        W0();
        this.H = true;
        return true;
    L21:
        return this.f312l.requestFeature(r11);
    L26:
        W0();
        this.I = true;
        return true;
    }

    public final boolean F0(int r10, KeyEvent r11) {
        if (this.f321u == null) goto L5;
        return false;
    L5:
        boolean r12 = true;
        PanelFeatureState r13 = q0(r10, true);
        if (r10 != 0) goto L21;
        DecorContentParent r14 = this.f318r;
        if (r14 == null) goto L21;
        if (r14.canShowOverflowMenu() == false) goto L21;
        if (ViewConfiguration.get(this.f311k).hasPermanentMenuKey() == true) goto L21;
        if (this.f318r.isOverflowMenuShowing() == false) goto L16;
        r12 = this.f318r.hideOverflowMenu();
    L36:
        if (r12 == false) goto L41;
        AudioManager r15 = (AudioManager) this.f311k.getApplicationContext().getSystemService("audio");
        if (r15 == null) goto L40;
        r15.playSoundEffect(0);
        goto L41
    L40:
        Log.w("AppCompatDelegate", "Couldn't get audio manager");
    L41:
        return r12;
    L16:
        if (this.R == false) goto L18;
    L34:
        r12 = false;
        goto L36
    L18:
        if (M0(r13, r11) == false) goto L34;
        r12 = this.f318r.showOverflowMenu();
    L21:
        boolean r16 = r13.f341o;
        if (r16 == false) goto L24;
    L35:
        Z(r13, true);
        r12 = r16;
        goto L36
    L24:
        if (r13.f340n == true) goto L35;
        if (r13.f339m == false) goto L34;
        if (r13.f344r == false) goto L31;
        r13.f339m = false;
        boolean r17 = M0(r13, r11);
    L32:
        if (r17 == false) goto L34;
        J0(r13, r11);
        goto L36
    L31:
        r17 = true;
        goto L32
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void G(int r10) {
        h0();
        ViewGroup r11 = (ViewGroup) this.B.findViewById(R.id.content);
        r11.removeAllViews();
        LayoutInflater.from(this.f311k).inflate(r10, r11);
        this.f313m.c(this.f312l.getCallback());
    }

    public void G0(int r10) {
        if (r10 != 108) goto L8;
        ActionBar r11 = q();
        if (r11 == null) goto L9;
        r11.c(true);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void H(View r10) {
        h0();
        ViewGroup r11 = (ViewGroup) this.B.findViewById(R.id.content);
        r11.removeAllViews();
        r11.addView(r10);
        this.f313m.c(this.f312l.getCallback());
    }

    public void H0(int r10) {
        if (r10 != 108) goto L7;
        ActionBar r11 = q();
        if (r11 == null) goto L12;
        r11.c(false);
        return;
    L12:
        return;
    L7:
        if (r10 != 0) goto L14;
        PanelFeatureState r12 = q0(r10, true);
        if (r12.f341o == false) goto L15;
        Z(r12, false);
        return;
    L15:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void I(View r10, ViewGroup.LayoutParams r11) {
        h0();
        ViewGroup r12 = (ViewGroup) this.B.findViewById(R.id.content);
        r12.removeAllViews();
        r12.addView(r10, r11);
        this.f313m.c(this.f312l.getCallback());
    }

    public void I0(ViewGroup r10) {
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void J(int r10) {
        if (this.T == r10) goto L8;
        this.T = r10;
        if (this.P == false) goto L9;
        Q();
        return;
    L9:
        return;
    }

    public final void J0(PanelFeatureState r12, KeyEvent r13) {
        if (r12.f341o == false) goto L5;
        return;
    L5:
        if (this.R == false) goto L8;
        return;
    L8:
        if (r12.f327a == 0) goto L10;
    L12:
        Window.Callback r10 = s0();
        if (r10 != null) goto L15;
    L18:
        WindowManager r11 = (WindowManager) this.f311k.getSystemService("window");
        if (r11 != null) goto L22;
        return;
    L22:
        if (M0(r12, r13) == true) goto L24;
        return;
    L24:
        ViewGroup r14 = r12.f333g;
        if (r14 != null) goto L27;
    L36:
        if (r14 != null) goto L43;
        if (v0(r12) == true) goto L40;
        return;
    L40:
        if (r12.f333g != null) goto L48;
        return;
    L48:
        if (u0(r12) == true) goto L50;
    L66:
        r12.f343q = true;
        return;
    L50:
        if (r12.b() == false) goto L66;
        ViewGroup.LayoutParams r15 = r12.f334h.getLayoutParams();
        if (r15 != null) goto L55;
        r15 = new ViewGroup.LayoutParams(-2, -2);
    L55:
        r12.f333g.setBackgroundResource(r12.f328b);
        ViewParent r16 = r12.f334h.getParent();
        if ((r16 instanceof ViewGroup) == false) goto L58;
        ((ViewGroup) r16).removeView(r12.f334h);
    L58:
        r12.f333g.addView(r12.f334h, r15);
        if (r12.f334h.hasFocus() == true) goto L61;
        r12.f334h.requestFocus();
    L61:
        int r17 = -2;
    L62:
        r12.f340n = false;
        WindowManager.LayoutParams r18 = new WindowManager.LayoutParams(r17, -2, r12.f330d, r12.f331e, 1002, 8519680, -3);
        r18.gravity = r12.f329c;
        r18.windowAnimations = r12.f332f;
        r11.addView(r12.f333g, r18);
        r12.f341o = true;
        if (r12.f327a != 0) goto L69;
        a1();
        return;
    L69:
        return;
    L43:
        if (r12.f343q == false) goto L48;
        if (r14.getChildCount() <= 0) goto L48;
        r12.f333g.removeAllViews();
        goto L48
    L27:
        if (r12.f343q == true) goto L36;
        View r19 = r12.f335i;
        if (r19 == null) goto L61;
        ViewGroup.LayoutParams r110 = r19.getLayoutParams();
        if (r110 == null) goto L61;
        if (r110.width != (-1)) goto L61;
        r17 = -1;
        goto L62
    L15:
        if (r10.onMenuOpened(r12.f327a, r12.f336j) == true) goto L18;
        Z(r12, true);
        return;
    L10:
        if ((this.f311k.getResources().getConfiguration().screenLayout & 15) != 4) goto L12;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void K(OnBackInvokedDispatcher r10) {
        super.K(r10);
        OnBackInvokedDispatcher r11 = this.f308h0;
        if (r11 == null) goto L7;
        OnBackInvokedCallback r12 = this.f309i0;
        if (r12 == null) goto L7;
        m.c(r11, r12);
        this.f309i0 = null;
    L7:
        if (r10 != null) goto L13;
        Object r13 = this.f310j;
        if ((r13 instanceof Activity) == false) goto L13;
        if (((Activity) r13).getWindow() == null) goto L13;
        this.f308h0 = m.a((Activity) this.f310j);
    L14:
        a1();
        return;
    L13:
        this.f308h0 = r10;
        goto L14
    }

    public final ActionBar K0() {
        return this.f315o;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void L(int r10) {
        this.U = r10;
    }

    public final boolean L0(PanelFeatureState r10, int r11, KeyEvent r12, int r13) {
        boolean r14 = false;
        if (r12.isSystem() == false) goto L6;
        return false;
    L6:
        if (r10.f339m == false) goto L8;
    L9:
        MenuBuilder r15 = r10.f336j;
        if (r15 == null) goto L12;
        r14 = r15.performShortcut(r11, r12, r13);
    L12:
        if (r14 == true) goto L14;
    L18:
        return r14;
    L14:
        if ((r13 & 1) != 0) goto L18;
        if (this.f318r != null) goto L18;
        Z(r10, true);
        goto L18
    L8:
        if (M0(r10, r12) == false) goto L12;
        goto L9
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void M(CharSequence r10) {
        this.f317q = r10;
        DecorContentParent r11 = this.f318r;
        if (r11 == null) goto L6;
        r11.setWindowTitle(r10);
        return;
    L6:
        if (K0() == null) goto L8;
        K0().p(r10);
        return;
    L8:
        TextView r12 = this.C;
        if (r12 == null) goto L14;
        r12.setText(r10);
        return;
    }

    public final boolean M0(PanelFeatureState r10, KeyEvent r11) {
        if (this.R == false) goto L6;
        return false;
    L6:
        if (r10.f339m == false) goto L8;
        return true;
    L8:
        PanelFeatureState r12 = this.N;
        if (r12 == null) goto L12;
        if (r12 == r10) goto L12;
        Z(r12, false);
    L12:
        Window.Callback r13 = s0();
        if (r13 == null) goto L15;
        r10.f335i = r13.onCreatePanelView(r10.f327a);
    L15:
        int r14 = r10.f327a;
        if (r14 != 0) goto L18;
    L21:
        boolean r15 = true;
    L22:
        if (r15 == false) goto L27;
        DecorContentParent r16 = this.f318r;
        if (r16 == null) goto L27;
        r16.setMenuPrepared();
    L27:
        if (r10.f335i != null) goto L75;
        if (r15 == false) goto L30;
        K0();
    L30:
        MenuBuilder r17 = r10.f336j;
        if (r17 != null) goto L33;
    L34:
        if (r17 == null) goto L36;
    L40:
        if (r15 == true) goto L42;
    L47:
        r10.f336j.stopDispatchingItemsChanged();
        if (r13.onCreatePanelMenu(r10.f327a, r10.f336j) == true) goto L55;
        r10.c(null);
        if (r15 == false) goto L54;
        DecorContentParent r18 = this.f318r;
        if (r18 == null) goto L54;
        r18.setMenu(null, this.f319s);
    L54:
        return false;
    L55:
        r10.f344r = false;
    L56:
        r10.f336j.stopDispatchingItemsChanged();
        Bundle r19 = r10.f345s;
        if (r19 == null) goto L60;
        r10.f336j.restoreActionViewStates(r19);
        r10.f345s = null;
    L60:
        if (r13.onPreparePanel(0, r10.f335i, r10.f336j) == true) goto L67;
        if (r15 == false) goto L65;
        DecorContentParent r110 = this.f318r;
        if (r110 == null) goto L65;
        r110.setMenu(null, this.f319s);
    L65:
        r10.f336j.startDispatchingItemsChanged();
        return false;
    L67:
        if (r11 == null) goto L69;
        int r111 = r11.getDeviceId();
    L71:
        if (KeyCharacterMap.load(r111).getKeyboardType() == 1) goto L73;
        boolean r112 = true;
    L74:
        r10.f342p = r112;
        r10.f336j.setQwertyMode(r112);
        r10.f336j.startDispatchingItemsChanged();
        goto L75
    L73:
        r112 = false;
        goto L74
    L69:
        r111 = -1;
        goto L71
    L42:
        if (this.f318r == null) goto L47;
        if (this.f319s != null) goto L46;
        this.f319s = new g(this);
    L46:
        this.f318r.setMenu(r10.f336j, this.f319s);
        goto L47
    L36:
        if (w0(r10) == true) goto L38;
    L39:
        return false;
    L38:
        if (r10.f336j != null) goto L40;
    L33:
        if (r10.f344r == false) goto L56;
    L75:
        r10.f339m = true;
        r10.f340n = false;
        this.N = r10;
        return true;
    L18:
        if (r14 == 108) goto L21;
        r15 = false;
        goto L22
    }

    public final void N0(boolean r10) {
        DecorContentParent r11 = this.f318r;
        if (r11 != null) goto L5;
    L33:
        PanelFeatureState r12 = q0(0, true);
        r12.f343q = true;
        Z(r12, false);
        J0(r12, null);
        return;
    L5:
        if (r11.canShowOverflowMenu() == false) goto L33;
        if (ViewConfiguration.get(this.f311k).hasPermanentMenuKey() == true) goto L9;
    L10:
        Window.Callback r13 = s0();
        if (this.f318r.isOverflowMenuShowing() == false) goto L17;
        if (r10 == false) goto L17;
        this.f318r.hideOverflowMenu();
        if (this.R == true) goto L35;
        r13.onPanelClosed(108, q0(0, true).f336j);
        return;
    L35:
        return;
    L17:
        if (r13 != null) goto L19;
        return;
    L19:
        if (this.R == false) goto L21;
        return;
    L21:
        if (this.Z == true) goto L23;
    L25:
        PanelFeatureState r14 = q0(0, true);
        MenuBuilder r15 = r14.f336j;
        if (r15 != null) goto L28;
        return;
    L28:
        if (r14.f344r == false) goto L30;
        return;
    L30:
        if (r13.onPreparePanel(0, r14.f335i, r15) == false) goto L41;
        r13.onMenuOpened(108, r14.f336j);
        this.f318r.showOverflowMenu();
        return;
    L41:
        return;
    L23:
        if ((this.f301a0 & 1) == 0) goto L25;
        this.f312l.getDecorView().removeCallbacks(this.f302b0);
        this.f302b0.run();
        goto L25
    L9:
        if (this.f318r.isOverflowMenuShowPending() == false) goto L33;
        goto L10
    }

    public final boolean O(boolean r10) {
        return P(r10, true);
    }

    public final int O0(int r10) {
        if (r10 != 8) goto L7;
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
        return 108;
    L7:
        if (r10 != 9) goto L10;
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    L10:
        return r10;
    }

    public final boolean P(boolean r10, boolean r11) {
        if (this.R == false) goto L6;
        return false;
    L6:
        int r12 = U();
        int r13 = z0(this.f311k, r12);
        if (Build.VERSION.SDK_INT >= 33) goto L9;
        androidx.core.os.e r14 = T(this.f311k);
    L10:
        if (r11 == true) goto L13;
        if (r14 == null) goto L13;
        r14 = p0(this.f311k.getResources().getConfiguration());
    L13:
        boolean r15 = Z0(r13, r14, r10);
        if (r12 != 0) goto L16;
        o0(this.f311k).e();
    L20:
        if (r12 != 3) goto L22;
        n0(this.f311k).e();
    L25:
        return r15;
    L22:
        p r16 = this.Y;
        if (r16 == null) goto L25;
        r16.a();
        goto L25
    L16:
        p r17 = this.X;
        if (r17 == null) goto L20;
        r17.a();
        goto L20
    L9:
        r14 = null;
        goto L10
    }

    public void P0(Configuration r10, androidx.core.os.e r11) {
        k.d(r10, r11);
    }

    public boolean Q() {
        return O(true);
    }

    public void Q0(androidx.core.os.e r10) {
        k.c(r10);
    }

    public final void R() {
        ContentFrameLayout r10 = (ContentFrameLayout) this.B.findViewById(R.id.content);
        View r11 = this.f312l.getDecorView();
        r10.a(r11.getPaddingLeft(), r11.getPaddingTop(), r11.getPaddingRight(), r11.getPaddingBottom());
        TypedArray r12 = this.f311k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        r12.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, r10.getMinWidthMajor());
        r12.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, r10.getMinWidthMinor());
        int r13 = R$styleable.AppCompatTheme_windowFixedWidthMajor;
        if (r12.hasValue(r13) == false) goto L5;
        r12.getValue(r13, r10.getFixedWidthMajor());
    L5:
        int r14 = R$styleable.AppCompatTheme_windowFixedWidthMinor;
        if (r12.hasValue(r14) == false) goto L8;
        r12.getValue(r14, r10.getFixedWidthMinor());
    L8:
        int r15 = R$styleable.AppCompatTheme_windowFixedHeightMajor;
        if (r12.hasValue(r15) == false) goto L11;
        r12.getValue(r15, r10.getFixedHeightMajor());
    L11:
        int r16 = R$styleable.AppCompatTheme_windowFixedHeightMinor;
        if (r12.hasValue(r16) == false) goto L14;
        r12.getValue(r16, r10.getFixedHeightMinor());
    L14:
        r12.recycle();
        r10.requestLayout();
    }

    public final boolean R0() {
        if (this.A == false) goto L9;
        ViewGroup r10 = this.B;
        if (r10 == null) goto L9;
        if (ViewCompat.T(r10) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final void S(Window r10) {
        if (this.f312l != null) goto L18;
        Window.Callback r11 = r10.getCallback();
        if ((r11 instanceof n) == true) goto L16;
        n r12 = new n(this, r11);
        this.f313m = r12;
        r10.setCallback(r12);
        b0 r13 = b0.u(this.f311k, null, f297l0);
        Drawable r14 = r13.h(0);
        if (r14 == null) goto L9;
        r10.setBackgroundDrawable(r14);
    L9:
        r13.w();
        this.f312l = r10;
        if (Build.VERSION.SDK_INT >= 33) goto L12;
        return;
    L12:
        if (this.f308h0 != null) goto L20;
        K(null);
        return;
    L20:
        return;
    L16:
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    L18:
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public final boolean S0(ViewParent r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        View r11 = this.f312l.getDecorView();
    L6:
        if (r10 == null) goto L7;
        if (r10 == r11) goto L16;
        if ((r10 instanceof View) == false) goto L16;
        if (ViewCompat.S((View) r10) == true) goto L16;
        r10 = r10.getParent();
    L16:
        return false;
    L7:
        return true;
    }

    public androidx.core.os.e T(Context r10) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        return null;
    L5:
        androidx.core.os.e r11 = AppCompatDelegate.p();
        if (r11 != null) goto L8;
        return null;
    L8:
        androidx.core.os.e r12 = p0(r10.getApplicationContext().getResources().getConfiguration());
        androidx.core.os.e r13 = androidx.appcompat.app.k.b(r11, r12);
        if (r13.e() == false) goto L12;
        return r12;
    L12:
        return r13;
    }

    public boolean T0() {
        if (this.f308h0 != null) goto L5;
        return false;
    L5:
        PanelFeatureState r10 = q0(0, false);
        if (r10 == null) goto L11;
        if (r10.f341o == false) goto L11;
        return true;
    L11:
        if (this.f321u == null) goto L13;
        return true;
    L13:
        return false;
    }

    public final int U() {
        int r10 = this.T;
        if (r10 == (-100)) goto L6;
        return r10;
    L6:
        return AppCompatDelegate.k();
    }

    public ActionMode U0(ActionMode.Callback r10) {
        if (r10 == null) goto L19;
        ActionMode r11 = this.f321u;
        if (r11 == null) goto L6;
        r11.a();
    L6:
        h r12 = new h(this, r10);
        ActionBar r13 = q();
        if (r13 == null) goto L14;
        ActionMode r14 = r13.q(r12);
        this.f321u = r14;
        if (r14 == null) goto L14;
        AppCompatCallback r15 = this.f314n;
        if (r15 == null) goto L14;
        r15.onSupportActionModeStarted(r14);
    L14:
        if (this.f321u != null) goto L16;
        this.f321u = V0(r12);
    L16:
        a1();
        return this.f321u;
    L19:
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public void V(int r10, PanelFeatureState r11, Menu r12) {
        if (r12 != null) goto L10;
        if (r11 != null) goto L8;
        if (r10 < 0) goto L8;
        PanelFeatureState[] r13 = this.M;
        if (r10 >= r13.length) goto L8;
        r11 = r13[r10];
    L8:
        if (r11 == null) goto L10;
        r12 = r11.f336j;
    L10:
        if (r11 == null) goto L15;
        if (r11.f341o == true) goto L15;
        return;
    L15:
        if (this.R == true) goto L18;
        this.f313m.d(this.f312l.getCallback(), r10, r12);
        return;
    }

    public ActionMode V0(ActionMode.Callback r10) {
        g0();
        ActionMode r11 = this.f321u;
        if (r11 == null) goto L6;
        r11.a();
    L6:
        if ((r10 instanceof h) == true) goto L8;
        r10 = new h(this, r10);
    L8:
        AppCompatCallback r12 = this.f314n;
        if (r12 != null) goto L11;
    L14:
        ActionMode r13 = null;
    L15:
        if (r13 == null) goto L17;
        this.f321u = r13;
    L47:
        ActionMode r14 = this.f321u;
        if (r14 == null) goto L52;
        AppCompatCallback r15 = this.f314n;
        if (r15 == null) goto L52;
        r15.onSupportActionModeStarted(r14);
    L52:
        a1();
        return this.f321u;
    L17:
        boolean r16 = true;
        if (this.f322v != null) goto L30;
        if (this.f300J == false) goto L26;
        TypedValue r17 = new TypedValue();
        Resources.Theme r18 = this.f311k.getTheme();
        r18.resolveAttribute(R$attr.actionBarTheme, r17, true);
        if (r17.resourceId == 0) goto L24;
        Resources.Theme r19 = this.f311k.getResources().newTheme();
        r19.setTo(r18);
        r19.applyStyle(r17.resourceId, true);
        Context r20 = new g.b(this.f311k, 0);
        r20.getTheme().setTo(r19);
    L25:
        this.f322v = new ActionBarContextView(r20);
        PopupWindow r21 = new PopupWindow(r20, null, R$attr.actionModePopupWindowStyle);
        this.f323w = r21;
        androidx.core.widget.j.b(r21, 2);
        this.f323w.setContentView(this.f322v);
        this.f323w.setWidth(-1);
        r20.getTheme().resolveAttribute(R$attr.actionBarSize, r17, true);
        this.f322v.setContentHeight(TypedValue.complexToDimensionPixelSize(r17.data, r20.getResources().getDisplayMetrics()));
        this.f323w.setHeight(-2);
        this.f324x = new d(this);
        goto L30
    L24:
        r20 = this.f311k;
        goto L25
    L26:
        ViewStubCompat r22 = (ViewStubCompat) this.B.findViewById(R$id.action_mode_bar_stub);
        if (r22 == null) goto L30;
        r22.setLayoutInflater(LayoutInflater.from(l0()));
        this.f322v = (ActionBarContextView) r22.a();
    L30:
        if (this.f322v == null) goto L47;
        g0();
        this.f322v.k();
        Context r23 = this.f322v.getContext();
        ActionBarContextView r24 = this.f322v;
        if (this.f323w == null) goto L35;
        r16 = false;
    L35:
        androidx.appcompat.view.a r25 = new androidx.appcompat.view.a(r23, r24, r10, r16);
        if (r10.onCreateActionMode(r25, r25.c()) == false) goto L46;
        r25.i();
        this.f322v.h(r25);
        this.f321u = r25;
        if (R0() == false) goto L40;
        this.f322v.setAlpha(0.0f);
        androidx.core.view.r r26 = ViewCompat.e(this.f322v).b(1.0f);
        this.f325y = r26;
        r26.h(new e(this));
    L44:
        if (this.f323w == null) goto L47;
        this.f312l.getDecorView().post(this.f324x);
        goto L47
    L40:
        this.f322v.setAlpha(1.0f);
        this.f322v.setVisibility(0);
        if ((this.f322v.getParent() instanceof View) == false) goto L44;
        ViewCompat.m0((View) this.f322v.getParent());
        goto L44
    L46:
        this.f321u = null;
        goto L47
    L11:
        if (this.R == true) goto L14;
        r13 = r12.onWindowStartingSupportActionMode(r10);     // Catch: AbstractMethodError -> L54
        goto L15
    }

    public void W(MenuBuilder r10) {
        if (this.L == false) goto L5;
        return;
    L5:
        this.L = true;
        this.f318r.dismissPopups();
        Window.Callback r11 = s0();
        if (r11 != null) goto L8;
    L10:
        this.L = false;
        return;
    L8:
        if (this.R == true) goto L10;
        r11.onPanelClosed(108, r10);
        goto L10
    }

    public final void W0() {
        if (this.A == true) goto L6;
        return;
    L6:
        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    public final void X() {
        p r10 = this.X;
        if (r10 == null) goto L5;
        r10.a();
    L5:
        p r11 = this.Y;
        if (r11 == null) goto L9;
        r11.a();
        return;
    }

    public final AppCompatActivity X0() {
        Context r10 = this.f311k;
    L4:
        if (r10 == null) goto L12;
        if ((r10 instanceof AppCompatActivity) == true) goto L8;
        if ((r10 instanceof ContextWrapper) == false) goto L12;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L4
    L8:
        return (AppCompatActivity) r10;
    L12:
        return null;
    }

    public void Y(int r10) {
        Z(q0(r10, true), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y0(Configuration r10) {
        Activity r11 = (Activity) this.f310j;
        if ((r11 instanceof LifecycleOwner) == false) goto L8;
        if (((LifecycleOwner) r11).getLifecycle().b().isAtLeast(Lifecycle.State.CREATED) == false) goto L13;
        r11.onConfigurationChanged(r10);
        return;
    L13:
        return;
    L8:
        if (this.Q == true) goto L10;
        return;
    L10:
        if (this.R == true) goto L16;
        r11.onConfigurationChanged(r10);
        return;
    }

    public void Z(PanelFeatureState r10, boolean r11) {
        if (r11 == true) goto L4;
    L11:
        WindowManager r12 = (WindowManager) this.f311k.getSystemService("window");
        if (r12 != null) goto L14;
    L20:
        r10.f339m = false;
        r10.f340n = false;
        r10.f341o = false;
        r10.f334h = null;
        r10.f343q = true;
        if (this.N != r10) goto L24;
        this.N = null;
    L24:
        if (r10.f327a != 0) goto L27;
        a1();
        return;
    L27:
        return;
    L14:
        if (r10.f341o == false) goto L20;
        ViewGroup r13 = r10.f333g;
        if (r13 == null) goto L20;
        r12.removeView(r13);
        if (r11 == false) goto L20;
        V(r10.f327a, r10, null);
        goto L20
    L4:
        if (r10.f327a != 0) goto L11;
        DecorContentParent r14 = this.f318r;
        if (r14 == null) goto L11;
        if (r14.isOverflowMenuShowing() == false) goto L11;
        W(r10.f336j);
    }

    public final boolean Z0(int r10, androidx.core.os.e r11, boolean r12) {
        Configuration r13 = a0(this.f311k, r10, r11, null, false);
        int r14 = m0(this.f311k);
        Configuration r15 = this.S;
        if (r15 != null) goto L5;
        r15 = this.f311k.getResources().getConfiguration();
    L5:
        int r16 = r15.uiMode & 48;
        int r17 = r13.uiMode & 48;
        androidx.core.os.e r18 = p0(r15);
        if (r11 != null) goto L8;
        androidx.core.os.e r19 = null;
    L9:
        boolean r20 = false;
        if (r16 == r17) goto L12;
        int r21 = 512;
    L13:
        if (r19 != null) goto L15;
    L17:
        boolean r22 = true;
        if (((~r14) & r21) == 0) goto L31;
        if (r12 == false) goto L31;
        if (this.P == false) goto L31;
        if (f298m0 == false) goto L25;
    L26:
        Object r110 = this.f310j;
        if ((r110 instanceof Activity) == false) goto L31;
        if (((Activity) r110).isChild() == true) goto L31;
        ActivityCompat.p((Activity) this.f310j);
        boolean r111 = true;
    L32:
        if (r111 == true) goto L38;
        if (r21 == 0) goto L38;
        if ((r21 & r14) != r21) goto L37;
        r20 = true;
    L37:
        b1(r17, r19, r20, null);
    L39:
        if (r22 == false) goto L48;
        Object r112 = this.f310j;
        if ((r112 instanceof AppCompatActivity) == false) goto L48;
        if ((r21 & 512) == 0) goto L46;
        ((AppCompatActivity) r112).y(r10);
    L46:
        if ((r21 & 4) == 0) goto L48;
        ((AppCompatActivity) this.f310j).x(r11);
    L48:
        if (r22 == false) goto L51;
        if (r19 == null) goto L51;
        Q0(p0(this.f311k.getResources().getConfiguration()));
    L51:
        return r22;
    L38:
        r22 = r111;
        goto L39
    L25:
        if (this.Q == true) goto L26;
    L31:
        r111 = false;
        goto L32
    L15:
        if (r18.equals(r19) == true) goto L17;
        r21 = r21 | 8196;
        goto L17
    L12:
        r21 = 0;
        goto L13
    L8:
        r19 = p0(r13);
        goto L9
    }

    public final Configuration a0(Context r10, int r11, androidx.core.os.e r12, Configuration r13, boolean r14) {
        if (r11 != 1) goto L5;
        int r15 = 16;
    L11:
        Configuration r16 = new Configuration();
        r16.fontScale = 0.0f;
        if (r13 == null) goto L14;
        r16.setTo(r13);
    L14:
        r16.uiMode = r15 | (r16.uiMode & (-49));
        if (r12 == null) goto L17;
        P0(r16, r12);
    L17:
        return r16;
    L5:
        if (r11 == 2) goto L9;
        if (r14 == false) goto L8;
        r15 = 0;
        goto L11
    L8:
        r15 = r10.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        goto L11
    L9:
        r15 = 32;
        goto L11
    }

    public void a1() {
        if (Build.VERSION.SDK_INT < 33) goto L14;
        boolean r10 = T0();
        if (r10 == true) goto L7;
    L9:
        if (r10 == true) goto L16;
        OnBackInvokedCallback r11 = this.f309i0;
        if (r11 == null) goto L17;
        m.c(this.f308h0, r11);
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if (this.f309i0 != null) goto L9;
        this.f309i0 = m.b(this.f308h0, this);
        return;
    }

    public final ViewGroup b0() {
        TypedArray r10 = this.f311k.obtainStyledAttributes(R$styleable.AppCompatTheme);
        int r11 = R$styleable.AppCompatTheme_windowActionBar;
        if (r10.hasValue(r11) == true) goto L5;
        r10.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    L5:
        if (r10.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false) == false) goto L8;
        F(1);
    L11:
        if (r10.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false) == false) goto L14;
        F(109);
    L14:
        if (r10.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false) == false) goto L16;
        F(10);
    L16:
        this.f300J = r10.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
        r10.recycle();
        i0();
        this.f312l.getDecorView();
        LayoutInflater r12 = LayoutInflater.from(this.f311k);
        if (this.K == true) goto L38;
        if (this.f300J == false) goto L22;
        ViewGroup r13 = (ViewGroup) r12.inflate(R$layout.abc_dialog_title_material, null);
        this.H = false;
        this.G = false;
    L41:
        if (r13 == null) goto L56;
        ViewCompat.C0(r13, new b(this));
        if (this.f318r != null) goto L45;
        this.C = (TextView) r13.findViewById(R$id.title);
    L45:
        i0.c(r13);
        ContentFrameLayout r14 = (ContentFrameLayout) r13.findViewById(R$id.action_bar_activity_content);
        ViewGroup r15 = (ViewGroup) this.f312l.findViewById(R.id.content);
        if (r15 != null) goto L48;
    L53:
        this.f312l.setContentView(r13);
        r14.setAttachListener(new c(this));
        return r13;
    L48:
        if (r15.getChildCount() <= 0) goto L50;
        View r16 = r15.getChildAt(0);
        r15.removeViewAt(0);
        r14.addView(r16);
        goto L48
    L50:
        r15.setId(-1);
        r14.setId(R.id.content);
        if ((r15 instanceof FrameLayout) == false) goto L53;
        ((FrameLayout) r15).setForeground(null);
        goto L53
    L56:
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.G + ", windowActionBarOverlay: " + this.H + ", android:windowIsFloating: " + this.f300J + ", windowActionModeOverlay: " + this.I + ", windowNoTitle: " + this.K + " }");
    L22:
        if (this.G == false) goto L36;
        TypedValue r17 = new TypedValue();
        this.f311k.getTheme().resolveAttribute(R$attr.actionBarTheme, r17, true);
        if (r17.resourceId == 0) goto L26;
        Context r18 = new g.b(this.f311k, r17.resourceId);
    L27:
        r13 = (ViewGroup) LayoutInflater.from(r18).inflate(R$layout.abc_screen_toolbar, null);
        DecorContentParent r19 = (DecorContentParent) r13.findViewById(R$id.decor_content_parent);
        this.f318r = r19;
        r19.setWindowCallback(s0());
        if (this.H == false) goto L31;
        this.f318r.initFeature(109);
    L31:
        if (this.E == false) goto L34;
        this.f318r.initFeature(2);
    L34:
        if (this.F == false) goto L41;
        this.f318r.initFeature(5);
        goto L41
    L26:
        r18 = this.f311k;
        goto L27
    L36:
        r13 = null;
        goto L41
    L38:
        if (this.I == false) goto L40;
        r13 = (ViewGroup) r12.inflate(R$layout.abc_screen_simple_overlay_action_mode, null);
        goto L41
    L40:
        r13 = (ViewGroup) r12.inflate(R$layout.abc_screen_simple, null);
        goto L41
    L8:
        if (r10.getBoolean(r11, false) == false) goto L11;
        F(108);
        goto L11
    }

    public final void b1(int r10, androidx.core.os.e r11, boolean r12, Configuration r13) {
        Resources r14 = this.f311k.getResources();
        Configuration r15 = new Configuration(r14.getConfiguration());
        if (r13 == null) goto L5;
        r15.updateFrom(r13);
    L5:
        r15.uiMode = r10 | (r14.getConfiguration().uiMode & (-49));
        if (r11 == null) goto L8;
        P0(r15, r11);
    L8:
        r14.updateConfiguration(r15, null);
        int r16 = this.U;
        if (r16 == 0) goto L11;
        this.f311k.setTheme(r16);
        this.f311k.getTheme().applyStyle(this.U, true);
    L11:
        if (r12 == true) goto L13;
        return;
    L13:
        if ((this.f310j instanceof Activity) == false) goto L17;
        Y0(r15);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void c(View r10, ViewGroup.LayoutParams r11) {
        h0();
        ((ViewGroup) this.B.findViewById(R.id.content)).addView(r10, r11);
        this.f313m.c(this.f312l.getCallback());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View c0(View r11, String r12, Context r13, AttributeSet r14) {
        if (this.f306f0 != null) goto L11;
        String r10 = this.f311k.obtainStyledAttributes(R$styleable.AppCompatTheme).getString(R$styleable.AppCompatTheme_viewInflaterClass);
        if (r10 != null) goto L28;
        this.f306f0 = new androidx.appcompat.app.g();
        goto L11
    L28:
        this.f306f0 = (androidx.appcompat.app.g) this.f311k.getClassLoader().loadClass(r10).getDeclaredConstructor(null).newInstance(null);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + r10 + ". Falling back to default.", th);
        this.f306f0 = new androidx.appcompat.app.g();
    L11:
        boolean r15 = f296k0;
        boolean r16 = false;
        if (r15 == true) goto L14;
    L25:
        boolean r17 = r16;
    L27:
        return this.f306f0.createView(r11, r12, r13, r14, r17, r15, true, h0.c());
    L14:
        if (this.f307g0 != null) goto L17;
        this.f307g0 = new androidx.appcompat.app.j();
    L17:
        if (this.f307g0.a(r14) == false) goto L20;
        r17 = true;
        goto L27
    L20:
        if ((r14 instanceof XmlPullParser) == true) goto L22;
        r16 = S0((ViewParent) r11);
        goto L25
    L22:
        if (((XmlPullParser) r14).getDepth() <= 1) goto L25;
        r16 = true;
        goto L25
    }

    public final int c1(WindowInsetsCompat r11, Rect r12) {
        int r10 = 0;
        if (r11 == null) goto L5;
        int r13 = r11.m();
    L8:
        ActionBarContextView r14 = this.f322v;
        if (r14 != null) goto L11;
    L69:
        boolean r15 = false;
    L70:
        View r16 = this.D;
        if (r16 == null) goto L76;
        if (r15 == true) goto L75;
        r10 = 8;
    L75:
        r16.setVisibility(r10);
    L76:
        return r13;
    L11:
        if ((r14.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L69;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) this.f322v.getLayoutParams();
        boolean r18 = true;
        if (this.f322v.isShown() == false) goto L64;
        if (this.f304d0 != null) goto L17;
        this.f304d0 = new Rect();
        this.f305e0 = new Rect();
    L17:
        Rect r19 = this.f304d0;
        Rect r20 = this.f305e0;
        if (r11 != null) goto L20;
        r19.set(r12);
    L21:
        i0.a(this.B, r19, r20);
        int r110 = r19.top;
        int r111 = r19.left;
        int r21 = r19.right;
        WindowInsetsCompat r22 = ViewCompat.H(this.B);
        if (r22 != null) goto L24;
        int r23 = 0;
    L25:
        if (r22 != null) goto L27;
        int r24 = 0;
    L29:
        if (r17.topMargin == r110) goto L31;
    L36:
        r17.topMargin = r110;
        r17.leftMargin = r111;
        r17.rightMargin = r21;
        boolean r112 = true;
    L37:
        if (r110 > 0) goto L39;
    L41:
        View r113 = this.D;
        if (r113 == null) goto L50;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113.getLayoutParams();
        int r25 = r114.height;
        int r26 = r17.topMargin;
        if (r25 == r26) goto L46;
    L49:
        r114.height = r26;
        r114.leftMargin = r23;
        r114.rightMargin = r24;
        this.D.setLayoutParams(r114);
        goto L50
    L46:
        if (r114.leftMargin != r23) goto L49;
        if (r114.rightMargin != r24) goto L49;
    L50:
        View r115 = this.D;
        if (r115 != null) goto L54;
        r18 = false;
    L54:
        if (r18 == false) goto L59;
        if (r115.getVisibility() == 0) goto L59;
        d1(this.D);
    L59:
        if (this.I == true) goto L62;
        if (r18 == false) goto L62;
        r13 = 0;
    L62:
        r15 = r18;
        r18 = r112;
    L67:
        if (r18 == false) goto L70;
        this.f322v.setLayoutParams(r17);
        goto L70
    L39:
        if (this.D != null) goto L41;
        View r116 = new View(this.f311k);
        this.D = r116;
        r116.setVisibility(8);
        FrameLayout.LayoutParams r117 = new FrameLayout.LayoutParams(-1, r17.topMargin, 51);
        r117.leftMargin = r23;
        r117.rightMargin = r24;
        this.B.addView(this.D, -1, r117);
        goto L50
    L31:
        if (r17.leftMargin != r111) goto L36;
        if (r17.rightMargin != r21) goto L36;
        r112 = false;
        goto L37
    L27:
        r24 = r22.l();
        goto L29
    L24:
        r23 = r22.k();
        goto L25
    L20:
        r19.set(r11.k(), r11.m(), r11.l(), r11.j());
        goto L21
    L64:
        if (r17.topMargin == 0) goto L66;
        r17.topMargin = 0;
        r15 = false;
        goto L67
    L66:
        r15 = false;
        r18 = false;
        goto L67
    L5:
        if (r12 == null) goto L7;
        r13 = r12.top;
        goto L8
    L7:
        r13 = 0;
        goto L8
    }

    public void d0() {
        DecorContentParent r10 = this.f318r;
        if (r10 == null) goto L6;
        r10.dismissPopups();
    L6:
        if (this.f323w == null) goto L11;
        this.f312l.getDecorView().removeCallbacks(this.f324x);
        if (this.f323w.isShowing() == true) goto L18;
    L10:
        this.f323w = null;
        goto L11
    L18:
        this.f323w.dismiss();     // Catch: IllegalArgumentException -> L17
    L11:
        g0();
        PanelFeatureState r11 = q0(0, false);
        if (r11 == null) goto L20;
        MenuBuilder r12 = r11.f336j;
        if (r12 == null) goto L21;
        r12.close();
        return;
    L21:
        return;
    }

    public final void d1(View r10) {
        if ((ViewCompat.L(r10) & 8192) == 0) goto L5;
        int r11 = ContextCompat.b(this.f311k, R$color.abc_decor_view_status_guard_light);
    L6:
        r10.setBackgroundColor(r11);
        return;
    L5:
        r11 = ContextCompat.b(this.f311k, R$color.abc_decor_view_status_guard);
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public Context e(Context r10) {
        this.P = true;
        int r11 = z0(r10, U());
        if (AppCompatDelegate.t(r10) == false) goto L5;
        AppCompatDelegate.N(r10);
    L5:
        androidx.core.os.e r12 = T(r10);
        if (f299n0 == false) goto L13;
        if ((r10 instanceof ContextThemeWrapper) == false) goto L13;
        r.a((ContextThemeWrapper) r10, a0(r10, r11, r12, null, false));     // Catch: IllegalStateException -> L32
        return r10;
    L13:
        if ((r10 instanceof g.b) == false) goto L18;
        ((g.b) r10).a(a0(r10, r11, r12, null, false));     // Catch: IllegalStateException -> L33
        return r10;
    L18:
        if (f298m0 == false) goto L20;
        Configuration r13 = new Configuration();
        r13.uiMode = -1;
        r13.fontScale = 0.0f;
        Configuration r14 = i.a(r10, r13).getResources().getConfiguration();
        Configuration r15 = r10.getResources().getConfiguration();
        r14.uiMode = r15.uiMode;
        if (r14.equals(r15) == true) goto L25;
        Configuration r16 = k0(r14, r15);
    L26:
        Configuration r17 = a0(r10, r11, r12, r16, true);
        g.b r18 = new g.b(r10, R$style.Theme_AppCompat_Empty);
        r18.a(r17);
        if (r10.getTheme() == null) goto L31;
        androidx.core.content.res.a.f.a(r18.getTheme());
    L31:
        return super.e(r18);
    L25:
        r16 = null;
        goto L26
    L20:
        return super.e(r10);
    }

    public boolean e0(KeyEvent r10) {
        Object r11 = this.f310j;
        if ((r11 instanceof KeyEventDispatcher.Component) == false) goto L5;
    L6:
        View r12 = this.f312l.getDecorView();
        if (r12 != null) goto L9;
    L12:
        if (r10.getKeyCode() == 82) goto L14;
    L16:
        int r13 = r10.getKeyCode();
        if (r10.getAction() != 0) goto L20;
        return B0(r13, r10);
    L20:
        return E0(r13, r10);
    L14:
        if (this.f313m.b(this.f312l.getCallback(), r10) == false) goto L16;
        return true;
    L9:
        if (KeyEventDispatcher.a(r12, r10) == false) goto L12;
        return true;
    L5:
        if ((r11 instanceof androidx.appcompat.app.e) == false) goto L12;
        goto L6
    }

    public void f0(int r10) {
        PanelFeatureState r11 = q0(r10, true);
        if (r11.f336j == null) goto L8;
        Bundle r12 = new Bundle();
        r11.f336j.saveActionViewStates(r12);
        if (r12.size() <= 0) goto L7;
        r11.f345s = r12;
    L7:
        r11.f336j.stopDispatchingItemsChanged();
        r11.f336j.clear();
    L8:
        r11.f344r = true;
        r11.f343q = true;
        if (r10 == 108) goto L12;
        if (r10 == 0) goto L12;
        return;
    L12:
        if (this.f318r == null) goto L18;
        PanelFeatureState r13 = q0(0, false);
        if (r13 == null) goto L19;
        r13.f339m = false;
        M0(r13, null);
        return;
    L19:
        return;
    }

    public void g0() {
        androidx.core.view.r r10 = this.f325y;
        if (r10 == null) goto L6;
        r10.c();
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public View h(int r10) {
        h0();
        return this.f312l.findViewById(r10);
    }

    public final void h0() {
        if (this.A == true) goto L22;
        this.B = b0();
        CharSequence r10 = r0();
        if (TextUtils.isEmpty(r10) == true) goto L15;
        DecorContentParent r11 = this.f318r;
        if (r11 == null) goto L10;
        r11.setWindowTitle(r10);
        goto L15
    L10:
        if (K0() == null) goto L12;
        K0().p(r10);
        goto L15
    L12:
        TextView r12 = this.C;
        if (r12 == null) goto L15;
        r12.setText(r10);
    L15:
        R();
        I0(this.B);
        this.A = true;
        PanelFeatureState r13 = q0(0, false);
        if (this.R == true) goto L23;
        if (r13 != null) goto L19;
    L20:
        x0(108);
        return;
    L19:
        if (r13.f336j == null) goto L20;
        return;
    L23:
        return;
    }

    public final void i0() {
        if (this.f312l != null) goto L8;
        Object r10 = this.f310j;
        if ((r10 instanceof Activity) == false) goto L8;
        S(((Activity) r10).getWindow());
    L8:
        if (this.f312l == null) goto L11;
        return;
    L11:
        throw new IllegalStateException("We have not been given a Window");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public Context j() {
        return this.f311k;
    }

    public PanelFeatureState j0(Menu r10) {
        PanelFeatureState[] r11 = this.M;
        int r12 = 0;
        if (r11 == null) goto L5;
        int r13 = r11.length;
    L6:
        if (r12 >= r13) goto L13;
        PanelFeatureState r14 = r11[r12];
        if (r14 == null) goto L12;
        if (r14.f336j != r10) goto L12;
        return r14;
    L12:
        r12 = r12 + 1;
        goto L6
    L13:
        return null;
    L5:
        r13 = 0;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawerToggle$Delegate l() {
        return new f(this);
    }

    public final Context l0() {
        ActionBar r10 = q();
        if (r10 == null) goto L5;
        Context r11 = r10.e();
    L6:
        if (r11 == null) goto L8;
        return r11;
    L8:
        return this.f311k;
    L5:
        r11 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public int m() {
        return this.T;
    }

    public final int m0(Context r10) {
        if (this.W == false) goto L5;
    L15:
        this.W = true;
        return this.V;
    L5:
        if ((this.f310j instanceof Activity) == false) goto L15;
        PackageManager r11 = r10.getPackageManager();
        if (r11 != null) goto L17;
        return 0;
    L17:
        ActivityInfo r12 = r11.getActivityInfo(new ComponentName(r10, this.f310j.getClass()), 269221888);     // Catch: PackageManager.NameNotFoundException -> L13
        if (r12 == null) goto L15;
        this.V = r12.configChanges;     // Catch: PackageManager.NameNotFoundException -> L13
    L13:
        e = move-exception;
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
        this.V = 0;
        goto L15
    }

    public final p n0(Context r10) {
        if (this.Y != null) goto L6;
        this.Y = new o(this, r10);
    L6:
        return this.Y;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public MenuInflater o() {
        if (this.f316p != null) goto L10;
        t0();
        ActionBar r10 = this.f315o;
        if (r10 == null) goto L7;
        Context r11 = r10.e();
    L8:
        this.f316p = new g.c(r11);
        goto L10
    L7:
        r11 = this.f311k;
    L10:
        return this.f316p;
    }

    public final p o0(Context r10) {
        if (this.X != null) goto L6;
        this.X = new q(this, androidx.appcompat.app.m.a(r10));
    L6:
        return this.X;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View r10, String r11, Context r12, AttributeSet r13) {
        return c0(r10, r11, r12, r13);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder r10, MenuItem r11) {
        Window.Callback r12 = s0();
        if (r12 != null) goto L5;
        return false;
    L5:
        if (this.R == true) goto L12;
        PanelFeatureState r13 = j0(r10.getRootMenu());
        if (r13 != null) goto L9;
        return false;
    L9:
        return r12.onMenuItemSelected(r13.f327a, r11);
    L12:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder r10) {
        N0(true);
    }

    public androidx.core.os.e p0(Configuration r10) {
        return k.b(r10);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public ActionBar q() {
        t0();
        return this.f315o;
    }

    public PanelFeatureState q0(int r10, boolean r11) {
        PanelFeatureState[] r12 = this.M;
        if (r12 != null) goto L5;
    L6:
        PanelFeatureState[] r13 = new PanelFeatureState[r10 + 1];
        if (r12 == null) goto L9;
        System.arraycopy(r12, 0, r13, 0, r12.length);
    L9:
        this.M = r13;
        r12 = r13;
    L10:
        PanelFeatureState r14 = r12[r10];
        if (r14 != null) goto L14;
        PanelFeatureState r15 = new PanelFeatureState(r10);
        r12[r10] = r15;
        return r15;
    L14:
        return r14;
    L5:
        if (r12.length > r10) goto L10;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void r() {
        LayoutInflater r10 = LayoutInflater.from(this.f311k);
        if (r10.getFactory() != null) goto L6;
        androidx.core.view.d.a(r10, this);
        return;
    L6:
        if ((r10.getFactory2() instanceof AppCompatDelegateImpl) == true) goto L10;
        Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        return;
    }

    public final CharSequence r0() {
        Object r10 = this.f310j;
        if ((r10 instanceof Activity) == false) goto L7;
        return ((Activity) r10).getTitle();
    L7:
        return this.f317q;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void s() {
        if (K0() != null) goto L5;
        return;
    L5:
        if (q().f() == true) goto L10;
        x0(0);
        return;
    }

    public final Window.Callback s0() {
        return this.f312l.getCallback();
    }

    public final void t0() {
        h0();
        if (this.G == true) goto L5;
        return;
    L5:
        if (this.f315o != null) goto L19;
        Object r10 = this.f310j;
        if ((r10 instanceof Activity) == false) goto L11;
        this.f315o = new androidx.appcompat.app.n((Activity) this.f310j, this.H);
    L13:
        ActionBar r11 = this.f315o;
        if (r11 == null) goto L18;
        r11.l(this.f303c0);
        return;
    L18:
        return;
    L11:
        if ((r10 instanceof Dialog) == false) goto L13;
        this.f315o = new androidx.appcompat.app.n((Dialog) this.f310j);
        goto L13
    }

    public final boolean u0(PanelFeatureState r10) {
        View r11 = r10.f335i;
        if (r11 == null) goto L7;
        r10.f334h = r11;
        return true;
    L7:
        if (r10.f336j != null) goto L10;
        return false;
    L10:
        if (this.f320t != null) goto L12;
        this.f320t = new t(this);
    L12:
        View r12 = (View) r10.a(this.f320t);
        r10.f334h = r12;
        if (r12 == null) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void v(Configuration r10) {
        if (this.G == true) goto L5;
    L9:
        androidx.appcompat.widget.f.b().g(this.f311k);
        this.S = new Configuration(this.f311k.getResources().getConfiguration());
        P(false, false);
        return;
    L5:
        if (this.A == false) goto L9;
        ActionBar r11 = q();
        if (r11 == null) goto L9;
        r11.g(r10);
        goto L9
    }

    public final boolean v0(PanelFeatureState r10) {
        r10.d(l0());
        r10.f333g = new s(this, r10.f338l);
        r10.f329c = 81;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void w(Bundle r10) {
        this.P = true;
        O(false);
        i0();
        Object r11 = this.f310j;
        if ((r11 instanceof Activity) == true) goto L15;
    L13:
        this.S = new Configuration(this.f311k.getResources().getConfiguration());
        this.Q = true;
        return;
    L15:
        String r12 = androidx.core.app.f.c((Activity) r11);     // Catch: IllegalArgumentException -> L6
    L7:
        if (r12 == null) goto L12;
        ActionBar r13 = K0();
        if (r13 != null) goto L11;
        this.f303c0 = true;
        goto L12
    L11:
        r13.l(true);
    L12:
        AppCompatDelegate.b(this);
    L6:
        r12 = null;
        goto L7
    }

    public final boolean w0(PanelFeatureState r10) {
        Context r11 = this.f311k;
        int r12 = r10.f327a;
        if (r12 == 0) goto L7;
        if (r12 == 108) goto L7;
    L19:
        MenuBuilder r13 = new MenuBuilder(r11);
        r13.setCallback(this);
        r10.c(r13);
        return true;
    L7:
        if (this.f318r == null) goto L19;
        TypedValue r14 = new TypedValue();
        Resources.Theme r15 = r11.getTheme();
        r15.resolveAttribute(R$attr.actionBarTheme, r14, true);
        if (r14.resourceId == 0) goto L11;
        Resources.Theme r16 = r11.getResources().newTheme();
        r16.setTo(r15);
        r16.applyStyle(r14.resourceId, true);
        r16.resolveAttribute(R$attr.actionBarWidgetTheme, r14, true);
    L13:
        if (r14.resourceId == 0) goto L17;
        if (r16 != null) goto L16;
        r16 = r11.getResources().newTheme();
        r16.setTo(r15);
    L16:
        r16.applyStyle(r14.resourceId, true);
    L17:
        if (r16 == null) goto L19;
        g.b r17 = new g.b(r11, 0);
        r17.getTheme().setTo(r16);
        r11 = r17;
        goto L19
    L11:
        r15.resolveAttribute(R$attr.actionBarWidgetTheme, r14, true);
        r16 = null;
        goto L13
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void x() {
        if ((this.f310j instanceof Activity) == false) goto L6;
        AppCompatDelegate.D(this);
    L6:
        if (this.Z == false) goto L8;
        this.f312l.getDecorView().removeCallbacks(this.f302b0);
    L8:
        this.R = true;
        if (this.T == (-100)) goto L15;
        Object r10 = this.f310j;
        if ((r10 instanceof Activity) == false) goto L15;
        if (((Activity) r10).isChangingConfigurations() == false) goto L15;
        f295j0.put(this.f310j.getClass().getName(), Integer.valueOf(this.T));
    L16:
        ActionBar r11 = this.f315o;
        if (r11 == null) goto L19;
        r11.h();
    L19:
        X();
        return;
    L15:
        f295j0.remove(this.f310j.getClass().getName());
        goto L16
    }

    public final void x0(int r10) {
        int r11 = 1 << r10;
        this.f301a0 = r11 | this.f301a0;
        if (this.Z == true) goto L6;
        ViewCompat.h0(this.f312l.getDecorView(), this.f302b0);
        this.Z = true;
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void y(Bundle r10) {
        h0();
    }

    public boolean y0() {
        return this.f326z;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public void z() {
        ActionBar r10 = q();
        if (r10 == null) goto L6;
        r10.o(true);
        return;
    }

    public int z0(Context r10, int r11) {
        if (r11 == (-100)) goto L22;
        if (r11 == (-1)) goto L21;
        if (r11 == 0) goto L17;
        if (r11 == 1) goto L21;
        if (r11 == 2) goto L21;
        if (r11 != 3) goto L15;
        return n0(r10).c();
    L15:
        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
    L17:
        if (((UiModeManager) r10.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) goto L20;
        return -1;
    L20:
        return o0(r10).c();
    L21:
        return r11;
    L22:
        return -1;
    }

    public AppCompatDelegateImpl(Dialog r10, AppCompatCallback r11) {
        this(r10.getContext(), r10.getWindow(), r11, r10);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r10, Context r11, AttributeSet r12) {
        return onCreateView(null, r10, r11, r12);
    }

    public AppCompatDelegateImpl(Context r10, Window r11, AppCompatCallback r12, Object r13) {
        this.f325y = null;
        this.f326z = true;
        this.T = -100;
        this.f302b0 = new a(this);
        this.f311k = r10;
        this.f314n = r12;
        this.f310j = r13;
        if (this.T != (-100)) goto L10;
        if ((r13 instanceof Dialog) == false) goto L10;
        AppCompatActivity r14 = X0();
        if (r14 == null) goto L10;
        this.T = r14.s().m();
    L10:
        if (this.T != (-100)) goto L14;
        SimpleArrayMap r15 = f295j0;
        Integer r16 = (Integer) r15.get(r13.getClass().getName());
        if (r16 == null) goto L14;
        this.T = r16.intValue();
        r15.remove(r13.getClass().getName());
    L14:
        if (r11 == null) goto L16;
        S(r11);
    L16:
        androidx.appcompat.widget.f.h();
    }
}
