package com.bytedance.android.ec.store.common.floatelement;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/store/common/floatelement/StoreCartEntryConfig;", "Ljava/io/Serializable;", "jumpUrl", "", "(Ljava/lang/String;)V", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreCartEntryConfig implements Serializable {

    @SerializedName("jump_url")
    private String jumpUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public StoreCartEntryConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ StoreCartEntryConfig copy$default(StoreCartEntryConfig r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.jumpUrl;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.jumpUrl;
    }

    public final StoreCartEntryConfig copy(String r100) {
        return new StoreCartEntryConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof StoreCartEntryConfig) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.jumpUrl, ((StoreCartEntryConfig) r100).jumpUrl) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r100 = this.jumpUrl;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "StoreCartEntryConfig(jumpUrl=" + this.jumpUrl + ")";
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public StoreCartEntryConfig(String r100) {
        this.jumpUrl = r100;
    }

    public final void setJumpUrl(String r100) {
        this.jumpUrl = r100;
    }

    public /* synthetic */ StoreCartEntryConfig(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
