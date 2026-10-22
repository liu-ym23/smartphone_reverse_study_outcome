package com.bytedance.ai.view.popup;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.api.model.view.AIFragmentBase;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.view.popup.anim.AnimController;
import com.bytedance.ai.view.popup.anim.AnimationStyle;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import com.bytedance.ai.view.popup.viewmodel.AppletPopupViewModel;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k2.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ¿\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004¾\u0001¿\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010U\u001a\u0004\u0018\u00010\u00112\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\b\u0010^\u001a\u00020_H\u0002J\u001c\u0010`\u001a\u0002042\b\u0010a\u001a\u0004\u0018\u00010\u00112\b\u0010b\u001a\u0004\u0018\u000104H\u0002J&\u0010c\u001a\u00020_2\b\b\u0002\u0010d\u001a\u00020*2\b\b\u0002\u0010e\u001a\u00020*2\b\b\u0002\u0010f\u001a\u00020\bH\u0002J\u000e\u0010g\u001a\u00020_2\u0006\u0010h\u001a\u00020\bJ\u000e\u0010i\u001a\u00020_2\u0006\u0010h\u001a\u00020\bJ\u000e\u0010j\u001a\u00020_2\u0006\u0010k\u001a\u00020*J\u000e\u0010l\u001a\u00020_2\u0006\u0010m\u001a\u00020*J\u0010\u0010n\u001a\u00020\u001d2\u0006\u0010o\u001a\u00020pH\u0002J\u001a\u0010q\u001a\u00020_2\u0006\u0010r\u001a\u00020\u00112\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\n\u0010s\u001a\u0004\u0018\u00010tH\u0002J\u0010\u0010u\u001a\u00020_2\u0006\u0010v\u001a\u00020-H\u0002J\b\u0010w\u001a\u00020_H\u0002J\u0006\u0010x\u001a\u00020*J\b\u0010y\u001a\u00020\bH\u0002J\u000e\u0010|\u001a\u00020_2\u0006\u0010v\u001a\u00020{J\u0012\u0010}\u001a\u00020_2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u0012\u0010~\u001a\u00020\u007f2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u0012\u0010\u0080\u0001\u001a\u00020_2\u0007\u0010\u0081\u0001\u001a\u00020[H\u0016J\u0014\u0010\u0082\u0001\u001a\u00020_2\t\b\u0002\u0010\u0083\u0001\u001a\u00020*H\u0002J\t\u0010\u0084\u0001\u001a\u00020*H\u0002J\t\u0010\u0085\u0001\u001a\u00020_H\u0016J\t\u0010\u0086\u0001\u001a\u00020_H\u0016J\t\u0010\u0087\u0001\u001a\u00020_H\u0016J\t\u0010\u0088\u0001\u001a\u00020_H\u0016J\u0013\u0010\u0089\u0001\u001a\u00020_2\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0016J\t\u0010\u008c\u0001\u001a\u00020_H\u0016J\u0012\u0010\u008d\u0001\u001a\u00020_2\u0007\u0010\u008e\u0001\u001a\u00020*H\u0016J\u0012\u0010\u008f\u0001\u001a\u00020_2\u0007\u0010\u0090\u0001\u001a\u00020*H\u0016J\u0011\u0010\u0091\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0011H\u0016J\u0011\u0010\u0092\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0011H\u0016J\t\u0010\u0093\u0001\u001a\u00020_H\u0016J\u0007\u0010\u0094\u0001\u001a\u00020_J\t\u0010\u0095\u0001\u001a\u00020_H\u0016J\t\u0010\u0096\u0001\u001a\u00020*H\u0002J\t\u0010\u0097\u0001\u001a\u00020_H\u0016J\u001b\u0010\u0098\u0001\u001a\u00020_2\u0007\u0010\u0099\u0001\u001a\u00020\b2\u0007\u0010\u009a\u0001\u001a\u00020\bH\u0002J\u001b\u0010\u009b\u0001\u001a\u00020_2\u0007\u0010\u0099\u0001\u001a\u00020\b2\u0007\u0010\u009a\u0001\u001a\u00020\bH\u0002J\t\u0010\u009c\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u009d\u0001\u001a\u00020_2\u0007\u0010\u009a\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u009e\u0001\u001a\u00020_2\u0007\u0010\u009f\u0001\u001a\u00020\bH\u0002J\t\u0010 \u0001\u001a\u00020*H\u0002J\t\u0010¡\u0001\u001a\u00020*H\u0002J\t\u0010¢\u0001\u001a\u00020*H\u0002J\u0007\u0010£\u0001\u001a\u00020*J\u001e\u0010¤\u0001\u001a\u00020_2\b\u0010¥\u0001\u001a\u00030¦\u00012\t\u0010§\u0001\u001a\u0004\u0018\u00010pH\u0002J\u001e\u0010¨\u0001\u001a\u00020_2\b\u0010¥\u0001\u001a\u00030¦\u00012\t\u0010§\u0001\u001a\u0004\u0018\u00010pH\u0016J\t\u0010¨\u0001\u001a\u00020_H\u0016J\t\u0010©\u0001\u001a\u00020_H\u0016J\t\u0010ª\u0001\u001a\u00020_H\u0016J\t\u0010«\u0001\u001a\u0004\u0018\u00010\u001aJ\u001a\u0010¬\u0001\u001a\u00020\b2\u000b\b\u0002\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\b¢\u0006\u0003\u0010®\u0001J\u0007\u0010¯\u0001\u001a\u00020\bJ\u000f\u0010°\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010$J\u0011\u0010±\u0001\u001a\u00020_2\u0006\u00105\u001a\u00020*H\u0002J\u0012\u0010²\u0001\u001a\u00020_2\u0007\u0010³\u0001\u001a\u00020*H\u0002J\u0012\u0010´\u0001\u001a\u00020_2\u0007\u0010µ\u0001\u001a\u00020*H\u0016J\u0014\u0010¶\u0001\u001a\u00020_2\t\b\u0001\u0010·\u0001\u001a\u00020\bH\u0002J\t\u0010¸\u0001\u001a\u0004\u0018\u00010pJ\u0019\u0010¹\u0001\u001a\u00020_*\u00030º\u00012\t\u0010§\u0001\u001a\u0004\u0018\u00010pH\u0002J\t\u0010»\u0001\u001a\u00020OH\u0002J\u0011\u0010¼\u0001\u001a\u00020_2\b\u0010r\u001a\u0004\u0018\u00010\u0011J\u000f\u0010½\u0001\u001a\u00020_2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020\b0BX\u0082\u000e¢\u0006\u0004\n\u0002\u0010CR\u000e\u0010D\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010H\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bJ\u0010KR\u001b\u0010N\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010M\u001a\u0004\bP\u0010QR\u000e\u0010S\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020]X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006À\u0001"}, d2 = {"Lcom/bytedance/ai/view/popup/AppletPopup;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/bytedance/ai/view/IAppletView;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "<init>", "()V", "dp100", "", "popupRoot", "Landroid/widget/FrameLayout;", "popupContainer", "Landroid/widget/LinearLayout;", "popupInnerContainer", "Lcom/bytedance/ai/view/popup/RadiusLayout;", "popupTopViewContainer", "popupBg", "Landroid/view/View;", "popupCoordinator", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parameters", "", "Lcom/bytedance/ai/view/popup/api/IAppletParameter;", "animatorParamHandler", "Lcom/bytedance/ai/view/popup/params/AnimationParameter;", "schemaParam", "Lcom/bytedance/ai/view/popup/params/AppletPopupSchemaParam;", "topView", "appletFragment", "Lcom/bytedance/ai/api/model/view/AIFragmentBase;", "getAppletFragment$annotations", "getAppletFragment", "()Lcom/bytedance/ai/api/model/view/AIFragmentBase;", "setAppletFragment", "(Lcom/bytedance/ai/api/model/view/AIFragmentBase;)V", "behavior", "Lcom/bytedance/ai/view/popup/anim/BottomSheetBehavior;", "animController", "Lcom/bytedance/ai/view/popup/anim/AnimController;", "popupContainerHeightPrevious", "lastHeightState", "viewTreeObserverConsumedFlag", "", "lastAvailableHeight", "onGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "peekHeightPrevious", "keyboardVisible", "lastKeyboardHeight", "isDraggablePrevious", "preloadSparkViewOnFirstScreen", "lastInsets", "Landroidx/core/view/WindowInsetsCompat;", "visible", "parentActivityVisible", "lastContentViewBottom", "hasSetAdapativeFlag", "getHasSetAdapativeFlag$ai_sdk_release", "()Z", "setHasSetAdapativeFlag$ai_sdk_release", "(Z)V", "fixPopupAnimLag", "fixPopupHeight", "decorView", "hasDismissed", GXTemplateKey.FLEXBOX_MARGIN, "", "[Ljava/lang/Integer;", "imeVisible", "type", "Lcom/bytedance/ai/view/popup/RenderType;", "showMask", "viewModel", "Lcom/bytedance/ai/view/popup/viewmodel/AppletPopupViewModel;", "getViewModel", "()Lcom/bytedance/ai/view/popup/viewmodel/AppletPopupViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "defaultAnimatorProvider", "Lcom/bytedance/ai/view/IPopupAnimator;", "getDefaultAnimatorProvider", "()Lcom/bytedance/ai/view/IPopupAnimator;", "defaultAnimatorProvider$delegate", "addLayoutListener", "layoutListener", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onApplyWindowInsetsListener", "Landroidx/core/view/OnApplyWindowInsetsListener;", "registerOnApplyWindowInsetsListener", "", "applyWindowInset", BaseSwitches.V, "insets", "refreshPopupHeight", "requestLayout", "needRefreshPeekHeight", "loadingHeight", "setBehaviorMinMarginTop", "minMarginTop", "setMinMarginTop", "setDraggable", "isDraggable", "setDisableOutsideClickClose", "disableOutsideClickClose", "obtainFragment", "appId", "", "onViewCreated", "view", "getDialogWindow", "Landroid/view/Window;", "registerRootViewGlobalLayoutChangeListerOnce", "listener", "onLayoutChanged", "isImeVisible", "getAvailableHeight", "mLifeCycleListener", "Lcom/bytedance/ai/view/popup/AppletPopup$FragmentLifecycleListener;", "setLifeCycleListener", WidgetCostModule.TYPE_ON_CREATE, "onCreateDialog", "Landroid/app/Dialog;", "onSaveInstanceState", "outState", "popupDismiss", GXTemplateKey.GAIAX_ANIMATION, "popSelfBackStackIfTop", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onDetach", "onHiddenChanged", "hidden", "setUserVisibleHint", "isVisibleToUser", "onViewAttachedToWindow", "onViewDetachedFromWindow", "close", "closeWithoutAnimation", "refresh", "useBottomSheetBehaviorLayout", LiveCommonConstants.REASON_ON_DEDTROY, "onKeyBoardShow", "keyboardHeight", "contentViewBottom", "onKeyBoardHide", "getPopupTopViewHeight", "compatSoftInputMode", "onKeyboardStatusChange", "diffHeight", "needPaddingWhenKeyboardHide", "needPaddingWhenKeyboardShow", "isGravityBottom", "isKeyboardVisible", "showAllowingStateLoss", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "show", "hide", "exitFullScreen", "getSchemaParams", "getCurrentMinMarginTop", "state", "(Ljava/lang/Integer;)I", "getBehaviorState", "getBehavior", "onActivityVisibilityChanged", "checkVisibility", "expected", "onWindowFocusChanged", "hasFocus", "showAppletPage", "containerViewId", "getAppId", "commitNowAllowingStateLossSafely", "Landroidx/fragment/app/FragmentTransaction;", "getPopupAnimator", "setTopView", "init", "FragmentLifecycleListener", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPopup extends AppCompatDialogFragment implements View.OnAttachStateChangeListener, ViewTreeObserver.OnWindowFocusChangeListener {
    public static final int R = 0;
    public boolean A;
    public int B;
    public boolean C;
    public final boolean D;
    public final boolean E;
    public View F;
    public boolean G;
    public Integer[] H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final RenderType f37788J;
    public boolean K;
    public final Lazy L;
    public final Lazy M;
    public boolean N;
    public final j O;
    public final k P;
    public b Q;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f37789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f37790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f37791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RadiusLayout f37792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f37793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f37794i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CoordinatorLayout f37795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<x5.a> f37796k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public y5.b f37797l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AppletPopupSchemaParam f37798m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AIFragmentBase f37799n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public BottomSheetBehavior<LinearLayout> f37800o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AnimController f37801p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f37802q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f37803r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f37804s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f37805t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f37806u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f37807v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f37808w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f37809x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public WindowInsetsCompat f37810y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f37811z;

    public static final class a {
        public a() {
        }

        public static View a(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        public static int b(Window r100, View r101, AppletPopup r102) {
            Intrinsics.checkNotNullParameter(r102, "appletPopup");
            if (r100 == null) goto L7;
            WindowManager.LayoutParams r103 = r100.getAttributes();
            if (r103 == null) goto L7;
            int r104 = r103.softInputMode;
        L8:
            boolean r105 = r102.Y90();
            Context r106 = null;
            if ((r104 & 16) == 16) goto L32;
            if (r105 == false) goto L32;
            Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L29
            if (r100 == null) goto L14;
            View r108 = a(r100);     // Catch: Throwable -> L29
        L16:
            if ((r108 instanceof ViewGroup) == false) goto L18;
            ViewGroup r109 = (ViewGroup) r108;     // Catch: Throwable -> L29
        L19:
            if (r109 == null) goto L24;
            View r110 = r109.getChildAt(0);     // Catch: Throwable -> L29
            if (r110 == null) goto L24;
            int r111 = r110.getMeasuredHeight();     // Catch: Throwable -> L29
        L89:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
        L33:
            if (r111 != 0) goto L95;
            Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L82
            if (r100 == null) goto L38;
            View r113 = a(r100);     // Catch: Throwable -> L82
            if (r113 == null) goto L38;
        L41:
            if (r113 == null) goto L43;
            r113.getFitsSystemWindows();     // Catch: Throwable -> L82
        L43:
            Rect r114 = new Rect();     // Catch: Throwable -> L82
            if (r113 == null) goto L46;
            r113.getWindowVisibleDisplayFrame(r114);     // Catch: Throwable -> L82
        L46:
            int r115 = r114.bottom - r114.top;
            if (r113 != null) goto L87;
        L53:
            boolean r116 = false;
        L54:
            if (r116 == false) goto L64;
            if (r113 == null) goto L58;
            Context r117 = r113.getContext();     // Catch: Throwable -> L78
            if (r117 == null) goto L58;
        L62:
            if (r117 == null) goto L64;
            r115 = r115 + UIUtils.getStatusBarHeight(r117);     // Catch: Throwable -> L78
        L58:
            AppletRuntimeManager.INSTANCE.getClass();     // Catch: Throwable -> L78
            g2.b r118 = AppletRuntimeManager.f36749d;     // Catch: Throwable -> L78
            if (r118 == null) goto L61;
            r117 = r118.currentActivity();     // Catch: Throwable -> L78
            goto L62
        L61:
            r117 = null;
        L64:
            int r119 = AppletPopup.R;     // Catch: Throwable -> L78
            boolean r120 = d(r113, r100, r102.getView());     // Catch: Throwable -> L78
            boolean r121 = r102.Y90();     // Catch: Throwable -> L78
            if (r120 == false) goto L80;
            if (r121 == true) goto L80;
            WindowInsetsCompat r122 = r102.f37810y;     // Catch: Throwable -> L78
            if (r122 == null) goto L73;
            Insets r123 = r122.getInsets(WindowInsetsCompat.Type.navigationBars());     // Catch: Throwable -> L78
            if (r123 == null) goto L72;
            int r124 = r123.bottom;     // Catch: Throwable -> L78
        L77:
            r115 = r115 + r124;     // Catch: Throwable -> L78
            goto L80
        L72:
            r124 = 0;
            goto L77
        L73:
            com.bytedance.ai.utils.l r125 = com.bytedance.ai.utils.l.f37675a;     // Catch: Throwable -> L78
            if (r113 == null) goto L76;
            r106 = r113.getContext();     // Catch: Throwable -> L78
        L76:
            r125.getClass();     // Catch: Throwable -> L78
            r124 = com.bytedance.ai.utils.l.a(r106);     // Catch: Throwable -> L78
        L80:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L78
        L86:
            return RangesKt.coerceAtLeast(r115, 0);
        L78:
            th = th;
        L84:
            Result.Companion r126 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L86
        L87:
            if ((r113.getWindowSystemUiVisibility() & 1024) == 0) goto L53;
            r116 = true;
        L38:
            if (r101 == null) goto L40;
            r113 = r101.getRootView();     // Catch: Throwable -> L82
            goto L41
        L40:
            r113 = null;
        L82:
            th = th;
            r115 = 0;
            goto L84
        L95:
            return r111;
        L27:
            Throwable th10 = th;
        L31:
            Result.Companion r127 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th10));
        L24:
            r111 = 0;
            goto L89
        L18:
            r109 = null;
            goto L19
        L14:
            r108 = null;
        L29:
            th = move-exception;
            th10 = th;
            r111 = 0;
        L32:
            r111 = 0;
        L7:
            r104 = 0;
            goto L8
        }

        public static int c(Activity r100, AppletPopupSchemaParam r101, AppletPopup r102) {
            int r103 = AppletPopup.R;
            Intrinsics.checkNotNullParameter(r101, "params");
            Intrinsics.checkNotNullParameter(r102, "appletPopup");
            com.bytedance.ai.utils.g.f37637a.d("AppletPopup", "getShowHeight");
            Window r104 = r102.X90();
            if (r104 == null) goto L5;
            a(r104);
        L5:
            Context r105 = null;
            if (r104 == null) goto L8;
            Context r106 = r104.getContext();
        L9:
            int r107 = r101.getRealHeight(r106);
            BottomSheetBehavior<LinearLayout> r108 = r102.f37800o;
            if (r108 == null) goto L12;
            int r109 = r108.D;
        L14:
            if (r109 == 3) goto L16;
        L18:
            int r110 = 0;
            if (r100 == null) goto L26;
            AppletRuntimeManager.INSTANCE.getClass();
            g2.b r111 = AppletRuntimeManager.f36749d;
            if (r111 == null) goto L23;
            Integer r112 = Integer.valueOf(r111.getStatusBarHeight(r100));
        L24:
            if (r112 == null) goto L26;
            int r113 = r112.intValue();
        L27:
            int r114 = b(r104, r102.getView(), r102) - r113;
            int r115 = r102.W90(null);
            if (r115 <= 0) goto L30;
            r110 = r115;
        L30:
            int r116 = (r107 - AppletPopup.R) - r110;
            int r117 = r102.f37808w;
            if (r116 <= r117) goto L34;
            r114 = r107 - r117;
        L36:
            if (r107 <= 0) goto L42;
            if (r104 == null) goto L42;
            if (r110 <= 0) goto L40;
            int r118 = RangesKt.coerceAtMost(r107, r114 - r110);
        L51:
            return r118;
        L40:
            r118 = RangesKt.coerceAtMost(r107, r114);
        L42:
            if (r107 != 0) goto L50;
            if (r104 == null) goto L46;
            r105 = r104.getContext();
        L46:
            if (Intrinsics.areEqual(r101.getRealGravity(r105), "center") == false) goto L52;
            if (r104 == null) goto L53;
            int r119 = com.bytedance.ai.utils.o.f37679a;
            return com.bytedance.ai.utils.o.b(r104.getContext(), 400.0d);
        L53:
            return -1;
        L52:
            return -1;
        L50:
            return r107;
        L34:
            if ((r107 + r117) < r114) goto L36;
            r114 = r114 - r117;
            goto L36
        L23:
            r112 = null;
        L26:
            r113 = 0;
            goto L27
        L16:
            if (r101.getDragHeight() <= 0) goto L18;
            r107 = r101.getDragHeight();
            goto L18
        L12:
            r109 = -1;
            goto L14
        L8:
            r106 = null;
            goto L9
        }

        public static boolean d(View r100, Window r101, View r102) {
            if (r100 != null) goto L5;
            return false;
        L5:
            if (r101 == null) goto L9;
            WindowManager.LayoutParams r103 = r101.getAttributes();
            if (r103 == null) goto L9;
            int r104 = r103.flags;
        L11:
            if ((r100.getWindowSystemUiVisibility() & 512) != 0) goto L13;
        L15:
            boolean r105 = false;
        L16:
            if (r105 == true) goto L18;
        L20:
            boolean r106 = false;
        L21:
            View r107 = null;
            if (r102 == null) goto L24;
            ViewParent r108 = r102.getParent();
        L26:
            if ((r108 instanceof View) == false) goto L28;
            r107 = (View) r108;
        L28:
            if (r107 == null) goto L30;
            int r109 = r107.getPaddingBottom();
        L31:
            if (r109 != 0) goto L33;
            boolean r110 = true;
        L34:
            if (r106 == false) goto L38;
            if (r110 == false) goto L39;
            return true;
        L39:
            return false;
        L38:
            return false;
        L33:
            r110 = false;
            goto L34
        L30:
            r109 = 0;
            goto L31
        L24:
            r108 = null;
            goto L26
        L18:
            if ((Integer.MIN_VALUE & r104) == 0) goto L20;
            r106 = true;
            goto L21
        L13:
            if ((134217728 & r104) != 0) goto L15;
            r105 = true;
        L9:
            r104 = 0;
            goto L11
        }
    }

    public interface b {
        void a(AppletPopup r100);
    }

    public static final class c extends v5.a {
        public c() {
        }

        @Override // v5.a
        public final void a(ViewPropertyAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            r100.setInterpolator(new LinearInterpolator());
            r100.setDuration(300);
        }

        @Override // v5.a
        public final void b(ViewPropertyAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            r100.setInterpolator(new LinearInterpolator());
            r100.setDuration(300);
        }
    }

    public static final class d extends BottomSheetBehavior.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f37812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f37813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppletPopup f37814c;

        public d(AppletPopup r100) {
            this.f37814c = r100;
            this.f37812a = 1.0f;
        }

        @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior.b
        public final void a(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            AppletPopup r102 = this.f37814c;
            boolean r103 = true;
            if (r102.K == false) goto L29;
            AppletPopupSchemaParam r104 = r102.f37798m;
            View r105 = null;
            if (r104 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r104 = null;
        L8:
            if (r104.getShowMask() == true) goto L29;
            AppletPopupSchemaParam r106 = this.f37814c.f37798m;
            if (r106 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r106 = null;
        L13:
            if (r106.getDragByGesture() == false) goto L29;
            AppletPopupSchemaParam r107 = this.f37814c.f37798m;
            if (r107 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r107 = null;
        L17:
            r107.setShowMask(true);
            AppletPopupSchemaParam r108 = this.f37814c.f37798m;
            if (r108 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r108 = null;
        L20:
            View r109 = this.f37814c.f37794i;
            if (r109 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        L24:
            Intrinsics.checkNotNullParameter(r108, "params");
            Intrinsics.checkNotNullParameter(r105, "view");
            if (r108.getShowMask() == false) goto L27;
            r105.setVisibility(0);
            r105.setAlpha(1.0f);
            goto L29
        L27:
            r105.setVisibility(0);
            r105.setAlpha(0.0f);
            goto L29
        L23:
            r105 = r109;
        L29:
            if (this.f37812a >= r101) goto L32;
            r103 = false;
        L32:
            this.f37813b = r103;
            this.f37812a = r101;
        }

        @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior.b
        public final void b(View r110, int r111) {
            Intrinsics.checkNotNullParameter(r110, "bottomSheet");
            BottomSheetBehavior<LinearLayout> r112 = this.f37814c.f37800o;
            View r100 = null;
            AppletPopupSchemaParam r101 = null;
            View r102 = null;
            if (r112 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
            r112 = null;
        L6:
            if (r112.D == 2) goto L8;
        L27:
            BottomSheetBehavior<LinearLayout> r113 = this.f37814c.f37800o;
            if (r113 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
            r113 = null;
        L31:
            if (r113.B != 3) goto L33;
            if (r111 == 3) goto L33;
        L39:
            AppletPopup.ea0(this.f37814c, false, false, 6);
            AppletPopup r114 = this.f37814c;
            if (r114.K == false) goto L77;
            if (r111 != 3) goto L62;
            AppletPopupSchemaParam r115 = r114.f37798m;
            if (r115 != null) goto L47;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r115 = null;
        L47:
            if (r115.getDragByGesture() == false) goto L62;
            AppletPopupSchemaParam r116 = this.f37814c.f37798m;
            if (r116 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r116 = null;
        L51:
            r116.setShowMask(false);
            AppletPopupSchemaParam r117 = this.f37814c.f37798m;
            if (r117 != null) goto L54;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r117 = null;
        L54:
            View r103 = this.f37814c.f37794i;
            if (r103 != null) goto L57;
            Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        L58:
            Intrinsics.checkNotNullParameter(r117, "params");
            Intrinsics.checkNotNullParameter(r102, "view");
            if (r117.getShowMask() == false) goto L61;
            r102.setVisibility(0);
            r102.setAlpha(1.0f);
            goto L77
        L61:
            r102.setVisibility(0);
            r102.setAlpha(0.0f);
            goto L77
        L57:
            r102 = r103;
        L62:
            AppletPopupSchemaParam r118 = this.f37814c.f37798m;
            if (r118 != null) goto L65;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r118 = null;
        L65:
            r118.setShowMask(true);
            AppletPopupSchemaParam r119 = this.f37814c.f37798m;
            if (r119 != null) goto L68;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r119 = null;
        L68:
            View r104 = this.f37814c.f37794i;
            if (r104 != null) goto L71;
            Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        L72:
            Intrinsics.checkNotNullParameter(r119, "params");
            Intrinsics.checkNotNullParameter(r100, "view");
            if (r119.getShowMask() == false) goto L75;
            r100.setVisibility(0);
            r100.setAlpha(1.0f);
            goto L77
        L75:
            r100.setVisibility(0);
            r100.setAlpha(0.0f);
            goto L77
        L71:
            r100 = r104;
        L77:
            if (r111 != 5) goto L80;
            this.f37814c.da0(false);
            return;
        L80:
            return;
        L33:
            BottomSheetBehavior<LinearLayout> r120 = this.f37814c.f37800o;
            if (r120 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
            r120 = null;
        L37:
            if (r120.B == 3) goto L77;
            if (r111 != 3) goto L77;
        L8:
            if (this.f37813b == false) goto L27;
            com.bytedance.ai.utils.g.f37637a.i("AppletPopup", "不再消费滚动事件");
            BottomSheetBehavior<LinearLayout> r121 = this.f37814c.f37800o;
            if (r121 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
            r121 = null;
        L12:
            com.bytedance.ai.view.popup.anim.a r122 = r121.E;
            r122.b();
            if (r122.f37872a != 2) goto L15;
            r122.f37887p.getCurrX();
            r122.f37887p.getCurrY();
            r122.f37887p.abortAnimation();
            r122.f37887p.getCurrX();
            ((BottomSheetBehavior.a) r122.f37888q).f37866a.dispatchOnSlide(r122.f37887p.getCurrY());
        L15:
            r122.p(0);
            AppletPopupSchemaParam r123 = this.f37814c.f37798m;
            if (r123 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
            r123 = null;
        L19:
            if (Intrinsics.areEqual(r123.getTransitionAnimationOut(), AnimationStyle.ZOOM.getValue()) == true) goto L25;
            AppletPopupSchemaParam r124 = this.f37814c.f37798m;
            if (r124 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        L24:
            r101.setTransitionAnimationOut(AnimationStyle.SLIDE.getValue());
            goto L25
        L23:
            r101 = r124;
        L25:
            this.f37814c.da0(true);
        }
    }

    static {
        new a();
        R = com.bytedance.ai.utils.o.a(20.0f);
    }

    public final boolean Y90() {
        if (Build.VERSION.SDK_INT <= 29) goto L10;
        WindowInsetsCompat r100 = this.f37810y;
        if (r100 != null) goto L11;
        return false;
    L11:
        return r100.isVisible(WindowInsetsCompat.Type.ime());
    L10:
        return this.I;
    }

    public final void ba0() {
        if (Build.VERSION.SDK_INT <= 29) goto L5;
        return;
    L5:
        if (this.f37811z == true) goto L7;
        return;
    L7:
        Window r100 = X90();
        AppletPopupSchemaParam r101 = null;
        if (r100 == null) goto L10;
        View r102 = S90(r100);
    L11:
        if (r102 == null) goto L64;
        Rect r103 = new Rect();
        r102.getWindowVisibleDisplayFrame(r103);
        int r104 = r102.getRootView().getHeight();
        int r105 = r104 - r103.bottom;
        boolean r106 = a.d(r102, X90(), getView());
        WindowInsetsCompat r107 = this.f37810y;
        if (r107 != null) goto L15;
    L17:
        boolean r108 = false;
    L18:
        if (r108 == false) goto L25;
        if (r106 == true) goto L25;
        WindowInsetsCompat r109 = this.f37810y;
        if (r109 == null) goto L25;
        Insets r110 = r109.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r110 == null) goto L25;
        int r111 = r110.bottom;
    L27:
        if (r105 <= (((double) r104) * 0.25d)) goto L46;
        if (this.I == false) goto L31;
        return;
    L31:
        this.I = true;
        int r112 = this.B;
        if (r112 != (-1)) goto L35;
        this.B = r105;
        return;
    L35:
        if (r112 != r105) goto L37;
        return;
    L37:
        AppletPopupSchemaParam r113 = this.f37798m;
        if (r113 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L42:
        if (r101.getIgnoreKeyboardStatusChange() == false) goto L44;
        return;
    L44:
        this.B = r105;
        aa0(r105 - r111, r105);
        return;
    L40:
        r101 = r113;
        goto L42
    L46:
        if (this.I == true) goto L48;
        return;
    L48:
        this.I = false;
        int r114 = this.B;
        if (r114 != (-1)) goto L52;
        this.B = r111;
        return;
    L52:
        if (r114 != r111) goto L54;
        return;
    L54:
        AppletPopupSchemaParam r115 = this.f37798m;
        if (r115 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L59:
        if (r101.getIgnoreKeyboardStatusChange() == false) goto L61;
        return;
    L61:
        int r116 = r111 - this.B;
        this.B = r111;
        Z90(r116, r111);
        return;
    L57:
        r101 = r115;
    L25:
        r111 = 0;
        goto L27
    L15:
        if (r107.isVisible(WindowInsetsCompat.Type.navigationBars()) != true) goto L17;
        r108 = true;
        goto L18
    L64:
        return;
    L10:
        r102 = null;
        goto L11
    }

    public final boolean ha0() {
        AppletPopupSchemaParam r100 = this.f37798m;
        AppletPopupSchemaParam r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r100 = null;
    L6:
        if (r100.getEnablePullDownClose() == true) goto L20;
        AppletPopupSchemaParam r102 = this.f37798m;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r102 = null;
    L11:
        if (r102.getDragByGesture() == true) goto L20;
        AppletPopupSchemaParam r103 = this.f37798m;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L17:
        if (Intrinsics.areEqual(r101.getRealGravity(getContext()), "bottom") == true) goto L20;
        return false;
    L15:
        r101 = r103;
    L20:
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        List<m> r100 = n.f37907a;
        Intrinsics.checkNotNullParameter(this, "popup");
        Iterator r101 = ((ArrayList) n.f37908b).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        AppletPopup r102 = (AppletPopup) ((WeakReference) r101.next()).get();
        if (r102 == null) goto L9;
        if (Intrinsics.areEqual(r102, this) == false) goto L4;
    L9:
        r101.remove();
        goto L4
    L10:
        Iterator r103 = CollectionsKt.toList(n.f37907a).iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        ((m) r103.next()).b(this);
        goto L12
    L14:
        super.onDestroy();
        View r104 = getView();
        boolean r105 = false;
        if (r104 == null) goto L21;
        ViewTreeObserver r106 = r104.getViewTreeObserver();
        if (r106 == null) goto L21;
        if (r106.isAlive() != true) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L28;
        View r108 = getView();
        if (r108 == null) goto L28;
        ViewTreeObserver r109 = r108.getViewTreeObserver();
        if (r109 == null) goto L28;
        r109.removeOnWindowFocusChangeListener(this);
    L28:
        View r110 = this.F;
        if (r110 == null) goto L40;
        Map<Integer, List<OnApplyWindowInsetsListener>> r111 = q.f37914a;
        k r112 = this.P;
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r112, "listener");
        int r113 = r110.hashCode();
        Map<Integer, List<OnApplyWindowInsetsListener>> r114 = q.f37914a;
        LinkedHashMap r115 = (LinkedHashMap) r114;
        List r116 = (List) r115.get(Integer.valueOf(r113));
        if (r116 == null) goto L33;
        r116.remove(r112);
    L33:
        List r117 = (List) r115.get(Integer.valueOf(r113));
        if (r117 != null) goto L36;
    L38:
        if (r105 == false) goto L40;
        r114.remove(Integer.valueOf(r113));
        goto L40
    L36:
        if (r117.isEmpty() != true) goto L38;
        r105 = true;
    L40:
        this.F = null;
        return;
    L21:
        r107 = false;
        goto L22
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        List<m> r100 = n.f37907a;
        Intrinsics.checkNotNullParameter(this, "popup");
        Iterator r101 = CollectionsKt.toList(n.f37907a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((m) r101.next()).e(this);
        goto L4
    L6:
        super.onPause();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        List<m> r100 = n.f37907a;
        Intrinsics.checkNotNullParameter(this, "popup");
        Iterator r101 = CollectionsKt.toList(n.f37907a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((m) r101.next()).a(this);
        goto L4
    L6:
        super.onStop();
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.bytedance.ai.view.popup.j] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.bytedance.ai.view.popup.k] */
    public AppletPopup() {
        this.f37789d = com.bytedance.ai.utils.o.a(100.0f);
        this.f37796k = new ArrayList();
        this.f37801p = new AnimController();
        this.f37803r = -1;
        this.B = -1;
        this.D = true;
        this.E = true;
        this.H = new Integer[0];
        this.f37788J = RenderType.WEB;
        final Function0<Fragment> r100 = new AppletPopup$special$$inlined$viewModels$default$1(this);
        this.L = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AppletPopupViewModel.class), new AppletPopup$special$$inlined$viewModels$default$2(r100), null);
        this.M = LazyKt.lazy(new i());
        this.O = new j(this);
        this.P = new k(this);
    }

    public final Window X90() {
        Dialog r100 = getDialog();
        Window r101 = null;
        if (r100 == null) goto L6;
        Window r102 = r100.getWindow();
        if (r102 == null) goto L6;
    L15:
        if (r102 != null) goto L23;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r103 = AppletRuntimeManager.f36749d;
        if (r103 == null) goto L22;
        Activity r104 = r103.currentActivity();
        if (r104 == null) goto L22;
        r101 = r104.getWindow();
    L22:
        return r101;
    L23:
        return r102;
    L6:
        Fragment r105 = getParentFragment();
        if ((r105 instanceof DialogFragment) == false) goto L9;
        DialogFragment r106 = (DialogFragment) r105;
    L10:
        if (r106 == null) goto L14;
        Dialog r107 = r106.getDialog();
        if (r107 == null) goto L14;
        r102 = r107.getWindow();
    L14:
        r102 = null;
        goto L15
    L9:
        r106 = null;
        goto L10
    }

    public final boolean ca0() {
        FragmentManager r100 = getFragmentManager();
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        String r102 = getTag();
        if (r102 != null) goto L24;
        return false;
    L24:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L17
        int r104 = r100.getBackStackEntryCount();     // Catch: Throwable -> L17
        if (r104 > 0) goto L12;
    L15:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r101));     // Catch: Throwable -> L17
    L19:
        Boolean r106 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L23;
        r105 = r106;
    L23:
        return ((Boolean) r105).booleanValue();
    L12:
        if (Intrinsics.areEqual(r100.getBackStackEntryAt(r104 - 1).getName(), r102) == false) goto L15;
        r101 = r100.popBackStackImmediate(r102, 1);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        U90(false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.A = true;
        U90(true);
        if (this.f37803r != (-1)) goto L11;
        BottomSheetBehavior<LinearLayout> r100 = this.f37800o;
        if (r100 == null) goto L9;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r100 = null;
    L8:
        int r101 = r100.D;
    L10:
        this.f37803r = r101;
        goto L11
    L9:
        r101 = 3;
    L11:
        List<m> r102 = n.f37907a;
        Intrinsics.checkNotNullParameter(this, "popup");
        Iterator r103 = CollectionsKt.toList(n.f37907a).iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        ((m) r103.next()).f(this);
        goto L13
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        List<m> r100 = n.f37907a;
        Intrinsics.checkNotNullParameter(this, "popup");
        Iterator r101 = CollectionsKt.toList(n.f37907a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((m) r101.next()).d(this);
        goto L4
    }

    public static View S90(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void U90(boolean r100) {
        if (r100 != this.f37811z) goto L5;
        return;
    L5:
        boolean r101 = false;
        if (r100 == false) goto L8;
    L16:
        if (r100 == true) goto L18;
    L28:
        boolean r102 = this.A;
        boolean r103 = super.isVisible();
        boolean r104 = getUserVisibleHint();
        View r105 = getView();
        if (r105 == null) goto L31;
        boolean r106 = r105.hasWindowFocus();
    L32:
        if (r102 == false) goto L38;
        if (r103 == false) goto L38;
        if (r104 == false) goto L38;
        if (r106 == false) goto L38;
        r101 = true;
    L38:
        if (r101 == this.f37811z) goto L47;
        this.f37811z = r101;
        Window r107 = X90();
        if (r107 == null) goto L48;
        View r108 = S90(r107);
        if (r108 == null) goto L49;
        WindowInsetsCompat r109 = this.f37810y;
        if (r109 == null) goto L50;
        T90(r108, r109);
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L31:
        r106 = false;
        goto L32
    L18:
        if (this.N == true) goto L28;
        if (this.f37806u == null) goto L28;
        this.N = true;
        Window r110 = X90();
        if (r110 == null) goto L28;
        View r111 = S90(r110);
        if (r111 == null) goto L28;
        ViewTreeObserver r112 = r111.getViewTreeObserver();
        if (r112 == null) goto L28;
        r112.addOnGlobalLayoutListener(this.O);
        goto L28
    L8:
        if (this.N == false) goto L16;
        this.N = false;
        Window r113 = X90();
        if (r113 == null) goto L28;
        View r114 = S90(r113);
        if (r114 == null) goto L28;
        ViewTreeObserver r115 = r114.getViewTreeObserver();
        if (r115 == null) goto L28;
        r115.removeOnGlobalLayoutListener(this.O);
        goto L28
    }

    public final void V90(int r110) {
        com.bytedance.ai.utils.g r100 = com.bytedance.ai.utils.g.f37637a;
        r100.d("AppletPopup", "contentViewBottom: " + r110);
        Window r101 = X90();
        AppletPopupSchemaParam r102 = null;
        if (r101 == null) goto L5;
        View r103 = S90(r101);
    L6:
        View r104 = getView();
        if (r104 == null) goto L9;
        Object r105 = r104.getParent();
    L11:
        if ((r105 instanceof View) == false) goto L13;
        View r106 = (View) r105;
    L14:
        boolean r107 = false;
        if (r106 == null) goto L17;
        int r108 = r106.getPaddingBottom();
    L19:
        if ((r103 instanceof ViewGroup) == false) goto L21;
        ViewGroup r109 = (ViewGroup) r103;
    L22:
        if (r109 == null) goto L26;
        View r111 = r109.getChildAt(0);
        if (r111 == null) goto L26;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
    L28:
        if ((r112 instanceof FrameLayout.LayoutParams) == false) goto L30;
        FrameLayout.LayoutParams r113 = (FrameLayout.LayoutParams) r112;
    L31:
        if (r113 == null) goto L33;
        int r114 = r113.bottomMargin;
    L34:
        int r115 = (r110 - r108) - r114;
        if (r103 != null) goto L37;
    L62:
        AppletPopupSchemaParam r116 = this.f37798m;
        if (r116 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r116 = null;
    L66:
        if (r116.getSelfAdaptiveHeight() == true) goto L73;
        AppletPopupSchemaParam r117 = this.f37798m;
        if (r117 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L71:
        ea0(this, !r102.getBounceWithKeyboard(), true, 4);
        return;
    L70:
        r102 = r117;
        goto L71
    L73:
        return;
    L37:
        if ((r103.getWindowSystemUiVisibility() & 1024) == 0) goto L39;
        boolean r118 = true;
    L40:
        if (r118 == true) goto L42;
    L44:
        boolean r119 = false;
    L45:
        if (r118 == true) goto L47;
    L59:
        if (r119 == true) goto L61;
        if (r107 == false) goto L62;
    L61:
        r103.setPadding(r103.getPaddingLeft(), r103.getPaddingTop(), r103.getPaddingRight(), r115);
        r100.d("AppletPopup", "updatePadding: " + r115);
        r103.requestLayout();
        goto L62
    L47:
        if (this.f37788J != RenderType.LYNX) goto L59;
        AppletPopupSchemaParam r120 = this.f37798m;
        if (r120 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r120 = null;
    L52:
        if (r120.getKeyboardAdjust() != 2) goto L59;
        AppletPopupSchemaParam r121 = this.f37798m;
        if (r121 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r121 = null;
    L57:
        if (r121.getKeyboardCompat() == false) goto L59;
        r107 = true;
        goto L59
    L42:
        if (this.f37788J != RenderType.WEB) goto L44;
        r119 = true;
        goto L45
    L39:
        r118 = false;
        goto L40
    L33:
        r114 = 0;
        goto L34
    L30:
        r113 = null;
    L26:
        r112 = null;
        goto L28
    L21:
        r109 = null;
        goto L22
    L17:
        r108 = 0;
        goto L19
    L13:
        r106 = null;
        goto L14
    L9:
        r105 = null;
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    public final int W90(Integer r100) {
        if (r100 == null) goto L4;
        int r101 = r100.intValue();
    L8:
        AppletPopupSchemaParam r102 = null;
        if (r101 != 3) goto L20;
        AppletPopupSchemaParam r103 = this.f37798m;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r103 = null;
    L14:
        if (r103.getDragMinMarginTop() <= 0) goto L20;
        AppletPopupSchemaParam r104 = this.f37798m;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L26:
        return r102.getDragMinMarginTop();
    L18:
        r102 = r104;
    L20:
        AppletPopupSchemaParam r105 = this.f37798m;
        if (r105 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L25:
        return r102.getMinMarginTop();
    L23:
        r102 = r105;
        goto L25
    L4:
        BottomSheetBehavior<LinearLayout> r106 = this.f37800o;
        if (r106 == null) goto L7;
        r101 = r106.D;
        goto L8
    L7:
        r101 = -1;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.ai.view.popup.a] */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, java.lang.Object, java.lang.String] */
    public final void da0(boolean r110) {
        if (this.G == false) goto L6;
        return;
    L6:
        if (getFragmentManager() == null) goto L99;
        if (r110 == false) goto L101;
        y5.b r100 = this.f37797l;
        if (r100 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("animatorParamHandler");
        r100 = null;
    L11:
        v5.a r101 = (v5.a) this.M.getValue();
        ?? r102 = new com.bytedance.ai.view.popup.a(this);
        boolean r103 = false;
        if (r100.f566181c.f37827b == AnimController.AnimProcessType.NONE) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == true) goto L99;
        Ref.ObjectRef r105 = new Ref.ObjectRef();
        ?? r106 = r100.a(false);
        r105.element = r106;
        if (Intrinsics.areEqual(r106, AnimationStyle.ZOOM.getValue()) == false) goto L50;
        PathInterpolator r107 = w5.d.f558292a;
        View r108 = r100.f566180b;
        String r111 = r100.f566179a.getFloatingPageName();
        AnimController r112 = r100.f566181c;
        Intrinsics.checkNotNullParameter(r108, "transitionView");
        Intrinsics.checkNotNullParameter(r111, "floatingPageName");
        Intrinsics.checkNotNullParameter(r112, "animController");
        i2.j r113 = i2.i.f488034a;
        s r114 = i2.i.a.a().j();
        if (r114 == null) goto L24;
        PageInfo r115 = r114.getPageInfo();
        if (r115 == null) goto L24;
        String r116 = r115.getPageName();
    L26:
        if (i2.i.a.a().h() == true) goto L28;
    L31:
        boolean r117 = true;
    L32:
        if (r117 == false) goto L47;
        Rect r118 = i2.i.a.a().b();
        if (r118 == null) goto L47;
        com.bytedance.ai.view.popup.anim.c r119 = new com.bytedance.ai.view.popup.anim.c(r108, r112, r102);
        com.bytedance.ai.utils.g r120 = com.bytedance.ai.utils.g.f37637a;
        r120.i("AppletPopup", "zoomOut: zoomOut with Animation first");
        r120.i("AppletPopup", "zoomOutAnimation " + r118.flattenToString());
        Rect r121 = new Rect();
        r108.getGlobalVisibleRect(r121);
        r108.setPivotX(0.0f);
        r108.setPivotY(0.0f);
        float r122 = r118.width() / r121.width();
        float r109 = r118.height() / r108.getHeight();
        float r123 = r118.left - r121.left;
        r108.animate().alpha(0.0f).scaleX(r122).scaleY(r109).translationX(r123).translationY(r118.top - r121.top).setInterpolator(w5.d.f558292a).setDuration(300).setListener(r119).start();
        View r124 = r108.getRootView();
        if (r124 == null) goto L46;
        ViewPropertyAnimator r125 = r124.animate();
        if (r125 == null) goto L46;
        ViewPropertyAnimator r126 = r125.alpha(0.0f);
        if (r126 == null) goto L46;
        ViewPropertyAnimator r127 = r126.setDuration(300);
        if (r127 == null) goto L46;
        r127.start();
    L46:
        r120.i("AppletPopup", "zoomOut: show floating widget after 200 ms");
        p2.c.e(new w5.c(), 200);
        r103 = true;
    L47:
        if (r103 == true) goto L99;
        r105.element = AnimationStyle.SLIDE.getValue();
        goto L50
    L28:
        if (Intrinsics.areEqual(r116, r111) == true) goto L31;
        r117 = false;
    L24:
        r116 = null;
    L50:
        y5.a r128 = new y5.a(r100, r105, r102);
        String r129 = (String) r105.element;
        if (Intrinsics.areEqual(r129, AnimationStyle.SLIDE.getValue()) == false) goto L54;
        Intrinsics.checkNotNull(r100.f566180b.animate().translationY(r100.f566180b.getHeight()).setDuration(r100.f566179a.getResizeDurationInMillSeconds()).setListener(r128));
    L82:
        if (r101 == null) goto L84;
        r101.a(r100.f566180b.animate());
    L84:
        r100.f566180b.animate().start();
        goto L99
    L54:
        if (Intrinsics.areEqual(r129, AnimationStyle.LEFT.getValue()) == false) goto L65;
        DisplayMetrics r130 = new DisplayMetrics();
        if ((r100.f566180b.getContext() instanceof Activity) == false) goto L58;
        Context r131 = r100.f566180b.getContext();
        Intrinsics.checkNotNull(r131, "null cannot be cast to non-null type android.app.Activity");
        WindowManager r132 = ((Activity) r131).getWindowManager();
    L59:
        if (r132 == null) goto L63;
        Display r133 = r132.getDefaultDisplay();
        if (r133 == null) goto L63;
        r133.getMetrics(r130);
    L63:
        Intrinsics.checkNotNull(r100.f566180b.animate().translationX(-r130.widthPixels).setDuration(r100.f566179a.getResizeDurationInMillSeconds()).setListener(r128));
        goto L82
    L58:
        Object r134 = r100.f566180b.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r134, "null cannot be cast to non-null type android.view.WindowManager");
        r132 = (WindowManager) r134;
        goto L59
    L65:
        if (Intrinsics.areEqual(r129, AnimationStyle.RIGHT.getValue()) == false) goto L76;
        DisplayMetrics r135 = new DisplayMetrics();
        if ((r100.f566180b.getContext() instanceof Activity) == false) goto L69;
        Context r136 = r100.f566180b.getContext();
        Intrinsics.checkNotNull(r136, "null cannot be cast to non-null type android.app.Activity");
        WindowManager r137 = ((Activity) r136).getWindowManager();
    L70:
        if (r137 == null) goto L74;
        Display r138 = r137.getDefaultDisplay();
        if (r138 == null) goto L74;
        r138.getMetrics(r135);
    L74:
        Intrinsics.checkNotNull(r100.f566180b.animate().translationX(r135.widthPixels).setDuration(r100.f566179a.getResizeDurationInMillSeconds()).setListener(r128));
        goto L82
    L69:
        Object r139 = r100.f566180b.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r139, "null cannot be cast to non-null type android.view.WindowManager");
        r137 = (WindowManager) r139;
        goto L70
    L76:
        if (Intrinsics.areEqual(r129, AnimationStyle.AUTO.getValue()) == false) goto L79;
        View r140 = r100.f566180b;
        r140.setAlpha(1.0f);
        Intrinsics.checkNotNull(r140.animate().alpha(0.0f).setDuration(r100.f566179a.getResizeDurationInMillSeconds()).setListener(r128));
        goto L82
    L79:
        if (Intrinsics.areEqual(r129, AnimationStyle.NONE.getValue()) == false) goto L81;
        r102.invoke();
        r100.f566181c.a(AnimController.AnimProcessType.DONE, false, null);
        goto L82
    L81:
        r102.invoke();
        r100.f566181c.a(AnimController.AnimProcessType.DONE, false, null);
        goto L82
    L14:
        r104 = false;
        goto L15
    L101:
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L96
        if (ca0() == false) goto L103;
    L94:
        Object r142 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L96
    L98:
        Result.m9448boximpl(r142);
        goto L99
    L103:
        dismissAllowingStateLoss();     // Catch: Exception -> L89 Throwable -> L96
    L89:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L96
        Throwable r143 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L96
        if (r143 == null) goto L94;
        com.bytedance.crash.d.d(r143, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L99:
        this.G = true;
    }

    public final void fa0(boolean r100) {
        BottomSheetBehavior<LinearLayout> r101 = this.f37800o;
        if (r101 != null) goto L5;
        return;
    L5:
        AppletPopupSchemaParam r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r101 = null;
    L8:
        r101.f37852s = r100;
        AppletPopupSchemaParam r103 = this.f37798m;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L12:
        r102.setDragByGesture(r100);
        return;
    L11:
        r102 = r103;
        goto L12
    }

    public final void ga0(int r100) {
        Fragment r101 = getChildFragmentManager().findFragmentById(r100);
        AIFragmentBase r102 = null;
        if ((r101 instanceof AIFragmentBase) == false) goto L5;
        AIFragmentBase r103 = (AIFragmentBase) r101;
    L6:
        if (r103 == null) goto L32;
        this.f37799n = r103;
        return;
    L32:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L26
        Bundle r105 = getArguments();     // Catch: Throwable -> L26
        if (r105 == null) goto L13;
        String r106 = r105.getString("appId");     // Catch: Throwable -> L26
        if (r106 == null) goto L13;
    L14:
        FragmentTransaction r107 = getChildFragmentManager().beginTransaction();     // Catch: Throwable -> L26
        AIFragmentBase r108 = this.f37799n;     // Catch: Throwable -> L26
        if (r108 != null) goto L20;
        AppletRuntimeManager.INSTANCE.getClass();     // Catch: Throwable -> L26
        g2.b r109 = AppletRuntimeManager.f36749d;     // Catch: Throwable -> L26
        if (r109 == null) goto L19;
        r102 = r109.g(r106);     // Catch: Throwable -> L26
    L19:
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L26
        r108 = r102;
    L20:
        this.f37799n = r108;     // Catch: Throwable -> L26
        r108.setArguments(getArguments());     // Catch: Throwable -> L26
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L26
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r107, r108, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "popup", r100) == true) goto L24;
        r107 = r107.add(r100, r108, "popup");     // Catch: Throwable -> L26
    L24:
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L26
        p2.c.d(new f("popup", r107));     // Catch: Throwable -> L26
        Object r111 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L26
    L28:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L34;
        com.bytedance.ai.utils.g.f37637a.e("AppletPopup", "showAppletPage", r112);
        return;
    L34:
        return;
    L13:
        r106 = "";
    L26:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        U90(true);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (r100 == null) goto L8;
        Bundle r101 = new Bundle();
        r101.putAll(r100);
        setArguments(r101);
        Serializable r102 = r100.getSerializable("popupSchema");
        if (r102 == null) goto L8;
        this.f37798m = (AppletPopupSchemaParam) r102;
    L8:
        if (this.Q != null) goto L10;
        this.Q = ((AppletPopupViewModel) this.L.getValue()).getMLifeCycleListener();
    L11:
        b r103 = this.Q;
        if (r103 == null) goto L14;
        r103.a(this);
    L14:
        List<m> r104 = n.f37907a;
        Intrinsics.checkNotNullParameter(this, "popup");
        List<WeakReference<AppletPopup>> r105 = n.f37908b;
        ArrayList r106 = (ArrayList) r105;
        r106.add(new WeakReference(this));
        Iterator r107 = CollectionsKt.toList(n.f37907a).iterator();
    L16:
        if (r107.hasNext() == false) goto L18;
        ((m) r107.next()).c(this);
        goto L16
    L18:
        return;
    L10:
        AppletPopupViewModel r108 = (AppletPopupViewModel) this.L.getValue();
        b r109 = this.Q;
        Intrinsics.checkNotNull(r109);
        r108.setLifeCycleListener(r109);
        goto L11
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        final Context r101 = requireContext();
        AppletPopUpDialog r102 = new AnonymousClass1(this, r101);
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L5;
        r102.setOwnerActivity(r103);
    L5:
        AppletPopupSchemaParam r104 = this.f37798m;
        if (r104 != null) goto L9;
        r104 = null;
    L9:
        r102.f37787a = r104;
        return r102;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r100) {
        super.onHiddenChanged(r100);
        U90(!r100);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        r100.putAll(getArguments());
        AppletPopupSchemaParam r101 = this.f37798m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r101 = null;
    L5:
        r100.putSerializable("popupSchema", r101);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        U90(true);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        r100.removeOnAttachStateChangeListener(this);
        U90(false);
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean r100) {
        U90(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        U90(r100);
    }

    public final WindowInsetsCompat T90(View r100, WindowInsetsCompat r101) {
        if (r100 == null) goto L4;
        if (r101 == null) goto L7;
        WindowInsetsCompat r102 = ViewCompat.onApplyWindowInsets(r100, r101);
        boolean r103 = Y90();
        boolean r104 = a.d(r100, X90(), getView());
        if (r101.isVisible(WindowInsetsCompat.Type.navigationBars()) == false) goto L12;
        if (r104 == true) goto L12;
        int r105 = r101.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
    L13:
        if (r103 == false) goto L15;
        r105 = r101.getInsets(WindowInsetsCompat.Type.ime()).bottom;
    L15:
        int r106 = this.B;
        if (r106 != (-1)) goto L19;
        this.B = r105;
        return r102;
    L19:
        if (r106 != r105) goto L21;
        return r102;
    L21:
        AppletPopupSchemaParam r107 = this.f37798m;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r107 = null;
    L25:
        if (r107.getIgnoreKeyboardStatusChange() == false) goto L28;
        return r102;
    L28:
        if (this.f37811z == true) goto L30;
        return r102;
    L30:
        int r108 = this.B;
        int r109 = r105 - r108;
        int r110 = this.f37789d;
        if (r109 <= r110) goto L35;
        aa0(r109, r105);
        this.B = r105;
        return r102;
    L35:
        if ((r108 - r105) <= r110) goto L37;
        Z90(r109, r105);
        this.B = r105;
    L37:
        return r102;
    L12:
        r105 = 0;
        goto L13
    L7:
        return WindowInsetsCompat.CONSUMED;
    L4:
        return WindowInsetsCompat.CONSUMED;
    }

    public final void Z90(int r110, int r111) {
        int r112 = -Math.abs(r110);
        if (r112 <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L9;
        r112 = 0;
    L9:
        Context r101 = getContext();
        if (r101 == null) goto L12;
        com.bytedance.ai.utils.o.d(r112, r101);
    L12:
        this.f37808w = 0;
        if (getActivity() == null) goto L78;
        View r113 = getView();
        AppletPopupSchemaParam r102 = null;
        if (r113 == null) goto L62;
        AppletPopupSchemaParam r103 = this.f37798m;
        if (r103 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r103 = null;
    L20:
        if (r103.getSelfAdaptiveHeight() == true) goto L62;
        LinearLayout r104 = this.f37791f;
        if (r104 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r104 = null;
    L25:
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        X90();
        FragmentActivity r106 = getActivity();
        AppletPopupSchemaParam r107 = this.f37798m;
        if (r107 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r107 = null;
    L28:
        r105.height = a.c(r106, r107, this);
        RadiusLayout r108 = this.f37792g;
        if (r108 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r108 = null;
    L31:
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        LinearLayout r114 = this.f37791f;
        if (r114 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r114 = null;
    L34:
        r109.height = r114.getLayoutParams().height - 0;
        BottomSheetBehavior<LinearLayout> r115 = this.f37800o;
        if (r115 == null) goto L55;
        r115.C = true;
        if (r115 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r115 = null;
    L40:
        if (r115.D == 3) goto L48;
        BottomSheetBehavior<LinearLayout> r116 = this.f37800o;
        if (r116 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r116 = null;
    L44:
        LinearLayout r117 = this.f37791f;
        if (r117 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r117 = null;
    L47:
        r116.setPeekHeight(r117.getLayoutParams().height);
        goto L55
    L48:
        BottomSheetBehavior<LinearLayout> r118 = this.f37800o;
        if (r118 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r118 = null;
    L51:
        LinearLayout r119 = this.f37791f;
        if (r119 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r119 = null;
    L54:
        r118.f37856w = r119.getLayoutParams().height;
    L55:
        int r120 = y5.e.f566189d;
        AppletPopupSchemaParam r121 = this.f37798m;
        if (r121 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r121 = null;
    L58:
        int r122 = y5.e.a.a(r121, r113, this.H);
        LinearLayout r123 = this.f37791f;
        if (r123 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r123 = null;
    L61:
        y5.e.a.b(r123, r122);
    L62:
        BottomSheetBehavior<LinearLayout> r124 = this.f37800o;
        if (r124 == null) goto L75;
        r124.C = true;
        if (this.f37809x == false) goto L67;
        fa0(true);
    L67:
        BottomSheetBehavior<LinearLayout> r125 = this.f37800o;
        if (r125 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r125 = null;
    L70:
        AppletPopupSchemaParam r126 = this.f37798m;
        if (r126 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L74:
        r125.setHideable(r102.getEnablePullDownClose());
        goto L75
    L73:
        r102 = r126;
    L75:
        CoordinatorLayout r127 = this.f37795j;
        if (r127 == null) goto L78;
        r127.requestLayout();
    L78:
        V90(r111);
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void aa0(int r110, int r111) {
        int r100 = Math.abs(r110);
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = 0;
    L9:
        Context r102 = getContext();
        if (r102 == null) goto L12;
        com.bytedance.ai.utils.o.d(r100, r102);
    L12:
        this.f37808w = Math.abs(r110);
        if (getActivity() == null) goto L116;
        View r112 = getView();
        if (r112 == null) goto L116;
        AppletPopupSchemaParam r103 = this.f37798m;
        RadiusLayout r104 = null;
        if (r103 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r103 = null;
    L20:
        if (r103.getSelfAdaptiveHeight() == true) goto L90;
        int r113 = a.b(X90(), r112, this);
        if (this.f37802q != 0) goto L38;
        AppletPopupSchemaParam r105 = this.f37798m;
        if (r105 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r105 = null;
    L28:
        if (r105.getSelfAdaptiveHeight() == false) goto L33;
        AppletPopupSchemaParam r106 = this.f37798m;
        if (r106 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r106 = null;
    L32:
        int r107 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r106.getHeight(), r113 - W90(null)), 0);
    L37:
        this.f37802q = r107;
        goto L38
    L33:
        LinearLayout r108 = this.f37791f;
        if (r108 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r108 = null;
    L36:
        r107 = r108.getMeasuredHeight();
    L38:
        int r114 = RangesKt.coerceAtMost(this.f37802q, r113 - W90(null));
        LinearLayout r109 = this.f37791f;
        if (r109 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r109 = null;
    L41:
        ViewGroup.LayoutParams r115 = r109.getLayoutParams();
        if (r115 == null) goto L44;
        r115.height = r114;
    L44:
        int r116 = r114 - 0;
        RadiusLayout r117 = this.f37792g;
        if (r117 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r117 = null;
    L47:
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if (r118 == null) goto L50;
        r118.height = r116;
    L50:
        int r119 = y5.e.f566189d;
        LinearLayout r120 = this.f37791f;
        if (r120 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r120 = null;
    L53:
        Intrinsics.checkNotNullParameter(r120, "view");
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        if ((r121 instanceof FrameLayout.LayoutParams) == false) goto L57;
        ViewGroup.LayoutParams r122 = r120.getLayoutParams();
        Intrinsics.checkNotNull(r122, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int r123 = ((FrameLayout.LayoutParams) r122).gravity;
    L63:
        int r124 = r123 & 7;
        LinearLayout r125 = this.f37791f;
        if (r125 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r125 = null;
    L66:
        y5.e.a.b(r125, r124 | 80);
        BottomSheetBehavior<LinearLayout> r126 = this.f37800o;
        if (r126 == null) goto L90;
        r126.C = true;
        if (this.f37807v != 0) goto L77;
        if (r126 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r126 = null;
    L73:
        if (r126.f37838e == false) goto L75;
        int r127 = -1;
    L76:
        this.f37807v = r127;
        goto L77
    L75:
        r127 = r126.f37837d;
    L77:
        BottomSheetBehavior<LinearLayout> r128 = this.f37800o;
        if (r128 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r128 = null;
    L81:
        if (r128.D == 3) goto L86;
        BottomSheetBehavior<LinearLayout> r129 = this.f37800o;
        if (r129 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r129 = null;
    L85:
        r129.setPeekHeight(r116);
        goto L90
    L86:
        BottomSheetBehavior<LinearLayout> r130 = this.f37800o;
        if (r130 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r130 = null;
    L89:
        r130.f37856w = r116;
        goto L90
    L57:
        if ((r121 instanceof CoordinatorLayout.LayoutParams) == false) goto L60;
        ViewGroup.LayoutParams r131 = r120.getLayoutParams();
        Intrinsics.checkNotNull(r131, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        r123 = ((CoordinatorLayout.LayoutParams) r131).gravity;
        goto L63
    L60:
        if ((r121 instanceof LinearLayout.LayoutParams) == false) goto L62;
        ViewGroup.LayoutParams r132 = r120.getLayoutParams();
        Intrinsics.checkNotNull(r132, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        r123 = ((LinearLayout.LayoutParams) r132).gravity;
        goto L63
    L62:
        r123 = 0;
    L90:
        BottomSheetBehavior<LinearLayout> r133 = this.f37800o;
        if (r133 != null) goto L93;
    L103:
        AppletPopupSchemaParam r134 = this.f37798m;
        if (r134 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r134 = null;
    L107:
        if (r134.getSelfAdaptiveHeight() == false) goto L116;
        LinearLayout r135 = this.f37791f;
        if (r135 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r135 = null;
    L111:
        r135.requestLayout();
        RadiusLayout r136 = this.f37792g;
        if (r136 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
    L115:
        r104.requestLayout();
        goto L116
    L114:
        r104 = r136;
        goto L115
    L93:
        if (r133.f37852s == false) goto L103;
        if (r133 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r133 = null;
    L96:
        r133.C = true;
        BottomSheetBehavior<LinearLayout> r137 = this.f37800o;
        if (r137 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r137 = null;
    L99:
        this.f37809x = r137.f37852s;
        fa0(false);
        BottomSheetBehavior<LinearLayout> r138 = this.f37800o;
        if (r138 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r138 = null;
    L102:
        r138.setHideable(false);
    L116:
        V90(r111);
        return;
    L5:
        r101 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r8v3, types: [com.bytedance.ai.view.popup.e] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        r110.getViewTreeObserver().addOnWindowFocusChangeListener(this);
        r110.addOnAttachStateChangeListener(this);
        boolean r100 = true;
        if (this.f37800o == null) goto L15;
        ViewTreeObserver.OnGlobalLayoutListener r112 = new com.bytedance.ai.view.popup.d(this);
        this.f37804s = false;
        this.f37806u = r112;
        Window r113 = X90();
        if (r113 == null) goto L7;
        View r114 = S90(r113);
    L9:
        if (this.N == true) goto L15;
        this.N = true;
        com.bytedance.ai.utils.g.f37637a.d("AppletPopup", this + " ######registerRootViewGlobalLayoutChangeListerOnce#####");
        if (r114 == null) goto L15;
        ViewTreeObserver r115 = r114.getViewTreeObserver();
        if (r115 == null) goto L15;
        r115.addOnGlobalLayoutListener(this.O);
        goto L15
    L7:
        r114 = null;
    L15:
        List<x5.a> r116 = this.f37796k;
        AppletPopupSchemaParam r101 = this.f37798m;
        if (r101 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r101 = null;
    L18:
        LinearLayout r102 = this.f37791f;
        if (r102 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r102 = null;
    L21:
        ArrayList r117 = (ArrayList) r116;
        r117.add(new y5.j(r101, r102));
        AppletPopupSchemaParam r103 = this.f37798m;
        if (r103 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r103 = null;
    L24:
        LinearLayout r104 = this.f37791f;
        if (r104 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r104 = null;
    L27:
        RadiusLayout r105 = this.f37792g;
        if (r105 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r105 = null;
    L30:
        ha0();
        AppletPopupSchemaParam r106 = this.f37798m;
        if (r106 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r106 = null;
    L33:
        r117.add(new y5.h(r103, r104, r105, r106.getRealGravity(getContext())));
        AppletPopupSchemaParam r107 = this.f37798m;
        if (r107 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r107 = null;
    L36:
        View r108 = this.f37794i;
        if (r108 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        r108 = null;
    L39:
        r117.add(new y5.i(r107, r108));
        AppletPopupSchemaParam r109 = this.f37798m;
        if (r109 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r109 = null;
    L42:
        View r118 = this.f37794i;
        if (r118 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        r118 = null;
    L45:
        r117.add(new y5.g(r109, r118));
        AppletPopupSchemaParam r119 = this.f37798m;
        if (r119 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r119 = null;
    L48:
        View r120 = this.f37794i;
        if (r120 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        r120 = null;
    L51:
        r117.add(new y5.d(r119, r120, new e(this)));
        AppletPopupSchemaParam r121 = this.f37798m;
        if (r121 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r121 = null;
    L54:
        LinearLayout r122 = this.f37791f;
        if (r122 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r122 = null;
    L57:
        r117.add(new y5.f(r121, r122, this.H));
        Iterator r123 = ((ArrayList) this.f37796k).iterator();
    L59:
        if (r123.hasNext() == false) goto L61;
        ((x5.a) r123.next()).invoke();
        goto L59
    L61:
        int r124 = z5.a.f570044a;
        Dialog r125 = getDialog();
        if (r125 == null) goto L64;
        Window r126 = r125.getWindow();
    L65:
        AppletPopupSchemaParam r127 = this.f37798m;
        if (r127 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r127 = null;
    L69:
        if (this.f37791f != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
    L71:
        Intrinsics.checkNotNullParameter(r127, "schemaParams");
        int r128 = r127.getKeyboardAdjust();
        if (r128 != 0) goto L74;
        if (r126 == null) goto L86;
        r126.setSoftInputMode(48);
    L86:
        if (getActivity() != null) goto L88;
        return;
    L88:
        if (ha0() == true) goto L116;
        int r129 = a.b(X90(), getView(), this);
        AppletPopupSchemaParam r130 = this.f37798m;
        if (r130 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r130 = null;
    L93:
        if ((!Intrinsics.areEqual(r130.getRealGravity(getContext()), "center")) == false) goto L99;
        AppletPopupSchemaParam r131 = this.f37798m;
        if (r131 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r131 = null;
    L98:
        if (r131.getRealHeight(getActivity()) <= (r129 - W90(null))) goto L99;
    L111:
        if (r100 == false) goto L117;
        r110.setPadding(r110.getPaddingLeft(), r110.getPaddingTop() + W90(null), r110.getPaddingRight(), r110.getPaddingBottom());
        return;
    L117:
        return;
    L99:
        AppletPopupSchemaParam r132 = this.f37798m;
        if (r132 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r132 = null;
    L103:
        if ((!Intrinsics.areEqual(r132.getRealGravity(getContext()), "center")) == true) goto L110;
        AppletPopupSchemaParam r133 = this.f37798m;
        if (r133 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r133 = null;
    L108:
        if (r133.getRealHeight(getActivity()) > (r129 - (W90(null) * 2))) goto L111;
    L110:
        r100 = false;
        goto L111
    L116:
        return;
    L74:
        if (r128 == 1) goto L81;
        if (r128 == 2) goto L78;
        if (r126 == null) goto L86;
        r126.setSoftInputMode(32);
        goto L86
    L78:
        if (r126 == null) goto L80;
        r126.setSoftInputMode(16);
    L80:
        r127.getTransStatusBar();
        goto L86
    L81:
        if (r126 == null) goto L86;
        r126.setSoftInputMode(32);
        goto L86
    L64:
        r126 = null;
        goto L65
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Field r103 = DialogFragment.class.getDeclaredField("mDismissed");     // Catch: Throwable -> L5
        r103.setAccessible(true);     // Catch: Throwable -> L5
        r103.set(this, Boolean.FALSE);     // Catch: Throwable -> L5
        Field r104 = DialogFragment.class.getDeclaredField("mShownByMe");     // Catch: Throwable -> L5
        r104.setAccessible(true);     // Catch: Throwable -> L5
        r104.set(this, Boolean.TRUE);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L24:
        FragmentTransaction r105 = r100.beginTransaction();     // Catch: Throwable -> L16
        Fragment r106 = r100.findFragmentByTag(r101);     // Catch: Throwable -> L16
        if (r106 == null) goto L10;
        com.bytedance.ai.utils.g.f37637a.d("AppletPopup", "showAllowingStateLoss remove fragment[" + getId() + ']');     // Catch: Throwable -> L16
        r105.remove(r106);     // Catch: Throwable -> L16
    L10:
        com.bytedance.ai.utils.g.f37637a.d("AppletPopup", "showAllowingStateLoss add fragment[" + this + ']');     // Catch: Throwable -> L16
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r105, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r101, 0) == true) goto L14;
        r105.add(this, r101);     // Catch: Throwable -> L16
    L14:
        p2.c.d(new f(r101, r105));     // Catch: Throwable -> L16
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L26;
        com.bytedance.ai.utils.g.f37637a.e("AppletPopup", "showAllowingStateLoss", r108);
        return;
    L26:
        return;
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r210) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        AppletPopupSchemaParam r100 = this.f37798m;
        AppletPopupSchemaParam r101 = null;
        BottomSheetBehavior<LinearLayout> r102 = null;
        if (r100 != null) goto L7;
        r100 = null;
    L7:
        if (r100 != null) goto L10;
        com.bytedance.ai.utils.g.f37637a.w("AppletPopup", "schemaParam is null, close fragment directly");
        da0(false);
        return null;
    L10:
        com.bytedance.ai.utils.g r103 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r104 = new StringBuilder("[");
        r104.append(this);
        r104.append("] onCreateView, savedInstanceState is ");
        if (r210 != null) goto L13;
        String r105 = "null";
    L14:
        r104.append(r105);
        r103.d("AppletPopup", r104.toString());
        Window r106 = X90();
        if (r106 == null) goto L17;
        View r107 = S90(r106);
    L18:
        this.F = r107;
        if (r107 == null) goto L33;
        Map<Integer, List<OnApplyWindowInsetsListener>> r108 = q.f37914a;
        k r109 = this.P;
        Intrinsics.checkNotNullParameter(r107, "view");
        Intrinsics.checkNotNullParameter(r109, "listener");
        final int r112 = r107.hashCode();
        Map<Integer, List<OnApplyWindowInsetsListener>> r113 = q.f37914a;
        LinkedHashMap r114 = (LinkedHashMap) r113;
        Collection r115 = (Collection) r114.get(Integer.valueOf(r112));
        if (r115 != null) goto L23;
    L26:
        boolean r116 = true;
    L27:
        if (r116 == false) goto L29;
        r113.put(Integer.valueOf(r112), new ArrayList());
        ViewCompat.setOnApplyWindowInsetsListener(r107, new p(r112));
    L29:
        List r117 = (List) r114.get(Integer.valueOf(r112));
        if (r117 == null) goto L32;
        r117.add(r109);
    L32:
        r107.requestApplyInsets();
        goto L33
    L23:
        if (r115.isEmpty() == true) goto L26;
        r116 = false;
    L33:
        int r118 = z5.a.f570044a;
        AppletPopupSchemaParam r119 = this.f37798m;
        if (r119 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r119 = null;
    L36:
        Context r120 = r110.getContext();
        Intrinsics.checkNotNullParameter(r119, "params");
        Intrinsics.checkNotNullParameter(r120, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r119.getMarginTop() <= 0) goto L39;
        int r121 = r119.getMarginTop();
        boolean r122 = true;
    L41:
        if (r119.getMarginBottom() <= 0) goto L43;
        int r123 = r119.getMarginBottom();
        r122 = true;
    L45:
        if (r119.getMarginLeft() <= 0) goto L47;
        int r124 = r119.getMarginLeft();
        boolean r125 = true;
    L49:
        if (r119.getMarginRight() <= 0) goto L51;
        int r126 = r119.getMarginRight();
        r125 = true;
    L52:
        boolean r127 = z5.a.a(r120);
        if (r119.getMarginStart() <= 0) goto L55;
        int r128 = r119.getMarginStart();
        r125 = true;
    L57:
        if (r119.getMarginEnd() <= 0) goto L59;
        int r129 = r119.getMarginEnd();
        r125 = true;
    L60:
        if (r125 == false) goto L79;
        if (r122 == true) goto L79;
        if (Intrinsics.areEqual(r119.getGravity(), "left") == false) goto L65;
    L78:
        r123 = 0;
    L86:
        r121 = 0;
        r126 = 0;
    L87:
        this.H = new Integer[]{Integer.valueOf(r124), Integer.valueOf(r121), Integer.valueOf(r126), Integer.valueOf(r123), Integer.valueOf(r128), Integer.valueOf(r129)};
        if (ha0() == false) goto L145;
        View r130 = r110.inflate(R.layout.applet_fragment_popup_enable_pull_down_close, r111, false);
        this.f37790e = (FrameLayout) r130.findViewById(R.id.popup_root);
        LinearLayout r131 = (LinearLayout) r130.findViewById(R.id.popup_container);
        r131.setOnClickListener(new g());
        this.f37791f = r131;
        this.f37792g = (RadiusLayout) r130.findViewById(R.id.popup_inner_container);
        this.f37793h = (FrameLayout) r130.findViewById(R.id.popup_top_container);
        this.f37794i = r130.findViewById(R.id.popup_bg);
        this.f37795j = (CoordinatorLayout) r130.findViewById(R.id.popup_coordinator);
        AppletPopupSchemaParam r132 = this.f37798m;
        if (r132 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r132 = null;
    L92:
        LinearLayout r133 = this.f37791f;
        if (r133 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r133 = null;
    L95:
        this.f37797l = new y5.b(r132, r133, this.f37801p);
        AppletPopupSchemaParam r134 = this.f37798m;
        if (r134 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r134 = null;
    L98:
        r134.getDragByGesture();
        LinearLayout r135 = this.f37791f;
        if (r135 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r135 = null;
    L101:
        ViewGroup.LayoutParams r136 = r135.getLayoutParams();
        boolean r137 = r136 instanceof CoordinatorLayout.LayoutParams;
        CoordinatorLayout.Behavior r138 = ((CoordinatorLayout.LayoutParams) r136).getBehavior();
        boolean r139 = r138 instanceof BottomSheetBehavior;
        BottomSheetBehavior<LinearLayout> r140 = (BottomSheetBehavior) r138;
        r140.setHideable(true);
        r140.S = true;
        RadiusLayout r141 = this.f37792g;
        if (r141 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r141 = null;
    L104:
        r140.f37853t = new WeakReference(r141);
        r140.f37854u = new WeakReference(null);
        d r142 = new d(this);
        if (r140.M.contains(r142) == true) goto L108;
        r140.M.add(r142);
    L108:
        if (this.D == false) goto L110;
        r140.f37838e = false;
    L110:
        this.f37800o = r140;
        AnimController r143 = this.f37801p;
        r143.getClass();
        AnimController.AnimProcessType r144 = AnimController.AnimProcessType.NONE;
        r143.f37826a = r144;
        r143.f37827b = r144;
        r143.f37828c = null;
        BottomSheetBehavior<LinearLayout> r145 = this.f37800o;
        if (r145 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r145 = null;
    L113:
        r145.V = this.f37801p;
        BottomSheetBehavior<LinearLayout> r146 = this.f37800o;
        if (r146 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r146 = null;
    L116:
        r146.setFitToContents(false);
        BottomSheetBehavior<LinearLayout> r147 = this.f37800o;
        if (r147 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r147 = null;
    L119:
        AppletPopupSchemaParam r148 = this.f37798m;
        if (r148 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r148 = null;
    L122:
        r147.setHideable(r148.getEnablePullDownClose());
        BottomSheetBehavior<LinearLayout> r149 = this.f37800o;
        if (r149 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r149 = null;
    L125:
        AppletPopupSchemaParam r150 = this.f37798m;
        if (r150 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r150 = null;
    L128:
        r149.f37852s = r150.getDragByGesture();
        BottomSheetBehavior<LinearLayout> r151 = this.f37800o;
        if (r151 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r151 = null;
    L131:
        int r152 = W90(4);
        if (r152 >= 0) goto L134;
        r151.getClass();
    L135:
        BottomSheetBehavior<LinearLayout> r153 = this.f37800o;
        if (r153 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L139:
        int r154 = W90(3);
        if (r154 < 0) goto L143;
        r102.f37845l = r154;
        ga0(R.id.engine_container);
        return r130;
    L143:
        r102.getClass();
        throw new IllegalArgumentException("dragMinMarginTop must be greater than or equal to 0");
    L138:
        r102 = r153;
        goto L139
    L134:
        r151.f37844k = r152;
        goto L135
    L145:
        View r155 = r110.inflate(R.layout.applet_fragment_popup, r111, false);
        this.f37790e = (FrameLayout) r155.findViewById(R.id.popup_root);
        LinearLayout r156 = (LinearLayout) r155.findViewById(R.id.popup_container);
        ga0(R.id.popup_inner_container);
        r156.setOnClickListener(new g());
        this.f37791f = r156;
        this.f37792g = (RadiusLayout) r155.findViewById(R.id.popup_inner_container);
        this.f37793h = (FrameLayout) r155.findViewById(R.id.popup_top_container);
        this.f37794i = r155.findViewById(R.id.popup_bg);
        List<x5.a> r157 = this.f37796k;
        AppletPopupSchemaParam r158 = this.f37798m;
        if (r158 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r158 = null;
    L148:
        LinearLayout r159 = this.f37791f;
        if (r159 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r159 = null;
    L151:
        ((ArrayList) r157).add(new y5.e(r158, r159, this.H));
        AppletPopupSchemaParam r160 = this.f37798m;
        if (r160 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r160 = null;
    L154:
        LinearLayout r161 = this.f37791f;
        if (r161 != null) goto L157;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r161 = null;
    L157:
        y5.b r162 = new y5.b(r160, r161, this.f37801p);
        this.f37797l = r162;
        v5.a r163 = (v5.a) this.M.getValue();
        AppletPopupSchemaParam r164 = this.f37798m;
        if (r164 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L161:
        r162.b(r163, r101.getHeight(), new h());
        ea0(this, false, false, 7);
        return r155;
    L160:
        r101 = r164;
        goto L161
    L65:
        if (Intrinsics.areEqual(r119.getGravity(), "start") == false) goto L68;
        if (r127 == false) goto L78;
    L68:
        if (Intrinsics.areEqual(r119.getGravity(), "end") == false) goto L72;
        if (r127 == true) goto L78;
    L72:
        if (Intrinsics.areEqual(r119.getGravity(), "right") == false) goto L74;
    L77:
        r121 = 0;
        r123 = 0;
        r124 = 0;
        goto L87
    L74:
        if (Intrinsics.areEqual(r119.getGravity(), "start") == true) goto L77;
        if (Intrinsics.areEqual(r119.getGravity(), "end") == true) goto L77;
    L84:
        r123 = 0;
    L85:
        r124 = 0;
    L79:
        if (r125 == true) goto L87;
        if (r122 == false) goto L87;
        if (Intrinsics.areEqual(r119.getGravity(), "bottom") == false) goto L84;
    L59:
        r129 = 0;
        goto L60
    L55:
        r128 = 0;
        goto L57
    L51:
        r126 = 0;
        goto L52
    L47:
        r124 = 0;
        r125 = false;
        goto L49
    L43:
        r123 = 0;
        goto L45
    L39:
        r121 = 0;
        r122 = false;
        goto L41
    L17:
        r107 = null;
        goto L18
    L13:
        r105 = "not null";
        goto L14
    }

    public static void ea0(AppletPopup r110, boolean r111, boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r111 = true;
    L5:
        int r100 = 0;
        if ((r113 & 2) == 0) goto L8;
        r112 = false;
    L8:
        int r101 = -1;
        if ((r113 & 4) == 0) goto L11;
        r100 = -1;
    L11:
        AppletPopupSchemaParam r114 = null;
        if (r100 > (-1)) goto L19;
        r110.X90();
        FragmentActivity r102 = r110.getActivity();
        AppletPopupSchemaParam r103 = r110.f37798m;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r103 = null;
    L17:
        r100 = a.c(r102, r103, r110);
    L19:
        if (r112 == false) goto L45;
        BottomSheetBehavior<LinearLayout> r115 = r110.f37800o;
        if (r115 != null) goto L23;
    L46:
        com.bytedance.ai.utils.g.f37637a.d("AppletPopup", "refreshPopupHeight. ShowHeight: " + r100);
        if (r111 == false) goto L96;
        AppletPopupSchemaParam r116 = r110.f37798m;
        if (r116 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r116 = null;
    L51:
        RadiusLayout r117 = r110.f37792g;
        if (r117 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r117 = null;
    L54:
        r110.X90();
        FragmentActivity r104 = r110.getActivity();
        Intrinsics.checkNotNullParameter(r116, "params");
        Intrinsics.checkNotNullParameter(r117, "view");
        Intrinsics.checkNotNullParameter(r110, "appletPopup");
        Integer r105 = Integer.valueOf(r100);
        if (r116.getSelfAdaptiveHeight() == true) goto L57;
        if (r105 == null) goto L61;
        int r118 = r105.intValue();
    L62:
        ViewGroup.LayoutParams r106 = r117.getLayoutParams();
        if (r118 < 0) goto L66;
        r118 = r118 + 0;
    L66:
        r106.height = r118;
        r117.requestLayout();
    L67:
        AppletPopupSchemaParam r119 = r110.f37798m;
        if (r119 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r119 = null;
    L70:
        LinearLayout r120 = r110.f37791f;
        if (r120 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r120 = null;
    L73:
        r110.X90();
        FragmentActivity r107 = r110.getActivity();
        Intrinsics.checkNotNullParameter(r119, "params");
        Intrinsics.checkNotNullParameter(r120, "view");
        Intrinsics.checkNotNullParameter(r110, "appletPopup");
        Integer r108 = Integer.valueOf(r100);
        if (r119.getSelfAdaptiveHeight() == true) goto L76;
        if (r108 == null) goto L80;
        int r121 = r108.intValue();
    L81:
        ViewGroup.LayoutParams r109 = r120.getLayoutParams();
        if (r121 < 0) goto L85;
        r121 = r121 + 0;
    L85:
        r109.height = r121;
        r120.requestLayout();
    L86:
        AppletPopupSchemaParam r122 = r110.f37798m;
        if (r122 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L91:
        if (r114.getSelfAdaptiveHeight() == true) goto L93;
        return;
    L93:
        if (r110.C == true) goto L98;
        r110.C = true;
        return;
    L98:
        return;
    L89:
        r114 = r122;
        goto L91
    L80:
        r121 = a.c(r107, r119, r110);
        goto L81
    L76:
        if (r110.C == true) goto L86;
        r120.getLayoutParams().height = -2;
        r120.requestLayout();
        goto L86
    L61:
        r118 = a.c(r104, r116, r110);
        goto L62
    L57:
        if (r110.C == true) goto L67;
        r117.getLayoutParams().height = -2;
        r117.requestLayout();
        goto L67
    L96:
        return;
    L23:
        if (r115.f37838e == true) goto L26;
        r101 = r115.f37837d;
    L26:
        if (r101 == r100) goto L46;
        if (r115 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r115 = null;
    L31:
        if (r115.D == 3) goto L36;
        BottomSheetBehavior<LinearLayout> r123 = r110.f37800o;
        if (r123 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r123 = null;
    L35:
        r123.setPeekHeight(r100);
    L40:
        if (r111 == true) goto L46;
        LinearLayout r124 = r110.f37791f;
        if (r124 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r124 = null;
    L44:
        r124.requestLayout();
        goto L46
    L36:
        BottomSheetBehavior<LinearLayout> r125 = r110.f37800o;
        if (r125 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r125 = null;
    L39:
        r125.f37856w = r100;
        goto L40
    L45:
        r110.getClass();
        goto L46
    }
}
