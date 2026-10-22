package com.bytedance.android.livesdk.dispatch.utils;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.qo;
import com.bytedance.android.livesdk.dispatch.DispatchContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.ss.android.cert.manager.constants.EventConstant;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class DispatchLogUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f122274a = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/dispatch/utils/DispatchLogUtil$InstanceType;", "", "", EventConstant.Key.MODULE, "Ljava/lang/String;", "getModule", "()Ljava/lang/String;", "action", "getAction", "FOLLOW", "UNFOLLOW", "DISLIKE", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum InstanceType extends Enum<InstanceType> {
        public static final InstanceType DISLIKE = null;
        public static final InstanceType FOLLOW = null;
        public static final InstanceType UNFOLLOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InstanceType[] f122275a = null;
        private final String action;
        private final String module;

        static {
            InstanceType r100 = new InstanceType("FOLLOW", 0, "User", "follow");
            FOLLOW = r100;
            InstanceType r101 = new InstanceType("UNFOLLOW", 1, "User", "unfollow");
            UNFOLLOW = r101;
            InstanceType r102 = new InstanceType("DISLIKE", 2, "Dislike", AppConstants.BUNDLE_DISLIKE);
            DISLIKE = r102;
            f122275a = new InstanceType[]{r100, r101, r102};
        }

        public static InstanceType valueOf(String r100) {
            return (InstanceType) r27.a.a(InstanceType.class, r100);
        }

        public static InstanceType[] values() {
            return (InstanceType[]) f122275a.clone();
        }

        public final String getAction() {
            return this.action;
        }

        public final String getModule() {
            return this.module;
        }

        public InstanceType(String r100, int r101, String r102, String r103) {
            super(r100, r101);
            this.module = r102;
            this.action = r103;
        }
    }

    static {
        f122274a = LazyKt.lazy(DispatchLogUtil$isDebug$2.INSTANCE);
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (((Boolean) f122274a.getValue()).booleanValue() == false) goto L6;
        ALogger.e("DispatchLogUtil", r100);
        return;
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (((Boolean) f122274a.getValue()).booleanValue() == false) goto L8;
        int r101 = a.f122276a;
        if (qo.f121071a.getValue().booleanValue() == false) goto L9;
        f2.c(r100, 0);
        return;
    L9:
        return;
    }

    public static void d(int r100, InstanceType r101) {
        Intrinsics.checkNotNullParameter(r101, "instanceType");
        f(r100, r101.getModule(), r101.getAction(), null);
    }

    public static void b(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter("User", EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, "fullSchema");
        long r103 = System.currentTimeMillis() - r100;
        u.l().sendLog("livesdk_schema_dispatcher", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(EventConstant.Key.MODULE, "User"), TuplesKt.to("action", r101), TuplesKt.to("type", "dispatch"), TuplesKt.to("duration", String.valueOf(r103)), TuplesKt.to("scheme", r102)}), new Object[]{Room.class, x.class});
        a("module 是 User  action 是 " + r101 + " duration 是 " + r103);
    }

    public static void e(int r110, String r111, DispatchContext r112) {
        Intrinsics.checkNotNullParameter(r111, "key");
        long r100 = System.currentTimeMillis();
        RoomContext.a r101 = RoomContext.Companion;
        RoomContext r102 = RoomContext.a.c(r101, null, 0, 3);
        DataContext r113 = r112;
        if (r102 == null) goto L11;
        j<DataContext> r103 = r102.getDispatchContext();
        r113 = r112;
        if (r103 == null) goto L11;
        DataContext r104 = r103.getValue();
        r113 = r112;
        if (r104 == null) goto L11;
        r113 = r104;
    L11:
        if ((r113 instanceof DispatchContext) == true) goto L13;
        return;
    L13:
        if (r110 != 1) goto L15;
        ((DispatchContext) r113).getLogStartTime().put(r111, Long.valueOf(r100));
    L15:
        Long r114 = ((DispatchContext) r113).getLogStartTime().get(r111);
        if (r114 == null) goto L18;
        long r105 = r114.longValue();
    L19:
        if (r110 == 0) goto L23;
        if (r110 == 1) goto L23;
        long r106 = r100 - r105;
    L24:
        u.l().sendLog("livesdk_schema_dispatcher_trace", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("path", r111), TuplesKt.to("type", String.valueOf(r110)), TuplesKt.to("duration", String.valueOf(r106))}), new Object[]{Room.class, x.class});
        RoomContext r115 = RoomContext.a.c(r101, null, 0, 3);
        if (r115 == null) goto L29;
        m<Room> r116 = r115.getRoom();
        if (r116 == null) goto L29;
        Room r117 = r116.getValue();
    L30:
        String r107 = ((IUserService) k.n(IUserService.class)).user().n();
        int r108 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r109 = com.bytedance.android.live.core.monitor.trace.e.b.a(r111, "live_dispatch_handle");
        r109.f65012c = "webcast_client_community";
        r109.f65017h = Integer.valueOf(r110);
        r109.f65018i = r111;
        if (r117 == null) goto L33;
        String r118 = String.valueOf(r117.f162599id);
    L34:
        r109.f65014e = r118;
        r109.f65016g = r107;
        if (r117 == null) goto L37;
        String r119 = r117.getAnchorId();
    L38:
        r109.f65015f = r119;
        com.bytedance.android.live.core.monitor.trace.c.b(r109.a(), null);
        a("path: " + r111 + "  type:  " + r110 + "  duration: " + r106);
        if (r110 != 4) goto L42;
        c("执行 ".concat(r111));
        return;
    L42:
        if (r110 != 6) goto L45;
        c(r111.concat(" 回调成功"));
        return;
    L45:
        if (r110 != 8) goto L51;
        c(r111.concat(" 回调失败"));
        return;
    L51:
        return;
    L37:
        r119 = null;
        goto L38
    L33:
        r118 = null;
    L29:
        r117 = null;
    L23:
        r106 = 0;
        goto L24
    L18:
        r105 = System.currentTimeMillis();
        goto L19
    }

    public static void f(int r100, String r101, String r102, DispatchContext r103) {
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r102, "action");
        e(r100, r101 + '/' + r102, r103);
    }
}
