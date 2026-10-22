package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: FeatureConfigBean.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FeatureConfigBean implements Parcelable {
    public static final Parcelable.Creator<FeatureConfigBean> CREATOR = null;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("max_rom_release_date")
    private final int maxRomReleaseDate;

    @SerializedName("max_rom_version")
    private final String maxRomVersion;

    @SerializedName("min_rom_release_date")
    private final int minRomReleaseDate;

    @SerializedName("min_rom_version")
    private final String minRomVersion;

    @SerializedName("product_name_list")
    private final String productNameList;

    /* JADX INFO: compiled from: FeatureConfigBean.kt */
    public static final class Creator implements Parcelable.Creator<FeatureConfigBean> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeatureConfigBean createFromParcel(Parcel r8) {
            o.e(r8, "parcel");
            if (r8.readInt() == 0) goto L5;
            boolean r0 = true;
        L7:
            return new FeatureConfigBean(r0, r8.readString(), r8.readInt(), r8.readString(), r8.readInt(), r8.readString());
        L5:
            r0 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FeatureConfigBean createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeatureConfigBean[] newArray(int r1) {
            return new FeatureConfigBean[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FeatureConfigBean[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public FeatureConfigBean() {
        this(false, null, 0, null, 0, null, 63, null);
    }

    public static /* synthetic */ FeatureConfigBean copy$default(FeatureConfigBean r4, boolean r5, String r6, int r7, String r8, int r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.enabled;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.minRomVersion;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.minRomReleaseDate;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.maxRomVersion;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.maxRomReleaseDate;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.productNameList;
    L20:
        boolean r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.minRomVersion;
    }

    public final int component3() {
        return this.minRomReleaseDate;
    }

    public final String component4() {
        return this.maxRomVersion;
    }

    public final int component5() {
        return this.maxRomReleaseDate;
    }

    public final String component6() {
        return this.productNameList;
    }

    public final FeatureConfigBean copy(boolean r8, String r9, int r10, String r11, int r12, String r13) {
        o.e(r9, "minRomVersion");
        o.e(r11, "maxRomVersion");
        o.e(r13, "productNameList");
        return new FeatureConfigBean(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FeatureConfigBean.class) == true) goto L8;
        return false;
    L8:
        FeatureConfigBean r6 = (FeatureConfigBean) ZeusTransformUtils.preCheckCast(r5, FeatureConfigBean.class, "com.obric.aiagent.plugin");
        if (this.enabled == r6.enabled) goto L12;
        return false;
    L12:
        if (o.a(this.minRomVersion, r6.minRomVersion) == true) goto L15;
        return false;
    L15:
        if (this.minRomReleaseDate == r6.minRomReleaseDate) goto L18;
        return false;
    L18:
        if (o.a(this.maxRomVersion, r6.maxRomVersion) == true) goto L21;
        return false;
    L21:
        if (this.maxRomReleaseDate == r6.maxRomReleaseDate) goto L24;
        return false;
    L24:
        if (o.a(this.productNameList, r6.productNameList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.enabled) * 31) + this.minRomVersion.hashCode()) * 31) + Integer.hashCode(this.minRomReleaseDate)) * 31) + this.maxRomVersion.hashCode()) * 31) + Integer.hashCode(this.maxRomReleaseDate)) * 31) + this.productNameList.hashCode();
    }

    public String toString() {
        return "FeatureConfigBean(enabled=" + this.enabled + ", minRomVersion=" + this.minRomVersion + ", minRomReleaseDate=" + this.minRomReleaseDate + ", maxRomVersion=" + this.maxRomVersion + ", maxRomReleaseDate=" + this.maxRomReleaseDate + ", productNameList=" + this.productNameList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeInt(this.enabled ? 1 : 0);
        r1.writeString(this.minRomVersion);
        r1.writeInt(this.minRomReleaseDate);
        r1.writeString(this.maxRomVersion);
        r1.writeInt(this.maxRomReleaseDate);
        r1.writeString(this.productNameList);
    }

    public FeatureConfigBean(boolean r2, String r3, int r4, String r5, int r6, String r7) {
        o.e(r3, "minRomVersion");
        o.e(r5, "maxRomVersion");
        o.e(r7, "productNameList");
        this.enabled = r2;
        this.minRomVersion = r3;
        this.minRomReleaseDate = r4;
        this.maxRomVersion = r5;
        this.maxRomReleaseDate = r6;
        this.productNameList = r7;
    }

    public /* synthetic */ FeatureConfigBean(boolean r5, String r6, int r7, String r8, int r9, String r10, int r11, h r12) {
        if ((r11 & 1) == 0) goto L5;
        r5 = true;
    L5:
        String r0 = "";
        if ((r11 & 2) == 0) goto L8;
        String r13 = "";
    L9:
        int r1 = 0;
        if ((r11 & 4) == 0) goto L12;
        int r2 = 0;
    L14:
        if ((r11 & 8) == 0) goto L16;
        String r3 = "";
    L18:
        if ((r11 & 16) != 0) goto L22;
        r1 = r9;
    L22:
        if ((r11 & 32) != 0) goto L25;
        r0 = r10;
    L25:
        this(r5, r13, r2, r3, r1, r0);
        return;
    L16:
        r3 = r8;
        goto L18
    L12:
        r2 = r7;
        goto L14
    L8:
        r13 = r6;
        goto L9
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getMinRomVersion() {
        return this.minRomVersion;
    }

    public final int getMinRomReleaseDate() {
        return this.minRomReleaseDate;
    }

    public final String getMaxRomVersion() {
        return this.maxRomVersion;
    }

    public final int getMaxRomReleaseDate() {
        return this.maxRomReleaseDate;
    }

    public final String getProductNameList() {
        return this.productNameList;
    }
}
