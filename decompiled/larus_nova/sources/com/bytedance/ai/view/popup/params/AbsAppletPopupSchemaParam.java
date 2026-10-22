package com.bytedance.ai.view.popup.params;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.view.popup.anim.AnimationStyle;
import com.bytedance.ai.view.popup.o;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\bw\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001a\u0010(\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001a\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001a\u00101\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR\u001a\u00104\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR\u001a\u00107\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\"\"\u0004\b9\u0010$R\u001a\u0010:\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\u001a\u0010=\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010\u0012R\u001a\u0010@\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012R\u001a\u0010C\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0010\"\u0004\bE\u0010\u0012R\u001a\u0010F\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010\u0012R\u001a\u0010I\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\"\"\u0004\bK\u0010$R\u001a\u0010L\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0010\"\u0004\bN\u0010\u0012R\u001a\u0010O\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0010\"\u0004\bQ\u0010\u0012R\u001a\u0010R\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0010\"\u0004\bT\u0010\u0012R\u001a\u0010U\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\"\"\u0004\bW\u0010$R\u001a\u0010X\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\"\"\u0004\bZ\u0010$R\u001a\u0010[\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\"\"\u0004\b]\u0010$R\u001a\u0010^\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\"\"\u0004\b`\u0010$R\u001a\u0010a\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\"\"\u0004\bc\u0010$R\u001c\u0010d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0007\"\u0004\bf\u0010\tR\u001c\u0010g\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0007\"\u0004\bi\u0010\tR\u001a\u0010j\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0007\"\u0004\bl\u0010\tR\u001a\u0010m\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0010\"\u0004\bo\u0010\u0012R\u001a\u0010p\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0010\"\u0004\br\u0010\u0012R\u001a\u0010s\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u0010\"\u0004\bu\u0010\u0012R\u001a\u0010v\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0010\"\u0004\bx\u0010\u0012R\u001a\u0010y\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0010\"\u0004\b{\u0010\u0012R\u001a\u0010|\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u0010\"\u0004\b~\u0010\u0012R\u001c\u0010\u007f\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\"\"\u0005\b\u0081\u0001\u0010$R\u001d\u0010\u0082\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0010\"\u0005\b\u0084\u0001\u0010\u0012R\u001d\u0010\u0085\u0001\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\"\"\u0005\b\u0087\u0001\u0010$R\u001d\u0010\u0088\u0001\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010\"\"\u0005\b\u008a\u0001\u0010$R\u001d\u0010\u008b\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u0010\"\u0005\b\u008d\u0001\u0010\u0012R\u001d\u0010\u008e\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u0010\"\u0005\b\u0090\u0001\u0010\u0012R\u001d\u0010\u0091\u0001\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\"\"\u0005\b\u0093\u0001\u0010$R\u001d\u0010\u0094\u0001\u001a\u00020 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\"\"\u0005\b\u0096\u0001\u0010$¨\u0006\u0097\u0001"}, d2 = {"Lcom/bytedance/ai/view/popup/params/AbsAppletPopupSchemaParam;", "Ljava/io/Serializable;", "<init>", "()V", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "getGravity", "()Ljava/lang/String;", "setGravity", "(Ljava/lang/String;)V", "landscapeGravity", "getLandscapeGravity", "setLandscapeGravity", "width", "", "getWidth", "()I", "setWidth", "(I)V", "landscapeWidth", "getLandscapeWidth", "setLandscapeWidth", "height", "getHeight", "setHeight", "landscapeHeight", "getLandscapeHeight", "setLandscapeHeight", "radius", "getRadius", "setRadius", "showMask", "", "getShowMask", "()Z", "setShowMask", "(Z)V", "disableOutsideClickClose", "getDisableOutsideClickClose", "setDisableOutsideClickClose", "enablePullDownClose", "getEnablePullDownClose", "setEnablePullDownClose", "transitionAnimationIn", "getTransitionAnimationIn", "setTransitionAnimationIn", "transitionAnimationOut", "getTransitionAnimationOut", "setTransitionAnimationOut", "floatingPageName", "getFloatingPageName", "setFloatingPageName", "landscapeTransitionAnimation", "getLandscapeTransitionAnimation", "setLandscapeTransitionAnimation", "dragByGesture", "getDragByGesture", "setDragByGesture", "dragHeight", "getDragHeight", "setDragHeight", "dragUpThreshold", "getDragUpThreshold", "setDragUpThreshold", "dragDownThreshold", "getDragDownThreshold", "setDragDownThreshold", "dragDownCloseThreshold", "getDragDownCloseThreshold", "setDragDownCloseThreshold", "peekDownCloseThreshold", "getPeekDownCloseThreshold", "setPeekDownCloseThreshold", "dragBack", "getDragBack", "setDragBack", "variableHeight", "getVariableHeight", "setVariableHeight", "minMarginTop", "getMinMarginTop", "setMinMarginTop", "dragMinMarginTop", "getDragMinMarginTop", "setDragMinMarginTop", "selfAdaptiveHeight", "getSelfAdaptiveHeight", "setSelfAdaptiveHeight", "ignoreKeyboardStatusChange", "getIgnoreKeyboardStatusChange", "setIgnoreKeyboardStatusChange", "forceDialogNonCancelable", "getForceDialogNonCancelable", "setForceDialogNonCancelable", "popupFollowActivityUi", "getPopupFollowActivityUi", "setPopupFollowActivityUi", "transStatusBar", "getTransStatusBar", "setTransStatusBar", "statusFontMode", "getStatusFontMode", "setStatusFontMode", "navigationFontMode", "getNavigationFontMode", "setNavigationFontMode", "resizeDuration", "getResizeDuration", "setResizeDuration", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "marginTop", "getMarginTop", "setMarginTop", "marginBottom", "getMarginBottom", "setMarginBottom", "marginStart", "getMarginStart", "setMarginStart", "marginEnd", "getMarginEnd", "setMarginEnd", "keyboardCompat", "getKeyboardCompat", "setKeyboardCompat", "keyboardAdjust", "getKeyboardAdjust", "setKeyboardAdjust", "transNavigationBar", "getTransNavigationBar", "setTransNavigationBar", "disableBackPress", "getDisableBackPress", "setDisableBackPress", "navigationBarBgColor", "getNavigationBarBgColor", "setNavigationBarBgColor", "windowBackgroundColor", "getWindowBackgroundColor", "setWindowBackgroundColor", "appearanceLightNavigationBars", "getAppearanceLightNavigationBars", "setAppearanceLightNavigationBars", "bounceWithKeyboard", "getBounceWithKeyboard", "setBounceWithKeyboard", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsAppletPopupSchemaParam implements Serializable {
    private boolean appearanceLightNavigationBars;
    private boolean bounceWithKeyboard;
    private boolean disableBackPress;
    private boolean disableOutsideClickClose;
    private boolean dragBack;
    private boolean dragByGesture;
    private int dragDownCloseThreshold;
    private int dragDownThreshold;
    private int dragHeight;
    private int dragMinMarginTop;
    private int dragUpThreshold;
    private boolean enablePullDownClose;
    private String floatingPageName;
    private boolean forceDialogNonCancelable;
    private String gravity;
    private int height;
    private boolean ignoreKeyboardStatusChange;
    private int keyboardAdjust;
    private boolean keyboardCompat;
    private String landscapeGravity;
    private int landscapeHeight;
    private String landscapeTransitionAnimation;
    private int landscapeWidth;
    private int marginBottom;
    private int marginEnd;
    private int marginLeft;
    private int marginRight;
    private int marginStart;
    private int marginTop;
    private int minMarginTop;
    private int navigationBarBgColor;
    private String navigationFontMode;
    private int peekDownCloseThreshold;
    private boolean popupFollowActivityUi;
    private int radius;
    private String resizeDuration;
    private boolean selfAdaptiveHeight;
    private boolean showMask;
    private String statusFontMode;
    private boolean transNavigationBar;
    private boolean transStatusBar;
    private String transitionAnimationIn;
    private String transitionAnimationOut;
    private int variableHeight;
    private int width;
    private int windowBackgroundColor;

    public AbsAppletPopupSchemaParam() {
        this.gravity = "bottom";
        this.landscapeGravity = "";
        this.width = o.f37909a;
        this.landscapeWidth = -1;
        this.height = o.f37910b;
        this.landscapeHeight = -1;
        this.radius = 8;
        AnimationStyle r100 = AnimationStyle.AUTO;
        this.transitionAnimationIn = r100.getValue();
        this.transitionAnimationOut = r100.getValue();
        this.floatingPageName = "";
        this.landscapeTransitionAnimation = "";
        this.dragHeight = -1;
        this.dragUpThreshold = o.f37911c;
        this.popupFollowActivityUi = true;
        this.resizeDuration = "0.3";
        this.keyboardAdjust = 1;
        this.appearanceLightNavigationBars = true;
    }

    public final boolean getAppearanceLightNavigationBars() {
        return this.appearanceLightNavigationBars;
    }

    public final boolean getBounceWithKeyboard() {
        return this.bounceWithKeyboard;
    }

    public final boolean getDisableBackPress() {
        return this.disableBackPress;
    }

    public final boolean getDisableOutsideClickClose() {
        return this.disableOutsideClickClose;
    }

    public final boolean getDragBack() {
        return this.dragBack;
    }

    public final boolean getDragByGesture() {
        return this.dragByGesture;
    }

    public final int getDragDownCloseThreshold() {
        return this.dragDownCloseThreshold;
    }

    public final int getDragDownThreshold() {
        return this.dragDownThreshold;
    }

    public final int getDragHeight() {
        return this.dragHeight;
    }

    public final int getDragMinMarginTop() {
        return this.dragMinMarginTop;
    }

    public final int getDragUpThreshold() {
        return this.dragUpThreshold;
    }

    public final boolean getEnablePullDownClose() {
        return this.enablePullDownClose;
    }

    public final String getFloatingPageName() {
        return this.floatingPageName;
    }

    public final boolean getForceDialogNonCancelable() {
        return this.forceDialogNonCancelable;
    }

    public final String getGravity() {
        return this.gravity;
    }

    public final int getHeight() {
        return this.height;
    }

    public final boolean getIgnoreKeyboardStatusChange() {
        return this.ignoreKeyboardStatusChange;
    }

    public final int getKeyboardAdjust() {
        return this.keyboardAdjust;
    }

    public final boolean getKeyboardCompat() {
        return this.keyboardCompat;
    }

    public final String getLandscapeGravity() {
        return this.landscapeGravity;
    }

    public final int getLandscapeHeight() {
        return this.landscapeHeight;
    }

    public final String getLandscapeTransitionAnimation() {
        return this.landscapeTransitionAnimation;
    }

    public final int getLandscapeWidth() {
        return this.landscapeWidth;
    }

    public final int getMarginBottom() {
        return this.marginBottom;
    }

    public final int getMarginEnd() {
        return this.marginEnd;
    }

    public final int getMarginLeft() {
        return this.marginLeft;
    }

    public final int getMarginRight() {
        return this.marginRight;
    }

    public final int getMarginStart() {
        return this.marginStart;
    }

    public final int getMarginTop() {
        return this.marginTop;
    }

    public final int getMinMarginTop() {
        return this.minMarginTop;
    }

    public final int getNavigationBarBgColor() {
        return this.navigationBarBgColor;
    }

    public final String getNavigationFontMode() {
        return this.navigationFontMode;
    }

    public final int getPeekDownCloseThreshold() {
        return this.peekDownCloseThreshold;
    }

    public final boolean getPopupFollowActivityUi() {
        return this.popupFollowActivityUi;
    }

    public final int getRadius() {
        return this.radius;
    }

    public final String getResizeDuration() {
        return this.resizeDuration;
    }

    public final boolean getSelfAdaptiveHeight() {
        return this.selfAdaptiveHeight;
    }

    public final boolean getShowMask() {
        return this.showMask;
    }

    public final String getStatusFontMode() {
        return this.statusFontMode;
    }

    public final boolean getTransNavigationBar() {
        return this.transNavigationBar;
    }

    public final boolean getTransStatusBar() {
        return this.transStatusBar;
    }

    public final String getTransitionAnimationIn() {
        return this.transitionAnimationIn;
    }

    public final String getTransitionAnimationOut() {
        return this.transitionAnimationOut;
    }

    public final int getVariableHeight() {
        return this.variableHeight;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getWindowBackgroundColor() {
        return this.windowBackgroundColor;
    }

    public final void setAppearanceLightNavigationBars(boolean r100) {
        this.appearanceLightNavigationBars = r100;
    }

    public final void setBounceWithKeyboard(boolean r100) {
        this.bounceWithKeyboard = r100;
    }

    public final void setDisableBackPress(boolean r100) {
        this.disableBackPress = r100;
    }

    public final void setDisableOutsideClickClose(boolean r100) {
        this.disableOutsideClickClose = r100;
    }

    public final void setDragBack(boolean r100) {
        this.dragBack = r100;
    }

    public final void setDragByGesture(boolean r100) {
        this.dragByGesture = r100;
    }

    public final void setDragDownCloseThreshold(int r100) {
        this.dragDownCloseThreshold = r100;
    }

    public final void setDragDownThreshold(int r100) {
        this.dragDownThreshold = r100;
    }

    public final void setDragHeight(int r100) {
        this.dragHeight = r100;
    }

    public final void setDragMinMarginTop(int r100) {
        this.dragMinMarginTop = r100;
    }

    public final void setDragUpThreshold(int r100) {
        this.dragUpThreshold = r100;
    }

    public final void setEnablePullDownClose(boolean r100) {
        this.enablePullDownClose = r100;
    }

    public final void setFloatingPageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.floatingPageName = r100;
    }

    public final void setForceDialogNonCancelable(boolean r100) {
        this.forceDialogNonCancelable = r100;
    }

    public final void setGravity(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gravity = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setIgnoreKeyboardStatusChange(boolean r100) {
        this.ignoreKeyboardStatusChange = r100;
    }

    public final void setKeyboardAdjust(int r100) {
        this.keyboardAdjust = r100;
    }

    public final void setKeyboardCompat(boolean r100) {
        this.keyboardCompat = r100;
    }

    public final void setLandscapeGravity(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.landscapeGravity = r100;
    }

    public final void setLandscapeHeight(int r100) {
        this.landscapeHeight = r100;
    }

    public final void setLandscapeTransitionAnimation(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.landscapeTransitionAnimation = r100;
    }

    public final void setLandscapeWidth(int r100) {
        this.landscapeWidth = r100;
    }

    public final void setMarginBottom(int r100) {
        this.marginBottom = r100;
    }

    public final void setMarginEnd(int r100) {
        this.marginEnd = r100;
    }

    public final void setMarginLeft(int r100) {
        this.marginLeft = r100;
    }

    public final void setMarginRight(int r100) {
        this.marginRight = r100;
    }

    public final void setMarginStart(int r100) {
        this.marginStart = r100;
    }

    public final void setMarginTop(int r100) {
        this.marginTop = r100;
    }

    public final void setMinMarginTop(int r100) {
        this.minMarginTop = r100;
    }

    public final void setNavigationBarBgColor(int r100) {
        this.navigationBarBgColor = r100;
    }

    public final void setNavigationFontMode(String r100) {
        this.navigationFontMode = r100;
    }

    public final void setPeekDownCloseThreshold(int r100) {
        this.peekDownCloseThreshold = r100;
    }

    public final void setPopupFollowActivityUi(boolean r100) {
        this.popupFollowActivityUi = r100;
    }

    public final void setRadius(int r100) {
        this.radius = r100;
    }

    public final void setResizeDuration(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resizeDuration = r100;
    }

    public final void setSelfAdaptiveHeight(boolean r100) {
        this.selfAdaptiveHeight = r100;
    }

    public final void setShowMask(boolean r100) {
        this.showMask = r100;
    }

    public final void setStatusFontMode(String r100) {
        this.statusFontMode = r100;
    }

    public final void setTransNavigationBar(boolean r100) {
        this.transNavigationBar = r100;
    }

    public final void setTransStatusBar(boolean r100) {
        this.transStatusBar = r100;
    }

    public final void setTransitionAnimationIn(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.transitionAnimationIn = r100;
    }

    public final void setTransitionAnimationOut(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.transitionAnimationOut = r100;
    }

    public final void setVariableHeight(int r100) {
        this.variableHeight = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public final void setWindowBackgroundColor(int r100) {
        this.windowBackgroundColor = r100;
    }
}
