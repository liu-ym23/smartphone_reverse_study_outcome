package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/u0;", "", "", "type", "I", "getType", "()I", "value", "getValue", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u0 {

    @SerializedName("type")
    private final int type;

    @SerializedName("value")
    private final int value;

    public u0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u0) == false) goto L10;
        u0 r101 = (u0) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (this.value == r101.value) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.type * 31) + this.value;
    }

    public final String toString() {
        return "DurationConfig(type=" + this.type + ", value=" + this.value + ")";
    }

    public final int getType() {
        return this.type;
    }

    public u0(int r100) {
        this.type = 0;
        this.value = 1;
    }
}
