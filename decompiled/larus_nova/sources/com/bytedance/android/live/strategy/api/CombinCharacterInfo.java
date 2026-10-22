package com.bytedance.android.live.strategy.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001-BY\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b*\u0010+J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJb\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0018\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÖ\u0003R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b#\u0010\u001eR\u001a\u0010\u0012\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b'\u0010\u001eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\r¨\u0006."}, d2 = {"Lcom/bytedance/android/live/strategy/api/CombinCharacterInfo;", "Ljava/io/Serializable;", "", "component1", "component2", "", "component3", "component4", "", "component5", "component6", "", "component7", "()Ljava/lang/Integer;", "chName", "chType", "chValue", "op", "checkInterval", "alias", "dataType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/live/strategy/api/CombinCharacterInfo;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getChName", "()Ljava/lang/String;", "getChType", "Ljava/lang/Object;", "getChValue", "()Ljava/lang/Object;", "getOp", "J", "getCheckInterval", "()J", "getAlias", "Ljava/lang/Integer;", "getDataType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livestrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CombinCharacterInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("alias")
    private final String alias;

    @SerializedName("ch_name")
    private final String chName;

    @SerializedName("ch_type")
    private final String chType;

    @SerializedName("ch_value")
    private final Object chValue;

    @SerializedName("check_interval")
    private final long checkInterval;

    @SerializedName("data_type")
    private final Integer dataType;

    /* JADX INFO: renamed from: op, reason: collision with root package name */
    @SerializedName("op")
    private final String f101917op;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CombinCharacterInfo() {
        this(null, null, null, null, 0, null, null, 127, null);
    }

    public static /* synthetic */ CombinCharacterInfo copy$default(CombinCharacterInfo r100, String r110, String r111, Object r112, String r113, long r114, String r115, Integer r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        String r101 = r100.chName;
    L7:
        if ((r117 & 2) == 0) goto L9;
        String r102 = r100.chType;
    L11:
        if ((r117 & 4) == 0) goto L13;
        Object r103 = r100.chValue;
    L15:
        if ((r117 & 8) == 0) goto L17;
        String r104 = r100.f101917op;
    L19:
        if ((r117 & 16) == 0) goto L21;
        long r105 = r100.checkInterval;
    L23:
        if ((r117 & 32) == 0) goto L25;
        String r106 = r100.alias;
    L27:
        if ((r117 & 64) == 0) goto L29;
        Integer r107 = r100.dataType;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.chName;
    }

    public final String component2() {
        return this.chType;
    }

    public final Object component3() {
        return this.chValue;
    }

    public final String component4() {
        return this.f101917op;
    }

    public final long component5() {
        return this.checkInterval;
    }

    public final String component6() {
        return this.alias;
    }

    public final Integer component7() {
        return this.dataType;
    }

    public final CombinCharacterInfo copy(String r110, String r111, Object r112, String r113, long r114, String r115, Integer r116) {
        return new CombinCharacterInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CombinCharacterInfo) == false) goto L20;
        CombinCharacterInfo r101 = (CombinCharacterInfo) r100;
        if (Intrinsics.areEqual(this.chName, r101.chName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.chType, r101.chType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.chValue, r101.chValue) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f101917op, r101.f101917op) == true) goto L14;
        return false;
    L14:
        if (this.checkInterval == r101.checkInterval) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.alias, r101.alias) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dataType, r101.dataType) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.chName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.chType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.chValue;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f101917op;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.checkInterval;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        String r115 = this.alias;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        Integer r118 = this.dataType;
        if (r118 == null) goto L26;
        r101 = r118.hashCode();
    L26:
        return r117 + r101;
    L21:
        r116 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CombinCharacterInfo(chName=" + this.chName + ", chType=" + this.chType + ", chValue=" + this.chValue + ", op=" + this.f101917op + ", checkInterval=" + this.checkInterval + ", alias=" + this.alias + ", dataType=" + this.dataType + ")";
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getChName() {
        return this.chName;
    }

    public final String getChType() {
        return this.chType;
    }

    public final Object getChValue() {
        return this.chValue;
    }

    public final long getCheckInterval() {
        return this.checkInterval;
    }

    public final Integer getDataType() {
        return this.dataType;
    }

    public final String getOp() {
        return this.f101917op;
    }

    public CombinCharacterInfo(String r100, String r101, Object r102, String r103, long r104, String r105, Integer r106) {
        this.chName = r100;
        this.chType = r101;
        this.chValue = r102;
        this.f101917op = r103;
        this.checkInterval = r104;
        this.alias = r105;
        this.dataType = r106;
    }

    public /* synthetic */ CombinCharacterInfo(String r100, String r110, Object r111, String r112, long r113, String r114, Integer r115, int r116, DefaultConstructorMarker r117) {
        String r101 = "";
        if ((r116 & 1) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r116 & 4) == 0) goto L13;
        Object r104 = null;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r116 & 16) == 0) goto L21;
        long r106 = 0;
    L23:
        if ((r116 & 32) != 0) goto L27;
        r101 = r114;
    L27:
        if ((r116 & 64) == 0) goto L29;
        Integer r107 = 0;
    L30:
        this(r102, r103, r104, r105, r106, r101, r107);
        return;
    L29:
        r107 = r115;
        goto L30
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
