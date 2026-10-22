package com.bytedance.android.livesdk.gift.platform.format.panel.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftListViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftPanelDialogViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftTabViewModel;
import com.bytedance.android.livesdk.gift.platform.format.panel.view.v2.FormatGiftBottomWidget;
import com.bytedance.android.livesdk.gift.platform.format.panel.viewmodel.FormatGiftDialogViewModel;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.k;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/format/panel/view/FormatGiftDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/matchroom/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatGiftDialog extends LiveDialogFragment implements com.bytedance.android.live.matchroom.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FormatGiftDialogViewModel f132165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LocateGiftInfo f132166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f132167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f132168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f132169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f132170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f132171j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final GiftViewModelManager f132172k;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f132173a = null;

        static {
            f132173a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FormatGiftDialog f132174a;

        public c(FormatGiftDialog r100) {
            this.f132174a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            this.f132174a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r102 = DialogFragmentLancet.sLastShowStack;
            if (r102 == null) goto L12;
            com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f132175a = null;

        static {
            f132175a = new d();
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.matchroom.b
    public final int getActualContentWidth() {
        return -1;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment
    public final String getDegradeTag() {
        return "gift_format_panel";
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment
    public final boolean onBackPressed() {
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        return super.onBackPressed();
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        com.bytedance.android.livesdk.gift.util.b.e(this);
        this.f132167f.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        GiftContext r100 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r100 == null) goto L9;
        k<Unit> r101 = r100.getHideDialog();
        if (r101 == null) goto L9;
        PublishSubject r102 = r101.onEvent();
        if (r102 == null) goto L9;
        Disposable r103 = r102.subscribe(new c(this));
    L10:
        if (r103 == null) goto L13;
        this.f132167f.add(r103);
        return;
    L13:
        return;
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        ViewGroup.LayoutParams r101 = null;
        Dialog r102 = getDialog();     // Catch: Exception -> L9
        if (r102 == null) goto L11;
        Window r103 = r102.getWindow();     // Catch: Exception -> L9
        if (r103 == null) goto L11;
        r103.setDimAmount(0.0f);     // Catch: Exception -> L9
    L11:
        super.onActivityCreated(r100);
        Dialog r104 = getDialog();
        if (r104 == null) goto L14;
        Window r105 = r104.getWindow();
    L15:
        if (r105 == null) goto L30;
        r105.setGravity(80);
        r105.setSoftInputMode(48);
        r105.setLayout(-1, -1);
        View r106 = getView();
        if (r106 == null) goto L19;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
    L21:
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L30;
        View r108 = getView();
        if (r108 == null) goto L25;
        r101 = r108.getLayoutParams();
    L25:
        if (r101 == null) goto L27;
        r101.height = s1.s(getActivity());
    L27:
        View r109 = getView();
        if (r109 == null) goto L30;
        r109.setLayoutParams(r101);
        goto L30
    L19:
        r107 = null;
    L30:
        setBottomSheetSlideProcessor(b.f132173a);
        Dialog r110 = getDialog();
        if (r110 == null) goto L43;
        Window r111 = r110.getWindow();
        if (r111 == null) goto L44;
        r111.clearFlags(1024);
        View r112 = r111.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L39;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r113 = ThreadMethodProxy.currentThread();
        if (r113 == com.larus.home.impl.utils.c.f346341a) goto L39;
        com.larus.home.impl.utils.c.a(r113, "getDecorView");
    L39:
        r112.setSystemUiVisibility(0);
        return;
    L44:
        return;
    L43:
        return;
    L14:
        r105 = null;
    L9:
        e = move-exception;
        jy0.b.c("FormatGiftDialog", "request feature before set content, " + e.getMessage(), null, 4);
        goto L11
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setVertical(true);
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(getContext(), isVertical(), false) == false) goto L5;
        int r101 = R.style.ttlive_gift_dialog_with_status_bar_opt;
    L6:
        setStyle(1, r101);
        Context r102 = this.f132171j;
        if ((r102 instanceof FragmentActivity) == false) goto L10;
        this.f132165d = (FormatGiftDialogViewModel) ViewModelProviders.of((FragmentActivity) r102).get(FormatGiftDialogViewModel.class);
        return;
    L10:
        return;
    L5:
        r101 = R.style.ttlive_gift_dialog_opt;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        return super.onCreateDialog(r100);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
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

    public static final void S90(FormatGiftDialog r100, GiftStateMachineConfig.g r101) {
        r100.getClass();
        if ((r101 instanceof GiftStateMachineConfig.e.c) == false) goto L6;
        return;
    L6:
        if ((r101 instanceof GiftStateMachineConfig.e.b) == false) goto L12;
        LocateGiftInfo r102 = r100.f132166e;
        if (r102 != null) goto L10;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.i());
        return;
    L10:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.j(r102));
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = this.f132168g;
        GiftStateMachineConfig.g r103 = null;
        if (r102 == null) goto L5;
        View r104 = r102.findViewById(R.id.close_view);
    L6:
        this.f132169h = r104;
        Context r105 = this.f132171j;
        if ((r105 instanceof FragmentActivity) == true) goto L10;
        r105 = null;
    L10:
        if (((FragmentActivity) r105) == null) goto L55;
        if (r104 == null) goto L13;
        r104.setOnClickListener(d.f132175a);
    L13:
        s12.a r106 = new s12.a(this);
        q12.a r107 = q12.b.f531284a;
        if (r107 == null) goto L16;
        Object r108 = m.f163449e.d(r107, FormatGiftListViewModel.class);
    L17:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r109 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r108;
        if (r109 == null) goto L20;
        GiftStateMachineConfig.g r110 = r109.c(this, r106);
    L21:
        if (r110 == null) goto L23;
        r106.onChanged(r110);
    L23:
        s12.b r111 = new s12.b(this);
        q12.a r112 = q12.b.f531284a;
        if (r112 == null) goto L26;
        Object r113 = m.f163449e.d(r112, FormatGiftTabViewModel.class);
    L27:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r114 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r113;
        if (r114 == null) goto L30;
        GiftStateMachineConfig.g r115 = r114.c(this, r111);
    L31:
        if (r115 == null) goto L33;
        r111.onChanged(r115);
    L33:
        s12.c r116 = new s12.c(this);
        q12.a r117 = q12.b.f531284a;
        if (r117 == null) goto L36;
        Object r118 = m.f163449e.d(r117, FormatGiftPanelDialogViewModel.class);
    L37:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r119 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r118;
        if (r119 == null) goto L40;
        r103 = r119.c(this, r116);
    L40:
        if (r103 == null) goto L42;
        r116.onChanged(r103);
    L42:
        WidgetManager r120 = WidgetManager.of(this, getView());
        r120.setDataCenter(this.f132170i);
        GiftContext r121 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r121 == null) goto L47;
        com.bytedance.live.datacontext.m<Boolean> r122 = r121.isVSPadUseVerticalStyle();
        if (r122 == null) goto L47;
        r122.setValue(Boolean.TRUE);
    L47:
        GiftViewModelManager r123 = this.f132172k;
        r120.load(R.id.gift_bottom_widget_container, new FormatGiftBottomWidget(r123));
        r120.load(R.id.gift_list_widget_container, new FormatGiftListWidget(r123, this.f132165d));
        return;
    L36:
        r118 = null;
        goto L37
    L30:
        r115 = null;
        goto L31
    L26:
        r113 = null;
        goto L27
    L20:
        r110 = null;
        goto L21
    L16:
        r108 = null;
        goto L17
    L55:
        dismissAllowingStateLoss();     // Catch: Exception -> L50
        return;
    L50:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r124 = DialogFragmentLancet.sLastShowStack;
        if (r124 == null) goto L58;
        com.bytedance.crash.d.d(r124, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L58:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public FormatGiftDialog(DataCenter r100, Context r101, GiftViewModelManager r102) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "outerContext");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        this.f132170i = r100;
        this.f132171j = r101;
        this.f132172k = r102;
        setNoTitleAndCancelOutside(true);
        this.f132166e = null;
        this.f132167f = new CompositeDisposable();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_format_gift_dialog_fragment_new, r101, false);
        this.f132168g = r103;
        return r103;
    }
}
