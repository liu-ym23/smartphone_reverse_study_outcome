package com.obric.oui.toast;

import android.app.Activity;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.DeadObjectException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUILogger;
import com.obric.oui.common.util.OUILoggerKt;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ToolsExtKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OPopupNotice.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u00020\u0001:\u0007\u001c\u001d\u001e\u001f !\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007J\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\u0001J\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice;", "", "builder", "Lcom/obric/oui/toast/OPopupNotice$Builder;", "(Lcom/obric/oui/toast/OPopupNotice$Builder;)V", "contentDescOfContentView", "", "contentView", "Landroid/view/View;", "dismissByAPI", "", "innerHeightOfPopV", "", "mTimer", "Lcom/obric/oui/toast/OPopupNotice$Timer;", "popupWindow", "Landroid/widget/PopupWindow;", "computeCountdownInterval", "", "duration", "hide", "", "reason", "Lcom/obric/oui/toast/OPopupNotice$HideReason;", "isShowing", "originImpl", "originView", "show", "Builder", "Callback", "Companion", "HideCallback", "HideReason", "PopupOutlineProvider", "Timer", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopupNotice {
    public static final Companion Companion = null;
    public static final int DEFAULT_ANCHOR_GRAVITY = 81;
    private static final int DEFAULT_CONOR_RADIUS_DP = 0;
    private static final int DEFAULT_LEFT_VIEW_SIZE_DP = 0;
    public static final long DEFAULT_SHOW_DURATION = 5000;
    public static final int DUX_BOTTOM_NOTICE_LARGE_WINDOW_WIDTH_IN_DP = 556;
    public static final int DUX_BOTTOM_NOTICE_SMALL_WINDOW_WIDTH_IN_DP = 460;
    public static final int MAX_WIDTH_IN_DP = 556;
    private static final String TAG = "OPopupNotice";
    private static WeakReference<OPopupNotice> lastPopupNoticeRef;
    private final Builder builder;
    private String contentDescOfContentView;
    private final View contentView;
    private boolean dismissByAPI;
    private int innerHeightOfPopV;
    private Timer mTimer;
    private final PopupWindow popupWindow;

    /* JADX INFO: compiled from: OPopupNotice.kt */
    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0007\u0010\u0096\u0001\u001a\u00020MJ$\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\t\b\u0002\u0010\u0090\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0097\u0001\u001a\u00020\fJ\u0011\u0010\u001c\u001a\u00020\u00002\t\b\u0001\u0010\u0098\u0001\u001a\u00020\fJ\u0011\u0010R\u001a\u00020\u00002\t\b\u0001\u0010\u0098\u0001\u001a\u00020\fJ\u0011\u0010f\u001a\u00020\u00002\t\b\u0001\u0010\u0099\u0001\u001a\u00020\fJ.\u0010m\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u00062\t\b\u0002\u0010\u0090\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0093\u0001\u001a\u00020\f2\b\b\u0002\u0010:\u001a\u00020\fJ\u0011\u0010z\u001a\u00020\u00002\t\b\u0001\u0010\u0098\u0001\u001a\u00020\fJ\u0012\u0010\u0084\u0001\u001a\u00020\u00002\t\b\u0001\u0010\u0099\u0001\u001a\u00020\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR-\u0010\u001e\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017R\u001a\u0010:\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0015\"\u0004\bI\u0010\u0017R\u001a\u0010J\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0015\"\u0004\bK\u0010\u0017R(\u0010L\u001a\u0010\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010#\"\u0004\bO\u0010%R\u001c\u0010P\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001b\"\u0004\bR\u0010\u001dR-\u0010S\u001a\u0015\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010#\"\u0004\bV\u0010%R\u001c\u0010W\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R-\u0010]\u001a\u0015\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010#\"\u0004\b`\u0010%R-\u0010a\u001a\u0015\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010#\"\u0004\bc\u0010%R\u001c\u0010d\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010Z\"\u0004\bf\u0010\\R\u001c\u0010g\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\b\"\u0004\bi\u0010\nR(\u0010k\u001a\u0004\u0018\u00010\u00062\b\u0010j\u001a\u0004\u0018\u00010\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\b\"\u0004\bm\u0010\nR-\u0010n\u001a\u0015\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010#\"\u0004\bp\u0010%R\"\u0010r\u001a\u0004\u0018\u00010M2\b\u0010q\u001a\u0004\u0018\u00010M@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bs\u0010tR(\u0010u\u001a\u0010\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010#\"\u0004\bw\u0010%R\u001c\u0010x\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u001b\"\u0004\bz\u0010\u001dR-\u0010{\u001a\u0015\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010#\"\u0004\b}\u0010%R/\u0010~\u001a\u0015\u0012\u0004\u0012\u00020\u007f\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010#\"\u0005\b\u0081\u0001\u0010%R\u001f\u0010\u0082\u0001\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010Z\"\u0005\b\u0084\u0001\u0010\\R\u0016\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020 0\u0086\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0087\u0001\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010\u0015\"\u0005\b\u0089\u0001\u0010\u0017R\u001d\u0010\u008a\u0001\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0015\"\u0005\b\u008c\u0001\u0010\u0017R\u001d\u0010\u008d\u0001\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010<\"\u0005\b\u008f\u0001\u0010>R\u001d\u0010\u0090\u0001\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010<\"\u0005\b\u0092\u0001\u0010>R\u001d\u0010\u0093\u0001\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010<\"\u0005\b\u0095\u0001\u0010>¨\u0006\u009a\u0001"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$Builder;", "", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "anchorView", "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "animationStyle", "", "getAnimationStyle", "()Ljava/lang/Integer;", "setAnimationStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "autoSwitchDayNight", "", "getAutoSwitchDayNight", "()Z", "setAutoSwitchDayNight", "(Z)V", "background", "Landroid/graphics/drawable/Drawable;", "getBackground", "()Landroid/graphics/drawable/Drawable;", "setBackground", "(Landroid/graphics/drawable/Drawable;)V", "backgroundAttrs", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "getBackgroundAttrs", "()Lkotlin/jvm/functions/Function1;", "setBackgroundAttrs", "(Lkotlin/jvm/functions/Function1;)V", "callback", "Lcom/obric/oui/toast/OPopupNotice$Callback;", "getCallback", "()Lcom/obric/oui/toast/OPopupNotice$Callback;", "setCallback", "(Lcom/obric/oui/toast/OPopupNotice$Callback;)V", "closeLastNotice", "getCloseLastNotice", "setCloseLastNotice", "getContext$OUI_standardRelease", "()Landroid/app/Activity;", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "enableAutoDismiss", "getEnableAutoDismiss", "setEnableAutoDismiss", "gravity", "getGravity", "()I", "setGravity", "(I)V", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "getHeight", "setHeight", "hideCallback", "Lcom/obric/oui/toast/OPopupNotice$HideCallback;", "getHideCallback", "()Lcom/obric/oui/toast/OPopupNotice$HideCallback;", "setHideCallback", "(Lcom/obric/oui/toast/OPopupNotice$HideCallback;)V", "isFocusable", "setFocusable", "isOutsideTouchable", "setOutsideTouchable", "leftAction", "Lcom/obric/oui/toast/OPopupNotice;", "getLeftAction", "setLeftAction", "leftIcon", "getLeftIcon", "setLeftIcon", "leftIconAttrs", "Landroid/widget/ImageView;", "getLeftIconAttrs", "setLeftIconAttrs", "leftSubTitle", "", "getLeftSubTitle", "()Ljava/lang/String;", "setLeftSubTitle", "(Ljava/lang/String;)V", "leftSubTitleAttrs", "Landroid/widget/TextView;", "getLeftSubTitleAttrs", "setLeftSubTitleAttrs", "leftTextAttrs", "getLeftTextAttrs", "setLeftTextAttrs", "leftTitle", "getLeftTitle", "setLeftTitle", "leftView", "getLeftView", "setLeftView", "value", "parentView", "getParentView", "setParentView", "popViewClickAction", "getPopViewClickAction", "setPopViewClickAction", "<set-?>", "popupNoticeDelegate", "getPopupNoticeDelegate", "()Lcom/obric/oui/toast/OPopupNotice;", "rightAction", "getRightAction", "setRightAction", "rightIcon", "getRightIcon", "setRightIcon", "rightIconAttrs", "getRightIconAttrs", "setRightIconAttrs", "rightTextAttrs", "Lcom/obric/oui/button/OButton;", "getRightTextAttrs", "setRightTextAttrs", "rightTitle", "getRightTitle", "setRightTitle", "setDefaultAnchorView", "Lkotlin/Function0;", "useButtonStyleAtEnd", "getUseButtonStyleAtEnd", "setUseButtonStyleAtEnd", "useDefaultAnchorView", "getUseDefaultAnchorView", "setUseDefaultAnchorView", MaterialConfigFormatNames.WIDTH, "getWidth", "setWidth", "xOffset", "getXOffset", "setXOffset", "yOffset", "getYOffset", "setYOffset", "build", "yOffsetBottom", "drawable", "title", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private View anchorView;
        private Integer animationStyle;
        private boolean autoSwitchDayNight;
        private Drawable background;
        private Function1<? super View, Unit> backgroundAttrs;
        private Callback callback;
        private boolean closeLastNotice;
        private final Activity context;
        private long duration;
        private boolean enableAutoDismiss;
        private int gravity;
        private int height;
        private HideCallback hideCallback;
        private boolean isFocusable;
        private boolean isOutsideTouchable;
        private Function1<? super OPopupNotice, Unit> leftAction;
        private Drawable leftIcon;
        private Function1<? super ImageView, Unit> leftIconAttrs;
        private String leftSubTitle;
        private Function1<? super TextView, Unit> leftSubTitleAttrs;
        private Function1<? super TextView, Unit> leftTextAttrs;
        private String leftTitle;
        private View leftView;
        private View parentView;
        private Function1<? super OPopupNotice, Unit> popViewClickAction;
        private OPopupNotice popupNoticeDelegate;
        private Function1<? super OPopupNotice, Unit> rightAction;
        private Drawable rightIcon;
        private Function1<? super ImageView, Unit> rightIconAttrs;
        private Function1<? super OButton, Unit> rightTextAttrs;
        private String rightTitle;
        private final Function0<Unit> setDefaultAnchorView;
        private boolean useButtonStyleAtEnd;
        private boolean useDefaultAnchorView;
        private int width;
        private int xOffset;
        private int yOffset;

        public Builder(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            this.context = r4;
            this.gravity = 81;
            this.yOffset = OUnitExtensionKt.cdp(r4, 12);
            this.duration = 5000;
            this.width = Math.min(OUnitExtensionKt.getScreenWidth(r4) - OUnitExtensionKt.cdp(r4, 16), OUnitExtensionKt.cdp(r4, 556));
            this.height = -2;
            this.enableAutoDismiss = true;
            this.animationStyle = Integer.valueOf(R.style.NoticePopupAnim);
            this.useDefaultAnchorView = true;
            this.setDefaultAnchorView = new OPopupNotice$Builder$setDefaultAnchorView$1(this);
        }

        public final Activity getContext$OUI_standardRelease() {
            return this.context;
        }

        public final Function1<OPopupNotice, Unit> getPopViewClickAction() {
            return this.popViewClickAction;
        }

        public final void setPopViewClickAction(Function1<? super OPopupNotice, Unit> r1) {
            this.popViewClickAction = r1;
        }

        public final Drawable getBackground() {
            return this.background;
        }

        public final void setBackground(Drawable r1) {
            this.background = r1;
        }

        public final Function1<View, Unit> getBackgroundAttrs() {
            return this.backgroundAttrs;
        }

        public final void setBackgroundAttrs(Function1<? super View, Unit> r1) {
            this.backgroundAttrs = r1;
        }

        public final Drawable getLeftIcon() {
            return this.leftIcon;
        }

        public final void setLeftIcon(Drawable r1) {
            this.leftIcon = r1;
        }

        public final Function1<ImageView, Unit> getLeftIconAttrs() {
            return this.leftIconAttrs;
        }

        public final void setLeftIconAttrs(Function1<? super ImageView, Unit> r1) {
            this.leftIconAttrs = r1;
        }

        public final View getLeftView() {
            return this.leftView;
        }

        public final void setLeftView(View r1) {
            this.leftView = r1;
        }

        public final String getLeftTitle() {
            return this.leftTitle;
        }

        public final void setLeftTitle(String r1) {
            this.leftTitle = r1;
        }

        public final Function1<TextView, Unit> getLeftTextAttrs() {
            return this.leftTextAttrs;
        }

        public final void setLeftTextAttrs(Function1<? super TextView, Unit> r1) {
            this.leftTextAttrs = r1;
        }

        public final String getLeftSubTitle() {
            return this.leftSubTitle;
        }

        public final void setLeftSubTitle(String r1) {
            this.leftSubTitle = r1;
        }

        public final Function1<TextView, Unit> getLeftSubTitleAttrs() {
            return this.leftSubTitleAttrs;
        }

        public final void setLeftSubTitleAttrs(Function1<? super TextView, Unit> r1) {
            this.leftSubTitleAttrs = r1;
        }

        public final Function1<OPopupNotice, Unit> getLeftAction() {
            return this.leftAction;
        }

        public final void setLeftAction(Function1<? super OPopupNotice, Unit> r1) {
            this.leftAction = r1;
        }

        public final Drawable getRightIcon() {
            return this.rightIcon;
        }

        public final void setRightIcon(Drawable r1) {
            this.rightIcon = r1;
        }

        public final Function1<ImageView, Unit> getRightIconAttrs() {
            return this.rightIconAttrs;
        }

        public final void setRightIconAttrs(Function1<? super ImageView, Unit> r1) {
            this.rightIconAttrs = r1;
        }

        public final String getRightTitle() {
            return this.rightTitle;
        }

        public final void setRightTitle(String r1) {
            this.rightTitle = r1;
        }

        public final Function1<OButton, Unit> getRightTextAttrs() {
            return this.rightTextAttrs;
        }

        public final void setRightTextAttrs(Function1<? super OButton, Unit> r1) {
            this.rightTextAttrs = r1;
        }

        public final Function1<OPopupNotice, Unit> getRightAction() {
            return this.rightAction;
        }

        public final void setRightAction(Function1<? super OPopupNotice, Unit> r1) {
            this.rightAction = r1;
        }

        public final View getAnchorView() {
            return this.anchorView;
        }

        public final void setAnchorView(View r1) {
            this.anchorView = r1;
        }

        public final View getParentView() {
            return this.parentView;
        }

        public final void setParentView(View r1) {
            this.parentView = r1;
            this.useDefaultAnchorView = false;
        }

        public final int getGravity() {
            return this.gravity;
        }

        public final void setGravity(int r1) {
            this.gravity = r1;
        }

        public final int getXOffset() {
            return this.xOffset;
        }

        public final void setXOffset(int r1) {
            this.xOffset = r1;
        }

        public final int getYOffset() {
            return this.yOffset;
        }

        public final void setYOffset(int r1) {
            this.yOffset = r1;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final void setDuration(long r1) {
            this.duration = r1;
        }

        public final Callback getCallback() {
            return this.callback;
        }

        public final void setCallback(Callback r1) {
            this.callback = r1;
        }

        public final HideCallback getHideCallback() {
            return this.hideCallback;
        }

        public final void setHideCallback(HideCallback r1) {
            this.hideCallback = r1;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setWidth(int r1) {
            this.width = r1;
        }

        public final int getHeight() {
            return this.height;
        }

        public final void setHeight(int r1) {
            this.height = r1;
        }

        public final boolean isOutsideTouchable() {
            return this.isOutsideTouchable;
        }

        public final void setOutsideTouchable(boolean r1) {
            this.isOutsideTouchable = r1;
        }

        public final boolean isFocusable() {
            return this.isFocusable;
        }

        public final void setFocusable(boolean r1) {
            this.isFocusable = r1;
        }

        public final boolean getEnableAutoDismiss() {
            return this.enableAutoDismiss;
        }

        public final void setEnableAutoDismiss(boolean r1) {
            this.enableAutoDismiss = r1;
        }

        public final boolean getUseButtonStyleAtEnd() {
            return this.useButtonStyleAtEnd;
        }

        public final void setUseButtonStyleAtEnd(boolean r1) {
            this.useButtonStyleAtEnd = r1;
        }

        public final Integer getAnimationStyle() {
            return this.animationStyle;
        }

        public final void setAnimationStyle(Integer r1) {
            this.animationStyle = r1;
        }

        public final boolean getUseDefaultAnchorView() {
            return this.useDefaultAnchorView;
        }

        public final void setUseDefaultAnchorView(boolean r1) {
            this.useDefaultAnchorView = r1;
        }

        public final boolean getAutoSwitchDayNight() {
            return this.autoSwitchDayNight;
        }

        public final void setAutoSwitchDayNight(boolean r1) {
            this.autoSwitchDayNight = r1;
        }

        public final boolean getCloseLastNotice() {
            return this.closeLastNotice;
        }

        public final void setCloseLastNotice(boolean r1) {
            this.closeLastNotice = r1;
        }

        public final Builder setBackground(int r2) {
            Drawable r3 = ContextCompat.getDrawable(getContext$OUI_standardRelease(), r2);
            if (r3 == null) goto L6;
            setBackground(r3);
        L6:
            return this;
        }

        public final Builder setLeftIcon(int r2) {
            Drawable r3 = ContextCompat.getDrawable(getContext$OUI_standardRelease(), r2);
            if (r3 == null) goto L6;
            setLeftIcon(r3);
        L6:
            return this;
        }

        public final Builder setLeftTitle(int r2) {
            setLeftTitle(getContext$OUI_standardRelease().getString(r2));
            return this;
        }

        public final Builder setRightIcon(int r2) {
            Drawable r3 = ContextCompat.getDrawable(getContext$OUI_standardRelease(), r2);
            if (r3 == null) goto L6;
            setRightIcon(r3);
        L6:
            return this;
        }

        public final Builder setRightTitle(int r2) {
            setRightTitle(getContext$OUI_standardRelease().getString(r2));
            return this;
        }

        public static /* synthetic */ Builder setParentView$default(Builder r0, View r1, int r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 2) == 0) goto L6;
            r2 = r0.xOffset;
        L6:
            if ((r5 & 4) == 0) goto L9;
            r3 = r0.yOffset;
        L9:
            if ((r5 & 8) == 0) goto L12;
            r4 = r0.gravity;
        L12:
            return r0.setParentView(r1, r2, r3, r4);
        }

        public final Builder setParentView(View r2, int r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "parentView");
            setParentView(r2);
            setXOffset(r3);
            setYOffset(r4);
            setGravity(r5);
            return this;
        }

        public static /* synthetic */ Builder setAnchorView$default(Builder r0, View r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 2) == 0) goto L6;
            r2 = r0.xOffset;
        L6:
            if ((r4 & 4) == 0) goto L9;
            r3 = r0.yOffset;
        L9:
            return r0.setAnchorView(r1, r2, r3);
        }

        public final Builder setAnchorView(View r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "anchorView");
            setAnchorView(r2);
            setXOffset(r3);
            setYOffset(r4);
            return this;
        }

        public final OPopupNotice getPopupNoticeDelegate() {
            return this.popupNoticeDelegate;
        }

        public final OPopupNotice build() {
            if (this.anchorView == null) goto L5;
        L7:
            OPopupNotice r0 = new OPopupNotice(this);
            this.popupNoticeDelegate = r0;
            return r0;
        L5:
            if (this.useDefaultAnchorView == false) goto L7;
            this.setDefaultAnchorView.invoke();
            OUILogger.INSTANCE.d(OPopupNotice.TAG, Intrinsics.stringPlus("build: anchorView is null, using defaultAnchorView=", this.anchorView));
            goto L7
        }
    }

    /* JADX INFO: compiled from: OPopupNotice.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$Callback;", "", "beforeHide", "", "obj", "Lcom/obric/oui/toast/OPopupNotice;", "beforeShow", "onHide", "onShow", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Callback {

        /* JADX INFO: compiled from: OPopupNotice.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void beforeHide(Callback r1, OPopupNotice r2) {
                Intrinsics.checkNotNullParameter(r1, "this");
                Intrinsics.checkNotNullParameter(r2, "obj");
            }

            public static void beforeShow(Callback r1, OPopupNotice r2) {
                Intrinsics.checkNotNullParameter(r1, "this");
                Intrinsics.checkNotNullParameter(r2, "obj");
            }
        }

        void beforeHide(OPopupNotice r1);

        void beforeShow(OPopupNotice r1);

        void onHide(OPopupNotice r1);

        void onShow(OPopupNotice r1);
    }

    /* JADX INFO: compiled from: OPopupNotice.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\u0018H\u0087\bø\u0001\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$Companion;", "", "()V", "DEFAULT_ANCHOR_GRAVITY", "", "DEFAULT_CONOR_RADIUS_DP", "DEFAULT_LEFT_VIEW_SIZE_DP", "DEFAULT_SHOW_DURATION", "", "DUX_BOTTOM_NOTICE_LARGE_WINDOW_WIDTH_IN_DP", "DUX_BOTTOM_NOTICE_SMALL_WINDOW_WIDTH_IN_DP", "MAX_WIDTH_IN_DP", "TAG", "", "lastPopupNoticeRef", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/toast/OPopupNotice;", "build", "context", "Landroid/app/Activity;", "builderReceiver", "Lkotlin/Function1;", "Lcom/obric/oui/toast/OPopupNotice$Builder;", "", "Lkotlin/ExtensionFunctionType;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final OPopupNotice build(Activity r1, Function1<? super Builder, Unit> r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "builderReceiver");
            Builder r0 = new Builder(r1);
            r2.invoke(r0);
            return r0.build();
        }
    }

    /* JADX INFO: compiled from: OPopupNotice.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$HideCallback;", "", "beforeHide", "", "obj", "Lcom/obric/oui/toast/OPopupNotice;", "reason", "Lcom/obric/oui/toast/OPopupNotice$HideReason;", "onHide", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface HideCallback {

        /* JADX INFO: compiled from: OPopupNotice.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void beforeHide(HideCallback r1, OPopupNotice r2, HideReason r3) {
                Intrinsics.checkNotNullParameter(r1, "this");
                Intrinsics.checkNotNullParameter(r2, "obj");
                Intrinsics.checkNotNullParameter(r3, "reason");
            }
        }

        void beforeHide(OPopupNotice r1, HideReason r2);

        void onHide(OPopupNotice r1, HideReason r2);
    }

    /* JADX INFO: compiled from: OPopupNotice.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$HideReason;", "", "(Ljava/lang/String;I)V", "HIDE_AUTO", "HIDE_MANUAL", "HIDE_CONFLICT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum HideReason extends Enum<HideReason> {
        private static final /* synthetic */ HideReason[] $VALUES = null;
        public static final HideReason HIDE_AUTO = null;
        public static final HideReason HIDE_CONFLICT = null;
        public static final HideReason HIDE_MANUAL = null;

        private static final /* synthetic */ HideReason[] $values() {
            return new HideReason[]{HIDE_AUTO, HIDE_MANUAL, HIDE_CONFLICT};
        }

        public static HideReason valueOf(String r1) {
            return (HideReason) Enum.valueOf(HideReason.class, r1);
        }

        public static HideReason[] values() {
            return (HideReason[]) $VALUES.clone();
        }

        private HideReason(String r1, int r2) {
            super(r1, r2);
        }

        static {
            HIDE_AUTO = new HideReason("HIDE_AUTO", 0);
            HIDE_MANUAL = new HideReason("HIDE_MANUAL", 1);
            HIDE_CONFLICT = new HideReason("HIDE_CONFLICT", 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: OPopupNotice.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0014\u0010\u0004\u001a\u00020\u0016*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0014\u0010\u0006\u001a\u00020\u0016*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0005H\u0002R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$PopupOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "yShift", "", "scaleX", "", "scaleY", "(Lcom/obric/oui/toast/OPopupNotice;IFF)V", "radius", "rect", "Landroid/graphics/Rect;", "getScaleX", "()F", "setScaleX", "(F)V", "getScaleY", "setScaleY", "getYShift", "()I", "setYShift", "(I)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "scale", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class PopupOutlineProvider extends ViewOutlineProvider {
        private float radius;
        private final Rect rect;
        private float scaleX;
        private float scaleY;
        final /* synthetic */ OPopupNotice this$0;
        private int yShift;

        public PopupOutlineProvider(OPopupNotice r2, int r3, float r4, float r5) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            this.yShift = r3;
            this.scaleX = r4;
            this.scaleY = r5;
            this.rect = new Rect();
            this.radius = -1.0f;
        }

        public final int getYShift() {
            return this.yShift;
        }

        public final void setYShift(int r1) {
            this.yShift = r1;
        }

        public final float getScaleX() {
            return this.scaleX;
        }

        public final void setScaleX(float r1) {
            this.scaleX = r1;
        }

        public final float getScaleY() {
            return this.scaleY;
        }

        public final void setScaleY(float r1) {
            this.scaleY = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r4, Outline r5) {
            if (this.radius != (-1.0f)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            this.radius = OUnitExtensionKt.vdpFloat(OPopupNotice.access$getContentView$p(this.this$0), OPopupNotice.access$getDEFAULT_CONOR_RADIUS_DP$cp());
        L8:
            if (r4 == null) goto L14;
            Drawable r6 = r4.getBackground();
            if (r6 == null) goto L14;
            r6.copyBounds(this.rect);
        L14:
            scaleX(this.rect, this.scaleX);
            scaleY(this.rect, this.scaleY);
            this.rect.offset(0, this.yShift);
            if (r5 == null) goto L19;
            r5.setRoundRect(this.rect, this.radius);
            return;
        L19:
            return;
        L5:
            r0 = false;
            goto L6
        }

        private final void scaleX(Rect r2, float r3) {
            if (r3 != 1.0f) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L9;
            r2.left = (int) ((r2.left * r3) + 0.5f);
            r2.right = (int) ((r2.right * r3) + 0.5f);
            return;
        L9:
            return;
        L5:
            r1 = false;
            goto L6
        }

        private final void scaleY(Rect r2, float r3) {
            if (r3 != 1.0f) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L9;
            r2.top = (int) ((r2.top * r3) + 0.5f);
            r2.bottom = (int) ((r2.bottom * r3) + 0.5f);
            return;
        L9:
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: OPopupNotice.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$Timer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/obric/oui/toast/OPopupNotice;JJ)V", "onFinish", "", "onTick", "p0", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class Timer extends CountDownTimer {
        final /* synthetic */ OPopupNotice this$0;

        @Override // android.os.CountDownTimer
        public void onTick(long r1) {
        }

        public Timer(OPopupNotice r2, long r3, long r5) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.this$0 = r2;
            super(r3, r5);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.this$0.hide(HideReason.HIDE_AUTO);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$7ZPbA6nGZEzupLKpcB3yLREbj-4, reason: not valid java name */
    public static /* synthetic */ void m737$r8$lambda$7ZPbA6nGZEzupLKpcB3yLREbj4(Function1 r0, OPopupNotice r1, View r2) {
        m741lambda17$lambda16$lambda15(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$APLx3FVtbQ1PAXWUht0sg3ZTx74(Function1 r0, OPopupNotice r1, View r2) {
        m743lambda22$lambda21$lambda20(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Mbyxy5nu22uBx9Fi3Eb_KQkL_VU(OPopupNotice r0) {
        m739_init_$lambda37(r0);
    }

    public static /* synthetic */ void $r8$lambda$cHSbve1cLWtDoeXsS4cXxQsnuR4(Function1 r0, OPopupNotice r1, View r2) {
        m742lambda2$lambda1$lambda0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$eCbYu-GAy28muk8Gc8mMWmyNn5o, reason: not valid java name */
    public static /* synthetic */ void m738$r8$lambda$eCbYuGAy28muk8Gc8mMWmyNn5o(Function1 r0, OPopupNotice r1, View r2) {
        m745lambda33$lambda32$lambda31(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$h4aSc2AhutUwgG_7GWehebrw3XM(Function1 r0, OPopupNotice r1, View r2) {
        m744lambda28$lambda27$lambda26(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$utpTkRin8Fbh_t4emvX_FKQbzeY(Function1 r0, OPopupNotice r1, View r2) {
        m740lambda12$lambda7$lambda6(r0, r1, r2);
    }

    @JvmStatic
    public static final OPopupNotice build(Activity r1, Function1<? super Builder, Unit> r2) {
        return Companion.build(r1, r2);
    }

    public final void hide() {
        hide$default(this, null, 1, null);
    }

    public OPopupNotice(Builder r9) {
        Intrinsics.checkNotNullParameter(r9, "builder");
        this.builder = r9;
        ViewGroup.MarginLayoutParams r2 = null;
        View r0 = LayoutInflater.from(r9.getContext$OUI_standardRelease()).inflate(R.layout.o_popup_notice, null);
        Intrinsics.checkNotNullExpressionValue(r0, "from(builder.context)\n  …out.o_popup_notice, null)");
        this.contentView = r0;
        this.contentDescOfContentView = "";
        View r1 = r0.findViewById(R.id.pop_view_content);
        if (r1 == null) goto L9;
        final Function1<OPopupNotice, Unit> r3 = r9.getPopViewClickAction();
        if (r3 == null) goto L9;
        r1.setOnClickListener(new OPopupNotice$$ExternalSyntheticLambda0(r3, this));
        Unit r4 = Unit.INSTANCE;
        Unit r5 = Unit.INSTANCE;
    L9:
        FrameLayout r6 = (FrameLayout) r0.findViewById(R.id.fl_left_container);
        if (r6 == null) goto L61;
        r6.removeAllViews();
        int r7 = OUnitExtensionKt.vdp(r0, DEFAULT_LEFT_VIEW_SIZE_DP);
        if (r9.getLeftView() != null) goto L27;
        ImageView r8 = new ImageView(r9.getContext$OUI_standardRelease());
        r8.setLayoutParams(new ViewGroup.LayoutParams(r7, r7));
        if (r9.getAutoSwitchDayNight() == false) goto L17;
        int r10 = R.color.TextPrimary;
    L18:
        r8.setImageTintList(ContextCompat.getColorStateList(r9.getContext$OUI_standardRelease(), r10));
        r8.setImageResource(R.drawable.ic_s_s_bell_outlined);
        Drawable r11 = r9.getLeftIcon();
        if (r11 == null) goto L22;
        r8.setImageDrawable(r11);
        Unit r12 = Unit.INSTANCE;
        Unit r13 = Unit.INSTANCE;
    L22:
        Function1<ImageView, Unit> r14 = r9.getLeftIconAttrs();
        if (r14 == null) goto L26;
        r14.invoke(r8);
        Unit r15 = Unit.INSTANCE;
        Unit r16 = Unit.INSTANCE;
    L26:
        Unit r17 = Unit.INSTANCE;
        ImageView r18 = r8;
        ViewExtensionsKt.removeFromParent(r18);
        r6.addView(r18);
    L31:
        final Function1<OPopupNotice, Unit> r19 = r9.getLeftAction();
        if (r19 == null) goto L35;
        r6.setOnClickListener(new OPopupNotice$$ExternalSyntheticLambda1(r19, this));
        Unit r20 = Unit.INSTANCE;
        Unit r21 = Unit.INSTANCE;
    L35:
        Iterator<View> r22 = ViewGroupKt.getChildren(r6).iterator();
    L37:
        if (r22.hasNext() == false) goto L44;
        View r23 = r22.next();
        if (r23.getVisibility() == 8) goto L41;
        boolean r24 = true;
    L42:
        if (r24 == false) goto L37;
    L45:
        if (r23 != null) goto L47;
        boolean r25 = true;
    L48:
        if (r25 == false) goto L50;
        FrameLayout r26 = r6;
    L51:
        if (r26 == null) goto L61;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == false) goto L56;
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r27;
    L57:
        if (r28 == null) goto L60;
        r28.setMarginStart(OUnitExtensionKt.vdp(r6, 8));
        Unit r29 = Unit.INSTANCE;
        r2 = r28;
    L60:
        r26.setLayoutParams(r2);
        Unit r30 = Unit.INSTANCE;
        goto L61
    L56:
        r28 = null;
        goto L57
    L50:
        r26 = null;
        goto L51
    L47:
        r25 = false;
        goto L48
    L41:
        r24 = false;
        goto L42
    L44:
        r23 = null;
        goto L45
    L17:
        r10 = R.color.TextReverse;
        goto L18
    L27:
        View r31 = r9.getLeftView();
        Intrinsics.checkNotNull(r31);
        if (r31.getLayoutParams() != null) goto L30;
        View r32 = r9.getLeftView();
        Intrinsics.checkNotNull(r32);
        r32.setLayoutParams(new ViewGroup.LayoutParams(r7, r7));
    L30:
        View r33 = r9.getLeftView();
        Intrinsics.checkNotNull(r33);
        ViewExtensionsKt.removeFromParent(r33);
        r6.addView(r9.getLeftView());
    L61:
        TextView r34 = (TextView) this.contentView.findViewById(R.id.tv_left);
        if (r34 != null) goto L65;
    L81:
        TextView r35 = (TextView) this.contentView.findViewById(R.id.tv_left_subtitle);
        if (r35 != null) goto L85;
    L111:
        ViewStub r36 = (ViewStub) this.contentView.findViewById(R.id.vs_right_container);
        if (r36 != null) goto L115;
    L119:
        OButton r37 = (OButton) this.contentView.findViewById(R.id.tv_right);
        if (r37 == null) goto L145;
        String r38 = this.builder.getRightTitle();
        if (r38 == null) goto L126;
        r37.setText(r38);
        Unit r39 = Unit.INSTANCE;
        Unit r40 = Unit.INSTANCE;
    L126:
        r37.setClickable(false);
        Function1<OButton, Unit> r41 = this.builder.getRightTextAttrs();
        if (r41 == null) goto L130;
        r41.invoke(r37);
        Unit r42 = Unit.INSTANCE;
        Unit r43 = Unit.INSTANCE;
    L130:
        final Function1<OPopupNotice, Unit> r44 = this.builder.getRightAction();
        if (r44 == null) goto L134;
        r37.setOnClickListener(new OPopupNotice$$ExternalSyntheticLambda4(r44, this));
        Unit r45 = Unit.INSTANCE;
        Unit r46 = Unit.INSTANCE;
    L134:
        CharSequence r47 = r37.getText();
        if (r47 != null) goto L137;
    L140:
        boolean r48 = true;
    L141:
        if (r48 == false) goto L143;
        int r49 = 8;
    L144:
        r37.setVisibility(r49);
        this.contentDescOfContentView = Intrinsics.stringPlus(this.contentDescOfContentView, r37.getText());
        Unit r50 = Unit.INSTANCE;
        Unit r51 = Unit.INSTANCE;
        goto L145
    L143:
        r49 = 0;
        goto L144
    L137:
        if (r47.length() == 0) goto L140;
        r48 = false;
    L145:
        ImageView r52 = (ImageView) this.contentView.findViewById(R.id.iv_right);
        if (r52 == null) goto L170;
        if (this.builder.getAutoSwitchDayNight() == false) goto L151;
        int r53 = R.color.TextPrimary;
    L152:
        r52.setImageTintList(ContextCompat.getColorStateList(this.builder.getContext$OUI_standardRelease(), r53));
        Drawable r54 = this.builder.getRightIcon();
        if (r54 == null) goto L156;
        r52.setImageDrawable(r54);
        Unit r55 = Unit.INSTANCE;
        Unit r56 = Unit.INSTANCE;
    L156:
        Function1<ImageView, Unit> r57 = this.builder.getRightIconAttrs();
        if (r57 == null) goto L160;
        r57.invoke(r52);
        Unit r58 = Unit.INSTANCE;
        Unit r59 = Unit.INSTANCE;
    L160:
        final Function1<OPopupNotice, Unit> r60 = this.builder.getRightAction();
        if (r60 == null) goto L165;
        r52.setOnClickListener(new OPopupNotice$$ExternalSyntheticLambda5(r60, this));
        Unit r61 = Unit.INSTANCE;
        Unit r62 = Unit.INSTANCE;
    L165:
        if (r52.getDrawable() == null) goto L167;
        int r63 = 0;
    L168:
        r52.setVisibility(r63);
        ViewExtensionsKt.expandTouchArea(r52, OUnitExtensionKt.vdp(this.contentView, 44));
        Unit r64 = Unit.INSTANCE;
        Unit r65 = Unit.INSTANCE;
        goto L170
    L167:
        r63 = 8;
        goto L168
    L151:
        r53 = R.color.TextReverse;
    L170:
        if (this.builder.getContext$OUI_standardRelease().getResources().getConfiguration().fontScale <= 1.0f) goto L172;
        new OPopupNoticeLargeFontConfig(this.builder).initConfig(this.contentView);
    L172:
        this.contentView.measure(View.MeasureSpec.makeMeasureSpec(this.builder.getWidth(), 1073741824), 0);
        int r66 = this.contentView.getMeasuredHeight();
        this.innerHeightOfPopV = r66;
        OUILoggerKt.debugLog(Intrinsics.stringPlus("OPopupNotice: check innerHeightOfPopV=", Integer.valueOf(r66)));
        PopupWindow r67 = new PopupWindow(this.contentView, this.builder.getWidth(), this.builder.getHeight());
        this.popupWindow = r67;
        r67.setOutsideTouchable(this.builder.isOutsideTouchable());
        r67.setFocusable(this.builder.isFocusable());
        if (this.builder.getAnimationStyle() == null) goto L175;
        Integer r68 = this.builder.getAnimationStyle();
        Intrinsics.checkNotNull(r68);
        r67.setAnimationStyle(r68.intValue());
    L176:
        r67.setElevation(OUnitExtensionKt.vdpFloat(this.contentView, 8));
        View r69 = this.contentView;
        GradientDrawable r70 = new GradientDrawable();
        r70.setCornerRadius(OUnitExtensionKt.vdpFloat(this.contentView, DEFAULT_CONOR_RADIUS_DP));
        if (this.builder.getAutoSwitchDayNight() == false) goto L179;
        int r71 = R.color.BGPopoverDefault;
    L180:
        r70.setColor(ContextCompat.getColorStateList(this.builder.getContext$OUI_standardRelease(), r71));
        r70.setStroke(1, ContextCompat.getColor(this.builder.getContext$OUI_standardRelease(), R.color.LineTertiary));
        Unit r72 = Unit.INSTANCE;
        r69.setBackground(r70);
        this.contentView.setOutlineProvider(new PopupOutlineProvider(this, -4, 1.0f, 0.9f));
        Drawable r73 = this.builder.getBackground();
        if (r73 == null) goto L184;
        this.contentView.setBackground(r73);
        Unit r74 = Unit.INSTANCE;
        Unit r75 = Unit.INSTANCE;
    L184:
        Function1<View, Unit> r76 = this.builder.getBackgroundAttrs();
        if (r76 == null) goto L188;
        r76.invoke(this.contentView);
        Unit r77 = Unit.INSTANCE;
        Unit r78 = Unit.INSTANCE;
    L188:
        r67.setOnDismissListener(new OPopupNotice$$ExternalSyntheticLambda6(this));
        return;
    L179:
        r71 = R.color.BGReverse;
        goto L180
    L175:
        r67.setAnimationStyle(0);
        goto L176
    L115:
        if (this.builder.getUseButtonStyleAtEnd() == false) goto L117;
        int r79 = R.layout.o_popup_notice_r_button;
    L118:
        r36.setLayoutResource(r79);
        r36.inflate();
        goto L119
    L117:
        r79 = R.layout.o_popup_notice_r_text;
        goto L118
    L85:
        if (this.builder.getAutoSwitchDayNight() == false) goto L87;
        int r80 = R.color.TextSecondary;
    L88:
        r35.setTextColor(ContextCompat.getColorStateList(this.builder.getContext$OUI_standardRelease(), r80));
        String r81 = this.builder.getLeftSubTitle();
        if (r81 == null) goto L92;
        r35.setText(r81);
        Unit r82 = Unit.INSTANCE;
        Unit r83 = Unit.INSTANCE;
    L92:
        Function1<TextView, Unit> r84 = this.builder.getLeftSubTitleAttrs();
        if (r84 == null) goto L96;
        r84.invoke(r35);
        Unit r85 = Unit.INSTANCE;
        Unit r86 = Unit.INSTANCE;
    L96:
        final Function1<OPopupNotice, Unit> r87 = this.builder.getLeftAction();
        if (r87 == null) goto L100;
        r35.setOnClickListener(new OPopupNotice$$ExternalSyntheticLambda3(r87, this));
        Unit r88 = Unit.INSTANCE;
        Unit r89 = Unit.INSTANCE;
    L100:
        CharSequence r90 = r35.getText();
        if (r90 != null) goto L103;
    L106:
        boolean r91 = true;
    L107:
        if (r91 == false) goto L109;
        int r92 = 8;
    L110:
        r35.setVisibility(r92);
        this.contentDescOfContentView = Intrinsics.stringPlus(this.contentDescOfContentView, r35.getText());
        Unit r93 = Unit.INSTANCE;
        Unit r94 = Unit.INSTANCE;
        goto L111
    L109:
        r92 = 0;
        goto L110
    L103:
        if (r90.length() == 0) goto L106;
        r91 = false;
        goto L107
    L87:
        r80 = R.color.TextReverse2;
        goto L88
    L65:
        if (this.builder.getAutoSwitchDayNight() == false) goto L67;
        int r95 = R.color.TextPrimary;
    L68:
        r34.setTextColor(ContextCompat.getColorStateList(this.builder.getContext$OUI_standardRelease(), r95));
        String r96 = this.builder.getLeftTitle();
        if (r96 == null) goto L72;
        r34.setText(r96);
        Unit r97 = Unit.INSTANCE;
        Unit r98 = Unit.INSTANCE;
    L72:
        Function1<TextView, Unit> r99 = this.builder.getLeftTextAttrs();
        if (r99 == null) goto L76;
        r99.invoke(r34);
        Unit r100 = Unit.INSTANCE;
        Unit r101 = Unit.INSTANCE;
    L76:
        final Function1<OPopupNotice, Unit> r102 = this.builder.getLeftAction();
        if (r102 == null) goto L80;
        r34.setOnClickListener(new OPopupNotice$$ExternalSyntheticLambda2(r102, this));
        Unit r103 = Unit.INSTANCE;
        Unit r104 = Unit.INSTANCE;
    L80:
        this.contentDescOfContentView = Intrinsics.stringPlus(this.contentDescOfContentView, r34.getText());
        Unit r105 = Unit.INSTANCE;
        Unit r106 = Unit.INSTANCE;
        goto L81
    L67:
        r95 = R.color.TextReverse;
        goto L68
    }

    public static final /* synthetic */ View access$getContentView$p(OPopupNotice r0) {
        return r0.contentView;
    }

    public static final /* synthetic */ int access$getDEFAULT_CONOR_RADIUS_DP$cp() {
        return DEFAULT_CONOR_RADIUS_DP;
    }

    static {
        Companion = new Companion(null);
        DEFAULT_CONOR_RADIUS_DP = 12;
        DEFAULT_LEFT_VIEW_SIZE_DP = 24;
    }

    /* JADX INFO: renamed from: lambda-2$lambda-1$lambda-0, reason: not valid java name */
    private static final void m742lambda2$lambda1$lambda0(Function1 r0, OPopupNotice r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "$it");
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r0.invoke(r1);
    }

    /* JADX INFO: renamed from: lambda-12$lambda-7$lambda-6, reason: not valid java name */
    private static final void m740lambda12$lambda7$lambda6(Function1 r0, OPopupNotice r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "$it");
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r0.invoke(r1);
    }

    /* JADX INFO: renamed from: lambda-17$lambda-16$lambda-15, reason: not valid java name */
    private static final void m741lambda17$lambda16$lambda15(Function1 r0, OPopupNotice r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "$it");
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r0.invoke(r1);
    }

    /* JADX INFO: renamed from: lambda-22$lambda-21$lambda-20, reason: not valid java name */
    private static final void m743lambda22$lambda21$lambda20(Function1 r0, OPopupNotice r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "$it");
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r0.invoke(r1);
    }

    /* JADX INFO: renamed from: lambda-28$lambda-27$lambda-26, reason: not valid java name */
    private static final void m744lambda28$lambda27$lambda26(Function1 r0, OPopupNotice r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "$it");
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r0.invoke(r1);
    }

    /* JADX INFO: renamed from: lambda-33$lambda-32$lambda-31, reason: not valid java name */
    private static final void m745lambda33$lambda32$lambda31(Function1 r0, OPopupNotice r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "$it");
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r0.invoke(r1);
    }

    /* JADX INFO: renamed from: _init_$lambda-37, reason: not valid java name */
    private static final void m739_init_$lambda37(OPopupNotice r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r2.dismissByAPI == true) goto L13;
        Callback r0 = r2.builder.getCallback();
        if (r0 == null) goto L8;
        r0.onHide(r2);
    L8:
        HideCallback r1 = r2.builder.getHideCallback();
        if (r1 == null) goto L14;
        r1.onHide(r2, HideReason.HIDE_MANUAL);
        return;
    L14:
        return;
    }

    public final OPopupNotice show() {
        if (isShowing() == false) goto L5;
    L71:
        return this;
    L5:
        if (this.builder.getDuration() <= 0) goto L71;
        View r2 = null;
        if (this.builder.getCloseLastNotice() == false) goto L22;
        WeakReference<OPopupNotice> r1 = lastPopupNoticeRef;
        if (r1 == null) goto L22;
        OPopupNotice r3 = r1.get();
        if (r3 == null) goto L22;
        if (r3.isShowing() == true) goto L19;
        r3 = null;
    L19:
        if (r3 == null) goto L22;
        r3.hide(HideReason.HIDE_CONFLICT);
    L22:
        Callback r4 = this.builder.getCallback();
        if (r4 == null) goto L27;
        r4.beforeShow(this);
    L27:
        if (this.builder.getDuration() != Long.MAX_VALUE) goto L29;
    L72:
        View r5 = this.builder.getAnchorView();     // Catch: DeadObjectException -> L62 RuntimeException -> L64
        if (r5 != null) goto L39;
        r5 = null;
    L40:
        if (r5 != null) goto L59;
        View r6 = this.builder.getParentView();     // Catch: DeadObjectException -> L62 RuntimeException -> L64
        if (r6 != null) goto L44;
        r6 = null;
    L45:
        if (r6 != null) goto L59;
        Activity r7 = this.builder.getContext$OUI_standardRelease();     // Catch: DeadObjectException -> L62 RuntimeException -> L64
        if ((r7 instanceof Activity) == true) goto L50;
        r7 = null;
    L50:
        if (r7 == null) goto L56;
        View r8 = r7.findViewById(android.R.id.content);     // Catch: DeadObjectException -> L62 RuntimeException -> L64
        if (r8 == null) goto L56;
        OUILogger.INSTANCE.d(TAG, Intrinsics.stringPlus("using anchor=", r8));     // Catch: DeadObjectException -> L62 RuntimeException -> L64
        this.popupWindow.showAtLocation(r8, this.builder.getGravity(), this.builder.getXOffset(), this.builder.getYOffset());     // Catch: DeadObjectException -> L62 RuntimeException -> L64
        r2 = r8;
    L56:
        if (r2 != null) goto L59;
        OUILogger.e$default(OUILogger.INSTANCE, TAG, "both anchorView and parentView are null", null, 4, null);     // Catch: DeadObjectException -> L62 RuntimeException -> L64
        Unit r9 = Unit.INSTANCE;     // Catch: DeadObjectException -> L62 RuntimeException -> L64
        goto L59
    L44:
        OUILogger.INSTANCE.d(TAG, Intrinsics.stringPlus("using anchor=", r6));     // Catch: DeadObjectException -> L62 RuntimeException -> L64
        this.popupWindow.showAtLocation(r6, this.builder.getGravity(), this.builder.getXOffset(), this.builder.getYOffset());     // Catch: DeadObjectException -> L62 RuntimeException -> L64
    L59:
        if (isShowing() == false) goto L67;
        lastPopupNoticeRef = new WeakReference(this);     // Catch: DeadObjectException -> L62 RuntimeException -> L64
    L67:
        this.contentView.announceForAccessibility(this.contentDescOfContentView);
        Callback r0 = this.builder.getCallback();
        if (r0 == null) goto L71;
        r0.onShow(this);
        goto L71
    L39:
        OUILogger.INSTANCE.d(TAG, Intrinsics.stringPlus("using anchor=", r5));     // Catch: DeadObjectException -> L62 RuntimeException -> L64
        this.popupWindow.showAsDropDown(r5, ((-(this.builder.getWidth() - r5.getWidth())) / 2) + this.builder.getXOffset(), (-Math.abs(this.builder.getYOffset())) - this.innerHeightOfPopV, 81);     // Catch: DeadObjectException -> L62 RuntimeException -> L64
    L62:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try DeadObjectException occur, ", e.getMessage()));
    L66:
        ToolsExtKt.printLog("OPopupNotice, showAsDropDown exception occur, try showAtLocation");
    L64:
        e = move-exception;
        ToolsExtKt.printLog(Intrinsics.stringPlus("Try runtimeException occur, ", e.getMessage()));
        goto L66
    L29:
        if (this.builder.getEnableAutoDismiss() == false) goto L72;
        Timer r10 = this.mTimer;
        if (r10 == null) goto L34;
        r10.cancel();
    L34:
        Timer r11 = new Timer(this, this.builder.getDuration(), computeCountdownInterval(this.builder.getDuration()));
        this.mTimer = r11;
        r11.start();
        goto L72
    }

    public static /* synthetic */ void hide$default(OPopupNotice r0, HideReason r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = HideReason.HIDE_MANUAL;
    L5:
        r0.hide(r1);
    }

    public final void hide(HideReason r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        if (isShowing() == true) goto L5;
        return;
    L5:
        this.dismissByAPI = true;
        Callback r0 = this.builder.getCallback();
        if (r0 == null) goto L9;
        r0.beforeHide(this);
    L9:
        HideCallback r1 = this.builder.getHideCallback();
        if (r1 == null) goto L30;
        r1.beforeHide(this, r5);
    L30:
        this.popupWindow.dismiss();     // Catch: Exception -> L15
    L17:
        Timer r2 = this.mTimer;
        if (r2 == null) goto L21;
        r2.cancel();
    L21:
        Callback r3 = this.builder.getCallback();
        if (r3 == null) goto L25;
        r3.onHide(this);
    L25:
        HideCallback r4 = this.builder.getHideCallback();
        if (r4 == null) goto L32;
        r4.onHide(this, r5);
        return;
    L32:
        return;
    L15:
        e = move-exception;
        OUILogger.INSTANCE.e(TAG, Intrinsics.stringPlus("hide: ", e.getMessage()), e);
        goto L17
    }

    public final boolean isShowing() {
        return this.popupWindow.isShowing();
    }

    public final Object originImpl() {
        return this.popupWindow;
    }

    public final View originView() {
        return this.contentView;
    }

    public final Builder builder() {
        return this.builder;
    }

    private final long computeCountdownInterval(long r5) {
        if ((r5 / ((long) 10)) != 0) goto L7;
        return 1;
    L7:
        return (long) Math.pow(10.0d, ((int) Math.log10(r5)) - 1);
    }
}
