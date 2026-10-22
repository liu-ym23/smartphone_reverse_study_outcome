package com.bytedance.android.live.liveinteract.plantform.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApis;
import com.bytedance.android.live.liveinteract.plantform.base.f;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.v0;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import io.reactivex.Single;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import us1.g;
import yf0.e;

/* JADX INFO: loaded from: classes46.dex */
public class AudienceTypeFragment extends InteractDialogFragmentBaseContract$View<e> implements Observer<KVData> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f76775m = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataCenter f76776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IRoom f76777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f76778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f76779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f76780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f76781l;

    public class a implements com.bytedance.android.livesdk.app.dataholder.Observer<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceTypeFragment f76782a;

        public a(AudienceTypeFragment r100) {
            this.f76782a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Integer r100) {
            if (r100.intValue() != 0) goto L6;
            ALogger.e("ttlive_link", "close video interact and open video ktv");
            this.f76782a.f76776g.put("data_need_restore_video_interact", Boolean.TRUE);
            hd0.c.f().e(this.f76782a.f76780k);
            this.f76782a.ea0();
            return;
        }
    }

    public class b implements com.bytedance.android.livesdk.app.dataholder.Observer<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceTypeFragment f76783a;

        public b(AudienceTypeFragment r100) {
            this.f76783a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Integer r100) {
            if (r100.intValue() != 0) goto L6;
            ALogger.e("ttlive_link", "close video interact and open video talk");
            this.f76783a.f76776g.put("data_need_restore_video_interact", Boolean.TRUE);
            hd0.c.f().e(this.f76783a.f76781l);
            AudienceTypeFragment r101 = this.f76783a;
            int r102 = g.f551445a;
            IRoom r103 = r101.f76777h;
            r101.da0(false, null);
            return;
        }
    }

    public class c implements d {
        public c() {
        }
    }

    public interface d {
    }

    public final void ea0() {
        boolean r100 = ((IKtvService) k.f(IKtvService.class)).isKtvComponentV2Enable();
        TalkRoomLogUtils.l0("ktv_tab");
        if (r100 == true) goto L5;
        this.f76776g.put("cmd_open_ktv_component_with_link_check", new Pair(Boolean.TRUE, "ktv_tab"));
    L12:
        yf0.g r101 = this.f74347d;
        if (r101 == null) goto L16;
        r101.dismiss();
        return;
    L16:
        return;
    L5:
        if (k.f(IKtvService.class) != null) goto L7;
    L9:
        i0 r102 = TalkRoomLogUtils.f77433a;
        TalkRoomLogUtils.o1("music");
    L10:
        int r103 = g.f551445a;
        da0(false, new c());
        goto L12
    L7:
        if (((IKtvService) k.f(IKtvService.class)).isMultiChorusEnable() == false) goto L9;
        i0 r104 = TalkRoomLogUtils.f77433a;
        TalkRoomLogUtils.o1("user_chorus");
        goto L10
    }

    public AudienceTypeFragment() {
        this.f76777h = m.i().getCurrentRoom();
        this.f76780k = new a(this);
        this.f76781l = new b(this);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        if (je0.d.W() == false) goto L6;
        return 168.0f;
    L6:
        return 152.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        if (vm2.d.S() == false) goto L5;
        boolean r100 = tb1.d.f545237a;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return s1.B(R.string.ttlive_live_interact_title_type_new);
    L10:
        return s1.B(R.string.ttlive_live_interact_title_type);
    L5:
        r101 = false;
        goto L6
    }

    public final void ba0() {
        if (f.a() != null) goto L5;
    L7:
        int r100 = g.f551445a;
        da0(false, null);
        return;
    L5:
        if (f.a().k0(2) == false) goto L7;
        this.f76776g.put("cmd_force_close_linkin_before_videotalk", Boolean.TRUE);
        hd0.c.f().k(2);
        hd0.c.f().c(this.f76781l);
    }

    public final void ca0() {
        if (f.a() != null) goto L5;
    L7:
        ea0();
        return;
    L5:
        if (f.a().k0(2) == false) goto L7;
        this.f76776g.put("cmd_force_close_linkin_before_videotalk", Boolean.TRUE);
        hd0.c.f().k(2);
        hd0.c.f().c(this.f76780k);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        hd0.c.f().e(this.f76780k);
        hd0.c.f().e(this.f76781l);
        DataCenter r100 = this.f76776g;
        if (r100 == null) goto L6;
        r100.removeObserver(this);
        return;
    }

    public static void aa0(View r100) {
        if (r100 == null) goto L9;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        float r102 = com.bytedance.android.livesdk.m.b();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r102 <= 1.0f) goto L11;
        r101.width = (int) (r101.width / r102);
        r100.setLayoutParams(r101);
        return;
    L11:
        return;
    }

    public static void fa0(View r100) {
        View r101 = r100.findViewById(R.id.video_talk_room);
        ImageView r102 = (ImageView) r100.findViewById(R.id.video_talk_room_icon);
        TextView r103 = (TextView) r100.findViewById(R.id.tv_video_talk_tips);
        r101.setBackgroundResource(R.drawable.ttlive_bg_video_talk_room_grey);
        r102.setImageResource(R.drawable.ttlive_video_talkroom_icon_grey);
        r103.setText(R.string.ttlive_paid_live_disable_video_talk_room);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(KVData r100) {
        KVData r101 = r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r101.getKey(), "live_audience_type_dialog_dismiss") == false) goto L11;
        yf0.g r102 = this.f74347d;
        if (r102 == null) goto L12;
        r102.dismiss();
        return;
    L12:
        return;
    }

    public final void da0(final boolean r210, final d r211) {
        final long r110 = System.currentTimeMillis();
        if (this.f76777h != null) goto L11;
        DataCenter r100 = this.f76776g;
        if (r100 == null) goto L8;
        this.f76777h = (IRoom) r100.get("data_room", null);
    L8:
        if (this.f76777h != null) goto L11;
        return;
    L11:
        if (((IMultiLinkServiceExternal) k.f(IMultiLinkServiceExternal.class)).getMultiDataHolderExternal().getChannelId() == 0) goto L15;
        f2.b(R.string.ttlive_interact_audience_pk_reject, 0);
        TalkRoomBusinessFullLinkMonitor.f71456a.getClass();
        TalkRoomBusinessFullLinkMonitor.g0("during_pk");
        return;
    L15:
        if (this.f76779j == false) goto L17;
        return;
    L17:
        this.f76779j = true;
        int r101 = com.bytedance.android.live.liveinteract.plantform.utils.f.f77476a;
        com.bytedance.android.live.liveinteract.plantform.utils.f.a((LiveMode) this.f76776g.get("data_live_mode", LiveMode.UNDEFINED));
        final int r102 = com.bytedance.android.livesdk.sharedpref.c.f158301r1.getValue().intValue();
        wf0.b.i(r102);
        if (r210 == false) goto L20;
        Single<com.bytedance.android.live.network.response.e<j0>> r103 = ((LinkApis) com.bytedance.android.live.network.c.b().e(LinkApis.class)).initV2(this.f76777h.getId(), 4, 16, false, r102, "8,12", 0, 0, 1);
    L21:
        ((IInteractService) k.f(IInteractService.class)).setDynamicFromAudience(false);
        TalkRoomBusinessFullLinkMonitor.f71456a.getClass();
        TalkRoomBusinessFullLinkMonitor.c0("click_bottom_bar_icon", r102, 0);
        InteractLinkFullLinkMonitor.i("8,12", r102, "click_bottom_bar_icon");
        ((SingleSubscribeProxy) r103.as(S90())).subscribe(new hh0.d(this, r110, r102, r211), new hh0.e(this, r210, r211, r110));
        return;
    L20:
        r103 = ((LinkApis) com.bytedance.android.live.network.c.b().e(LinkApis.class)).initV2(this.f76777h.getId(), 4, false, r102, "8,12");
        goto L21
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        if (this.f76776g == null) goto L6;
        boolean r102 = us1.e.f551439a;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        us1.e.f551443e = "";
        this.f76776g.put("data_video_talk_dot_with_number_show", "");
        this.f76776g.observe("live_audience_type_dialog_dismiss", this);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        r100.inflate(R.layout.ttlive_dialog_interact_audience_type_v1, r101, false);
        i0 r111 = TalkRoomLogUtils.f77433a;
        TalkRoomLogUtils.o1("link_icon");
        boolean r112 = tb1.d.f545237a;
        if (je0.d.W() == false) goto L15;
        View r102 = r100.inflate(R.layout.ttlive_dialog_interact_audience_type_v3, r101, false);
        TextView r103 = (TextView) r102.findViewById(R.id.tv_interact);
        TextView r104 = (TextView) r102.findViewById(R.id.tv_interact_desc);
        if (vm2.e.j() == true) goto L9;
        int r113 = v0.f77566a;
        if (v0.a(this.f76776g) == false) goto L9;
        fa0(r102);
        View r114 = r102.findViewById(R.id.video_ktv_room);
        ImageView r105 = (ImageView) r102.findViewById(R.id.video_ktv_room_icon);
        TextView r106 = (TextView) r102.findViewById(R.id.tv_video_ktv_tips);
        r114.setBackgroundResource(R.drawable.ttlive_bg_video_talk_room_grey);
        r105.setImageResource(R.drawable.ttlive_ktv_room_icon_grey);
        r106.setText(R.string.ttlive_paid_live_disable_video_talk_room);
    L9:
        boolean r115 = us1.e.f551439a;
        if (us1.e.a(this.f76777h) == false) goto L27;
        if (us1.e.b(this.f76777h) == false) goto L14;
        r104.setText(R.string.ttlive_tips_scene_init_multi_talk2);
        goto L27
    L14:
        r104.setText(R.string.ttlive_tips_scene_init_multi_talk);
    L27:
        if (com.bytedance.android.livesdk.m.c() == false) goto L29;
        View r107 = r102.findViewById(R.id.double_talk);
        View r108 = r102.findViewById(R.id.video_talk_room);
        View r109 = r102.findViewById(R.id.video_ktv_room);
        aa0(r107);
        aa0(r109);
        aa0(r108);
    L29:
        r102.findViewById(R.id.double_talk).setOnClickListener(new hh0.a(this));
        r102.findViewById(R.id.video_talk_room).setOnClickListener(new hh0.b(this));
        if (je0.d.W() == false) goto L32;
        r102.findViewById(R.id.video_ktv_room).setOnClickListener(new hh0.c(this));
    L32:
        Intrinsics.checkNotNullParameter("ktv_tab", "source");
        com.bytedance.live.datacontext.m<IRoom> r116 = m.i().getRoom();
        if (r116 == null) goto L37;
        IRoom r117 = r116.getValue();
        if (r117 == null) goto L37;
        long r118 = r117.getRoomId();
    L38:
        com.bytedance.live.datacontext.m<IRoom> r119 = m.i().getRoom();
        if (r119 == null) goto L44;
        IRoom r120 = r119.getValue();
        if (r120 == null) goto L44;
        Object r121 = r120.getOwnerUserIdString();
        if (r121 == null) goto L44;
    L45:
        LinkedHashMap r122 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r122);
        TalkRoomLogUtils.B0(r122, null, null, 6);
        TalkRoomLogUtils.V0(r122);
        r122.put("source", "ktv_tab");
        r122.put("room_id", String.valueOf(r118));
        r122.put("anchor_id", r121.toString());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_music_icon_show", r122, new Object[]{IRoom.class});
        return r102;
    L44:
        r121 = 0L;
    L37:
        r118 = 0;
        goto L38
    L15:
        r102 = r100.inflate(R.layout.ttlive_dialog_interact_audience_type_v2, r101, false);
        TextView r123 = (TextView) r102.findViewById(R.id.tv_interact);
        TextView r124 = (TextView) r102.findViewById(R.id.tv_interact_desc);
        boolean r125 = us1.e.f551439a;
        if (us1.e.a(this.f76777h) == true) goto L18;
    L21:
        ((TextView) r102.findViewById(R.id.tv_video_talk_tips)).setText(R.string.ttlive_tips_scene_init_talk_room);
        if (vm2.e.j() == true) goto L27;
        int r126 = v0.f77566a;
        if (v0.a(this.f76776g) == false) goto L27;
        fa0(r102);
        goto L27
    L18:
        if (us1.e.b(this.f76777h) == false) goto L20;
        r124.setText(R.string.ttlive_tips_scene_init_multi_talk2);
        goto L21
    L20:
        r124.setText(R.string.ttlive_tips_scene_init_multi_talk);
        goto L21
    }
}
