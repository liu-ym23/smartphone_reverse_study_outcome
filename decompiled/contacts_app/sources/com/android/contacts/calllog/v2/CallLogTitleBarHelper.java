package com.android.contacts.calllog.v2;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import bytedanceos.util.MultiSimAdapter;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.calllog.blocked.repo.BlockedDataRequester;
import com.android.contacts.util.Constants;
import com.android.contacts.widget.SelectAllState;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.ui.OFloatingTitleBarHolder;
import com.obric.ui.popover.Direct;
import com.obric.ui.popover.ItemType;
import com.obric.ui.popover.MenuItemData;
import com.obric.ui.popover.OUIPopoverHelper;
import com.obric.utils.NewContactsTraceLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import obric.app.tracker.Agent;

/* JADX INFO: compiled from: CallLogTitleBarHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 32\u00020\u0001:\u00013BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bJ\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0012H\u0002J\u000e\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u001fJ\u000e\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u000eJ\b\u0010-\u001a\u00020\bH\u0002J\b\u0010.\u001a\u00020\bH\u0002J\b\u0010/\u001a\u00020\bH\u0002J\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020\bJ\u0006\u00102\u001a\u00020\bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogTitleBarHelper;", "", "fragment", "Landroidx/fragment/app/Fragment;", "viewModel", "Lcom/android/contacts/calllog/v2/CallLogViewModel;", "onStartEdit", "Lkotlin/Function0;", "", "onExitEdit", "onSelectAll", "onTabSwitching", "(Landroidx/fragment/app/Fragment;Lcom/android/contacts/calllog/v2/CallLogViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "btnEdit", "Landroid/view/View;", "callLogTitleView", "Lcom/obric/oui/text/OTextView;", "currentTabIndex", "", "popover", "Lcom/obric/oui/popover/v2/OPopover;", "selectAllState", "Lcom/android/contacts/widget/SelectAllState;", "tabCenterView", "tabLayout", "Lcom/obric/oui/tab/OTabLayout;", "titleBarHolder", "Lcom/obric/ui/OFloatingTitleBarHolder;", "buildBlockedCallMenuItem", "Lcom/obric/ui/popover/MenuItemData;", "isBlockedCallAddStatus", "", "destroy", "dismissPopover", "onClickMenu", "clickView", "onTabSwitch", "pos", "renderEditMode", "editState", "Lcom/android/contacts/calllog/v2/EditModeState;", "setEditEnabled", "enabled", "setup", "view", "setupEditState", "setupNormalState", "setupTabLayout", "switchToEditState", "switchToNormalState", "updateCallLogFilter", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogTitleBarHelper {
    public static final Companion Companion = null;
    private static final boolean FEATURE_CMCC_CU = false;
    private static final int TAB_INDEX_ALL = 0;
    private static final int TAB_INDEX_SIM1_OR_MISSED = 1;
    private static final int TAB_INDEX_SIM2 = 2;
    private static final String TAG = "CallLogV2";
    private View btnEdit;
    private OTextView callLogTitleView;
    private int currentTabIndex;
    private final Fragment fragment;
    private final Function0<Unit> onExitEdit;
    private final Function0<Unit> onSelectAll;
    private final Function0<Unit> onStartEdit;
    private final Function0<Unit> onTabSwitching;
    private OPopover popover;
    private SelectAllState selectAllState;
    private View tabCenterView;
    private OTabLayout tabLayout;
    private OFloatingTitleBarHolder titleBarHolder;
    private final CallLogViewModel viewModel;

    /* JADX INFO: compiled from: CallLogTitleBarHelper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogTitleBarHelper$Companion;", "", "()V", "FEATURE_CMCC_CU", "", "getFEATURE_CMCC_CU$app_QssiCnRelease", "()Z", "TAB_INDEX_ALL", "", "TAB_INDEX_SIM1_OR_MISSED", "TAB_INDEX_SIM2", "TAG", "", "hasMultiSimInDevice", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final boolean getFEATURE_CMCC_CU$app_QssiCnRelease() {
            return CallLogTitleBarHelper.access$getFEATURE_CMCC_CU$cp();
        }

        public final boolean hasMultiSimInDevice() {
            if (MultiSimAdapter.isMultiSimEnabled() == true) goto L5;
            return false;
        L5:
            if (MultiSimAdapter.hasIccCard(0) == true) goto L7;
            return false;
        L7:
            if (MultiSimAdapter.hasIccCard(1) == true) goto L9;
            return false;
        L9:
            return true;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.CallLogTitleBarHelper$onClickMenu$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CallLogTitleBarHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogTitleBarHelper$onClickMenu$1", f = "CallLogTitleBarHelper.kt", i = {0}, l = {HttpStatus.SC_MULTI_STATUS}, m = "invokeSuspend", n = {"items"}, s = {"L$0"})
    static final class C01711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $act;
        final /* synthetic */ View $clickView;
        Object L$0;
        int label;
        final /* synthetic */ CallLogTitleBarHelper this$0;

        C01711(FragmentActivity r1, CallLogTitleBarHelper r2, View r3, Continuation<? super C01711> r4) {
            this.$act = r1;
            this.this$0 = r2;
            this.$clickView = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01711(this.$act, this.this$0, this.$clickView, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01711) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ArrayList r3 = (ArrayList) this.L$0;
            ResultKt.throwOnFailure(r18);
            Object r4 = r18;
        L12:
            boolean r5 = ((Boolean) r4).booleanValue();
            r3.add(CallLogTitleBarHelper.access$buildBlockedCallMenuItem(this.this$0, r5));
            ItemType r6 = ItemType.TEXT;
            Integer r7 = Boxing.boxInt(R.drawable.menu_item_settings_icon);
            String r8 = CallLogTitleBarHelper.access$getFragment$p(this.this$0).getString(R.string.common_settings);
            final CallLogTitleBarHelper r13 = this.this$0;
            r3.add(new MenuItemData(r6, r7, null, null, r8, null, null, null, null, new C00211(r13), false, 1024, null));
            CallLogTitleBarHelper.access$setPopover$p(this.this$0, OUIPopoverHelper.genPopover$default(this.$act, r3, false, 4, null));
            FragmentActivity r9 = this.$act;
            OPopover r10 = CallLogTitleBarHelper.access$getPopover$p(this.this$0);
            Intrinsics.checkNotNull(r10);
            OUIPopoverHelper.showPopupAtAnchorView(r9, r10, Direct.BOTTOM_LEFT, this.$clickView, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r18);
            ArrayList r11 = new ArrayList();
            BlockedDataRequester r12 = BlockedDataRequester.INSTANCE;
            ContentResolver r14 = this.$act.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(r14, "act.contentResolver");
            this.L$0 = r11;
            this.label = 1;
            r4 = r12.queryBlockedCallAddStatusAsync(r14, this);
            if (r4 != r1) goto L11;
            return r1;
        L11:
            r3 = r11;
            goto L12
        }
    }

    public static /* synthetic */ void $r8$lambda$GfCSFxfn5qDzuUKjDPVOcCmMTWA(CallLogTitleBarHelper r0, View r1) {
        setupNormalState$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$aN5kU4h_jseJahTqjOonVpBEU_A(CallLogTitleBarHelper r0, View r1) {
        setupEditState$lambda$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$e7xPrTmhGQmFf6Vo53AWpNGcvKE(CallLogTitleBarHelper r0, View r1) {
        setupNormalState$lambda$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$fFQgc7Kn0vPLWpSjy_t4Pzvvivw(CallLogTitleBarHelper r0, View r1) {
        setupEditState$lambda$6(r0, r1);
    }

    public CallLogTitleBarHelper(Fragment r2, CallLogViewModel r3, Function0<Unit> r4, Function0<Unit> r5, Function0<Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "onStartEdit");
        Intrinsics.checkNotNullParameter(r5, "onExitEdit");
        Intrinsics.checkNotNullParameter(r6, "onSelectAll");
        Intrinsics.checkNotNullParameter(r7, "onTabSwitching");
        this.fragment = r2;
        this.viewModel = r3;
        this.onStartEdit = r4;
        this.onExitEdit = r5;
        this.onSelectAll = r6;
        this.onTabSwitching = r7;
    }

    public static final /* synthetic */ MenuItemData access$buildBlockedCallMenuItem(CallLogTitleBarHelper r0, boolean r1) {
        return r0.buildBlockedCallMenuItem(r1);
    }

    public static final /* synthetic */ boolean access$getFEATURE_CMCC_CU$cp() {
        return FEATURE_CMCC_CU;
    }

    public static final /* synthetic */ Fragment access$getFragment$p(CallLogTitleBarHelper r0) {
        return r0.fragment;
    }

    public static final /* synthetic */ OPopover access$getPopover$p(CallLogTitleBarHelper r0) {
        return r0.popover;
    }

    public static final /* synthetic */ void access$onTabSwitch(CallLogTitleBarHelper r0, int r1) {
        r0.onTabSwitch(r1);
    }

    public static final /* synthetic */ void access$setPopover$p(CallLogTitleBarHelper r0, OPopover r1) {
        r0.popover = r1;
    }

    public /* synthetic */ CallLogTitleBarHelper(Fragment r8, CallLogViewModel r9, Function0 r10, Function0 r11, Function0 r12, AnonymousClass1 r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = AnonymousClass1.INSTANCE;
    L5:
        this(r8, r9, r10, r11, r12, r13);
    }

    public final void setup(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        OFloatingTitleBar r3 = (OFloatingTitleBar) r2.findViewById(R.id.otitlebar);
        if (r3 != null) goto L5;
        return;
    L5:
        this.titleBarHolder = new OFloatingTitleBarHolder(r3);
        setupNormalState();
        setupEditState();
        setupTabLayout();
        OFloatingTitleBarHolder r1 = this.titleBarHolder;
        if (r1 == null) goto L9;
        r1.stateTo(OFloatingTitleBarHolder.STATE_NORMAL);
        return;
    }

    private final void setupNormalState() {
        OFloatingTitleBarHolder r6 = this.titleBarHolder;
        if (r6 != null) goto L5;
        return;
    L5:
        View r0 = OFloatingTitleBarHolder.addStartAction$default(r6, OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.standard_icon_multi_select_selector, null, 4, null);
        this.btnEdit = r0;
        if (r0 == null) goto L9;
        r0.setContentDescription(this.fragment.getString(R.string.common_edit));
    L9:
        View r1 = this.btnEdit;
        if (r1 == null) goto L12;
        r1.setOnClickListener(new CallLogTitleBarHelper$$ExternalSyntheticLambda0(this));
    L12:
        View r2 = r6.addEndAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.icon_menu_more, new CallLogTitleBarHelper$$ExternalSyntheticLambda1(this));
        if (r2 == null) goto L17;
        r2.setContentDescription(this.fragment.getString(R.string.more_btn));
        return;
    }

    private static final void setupNormalState$lambda$0(CallLogTitleBarHelper r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onStartEdit.invoke();
    }

    private static final void setupNormalState$lambda$1(CallLogTitleBarHelper r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        r1.onClickMenu(r2);
    }

    private final void setupEditState() {
        OFloatingTitleBarHolder r0 = this.titleBarHolder;
        if (r0 != null) goto L5;
        return;
    L5:
        FragmentActivity r1 = this.fragment.getActivity();
        if (r1 == null) goto L8;
        OTextView r10 = new OTextView(r1, null, 0, null, 14, null);
        r10.setGravity(17);
        r10.setSingleLine(true);
        r10.setMinHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 22, Resources.getSystem().getDisplayMetrics())));
        r10.setMaxLines(1);
        r10.setEllipsize(TextUtils.TruncateAt.END);
        r10.setTextAppearance(R.style.Title_1_Bold);
        r10.setTextColor(ResourcesCompat.getColor(r10.getResources(), R.color.oui_basic_text_1, null));
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        r3.gravity = 17;
        r10.setLayoutParams(r3);
        this.callLogTitleView = r10;
    L8:
        r0.addStartAction(OFloatingTitleBarHolder.STATE_EDIT, R.drawable.icon_cancel_22_22, new CallLogTitleBarHelper$$ExternalSyntheticLambda2(this)).setContentDescription(this.fragment.getString(R.string.accessibility_btn_cancel));
        String r2 = this.fragment.getResources().getString(R.string.select_all);
        Intrinsics.checkNotNullExpressionValue(r2, "fragment.resources.getString(R.string.select_all)");
        View r4 = r0.addEndAction(OFloatingTitleBarHolder.STATE_EDIT, r2, new CallLogTitleBarHelper$$ExternalSyntheticLambda3(this));
        r4.setContentDescription(this.fragment.getString(R.string.select_all));
        if ((r4 instanceof ViewGroup) == false) goto L11;
        ViewGroup r5 = (ViewGroup) r4;
    L12:
        if (r5 == null) goto L14;
        View r6 = r5.getChildAt(0);
    L16:
        if ((r6 instanceof OTextView) == false) goto L18;
        OTextView r7 = (OTextView) r6;
    L19:
        if (r7 == null) goto L22;
        r7.setTextColor(ResourcesCompat.getColor(this.fragment.getResources(), R.color.oui_functional_blue_6, null));
        this.selectAllState = new SelectAllState(r7);
        return;
    L22:
        return;
    L18:
        r7 = null;
        goto L19
    L14:
        r6 = null;
        goto L16
    L11:
        r5 = null;
        goto L12
    }

    private static final void setupEditState$lambda$5(CallLogTitleBarHelper r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r0.viewModel.getUiState().getValue().getEditMode().isActive() == false) goto L6;
        r0.onExitEdit.invoke();
        return;
    }

    private static final void setupEditState$lambda$6(CallLogTitleBarHelper r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onSelectAll.invoke();
    }

    private final void setupTabLayout() {
        OFloatingTitleBarHolder r0 = this.titleBarHolder;
        if (r0 != null) goto L5;
        return;
    L5:
        String[] r1 = {this.fragment.getString(R.string.tab_all), this.fragment.getString(R.string.tab_missed_calls), this.fragment.getString(R.string.tab_missed_calls)};
        boolean r2 = FEATURE_CMCC_CU;
        List r3 = ArraysKt.toList(r1);
        if (r2 == true) goto L9;
        r3 = r3.subList(0, 2);
    L9:
        View r4 = LayoutInflater.from(this.fragment.getContext()).inflate(R.layout.content_title_segmentedlayout, null, false);
        this.tabCenterView = r4;
        if (r4 == null) goto L12;
        OTabLayout r5 = (OTabLayout) r4.findViewById(R.id.tab_layout_title);
    L13:
        this.tabLayout = r5;
        if (r5 == null) goto L17;
        r5.setTabMode(0);
    L17:
        Iterator r6 = r3.iterator();
        int r7 = 0;
    L19:
        if (r6.hasNext() == false) goto L31;
        Object r8 = r6.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        String r10 = (String) r8;
        OTabLayout r11 = this.tabLayout;
        if (r11 == null) goto L26;
        OTabLayoutBase.Tab r12 = r11.getTabAt(r7);
    L27:
        if (r12 == null) goto L30;
        r12.setText(r10);
    L30:
        r7 = r9;
        goto L19
    L26:
        r12 = null;
        goto L27
    L31:
        OTabLayout r13 = this.tabLayout;
        if (r13 == null) goto L34;
        r13.addOnTabSelectedListener(new AnonymousClass2(this));
    L34:
        View r14 = this.tabCenterView;
        if (r14 == null) goto L39;
        r14.setLayoutParams(new ViewGroup.LayoutParams(-2, MathKt.roundToInt(TypedValue.applyDimension(1, 40, Resources.getSystem().getDisplayMetrics()))));
        OFloatingTitleBar r15 = r0.getTitleBar();
        if (r15 == null) goto L39;
        r15.setCenterCustomView(r14);
    L39:
        OTabLayout r16 = this.tabLayout;
        if (r16 == null) goto L43;
        r16.selectTab(0);
    L43:
        if (FEATURE_CMCC_CU == false) goto L49;
        updateCallLogFilter();
        return;
    L49:
        return;
    L12:
        r5 = null;
        goto L13
    }

    private final void onTabSwitch(int r7) {
        if (r7 != this.currentTabIndex) goto L5;
        return;
    L5:
        this.onTabSwitching.invoke();
        this.currentTabIndex = r7;
        OTabLayout r0 = this.tabLayout;
        if (r0 == null) goto L8;
        r0.selectTab(r7);
    L8:
        OTabLayoutBase.Tab r1 = null;
        if (r7 == 0) goto L25;
        if (r7 != 1) goto L39;
        OTabLayout r3 = this.tabLayout;
        if (r3 == null) goto L15;
        OTabLayoutBase.Tab r4 = r3.getTabAt(1);
    L16:
        if (r4 == null) goto L19;
        r4.setContentDescription(this.fragment.getString(R.string.accessibility_tab_missed_description));
    L19:
        OTabLayout r5 = this.tabLayout;
        if (r5 == null) goto L22;
        r1 = r5.getTabAt(0);
    L22:
        if (r1 == null) goto L39;
        r1.setContentDescription(this.fragment.getString(R.string.accessibility_tab_all_unselected));
        goto L39
    L15:
        r4 = null;
    L39:
        if (r7 == 0) goto L51;
        if (r7 != 1) goto L42;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_MISSED_CALL_LOG);
        if (FEATURE_CMCC_CU == true) goto L48;
    L50:
        CallLogTab r2 = CallLogTab.MISSED;
    L52:
        this.viewModel.switchTab(r2);
        NewContactsTraceLog.INSTANCE.onCallLogPageLog("CallLogV2Fragment onTabSwitch tab:" + r2);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onTabSwitch: pos=" + r7 + ", tab=" + r2);
        return;
    L48:
        if (DSUtils.useDSFeature() == false) goto L50;
        r2 = CallLogTab.SIM1;
        goto L52
    L42:
        if (r7 == 2) goto L44;
        r2 = CallLogTab.ALL;
        goto L52
    L44:
        r2 = CallLogTab.SIM2;
        goto L52
    L51:
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_ALL_CALL_LOG);
        r2 = CallLogTab.ALL;
        goto L52
    L25:
        OTabLayout r6 = this.tabLayout;
        if (r6 == null) goto L28;
        OTabLayoutBase.Tab r8 = r6.getTabAt(0);
    L29:
        if (r8 == null) goto L32;
        r8.setContentDescription(this.fragment.getString(R.string.accessibility_tab_all_description));
    L32:
        OTabLayout r9 = this.tabLayout;
        if (r9 == null) goto L35;
        r1 = r9.getTabAt(1);
    L35:
        if (r1 == null) goto L39;
        r1.setContentDescription(this.fragment.getString(R.string.accessibility_tab_missed_unselected));
        goto L39
    L28:
        r8 = null;
        goto L29
    }

    public final void updateCallLogFilter() {
        OTabLayoutBase.TabView r2 = null;
        if (DSUtils.useDSFeature() == false) goto L12;
        OTabLayout r3 = this.tabLayout;
        if (r3 == null) goto L9;
        OTabLayoutBase.Tab r4 = r3.getTabAt(1);
        if (r4 == null) goto L9;
        r2 = r4.getView();
    L9:
        if (r2 == null) goto L22;
        r2.setVisibility(0);
        return;
    L22:
        return;
    L12:
        OTabLayout r5 = this.tabLayout;
        if (r5 == null) goto L17;
        OTabLayoutBase.Tab r6 = r5.getTabAt(1);
        if (r6 == null) goto L17;
        r2 = r6.getView();
    L17:
        if (r2 == null) goto L23;
        r2.setVisibility(8);
        return;
    }

    private final void onClickMenu(View r9) {
        FragmentActivity r0 = this.fragment.getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        LifecycleOwner r1 = this.fragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r1, "fragment.viewLifecycleOwner");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r1), null, null, new C01711(r0, this, r9, null), 3, null);
    }

    private final MenuItemData buildBlockedCallMenuItem(final boolean r18) {
        if (r18 == false) goto L5;
        ItemType r2 = ItemType.TEXT_WITH_BADGE;
    L6:
        ItemType r4 = r2;
        if (r18 == false) goto L9;
        OPopoverEntranceMenuView.Builder.BadgeInfo r3 = new OPopoverEntranceMenuView.Builder.BadgeInfo(OPopoverEntranceMenuView.Builder.BadgeInfo.Style.DOT, 0, 0, 6, null);
    L10:
        Integer r5 = Integer.valueOf(R.drawable.menu_item_blocked_call_icon);
        String r8 = this.fragment.getString(R.string.blocked_call_log_title);
        return new MenuItemData(r4, r5, null, null, r8, null, null, null, r3, new C01701(this, r18), false, 1024, null);
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = ItemType.TEXT;
        goto L6
    }

    public final void switchToNormalState() {
        OFloatingTitleBarHolder r0 = this.titleBarHolder;
        if (r0 == null) goto L5;
        r0.stateTo(OFloatingTitleBarHolder.STATE_NORMAL);
    L5:
        View r1 = this.tabCenterView;
        if (r1 == null) goto L13;
        OFloatingTitleBarHolder r2 = this.titleBarHolder;
        if (r2 == null) goto L14;
        OFloatingTitleBar r3 = r2.getTitleBar();
        if (r3 == null) goto L15;
        r3.setCenterCustomView(r1);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void switchToEditState() {
        OFloatingTitleBarHolder r0 = this.titleBarHolder;
        if (r0 == null) goto L5;
        r0.stateTo(OFloatingTitleBarHolder.STATE_EDIT);
    L5:
        OTextView r1 = this.callLogTitleView;
        if (r1 == null) goto L13;
        OFloatingTitleBarHolder r2 = this.titleBarHolder;
        if (r2 == null) goto L14;
        OFloatingTitleBar r3 = r2.getTitleBar();
        if (r3 == null) goto L15;
        r3.setCenterCustomView(r1);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void renderEditMode(EditModeState r6) {
        Intrinsics.checkNotNullParameter(r6, "editState");
        int r0 = r6.getSelectedIds().size();
        OTextView r1 = this.callLogTitleView;
        if (r1 == null) goto L6;
        r1.setText(this.fragment.getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r0)}));
    L6:
        SelectAllState r5 = this.selectAllState;
        if (r5 == null) goto L11;
        r5.setSelectAll(r6.getSelectAllChecked());
        return;
    }

    public final void setEditEnabled(boolean r2) {
        View r0 = this.btnEdit;
        if (r0 == null) goto L6;
        r0.setEnabled(r2);
    L6:
        View r1 = this.btnEdit;
        if (r1 == null) goto L14;
        if (r2 == false) goto L11;
        float r3 = 1.0f;
    L12:
        r1.setAlpha(r3);
        return;
    L11:
        r3 = 0.3f;
        goto L12
    }

    public final void dismissPopover() {
        OPopover r0 = this.popover;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    public final void destroy() {
        this.titleBarHolder = null;
        this.tabLayout = null;
        this.tabCenterView = null;
        this.callLogTitleView = null;
        this.selectAllState = null;
        this.btnEdit = null;
        this.popover = null;
    }

    static {
        Companion = new Companion(null);
        if (ContactsUtils.FEATURE_CMCC == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        FEATURE_CMCC_CU = r0;
        return;
    L5:
        if (ContactsUtils.FEATURE_CU == true) goto L8;
        r0 = false;
        goto L9
    }
}
