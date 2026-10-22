package com.obric.oui.dialog.base;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.color.j0;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.dialog.v2.alert.style.AlertDialogHost;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import com.obric.oui.view.ViewCompat;
import com.obric.oui.view.WindowInsetsCompat;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\b\u0007*\u0002\u0099\u0001\b&\u0018\u0000 \u009d\u00012\u00020\u00012\u00020\u0002:\u0003\u009e\u0001@B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u0017\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0005¢\u0006\u0004\b$\u0010\"J\u0015\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0005¢\u0006\u0004\b&\u0010\"J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010(J#\u0010*\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b*\u0010+J/\u00100\u001a\u00020\n2\u0006\u0010-\u001a\u00020,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\nH\u0014¢\u0006\u0004\b5\u0010\fJ\u000f\u00106\u001a\u00020\nH\u0014¢\u0006\u0004\b6\u0010\fJ\u000f\u00107\u001a\u00020\nH\u0016¢\u0006\u0004\b7\u0010\fJ\u000f\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010\fJ\u000f\u00108\u001a\u00020\nH\u0004¢\u0006\u0004\b8\u0010\fJ\u000f\u00109\u001a\u00020\u0012H\u0014¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0012H\u0014¢\u0006\u0004\b;\u0010:J\u000f\u0010<\u001a\u00020\u0012H\u0014¢\u0006\u0004\b<\u0010:J\u000f\u0010=\u001a\u00020\nH\u0004¢\u0006\u0004\b=\u0010\fJ\u000f\u0010>\u001a\u00020\nH\u0014¢\u0006\u0004\b>\u0010\fJ\u000f\u0010?\u001a\u00020\u0012H&¢\u0006\u0004\b?\u0010:R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010(R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\bC\u0010A\u001a\u0004\bD\u0010(R\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010AR\u0016\u0010Q\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010RR\u0016\u0010U\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010AR\"\u0010X\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010A\u001a\u0004\bV\u0010(\"\u0004\bW\u0010\"R\u0018\u0010Z\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010YR\u0018\u0010]\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010^R$\u0010c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010^\u001a\u0004\b`\u0010a\"\u0004\bb\u0010\u0019R\"\u0010g\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bd\u0010A\u001a\u0004\be\u0010(\"\u0004\bf\u0010\"R\"\u0010j\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b=\u0010A\u001a\u0004\bh\u0010(\"\u0004\bi\u0010\"R\"\u0010o\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b*\u0010k\u001a\u0004\bl\u0010:\"\u0004\bm\u0010nR\"\u0010s\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bp\u0010k\u001a\u0004\bq\u0010:\"\u0004\br\u0010nR\"\u0010w\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bt\u0010A\u001a\u0004\bu\u0010(\"\u0004\bv\u0010\"R\"\u0010z\u001a\u00020\u00058\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010A\u001a\u0004\bx\u0010(\"\u0004\by\u0010\"R\"\u0010|\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010A\u001a\u0004\b[\u0010(\"\u0004\b{\u0010\"R\u0018\u0010\u007f\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0084\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010AR\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0087\u0001R(\u0010\u0090\u0001\u001a\u00020E8\u0006@\u0006X\u0086.¢\u0006\u0017\n\u0005\b\u008b\u0001\u0010G\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R(\u0010\u0094\u0001\u001a\u00020E8\u0004@\u0004X\u0084.¢\u0006\u0017\n\u0005\b\u0091\u0001\u0010G\u001a\u0006\b\u0092\u0001\u0010\u008d\u0001\"\u0006\b\u0093\u0001\u0010\u008f\u0001R(\u0010\u0098\u0001\u001a\u00020E8\u0004@\u0004X\u0084.¢\u0006\u0017\n\u0005\b\u0095\u0001\u0010G\u001a\u0006\b\u0096\u0001\u0010\u008d\u0001\"\u0006\b\u0097\u0001\u0010\u008f\u0001R\u001a\u0010\u009c\u0001\u001a\u00030\u0099\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001¨\u0006\u009f\u0001"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialogModal;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/dialog/v2/alert/style/AlertDialogHost;", "Landroid/content/Context;", "context", "", "widthMatch", "matchParentHeight", "<init>", "(Landroid/content/Context;ZZ)V", "", "t", "()V", "Lcom/obric/oui/view/WindowInsetsCompat;", "insets", "i", "(Lcom/obric/oui/view/WindowInsetsCompat;)V", "s", "", "heightPx", "setRootFixedHeight", "(Ljava/lang/Integer;)V", "Landroid/content/DialogInterface$OnShowListener;", "listener", "setOnShowListener", "(Landroid/content/DialogInterface$OnShowListener;)V", "Landroid/content/DialogInterface$OnDismissListener;", "setOnDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "cancelable", "setCancelable", "(Z)V", "cancel", "setCanceledOnTouchOutside", "enabled", "setAutoDismiss", "isAutoDismiss", "()Z", "Landroid/view/View$OnClickListener;", "p", "(ZLandroid/view/View$OnClickListener;)V", "Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;", "style", "customIconColor", "customIconBgColor", "g", "(Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;Ljava/lang/Integer;Ljava/lang/Integer;)V", "include", "setIncludeCutoutInLandscape", "(Ljava/lang/Boolean;)V", "m", "l", "dismiss", "j", "getBaseLayoutRes", "()I", "getLayoutMarginHorizontal", "getLayoutMarginBottom", "o", "onDetachedFromWindow", "getLayout", "a", "Z", "getWidthMatch", "b", "getMatchParentHeight", "Landroid/view/View;", "c", "Landroid/view/View;", "closeIconContainer", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "closeIcon", "e", "closeIconEnabled", "f", "Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;", "closeIconStyle", "Landroid/view/View$OnClickListener;", "onCloseClickListener", "h", "autoDismissOnButtonClick", "getMCancelable", "setMCancelable", "mCancelable", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "k", "Landroid/content/DialogInterface$OnCancelListener;", "cancelListener", "Landroid/content/DialogInterface$OnShowListener;", "showListener", "getCompleteShowListener", "()Landroid/content/DialogInterface$OnShowListener;", "setCompleteShowListener", "completeShowListener", "n", "getHideFirstFrame", "setHideFirstFrame", "hideFirstFrame", "getEnableMaterial", "setEnableMaterial", "enableMaterial", "I", "getBgColor", "setBgColor", "(I)V", Style.KEY_BG_COLOR, "q", "getMaxRootViewHeightGap", "setMaxRootViewHeightGap", "maxRootViewHeightGap", "r", "getShowAnimRunning", "setShowAnimRunning", "showAnimRunning", "getUseNewDialogAnim", "setUseNewDialogAnim", "useNewDialogAnim", "setShowingModal", "isShowingModal", "u", "Ljava/lang/Integer;", "rootFixedHeightPx", "v", "Ljava/lang/Boolean;", "includeCutoutInLandscape", "w", "configurationCallbackRegistered", "Landroid/view/Window$Callback;", FixCard.FixStyle.KEY_X, "Landroid/view/Window$Callback;", "originalWindowCallback", FixCard.FixStyle.KEY_Y, "myWindowCallback", "z", "getDialogRootView", "()Landroid/view/View;", "setDialogRootView", "(Landroid/view/View;)V", "dialogRootView", "A", "getContentRootView", "setContentRootView", "contentRootView", "B", "getDimView", "setDimView", "dimView", "com/obric/oui/dialog/base/AbstractDialogModal$c", "C", "Lcom/obric/oui/dialog/base/AbstractDialogModal$c;", "configurationCallback", "D", "CloseIconStyle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractDialogModal extends FrameLayout implements AlertDialogHost {
    public static final a D = null;
    public View A;
    public View B;
    public c C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f14393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f14394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CloseIconStyle f14396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f14397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DialogInterface.OnDismissListener f14400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DialogInterface.OnCancelListener f14401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DialogInterface.OnShowListener f14402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DialogInterface.OnShowListener f14403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14404n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14405o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14406p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14407q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f14408r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f14409s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f14410t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f14411u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Boolean f14412v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f14413w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Window.Callback f14414x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Window.Callback f14415y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f14416z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialogModal$CloseIconStyle;", "", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "CUSTOM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
        private static final /* synthetic */ CloseIconStyle[] $VALUES = null;
        public static final CloseIconStyle CUSTOM = null;
        public static final CloseIconStyle DARK = null;
        public static final CloseIconStyle LIGHT = null;

        private static final /* synthetic */ CloseIconStyle[] $values() {
            return new CloseIconStyle[]{LIGHT, DARK, CUSTOM};
        }

        static {
            LIGHT = new CloseIconStyle("LIGHT", 0);
            DARK = new CloseIconStyle("DARK", 1);
            CUSTOM = new CloseIconStyle("CUSTOM", 2);
            $VALUES = $values();
        }

        private CloseIconStyle(String r10, int r11) {
            super(r10, r11);
        }

        public static CloseIconStyle valueOf(String r10) {
            return (CloseIconStyle) Enum.valueOf(CloseIconStyle.class, r10);
        }

        public static CloseIconStyle[] values() {
            return (CloseIconStyle[]) $VALUES.clone();
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14417a = null;

        static {
            int[] r10 = new int[CloseIconStyle.values().length];
            r10[CloseIconStyle.DARK.ordinal()] = 1;
            r10[CloseIconStyle.LIGHT.ordinal()] = 2;
            r10[CloseIconStyle.CUSTOM.ordinal()] = 3;
            f14417a = r10;
        }
    }

    public static final class c implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractDialogModal f14418a;

        public c(AbstractDialogModal r10) {
            this.f14418a = r10;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration r10) {
            q.g(r10, "newConfig");
            if (this.f14418a.k() == false) goto L6;
            AbstractDialogModal.f(this.f14418a);
            this.f14418a.requestApplyInsets();
            return;
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    static {
        D = new a(null);
    }

    public AbstractDialogModal(Context r10, boolean r11, boolean r12) {
        q.g(r10, "context");
        super(r10);
        this.f14391a = r11;
        this.f14392b = r12;
        this.f14396f = CloseIconStyle.DARK;
        this.f14398h = true;
        this.f14399i = true;
        this.f14407q = -1;
        this.f14409s = true;
        this.C = new c(this);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(true);
        setFocusable(true);
        setVisibility(8);
        View r13 = new View(r10);
        r13.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r13.setBackgroundColor(-16777216);
        r13.setAlpha(0.0f);
        r13.setVisibility(8);
        setDimView(r13);
        addView(getDimView());
        View r14 = LayoutInflater.from(r10).inflate(getBaseLayoutRes(), this, false);
        q.f(r14, "from(context).inflate(ge…LayoutRes(), this, false)");
        setDialogRootView(r14);
        addView(getDialogRootView());
        if ((getDialogRootView().getBackground() instanceof ColorDrawable) == false) goto L10;
        Drawable r15 = getDialogRootView().getBackground();
        if (r15 == null) goto L8;
        this.f14406p = ((ColorDrawable) r15).getColor();
    L20:
        getDialogRootView().setAlpha(0.0f);
        this.f14394d = (ImageView) findViewById(R$id.btn_close);
        this.f14393c = findViewById(R$id.close_container);
        if (r12 == false) goto L23;
        View r16 = getDialogRootView();
        ViewGroup.LayoutParams r17 = getDialogRootView().getLayoutParams();
        r17.height = -1;
        r16.setLayoutParams(r17);
    L23:
        q(this, this.f14395e, null, 2, null);
        ViewStub r18 = (ViewStub) findViewById(R$id.contentView);
        r18.setLayoutResource(getLayout());
        View r19 = r18.inflate();
        q.f(r19, "viewStub.inflate()");
        setContentRootView(r19);
        DialogAnimStyle.f14342a.c(getDialogRootView());
        if (o.e(r10) == true) goto L26;
    L28:
        boolean r110 = false;
    L29:
        this.f14405o = r110;
        if (r110 == false) goto L41;
        getDialogRootView().setBackgroundColor(0);
        com.obric.oui.material.b[] r111 = MaterialToken.OUI_Bg_Modal.invoke(Boolean.valueOf(!td.i.a(getDialogRootView())));
        o.j(getDialogRootView(), r111, false, 0, null, 14, null);
        if (OMaterialHelper.q(r10) != 1) goto L34;
    L35:
        j0 r112 = r111[0].j();
        if (r112 == null) goto L41;
        if ((getDialogRootView() instanceof DialogRootView) == false) goto L41;
        ((DialogRootView) getDialogRootView()).d(r112.b(), tc.f.a(r10, r112.c()));
        goto L41
    L34:
        if (r111.length == 1) goto L35;
    L41:
        ViewCompat.b(this, new j(this));
        return;
    L26:
        if (OMaterialHelper.w() == false) goto L28;
        r110 = true;
        goto L29
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
    L10:
        if ((getDialogRootView().getBackground() instanceof GradientDrawable) == false) goto L20;
        Drawable r20 = getDialogRootView().getBackground();
        if (r20 == null) goto L19;
        ColorStateList r21 = ((GradientDrawable) r20).getColor();
        if (r21 != null) goto L16;
        int r22 = 0;
    L17:
        this.f14406p = r22;
        goto L20
    L16:
        r22 = r21.getDefaultColor();
        goto L17
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    public static /* synthetic */ WindowInsetsCompat a(AbstractDialogModal r10, View r11, WindowInsetsCompat r12) {
        return e(r10, r11, r12);
    }

    public static /* synthetic */ void b(AbstractDialogModal r10, View r11) {
        r(r10, r11);
    }

    public static /* synthetic */ void c(AbstractDialogModal r10) {
        u(r10);
    }

    public static /* synthetic */ void d(AbstractDialogModal r10) {
        n(r10);
    }

    public static final WindowInsetsCompat e(AbstractDialogModal r10, View r11, WindowInsetsCompat r12) {
        q.g(r10, "this$0");
        q.f(r12, "insets");
        r10.i(r12);
        return r12;
    }

    public static final /* synthetic */ void f(AbstractDialogModal r10) {
        r10.t();
    }

    public static /* synthetic */ void h(AbstractDialogModal r10, CloseIconStyle r11, Integer r12, Integer r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = null;
    L7:
        if ((r14 & 4) == 0) goto L9;
        r13 = null;
    L9:
        r10.g(r11, r12, r13);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyCloseIconStyle");
    }

    public static final void n(AbstractDialogModal r10) {
        q.g(r10, "this$0");
        tc.l.k(r10.getDimView());
    }

    public static /* synthetic */ void q(AbstractDialogModal r10, boolean r11, View.OnClickListener r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        r10.p(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCloseIconEnabled");
    }

    public static final void r(AbstractDialogModal r10, View r11) {
        q.g(r10, "this$0");
        r10.dismiss();
        View.OnClickListener r12 = r10.f14397g;
        if (r12 == null) goto L7;
        r12.onClick(r11);
        return;
    }

    public static final void u(AbstractDialogModal r10) {
        q.g(r10, "this$0");
        Size r11 = wd.a.c(r10.getContext());
        ViewGroup.LayoutParams r12 = r10.getDialogRootView().getLayoutParams();
        if ((r12 instanceof FrameLayout.LayoutParams) == false) goto L5;
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12;
    L6:
        int r14 = -2;
        if (r13 != null) goto L10;
        r13 = new FrameLayout.LayoutParams(-2, -2);
    L10:
        if (r10.f14392b == false) goto L17;
        if (r10.f14391a == false) goto L14;
        int r15 = -1;
    L15:
        r13.width = r15;
        r13.height = -1;
        r13.gravity = 17;
        r13.bottomMargin = 0;
    L32:
        r10.getDialogRootView().setLayoutParams(r13);
        return;
    L14:
        r15 = r13.width;
        goto L15
    L17:
        if (r10.f14391a == false) goto L25;
        r13.width = -1;
        Integer r16 = r10.f14411u;
        if (r16 == null) goto L22;
        r14 = r16.intValue();
    L22:
        r13.height = r14;
        r13.gravity = 80;
        r13.bottomMargin = 0;
        if ((r10.getDialogRootView() instanceof DialogRootView) == false) goto L32;
        float r17 = r10.getContext().getResources().getDimension(R$dimen.oui_r_l3);
        ((DialogRootView) r10.getDialogRootView()).c(r17, r17, 0.0f, 0.0f);
        goto L32
    L25:
        int r18 = Math.min(r11.getWidth(), r11.getHeight()) - (r10.getLayoutMarginHorizontal() * 2);
        r13.width = r18;
        Integer r19 = r10.f14411u;
        if (r19 == null) goto L29;
        r14 = r19.intValue();
    L29:
        r13.height = r14;
        r13.gravity = 81;
        r10.getDialogRootView().measure(View.MeasureSpec.makeMeasureSpec(r18, Integer.MIN_VALUE), 0);
        if (r11.getWidth() >= r11.getHeight()) goto L32;
        int r20 = r11.getHeight();
        Context r21 = r10.getContext();
        q.f(r21, "context");
        r10.f14407q = Math.max(0, r10.getDialogRootView().getMeasuredHeight() - (r20 - tc.f.b(r21, 232)));
        goto L32
    L5:
        r13 = null;
        goto L6
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        if (this.f14399i == true) goto L5;
        return;
    L5:
        DialogInterface.OnCancelListener r10 = this.f14401k;
        if (r10 == null) goto L9;
        r10.onCancel(this);
    L9:
        dismiss();
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        if (this.f14410t == true) goto L5;
        return;
    L5:
        o();
        m();
    }

    public final void g(CloseIconStyle r10, Integer r11, Integer r12) {
        q.g(r10, "style");
        this.f14396f = r10;
        if (this.f14395e == true) goto L5;
        return;
    L5:
        int r13 = b.f14417a[r10.ordinal()];
        if (r13 != 1) goto L8;
        int r14 = R$color.ConstTextInverse;
        r12 = Integer.valueOf(R$color.ConstBGContainer7);
    L18:
        ImageView r15 = this.f14394d;
        if (r15 == null) goto L22;
        r15.setImageTintList(ContextCompat.c(getContext(), r14));
    L22:
        GradientDrawable r16 = null;
        if (r12 != null) goto L28;
        View r17 = this.f14393c;
        if (r17 == null) goto L40;
        r17.setBackground(null);
        return;
    L40:
        return;
    L28:
        View r18 = this.f14393c;
        if (r18 != null) goto L31;
        Drawable r19 = null;
    L33:
        if ((r19 instanceof GradientDrawable) == false) goto L35;
        r16 = (GradientDrawable) r19;
    L35:
        if (r16 == null) goto L41;
        r16.setColor(ContextCompat.c(getContext(), r12.intValue()));
        return;
    L41:
        return;
    L31:
        r19 = r18.getBackground();
        goto L33
    L8:
        if (r13 != 2) goto L10;
        r14 = R$color.TextReverse;
        r12 = Integer.valueOf(R$color.ConstTextInverse5);
        goto L18
    L10:
        if (r13 != 3) goto L15;
        if (r11 != null) goto L13;
        r14 = R$color.ConstTextInverse;
        goto L18
    L13:
        r14 = r11.intValue();
        goto L18
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public int getBaseLayoutRes() {
        if (this.f14392b == false) goto L6;
        return R$layout.o_base_dialog_with_match_parent_height;
    L6:
        return R$layout.o_base_dialog;
    }

    public final int getBgColor() {
        return this.f14406p;
    }

    @Nullable
    public final DialogInterface.OnShowListener getCompleteShowListener() {
        return this.f14403m;
    }

    @NotNull
    public final View getContentRootView() {
        View r10 = this.A;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("contentRootView");
        return null;
    }

    @NotNull
    public final View getDialogRootView() {
        View r10 = this.f14416z;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("dialogRootView");
        return null;
    }

    @NotNull
    public final View getDimView() {
        View r10 = this.B;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("dimView");
        return null;
    }

    public final boolean getEnableMaterial() {
        return this.f14405o;
    }

    public final boolean getHideFirstFrame() {
        return this.f14404n;
    }

    public abstract int getLayout();

    public int getLayoutMarginBottom() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.oui_dialog_layout_margin);
    }

    public int getLayoutMarginHorizontal() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.oui_dialog_layout_margin);
    }

    public final boolean getMCancelable() {
        return this.f14399i;
    }

    public final boolean getMatchParentHeight() {
        return this.f14392b;
    }

    public final int getMaxRootViewHeightGap() {
        return this.f14407q;
    }

    public final boolean getShowAnimRunning() {
        return this.f14408r;
    }

    public boolean getUseNewDialogAnim() {
        return this.f14409s;
    }

    public final boolean getWidthMatch() {
        return this.f14391a;
    }

    public final void i(WindowInsetsCompat r10) {
        Context r11 = getContext();
        q.f(r11, "context");
        boolean r12 = wd.a.k(r11);
        int r13 = r10.f(WindowInsetsCompat.Type.a()).f25230d;
        wd.a r14 = wd.a.f25402a;
        Context r15 = getContext();
        q.f(r15, "context");
        boolean r16 = r14.n(r15);
        Context r17 = getContext();
        q.f(r17, "context");
        boolean r18 = r14.m(r17);
        int r19 = 0;
        if (r18 == true) goto L7;
        if (r16 == true) goto L7;
        int r20 = r14.f(getContext());
    L8:
        ViewGroup.LayoutParams r21 = getDialogRootView().getLayoutParams();
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
    L12:
        if (r22 != null) goto L15;
        return;
    L15:
        if (this.f14391a == false) goto L17;
        r22.bottomMargin = 0;
        getDialogRootView().setLayoutParams(r22);
        getDialogRootView().setTranslationY(0.0f);
        getDialogRootView().setPadding(getDialogRootView().getPaddingLeft(), getDialogRootView().getPaddingTop(), getDialogRootView().getPaddingRight(), r13);
        return;
    L17:
        if (r12 == false) goto L19;
        r20 = 0;
    L19:
        int r23 = getLayoutMarginBottom();
        if (r13 <= 0) goto L22;
        int r24 = 0;
    L23:
        int r25 = r23 + r24;
        if (r22.bottomMargin == r25) goto L26;
        r22.bottomMargin = r25;
        getDialogRootView().setLayoutParams(r22);
    L26:
        if (r13 <= 0) goto L28;
        r19 = Math.max(0, r13 - r20);
    L28:
        getDialogRootView().setTranslationY(-r19);
        return;
    L22:
        r24 = r20;
        goto L23
    L11:
        r22 = null;
    L7:
        r20 = 0;
        goto L8
    }

    @Override // com.obric.oui.dialog.v2.alert.style.AlertDialogHost
    public boolean isAutoDismiss() {
        return this.f14398h;
    }

    public final void j() {
        this.f14408r = false;
        DialogInterface.OnShowListener r10 = this.f14403m;
        if (r10 == null) goto L7;
        r10.onShow(this);
        return;
    }

    public final boolean k() {
        return this.f14410t;
    }

    public void l() {
        if (this.f14410t == true) goto L5;
        return;
    L5:
        this.f14410t = false;
        this.f14408r = false;
        o();
        s();
        DialogInterface.OnDismissListener r10 = this.f14400j;
        if (r10 == null) goto L9;
        r10.onDismiss(this);
    L9:
        ViewParent r11 = getParent();
        if ((r11 instanceof ViewGroup) == false) goto L12;
        ViewGroup r12 = (ViewGroup) r11;
    L13:
        if (r12 == null) goto L16;
        r12.removeView(this);
    L16:
        setVisibility(8);
        getDimView().setAlpha(0.0f);
        getDialogRootView().setAlpha(1.0f);
        getDialogRootView().setTranslationX(0.0f);
        getDialogRootView().setTranslationY(0.0f);
        return;
    L12:
        r12 = null;
        goto L13
    }

    public void m() {
        getDimView().animate().alpha(0.0f).setDuration(180).withEndAction(new k(this)).start();
        ViewPropertySpringAnimator r10 = DialogAnimStyle.f14342a.f(getDialogRootView(), null, false, getUseNewDialogAnim());
        ViewPropertySpringAnimator.o(r10, null, new AbstractDialogModal$performExitAnimation$2$1(this), new AbstractDialogModal$performExitAnimation$2$2(this), 1, null);
        r10.q();
    }

    public final void o() {
        wd.a r10 = wd.a.f25402a;
        Context r11 = getContext();
        q.f(r11, "context");
        Activity r12 = r10.b(r11);
        if (r12 != null) goto L5;
        return;
    L5:
        Window.Callback r13 = this.f14414x;
        if (r13 != null) goto L9;
        return;
    L9:
        if (r12.getWindow().getCallback() != this.f14415y) goto L11;
        r12.getWindow().setCallback(r13);
    L11:
        this.f14415y = null;
        this.f14414x = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
        s();
    }

    public void p(boolean r10, View.OnClickListener r11) {
        this.f14395e = r10;
        this.f14397g = r11;
        ImageView r12 = this.f14394d;
        if (r12 == null) goto L21;
        Context r13 = getContext();
        q.f(r13, "context");
        tc.l.c(r12, tc.f.b(r13, 44));
        if (r10 == false) goto L15;
        View r14 = this.f14393c;
        if (r14 == null) goto L11;
        tc.l.m(r14);
    L11:
        h(this, this.f14396f, null, null, 6, null);
        View r15 = this.f14393c;
        if (r15 == null) goto L22;
        r15.setOnClickListener(new l(this));
        return;
    L22:
        return;
    L15:
        View r16 = this.f14393c;
        if (r16 == null) goto L23;
        tc.l.k(r16);
        return;
    L23:
        return;
    }

    public final void s() {
        if (this.f14413w == true) goto L5;
        return;
    L5:
        getContext().unregisterComponentCallbacks(this.C);
        this.f14413w = false;
    }

    public final void setAutoDismiss(boolean r10) {
        this.f14398h = r10;
    }

    public final void setBgColor(int r10) {
        this.f14406p = r10;
    }

    public void setCancelable(boolean r10) {
        this.f14399i = r10;
    }

    public final void setCanceledOnTouchOutside(boolean r10) {
        setCancelable(r10);
    }

    public final void setCompleteShowListener(@Nullable DialogInterface.OnShowListener r10) {
        this.f14403m = r10;
    }

    public final void setContentRootView(@NotNull View r10) {
        q.g(r10, "<set-?>");
        this.A = r10;
    }

    public final void setDialogRootView(@NotNull View r10) {
        q.g(r10, "<set-?>");
        this.f14416z = r10;
    }

    public final void setDimView(@NotNull View r10) {
        q.g(r10, "<set-?>");
        this.B = r10;
    }

    public final void setEnableMaterial(boolean r10) {
        this.f14405o = r10;
    }

    public final void setHideFirstFrame(boolean r10) {
        this.f14404n = r10;
    }

    public final void setIncludeCutoutInLandscape(@Nullable Boolean r10) {
        this.f14412v = r10;
    }

    public final void setMCancelable(boolean r10) {
        this.f14399i = r10;
    }

    public final void setMaxRootViewHeightGap(int r10) {
        this.f14407q = r10;
    }

    public final void setOnCancelListener(@Nullable DialogInterface.OnCancelListener r10) {
        this.f14401k = r10;
    }

    public final void setOnDismissListener(@Nullable DialogInterface.OnDismissListener r10) {
        this.f14400j = r10;
    }

    public final void setOnShowListener(@Nullable DialogInterface.OnShowListener r10) {
        this.f14402l = r10;
    }

    public final void setRootFixedHeight(@Nullable Integer r10) {
        if (r10 != null) goto L6;
    L4:
        r10 = null;
    L7:
        this.f14411u = r10;
        return;
    L6:
        if (r10.intValue() <= 0) goto L4;
        goto L4
    }

    public final void setShowAnimRunning(boolean r10) {
        this.f14408r = r10;
    }

    public final void setShowingModal(boolean r10) {
        this.f14410t = r10;
    }

    public void setUseNewDialogAnim(boolean r10) {
        this.f14409s = r10;
    }

    public final void t() {
        getDialogRootView().post(new m(this));
    }
}
