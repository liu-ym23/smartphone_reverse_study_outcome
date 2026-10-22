package com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior;

import am2.a0;
import am2.b0;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IShareDialogListener;
import com.bytedance.android.livehostapi.business.depend.share.IShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.android.livehostapi.business.depend.share.ShareOutsideDialogParam;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.share.VsLiveShareType;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public class r extends com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Episode f110059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f110060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f110061f;

    public static final class a {
    }

    public static final class b implements IShareDialogListener {
        public b() {
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareDialogListener
        public final void onShareDialogDismiss() {
            com.bytedance.android.livesdk.f.d().f();
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareDialogListener
        public final void onShareDialogShow() {
            com.bytedance.android.livesdk.f.d().a();
        }
    }

    public static final class c implements IShareCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f110062a;

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onFail(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final /* synthetic */ void onShareUiDismiss() {
            IShareCallback.CC.$default$onShareUiDismiss(this);
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final /* synthetic */ void onShareUiShow() {
            IShareCallback.CC.$default$onShareUiShow(this);
        }

        public c(r r100) {
            this.f110062a = r100;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final boolean interceptReportAction(IShareParams r100) {
            Intrinsics.checkNotNullParameter(r100, "shareParams");
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a == true) goto L5;
            return false;
        L5:
            if (TextUtils.isEmpty(com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.s().c()) == true) goto L21;
            Episode r101 = this.f110062a.f110059d;
            if (r101 == null) goto L20;
            yr1.g r102 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.f();
            IBaseUser r103 = r101.getOwner();
            String r104 = null;
            if (r103 == null) goto L11;
            Intrinsics.checkNotNullParameter(r103, "$this$secUidExt");
            String r105 = r103.getCastSecUid();
        L12:
            long r106 = r101.getId();
            IBaseUser r107 = fq1.t.a().b();
            if (r107 == null) goto L15;
            Intrinsics.checkNotNullParameter(r107, "$this$secUidExt");
            r104 = r107.getCastSecUid();
        L15:
            r102.A(r105, r106, r104);
            return true;
        L11:
            r105 = null;
            goto L12
        L20:
            return true;
        L21:
            return false;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onSuccess(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter(r101, "shareType");
            if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a == true) goto L5;
        L9:
            r r102 = this.f110062a;
            r102.f110060e = r100;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r100, "platform");
            Episode r103 = r102.f110059d;
            if (r103 != null) goto L12;
        L14:
            boolean r104 = false;
        L15:
            HashMap r105 = new HashMap();
            Episode r106 = r102.f110059d;
            if (r106 == null) goto L18;
            String r107 = r106.itemId;
        L19:
            if (r107 != null) goto L21;
            r107 = "";
        L21:
            r105.put("item_id", r107);
            r105.put("share_delta", "1");
            r105.put("source", "0");
            r105.put("stats_channel", r100);
            mq1.c r108 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.q.a();
            if (r108 == null) goto L24;
            r108.g(r105, r104);
        L24:
            DataCenter r109 = this.f110062a.f110008a;
            if (r109 == null) goto L28;
            com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r109).d("share", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("platform", r100)}), new Object[0]);
            return;
        L28:
            return;
        L18:
            r107 = null;
            goto L19
        L12:
            if (r103.notReportPV != true) goto L14;
            r104 = true;
            goto L15
        L5:
            if (TextUtils.equals(r100, this.f110062a.f110060e) == false) goto L9;
            if (TextUtils.equals(r101, "command") == false) goto L9;
        }
    }

    static {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r210) {
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.b.a() == true) goto L5;
        return;
    L5:
        Context r100 = this.f110010c;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        DataCenter r101 = this.f110008a;
        boolean r110 = false;
        if (r101 == null) goto L10;
        Boolean r102 = (Boolean) r101.get("data_is_portrait", Boolean.FALSE);
        if (r102 == null) goto L10;
        boolean r103 = r102.booleanValue();
    L11:
        py.k r111 = null;
        if (r103 == false) goto L15;
    L26:
        boolean r104 = true;
    L27:
        if (r104 == true) goto L29;
        return;
    L29:
        Context r105 = this.f110010c;
        if ((r105 instanceof FragmentActivity) == true) goto L32;
        r105 = null;
    L32:
        FragmentActivity r112 = (FragmentActivity) r105;
        if (r112 != null) goto L35;
        return;
    L35:
        DataCenter r106 = this.f110008a;
        if (r106 == null) goto L38;
        Episode r107 = (Episode) r106.get("data_vs_episode_data", null);
    L39:
        this.f110059d = r107;
        if (r107 != null) goto L42;
        return;
    L42:
        DataCenter r108 = this.f110008a;
        if (r108 == null) goto L48;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d r109 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r108);
        HashMap r113 = new HashMap();
        String r114 = this.f110061f;
        if (r114 == null) goto L47;
        r113.put("vs_scene_source", r114);
    L47:
        r109.d("click_share_button", r113, new Object[0]);
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r108).e("click_share_button", null, new Object[0]);
    L48:
        String r115 = fq1.t.a().getCurrentUserId();
        ShareParams.Builder r116 = ShareParams.buildUponReplay(this.f110059d).setUserId(r115).setEnterFrom(VSConstants.EXTRA_REPLAY_SHARE_ENTER_FROM);
        Episode r117 = this.f110059d;
        if (r117 == null) goto L51;
        String r118 = EpisodeExtKt.getOwnerIdString(r117);
    L52:
        ShareParams.Builder r119 = r116.setAnchor(Intrinsics.areEqual(r118, r115)).setVSSceneSource(this.f110061f).setEnableLandscapePlayerOpt(true);
        DataCenter r120 = this.f110008a;
        if (r120 != null) goto L55;
    L57:
        HashMap<String, String> r121 = new HashMap();
        Episode r122 = this.f110059d;
        if (r122 == null) goto L61;
        String r123 = String.valueOf(r122.getId());
        if (r123 == null) goto L61;
    L62:
        r121.put(ShareConstants.REPLAY_ID, r123);
        r121.put("content_type", "replay");
        r119.setExtraParams(r121);
        HashMap<String, String> r124 = new HashMap();
        r124.put("content_type", "replay");
        r119.setActivityInfo(r124);
        DataCenter r125 = this.f110008a;
        String r126 = "";
        if (r125 == null) goto L65;
        String r127 = (String) r125.get("data_member_count_str", "");
    L66:
        DataCenter r128 = this.f110008a;
        if (r128 == null) goto L71;
        Boolean r129 = (Boolean) r128.get("data_up_right_is_show_pv", Boolean.FALSE);
        if (r129 == null) goto L71;
        boolean r130 = r129.booleanValue();
    L72:
        if (r127 == null) goto L93;
        if (this.f110010c != null) goto L76;
    L81:
        boolean r131 = false;
    L82:
        if (r131 == true) goto L85;
        r127 = null;
    L85:
        if (r127 == null) goto L93;
        if (r130 == false) goto L88;
        String r132 = this.f110010c.getString(R.string.ttlive_share_room_member_pv_count, new Object[]{r127});
    L89:
        if (r132 == null) goto L93;
        r126 = r132;
        goto L93
    L88:
        r132 = this.f110010c.getString(R.string.ttlive_share_room_member_count, new Object[]{r127});
        goto L89
    L76:
        if (r127.length() <= 0) goto L78;
        boolean r133 = true;
    L79:
        if (r133 == false) goto L81;
        r131 = true;
        goto L82
    L78:
        r133 = false;
    L93:
        if (r126.length() <= 0) goto L95;
        r110 = true;
    L95:
        if (r110 == false) goto L97;
        r119.setRoomMemberCountStr(r126);
    L97:
        HashMap<String, String> r134 = new HashMap();
        r134.put(IPerformanceManager.Params.room_type, "replay");
        r134.put("content_type", "replay");
        DataCenter r135 = this.f110008a;
        if (r135 == null) goto L127;
        com.bytedance.android.livesdk.log.filter.o r136 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r135).c(a0.class);
        if (r136 == null) goto L104;
        Map<String, String> r137 = r136.getMap();
        if (r137 == null) goto L104;
        r134.putAll(r137);
    L104:
        com.bytedance.android.livesdk.log.filter.o r138 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r135).c(b0.class);
        if (r138 == null) goto L107;
        Map<String, String> r139 = r138.getMap();
    L108:
        if (r139 == null) goto L110;
        r134.putAll(r139);
    L110:
        com.bytedance.android.livesdk.log.filter.o r140 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r135).c(b0.class);
        if (r140 == null) goto L115;
        Map<String, String> r141 = r140.getMap();
        if (r141 == null) goto L115;
        String r142 = r141.get("request_id");
    L117:
        if (r119.getRequestId() != null) goto L119;
        r119.setRequestId(r142);
    L119:
        r119.getExtras().putBoolean("enter_from_dou_plus", ((Boolean) r135.get("enter_from_dou_plus", Boolean.FALSE)).booleanValue());
        ShareOutsideDialogParam r143 = new ShareOutsideDialogParam();
        Episode r144 = this.f110059d;
        if (r144 == null) goto L126;
        EpisodeBasicInfo r145 = r144.episodeBasicInfo;
        if (r145 == null) goto L126;
        py.s r146 = r145.getShareResource();
        if (r146 == null) goto L126;
        r111 = r146.getToastBackground();
    L126:
        r143.setToastBackground(r111);
        Unit r147 = Unit.INSTANCE;
        r119.setCustomCommandDialogParam(r143);
    L115:
        r142 = null;
        goto L117
    L107:
        r139 = null;
    L127:
        r119.setLogExtraParams(r134);
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.w().a(new xr1.a(null, r112, null, r119.setShareDialogListener(new b()).build(), null, null, null, null, null, null, null), "ReplayToolbarShareEpisodeBehavior", VsLiveShareType.SHARE_DIALOG, new c(this));
        return;
    L71:
        r130 = false;
        goto L72
    L65:
        r127 = null;
    L61:
        r123 = "0";
        goto L62
    L55:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r120, true) == true) goto L57;
        r119.setEnableMatchRoomDialogAnim(true);
        goto L57
    L51:
        r118 = null;
        goto L52
    L38:
        r107 = null;
        goto L39
    L15:
        if (fq1.t.a().isLogin() == true) goto L26;
        DataCenter r148 = this.f110008a;
        if (r148 == null) goto L19;
        Boolean r149 = (Boolean) r148.get("data_is_portrait", Boolean.TRUE);
    L21:
        if ((!Intrinsics.areEqual(r149, Boolean.TRUE)) == false) goto L25;
        mq1.o r150 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.d();
        if (r150 == null) goto L25;
        mq1.o.a.a(r150, 1, 0, 0, "share", 22);
    L25:
        com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m.a.a(fq1.t.a(), r100, s1.B(R.string.ttlive_replay_core_login_dialog_message), "popup", null, null, 0, null, 120).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.a(this));
        r104 = false;
        goto L27
    L19:
        r149 = null;
    L10:
        r103 = false;
        goto L11
    }

    public r(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        this.f110061f = r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f110008a = r101;
        String r102 = this.f110061f;
        if (r102 == null) goto L41;
        int r103 = r102.hashCode();
        if (r103 == (-1140094085)) goto L22;
        if (r103 == 3357525) goto L16;
        if (r103 == 116576946) goto L13;
        return;
    L13:
        if (r102.equals("top_right") == false) goto L34;
    L23:
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r104 = ReplayDataContext.a.b(r101);
        if (r104 == null) goto L38;
        com.bytedance.live.datacontext.j<iq1.a> r105 = r104.getLoggerHelper();
        if (r105 == null) goto L39;
        iq1.a r106 = r105.getValue();
        if (r106 == null) goto L40;
        HashMap r107 = new HashMap();
        String r108 = this.f110061f;
        if (r108 == null) goto L32;
        r107.put("vs_scene_source", r108);
    L32:
        r106.a("share_button_show", r107);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L34:
        return;
    L16:
        if (r102.equals("more") == false) goto L35;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d r109 = com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r101);
        HashMap r110 = new HashMap();
        String r111 = this.f110061f;
        if (r111 == null) goto L20;
        r110.put("vs_scene_source", r111);
    L20:
        r109.d("share_button_show", r110, new Object[0]);
        return;
    L35:
        return;
    L22:
        if (r102.equals(NewBroadcastMonitor.STAGE.TOOLBAR) == true) goto L23;
        return;
    }
}
