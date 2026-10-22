package com.bytedance.android.livesdk.chatroom.vs_base.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayAdaptiveDialogUIState;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.ReplayStatusBarUIState;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.t;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq1.d0;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/view/ReplayAdaptiveDialogFragment;", "Lcom/bytedance/android/livesdk/castscreen/AdaptiveDialogFragment;", "Lcom/bytedance/android/live/matchroom/b;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ReplayAdaptiveDialogFragment extends AdaptiveDialogFragment implements com.bytedance.android.live.matchroom.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f118223e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayAdaptiveDialogFragment f118224a;

        public b(ReplayAdaptiveDialogFragment r100) {
            this.f118224a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f118224a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public abstract String S90();

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = ReplayRoomFragmentScopeUtil.f117917a;
        ((ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class)).o(S90());
        super.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L12;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.live.matchroom.b
    public int getActualContentWidth() {
        return UtilityKotlinExtentionsKt.c(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    }

    public ReplayAdaptiveDialogFragment() {
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r100 = ReplayRoomFragmentScopeUtil.f117917a;
        this.f118223e = ((ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class)).i();
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment
    public final boolean isVertical() {
        return this.f118223e;
    }

    @Override // com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r110) {
        super.onActivityCreated(r110);
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r111 = ReplayRoomFragmentScopeUtil.f117917a;
        ReplayAdaptiveDialogUIState r112 = (ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class);
        Dialog r100 = getDialog();
        View r101 = null;
        if (r100 == null) goto L5;
        Window r102 = r100.getWindow();
    L6:
        View r103 = getView();
        FragmentActivity r104 = getActivity();
        if (r102 != null) goto L9;
        r112.getClass();
    L81:
        View r113 = getView();
        if (r113 == null) goto L86;
        View r114 = r113.findViewById(R.id.dismiss_view);
        if (r114 == null) goto L86;
        r114.setOnClickListener(new b(this));
    L86:
        View r115 = getView();
        if (r115 == null) goto L89;
        r101 = r115.findViewById(R.id.dialog_content);
    L89:
        Dialog r116 = getDialog();
        if (r116 == null) goto L92;
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r105 = ReplayRoomFragmentScopeUtil.f117917a;
        ((ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class)).s(r116, r101);
    L92:
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r117 = ReplayRoomFragmentScopeUtil.f117917a;
        ReplayAdaptiveDialogUIState r118 = (ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class);
        Dialog r106 = getDialog();
        if (r106 == null) goto L95;
        r106.getWindow();
    L95:
        r118.getClass();
        return;
    L9:
        d0 r107 = r112.f495438a;
        if (r107 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L12:
        boolean r108 = ReplayStatusBarUIState.q(r104, ((ReplayStatusBarUIState) r107.c(ReplayStatusBarUIState.class)).d());
        boolean r109 = r104 instanceof Context;
        int r119 = 0;
        if (r109 == false) goto L34;
        int r120 = t.f118215a;
        if (r109 == true) goto L17;
        FragmentActivity r121 = null;
    L18:
        boolean r122 = true;
        if (r121 != null) goto L97;
    L29:
        boolean r123 = true;
    L30:
        if (r123 == false) goto L34;
        if (r112.i() == false) goto L34;
    L36:
        if (r108 == true) goto L40;
        if (r122 == true) goto L40;
        r102.addFlags(1024);
    L42:
        if (r112.i() == false) goto L44;
        r102.setGravity(80);
    L45:
        r102.setSoftInputMode(48);
        if (r108 == true) goto L64;
        if (r122 == true) goto L64;
        r102.setLayout(-1, -1);
        if (r103 == null) goto L52;
        ViewGroup.LayoutParams r124 = r103.getLayoutParams();
    L54:
        if ((r124 instanceof ViewGroup.MarginLayoutParams) == true) goto L56;
        r124 = null;
    L56:
        ViewGroup.MarginLayoutParams r125 = (ViewGroup.MarginLayoutParams) r124;
        if (r125 == null) goto L81;
        int r126 = t.f118215a;
        Rect r127 = new Rect();
        if ((r104 instanceof Activity) == false) goto L61;
        t.b(r104.getWindow()).getWindowVisibleDisplayFrame(r127);
    L61:
        r125.height = r127.height();
        if (r103 == null) goto L81;
        r103.setLayoutParams(r125);
        goto L81
    L52:
        r124 = null;
    L64:
        if (r108 == false) goto L66;
        int r128 = s1.A();
    L67:
        if (r122 == false) goto L69;
        r119 = s1.o();
    L69:
        r102.setLayout(-1, -2);
        WindowManager.LayoutParams r129 = r102.getAttributes();
        int r130 = t.f118215a;
        r129.width = s1.q(s1.getContext()).widthPixels;
        r129.height = (s1.q(s1.getContext()).heightPixels - r119) - r128;
        r102.setAttributes(r129);
        if (r103 == null) goto L72;
        ViewGroup.LayoutParams r131 = r103.getLayoutParams();
    L74:
        if ((r131 instanceof ViewGroup.MarginLayoutParams) == true) goto L76;
        r131 = null;
    L76:
        ViewGroup.MarginLayoutParams r132 = (ViewGroup.MarginLayoutParams) r131;
        if (r132 == null) goto L81;
        r132.height = (s1.q(s1.getContext()).heightPixels - r119) - r128;
        if (r103 == null) goto L81;
        r103.setLayoutParams(r132);
        goto L81
    L72:
        r131 = null;
        goto L74
    L66:
        r128 = 0;
        goto L67
    L44:
        r102.setGravity(GravityCompat.END);
    L40:
        r102.clearFlags(1024);
        goto L42
    L97:
    L27:
        e = move-exception;
        ALogger.e("ReplayResUtils", "isNavBarShow: get nav bar status fail, " + e.getMessage());
        goto L29
    L22:
        if (Settings.Secure.getInt(r121.getContentResolver(), t.c(), 0) != 0) goto L26;
        if (Settings.Global.getInt(r121.getContentResolver(), t.c(), 0) == 0) goto L29;
    L26:
        r123 = false;
        goto L30
    L17:
        r121 = r104;
    L34:
        r122 = false;
        goto L36
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.castscreen.AdaptiveDialogFragment, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r101 = ReplayRoomFragmentScopeUtil.f117917a;
        setStyle(1, ((ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class)).t(getActivity()));
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment
    public final void setVertical(boolean r100) {
        this.f118223e = r100;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r102 = ReplayRoomFragmentScopeUtil.f117917a;
        ReplayAdaptiveDialogUIState r103 = (ReplayAdaptiveDialogUIState) ReplayRoomFragmentScopeUtil.a(ReplayAdaptiveDialogUIState.class);
        String r104 = S90();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "key");
        if (r103.h() == true) goto L5;
    L7:
        super.onViewCreated(r100, r101);
        return;
    L5:
        if (r103.d() == false) goto L7;
        boolean r105 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.y(r104, this, -1);
        goto L7
    }
}
