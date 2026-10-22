package com.bytedance.android.live.saas.middleware.baselib;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/baselib/BaseLibConfig;", "", "ttExecutors", "Lcom/bytedance/android/live/saas/middleware/baselib/ITTExecutors;", "isToB", "", "(Lcom/bytedance/android/live/saas/middleware/baselib/ITTExecutors;Z)V", "()Z", "getTtExecutors", "()Lcom/bytedance/android/live/saas/middleware/baselib/ITTExecutors;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class BaseLibConfig {
    private final boolean isToB;
    private final ITTExecutors ttExecutors;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseLibConfig() {
        ITTExecutors r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BaseLibConfig copy$default(BaseLibConfig r100, ITTExecutors r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.ttExecutors;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isToB;
    L9:
        return r100.copy(r101, r102);
    }

    public final ITTExecutors component1() {
        return this.ttExecutors;
    }

    public final boolean component2() {
        return this.isToB;
    }

    public final BaseLibConfig copy(ITTExecutors r100, boolean r101) {
        return new BaseLibConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BaseLibConfig) == false) goto L10;
        BaseLibConfig r101 = (BaseLibConfig) r100;
        if (Intrinsics.areEqual(this.ttExecutors, r101.ttExecutors) == true) goto L8;
        return false;
    L8:
        if (this.isToB == r101.isToB) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        ITTExecutors r100 = this.ttExecutors;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.isToB;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "BaseLibConfig(ttExecutors=" + this.ttExecutors + ", isToB=" + this.isToB + ")";
    }

    public final ITTExecutors getTtExecutors() {
        return this.ttExecutors;
    }

    public final boolean isToB() {
        return this.isToB;
    }

    public BaseLibConfig(ITTExecutors r100, boolean r101) {
        this.ttExecutors = r100;
        this.isToB = r101;
    }

    public /* synthetic */ BaseLibConfig(ITTExecutors r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
