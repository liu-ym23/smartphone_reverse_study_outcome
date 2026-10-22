package com.bytedance.android.livesdk.chatroom.vs.report;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.base.service.IVSReportService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.IReportService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.nl;
import com.bytedance.android.livesdk.config.oc;
import com.bytedance.android.livesdk.config.ui1;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.s0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.service.f;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.abs.EpisodeCompatDelegate;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomData;
import com.bytedance.android.livesdkapi.depend.model.live.abs.RoomCompatDelegate;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.videoshop.context.VideoContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ita.i;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import xs2.b;
import zg1.j3;
import zg1.r2;
import zg1.u;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JD\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016JV\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0013J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0006H\u0016JP\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/report/VSReportServiceImpl;", "Lcom/bytedance/android/live/base/service/IVSReportService;", "()V", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "mIsFetchingReasons", "", "logReport", "", "isLive", "toUserId", "", "toCommentId", "reportType", "requestPage", "dataCenter", "Landroidx/lifecycle/ViewModel;", "toCommentType", "mLogParams", "", "login", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "loginCheck", "isPortrait", "report", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/abs/IRoomData;", "userId", "isAnchor", "userProfileEvent", "Lcom/bytedance/android/livesdk/chatroom/event/UserProfileEvent;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "isVertical", "vsmain-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VSReportServiceImpl implements IVSReportService {
    private final CompositeDisposable mCompositeDisposable;
    private boolean mIsFetchingReasons;

    public static final class a extends h<IBaseUser> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSReportServiceImpl f117753a;

        public a(VSReportServiceImpl r100) {
            this.f117753a = r100;
        }

        @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            Intrinsics.checkNotNullParameter(r100, "d");
            VSReportServiceImpl.access$getMCompositeDisposable$p(this.f117753a).add(r100);
        }
    }

    public VSReportServiceImpl() {
        this.mCompositeDisposable = new CompositeDisposable();
    }

    public static final /* synthetic */ CompositeDisposable access$getMCompositeDisposable$p(VSReportServiceImpl r100) {
        return r100.mCompositeDisposable;
    }

    private final boolean login(Context r100) {
        if (((f) TTLiveSDKContext.getHostService()).h().isLogin() == true) goto L6;
        com.bytedance.android.livesdk.user.f r101 = ((f) TTLiveSDKContext.getHostService()).h();
        l.a r102 = new l.a();
        r102.f158685a = s1.B(R.string.ttlive_core_login_dialog_message);
        r102.f158687c = -1;
        r102.f158689e = "live_detail";
        r102.f158691g = "user_report";
        r102.f158688d = "popup";
        r101.login(r100, new l(r102)).subscribe(new a(this));
        return false;
    L6:
        return true;
    }

    @Override // com.bytedance.android.live.base.service.IVSReportService
    public boolean loginCheck(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == true) goto L9;
        VideoContext r102 = VideoContext.n0(r100);
        if (r102 == null) goto L7;
        r102.l0();
    L7:
        b.a().post(new HorizontalPlayEvent(1, "report"));
    L9:
        return login(r100);
    }

    @Override // com.bytedance.android.live.base.service.IVSReportService
    public void logReport(boolean r110, String r111, String r112, String r113, String r114, ViewModel r115, String r116) {
        Intrinsics.checkNotNullParameter(r111, "toUserId");
        Intrinsics.checkNotNullParameter(r112, "toCommentId");
        Intrinsics.checkNotNullParameter(r113, "reportType");
        Intrinsics.checkNotNullParameter(r114, "requestPage");
        logReport(r110, r111, r112, r113, r114, r115, r116, new LinkedHashMap());
    }

    public final void logReport(boolean r100, String r101, String r102, String r103, String r104, ViewModel r105, String r106, Map<String, String> r107) {
        Intrinsics.checkNotNullParameter(r101, "toUserId");
        Intrinsics.checkNotNullParameter(r102, "toCommentId");
        Intrinsics.checkNotNullParameter(r103, "reportType");
        Intrinsics.checkNotNullParameter(r104, "requestPage");
        Intrinsics.checkNotNullParameter(r107, "mLogParams");
        r107.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r101);
        r107.put("to_comment_id", r102);
        r107.put("report_type", r103);
        r107.put("request_page", r104);
        if (r106 == null) goto L5;
        r107.put("to_comment_type", r106);
    L5:
        if (r105 != null) goto L7;
        return;
    L7:
        if ((r105 instanceof DataCenter) == false) goto L21;
        DataCenter r108 = (DataCenter) r105;
        VSDataContext r109 = VSDataContext.a.c(VSDataContext.Companion, r108);
        if (r109 == null) goto L15;
        m<Boolean> r110 = r109.isVSVideo();
        if (r110 == null) goto L15;
        boolean r111 = true;
        if (r110.getValue().booleanValue() != true) goto L15;
    L16:
        if (r111 == false) goto L18;
        com.bytedance.android.livesdk.vs.f.a(r108).c("user_report", r107, new Object[0]);
        return;
    L18:
        com.bytedance.android.livesdk.vs.f.a(r108).c("live_user_report", r107, new Object[0]);
        return;
    L15:
        r111 = false;
        goto L16
    }

    @Override // com.bytedance.android.live.base.service.IVSReportService
    public boolean report(IRoomData r310, Context r311, String r312, boolean r313, UserProfileEvent r314, User r315, boolean r316, ViewModel r317) {
        Intrinsics.checkNotNullParameter(r312, "userId");
        String r100 = "user";
        Intrinsics.checkNotNullParameter(r315, "user");
        Boolean r210 = Boolean.FALSE;
        if (r310 != null) goto L5;
        return false;
    L5:
        if ((r311 instanceof Activity) == true) goto L8;
        return false;
    L8:
        if (this.mIsFetchingReasons == false) goto L11;
        return false;
    L11:
        if (r314 == null) goto L18;
        if (r314.forceNoRotate != true) goto L18;
        if (login(r311) == true) goto L20;
        return false;
    L20:
        int r101 = i.f495747a;
        if (NetworkUtils.isNetworkAvailable(r311) == true) goto L24;
        f2.b(R.string.ttlive_core_network_unavailable, 0);
        return true;
    L24:
        f r102 = (f) TTLiveSDKContext.getHostService();
        if (r102.f157993c != null) goto L28;
        r102.f157993c = new com.bytedance.android.livesdk.share.h(r102.f157991a.share());
    L28:
        if (r102.f157993c != null) goto L30;
        return false;
    L30:
        if (r313 == false) goto L32;
        Object r103 = Long.valueOf(r310.getRoomId());
        r100 = "live";
    L33:
        boolean r104 = r310 instanceof RoomCompatDelegate;
        if (r104 == false) goto L37;
        ((RoomCompatDelegate) r310).getLiveRoom();
    L39:
        if (r314 == null) goto L41;
        String r105 = r314.mReportSource;
    L43:
        if (TextUtils.equals("personal_profile", r105) == false) goto L45;
        r100 = "live_comment";
    L45:
        String r211 = r100;
        if (r314 == null) goto L48;
        String r106 = r314.mSource;
    L50:
        if (TextUtils.equals(r106, UserProfileEvent.SOURCE_VSTOPIC_HEAD) == true) goto L58;
        if (r314 == null) goto L53;
        String r107 = r314.mSource;
    L55:
        if (TextUtils.equals(r107, UserProfileEvent.SOURCE_VSTOPIC) == true) goto L58;
        boolean r108 = false;
    L60:
        if (r108 == true) goto L62;
    L124:
        boolean r109 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a;
        if (r109 == false) goto L216;
        if (r314 == null) goto L128;
        String r110 = r314.mReportSource;
    L130:
        if (r2.a(r110) == false) goto L216;
        if (TextUtils.isEmpty(oc.f120892a.getValue()) == true) goto L216;
        String r111 = r310.getOwner().getCastSecUid();
        long r112 = r310.getRoomId();
        String r113 = o.a(((IUserService) k.n(IUserService.class)).user().b());
        if (r314 == null) goto L136;
        String r114 = r314.mReportSource;
    L138:
        if (Intrinsics.areEqual(PbRequest.SwitchType.PK, r114) == true) goto L162;
        if (r314 == null) goto L141;
        String r115 = r314.mReportSource;
    L143:
        if (Intrinsics.areEqual("anchor_linkmic", r115) == true) goto L162;
        if (r314 == null) goto L147;
        String r116 = r314.mReportSource;
    L149:
        if (Intrinsics.areEqual("audience_audio", r116) == true) goto L157;
        if (r314 == null) goto L152;
        String r117 = r314.mReportSource;
    L154:
        if (Intrinsics.areEqual("audience_linkmic", r117) == true) goto L157;
        String r118 = "";
    L163:
        String r119 = r111;
        long r120 = r112;
        String r212 = r113;
        String r213 = "";
        String r214 = r213;
    L165:
        if (r118 != null) goto L167;
        String r215 = "";
    L168:
        if (r314 == null) goto L170;
        String r216 = r314.mReportTypeForLog;
    L171:
        j3 r121 = new j3(r119, r120, r212, r215, r213, r214, r216, r315.isVcdContentAuthorized());
        if (r314 == null) goto L174;
        String r122 = r314.mSource;
    L176:
        if (TextUtils.equals("personal_profile", r122) == true) goto L184;
        if (r314 == null) goto L179;
        String r123 = r314.mSource;
    L181:
        if (TextUtils.equals(UserProfileEvent.SOURCE_BARRAGE, r123) == true) goto L184;
        boolean r124 = false;
    L185:
        IReportService r125 = (IReportService) k.f(IReportService.class);
        if (r125 == null) goto L194;
        if (r314 == null) goto L189;
        String r126 = r314.mSource;
    L190:
        if (r314 == null) goto L192;
        String r127 = r314.mReportTypeForLog;
    L193:
        String r128 = r125.getReportType(r126, r127, r124);
    L195:
        r121.f571928g = r128;
        IReportService r129 = (IReportService) k.f(IReportService.class);
        if (r129 == null) goto L204;
        if (r314 == null) goto L199;
        String r130 = r314.mSource;
    L200:
        if (r314 == null) goto L202;
        String r131 = r314.mReportTypeForLog;
    L203:
        String r132 = r129.getRequestPage(r130, r131);
    L205:
        r121.f571930i = r132;
        b.a().post(r121);
        if (r104 == false) goto L214;
        EpisodeExtraInfo r133 = ((RoomCompatDelegate) r310).getLiveRoom().getEpisodeExtra2();
        if (r133 == null) goto L214;
        IBaseEpisodeMod r134 = r133.getEpisodeMod();
        if (r134 == null) goto L214;
        if (r134.getEpisodeStage() != EpisodeMod.EpisodeStageType.LIVE) goto L214;
        IVSReportService.b.a(this, true, r103.toString(), "report_official_account", UserProfileEvent.DATA_TYPE_CARD_ANCHOR, r317);
    L215:
        return true;
    L214:
        IVSReportService.b.a(this, false, r103.toString(), "report_official_account", UserProfileEvent.DATA_TYPE_CARD_ANCHOR, r317);
        goto L215
    L202:
        r131 = "";
        goto L203
    L199:
        r130 = null;
        goto L200
    L204:
        r132 = null;
        goto L205
    L192:
        r127 = "";
        goto L193
    L189:
        r126 = null;
        goto L190
    L194:
        r128 = null;
        goto L195
    L179:
        r123 = null;
    L184:
        r124 = true;
        goto L185
    L174:
        r122 = null;
        goto L176
    L170:
        r216 = null;
        goto L171
    L167:
        r215 = r118;
        goto L168
    L152:
        r117 = null;
    L157:
        String r135 = r315.getCastSecUid();
        if (TextUtils.isEmpty(r135) == false) goto L160;
        String r136 = r315.getIdString();
    L161:
        r118 = r314.mReportSource;
        r119 = r111;
        r120 = r112;
        r212 = r113;
        r213 = r135;
        r214 = r136;
        goto L165
    L160:
        r136 = "";
        goto L161
    L147:
        r116 = null;
        goto L149
    L141:
        r115 = null;
    L162:
        r111 = r315.getCastSecUid();
        r113 = r315.getCastSecUid();
        r112 = r315.getLiveRoomId();
        r118 = r314.mReportSource;
        goto L163
    L136:
        r114 = null;
        goto L138
    L128:
        r110 = null;
    L216:
        if (r313 == false) goto L271;
        if (r109 == false) goto L271;
        if (TextUtils.isEmpty(oc.f120892a.getValue()) == true) goto L271;
        if (ui1.f121378a.getValue().booleanValue() == false) goto L271;
        j3 r137 = new j3(r310.getOwner().getCastSecUid(), r310.getRoomId(), o.a(((IUserService) k.n(IUserService.class)).user().b()));
        if (r314 == null) goto L225;
        String r138 = r314.mReportTypeForLog;
    L226:
        r137.f571928g = r138;
        if (r314 == null) goto L229;
        String r139 = r314.mSource;
    L231:
        if (TextUtils.equals("personal_profile", r139) == true) goto L239;
        if (r314 == null) goto L234;
        String r140 = r314.mSource;
    L236:
        if (TextUtils.equals(UserProfileEvent.SOURCE_BARRAGE, r140) == true) goto L239;
        boolean r141 = false;
    L240:
        IReportService r142 = (IReportService) k.f(IReportService.class);
        if (r142 == null) goto L249;
        if (r314 == null) goto L244;
        String r143 = r314.mSource;
    L245:
        if (r314 == null) goto L247;
        String r144 = r314.mReportTypeForLog;
    L248:
        String r145 = r142.getReportType(r143, r144, r141);
    L250:
        r137.f571928g = r145;
        IReportService r146 = (IReportService) k.f(IReportService.class);
        if (r146 == null) goto L259;
        if (r314 == null) goto L254;
        String r147 = r314.mSource;
    L255:
        if (r314 == null) goto L257;
        String r148 = r314.mReportTypeForLog;
    L258:
        String r149 = r146.getRequestPage(r147, r148);
    L260:
        r137.f571930i = r149;
        b.a().post(r137);
        if (r104 == false) goto L269;
        EpisodeExtraInfo r150 = ((RoomCompatDelegate) r310).getLiveRoom().getEpisodeExtra2();
        if (r150 == null) goto L269;
        IBaseEpisodeMod r151 = r150.getEpisodeMod();
        if (r151 == null) goto L269;
        if (r151.getEpisodeStage() != EpisodeMod.EpisodeStageType.LIVE) goto L269;
        IVSReportService.b.a(this, true, r103.toString(), "report_official_account", UserProfileEvent.DATA_TYPE_CARD_ANCHOR, r317);
    L270:
        return true;
    L269:
        IVSReportService.b.a(this, false, r103.toString(), "report_official_account", UserProfileEvent.DATA_TYPE_CARD_ANCHOR, r317);
        goto L270
    L257:
        r148 = "";
        goto L258
    L254:
        r147 = null;
        goto L255
    L259:
        r149 = null;
        goto L260
    L247:
        r144 = "";
        goto L248
    L244:
        r143 = null;
        goto L245
    L249:
        r145 = null;
        goto L250
    L234:
        r140 = null;
    L239:
        r141 = true;
        goto L240
    L229:
        r139 = null;
        goto L231
    L225:
        r138 = null;
    L271:
        if (r104 == false) goto L279;
        EpisodeExtraInfo r152 = ((RoomCompatDelegate) r310).getLiveRoom().getEpisodeExtra2();
        if (r152 == null) goto L279;
        IBaseEpisodeMod r153 = r152.getEpisodeMod();
        if (r153 == null) goto L279;
        if (r153.getEpisodeStage() != EpisodeMod.EpisodeStageType.LIVE) goto L279;
        IVSReportService.b.a(this, true, r103.toString(), "report_user", UserProfileEvent.DATA_TYPE_CARD_SEND_GIFT_INFO, r317);
    L280:
        ShareParams.Builder r154 = ShareParams.buildUponParams(r103.toString(), r312);
        r154.setRoomId(r310.getRoomId());
        ((ILiveShareService) k.n(ILiveShareService.class)).share(new i81.a(null, (Activity) r311, null, r154.build(), null, null, null, null, null, null, r211, r210, null, null, null, null, false), "VSReportServiceImpl", LiveShareType.REPORT_DIALOG, null);
        return false;
    L279:
        IVSReportService.b.a(this, false, r103.toString(), "report_user", UserProfileEvent.DATA_TYPE_CARD_SEND_GIFT_INFO, r317);
        goto L280
    L62:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117920a == false) goto L64;
    L65:
        if (r314 == null) goto L123;
        u r155 = r314.mCommentReportModel;
        if (r155 == null) goto L123;
        if ((!Intrinsics.areEqual(r314.mSource, UserProfileEvent.SOURCE_VSTOPIC)) == false) goto L72;
        String r156 = r103.toString();
        String r157 = r314.getUserIdStr();
        String r158 = r314.reportType;
        String r159 = r314.requestPage;
        LinkedHashMap r160 = new LinkedHashMap();
        r160.put(VSConstants.KEY_TO_COMMENT_CATEGORY, r314.toCommentCategory);
        r160.put(VSConstants.KEY_IS_FROM_AT_USER_NICKNAME, String.valueOf(r314.isFromUserNickname));
        r160.put(VSConstants.KEY_TO_DISCUSSION_BOARD_COMMENT_ID, r314.toDiscussionBoardCommentId);
        Unit r161 = Unit.INSTANCE;
        logReport(true, r156, r157, r158, r159, r317, "", r160);
    L72:
        Activity r162 = (Activity) r311;
        int r163 = xp1.b.f564697a;
        Intrinsics.checkNotNullParameter(r162, "activity");
        Intrinsics.checkNotNullParameter(r315, "mUser");
        Intrinsics.checkNotNullParameter(r310, "mRoom");
        Intrinsics.checkNotNullParameter(r155, "commentReportModel");
        String r164 = r314.mReportTypeForLog;
        if (r164 != null) goto L75;
        r164 = "";
    L75:
        String r165 = nl.f120842a.getValue();
        ita.l r166 = new ita.l(r165);
        r166.c("comment", Uri.encode(r155.b()));
        r166.c("sec_reported_user_id", r155.c());
        r166.c("reported_user_id", String.valueOf(r155.d()));
        r166.b("msg_id", r155.a());
        r166.a("chat_type", r155.getType());
        r166.b("room_id", r310.getId());
        r166.c("show_type", r164);
        String r167 = r314.reportType;
        if (r167 != null) goto L78;
        r167 = "report_message";
    L78:
        r166.c("report_type", r167);
        String r168 = r314.requestPage;
        if (r168 != null) goto L81;
        r168 = "";
    L81:
        r166.c("request_page", r168);
        com.bytedance.android.livesdk.log.filter.o r169 = com.bytedance.android.livesdk.log.u.l().c(x.class);
        if ((r169 instanceof n0) == false) goto L92;
        n0 r170 = (n0) r169;
        if (r170.f153291b.containsKey("enter_from_merge") == false) goto L87;
        r166.c("enter_from_merge", r170.f153291b.get("enter_from_merge"));
    L87:
        if (r170.f153291b.containsKey("enter_method") == false) goto L90;
        r166.c("enter_method", r170.f153291b.get("enter_method"));
    L90:
        if (r170.f153291b.containsKey("action_type") == false) goto L92;
        r166.c("action_type", r170.f153291b.get("action_type"));
    L92:
        com.bytedance.android.livesdk.log.filter.o r171 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if ((r171 instanceof s0) == false) goto L104;
        s0 r172 = (s0) r171;
        if (r172.f153291b.containsKey("anchor_id") == false) goto L98;
        r166.c("anchor_id", r172.f153291b.get("anchor_id"));
    L98:
        if (r172.f153291b.containsKey("log_pb") == false) goto L101;
        r166.c("log_pb", r172.f153291b.get("log_pb"));
    L101:
        if (r172.f153291b.containsKey("request_id") == false) goto L104;
        r166.c("request_id", r172.f153291b.get("request_id"));
    L104:
        if (r315.isVcdContentAuthorized() == false) goto L106;
        String r173 = "1";
    L107:
        r166.c("is_reported_user_authorized", r173);
        r166.c(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_LAYOUT, "normal");
        int r174 = xp1.a.f564696a[r310.getStreamType().ordinal()];
        String r175 = "video_live";
        if (r174 == 1) goto L112;
        if (r174 == 2) goto L111;
        String r176 = "video_live";
    L114:
        if (Intrinsics.areEqual(r314.reportType, "report_discussion_message_user") == false) goto L116;
        r166.c("report_scene", "vs");
    L117:
        r166.c("live_type", r175);
        r166.c("is_sale", "0");
        r166.c("livesdk_profile_hide_confirm", "0");
        if (StringsKt.startsWith$default(r165, AppConstants.SCHEME_SS_LOCAL, false, 2, null) == false) goto L122;
        IBaseLiveActionHandler r177 = (IBaseLiveActionHandler) k.f(IBaseLiveActionHandler.class);
        if (r177 == null) goto L123;
        r177.handle(com.bytedance.android.live.core.utils.a.d(), r166.d());
        goto L123
    L122:
        ((f) TTLiveSDKContext.getHostService()).a().openLiveBrowser(r166.d(), new Bundle(), r162);
        goto L123
    L116:
        r175 = r176;
        goto L117
    L111:
        r176 = PriorityModule.SCENE_THIRD_PARTY;
        goto L114
    L112:
        r176 = "voice_live";
        goto L114
    L106:
        r173 = "0";
    L123:
        return true;
    L64:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.f117922c == false) goto L124;
    L53:
        r107 = null;
    L58:
        r108 = true;
        goto L60
    L48:
        r106 = null;
        goto L50
    L41:
        r105 = null;
        goto L43
    L37:
        if ((r310 instanceof EpisodeCompatDelegate) == false) goto L39;
        ((EpisodeCompatDelegate) r310).getEpisode();
        goto L39
    L32:
        r103 = r312;
    L18:
        if (loginCheck(r311, r316) == true) goto L20;
        return false;
    }
}
