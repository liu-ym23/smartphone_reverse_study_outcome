package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/LandscapeCameraLinkRoomDialog;", "Lcom/bytedance/android/livesdk/castscreen/AdaptiveDialogFragment;", "Lcom/bytedance/android/live/matchroom/b;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeCameraLinkRoomDialog extends AdaptiveDialogFragment implements com.bytedance.android.live.matchroom.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f159545h = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f159546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f159547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataCenter f159548g;

    public static final class a {
        public static void a(LandscapeCameraLinkRoomDialog r100, FragmentManager r101) {
            LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "MatchRoomMultiCameraDialog", r102);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r100.showNow(r101, "MatchRoomMultiCameraDialog");
        }
    }

    static {
    }

    public final int S90() {
        DataCenter r100 = this.f159548g;
        if (r100 == null) goto L5;
        IRoom r101 = lu2.c.f(r100);
    L7:
        if (lu2.b.j(r101) == false) goto L10;
        return UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    L10:
        return UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME);
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        MatchRoomLandScapeAnimUtil.E.j("MatchRoomMultiCameraDialog");
        u r100 = r.u(this.f159548g, null, 2);
        if (r100 == null) goto L14;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.z1();
        if (r101 == null) goto L14;
        r101.setValue(Boolean.FALSE);
    L14:
        super.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismissAllowingStateLoss() {
        MatchRoomLandScapeAnimUtil.E.j("MatchRoomMultiCameraDialog");
        u r100 = r.u(this.f159548g, null, 2);
        if (r100 == null) goto L14;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.z1();
        if (r101 == null) goto L14;
        r101.setValue(Boolean.FALSE);
    L14:
        super.dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.live.matchroom.b
    public final int getActualContentWidth() {
        return S90();
    }

    public LandscapeCameraLinkRoomDialog() {
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment
    public final boolean isVertical() {
        return this.f159546e;
    }

    @Override // com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        View r101 = getView();
        ViewGroup.LayoutParams r102 = null;
        if (r101 == null) goto L5;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
    L7:
        if ((r103 instanceof FrameLayout.LayoutParams) == true) goto L9;
        r103 = null;
    L9:
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
        if (r104 == null) goto L14;
        r104.width = S90();
        r104.gravity = GravityCompat.END;
        r104.height = s1.s(getActivity());
        View r105 = getView();
        if (r105 == null) goto L14;
        r105.setLayoutParams(r104);
    L14:
        Dialog r106 = getDialog();
        if ((r106 instanceof LiveBottomSheetDialog) == true) goto L17;
        r106 = null;
    L17:
        LiveBottomSheetDialog r107 = (LiveBottomSheetDialog) r106;
        if (r107 == null) goto L20;
        View r108 = r107.getBottomSheetView();
    L21:
        if (r108 == null) goto L23;
        r108.setBackground(s1.m(R.drawable.ttlive_bg_more_many_icon_dialog_gradient));
    L23:
        if (r108 == null) goto L25;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L27:
        if ((r109 instanceof CoordinatorLayout.LayoutParams) == true) goto L29;
        r109 = null;
    L29:
        CoordinatorLayout.LayoutParams r110 = (CoordinatorLayout.LayoutParams) r109;
        if (r110 == null) goto L33;
        ((ViewGroup.MarginLayoutParams) r110).width = S90();
        r110.gravity = GravityCompat.END;
        ((ViewGroup.MarginLayoutParams) r110).height = s1.s(getActivity());
        r108.setLayoutParams(r110);
    L33:
        if ((this.f159547f instanceof Activity) == false) goto L47;
        Dialog r111 = getDialog();
        if (r111 == null) goto L48;
        View r112 = r111.findViewById(R.id.ttlive_touch_outside);
        if (r112 == null) goto L49;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if ((r113 instanceof CoordinatorLayout.LayoutParams) == false) goto L42;
        r102 = r113;
    L42:
        CoordinatorLayout.LayoutParams r114 = (CoordinatorLayout.LayoutParams) r102;
        if (r114 == null) goto L45;
        ((ViewGroup.MarginLayoutParams) r114).width = s1.t() - S90();
        r114.gravity = GravityCompat.START;
        r112.setLayoutParams(r114);
    L45:
        r3.c(r112, "关闭", true);
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L25:
        r109 = null;
        goto L27
    L20:
        r108 = null;
        goto L21
    L5:
        r103 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L12;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment
    public final void setVertical(boolean r100) {
        this.f159546e = r100;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        boolean r102 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.y("MatchRoomMultiCameraDialog", this, -1);
        u r103 = r.u(this.f159548g, null, 2);
        if (r103 == null) goto L7;
        com.bytedance.live.datacontext.m<Boolean> r104 = r103.z1();
        if (r104 == null) goto L7;
        r104.setValue(Boolean.TRUE);
    L7:
        super.onViewCreated(r100, r101);
        Context r105 = this.f159547f;
        if (r105 != null) goto L10;
    L19:
        dismissAllowingStateLoss();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r106 = DialogFragmentLancet.sLastShowStack;
        if (r106 == null) goto L22;
        com.bytedance.crash.d.d(r106, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L22:
        return;
    L10:
        if ((r105 instanceof FragmentActivity) == false) goto L19;
        MultiCameraLinkedRoomDialogWidget r107 = new MultiCameraLinkedRoomDialogWidget(new com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.a(this));
        WidgetManager r108 = WidgetManager.of(this, getView());
        r108.setDataCenter(this.f159548g);
        r108.load(R.id.container, r107);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_layout_matchroom_camera_dialog, r101, false);
    }
}
