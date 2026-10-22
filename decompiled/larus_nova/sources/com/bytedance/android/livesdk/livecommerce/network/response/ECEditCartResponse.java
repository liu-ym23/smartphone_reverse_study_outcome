package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.g;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEditCartResponse;", "Lcom/bytedance/android/ec/model/g;", "Ljava/io/Serializable;", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEditCartData;", "component1", "editCartData", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEditCartData;", "getEditCartData", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEditCartData;", "<init>", "(Lcom/bytedance/android/livesdk/livecommerce/network/response/ECEditCartData;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECEditCartResponse extends g implements Serializable {

    @SerializedName("data")
    private final ECEditCartData editCartData;

    /* JADX WARN: Multi-variable type inference failed */
    public ECEditCartResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ECEditCartResponse copy$default(ECEditCartResponse r100, ECEditCartData r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.editCartData;
    L6:
        return r100.copy(r101);
    }

    public final ECEditCartData component1() {
        return this.editCartData;
    }

    public final ECEditCartResponse copy(ECEditCartData r100) {
        return new ECEditCartResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECEditCartResponse) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.editCartData, ((ECEditCartResponse) r100).editCartData) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        ECEditCartData r100 = this.editCartData;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "ECEditCartResponse(editCartData=" + this.editCartData + ")";
    }

    public final ECEditCartData getEditCartData() {
        return this.editCartData;
    }

    public ECEditCartResponse(ECEditCartData r100) {
        this.editCartData = r100;
    }

    public /* synthetic */ ECEditCartResponse(ECEditCartData r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
