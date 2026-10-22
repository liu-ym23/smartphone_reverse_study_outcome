package com.bytedance.android.live.saas.middleware.sec;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ry.e;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010#J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0011\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\r\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/sec/SecConfig;", "", "Lcom/bytedance/android/live/saas/middleware/sec/ISecSdk;", "component1", "", "component2", "component3", "", "component4", "Lry/e;", "component5", "impl", "standalone", "isToBVersion", "id", "hostPermission", "copy", "toString", "", "hashCode", "other", "equals", "Lcom/bytedance/android/live/saas/middleware/sec/ISecSdk;", "getImpl", "()Lcom/bytedance/android/live/saas/middleware/sec/ISecSdk;", "Z", "getStandalone", "()Z", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lry/e;", "getHostPermission", "()Lry/e;", "<init>", "(Lcom/bytedance/android/live/saas/middleware/sec/ISecSdk;ZZLjava/lang/String;Lry/e;)V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class SecConfig {
    private final e hostPermission;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f100466id;
    private final ISecSdk impl;
    private final boolean isToBVersion;
    private final boolean standalone;

    public SecConfig() {
        this(null, false, false, null, null, 31, null);
    }

    public static /* synthetic */ SecConfig copy$default(SecConfig r100, ISecSdk r101, boolean r102, boolean r103, String r104, e r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.impl;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.standalone;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.isToBVersion;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.f100466id;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.hostPermission;
    L17:
        ISecSdk r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final ISecSdk component1() {
        return this.impl;
    }

    public final boolean component2() {
        return this.standalone;
    }

    public final boolean component3() {
        return this.isToBVersion;
    }

    public final String component4() {
        return this.f100466id;
    }

    public final e component5() {
        return this.hostPermission;
    }

    public final SecConfig copy(ISecSdk r100, boolean r101, boolean r110, String r111, e r112) {
        Intrinsics.checkNotNullParameter(r111, "id");
        return new SecConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SecConfig) == false) goto L16;
        SecConfig r101 = (SecConfig) r100;
        if (Intrinsics.areEqual(this.impl, r101.impl) == true) goto L8;
        return false;
    L8:
        if (this.standalone == r101.standalone) goto L10;
        return false;
    L10:
        if (this.isToBVersion == r101.isToBVersion) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f100466id, r101.f100466id) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.hostPermission, r101.hostPermission) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        ISecSdk r100 = this.impl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.standalone;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.isToBVersion;
        if (r108 == true) goto L13;
        r105 = r108;
    L13:
        int r109 = (r107 + r105) * 31;
        String r110 = this.f100466id;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        e r113 = this.hostPermission;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L16:
        r111 = 0;
        goto L17
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SecConfig(impl=" + this.impl + ", standalone=" + this.standalone + ", isToBVersion=" + this.isToBVersion + ", id=" + this.f100466id + ", hostPermission=" + this.hostPermission + ")";
    }

    public final e getHostPermission() {
        return this.hostPermission;
    }

    public final String getId() {
        return this.f100466id;
    }

    public final ISecSdk getImpl() {
        return this.impl;
    }

    public final boolean getStandalone() {
        return this.standalone;
    }

    public final boolean isToBVersion() {
        return this.isToBVersion;
    }

    public SecConfig(ISecSdk r100, boolean r101, boolean r102, String r103, e r104) {
        Intrinsics.checkNotNullParameter(r103, "id");
        this.impl = r100;
        this.standalone = r101;
        this.isToBVersion = r102;
        this.f100466id = r103;
        this.hostPermission = r104;
    }

    public /* synthetic */ SecConfig(ISecSdk r100, boolean r101, boolean r102, String r103, e r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        ISecSdk r112 = null;
    L6:
        boolean r105 = false;
        if ((r110 & 2) == 0) goto L9;
        boolean r106 = false;
    L11:
        if ((r110 & 4) != 0) goto L15;
        r105 = r102;
    L15:
        if ((r110 & 8) == 0) goto L17;
        r103 = "";
    L17:
        String r107 = r103;
        if ((r110 & 16) == 0) goto L20;
        e r113 = null;
    L21:
        this(r112, r106, r105, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L9:
        r106 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L6
    }
}
