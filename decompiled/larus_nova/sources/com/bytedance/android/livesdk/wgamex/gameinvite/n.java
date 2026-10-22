package com.bytedance.android.livesdk.wgamex.gameinvite;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.livesdk.message.model.z4;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f160743a = 0;

    static {
    }

    public static void b(boolean r100, long r101, String r102, z4.b r110, z4.a r111) {
        Intrinsics.checkNotNullParameter(r102, "userID");
        int r103 = !r100 ? 1 : 0;
        JSONObject r104 = new JSONObject();
        long r105 = 0;
        if (r110 == null) goto L5;
        long r106 = r110.c();
    L6:
        BaseMonitor.add(r104, "game_id", r106);
        if (r110 == null) goto L9;
        int r107 = r110.f();
    L10:
        BaseMonitor.add(r104, "play_kind", r107);
        BaseMonitor.add(r104, "room_id", r101);
        if (r110 == null) goto L13;
        long r108 = r110.h();
    L14:
        BaseMonitor.add(r104, "switch_id", r108);
        BaseMonitor.add(r104, "user_id", r102);
        if (r111 == null) goto L17;
        r105 = r111.b();
    L17:
        BaseMonitor.add(r104, "invite_id", r105);
        Unit r109 = Unit.INSTANCE;
        LiveSlardarMonitor.monitorStatus("ttlive_wgamex_invite_audience_open_game_all", r103, r104);
        return;
    L13:
        r108 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    public static void c(long r100, String r101, z4.b r102, z4.a r110, String r111) {
        Intrinsics.checkNotNullParameter(r101, "userID");
        JSONObject r103 = new JSONObject();
        long r104 = 0;
        if (r102 == null) goto L5;
        long r105 = r102.c();
    L6:
        BaseMonitor.add(r103, "game_id", r105);
        if (r102 == null) goto L9;
        int r106 = r102.f();
    L10:
        BaseMonitor.add(r103, "play_kind", r106);
        BaseMonitor.add(r103, "room_id", r100);
        if (r102 == null) goto L13;
        long r107 = r102.h();
    L14:
        BaseMonitor.add(r103, "switch_id", r107);
        BaseMonitor.add(r103, "user_id", r101);
        if (r110 == null) goto L17;
        r104 = r110.b();
    L17:
        BaseMonitor.add(r103, "invite_id", r104);
        if (r111 != null) goto L20;
        r111 = "";
    L20:
        BaseMonitor.add(r103, "schema_for_check", r111);
        Unit r108 = Unit.INSTANCE;
        LiveSlardarMonitor.monitorStatus("ttlive_wgamex_invite_audience_open_game_error", 4, r103);
        return;
    L13:
        r107 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    public static void a(boolean r100, int r101, long r102, long r103, long r104, long r110, long r111) {
        JSONObject r105 = new JSONObject();
        BaseMonitor.add(r105, "game_id", r110);
        BaseMonitor.add(r105, "play_kind", r111);
        BaseMonitor.add(r105, "room_id", r104);
        BaseMonitor.add(r105, "switch_id", r102);
        BaseMonitor.add(r105, "invite_id", r103);
        if (r100 == false) goto L5;
        String r106 = "ttlive_wgamex_single_invite_track";
    L6:
        LiveSlardarMonitor.monitorStatus(r106, r101, r105);
        return;
    L5:
        r106 = "ttlive_wgamex_all_invite_track";
        goto L6
    }
}
