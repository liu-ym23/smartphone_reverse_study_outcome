package cm1;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.replay.report.ReplayCommentReportApi;
import com.bytedance.android.livesdk.chatroom.replay.ui.d0;
import com.bytedance.android.livesdk.chatroom.vs_base.base.d;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.util.y;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.share.VsLiveShareType;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.m;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.scope.o;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import fq1.t;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ita.i;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import mq1.a0;
import mq1.z;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements a0, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f24153a;

    /* JADX INFO: renamed from: cm1.a$a, reason: collision with other inner class name */
    public static final class C0458a extends h<IBaseUser> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f24154a;

        public C0458a(a r100) {
            this.f24154a = r100;
        }

        @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
            this.f24154a.f24153a.add(r100);
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public a() {
        this.f24153a = new CompositeDisposable();
    }

    public final boolean d(Context r110) {
        if (t.a().isLogin() == true) goto L6;
        m.a.a(t.a(), r110, s1.B(R.string.ttlive_replay_core_login_dialog_message), "popup", "live_detail", null, -1, "user_report", 16).subscribe(new C0458a(this));
        return false;
    L6:
        return true;
    }

    @Override // mq1.a0
    public final boolean c(Episode r210, Context r211, String r212, boolean r310, vk1.a r311, IBaseUser r312, DataCenter r313) {
        Intrinsics.checkNotNullParameter(r212, "userId");
        String r100 = "user";
        Intrinsics.checkNotNullParameter(r312, "user");
        if (r210 != null) goto L5;
        return false;
    L5:
        if ((r211 instanceof Activity) == true) goto L8;
        return false;
    L8:
        if (r311 != null) goto L10;
    L14:
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        d r101 = ReplayRoomFragmentScopeUtil.f117917a;
        if (((d0) ReplayRoomFragmentScopeUtil.a(d0.class)).d() == false) goto L20;
        mq1.o r110 = s.d();
        if (r110 == null) goto L20;
        mq1.o.a.a(r110, 1, 0, 0, "report", 22);
    L20:
        if (d(r211) == true) goto L22;
        return false;
    L22:
        int r102 = i.f495747a;
        if (NetworkUtils.isNetworkAvailable(r211) == true) goto L26;
        y.a(R.string.ttlive_replay_core_network_unavailable);
        return true;
    L26:
        r.s().k();
        if (r310 == false) goto L29;
        r.s().g();
        String r111 = String.valueOf(r210.roomId);
        r100 = "live";
    L30:
        if (r311 == null) goto L32;
        String r103 = r311.f555461e;
    L34:
        if (TextUtils.equals("personal_profile", r103) == false) goto L36;
        r.s().i();
        r100 = "live_comment";
    L36:
        String r213 = r100;
        boolean r104 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a;
        if (r104 == false) goto L112;
        z.f514788j2.getClass();
        ArrayList<String> r105 = z.a.f514790b;
        if (r311 == null) goto L42;
        String r112 = r311.f555461e;
        if (r112 == null) goto L42;
    L44:
        if (r105.contains(r112) == false) goto L112;
        if (TextUtils.isEmpty(r.s().c()) == true) goto L112;
        String r106 = com.bytedance.android.live.base.model.user.o.a(r210.getOwner());
        IBaseUser r107 = t.a().b();
        if (r107 == null) goto L50;
        Intrinsics.checkNotNullParameter(r107, "$this$secUidExt");
        String r108 = r107.getCastSecUid();
    L51:
        if (r311 == null) goto L53;
        String r109 = r311.f555461e;
    L55:
        if (Intrinsics.areEqual(PbRequest.SwitchType.PK, r109) == true) goto L77;
        if (r311 == null) goto L58;
        String r113 = r311.f555461e;
    L60:
        if (Intrinsics.areEqual("anchor_linkmic", r113) == true) goto L77;
        if (r311 == null) goto L64;
        String r114 = r311.f555461e;
    L66:
        if (Intrinsics.areEqual("audience_audio", r114) == true) goto L72;
        if (r311 == null) goto L69;
        String r115 = r311.f555461e;
    L71:
        if (Intrinsics.areEqual("audience_linkmic", r115) == true) goto L72;
    L78:
        String r116 = r108;
        String r117 = "";
        String r118 = r117;
    L79:
        String r119 = r106;
        if (r311 == null) goto L82;
        String r120 = r311.f555460d;
    L84:
        if (TextUtils.equals("personal_profile", r120) == true) goto L92;
        if (r311 == null) goto L87;
        String r121 = r311.f555460d;
    L89:
        if (TextUtils.equals(UserProfileEvent.SOURCE_BARRAGE, r121) == true) goto L92;
        boolean r122 = false;
    L93:
        mq1.o r123 = s.d();
        if (r123 == null) goto L110;
        yr1.m r124 = r.s();
        if (r311 == null) goto L98;
        String r125 = r311.f555460d;
    L99:
        if (r311 == null) goto L101;
        String r126 = r311.f555462f;
    L102:
        String r127 = r124.getReportType(r125, r126, r122);
        yr1.m r128 = r.s();
        if (r311 == null) goto L105;
        String r129 = r311.f555460d;
    L106:
        if (r311 == null) goto L108;
        String r130 = r311.f555462f;
    L109:
        String r131 = r116;
        String r132 = r117;
        String r133 = r118;
        r123.Sa(r210, r119, r131, r132, r133, r127, r128.getRequestPage(r129, r130), r312.isVcdContentAuthorized());
        goto L110
    L108:
        r130 = "";
        goto L109
    L105:
        r129 = null;
        goto L106
    L101:
        r126 = "";
        goto L102
    L98:
        r125 = null;
    L110:
        a0.a.a(this, r111.toString(), "report_official_account", UserProfileEvent.DATA_TYPE_CARD_ANCHOR, r313);
        return true;
    L87:
        r121 = null;
    L92:
        r122 = true;
        goto L93
    L82:
        r120 = null;
        goto L84
    L69:
        r115 = null;
    L72:
        Intrinsics.checkNotNullParameter(r312, "$this$secUidExt");
        String r134 = r312.getCastSecUid();
        if (TextUtils.isEmpty(r134) == false) goto L75;
        String r135 = r312.getIdString();
    L76:
        r311.getClass();
        r118 = r135;
        r117 = r134;
        r116 = r108;
        goto L79
    L75:
        r135 = "";
        goto L76
    L64:
        r114 = null;
        goto L66
    L58:
        r113 = null;
    L77:
        Intrinsics.checkNotNullParameter(r312, "$this$secUidExt");
        r106 = r312.getCastSecUid();
        Intrinsics.checkNotNullParameter(r312, "$this$secUidExt");
        r108 = r312.getCastSecUid();
        r312.getLiveRoomId();
        r311.getClass();
        goto L78
    L53:
        r109 = null;
        goto L55
    L50:
        r108 = null;
    L42:
        r112 = "";
    L112:
        if (r310 == false) goto L152;
        if (r104 == false) goto L152;
        if (TextUtils.isEmpty(r.s().c()) == true) goto L152;
        if (r311 == null) goto L118;
        String r136 = r311.f555460d;
    L120:
        if (TextUtils.equals("personal_profile", r136) == true) goto L128;
        if (r311 == null) goto L123;
        String r137 = r311.f555460d;
    L125:
        if (TextUtils.equals(UserProfileEvent.SOURCE_BARRAGE, r137) == true) goto L128;
        boolean r138 = false;
    L129:
        mq1.o r139 = s.d();
        if (r139 == null) goto L150;
        String r140 = com.bytedance.android.live.base.model.user.o.a(r210.getOwner());
        IBaseUser r141 = t.a().b();
        if (r141 == null) goto L134;
        Intrinsics.checkNotNullParameter(r141, "$this$secUidExt");
        String r142 = r141.getCastSecUid();
    L135:
        yr1.m r143 = r.s();
        if (r311 == null) goto L138;
        String r144 = r311.f555460d;
    L139:
        if (r311 == null) goto L141;
        String r145 = r311.f555462f;
    L142:
        String r146 = r143.getReportType(r144, r145, r138);
        yr1.m r147 = r.s();
        if (r311 == null) goto L145;
        String r148 = r311.f555460d;
    L146:
        if (r311 == null) goto L148;
        String r149 = r311.f555462f;
    L149:
        String r150 = r147.getRequestPage(r148, r149);
        r139.Sa(r210, r140, r142, null, null, r146, r150, false);
        goto L150
    L148:
        r149 = "";
        goto L149
    L145:
        r148 = null;
        goto L146
    L141:
        r145 = "";
        goto L142
    L138:
        r144 = null;
        goto L139
    L134:
        r142 = null;
    L150:
        a0.a.a(this, r111.toString(), "report_official_account", UserProfileEvent.DATA_TYPE_CARD_ANCHOR, r313);
        return true;
    L123:
        r137 = null;
    L128:
        r138 = true;
        goto L129
    L118:
        r136 = null;
    L152:
        a0.a.a(this, r111.toString(), "report_user", UserProfileEvent.DATA_TYPE_CARD_SEND_GIFT_INFO, r313);
        ShareParams.Builder r151 = ShareParams.buildUponParams(r111, r212);
        r151.setRoomId(r210.roomId);
        Activity r152 = (Activity) r211;
        r.w().a(new xr1.a(null, r152, null, r151.build(), null, null, null, null, null, null, r213), "VSReportServiceImpl", VsLiveShareType.REPORT_DIALOG, null);
        return false;
    L32:
        r103 = null;
        goto L34
    L29:
        r111 = r212;
        goto L30
    L10:
        if (r311.f555468l != true) goto L14;
        if (d(r211) == true) goto L22;
        return false;
    }

    @Override // mq1.a0
    public final void logReport(boolean r100, String r101, String r102, String r103, String r104, ViewModel r110, String r111) {
        Intrinsics.checkNotNullParameter(r101, "toUserId");
        Intrinsics.checkNotNullParameter(r102, "toCommentId");
        Intrinsics.checkNotNullParameter(r103, "reportType");
        Intrinsics.checkNotNullParameter(r104, "requestPage");
        LinkedHashMap r105 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r101, "toUserId");
        Intrinsics.checkNotNullParameter(r102, "toCommentId");
        Intrinsics.checkNotNullParameter(r103, "reportType");
        Intrinsics.checkNotNullParameter(r104, "requestPage");
        Intrinsics.checkNotNullParameter(r105, "mLogParams");
        r105.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r101);
        r105.put("to_comment_id", r102);
        r105.put("report_type", r103);
        r105.put("request_page", r104);
        if (r111 == null) goto L5;
        r105.put("to_comment_type", r111);
    L5:
        if (r110 != null) goto L7;
        return;
    L7:
        if ((r110 instanceof DataCenter) == false) goto L11;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a((DataCenter) r110).d("user_report", r105, new Object[0]);
        return;
    }

    @Override // mq1.a0
    public final void a(Long r110, long r111, long r210, String r211, String r212, long r213, String r214, String r215, DataCenter r216, Context r310) {
        Intrinsics.checkNotNullParameter(r211, "secTargetUserId");
        Intrinsics.checkNotNullParameter(r212, "content");
        Intrinsics.checkNotNullParameter(r215, "toCommentType");
        if (r110 == null) goto L11;
        r110.longValue();
        ReplayCommentReportApi r100 = (ReplayCommentReportApi) r.n().getService(ReplayCommentReportApi.class);
        long r101 = r110.longValue();
        if (r.d().isSaas() == false) goto L7;
        String r102 = "/webcast/openapi/review/episode/report_chat/";
    L8:
        r100.reportVSChat(r101, r111, 1, r210, r211, r214, "", r212, 4, r213, r102).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r210, r214, r310, r216), new c(this, r310));
        goto L11
    L7:
        r102 = "/webcast/review/episode/report_chat/";
    L11:
        if (r214 != null) goto L13;
        String r103 = "";
    L14:
        String r217 = r103;
        logReport(false, r217, String.valueOf(r210), "report_message", "comment_popup", r216, r215);
        return;
    L13:
        r103 = r214;
        goto L14
    }
}
