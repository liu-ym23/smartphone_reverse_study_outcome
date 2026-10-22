package com.bytedance.android.live.broadcastgame.api.openplatform;

import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Room f59407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f59409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f59410d;

    public e() {
        this(null, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f59407a, r101.f59407a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f59408b, r101.f59408b) == true) goto L10;
        return false;
    L10:
        if (this.f59409c == r101.f59409c) goto L12;
        return false;
    L12:
        if (this.f59410d == r101.f59410d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        Room r100 = this.f59407a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f59408b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f59409c;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.f59410d;
        if (r110 == true) goto L17;
        r107 = r110;
    L17:
        return r109 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LaunchLogParam(room=" + this.f59407a + ", launchFrom=" + this.f59408b + ", isRetry=" + this.f59409c + ", isAutoLaunch=" + this.f59410d + ")";
    }

    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        r100.put("is_retry", this.f59409c);
        Room r101 = this.f59407a;
        if (r101 == null) goto L5;
        LiveMode r102 = r101.getStreamType();
        int r103 = h1.f66189a;
        r100.put("live_type", i1.a(r102));
        r100.put("room_id", this.f59407a.getRoomId());
        r100.put("anchor_id", this.f59407a.getAnchorId());
    L5:
        r100.put("auto_launch", this.f59410d);
    }

    public e(Room r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "anchor";
    L8:
        Intrinsics.checkNotNullParameter(r101, "launchFrom");
        this.f59407a = r100;
        this.f59408b = r101;
        this.f59409c = false;
        this.f59410d = false;
    }
}
