package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/sku/ShowEventTrack;", "Ljava/io/Serializable;", "showServiceCode", "", "(Ljava/lang/String;)V", "getShowServiceCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ShowEventTrack implements Serializable {

    @SerializedName("show_service_code")
    private final String showServiceCode;

    /* JADX WARN: Multi-variable type inference failed */
    public ShowEventTrack() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ShowEventTrack copy$default(ShowEventTrack r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.showServiceCode;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.showServiceCode;
    }

    public final ShowEventTrack copy(String r100) {
        return new ShowEventTrack(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShowEventTrack) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.showServiceCode, ((ShowEventTrack) r100).showServiceCode) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r100 = this.showServiceCode;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "ShowEventTrack(showServiceCode=" + this.showServiceCode + ")";
    }

    public final String getShowServiceCode() {
        return this.showServiceCode;
    }

    public ShowEventTrack(String r100) {
        this.showServiceCode = r100;
    }

    public /* synthetic */ ShowEventTrack(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
