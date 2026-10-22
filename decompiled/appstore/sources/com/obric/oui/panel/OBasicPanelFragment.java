package com.obric.oui.panel;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.f;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$style;
import com.obric.oui.panel.anim.AnimConfig;
import com.obric.oui.panel.anim.AnimController;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;
import tc.h;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002¯\u0001\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ%\u0010\r\u001a\u00020\u00042\f\b\u0001\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u0003J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b$\u0010!R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00105\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010&\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010&\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\"\u0010=\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010&\u001a\u0004\b;\u00102\"\u0004\b<\u00104R\"\u0010A\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010&\u001a\u0004\b?\u00102\"\u0004\b@\u00104R\"\u0010E\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010&\u001a\u0004\bC\u00102\"\u0004\bD\u00104R$\u0010M\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010T\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR*\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\b*\u0010X\"\u0004\bY\u0010ZR$\u0010c\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010k\u001a\u0004\u0018\u00010d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010o\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010&\u001a\u0004\bm\u00102\"\u0004\bn\u00104R\"\u0010r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010&\u001a\u0004\bp\u00102\"\u0004\bq\u00104R0\u0010z\u001a\u0010\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\u0007\u0018\u00010s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010~\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010&\u001a\u0004\b|\u00102\"\u0004\b}\u00104R&\u0010\u0081\u0001\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b\u0005\u0010O\u001a\u0004\b\u007f\u0010Q\"\u0005\b\u0080\u0001\u0010SR'\u0010\u0084\u0001\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u0006\u0010O\u001a\u0005\b\u0082\u0001\u0010Q\"\u0005\b\u0083\u0001\u0010SR%\u0010\u0087\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bC\u0010&\u001a\u0005\b\u0085\u0001\u00102\"\u0005\b\u0086\u0001\u00104R3\u0010\u0090\u0001\u001a\f\u0012\u0005\u0012\u00030\u0089\u0001\u0018\u00010\u0088\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R&\u0010\u0094\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0091\u0001\u0010&\u001a\u0005\b\u0092\u0001\u00102\"\u0005\b\u0093\u0001\u00104R+\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bp\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R%\u0010\u009e\u0001\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b?\u0010*\u001a\u0005\b\u009c\u0001\u0010,\"\u0005\b\u009d\u0001\u0010.R&\u0010 \u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010&\u001a\u0005\b\u008a\u0001\u00102\"\u0005\b\u009f\u0001\u00104R%\u0010£\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bm\u0010&\u001a\u0005\b¡\u0001\u00102\"\u0005\b¢\u0001\u00104R\u001f\u0010§\u0001\u001a\u00030¤\u00018\u0000X\u0080\u0004¢\u0006\u000f\n\u0005\b\u007f\u0010¥\u0001\u001a\u0006\b\u0091\u0001\u0010¦\u0001R,\u0010®\u0001\u001a\u0005\u0018\u00010¨\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R\u0017\u0010±\u0001\u001a\u00030¯\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bv\u0010°\u0001R,\u0010³\u0001\u001a\u0005\u0018\u00010²\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001¨\u0006¹\u0001"}, d2 = {"Lcom/obric/oui/panel/OBasicPanelFragment;", "Landroidx/appcompat/app/f;", "<init>", "()V", "", "q", "r", "", "allowingStateLoss", "tryDismissWithAnimation", "(Z)Z", "Lcom/obric/oui/panel/BottomSheetBehavior;", "behavior", "n", "(Lcom/obric/oui/panel/BottomSheetBehavior;Z)V", "dismissAfterAnimation", "", CommonKey.KEY_VALUE, "out", "o", "(FZ)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "dismiss", "dismissAllowingStateLoss", "onDismiss", "a", "Z", "waitingForDismissAllowingStateLoss", "", "b", "I", "G", "()I", "setMaxPanelHeight", "(I)V", "maxPanelHeight", "c", "N", "()Z", "setUseToneBg", "(Z)V", "useToneBg", "d", "O", "setExpandable", "isExpandable", "e", "F", "setFloatHeader", "floatHeader", "f", "w", "setBackgroundDimEnable", "backgroundDimEnable", "g", "s", "setAdaptNavBarColor", "adaptNavBarColor", "Lcom/obric/oui/panel/header/b;", "h", "Lcom/obric/oui/panel/header/b;", "L", "()Lcom/obric/oui/panel/header/b;", "setPanelHeader", "(Lcom/obric/oui/panel/header/b;)V", "panelHeader", "i", "Ljava/lang/Integer;", "H", "()Ljava/lang/Integer;", "setNavBarColor", "(Ljava/lang/Integer;)V", "navBarColor", "Lkotlin/Function0;", "j", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "setOnDialogBackPressCallback", "(Lkotlin/jvm/functions/Function0;)V", "onDialogBackPressCallback", "Landroid/content/DialogInterface$OnDismissListener;", "k", "Landroid/content/DialogInterface$OnDismissListener;", "getOnDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "setOnDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "onDismissListener", "Landroid/content/DialogInterface$OnCancelListener;", "l", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "onCancelListener", "m", FixCard.FixStyle.KEY_Y, "setClipTopCorner", "clipTopCorner", "v", "setAutoSwitchDayNight", "autoSwitchDayNight", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/jvm/functions/Function1;", "B", "()Lkotlin/jvm/functions/Function1;", "setDispatchTouchEvent", "(Lkotlin/jvm/functions/Function1;)V", "dispatchTouchEvent", "p", "M", "setRemoveMinHeight", "removeMinHeight", "z", "setCollapsedHeight", "collapsedHeight", "C", "setExpandedHeight", "expandedHeight", "D", "setFitsSystemWindows", "fitsSystemWindows", "", "Lcom/obric/oui/panel/BottomSheetBehavior$d;", "t", "Ljava/util/List;", FixCard.FixStyle.KEY_X, "()Ljava/util/List;", "setBottomSheetCallbacks", "(Ljava/util/List;)V", "bottomSheetCallbacks", "u", "E", "setFixedPanelHeight", "fixedPanelHeight", "Lcom/obric/oui/panel/anim/AnimConfig;", "Lcom/obric/oui/panel/anim/AnimConfig;", "getAnimConfig", "()Lcom/obric/oui/panel/anim/AnimConfig;", "setAnimConfig", "(Lcom/obric/oui/panel/anim/AnimConfig;)V", "animConfig", "getStyleId", "setStyleId", "styleId", "setAdaptRLSlide", "adaptRLSlide", "A", "setDisableAutoAdaptHeight", "disableAutoAdaptHeight", "Lcom/obric/oui/panel/anim/AnimController;", "Lcom/obric/oui/panel/anim/AnimController;", "()Lcom/obric/oui/panel/anim/AnimController;", "animController", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "J", "()Landroid/view/View$OnClickListener;", "setOutsideClickListener", "(Landroid/view/View$OnClickListener;)V", "outsideClickListener", "com/obric/oui/panel/OBasicPanelFragment$a", "Lcom/obric/oui/panel/OBasicPanelFragment$a;", "bottomSheetDismissCallback", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "padCompatConfig", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "K", "()Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "setPadCompatConfig", "(Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OBasicPanelFragment extends f {
    public View.OnClickListener A;
    public final a B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f15785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.obric.oui.panel.header.b f15786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f15787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0 f15788j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DialogInterface.OnDismissListener f15789k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DialogInterface.OnCancelListener f15790l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f15791m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f15792n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1 f15793o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f15794p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f15795q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f15796r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f15797s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List f15798t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f15799u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AnimConfig f15800v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f15801w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f15802x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f15803y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AnimController f15804z;

    public static final class a extends BottomSheetBehavior.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBasicPanelFragment f15805a;

        public a(OBasicPanelFragment r10) {
            this.f15805a = r10;
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public void c(View r10, float r11) {
            q.g(r10, "bottomSheet");
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public void d(View r10, int r11) {
            q.g(r10, "bottomSheet");
            if (r11 != 5) goto L6;
            OBasicPanelFragment.l(this.f15805a);
            return;
        }
    }

    public OBasicPanelFragment() {
        this.f15780b = -1;
        this.f15784f = true;
        this.f15791m = true;
        this.f15797s = true;
        this.f15801w = R$style.OBasicPanel;
        this.f15804z = new AnimController();
        this.B = new a(this);
    }

    public static final void P(OBasicPanelFragment r10, DialogInterface r11) {
        q.g(r10, "this$0");
        r10.q();
    }

    public static /* synthetic */ void k(OBasicPanelFragment r10, DialogInterface r11) {
        P(r10, r11);
    }

    public static final /* synthetic */ void l(OBasicPanelFragment r10) {
        r10.dismissAfterAnimation();
    }

    public static final /* synthetic */ void m(OBasicPanelFragment r10, float r11, boolean r12) {
        r10.o(r11, r12);
    }

    public static /* synthetic */ void p(OBasicPanelFragment r10, float r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = true;
    L6:
        r10.o(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchAnimProgress");
    }

    public final boolean A() {
        return this.f15803y;
    }

    public final Function1 B() {
        return this.f15793o;
    }

    public final Integer C() {
        return this.f15796r;
    }

    public final boolean D() {
        return this.f15797s;
    }

    public final boolean E() {
        return this.f15799u;
    }

    public final boolean F() {
        return this.f15783e;
    }

    public final int G() {
        return this.f15780b;
    }

    public final Integer H() {
        return this.f15787i;
    }

    public final Function0 I() {
        return this.f15788j;
    }

    public final View.OnClickListener J() {
        return this.A;
    }

    public final OBasicPanel$PadCompatConfig K() {
        return null;
    }

    public final com.obric.oui.panel.header.b L() {
        return this.f15786h;
    }

    public final boolean M() {
        return this.f15794p;
    }

    public final boolean N() {
        return this.f15781c;
    }

    public final boolean O() {
        return this.f15782d;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        r();     // Catch: Exception -> L5
        if (tryDismissWithAnimation(true) == true) goto L7;
        super.dismiss();     // Catch: Exception -> L5
    L7:
        Unit r10 = Unit.f21064a;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        h.a(q.p("Try exception occur ", e.getMessage()));
        Unit r11 = Unit.f21064a;
    }

    public final void dismissAfterAnimation() {
        if (this.f15779a == false) goto L5;
        super.dismissAllowingStateLoss();
        return;
    L5:
        super.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        r();
        super.dismissAllowingStateLoss();
    }

    public final void n(BottomSheetBehavior r10, boolean r11) {
        this.f15779a = r11;
        if (r10.getState() != 5) goto L6;
        dismissAfterAnimation();
        return;
    L6:
        if ((getDialog() instanceof com.obric.oui.panel.a) == false) goto L15;
        com.obric.oui.panel.a r12 = (com.obric.oui.panel.a) getDialog();
        if (r12 == null) goto L11;
        r12.removeDefaultCallback();
    L11:
        com.obric.oui.panel.a r13 = (com.obric.oui.panel.a) getDialog();
        if (r13 == null) goto L15;
        r13.g();
    L15:
        r10.e(this.B);
        r10.setState(5);
    }

    public final void o(float r10, boolean r11) {
        List r12 = this.f15798t;
        if (r12 == null) goto L12;
        Iterator r13 = r12.iterator();
    L7:
        if (r13.hasNext() == false) goto L19;
        BottomSheetBehavior.d r14 = (BottomSheetBehavior.d) r13.next();
        if (r11 == true) goto L10;
        r14.a(r10);
        goto L7
    L10:
        r14.b(r10);
        goto L7
    L19:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r10) {
        q.g(r10, "dialog");
        r();
        super.onCancel(r10);
        DialogInterface.OnCancelListener r11 = this.f15790l;
        if (r11 == null) goto L7;
        r11.onCancel(r10);
        return;
    }

    @Override // androidx.appcompat.app.f, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r10) {
        Context r11 = requireContext();
        q.f(r11, "requireContext()");
        c r12 = new c(r11, this.f15801w);
        r12.G(G());
        r12.M(N());
        r12.z(O());
        r12.F(F());
        r12.u(w());
        r12.r(s());
        r12.K(L());
        r12.H(H());
        r12.I(I());
        r12.v(y());
        r12.t(v());
        r12.y(B());
        r12.L(M());
        K();
        r12.J(null);
        r12.E(E());
        r12.setOutsideClickListener(J());
        r12.w(z());
        r12.B(C());
        r12.D(D());
        r12.s(t());
        r12.x(A());
        if (x() == null) goto L11;
        List r13 = x();
        if (r13 == null) goto L11;
        Iterator r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L11;
        r12.f((BottomSheetBehavior.d) r14.next());
    L11:
        return r12;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r10) {
        q.g(r10, "dialog");
        super.onDismiss(r10);
        DialogInterface.OnDismissListener r11 = this.f15789k;
        if (r11 == null) goto L7;
        r11.onDismiss(r10);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        Dialog r12 = getDialog();
        if (r12 == null) goto L7;
        r12.setOnShowListener(new d(this));
        return;
    }

    public final void q() {
        Dialog r10 = getDialog();
        View r11 = null;
        if (r10 == null) goto L9;
        Window r12 = r10.getWindow();
        if (r12 == null) goto L9;
        r11 = r12.getDecorView();
    L9:
        if (r11 == null) goto L18;
        AnimConfig r13 = this.f15800v;
        if (r13 == null) goto L19;
        ObjectAnimator r14 = r13.getEnterAnim(r11);
        if (r14 == null) goto L20;
        u().c(r14, new OBasicPanelFragment$exeEnterAnim$1$1(this));
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void r() {
        Dialog r10 = getDialog();
        View r11 = null;
        if (r10 == null) goto L9;
        Window r12 = r10.getWindow();
        if (r12 == null) goto L9;
        r11 = r12.getDecorView();
    L9:
        if (r11 == null) goto L18;
        AnimConfig r13 = this.f15800v;
        if (r13 == null) goto L19;
        ObjectAnimator r14 = r13.getExitAnim(r11);
        if (r14 == null) goto L20;
        u().d(r14, new OBasicPanelFragment$exeExitAnim$1$1(this));
        return;
    L20:
        return;
    L19:
        return;
    }

    public final boolean s() {
        return this.f15785g;
    }

    public final void setOnCancelListener(@Nullable DialogInterface.OnCancelListener r10) {
        this.f15790l = r10;
    }

    public final void setOnDismissListener(@Nullable DialogInterface.OnDismissListener r10) {
        this.f15789k = r10;
    }

    public final void setOutsideClickListener(@Nullable View.OnClickListener r10) {
        this.A = r10;
    }

    public final boolean t() {
        return this.f15802x;
    }

    public final boolean tryDismissWithAnimation(boolean r10) {
        Dialog r11 = getDialog();
        if ((r11 instanceof com.obric.oui.panel.a) == false) goto L10;
        com.obric.oui.panel.a r12 = (com.obric.oui.panel.a) r11;
        BottomSheetBehavior r13 = r12.h();
        q.f(r13, "dialog.behavior");
        if (r13.isHideable() == true) goto L7;
        return false;
    L7:
        if (r12.getDismissWithAnimation() == false) goto L13;
        n(r13, r10);
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public final AnimController u() {
        return this.f15804z;
    }

    public final boolean v() {
        return this.f15792n;
    }

    public final boolean w() {
        return this.f15784f;
    }

    public final List x() {
        return this.f15798t;
    }

    public final boolean y() {
        return this.f15791m;
    }

    public final Integer z() {
        return this.f15795q;
    }
}
