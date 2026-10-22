package com.bytedance.android.live.strategy.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0002HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÖ\u0003R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/strategy/api/CombbineFactorInfo;", "Ljava/io/Serializable;", "", "component1", "component2", "", "component3", "faName", "faType", "faValue", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getFaName", "()Ljava/lang/String;", "getFaType", "Ljava/lang/Object;", "getFaValue", "()Ljava/lang/Object;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livestrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CombbineFactorInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("fa_name")
    private final String faName;

    @SerializedName("fa_type")
    private final String faType;

    @SerializedName("fa_value")
    private final Object faValue;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CombbineFactorInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CombbineFactorInfo copy$default(CombbineFactorInfo r100, String r101, String r102, Object r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.faName;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.faType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.faValue;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.faName;
    }

    public final String component2() {
        return this.faType;
    }

    public final Object component3() {
        return this.faValue;
    }

    public final CombbineFactorInfo copy(String r100, String r101, Object r102) {
        return new CombbineFactorInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CombbineFactorInfo) == false) goto L12;
        CombbineFactorInfo r101 = (CombbineFactorInfo) r100;
        if (Intrinsics.areEqual(this.faName, r101.faName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.faType, r101.faType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.faValue, r101.faValue) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.faName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.faType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.faValue;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CombbineFactorInfo(faName=" + this.faName + ", faType=" + this.faType + ", faValue=" + this.faValue + ")";
    }

    public final String getFaName() {
        return this.faName;
    }

    public final String getFaType() {
        return this.faType;
    }

    public final Object getFaValue() {
        return this.faValue;
    }

    public CombbineFactorInfo(String r100, String r101, Object r102) {
        this.faName = r100;
        this.faType = r101;
        this.faValue = r102;
    }

    public /* synthetic */ CombbineFactorInfo(String r100, String r101, Object r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
