package com.bytedance.android.livesdk.chatroom.record;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.ability.AbilityCenter;
import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.config.ar;
import com.bytedance.android.livesdk.config.rs;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f108084a = null;

    public u() {
    }

    static {
        f108084a = u.class.getSimpleName();
    }

    public static boolean b(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L9;
        if (r101.isDirectory() == false) goto L9;
        return true;
    L9:
        if (r101.exists() == false) goto L15;
        if (r101.delete() == true) goto L15;
        Logger.e(f108084a, "Can not delete file: " + r101.getAbsolutePath());
        return false;
    L15:
        return r101.mkdirs();
    }

    public static boolean d(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        AbilityCenter r101 = (AbilityCenter) r100.get("data_room_ablity_center");
        if (r101 != null) goto L8;
    L12:
        se1.c r102 = (se1.c) r100.get("data_audience_backtrace_service");
        if (r102 != null) goto L15;
        IAnchorBacktrackService r103 = (IAnchorBacktrackService) r100.get("data_backtrack_service", null);
        if (r103 != null) goto L21;
        return false;
    L21:
        if (r103.getState() != IAnchorBacktrackService.State.BACKTRACK_DOING) goto L26;
        return true;
    L26:
        return false;
    L15:
        if (r102.a().f104061a != BacktrackState.BACKTRACK_DOING) goto L24;
        return true;
    L24:
        return false;
    L8:
        if (r101.getAbility(IRoomRecordService.class) == null) goto L12;
        if (((IRoomRecordService) r101.getAbility(IRoomRecordService.class)).isRecording() == false) goto L12;
        return true;
    }

    public static void a(Bitmap r100, String r101) throws IOException {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.createNewFile() == false) goto L6;
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102);
        r100.compress(Bitmap.CompressFormat.JPEG, 75, r103);
        r103.close();
        r100.recycle();
        return;
    L6:
        r100.recycle();
        throw new IOException("Can not create screenshot file");
    }

    public static String c(Context r100, String r101) {
        if (r100 != null) goto L5;
    L4:
        String r102 = null;
    L9:
        if (r102 != null) goto L11;
        return null;
    L11:
        StringBuilder r103 = new StringBuilder();
        r103.append(r102);
        String r104 = File.separator;
        r103.append(r104);
        r103.append("record");
        String r105 = r103.toString();
        if (b(r105) == true) goto L15;
        return null;
    L15:
        return r105 + r104 + r101;
    L5:
        File r106 = r100.getExternalCacheDir();
        if (r106 == null) goto L4;
        r102 = r106.getAbsolutePath();
        goto L9
    }

    public static boolean e(boolean r100, Room r101) {
        if (r101 == null) goto L33;
        if (r100 == false) goto L7;
        return false;
    L7:
        if (tb1.c.f545231c == false) goto L10;
        return false;
    L10:
        if (r101.getRoomAuthStatus() != null) goto L31;
        return false;
    L31:
        com.bytedance.android.livesdk.config.setting.h r102 = com.bytedance.android.livesdk.config.setting.i.f121210a;     // Catch: Exception -> L18
        if (com.bytedance.android.livesdk.config.setting.i.f121210a.b() == false) goto L19;
        if (((ILiveExpOptService) jc1.k.f(ILiveExpOptService.class)).getSceneState(null, l61.d.a.C6653d.f507606e).a() == false) goto L19;
        boolean r103 = true;
    L21:
        if (tb1.c.f545229a == true) goto L23;
        return false;
    L23:
        if (ar.f119813a.getValue().intValue() != 1) goto L35;
        if (r103 == false) goto L26;
        return false;
    L26:
        if (r101.getRoomAuthStatus() != null) goto L28;
        return false;
    L28:
        if (r101.getRoomAuthStatus().isEnableRecordScreen() == false) goto L38;
        return true;
    L38:
        return false;
    L35:
        return false;
    L19:
        r103 = false;
        goto L21
    L33:
        return false;
    }

    public static boolean f(boolean r100, IRoom r101) {
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r100 == false) goto L19;
        LiveMode r102 = r101.getStreamType();
        if (((IUserService) jc1.k.f(IUserService.class)).user().isLogin() == true) goto L10;
        return false;
    L10:
        if (tb1.c.f545229a == true) goto L12;
        return false;
    L12:
        if (r102 != LiveMode.AUDIO) goto L14;
    L17:
        return true;
    L14:
        if (r102 == LiveMode.VIDEO) goto L17;
        if (r102 == LiveMode.THIRD_PARTY) goto L17;
        return false;
    L19:
        ILivePlayerClient r103 = LivePlatformPlayerManager.f();
        if (r103 != null) goto L22;
    L24:
        LiveRoomPermission.D.getClass();
        boolean r104 = LiveRoomPermission.Companion.c();
        if (com.bytedance.android.livesdk.config.setting.i.f121210a.A() == false) goto L31;
        if (((ILiveExpOptService) jc1.k.f(ILiveExpOptService.class)).getSceneState(null, l61.d.a.k0.f507627e).a() == false) goto L31;
        boolean r105 = true;
    L33:
        if ((!rf2.a.a()) == true) goto L35;
        return false;
    L35:
        if (tb1.c.f545229a == false) goto L52;
        if (r105 == false) goto L38;
        return false;
    L38:
        if (rs.f121154a.getValue().booleanValue() == false) goto L40;
    L44:
        return true;
    L40:
        if (r101.getRoomAuthStatus() != null) goto L42;
    L43:
        if (r104 == true) goto L44;
        return false;
    L42:
        if (r101.getRoomAuthStatus().isEnableRecordScreen() == true) goto L44;
    L52:
        return false;
    L31:
        r105 = false;
        goto L33
    L22:
        if (r103.extraRenderController().isUgcRoom() == false) goto L24;
        return false;
    }
}
