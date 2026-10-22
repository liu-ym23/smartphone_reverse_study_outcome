package com.bytedance.android.live.network;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.annotation.PbRequest;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f83806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f83807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f83808c;

    public /* synthetic */ d() {
        this("", 1, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f83806a, r101.f83806a) == true) goto L8;
        return false;
    L8:
        if (this.f83807b == r101.f83807b) goto L10;
        return false;
    L10:
        if (this.f83808c == r101.f83808c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        String r100 = this.f83806a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((r101 * 31) + this.f83807b) * 31;
        boolean r103 = this.f83808c;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "PbAdapterConfig(pbRequestSwitches=" + this.f83806a + ", enterSwitches=" + this.f83807b + ", strategySwitch=" + this.f83808c + ")";
    }

    public final JSONObject a() {
        int r100 = this.f83807b;
        if (r100 != 1) goto L5;
        JSONObject r101 = new JSONObject(this.f83806a).put("room", false);
    L9:
        r101.put(PbRequest.SwitchType.RANK_LIST, false);
        r101.put(PbRequest.SwitchType.POPULAR, false);
        r101.put("report", false);
        r101.put(PbRequest.SwitchType.DYNAMIC_STRATEGY, this.f83808c);
        ALogger.i("PbAdapterConfig", "response-format proto override setting to closed cause aggressive fuse");
        return r101;
    L5:
        if (r100 == 2) goto L7;
        r101 = new JSONObject(this.f83806a);
        goto L9
    L7:
        r101 = new JSONObject(this.f83806a).put("room", true);
        goto L9
    }

    public d(String r100, int r101, boolean r102) {
        this.f83806a = r100;
        this.f83807b = r101;
        this.f83808c = r102;
    }
}
