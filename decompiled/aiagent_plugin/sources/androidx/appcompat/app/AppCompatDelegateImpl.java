package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
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
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
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
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.r;
import androidx.appcompat.widget.y;
import androidx.core.app.ActivityCompat;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ae;
import androidx.core.view.al;
import androidx.lifecycle.p;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class AppCompatDelegateImpl extends androidx.appcompat.app.c implements LayoutInflater.Factory2, MenuBuilder.a {
    static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    private static final boolean IS_PRE_LOLLIPOP = false;
    private static final boolean sCanApplyOverrideConfiguration = false;
    private static final boolean sCanReturnDifferentContext = false;
    private static boolean sInstalledExceptionHandler;
    private static final androidx.b.g<String, Integer> sLocalNightModes = null;
    private static final int[] sWindowBackgroundStyleable = null;
    ActionBar mActionBar;
    private c mActionMenuPresenterCallback;
    androidx.appcompat.view.b mActionMode;
    PopupWindow mActionModePopup;
    ActionBarContextView mActionModeView;
    private int mActivityHandlesConfigFlags;
    private boolean mActivityHandlesConfigFlagsChecked;
    final androidx.appcompat.app.b mAppCompatCallback;
    private AppCompatViewInflater mAppCompatViewInflater;
    private AppCompatWindowCallback mAppCompatWindowCallback;
    private k mAutoBatteryNightModeManager;
    private k mAutoTimeNightModeManager;
    private OnBackInvokedCallback mBackCallback;
    private boolean mBaseContextAttached;
    private boolean mClosingActionMenu;
    final Context mContext;
    private boolean mCreated;
    private o mDecorContentParent;
    boolean mDestroyed;
    private OnBackInvokedDispatcher mDispatcher;
    private Configuration mEffectiveConfiguration;
    private boolean mEnableDefaultActionBarUp;
    ae mFadeAnim;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private boolean mHandleNativeActionModes;
    boolean mHasActionBar;
    final Object mHost;
    int mInvalidatePanelMenuFeatures;
    boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable;
    boolean mIsFloating;
    private androidx.appcompat.app.e mLayoutIncludeDetector;
    private int mLocalNightMode;
    private boolean mLongPressBackDown;
    MenuInflater mMenuInflater;
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    private n mPanelMenuPresenterCallback;
    private PanelFeatureState[] mPanels;
    private PanelFeatureState mPreparedPanel;
    Runnable mShowActionModePopup;
    private View mStatusGuard;
    ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private int mThemeResId;
    private CharSequence mTitle;
    private TextView mTitleView;
    Window mWindow;
    boolean mWindowNoTitle;

    class AppCompatWindowCallback extends WindowCallbackWrapper {
        private b mActionBarCallback;
        private boolean mDispatchKeyEventBypassEnabled;
        private boolean mOnContentChangedBypassEnabled;
        private boolean mOnPanelClosedBypassEnabled;
        final /* synthetic */ AppCompatDelegateImpl this$0;

        AppCompatWindowCallback(AppCompatDelegateImpl r3, Window.Callback r4) {
            Window.Callback r5 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r4, Window.Callback.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        void setActionBarCallback(b r3) {
            this.mActionBarCallback = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent r2) {
            if (this.mDispatchKeyEventBypassEnabled == false) goto L7;
            return getWrapped().dispatchKeyEvent(r2);
        L7:
            if (this.this$0.dispatchKeyEvent(r2) == false) goto L9;
        L12:
            return true;
        L9:
            if (super.dispatchKeyEvent(r2) == true) goto L12;
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent r2) {
            if (super.dispatchKeyShortcutEvent(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (this.this$0.onKeyShortcut(r2.getKeyCode(), r2) == true) goto L8;
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onCreatePanelMenu(int r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
            if (r3 != 0) goto L9;
            if (ZeusTransformUtils.instanceOf(r5, MenuBuilder.class) == true) goto L9;
            return false;
        L9:
            return super.onCreatePanelMenu(r3, r5);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int r2) {
            b r0 = this.mActionBarCallback;
            if (r0 == null) goto L8;
            View r1 = r0.b(r2);
            if (r1 == null) goto L8;
            return r1;
        L8:
            return super.onCreatePanelView(r2);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onContentChanged() {
            if (this.mOnContentChangedBypassEnabled == false) goto L6;
            getWrapped().onContentChanged();
            return;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int r5, View r6, Menu r7) {
            Menu r8 = (Menu) ZeusTransformUtils.wrapperContextForParams(r7, Menu.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r8, MenuBuilder.class) == false) goto L5;
            MenuBuilder r0 = (MenuBuilder) ZeusTransformUtils.preCheckCast(r8, MenuBuilder.class, "com.obric.aiagent.plugin");
        L7:
            if (r5 != 0) goto L10;
            if (r0 != null) goto L10;
            return false;
        L10:
            boolean r2 = true;
            if (r0 == null) goto L13;
            r0.setOverrideVisibleItems(true);
        L13:
            b r3 = this.mActionBarCallback;
            if (r3 != null) goto L16;
        L18:
            r2 = false;
        L19:
            if (r2 == true) goto L21;
            r2 = super.onPreparePanel(r5, r6, r8);
        L21:
            if (r0 == null) goto L23;
            r0.setOverrideVisibleItems(false);
        L23:
            return r2;
        L16:
            if (r3.a(r5) == false) goto L18;
        L5:
            r0 = null;
            goto L7
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onMenuOpened(int r3, Menu r4) {
            super.onMenuOpened(r3, (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin"));
            this.this$0.onMenuOpened(r3);
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onPanelClosed(int r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
            if (this.mOnPanelClosedBypassEnabled == false) goto L6;
            getWrapped().onPanelClosed(r3, r5);
            return;
        L6:
            super.onPanelClosed(r3, r5);
            this.this$0.onPanelClosed(r3);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback r3) {
            ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin");
            if (Build.VERSION.SDK_INT < 23) goto L7;
            return null;
        L7:
            if (this.this$0.isHandleNativeActionModesEnabled() == false) goto L11;
            return startAsSupportActionMode(r4);
        L11:
            return super.onWindowStartingActionMode(r4);
        }

        final ActionMode startAsSupportActionMode(ActionMode.Callback r3) {
            ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin");
            SupportActionModeWrapper.a r0 = new SupportActionModeWrapper.a(this.this$0.mContext, r4);
            androidx.appcompat.view.b r2 = this.this$0.startSupportActionMode(r0);
            if (r2 != null) goto L5;
            return null;
        L5:
            return r0.b(r2);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback r3, int r4) {
            ActionMode.Callback r5 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin");
            if (this.this$0.isHandleNativeActionModesEnabled() == false) goto L9;
            if (r4 != 0) goto L9;
            return startAsSupportActionMode(r5);
        L9:
            return super.onWindowStartingActionMode(r5, r4);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r4, Menu r5, int r6) {
            List<KeyboardShortcutGroup> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            Menu r8 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.aiagent.plugin");
            PanelFeatureState r0 = this.this$0.getPanelState(0, true);
            if (r0 != null) goto L5;
        L7:
            super.onProvideKeyboardShortcuts(r7, r8, r6);
            return;
        L5:
            if (r0.j == null) goto L7;
            super.onProvideKeyboardShortcuts(r7, r0.j, r6);
        }

        public void bypassOnContentChanged(Window.Callback r3) {
            Window.Callback r4 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Window.Callback.class, "com.obric.aiagent.plugin");
            this.mOnContentChangedBypassEnabled = true;     // Catch: Throwable -> L6
            r4.onContentChanged();     // Catch: Throwable -> L6
            this.mOnContentChangedBypassEnabled = false;
            return;
        L6:
            th = move-exception;
            this.mOnContentChangedBypassEnabled = false;
            throw th;
        }

        public boolean bypassDispatchKeyEvent(Window.Callback r3, KeyEvent r4) {
            Window.Callback r5 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Window.Callback.class, "com.obric.aiagent.plugin");
            this.mDispatchKeyEventBypassEnabled = true;     // Catch: Throwable -> L6
            boolean r6 = r5.dispatchKeyEvent(r4);     // Catch: Throwable -> L6
            this.mDispatchKeyEventBypassEnabled = false;
            return r6;
        L6:
            th = move-exception;
            this.mDispatchKeyEventBypassEnabled = false;
            throw th;
        }

        public void bypassOnPanelClosed(Window.Callback r3, int r4, Menu r5) {
            Window.Callback r6 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Window.Callback.class, "com.obric.aiagent.plugin");
            Menu r7 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.aiagent.plugin");
            this.mOnPanelClosedBypassEnabled = true;     // Catch: Throwable -> L6
            r6.onPanelClosed(r4, r7);     // Catch: Throwable -> L6
            this.mOnPanelClosedBypassEnabled = false;
            return;
        L6:
            th = move-exception;
            this.mOnPanelClosedBypassEnabled = false;
            throw th;
        }
    }

    private class ListMenuDecorView extends ContentFrameLayout {
        final /* synthetic */ AppCompatDelegateImpl this$0;

        public ListMenuDecorView(AppCompatDelegateImpl r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent r2) {
            if (this.this$0.dispatchKeyEvent(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (super.dispatchKeyEvent(r2) == true) goto L8;
            return false;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent r3) {
            if (r3.getAction() != 0) goto L9;
            if (isOutOfBounds((int) r3.getX(), (int) r3.getY()) == false) goto L9;
            this.this$0.closePanel(0);
            return true;
        L9:
            return super.onInterceptTouchEvent(r3);
        }

        @Override // android.view.View
        public void setBackgroundResource(int r4) {
            setBackgroundDrawable(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
        }

        private boolean isOutOfBounds(int r2, int r3) {
            if (r2 < (-5)) goto L11;
            if (r3 < (-5)) goto L11;
            if (r2 > (getWidth() + 5)) goto L11;
            if (r3 > (getHeight() + 5)) goto L11;
            return false;
        L11:
            return true;
        }
    }

    protected static final class PanelFeatureState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f217d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f218e;
        int f;
        ViewGroup g;
        View h;
        View i;
        MenuBuilder j;
        ListMenuPresenter k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q;
        boolean r;
        Bundle s;

        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = null;
            int featureId;
            boolean isOpen;
            Bundle menuState;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            SavedState() {
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel r1, int r2) {
                r1.writeInt(this.featureId);
                r1.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen == false) goto L6;
                r1.writeBundle(this.menuState);
                return;
            }

            static SavedState readFromParcel(Parcel r3, ClassLoader r4) {
                SavedState r0 = new SavedState();
                r0.featureId = r3.readInt();
                boolean r2 = true;
                if (r3.readInt() == 1) goto L6;
                r2 = false;
            L6:
                r0.isOpen = r2;
                if (r2 == false) goto L9;
                r0.menuState = r3.readBundle(r4);
            L9:
                return r0;
            }

            static {
                CREATOR = new AnonymousClass1();
            }
        }

        PanelFeatureState(int r1) {
            this.f214a = r1;
            this.q = false;
        }

        public boolean a() {
            if (this.h != null) goto L6;
            return false;
        L6:
            if (this.i == null) goto L9;
            return true;
        L9:
            if (this.k.getAdapter().getCount() > 0) goto L11;
            return false;
        L11:
            return true;
        }

        void a(Context r8) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            TypedValue r0 = new TypedValue();
            Resources.Theme r2 = ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin").newTheme();
            r2.setTo(r9.getTheme());
            r2.resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarPopupTheme, "attr", "actionBarPopupTheme"), r0, true);
            if (r0.resourceId == 0) goto L5;
            r2.applyStyle(r0.resourceId, true);
        L5:
            r2.resolveAttribute(ZeusTransformUtils.mapRes(R.attr.panelMenuListTheme, "attr", "panelMenuListTheme"), r0, true);
            if (r0.resourceId == 0) goto L8;
            r2.applyStyle(r0.resourceId, true);
        L9:
            ContextThemeWrapper r1 = new ContextThemeWrapper(r9, 0);
            r1.getTheme().setTo(r2);
            this.l = ZeusTransformUtils.wrapperContext(r1, "com.obric.aiagent.plugin");
            TypedArray r10 = r1.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.f215b = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_panelBackground, "styleable", "AppCompatTheme_panelBackground"), 0);
            this.f = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_android_windowAnimationStyle, "styleable", "AppCompatTheme_android_windowAnimationStyle"), 0);
            r10.recycle();
            return;
        L8:
            r2.applyStyle(ZeusTransformUtils.mapRes(R.style.Theme_AppCompat_CompactMenu, "style", "Theme_AppCompat_CompactMenu"), true);
            goto L9
        }

        void a(MenuBuilder r3) {
            MenuBuilder r0 = this.j;
            if (r3 != r0) goto L5;
            return;
        L5:
            if (r0 == null) goto L7;
            r0.removeMenuPresenter(this.k);
        L7:
            this.j = r3;
            if (r3 == null) goto L13;
            ListMenuPresenter r2 = this.k;
            if (r2 == null) goto L14;
            r3.addMenuPresenter(r2);
            return;
        L14:
            return;
        }

        androidx.appcompat.view.menu.e a(androidx.appcompat.view.menu.d.a r6) {
            androidx.appcompat.view.menu.d.a r7 = (androidx.appcompat.view.menu.d.a) ZeusTransformUtils.wrapperContextForParams(r6, androidx.appcompat.view.menu.d.a.class, "com.obric.aiagent.plugin");
            if (this.j != null) goto L7;
            return null;
        L7:
            if (this.k != null) goto L10;
            ListMenuPresenter r0 = new ListMenuPresenter(this.l, ZeusTransformUtils.mapRes(R.layout.abc_list_menu_item_layout, "layout", "abc_list_menu_item_layout"));
            this.k = r0;
            r0.setCallback(r7);
            this.j.addMenuPresenter(this.k);
        L10:
            return this.k.getMenuView(this.g);
        }
    }

    private class a implements androidx.appcompat.app.a.InterfaceC0008a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppCompatDelegateImpl f219a;

        a(AppCompatDelegateImpl r1) {
            this.f219a = r1;
        }

        @Override // androidx.appcompat.app.a.InterfaceC0008a
        public void a(int r1) {
            ActionBar r0 = this.f219a.getSupportActionBar();
            if (r0 == null) goto L6;
            r0.a(r1);
            return;
        }
    }

    interface b {
        boolean a(int r1);

        View b(int r1);
    }

    private final class c implements androidx.appcompat.view.menu.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppCompatDelegateImpl f220a;

        c(AppCompatDelegateImpl r1) {
            this.f220a = r1;
        }

        @Override // androidx.appcompat.view.menu.d.a
        public boolean onOpenSubMenu(MenuBuilder r2) {
            Window.Callback r1 = this.f220a.getWindowCallback();
            if (r1 == null) goto L7;
            r1.onMenuOpened(108, r2);
            return true;
        L7:
            return true;
        }

        @Override // androidx.appcompat.view.menu.d.a
        public void onCloseMenu(MenuBuilder r1, boolean r2) {
            this.f220a.checkCloseActionMenu(r1);
        }
    }

    class d implements androidx.appcompat.view.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppCompatDelegateImpl f221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private androidx.appcompat.view.b.a f222b;

        public d(AppCompatDelegateImpl r3, androidx.appcompat.view.b.a r4) {
            androidx.appcompat.view.b.a r5 = (androidx.appcompat.view.b.a) ZeusTransformUtils.wrapperContextForParams(r4, androidx.appcompat.view.b.a.class, "com.obric.aiagent.plugin");
            this.f221a = r3;
            this.f222b = r5;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
            return this.f222b.a(r3, r5);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(androidx.appcompat.view.b r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
            ViewCompat.u(this.f221a.mSubDecor);
            return this.f222b.b(r3, r5);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b r3, MenuItem r4) {
            MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.aiagent.plugin");
            return this.f222b.a(r3, r5);
        }

        @Override // androidx.appcompat.view.b.a
        public void a(androidx.appcompat.view.b r3) {
            this.f222b.a(r3);
            if (this.f221a.mActionModePopup == null) goto L6;
            this.f221a.mWindow.getDecorView().removeCallbacks(this.f221a.mShowActionModePopup);
        L6:
            if (this.f221a.mActionModeView == null) goto L9;
            this.f221a.endOnGoingFadeAnimation();
            AppCompatDelegateImpl r4 = this.f221a;
            r4.mFadeAnim = ViewCompat.p(r4.mActionModeView).a(0.0f);
            this.f221a.mFadeAnim.a(new AnonymousClass1(this));
        L9:
            if (this.f221a.mAppCompatCallback == null) goto L11;
            this.f221a.mAppCompatCallback.onSupportActionModeFinished(this.f221a.mActionMode);
        L11:
            this.f221a.mActionMode = null;
            ViewCompat.u(this.f221a.mSubDecor);
            this.f221a.updateBackInvokedCallbackState();
        }
    }

    static class e {
        static void a(Configuration r1, Configuration r2, Configuration r3) {
            if (r1.densityDpi == r2.densityDpi) goto L6;
            r3.densityDpi = r2.densityDpi;
            return;
        }

        static Context a(Context r2, Configuration r3) {
            return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).createConfigurationContext(r3), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        }

        static void a(Configuration r0, Locale r1) {
            r0.setLayoutDirection(r1);
        }

        static void b(Configuration r0, Locale r1) {
            r0.setLocale(r1);
        }
    }

    static class f {
        static boolean a(PowerManager r0) {
            return r0.isPowerSaveMode();
        }

        static String a(Locale r0) {
            return r0.toLanguageTag();
        }
    }

    static class g {
        static void a(Configuration r1, Configuration r2, Configuration r3) {
            LocaleList r4 = r1.getLocales();
            LocaleList r0 = r2.getLocales();
            if (r4.equals(r0) == true) goto L6;
            r3.setLocales(r0);
            r3.locale = r2.locale;
            return;
        }

        static androidx.core.os.i a(Configuration r0) {
            return androidx.core.os.i.a(r0.getLocales().toLanguageTags());
        }

        static void a(Configuration r0, androidx.core.os.i r1) {
            r0.setLocales(LocaleList.forLanguageTags(r1.d()));
        }

        public static void a(androidx.core.os.i r0) {
            LocaleList.setDefault(LocaleList.forLanguageTags(r0.d()));
        }
    }

    static class h {
        static void a(Configuration r2, Configuration r3, Configuration r4) {
            if ((r2.colorMode & 3) == (r3.colorMode & 3)) goto L6;
            r4.colorMode |= r3.colorMode & 3;
        L6:
            if ((r2.colorMode & 12) == (r3.colorMode & 12)) goto L9;
            r4.colorMode |= r3.colorMode & 12;
            return;
        }
    }

    static class i {
        static OnBackInvokedCallback a(Object r2, final AppCompatDelegateImpl r3) {
            Objects.requireNonNull(r3);
            OnBackInvokedCallback r0 = new $$Lambda$KohrZ7UvY8rXg9JPBZsbvgnAMyM(r3);
            ((OnBackInvokedDispatcher) ZeusTransformUtils.preCheckCast(r2, OnBackInvokedDispatcher.class, "com.obric.aiagent.plugin")).registerOnBackInvokedCallback(1000000, r0);
            return r0;
        }

        static void a(Object r2, Object r3) {
            OnBackInvokedCallback r4 = (OnBackInvokedCallback) ZeusTransformUtils.preCheckCast(r3, OnBackInvokedCallback.class, "com.obric.aiagent.plugin");
            ((OnBackInvokedDispatcher) ZeusTransformUtils.preCheckCast(r2, OnBackInvokedDispatcher.class, "com.obric.aiagent.plugin")).unregisterOnBackInvokedCallback(r4);
        }

        static OnBackInvokedDispatcher a(Activity r2) {
            return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).getOnBackInvokedDispatcher();
        }
    }

    private class j extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppCompatDelegateImpl f224a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PowerManager f225c;

        j(AppCompatDelegateImpl r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f224a = r3;
            super(r3);
            this.f225c = (PowerManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("power"), PowerManager.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.k
        public int a() {
            if (Build.VERSION.SDK_INT >= 21) goto L5;
            return 1;
        L5:
            if (f.a(this.f225c) == false) goto L9;
            return 2;
        L9:
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.k
        public void b() {
            this.f224a.applyDayNight();
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.k
        IntentFilter c() {
            if (Build.VERSION.SDK_INT < 21) goto L6;
            IntentFilter r1 = new IntentFilter();
            r1.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return r1;
        L6:
            return null;
        }
    }

    abstract class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private PluginBroadcastReceiver f226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppCompatDelegateImpl f227b;

        abstract int a();

        abstract void b();

        abstract IntentFilter c();

        k(AppCompatDelegateImpl r1) {
            this.f227b = r1;
        }

        void d() {
            e();
            IntentFilter r0 = c();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.countActions() != 0) goto L8;
            return;
        L8:
            if (this.f226a != null) goto L10;
            this.f226a = new AnonymousClass1(this);
        L10:
            ZeusTransformUtils.registerReceiver(this.f227b.mContext, this.f226a, r0, "com.obric.aiagent.plugin");
        }

        void e() {
            if (this.f226a == null) goto L10;
            ZeusTransformUtils.unregisterReceiver(this.f227b.mContext, this.f226a, "com.obric.aiagent.plugin");     // Catch: IllegalArgumentException -> L7
        L5:
            this.f226a = null;
            return;
        }
    }

    private class l extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppCompatDelegateImpl f229a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.appcompat.app.j f230c;

        l(AppCompatDelegateImpl r1, androidx.appcompat.app.j r2) {
            this.f229a = r1;
            super(r1);
            this.f230c = r2;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.k
        public int a() {
            if (this.f230c.a() == false) goto L5;
            return 2;
        L5:
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.k
        public void b() {
            this.f229a.applyDayNight();
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.k
        IntentFilter c() {
            IntentFilter r1 = new IntentFilter();
            r1.addAction("android.intent.action.TIME_SET");
            r1.addAction("android.intent.action.TIMEZONE_CHANGED");
            r1.addAction("android.intent.action.TIME_TICK");
            return r1;
        }
    }

    private static class m {
        static void a(android.view.ContextThemeWrapper r2, Configuration r3) {
            ((android.view.ContextThemeWrapper) ZeusTransformUtils.wrapperContextForParams(r2, android.view.ContextThemeWrapper.class, "com.obric.aiagent.plugin")).applyOverrideConfiguration(r3);
        }
    }

    private final class n implements androidx.appcompat.view.menu.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppCompatDelegateImpl f231a;

        n(AppCompatDelegateImpl r1) {
            this.f231a = r1;
        }

        @Override // androidx.appcompat.view.menu.d.a
        public void onCloseMenu(MenuBuilder r5, boolean r6) {
            MenuBuilder r0 = r5.getRootMenu();
            if (r0 == r5) goto L5;
            boolean r2 = true;
        L6:
            AppCompatDelegateImpl r3 = this.f231a;
            if (r2 == false) goto L9;
            r5 = r0;
        L9:
            PanelFeatureState r7 = r3.findMenuPanel(r5);
            if (r7 == null) goto L15;
            if (r2 == false) goto L13;
            this.f231a.callOnPanelClosed(r7.f214a, r7, r0);
            this.f231a.closePanel(r7, true);
            return;
        L13:
            this.f231a.closePanel(r7, r6);
            return;
        L15:
            return;
        L5:
            r2 = false;
            goto L6
        }

        @Override // androidx.appcompat.view.menu.d.a
        public boolean onOpenSubMenu(MenuBuilder r2) {
            if (r2 == r2.getRootMenu()) goto L5;
            return true;
        L5:
            if (this.f231a.mHasActionBar == false) goto L14;
            Window.Callback r0 = this.f231a.getWindowCallback();
            if (r0 != null) goto L9;
            return true;
        L9:
            if (this.f231a.mDestroyed == true) goto L16;
            r0.onMenuOpened(108, r2);
            return true;
        L16:
            return true;
        L14:
            return true;
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.i(r0, r1, r2);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1, Throwable r2) {
        return Log.d(r0, r1, r2);
    }

    @Override // androidx.appcompat.app.c
    public void onSaveInstanceState(Bundle r1) {
    }

    void onSubDecorInstalled(ViewGroup r1) {
    }

    static {
        sLocalNightModes = new androidx.b.g();
        boolean r1 = false;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        boolean r0 = true;
    L6:
        IS_PRE_LOLLIPOP = r0;
        sWindowBackgroundStyleable = new int[]{android.R.attr.windowBackground};
        sCanReturnDifferentContext = !"robolectric".equals(Build.FINGERPRINT);
        if (Build.VERSION.SDK_INT < 17) goto L9;
        r1 = true;
    L9:
        sCanApplyOverrideConfiguration = r1;
        if (r0 == true) goto L12;
        return;
    L12:
        if (sInstalledExceptionHandler == true) goto L16;
        final Thread.UncaughtExceptionHandler r2 = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new AnonymousClass1(r2));
        sInstalledExceptionHandler = true;
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    AppCompatDelegateImpl(Activity r3, androidx.appcompat.app.b r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        this(r5, null, (androidx.appcompat.app.b) ZeusTransformUtils.wrapperContextForParams(r4, androidx.appcompat.app.b.class, "com.obric.aiagent.plugin"), r5);
    }

    AppCompatDelegateImpl(Dialog r4, androidx.appcompat.app.b r5) {
        androidx.appcompat.app.b r6 = (androidx.appcompat.app.b) ZeusTransformUtils.wrapperContextForParams(r5, androidx.appcompat.app.b.class, "com.obric.aiagent.plugin");
        this((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4.getWindow(), r6, r4);
    }

    AppCompatDelegateImpl(Context r3, Window r4, androidx.appcompat.app.b r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this(r6, r4, (androidx.appcompat.app.b) ZeusTransformUtils.wrapperContextForParams(r5, androidx.appcompat.app.b.class, "com.obric.aiagent.plugin"), r6);
    }

    AppCompatDelegateImpl(Context r3, Activity r4, androidx.appcompat.app.b r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        this(r6, null, (androidx.appcompat.app.b) ZeusTransformUtils.wrapperContextForParams(r5, androidx.appcompat.app.b.class, "com.obric.aiagent.plugin"), r7);
    }

    private AppCompatDelegateImpl(Context r4, Window r5, androidx.appcompat.app.b r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        androidx.appcompat.app.b r9 = (androidx.appcompat.app.b) ZeusTransformUtils.wrapperContextForParams(r6, androidx.appcompat.app.b.class, "com.obric.aiagent.plugin");
        this.mFadeAnim = null;
        this.mHandleNativeActionModes = true;
        this.mLocalNightMode = -100;
        this.mInvalidatePanelMenuRunnable = new AnonymousClass2(this);
        this.mContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.mAppCompatCallback = r9;
        this.mHost = r7;
        if (this.mLocalNightMode != (-100)) goto L10;
        if (ZeusTransformUtils.instanceOf(r7, Dialog.class) == false) goto L10;
        AppCompatActivity r10 = (AppCompatActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(tryUnwrapContext(), "com.obric.aiagent.plugin"), AppCompatActivity.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L10;
        this.mLocalNightMode = r10.getDelegate().getLocalNightMode();
    L10:
        if (this.mLocalNightMode != (-100)) goto L14;
        androidx.b.g<String, Integer> r11 = sLocalNightModes;
        Integer r12 = (Integer) ZeusTransformUtils.preCheckCast(r11.get(r7.getClass().getName()), Integer.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L14;
        this.mLocalNightMode = r12.intValue();
        r11.remove(r7.getClass().getName());
    L14:
        if (r5 == null) goto L16;
        attachToWindow(r5);
    L16:
        androidx.appcompat.widget.d.a();
    }

    @Override // androidx.appcompat.app.c
    public void setOnBackInvokedDispatcher(OnBackInvokedDispatcher r4) {
        OnBackInvokedDispatcher r5 = (OnBackInvokedDispatcher) ZeusTransformUtils.wrapperContextForParams(r4, OnBackInvokedDispatcher.class, "com.obric.aiagent.plugin");
        super.setOnBackInvokedDispatcher(r5);
        OnBackInvokedDispatcher r0 = this.mDispatcher;
        if (r0 == null) goto L7;
        OnBackInvokedCallback r2 = this.mBackCallback;
        if (r2 == null) goto L7;
        i.a(r0, r2);
        this.mBackCallback = null;
    L7:
        if (r5 == null) goto L9;
    L13:
        this.mDispatcher = r5;
    L14:
        updateBackInvokedCallbackState();
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L13;
        if (ZeusTransformUtils.getWindow((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin") == null) goto L13;
        this.mDispatcher = i.a((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.aiagent.plugin"));
        goto L14
    }

    void updateBackInvokedCallbackState() {
        if (Build.VERSION.SDK_INT < 33) goto L14;
        boolean r0 = shouldRegisterBackInvokedCallback();
        if (r0 == true) goto L7;
    L9:
        if (r0 == true) goto L16;
        OnBackInvokedCallback r1 = this.mBackCallback;
        if (r1 == null) goto L17;
        i.a(this.mDispatcher, r1);
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if (this.mBackCallback != null) goto L9;
        this.mBackCallback = i.a(this.mDispatcher, this);
        return;
    }

    @Override // androidx.appcompat.app.c
    public Context attachBaseContext2(Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        boolean r0 = true;
        this.mBaseContextAttached = true;
        int r8 = mapNightMode(r12, calculateNightMode());
        if (isAutoStorageOptedIn(r12) == false) goto L5;
        syncRequestedAndStoredLocales(r12);
    L5:
        androidx.core.os.i r9 = calculateApplicationLocales(r12);
        if (sCanApplyOverrideConfiguration == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r12, android.view.ContextThemeWrapper.class) == false) goto L13;
        m.a((android.view.ContextThemeWrapper) ZeusTransformUtils.preCheckCast(r12, android.view.ContextThemeWrapper.class, "com.obric.aiagent.plugin"), createOverrideAppConfiguration(r12, r8, r9, null, false));     // Catch: IllegalStateException -> L36
        return r12;
    L13:
        if (ZeusTransformUtils.instanceOf(r12, ContextThemeWrapper.class) == false) goto L18;
        ((ContextThemeWrapper) ZeusTransformUtils.preCheckCast(r12, ContextThemeWrapper.class, "com.obric.aiagent.plugin")).applyOverrideConfiguration(createOverrideAppConfiguration(r12, r8, r9, null, false));     // Catch: IllegalStateException -> L37
        return r12;
    L18:
        if (sCanReturnDifferentContext == false) goto L20;
        Configuration r2 = null;
        if (Build.VERSION.SDK_INT < 17) goto L26;
        Configuration r3 = new Configuration();
        r3.uiMode = -1;
        r3.fontScale = 0.0f;
        Configuration r4 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.a(r12, r3), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration();
        Configuration r5 = ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin").getConfiguration();
        r4.uiMode = r5.uiMode;
        if (r4.equals(r5) == true) goto L26;
        r2 = generateConfigDelta(r4, r5);
    L26:
        Configuration r6 = createOverrideAppConfiguration(r12, r8, r9, r2, true);
        ContextThemeWrapper r7 = new ContextThemeWrapper(r12, ZeusTransformUtils.mapRes(R.style.Theme_AppCompat_Empty, "style", "Theme_AppCompat_Empty"));
        r7.applyOverrideConfiguration(r6);
        boolean r10 = false;
        if (r12.getTheme() != null) goto L31;
        r0 = false;
    L31:
        r10 = r0;
    L32:
        if (r10 == false) goto L35;
        androidx.core.content.b.h.g.a(r7.getTheme());
    L35:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(super.attachBaseContext2(r7), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L20:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(super.attachBaseContext2(r12), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.appcompat.app.c
    public void onCreate(Bundle r5) {
        this.mBaseContextAttached = true;
        applyApplicationSpecificConfig(false);
        ensureWindow();
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L12;
        String r0 = null;
        r0 = androidx.core.app.h.b((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.aiagent.plugin"));     // Catch: IllegalArgumentException -> L14
    L6:
        if (r0 == null) goto L11;
        ActionBar r1 = peekSupportActionBar();
        if (r1 != null) goto L10;
        this.mEnableDefaultActionBarUp = true;
        goto L11
    L10:
        r1.c(true);
    L11:
        addActiveDelegate(this);
    L12:
        this.mEffectiveConfiguration = new Configuration(ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").getConfiguration());
        this.mCreated = true;
    }

    @Override // androidx.appcompat.app.c
    public void onPostCreate(Bundle r1) {
        ensureSubDecor();
    }

    @Override // androidx.appcompat.app.c
    public ActionBar getSupportActionBar() {
        initWindowDecorActionBar();
        return this.mActionBar;
    }

    final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    private void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar == true) goto L5;
        return;
    L5:
        if (this.mActionBar == null) goto L8;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L11;
        this.mActionBar = new androidx.appcompat.app.k((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.aiagent.plugin"), this.mOverlayActionBar);
    L13:
        ActionBar r0 = this.mActionBar;
        if (r0 == null) goto L18;
        r0.c(this.mEnableDefaultActionBarUp);
        return;
    L18:
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(this.mHost, Dialog.class) == false) goto L13;
        this.mActionBar = new androidx.appcompat.app.k((Dialog) ZeusTransformUtils.preCheckCast(this.mHost, Dialog.class, "com.obric.aiagent.plugin"));
        goto L13
    }

    @Override // androidx.appcompat.app.c
    public void setSupportActionBar(Toolbar r4) {
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == true) goto L5;
        return;
    L5:
        ActionBar r0 = getSupportActionBar();
        if (ZeusTransformUtils.instanceOf(r0, androidx.appcompat.app.k.class) == true) goto L17;
        this.mMenuInflater = null;
        if (r0 == null) goto L10;
        r0.g();
    L10:
        this.mActionBar = null;
        if (r4 == null) goto L13;
        androidx.appcompat.app.h r1 = new androidx.appcompat.app.h(r4, getTitle(), this.mAppCompatWindowCallback);
        this.mActionBar = r1;
        this.mAppCompatWindowCallback.setActionBarCallback(r1.f254c);
        r4.setBackInvokedCallbackEnabled(true);
    L14:
        invalidateOptionsMenu();
        return;
    L13:
        this.mAppCompatWindowCallback.setActionBarCallback(null);
        goto L14
    L17:
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    final Context getActionBarThemedContext() {
        ActionBar r0 = getSupportActionBar();
        if (r0 == null) goto L5;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return this.mContext;
    L5:
        r1 = null;
        goto L6
    }

    @Override // androidx.appcompat.app.c
    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater != null) goto L10;
        initWindowDecorActionBar();
        ActionBar r1 = this.mActionBar;
        if (r1 == null) goto L7;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L8:
        this.mMenuInflater = new SupportMenuInflater(r2);
        goto L10
    L7:
        r2 = this.mContext;
    L10:
        return this.mMenuInflater;
    }

    @Override // androidx.appcompat.app.c
    public <T extends View> T findViewById(int r1) {
        ensureSubDecor();
        return (T) this.mWindow.findViewById(r1);
    }

    @Override // androidx.appcompat.app.c
    public void onConfigurationChanged(Configuration r3) {
        if (this.mHasActionBar == true) goto L5;
    L9:
        androidx.appcompat.widget.d.b().a(this.mContext);
        this.mEffectiveConfiguration = new Configuration(ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").getConfiguration());
        applyApplicationSpecificConfig(false, false);
        return;
    L5:
        if (this.mSubDecorInstalled == false) goto L9;
        ActionBar r0 = getSupportActionBar();
        if (r0 == null) goto L9;
        r0.a(r3);
        goto L9
    }

    @Override // androidx.appcompat.app.c
    public void onStart() {
        applyApplicationSpecificConfig(true, false);
    }

    @Override // androidx.appcompat.app.c
    public void onStop() {
        ActionBar r1 = getSupportActionBar();
        if (r1 == null) goto L6;
        r1.d(false);
        return;
    }

    @Override // androidx.appcompat.app.c
    public void onPostResume() {
        ActionBar r1 = getSupportActionBar();
        if (r1 == null) goto L6;
        r1.d(true);
        return;
    }

    @Override // androidx.appcompat.app.c
    public void setContentView(View r4) {
        ensureSubDecor();
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mSubDecor.findViewById(android.R.id.content), ViewGroup.class, "com.obric.aiagent.plugin");
        r0.removeAllViews();
        r0.addView(r4);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.c
    public void setContentView(int r4) {
        ensureSubDecor();
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mSubDecor.findViewById(android.R.id.content), ViewGroup.class, "com.obric.aiagent.plugin");
        r0.removeAllViews();
        ZeusTransformUtils.inflate(LayoutInflater.from(this.mContext), r4, r0, "com.obric.aiagent.plugin");
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.c
    public void setContentView(View r4, ViewGroup.LayoutParams r5) {
        ensureSubDecor();
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mSubDecor.findViewById(android.R.id.content), ViewGroup.class, "com.obric.aiagent.plugin");
        r0.removeAllViews();
        r0.addView(r4, r5);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.c
    public void addContentView(View r4, ViewGroup.LayoutParams r5) {
        ensureSubDecor();
        ((ViewGroup) ZeusTransformUtils.preCheckCast(this.mSubDecor.findViewById(android.R.id.content), ViewGroup.class, "com.obric.aiagent.plugin")).addView(r4, r5);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.c
    public void onDestroy() {
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L6;
        removeActivityDelegate(this);
    L6:
        if (this.mInvalidatePanelMenuPosted == false) goto L8;
        this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
    L8:
        this.mDestroyed = true;
        if (this.mLocalNightMode != (-100)) goto L11;
    L15:
        sLocalNightModes.remove(this.mHost.getClass().getName());
    L16:
        ActionBar r0 = this.mActionBar;
        if (r0 == null) goto L19;
        r0.g();
    L19:
        cleanupAutoManagers();
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L15;
        if (((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.aiagent.plugin")).isChangingConfigurations() == false) goto L15;
        sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
        goto L16
    }

    private void cleanupAutoManagers() {
        k r0 = this.mAutoTimeNightModeManager;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        k r1 = this.mAutoBatteryNightModeManager;
        if (r1 == null) goto L9;
        r1.e();
        return;
    }

    @Override // androidx.appcompat.app.c
    public void setTheme(int r1) {
        this.mThemeResId = r1;
    }

    private void ensureWindow() {
        if (this.mWindow != null) goto L8;
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L8;
        attachToWindow(ZeusTransformUtils.getWindow((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin"));
    L8:
        if (this.mWindow == null) goto L11;
        return;
    L11:
        throw new IllegalStateException("We have not been given a Window");
    }

    private void attachToWindow(Window r4) {
        if (this.mWindow != null) goto L18;
        Window.Callback r0 = r4.getCallback();
        if (ZeusTransformUtils.instanceOf(r0, AppCompatWindowCallback.class) == true) goto L16;
        AppCompatWindowCallback r1 = new AppCompatWindowCallback(this, r0);
        this.mAppCompatWindowCallback = r1;
        r4.setCallback(r1);
        y r2 = y.a(this.mContext, null, sWindowBackgroundStyleable);
        Drawable r3 = r2.b(0);
        if (r3 == null) goto L9;
        r4.setBackgroundDrawable(r3);
    L9:
        r2.b();
        this.mWindow = r4;
        if (Build.VERSION.SDK_INT >= 33) goto L12;
        return;
    L12:
        if (this.mDispatcher != null) goto L20;
        setOnBackInvokedDispatcher(null);
        return;
    L20:
        return;
    L16:
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    L18:
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private void ensureSubDecor() {
        if (this.mSubDecorInstalled == true) goto L22;
        this.mSubDecor = createSubDecor();
        CharSequence r0 = getTitle();
        if (TextUtils.isEmpty(r0) == true) goto L15;
        o r1 = this.mDecorContentParent;
        if (r1 == null) goto L10;
        r1.setWindowTitle(r0);
        goto L15
    L10:
        if (peekSupportActionBar() == null) goto L12;
        peekSupportActionBar().a(r0);
        goto L15
    L12:
        TextView r2 = this.mTitleView;
        if (r2 == null) goto L15;
        r2.setText(r0);
    L15:
        applyFixedSizeWindow();
        onSubDecorInstalled(this.mSubDecor);
        this.mSubDecorInstalled = true;
        PanelFeatureState r3 = getPanelState(0, false);
        if (this.mDestroyed == true) goto L23;
        if (r3 != null) goto L19;
    L20:
        invalidatePanelMenu(108);
        return;
    L19:
        if (r3.j == null) goto L20;
        return;
    L23:
        return;
    }

    private ViewGroup createSubDecor() {
        TypedArray r0 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (r0.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowActionBar, "styleable", "AppCompatTheme_windowActionBar")) == true) goto L5;
        r0.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    L5:
        if (r0.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowNoTitle, "styleable", "AppCompatTheme_windowNoTitle"), false) == false) goto L8;
        requestWindowFeature(1);
    L11:
        if (r0.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowActionBarOverlay, "styleable", "AppCompatTheme_windowActionBarOverlay"), false) == false) goto L14;
        requestWindowFeature(109);
    L14:
        if (r0.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowActionModeOverlay, "styleable", "AppCompatTheme_windowActionModeOverlay"), false) == false) goto L16;
        requestWindowFeature(10);
    L16:
        this.mIsFloating = r0.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_android_windowIsFloating, "styleable", "AppCompatTheme_android_windowIsFloating"), false);
        r0.recycle();
        ensureWindow();
        this.mWindow.getDecorView();
        LayoutInflater r1 = LayoutInflater.from(this.mContext);
        if (this.mWindowNoTitle == true) goto L38;
        if (this.mIsFloating == false) goto L22;
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r1, ZeusTransformUtils.mapRes(R.layout.abc_dialog_title_material, "layout", "abc_dialog_title_material"), null, "com.obric.aiagent.plugin"), ViewGroup.class, "com.obric.aiagent.plugin");
        this.mOverlayActionBar = false;
        this.mHasActionBar = false;
    L41:
        if (r2 == null) goto L62;
        if (Build.VERSION.SDK_INT < 21) goto L46;
        ViewCompat.a(r2, new AnonymousClass3(this));
    L49:
        if (this.mDecorContentParent != null) goto L51;
        this.mTitleView = (TextView) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE)), TextView.class, "com.obric.aiagent.plugin");
    L51:
        ac.b(r2);
        ContentFrameLayout r3 = (ContentFrameLayout) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_activity_content, DbHelper.COL_ID, "action_bar_activity_content")), ContentFrameLayout.class, "com.obric.aiagent.plugin");
        ViewGroup r4 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.mWindow.findViewById(android.R.id.content), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L54;
    L59:
        this.mWindow.setContentView(r2);
        r3.setAttachListener(new AnonymousClass5(this));
        return r2;
    L54:
        if (r4.getChildCount() <= 0) goto L56;
        View r5 = r4.getChildAt(0);
        r4.removeViewAt(0);
        r3.addView(r5);
        goto L54
    L56:
        r4.setId(-1);
        r3.setId(android.R.id.content);
        if (ZeusTransformUtils.instanceOf(r4, FrameLayout.class) == false) goto L59;
        ((FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.aiagent.plugin")).setForeground(null);
        goto L59
    L46:
        if (ZeusTransformUtils.instanceOf(r2, r.class) == false) goto L49;
        ((r) ZeusTransformUtils.preCheckCast(r2, r.class, "com.obric.aiagent.plugin")).setOnFitSystemWindowsListener(new AnonymousClass4(this));
        goto L49
    L62:
        throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
    L22:
        if (this.mHasActionBar == false) goto L36;
        TypedValue r6 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarTheme, "attr", "actionBarTheme"), r6, true);
        if (r6.resourceId == 0) goto L26;
        Context r7 = new ContextThemeWrapper(this.mContext, r6.resourceId);
    L27:
        r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from(r7), ZeusTransformUtils.mapRes(R.layout.abc_screen_toolbar, "layout", "abc_screen_toolbar"), null, "com.obric.aiagent.plugin"), ViewGroup.class, "com.obric.aiagent.plugin");
        o r8 = (o) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.decor_content_parent, DbHelper.COL_ID, "decor_content_parent")), o.class, "com.obric.aiagent.plugin");
        this.mDecorContentParent = r8;
        r8.setWindowCallback(getWindowCallback());
        if (this.mOverlayActionBar == false) goto L31;
        this.mDecorContentParent.initFeature(109);
    L31:
        if (this.mFeatureProgress == false) goto L34;
        this.mDecorContentParent.initFeature(2);
    L34:
        if (this.mFeatureIndeterminateProgress == false) goto L41;
        this.mDecorContentParent.initFeature(5);
        goto L41
    L26:
        r7 = this.mContext;
        goto L27
    L36:
        r2 = null;
        goto L41
    L38:
        if (this.mOverlayActionMode == false) goto L40;
        r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r1, ZeusTransformUtils.mapRes(R.layout.abc_screen_simple_overlay_action_mode, "layout", "abc_screen_simple_overlay_action_mode"), null, "com.obric.aiagent.plugin"), ViewGroup.class, "com.obric.aiagent.plugin");
        goto L41
    L40:
        r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r1, ZeusTransformUtils.mapRes(R.layout.abc_screen_simple, "layout", "abc_screen_simple"), null, "com.obric.aiagent.plugin"), ViewGroup.class, "com.obric.aiagent.plugin");
        goto L41
    L8:
        if (r0.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowActionBar, "styleable", "AppCompatTheme_windowActionBar"), false) == false) goto L11;
        requestWindowFeature(108);
        goto L11
    }

    private void applyFixedSizeWindow() {
        ContentFrameLayout r0 = (ContentFrameLayout) ZeusTransformUtils.preCheckCast(this.mSubDecor.findViewById(android.R.id.content), ContentFrameLayout.class, "com.obric.aiagent.plugin");
        View r1 = this.mWindow.getDecorView();
        r0.setDecorPadding(r1.getPaddingLeft(), r1.getPaddingTop(), r1.getPaddingRight(), r1.getPaddingBottom());
        TypedArray r5 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        r5.getValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowMinWidthMajor, "styleable", "AppCompatTheme_windowMinWidthMajor"), r0.getMinWidthMajor());
        r5.getValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowMinWidthMinor, "styleable", "AppCompatTheme_windowMinWidthMinor"), r0.getMinWidthMinor());
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedWidthMajor, "styleable", "AppCompatTheme_windowFixedWidthMajor")) == false) goto L6;
        r5.getValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedWidthMajor, "styleable", "AppCompatTheme_windowFixedWidthMajor"), r0.getFixedWidthMajor());
    L6:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedWidthMinor, "styleable", "AppCompatTheme_windowFixedWidthMinor")) == false) goto L9;
        r5.getValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedWidthMinor, "styleable", "AppCompatTheme_windowFixedWidthMinor"), r0.getFixedWidthMinor());
    L9:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedHeightMajor, "styleable", "AppCompatTheme_windowFixedHeightMajor")) == false) goto L12;
        r5.getValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedHeightMajor, "styleable", "AppCompatTheme_windowFixedHeightMajor"), r0.getFixedHeightMajor());
    L12:
        if (r5.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedHeightMinor, "styleable", "AppCompatTheme_windowFixedHeightMinor")) == false) goto L14;
        r5.getValue(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_windowFixedHeightMinor, "styleable", "AppCompatTheme_windowFixedHeightMinor"), r0.getFixedHeightMinor());
    L14:
        r5.recycle();
        r0.requestLayout();
    }

    @Override // androidx.appcompat.app.c
    public boolean requestWindowFeature(int r5) {
        int r6 = sanitizeWindowFeatureId(r5);
        if (this.mWindowNoTitle == false) goto L7;
        if (r6 != 108) goto L7;
        return false;
    L7:
        if (this.mHasActionBar == false) goto L10;
        if (r6 != 1) goto L10;
        this.mHasActionBar = false;
    L10:
        if (r6 != 1) goto L12;
        throwFeatureRequestIfSubDecorInstalled();
        this.mWindowNoTitle = true;
        return true;
    L12:
        if (r6 != 2) goto L14;
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureProgress = true;
        return true;
    L14:
        if (r6 != 5) goto L16;
        throwFeatureRequestIfSubDecorInstalled();
        this.mFeatureIndeterminateProgress = true;
        return true;
    L16:
        if (r6 == 10) goto L26;
        if (r6 != 108) goto L19;
        throwFeatureRequestIfSubDecorInstalled();
        this.mHasActionBar = true;
        return true;
    L19:
        if (r6 != 109) goto L21;
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionBar = true;
        return true;
    L21:
        return this.mWindow.requestFeature(r6);
    L26:
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionMode = true;
        return true;
    }

    @Override // androidx.appcompat.app.c
    public boolean hasWindowFeature(int r5) {
        int r0 = sanitizeWindowFeatureId(r5);
        if (r0 != 1) goto L5;
        boolean r1 = this.mWindowNoTitle;
    L21:
        if (r1 == false) goto L23;
        return true;
    L23:
        if (this.mWindow.hasFeature(r5) == false) goto L26;
        return true;
    L26:
        return false;
    L5:
        if (r0 != 2) goto L7;
        r1 = this.mFeatureProgress;
        goto L21
    L7:
        if (r0 != 5) goto L9;
        r1 = this.mFeatureIndeterminateProgress;
        goto L21
    L9:
        if (r0 != 10) goto L11;
        r1 = this.mOverlayActionMode;
        goto L21
    L11:
        if (r0 != 108) goto L13;
        r1 = this.mHasActionBar;
        goto L21
    L13:
        if (r0 == 109) goto L15;
        r1 = false;
        goto L21
    L15:
        r1 = this.mOverlayActionBar;
        goto L21
    }

    @Override // androidx.appcompat.app.c
    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.mTitle = r4;
        o r0 = this.mDecorContentParent;
        if (r0 == null) goto L6;
        r0.setWindowTitle(r4);
        return;
    L6:
        if (peekSupportActionBar() == null) goto L8;
        peekSupportActionBar().a(r4);
        return;
    L8:
        TextView r2 = this.mTitleView;
        if (r2 == null) goto L14;
        r2.setText(r4);
        return;
    }

    final CharSequence getTitle() {
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L7;
        return ((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.aiagent.plugin")).getTitle();
    L7:
        return this.mTitle;
    }

    void onPanelClosed(int r3) {
        if (r3 != 108) goto L7;
        ActionBar r2 = getSupportActionBar();
        if (r2 == null) goto L12;
        r2.e(false);
        return;
    L12:
        return;
    L7:
        if (r3 != 0) goto L14;
        PanelFeatureState r4 = getPanelState(r3, true);
        if (r4.o == false) goto L15;
        closePanel(r4, false);
        return;
    L15:
        return;
    }

    void onMenuOpened(int r2) {
        if (r2 != 108) goto L8;
        ActionBar r1 = getSupportActionBar();
        if (r1 == null) goto L9;
        r1.e(true);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.a
    public boolean onMenuItemSelected(MenuBuilder r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.aiagent.plugin");
        Window.Callback r0 = getWindowCallback();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.mDestroyed == true) goto L12;
        PanelFeatureState r2 = findMenuPanel(r3.getRootMenu());
        if (r2 != null) goto L9;
        return false;
    L9:
        return r0.onMenuItemSelected(r2.f214a, r5);
    L12:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.a
    public void onMenuModeChange(MenuBuilder r1) {
        reopenMenu(true);
    }

    @Override // androidx.appcompat.app.c
    public androidx.appcompat.view.b startSupportActionMode(androidx.appcompat.view.b.a r3) {
        androidx.appcompat.view.b.a r4 = (androidx.appcompat.view.b.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.appcompat.view.b.a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L20;
        androidx.appcompat.view.b r0 = this.mActionMode;
        if (r0 == null) goto L7;
        r0.c();
    L7:
        d r1 = new d(this, r4);
        ActionBar r5 = getSupportActionBar();
        if (r5 == null) goto L15;
        androidx.appcompat.view.b r6 = r5.a(r1);
        this.mActionMode = r6;
        if (r6 == null) goto L15;
        androidx.appcompat.app.b r2 = this.mAppCompatCallback;
        if (r2 == null) goto L15;
        r2.onSupportActionModeStarted(r6);
    L15:
        if (this.mActionMode != null) goto L17;
        this.mActionMode = startSupportActionModeFromWindow(r1);
    L17:
        updateBackInvokedCallbackState();
        return this.mActionMode;
    L20:
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    @Override // androidx.appcompat.app.c
    public void invalidateOptionsMenu() {
        if (peekSupportActionBar() != null) goto L5;
        return;
    L5:
        if (getSupportActionBar().e() == true) goto L10;
        invalidatePanelMenu(0);
        return;
    }

    androidx.appcompat.view.b startSupportActionModeFromWindow(androidx.appcompat.view.b.a r11) {
        androidx.appcompat.view.b.a r12 = (androidx.appcompat.view.b.a) ZeusTransformUtils.wrapperContextForParams(r11, androidx.appcompat.view.b.a.class, "com.obric.aiagent.plugin");
        endOnGoingFadeAnimation();
        androidx.appcompat.view.b r0 = this.mActionMode;
        if (r0 == null) goto L6;
        r0.c();
    L6:
        if (ZeusTransformUtils.instanceOf(r12, d.class) == true) goto L8;
        r12 = new d(this, r12);
    L8:
        androidx.appcompat.app.b r1 = this.mAppCompatCallback;
        if (r1 != null) goto L11;
    L14:
        androidx.appcompat.view.b r2 = null;
    L15:
        if (r2 == null) goto L17;
        this.mActionMode = r2;
    L47:
        androidx.appcompat.view.b r13 = this.mActionMode;
        if (r13 == null) goto L52;
        androidx.appcompat.app.b r3 = this.mAppCompatCallback;
        if (r3 == null) goto L52;
        r3.onSupportActionModeStarted(r13);
    L52:
        updateBackInvokedCallbackState();
        return this.mActionMode;
    L17:
        boolean r4 = true;
        if (this.mActionModeView != null) goto L30;
        if (this.mIsFloating == false) goto L26;
        TypedValue r5 = new TypedValue();
        Resources.Theme r6 = this.mContext.getTheme();
        r6.resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarTheme, "attr", "actionBarTheme"), r5, true);
        if (r5.resourceId == 0) goto L24;
        Resources.Theme r7 = ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").newTheme();
        r7.setTo(r6);
        r7.applyStyle(r5.resourceId, true);
        Context r8 = new ContextThemeWrapper(this.mContext, 0);
        r8.getTheme().setTo(r7);
    L25:
        this.mActionModeView = new ActionBarContextView(r8);
        PopupWindow r9 = new PopupWindow(r8, null, ZeusTransformUtils.mapRes(R.attr.actionModePopupWindowStyle, "attr", "actionModePopupWindowStyle"));
        this.mActionModePopup = r9;
        androidx.core.widget.f.a(r9, 2);
        this.mActionModePopup.setContentView(this.mActionModeView);
        this.mActionModePopup.setWidth(-1);
        r8.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarSize, "attr", "actionBarSize"), r5, true);
        this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(r5.data, ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getDisplayMetrics()));
        this.mActionModePopup.setHeight(-2);
        this.mShowActionModePopup = new AnonymousClass6(this);
        goto L30
    L24:
        r8 = this.mContext;
        goto L25
    L26:
        ViewStubCompat r10 = (ViewStubCompat) ZeusTransformUtils.preCheckCast(this.mSubDecor.findViewById(ZeusTransformUtils.mapRes(R.id.action_mode_bar_stub, DbHelper.COL_ID, "action_mode_bar_stub")), ViewStubCompat.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L30;
        r10.setLayoutInflater(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActionBarThemedContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
        this.mActionModeView = (ActionBarContextView) ZeusTransformUtils.preCheckCast(r10.inflate(), ActionBarContextView.class, "com.obric.aiagent.plugin");
    L30:
        if (this.mActionModeView == null) goto L47;
        endOnGoingFadeAnimation();
        this.mActionModeView.killMode();
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mActionModeView.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        ActionBarContextView r15 = this.mActionModeView;
        if (this.mActionModePopup == null) goto L35;
        r4 = false;
    L35:
        androidx.appcompat.view.d r16 = new androidx.appcompat.view.d(r14, r15, r12, r4);
        if (r12.a(r16, r16.b()) == false) goto L46;
        r16.d();
        this.mActionModeView.initForMode(r16);
        this.mActionMode = r16;
        if (shouldAnimateActionModeView() == false) goto L40;
        this.mActionModeView.setAlpha(0.0f);
        ae r17 = ViewCompat.p(this.mActionModeView).a(1.0f);
        this.mFadeAnim = r17;
        r17.a(new AnonymousClass7(this));
    L44:
        if (this.mActionModePopup == null) goto L47;
        this.mWindow.getDecorView().post(this.mShowActionModePopup);
        goto L47
    L40:
        this.mActionModeView.setAlpha(1.0f);
        this.mActionModeView.setVisibility(0);
        if (ZeusTransformUtils.instanceOf(this.mActionModeView.getParent(), View.class) == false) goto L44;
        ViewCompat.u((View) ZeusTransformUtils.preCheckCast(this.mActionModeView.getParent(), View.class, "com.obric.aiagent.plugin"));
        goto L44
    L46:
        this.mActionMode = null;
        goto L47
    L11:
        if (this.mDestroyed == true) goto L14;
        r2 = r1.onWindowStartingSupportActionMode(r12);     // Catch: AbstractMethodError -> L54
        goto L15
    }

    final boolean shouldAnimateActionModeView() {
        if (this.mSubDecorInstalled == false) goto L9;
        ViewGroup r1 = this.mSubDecor;
        if (r1 == null) goto L9;
        if (ViewCompat.F(r1) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.appcompat.app.c
    public void setHandleNativeActionModesEnabled(boolean r1) {
        this.mHandleNativeActionModes = r1;
    }

    @Override // androidx.appcompat.app.c
    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    void endOnGoingFadeAnimation() {
        ae r0 = this.mFadeAnim;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    boolean shouldRegisterBackInvokedCallback() {
        if (this.mDispatcher != null) goto L5;
        return false;
    L5:
        PanelFeatureState r0 = getPanelState(0, false);
        if (r0 == null) goto L11;
        if (r0.o == false) goto L11;
        return true;
    L11:
        if (this.mActionMode == null) goto L13;
        return true;
    L13:
        return false;
    }

    boolean onBackPressed() {
        boolean r0 = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        PanelFeatureState r2 = getPanelState(0, false);
        if (r2 != null) goto L5;
    L9:
        androidx.appcompat.view.b r1 = this.mActionMode;
        if (r1 == null) goto L13;
        r1.c();
        return true;
    L13:
        ActionBar r5 = getSupportActionBar();
        if (r5 != null) goto L16;
    L18:
        return false;
    L16:
        if (r5.f() == false) goto L18;
        return true;
    L5:
        if (r2.o == false) goto L9;
        if (r0 == true) goto L8;
        closePanel(r2, true);
    L8:
        return true;
    }

    boolean onKeyShortcut(int r4, KeyEvent r5) {
        ActionBar r0 = getSupportActionBar();
        if (r0 != null) goto L5;
    L7:
        PanelFeatureState r6 = this.mPreparedPanel;
        if (r6 == null) goto L16;
        if (performPanelShortcut(r6, r5.getKeyCode(), r5, 1) == false) goto L16;
        PanelFeatureState r3 = this.mPreparedPanel;
        if (r3 == null) goto L14;
        r3.n = true;
    L14:
        return true;
    L16:
        if (this.mPreparedPanel != null) goto L20;
        PanelFeatureState r7 = getPanelState(0, true);
        preparePanel(r7, r5);
        boolean r8 = performPanelShortcut(r7, r5.getKeyCode(), r5, 1);
        r7.m = false;
        if (r8 == false) goto L20;
        return true;
    L20:
        return false;
    L5:
        if (r0.a(r4, r5) == false) goto L7;
        return true;
    }

    boolean dispatchKeyEvent(KeyEvent r4) {
        boolean r1 = true;
        if (ZeusTransformUtils.instanceOf(this.mHost, androidx.core.view.e.a.class) == false) goto L5;
    L6:
        View r0 = this.mWindow.getDecorView();
        if (r0 != null) goto L9;
    L12:
        if (r4.getKeyCode() == 82) goto L14;
    L16:
        int r2 = r4.getKeyCode();
        if (r4.getAction() == 0) goto L20;
        r1 = false;
    L20:
        if (r1 == false) goto L23;
        return onKeyDown(r2, r4);
    L23:
        return onKeyUp(r2, r4);
    L14:
        if (this.mAppCompatWindowCallback.bypassDispatchKeyEvent(this.mWindow.getCallback(), r4) == false) goto L16;
        return true;
    L9:
        if (androidx.core.view.e.a(r0, r4) == false) goto L12;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(this.mHost, AppCompatDialog.class) == false) goto L12;
        goto L6
    }

    boolean onKeyUp(int r4, KeyEvent r5) {
        if (r4 == 4) goto L10;
        if (r4 != 82) goto L12;
        onKeyUpPanel(0, r5);
        return true;
    L12:
        return false;
    L10:
        if (onBackPressed() == false) goto L12;
        return true;
    }

    boolean onKeyDown(int r4, KeyEvent r5) {
        boolean r1 = true;
        if (r4 == 4) goto L10;
        if (r4 != 82) goto L14;
        onKeyDownPanel(0, r5);
        return true;
    L14:
        return false;
    L10:
        if ((r5.getFlags() & 128) != 0) goto L13;
        r1 = false;
    L13:
        this.mLongPressBackDown = r1;
        goto L14
    }

    @Override // androidx.appcompat.app.c
    public View createView(View r12, String r13, Context r14, AttributeSet r15) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r15, AttributeSet.class, "com.obric.aiagent.plugin");
        boolean r16 = false;
        if (this.mAppCompatViewInflater != null) goto L11;
        String r17 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(ZeusTransformUtils.mapRes(R.styleable.AppCompatTheme_viewInflaterClass, "styleable", "AppCompatTheme_viewInflaterClass"));
        if (r17 != null) goto L28;
        this.mAppCompatViewInflater = new AppCompatViewInflater();
        goto L11
    L28:
        this.mAppCompatViewInflater = (AppCompatViewInflater) ZeusTransformUtils.preCheckCast(this.mContext.getClassLoader().loadClass(r17).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), AppCompatViewInflater.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        INVOKESTATIC_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("AppCompatDelegate", "Failed to instantiate custom view inflater " + r17 + ". Falling back to default.", th);
        this.mAppCompatViewInflater = new AppCompatViewInflater();
    L11:
        boolean r8 = IS_PRE_LOLLIPOP;
        if (r8 == true) goto L14;
    L25:
        boolean r7 = r16;
    L27:
        return this.mAppCompatViewInflater.a(r12, r13, r5, r6, r7, r8, true, VectorEnabledTintResources.shouldBeUsed());
    L14:
        if (this.mLayoutIncludeDetector != null) goto L17;
        this.mLayoutIncludeDetector = new androidx.appcompat.app.e();
    L17:
        if (this.mLayoutIncludeDetector.a(r6) == false) goto L20;
        r7 = true;
        goto L27
    L20:
        if (ZeusTransformUtils.instanceOf(r6, XmlPullParser.class) == true) goto L22;
        r16 = shouldInheritContext((ViewParent) ZeusTransformUtils.preCheckCast(r12, ViewParent.class, "com.obric.aiagent.plugin"));
        goto L25
    L22:
        if (((XmlPullParser) ZeusTransformUtils.preCheckCast(r6, XmlPullParser.class, "com.obric.aiagent.plugin")).getDepth() <= 1) goto L25;
        r16 = true;
        goto L25
    }

    private boolean shouldInheritContext(ViewParent r4) {
        ViewParent r5 = (ViewParent) ZeusTransformUtils.wrapperContextForParams(r4, ViewParent.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return false;
    L5:
        View r3 = this.mWindow.getDecorView();
    L6:
        if (r5 == null) goto L7;
        if (r5 == r3) goto L16;
        if (ZeusTransformUtils.instanceOf(r5, View.class) == false) goto L16;
        if (ViewCompat.I((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin")) == true) goto L16;
        r5 = r5.getParent();
    L16:
        return false;
    L7:
        return true;
    }

    @Override // androidx.appcompat.app.c
    public void installViewFactory() {
        LayoutInflater r0 = LayoutInflater.from(this.mContext);
        if (r0.getFactory() != null) goto L6;
        LayoutInflaterCompat.a(r0, this);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0.getFactory2(), AppCompatDelegateImpl.class) == true) goto L10;
        INVOKESTATIC_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        return;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View r3, String r4, Context r5, AttributeSet r6) {
        return createView(r3, r4, (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r3, Context r4, AttributeSet r5) {
        return onCreateView(null, r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    private AppCompatActivity tryUnwrapContext() {
        Context r3 = this.mContext;
    L4:
        if (r3 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r3, AppCompatActivity.class) == true) goto L8;
        if (ZeusTransformUtils.instanceOf(r3, ContextWrapper.class) == false) goto L12;
        r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r3, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        goto L4
    L8:
        return (AppCompatActivity) ZeusTransformUtils.preCheckCast(r3, AppCompatActivity.class, "com.obric.aiagent.plugin");
    L12:
        return null;
    }

    private void openPanel(PanelFeatureState r18, KeyEvent r19) {
        if (r18.o == false) goto L5;
        return;
    L5:
        if (this.mDestroyed == false) goto L8;
        return;
    L8:
        if (r18.f214a == 0) goto L10;
    L15:
        Window.Callback r2 = getWindowCallback();
        if (r2 != null) goto L18;
    L21:
        WindowManager r3 = (WindowManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L25;
        return;
    L25:
        if (preparePanel(r18, r19) == true) goto L28;
        return;
    L28:
        if (r18.g == null) goto L40;
        if (r18.q == true) goto L40;
        if (r18.i == null) goto L65;
        ViewGroup.LayoutParams r4 = r18.i.getLayoutParams();
        if (r4 == null) goto L65;
        if (r4.width != (-1)) goto L65;
        int r10 = -1;
    L66:
        r18.n = false;
        WindowManager.LayoutParams r5 = new WindowManager.LayoutParams(r10, -2, r18.f217d, r18.f218e, 1002, 8519680, -3);
        r5.gravity = r18.f216c;
        r5.windowAnimations = r18.f;
        r3.addView(r18.g, r5);
        r18.o = true;
        if (r18.f214a != 0) goto L73;
        updateBackInvokedCallbackState();
        return;
    L73:
        return;
    L65:
        r10 = -2;
    L40:
        if (r18.g != null) goto L47;
        if (initializePanelDecor(r18) == true) goto L44;
        return;
    L44:
        if (r18.g != null) goto L52;
        return;
    L52:
        if (initializePanelContent(r18) == true) goto L54;
    L70:
        r18.q = true;
        return;
    L54:
        if (r18.a() == false) goto L70;
        ViewGroup.LayoutParams r6 = r18.h.getLayoutParams();
        if (r6 != null) goto L59;
        r6 = new ViewGroup.LayoutParams(-2, -2);
    L59:
        r18.g.setBackgroundResource(r18.f215b);
        ViewParent r7 = r18.h.getParent();
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.class) == false) goto L62;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(r18.h);
    L62:
        r18.g.addView(r18.h, r6);
        if (r18.h.hasFocus() == true) goto L65;
        r18.h.requestFocus();
        goto L65
    L47:
        if (r18.q == false) goto L52;
        if (r18.g.getChildCount() <= 0) goto L52;
        r18.g.removeAllViews();
        goto L52
    L18:
        if (r2.onMenuOpened(r18.f214a, r18.j) == true) goto L21;
        closePanel(r18, true);
        return;
    L10:
        if ((ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").getConfiguration().screenLayout & 15) != 4) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        return;
    L12:
        r8 = false;
        goto L13
    }

    private boolean initializePanelDecor(PanelFeatureState r4) {
        r4.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActionBarThemedContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r4.g = new ListMenuDecorView(this, r4.l);
        r4.f216c = 81;
        return true;
    }

    private void reopenMenu(boolean r6) {
        o r0 = this.mDecorContentParent;
        if (r0 != null) goto L5;
    L33:
        PanelFeatureState r7 = getPanelState(0, true);
        r7.q = true;
        closePanel(r7, false);
        openPanel(r7, null);
        return;
    L5:
        if (r0.canShowOverflowMenu() == false) goto L33;
        if (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() == true) goto L9;
    L10:
        Window.Callback r1 = getWindowCallback();
        if (this.mDecorContentParent.isOverflowMenuShowing() == false) goto L17;
        if (r6 == false) goto L17;
        this.mDecorContentParent.hideOverflowMenu();
        if (this.mDestroyed == true) goto L35;
        r1.onPanelClosed(108, getPanelState(0, true).j);
        return;
    L35:
        return;
    L17:
        if (r1 != null) goto L19;
        return;
    L19:
        if (this.mDestroyed == false) goto L21;
        return;
    L21:
        if (this.mInvalidatePanelMenuPosted == true) goto L23;
    L25:
        PanelFeatureState r8 = getPanelState(0, true);
        if (r8.j != null) goto L28;
        return;
    L28:
        if (r8.r == false) goto L30;
        return;
    L30:
        if (r1.onPreparePanel(0, r8.i, r8.j) == false) goto L41;
        r1.onMenuOpened(108, r8.j);
        this.mDecorContentParent.showOverflowMenu();
        return;
    L41:
        return;
    L23:
        if ((this.mInvalidatePanelMenuFeatures & 1) == 0) goto L25;
        this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuRunnable.run();
        goto L25
    L9:
        if (this.mDecorContentParent.isOverflowMenuShowPending() == false) goto L33;
        goto L10
    }

    private boolean initializePanelMenu(PanelFeatureState r10) {
        Context r0 = this.mContext;
        if (r10.f214a == 0) goto L7;
        if (r10.f214a == 108) goto L7;
    L19:
        MenuBuilder r1 = new MenuBuilder(r0);
        r1.setCallback(this);
        r10.a(r1);
        return true;
    L7:
        if (this.mDecorContentParent == null) goto L19;
        TypedValue r2 = new TypedValue();
        Resources.Theme r3 = r0.getTheme();
        r3.resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarTheme, "attr", "actionBarTheme"), r2, true);
        Resources.Theme r4 = null;
        if (r2.resourceId == 0) goto L11;
        r4 = ZeusTransformUtils.getResources(r0, "com.obric.aiagent.plugin").newTheme();
        r4.setTo(r3);
        r4.applyStyle(r2.resourceId, true);
        r4.resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarWidgetTheme, "attr", "actionBarWidgetTheme"), r2, true);
    L13:
        if (r2.resourceId == 0) goto L17;
        if (r4 != null) goto L16;
        r4 = ZeusTransformUtils.getResources(r0, "com.obric.aiagent.plugin").newTheme();
        r4.setTo(r3);
    L16:
        r4.applyStyle(r2.resourceId, true);
    L17:
        if (r4 == null) goto L19;
        ContextThemeWrapper r5 = new ContextThemeWrapper(r0, 0);
        r5.getTheme().setTo(r4);
        r0 = r5;
        goto L19
    L11:
        r3.resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarWidgetTheme, "attr", "actionBarWidgetTheme"), r2, true);
        goto L13
    }

    private boolean initializePanelContent(PanelFeatureState r5) {
        if (r5.i == null) goto L7;
        r5.h = r5.i;
        return true;
    L7:
        if (r5.j != null) goto L10;
        return false;
    L10:
        if (this.mPanelMenuPresenterCallback != null) goto L12;
        this.mPanelMenuPresenterCallback = new n(this);
    L12:
        r5.h = (View) ZeusTransformUtils.preCheckCast(r5.a(this.mPanelMenuPresenterCallback), View.class, "com.obric.aiagent.plugin");
        if (r5.h == null) goto L16;
        return true;
    L16:
        return false;
    }

    private boolean preparePanel(PanelFeatureState r9, KeyEvent r10) {
        if (this.mDestroyed == false) goto L6;
        return false;
    L6:
        if (r9.m == false) goto L8;
        return true;
    L8:
        PanelFeatureState r0 = this.mPreparedPanel;
        if (r0 == null) goto L12;
        if (r0 == r9) goto L12;
        closePanel(r0, false);
    L12:
        Window.Callback r1 = getWindowCallback();
        if (r1 == null) goto L16;
        r9.i = r1.onCreatePanelView(r9.f214a);
    L16:
        if (r9.f214a != 0) goto L18;
    L21:
        boolean r3 = true;
    L22:
        if (r3 == false) goto L27;
        o r4 = this.mDecorContentParent;
        if (r4 == null) goto L27;
        r4.setMenuPrepared();
    L27:
        if (r9.i != null) goto L77;
        if (r3 == false) goto L32;
        if (ZeusTransformUtils.instanceOf(peekSupportActionBar(), androidx.appcompat.app.h.class) == true) goto L77;
    L32:
        if (r9.j == null) goto L36;
        if (r9.r == true) goto L36;
    L58:
        r9.j.stopDispatchingItemsChanged();
        if (r9.s == null) goto L62;
        r9.j.restoreActionViewStates(r9.s);
        r9.s = null;
    L62:
        if (r1.onPreparePanel(0, r9.i, r9.j) == true) goto L69;
        if (r3 == false) goto L67;
        o r11 = this.mDecorContentParent;
        if (r11 == null) goto L67;
        r11.setMenu(null, this.mActionMenuPresenterCallback);
    L67:
        r9.j.startDispatchingItemsChanged();
        return false;
    L69:
        if (r10 == null) goto L71;
        int r12 = r10.getDeviceId();
    L73:
        if (KeyCharacterMap.load(r12).getKeyboardType() == 1) goto L75;
        boolean r13 = true;
    L76:
        r9.p = r13;
        r9.j.setQwertyMode(r9.p);
        r9.j.startDispatchingItemsChanged();
        goto L77
    L75:
        r13 = false;
        goto L76
    L71:
        r12 = -1;
    L36:
        if (r9.j == null) goto L38;
    L42:
        if (r3 == true) goto L44;
    L49:
        r9.j.stopDispatchingItemsChanged();
        if (r1.onCreatePanelMenu(r9.f214a, r9.j) == true) goto L57;
        r9.a(null);
        if (r3 == false) goto L56;
        o r14 = this.mDecorContentParent;
        if (r14 == null) goto L56;
        r14.setMenu(null, this.mActionMenuPresenterCallback);
    L56:
        return false;
    L57:
        r9.r = false;
        goto L58
    L44:
        if (this.mDecorContentParent == null) goto L49;
        if (this.mActionMenuPresenterCallback != null) goto L48;
        this.mActionMenuPresenterCallback = new c(this);
    L48:
        this.mDecorContentParent.setMenu(r9.j, this.mActionMenuPresenterCallback);
        goto L49
    L38:
        if (initializePanelMenu(r9) == true) goto L40;
    L41:
        return false;
    L40:
        if (r9.j != null) goto L42;
    L77:
        r9.m = true;
        r9.n = false;
        this.mPreparedPanel = r9;
        return true;
    L18:
        if (r9.f214a == 108) goto L21;
        r3 = false;
        goto L22
    }

    void checkCloseActionMenu(MenuBuilder r3) {
        if (this.mClosingActionMenu == false) goto L5;
        return;
    L5:
        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        Window.Callback r0 = getWindowCallback();
        if (r0 != null) goto L8;
    L10:
        this.mClosingActionMenu = false;
        return;
    L8:
        if (this.mDestroyed == true) goto L10;
        r0.onPanelClosed(108, r3);
        goto L10
    }

    void closePanel(int r2) {
        closePanel(getPanelState(r2, true), true);
    }

    void closePanel(PanelFeatureState r4, boolean r5) {
        if (r5 == true) goto L4;
    L11:
        WindowManager r0 = (WindowManager) ZeusTransformUtils.preCheckCast(this.mContext.getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L14;
    L20:
        r4.m = false;
        r4.n = false;
        r4.o = false;
        r4.h = null;
        r4.q = true;
        if (this.mPreparedPanel != r4) goto L24;
        this.mPreparedPanel = null;
    L24:
        if (r4.f214a != 0) goto L27;
        updateBackInvokedCallbackState();
        return;
    L27:
        return;
    L14:
        if (r4.o == false) goto L20;
        if (r4.g == null) goto L20;
        r0.removeView(r4.g);
        if (r5 == false) goto L20;
        callOnPanelClosed(r4.f214a, r4, null);
        goto L20
    L4:
        if (r4.f214a != 0) goto L11;
        o r1 = this.mDecorContentParent;
        if (r1 == null) goto L11;
        if (r1.isOverflowMenuShowing() == false) goto L11;
        checkCloseActionMenu(r4.j);
    }

    private boolean onKeyDownPanel(int r2, KeyEvent r3) {
        if (r3.getRepeatCount() != 0) goto L8;
        PanelFeatureState r4 = getPanelState(r2, true);
        if (r4.o == false) goto L7;
        return false;
    L7:
        return preparePanel(r4, r3);
    L8:
        return false;
    }

    private boolean onKeyUpPanel(int r4, KeyEvent r5) {
        if (this.mActionMode == null) goto L5;
        return false;
    L5:
        boolean r0 = true;
        PanelFeatureState r2 = getPanelState(r4, true);
        if (r4 != 0) goto L22;
        o r6 = this.mDecorContentParent;
        if (r6 == null) goto L22;
        if (r6.canShowOverflowMenu() == false) goto L22;
        if (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() == true) goto L22;
        if (this.mDecorContentParent.isOverflowMenuShowing() == false) goto L16;
        r0 = this.mDecorContentParent.hideOverflowMenu();
    L36:
        if (r0 == false) goto L41;
        AudioManager r3 = (AudioManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContext.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("audio"), AudioManager.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L40;
        r3.playSoundEffect(0);
        goto L41
    L40:
        INVOKESTATIC_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("AppCompatDelegate", "Couldn't get audio manager");
    L41:
        return r0;
    L16:
        if (this.mDestroyed == false) goto L18;
    L34:
        r0 = false;
        goto L36
    L18:
        if (preparePanel(r2, r5) == false) goto L34;
        r0 = this.mDecorContentParent.showOverflowMenu();
    L22:
        if (r2.o == false) goto L24;
    L35:
        boolean r7 = r2.o;
        closePanel(r2, true);
        r0 = r7;
        goto L36
    L24:
        if (r2.n == true) goto L35;
        if (r2.m == false) goto L34;
        if (r2.r == false) goto L31;
        r2.m = false;
        boolean r8 = preparePanel(r2, r5);
    L32:
        if (r8 == false) goto L34;
        openPanel(r2, r5);
        goto L36
    L31:
        r8 = true;
        goto L32
    }

    void callOnPanelClosed(int r3, PanelFeatureState r4, Menu r5) {
        Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L11;
        if (r4 != null) goto L9;
        if (r3 < 0) goto L9;
        PanelFeatureState[] r0 = this.mPanels;
        if (r3 >= r0.length) goto L9;
        r4 = r0[r3];
    L9:
        if (r4 == null) goto L11;
        r6 = r4.j;
    L11:
        if (r4 == null) goto L16;
        if (r4.o == true) goto L16;
        return;
    L16:
        if (this.mDestroyed == true) goto L19;
        this.mAppCompatWindowCallback.bypassOnPanelClosed(this.mWindow.getCallback(), r3, r6);
        return;
    }

    PanelFeatureState findMenuPanel(Menu r5) {
        Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.aiagent.plugin");
        PanelFeatureState[] r4 = this.mPanels;
        int r0 = 0;
        if (r4 == null) goto L5;
        int r1 = r4.length;
    L6:
        if (r0 >= r1) goto L13;
        PanelFeatureState r2 = r4[r0];
        if (r2 == null) goto L12;
        if (r2.j != r6) goto L12;
        return r2;
    L12:
        r0 = r0 + 1;
        goto L6
    L13:
        return null;
    L5:
        r1 = 0;
        goto L6
    }

    public PanelFeatureState getPanelState(int r4, boolean r5) {
        PanelFeatureState[] r6 = this.mPanels;
        if (r6 != null) goto L5;
    L6:
        PanelFeatureState[] r0 = new PanelFeatureState[r4 + 1];
        if (r6 == null) goto L9;
        System.arraycopy(r6, 0, r0, 0, r6.length);
    L9:
        this.mPanels = r0;
        r6 = r0;
    L10:
        PanelFeatureState r3 = r6[r4];
        if (r3 != null) goto L14;
        PanelFeatureState r7 = new PanelFeatureState(r4);
        r6[r4] = r7;
        return r7;
    L14:
        return r3;
    L5:
        if (r6.length > r4) goto L10;
        goto L6
    }

    private boolean performPanelShortcut(PanelFeatureState r3, int r4, KeyEvent r5, int r6) {
        boolean r1 = false;
        if (r5.isSystem() == false) goto L6;
        return false;
    L6:
        if (r3.m == true) goto L10;
        if (preparePanel(r3, r5) == true) goto L10;
    L12:
        if (r1 == true) goto L14;
    L18:
        return r1;
    L14:
        if ((r6 & 1) != 0) goto L18;
        if (this.mDecorContentParent != null) goto L18;
        closePanel(r3, true);
    L10:
        if (r3.j == null) goto L12;
        r1 = r3.j.performShortcut(r4, r5, r6);
        goto L12
    }

    private void invalidatePanelMenu(int r3) {
        int r4 = 1 << r3;
        this.mInvalidatePanelMenuFeatures = r4 | this.mInvalidatePanelMenuFeatures;
        if (this.mInvalidatePanelMenuPosted == true) goto L6;
        ViewCompat.a(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuPosted = true;
        return;
    }

    void doInvalidatePanelMenu(int r5) {
        PanelFeatureState r1 = getPanelState(r5, true);
        if (r1.j == null) goto L8;
        Bundle r2 = new Bundle();
        r1.j.saveActionViewStates(r2);
        if (r2.size() <= 0) goto L7;
        r1.s = r2;
    L7:
        r1.j.stopDispatchingItemsChanged();
        r1.j.clear();
    L8:
        r1.r = true;
        r1.q = true;
        if (r5 == 108) goto L12;
        if (r5 == 0) goto L12;
        return;
    L12:
        if (this.mDecorContentParent == null) goto L18;
        PanelFeatureState r0 = getPanelState(0, false);
        if (r0 == null) goto L19;
        r0.m = false;
        preparePanel(r0, null);
        return;
    L19:
        return;
    }

    final int updateStatusGuard(al r11, Rect r12) {
        int r0 = 0;
        if (r11 == null) goto L5;
        int r1 = r11.b();
    L8:
        ActionBarContextView r2 = this.mActionModeView;
        if (r2 != null) goto L11;
    L69:
        boolean r13 = false;
    L70:
        View r10 = this.mStatusGuard;
        if (r10 == null) goto L76;
        if (r13 == true) goto L75;
        r0 = 8;
    L75:
        r10.setVisibility(r0);
    L76:
        return r1;
    L11:
        if (ZeusTransformUtils.instanceOf(r2.getLayoutParams(), ViewGroup.MarginLayoutParams.class) == false) goto L69;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(this.mActionModeView.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        boolean r6 = true;
        if (this.mActionModeView.isShown() == false) goto L64;
        if (this.mTempRect1 != null) goto L17;
        this.mTempRect1 = new Rect();
        this.mTempRect2 = new Rect();
    L17:
        Rect r4 = this.mTempRect1;
        Rect r7 = this.mTempRect2;
        if (r11 != null) goto L20;
        r4.set(r12);
    L21:
        ac.a(this.mSubDecor, r4, r7);
        int r14 = r4.top;
        int r15 = r4.left;
        int r5 = r4.right;
        al r8 = ViewCompat.w(this.mSubDecor);
        if (r8 != null) goto L24;
        int r9 = 0;
    L25:
        if (r8 != null) goto L27;
        int r16 = 0;
    L29:
        if (r3.topMargin == r14) goto L31;
    L36:
        r3.topMargin = r14;
        r3.leftMargin = r15;
        r3.rightMargin = r5;
        boolean r17 = true;
    L37:
        if (r14 > 0) goto L39;
    L41:
        View r18 = this.mStatusGuard;
        if (r18 == null) goto L50;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r18.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r19.height == r3.topMargin) goto L46;
    L49:
        r19.height = r3.topMargin;
        r19.leftMargin = r9;
        r19.rightMargin = r16;
        this.mStatusGuard.setLayoutParams(r19);
        goto L50
    L46:
        if (r19.leftMargin != r9) goto L49;
        if (r19.rightMargin != r16) goto L49;
    L50:
        View r110 = this.mStatusGuard;
        if (r110 != null) goto L54;
        r6 = false;
    L54:
        if (r6 == false) goto L59;
        if (r110.getVisibility() == 0) goto L59;
        updateStatusGuardColor(this.mStatusGuard);
    L59:
        if (this.mOverlayActionMode == true) goto L62;
        if (r6 == false) goto L62;
        r1 = 0;
    L62:
        r13 = r6;
        r6 = r17;
    L67:
        if (r6 == false) goto L70;
        this.mActionModeView.setLayoutParams(r3);
        goto L70
    L39:
        if (this.mStatusGuard != null) goto L41;
        View r111 = new View(this.mContext);
        this.mStatusGuard = r111;
        r111.setVisibility(8);
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-1, r3.topMargin, 51);
        r112.leftMargin = r9;
        r112.rightMargin = r16;
        this.mSubDecor.addView(this.mStatusGuard, -1, r112);
        goto L50
    L31:
        if (r3.leftMargin != r15) goto L36;
        if (r3.rightMargin != r5) goto L36;
        r17 = false;
        goto L37
    L27:
        r16 = r8.c();
        goto L29
    L24:
        r9 = r8.a();
        goto L25
    L20:
        r4.set(r11.a(), r11.b(), r11.c(), r11.d());
        goto L21
    L64:
        if (r3.topMargin == 0) goto L66;
        r3.topMargin = 0;
        r13 = false;
        goto L67
    L66:
        r13 = false;
        r6 = false;
        goto L67
    L5:
        if (r12 == null) goto L7;
        r1 = r12.top;
        goto L8
    L7:
        r1 = 0;
        goto L8
    }

    private void updateStatusGuardColor(View r4) {
        if ((ViewCompat.t(r4) & 8192) == 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        int r3 = androidx.core.content.a.c(this.mContext, ZeusTransformUtils.mapRes(R.color.abc_decor_view_status_guard_light, "color", "abc_decor_view_status_guard_light"));
    L10:
        r4.setBackgroundColor(r3);
        return;
    L9:
        r3 = androidx.core.content.a.c(this.mContext, ZeusTransformUtils.mapRes(R.color.abc_decor_view_status_guard, "color", "abc_decor_view_status_guard"));
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled == true) goto L6;
        return;
    L6:
        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    private int sanitizeWindowFeatureId(int r2) {
        if (r2 != 8) goto L7;
        INVOKESTATIC_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
        return 108;
    L7:
        if (r2 != 9) goto L10;
        INVOKESTATIC_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    L10:
        return r2;
    }

    ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    void dismissPopups() {
        o r0 = this.mDecorContentParent;
        if (r0 == null) goto L6;
        r0.dismissPopups();
    L6:
        if (this.mActionModePopup == null) goto L11;
        this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
        if (this.mActionModePopup.isShowing() == true) goto L18;
    L10:
        this.mActionModePopup = null;
        goto L11
    L18:
        this.mActionModePopup.dismiss();     // Catch: IllegalArgumentException -> L17
    L11:
        endOnGoingFadeAnimation();
        PanelFeatureState r2 = getPanelState(0, false);
        if (r2 != null) goto L14;
        return;
    L14:
        if (r2.j == null) goto L21;
        r2.j.close();
        return;
    }

    @Override // androidx.appcompat.app.c
    public Context getContextForDelegate() {
        return this.mContext;
    }

    @Override // androidx.appcompat.app.c
    public boolean applyDayNight() {
        return applyApplicationSpecificConfig(true);
    }

    @Override // androidx.appcompat.app.c
    boolean applyAppLocales() {
        if (isAutoStorageOptedIn(this.mContext) == false) goto L10;
        if (getRequestedAppLocales() == null) goto L10;
        if (getRequestedAppLocales().equals(getStoredAppLocales()) == true) goto L10;
        asyncExecuteSyncRequestedAndStoredLocales(this.mContext);
    L10:
        return applyApplicationSpecificConfig(true);
    }

    private boolean applyApplicationSpecificConfig(boolean r2) {
        return applyApplicationSpecificConfig(r2, true);
    }

    private boolean applyApplicationSpecificConfig(boolean r6, boolean r7) {
        if (this.mDestroyed == false) goto L6;
        return false;
    L6:
        int r0 = calculateNightMode();
        int r1 = mapNightMode(this.mContext, r0);
        androidx.core.os.i r2 = null;
        if (Build.VERSION.SDK_INT >= 33) goto L9;
        r2 = calculateApplicationLocales(this.mContext);
    L9:
        if (r7 == true) goto L12;
        if (r2 == null) goto L12;
        r2 = getConfigurationLocales(ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").getConfiguration());
    L12:
        boolean r8 = updateAppConfiguration(r1, r2, r6);
        if (r0 != 0) goto L15;
        getAutoTimeNightModeManager(this.mContext).d();
    L19:
        if (r0 != 3) goto L21;
        getAutoBatteryNightModeManager(this.mContext).d();
    L24:
        return r8;
    L21:
        k r5 = this.mAutoBatteryNightModeManager;
        if (r5 == null) goto L24;
        r5.e();
        goto L24
    L15:
        k r9 = this.mAutoTimeNightModeManager;
        if (r9 == null) goto L19;
        r9.e();
        goto L19
    }

    androidx.core.os.i calculateApplicationLocales(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 33) goto L5;
        return null;
    L5:
        androidx.core.os.i r0 = getRequestedAppLocales();
        if (r0 != null) goto L8;
        return null;
    L8:
        androidx.core.os.i r4 = getConfigurationLocales(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration());
        if (Build.VERSION.SDK_INT < 24) goto L12;
        androidx.core.os.i r7 = androidx.appcompat.app.f.a(r0, r4);
    L16:
        if (r7.b() == false) goto L19;
        return r4;
    L19:
        return r7;
    L12:
        if (r0.b() == false) goto L14;
        r7 = androidx.core.os.i.e();
        goto L16
    L14:
        r7 = androidx.core.os.i.a(r0.a(0).toString());
        goto L16
    }

    @Override // androidx.appcompat.app.c
    public void setLocalNightMode(int r2) {
        if (this.mLocalNightMode == r2) goto L8;
        this.mLocalNightMode = r2;
        if (this.mBaseContextAttached == false) goto L9;
        applyDayNight();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.c
    public int getLocalNightMode() {
        return this.mLocalNightMode;
    }

    int mapNightMode(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 == (-100)) goto L24;
        if (r5 == (-1)) goto L23;
        if (r5 == 0) goto L17;
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L23;
        if (r5 != 3) goto L15;
        return getAutoBatteryNightModeManager(r6).a();
    L15:
        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
    L17:
        if (Build.VERSION.SDK_INT < 23) goto L22;
        if (((UiModeManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("uimode"), UiModeManager.class, "com.obric.aiagent.plugin")).getNightMode() != 0) goto L22;
        return -1;
    L22:
        return getAutoTimeNightModeManager(r6).a();
    L23:
        return r5;
    L24:
        return -1;
    }

    private int calculateNightMode() {
        int r1 = this.mLocalNightMode;
        if (r1 == (-100)) goto L6;
        return r1;
    L6:
        return getDefaultNightMode();
    }

    void setConfigurationLocales(Configuration r3, androidx.core.os.i r4) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        g.a(r3, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 17) goto L8;
        e.b(r3, r4.a(0));
        e.a(r3, r4.a(0));
        return;
    L8:
        r3.locale = r4.a(0);
    }

    androidx.core.os.i getConfigurationLocales(Configuration r2) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return g.a(r2);
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L11;
        return androidx.core.os.i.a(f.a(r2.locale));
    L11:
        return androidx.core.os.i.a(new Locale[]{r2.locale});
    }

    void setDefaultLocalesForLocaleList(androidx.core.os.i r2) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        g.a(r2);
        return;
    L5:
        Locale.setDefault(r2.a(0));
    }

    private Configuration createOverrideAppConfiguration(Context r3, int r4, androidx.core.os.i r5, Configuration r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 != 1) goto L5;
        int r9 = 16;
    L11:
        Configuration r10 = new Configuration();
        r10.fontScale = 0.0f;
        if (r6 == null) goto L14;
        r10.setTo(r6);
    L14:
        r10.uiMode = r9 | (r10.uiMode & (-49));
        if (r5 == null) goto L17;
        setConfigurationLocales(r10, r5);
    L17:
        return r10;
    L5:
        if (r4 == 2) goto L9;
        if (r7 == false) goto L8;
        r9 = 0;
        goto L11
    L8:
        r9 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().uiMode & 48;
        goto L11
    L9:
        r9 = 32;
        goto L11
    }

    private boolean updateAppConfiguration(int r10, androidx.core.os.i r11, boolean r12) {
        Configuration r0 = createOverrideAppConfiguration(this.mContext, r10, r11, null, false);
        int r1 = getActivityHandlesConfigChangesFlags(this.mContext);
        Configuration r2 = this.mEffectiveConfiguration;
        if (r2 != null) goto L5;
        r2 = ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").getConfiguration();
    L5:
        int r4 = r2.uiMode & 48;
        int r5 = r0.uiMode & 48;
        androidx.core.os.i r3 = getConfigurationLocales(r2);
        if (r11 != null) goto L8;
        androidx.core.os.i r6 = null;
    L9:
        boolean r7 = false;
        if (r4 == r5) goto L12;
        int r8 = 512;
    L13:
        if (r6 != null) goto L15;
    L19:
        boolean r9 = true;
        if (((~r1) & r8) == 0) goto L33;
        if (r12 == false) goto L33;
        if (this.mBaseContextAttached == false) goto L33;
        if (sCanReturnDifferentContext == true) goto L29;
        if (this.mCreated == false) goto L33;
    L29:
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L33;
        if (((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.aiagent.plugin")).isChild() == true) goto L33;
        ActivityCompat.e((Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.aiagent.plugin"));
        boolean r13 = true;
    L34:
        if (r13 == true) goto L40;
        if (r8 == 0) goto L40;
        if ((r8 & r1) != r8) goto L39;
        r7 = true;
    L39:
        updateResourcesConfiguration(r5, r6, r7, null);
    L41:
        if (r9 == true) goto L43;
    L50:
        if (r9 == false) goto L53;
        if (r6 == null) goto L53;
        setDefaultLocalesForLocaleList(getConfigurationLocales(ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin").getConfiguration()));
    L53:
        return r9;
    L43:
        if (ZeusTransformUtils.instanceOf(this.mHost, AppCompatActivity.class) == false) goto L50;
        if ((r8 & 512) == 0) goto L48;
        ((AppCompatActivity) ZeusTransformUtils.preCheckCast(this.mHost, AppCompatActivity.class, "com.obric.aiagent.plugin")).onNightModeChanged(r10);
    L48:
        if ((r8 & 4) == 0) goto L50;
        ((AppCompatActivity) ZeusTransformUtils.preCheckCast(this.mHost, AppCompatActivity.class, "com.obric.aiagent.plugin")).onLocalesChanged(r11);
    L40:
        r9 = r13;
    L33:
        r13 = false;
        goto L34
    L15:
        if (r3.equals(r6) == true) goto L19;
        r8 = r8 | 4;
        if (Build.VERSION.SDK_INT < 17) goto L19;
        r8 = r8 | 8192;
        goto L19
    L12:
        r8 = 0;
        goto L13
    L8:
        r6 = getConfigurationLocales(r0);
        goto L9
    }

    private void updateResourcesConfiguration(int r4, androidx.core.os.i r5, boolean r6, Configuration r7) {
        Resources r0 = ZeusTransformUtils.getResources(this.mContext, "com.obric.aiagent.plugin");
        Configuration r1 = new Configuration(r0.getConfiguration());
        if (r7 == null) goto L5;
        r1.updateFrom(r7);
    L5:
        r1.uiMode = r4 | (r0.getConfiguration().uiMode & (-49));
        if (r5 == null) goto L8;
        setConfigurationLocales(r1, r5);
    L8:
        r0.updateConfiguration(r1, null);
        if (Build.VERSION.SDK_INT >= 26) goto L11;
        androidx.appcompat.app.g.a(r0);
    L11:
        int r8 = this.mThemeResId;
        if (r8 == 0) goto L16;
        this.mContext.setTheme(r8);
        if (Build.VERSION.SDK_INT < 23) goto L16;
        this.mContext.getTheme().applyStyle(this.mThemeResId, true);
    L16:
        if (r6 == true) goto L18;
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L22;
        updateActivityConfiguration(r1);
        return;
    }

    private void updateActivityConfiguration(Configuration r4) {
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(this.mHost, Activity.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, p.class) == false) goto L8;
        if (((p) ZeusTransformUtils.preCheckCast(r0, p.class, "com.obric.aiagent.plugin")).getLifecycle().b().a(androidx.lifecycle.i.b.f2056c) == false) goto L13;
        r0.onConfigurationChanged(r4);
        return;
    L13:
        return;
    L8:
        if (this.mCreated == true) goto L10;
        return;
    L10:
        if (this.mDestroyed == true) goto L16;
        r0.onConfigurationChanged(r4);
        return;
    }

    final k getAutoTimeNightModeManager() {
        return getAutoTimeNightModeManager(this.mContext);
    }

    private k getAutoTimeNightModeManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (this.mAutoTimeNightModeManager != null) goto L6;
        this.mAutoTimeNightModeManager = new l(this, androidx.appcompat.app.j.a(r4));
    L6:
        return this.mAutoTimeNightModeManager;
    }

    private k getAutoBatteryNightModeManager(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (this.mAutoBatteryNightModeManager != null) goto L6;
        this.mAutoBatteryNightModeManager = new j(this, r4);
    L6:
        return this.mAutoBatteryNightModeManager;
    }

    private int getActivityHandlesConfigChangesFlags(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (this.mActivityHandlesConfigFlagsChecked == false) goto L5;
    L22:
        this.mActivityHandlesConfigFlagsChecked = true;
        return this.mActivityHandlesConfigFlags;
    L5:
        if (ZeusTransformUtils.instanceOf(this.mHost, Activity.class) == false) goto L22;
        PackageManager r0 = r7.getPackageManager();
        if (r0 != null) goto L24;
        return 0;
    L24:
    L20:
        e = move-exception;
        INVOKESTATIC_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
        this.mActivityHandlesConfigFlags = 0;
        goto L22
    L10:
        if (Build.VERSION.SDK_INT < 29) goto L13;
        int r2 = 269221888;
    L16:
        ActivityInfo r8 = r0.getActivityInfo(new ComponentName(r7, this.mHost.getClass()), r2);     // Catch: PackageManager.NameNotFoundException -> L20
        if (r8 == null) goto L22;
        this.mActivityHandlesConfigFlags = r8.configChanges;     // Catch: PackageManager.NameNotFoundException -> L20
        goto L22
    L13:
        if (Build.VERSION.SDK_INT < 24) goto L15;
        r2 = 786432;
        goto L16
    L15:
        r2 = 0;
        goto L16
    }

    @Override // androidx.appcompat.app.c
    public final androidx.appcompat.app.a.InterfaceC0008a getDrawerToggleDelegate() {
        return new a(this);
    }

    private static Configuration generateConfigDelta(Configuration r3, Configuration r4) {
        Configuration r0 = new Configuration();
        r0.fontScale = 0.0f;
        if (r4 != null) goto L5;
    L73:
        return r0;
    L5:
        if (r3.diff(r4) == 0) goto L73;
        if (r3.fontScale == r4.fontScale) goto L11;
        r0.fontScale = r4.fontScale;
    L11:
        if (r3.mcc == r4.mcc) goto L14;
        r0.mcc = r4.mcc;
    L14:
        if (r3.mnc == r4.mnc) goto L17;
        r0.mnc = r4.mnc;
    L17:
        if (Build.VERSION.SDK_INT < 24) goto L20;
        g.a(r3, r4, r0);
    L23:
        if (r3.touchscreen == r4.touchscreen) goto L26;
        r0.touchscreen = r4.touchscreen;
    L26:
        if (r3.keyboard == r4.keyboard) goto L29;
        r0.keyboard = r4.keyboard;
    L29:
        if (r3.keyboardHidden == r4.keyboardHidden) goto L32;
        r0.keyboardHidden = r4.keyboardHidden;
    L32:
        if (r3.navigation == r4.navigation) goto L35;
        r0.navigation = r4.navigation;
    L35:
        if (r3.navigationHidden == r4.navigationHidden) goto L38;
        r0.navigationHidden = r4.navigationHidden;
    L38:
        if (r3.orientation == r4.orientation) goto L41;
        r0.orientation = r4.orientation;
    L41:
        if ((r3.screenLayout & 15) == (r4.screenLayout & 15)) goto L44;
        r0.screenLayout |= r4.screenLayout & 15;
    L44:
        if ((r3.screenLayout & 192) == (r4.screenLayout & 192)) goto L47;
        r0.screenLayout |= r4.screenLayout & 192;
    L47:
        if ((r3.screenLayout & 48) == (r4.screenLayout & 48)) goto L50;
        r0.screenLayout |= r4.screenLayout & 48;
    L50:
        if ((r3.screenLayout & 768) == (r4.screenLayout & 768)) goto L53;
        r0.screenLayout |= r4.screenLayout & 768;
    L53:
        if (Build.VERSION.SDK_INT < 26) goto L56;
        h.a(r3, r4, r0);
    L56:
        if ((r3.uiMode & 15) == (r4.uiMode & 15)) goto L59;
        r0.uiMode |= r4.uiMode & 15;
    L59:
        if ((r3.uiMode & 48) == (r4.uiMode & 48)) goto L62;
        r0.uiMode |= r4.uiMode & 48;
    L62:
        if (r3.screenWidthDp == r4.screenWidthDp) goto L65;
        r0.screenWidthDp = r4.screenWidthDp;
    L65:
        if (r3.screenHeightDp == r4.screenHeightDp) goto L68;
        r0.screenHeightDp = r4.screenHeightDp;
    L68:
        if (r3.smallestScreenWidthDp == r4.smallestScreenWidthDp) goto L71;
        r0.smallestScreenWidthDp = r4.smallestScreenWidthDp;
    L71:
        if (Build.VERSION.SDK_INT < 17) goto L73;
        e.a(r3, r4, r0);
        goto L73
    L20:
        if (androidx.core.util.d.a(r3.locale, r4.locale) == true) goto L23;
        r0.locale = r4.locale;
        goto L23
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_appcompat_app_AppCompatDelegateImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
