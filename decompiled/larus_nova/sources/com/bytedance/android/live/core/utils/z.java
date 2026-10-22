package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.abs.EpisodeCompatDelegate;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IVSCompatRoom;
import com.bytedance.android.livesdkapi.depend.model.live.abs.RoomCompatDelegate;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live.RoomPreloadStage;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Room f66431a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Episode f66432b = null;

    static {
        f66431a = new Room();
        f66432b = new Episode();
    }

    public static final y b(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$common");
        IRoom r101 = (IRoom) r100.get("data_room");
        Object r102 = r100.get("data_is_portrait");
        if (r102 != null) goto L5;
        r102 = Boolean.TRUE;
    L5:
        boolean r103 = ((Boolean) r102).booleanValue();
        Object r104 = r100.get("data_is_anchor");
        if (r104 != null) goto L9;
        r104 = Boolean.FALSE;
    L9:
        return new y(r101, r103, ((Boolean) r104).booleanValue());
    }

    public static final LiveMode c(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getLiveMode");
        return (LiveMode) r100.get("data_live_mode", LiveMode.UNDEFINED);
    }

    public static /* synthetic */ boolean f(DataCenter r100) {
        return e(r100, false);
    }

    public static final boolean g(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r102 = (LiveMode) r100.get("data_live_mode", LiveMode.VIDEO);
        if (r101 == true) goto L8;
        return false;
    L8:
        if (r102 != LiveMode.AUDIO) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean h(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r102 = (LiveMode) r100.get("data_live_mode", LiveMode.VIDEO);
        if (r101 == true) goto L8;
        return false;
    L8:
        if (r102 != LiveMode.MEDIA) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean i(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r102 = (LiveMode) r100.get("data_live_mode", LiveMode.VIDEO);
        if (r101 == true) goto L8;
        return false;
    L8:
        if (r102 != LiveMode.SCREEN_RECORD) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean j(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r102 = (LiveMode) r100.get("data_live_mode", LiveMode.VIDEO);
        if (r101 == true) goto L8;
        return false;
    L8:
        if (r102 != LiveMode.THIRD_PARTY) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean k(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = ((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        LiveMode r102 = LiveMode.VIDEO;
        LiveMode r103 = (LiveMode) r100.get("data_live_mode", r102);
        if (r101 == false) goto L10;
        if (r103 != r102) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public static final boolean l(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMergeVSRoom");
        return o(r100).isMergeVSRoom();
    }

    public static /* synthetic */ boolean n(DataCenter r100) {
        return m(r100, true);
    }

    public static final Room o(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$room");
        return (Room) r100.get("data_room", f66431a);
    }

    public static final RoomPreloadStage p(DataCenter r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return (RoomPreloadStage) r100.get("data_preload_stage", null);
    }

    public static final IVSCompatRoom q(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$vsCompatRoomSafety");
        IVSCompatRoom r101 = (IVSCompatRoom) r100.get("data_vs_compat_room", null);
        if (r101 != null) goto L15;
        Room r102 = (Room) r100.get("data_room", null);
        if (r102 == null) goto L7;
        IVSCompatRoom r103 = new RoomCompatDelegate(r102);
    L11:
        if (r103 == null) goto L24;
        r100.put("data_vs_compat_room", r103);
        return r103;
    L24:
        return null;
    L7:
        Episode r104 = (Episode) r100.get("data_vs_episode_data", null);
        if (r104 == null) goto L10;
        r103 = new EpisodeCompatDelegate(r104);
        goto L11
    L10:
        r103 = null;
        goto L11
    L15:
        Room r105 = (Room) r100.get("data_room", null);
        if (r105 == null) goto L18;
        RoomCompatDelegate r106 = new RoomCompatDelegate(r105);
        r100.put("data_vs_compat_room", r106);
        return r106;
    L18:
        Episode r107 = (Episode) r100.get("data_vs_episode_data", null);
        if (r107 != null) goto L21;
        return r101;
    L21:
        if ((!Intrinsics.areEqual(r101, r107)) == false) goto L27;
        EpisodeCompatDelegate r108 = new EpisodeCompatDelegate(r107);
        r100.put("data_vs_compat_room", r108);
        return r108;
    L27:
        return r101;
    }

    public static final String d(DataCenter r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getRoomUniqueKey");
        long r102 = o(r100).f162599id;
        if (r102 <= 0) goto L7;
        r101 = Long.valueOf(r102);
    L7:
        if (((Boolean) r100.get("data_current_is_preview", Boolean.FALSE)).booleanValue() == false) goto L9;
        Integer r103 = (Integer) r100.get("data_current_unique_id_preview", 0);
    L10:
        StringBuilder r104 = new StringBuilder();
        r104.append(r101);
        r104.append('_');
        r104.append(r103);
        return r104.toString();
    L9:
        r103 = (Integer) r100.get("room_controller_unique_key", 0);
        goto L10
    }

    public static final boolean e(DataCenter r100, boolean r101) {
        if (r100 == null) goto L6;
        Boolean r102 = (Boolean) r100.get("data_is_anchor", Boolean.valueOf(r101));
        if (r102 == null) goto L6;
        return r102.booleanValue();
    L6:
        return false;
    }

    public static final boolean m(DataCenter r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isPortrait");
        return ((Boolean) r100.get("data_is_portrait", Boolean.valueOf(r101))).booleanValue();
    }

    public static final Room a(DataCenter r100, IBaseStreamUrl r101, Long r110) {
        Object r102 = null;
        if (r100 == null) goto L5;
        Room r103 = o(r100);
    L6:
        Room r104 = new Room();
        if (r103 == null) goto L37;
        if (r101 != null) goto L10;
        EpisodeExtraInfo r105 = r103.getEpisodeComponentData();
        if (r105 == null) goto L35;
        List<IVSCameraInfo> r106 = r105.getCameraInfos();
        if (r106 == null) goto L35;
        Iterator<T> r107 = r106.iterator();
    L19:
        if (r107.hasNext() == false) goto L29;
        Object r108 = r107.next();
        long r109 = ((IVSCameraInfo) r108).getCameraId();
        if (r110 != null) goto L24;
    L26:
        boolean r111 = false;
    L27:
        if (r111 == false) goto L19;
        r102 = r108;
        goto L29
    L24:
        if (r109 != r110.longValue()) goto L26;
        r111 = true;
    L29:
        IVSCameraInfo r112 = (IVSCameraInfo) r102;
        if (r112 == null) goto L35;
        IBaseStreamUrl r113 = r112.getStreamUrl();
        if (r113 == null) goto L35;
        StreamUrl r114 = (StreamUrl) com.bytedance.android.live.base.model.m.b(r113, StreamUrl.class);
        if (r114 == null) goto L35;
    L36:
        r104.setStreamUrl(r114);
        r104.setPlatform(r103.getPlatform());
        r104.clientVersion = r103.clientVersion;
        r104.f162599id = r103.f162599id;
        r104.setOwnerUserIdString(r103.getOwnerUserIdString());
    L35:
        r114 = r103.getStreamUrl();
        goto L36
    L10:
        if ((r101 instanceof StreamUrl) == true) goto L12;
        r101 = null;
    L12:
        r114 = (StreamUrl) r101;
    L37:
        return r104;
    L5:
        r103 = null;
        goto L6
    }
}
