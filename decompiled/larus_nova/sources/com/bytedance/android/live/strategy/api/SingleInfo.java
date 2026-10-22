package com.bytedance.android.live.strategy.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001'B[\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010%J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J]\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÖ\u0003R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b \u0010\u001bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b!\u0010\u001bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\"\u0010\u001bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b#\u0010\u001f¨\u0006("}, d2 = {"Lcom/bytedance/android/live/strategy/api/SingleInfo;", "Ljava/io/Serializable;", "", "component1", "component2", "", "component3", "component4", "component5", "component6", "component7", "chName", "chType", "chValue", "op", "faName", "faType", "faValue", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getChName", "()Ljava/lang/String;", "getChType", "Ljava/lang/Object;", "getChValue", "()Ljava/lang/Object;", "getOp", "getFaName", "getFaType", "getFaValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livestrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("ch_name")
    private final String chName;

    @SerializedName("ch_type")
    private final String chType;

    @SerializedName("ch_value")
    private final Object chValue;

    @SerializedName("fa_name")
    private final String faName;

    @SerializedName("fa_type")
    private final String faType;

    @SerializedName("fa_value")
    private final Object faValue;

    /* JADX INFO: renamed from: op, reason: collision with root package name */
    @SerializedName("op")
    private final String f101918op;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SingleInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ SingleInfo copy$default(SingleInfo r100, String r101, String r102, Object r103, String r104, String r110, String r111, Object r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.chName;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.chType;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.chValue;
    L11:
        Object r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.f101918op;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.faName;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.faType;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.faValue;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
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
        return this.f101918op;
    }

    public final String component5() {
        return this.faName;
    }

    public final String component6() {
        return this.faType;
    }

    public final Object component7() {
        return this.faValue;
    }

    public final SingleInfo copy(String r110, String r111, Object r112, String r113, String r114, String r115, Object r116) {
        return new SingleInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SingleInfo) == false) goto L20;
        SingleInfo r101 = (SingleInfo) r100;
        if (Intrinsics.areEqual(this.chName, r101.chName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.chType, r101.chType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.chValue, r101.chValue) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f101918op, r101.f101918op) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.faName, r101.faName) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.faType, r101.faType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.faValue, r101.faValue) == true) goto L31;
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
        String r110 = this.f101918op;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.faName;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.faType;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Object r119 = this.faValue;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
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
        return "SingleInfo(chName=" + this.chName + ", chType=" + this.chType + ", chValue=" + this.chValue + ", op=" + this.f101918op + ", faName=" + this.faName + ", faType=" + this.faType + ", faValue=" + this.faValue + ")";
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

    public final String getFaName() {
        return this.faName;
    }

    public final String getFaType() {
        return this.faType;
    }

    public final Object getFaValue() {
        return this.faValue;
    }

    public final String getOp() {
        return this.f101918op;
    }

    public SingleInfo(String r100, String r101, Object r102, String r103, String r104, String r105, Object r106) {
        this.chName = r100;
        this.chType = r101;
        this.chValue = r102;
        this.f101918op = r103;
        this.faName = r104;
        this.faType = r105;
        this.faValue = r106;
    }

    public /* synthetic */ SingleInfo(String r100, String r101, Object r102, String r110, String r111, String r112, Object r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = "";
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r114 & 4) == 0) goto L13;
        Object r104 = "";
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = "";
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = "";
    L27:
        if ((r114 & 64) == 0) goto L29;
        Object r117 = "";
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
