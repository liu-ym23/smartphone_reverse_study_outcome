package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/LogisticLineDTO;", "Ljava/io/Serializable;", "logisticItems", "", "Lcom/bytedance/android/ec/model/response/anchorv3/LogisticItemDTO;", "jumpUrl", "", "type", "", "(Ljava/util/List;Ljava/lang/String;J)V", "getJumpUrl", "()Ljava/lang/String;", "getLogisticItems", "()Ljava/util/List;", "getType", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class LogisticLineDTO implements Serializable {

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("logistic_items")
    private final List<LogisticItemDTO> logisticItems;

    @SerializedName("type")
    private final long type;

    public LogisticLineDTO() {
        this(null, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LogisticLineDTO copy$default(LogisticLineDTO r100, List r101, String r102, long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.logisticItems;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.jumpUrl;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.type;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<LogisticItemDTO> component1() {
        return this.logisticItems;
    }

    public final String component2() {
        return this.jumpUrl;
    }

    public final long component3() {
        return this.type;
    }

    public final LogisticLineDTO copy(List<LogisticItemDTO> r100, String r101, long r102) {
        return new LogisticLineDTO(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LogisticLineDTO) == false) goto L12;
        LogisticLineDTO r101 = (LogisticLineDTO) r100;
        if (Intrinsics.areEqual(this.logisticItems, r101.logisticItems) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L10;
        return false;
    L10:
        if (this.type == r101.type) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        List<LogisticItemDTO> r100 = this.logisticItems;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.jumpUrl;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.type;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LogisticLineDTO(logisticItems=" + this.logisticItems + ", jumpUrl=" + this.jumpUrl + ", type=" + this.type + ")";
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final List<LogisticItemDTO> getLogisticItems() {
        return this.logisticItems;
    }

    public final long getType() {
        return this.type;
    }

    public LogisticLineDTO(List<LogisticItemDTO> r100, String r101, long r102) {
        this.logisticItems = r100;
        this.jumpUrl = r101;
        this.type = r102;
    }

    public /* synthetic */ LogisticLineDTO(List r100, String r101, long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
