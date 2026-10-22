package com.bytedance.android.livesdk.chatroom.room.apm;

import android.content.SharedPreferences;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.utils.v6;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/room/apm/RoomExitExtensionMonitor;", "Lcom/bytedance/android/livesdk/chatroom/room/apm/RoomEnterExtensionMonitor;", "Lq81/j;", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomExitExtensionMonitor extends RoomEnterExtensionMonitor implements q81.j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f110684d;

    public final void j() {
        SharedPreferences r100 = h();
        if (r100 == null) goto L10;
        SharedPreferences.Editor r101 = r100.edit();
        if (r101 == null) goto L11;
        SharedPreferences.Editor r102 = r101.remove("enter_room_upload_extension" + this.f110684d);
        if (r102 == null) goto L12;
        r102.apply();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.room.apm.RoomEnterExtensionMonitor
    public final String g() {
        return this.f110684d;
    }

    public RoomExitExtensionMonitor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        super(r100);
        this.f110684d = r100;
    }

    @Override // q81.j
    public final JSONObject a(String r100) {
        JSONObject r101 = new JSONObject();
        BaseMonitor.add(r101, "enter_from_merge", "live_merge");
        BaseMonitor.add(r101, "enter_method", "live_cover");
        String r102 = v6.b().n();
        if (r102 != null) goto L5;
        r102 = "0";
    L5:
        BaseMonitor.add(r101, "user_id", r102);
        RoomEnterExtensionMonitor.a r103 = RoomEnterExtensionMonitor.CREATOR;
        Date r104 = new Date();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "date");
        BaseMonitor.add(r101, "real_time", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS", Locale.CHINA).format(r104));
        if (r100 == null) goto L8;
        BaseMonitor.add(r101, LocationMonitorConst.ERR_MSG, "Fail to get feed after click live square. Message is ".concat(r100));
    L8:
        return r101;
    }

    public final void i(String r100, String r101) {
        long r102 = 0;
        String r103 = this.f110684d;     // Catch: Exception -> L9
        if (r103 == null) goto L6;
        Long r104 = Long.valueOf(CastLongProtector.parseLong(r103));     // Catch: Exception -> L9
    L7:
        long r105 = r104.longValue();     // Catch: Exception -> L9
    L10:
        RoomEnterExtensionMonitor.RoomRecoveryData r106 = new RoomEnterExtensionMonitor.RoomRecoveryData();
        RoomEnterExtensionMonitor.a r107 = RoomEnterExtensionMonitor.CREATOR;
        Date r108 = new Date(r105);
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "date");
        r106.setTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS", Locale.CHINA).format(r108));
        if (r100 != null) goto L29;
    L15:
        long r109 = 0;
    L16:
        r106.setRoomId(r109);
        if (r101 != null) goto L31;
    L21:
        r106.setAnchorId(r102);
        r106.setUserId(v6.b().n());
        SharedPreferences r110 = h();
        if (r110 == null) goto L35;
        SharedPreferences.Editor r111 = r110.edit();
        if (r111 == null) goto L36;
        SharedPreferences.Editor r112 = r111.putString("enter_room_upload_extension" + this.f110684d, GsonProtectorUtils.toJson(GsonHelper.get(), r106));
        if (r112 == null) goto L37;
        r112.apply();
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L31:
        r102 = CastLongProtector.parseLong(r101);     // Catch: Exception -> L20
    L20:
        b0 r113 = b0.o();
        String r114 = "anchorId is invalid: ".concat(r101);
        r113.getClass();
        com.bytedance.android.live.core.log.g.a("enter_room_extension_", r114);
        goto L21
    L29:
        r109 = CastLongProtector.parseLong(r100);     // Catch: Exception -> L14
    L14:
        b0 r115 = b0.o();
        String r116 = "roomId is invalid: ".concat(r100);
        r115.getClass();
        com.bytedance.android.live.core.log.g.a("enter_room_extension_", r116);
        goto L15
    L6:
        r104 = null;
    L9:
        b0 r117 = b0.o();
        String r118 = "exitExtensionMonitor's session is invalid: " + this.f110684d;
        r117.getClass();
        com.bytedance.android.live.core.log.g.a("live_sdk_monitor", r118);
        r105 = 0;
        goto L10
    }
}
