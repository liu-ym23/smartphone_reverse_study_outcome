package com.bytedance.android.shopping.anchorv4.dto.business;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/e;", "", "", EffectConfiguration.KEY_CURSOR, "Ljava/lang/Long;", "getCursor", "()Ljava/lang/Long;", "count", "getCount", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("count")
    private final Long count;

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private final Long cursor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.cursor, r101.cursor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.count, r101.count) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.cursor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.count;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Page(cursor=" + this.cursor + ", count=" + this.count + ")";
    }

    public e() {
        this.cursor = null;
        this.count = null;
    }
}
