package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinExtraData;", "", "isDarkMode", "", "(Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/bytedance/android/shopping/api/mall/model/SkinExtraData;", "equals", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkinExtraData {

    @SerializedName("is_dark_mode")
    private final Boolean isDarkMode;

    /* JADX WARN: Multi-variable type inference failed */
    public SkinExtraData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SkinExtraData copy$default(SkinExtraData r100, Boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.isDarkMode;
    L6:
        return r100.copy(r101);
    }

    public final Boolean component1() {
        return this.isDarkMode;
    }

    public final SkinExtraData copy(Boolean r100) {
        return new SkinExtraData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkinExtraData) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.isDarkMode, ((SkinExtraData) r100).isDarkMode) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.isDarkMode;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "SkinExtraData(isDarkMode=" + this.isDarkMode + ")";
    }

    public final Boolean isDarkMode() {
        return this.isDarkMode;
    }

    public SkinExtraData(Boolean r100) {
        this.isDarkMode = r100;
    }

    public /* synthetic */ SkinExtraData(Boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
