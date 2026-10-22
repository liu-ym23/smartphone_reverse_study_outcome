package com.bytedance.android.live.room.report;

import am2.n;
import am2.x;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.room.api.IReportService;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.oc;
import com.bytedance.android.livesdk.config.pc;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.r2;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104J\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\u001e\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J.\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0017J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016JL\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001d\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\u0016J8\u0010#\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00152\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J$\u0010'\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020%H\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010)2\u0006\u0010(\u001a\u00020\u0012H\u0016J\u001c\u0010*\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/bytedance/android/live/room/report/ReportService;", "Lcom/bytedance/android/live/room/api/IReportService;", "Landroid/net/Uri$Builder;", "appendExtraParam", "", "key", "value", "appendQueryParameterIfNoNull", "Lcom/bytedance/android/live/room/api/userinfo/event/ReportConstant$BusinessSource;", "businessSource", "Lcom/bytedance/android/live/base/model/user/User;", "targetUser", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdk/chatroom/event/UserProfileEvent;", "userProfileEvent", "", "reportWithUserProfileEvent", "Ly71/a;", "reportParamsWrapper", "report", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "fromSource", "reportSource", "reportTypeForLog", "Lzg1/u;", "commentReportModel", "Lzg1/r2;", "reportAnchorEvent", "reportWithReportAnchorEvent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "anchor", "Landroid/content/DialogInterface$OnDismissListener;", "dismissCallback", "screenShotReport", "reportType", "", "isReportMessage", "getReportType", "params", "Lcom/bytedance/android/live/room/api/report/ReportObject;", "getRequestPage", "TAG", "Ljava/lang/String;", "Lcom/bytedance/android/live/room/report/LiveReportManager;", "reportManager$delegate", "Lkotlin/Lazy;", "getReportManager", "()Lcom/bytedance/android/live/room/report/LiveReportManager;", "reportManager", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ReportService implements IReportService {
    private final String TAG;
    private final Lazy reportManager$delegate;

    private final LiveReportManager getReportManager() {
        return (LiveReportManager) this.reportManager$delegate.getValue();
    }

    public ReportService() {
        this.TAG = "ReportService";
        this.reportManager$delegate = LazyKt.lazy(ReportService$reportManager$2.INSTANCE);
    }

    private final Uri.Builder appendExtraParam(Uri.Builder r100) {
        Map<String, ? extends String> r101 = pc.f120967a.getValue();
        if (r101 == null) goto L8;
        Iterator<Map.Entry<String, ? extends String>> r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<String, ? extends String> r103 = r102.next();
        r100.appendQueryParameter(r103.getKey(), r103.getValue());
    L8:
        return r100;
    }

    @Override // com.bytedance.android.live.room.api.report.IMiddlewareReportService
    public ReportObject getReportType(y71.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        int r101 = g.f100250k;
        g r102 = g.a.a(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return f.a(r102);
    }

    @Override // com.bytedance.android.live.room.api.IReportService, com.bytedance.android.live.room.api.report.IMiddlewareReportService
    public void report(y71.a r100) {
        Intrinsics.checkNotNullParameter(r100, "reportParamsWrapper");
        Map<String, String> r101 = ReportTracer.f100240a;
        ReportTracer.h(r100.f566580i, r100.f566572a, r100.f566573b);
        int r102 = c.f100247a;
        if (c.c(r100.f566580i, r100.f566572a, r100.f566573b) == true) goto L5;
        return;
    L5:
        int r103 = g.f100250k;
        g r104 = g.a.a(r100);
        if (r104 != null) goto L8;
        return;
    L8:
        getReportManager().c(r104);
    }

    @Override // com.bytedance.android.live.room.api.IReportService, com.bytedance.android.live.room.api.report.IMiddlewareReportService
    public String getRequestPage(String r100, String r101) {
        e.f100249a.getClass();
        return e.a.a(r100, r101);
    }

    private final Uri.Builder appendQueryParameterIfNoNull(Uri.Builder r100, String r101, String r102) {
        if (r102 != null) goto L4;
    L7:
        boolean r103 = true;
    L8:
        if (r103 == true) goto L10;
        r100.appendQueryParameter(r101, r102);
    L10:
        return r100;
    L4:
        if (r102.length() == 0) goto L7;
        r103 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.room.api.IReportService, com.bytedance.android.live.room.api.report.IMiddlewareReportService
    public String getReportType(String r100, String r101, boolean r102) {
        return e.f100249a.getType(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.room.api.IReportService
    public void reportWithReportAnchorEvent(ReportConstant$BusinessSource r110, r2 r111, Room r112) {
        Intrinsics.checkNotNullParameter(r110, "businessSource");
        Map<String, String> r100 = ReportTracer.f100240a;
        Intrinsics.checkNotNullParameter(r110, "businessSource");
        Map<String, String> r101 = ReportTracer.f100240a;
        if (r101 == null) goto L5;
        ((LinkedHashMap) r101).clear();
    L5:
        ReportTracer.f100240a = null;
        LinkedHashMap r102 = new LinkedHashMap();
        ReportTracer.f100240a = r102;
        String r103 = (String) r102.put("business_source", r110.getBusinessType());
        Map<String, String> r104 = ReportTracer.f100240a;
        if (r104 == null) goto L16;
        IUserService r105 = (IUserService) k.f(IUserService.class);
        if (r105 == null) goto L14;
        com.bytedance.android.livesdk.user.f r106 = r105.user();
        if (r106 == null) goto L14;
        IUser r107 = r106.b();
        if (r107 == null) goto L14;
        String r108 = r107.getIdString();
    L15:
        String r109 = r104.put("current_user_id", String.valueOf(r108));
    L14:
        r108 = null;
    L16:
        Map<String, String> r113 = ReportTracer.f100240a;
        if (r113 == null) goto L27;
        IUserService r114 = (IUserService) k.f(IUserService.class);
        if (r114 == null) goto L25;
        com.bytedance.android.livesdk.user.f r115 = r114.user();
        if (r115 == null) goto L25;
        IUser r116 = r115.b();
        if (r116 == null) goto L25;
        Intrinsics.checkNotNullParameter(r116, "$this$secUidExt");
        String r117 = r116.getCastSecUid();
    L26:
        String r118 = r113.put("sec_current_user_id", String.valueOf(r117));
    L25:
        r117 = null;
    L27:
        Map<String, String> r119 = ReportTracer.f100240a;
        if (r119 == null) goto L33;
        if (r112 == null) goto L31;
        Long r120 = Long.valueOf(r112.getId());
    L32:
        String r121 = r119.put("room_id", String.valueOf(r120));
        goto L33
    L31:
        r120 = null;
    L33:
        Map<String, String> r122 = ReportTracer.f100240a;
        if (r122 == null) goto L39;
        if (r112 == null) goto L37;
        String r123 = r112.getOwnerUserIdString();
    L38:
        String r124 = r122.put("anchor_id", String.valueOf(r123));
        goto L39
    L37:
        r123 = null;
    L39:
        Map<String, String> r125 = ReportTracer.f100240a;
        if (r125 == null) goto L48;
        if (r112 == null) goto L45;
        IBaseUser r126 = r112.getOwner();
        if (r126 == null) goto L45;
        Intrinsics.checkNotNullParameter(r126, "$this$secUidExt");
        String r127 = r126.getCastSecUid();
    L46:
        String r128 = r125.put("sec_anchor_id", String.valueOf(r127));
    L45:
        r127 = null;
    L48:
        if (r111 == null) goto L64;
        Map<String, String> r129 = ReportTracer.f100240a;
        if (r129 == null) goto L55;
        String r130 = r111.f571922a;
        if (r130 != null) goto L54;
        r130 = "";
    L54:
        String r131 = r129.put("sec_anchor_id", r130);
    L55:
        Map<String, String> r132 = ReportTracer.f100240a;
        if (r132 == null) goto L58;
        String r133 = r132.put("room_id", String.valueOf(r111.f571923b));
    L58:
        Map<String, String> r134 = ReportTracer.f100240a;
        if (r134 == null) goto L64;
        String r135 = r111.f571924c;
        if (r135 != null) goto L63;
        r135 = "";
    L63:
        String r136 = r134.put("sec_user_id", r135);
    L64:
        Map<String, String> r137 = ReportTracer.f100240a;
        if (r137 == null) goto L71;
        o r138 = u.l().c(x.class);
        o r139 = u.l().c(Room.class);
        if (r138 == null) goto L69;
        r138.a(r137);
    L69:
        if (r139 == null) goto L71;
        r139.a(r137);
    L71:
        ReportTracer.b(ReportTracer.EventName.call_start);
        ReportTracer.c(ReportTracer.EventName.call_function, ReportTracer.CallFunction.reportWithReportAnchorEvent);
        int r140 = c.f100247a;
        Intrinsics.checkNotNullParameter(r110, "businessSource");
        ReportTracer.b(ReportTracer.EventName.params_check);
        boolean r141 = false;
        if (c.f() == true) goto L74;
    L92:
        if (r141 == true) goto L94;
        return;
    L94:
        if (r112 != null) goto L96;
        return;
    L96:
        if (r111 != null) goto L98;
        return;
    L98:
        LiveReportManager r142 = getReportManager();
        r142.getClass();
        Intrinsics.checkNotNullParameter(r110, "businessSource");
        Intrinsics.checkNotNullParameter(r112, "room");
        Intrinsics.checkNotNullParameter(r111, "event");
        ReportTracer.b(ReportTracer.EventName.direct_report_anchor);
        xs2.b.a().post(new r2("", 0, ""));
        RoomContext r143 = RoomContext.a.c(RoomContext.Companion, null, r112.getRoomId(), 1);
        if (r143 == null) goto L105;
        i<Boolean> r144 = r143.isAnchor();
        if (r144 == null) goto L105;
        if (r144.getValue().booleanValue() != true) goto L105;
        LiveReportManager.d(r112, r111, null);
        return;
    L105:
        r142.e(r112, r111, null);
        return;
    L74:
        if (c.e() == false) goto L92;
        if (r111 != null) goto L79;
        d.a("reportAnchorEvent is null");
        ReportTracer.f("reportAnchorEvent is null");
    L87:
        boolean r145 = false;
    L88:
        if (r145 == false) goto L92;
        if (c.b(r112) == false) goto L92;
        r141 = true;
        goto L92
    L79:
        if (c.d(r111.f571922a) == false) goto L81;
    L86:
        d.a("reportAnchorEvent's secAnchorId or secUserId is empty, or roomId is 0L");
        ReportTracer.f("reportAnchorEvent's secAnchorId or secUserId is empty, or roomId is 0L");
        goto L87
    L81:
        if (r111.f571923b == 0) goto L86;
        if (c.d(r111.f571924c) == true) goto L86;
        r145 = true;
        goto L88
    }

    @Override // com.bytedance.android.live.room.api.IReportService
    @Deprecated(message = "不要用这个方法！！！！，这是方法是为了兼容资料卡的旧逻辑")
    public void reportWithUserProfileEvent(ReportConstant$BusinessSource r110, User r111, IRoom r112, UserProfileEvent r113) {
        Intrinsics.checkNotNullParameter(r110, "businessSource");
        ReportTracer.h(r110, r111, r112);
        ReportTracer.c(ReportTracer.EventName.call_function, ReportTracer.CallFunction.reportWithUserProfileEvent);
        int r100 = c.f100247a;
        Intrinsics.checkNotNullParameter(r110, "businessSource");
        ReportTracer.b(ReportTracer.EventName.params_check);
        boolean r101 = false;
        if (c.f() == true) goto L5;
    L17:
        if (r101 == true) goto L19;
        return;
    L19:
        int r102 = g.f100250k;
        Intrinsics.checkNotNullParameter(r110, "businessSource");
        ReportTracer.b(ReportTracer.EventName.generate_report_params);
        g r103 = null;
        if (r113 == null) goto L22;
        String r104 = r113.mSource;
    L23:
        if (r113 == null) goto L25;
        String r105 = r113.mReportSource;
    L26:
        if (r113 == null) goto L28;
        String r106 = r113.mReportTypeForLog;
    L29:
        if (r113 == null) goto L31;
        zg1.u r107 = r113.mCommentReportModel;
    L32:
        ReportTracer.a(r104, r105, r106, r107);
        if (r111 == null) goto L50;
        if (r112 == null) goto L50;
        if (r113 == null) goto L50;
        String r108 = r113.mSource;
        if (r108 != null) goto L40;
        String r109 = "";
    L41:
        String r114 = r113.mReportSource;
        if (r114 != null) goto L44;
        String r115 = "";
    L45:
        String r116 = r113.mReportTypeForLog;
        if (r116 != null) goto L48;
        String r117 = "";
    L49:
        r103 = new g(r110, r111, r112, r109, r115, r117, r113.mCommentReportModel, Intrinsics.areEqual(r111.getIdString(), r112.getOwnerUserIdString()));
        goto L50
    L48:
        r117 = r116;
        goto L49
    L44:
        r115 = r114;
        goto L45
    L40:
        r109 = r108;
    L50:
        if (r103 != null) goto L52;
        return;
    L52:
        getReportManager().c(r103);
        return;
    L31:
        r107 = null;
        goto L32
    L28:
        r106 = null;
        goto L29
    L25:
        r105 = null;
        goto L26
    L22:
        r104 = null;
        goto L23
    L5:
        if (c.e() == false) goto L17;
        if (c.a(r111) == false) goto L17;
        if (c.b(r112) == false) goto L17;
        if (r113 != null) goto L14;
        d.a("userProfileEvent is null");
        ReportTracer.f("userProfileEvent is null");
        boolean r118 = false;
    L15:
        if (r118 == false) goto L17;
        r101 = true;
        goto L17
    L14:
        r118 = true;
        goto L15
    }

    @Override // com.bytedance.android.live.room.api.IReportService, com.bytedance.android.live.room.api.report.IMiddlewareReportService
    public void reportWithUserProfileEvent(ReportConstant$BusinessSource r100, IBaseUser r101, IRoom r102, UserProfileEvent r103) {
        Intrinsics.checkNotNullParameter(r100, "businessSource");
        Intrinsics.checkNotNullParameter(r100, "businessSource");
        if ((r101 instanceof User) == true) goto L5;
        r101 = null;
    L5:
        User r104 = (User) r101;
        if (r104 != null) goto L9;
        return;
    L9:
        if ((r102 instanceof Room) == true) goto L11;
        r102 = null;
    L11:
        Room r105 = (Room) r102;
        if (r105 == null) goto L17;
        reportWithUserProfileEvent(r100, r104, r105, r103);
        return;
    }

    @Override // com.bytedance.android.live.room.api.IReportService
    public void screenShotReport(ReportConstant$BusinessSource r100, Context r101, User r102, Room r110, DialogInterface.OnDismissListener r111) {
        Intrinsics.checkNotNullParameter(r100, "businessSource");
        ReportTracer.h(r100, r102, r110);
        ReportTracer.c(ReportTracer.EventName.call_function, ReportTracer.CallFunction.screenShotReport);
        String r103 = null;
        if (r102 == null) goto L5;
        String r112 = r102.getCastSecUid();
    L7:
        if (r112 != null) goto L9;
    L12:
        boolean r113 = true;
    L13:
        if (r113 == false) goto L16;
        d.a("anchor secUid is empty");
        ReportTracer.f("anchor secUid is empty");
        return;
    L16:
        ReportTracer.b(ReportTracer.EventName.generate_screen_shot_report_url);
        String r114 = oc.f120892a.getValue();
        if (r114 != null) goto L19;
        return;
    L19:
        Uri.Builder r104 = UriProtector.parse(r114).buildUpon().appendQueryParameter("request_page", "live_screenshot").appendQueryParameter("sec_target_anchor_id", r102.getCastSecUid()).appendQueryParameter("type", "popup").appendQueryParameter(GXTemplateKey.GAIAX_LAYER_GRAVITY, "bottom");
        o r105 = u.l().c(x.class);
        if (r105 == null) goto L24;
        Map<String, String> r106 = r105.getMap();
        if (r106 == null) goto L24;
        String r107 = r106.get("enter_from_merge");
    L25:
        Uri.Builder r108 = appendQueryParameterIfNoNull(r104, "enter_from_merge", r107);
        ILiveService r109 = TTLiveService.getLiveService();
        if (r109 == null) goto L30;
        ILiveOntologyInfoManager r115 = r109.getLiveOntologyRecord();
        if (r115 == null) goto L30;
        String r116 = r115.getEnterFromMerge();
    L31:
        Uri.Builder r117 = appendQueryParameterIfNoNull(r108, ILiveRoomPlayFragmentConstant.EXTRA_VS_DRAWER_PAGE, r116);
        o r118 = u.l().c(n.class);
        if (r118 == null) goto L36;
        Map<String, String> r119 = r118.getMap();
        if (r119 == null) goto L36;
        r103 = r119.get("is_other_channel");
    L36:
        Uri r120 = appendQueryParameterIfNoNull(r117, "is_other_channel", r103).build();
        if ((!Intrinsics.areEqual("webcast_webview", r120.getHost())) == false) goto L39;
        r120 = appendExtraParam(UriProtector.parse("sslocal://webcast_webview").buildUpon().appendQueryParameter("url", r120.toString()).appendQueryParameter("type", "popup").appendQueryParameter(GXTemplateKey.GAIAX_LAYER_GRAVITY, "bottom")).build();
    L39:
        ReportTracer.b(ReportTracer.EventName.open_screen_shot_report_page);
        if (r111 == null) goto L44;
        ILiveActionHandler r121 = (ILiveActionHandler) k.f(ILiveActionHandler.class);
        if (r121 == null) goto L47;
        r121.handleWithCallback(r101, r120, r111);
    L47:
        ReportTracer.g();
        return;
    L44:
        ILiveActionHandler r122 = (ILiveActionHandler) k.f(ILiveActionHandler.class);
        if (r122 == null) goto L47;
        r122.handle(r101, r120);
    L30:
        r116 = null;
    L24:
        r107 = null;
        goto L25
    L9:
        if (r112.length() == 0) goto L12;
        r113 = false;
        goto L13
    L5:
        r112 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.room.api.IReportService
    public void report(ReportConstant$BusinessSource r110, User r111, Room r112, String r113, String r114, String r115, zg1.u r116) {
        Intrinsics.checkNotNullParameter(r110, "businessSource");
        ReportTracer.h(r110, r111, r112);
        ReportTracer.c(ReportTracer.EventName.call_function, ReportTracer.CallFunction.report);
        if (c.c(r110, r111, r112) == true) goto L5;
        return;
    L5:
        int r100 = g.f100250k;
        Intrinsics.checkNotNullParameter(r110, "businessSource");
        ReportTracer.b(ReportTracer.EventName.generate_report_params);
        ReportTracer.a(r113, r114, r115, r116);
        if (r111 == null) goto L20;
        if (r112 == null) goto L20;
        if (r113 != null) goto L12;
        String r101 = "";
    L13:
        if (r114 != null) goto L15;
        String r102 = "";
    L16:
        if (r115 != null) goto L18;
        String r103 = "";
    L19:
        g r104 = new g(r110, r111, r112, r101, r102, r103, r116, Intrinsics.areEqual(r111.getIdString(), r112.getOwnerUserIdString()));
    L21:
        if (r104 != null) goto L23;
        return;
    L23:
        getReportManager().c(r104);
        return;
    L18:
        r103 = r115;
        goto L19
    L15:
        r102 = r114;
        goto L16
    L12:
        r101 = r113;
    L20:
        r104 = null;
        goto L21
    }
}
