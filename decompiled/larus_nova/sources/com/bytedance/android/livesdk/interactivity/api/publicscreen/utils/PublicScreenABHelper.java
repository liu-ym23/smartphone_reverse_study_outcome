package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.g7;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.i0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.j0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.o0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.p0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.r0;
import com.bytedance.android.livesdk.k7;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPublicScreenAttachments;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPublicScreenInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.j3;
import r52.o3;
import r52.s3;
import r52.u4;
import r52.z2;

/* JADX INFO: loaded from: classes9.dex */
public final class PublicScreenABHelper {
    public static final Lazy A = null;
    public static final Lazy B = null;
    public static final boolean C = false;
    public static final o0 D = null;
    public static final Lazy E = null;
    public static final Lazy F = null;
    public static final Lazy G = null;
    public static final Lazy H = null;
    public static final Lazy I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final Lazy f133580J = null;
    public static final boolean K = false;
    public static final Lazy L = null;
    public static final Lazy M = null;
    public static final Lazy N = null;
    public static final Lazy O = null;
    public static final boolean P = false;
    public static final long Q = 0;
    public static final boolean R = false;
    public static final Boolean S = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f133581a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f133582b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f133583c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f133584d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f133585e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f133586f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f133587g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f133588h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f133589i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f133590j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f133591k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f133592l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f133593m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f133594n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f133595o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Boolean f133596p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Boolean f133597q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy f133598r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Lazy f133599s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Lazy f133600t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Lazy f133601u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Lazy f133602v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Lazy f133603w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Lazy f133604x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Lazy f133605y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Lazy f133606z = null;

    public static float e() {
        return ((Number) f133580J.getValue()).floatValue();
    }

    public static final a0 f() {
        return (a0) G.getValue();
    }

    public static final r0 h() {
        return (r0) F.getValue();
    }

    static {
        f133581a = LazyKt.lazy(PublicScreenABHelper$audienceWaitBufferScrollSize$2.INSTANCE);
        f133582b = LazyKt.lazy(PublicScreenABHelper$audienceWaitBufferFoldSize$2.INSTANCE);
        f133583c = LazyKt.lazy(PublicScreenABHelper$anchorWaitBufferScrollSize$2.INSTANCE);
        f133584d = LazyKt.lazy(PublicScreenABHelper$anchorWaitBufferFoldSize$2.INSTANCE);
        f133585e = LazyKt.lazy(PublicScreenABHelper$audienceDynamicSpeedStrategyV2$2.INSTANCE);
        f133586f = LazyKt.lazy(PublicScreenABHelper$audienceDynamicSpeedLevelConfigV2$2.INSTANCE);
        f133587g = LazyKt.lazy(PublicScreenABHelper$anchorDynamicSpeedStrategyV2$2.INSTANCE);
        f133588h = LazyKt.lazy(PublicScreenABHelper$anchorDynamicSpeedLevelConfigV2$2.INSTANCE);
        f133589i = LazyKt.lazy(PublicScreenABHelper$individualConfigForAnchor$2.INSTANCE);
        f133590j = LazyKt.lazy(PublicScreenABHelper$individualConfigForAudience$2.INSTANCE);
        f133591k = LazyKt.lazy(PublicScreenABHelper$audienceUpdateHotOptConfig$2.INSTANCE);
        f133592l = LazyKt.lazy(PublicScreenABHelper$heightPlatformStrategyConfig$2.INSTANCE);
        f133593m = LazyKt.lazy(PublicScreenABHelper$customerEntranceRemoteIconEnable$2.INSTANCE);
        f133594n = LazyKt.lazy(PublicScreenABHelper$useCustomItemAnimator$2.INSTANCE);
        f133595o = LazyKt.lazy(PublicScreenABHelper$enableFocusWhenMove$2.INSTANCE);
        f133596p = z2.f536294a.getValue();
        f133597q = j3.f536203a.getValue();
        f133598r = LazyKt.lazy(PublicScreenABHelper$enableUpdateWhenHeightChange$2.INSTANCE);
        f133599s = LazyKt.lazy(PublicScreenABHelper$heatAudienceConfig$2.INSTANCE);
        f133600t = LazyKt.lazy(PublicScreenABHelper$heatAnchorConfig$2.INSTANCE);
        f133601u = LazyKt.lazy(PublicScreenABHelper$animOptConfig$2.INSTANCE);
        f133602v = LazyKt.lazy(PublicScreenABHelper$messageHeatAnchorStrategy$2.INSTANCE);
        f133603w = LazyKt.lazy(PublicScreenABHelper$messageHeatAudienceStrategy$2.INSTANCE);
        f133604x = LazyKt.lazy(PublicScreenABHelper$messageBufferSizeAudienceConfig$2.INSTANCE);
        f133605y = LazyKt.lazy(PublicScreenABHelper$messageBufferSizeAnchorConfig$2.INSTANCE);
        f133606z = LazyKt.lazy(PublicScreenABHelper$anchorShowOrderMessageEnable$2.INSTANCE);
        A = LazyKt.lazy(PublicScreenABHelper$audienceShowOrderMessageEnable$2.INSTANCE);
        B = LazyKt.lazy(PublicScreenABHelper$enableGiftMessageDecoupleInPublicScreen$2.INSTANCE);
        C = s3.f536257a.getValue().booleanValue();
        D = o3.f536233a.getValue();
        E = LazyKt.lazy(PublicScreenABHelper$animFramesPerSecond$2.INSTANCE);
        F = LazyKt.lazy(PublicScreenABHelper$styleOptConfig$2.INSTANCE);
        G = LazyKt.lazy(PublicScreenABHelper$horizontalHeightOptConfig$2.INSTANCE);
        H = LazyKt.lazy(PublicScreenABHelper$templateSwitch$2.INSTANCE);
        I = LazyKt.lazy(PublicScreenABHelper$fusionEmojiSendEnable$2.INSTANCE);
        f133580J = LazyKt.lazy(PublicScreenABHelper$fusionEmojiResizeFactor$2.INSTANCE);
        K = u4.f536270a.getValue().enable;
        L = LazyKt.lazy(PublicScreenABHelper$overlappingHeight$2.INSTANCE);
        M = LazyKt.lazy(PublicScreenABHelper$enableNewPSOperateExpandScene$2.INSTANCE);
        N = LazyKt.lazy(PublicScreenABHelper$audienceMentionChatShowStyle$2.INSTANCE);
        O = LazyKt.lazy(PublicScreenABHelper$anchorMentionChatShowStyle$2.INSTANCE);
        g7 r100 = g7.f125384a;
        boolean r101 = r100.getValue().getEnable();
        P = r101;
        Q = r100.getValue().getThreshold();
        if (r101 == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        R = r102;
        S = k7.f142268a.getValue();
        return;
    L5:
        if (r100.getValue().getEnableVSSimplifyFirstMessage() == false) goto L7;
        r102 = true;
        goto L8
    }

    public static boolean c() {
        return !Float.valueOf(e()).equals(Float.valueOf(1.0f));
    }

    @JvmStatic
    public static final boolean a(IRoom r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        IRoomContextService r101 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r101 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.o r102 = IRoomContextService.a.a(r101, null, 0, 3);
        if (r102 == null) goto L28;
        com.bytedance.live.datacontext.n<z70.b> r103 = r102.getTemplateContext();
        if (r103 == null) goto L29;
        z70.b r104 = r103.getValue();
        if (r104 == null) goto L34;
        int r105 = com.bytedance.android.livesdk.interactivity.service.model.e.f140912a;
        if (com.bytedance.android.livesdk.interactivity.service.model.e.a.a().hotMsgTray == true) goto L17;
        return true;
    L17:
        if (r104.k() == false) goto L31;
        RoomPublicScreenInfo r106 = gb2.b.b(r100);
        if (r106 == null) goto L32;
        RoomPublicScreenAttachments r107 = r106.attachments;
        if (r107 != null) goto L23;
        return true;
    L23:
        if (r107.hotMessageTray != 2) goto L35;
        return false;
    L35:
        return true;
    L32:
        return true;
    L31:
        return true;
    L34:
        return true;
    L29:
        return true;
    L28:
        return true;
    L27:
        return true;
    }

    public static boolean b(IRoom r100) {
        if (((Boolean) I.getValue()).booleanValue() == false) goto L10;
        if (r100 == null) goto L10;
        IRoomAuthStatus r101 = r100.getRoomAuthStatus();
        if (r101 == null) goto L10;
        if (r101.isEnableFusionEmoji() != true) goto L10;
        return true;
    L10:
        return false;
    }

    @JvmStatic
    public static final j0 d(boolean r100) {
        if (r100 == false) goto L12;
        Lazy r101 = f133588h;
        List<p0> r102 = ((j0) r101.getValue()).b();
        if (r102 == null) goto L11;
        if (r102.isEmpty() != true) goto L11;
        int r103 = j0.f133763a;
        return j0.a.a();
    L11:
        return (j0) r101.getValue();
    L12:
        Lazy r104 = f133586f;
        List<p0> r105 = ((j0) r104.getValue()).b();
        if (r105 == null) goto L19;
        if (r105.isEmpty() != true) goto L19;
        int r106 = j0.f133763a;
        return j0.a.a();
    L19:
        return (j0) r104.getValue();
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.interactivity.api.settings.config.m g(boolean r100) {
        if (r100 == false) goto L5;
        return (com.bytedance.android.livesdk.interactivity.api.settings.config.m) f133589i.getValue();
    L5:
        return (com.bytedance.android.livesdk.interactivity.api.settings.config.m) f133590j.getValue();
    }

    @JvmStatic
    public static final boolean i(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        i0 r101 = (i0) f133601u.getValue();
        if (r101.b() == true) goto L5;
        return false;
    L5:
        if (r101.a() == false) goto L19;
        Intrinsics.checkNotNullParameter(r100, "room");
        IBaseStreamUrl r102 = r100.getStreamUrl();
        if (r102 != null) goto L9;
    L11:
        IStreamUrlExtra r103 = r100.getStreamUrlExtraSafely();
        if (r103.getWidth() <= r103.getHeight()) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == true) goto L10;
        boolean r105 = false;
    L18:
        if (r105 == true) goto L19;
        return false;
    L10:
        r105 = true;
        goto L18
    L14:
        r104 = false;
        goto L15
    L9:
        if (r102.getStreamOrientation() != 2) goto L11;
    L19:
        return true;
    }
}
