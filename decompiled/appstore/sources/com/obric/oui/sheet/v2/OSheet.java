package com.obric.oui.sheet.v2;

import android.R;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.obric.oui.dialog.DialogExtInterface;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
public class OSheet extends Dialog implements OSheetBase {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final a f16828J = null;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public ComponentCallbacks E;
    public float F;
    public float G;
    public int H;
    public boolean I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f16829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f16830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadiusLayout f16831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f16832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f16833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f16834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f16835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f16837i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h f16838j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HeightMode f16839k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f16840l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f16841m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f16842n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f16843o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f16844p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f16845q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Size f16846r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Boolean f16847s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f16848t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public jb.d f16849u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public DialogExtInterface.OnShowAnimListener f16850v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public DialogExtInterface.OnDismissAnimListener f16851w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public DialogExtInterface.OnConfigurationListener f16852x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f16853y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f16854z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet$Header;", "", "(Ljava/lang/String;I)V", "CUSTOM", "PAGE", "ACTION", "MODAL", "ONLY_TITLE", "PAGE_WITH_CLOSE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Header extends Enum<Header> {
        private static final /* synthetic */ Header[] $VALUES = null;
        public static final Header ACTION = null;
        public static final Header CUSTOM = null;
        public static final Header MODAL = null;
        public static final Header ONLY_TITLE = null;
        public static final Header PAGE = null;
        public static final Header PAGE_WITH_CLOSE = null;

        private static final /* synthetic */ Header[] $values() {
            return new Header[]{CUSTOM, PAGE, ACTION, MODAL, ONLY_TITLE, PAGE_WITH_CLOSE};
        }

        static {
            CUSTOM = new Header("CUSTOM", 0);
            PAGE = new Header("PAGE", 1);
            ACTION = new Header("ACTION", 2);
            MODAL = new Header("MODAL", 3);
            ONLY_TITLE = new Header("ONLY_TITLE", 4);
            PAGE_WITH_CLOSE = new Header("PAGE_WITH_CLOSE", 5);
            $VALUES = $values();
        }

        private Header(String r10, int r11) {
            super(r10, r11);
        }

        public static Header valueOf(String r10) {
            return (Header) Enum.valueOf(Header.class, r10);
        }

        public static Header[] values() {
            return (Header[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "", "(Ljava/lang/String;I)V", "FULL_HEIGHT", "WRAP_HEIGHT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum HeightMode extends Enum<HeightMode> {
        private static final /* synthetic */ HeightMode[] $VALUES = null;
        public static final HeightMode FULL_HEIGHT = null;
        public static final HeightMode WRAP_HEIGHT = null;

        private static final /* synthetic */ HeightMode[] $values() {
            return new HeightMode[]{FULL_HEIGHT, WRAP_HEIGHT};
        }

        static {
            FULL_HEIGHT = new HeightMode("FULL_HEIGHT", 0);
            WRAP_HEIGHT = new HeightMode("WRAP_HEIGHT", 1);
            $VALUES = $values();
        }

        private HeightMode(String r10, int r11) {
            super(r10, r11);
        }

        public static HeightMode valueOf(String r10) {
            return (HeightMode) Enum.valueOf(HeightMode.class, r10);
        }

        public static HeightMode[] values() {
            return (HeightMode[]) $VALUES.clone();
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSheet f16855a;

        public b(OSheet r10) {
            this.f16855a = r10;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration r10) {
            q.g(r10, "newConfig");
            this.f16855a.updateFullWindowSize();
            this.f16855a.getScaffoldController().i(this.f16855a.getFullWindowSize());
            DialogExtInterface.OnConfigurationListener r11 = OSheet.c(this.f16855a);
            if (r11 == null) goto L7;
            r11.onConfigurationChanged(this.f16855a, r10);
            return;
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    static {
        f16828J = new a(null);
    }

    public /* synthetic */ OSheet(Context r10, int r11, int r12, boolean r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 2) == 0) goto L5;
        int r17 = 0;
    L7:
        if ((r15 & 4) == 0) goto L9;
        int r18 = 0;
    L11:
        if ((r15 & 8) == 0) goto L13;
        boolean r19 = false;
    L15:
        if ((r15 & 16) == 0) goto L17;
        r14 = true;
    L17:
        this(r10, r17, r18, r19, r14);
        return;
    L13:
        r19 = r13;
        goto L15
    L9:
        r18 = r12;
        goto L11
    L5:
        r17 = r11;
        goto L7
    }

    public static /* synthetic */ void a(OSheet r10) {
        e(r10);
    }

    public static /* synthetic */ void b(OSheet r10, View r11) {
        j(r10, r11);
    }

    public static final /* synthetic */ DialogExtInterface.OnConfigurationListener c(OSheet r10) {
        return r10.f16852x;
    }

    public static final void e(OSheet r10) {
        q.g(r10, "this$0");
        r10.onPostShow();
        if (r10.I == true) goto L6;
        r10.getRootContainer().setAlpha(0.0f);
        r10.I = true;
        r10.performEnterAnimation();
        return;
    }

    public static final void j(OSheet r10, View r11) {
        q.g(r10, "this$0");
        r10.dismiss();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void applyMaterial(boolean r10) {
        OSheetBase.DefaultImpls.c(this, r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void calculateBodyMaxHeight() {
        OSheetBase.DefaultImpls.d(this);
    }

    public final void d() {
        setRunningAnim(null);     // Catch: Exception -> L7
        setOnDismissListener(null);     // Catch: Exception -> L7
        if (isShowing() == false) goto L12;
        super.dismiss();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        Log.e("OSheet", "dismissImmediately exception!", e);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        removeOnApplyWindowInsetsListener();
        OSheetBase.DefaultImpls.v(this, 0.0f, 1, null);
        this.I = false;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void enableIgnoreInsetBottom(boolean r10) {
        OSheetBase.DefaultImpls.e(this, r10);
    }

    public final void f() {
    L6:
        e = move-exception;
        Log.e("OSheet", "origin Dismiss exception!", e);
        return;
    L3:
        if (isShowing() == false) goto L11;
        super.dismiss();     // Catch: Exception -> L6
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase, com.obric.oui.sheet.v2.SheetMoveDelegate
    public void fling(float r10, float r11) {
        OSheetBase.DefaultImpls.f(this, r10, r11);
    }

    public final void g(boolean r10) {
        setMClearDimFlag(r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getAutoAddBodyPaddingTopWhenOverlay() {
        return this.A;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBgColor() {
        return this.H;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public FrameLayout getBodyContainer() {
        FrameLayout r10 = this.f16834f;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("bodyContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBodyContentPaddingBottom() {
        return this.f16854z;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBodyContentPaddingTop() {
        return this.f16853y;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public ComponentCallbacks getConfigurationCallback() {
        return this.E;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getConfigurationCallbackRegistered() {
        return this.D;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getContentLayoutResId() {
        return OSheetBase.DefaultImpls.g(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getDimView() {
        View r10 = this.f16830b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("dimView");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getEnableDimAnim() {
        return this.f16836h;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getEnableEnterAnim() {
        return this.f16837i;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getEnableMaterial() {
        return this.B;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getEndActionButton() {
        return OSheetBase.DefaultImpls.h(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public FrameLayout getFooterContainer() {
        FrameLayout r10 = this.f16833e;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("footerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Size getFullWindowSize() {
        return this.f16846r;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public FrameLayout getHeaderContainer() {
        FrameLayout r10 = this.f16832d;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("headerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public OSheetTitleBar getHeaderTitleBar() {
        return OSheetBase.DefaultImpls.i(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public HeightMode getHeightStyle() {
        return this.f16839k;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getIgnoreInsetBottom() {
        return this.f16848t;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getMCancelable() {
        return this.f16843o;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getMClearDimFlag() {
        return this.f16835g;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getMaxBodyHeight() {
        return OSheetBase.DefaultImpls.j(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getNegativeButton() {
        return OSheetBase.DefaultImpls.k(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getPositiveButton() {
        return OSheetBase.DefaultImpls.l(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public RadiusLayout getRootContainer() {
        RadiusLayout r10 = this.f16831c;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("rootContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public float getRootTransMoveStartX() {
        return this.F;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public float getRootTransMoveStartY() {
        return this.G;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public jb.d getRunningAnim() {
        return this.f16849u;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public ViewGroup getScaffoldContainer() {
        ViewGroup r10 = this.f16829a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("scaffoldContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public h getScaffoldController() {
        h r10 = this.f16838j;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("scaffoldController");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Context getSheetContext() {
        Context r10 = getContext();
        q.f(r10, "context");
        return r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getShowing() {
        return this.C;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getStartActionButton() {
        return OSheetBase.DefaultImpls.m(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Boolean getSystemInsetsAppearanceLightValue() {
        return this.f16847s;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getUserWindowHeight() {
        return this.f16845q;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getUserWindowWidth() {
        return this.f16844p;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getViewById(int r10) {
        View r11 = findViewById(r10);
        q.f(r11, "findViewById(id)");
        return r11;
    }

    public final void h(Window r10) {
        if (r10 == null) goto L6;
        r10.setNavigationBarContrastEnforced(false);
    L6:
        if (r10 == null) goto L9;
        r10.clearFlags(134217728);
    L9:
        if (r10 == null) goto L12;
        r10.addFlags(Integer.MIN_VALUE);
    L12:
        if (r10 == null) goto L15;
        r10.setNavigationBarColor(0);
    L15:
        if (r10 == null) goto L18;
        r10.setDecorFitsSystemWindows(false);
    L18:
        if (r10 == null) goto L22;
        r10.setNavigationBarDividerColor(0);
        return;
    }

    public final void i(Window r10) {
        Boolean r11 = getSystemInsetsAppearanceLightValue();
        int r12 = 0;
        if (r11 == null) goto L5;
        boolean r13 = r11.booleanValue();
    L9:
        if (r10 == null) goto L19;
        WindowInsetsController r14 = r10.getInsetsController();
        if (r14 == null) goto L19;
        if (r13 == false) goto L17;
        int r15 = 8;
    L18:
        r14.setSystemBarsAppearance(r15, 8);
        goto L19
    L17:
        r15 = 0;
    L19:
        if (r10 == null) goto L29;
        WindowInsetsController r16 = r10.getInsetsController();
        if (r16 != null) goto L25;
        return;
    L25:
        if (r13 == false) goto L27;
        r12 = 16;
    L27:
        r16.setSystemBarsAppearance(r12, 16);
        return;
    L29:
        return;
    L5:
        if ((getContext().getResources().getConfiguration().uiMode & 48) == 32) goto L7;
        r13 = true;
        goto L9
    L7:
        r13 = false;
        goto L9
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void initBgColor() {
        OSheetBase.DefaultImpls.n(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean isContentOverlayMode() {
        return this.f16840l;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean isDarkTheme() {
        return OSheetBase.DefaultImpls.o(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean isRootContainerMaxHeight() {
        return OSheetBase.DefaultImpls.p(this);
    }

    public final boolean k() {
        return !this.f16841m;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase, com.obric.oui.sheet.v2.SheetMoveDelegate
    public void move(float r10, float r11, boolean r12) {
        OSheetBase.DefaultImpls.q(this, r10, r11, r12);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean needDimAnim() {
        if (getEnableDimAnim() == true) goto L5;
    L7:
        return false;
    L5:
        if (getMClearDimFlag() == true) goto L7;
        return true;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (r10 == null) goto L5;
        return;
    L5:
        if (getEnableEnterAnim() == false) goto L9;
        getRootContainer().setAlpha(0.0f);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onDismissAnimEnd() {
        DialogExtInterface.OnDismissAnimListener r10 = this.f16851w;
        if (r10 == null) goto L7;
        r10.onDismissAnimEnd(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onDismissAnimStart() {
        DialogExtInterface.OnDismissAnimListener r10 = this.f16851w;
        if (r10 == null) goto L7;
        r10.onDismissAnimStart(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onDismissComplete() {
        f();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onPostShow() {
        OSheetBase.DefaultImpls.r(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onShowAnimEnd() {
        DialogExtInterface.OnShowAnimListener r10 = this.f16850v;
        if (r10 == null) goto L7;
        r10.onShowAnimEnd(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onShowAnimStart() {
        DialogExtInterface.OnShowAnimListener r10 = this.f16850v;
        if (r10 == null) goto L7;
        r10.onShowAnimStart(this);
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        registerConfigurationCallbackIfNeeded();
        calculateBodyMaxHeight();
        getRootContainer().post(new com.obric.oui.sheet.v2.b(this));
    }

    @Override // android.app.Dialog
    public void onStop() {
        unregisterConfigurationCallbackIfNeeded();
        super.onStop();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void performEnterAnimation() {
        OSheetBase.DefaultImpls.s(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void performExitAnimation(float r10) {
        OSheetBase.DefaultImpls.u(this, r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void registerConfigurationCallbackIfNeeded() {
        OSheetBase.DefaultImpls.x(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void removeOnApplyWindowInsetsListener() {
        OSheetBase.DefaultImpls.y(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setAutoAddBodyPaddingTopWhenOverlay(boolean r10) {
        this.A = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBgColor(int r10) {
        this.H = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContainer(FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f16834f = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContentPaddingBottom(int r10) {
        this.f16854z = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContentPaddingTop(int r10) {
        this.f16853y = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyView(View r10) {
        OSheetBase.DefaultImpls.z(this, r10);
    }

    @Override // android.app.Dialog, com.obric.oui.sheet.v2.OSheetBase
    public void setCanceledOnTouchOutside(boolean r10) {
        super.setCanceledOnTouchOutside(r10);
        setMCancelable(r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setConfigurationCallback(ComponentCallbacks r10) {
        q.g(r10, "<set-?>");
        this.E = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setConfigurationCallbackRegistered(boolean r10) {
        this.D = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setContentOverlayMode(boolean r10) {
        this.f16840l = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setDimView(View r10) {
        q.g(r10, "<set-?>");
        this.f16830b = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setEnableDimAnim(boolean r10) {
        this.f16836h = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setEnableEnterAnim(boolean r10) {
        this.f16837i = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setEnableMaterial(boolean r10) {
        this.B = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterButton(Integer r10, boolean r11, View.OnClickListener r12, Integer r13, boolean r14, View.OnClickListener r15) {
        OSheetBase.DefaultImpls.B(this, r10, r11, r12, r13, r14, r15);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterContainer(FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f16833e = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterView(View r10) {
        OSheetBase.DefaultImpls.D(this, r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFullWindowSize(Size r10) {
        q.g(r10, "<set-?>");
        this.f16846r = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeader(Header r10, Integer r11, Integer r12, String r13, String r14, boolean r15, View.OnClickListener r16, View.OnClickListener r17, Integer r18, Integer r19, String r110, String r111, Integer r112, Integer r113) {
        OSheetBase.DefaultImpls.E(this, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeaderContainer(FrameLayout r10) {
        q.g(r10, "<set-?>");
        this.f16832d = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeaderView(View r10) {
        OSheetBase.DefaultImpls.F(this, r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeightMode(HeightMode r10) {
        OSheetBase.DefaultImpls.G(this, r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeightStyle(HeightMode r10) {
        q.g(r10, "<set-?>");
        this.f16839k = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setIgnoreInsetBottom(boolean r10) {
        this.f16848t = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setMCancelable(boolean r10) {
        this.f16843o = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setMClearDimFlag(boolean r10) {
        this.f16835g = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setOnApplyWindowInsetsListener() {
        OSheetBase.DefaultImpls.H(this);
    }

    public final void setOnConfigurationListener(@Nullable DialogExtInterface.OnConfigurationListener r10) {
        this.f16852x = r10;
    }

    public final void setOnDismissAnimListener(@Nullable DialogExtInterface.OnDismissAnimListener r10) {
        this.f16851w = r10;
    }

    public final void setOnShowAnimListener(@Nullable DialogExtInterface.OnShowAnimListener r10) {
        this.f16850v = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setOverlayModeAutoBodyPaddingTopEnabled(boolean r10) {
        OSheetBase.DefaultImpls.I(this, r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootContainer(RadiusLayout r10) {
        q.g(r10, "<set-?>");
        this.f16831c = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootTransMoveStartX(float r10) {
        this.F = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootTransMoveStartY(float r10) {
        this.G = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRunningAnim(jb.d r10) {
        this.f16849u = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setScaffoldContainer(ViewGroup r10) {
        q.g(r10, "<set-?>");
        this.f16829a = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setScaffoldController(h r10) {
        q.g(r10, "<set-?>");
        this.f16838j = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setSheetBgColor(int r10) {
        OSheetBase.DefaultImpls.J(this, r10);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setShowing(boolean r10) {
        this.C = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setSystemInsetsAppearanceLightValue(Boolean r10) {
        this.f16847s = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setUserWindowHeight(int r10) {
        this.f16845q = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setUserWindowWidth(int r10) {
        this.f16844p = r10;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setupDimView(Context r10) {
        q.g(r10, "context");
        setDimView(new View(r10));
        if ((getRootContainer().getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r11 = getRootContainer().getParent();
        if (r11 == null) goto L8;
        ((ViewGroup) r11).addView(getDimView(), 0, new ViewGroup.LayoutParams(-1, -1));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setupView(Context r10) {
        q.g(r10, "context");
        OSheetBase.DefaultImpls.K(this, r10);
        updateMaterial();
    }

    @Override // android.app.Dialog
    public void show() {
        if (getShowing() == false) goto L5;
        updateFullWindowSize();
        getScaffoldController().i(getFullWindowSize());
    L9:
        super.show();
        setOnApplyWindowInsetsListener();
        Window r10 = getWindow();
        if (r10 == null) goto L49;
        r10.setBackgroundDrawableResource(R.color.transparent);
        h(r10);
        i(r10);
        if (getMClearDimFlag() == false) goto L15;
        r10.clearFlags(2);
    L16:
        Context r11 = r10.getContext();
        q.f(r11, "context");
        float r12 = e.b(r11);
        WindowManager.LayoutParams r13 = r10.getAttributes();
        if (getHeightStyle() != HeightMode.FULL_HEIGHT) goto L19;
    L22:
        boolean r14 = true;
    L23:
        this.f16842n = r14;
        boolean r15 = k();
        if (r15 == false) goto L26;
    L29:
        l.k(getDimView());
    L31:
        if (getShowing() == true) goto L34;
        r13.dimAmount = 0.0f;
        getDimView().setAlpha(0.0f);
    L34:
        if (needDimAnim() == true) goto L36;
    L37:
        if (r15 == false) goto L39;
        r13.dimAmount = r12;
    L41:
        if (this.f16842n == false) goto L43;
        int r16 = -1;
    L44:
        r10.setLayout(-1, r16);
        if (this.f16842n == false) goto L47;
        r13.setFitInsetsSides(0);
    L48:
        r13.layoutInDisplayCutoutMode = 3;
        r13.gravity = 80;
        r13.windowAnimations = 0;
        r10.setAttributes(r13);
        goto L49
    L47:
        r13.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        goto L48
    L43:
        r16 = -2;
        goto L44
    L39:
        r13.dimAmount = 0.0f;
        getDimView().setAlpha(r12);
        goto L41
    L36:
        if (getEnableEnterAnim() == true) goto L41;
    L26:
        if (getMClearDimFlag() == true) goto L29;
        l.m(getDimView());
        goto L31
    L19:
        if (this.f16841m == true) goto L22;
        r14 = false;
        goto L23
    L15:
        r10.addFlags(2);
    L49:
        setShowing(true);
        return;
    L5:
        if (getMCancelable() == false) goto L7;
        getDimView().setOnClickListener(new com.obric.oui.sheet.v2.a(this));
        goto L9
    L7:
        getDimView().setOnClickListener(null);
        goto L9
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void unregisterConfigurationCallbackIfNeeded() {
        OSheetBase.DefaultImpls.L(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void updateFullWindowSize() {
        OSheetBase.DefaultImpls.M(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void updateMaterial() {
        applyMaterial(true);
        o.n(getRootContainer(), getDimView());
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean useWindowDim() {
        return k();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Window windowForAnim() {
        return getWindow();
    }

    public OSheet(Context r10, int r11, int r12, boolean r13, boolean r14) {
        q.g(r10, "context");
        super(r10);
        this.f16836h = true;
        this.f16837i = true;
        this.f16839k = HeightMode.WRAP_HEIGHT;
        this.f16840l = r13;
        this.f16841m = true;
        this.f16843o = true;
        this.f16845q = r11;
        boolean r15 = false;
        this.f16846r = new Size(0, 0);
        this.A = true;
        this.E = new b(this);
        this.H = -1;
        if (r14 == true) goto L5;
    L10:
        Window r16 = getWindow();
        if (r16 == null) goto L14;
        r16.requestFeature(1);
    L14:
        setContentView(getContentLayoutResId());
        setupView(r10);
        return;
    L5:
        if (o.e(r10) == true) goto L7;
    L9:
        setEnableMaterial(r15);
        goto L10
    L7:
        if (OMaterialHelper.w() == false) goto L9;
        r15 = true;
        goto L9
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterButton(String r10, boolean r11, View.OnClickListener r12, String r13, boolean r14, View.OnClickListener r15) {
        OSheetBase.DefaultImpls.C(this, r10, r11, r12, r13, r14, r15);
    }
}
