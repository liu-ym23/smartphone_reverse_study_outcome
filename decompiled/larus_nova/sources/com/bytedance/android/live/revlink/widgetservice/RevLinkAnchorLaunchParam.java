package com.bytedance.android.live.revlink.widgetservice;

import com.bytedance.android.live.revlink.impl.control.launchcontext.c;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.revenue.platform.api.core.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
public final class RevLinkAnchorLaunchParam {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f98796q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f98797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f98798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f98799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Integer> f98800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Integer> f98801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f98802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Long, String> f98803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Long, String> f98804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Long, String> f98805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<Long, String> f98806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.control.launchcontext.a f98807k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f98808l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f98809m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f98810n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f98811o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f98812p;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.widgetservice.RevLinkAnchorLaunchParam$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
    final class AnonymousClass1 extends Lambda implements Function0<Integer> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return 0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.widgetservice.RevLinkAnchorLaunchParam$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
    final class AnonymousClass2 extends Lambda implements Function0<Integer> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return 0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }
    }

    public static final class Companion {
        public static RevLinkAnchorLaunchParam a(int r110, long r111, boolean r210) {
            return new RevLinkAnchorLaunchParam(r110, "", r111, RevLinkAnchorLaunchParam$Companion$genMergeSceneSwitchParam$1.INSTANCE, RevLinkAnchorLaunchParam$Companion$genMergeSceneSwitchParam$2.INSTANCE, d.a(new Pair[0]), d.a(new Pair[0]), d.a(new Pair[0]), d.a(new Pair[0]), null, null, false, false, true, r210);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RevLinkAnchorLaunchParam) == false) goto L38;
        RevLinkAnchorLaunchParam r101 = (RevLinkAnchorLaunchParam) r100;
        if (this.f98797a == r101.f98797a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f98798b, r101.f98798b) == true) goto L10;
        return false;
    L10:
        if (this.f98799c == r101.f98799c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f98800d, r101.f98800d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f98801e, r101.f98801e) == true) goto L16;
        return false;
    L16:
        if (this.f98802f == r101.f98802f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f98803g, r101.f98803g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f98804h, r101.f98804h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f98805i, r101.f98805i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f98806j, r101.f98806j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f98807k, r101.f98807k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f98808l, r101.f98808l) == true) goto L30;
        return false;
    L30:
        if (this.f98809m == r101.f98809m) goto L32;
        return false;
    L32:
        if (this.f98810n == r101.f98810n) goto L34;
        return false;
    L34:
        if (this.f98811o == r101.f98811o) goto L36;
        return false;
    L36:
        if (this.f98812p == r101.f98812p) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30, types: [int] */
    /* JADX WARN: Type inference failed for: r1v32, types: [int] */
    /* JADX WARN: Type inference failed for: r1v34, types: [int] */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final int hashCode() {
        int r100 = this.f98797a * 31;
        String r101 = this.f98798b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        long r104 = this.f98799c;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        Function0<Integer> r106 = this.f98800d;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        Function0<Integer> r109 = this.f98801e;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        boolean r112 = this.f98802f;
        ?? r113 = 1;
        ?? r114 = r112;
        if (r112 == false) goto L17;
        r114 = 1;
    L17:
        int r115 = (r111 + r114) * 31;
        Map<Long, String> r116 = this.f98803g;
        if (r116 == null) goto L20;
        int r117 = r116.hashCode();
    L21:
        int r118 = (r115 + r117) * 31;
        Map<Long, String> r119 = this.f98804h;
        if (r119 == null) goto L24;
        int r120 = r119.hashCode();
    L25:
        int r121 = (r118 + r120) * 31;
        Map<Long, String> r122 = this.f98805i;
        if (r122 == null) goto L28;
        int r123 = r122.hashCode();
    L29:
        int r124 = (r121 + r123) * 31;
        Map<Long, String> r125 = this.f98806j;
        if (r125 == null) goto L32;
        int r126 = r125.hashCode();
    L33:
        int r127 = (r124 + r126) * 31;
        com.bytedance.android.live.revlink.impl.control.launchcontext.a r128 = this.f98807k;
        if (r128 == null) goto L36;
        int r129 = r128.hashCode();
    L37:
        int r130 = (r127 + r129) * 31;
        c r131 = this.f98808l;
        if (r131 == null) goto L40;
        r102 = r131.hashCode();
    L40:
        int r132 = (r130 + r102) * 31;
        boolean r133 = this.f98809m;
        ?? r134 = r133;
        if (r133 == false) goto L43;
        r134 = 1;
    L43:
        int r135 = (r132 + r134) * 31;
        boolean r136 = this.f98810n;
        ?? r137 = r136;
        if (r136 == false) goto L46;
        r137 = 1;
    L46:
        int r138 = (r135 + r137) * 31;
        boolean r139 = this.f98811o;
        ?? r140 = r139;
        if (r139 == false) goto L49;
        r140 = 1;
    L49:
        int r141 = (r138 + r140) * 31;
        boolean r142 = this.f98812p;
        if (r142 == true) goto L54;
        r113 = r142;
    L54:
        return r141 + r113;
    L36:
        r129 = 0;
        goto L37
    L32:
        r126 = 0;
        goto L33
    L28:
        r123 = 0;
        goto L29
    L24:
        r120 = 0;
        goto L25
    L20:
        r117 = 0;
        goto L21
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "RevLinkAnchorLaunchParam(scene=" + this.f98797a + ", selfLinkerID=" + this.f98798b + ", channelID=" + this.f98799c + ", containerWidth=" + this.f98800d + ", containerHeight=" + this.f98801e + ", selfIsPKStarter=" + this.f98802f + ", rtcData=" + this.f98803g + ", liveCoreData=" + this.f98804h + ", indexRtcData=" + this.f98805i + ", indexLiveCoreData=" + this.f98806j + ", multiLinkAnchorLaunchContext=" + this.f98807k + ", pkAnchorLaunchContext=" + this.f98808l + ", hasStartRtc=" + this.f98809m + ", needJoinChannel=" + this.f98810n + ", isMergeSceneSwitchData=" + this.f98811o + ", resetPKDataContext=" + this.f98812p + ")";
    }

    public RevLinkAnchorLaunchParam(int r110, String r111, long r112, Function0 r113, Function0 r114, Map r115, Map r116, Map r117, Map r210, com.bytedance.android.live.revlink.impl.control.launchcontext.a r211, c r212, boolean r213, boolean r214, boolean r215, boolean r216) {
        Intrinsics.checkNotNullParameter(r111, "selfLinkerID");
        Intrinsics.checkNotNullParameter(r113, "containerWidth");
        Intrinsics.checkNotNullParameter(r114, "containerHeight");
        Intrinsics.checkNotNullParameter(r115, "rtcData");
        Intrinsics.checkNotNullParameter(r116, "liveCoreData");
        Intrinsics.checkNotNullParameter(r117, "indexRtcData");
        Intrinsics.checkNotNullParameter(r210, "indexLiveCoreData");
        this.f98797a = r110;
        this.f98798b = r111;
        this.f98799c = r112;
        this.f98800d = r113;
        this.f98801e = r114;
        this.f98802f = false;
        this.f98803g = r115;
        this.f98804h = r116;
        this.f98805i = r117;
        this.f98806j = r210;
        this.f98807k = r211;
        this.f98808l = r212;
        this.f98809m = r213;
        this.f98810n = r214;
        this.f98811o = r215;
        this.f98812p = r216;
    }
}
