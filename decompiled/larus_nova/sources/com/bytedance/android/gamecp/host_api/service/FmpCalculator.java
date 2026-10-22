package com.bytedance.android.gamecp.host_api.service;

import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class FmpCalculator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f57412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f57413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f57414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Window f57415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FmpCallback f57416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f57417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f57418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f57419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f57420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f57421j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f57422k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f57423l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f57424m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f57425n;

    public interface FmpCallback {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/service/FmpCalculator$FmpCallback$Type;", "", "Normal", "Touch", "Timeout", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum Type extends Enum<Type> {
            public static final Type Normal = null;
            public static final Type Timeout = null;
            public static final Type Touch = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Type[] f57426a = null;

            static {
                Type r100 = new Type("Normal", 0);
                Normal = r100;
                Type r101 = new Type("Touch", 1);
                Touch = r101;
                Type r102 = new Type("Timeout", 2);
                Timeout = r102;
                f57426a = new Type[]{r100, r101, r102};
            }

            public static Type valueOf(String r100) {
                return (Type) r27.a.a(Type.class, r100);
            }

            public static Type[] values() {
                return (Type[]) f57426a.clone();
            }

            public Type(String r100, int r101) {
                super(r100, r101);
            }
        }
    }

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FmpCalculator) == false) goto L34;
        FmpCalculator r101 = (FmpCalculator) r100;
        if (Intrinsics.areEqual(this.f57412a, r101.f57412a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f57413b, r101.f57413b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f57414c, r101.f57414c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f57415d, r101.f57415d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f57416e, r101.f57416e) == true) goto L16;
        return false;
    L16:
        if (this.f57417f == r101.f57417f) goto L18;
        return false;
    L18:
        if (this.f57418g == r101.f57418g) goto L20;
        return false;
    L20:
        if (Float.compare(this.f57419h, r101.f57419h) == 0) goto L22;
        return false;
    L22:
        if (this.f57420i == r101.f57420i) goto L24;
        return false;
    L24:
        if (this.f57421j == r101.f57421j) goto L26;
        return false;
    L26:
        if (this.f57422k == r101.f57422k) goto L28;
        return false;
    L28:
        if (this.f57423l == r101.f57423l) goto L30;
        return false;
    L30:
        if (this.f57424m == r101.f57424m) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f57425n, r101.f57425n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final int hashCode() {
        String r100 = this.f57412a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f57413b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        View r107 = this.f57414c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Window r110 = this.f57415d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        FmpCallback r113 = this.f57416e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        long r116 = this.f57417f;
        int r117 = (((((r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31) + this.f57418g) * 31) + Float.floatToIntBits(this.f57419h)) * 31;
        long r118 = this.f57420i;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        boolean r120 = this.f57421j;
        ?? r121 = 1;
        ?? r122 = r120;
        if (r120 == false) goto L25;
        r122 = 1;
    L25:
        int r123 = (((r119 + r122) * 31) + this.f57422k) * 31;
        boolean r124 = this.f57423l;
        ?? r125 = r124;
        if (r124 == false) goto L28;
        r125 = 1;
    L28:
        int r126 = (r123 + r125) * 31;
        boolean r127 = this.f57424m;
        if (r127 == true) goto L32;
        r121 = r127;
    L32:
        int r128 = (r126 + r121) * 31;
        Object r129 = this.f57425n;
        if (r129 == null) goto L36;
        r101 = r129.hashCode();
    L36:
        return r128 + r101;
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
        return "FmpCalculator(trackId=" + this.f57412a + ", page=" + this.f57413b + ", view=" + this.f57414c + ", window=" + this.f57415d + ", fmpCallBack=" + this.f57416e + ", fmpStartTime=" + this.f57417f + ", minStableChange=" + this.f57418g + ", minStableChangeRate=" + this.f57419h + ", fmpTimeOutDuration=" + this.f57420i + ", enableIgnoreLynxBackground=" + this.f57421j + ", waitFmpCompleteThresholdTime=" + this.f57422k + ", isCheckFrescoImageLoad=" + this.f57423l + ", isLynxBaseUIView=" + this.f57424m + ", lynxBaseUITag=" + this.f57425n + ")";
    }

    public FmpCalculator(String r110, String r111, View r210, Window r211, FmpCallback r212, long r213, boolean r214, boolean r215, Object r216, int r217) {
        if ((r217 & 32) == 0) goto L5;
        long r100 = SystemClock.elapsedRealtime();
    L7:
        if ((r217 & 64) == 0) goto L9;
        int r101 = 50;
    L11:
        if ((r217 & 128) == 0) goto L13;
        float r112 = 2.0f;
    L15:
        if ((r217 & 256) == 0) goto L17;
        long r113 = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
    L19:
        if ((r217 & 512) == 0) goto L21;
        boolean r114 = true;
    L23:
        if ((r217 & 1024) == 0) goto L25;
        int r115 = 800;
    L27:
        if ((r217 & 2048) == 0) goto L29;
        boolean r116 = false;
    L31:
        if ((r217 & 4096) == 0) goto L33;
        boolean r102 = false;
    L35:
        if ((r217 & 8192) == 0) goto L37;
        Object r117 = null;
    L38:
        Intrinsics.checkNotNullParameter(r110, "trackId");
        Intrinsics.checkNotNullParameter(r111, "page");
        Intrinsics.checkNotNullParameter(r210, "view");
        Intrinsics.checkNotNullParameter(r211, LiveEndPageData.TAG_WINDOW);
        this.f57412a = r110;
        this.f57413b = r111;
        this.f57414c = r210;
        this.f57415d = r211;
        this.f57416e = r212;
        this.f57417f = r100;
        this.f57418g = r101;
        this.f57419h = r112;
        this.f57420i = r113;
        this.f57421j = r114;
        this.f57422k = r115;
        this.f57423l = r116;
        this.f57424m = r102;
        this.f57425n = r117;
        return;
    L37:
        r117 = r216;
        goto L38
    L33:
        r102 = r215;
        goto L35
    L29:
        r116 = r214;
        goto L31
    L25:
        r115 = 0;
        goto L27
    L21:
        r114 = false;
        goto L23
    L17:
        r113 = r213;
        goto L19
    L13:
        r112 = 0.0f;
        goto L15
    L9:
        r101 = 0;
        goto L11
    L5:
        r100 = 0;
        goto L7
    }
}
