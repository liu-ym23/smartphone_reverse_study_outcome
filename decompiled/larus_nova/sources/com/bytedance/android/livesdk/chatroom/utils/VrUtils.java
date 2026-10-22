package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.setting.SettingKeyUtils;
import com.bytedance.android.livesdk.config.pr0;
import com.bytedance.android.livesdk.config.qx0;
import com.bytedance.android.livesdk.config.sx0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IPullData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class VrUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f114385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Integer f114386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f114387c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f114388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final VrUtils f114389e = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/utils/VrUtils$VRGestureDragType;", "", "", "type", "I", "getType", "()I", "NO_GESTURE_DRAG_VIEW_INTERACTIVE_ONLY", "NO_GESTURE_DRAG_VIEW_ALWAYS", "NO_GESTURE_DRAG_VIEW_CLEANSCREEN_ONLY", "NO_GESTURE_DRAG_VIEW_NEVER", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum VRGestureDragType extends Enum<VRGestureDragType> {
        public static final VRGestureDragType NO_GESTURE_DRAG_VIEW_ALWAYS = null;
        public static final VRGestureDragType NO_GESTURE_DRAG_VIEW_CLEANSCREEN_ONLY = null;
        public static final VRGestureDragType NO_GESTURE_DRAG_VIEW_INTERACTIVE_ONLY = null;
        public static final VRGestureDragType NO_GESTURE_DRAG_VIEW_NEVER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VRGestureDragType[] f114390a = null;
        private final int type;

        static {
            VRGestureDragType r100 = new VRGestureDragType("NO_GESTURE_DRAG_VIEW_INTERACTIVE_ONLY", 0, 0);
            NO_GESTURE_DRAG_VIEW_INTERACTIVE_ONLY = r100;
            VRGestureDragType r101 = new VRGestureDragType("NO_GESTURE_DRAG_VIEW_ALWAYS", 1, 1);
            NO_GESTURE_DRAG_VIEW_ALWAYS = r101;
            VRGestureDragType r102 = new VRGestureDragType("NO_GESTURE_DRAG_VIEW_CLEANSCREEN_ONLY", 2, 2);
            NO_GESTURE_DRAG_VIEW_CLEANSCREEN_ONLY = r102;
            VRGestureDragType r103 = new VRGestureDragType("NO_GESTURE_DRAG_VIEW_NEVER", 3, 3);
            NO_GESTURE_DRAG_VIEW_NEVER = r103;
            f114390a = new VRGestureDragType[]{r100, r101, r102, r103};
        }

        public static VRGestureDragType valueOf(String r100) {
            return (VRGestureDragType) r27.a.a(VRGestureDragType.class, r100);
        }

        public static VRGestureDragType[] values() {
            return (VRGestureDragType[]) f114390a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public VRGestureDragType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public VrUtils() {
    }

    @JvmStatic
    public static final boolean e() {
        if (C(null) == true) goto L5;
    L7:
        return false;
    L5:
        if (qx0.f121090a.getValue().booleanValue() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final String n() {
        if (C(null) == false) goto L18;
        int r100 = f114385a;
        if (r100 > 0) goto L20;
        IRoomContextService r101 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r101 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.o r102 = IRoomContextService.a.a(r101, null, 0, 3);
        if (r102 == null) goto L18;
        com.bytedance.live.datacontext.m<IRoom> r103 = r102.getRoom();
        if (r103 == null) goto L18;
        IRoom r104 = r103.getValue();
        if (r104 == null) goto L18;
        String r105 = String.valueOf(r104.getVRType());
        if (r105 == null) goto L18;
        return r105;
    L20:
        return String.valueOf(r100);
    L18:
        return "0";
    }

    static {
        f114389e = new VrUtils();
        f114386b = 0;
        f114387c = LazyKt.lazy(VrUtils$vrEnable$2.INSTANCE);
        f114388d = -1;
    }

    @JvmStatic
    public static final boolean B() {
        if (((Boolean) SettingKeyUtils.f111517f.getValue()).booleanValue() == true) goto L5;
    L27:
        return false;
    L5:
        if (C(null) == false) goto L27;
        MiddlewareRoomContext r100 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L11;
        com.bytedance.live.datacontext.m<Room> r101 = r100.getRoom();
        if (r101 == null) goto L11;
        Room r102 = r101.getValue();
    L13:
        if (x(r102) == false) goto L27;
        IRoomContextService r103 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r103 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.o r104 = IRoomContextService.a.a(r103, null, 0, 3);
        if (r104 == null) goto L21;
        com.bytedance.live.datacontext.m<IRoom> r105 = r104.getRoom();
        if (r105 == null) goto L21;
        IRoom r106 = r105.getValue();
    L23:
        if (A(r106, null) == true) goto L27;
        if (PadConfigUtils.c() == true) goto L27;
        return true;
    L21:
        r106 = null;
    L11:
        r102 = null;
        goto L13
    }

    @JvmStatic
    public static final boolean f() {
        if (pr0.f121002a.getValue().booleanValue() == false) goto L5;
        f114389e.getClass();
        boolean r100 = ((Boolean) f114387c.getValue()).booleanValue();
    L6:
        if (r100 == true) goto L8;
    L10:
        return false;
    L8:
        if (C(null) == false) goto L10;
        return true;
    L5:
        r100 = true;
        goto L6
    }

    @JvmStatic
    public static final boolean h() {
        return com.bytedance.android.livesdk.config.s3.f121179a.getValue().booleanValue();
    }

    @JvmStatic
    public static final int m() {
        Lazy r100 = SettingKeyUtils.f111512a;
        return ((Number) SettingKeyUtils.f111516e.getValue()).intValue();
    }

    @JvmStatic
    public static final boolean q() {
        MiddlewareRoomContext r100 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L32;
        com.bytedance.live.datacontext.m<Room> r101 = r100.getRoom();
        if (r101 == null) goto L33;
        Room r102 = r101.getValue();
        if (r102 == null) goto L35;
        StreamUrl r103 = r102.getStreamUrl();
        if (r103 == null) goto L23;
        Map<String, IPullData> r104 = r103.getPullDatas();
        if (r104 == null) goto L23;
        LinkedHashMap r105 = new LinkedHashMap();
        Iterator<Map.Entry<String, IPullData>> r106 = r104.entrySet().iterator();
    L15:
        if (r106.hasNext() == false) goto L22;
        Map.Entry<String, IPullData> r107 = r106.next();
        if (((LiveCoreSDKData.PullData) r107.getValue()).getKind() == 2) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == false) goto L15;
        r105.put(r107.getKey(), r107.getValue());
        goto L15
    L19:
        r108 = false;
        goto L20
    L22:
        int r109 = r105.size();
    L24:
        if (r109 <= 0) goto L34;
        return true;
    L34:
        return false;
    L23:
        r109 = 0;
        goto L24
    L35:
        return false;
    L33:
        return false;
    L32:
        return false;
    }

    @JvmStatic
    public static final boolean s() {
        IRoomContextService r100 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r100 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r101 = IRoomContextService.a.a(r100, null, 0, 3);
        if (r101 == null) goto L9;
        com.bytedance.live.datacontext.m<IRoom> r102 = r101.getRoom();
        if (r102 == null) goto L9;
        IRoom r103 = r102.getValue();
    L11:
        if (x(r103) == true) goto L13;
    L23:
        return false;
    L13:
        if (B() == false) goto L23;
        IRoomContextService r104 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r104 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.o r105 = IRoomContextService.a.a(r104, null, 0, 3);
        if (r105 == null) goto L23;
        com.bytedance.live.datacontext.m<Boolean> r106 = r105.A1();
        if (r106 == null) goto L23;
        if (r106.getValue().booleanValue() != true) goto L23;
        return true;
    L9:
        r103 = null;
        goto L11
    }

    @JvmStatic
    public static final boolean j() {
        if (h() == true) goto L5;
    L9:
        return false;
    L5:
        if (m() != VRGestureDragType.NO_GESTURE_DRAG_VIEW_INTERACTIVE_ONLY.getType()) goto L7;
    L8:
        return true;
    L7:
        if (m() != VRGestureDragType.NO_GESTURE_DRAG_VIEW_ALWAYS.getType()) goto L9;
        goto L8
    }

    @JvmStatic
    public static final boolean C(DataCenter r100) {
        IRoomContextService r101 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r101 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r102 = IRoomContextService.a.a(r101, r100, 0, 2);
        if (r102 == null) goto L9;
        com.bytedance.live.datacontext.m<IRoom> r103 = r102.getRoom();
        if (r103 == null) goto L9;
        IRoom r104 = r103.getValue();
    L11:
        if (A(r104, null) == false) goto L14;
    L18:
        return true;
    L14:
        if (v(r100) == true) goto L18;
        if (f114388d != 2) goto L18;
        return false;
    L9:
        r104 = null;
        goto L11
    }

    @JvmStatic
    public static final boolean c(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (gb2.a.c(r100, true) == true) goto L11;
        if (B() == true) goto L9;
        return false;
    L9:
        if (com.bytedance.android.live.core.utils.a0.n(r100).isMediaRoom() == false) goto L11;
        return false;
    L11:
        if (com.bytedance.android.live.core.utils.a0.d(r100, false) == false) goto L13;
        return false;
    L13:
        if (C(r100) == true) goto L15;
        return false;
    L15:
        if (w(r100) == false) goto L23;
        return true;
    L23:
        return false;
    }

    @JvmStatic
    public static final boolean d(DataCenter r100) {
        if (w(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (B() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean g(IRoom r100) {
        if (r100 == null) goto L8;
        if (r100.isVrRoom() != true) goto L8;
        return true;
    L8:
        if (q() == true) goto L42;
        Object r101 = null;
        if (r100 == null) goto L32;
        IEpisodeExtraInfo r102 = r100.getEpisodeComponentData();
        if (r102 == null) goto L32;
        List<IVSCameraInfo> r103 = r102.getCameraInfos();
        if (r103 == null) goto L32;
        Iterator<T> r104 = r103.iterator();
    L18:
        if (r104.hasNext() == false) goto L31;
        Object r105 = r104.next();
        IVSCameraInfo r106 = (IVSCameraInfo) r105;
        IBaseStreamUrl r107 = r106.getStreamUrl();
        if (r107 != null) goto L22;
    L23:
        IBaseStreamUrl r108 = r106.getStreamUrl();
        if (r108 != null) goto L26;
    L28:
        boolean r109 = false;
    L29:
        if (r109 == false) goto L18;
        r101 = r105;
        goto L31
    L26:
        if (r108.getVrType() != 2) goto L28;
    L27:
        r109 = true;
        goto L29
    L22:
        if (r107.getVrType() == 1) goto L27;
    L31:
        r101 = (IVSCameraInfo) r101;
    L32:
        if (r101 != null) goto L43;
        return false;
    L43:
        return true;
    L42:
        return true;
    }

    @JvmStatic
    public static final boolean i(DataCenter r100) {
        if (r100 != null) goto L4;
    L10:
        return false;
    L4:
        if (((Boolean) r100.get("data_hide_screen", Boolean.FALSE)).booleanValue() == false) goto L10;
        if (C(null) == false) goto L10;
        if (sx0.f121260a.getValue().booleanValue() == false) goto L10;
        return true;
    }

    @JvmStatic
    public static final int l(DataCenter r100) {
        if (r100 == null) goto L5;
        Integer r101 = (Integer) r100.get("data_screen_orientation", 1);
    L6:
        if (r101 != null) goto L9;
    L10:
        if (r101 != null) goto L13;
        return 1;
    L13:
        if (r101.intValue() != 6) goto L16;
    L14:
        return 0;
    L16:
        return 1;
    L9:
        if (r101.intValue() == 0) goto L14;
    L5:
        r101 = null;
        goto L6
    }

    @JvmStatic
    public static final String o(DataCenter r100) {
        if (C(null) == false) goto L12;
        if (r100 != null) goto L7;
        Integer r101 = f114386b;
        if (r101 == null) goto L20;
        if (r101.intValue() == 0) goto L20;
        return String.valueOf(f114386b);
    L20:
        return String.valueOf(f114385a);
    L7:
        if (w(r100) == false) goto L10;
        return String.valueOf(f114386b);
    L10:
        if (v(r100) == false) goto L12;
        return "1";
    L12:
        return "0";
    }

    @JvmStatic
    public static final boolean p(IRoom r100) {
        Object r101 = null;
        if (C(null) == true) goto L6;
        return false;
    L6:
        if (r100 != null) goto L8;
    L10:
        if (r100 == null) goto L31;
        IEpisodeExtraInfo r102 = r100.getEpisodeComponentData();
        if (r102 == null) goto L31;
        List<IVSCameraInfo> r103 = r102.getCameraInfos();
        if (r103 == null) goto L31;
        Iterator<T> r104 = r103.iterator();
    L17:
        if (r104.hasNext() == false) goto L30;
        Object r105 = r104.next();
        IVSCameraInfo r106 = (IVSCameraInfo) r105;
        IBaseStreamUrl r107 = r106.getStreamUrl();
        if (r107 != null) goto L21;
    L22:
        IBaseStreamUrl r108 = r106.getStreamUrl();
        if (r108 != null) goto L25;
    L27:
        boolean r109 = false;
    L28:
        if (r109 == false) goto L17;
        r101 = r105;
        goto L30
    L25:
        if (r108.getVrType() != 2) goto L27;
    L26:
        r109 = true;
        goto L28
    L21:
        if (r107.getVrType() == 1) goto L26;
    L30:
        r101 = (IVSCameraInfo) r101;
    L31:
        if (r101 == null) goto L33;
        return true;
    L33:
        return false;
    L8:
        if (r100.isVrRoom() != true) goto L10;
        return true;
    }

    @JvmStatic
    public static final boolean r(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Integer r101 = (Integer) r100.get("cmd_multicamera_biz_type", -1);
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.intValue() != 1) goto L12;
        return true;
    L12:
        return false;
    }

    @JvmStatic
    public static final boolean v(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Object r101 = null;
        Object r102 = r100.get("cmd_current_camera_info", null);
        if ((r102 instanceof ym0.a) == false) goto L9;
        r101 = r102;
    L9:
        ym0.a r103 = (ym0.a) r101;
        if (r103 != null) goto L13;
        return false;
    L13:
        if (r103.c() != 1) goto L15;
        boolean r104 = true;
    L17:
        if (r103.d() != 1) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == true) goto L24;
        if (r104 == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L19:
        r105 = false;
        goto L20
    L15:
        r104 = false;
        goto L17
    }

    @JvmStatic
    public static final boolean w(DataCenter r110) {
        if (C(r110) == true) goto L5;
        return false;
    L5:
        if (r110 == null) goto L9;
        IRoom r100 = com.bytedance.android.live.core.utils.a0.n(r110);
        if (r100 == null) goto L9;
        f114385a = r100.getVRType();
    L9:
        IRoomContextService r101 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        Integer r102 = null;
        if (r101 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.o r103 = IRoomContextService.a.a(r101, null, 0, 3);
    L13:
        if (r103 == null) goto L15;
        com.bytedance.live.datacontext.m<Long> r104 = r103.getCameraId();
    L17:
        if (r104 != null) goto L31;
        Integer r111 = f114386b;
        if (r111 != null) goto L22;
    L23:
        Integer r112 = f114386b;
        if (r112 != null) goto L27;
        return false;
    L27:
        if (r112.intValue() != 2) goto L101;
    L28:
        return true;
    L101:
        return false;
    L22:
        if (r111.intValue() == 1) goto L28;
    L31:
        if (r104.getValue().longValue() <= 0) goto L84;
        com.bytedance.live.datacontext.m<Long> r105 = r103.getCameraId();
        if (r105 == null) goto L35;
        Long r106 = r105.getValue();
    L36:
        com.bytedance.live.datacontext.m<IRoom> r107 = r103.getRoom();
        if (r107 == null) goto L43;
        IRoom r108 = r107.getValue();
        if (r108 == null) goto L43;
        IEpisodeExtraInfo r109 = r108.getEpisodeComponentData();
        if (r109 == null) goto L43;
        Long r113 = Long.valueOf(r109.getDefaultCameraId());
    L45:
        if ((!Intrinsics.areEqual(r106, r113)) == false) goto L84;
        com.bytedance.live.datacontext.m<IRoom> r114 = r103.getRoom();
        if (r114 == null) goto L67;
        IRoom r115 = r114.getValue();
        if (r115 == null) goto L67;
        IEpisodeExtraInfo r116 = r115.getEpisodeComponentData();
        if (r116 == null) goto L67;
        List<IVSCameraInfo> r117 = r116.getCameraInfos();
        if (r117 == null) goto L67;
        Iterator<T> r118 = r117.iterator();
    L56:
        if (r118.hasNext() == false) goto L65;
        Object r119 = r118.next();
        long r120 = ((IVSCameraInfo) r119).getCameraId();
        com.bytedance.live.datacontext.m<Long> r121 = r103.getCameraId();
        if (r121 != null) goto L60;
    L62:
        boolean r122 = false;
    L63:
        if (r122 == false) goto L56;
    L66:
        IVSCameraInfo r123 = (IVSCameraInfo) r119;
    L68:
        if (r123 == null) goto L72;
        IBaseStreamUrl r124 = r123.getStreamUrl();
        if (r124 == null) goto L72;
        r102 = Integer.valueOf(r124.getVrType());
    L72:
        f114386b = r102;
        if (r102 != null) goto L76;
    L77:
        Integer r125 = f114386b;
        if (r125 != null) goto L81;
        return false;
    L81:
        if (r125.intValue() != 2) goto L103;
    L82:
        return true;
    L103:
        return false;
    L76:
        if (r102.intValue() == 1) goto L82;
    L60:
        if (r120 != r121.getValue().longValue()) goto L62;
        r122 = true;
        goto L63
    L65:
        r119 = null;
    L67:
        r123 = null;
    L43:
        r113 = null;
        goto L45
    L35:
        r106 = null;
    L84:
        if (r110 == null) goto L88;
        IRoom r126 = com.bytedance.android.live.core.utils.a0.n(r110);
        if (r126 == null) goto L88;
        r102 = Integer.valueOf(r126.getVRType());
    L88:
        f114386b = r102;
        if (r110 == null) goto L105;
        IRoom r127 = com.bytedance.android.live.core.utils.a0.n(r110);
        if (r127 != null) goto L93;
        return false;
    L93:
        if (r127.isVrRoom() != true) goto L107;
        return true;
    L107:
        return false;
    L105:
        return false;
    L15:
        r104 = null;
        goto L17
    L12:
        r103 = null;
        goto L13
    }

    @JvmStatic
    public static final boolean x(IRoom r100) {
        if (r100 == null) goto L5;
        boolean r101 = r100.isVrRoom();
    L6:
        if (r101 == true) goto L8;
        return false;
    L8:
        if (C(null) == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean y(DataCenter r100) {
        if (r100 == null) goto L7;
        IRoom r101 = com.bytedance.android.live.core.utils.a0.n(r100);
        if (r101 == null) goto L7;
        boolean r102 = r101.isVrRoom();
    L8:
        if (r102 == true) goto L10;
        return false;
    L10:
        if (C(null) == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        r102 = false;
        goto L8
    }

    @JvmStatic
    public static final boolean z(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        if (((Boolean) r100.get("cmd_vr_stream_enable", Boolean.TRUE)).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (C(null) == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean A(IRoom r100, RoomContext r101) {
        if (r100 != null) goto L4;
    L30:
        return false;
    L4:
        if (r100.isMergeVSRoom() == false) goto L7;
        return true;
    L7:
        if (r100.isMediaRoom() == false) goto L15;
        IEpisodeExtraInfo r102 = r100.getEpisodeComponentData();
        if (r102 == null) goto L15;
        List<IVSCameraInfo> r103 = r102.getCameraInfos();
        if (r103 == null) goto L15;
        if ((!r103.isEmpty()) != true) goto L15;
        return true;
    L15:
        if (r101 == null) goto L23;
        IRoomContextService r104 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r104 == null) goto L30;
        com.bytedance.android.livesdk.chatroom.r r105 = r104.getRoomExpService(r101);
        if (r105 == null) goto L30;
        if (r105.isMergeVSMediaRoom(r100) != true) goto L30;
        return true;
    L23:
        IRoomContextService r106 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r106 == null) goto L30;
        com.bytedance.android.livesdk.chatroom.r r107 = r106.getRoomExpService(null, 0);
        if (r107 == null) goto L30;
        if (r107.isMergeVSMediaRoom(r100) != true) goto L30;
        return true;
    }

    @JvmStatic
    public static final boolean k(DataCenter r110, Room r111) {
        Intrinsics.checkNotNullParameter(r110, "dataCenter");
        if (r111 != null) goto L5;
        return false;
    L5:
        if (r111.getRoomAuthStatus() == null) goto L76;
        IRoomAuthStatus r100 = r111.getRoomAuthStatus();
        IEpisodeExtraInfo r112 = r111.getEpisodeComponentData();
        if (r112 == null) goto L65;
        List<IVSCameraInfo> r113 = r112.getCameraInfos();
        if (r113 == null) goto L65;
        if ((!r113.isEmpty()) != true) goto L65;
        IRoomContextService r114 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        IVSCameraInfo r101 = null;
        Object r102 = null;
        r101 = null;
        r101 = null;
        if (r114 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.o r115 = IRoomContextService.a.a(r114, null, 0, 3);
    L17:
        if (r115 == null) goto L19;
        com.bytedance.live.datacontext.m<Long> r103 = r115.getCameraId();
        com.bytedance.live.datacontext.m<Long> r104 = r115.getCameraId();
        if (r104 == null) goto L27;
        Long r105 = r104.getValue();
        if (r105 == null) goto L27;
        long r106 = r105.longValue();
    L29:
        if (r106 <= 0) goto L65;
        com.bytedance.live.datacontext.m<Long> r107 = r115.getCameraId();
        if (r107 == null) goto L33;
        Long r108 = r107.getValue();
    L34:
        Room r109 = r115.S1();
        if (r109 == null) goto L39;
        IEpisodeExtraInfo r116 = r109.getEpisodeComponentData();
        if (r116 == null) goto L39;
        Long r117 = Long.valueOf(r116.getDefaultCameraId());
    L41:
        if ((!Intrinsics.areEqual(r108, r117)) == false) goto L65;
        Room r118 = r115.S1();
        if (r118 == null) goto L60;
        IEpisodeExtraInfo r119 = r118.getEpisodeComponentData();
        if (r119 == null) goto L60;
        List<IVSCameraInfo> r120 = r119.getCameraInfos();
        if (r120 == null) goto L60;
        Iterator<T> r121 = r120.iterator();
    L50:
        if (r121.hasNext() == false) goto L59;
        Object r122 = r121.next();
        long r123 = ((IVSCameraInfo) r122).getCameraId();
        if (r103 != null) goto L54;
    L56:
        boolean r124 = false;
    L57:
        if (r124 == false) goto L50;
        r102 = r122;
        goto L59
    L54:
        if (r123 != r103.getValue().longValue()) goto L56;
        r124 = true;
    L59:
        r101 = (IVSCameraInfo) r102;
    L60:
        if (r101 == null) goto L65;
        IRoomAuthStatus r125 = r101.getCameraRoomAuth();
        if (r125 == null) goto L65;
        r100 = r125;
    L39:
        r117 = null;
        goto L41
    L33:
        r108 = null;
    L27:
        r106 = 0;
        goto L29
    L19:
        if (r100.getCastScreenExplicit() != 1) goto L73;
        return true;
    L73:
        return false;
    L16:
        r115 = null;
    L65:
        if (r100.getCastScreenExplicit() != 1) goto L75;
        return true;
    L75:
        return false;
    L76:
        return false;
    }

    @JvmStatic
    public static final boolean t(DataCenter r100, boolean r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 == true) goto L9;
        if (gb2.a.c(r100, true) == false) goto L9;
        return false;
    L9:
        if (d(r100) == true) goto L11;
        return false;
    L11:
        if (com.bytedance.android.live.core.utils.a0.d(r100, false) == false) goto L13;
        return false;
    L13:
        if (C(null) == false) goto L20;
        return true;
    L20:
        return false;
    }

    @JvmStatic
    public static final boolean u(DataCenter r100, boolean r101) {
        if (t(r100, r101) == false) goto L13;
        IRoomContextService r102 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r102 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.o r103 = IRoomContextService.a.a(r102, null, 0, 3);
        if (r103 == null) goto L13;
        com.bytedance.live.datacontext.m<Boolean> r104 = r103.A1();
        if (r104 == null) goto L13;
        if (r104.getValue().booleanValue() != true) goto L13;
        return true;
    L13:
        return false;
    }

    @JvmStatic
    public static final void a(List r100, CompositeDisposable r101, RoomContext r102) {
        Intrinsics.checkNotNullParameter(r100, "viewItems");
        if (sx0.f121260a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (C(null) == false) goto L20;
        if (r102 == null) goto L24;
        IRoomContextService r103 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r103 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.r r104 = r103.getRoomExpService(r102);
        if (r104 == null) goto L22;
        com.bytedance.live.datacontext.m<Boolean> r105 = r104.x();
        if (r105 != null) goto L15;
        return;
    L15:
        if (r105.getValue().booleanValue() == false) goto L17;
        b(true, r100, r102);
    L17:
        RxUtilKt.c(r105.a().subscribe(new i5(r100, r102)), r101);
        return;
    L22:
        return;
    L21:
        return;
    L24:
        return;
    }

    @JvmStatic
    public static final void b(boolean r100, List<ph1.a> r101, DataContext r110) {
        Intrinsics.checkNotNullParameter(r101, "viewItems");
        IRoomContextService r102 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r102 == null) goto L72;
        com.bytedance.android.livesdk.chatroom.o r103 = IRoomContextService.a.a(r102, null, 0, 3);
        if (r103 != null) goto L7;
        return;
    L7:
        if (((Boolean) SettingKeyUtils.f111513b.getValue()).booleanValue() == true) goto L9;
        return;
    L9:
        if (C(null) == false) goto L75;
        if (r110 == null) goto L80;
        com.bytedance.live.datacontext.m<IRoom> r104 = r103.getRoom();
        if (r104 == null) goto L15;
        IRoom r105 = r104.getValue();
    L17:
        if (p(r105) == true) goto L20;
        return;
    L20:
        if (r101.isEmpty() == false) goto L22;
        return;
    L22:
        IRoomContextService r106 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r106 == null) goto L76;
        com.bytedance.android.livesdk.chatroom.r r111 = r106.getRoomExpService(r110);
        if (r111 == null) goto L77;
        com.bytedance.live.datacontext.n<ArrayList<ph1.a>> r112 = r111.l();
        if (r112 == null) goto L78;
        ArrayList<ph1.a> r113 = r112.getValue();
        if (r113 == null) goto L79;
        if (r100 == false) goto L32;
        String r107 = "add";
    L33:
        ALogger.i("VrUtils", "Before " + r107 + ", vrCleanModeAnchorViews has " + r113.size() + " item(s).");
        if (r100 == false) goto L47;
        Iterator<T> r108 = r101.iterator();
    L37:
        if (r108.hasNext() == false) goto L56;
        ph1.a r109 = (ph1.a) r108.next();
        Iterator<T> r114 = r113.iterator();
    L40:
        if (r114.hasNext() == false) goto L44;
        Object r115 = r114.next();
        if (Intrinsics.areEqual((ph1.a) r115, r109) == false) goto L40;
    L45:
        if (r115 != null) goto L37;
        r113.add(r109);
        goto L37
    L44:
        r115 = null;
    L56:
        ALogger.i("VrUtils", "After " + r107 + ", vrCleanModeAnchorViews has " + r113.size() + " item(s).");
        return;
    L47:
        Iterator<T> r116 = r101.iterator();
    L49:
        if (r116.hasNext() == false) goto L56;
        ph1.a r117 = (ph1.a) r116.next();
        Iterator<ph1.a> r118 = r113.iterator();
    L52:
        if (r118.hasNext() == false) goto L49;
        if (Intrinsics.areEqual(r118.next(), r117) == false) goto L52;
        r118.remove();
        goto L52
    L32:
        r107 = "remove";
        goto L33
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L15:
        r105 = null;
        goto L17
    L80:
        return;
    L75:
        return;
    }
}
