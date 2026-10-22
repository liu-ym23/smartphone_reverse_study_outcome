package com.obric.oui.sheet.v2;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.window.OWindowConfigController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSheetModal.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\bÍ\u0001Î\u0001Ï\u0001Ð\u0001B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\n\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0002J\u0007\u0010 \u0001\u001a\u00020\nJ\b\u0010¡\u0001\u001a\u00030\u009f\u0001J\u0017\u0010¢\u0001\u001a\u00030\u009f\u00012\u000b\b\u0002\u0010£\u0001\u001a\u0004\u0018\u00010\u007fH\u0002J\u000b\u0010¤\u0001\u001a\u0004\u0018\u00010\u007fH\u0002J$\u0010¥\u0001\u001a\u0003H¦\u0001\"\t\b\u0000\u0010¦\u0001*\u0002002\u0007\u0010§\u0001\u001a\u00020\bH\u0016¢\u0006\u0003\u0010¨\u0001J\n\u0010©\u0001\u001a\u00030\u009f\u0001H\u0002J\t\u0010ª\u0001\u001a\u00020\nH\u0016J\n\u0010«\u0001\u001a\u00030\u009f\u0001H\u0014J\u0007\u0010¬\u0001\u001a\u00020\nJ\n\u0010\u00ad\u0001\u001a\u00030\u009f\u0001H\u0014J\n\u0010®\u0001\u001a\u00030\u009f\u0001H\u0016J\n\u0010¯\u0001\u001a\u00030\u009f\u0001H\u0016J\n\u0010°\u0001\u001a\u00030\u009f\u0001H\u0016J\n\u0010±\u0001\u001a\u00030\u009f\u0001H\u0016J\n\u0010²\u0001\u001a\u00030\u009f\u0001H\u0016J\n\u0010³\u0001\u001a\u00030\u009f\u0001H\u0002J\n\u0010´\u0001\u001a\u00030\u009f\u0001H\u0002J\u0011\u0010µ\u0001\u001a\u00030\u009f\u00012\u0007\u0010¶\u0001\u001a\u00020\nJ\u0011\u0010·\u0001\u001a\u00030\u009f\u00012\u0007\u0010¸\u0001\u001a\u00020\nJ\u0013\u0010¹\u0001\u001a\u00030\u009f\u00012\t\u0010º\u0001\u001a\u0004\u0018\u00010#J\u0013\u0010»\u0001\u001a\u00030\u009f\u00012\t\u0010º\u0001\u001a\u0004\u0018\u00010.J\u0013\u0010¼\u0001\u001a\u00030\u009f\u00012\t\u0010º\u0001\u001a\u0004\u0018\u000109J\u0014\u0010½\u0001\u001a\u00030\u009f\u00012\n\u0010º\u0001\u001a\u0005\u0018\u00010\u008e\u0001J\u0013\u0010¾\u0001\u001a\u00030\u009f\u00012\u0007\u0010¿\u0001\u001a\u00020\nH\u0016J\u0011\u0010À\u0001\u001a\u00030\u009f\u00012\u0007\u0010Á\u0001\u001a\u00020\nJ\u0011\u0010Â\u0001\u001a\u00030\u009f\u00012\u0007\u0010Ã\u0001\u001a\u00020\nJ\u0019\u0010Ä\u0001\u001a\u00030\u009f\u00012\t\u0010Å\u0001\u001a\u0004\u0018\u00010\n¢\u0006\u0003\u0010\u0096\u0001J\u0012\u0010Æ\u0001\u001a\u00030\u009f\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010Ç\u0001\u001a\u00030\u009f\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010È\u0001\u001a\u00030\u009f\u0001J\u0013\u0010È\u0001\u001a\u00030\u009f\u00012\t\u0010£\u0001\u001a\u0004\u0018\u00010\u007fJ\n\u0010É\u0001\u001a\u00030\u009f\u0001H\u0016J\t\u0010Ê\u0001\u001a\u00020\nH\u0016J\f\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0016R\u001a\u0010\r\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0001X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\u001f\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000200X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000200X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010\u0011R\u001a\u0010=\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u000f\"\u0004\b?\u0010\u0011R\u001a\u0010@\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000f\"\u0004\bB\u0010\u0011R\u001a\u0010C\u001a\u00020\u0001X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0019\"\u0004\bE\u0010\u001bR\u001a\u0010F\u001a\u00020GX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020\u0001X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0019\"\u0004\bN\u0010\u001bR\u001a\u0010O\u001a\u00020PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000f\"\u0004\bW\u0010\u0011R\u001a\u0010X\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u000f\"\u0004\bY\u0010\u0011R\u001a\u0010Z\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u000f\"\u0004\b\\\u0010\u0011R\u001a\u0010]\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u000f\"\u0004\b_\u0010\u0011R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010cR\u0012\u0010d\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010cR\u0012\u0010e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010cR\u0010\u0010f\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010i\u001a\u00020jX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020pX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020pX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010r\"\u0004\bw\u0010tR\u001c\u0010x\u001a\u0004\u0018\u00010yX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001e\u0010~\u001a\u00020\u007fX\u0096.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u0084\u0001\u001a\u00030\u0085\u0001X\u0096.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0017\u0010\u008a\u0001\u001a\u00020\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0012\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u008f\u0001\u001a\u00020\nX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u000f\"\u0005\b\u0091\u0001\u0010\u0011R$\u0010\u0092\u0001\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u0015\n\u0003\u0010\u0097\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001d\u0010\u0098\u0001\u001a\u00020\bX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010\u0014\"\u0005\b\u009a\u0001\u0010\u0016R\u001d\u0010\u009b\u0001\u001a\u00020\bX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010\u0014\"\u0005\b\u009d\u0001\u0010\u0016¨\u0006Ñ\u0001"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/sheet/v2/OSheetBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "contentOverlay", "", "userEnableMaterial", "(Landroid/content/Context;Landroid/util/AttributeSet;IZZ)V", "autoAddBodyPaddingTopWhenOverlay", "getAutoAddBodyPaddingTopWhenOverlay", "()Z", "setAutoAddBodyPaddingTopWhenOverlay", "(Z)V", "bgColor", "getBgColor", "()I", "setBgColor", "(I)V", "bodyContainer", "getBodyContainer", "()Landroid/widget/FrameLayout;", "setBodyContainer", "(Landroid/widget/FrameLayout;)V", "bodyContentPaddingBottom", "getBodyContentPaddingBottom", "setBodyContentPaddingBottom", "bodyContentPaddingTop", "getBodyContentPaddingTop", "setBodyContentPaddingTop", "cancelListener", "Lcom/obric/oui/sheet/v2/OSheetModal$OnCancelListener;", "configurationCallback", "Landroid/content/ComponentCallbacks;", "getConfigurationCallback", "()Landroid/content/ComponentCallbacks;", "setConfigurationCallback", "(Landroid/content/ComponentCallbacks;)V", "configurationCallbackRegistered", "getConfigurationCallbackRegistered", "setConfigurationCallbackRegistered", "configurationListener", "Lcom/obric/oui/sheet/v2/OSheetModal$OnConfigurationListener;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "dimView", "getDimView", "setDimView", "dismissAnimListener", "Lcom/obric/oui/sheet/v2/OSheetModal$OnDismissAnimListener;", "enableDimAnim", "getEnableDimAnim", "setEnableDimAnim", "enableEnterAnim", "getEnableEnterAnim", "setEnableEnterAnim", "enableMaterial", "getEnableMaterial", "setEnableMaterial", "footerContainer", "getFooterContainer", "setFooterContainer", "fullWindowSize", "Landroid/util/Size;", "getFullWindowSize", "()Landroid/util/Size;", "setFullWindowSize", "(Landroid/util/Size;)V", "headerContainer", "getHeaderContainer", "setHeaderContainer", "heightStyle", "Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "getHeightStyle", "()Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "setHeightStyle", "(Lcom/obric/oui/sheet/v2/OSheet$HeightMode;)V", "ignoreInsetBottom", "getIgnoreInsetBottom", "setIgnoreInsetBottom", "isContentOverlayMode", "setContentOverlayMode", "mCancelable", "getMCancelable", "setMCancelable", "mClearDimFlag", "getMClearDimFlag", "setMClearDimFlag", "myWindowCallback", "Landroid/view/Window$Callback;", "originalNavigationBarAppearance", "Ljava/lang/Integer;", "originalStatusBarAppearance", "originalSystemUiVisibility", "originalWindowCallback", "passThroughTouchOutside", "removeOnDismiss", "rootContainer", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "setRootContainer", "(Lcom/obric/oui/dialog/alert/view/RadiusLayout;)V", "rootTransMoveStartX", "", "getRootTransMoveStartX", "()F", "setRootTransMoveStartX", "(F)V", "rootTransMoveStartY", "getRootTransMoveStartY", "setRootTransMoveStartY", "runningAnim", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "getRunningAnim", "()Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "setRunningAnim", "(Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;)V", "scaffoldContainer", "Landroid/view/ViewGroup;", "getScaffoldContainer", "()Landroid/view/ViewGroup;", "setScaffoldContainer", "(Landroid/view/ViewGroup;)V", "scaffoldController", "Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "getScaffoldController", "()Lcom/obric/oui/sheet/v2/OSheetScaffoldController;", "setScaffoldController", "(Lcom/obric/oui/sheet/v2/OSheetScaffoldController;)V", "sheetContext", "getSheetContext", "()Landroid/content/Context;", "showAnimListener", "Lcom/obric/oui/sheet/v2/OSheetModal$OnShowAnimListener;", "showing", "getShowing", "setShowing", "systemInsetsAppearanceLightValue", "getSystemInsetsAppearanceLightValue", "()Ljava/lang/Boolean;", "setSystemInsetsAppearanceLightValue", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "userWindowHeight", "getUserWindowHeight", "setUserWindowHeight", "userWindowWidth", "getUserWindowWidth", "setUserWindowWidth", "applySystemInsetsAppearance", "", "cancel", "dismiss", "ensureAttachedToParent", "parent", "findDecorViewParent", "getViewById", ExifInterface.GPS_DIRECTION_TRUE, "id", "(I)Landroid/view/View;", "interceptBackPressed", "needDimAnim", "onAttachedToWindow", "onBackPressed", "onDetachedFromWindow", "onDismissAnimEnd", "onDismissAnimStart", "onDismissComplete", "onShowAnimEnd", "onShowAnimStart", "restoreSystemInsetsAppearance", "restoreWindowCallback", "setCancelable", "cancelable", "setClearDimFlag", "dim", "setOnCancelListener", "listener", "setOnConfigurationListener", "setOnDismissAnimListener", "setOnShowAnimListener", "setOverlayModeAutoBodyPaddingTopEnabled", "enable", "setPassThroughTouchOutside", "passThrough", "setRemoveOnDismiss", "remove", "setSystemInsetsAppearanceLight", "appearanceLight", "setupDimView", "setupView", "show", "updateMaterial", "useWindowDim", "windowForAnim", "Landroid/view/Window;", "OnCancelListener", "OnConfigurationListener", "OnDismissAnimListener", "OnShowAnimListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSheetModal extends FrameLayout implements OSheetBase {
    private boolean autoAddBodyPaddingTopWhenOverlay;
    private int bgColor;
    public FrameLayout bodyContainer;
    private int bodyContentPaddingBottom;
    private int bodyContentPaddingTop;
    private OnCancelListener cancelListener;
    private ComponentCallbacks configurationCallback;
    private boolean configurationCallbackRegistered;
    private OnConfigurationListener configurationListener;
    public View contentView;
    public View dimView;
    private OnDismissAnimListener dismissAnimListener;
    private boolean enableDimAnim;
    private boolean enableEnterAnim;
    private boolean enableMaterial;
    public FrameLayout footerContainer;
    private Size fullWindowSize;
    public FrameLayout headerContainer;
    private OSheet.HeightMode heightStyle;
    private boolean ignoreInsetBottom;
    private boolean isContentOverlayMode;
    private boolean mCancelable;
    private boolean mClearDimFlag;
    private Window.Callback myWindowCallback;
    private Integer originalNavigationBarAppearance;
    private Integer originalStatusBarAppearance;
    private Integer originalSystemUiVisibility;
    private Window.Callback originalWindowCallback;
    private boolean passThroughTouchOutside;
    private boolean removeOnDismiss;
    public RadiusLayout rootContainer;
    private float rootTransMoveStartX;
    private float rootTransMoveStartY;
    private AnimationManager runningAnim;
    public ViewGroup scaffoldContainer;
    public OSheetScaffoldController scaffoldController;
    private OnShowAnimListener showAnimListener;
    private boolean showing;
    private Boolean systemInsetsAppearanceLightValue;
    private int userWindowHeight;
    private int userWindowWidth;

    /* JADX INFO: compiled from: OSheetModal.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal$OnCancelListener;", "", "onCancel", "", "view", "Lcom/obric/oui/sheet/v2/OSheetModal;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCancelListener {
        void onCancel(OSheetModal r1);
    }

    /* JADX INFO: compiled from: OSheetModal.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal$OnConfigurationListener;", "", "onConfigurationChanged", "", "view", "Lcom/obric/oui/sheet/v2/OSheetModal;", "configuration", "Landroid/content/res/Configuration;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnConfigurationListener {
        void onConfigurationChanged(OSheetModal r1, Configuration r2);
    }

    /* JADX INFO: compiled from: OSheetModal.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal$OnDismissAnimListener;", "", "onDismissAnimEnd", "", "view", "Lcom/obric/oui/sheet/v2/OSheetModal;", "onDismissAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDismissAnimListener {
        void onDismissAnimEnd(OSheetModal r1);

        void onDismissAnimStart(OSheetModal r1);
    }

    /* JADX INFO: compiled from: OSheetModal.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetModal$OnShowAnimListener;", "", "onShowAnimEnd", "", "view", "Lcom/obric/oui/sheet/v2/OSheetModal;", "onShowAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnShowAnimListener {
        void onShowAnimEnd(OSheetModal r1);

        void onShowAnimStart(OSheetModal r1);
    }

    public static /* synthetic */ void $r8$lambda$K0aaz_pMmkAcUSSHFT9bZXgsKrE(OSheetModal r0) {
        m697show$lambda2(r0);
    }

    public static /* synthetic */ void $r8$lambda$mg_jy21wVoJ9ExL6GtPywsJnqv4(OSheetModal r0, View r1) {
        m696show$lambda1(r0, r1);
    }

    public OSheetModal(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, null, 0, false, false, 30, null);
    }

    public OSheetModal(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 0, false, false, 28, null);
    }

    public OSheetModal(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, false, false, 24, null);
    }

    public OSheetModal(Context r10, AttributeSet r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, r13, false, 16, null);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean useWindowDim() {
        return false;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Window windowForAnim() {
        return null;
    }

    public /* synthetic */ OSheetModal(Context r7, AttributeSet r8, int r9, boolean r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = null;
    L5:
        AttributeSet r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        int r3 = 0;
    L10:
        if ((r12 & 8) == 0) goto L12;
        boolean r4 = false;
    L14:
        if ((r12 & 16) == 0) goto L16;
        r11 = true;
    L16:
        this(r7, r2, r3, r4, r11);
        return;
    L12:
        r4 = r10;
        goto L14
    L8:
        r3 = r9;
        goto L10
    }

    public static final /* synthetic */ OnConfigurationListener access$getConfigurationListener$p(OSheetModal r0) {
        return r0.configurationListener;
    }

    public static final /* synthetic */ Window.Callback access$getOriginalWindowCallback$p(OSheetModal r0) {
        return r0.originalWindowCallback;
    }

    public static final /* synthetic */ void access$restoreWindowCallback(OSheetModal r0) {
        r0.restoreWindowCallback();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void applyMaterial(boolean r1) {
        OSheetBase.DefaultImpls.applyMaterial(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void calculateBodyMaxHeight() {
        OSheetBase.DefaultImpls.calculateBodyMaxHeight(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void enableIgnoreInsetBottom(boolean r1) {
        OSheetBase.DefaultImpls.enableIgnoreInsetBottom(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase, com.obric.oui.sheet.v2.SheetMoveDelegate
    public void fling(float r1, float r2) {
        OSheetBase.DefaultImpls.fling(this, r1, r2);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getContentLayoutResId() {
        return OSheetBase.DefaultImpls.getContentLayoutResId(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getEndActionButton() {
        return OSheetBase.DefaultImpls.getEndActionButton(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getMaxBodyHeight() {
        return OSheetBase.DefaultImpls.getMaxBodyHeight(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getNegativeButton() {
        return OSheetBase.DefaultImpls.getNegativeButton(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getPositiveButton() {
        return OSheetBase.DefaultImpls.getPositiveButton(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getStartActionButton() {
        return OSheetBase.DefaultImpls.getStartActionButton(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void initBgColor() {
        OSheetBase.DefaultImpls.initBgColor(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean isDarkTheme() {
        return OSheetBase.DefaultImpls.isDarkTheme(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean isRootContainerMaxHeight() {
        return OSheetBase.DefaultImpls.isRootContainerMaxHeight(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase, com.obric.oui.sheet.v2.SheetMoveDelegate
    public void move(float r1, float r2, boolean r3) {
        OSheetBase.DefaultImpls.move(this, r1, r2, r3);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onPostShow() {
        OSheetBase.DefaultImpls.onPostShow(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void performEnterAnimation() {
        OSheetBase.DefaultImpls.performEnterAnimation(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void performExitAnimation(float r1) {
        OSheetBase.DefaultImpls.performExitAnimation(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void registerConfigurationCallbackIfNeeded() {
        OSheetBase.DefaultImpls.registerConfigurationCallbackIfNeeded(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void removeOnApplyWindowInsetsListener() {
        OSheetBase.DefaultImpls.removeOnApplyWindowInsetsListener(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyView(View r1) {
        OSheetBase.DefaultImpls.setBodyView(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setCanceledOnTouchOutside(boolean r1) {
        OSheetBase.DefaultImpls.setCanceledOnTouchOutside(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterButton(Integer r8, boolean r9, View.OnClickListener r10, Integer r11, boolean r12, View.OnClickListener r13) {
        OSheetBase.DefaultImpls.setFooterButton(this, r8, r9, r10, r11, r12, r13);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterButton(String r8, boolean r9, View.OnClickListener r10, String r11, boolean r12, View.OnClickListener r13) {
        OSheetBase.DefaultImpls.setFooterButton(this, r8, r9, r10, r11, r12, r13);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterView(View r1) {
        OSheetBase.DefaultImpls.setFooterView(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeader(OSheet.Header r16, Integer r17, Integer r18, String r19, String r20, boolean r21, View.OnClickListener r22, View.OnClickListener r23, Integer r24, Integer r25, String r26, String r27, Integer r28, Integer r29) {
        OSheetBase.DefaultImpls.setHeader(this, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeaderView(View r1) {
        OSheetBase.DefaultImpls.setHeaderView(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeightMode(OSheet.HeightMode r1) {
        OSheetBase.DefaultImpls.setHeightMode(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setOnApplyWindowInsetsListener() {
        OSheetBase.DefaultImpls.setOnApplyWindowInsetsListener(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setSheetBgColor(int r1) {
        OSheetBase.DefaultImpls.setSheetBgColor(this, r1);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void unregisterConfigurationCallbackIfNeeded() {
        OSheetBase.DefaultImpls.unregisterConfigurationCallbackIfNeeded(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void updateFullWindowSize() {
        OSheetBase.DefaultImpls.updateFullWindowSize(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSheetModal(Context r2, AttributeSet r3, int r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        boolean r7 = true;
        this.enableDimAnim = true;
        this.enableEnterAnim = true;
        this.heightStyle = OSheet.HeightMode.WRAP_HEIGHT;
        this.isContentOverlayMode = r5;
        this.mCancelable = true;
        this.fullWindowSize = new Size(0, 0);
        this.removeOnDismiss = true;
        this.configurationCallback = new OSheetModal$configurationCallback$1(this);
        this.autoAddBodyPaddingTopWhenOverlay = true;
        this.bgColor = -1;
        if (r6 == true) goto L5;
    L11:
        setVisibility(8);
        View r8 = LayoutInflater.from(r2).inflate(getContentLayoutResId(), this, false);
        Intrinsics.checkNotNullExpressionValue(r8, "from(context)\n          …youtResId(), this, false)");
        setContentView(r8);
        View r9 = getContentView();
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-1, -2);
        r10.gravity = 80;
        Unit r11 = Unit.INSTANCE;
        addView(r9, r10);
        setupView(r2);
        if ((r2 instanceof LifecycleOwner) == false) goto L14;
        LifecycleOwner r12 = (LifecycleOwner) r2;
    L15:
        if (r12 == null) goto L22;
        Lifecycle r13 = r12.getLifecycle();
        if (r13 == null) goto L23;
        r13.addObserver(new AnonymousClass2(this));
        return;
    L23:
        return;
    L22:
        return;
    L14:
        r12 = null;
        goto L15
    L5:
        if (OMaterialExtBaseKt.isMaterialEffectEnabled(r2) == true) goto L7;
    L9:
        r7 = false;
    L10:
        setEnableMaterial(r7);
        goto L11
    L7:
        if (OMaterialHelper.isWidgetMaterialEffectEnabled() == false) goto L9;
        goto L9
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Context getSheetContext() {
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        return r1;
    }

    public final View getContentView() {
        View r0 = this.contentView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    public final void setContentView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contentView = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public ViewGroup getScaffoldContainer() {
        ViewGroup r0 = this.scaffoldContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setScaffoldContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scaffoldContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public View getDimView() {
        View r0 = this.dimView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dimView");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setDimView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dimView = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public RadiusLayout getRootContainer() {
        RadiusLayout r0 = this.rootContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootContainer(RadiusLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rootContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public FrameLayout getHeaderContainer() {
        FrameLayout r0 = this.headerContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeaderContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.headerContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public FrameLayout getFooterContainer() {
        FrameLayout r0 = this.footerContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFooterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.footerContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public FrameLayout getBodyContainer() {
        FrameLayout r0 = this.bodyContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bodyContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.bodyContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getMClearDimFlag() {
        return this.mClearDimFlag;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setMClearDimFlag(boolean r1) {
        this.mClearDimFlag = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getEnableDimAnim() {
        return this.enableDimAnim;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setEnableDimAnim(boolean r1) {
        this.enableDimAnim = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getEnableEnterAnim() {
        return this.enableEnterAnim;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setEnableEnterAnim(boolean r1) {
        this.enableEnterAnim = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public OSheetScaffoldController getScaffoldController() {
        OSheetScaffoldController r0 = this.scaffoldController;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldController");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setScaffoldController(OSheetScaffoldController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scaffoldController = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public OSheet.HeightMode getHeightStyle() {
        return this.heightStyle;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setHeightStyle(OSheet.HeightMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.heightStyle = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean isContentOverlayMode() {
        return this.isContentOverlayMode;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setContentOverlayMode(boolean r1) {
        this.isContentOverlayMode = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getIgnoreInsetBottom() {
        return this.ignoreInsetBottom;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setIgnoreInsetBottom(boolean r1) {
        this.ignoreInsetBottom = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getMCancelable() {
        return this.mCancelable;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setMCancelable(boolean r1) {
        this.mCancelable = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getUserWindowWidth() {
        return this.userWindowWidth;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setUserWindowWidth(int r1) {
        this.userWindowWidth = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getUserWindowHeight() {
        return this.userWindowHeight;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setUserWindowHeight(int r1) {
        this.userWindowHeight = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Size getFullWindowSize() {
        return this.fullWindowSize;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setFullWindowSize(Size r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fullWindowSize = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public AnimationManager getRunningAnim() {
        return this.runningAnim;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRunningAnim(AnimationManager r1) {
        this.runningAnim = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getShowing() {
        return this.showing;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setShowing(boolean r1) {
        this.showing = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getEnableMaterial() {
        return this.enableMaterial;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setEnableMaterial(boolean r1) {
        this.enableMaterial = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public Boolean getSystemInsetsAppearanceLightValue() {
        return this.systemInsetsAppearanceLightValue;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setSystemInsetsAppearanceLightValue(Boolean r1) {
        this.systemInsetsAppearanceLightValue = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getConfigurationCallbackRegistered() {
        return this.configurationCallbackRegistered;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setConfigurationCallbackRegistered(boolean r1) {
        this.configurationCallbackRegistered = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public ComponentCallbacks getConfigurationCallback() {
        return this.configurationCallback;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setConfigurationCallback(ComponentCallbacks r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.configurationCallback = r2;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBodyContentPaddingTop() {
        return this.bodyContentPaddingTop;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContentPaddingTop(int r1) {
        this.bodyContentPaddingTop = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBodyContentPaddingBottom() {
        return this.bodyContentPaddingBottom;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBodyContentPaddingBottom(int r1) {
        this.bodyContentPaddingBottom = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public boolean getAutoAddBodyPaddingTopWhenOverlay() {
        return this.autoAddBodyPaddingTopWhenOverlay;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setAutoAddBodyPaddingTopWhenOverlay(boolean r1) {
        this.autoAddBodyPaddingTopWhenOverlay = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public float getRootTransMoveStartX() {
        return this.rootTransMoveStartX;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootTransMoveStartX(float r1) {
        this.rootTransMoveStartX = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public float getRootTransMoveStartY() {
        return this.rootTransMoveStartY;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setRootTransMoveStartY(float r1) {
        this.rootTransMoveStartY = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public int getBgColor() {
        return this.bgColor;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setBgColor(int r1) {
        this.bgColor = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public <T extends View> T getViewById(int r1) {
        T r0 = (T) getContentView().findViewById(r1);
        Intrinsics.checkNotNullExpressionValue(r0, "contentView.findViewById(id)");
        return r0;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setupView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        OSheetBase.DefaultImpls.setupView(this, r2);
        updateMaterial();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void updateMaterial() {
        applyMaterial(false);
        OMaterialExtBaseKt.setMaterialBackdropTarget(getRootContainer(), this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setupDimView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        setDimView(new View(r3));
        addView(getDimView(), 0, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void setOnShowAnimListener(OnShowAnimListener r1) {
        this.showAnimListener = r1;
    }

    public final void setOnDismissAnimListener(OnDismissAnimListener r1) {
        this.dismissAnimListener = r1;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void setOverlayModeAutoBodyPaddingTopEnabled(boolean r1) {
        OSheetBase.DefaultImpls.setOverlayModeAutoBodyPaddingTopEnabled(this, r1);
    }

    public final void setOnConfigurationListener(OnConfigurationListener r1) {
        this.configurationListener = r1;
    }

    public final void setOnCancelListener(OnCancelListener r1) {
        this.cancelListener = r1;
    }

    public final void setSystemInsetsAppearanceLight(Boolean r1) {
        setSystemInsetsAppearanceLightValue(r1);
    }

    public final void setRemoveOnDismiss(boolean r1) {
        this.removeOnDismiss = r1;
    }

    public final void setCancelable(boolean r1) {
        setMCancelable(r1);
    }

    public final void setPassThroughTouchOutside(boolean r1) {
        this.passThroughTouchOutside = r1;
    }

    public final void setClearDimFlag(boolean r1) {
        setMClearDimFlag(r1);
    }

    public final void show() {
        show(null);
    }

    public final void show(ViewGroup r4) {
        if (this.passThroughTouchOutside == false) goto L6;
        getDimView().setOnClickListener(null);
    L10:
        if (getShowing() == true) goto L18;
        ensureAttachedToParent(r4);
        setOnApplyWindowInsetsListener();
        getDimView().setAlpha(0.0f);
        if (getMClearDimFlag() == false) goto L14;
    L17:
        ViewExtensionsKt.makeGone(getDimView());
    L20:
        if (getEnableDimAnim() == false) goto L24;
        if (getEnableEnterAnim() == false) goto L24;
    L27:
        if ((getParent() instanceof ViewGroup) == false) goto L33;
        ViewParent r5 = getParent();
        if (r5 == null) goto L32;
        ((ViewGroup) r5).requestApplyInsets();
        goto L33
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L33:
        applySystemInsetsAppearance();
        if (getShowing() == true) goto L37;
        setShowing(true);
        setVisibility(0);
        setAlpha(0.0f);
        post(new OSheetModal$$ExternalSyntheticLambda1(this));
        interceptBackPressed();
        return;
    L37:
        return;
    L24:
        if (getMClearDimFlag() == true) goto L27;
        View r6 = getDimView();
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        r6.setAlpha(OSheetBaseKt.getTargetDimAmount(r0));
        goto L27
    L14:
        if (this.passThroughTouchOutside == true) goto L17;
        ViewExtensionsKt.makeVisible(getDimView());
        goto L20
    L18:
        updateFullWindowSize();
        getScaffoldController().refreshForConfiguration(getFullWindowSize());
        goto L20
    L6:
        if (getMCancelable() == false) goto L8;
        getDimView().setOnClickListener(new OSheetModal$$ExternalSyntheticLambda0(this));
        goto L10
    L8:
        getDimView().setOnClickListener(null);
        goto L10
    }

    /* JADX INFO: renamed from: show$lambda-1, reason: not valid java name */
    private static final void m696show$lambda1(OSheetModal r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.cancel();
    }

    /* JADX INFO: renamed from: show$lambda-2, reason: not valid java name */
    private static final void m697show$lambda2(OSheetModal r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.setAlpha(1.0f);
        r1.onPostShow();
        r1.performEnterAnimation();
    }

    private final void interceptBackPressed() {
        OWindowConfigController r0 = OWindowConfigController.INSTANCE;
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        Activity r2 = r0.getActivity(r1);
        if (r2 == null) goto L10;
        final Window.Callback r3 = r2.getWindow().getCallback();
        if (r3 != null) goto L8;
        return;
    L8:
        this.originalWindowCallback = r3;
        this.myWindowCallback = new OSheetModal$interceptBackPressed$1$1(r3, this);
        r2.getWindow().setCallback(this.myWindowCallback);
        return;
    }

    private final void restoreWindowCallback() {
        OWindowConfigController r0 = OWindowConfigController.INSTANCE;
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        Activity r2 = r0.getActivity(r1);
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.getWindow().getCallback() == this.myWindowCallback) goto L8;
    L10:
        this.originalWindowCallback = null;
        this.myWindowCallback = null;
        return;
    L8:
        if (this.originalWindowCallback == null) goto L10;
        r2.getWindow().setCallback(this.originalWindowCallback);
        goto L10
    }

    public final void dismiss() {
        if (getShowing() == true) goto L5;
        return;
    L5:
        removeOnApplyWindowInsetsListener();
        OSheetBase.DefaultImpls.performExitAnimation$default(this, 0.0f, 1, null);
    }

    public final boolean cancel() {
        if (getShowing() == true) goto L5;
        return false;
    L5:
        if (getMCancelable() == false) goto L15;
        OnCancelListener r0 = this.cancelListener;
        if (r0 == null) goto L11;
        r0.onCancel(this);
    L11:
        dismiss();
        return true;
    L15:
        return false;
    }

    public final boolean onBackPressed() {
        if (getShowing() == true) goto L5;
        return false;
    L5:
        if (getMCancelable() == false) goto L10;
        cancel();
        return true;
    L10:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerConfigurationCallbackIfNeeded();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        unregisterConfigurationCallbackIfNeeded();
        super.onDetachedFromWindow();
        restoreWindowCallback();
    }

    private final void applySystemInsetsAppearance() {
        Context r0 = getContext();
        Integer r2 = null;
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r1 = (Activity) r0;
    L6:
        if (r1 != null) goto L8;
        Window r3 = null;
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        Boolean r4 = getSystemInsetsAppearanceLightValue();
        int r5 = 0;
        if (r4 == null) goto L14;
        boolean r6 = r4.booleanValue();
    L19:
        if (this.originalStatusBarAppearance != null) goto L26;
        WindowInsetsController r7 = r3.getInsetsController();
        if (r7 != null) goto L23;
        Integer r8 = null;
    L24:
        this.originalStatusBarAppearance = r8;
        goto L26
    L23:
        r8 = Integer.valueOf(r7.getSystemBarsAppearance() & 8);
    L26:
        if (this.originalNavigationBarAppearance != null) goto L32;
        WindowInsetsController r9 = r3.getInsetsController();
        if (r9 == null) goto L31;
        r2 = Integer.valueOf(r9.getSystemBarsAppearance() & 16);
    L31:
        this.originalNavigationBarAppearance = r2;
    L32:
        WindowInsetsController r10 = r3.getInsetsController();
        if (r10 == null) goto L39;
        if (r6 == false) goto L37;
        int r11 = 8;
    L38:
        r10.setSystemBarsAppearance(r11, 8);
        goto L39
    L37:
        r11 = 0;
    L39:
        WindowInsetsController r12 = r3.getInsetsController();
        if (r12 == null) goto L46;
        if (r6 == false) goto L44;
        r5 = 16;
    L44:
        r12.setSystemBarsAppearance(r5, 16);
        return;
    L46:
        return;
    L14:
        if ((getContext().getResources().getConfiguration().uiMode & 48) == 32) goto L16;
        r6 = true;
        goto L19
    L16:
        r6 = false;
        goto L19
    L8:
        r3 = r1.getWindow();
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    static /* synthetic */ void ensureAttachedToParent$default(OSheetModal r0, ViewGroup r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.ensureAttachedToParent(r1);
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
        r3.addView(this, new ViewGroup.LayoutParams(-1, -1));
    }

    private final ViewGroup findDecorViewParent() {
        Context r0 = getContext();
    L4:
        if ((r0 instanceof ContextWrapper) == false) goto L16;
        if ((r0 instanceof Activity) == true) goto L7;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L4
    L7:
        Window r3 = ((Activity) r0).getWindow();
        if (r3 != null) goto L10;
        View r4 = null;
    L12:
        if ((r4 instanceof ViewGroup) == true) goto L14;
        return null;
    L14:
        return (ViewGroup) r4;
    L10:
        r4 = r3.getDecorView();
        goto L12
    L16:
        Context r5 = getContext();
        if ((r5 instanceof Activity) == false) goto L19;
        Activity r6 = (Activity) r5;
    L20:
        if (r6 != null) goto L22;
    L21:
        View r7 = null;
    L27:
        if ((r7 instanceof ViewGroup) == true) goto L29;
        return null;
    L29:
        return (ViewGroup) r7;
    L22:
        Window r8 = r6.getWindow();
        if (r8 == null) goto L21;
        r7 = r8.getDecorView();
        goto L27
    L19:
        r6 = null;
        goto L20
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

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onShowAnimStart() {
        OnShowAnimListener r0 = this.showAnimListener;
        if (r0 == null) goto L7;
        r0.onShowAnimStart(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onShowAnimEnd() {
        OnShowAnimListener r0 = this.showAnimListener;
        if (r0 == null) goto L7;
        r0.onShowAnimEnd(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onDismissAnimStart() {
        OnDismissAnimListener r0 = this.dismissAnimListener;
        if (r0 == null) goto L7;
        r0.onDismissAnimStart(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onDismissAnimEnd() {
        OnDismissAnimListener r0 = this.dismissAnimListener;
        if (r0 == null) goto L7;
        r0.onDismissAnimEnd(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public void onDismissComplete() {
        setShowing(false);
        setVisibility(8);
        restoreSystemInsetsAppearance();
        restoreWindowCallback();
        if (this.removeOnDismiss == false) goto L12;
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewGroup) == false) goto L7;
        ViewGroup r1 = (ViewGroup) r0;
    L8:
        if (r1 == null) goto L13;
        r1.removeView(this);
        return;
    L13:
        return;
    L7:
        r1 = null;
        goto L8
    }

    private final void restoreSystemInsetsAppearance() {
        Context r0 = getContext();
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r1 = (Activity) r0;
    L6:
        if (r1 != null) goto L8;
        Window r2 = null;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        Integer r3 = this.originalStatusBarAppearance;
        if (r3 == null) goto L18;
        int r4 = r3.intValue();
        WindowInsetsController r5 = r2.getInsetsController();
        if (r5 == null) goto L18;
        r5.setSystemBarsAppearance(r4, 8);
    L18:
        Integer r6 = this.originalNavigationBarAppearance;
        if (r6 == null) goto L25;
        int r7 = r6.intValue();
        WindowInsetsController r8 = r2.getInsetsController();
        if (r8 == null) goto L25;
        r8.setSystemBarsAppearance(r7, 16);
    L25:
        this.originalStatusBarAppearance = null;
        this.originalNavigationBarAppearance = null;
        return;
    L8:
        r2 = r1.getWindow();
        goto L9
    L5:
        r1 = null;
        goto L6
    }
}
