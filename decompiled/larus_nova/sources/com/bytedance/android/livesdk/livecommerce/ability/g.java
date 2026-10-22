package com.bytedance.android.livesdk.livecommerce.ability;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/ability/g;", "", "", "service", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "action", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "params", "b", "Lc93/b;", "scheduler", "Lc93/b;", "c", "()Lc93/b;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("action")
    private final String action;

    @SerializedName("params")
    private final String params;

    @SerializedName("scheduler")
    private final c93.b scheduler;

    @SerializedName("service")
    private final String service;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L14;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.service, r101.service) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scheduler, r101.scheduler) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.service;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.action;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.params;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        c93.b r110 = this.scheduler;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "LiveAtomicActionDsl(service=" + this.service + ", action=" + this.action + ", params=" + this.params + ", scheduler=" + this.scheduler + ")";
    }

    public final String a() {
        return this.action;
    }

    public final String b() {
        return this.params;
    }

    public final c93.b c() {
        return this.scheduler;
    }

    public final String d() {
        return this.service;
    }
}
