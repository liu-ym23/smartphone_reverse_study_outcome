package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J-\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u000fJ\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/model/response/LottieIconData;", "Ljava/io/Serializable;", "lottieData", "", "lottieIconParams", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getLottieData", "()Ljava/lang/String;", "getLottieIconParams", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "isValid", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class LottieIconData implements Serializable {

    @SerializedName("lottie_data")
    private final String lottieData;

    @SerializedName("lottie_icon_params")
    private final Map<String, String> lottieIconParams;

    /* JADX WARN: Multi-variable type inference failed */
    public LottieIconData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LottieIconData copy$default(LottieIconData r100, String r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.lottieData;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.lottieIconParams;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.lottieData;
    }

    public final Map<String, String> component2() {
        return this.lottieIconParams;
    }

    public final LottieIconData copy(String r100, Map<String, String> r101) {
        return new LottieIconData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LottieIconData) == false) goto L10;
        LottieIconData r101 = (LottieIconData) r100;
        if (Intrinsics.areEqual(this.lottieData, r101.lottieData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lottieIconParams, r101.lottieIconParams) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.lottieData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.lottieIconParams;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LottieIconData(lottieData=" + this.lottieData + ", lottieIconParams=" + this.lottieIconParams + ")";
    }

    public final boolean isValid() {
        return com.bytedance.android.shopping.anchorv3.a.b(this.lottieData);
    }

    public final String getLottieData() {
        return this.lottieData;
    }

    public final Map<String, String> getLottieIconParams() {
        return this.lottieIconParams;
    }

    public LottieIconData(String r100, Map<String, String> r101) {
        this.lottieData = r100;
        this.lottieIconParams = r101;
    }

    public /* synthetic */ LottieIconData(String r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
