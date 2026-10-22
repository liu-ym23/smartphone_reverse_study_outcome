package com.obric.oui.sheet.v2;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.common.oui.R;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.utils.ViewUtilKt;
import com.obric.oui.view.WindowInsetsCompat;
import com.obric.oui.window.OWindowConfigController;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSheetBase.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001a\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\r2\b\u00106\u001a\u0004\u0018\u00010\u000fJ\u0006\u00107\u001a\u000204J\u0006\u00108\u001a\u00020$J\u0006\u00109\u001a\u00020\u001eJ\u000e\u0010:\u001a\u0002042\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u000204J\u0010\u0010>\u001a\u0002042\b\u00106\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010?\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\r2\b\u00106\u001a\u0004\u0018\u00010\u000fJO\u0010@\u001a\u0002042\n\b\u0002\u0010A\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010B\u001a\u00020\u001e2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010F\u001a\u00020\u001e2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010D¢\u0006\u0002\u0010HJJ\u0010@\u001a\u0002042\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J2\b\b\u0002\u0010B\u001a\u00020\u001e2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J2\b\b\u0002\u0010F\u001a\u00020\u001e2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010DJ\u0010\u0010L\u001a\u0002042\b\u00106\u001a\u0004\u0018\u00010\u000fJµ\u0001\u0010M\u001a\u0002042\u0006\u0010N\u001a\u00020O2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010J2\b\b\u0002\u0010T\u001a\u00020\u001e2\b\u0010U\u001a\u0004\u0018\u00010D2\b\u0010V\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010^¢\u0006\u0002\u0010_J\u0010\u0010`\u001a\u0002042\b\u00106\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010a\u001a\u000204J\u000e\u0010b\u001a\u0002042\u0006\u0010;\u001a\u00020<J\u000e\u0010c\u001a\u0002042\u0006\u0010;\u001a\u00020<J\u0006\u0010d\u001a\u000204J\u0006\u0010e\u001a\u000204J\u0006\u0010f\u001a\u000204R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010'\"\u0004\b.\u0010)R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006g"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "", "context", "Landroid/content/Context;", "sheet", "Lcom/obric/oui/sheet/v2/OSheetBase;", "rootContainer", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "headerContainer", "Landroid/widget/FrameLayout;", "bodyContainer", "footerContainer", "scaffoldContainer", "Landroid/view/ViewGroup;", "dimView", "Landroid/view/View;", "(Landroid/content/Context;Lcom/obric/oui/sheet/v2/OSheetBase;Lcom/obric/oui/dialog/alert/view/RadiusLayout;Landroid/widget/FrameLayout;Landroid/widget/FrameLayout;Landroid/widget/FrameLayout;Landroid/view/ViewGroup;Landroid/view/View;)V", "getBodyContainer", "()Landroid/widget/FrameLayout;", "getDimView", "()Landroid/view/View;", "getFooterContainer", "getHeaderContainer", "heightStyle", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "getHeightStyle", "()Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "setHeightStyle", "(Lcom/obric/oui/sheet/v2/OSheet$HeightMode;)V", "ignoreInsetBottom", "", "getIgnoreInsetBottom", "()Z", "setIgnoreInsetBottom", "(Z)V", "maxBodyHeight", "", "maxRootHeight", "getMaxRootHeight", "()I", "setMaxRootHeight", "(I)V", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "rootContainerOriginPaddingBottom", "getRootContainerOriginPaddingBottom", "setRootContainerOriginPaddingBottom", "getScaffoldContainer", "()Landroid/view/ViewGroup;", "getSheet", "()Lcom/obric/oui/sheet/v2/OSheetBase;", "addChildToParent", "", "parent", "child", "calculateBodyMaxHeight", "getMaxBodyHeight", "isRootContainerMaxHeight", "refreshForConfiguration", "fullWindowSize", "Landroid/util/Size;", "removeOnApplyWindowInsetsListener", "setBodyView", "setChildToParent", "setFooterButton", "negativeBtnTextResId", "negativeIsPrimary", "negativeActionEvent", "Landroid/view/View$OnClickListener;", "positiveBtnTextResId", "positiveIsPrimary", "positiveActionEvent", "(Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;)V", "negativeBtnText", "", "positiveBtnText", "setFooterView", "setHeader", "style", "Lcom/obric/oui/sheet/v2/OSheet$Header;", "titleResId", "subTitleResId", "title", "subTitle", "showHandleView", "startActionEvent", "endActionEvent", "startActionDesResId", "endActionDesResId", "startActionDes", "endActionDesRes", "startActionIconResId", "endActionIconResId", "handleDelegate", "Lcom/obric/oui/sheet/v2/SheetMoveDelegate;", "(Lcom/obric/oui/sheet/v2/OSheet$Header;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLandroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/obric/oui/sheet/v2/SheetMoveDelegate;)V", "setHeaderView", "setOnApplyWindowInsetsListener", "setupRoot", "updateMaxRootHeight", "updateRootHeight", "updateRootSize", "updateRootWidth", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSheetScaffoldController {
    private final FrameLayout bodyContainer;
    private final Context context;
    private final View dimView;
    private final FrameLayout footerContainer;
    private final FrameLayout headerContainer;
    private OSheet.HeightMode heightStyle;
    private boolean ignoreInsetBottom;
    private int maxBodyHeight;
    private int maxRootHeight;
    private final RadiusLayout rootContainer;
    private int rootContainerOriginPaddingBottom;
    private final ViewGroup scaffoldContainer;
    private final OSheetBase sheet;

    /* JADX INFO: compiled from: OSheetBase.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[OSheet.HeightMode.values().length];
            r0[OSheet.HeightMode.FULL_HEIGHT.ordinal()] = 1;
            r0[OSheet.HeightMode.WRAP_HEIGHT.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[OSheet.Header.values().length];
            r1[OSheet.Header.PAGE.ordinal()] = 1;
            r1[OSheet.Header.ACTION.ordinal()] = 2;
            r1[OSheet.Header.MODAL.ordinal()] = 3;
            r1[OSheet.Header.ONLY_TITLE.ordinal()] = 4;
            r1[OSheet.Header.PAGE_WITH_CLOSE.ordinal()] = 5;
            $EnumSwitchMapping$1 = r1;
        }
    }

    public static /* synthetic */ void $r8$lambda$JjEYsSbmWuVOBufFIT7YxUieXpQ(View r0) {
        m699setupRoot$lambda0(r0);
    }

    public static /* synthetic */ WindowInsets $r8$lambda$asTo9Za0fEwreeND9zdWxhY3PLY(OSheetScaffoldController r0, View r1, WindowInsets r2) {
        return m698setOnApplyWindowInsetsListener$lambda2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: setupRoot$lambda-0, reason: not valid java name */
    private static final void m699setupRoot$lambda0(View r0) {
    }

    public OSheetScaffoldController(Context r2, OSheetBase r3, RadiusLayout r4, FrameLayout r5, FrameLayout r6, FrameLayout r7, ViewGroup r8, View r9) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "sheet");
        Intrinsics.checkNotNullParameter(r4, "rootContainer");
        Intrinsics.checkNotNullParameter(r5, "headerContainer");
        Intrinsics.checkNotNullParameter(r6, "bodyContainer");
        Intrinsics.checkNotNullParameter(r7, "footerContainer");
        Intrinsics.checkNotNullParameter(r8, "scaffoldContainer");
        Intrinsics.checkNotNullParameter(r9, "dimView");
        this.context = r2;
        this.sheet = r3;
        this.rootContainer = r4;
        this.headerContainer = r5;
        this.bodyContainer = r6;
        this.footerContainer = r7;
        this.scaffoldContainer = r8;
        this.dimView = r9;
        this.heightStyle = OSheet.HeightMode.WRAP_HEIGHT;
        this.rootContainerOriginPaddingBottom = r4.getPaddingBottom();
    }

    public final OSheetBase getSheet() {
        return this.sheet;
    }

    public final RadiusLayout getRootContainer() {
        return this.rootContainer;
    }

    public final FrameLayout getHeaderContainer() {
        return this.headerContainer;
    }

    public final FrameLayout getBodyContainer() {
        return this.bodyContainer;
    }

    public final FrameLayout getFooterContainer() {
        return this.footerContainer;
    }

    public final ViewGroup getScaffoldContainer() {
        return this.scaffoldContainer;
    }

    public final View getDimView() {
        return this.dimView;
    }

    public final int getMaxRootHeight() {
        return this.maxRootHeight;
    }

    public final void setMaxRootHeight(int r1) {
        this.maxRootHeight = r1;
    }

    public final OSheet.HeightMode getHeightStyle() {
        return this.heightStyle;
    }

    public final void setHeightStyle(OSheet.HeightMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.heightStyle = r2;
    }

    public final boolean getIgnoreInsetBottom() {
        return this.ignoreInsetBottom;
    }

    public final void setIgnoreInsetBottom(boolean r1) {
        this.ignoreInsetBottom = r1;
    }

    public final int getRootContainerOriginPaddingBottom() {
        return this.rootContainerOriginPaddingBottom;
    }

    public final void setRootContainerOriginPaddingBottom(int r1) {
        this.rootContainerOriginPaddingBottom = r1;
    }

    public final void setupRoot(Size r3) {
        Intrinsics.checkNotNullParameter(r3, "fullWindowSize");
        this.rootContainer.setOnClickListener(new OSheetScaffoldController$$ExternalSyntheticLambda0());
        this.scaffoldContainer.setClipChildren(false);
        this.dimView.setBackgroundColor(-16777216);
        this.dimView.setAlpha(0.0f);
        ViewExtensionsKt.makeGone(this.dimView);
        updateMaxRootHeight(r3);
        updateRootSize();
        SheetAnimStyle.INSTANCE.adjustSheetRootTopSpace(this.rootContainer);
        calculateBodyMaxHeight();
    }

    public final void updateMaxRootHeight(Size r3) {
        Intrinsics.checkNotNullParameter(r3, "fullWindowSize");
        if (r3.getWidth() <= r3.getHeight()) goto L5;
        this.maxRootHeight = (int) (r3.getHeight() * 0.84f);
        return;
    L5:
        this.maxRootHeight = (int) (r3.getHeight() * 0.93f);
    }

    public final void refreshForConfiguration(Size r2) {
        Intrinsics.checkNotNullParameter(r2, "fullWindowSize");
        updateMaxRootHeight(r2);
        updateRootSize();
        SheetAnimStyle.INSTANCE.adjustSheetRootTopSpace(this.rootContainer);
        calculateBodyMaxHeight();
        this.rootContainer.requestLayout();
    }

    public final void updateRootSize() {
        updateRootWidth();
        updateRootHeight();
    }

    public final void updateRootWidth() {
        int r0 = this.context.getResources().getDisplayMetrics().widthPixels;
        int r1 = OSheetBaseKt.getSheetMaxWidth(this.context, r0);
        ViewUtilKt.setWidth(this.rootContainer, r1);
        float r2 = this.context.getResources().getDimension(R.dimen.oui_r_l3);
        this.rootContainer.setRadius(r2, r2, 0.0f, 0.0f);
    }

    public final void updateRootHeight() {
        this.rootContainer.setMaxHeight(this.maxRootHeight);
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.heightStyle.ordinal()];
        boolean r3 = false;
        if (r0 != 1) goto L5;
        ViewUtilKt.setHeight(this.rootContainer, this.maxRootHeight);
        if ((this.scaffoldContainer instanceof LinearLayout) == false) goto L27;
        ViewGroup.LayoutParams r1 = this.bodyContainer.getLayoutParams();
        if (r1 == null) goto L26;
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) r1;
        r2.weight = 1.0f;
        r2.height = 0;
        this.bodyContainer.setLayoutParams(r2);
    L30:
        this.scaffoldContainer.getLayoutParams().height = -1;
    L31:
        RadiusLayout r4 = this.rootContainer;
        if (this.heightStyle != OSheet.HeightMode.WRAP_HEIGHT) goto L34;
        r3 = true;
    L34:
        r4.setMeasureHeightUnspecified(r3);
        RadiusLayout r6 = this.rootContainer;
        ViewGroup.LayoutParams r5 = r6.getLayoutParams();
        if (r5 == null) goto L39;
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r5;
        r7.gravity = 81;
        r6.setLayoutParams(r7);
        return;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L27:
        ViewGroup.LayoutParams r8 = this.bodyContainer.getLayoutParams();
        if (r8 == null) goto L41;
        r8.height = -1;
        this.bodyContainer.setLayoutParams(r8);
        goto L30
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L5:
        if (r0 != 2) goto L31;
        ViewUtilKt.setHeight(this.rootContainer, -2);
        if ((this.scaffoldContainer instanceof LinearLayout) == false) goto L14;
        ViewGroup.LayoutParams r9 = this.bodyContainer.getLayoutParams();
        if (r9 == null) goto L13;
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) r9;
        r10.weight = 0.0f;
        r10.height = -2;
        this.bodyContainer.setLayoutParams(r10);
    L17:
        this.scaffoldContainer.getLayoutParams().height = -2;
        goto L31
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L14:
        ViewGroup.LayoutParams r11 = this.bodyContainer.getLayoutParams();
        if (r11 == null) goto L19;
        r11.height = -2;
        this.bodyContainer.setLayoutParams(r11);
        goto L17
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void setOnApplyWindowInsetsListener() {
        this.rootContainer.setOnApplyWindowInsetsListener(new OSheetScaffoldController$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: setOnApplyWindowInsetsListener$lambda-2, reason: not valid java name */
    private static final WindowInsets m698setOnApplyWindowInsetsListener$lambda2(OSheetScaffoldController r3, View r4, WindowInsets r5) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r5, "insets");
        if (r3.ignoreInsetBottom == true) goto L5;
    L8:
        WindowInsetsCompat r0 = WindowInsetsCompat.toWindowInsetsCompat(r5);
        Intrinsics.checkNotNullExpressionValue(r0, "toWindowInsetsCompat(insets)");
        int r1 = r0.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars()).bottom;
        int r2 = OWindowConfigController.INSTANCE.getImeHeight(r4);
        if (r2 <= 0) goto L11;
        r4.setPadding(0, 0, 0, r2);
    L17:
        return r5;
    L11:
        ViewUtilKt.setMarginBottom(r4, 0);
        if (r1 == 0) goto L14;
    L16:
        r4.setPadding(0, 0, 0, r1 + r3.rootContainerOriginPaddingBottom);
        goto L17
    L14:
        if (r4.getRootWindowInsets() == null) goto L16;
        WindowInsetsCompat r6 = WindowInsetsCompat.toWindowInsetsCompat(r4.getRootWindowInsets());
        Intrinsics.checkNotNullExpressionValue(r6, "toWindowInsetsCompat(v.rootWindowInsets)");
        r1 = r6.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars()).bottom;
        goto L16
    L5:
        if ((r3.footerContainer.getChildAt(0) instanceof OSheetFooterBtnContainer) == true) goto L8;
        r4.setPadding(0, 0, 0, r3.rootContainerOriginPaddingBottom);
        return r5;
    }

    public final void removeOnApplyWindowInsetsListener() {
        this.rootContainer.setOnApplyWindowInsetsListener(null);
    }

    public static /* synthetic */ void setHeader$default(OSheetScaffoldController r19, OSheet.Header r20, Integer r21, Integer r22, String r23, String r24, boolean r25, View.OnClickListener r26, View.OnClickListener r27, Integer r28, Integer r29, String r30, String r31, Integer r32, Integer r33, SheetMoveDelegate r34, int r35, Object r36) {
        if ((r35 & 2) == 0) goto L5;
        Integer r5 = null;
    L7:
        if ((r35 & 4) == 0) goto L9;
        Integer r6 = null;
    L11:
        if ((r35 & 8) == 0) goto L13;
        String r7 = null;
    L15:
        if ((r35 & 16) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r35 & 32) == 0) goto L21;
        boolean r9 = false;
    L23:
        if ((r35 & 256) == 0) goto L25;
        Integer r12 = null;
    L27:
        if ((r35 & 512) == 0) goto L29;
        Integer r13 = null;
    L31:
        if ((r35 & 1024) == 0) goto L33;
        String r14 = null;
    L35:
        if ((r35 & 2048) == 0) goto L37;
        String r15 = null;
    L39:
        if ((r35 & 4096) == 0) goto L41;
        Integer r16 = null;
    L43:
        if ((r35 & 8192) == 0) goto L45;
        Integer r17 = null;
    L47:
        if ((r35 & 16384) == 0) goto L49;
        SheetMoveDelegate r18 = null;
    L50:
        r19.setHeader(r20, r5, r6, r7, r8, r9, r26, r27, r12, r13, r14, r15, r16, r17, r18);
        return;
    L49:
        r18 = r34;
        goto L50
    L45:
        r17 = r33;
        goto L47
    L41:
        r16 = r32;
        goto L43
    L37:
        r15 = r31;
        goto L39
    L33:
        r14 = r30;
        goto L35
    L29:
        r13 = r29;
        goto L31
    L25:
        r12 = r28;
        goto L27
    L21:
        r9 = r25;
        goto L23
    L17:
        r8 = r24;
        goto L19
    L13:
        r7 = r23;
        goto L15
    L9:
        r6 = r22;
        goto L11
    L5:
        r5 = r21;
        goto L7
    }

    public final void setHeader(OSheet.Header r19, Integer r20, Integer r21, String r22, String r23, boolean r24, View.OnClickListener r25, View.OnClickListener r26, Integer r27, Integer r28, String r29, String r30, Integer r31, Integer r32, SheetMoveDelegate r33) {
        Intrinsics.checkNotNullParameter(r19, "style");
        if (r20 == null) goto L5;
        String r4 = this.context.getString(r20.intValue());
    L6:
        if (r21 == null) goto L8;
        String r6 = this.context.getString(r21.intValue());
    L9:
        if (r27 == null) goto L11;
        String r7 = this.context.getString(r27.intValue());
    L12:
        if (r28 == null) goto L14;
        String r8 = this.context.getString(r28.intValue());
    L15:
        int r5 = WhenMappings.$EnumSwitchMapping$1[r19.ordinal()];
        if (r5 != 1) goto L18;
        OSheetTitleBar r2 = new OSheetTitleBar(this.context, null, 0, 6, null);
        r2.setTitleText(r4);
        r2.setSubTitleText(r6);
        if (r25 == null) goto L74;
        r2.findViewById(R.id.left_action_back).setOnClickListener(r25);
    L74:
        OSheetTitleBar r1 = r2;
    L75:
        if (r1 == null) goto L84;
        r1.setClipChildren(false);
        if (r24 == false) goto L82;
        if (r33 == null) goto L82;
        r1.createHandleView(this.context, r33);
    L82:
        setHeaderView(r1);
        r1.applyMaskMaterial(getSheet().isContentOverlayMode());
        getHeaderContainer().setClipChildren(false);
        return;
    L84:
        return;
    L18:
        if (r5 != 2) goto L20;
        OSheetTitleBar r9 = new OSheetTitleBar(this.context, null, 0, 6, null);
        r9.setShowLeftBack(false);
        r9.setTitleText(r4);
        r9.setSubTitleText(r6);
        Context r13 = r9.getContext();
        Intrinsics.checkNotNullExpressionValue(r13, "context");
        LinearLayout r14 = r9.getMLeftContainer();
        if (r31 != null) goto L56;
        int r10 = R.drawable.oui_ic_title_bar_close;
    L57:
        OIconButtonFloating r11 = r9.createNeutralIconButton(r13, r14, r10, r9.getContext().getColorStateList(R.color.oui_text_1), Integer.valueOf(R.string.oui_iv_close_desc));
        r11.setId(R.id.btn_start_action);
        r11.setContentDescription(r7);
        if (r25 == null) goto L61;
        r11.setOnClickListener(r25);
    L61:
        Context r3 = r9.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        LinearLayout r12 = r9.getMRightContainer();
        if (r32 != null) goto L64;
        int r15 = R.drawable.oui_ic_title_bar_confirm;
    L65:
        int r34 = r15;
        OIconButtonFloating r16 = r9.createPrimaryIconButton(r3, r12, r34, r9.getContext().getColorStateList(R.color.oui_on_accent_default), Integer.valueOf(R.string.oui_confirm));
        r16.setId(R.id.btn_end_action);
        r16.setContentDescription(r8);
        if (r26 == null) goto L69;
        r16.setOnClickListener(r26);
    L69:
        r1 = r9;
        goto L75
    L64:
        r15 = r32.intValue();
        goto L65
    L56:
        r10 = r31.intValue();
        goto L57
    L20:
        if (r5 != 3) goto L22;
        r1 = new OSheetTitleBar(this.context, null, 0, 6, null);
        r1.setShowLeftBack(false);
        r1.setTitleText(r4);
        r1.setSubTitleText(r6);
        Context r17 = r1.getContext();
        Intrinsics.checkNotNullExpressionValue(r17, "context");
        LinearLayout r18 = r1.getMRightContainer();
        if (r31 != null) goto L48;
        int r35 = R.drawable.oui_ic_title_bar_close;
    L49:
        int r36 = r35;
        OIconButtonFloating r37 = r1.createNeutralIconButton(r17, r18, r36, r1.getContext().getColorStateList(R.color.oui_text_1), Integer.valueOf(R.string.oui_iv_close_desc));
        r37.setId(R.id.btn_end_action);
        r37.setContentDescription(r8);
        if (r26 == null) goto L75;
        r37.setOnClickListener(r26);
        goto L75
    L48:
        r35 = r31.intValue();
        goto L49
    L22:
        if (r5 != 4) goto L24;
        r1 = new OSheetTitleBar(this.context, null, 0, 6, null);
        r1.setShowLeftBack(false);
        r1.setTitleText(r4);
        r1.setSubTitleText(r6);
        goto L75
    L24:
        if (r5 == 5) goto L26;
        r1 = null;
        goto L75
    L26:
        r9 = new OSheetTitleBar(this.context, null, 0, 6, null);
        r9.setTitleText(r4);
        r9.setSubTitleText(r6);
        if (r25 == null) goto L33;
        View r38 = r9.findViewById(R.id.left_action_back);
        if (r38 == null) goto L33;
        r38.setOnClickListener(r25);
    L33:
        Context r39 = r9.getContext();
        Intrinsics.checkNotNullExpressionValue(r39, "context");
        LinearLayout r40 = r9.getMRightContainer();
        if (r32 != null) goto L36;
        int r41 = R.drawable.oui_ic_title_bar_close;
    L37:
        int r310 = r41;
        OIconButtonFloating r42 = r9.createNeutralIconButton(r39, r40, r310, r9.getContext().getColorStateList(R.color.oui_text_1), Integer.valueOf(R.string.oui_iv_close_desc));
        r42.setId(R.id.btn_end_action);
        if (r8 == null) goto L41;
        r42.setContentDescription(r8);
    L41:
        if (r26 == null) goto L69;
        r42.setOnClickListener(r26);
        goto L69
    L36:
        r41 = r32.intValue();
        goto L37
    L14:
        r8 = r30;
        goto L15
    L11:
        r7 = r29;
        goto L12
    L8:
        r6 = r23;
        goto L9
    L5:
        r4 = r22;
        goto L6
    }

    public final void setHeaderView(View r2) {
        setChildToParent(this.headerContainer, r2);
    }

    public final void setBodyView(View r2) {
        setChildToParent(this.bodyContainer, r2);
    }

    public final void setFooterView(View r2) {
        setChildToParent(this.footerContainer, r2);
    }

    public static /* synthetic */ void setFooterButton$default(OSheetScaffoldController r1, Integer r2, boolean r3, View.OnClickListener r4, Integer r5, boolean r6, View.OnClickListener r7, int r8, Object r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = true;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        r1.setFooterButton(r2, r3, r4, r5, r6, r7);
    }

    public final void setFooterButton(Integer r9, boolean r10, View.OnClickListener r11, Integer r12, boolean r13, View.OnClickListener r14) {
        OSheetFooterBtnContainer r7 = new OSheetFooterBtnContainer(this.context, null, 2, null);
        r7.setButtons(r9, r10, r11, r12, r13, r14);
        setFooterView(r7);
    }

    public static /* synthetic */ void setFooterButton$default(OSheetScaffoldController r1, String r2, boolean r3, View.OnClickListener r4, String r5, boolean r6, View.OnClickListener r7, int r8, Object r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = true;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        r1.setFooterButton(r2, r3, r4, r5, r6, r7);
    }

    public final void setFooterButton(String r9, boolean r10, View.OnClickListener r11, String r12, boolean r13, View.OnClickListener r14) {
        OSheetFooterBtnContainer r7 = new OSheetFooterBtnContainer(this.context, null, 2, null);
        r7.setButtons(r9, r10, r11, r12, r13, r14);
        setFooterView(r7);
    }

    public final void calculateBodyMaxHeight() {
        this.maxBodyHeight = (((this.maxRootHeight - this.headerContainer.getHeight()) - this.footerContainer.getHeight()) - this.rootContainer.getPaddingTop()) - this.rootContainer.getPaddingBottom();
    }

    public final int getMaxBodyHeight() {
        return this.maxBodyHeight;
    }

    public final boolean isRootContainerMaxHeight() {
        if (this.rootContainer.getHeight() < this.maxRootHeight) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setChildToParent(ViewGroup r1, View r2) {
        if (r2 == null) goto L12;
        if (r1 == null) goto L6;
        ViewExtensionsKt.makeVisible(r1);
    L6:
        if (r1 == null) goto L9;
        r1.removeAllViews();
    L9:
        if (r1 == null) goto L20;
        r1.addView(r2);
        return;
    L20:
        return;
    L12:
        if (r1 == null) goto L15;
        r1.removeAllViews();
    L15:
        if (r1 == null) goto L21;
        ViewExtensionsKt.makeGone(r1);
        return;
    }

    public final void addChildToParent(ViewGroup r1, View r2) {
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        ViewExtensionsKt.makeVisible(r1);
    L6:
        if (r1 == null) goto L14;
        r1.addView(r2);
        return;
    L14:
        return;
    L9:
        if (r1 == null) goto L15;
        ViewExtensionsKt.makeGone(r1);
        return;
    }
}
