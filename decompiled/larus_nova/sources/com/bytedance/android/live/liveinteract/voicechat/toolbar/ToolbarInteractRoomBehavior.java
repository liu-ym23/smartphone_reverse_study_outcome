package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import java.util.HashMap;
import vlc.l;

/* JADX INFO: loaded from: classes46.dex */
public class ToolbarInteractRoomBehavior implements c0.b, Observer<KVData>, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f80773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f80774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f80775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f80776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DataCenter f80777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f80778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public vlc.d f80779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RedDotView f80780h;

    public ToolbarInteractRoomBehavior() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    public void onMessage(tlc.d r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void a() {
        Integer r100 = je0.d.h();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.intValue() != 29) goto L16;
        Boolean r101 = com.bytedance.android.livesdk.sharedpref.b.V3.getValue();
        if (r101 == null) goto L9;
        boolean r102 = r101.booleanValue();
    L10:
        if (r102 == true) goto L17;
        RedDotView r103 = this.f80780h;
        if (r103 == null) goto L18;
        r103.setVisibility(0);
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r102 = false;
        goto L10
    }

    public final void b(int r100) {
        if (this.f80778f == true) goto L5;
        return;
    L5:
        UIUtils.setViewVisibility(this.f80773a, r100);
    }

    public final void c(int r100) {
        if (this.f80778f == true) goto L5;
        return;
    L5:
        if (this.f80773a != null) goto L8;
        return;
    L8:
        if (r100 <= 0) goto L10;
        UIUtils.setViewVisibility(this.f80774b, 8);
        UIUtils.setViewVisibility(this.f80775c, 0);
        return;
    L10:
        UIUtils.setViewVisibility(this.f80774b, 0);
        UIUtils.setViewVisibility(this.f80775c, 8);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(KVData r100) {
        KVData r101 = r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getKey().isEmpty() == false) goto L7;
        return;
    L7:
        if (r101.getData() != null) goto L10;
        return;
    L10:
        if (r101.getKey().equals("data_audio_talk_dot_with_number_show") == false) goto L36;
        String r102 = (String) r101.getData();
        String r103 = s1.B(R.string.ttlive_interact_profile_card_apply);
        if (TextUtils.isEmpty(r102) == false) goto L14;
        this.f80776d.setVisibility(8);
        a();
        r3.c(this.f80773a, r103, true);
    L32:
        c(CastIntegerProtector.parseInt(r102));     // Catch: Exception -> L30
        return;
    L30:
        c(0);
        return;
    L14:
        this.f80776d.setText(r102);
        this.f80776d.setVisibility(0);
        RedDotView r104 = this.f80780h;
        if (r104 == null) goto L18;
        r104.setVisibility(8);
    L18:
        if (this.f80778f == true) goto L20;
    L27:
        r3.c(this.f80773a, r103 + "，" + r102, true);
        goto L32
    L20:
        if (vm2.d.s() == false) goto L27;
        this.f80776d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewGroup.LayoutParams r105 = this.f80776d.getLayoutParams();
        if (r105 == null) goto L27;
        r105.width = this.f80776d.getMeasuredWidth();
        if ((r105 instanceof FrameLayout.LayoutParams) == false) goto L26;
        ((FrameLayout.LayoutParams) r105).gravity = 48;
    L26:
        this.f80776d.setLayoutParams(r105);
        goto L27
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r101 = IVoiceChatAdminService.a.a();
        if (r101 == null) goto L5;
        r101.showInviteAndPermitDialog(false, "bottom", -1);
    L5:
        RedDotView r102 = this.f80780h;
        if (r102 != null) goto L8;
    L14:
        HashMap r103 = new HashMap();
        r103.put("action_type", "click");
        TalkRoomLogUtils.z0(r103, Integer.valueOf(je0.d.f()));
        j0.l().sendLog("livesdk_guest_connection_anchor", r103, new Object[]{IRoom.class});
        return;
    L8:
        if (r102.f112467b == false) goto L14;
        if (je0.d.h().intValue() != 29) goto L14;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r104 = com.bytedance.android.livesdk.sharedpref.b.V3;
        Boolean r105 = Boolean.TRUE;
        r104.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r104, r105);
        RedDotView r106 = this.f80780h;
        if (r106 == null) goto L14;
        r106.setVisibility(8);
        goto L14
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        this.f80777e.removeObserver(this);
        vlc.d r102 = this.f80779g;
        if (r102 == null) goto L6;
        r102.removeMessageListener(this);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        this.f80777e = r101;
        r101.observe("data_audio_talk_dot_with_number_show", this);
        this.f80778f = ((Boolean) this.f80777e.get("data_is_anchor", Boolean.TRUE)).booleanValue();
        DataCenter r102 = this.f80777e;
        if (r102 == null) goto L5;
        this.f80779g = (vlc.d) r102.get("data_message_manager");
    L5:
        vlc.d r103 = this.f80779g;
        if (r103 == null) goto L8;
        r103.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getIntType(), this);
    L8:
        this.f80773a = r100;
        r100.getContext();
        this.f80774b = this.f80773a.findViewById(R.id.opened);
        this.f80775c = this.f80773a.findViewById(R.id.waiting);
        this.f80776d = (TextView) this.f80773a.findViewById(R.id.number_dot);
        this.f80780h = (RedDotView) this.f80773a.findViewById(R.id.view_red_dot);
        if (this.f80778f == true) goto L11;
    L15:
        UIUtils.setViewVisibility(this.f80774b, 0);
        UIUtils.setViewVisibility(this.f80773a, 0);
        UIUtils.setViewVisibility(this.f80775c, 8);
        UIUtils.setViewVisibility(this.f80776d, 8);
        if (this.f80778f == false) goto L18;
        HashMap r104 = new HashMap();
        r104.put("action_type", "show");
        j0.l().sendLog("livesdk_guest_connection_anchor", r104, new Object[]{IRoom.class});
    L18:
        a();
        return;
    L11:
        if (vm2.d.s() == false) goto L15;
        UIUtils.setViewVisibility(this.f80773a.findViewById(R.id.ttlive_broadcast_toolbar_audio_interact), 0);
        View r105 = this.f80773a;
        if ((r105 instanceof ViewGroup) == false) goto L15;
        ((ViewGroup) r105).setClipChildren(false);
        ((ViewGroup) this.f80773a).setClipToPadding(false);
        goto L15
    }
}
