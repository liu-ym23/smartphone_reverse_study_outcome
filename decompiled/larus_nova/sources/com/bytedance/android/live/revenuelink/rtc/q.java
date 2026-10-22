package com.bytedance.android.live.revenuelink.rtc;

import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.s1;
import com.bytedance.android.livesdk.link.model.bridge.t1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f91970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f91971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f91972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s1 f91973d;

    public q() {
        this(null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L14;
        q r101 = (q) r100;
        if (this.f91970a == r101.f91970a) goto L8;
        return false;
    L8:
        if (this.f91971b == r101.f91971b) goto L10;
        return false;
    L10:
        if (this.f91972c == r101.f91972c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f91973d, r101.f91973d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r100 = this.f91970a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f91971b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f91972c;
        if (r107 == true) goto L12;
        r101 = r107;
    L12:
        int r108 = (r106 + r101) * 31;
        s1 r109 = this.f91973d;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L17:
        return r108 + r110;
    L15:
        r110 = 0;
        goto L17
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("StartEngineParams{needPushStream=");
        r100.append(this.f91970a);
        r100.append(", enableAllRemoteRender=");
        r100.append(this.f91971b);
        r100.append(", startForwardStream=");
        r100.append(this.f91972c);
        r100.append(", ");
        s1 r101 = this.f91973d;
        if (r101 == null) goto L5;
        String r102 = t1.a(r101);
    L6:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public /* synthetic */ q(b7 r100, int r101) {
        boolean r102 = false;
        if ((r101 & 1) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r101 & 2) == 0) goto L9;
        boolean r104 = true;
    L11:
        if ((r101 & 4) == 0) goto L14;
        r102 = true;
    L14:
        if ((r101 & 8) == 0) goto L16;
        r100 = null;
    L16:
        this(r103, r104, r102, r100);
        return;
    L9:
        r104 = false;
        goto L11
    L5:
        r103 = false;
        goto L7
    }

    public q(boolean r100, boolean r101, boolean r102, s1 r103) {
        this.f91970a = r100;
        this.f91971b = r101;
        this.f91972c = r102;
        this.f91973d = r103;
    }
}
