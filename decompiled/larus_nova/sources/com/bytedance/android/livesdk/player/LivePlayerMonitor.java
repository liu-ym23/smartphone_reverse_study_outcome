package com.bytedance.android.livesdk.player;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livesdk.config.dp0;
import com.bytedance.android.livesdk.config.w51;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.log.alog.TTLiveALogTag;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class LivePlayerMonitor extends BaseMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public lf2.a f154955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f154956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f154957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f154958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f154959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f154960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f0 f154961g;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SourceRoomType {
        public static final int MATCH_ROOM = 1;
        public static final int NORMAL = 0;
        public static final int REPLAY = 2;
        public static final int VS_VIDEO = 3;
    }

    public final long m() {
        lf2.a r100 = this.f154955a;
        if (r100 == null) goto L7;
        r100.getClass();
        long r101 = SystemClock.elapsedRealtime();
        long r102 = r100.f509046b;
    L5:
        long r103 = r101 - r102;
    L10:
        this.f154955a = null;
        this.f154956b = 0;
        return r103;
    L7:
        if (this.f154956b <= 0) goto L9;
        r101 = SystemClock.uptimeMillis();
        r102 = this.f154956b;
        goto L5
    L9:
        r103 = 0;
        goto L10
    }

    public LivePlayerMonitor() {
        this.f154956b = 0;
        this.f154958d = false;
        this.f154959e = 0;
        this.f154960f = 0;
    }

    public final void q(g0 r100) {
        if (this.f154958d == false) goto L6;
        return;
    L6:
        if (r100.f155370a == 115) goto L8;
        this.f154958d = true;
    L8:
        JSONObject r101 = new JSONObject();
        BaseMonitor.add(r101, "exit_code", r100.f155370a);
        String r102 = r100.f155371b;
        if (r102 == null) goto L11;
        BaseMonitor.add(r101, "exit_msg", r102);
    L11:
        BaseMonitor.add(r101, "room_id", r100.f155373d);
        BaseMonitor.add(r101, "real_error_code", 0);
        JSONObject r103 = r100.f155372c;
        if (r103 == null) goto L14;
        BaseMonitor.add(r101, "room_info", r103);
    L14:
        l(r101, r100.f155376g, r100.f155377h);
        r(r100.f155374e, r100.f155375f, r101);
        int r104 = w51.f121499a;
        wm0.a r105 = om0.c.h();
        if (r105 == null) goto L21;
        if (r100.a() == false) goto L19;
        r105.monitorStatus("ttlive_audience_leave_room_error", r100.f155370a, r101);
    L24:
        HashMap r106 = new HashMap();
        r106.put("service_name", "ttlive_audience_leave_room");
        r106.put("exit_code", String.valueOf(r100.f155370a));
        String r107 = r100.f155371b;
        if (r107 == null) goto L27;
        r106.put("exit_msg", r107);
    L27:
        r106.put("room_id", String.valueOf(r100.f155373d));
        com.bytedance.android.livesdk.log.b0.o().b("ttlive_room_exit", r106);
        return;
    L19:
        r105.monitorStatus("ttlive_audience_leave_room", r100.f155370a, r101);
        goto L24
    L21:
        if (r100.a() == false) goto L23;
        LiveSlardarMonitor.monitorStatus("ttlive_audience_leave_room_error", r100.f155370a, r101);
        goto L24
    L23:
        LiveSlardarMonitor.monitorStatus("ttlive_audience_leave_room", r100.f155370a, r101);
        goto L24
    }

    public static void r(ls2.e r100, hl0.a r101, JSONObject r102) {
        if (dp0.f120055a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (r100 == null) goto L17;
        BaseMonitor.add(r102, "endCode", r100.getEndV2());
        if (TextUtils.isEmpty(r100.getSourceKeyV2()) == true) goto L12;
        if (TextUtils.isEmpty(r100.getSourceValueV2V2()) == true) goto L12;
        BaseMonitor.add(r102, "sourceKey", r100.getSourceKeyV2());
        BaseMonitor.add(r102, "sourceValue", r100.getSourceValueV2V2());
    L12:
        if (r100.getReasonV2() == null) goto L15;
        BaseMonitor.add(r102, "endReason", r100.getReasonV2().toString());
    L15:
        if (TextUtils.isEmpty(r100.getPlayerStateV2()) == true) goto L17;
        BaseMonitor.add(r102, "playerState", r100.getPlayerStateV2());
    L17:
        if (r101 != null) goto L19;
        return;
    L19:
        if (TextUtils.isEmpty(r101.f485663c) == true) goto L23;
        BaseMonitor.add(r102, "api_error_log_id", r101.f485663c);
        return;
    }

    public final void l(JSONObject r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == true) goto L6;
        BaseMonitor.add(r100, "enter_from_merge", r101);
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L8;
        BaseMonitor.add(r100, "enter_method", r102);
    L8:
        int r103 = this.f154959e;
        if (r103 != 2) goto L11;
        BaseMonitor.add(r100, "source_room_type", "replay");
        return;
    L11:
        if (r103 == 3) goto L13;
        BaseMonitor.add(r100, "source_room_type", "normal");
        return;
    L13:
        BaseMonitor.add(r100, "source_room_type", SourceType.VS_VIDEO);
    }

    public final void t(String r110, String r111, int r112) {
        this.f154960f = 2;
        f0 r100 = this.f154961g;
        if (r100 == null) goto L6;
        o(r100.f155365a, r100.f155366b, r100.f155367c, r100.f155368d, r100.f155369e, r110, r111, r112);
        xs2.b.a().post(new zg1.h("enter_error", "code: " + this.f154961g.f155365a + ", msg: " + this.f154961g.f155366b));
        this.f154961g = null;
        return;
    }

    public final void n(long r100, String r101, String r102, int r110) {
        if (this.f154957c == false) goto L5;
        return;
    L5:
        this.f154957c = true;
        lf2.a r103 = this.f154955a;
        if (r103 == null) goto L8;
        String r104 = r103.f509045a;
    L9:
        long r105 = m();
        JSONObject r106 = new JSONObject();
        BaseMonitor.add(r106, "enter_room_type", r104);
        BaseMonitor.add(r106, "room_id", r100);
        BaseMonitor.add(r106, ILiveRoomPlayFragmentConstant.EXTRA_IS_AUTO, r110);
        l(r106, r101, r102);
        int r107 = w51.f121499a;
        wm0.a r108 = om0.c.h();
        if (r108 == null) goto L12;
        r108.c(2, r105, r106);
    L13:
        zl2.a r109 = zl2.a.b();
        String r111 = TTLiveALogTag.Room.info;
        r109.getClass();
        zl2.a.d(r111, "ttlive_audience_enter_room", 2, r106);
        return;
    L12:
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_audience_enter_room_all", 2, r105, r106);
        goto L13
    L8:
        r104 = "other";
        goto L9
    }

    public final void o(int r110, String r111, long r112, String r113, String r114, String r115, String r210, int r211) {
        p(r110, r111, r112, r113, r114, r115, r210, null, null, r211);
    }

    public final void s(int r110, String r111, long r112, String r113, String r114, String r115, String r210, int r211) {
        int r100 = this.f154960f;
        if (r100 != 1) goto L6;
        return;
    L6:
        if (r100 != 2) goto L10;
        o(r110, r111, r112, r113, r114, r115, r210, r211);
        xs2.b.a().post(new zg1.h("enter_error", "code: " + r110 + ", msg: " + r111));
        return;
    L10:
        if (this.f154961g != null) goto L13;
        this.f154961g = new f0(r110, r111, r112, r113, r114);
        return;
    }

    public final void p(int r100, String r101, long r102, String r103, String r110, String r111, String r112, ls2.e r113, hl0.a r114, int r115) {
        if (this.f154957c == false) goto L5;
        return;
    L5:
        this.f154957c = true;
        lf2.a r104 = this.f154955a;
        if (r104 == null) goto L8;
        String r105 = r104.f509045a;
    L9:
        m();
        JSONObject r106 = new JSONObject();
        BaseMonitor.add(r106, "enter_room_type", r105);
        BaseMonitor.add(r106, IPerformanceManager.Params.room_type, r103);
        if (r114 == null) goto L18;
        String r107 = r114.f485663c;
        if (r107 == null) goto L18;
        if (r107.contains("JsonSyntaxException") == false) goto L16;
    L17:
        r100 = 107;
        goto L18
    L16:
        if (r114.f485663c.contains("JsonIOException") == true) goto L17;
    L18:
        BaseMonitor.add(r106, "error_code", r100);
        BaseMonitor.add(r106, "error_msg", r101);
        BaseMonitor.add(r106, "room_id", r102);
        BaseMonitor.add(r106, "pull_url", r110);
        BaseMonitor.add(r106, ILiveRoomPlayFragmentConstant.EXTRA_IS_AUTO, r115);
        l(r106, r111, r112);
        r(r113, r114, r106);
        int r108 = w51.f121499a;
        wm0.a r109 = om0.c.h();
        if (r109 == null) goto L21;
        r109.a(r106);
    L22:
        zl2.a r116 = zl2.a.b();
        String r117 = TTLiveALogTag.Room.info;
        r116.getClass();
        zl2.a.d(r117, "ttlive_audience_enter_room", 1, r106);
        return;
    L21:
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_audience_enter_room_all", 1, r106);
        goto L22
    L8:
        r105 = "other";
        goto L9
    }
}
