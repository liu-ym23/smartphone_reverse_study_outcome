package com.bytedance.android.live.revlink.impl.control.launchcontext;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.widgetservice.RevLinkAnchorLaunchParam;
import com.bytedance.android.live.revlink.widgetservice.RevLinkAudienceLaunchParam;
import com.bytedance.android.livesdk.link.model.a6;
import com.bytedance.android.livesdk.link.model.bridge.o1;
import com.bytedance.android.livesdk.link.model.bridge.p1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdk.link.model.m;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.v3;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class RevLinkSwitchExtraContext {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f92423g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sc0.a f92424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sc0.b f92425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final sc0.c f92426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final sc0.d f92427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RevLinkAnchorLaunchParam f92428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RevLinkAudienceLaunchParam f92429f;

    public static final class Companion {
        public Companion() {
        }

        public static RevLinkSwitchExtraContext a(u r210, f21.a r211, v3 r212, p0 r213, String r310) {
            a r110 = new a(r210, r211, r212, r213, r310);
            long r100 = 0;
            String r101 = "";
            int r102 = 7;
            if (d51.b.f466913m.b() == true) goto L5;
            b03.a r103 = b03.a.f16857a;
            final int r104 = s1.w();
            final int r105 = s1.y();
            if (r210 == null) goto L67;
            r102 = r210.b();
        L67:
            if (r210 == null) goto L72;
            String r111 = r210.f94965c;
            if (r111 == null) goto L72;
            r101 = r111;
        L72:
            if (r210 == null) goto L74;
            r100 = r210.f94963a;
        L74:
            long r112 = r100;
            Function0<Integer> r106 = new RevLinkSwitchExtraContext$Companion$packetMultiLinkAnchor$3(r105);
            Function0<Integer> r107 = new RevLinkSwitchExtraContext$Companion$packetMultiLinkAnchor$4(r104);
            if (r211 == null) goto L82;
            v1 r108 = r211.f475127q;
            if (r108 == null) goto L82;
            o1 r109 = r108.getMultiAnchorLinkMicRtcInfo();
            if (r109 == null) goto L82;
            Map<Long, String> r113 = r109.getPushStreamModeRTCMap();
            if (r113 == null) goto L82;
        L83:
            Map<Long, String> r114 = r113;
            if (r211 == null) goto L91;
            d7 r115 = r211.f475126p;
            if (r115 == null) goto L91;
            p1 r116 = r115.getMultiAnchorLiveCoreInfo();
            if (r116 == null) goto L91;
            Map<Long, String> r117 = r116.getPushStreamModeLiveCoreMap();
            if (r117 == null) goto L91;
        L92:
            Map<Long, String> r118 = r117;
            if (r211 == null) goto L100;
            v1 r119 = r211.f475127q;
            if (r119 == null) goto L100;
            o1 r120 = r119.getMultiAnchorLinkMicRtcInfo();
            if (r120 == null) goto L100;
            Map<Long, String> r121 = r120.getRtcInfoMap();
            if (r121 == null) goto L100;
        L101:
            Map<Long, String> r122 = r121;
            if (r211 == null) goto L109;
            d7 r123 = r211.f475126p;
            if (r123 == null) goto L109;
            p1 r124 = r123.getMultiAnchorLiveCoreInfo();
            if (r124 == null) goto L109;
            Map<Long, String> r125 = r124.getLiveCoreExtInfoMap();
            if (r125 == null) goto L109;
        L110:
            Map<Long, String> r214 = r125;
            if (r211 != null) goto L113;
        L115:
            boolean r215 = false;
        L116:
            if (r211 != null) goto L118;
        L120:
            boolean r216 = false;
        L122:
            return new RevLinkSwitchExtraContext(r110, null, null, new RevLinkAnchorLaunchParam(r102, r101, r112, r106, r107, r114, r118, r122, r214, r110, null, r215, r216, false, true), null, 46);
        L118:
            if (r211.b() != true) goto L120;
            r216 = true;
            goto L122
        L113:
            if (r211.c() != true) goto L115;
            r215 = true;
        L109:
            r125 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L100:
            r121 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L91:
            r117 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L82:
            r113 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
            goto L83
        L5:
            if (r210 == null) goto L7;
            r102 = r210.b();
        L7:
            if (r210 == null) goto L12;
            String r126 = r210.f94965c;
            if (r126 == null) goto L12;
            r101 = r126;
        L12:
            if (r210 == null) goto L14;
            long r127 = r210.f94963a;
        L15:
            RevLinkSwitchExtraContext$Companion$packetMultiLinkAnchor$1 r128 = RevLinkSwitchExtraContext$Companion$packetMultiLinkAnchor$1.INSTANCE;
            RevLinkSwitchExtraContext$Companion$packetMultiLinkAnchor$2 r129 = RevLinkSwitchExtraContext$Companion$packetMultiLinkAnchor$2.INSTANCE;
            if (r211 == null) goto L23;
            v1 r130 = r211.f475127q;
            if (r130 == null) goto L23;
            o1 r131 = r130.getMultiAnchorLinkMicRtcInfo();
            if (r131 == null) goto L23;
            Map<Long, String> r132 = r131.getPushStreamModeRTCMap();
            if (r132 == null) goto L23;
        L24:
            Map<Long, String> r133 = r132;
            if (r211 == null) goto L32;
            d7 r134 = r211.f475126p;
            if (r134 == null) goto L32;
            p1 r135 = r134.getMultiAnchorLiveCoreInfo();
            if (r135 == null) goto L32;
            Map<Long, String> r136 = r135.getPushStreamModeLiveCoreMap();
            if (r136 == null) goto L32;
        L33:
            Map<Long, String> r137 = r136;
            if (r211 == null) goto L41;
            v1 r138 = r211.f475127q;
            if (r138 == null) goto L41;
            o1 r139 = r138.getMultiAnchorLinkMicRtcInfo();
            if (r139 == null) goto L41;
            Map<Long, String> r140 = r139.getRtcInfoMap();
            if (r140 == null) goto L41;
        L42:
            Map<Long, String> r141 = r140;
            if (r211 == null) goto L50;
            d7 r142 = r211.f475126p;
            if (r142 == null) goto L50;
            p1 r143 = r142.getMultiAnchorLiveCoreInfo();
            if (r143 == null) goto L50;
            Map<Long, String> r144 = r143.getLiveCoreExtInfoMap();
            if (r144 == null) goto L50;
        L51:
            Map<Long, String> r217 = r144;
            if (r211 != null) goto L54;
        L56:
            boolean r218 = false;
        L57:
            if (r211 != null) goto L59;
        L61:
            boolean r219 = false;
        L63:
            return new RevLinkSwitchExtraContext(r110, null, null, new RevLinkAnchorLaunchParam(r102, r101, r127, r128, r129, r133, r137, r141, r217, r110, null, r218, r219, false, true), null, 46);
        L59:
            if (r211.b() != true) goto L61;
            r219 = true;
            goto L63
        L54:
            if (r211.c() != true) goto L56;
            r218 = true;
        L50:
            r144 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L41:
            r140 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L32:
            r136 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L23:
            r132 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
            goto L24
        L14:
            r127 = 0;
            goto L15
        }

        public static RevLinkSwitchExtraContext b(int r110, long r111, com.bytedance.android.live.revlink.impl.audience.c r112, String r113, a6 r210) {
            Intrinsics.checkNotNullParameter(r112, "source");
            b r100 = new b(r111, r112, r113, r210);
            if (d51.b.f466913m.b() == false) goto L6;
            RevLinkSwitchExtraContext$Companion$packetMultiLinkAudience$1 r101 = RevLinkSwitchExtraContext$Companion$packetMultiLinkAudience$1.INSTANCE;
            return new RevLinkSwitchExtraContext(null, r100, null, null, new RevLinkAudienceLaunchParam(r110, r111, RevLinkSwitchExtraContext$Companion$packetMultiLinkAudience$2.INSTANCE, r101, r210, r100, 160), 29);
        L6:
            b03.a r102 = b03.a.f16857a;
            final int r103 = s1.w();
            int r104 = s1.y();
            if (b03.a.c() == false) goto L9;
            int r105 = 0;
        L10:
            final int r106 = r104 + r105;
            Function0<Integer> r107 = new RevLinkSwitchExtraContext$Companion$packetMultiLinkAudience$3(r103);
            return new RevLinkSwitchExtraContext(null, r100, null, null, new RevLinkAudienceLaunchParam(r110, r111, new RevLinkSwitchExtraContext$Companion$packetMultiLinkAudience$4(r106), r107, r210, r100, 160), 29);
        L9:
            r105 = s1.A();
            goto L10
        }

        public static RevLinkSwitchExtraContext c(long r310, String r311, String r312, PkAnchorLaunchType r313, v1 r314, d7 r315, m r410, p0 r411, String r412) {
            Intrinsics.checkNotNullParameter(r311, "selfLinkerID");
            Intrinsics.checkNotNullParameter(r313, "launchType");
            c r316 = new c(r310, r312, r313, r411, r410, r412);
            if (d51.b.f466913m.b() == false) goto L34;
            RevLinkSwitchExtraContext$Companion$packetPkAnchor$1 r100 = RevLinkSwitchExtraContext$Companion$packetPkAnchor$1.INSTANCE;
            RevLinkSwitchExtraContext$Companion$packetPkAnchor$2 r101 = RevLinkSwitchExtraContext$Companion$packetPkAnchor$2.INSTANCE;
            if (r314 == null) goto L10;
            o1 r102 = r314.getMultiAnchorLinkMicRtcInfo();
            if (r102 == null) goto L10;
            Map<Long, String> r103 = r102.getPushStreamModeRTCMap();
            if (r103 == null) goto L10;
        L11:
            Map<Long, String> r104 = r103;
            if (r315 == null) goto L17;
            p1 r105 = r315.getMultiAnchorLiveCoreInfo();
            if (r105 == null) goto L17;
            Map<Long, String> r106 = r105.getPushStreamModeLiveCoreMap();
            if (r106 == null) goto L17;
        L18:
            Map<Long, String> r107 = r106;
            if (r314 == null) goto L24;
            o1 r108 = r314.getMultiAnchorLinkMicRtcInfo();
            if (r108 == null) goto L24;
            Map<Long, String> r109 = r108.getRtcInfoMap();
            if (r109 == null) goto L24;
        L25:
            Map<Long, String> r110 = r109;
            if (r315 == null) goto L31;
            p1 r111 = r315.getMultiAnchorLiveCoreInfo();
            if (r111 == null) goto L31;
            Map<Long, String> r112 = r111.getLiveCoreExtInfoMap();
            if (r112 == null) goto L31;
        L33:
            return new RevLinkSwitchExtraContext(null, null, r316, new RevLinkAnchorLaunchParam(1, r311, r310, r100, r101, r104, r107, r110, r112, null, r316, true, false, false, true), null, 43);
        L31:
            r112 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L24:
            r109 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L17:
            r106 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L10:
            r103 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
            goto L11
        L34:
            b03.a r113 = b03.a.f16857a;
            final int r114 = s1.y();
            final int r115 = s1.w();
            Function0<Integer> r116 = new RevLinkSwitchExtraContext$Companion$packetPkAnchor$3(r114);
            Function0<Integer> r117 = new RevLinkSwitchExtraContext$Companion$packetPkAnchor$4(r115);
            if (r314 == null) goto L40;
            o1 r118 = r314.getMultiAnchorLinkMicRtcInfo();
            if (r118 == null) goto L40;
            Map<Long, String> r119 = r118.getPushStreamModeRTCMap();
            if (r119 == null) goto L40;
        L41:
            Map<Long, String> r210 = r119;
            if (r315 == null) goto L47;
            p1 r120 = r315.getMultiAnchorLiveCoreInfo();
            if (r120 == null) goto L47;
            Map<Long, String> r121 = r120.getPushStreamModeLiveCoreMap();
            if (r121 == null) goto L47;
        L48:
            Map<Long, String> r211 = r121;
            if (r314 == null) goto L54;
            o1 r122 = r314.getMultiAnchorLinkMicRtcInfo();
            if (r122 == null) goto L54;
            Map<Long, String> r123 = r122.getRtcInfoMap();
            if (r123 == null) goto L54;
        L55:
            Map<Long, String> r212 = r123;
            if (r315 == null) goto L63;
            p1 r124 = r315.getMultiAnchorLiveCoreInfo();
            if (r124 == null) goto L63;
            Map<Long, String> r125 = r124.getLiveCoreExtInfoMap();
            if (r125 == null) goto L63;
            Map<Long, String> r213 = r125;
        L65:
            return new RevLinkSwitchExtraContext(null, null, r316, new RevLinkAnchorLaunchParam(1, r311, r310, r116, r117, r210, r211, r212, r213, null, r316, true, false, false, true), null, 43);
        L63:
            r213 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L54:
            r123 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L47:
            r121 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L40:
            r119 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
            goto L41
        }
    }

    static {
        new Companion();
    }

    public RevLinkSwitchExtraContext() {
        this(null, null, null, null, null, 63);
    }

    public final int hashCode() {
        sc0.a r100 = this.f92424a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        sc0.b r104 = this.f92425b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        sc0.c r107 = this.f92426c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        sc0.d r110 = this.f92427d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        RevLinkAnchorLaunchParam r113 = this.f92428e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        RevLinkAudienceLaunchParam r116 = this.f92429f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RevLinkSwitchExtraContext(multiLinkAnchorSwitchContext=" + this.f92424a + ", multiLinkAudienceSwitchContext=" + this.f92425b + ", pkAnchorSwitchContext=" + this.f92426c + ", pkAudienceSwitchContext=" + this.f92427d + ", revLinkAnchorLaunchParam=" + this.f92428e + ", revLinkAudienceLaunchParam=" + this.f92429f + ")";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RevLinkSwitchExtraContext) == false) goto L18;
        RevLinkSwitchExtraContext r101 = (RevLinkSwitchExtraContext) r100;
        if (Intrinsics.areEqual(this.f92424a, r101.f92424a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f92425b, r101.f92425b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f92426c, r101.f92426c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f92427d, r101.f92427d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f92428e, r101.f92428e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f92429f, r101.f92429f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public RevLinkSwitchExtraContext(a r100, b r101, c r102, RevLinkAnchorLaunchParam r103, RevLinkAudienceLaunchParam r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 32) == 0) goto L17;
        r104 = null;
    L17:
        this.f92424a = r100;
        this.f92425b = r101;
        this.f92426c = r102;
        this.f92427d = null;
        this.f92428e = r103;
        this.f92429f = r104;
    }
}
