package com.bytedance.android.livesdk.wgamex.gameinvite;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.s20;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/wgamex/gameinvite/AnchorInviteDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorInviteDialogFragment extends LiveDialogFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f160665j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f160666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnchorInviteViewModel f160667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DialogInterface.OnDismissListener f160668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f160669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f160670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f160671i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorInviteDialogFragment f160672a;

        public b(AnchorInviteDialogFragment r100) {
            this.f160672a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Pair r101 = (Pair) r100;
            i r102 = (i) r101.component1();
            i r103 = (i) r101.component2();
            AnchorInviteDialogFragment r104 = this.f160672a;
            int r105 = AnchorInviteDialogFragment.f160665j;
            r104.getClass();
            if ((r103 instanceof i.c) == false) goto L5;
            AnchorInviteDialogFragment.S90(r104);
            return;
        L5:
            Drawable r106 = null;
            if ((r103 instanceof i.a) == false) goto L8;
        L28:
            AnchorInviteViewModel r107 = r104.f160667e;
            if (r107 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L31:
            l r108 = r107.getGameConfig();
            if (r108 == null) goto L39;
            ((TextView) r104.T90(R.id.tv_invite)).setText(r104.getString(R.string.ttlive_wgame_anchor_invite_btn_invite_all));
            ((TextView) r104.T90(R.id.tv_invite)).setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
            TextView r109 = (TextView) r104.T90(R.id.tv_invite);
            Context r110 = r104.getContext();
            if (r110 == null) goto L38;
            Resources r111 = r110.getResources();
            if (r111 == null) goto L38;
            r106 = r111.getDrawable(R.drawable.ttlive_vcd_auth_notify_btn_bg);
        L38:
            r109.setBackground(r106);
            ImageLoader.load(ImageModel.genBy(r108.anchorInviteCenterImg)).a((HSImageView) r104.T90(R.id.iv_center_img));
        L39:
            r104.U90();
            ((TextView) r104.T90(R.id.tv_invite)).setEnabled(true);
            return;
        L8:
            if ((r103 instanceof i.b) == true) goto L28;
            if ((r103 instanceof i.d) == true) goto L13;
            AnchorInviteDialogFragment.S90(r104);
            return;
        L13:
            if (((i.d) r103).f160736a.g() != 1) goto L26;
            AnchorInviteViewModel r112 = r104.f160667e;
            if (r112 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L17:
            l r113 = r112.getGameConfig();
            if (r113 == null) goto L25;
            ((TextView) r104.T90(R.id.tv_invite)).setText(r104.getString(R.string.ttlive_wgame_anchor_invite_btn_cancel));
            ((TextView) r104.T90(R.id.tv_invite)).setTextColor(ColorProtector.parseColor("#E6FFFFFF"));
            TextView r114 = (TextView) r104.T90(R.id.tv_invite);
            Context r115 = r104.getContext();
            if (r115 == null) goto L24;
            Resources r116 = r115.getResources();
            if (r116 == null) goto L24;
            r106 = r116.getDrawable(R.drawable.ttlive_wgame_nagative_btn_bg);
        L24:
            r114.setBackground(r106);
            ImageLoader.load(ImageModel.genBy(r113.anchorInviteCenterImg)).a((HSImageView) r104.T90(R.id.iv_center_img));
        L25:
            r104.U90();
            ((TextView) r104.T90(R.id.tv_invite)).setEnabled(true);
            return;
        L26:
            AnchorInviteDialogFragment.S90(r104);
        }
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        this.f160671i.clear();
        super.onDestroy();
    }

    public AnchorInviteDialogFragment() {
        this.f160666d = new LinkedHashMap();
        this.f160669g = true;
        this.f160671i = new CompositeDisposable();
        setNoTitleAndCancelOutside(true);
    }

    public final void U90() {
        ((TextView) T90(R.id.tv_title)).setText(getString(R.string.ttlive_wgame_invite_title));
        ((TextView) T90(R.id.tv_top_tip)).setText(getString(R.string.ttlive_wgame_anchor_invite_top_tip));
        ((TextView) T90(R.id.tv_bottom_tip)).setText(getString(R.string.ttlive_wgame_anchor_invite_bottom_tip));
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f160666d).clear();
    }

    public static void S90(AnchorInviteDialogFragment r100) {
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

    public final View T90(int r100) {
        if (this.f160666d != null) goto L5;
        this.f160666d = new LinkedHashMap();
    L5:
        View r101 = this.f160666d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f160666d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L22;
        Window r102 = r101.getWindow();
        if (r102 != null) goto L7;
        return;
    L7:
        if (this.f160669g == true) goto L9;
    L12:
        r102.addFlags(1024);
    L14:
        if (this.f160669g == false) goto L16;
        int r103 = 80;
    L17:
        r102.setGravity(r103);
        r102.setSoftInputMode(48);
        if (this.f160670h == false) goto L20;
        r102.setLayout(-1, -2);
        WindowManager.LayoutParams r104 = r102.getAttributes();
        r104.width = s1.y();
        r104.height = s1.w() - s1.A();
        r102.setAttributes(r104);
        return;
    L20:
        r102.setLayout(-1, -1);
        return;
    L16:
        r103 = GravityCompat.END;
        goto L17
    L9:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(getContext(), this.f160669g, true) == false) goto L12;
        r102.clearFlags(1024);
        goto L14
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getId());
    L5:
        if (r101 != null) goto L8;
    L36:
        if (r101 != null) goto L39;
        return;
    L39:
        if (r101.intValue() != R.id.top_view_container) goto L45;
        S90(this);
        return;
    L45:
        return;
    L8:
        if (r101.intValue() != R.id.tv_invite) goto L36;
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L13;
        IESUIUtils.displayToast(getContext(), R.string.ttlive_core_network_unavailable);
        return;
    L13:
        AnchorInviteViewModel r102 = this.f160667e;
        if (r102 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        if ((r102.state() instanceof i.d) == false) goto L22;
        AnchorInviteViewModel r103 = this.f160667e;
        if (r103 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        r103.cancel();
        ((TextView) T90(R.id.tv_invite)).setEnabled(false);
        return;
    L22:
        AnchorInviteViewModel r104 = this.f160667e;
        if (r104 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        if ((r104.state() instanceof i.b) == true) goto L33;
        AnchorInviteViewModel r105 = this.f160667e;
        if (r105 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        if ((r105.state() instanceof i.a) == true) goto L33;
        return;
    L33:
        if (getContext() == null) goto L46;
        Context r106 = getContext();
        Intrinsics.checkNotNull(r106);
        j0.a r107 = new j0.a(r106);
        r107.a(s1.B(R.string.ttlive_text_cancel), com.bytedance.android.livesdk.wgamex.gameinvite.a.f160729a);
        r107.b(s1.B(R.string.ttlive_text_ensure), new com.bytedance.android.livesdk.wgamex.gameinvite.b(this));
        r107.f161764a = getString(R.string.ttlive_wgame_invite_invite_all_dialog_tips);
        r107.c();
        return;
    L46:
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_gift_dialog_with_status_bar);
        AnchorInviteViewModel r101 = this.f160667e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        Disposable r102 = RxUtilKt.e(r101.stateChanged()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        this.f160671i.add(r102);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L8
        super.onDismiss(r100);     // Catch: Throwable -> L8
        DialogInterface.OnDismissListener r101 = this.f160668f;     // Catch: Throwable -> L8
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dismissListener");     // Catch: Throwable -> L8
    L5:
        r101.onDismiss(r100);     // Catch: Throwable -> L8
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L8:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        a1.r((HSImageView) T90(R.id.iv_bg), s20.f121178a.getValue().a(), 0);
        ((TextView) T90(R.id.tv_invite)).setOnClickListener(this);
        ((FrameLayout) T90(R.id.top_view_container)).setOnClickListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_wgame_invite_anchor_dialog, r101, false);
    }
}
