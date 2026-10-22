package com.bytedance.applet.model.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ai.api.AppletBottomSheetAction;
import com.bytedance.ai.api.AppletBottomSheetButtonRole;
import com.bytedance.ai.api.AppletBottomSheetCancelSource;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.applet.databinding.LarusDoubaoBottomSheetDialogBinding;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import iw3.e;
import iw3.f;
import iw3.g;
import iw3.h;
import iw3.i;
import iw3.j;
import iw3.k;
import iw3.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 O2\u00020\u0001:\u0002NOB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\"\u001a\u00020\u0007*\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0014\u0010'\u001a\u00020\u0007*\u00020\u00132\u0006\u0010(\u001a\u00020)H\u0002J\f\u0010*\u001a\u00020\u0007*\u00020\u0013H\u0002J\f\u0010+\u001a\u00020\u0007*\u00020\u0013H\u0002J\u001a\u0010,\u001a\u00020\u0007*\u00020\u00132\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002J\u0018\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0002J\f\u00104\u001a\u00020\u0007*\u00020\u0013H\u0002J\b\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020\u0007H\u0016J\u0010\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020\u00072\u0006\u00108\u001a\u000209H\u0016J\b\u0010;\u001a\u00020\u0007H\u0016J\u000e\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020>J\u0010\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0006H\u0002J\u0010\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\rH\u0002J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\rH\u0002J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010E\u001a\u00020\u0007H\u0002J\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010G\u001a\u00020\u0017H\u0002J\u000e\u0010H\u001a\u0004\u0018\u00010\u0006*\u00020)H\u0002J\f\u0010I\u001a\u00020$*\u00020)H\u0002J\f\u0010J\u001a\u00020)*\u00020)H\u0002J\f\u0010K\u001a\u00020)*\u00020)H\u0002J\f\u0010L\u001a\u000203*\u000203H\u0002J\b\u0010M\u001a\u000203H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/bytedance/applet/model/bottomsheet/DoubaoBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onButtonClick", "Lkotlin/Function1;", "Lcom/bytedance/ai/api/AppletBottomSheetButtonRole;", "", "getOnButtonClick", "()Lkotlin/jvm/functions/Function1;", "setOnButtonClick", "(Lkotlin/jvm/functions/Function1;)V", "onCancelClick", "Lcom/bytedance/ai/api/AppletBottomSheetCancelSource;", "getOnCancelClick", "setOnCancelClick", "completed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "binding", "Lcom/bytedance/applet/databinding/LarusDoubaoBottomSheetDialogBinding;", "pendingCancelSource", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "updateHeaderLayout", "hasAppInfo", "", "hasAppName", "hasIcon", "bindContent", "contentHtml", "", "setupContentNestedScroll", "setupContentFade", "bindButtons", "buttons", "", "Lcom/bytedance/applet/model/bottomsheet/DoubaoBottomSheetDialogFragment$ButtonUiModel;", "createButtonView", "button", "index", "", "setupBottomInsets", "updateContentHeightLimit", WidgetCostModule.TYPE_ON_START, "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onDestroyView", "dismissWithResult", "result", "Lcom/bytedance/ai/api/AppletBottomSheetResult;", "dismissWithButtonRole", "role", "dismissWithCancelSource", "source", "resolveCancel", JSEventListener.ACTION_RESOLVE, "clearHandlers", "readButtons", "args", "toButtonRole", "hasSupportedHtmlTag", "normalizeParagraphHtml", "toPlainTextFallback", "dpToPx", "getTheme", "ButtonUiModel", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoBottomSheetDialogFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Regex f192073i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Regex f192074j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Regex f192075k = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super AppletBottomSheetButtonRole, Unit> f192076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super AppletBottomSheetCancelSource, Unit> f192077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f192078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusDoubaoBottomSheetDialogBinding f192079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppletBottomSheetCancelSource f192080h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppletBottomSheetButtonRole f192081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f192082b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f192081a == r101.f192081a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f192082b, r101.f192082b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f192081a.hashCode() * 31) + this.f192082b.hashCode();
        }

        public final String toString() {
            return "ButtonUiModel(role=" + this.f192081a + ", text=" + this.f192082b + ')';
        }

        public a(AppletBottomSheetButtonRole r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "role");
            Intrinsics.checkNotNullParameter(r101, "text");
            this.f192081a = r100;
            this.f192082b = r101;
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192083a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f192084b = null;

        static {
            int[] r100 = new int[AppletBottomSheetButtonRole.values().length];
            r100[AppletBottomSheetButtonRole.AGREE_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[AppletBottomSheetButtonRole.AGREE_SUB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[AppletBottomSheetButtonRole.REJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            f192083a = r100;
            int[] r101 = new int[AppletBottomSheetAction.values().length];
            r101[AppletBottomSheetAction.BUTTON_CLICK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r101[AppletBottomSheetAction.CANCEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            f192084b = r101;
        }
    }

    public static final class d extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f192085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BottomSheetBehavior<View> f192086b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DoubaoBottomSheetDialogFragment f192087c;

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            boolean r102 = this.f192085a;
            if (r102 == false) goto L5;
        L11:
            if (r102 == false) goto L17;
            if (r101 == 5) goto L14;
            return;
        L14:
            if (this.f192087c.f192078f.get() == true) goto L19;
            DoubaoBottomSheetDialogFragment r103 = this.f192087c;
            AppletBottomSheetCancelSource r104 = AppletBottomSheetCancelSource.GESTURE;
            r103.f192080h = r104;
            r103.T90(r104);
            DoubaoBottomSheetDialogFragment.S90(r103);
            return;
        L19:
            return;
        L17:
            return;
        L5:
            if (r101 != 1) goto L7;
        L9:
            this.f192086b.setState(3);
            return;
        L7:
            if (r101 == 4) goto L9;
            if (r101 != 5) goto L11;
            goto L9
        }

        public d(boolean r100, BottomSheetBehavior<View> r101, DoubaoBottomSheetDialogFragment r102) {
            this.f192085a = r100;
            this.f192086b = r101;
            this.f192087c = r102;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.larus_BottomSheetDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f192079g = null;
        super.onDestroyView();
    }

    static {
        RegexOption r100 = RegexOption.IGNORE_CASE;
        f192073i = new Regex("</?\\s*(p|b|a)\\b", r100);
        f192074j = new Regex("<p\\b[^>]*>", r100);
        f192075k = new Regex("</p>", r100);
    }

    public final void U90() {
        final LarusDoubaoBottomSheetDialogBinding r100 = this.f192079g;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.f191535a.getHeight();
        int r102 = r100.f191542h.getHeight();
        int r103 = r100.f191539e.getMeasuredHeight();
        if (r101 <= 0) goto L19;
        if (r102 <= 0) goto L20;
        if (r103 <= 0) goto L21;
        Resources r104 = getResources();
        Resources r105 = getResources();
        int r106 = RangesKt.coerceAtMost(r103, RangesKt.coerceAtLeast(((int) (WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).heightPixels * 0.85f)) - (r101 - r102), (int) ((72 * WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density) + 0.5f)));
        NestedScrollView r107 = r100.f191542h;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if (r108 == null) goto L18;
        FrameLayout.LayoutParams r109 = (FrameLayout.LayoutParams) r108;
        if (r109.height == r106) goto L15;
        r109.height = r106;
    L15:
        r107.setLayoutParams(r109);
        r100.f191542h.post(new j(r100));
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L21:
        return;
    L20:
        return;
    }

    public DoubaoBottomSheetDialogFragment() {
        this.f192078f = new AtomicBoolean(false);
        this.f192080h = AppletBottomSheetCancelSource.MASK;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        final boolean r100 = requireArguments().getBoolean("arg_dismiss_on_mask_tap", true);
        Dialog r101 = getDialog();
        if (r101 == null) goto L5;
        r101.setCanceledOnTouchOutside(r100);
    L5:
        Dialog r102 = getDialog();
        if (r102 == null) goto L10;
        View r103 = r102.findViewById(R.id.touch_outside);
        if (r103 == null) goto L10;
        r103.setOnClickListener(new e(this, r100));
    L10:
        Dialog r104 = getDialog();
        if (r104 == null) goto L23;
        View r105 = r104.findViewById(R.id.design_bottom_sheet);
        if (r105 == null) goto L24;
        r105.setBackgroundColor(0);
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L17
        BottomSheetBehavior r107 = BottomSheetBehavior.from(r105);     // Catch: Throwable -> L17
        r107.setState(3);     // Catch: Throwable -> L17
        r107.setSkipCollapsed(true);     // Catch: Throwable -> L17
        r107.setHideable(r100);     // Catch: Throwable -> L17
        r107.setBottomSheetCallback(new d(r100, r107, this));     // Catch: Throwable -> L17
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Result.m9448boximpl(r108);
        return;
    L17:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L24:
        return;
    }

    public static void S90(DoubaoBottomSheetDialogFragment r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void T90(AppletBottomSheetCancelSource r100) {
        if (this.f192078f.compareAndSet(false, true) == false) goto L9;
        Function1<? super AppletBottomSheetCancelSource, Unit> r101 = this.f192077e;
        if (r101 == null) goto L7;
        r101.invoke(r100);
    L7:
        this.f192076d = null;
        this.f192077e = null;
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onCancel(r100);
        T90(this.f192080h);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setCancelable(requireArguments().getBoolean("arg_dismiss_on_mask_tap", true));
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setOnKeyListener(new iw3.d(this));
        return r101;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        T90(this.f192080h);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v32, types: [iw3.f] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Bundle r100 = requireArguments();
        final LarusDoubaoBottomSheetDialogBinding r101 = this.f192079g;
        if (r101 == null) goto L151;
        String r102 = r100.getString("arg_app_name");
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        String r103 = r100.getString("arg_icon_url");
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        if ((!StringsKt.isBlank(r102)) == false) goto L13;
    L16:
        boolean r104 = true;
    L17:
        SimpleDraweeView r105 = r101.f191536b;
        int r112 = 8;
        if ((!StringsKt.isBlank(r103)) == false) goto L20;
        int r113 = 0;
    L21:
        r105.setVisibility(r113);
        TextView r106 = r101.f191537c;
        if ((!StringsKt.isBlank(r102)) == false) goto L24;
        r112 = 0;
    L24:
        r106.setVisibility(r112);
        boolean r107 = !StringsKt.isBlank(r102);
        boolean r114 = !StringsKt.isBlank(r103);
        int r115 = getResources().getDimensionPixelSize(R.dimen.dp_28);
        int r116 = getResources().getDimensionPixelSize(R.dimen.dp_9);
        int r117 = getResources().getDimensionPixelSize(R.dimen.dp_20);
        TextView r118 = r101.f191537c;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if (r119 == null) goto L150;
        ConstraintLayout.LayoutParams r108 = (ConstraintLayout.LayoutParams) r119;
        if (r114 == false) goto L29;
        r108.startToStart = -1;
        r108.startToEnd = R.id.app_icon;
        r108.topToTop = R.id.app_icon;
        r108.bottomToBottom = R.id.app_icon;
        ((ViewGroup.MarginLayoutParams) r108).topMargin = 0;
        r108.setMarginStart(r116);
        int r120 = -1;
    L30:
        r118.setLayoutParams(r108);
        TextView r109 = r101.f191543i;
        ViewGroup.LayoutParams r121 = r109.getLayoutParams();
        if (r121 == null) goto L148;
        ConstraintLayout.LayoutParams r122 = (ConstraintLayout.LayoutParams) r121;
        if (r114 == false) goto L36;
        r122.startToStart = R.id.app_icon;
        r122.topToTop = r120;
        r122.topToBottom = R.id.app_icon;
        r122.setMarginStart(0);
        ((ViewGroup.MarginLayoutParams) r122).topMargin = r117;
    L39:
        r109.setLayoutParams(r122);
        FrameLayout r123 = r101.f191541g;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
        if (r124 == null) goto L146;
        ConstraintLayout.LayoutParams r125 = (ConstraintLayout.LayoutParams) r124;
        if (r104 == false) goto L44;
        int r126 = R.id.title;
    L45:
        r125.startToStart = r126;
        if (r104 == false) goto L48;
        r115 = 0;
    L48:
        r125.setMarginStart(r115);
        r123.setLayoutParams(r125);
        r101.f191537c.setText(r102);
        if ((!StringsKt.isBlank(r103)) == false) goto L51;
        ImageLoaderKt.u(r101.f191536b, r103, "AppletBottomSheet");
    L51:
        TextView r127 = r101.f191543i;
        String r128 = r100.getString("arg_title");
        if (r128 != null) goto L54;
        r128 = "";
    L54:
        r127.setText(r128);
        String r129 = r100.getString("arg_content");
        if (r129 != null) goto L57;
        String r130 = "";
    L58:
        r101.f191539e.setOnClickListener(new m(this));
        if (f192073i.containsMatchIn(r130) == true) goto L152;
        r101.f191539e.setText(r130);
    L77:
        ViewCompat.setNestedScrollingEnabled(r101.f191542h, true);
        final ?? r131 = new f(r101);
        r101.f191542h.getViewTreeObserver().addOnScrollChangedListener(new g(r131));
        r101.f191542h.post(new h(r131));
        List r132 = r100.getStringArrayList("arg_button_roles");
        if (r132 != null) goto L80;
        r132 = CollectionsKt.emptyList();
    L80:
        Iterable r133 = r100.getStringArrayList("arg_button_texts");
        if (r133 != null) goto L83;
        r133 = CollectionsKt.emptyList();
    L83:
        ArrayList r134 = new ArrayList();
        Iterator r135 = r133.iterator();
        int r136 = 0;
    L85:
        if (r135.hasNext() == false) goto L115;
        Object r137 = r135.next();
        int r138 = r136 + 1;
        if (r136 >= 0) goto L89;
        CollectionsKt.throwIndexOverflow();
    L89:
        String r139 = (String) r137;
        String r140 = (String) CollectionsKt.getOrNull(r132, r136);
        a r141 = null;
        if (r140 == null) goto L112;
        int r142 = r140.hashCode();
        if (r142 == (-934710369)) goto L106;
        if (r142 == 974829189) goto L103;
        if (r142 == 1832567796) goto L99;
    L107:
        AppletBottomSheetButtonRole r143 = null;
    L109:
        if (r143 == null) goto L112;
        Intrinsics.checkNotNull(r139);
        r141 = new a(r143, r139);
        goto L112
    L99:
        if (r140.equals("agreeSub") == false) goto L107;
        r143 = AppletBottomSheetButtonRole.AGREE_SUB;
        goto L109
    L103:
        if (r140.equals("agreeMain") == false) goto L107;
        r143 = AppletBottomSheetButtonRole.AGREE_MAIN;
        goto L109
    L106:
        if (r140.equals("reject") == false) goto L107;
        r143 = AppletBottomSheetButtonRole.REJECT;
    L112:
        if (r141 == null) goto L114;
        r134.add(r141);
    L114:
        r136 = r138;
        goto L85
    L115:
        r101.f191538d.removeAllViews();
        Iterator r144 = r134.iterator();
        int r145 = 0;
    L117:
        if (r144.hasNext() == false) goto L144;
        Object r146 = r144.next();
        int r147 = r145 + 1;
        if (r145 >= 0) goto L121;
        CollectionsKt.throwIndexOverflow();
    L121:
        final a r148 = (a) r146;
        LinearLayout r149 = r101.f191538d;
        Context r150 = requireContext();
        int r151 = getResources().getDimensionPixelSize(R.dimen.dp_56);
        int r152 = v19.c.b(R.attr.larus_dp_16, r150, R.dimen.larus_dp_16);
        if (r145 != 0) goto L124;
        int r153 = 0;
    L125:
        AppletBottomSheetButtonRole r154 = r148.f192081a;
        int[] r155 = c.f192083a;
        int r156 = r155[r154.ordinal()];
        if (r156 == 1) goto L133;
        if (r156 == 2) goto L132;
        if (r156 == 3) goto L132;
        throw new NoWhenBranchMatchedException();
    L132:
        int r157 = R.color.neutral_transparent_1;
    L134:
        int r158 = r155[r148.f192081a.ordinal()];
        if (r158 == 1) goto L142;
        if (r158 == 2) goto L141;
        if (r158 == 3) goto L141;
        throw new NoWhenBranchMatchedException();
    L141:
        int r159 = R.color.neutral_100;
    L143:
        RoundFrameLayout r160 = new RoundFrameLayout(r150);
        LinearLayout.LayoutParams r161 = new LinearLayout.LayoutParams(-1, r151);
        r161.topMargin = r153;
        r160.setLayoutParams(r161);
        int r162 = ContextCompat.getColor(r150, r157);
        r160.getDelegate().e(r160.getResources().getDimensionPixelSize(r152));
        c29.a r163 = r160.getDelegate();
        r163.f22237s = false;
        r163.f22223e = r162;
        r163.f22225g = r162;
        r163.c();
        TextView r164 = new TextView(r150);
        r164.setGravity(17);
        r164.setMaxLines(1);
        r164.setEllipsize(TextUtils.TruncateAt.END);
        r164.setText(r148.f192082b);
        r164.setTextSize(17.0f);
        r164.setTypeface(Typeface.DEFAULT_BOLD);
        r164.setTextColor(ContextCompat.getColor(r150, r159));
        r160.addView(r164, new FrameLayout.LayoutParams(-1, -2, 17));
        e1.d(r160, new k(this, r148));
        r149.addView(r160);
        r145 = r147;
        goto L117
    L142:
        r159 = R.color.larus_static_white;
        goto L143
    L133:
        r157 = R.color.primary_50;
        goto L134
    L124:
        r153 = getResources().getDimensionPixelSize(r152);
        goto L125
    L144:
        final int r165 = getResources().getDimensionPixelSize(R.dimen.dp_20);
        ViewCompat.setOnApplyWindowInsetsListener(r101.f191535a, new i(r165, this));
        ViewCompat.requestApplyInsets(r101.f191535a);
        r101.f191535a.post(new iw3.c(this));
        return;
    L152:
        Result.Companion r166 = Result.Companion;     // Catch: Throwable -> L62
        r101.f191539e.setUrlSpannedText(f192075k.replace(f192074j.replace(StringsKt.trim(r130).toString(), ""), "<br/>"));     // Catch: Throwable -> L62
        Object r167 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L62
    L64:
        Object r168 = r167;
        if (Result.m9452exceptionOrNullimpl(r168) == null) goto L75;
        UrlSpanTextView r169 = r101.f191539e;
        Object r170 = Result.m9449constructorimpl(HtmlCompat.fromHtml(r130, 0).toString());     // Catch: Throwable -> L69
    L71:
        Object r171 = r130;
        if (Result.m9452exceptionOrNullimpl(r170) != null) goto L74;
        r171 = r170;
    L74:
        r169.setText((String) r171);
    L69:
        th = move-exception;
        Result.Companion r172 = Result.Companion;
        r170 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L75:
        Result.m9448boximpl(r168);
    L62:
        th = move-exception;
        Result.Companion r173 = Result.Companion;
        r167 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L64
    L57:
        r130 = r129;
        goto L58
    L44:
        r126 = 0;
        goto L45
    L146:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L36:
        if (r107 == false) goto L38;
        r122.startToStart = 0;
        r122.topToTop = r120;
        r122.topToBottom = R.id.app_name_view;
        r122.setMarginStart(r115);
        ((ViewGroup.MarginLayoutParams) r122).topMargin = r117;
        goto L39
    L38:
        r122.startToStart = 0;
        r122.topToBottom = r120;
        r122.topToTop = 0;
        r122.setMarginStart(r115);
        ((ViewGroup.MarginLayoutParams) r122).topMargin = r115;
        goto L39
    L148:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L29:
        r120 = -1;
        r108.startToEnd = -1;
        r108.startToStart = 0;
        r108.topToTop = 0;
        r108.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) r108).topMargin = r115;
        r108.setMarginStart(r115);
        goto L30
    L150:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L20:
        r113 = 8;
        goto L21
    L13:
        if ((!StringsKt.isBlank(r103)) == true) goto L16;
        r104 = false;
        goto L17
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_doubao_bottom_sheet_dialog, r111, false);
        int r114 = R.id.app_icon;
        SimpleDraweeView r100 = (SimpleDraweeView) ViewBindings.findChildViewById(r113, R.id.app_icon);
        if (r100 == null) goto L25;
        r114 = R.id.app_name_view;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r113, R.id.app_name_view);
        if (r101 == null) goto L25;
        r114 = R.id.button_container;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.button_container);
        if (r102 == null) goto L25;
        r114 = R.id.content;
        UrlSpanTextView r103 = (UrlSpanTextView) ViewBindings.findChildViewById(r113, R.id.content);
        if (r103 == null) goto L25;
        r114 = R.id.content_bottom_fade;
        View r104 = ViewBindings.findChildViewById(r113, R.id.content_bottom_fade);
        if (r104 == null) goto L25;
        r114 = R.id.content_container;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.content_container);
        if (r105 == null) goto L25;
        r114 = R.id.content_scroll;
        NestedScrollView r106 = (NestedScrollView) ViewBindings.findChildViewById(r113, R.id.content_scroll);
        if (r106 == null) goto L25;
        ConstraintLayout r115 = (ConstraintLayout) r113;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r113, R.id.title);
        if (r107 == null) goto L23;
        this.f192079g = new LarusDoubaoBottomSheetDialogBinding(r115, r100, r101, r102, r103, r104, r105, r106, r107);
        if (r115 == null) goto L22;
        return r115;
    L22:
        return new View(requireContext());
    L23:
        r114 = R.id.title;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
