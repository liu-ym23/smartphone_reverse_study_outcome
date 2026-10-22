package com.bytedance.android.livesdk.announcement;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.config.sp0;
import com.bytedance.android.livesdk.config.vq;
import com.bytedance.android.livesdkapi.announcement.AnnounceCalendarInfo;
import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f103638a = 0;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.calendar.b f103639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AnnounceCalendarInfo f103640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f103641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f103642d;

        public a(com.bytedance.android.livesdk.calendar.b r100, Context r101, AnnounceCalendarInfo r102, List r103, String r104) {
            this.f103639a = r100;
            this.f103640b = r102;
            this.f103641c = r103;
            this.f103642d = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            ICalendarManager.ErrorCode r111 = (ICalendarManager.ErrorCode) r110;
            if (r111 != ICalendarManager.ErrorCode.Success) goto L5;
        L6:
            int r112 = x0.f103638a;
            com.bytedance.android.livesdk.calendar.b r113 = this.f103639a;
            AnnounceCalendarInfo r100 = this.f103640b;
            List<Integer> r101 = this.f103641c;
            String r102 = x0.c(this.f103642d);
            ICalendarManager.EventParams r103 = new ICalendarManager.EventParams();
            r103.setEventId(r102);
            if (r100 == null) goto L9;
            long r104 = r100.getStartTime();
        L10:
            r103.setStartTime(r104);
            r103.setEndTime(r103.getStartTime() + ((long) AnnouncementViewModel.HOUR_DURATION));
            String r105 = null;
            if (r100 == null) goto L13;
            String r106 = r100.getTitle();
        L14:
            r103.setTitle(r106);
            r103.setAlarmMinutes(15);
            r103.setScheduledWeekDays(r101);
            if (r100 == null) goto L17;
            r105 = r100.getDescroption();
        L17:
            r103.setDescription(r105);
            if (r113 == null) goto L64;
            Intrinsics.checkNotNullParameter(r103, "event");
        L53:
            th = move-exception;
            ALogger.throwable(5, "CalendarManager", "failed to add calendar event", th);
            Single r114 = Single.fromCallable(com.bytedance.android.livesdk.calendar.h.f104442a);
        L55:
            if (r114 == null) goto L65;
            Single<T> r115 = r114.subscribeOn(Schedulers.io());
            if (r115 == null) goto L66;
            Single<T> r116 = r115.observeOn(AndroidSchedulers.mainThread());
            if (r116 == null) goto L67;
            r116.subscribe(new y0(r102), new z0(r102));
            return;
        L67:
            return;
        L66:
            return;
        L65:
            return;
        L21:
            if (r103.getEventId() != null) goto L23;
            r114 = Single.fromCallable(com.bytedance.android.livesdk.calendar.d.f104435a);     // Catch: Throwable -> L53
            goto L55
        L23:
            String r107 = r103.getEventId();     // Catch: Throwable -> L53
            boolean r108 = false;
            if (r107 != null) goto L26;
        L29:
            boolean r109 = true;
        L30:
            if (r109 == true) goto L46;
            String r117 = r103.getTitle();     // Catch: Throwable -> L53
            if (r117 != null) goto L34;
        L37:
            boolean r118 = true;
        L38:
            if (r118 == true) goto L46;
            if (r103.getStartTime() <= 0) goto L46;
            if (r103.getEndTime() <= 0) goto L46;
            if (r103.getStartTime() > r103.getEndTime()) goto L46;
            r108 = true;
            goto L46
        L34:
            if (r117.length() == 0) goto L37;
            r118 = false;
        L46:
            if (r108 == true) goto L49;
            ALogger.e("CalendarManager", "invalid event params: " + r103);     // Catch: Throwable -> L53
            r114 = Single.fromCallable(com.bytedance.android.livesdk.calendar.e.f104436a);     // Catch: Throwable -> L53
            goto L55
        L49:
            if (r113.a() == true) goto L51;
            ALogger.e("CalendarManager", "no calendar permission: write=" + r113.a());     // Catch: Throwable -> L53
            r114 = Single.fromCallable(com.bytedance.android.livesdk.calendar.f.f104437a);     // Catch: Throwable -> L53
            goto L55
        L51:
            r114 = Single.create(new com.bytedance.android.livesdk.calendar.g(r113, r103));     // Catch: Throwable -> L53
            goto L55
        L26:
            if (r107.length() == 0) goto L29;
            r109 = false;
            goto L30
        L64:
            return;
        L13:
            r106 = null;
            goto L14
        L9:
            r104 = 0;
            goto L10
        L5:
            if (r111 == ICalendarManager.ErrorCode.NotFound) goto L6;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f103643a;

        public b(String r100) {
            this.f103643a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = x0.f103638a;
            ALogger.i("AudienceAnnounceCalendarUtil", "delete " + this.f103643a + " failed, reason " + ((Throwable) r100).getMessage());
        }
    }

    public static final class c implements o60.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f103644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f103645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.calendar.b f103646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f103647d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AnnounceCalendarInfo f103648e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f103649f;

        @Override // o60.e
        public final void onPermissionDenied(String... r100) {
            Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
            f2.b(R.string.ttlive_annocement_request_calendar_toast, 0);
        }

        @Override // o60.e
        public final void onPermissionGrant(String... r100) {
            Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
            if (this.f103644a == false) goto L5;
            int r101 = f.f103363a;
            f.f("livesdk_live_announce_calendar_add_success", this.f103645b);
            int r102 = x0.f103638a;
            x0.b(this.f103646c, this.f103647d, this.f103648e, null, this.f103649f);
            return;
        L5:
            int r103 = x0.f103638a;
            x0.e(this.f103646c, this.f103649f);
        }

        public c(boolean r100, Map r101, com.bytedance.android.livesdk.calendar.b r102, Context r103, AnnounceCalendarInfo r104, String r105) {
            this.f103644a = r100;
            this.f103645b = r101;
            this.f103646c = r102;
            this.f103647d = r103;
            this.f103648e = r104;
            this.f103649f = r105;
        }
    }

    public static final class d implements lm3.c.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f103650b;

        public d(Map r100) {
            this.f103650b = r100;
        }

        @Override // lm3.c.a
        public final void onAction(lm3.d r100) {
            SharedPrefHelper r101 = SharedPrefHelper.b(s1.getContext());
            if (r101.f("live.pref.PREF_ANNOUNCE_WAIT_SIGANAL", false) == false) goto L5;
            r101.l("live.pref.PREF_ANNOUNCE_ALWAYS_NOT_ADD", Boolean.TRUE);
            r101.a();
        L6:
            this.f103650b.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "cancel");
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_announce_calendar_click", this.f103650b, new Object[0]);
            return;
        L5:
            long r102 = System.currentTimeMillis() / ((long) 1000);
            int r103 = sp0.f121244a.getValue().intValue() * 86400;
            r101.l("live.pref.PREF_ANNOUNCE_WAIT_SIGANAL", Boolean.TRUE);
            r101.l("live.pref.PREF_ANNOUNCE_WAIT_TIMESTAMP", Long.valueOf(r102 + ((long) r103)));
            r101.a();
            goto L6
        }
    }

    public static final class e implements lm3.c.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f103651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f103652c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f103653d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f103654e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f103655f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ List f103656g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Map f103657h;

        public e(Context r100, int r101, long r102, String r103, String r104, List r105, Map r106) {
            this.f103651b = r100;
            this.f103652c = r101;
            this.f103653d = r102;
            this.f103654e = r103;
            this.f103655f = r104;
            this.f103656g = r105;
            this.f103657h = r106;
        }

        @Override // lm3.c.a
        public final void onAction(lm3.d r100) {
            SharedPrefHelper r101 = SharedPrefHelper.b(s1.getContext());
            r101.l("live.pref.PREF_ANNOUNCE_ALWAYS_ADD", Boolean.TRUE);
            r101.a();
            int r102 = x0.f103638a;
            x0.d(this.f103651b, this.f103652c, new AnnounceCalendarInfo(this.f103653d, this.f103654e, this.f103655f), this.f103656g, this.f103657h);
            this.f103657h.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, LocationMonitorConst.SUBMIT);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_announce_calendar_click", this.f103657h, new Object[0]);
        }
    }

    static {
    }

    public static String c(String r100) {
        return "announced_broadcast_event" + r100;
    }

    public static void e(com.bytedance.android.livesdk.calendar.b r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "appointmentId");
        String r102 = c(r101);
        if (r100 == null) goto L10;
        Single r103 = r100.b(r102);
        if (r103 == null) goto L11;
        Single r104 = r103.subscribeOn(AndroidSchedulers.mainThread());
        if (r104 == null) goto L12;
        r104.subscribe(new a1(r102), new b1(r102));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static long h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scheduledDate");
        Intrinsics.checkNotNullParameter(r101, "scheduledTime");
    L12:
        return 0;
    L5:
        if (r101.length() != 3) goto L8;
        r101 = "0".concat(r101);     // Catch: Exception -> L12
    L8:
        if (r100.equals("0") == false) goto L10;
        Date r102 = new Date(System.currentTimeMillis());     // Catch: Exception -> L12
        r100 = new SimpleDateFormat("yyyyMMdd").format(r102);     // Catch: Exception -> L12
    L10:
        StringBuffer r103 = new StringBuffer();     // Catch: Exception -> L12
        r103.append(r100);     // Catch: Exception -> L12
        r103.append(r101);     // Catch: Exception -> L12
        return new SimpleDateFormat("yyyyMMddHHmm").parse(r103.toString()).getTime() / ((long) 1000);
    }

    public static void b(com.bytedance.android.livesdk.calendar.b r100, Context r110, AnnounceCalendarInfo r111, List r112, String r113) {
        Intrinsics.checkNotNullParameter(r113, "appointmentId");
        String r101 = c(r113);
        if (r100 == null) goto L10;
        Single r102 = r100.b(r101);
        if (r102 == null) goto L11;
        Single r103 = r102.subscribeOn(AndroidSchedulers.mainThread());
        if (r103 == null) goto L12;
        r103.subscribe(new a(r100, r110, r111, r112, r113), new b(r101));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void d(Context r100, int r101, AnnounceCalendarInfo r102, List r110, Map r111) {
        com.bytedance.android.livesdk.calendar.b r103 = new com.bytedance.android.livesdk.calendar.b(r100);
        int r104 = f.f103363a;
        LinkedHashMap r105 = new LinkedHashMap();
        f.a(r105, r101);
        String r106 = (String) r111.get(IPerformanceManager.Params.is_anchor);
        String r107 = "";
        if (r106 != null) goto L5;
        r106 = "";
    L5:
        r105.put(IPerformanceManager.Params.is_anchor, r106);
        if (r110 != null) goto L8;
    L10:
        String r108 = "0";
    L11:
        r105.put("is_cycle", r108);
        String r109 = (String) r111.get("enter_method");
        if (r109 != null) goto L14;
        r109 = "";
    L14:
        r105.put("enter_method", r109);
        String r112 = (String) r111.get("enter_from");
        if (r112 != null) goto L17;
        r112 = "";
    L17:
        r105.put("enter_from", r112);
        String r113 = (String) r111.get("appointment_id");
        if (r113 != null) goto L20;
        r113 = "";
    L20:
        r105.put("appointment_id", r113);
        String r114 = (String) r111.get("enter_from_merge");
        if (r114 != null) goto L23;
        r114 = "";
    L23:
        r105.put("enter_from_merge", r114);
        if (r103.a() != true) goto L30;
        f.f("livesdk_live_announce_calendar_add_success", r105);
        String r115 = (String) r111.get("appointment_id");
        if (r115 == null) goto L29;
        r107 = r115;
    L29:
        b(r103, r100, r102, r110, r107);
        return;
    L30:
        IHostApp r116 = (IHostApp) jc1.k.f(IHostApp.class);
        if (r116 == null) goto L33;
        Activity r117 = r116.getCurrentActivity();
    L34:
        if (r117 == null) goto L42;
        String r118 = (String) r111.get("appointment_id");
        if (r118 != null) goto L38;
        String r119 = "";
    L39:
        f(r117, r103, r100, true, r102, r105, r119);
        return;
    L38:
        r119 = r118;
        goto L39
    L42:
        return;
    L33:
        r117 = null;
        goto L34
    L8:
        if ((!r110.isEmpty()) != true) goto L10;
        r108 = "1";
        goto L11
    }

    public static boolean a(Context r110, int r111, long r112, String r210, String r211, Map r212, List r213) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "anchorId");
        Intrinsics.checkNotNullParameter(r211, "nickName");
        Intrinsics.checkNotNullParameter(r212, "logParams");
        if (vq.f121470a.getValue().booleanValue() == true) goto L5;
        return false;
    L5:
        if (r213 == null) goto L7;
        String r100 = "1";
    L8:
        r212.put("is_cycle", r100);
        r212.put("enter_from", ActivityVO.APPOINTMENT);
        r212.put(IPerformanceManager.Params.is_anchor, "false");
        String r101 = "你预约了" + r211 + "的直播";
        kjc.c r102 = new kjc.c();
        if (3 != kjc.a.a()) goto L12;
        Uri.Builder r103 = UriProtector.parse("https://huoshan.zlinkurl.cn/JvBL4").buildUpon();
    L21:
        JSONObject r104 = new JSONObject();
        r104.put("user_id", r210);
        String r105 = r103.appendQueryParameter("schemeParams", r104.toString()).build().toString() + " 点击上方url可进入直播间";
        SharedPrefHelper r106 = SharedPrefHelper.b(s1.getContext());
        if (r106.f("live.pref.PREF_ANNOUNCE_ALWAYS_ADD", false) == false) goto L26;
        d(r110, r111, new AnnounceCalendarInfo(r112, r101, r105), r213, r212);
        return false;
    L26:
        if (r106.f("live.pref.PREF_ANNOUNCE_ALWAYS_NOT_ADD", false) == false) goto L29;
        return false;
    L29:
        if (r106.f("live.pref.PREF_ANNOUNCE_WAIT_SIGANAL", false) == false) goto L38;
        long r113 = r106.i("live.pref.PREF_ANNOUNCE_WAIT_TIMESTAMP", -1);
        long r114 = System.currentTimeMillis() / ((long) 1000);
        if (r113 > 0) goto L33;
        return false;
    L33:
        if (r114 <= r113) goto L40;
        g(r110, r111, r112, r101, r105, r213, r212);
        return true;
    L40:
        return false;
    L38:
        g(r110, r111, r112, r101, r105, r213, r212);
        return true;
    L12:
        if (2 != kjc.a.a()) goto L15;
        r103 = UriProtector.parse("https://l.douyin.com/ejemG").buildUpon();
        goto L21
    L15:
        if (4 != kjc.a.a()) goto L18;
        r103 = UriProtector.parse("https://z1.nextvid.net/8By7K").buildUpon();
        goto L21
    L18:
        if (r102.f503731b == true) goto L20;
        r103 = UriProtector.parse("https://z.douyin.com/eeSUd").buildUpon();
        goto L21
    L20:
        T r107 = r102.f503730a.f503729a;
        r103 = UriProtector.parse("https://z.douyin.com/eeSUd").buildUpon();
        goto L21
    L7:
        r100 = "0";
        goto L8
    }

    public static void f(Activity r100, com.bytedance.android.livesdk.calendar.b r101, Context r110, boolean r111, AnnounceCalendarInfo r112, Map r113, String r114) {
        SettingKey<Boolean> r102 = m60.i.f512260a;
        new m60.i.b(r100).b(new c(r111, r113, r101, r110, r112, r114), null, TokenCert.Companion.with("bpea-live_announcement_request_calendar"), new String[]{"android.permission.WRITE_CALENDAR"});
    }

    public static void g(Context r110, int r111, long r112, String r113, String r114, List r115, Map r210) {
        lm3.c r116 = new lm3.c();
        r116.f509864b = s1.B(R.string.ttlive_announce_delete_confirm_later);
        r116.f509865c = new d(r210);
        lm3.c r117 = new lm3.c();
        r117.f509864b = s1.B(R.string.ttlive_announce_delete_confirm_add_opt);
        r117.f509865c = new e(r110, r111, r112, r113, r114, r115, r210);
        lm3.d.a r100 = new lm3.d.a(r110);
        r100.f509870a = s1.B(R.string.ttlive_annocement_alert_dialog_title_opt_2);
        r100.f509871b = s1.B(R.string.ttlive_annocement_alert_dialog_content_opt_2);
        r100.f509874e = CollectionsKt.listOf(new lm3.c[]{r116, r117});
        r100.f509879j = false;
        r100.f509880k = Integer.valueOf(R.drawable.ttlive_announce_templete_dialog_bg);
        r100.a();
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_announce_calendar_show", r210, new Object[0]);
    }
}
