package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.VSInputPanelLayout;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.widget.ReplaySendDanmuPanelWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.view.InputLinearLayout;
import com.bytedance.android.livesdk.f;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ol1.d;
import qq1.b;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/dialog/ReplayDanmakuInputDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/widget/ReplaySendDanmuPanelWidget$a;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ReplayDanmakuInputDialog extends DialogFragment implements ReplaySendDanmuPanelWidget.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InputLinearLayout f109080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f109081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WidgetManager f109082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReplaySendDanmuPanelWidget f109083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final nl1.a f109084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f109085i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Episode f109086j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f109087k;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayDanmakuInputDialog f109088a;

        public a(ReplayDanmakuInputDialog r100) {
            this.f109088a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f109088a.f109084h.f519539a.onNext(Boolean.TRUE);
        }
    }

    public ReplayDanmakuInputDialog() {
        this.f109083g = new ReplaySendDanmuPanelWidget(this);
        this.f109084h = new nl1.a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.widget.ReplaySendDanmuPanelWidget.a
    public final boolean L6() {
        return isAdded();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        int r100 = pl1.a.f529750a;
        pl1.a.f529750a = 0;
        pl1.a.f529751b = "unknown";
        pl1.a.f529752c = null;
        this.f109087k = true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.widget.ReplaySendDanmuPanelWidget.a
    public final void EQ(ReplaySendDanmuPanelWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        InputLinearLayout r101 = this.f109080d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        b r102 = r101.getKeyBoardObservable();
        VSInputPanelLayout r103 = r100.f109147b;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomPanelContainer");
    L8:
        r102.b(r103);
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.widget.ReplaySendDanmuPanelWidget.a
    public final void bT(ReplaySendDanmuPanelWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        InputLinearLayout r101 = this.f109080d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        b r102 = r101.getKeyBoardObservable();
        VSInputPanelLayout r103 = r100.f109147b;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomPanelContainer");
    L8:
        r102.a(r103);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setLayout(-1, -1);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_vs_bottom_dialog_with_keyboard);
        d r101 = this.f109085i;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L5:
        DataCenter r102 = r101.f524134p;
        if (r102 == null) goto L8;
        Episode r103 = (Episode) r102.get("data_vs_episode_data");
    L9:
        this.f109086j = r103;
        d r104 = this.f109085i;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L12:
        r104.f524134p.put("data_vs_episode_data", this.f109086j);
        d r105 = this.f109085i;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L15:
        r105.f524134p.put("VSDanmakuInputDialogCallerContext", this.f109084h);
        d r106 = this.f109085i;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L18:
        DataCenter r107 = r106.f524134p;
        d r108 = this.f109085i;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L21:
        r107.put("VSScreenVertical", Boolean.valueOf(r108.f524120b));
        d r109 = this.f109085i;
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L24:
        DataCenter r110 = r109.f524134p;
        d r111 = this.f109085i;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L27:
        r110.put("VSInputInitText", r111.f524121c);
        d r112 = this.f109085i;
        if (r112 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L30:
        DataCenter r113 = r112.f524134p;
        d r114 = this.f109085i;
        if (r114 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L33:
        r113.put("VSCanSendEmojiDanmu", Boolean.valueOf(r114.f524123e));
        d r115 = this.f109085i;
        if (r115 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L36:
        DataCenter r116 = r115.f524134p;
        d r117 = this.f109085i;
        if (r117 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L39:
        r116.put("VSSendDanmuAction", r117.f524124f);
        d r118 = this.f109085i;
        if (r118 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L42:
        DataCenter r119 = r118.f524134p;
        d r120 = this.f109085i;
        if (r120 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L45:
        r119.put("VSDanmuInputDialogRes", Integer.valueOf(r120.f524125g));
        d r121 = this.f109085i;
        if (r121 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L48:
        DataCenter r122 = r121.f524134p;
        d r123 = this.f109085i;
        if (r123 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L51:
        r122.put("VSDanmuInputDialogEmojiInput", r123.f524126h);
        d r124 = this.f109085i;
        if (r124 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L54:
        DataCenter r125 = r124.f524134p;
        d r126 = this.f109085i;
        if (r126 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L57:
        r125.put("VSDanmuInputPanelHintText", r126.f524122d);
        d r127 = this.f109085i;
        if (r127 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L60:
        DataCenter r128 = r127.f524134p;
        d r129 = this.f109085i;
        if (r129 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L63:
        r128.put("VSDanmuInputTextColor", Integer.valueOf(r129.f524127i));
        d r130 = this.f109085i;
        if (r130 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L66:
        DataCenter r131 = r130.f524134p;
        d r132 = this.f109085i;
        if (r132 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L69:
        r131.put("VSDanmuInputEmojiPanelType", Integer.valueOf(r132.f524128j));
        d r133 = this.f109085i;
        if (r133 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L72:
        DataCenter r134 = r133.f524134p;
        d r135 = this.f109085i;
        if (r135 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L75:
        r134.put("VSDanmuInputMaxInputLength", Integer.valueOf(r135.f524129k));
        d r136 = this.f109085i;
        if (r136 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L78:
        DataCenter r137 = r136.f524134p;
        d r138 = this.f109085i;
        if (r138 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L81:
        r137.put("VSDanmuInputSource", Integer.valueOf(r138.f524133o));
        d r139 = this.f109085i;
        if (r139 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L84:
        DataCenter r140 = r139.f524134p;
        d r141 = this.f109085i;
        if (r141 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L87:
        r140.put("VSCommentFirstShowingPanel", r141.f524130l);
        d r142 = this.f109085i;
        if (r142 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L90:
        DataCenter r143 = r142.f524134p;
        d r144 = this.f109085i;
        if (r144 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L93:
        r143.put("VSEventPage", r144.f524131m);
        d r145 = this.f109085i;
        if (r145 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L96:
        DataCenter r146 = r145.f524134p;
        d r147 = this.f109085i;
        if (r147 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L99:
        r146.put("VSReplyClickPosition", r147.f524132n);
        this.f109084h.f519539a.compose(RxUtil.bindUntilDestroy(this)).subscribe(new ol1.b(this));
        int r148 = pl1.a.f529750a;
        d r149 = this.f109085i;
        if (r149 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L102:
        int r150 = r149.f524133o;
        d r151 = this.f109085i;
        if (r151 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L105:
        DataCenter r152 = r151.f524134p;
        Intrinsics.checkNotNullParameter(r152, "dataCenter");
        pl1.a.f529750a = r150;
        if (r150 != 1) goto L108;
    L110:
        String r153 = "send_barrage";
    L111:
        pl1.a.f529751b = r153;
        pl1.a.f529752c = r152;
        this.f109087k = false;
        return;
    L108:
        if (r150 == 2) goto L110;
        r153 = "unknown";
        goto L111
    L8:
        r103 = null;
        goto L9
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setCanceledOnTouchOutside(false);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setGravity(80);
        r102.setLayout(-1, -2);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        if (r.a().c() == false) goto L7;
        int r103 = 19;
    L8:
        r102.setSoftInputMode(r103);
        r102.addFlags(32);
        r102.clearFlags(2);
        r102.addFlags(1024);
        goto L9
    L7:
        r103 = 3;
    L9:
        return r101;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L10
        super.onDismiss(r100);     // Catch: Throwable -> L10
        f.d().f();     // Catch: Throwable -> L10
        d r101 = this.f109085i;     // Catch: Throwable -> L10
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");     // Catch: Throwable -> L10
    L5:
        Function0<Unit> r102 = r101.f524119a;     // Catch: Throwable -> L10
        if (r102 == null) goto L8;
        Unit r103 = r102.invoke();     // Catch: Throwable -> L10
    L8:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L10:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        WidgetManager r102 = WidgetManager.of(this, r100);
        this.f109082f = r102;
        if (r102 == null) goto L8;
        d r103 = this.f109085i;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("dialogParam");
    L7:
        r102.setDataCenter(r103.f524134p);
    L8:
        WidgetManager r104 = this.f109082f;
        if (r104 == null) goto L12;
        r104.load(R.id.send_danmu_panel, this.f109083g);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (this.f109087k == true) goto L14;
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == false) goto L12;
    L9:
        f.d().a();
        return;
    L12:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L8:
        super.show(r100, r101);
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Context r103 = getContext();
        if (r103 != null) goto L6;
        return null;
    L6:
        View r104 = LayoutInflater.from(r103).inflate(R.layout.ttlive_dialog_replay_danmaku_input, r101, false);
        this.f109080d = (InputLinearLayout) r104.findViewById(R.id.root_view);
        View r105 = r104.findViewById(R.id.empty_view);
        this.f109081e = r105;
        if (r105 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("emptyView");
    L9:
        r105.setOnClickListener(new a(this));
        return r104;
    }
}
