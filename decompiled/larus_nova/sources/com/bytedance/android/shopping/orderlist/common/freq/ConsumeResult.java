package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/ConsumeResult;", "Ljava/io/Serializable;", "selfShowId", "", "(Ljava/lang/String;)V", "getSelfShowId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConsumeResult implements Serializable {

    @SerializedName("self_show_id")
    private final String selfShowId;

    public static /* synthetic */ ConsumeResult copy$default(ConsumeResult r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.selfShowId;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.selfShowId;
    }

    public final ConsumeResult copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "selfShowId");
        return new ConsumeResult(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ConsumeResult) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.selfShowId, ((ConsumeResult) r100).selfShowId) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r100 = this.selfShowId;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "ConsumeResult(selfShowId=" + this.selfShowId + ")";
    }

    public final String getSelfShowId() {
        return this.selfShowId;
    }

    public ConsumeResult(String r100) {
        Intrinsics.checkNotNullParameter(r100, "selfShowId");
        this.selfShowId = r100;
    }
}
