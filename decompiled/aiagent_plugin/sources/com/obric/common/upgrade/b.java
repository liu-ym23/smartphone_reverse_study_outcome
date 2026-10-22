package com.obric.common.upgrade;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppUpgradeResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("is_system_halt")
    private final boolean f32597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("is_system_reboot")
    private final boolean f32598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("is_system_component")
    private final boolean f32599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("is_black_list")
    private final boolean f32600d;

    public b() {
        this(false, false, false, false, 15, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f32597a == r6.f32597a) goto L12;
        return false;
    L12:
        if (this.f32598b == r6.f32598b) goto L15;
        return false;
    L15:
        if (this.f32599c == r6.f32599c) goto L18;
        return false;
    L18:
        if (this.f32600d == r6.f32600d) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public int hashCode() {
        boolean r0 = this.f32597a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.f32598b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.f32599c;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.f32600d;
        if (r10 == true) goto L16;
        r1 = r10;
    L16:
        return r9 + r1;
    }

    public String toString() {
        return "AppTag(isSystemHalt=" + this.f32597a + ", isSystemReboot=" + this.f32598b + ", isSystemComponent=" + this.f32599c + ", isBlackList=" + this.f32600d + ')';
    }

    public b(boolean r1, boolean r2, boolean r3, boolean r4) {
        this.f32597a = r1;
        this.f32598b = r2;
        this.f32599c = r3;
        this.f32600d = r4;
    }

    public /* synthetic */ b(boolean r2, boolean r3, boolean r4, boolean r5, int r6, d.h.b.h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }
}
