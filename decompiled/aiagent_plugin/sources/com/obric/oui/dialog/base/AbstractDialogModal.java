package com.obric.oui.dialog.base;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.Size;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.dialog.v2.alert.style.AlertDialogHost;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.obric.oui.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: AbstractDialogModal.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractDialogModal extends FrameLayout implements AlertDialogHost {
    public static final b Companion = null;
    public static final String TAG = "AbstractDialogModal";
    private boolean autoDismissOnButtonClick;
    private int bgColor;
    private DialogInterface.OnCancelListener cancelListener;
    private ImageView closeIcon;
    private View closeIconContainer;
    private boolean closeIconEnabled;
    private a closeIconStyle;
    private DialogInterface.OnShowListener completeShowListener;
    private AbstractDialogModal$configurationCallback$1 configurationCallback;
    private boolean configurationCallbackRegistered;
    protected View contentRootView;
    private com.obric.oui.animation.a.b<View> dialogAnimator;
    public View dialogRootView;
    protected View dimView;
    private DialogInterface.OnDismissListener dismissListener;
    private boolean enableMaterial;
    private boolean hideFirstFrame;
    private Boolean includeCutoutInLandscape;
    private boolean isShowingModal;
    private Integer lastAppliedModalYPx;
    private boolean mCancelable;
    private final boolean matchParentHeight;
    private int maxRootViewHeightGap;
    private Integer modalYAnimCurrentPx;
    private Integer modalYAnimTargetPx;
    private ValueAnimator modalYAnimator;
    private Window.Callback myWindowCallback;
    private View.OnClickListener onCloseClickListener;
    private Window.Callback originalWindowCallback;
    private boolean pendingApplyModalPosition;
    private Integer rootFixedHeightPx;
    private boolean showAnimRunning;
    private DialogInterface.OnShowListener showListener;
    private boolean useNewDialogAnim;
    private final boolean widthMatch;

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    private static final class BackPressedWindowCallback implements Window.Callback {
        private final Window.Callback delegate;
        private final WeakReference<AbstractDialogModal> dialogRef;

        @Override // android.view.Window.Callback
        public boolean dispatchGenericMotionEvent(MotionEvent r1) {
            return this.delegate.dispatchGenericMotionEvent(r1);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent r1) {
            return this.delegate.dispatchKeyShortcutEvent(r1);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
            return this.delegate.dispatchPopulateAccessibilityEvent(r1);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent r1) {
            return this.delegate.dispatchTouchEvent(r1);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTrackballEvent(MotionEvent r1) {
            return this.delegate.dispatchTrackballEvent(r1);
        }

        @Override // android.view.Window.Callback
        public void onActionModeFinished(ActionMode r1) {
            this.delegate.onActionModeFinished(r1);
        }

        @Override // android.view.Window.Callback
        public void onActionModeStarted(ActionMode r1) {
            this.delegate.onActionModeStarted(r1);
        }

        @Override // android.view.Window.Callback
        public void onAttachedToWindow() {
            this.delegate.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            this.delegate.onContentChanged();
        }

        @Override // android.view.Window.Callback
        public boolean onCreatePanelMenu(int r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
            o.e(r5, "p1");
            return this.delegate.onCreatePanelMenu(r3, r5);
        }

        @Override // android.view.Window.Callback
        public View onCreatePanelView(int r1) {
            return this.delegate.onCreatePanelView(r1);
        }

        @Override // android.view.Window.Callback
        public void onDetachedFromWindow() {
            this.delegate.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public boolean onMenuItemSelected(int r3, MenuItem r4) {
            MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.aiagent.plugin");
            o.e(r5, "p1");
            return this.delegate.onMenuItemSelected(r3, r5);
        }

        @Override // android.view.Window.Callback
        public boolean onMenuOpened(int r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
            o.e(r5, "p1");
            return this.delegate.onMenuOpened(r3, r5);
        }

        @Override // android.view.Window.Callback
        public void onPanelClosed(int r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
            o.e(r5, "p1");
            this.delegate.onPanelClosed(r3, r5);
        }

        @Override // android.view.Window.Callback
        public boolean onPreparePanel(int r3, View r4, Menu r5) {
            Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r5, Menu.class, "com.obric.aiagent.plugin");
            o.e(r6, "p2");
            return this.delegate.onPreparePanel(r3, r4, r6);
        }

        @Override // android.view.Window.Callback
        public boolean onSearchRequested() {
            return this.delegate.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public boolean onSearchRequested(SearchEvent r1) {
            return this.delegate.onSearchRequested(r1);
        }

        @Override // android.view.Window.Callback
        public void onWindowAttributesChanged(WindowManager.LayoutParams r1) {
            this.delegate.onWindowAttributesChanged(r1);
        }

        @Override // android.view.Window.Callback
        public void onWindowFocusChanged(boolean r1) {
            this.delegate.onWindowFocusChanged(r1);
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback r3) {
            ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin");
            return this.delegate.onWindowStartingActionMode(r4);
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback r3, int r4) {
            ActionMode.Callback r5 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin");
            return this.delegate.onWindowStartingActionMode(r5, r4);
        }

        public BackPressedWindowCallback(AbstractDialogModal r3, Window.Callback r4) {
            Window.Callback r5 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r4, Window.Callback.class, "com.obric.aiagent.plugin");
            o.e(r3, "dialog");
            o.e(r5, "delegate");
            this.delegate = r5;
            this.dialogRef = new WeakReference(r3);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent r4) {
            o.e(r4, "event");
            AbstractDialogModal r0 = (AbstractDialogModal) ZeusTransformUtils.preCheckCast(this.dialogRef.get(), AbstractDialogModal.class, "com.obric.aiagent.plugin");
            if (r0 == null) goto L13;
            if (r4.getKeyCode() != 4) goto L13;
            if (r4.getAction() != 1) goto L13;
            if (r0.isShowingModal() == false) goto L13;
            r0.cancel();
            return true;
        L13:
            return this.delegate.dispatchKeyEvent(r4);
        }
    }

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f35079a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f35080b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f35081c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f35082d = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f35079a, f35080b, f35081c};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f35082d.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f35079a = new a("LIGHT", 0);
            f35080b = new a("DARK", 1);
            f35081c = new a("CUSTOM", 2);
            f35082d = a();
        }
    }

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35083a = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f35080b.ordinal()] = 1;
            r0[a.f35079a.ordinal()] = 2;
            r0[a.f35081c.ordinal()] = 3;
            f35083a = r0;
        }
    }

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    static final class d extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialogModal f35084a;

        d(AbstractDialogModal r1) {
            this.f35084a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            if (this.f35084a.getDialogRootView().getAlpha() != 0.0f) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L9;
            this.f35084a.getDialogRootView().setAlpha(1.0f);
            return;
        L9:
            return;
        L5:
            r3 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    static final class e extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialogModal f35085a;

        e(AbstractDialogModal r1) {
            this.f35085a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f35085a.completeOnShow();
        }
    }

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    static final class f extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialogModal f35086a;

        f(AbstractDialogModal r1) {
            this.f35086a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f35086a.completeOnShow();
        }
    }

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    static final class g extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialogModal f35087a;

        g(AbstractDialogModal r1) {
            this.f35087a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f35087a.completeOnShow();
        }
    }

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    static final class h extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialogModal f35088a;

        h(AbstractDialogModal r1) {
            this.f35088a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f35088a.completeOnShow();
        }
    }

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    static final class i extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialogModal f35089a;

        i(AbstractDialogModal r1) {
            this.f35089a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f35089a.originDismiss();
        }
    }

    /* JADX INFO: compiled from: AbstractDialogModal.kt */
    static final class j extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialogModal f35090a;

        j(AbstractDialogModal r1) {
            this.f35090a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f35090a.originDismiss();
        }
    }

    static {
        Companion = new b(null);
    }

    public static /* synthetic */ void lambda$1EP_XIyuBR_tmQQFXZqps11RSEE(View r0, AbstractDialogModal r1, ValueAnimator r2, ValueAnimator r3) {
        m1020animateModalYTo$lambda13$lambda12(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$D-x2ZsOvK7gLOknwyZdnONsEPTY, reason: not valid java name */
    public static /* synthetic */ void m1021lambda$Dx2ZsOvK7gLOknwyZdnONsEPTY(AbstractDialogModal r0) {
        m1028updateRootLayout$lambda11(r0);
    }

    public static /* synthetic */ void lambda$KN2ONiczFcX8LWOTXShjFj8DGy0(AbstractDialogModal r0) {
        m1025performExitAnimation$lambda8(r0);
    }

    public static /* synthetic */ void lambda$TfVAJAGMXmoD8Aw6L1Q56fFtytY(AbstractDialogModal r0, View r1) {
        m1026setCloseIconEnabled$lambda6$lambda5(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$p3i1BSQ7b07IttbJ-kwq_wv2V-E, reason: not valid java name */
    public static /* synthetic */ void m1022lambda$p3i1BSQ7b07IttbJkwq_wv2VE(AbstractDialogModal r0, View r1) {
        m1027setupDimViewClick$lambda10(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$s-gQPthDznMOSavMncpOxN1CNGg, reason: not valid java name */
    public static /* synthetic */ void m1023lambda$sgQPthDznMOSavMncpOxN1CNGg(AbstractDialogModal r0) {
        m1024performEnterAnimation$lambda7(r0);
    }

    public static /* synthetic */ com.obric.oui.view.g lambda$sooevdVPuNghlJ8t0KNHaZW0EhY(AbstractDialogModal r0, View r1, com.obric.oui.view.g r2) {
        return m1019_init_$lambda3(r0, r1, r2);
    }

    public final void applyCloseIconStyle(a r8) {
        o.e(r8, "style");
        applyCloseIconStyle$default(this, r8, null, null, 6, null);
    }

    public final void applyCloseIconStyle(a r8, Integer r9) {
        o.e(r8, "style");
        applyCloseIconStyle$default(this, r8, r9, null, 4, null);
    }

    public abstract int getLayout();

    public /* synthetic */ AbstractDialogModal(Context r2, boolean r3, boolean r4, int r5, d.h.b.h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        this(r7, r3, r4);
    }

    public static final /* synthetic */ void access$setLastAppliedModalYPx$p(AbstractDialogModal r0, Integer r1) {
        r0.lastAppliedModalYPx = r1;
    }

    public static final /* synthetic */ void access$setModalYAnimCurrentPx$p(AbstractDialogModal r0, Integer r1) {
        r0.modalYAnimCurrentPx = r1;
    }

    public static final /* synthetic */ void access$setModalYAnimTargetPx$p(AbstractDialogModal r0, Integer r1) {
        r0.modalYAnimTargetPx = r1;
    }

    public static final /* synthetic */ void access$setModalYAnimator$p(AbstractDialogModal r0, ValueAnimator r1) {
        r0.modalYAnimator = r1;
    }

    public static final /* synthetic */ void access$updateRootLayout(AbstractDialogModal r0) {
        r0.updateRootLayout();
    }

    public final boolean getWidthMatch() {
        return this.widthMatch;
    }

    public final boolean getMatchParentHeight() {
        return this.matchParentHeight;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.oui.dialog.base.AbstractDialogModal$configurationCallback$1] */
    public AbstractDialogModal(Context r11, boolean r12, boolean r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        super(r14);
        this.widthMatch = r12;
        this.matchParentHeight = r13;
        this.closeIconStyle = a.f35080b;
        this.autoDismissOnButtonClick = true;
        this.mCancelable = true;
        this.maxRootViewHeightGap = -1;
        this.useNewDialogAnim = true;
        this.configurationCallback = new AbstractDialogModal$configurationCallback$1(this);
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(true);
        setFocusable(true);
        setVisibility(8);
        View r4 = new View(r14);
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r4.setBackgroundColor(-16777216);
        r4.setAlpha(0.0f);
        r4.setVisibility(8);
        setDimView(r4);
        addView(getDimView());
        View r3 = ZeusTransformUtils.inflate(LayoutInflater.from(r14), getBaseLayoutRes(), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        o.c(r3, "from(context).inflate(ge…LayoutRes(), this, false)");
        setDialogRootView(r3);
        addView(getDialogRootView());
        if (ZeusTransformUtils.instanceOf(getDialogRootView().getBackground(), ColorDrawable.class) == false) goto L6;
        Drawable r5 = getDialogRootView().getBackground();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
        this.bgColor = ((ColorDrawable) ZeusTransformUtils.preCheckCast(r5, ColorDrawable.class, "com.obric.aiagent.plugin")).getColor();
    L14:
        getDialogRootView().setAlpha(0.0f);
        this.closeIcon = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.btn_close, DbHelper.COL_ID, "btn_close")), ImageView.class, "com.obric.aiagent.plugin");
        this.closeIconContainer = findViewById(ZeusTransformUtils.mapRes(R.id.close_container, DbHelper.COL_ID, "close_container"));
        if (r13 == false) goto L17;
        View r15 = getDialogRootView();
        ViewGroup.LayoutParams r6 = getDialogRootView().getLayoutParams();
        r6.height = -1;
        r15.setLayoutParams(r6);
    L17:
        setCloseIconEnabled$default(this, this.closeIconEnabled, null, 2, null);
        ViewStub r16 = (ViewStub) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.contentView, DbHelper.COL_ID, "contentView")), ViewStub.class, "com.obric.aiagent.plugin");
        r16.setLayoutResource(getLayout());
        View r17 = r16.inflate();
        o.c(r17, "viewStub.inflate()");
        setContentRootView(r17);
        if (k.a(r14) == true) goto L20;
    L22:
        boolean r18 = false;
    L23:
        this.enableMaterial = r18;
        if (r18 == false) goto L35;
        getDialogRootView().setBackgroundColor(0);
        com.obric.oui.material.c[] r19 = (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!com.obric.oui.d.i.a(getDialogRootView()))), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin");
        k.a(getDialogRootView(), r19, false, 0, null, 14, null);
        if (l.b(r14) != 1) goto L28;
    L29:
        com.obric.oui.color.e r110 = r19[0].e();
        if (r110 == null) goto L35;
        if (ZeusTransformUtils.instanceOf(getDialogRootView(), DialogRootView.class) == false) goto L35;
        ((DialogRootView) ZeusTransformUtils.preCheckCast(getDialogRootView(), DialogRootView.class, "com.obric.aiagent.plugin")).setStroke(r110.b(), com.obric.oui.common.util.g.b(r14, r110.a()));
        goto L35
    L28:
        if (r19.length == 1) goto L29;
    L35:
        ViewCompat.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), new $$Lambda$AbstractDialogModal$sooevdVPuNghlJ8t0KNHaZW0EhY(this));
        return;
    L20:
        if (l.d() == false) goto L22;
        r18 = true;
        goto L23
    L6:
        if (ZeusTransformUtils.instanceOf(getDialogRootView().getBackground(), GradientDrawable.class) == false) goto L14;
        if (Build.VERSION.SDK_INT < 24) goto L14;
        Drawable r7 = getDialogRootView().getBackground();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ColorStateList r8 = ((GradientDrawable) ZeusTransformUtils.preCheckCast(r7, GradientDrawable.class, "com.obric.aiagent.plugin")).getColor();
        if (r8 != null) goto L12;
        int r9 = 0;
    L13:
        this.bgColor = r9;
        goto L14
    L12:
        r9 = r8.getDefaultColor();
        goto L13
    }

    public final boolean getMCancelable() {
        return this.mCancelable;
    }

    public final void setMCancelable(boolean r1) {
        this.mCancelable = r1;
    }

    public final DialogInterface.OnShowListener getCompleteShowListener() {
        return this.completeShowListener;
    }

    public final void setCompleteShowListener(DialogInterface.OnShowListener r3) {
        this.completeShowListener = (DialogInterface.OnShowListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnShowListener.class, "com.obric.aiagent.plugin");
    }

    public final boolean getHideFirstFrame() {
        return this.hideFirstFrame;
    }

    public final void setHideFirstFrame(boolean r1) {
        this.hideFirstFrame = r1;
    }

    public final boolean getEnableMaterial() {
        return this.enableMaterial;
    }

    public final void setEnableMaterial(boolean r1) {
        this.enableMaterial = r1;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final void setBgColor(int r1) {
        this.bgColor = r1;
    }

    public final int getMaxRootViewHeightGap() {
        return this.maxRootViewHeightGap;
    }

    public final void setMaxRootViewHeightGap(int r1) {
        this.maxRootViewHeightGap = r1;
    }

    public final boolean getShowAnimRunning() {
        return this.showAnimRunning;
    }

    public final void setShowAnimRunning(boolean r1) {
        this.showAnimRunning = r1;
    }

    public boolean getUseNewDialogAnim() {
        return this.useNewDialogAnim;
    }

    public void setUseNewDialogAnim(boolean r1) {
        this.useNewDialogAnim = r1;
    }

    public final boolean isShowingModal() {
        return this.isShowingModal;
    }

    public final void setShowingModal(boolean r1) {
        this.isShowingModal = r1;
    }

    public final View getDialogRootView() {
        View r0 = this.dialogRootView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("dialogRootView");
        return null;
    }

    public final void setDialogRootView(View r2) {
        o.e(r2, "<set-?>");
        this.dialogRootView = r2;
    }

    public final View getContentRootView() {
        View r0 = this.contentRootView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("contentRootView");
        return null;
    }

    public final void setContentRootView(View r2) {
        o.e(r2, "<set-?>");
        this.contentRootView = r2;
    }

    public final View getDimView() {
        View r0 = this.dimView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("dimView");
        return null;
    }

    public final void setDimView(View r2) {
        o.e(r2, "<set-?>");
        this.dimView = r2;
    }

    /* JADX INFO: renamed from: _init_$lambda-3, reason: not valid java name */
    private static final com.obric.oui.view.g m1019_init_$lambda3(AbstractDialogModal r0, View r1, com.obric.oui.view.g r2) {
        o.e(r0, "this$0");
        o.c(r2, "insets");
        r0.applyInsets(r2);
        return r2;
    }

    public final void setRootFixedHeight(Integer r4) {
        if (r4 != null) goto L6;
    L4:
        r4 = null;
    L10:
        this.rootFixedHeightPx = r4;
        return;
    L6:
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
    L8:
        r1 = false;
        goto L9
    }

    public final void setOnShowListener(DialogInterface.OnShowListener r3) {
        this.showListener = (DialogInterface.OnShowListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnShowListener.class, "com.obric.aiagent.plugin");
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener r3) {
        this.dismissListener = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.aiagent.plugin");
    }

    public final void setOnCancelListener(DialogInterface.OnCancelListener r3) {
        this.cancelListener = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnCancelListener.class, "com.obric.aiagent.plugin");
    }

    public void setCancelable(boolean r1) {
        this.mCancelable = r1;
    }

    public final void setCanceledOnTouchOutside(boolean r1) {
        setCancelable(r1);
    }

    public final void setAutoDismiss(boolean r1) {
        this.autoDismissOnButtonClick = r1;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.AlertDialogHost
    public boolean isAutoDismiss() {
        return this.autoDismissOnButtonClick;
    }

    public static /* synthetic */ void setCloseIconEnabled$default(AbstractDialogModal r2, boolean r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r7 = null;
    L7:
        r2.setCloseIconEnabled(r3, r7);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCloseIconEnabled");
    }

    public void setCloseIconEnabled(boolean r7, View.OnClickListener r8) {
        View.OnClickListener r9 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r8, View.OnClickListener.class, "com.obric.aiagent.plugin");
        this.closeIconEnabled = r7;
        this.onCloseClickListener = r9;
        ImageView r10 = this.closeIcon;
        if (r10 == null) goto L21;
        View r11 = (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        com.obric.oui.common.util.k.a(r11, com.obric.oui.common.util.g.a(r0, 44));
        if (r7 == false) goto L15;
        View r12 = this.closeIconContainer;
        if (r12 == null) goto L11;
        com.obric.oui.common.util.k.a(r12);
    L11:
        applyCloseIconStyle$default(this, this.closeIconStyle, null, null, 6, null);
        View r13 = this.closeIconContainer;
        if (r13 == null) goto L22;
        r13.setOnClickListener(new $$Lambda$AbstractDialogModal$TfVAJAGMXmoD8Aw6L1Q56fFtytY(this));
        return;
    L22:
        return;
    L15:
        View r6 = this.closeIconContainer;
        if (r6 == null) goto L23;
        com.obric.oui.common.util.k.b(r6);
        return;
    L23:
        return;
    }

    /* JADX INFO: renamed from: setCloseIconEnabled$lambda-6$lambda-5, reason: not valid java name */
    private static final void m1026setCloseIconEnabled$lambda6$lambda5(AbstractDialogModal r1, View r2) {
        o.e(r1, "this$0");
        r1.dismiss();
        View.OnClickListener r3 = r1.onCloseClickListener;
        if (r3 == null) goto L7;
        r3.onClick(r2);
        return;
    }

    public static /* synthetic */ void applyCloseIconStyle$default(AbstractDialogModal r1, a r2, Integer r3, Integer r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = null;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        r1.applyCloseIconStyle(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyCloseIconStyle");
    }

    public final void applyCloseIconStyle(a r4, Integer r5, Integer r6) {
        o.e(r4, "style");
        this.closeIconStyle = r4;
        if (this.closeIconEnabled == true) goto L5;
        return;
    L5:
        int r7 = c.f35083a[r4.ordinal()];
        if (r7 != 1) goto L8;
        int r8 = ZeusTransformUtils.mapRes(R.color.ConstTextInverse, "color", "ConstTextInverse");
        r6 = Integer.valueOf(ZeusTransformUtils.mapRes(R.color.ConstBGContainer7, "color", "ConstBGContainer7"));
    L18:
        ImageView r9 = this.closeIcon;
        if (r9 == null) goto L22;
        r9.setImageTintList(androidx.core.content.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8));
    L22:
        GradientDrawable r10 = null;
        if (r6 != null) goto L28;
        View r3 = this.closeIconContainer;
        if (r3 == null) goto L40;
        r3.setBackground(null);
        return;
    L40:
        return;
    L28:
        View r11 = this.closeIconContainer;
        if (r11 != null) goto L31;
        Drawable r12 = null;
    L33:
        if (ZeusTransformUtils.instanceOf(r12, GradientDrawable.class) == false) goto L35;
        r10 = (GradientDrawable) ZeusTransformUtils.preCheckCast(r12, GradientDrawable.class, "com.obric.aiagent.plugin");
    L35:
        if (r10 == null) goto L41;
        r10.setColor(androidx.core.content.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6.intValue()));
        return;
    L41:
        return;
    L31:
        r12 = r11.getBackground();
        goto L33
    L8:
        if (r7 != 2) goto L10;
        r8 = ZeusTransformUtils.mapRes(R.color.TextReverse, "color", "TextReverse");
        r6 = Integer.valueOf(ZeusTransformUtils.mapRes(R.color.ConstTextInverse5, "color", "ConstTextInverse5"));
        goto L18
    L10:
        if (r7 != 3) goto L15;
        if (r5 != null) goto L13;
        r8 = ZeusTransformUtils.mapRes(R.color.ConstTextInverse, "color", "ConstTextInverse");
        goto L18
    L13:
        r8 = r5.intValue();
        goto L18
    L15:
        throw new d.k();
    }

    public final void setIncludeCutoutInLandscape(Boolean r1) {
        this.includeCutoutInLandscape = r1;
    }

    public final void forceHideFirstFrame() {
        this.hideFirstFrame = true;
    }

    public static /* synthetic */ void show$default(AbstractDialogModal r0, ViewGroup r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.show(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    public void show(ViewGroup r3) {
        if (this.isShowingModal == true) goto L9;
        ensureAttachedToParent(r3);
        setupDimViewClick();
        updateRootLayout();
        requestModalApplyInsets();
        setVisibility(0);
        DialogInterface.OnShowListener r4 = this.showListener;
        if (r4 == null) goto L8;
        r4.onShow((DialogInterface) ZeusTransformUtils.preCheckCast(this, DialogInterface.class, "com.obric.aiagent.plugin"));
    L8:
        this.isShowingModal = true;
        this.showAnimRunning = true;
        performEnterAnimation();
        interceptBackPressed();
        registerConfigurationCallbackIfNeeded();
        return;
    L9:
        updateRootLayout();
        requestModalApplyInsets();
    }

    public void performEnterAnimation() {
        com.obric.oui.common.util.k.a(getDimView());
        getDimView().setAlpha(0.0f);
        ViewPropertyAnimator r0 = getDimView().animate();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        r0.alpha(getTargetDimAmount(r1)).setDuration(220).start();
        getDialogRootView().post(new $$Lambda$AbstractDialogModal$sgQPthDznMOSavMncpOxN1CNGg(this));
    }

    /* JADX INFO: renamed from: performEnterAnimation$lambda-7, reason: not valid java name */
    private static final void m1024performEnterAnimation$lambda7(AbstractDialogModal r15) {
        o.e(r15, "this$0");
        com.obric.oui.animation.a.b<View> r0 = com.obric.oui.dialog.a.a.a(com.obric.oui.dialog.a.a.f35019a, r15.getDialogRootView(), null, false, 0.0f, r15.getUseNewDialogAnim(), 4, null);
        if (r15.hideFirstFrame == false) goto L5;
        r0.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r15), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new e(r15), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new f(r15), d.h.a.b.class, "com.obric.aiagent.plugin"));
    L6:
        r15.dialogAnimator = r0;
        r0.b();
        return;
    L5:
        com.obric.oui.animation.a.b.a(r0, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new g(r15), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new h(r15), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null);
        goto L6
    }

    public void performExitAnimation() {
        getDimView().animate().alpha(0.0f).setDuration(180).withEndAction(new $$Lambda$AbstractDialogModal$KN2ONiczFcX8LWOTXShjFj8DGy0(this)).start();
        com.obric.oui.animation.a.b<View> r0 = com.obric.oui.dialog.a.a.f35019a.a(getDialogRootView(), null, false, getUseNewDialogAnim());
        com.obric.oui.animation.a.b.a(r0, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new i(this), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new j(this), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null);
        r0.b();
    }

    /* JADX INFO: renamed from: performExitAnimation$lambda-8, reason: not valid java name */
    private static final void m1025performExitAnimation$lambda8(AbstractDialogModal r1) {
        o.e(r1, "this$0");
        com.obric.oui.common.util.k.b(r1.getDimView());
    }

    public void originDismiss() {
        if (this.isShowingModal == true) goto L5;
        return;
    L5:
        this.isShowingModal = false;
        this.showAnimRunning = false;
        restoreWindowCallback();
        unregisterConfigurationCallbackIfNeeded();
        DialogInterface.OnDismissListener r0 = this.dismissListener;
        if (r0 == null) goto L9;
        r0.onDismiss((DialogInterface) ZeusTransformUtils.preCheckCast(this, DialogInterface.class, "com.obric.aiagent.plugin"));
    L9:
        ViewParent r1 = getParent();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L12;
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.aiagent.plugin");
    L13:
        if (r2 == null) goto L16;
        r2.removeView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    L16:
        setVisibility(8);
        getDimView().setAlpha(0.0f);
        getDialogRootView().setAlpha(1.0f);
        getDialogRootView().setTranslationX(0.0f);
        getDialogRootView().setTranslationY(0.0f);
        return;
    L12:
        r2 = null;
        goto L13
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        if (this.isShowingModal == true) goto L5;
        return;
    L5:
        restoreWindowCallback();
        performExitAnimation();
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        if (this.mCancelable == true) goto L5;
        return;
    L5:
        DialogInterface.OnCancelListener r0 = this.cancelListener;
        if (r0 == null) goto L9;
        r0.onCancel((DialogInterface) ZeusTransformUtils.preCheckCast(this, DialogInterface.class, "com.obric.aiagent.plugin"));
    L9:
        dismiss();
    }

    public final void completeOnShow() {
        this.showAnimRunning = false;
        this.dialogAnimator = null;
        DialogInterface.OnShowListener r0 = this.completeShowListener;
        if (r0 == null) goto L7;
        r0.onShow((DialogInterface) ZeusTransformUtils.preCheckCast(this, DialogInterface.class, "com.obric.aiagent.plugin"));
        return;
    }

    public int getBaseLayoutRes() {
        if (this.matchParentHeight == false) goto L6;
        return ZeusTransformUtils.mapRes(R.layout.o_base_dialog_with_match_parent_height, "layout", "o_base_dialog_with_match_parent_height");
    L6:
        return ZeusTransformUtils.mapRes(R.layout.o_base_dialog, "layout", "o_base_dialog");
    }

    public float getTargetDimAmount(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        if ((ZeusTransformUtils.getResources(r1, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        return 0.8f;
    L8:
        return 0.32f;
    L5:
        r3 = false;
        goto L6
    }

    public int getLayoutMarginHorizontal() {
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_layout_margin, "dimen", "oui_dialog_layout_margin"));
    }

    public int getLayoutMarginBottom(boolean r3) {
        if (r3 == false) goto L6;
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_layout_margin, "dimen", "oui_dialog_layout_margin"));
    L6:
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_layout_margin_with_three_button_mode, "dimen", "oui_dialog_layout_margin_with_three_button_mode"));
    }

    public void requestModalApplyInsets() {
        ViewCompat.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    }

    private final void setupDimViewClick() {
        if (this.mCancelable == false) goto L5;
        getDimView().setOnClickListener(new $$Lambda$AbstractDialogModal$p3i1BSQ7b07IttbJkwq_wv2VE(this));
        return;
    L5:
        getDimView().setOnClickListener(null);
    }

    /* JADX INFO: renamed from: setupDimViewClick$lambda-10, reason: not valid java name */
    private static final void m1027setupDimViewClick$lambda10(AbstractDialogModal r0, View r1) {
        o.e(r0, "this$0");
        r0.cancel();
    }

    private final void ensureAttachedToParent(ViewGroup r3) {
        if (getParent() == null) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        r3 = findDecorViewParent();
    L7:
        if (r3 != null) goto L9;
        return;
    L9:
        r3.addView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), new ViewGroup.LayoutParams(-1, -1));
    }

    private final ViewGroup findDecorViewParent() {
        Object r0 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L3:
        Context r1 = (Context) r0;
        if (ZeusTransformUtils.instanceOf(r1, ContextWrapper.class) == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r1, Activity.class) == true) goto L7;
        r0 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r1, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        goto L3
    L7:
        Window r4 = ZeusTransformUtils.getWindow((Activity) ZeusTransformUtils.preCheckCast(r1, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        if (r4 != null) goto L10;
        View r5 = null;
    L12:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == true) goto L14;
        return null;
    L14:
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
    L10:
        r5 = r4.getDecorView();
        goto L12
    L16:
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Activity.class) == false) goto L19;
        Activity r7 = (Activity) ZeusTransformUtils.preCheckCast(r6, Activity.class, "com.obric.aiagent.plugin");
    L20:
        if (r7 != null) goto L22;
    L21:
        View r8 = null;
    L27:
        if (ZeusTransformUtils.instanceOf(r8, ViewGroup.class) == true) goto L29;
        return null;
    L29:
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.aiagent.plugin");
    L22:
        Window r9 = ZeusTransformUtils.getWindow(r7, "com.obric.aiagent.plugin");
        if (r9 == null) goto L21;
        r8 = r9.getDecorView();
        goto L27
    L19:
        r7 = null;
        goto L20
    }

    private final void updateRootLayout() {
        getDialogRootView().post(new $$Lambda$AbstractDialogModal$Dx2ZsOvK7gLOknwyZdnONsEPTY(this));
    }

    /* JADX INFO: renamed from: updateRootLayout$lambda-11, reason: not valid java name */
    private static final void m1028updateRootLayout$lambda11(AbstractDialogModal r7) {
        o.e(r7, "this$0");
        Size r0 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        ViewGroup.LayoutParams r2 = r7.getDialogRootView().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r2, FrameLayout.LayoutParams.class) == false) goto L5;
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L6:
        int r4 = -2;
        if (r3 != null) goto L10;
        r3 = new FrameLayout.LayoutParams(-2, -2);
    L10:
        if (r7.matchParentHeight == false) goto L17;
        if (r7.widthMatch == false) goto L14;
        int r1 = -1;
    L15:
        r3.width = r1;
        r3.height = -1;
        r3.gravity = 17;
        r3.bottomMargin = 0;
    L32:
        r7.getDialogRootView().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return;
    L14:
        r1 = r3.width;
        goto L15
    L17:
        if (r7.widthMatch == false) goto L25;
        r3.width = -1;
        Integer r5 = r7.rootFixedHeightPx;
        if (r5 == null) goto L22;
        r4 = r5.intValue();
    L22:
        r3.height = r4;
        r3.gravity = 80;
        r3.bottomMargin = 0;
        if (ZeusTransformUtils.instanceOf(r7.getDialogRootView(), DialogRootView.class) == false) goto L32;
        float r6 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_l3, "dimen", "oui_r_l3"));
        ((DialogRootView) ZeusTransformUtils.preCheckCast(r7.getDialogRootView(), DialogRootView.class, "com.obric.aiagent.plugin")).setRadius(r6, r6, 0.0f, 0.0f);
        goto L32
    L25:
        int r8 = Math.min(r0.getWidth(), r0.getHeight()) - (r7.getLayoutMarginHorizontal() * 2);
        r3.width = r8;
        Integer r9 = r7.rootFixedHeightPx;
        if (r9 == null) goto L29;
        r4 = r9.intValue();
    L29:
        r3.height = r4;
        r3.gravity = 81;
        r7.getDialogRootView().measure(View.MeasureSpec.makeMeasureSpec(r8, Integer.MIN_VALUE), 0);
        if (r0.getWidth() >= r0.getHeight()) goto L32;
        int r10 = r0.getHeight();
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r11, "context");
        r7.maxRootViewHeightGap = Math.max(0, r7.getDialogRootView().getMeasuredHeight() - (r10 - com.obric.oui.common.util.g.a(r11, 232)));
        goto L32
    L5:
        r3 = null;
        goto L6
    }

    private final void applyInsets(com.obric.oui.view.g r9) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        boolean r1 = com.obric.oui.window.a.f(r0);
        int r10 = r9.a(com.obric.oui.view.g.m.a()).f36824e;
        com.obric.oui.window.a r3 = com.obric.oui.window.a.f36851a;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "context");
        boolean r5 = r3.g(r4);
        com.obric.oui.window.a r6 = com.obric.oui.window.a.f36851a;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "context");
        boolean r2 = r6.c(r7);
        boolean r8 = true;
        if (r2 == true) goto L7;
        if (r5 == true) goto L7;
        boolean r11 = false;
    L8:
        if (r11 == false) goto L10;
        int r12 = 0;
    L11:
        if (r1 == true) goto L15;
        if (r11 == true) goto L15;
        r8 = false;
    L15:
        int r13 = getLayoutMarginBottom(r8);
        if (r8 == true) goto L19;
        r13 = Math.max(r13, r12);
    L19:
        int r14 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_layout_margin_to_ime, "dimen", "oui_dialog_layout_margin_to_ime"));
        com.obric.oui.d.a.b.a(TAG, o.a("onApplyWindowInsets, update, imeBottom: ", Integer.valueOf(r10)));
        ViewGroup.LayoutParams r15 = getDialogRootView().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r15, ViewGroup.MarginLayoutParams.class) == false) goto L22;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L23:
        if (r16 != null) goto L26;
        return;
    L26:
        if (this.widthMatch == false) goto L29;
        r16.bottomMargin = 0;
        getDialogRootView().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r16, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        getDialogRootView().setTranslationY(0.0f);
        getDialogRootView().setPadding(getDialogRootView().getPaddingLeft(), getDialogRootView().getPaddingTop(), getDialogRootView().getPaddingRight(), r10);
        return;
    L29:
        if (r16.bottomMargin == r13) goto L31;
        r16.bottomMargin = r13;
        getDialogRootView().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r16, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    L31:
        if (r10 <= 0) goto L37;
        int r17 = ((r10 + r12) + r14) - r16.bottomMargin;
        com.obric.oui.animation.a.b<View> r18 = this.dialogAnimator;
        if (r18 == null) goto L36;
        r18.c();
    L36:
        animateModalYTo(-r17);
        return;
    L37:
        animateModalYTo(0);
        return;
    L22:
        r16 = null;
        goto L23
    L10:
        r12 = com.obric.oui.window.a.f36851a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L7:
        r11 = true;
        goto L8
    }

    private final void registerConfigurationCallbackIfNeeded() {
        if (this.configurationCallbackRegistered == false) goto L5;
        return;
    L5:
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).registerComponentCallbacks((ComponentCallbacks) ZeusTransformUtils.preCheckCast(this.configurationCallback, ComponentCallbacks.class, "com.obric.aiagent.plugin"));
        this.configurationCallbackRegistered = true;
    }

    private final void unregisterConfigurationCallbackIfNeeded() {
        if (this.configurationCallbackRegistered == true) goto L5;
        return;
    L5:
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).unregisterComponentCallbacks((ComponentCallbacks) ZeusTransformUtils.preCheckCast(this.configurationCallback, ComponentCallbacks.class, "com.obric.aiagent.plugin"));
        this.configurationCallbackRegistered = false;
    }

    private final void interceptBackPressed() {
        com.obric.oui.window.a r0 = com.obric.oui.window.a.f36851a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(r1), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        Window.Callback r3 = ZeusTransformUtils.getWindow(r2, "com.obric.aiagent.plugin").getCallback();
        if (r3 != null) goto L8;
        return;
    L8:
        this.originalWindowCallback = r3;
        this.myWindowCallback = (Window.Callback) ZeusTransformUtils.preCheckCast(new BackPressedWindowCallback(this, r3), Window.Callback.class, "com.obric.aiagent.plugin");
        ZeusTransformUtils.getWindow(r2, "com.obric.aiagent.plugin").setCallback(this.myWindowCallback);
    }

    public final void restoreWindowCallback() {
        com.obric.oui.window.a r0 = com.obric.oui.window.a.f36851a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(r1), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        Window.Callback r3 = this.originalWindowCallback;
        if (r3 != null) goto L9;
        return;
    L9:
        if (ZeusTransformUtils.getWindow(r2, "com.obric.aiagent.plugin").getCallback() != this.myWindowCallback) goto L11;
        ZeusTransformUtils.getWindow(r2, "com.obric.aiagent.plugin").setCallback(r3);
    L11:
        this.myWindowCallback = null;
        this.originalWindowCallback = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        restoreWindowCallback();
        unregisterConfigurationCallbackIfNeeded();
    }

    public final boolean isDarkTheme() {
        int r0 = this.bgColor;
        if (r0 != 0) goto L7;
        return com.obric.oui.d.i.a(getDialogRootView());
    L7:
        return com.obric.oui.color.d.a(r0);
    }

    public final void animateModalYTo(final int r6) {
        final View r0 = getDialogRootView();
        if (this.isShowingModal == true) goto L6;
        this.pendingApplyModalPosition = true;
        return;
    L6:
        Integer r1 = this.modalYAnimCurrentPx;
        if (r1 != null) goto L11;
        r1 = this.lastAppliedModalYPx;
        if (r1 != null) goto L11;
        int r2 = (int) r0.getTranslationY();
    L12:
        if (r2 != r6) goto L19;
        ValueAnimator r3 = this.modalYAnimator;
        if (r3 == null) goto L17;
        r3.cancel();
    L17:
        this.modalYAnimator = null;
        this.modalYAnimTargetPx = null;
        this.modalYAnimCurrentPx = Integer.valueOf(r6);
        this.lastAppliedModalYPx = Integer.valueOf(r6);
        r0.setTranslationY(r6);
        return;
    L19:
        ValueAnimator r4 = this.modalYAnimator;
        if (r4 != null) goto L23;
    L21:
        boolean r5 = false;
    L25:
        if (r5 == false) goto L32;
        Integer r7 = this.modalYAnimTargetPx;
        if (r7 == null) goto L32;
        if (r7.intValue() != r6) goto L32;
        return;
    L32:
        ValueAnimator r8 = this.modalYAnimator;
        if (r8 == null) goto L36;
        r8.cancel();
    L36:
        this.modalYAnimTargetPx = Integer.valueOf(r6);
        final ValueAnimator r9 = ValueAnimator.ofInt(new int[]{r2, r6});
        r9.setDuration(200);
        r9.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(1.5f), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r9.addUpdateListener(new $$Lambda$AbstractDialogModal$1EP_XIyuBR_tmQQFXZqps11RSEE(r0, this, r9));
        r9.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new AbstractDialogModal$animateModalYTo$1$2(this, r6), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        this.modalYAnimator = r9;
        if (r9 == null) goto L41;
        r9.start();
        return;
    L41:
        return;
    L23:
        if (r4.isRunning() != true) goto L21;
        r5 = true;
    L11:
        r2 = r1.intValue();
        goto L12
    }

    /* JADX INFO: renamed from: animateModalYTo$lambda-13$lambda-12, reason: not valid java name */
    private static final void m1020animateModalYTo$lambda13$lambda12(View r1, AbstractDialogModal r2, ValueAnimator r3, ValueAnimator r4) {
        o.e(r1, "$modal");
        o.e(r2, "this$0");
        o.e(r4, "it");
        if (r1.isAttachedToWindow() == false) goto L5;
        Object r5 = r4.getAnimatedValue();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue();
        r2.modalYAnimCurrentPx = Integer.valueOf(r6);
        r1.setTranslationY(r6);
        return;
    L5:
        r3.cancel();
    }
}
