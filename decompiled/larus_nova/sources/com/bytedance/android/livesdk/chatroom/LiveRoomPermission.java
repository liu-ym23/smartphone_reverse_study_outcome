package com.bytedance.android.livesdk.chatroom;

import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.user.api.IUserServiceV2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.larus.nova.R;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.ttvideoengine.model.VideoRef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveRoomPermission {
    public static final LiveRoomPermission A = null;
    public static final List<LiveRoomPermission> B = null;
    public static final List<LiveRoomPermission> C = null;
    public static final Companion D = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LiveRoomPermission f105058h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final LiveRoomPermission f105059i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final LiveRoomPermission f105060j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final LiveRoomPermission f105061k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final LiveRoomPermission f105062l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final LiveRoomPermission f105063m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final LiveRoomPermission f105064n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final LiveRoomPermission f105065o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final LiveRoomPermission f105066p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final LiveRoomPermission f105067q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final LiveRoomPermission f105068r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final LiveRoomPermission f105069s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final LiveRoomPermission f105070t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final LiveRoomPermission f105071u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final LiveRoomPermission f105072v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final LiveRoomPermission f105073w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final LiveRoomPermission f105074x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final LiveRoomPermission f105075y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final LiveRoomPermission f105076z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f105077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f105078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f105079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f105080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f105081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f105082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f105083g;

    public static final class Companion {

        @Retention(RetentionPolicy.RUNTIME)
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/LiveRoomPermission$Companion$PermissionType;", "", "liveuser-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public @interface PermissionType {
        }

        public Companion() {
        }

        @JvmStatic
        public static boolean c() {
            boolean r100 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().isAdmin();
            IMiddlewareUserService r101 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
            if (r101 == null) goto L13;
            com.bytedance.android.livesdk.user.e r102 = r101.user();
            if (r102 == null) goto L13;
            UserAttr r103 = r102.q();
            if (r103 == null) goto L13;
            List<Integer> r104 = r103.getAdminPrivileges();
            if (r104 == null) goto L13;
            LiveRoomPermission.D.getClass();
            if (r104.contains(Integer.valueOf(LiveRoomPermission.f105075y.f105077a)) != true) goto L13;
            boolean r105 = true;
        L14:
            if (r100 == false) goto L18;
            if (r105 == false) goto L19;
            return true;
        L19:
            return false;
        L18:
            return false;
        L13:
            r105 = false;
            goto L14
        }

        public static LiveRoomPermission a(int r100) {
            Iterator<T> r101 = LiveRoomPermission.B.iterator();
        L4:
            if (r101.hasNext() == false) goto L11;
            Object r102 = r101.next();
            if (((LiveRoomPermission) r102).f105077a != r100) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == false) goto L4;
        L13:
            return (LiveRoomPermission) r102;
        L8:
            r103 = false;
            goto L9
        L11:
            r102 = null;
            goto L13
        }

        public static boolean d(List r100) {
            Intrinsics.checkNotNullParameter(r100, ComplianceResult.JsonKey.PERMISSIONS);
            if (r100.contains(LiveRoomPermission.f105061k) == false) goto L5;
        L10:
            return true;
        L5:
            if (r100.contains(LiveRoomPermission.f105058h) == true) goto L10;
            if (r100.contains(LiveRoomPermission.f105059i) == true) goto L10;
            return false;
        }

        public static List b(List r100, int r101) {
            if (r100 == null) goto L4;
            List<LiveRoomPermission> r102 = LiveRoomPermission.B;
            ArrayList r103 = new ArrayList();
            Iterator<T> r104 = r102.iterator();
        L7:
            if (r104.hasNext() == false) goto L18;
            Object r105 = r104.next();
            LiveRoomPermission r106 = (LiveRoomPermission) r105;
            if (r100.contains(Integer.valueOf(r106.f105077a)) == false) goto L15;
            if (r101 < 0) goto L14;
            if (r101 < 0) goto L15;
            if (r101 != r106.getType()) goto L15;
        L14:
            boolean r107 = true;
        L16:
            if (r107 == false) goto L7;
            r103.add(r105);
        L15:
            r107 = false;
            goto L16
        L18:
            return r103;
        L4:
            return CollectionsKt.emptyList();
        }
    }

    static {
        D = new Companion();
        LiveRoomPermission r100 = new LiveRoomPermission(5, "禁言", null, 0, 252);
        f105058h = r100;
        LiveRoomPermission r101 = new LiveRoomPermission(6, "拉黑", null, 0, 252);
        f105059i = r101;
        LiveRoomPermission r102 = new LiveRoomPermission(11, "发弹幕", null, 0, 252);
        f105060j = r102;
        LiveRoomPermission r103 = new LiveRoomPermission(4, "设置屏蔽词", null, 0, 252);
        f105061k = r103;
        LiveRoomPermission r104 = new LiveRoomPermission(7, "操作连线嘉宾", null, 0, 252);
        f105062l = r104;
        LiveRoomPermission r105 = new LiveRoomPermission(2, "提词", "直播中能向你发送消息，仅你可见", 1, VideoRef.VALUE_VIDEO_REF_CATEGORY);
        f105063m = r105;
        LiveRoomPermission r106 = new LiveRoomPermission(12, s1.B(R.string.ttlive_admin_pin_comment_user), s1.B(R.string.ttlive_admin_pin_comment_desc_user), 1, VideoRef.VALUE_VIDEO_REF_CATEGORY);
        LiveRoomPermission r107 = new LiveRoomPermission(9, "心愿单控制", "直播中能帮你创建、修改心愿单内容", 1, 224);
        f105064n = r107;
        LiveRoomPermission r108 = new LiveRoomPermission(8, "礼物投票控制", "直播中能帮你创建、结束礼物投票", 1, 224);
        f105065o = r108;
        LiveRoomPermission r109 = new LiveRoomPermission(10, "小插件控制", "直播中能帮你开启、关闭小插件", 1, 224);
        f105066p = r109;
        LiveRoomPermission r110 = new LiveRoomPermission(14, "嘉宾大作战控制", "直播中能帮你开启、修改、结束嘉宾大作战", 3, 224);
        f105067q = r110;
        LiveRoomPermission r111 = new LiveRoomPermission(15, "多人团战控制", "直播中能帮你开启、修改、结束多人团战", 3, 224);
        f105068r = r111;
        LiveRoomPermission r112 = new LiveRoomPermission(16, "跨房玩法控制", "直播中能帮你开启、修改、结束跨房玩法", 3, 224);
        f105069s = r112;
        LiveRoomPermission r113 = new LiveRoomPermission(17, "你点我唱控制", "直播中能帮你开启、结束你点我唱", 3, 224);
        f105070t = r113;
        LiveRoomPermission r114 = new LiveRoomPermission(19, "观众连线玩法控制", "直播中能帮你开启、控制和关闭连线玩法", 2, 224);
        f105071u = r114;
        LiveRoomPermission r115 = new LiveRoomPermission(20, "设置房间主咖", "直播中能帮你将嘉宾设置为房间主咖", 2, 224);
        f105072v = r115;
        LiveRoomPermission r116 = new LiveRoomPermission(21, "设置麦位名称", "直播中能帮你开启、关闭和编辑麦位名称", 2, 224);
        f105073w = r116;
        LiveRoomPermission r117 = new LiveRoomPermission(25, "更改布局", "直播中能帮你更新切换布局", 2, 224);
        LiveRoomPermission r118 = new LiveRoomPermission(22, "置顶评论", "管理员可对评论进行置顶，帮你控场", 1, 224);
        f105074x = r118;
        LiveRoomPermission r210 = new LiveRoomPermission(23, "开始录屏", "管理员录屏", 1, 224);
        f105075y = r210;
        LiveRoomPermission r211 = new LiveRoomPermission(13, "发弹幕", "可通过管理员弹幕进行直播控场", 1, 224);
        f105076z = r211;
        LiveRoomPermission r212 = new LiveRoomPermission(18, "管理共创直播", "管理员可发起共创直播并邀请、管理嘉宾", 1, 224);
        A = r212;
        boolean r213 = false;
        List<LiveRoomPermission> r119 = CollectionsKt.mutableListOf(new LiveRoomPermission[]{r100, r101, r102, r103, r104, r212, r118, r211, r105, r107, r108, r106, r109, r114, r115, r116, r117, r110, r113, r112, r111, r210});
        B = r119;
        List<LiveRoomPermission> r120 = CollectionsKt.toMutableList(r119);
        IUserServiceV2 r121 = (IUserServiceV2) jc1.k.f(IUserServiceV2.class);
        IRoom r122 = null;
        if (r121 == null) goto L5;
        IRoom r123 = r121.getRoomFromStaticRoomContext();
    L6:
        if (r123 == null) goto L11;
        IRoomAuthStatus r124 = r123.getRoomAuthStatus();
        if (r124 == null) goto L11;
        if (1 != r124.getEnableAdminPinComment()) goto L11;
    L12:
        if (r213 == false) goto L14;
        r120.remove(r106);
    L14:
        r120.remove(r102);
        IUserServiceV2 r125 = (IUserServiceV2) jc1.k.f(IUserServiceV2.class);
        if (r125 == null) goto L17;
        r122 = r125.getRoomFromStaticRoomContext();
    L17:
        if (r122 != null) goto L19;
    L21:
        C = r120;
        return;
    L19:
        if (r122.isMediaRoom() != true) goto L21;
        r120.remove(r104);
    L11:
        r213 = true;
        goto L12
    L5:
        r123 = null;
        goto L6
    }

    public final int getType() {
        return this.f105080d;
    }

    public LiveRoomPermission(int r100, String r101, String r102, int r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 16) == 0) goto L8;
        r103 = 0;
    L8:
        this.f105077a = r100;
        this.f105078b = r101;
        this.f105079c = r102;
        this.f105080d = r103;
        this.f105081e = false;
        this.f105082f = null;
        this.f105083g = 0;
    }
}
