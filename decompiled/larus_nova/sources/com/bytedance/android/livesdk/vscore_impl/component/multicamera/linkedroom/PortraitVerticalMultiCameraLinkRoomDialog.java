package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.MaybeSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui.ITabView;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/PortraitVerticalMultiCameraLinkRoomDialog;", "Lcom/bytedance/android/livesdk/castscreen/AdaptiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PortraitVerticalMultiCameraLinkRoomDialog extends AdaptiveDialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f159618h = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f159619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f159620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataCenter f159621g;

    public static final class a {
        public static void a(PortraitVerticalMultiCameraLinkRoomDialog r100, FragmentManager r101) {
            LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "PadMatchRoomMultiCameraDialog", r102);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r100.showNow(r101, "PadMatchRoomMultiCameraDialog");
        }
    }

    public static final class b implements LiveBottomSheetDialog.m {
        public b() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean shouldInterceptSlide(int r100) {
            return false;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f159622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PortraitVerticalMultiCameraLinkRoomDialog f159623b;

        public c(u r100, PortraitVerticalMultiCameraLinkRoomDialog r101) {
            this.f159622a = r100;
            this.f159623b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            com.bytedance.live.datacontext.n<PadOrientation> r102 = this.f159622a.w();
            if (r102 == null) goto L5;
            PadOrientation r103 = r102.getValue();
        L7:
            if (r103 == PadOrientation.PORTRAIT) goto L16;
            return;
        L16:
            this.f159623b.dismiss();     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r104 = DialogFragmentLancet.sLastShowStack;
            if (r104 == null) goto L19;
            com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L19:
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PortraitVerticalMultiCameraLinkRoomDialog f159624a;

        public d(PortraitVerticalMultiCameraLinkRoomDialog r100) {
            this.f159624a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == true) goto L12;
            return;
        L12:
            this.f159624a.dismiss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L15;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        u r100 = r.u(this.f159621g, null, 2);
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
        u r100 = r.u(this.f159621g, null, 2);
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

    public PortraitVerticalMultiCameraLinkRoomDialog() {
        this.f159619e = !PadConfigUtils.c();
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment
    public final boolean isVertical() {
        return this.f159619e;
    }

    @Override // com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L8;
        r102.setGravity(VideoPlayDataContext.PLAYING_GRAVITY);
        r102.setDimAmount(0.0f);
    L8:
        if (PadConfigUtils.c() == false) goto L10;
        int r103 = 480;
    L11:
        View r104 = getView();
        ViewGroup.LayoutParams r105 = null;
        if (r104 == null) goto L14;
        ViewGroup.LayoutParams r106 = r104.getLayoutParams();
    L16:
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        r105 = r106;
    L19:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r105;
        if (r107 != null) goto L22;
    L28:
        setBottomSheetSlideProcessor(new b());
        return;
    L22:
        if (PadConfigUtils.c() == false) goto L24;
        int r108 = UtilityKotlinExtentionsKt.i(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    L25:
        r107.width = r108;
        r107.height = UtilityKotlinExtentionsKt.i(r103);
        View r109 = getView();
        if (r109 == null) goto L28;
        r109.setLayoutParams(r107);
        goto L28
    L24:
        r108 = -1;
        goto L25
    L14:
        r106 = null;
        goto L16
    L10:
        r103 = 432;
        goto L11
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
        this.f159619e = r100;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        u r102 = r.u(this.f159621g, null, 2);
        if (r102 == null) goto L21;
        com.bytedance.live.datacontext.m<Boolean> r103 = r102.z1();
        if (r103 == null) goto L7;
        r103.setValue(Boolean.TRUE);
    L7:
        com.bytedance.live.datacontext.n<PadOrientation> r104 = r102.w();
        if (r104 == null) goto L14;
        Observable<sh6.b<PadOrientation>> r105 = r104.a();
        if (r105 == null) goto L14;
        ObservableSubscribeProxy r106 = (ObservableSubscribeProxy) r105.as(AutoDispose.bind(this));
        if (r106 == null) goto L14;
        r106.subscribe(new c(r102, this));
    L14:
        com.bytedance.live.datacontext.i<Boolean> r107 = r102.S();
        if (r107 == null) goto L21;
        Maybe<Boolean> r108 = r107.b();
        if (r108 == null) goto L21;
        MaybeSubscribeProxy r109 = (MaybeSubscribeProxy) r108.as(AutoDispose.bind(this));
        if (r109 == null) goto L21;
        r109.subscribe(new d(this));
    L21:
        HashMap r110 = new HashMap();
        r110.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "more_machine");
        Map<String, String> r111 = com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.a(this.f159621g);
        if (r111 == null) goto L24;
        r110.putAll(r111);
    L24:
        r.l().sendLog("livesdk_relevant_live_panel_show", r110, new Object[]{x.class, Room.class});
        super.onViewCreated(r100, r101);
        Context r112 = this.f159620f;
        if (r112 != null) goto L27;
    L40:
        dismissAllowingStateLoss();     // Catch: Exception -> L35
        return;
    L35:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r113 = DialogFragmentLancet.sLastShowStack;
        if (r113 == null) goto L43;
        com.bytedance.crash.d.d(r113, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L43:
        return;
    L27:
        if ((r112 instanceof FragmentActivity) == false) goto L40;
        WidgetManager r114 = WidgetManager.of(this, getView());
        r114.setDataCenter(this.f159621g);
        if (PadConfigUtils.c() == false) goto L31;
        ITabView.Scene r115 = ITabView.Scene.SCENE_PAD_LANDSCAPE;
    L32:
        r114.load(R.id.panel_layout_container, new PortraitVerticalLinkedCameraDialogWidget(new n(this), r115));
        return;
    L31:
        r115 = ITabView.Scene.SCENE_PORTRAIT_VERTICAL;
        goto L32
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_layout_matchroom_camera_dialog_pad, r101, false);
    }
}
