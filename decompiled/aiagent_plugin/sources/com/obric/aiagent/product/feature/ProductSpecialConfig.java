package com.obric.aiagent.product.feature;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: FeatureConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ProductSpecialConfig implements Parcelable {
    public static final Parcelable.Creator<ProductSpecialConfig> CREATOR = null;

    @SerializedName("max_rom_release_date")
    private final long maxRomReleaseDate;

    @SerializedName("max_rom_version")
    private final String maxRomVersion;

    @SerializedName("min_rom_release_date")
    private final long minRomReleaseDate;

    @SerializedName("min_rom_version")
    private final String minRomVersion;

    @SerializedName("rom_version_black_list")
    private final List<String> romVersionBlackList;

    /* JADX INFO: compiled from: FeatureConfig.kt */
    public static final class Creator implements Parcelable.Creator<ProductSpecialConfig> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProductSpecialConfig createFromParcel(Parcel r9) {
            o.e(r9, "parcel");
            return new ProductSpecialConfig(r9.readString(), r9.readString(), (List) ZeusTransformUtils.preCheckCast(r9.createStringArrayList(), List.class, "com.obric.aiagent.plugin"), r9.readLong(), r9.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProductSpecialConfig createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProductSpecialConfig[] newArray(int r1) {
            return new ProductSpecialConfig[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProductSpecialConfig[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ProductSpecialConfig() {
        this(null, null, null, 0, 0, 31, null);
    }

    public static /* synthetic */ ProductSpecialConfig copy$default(ProductSpecialConfig r8, String r9, String r10, List r11, long r12, long r14, int r16, Object r17) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r16 & 1) == 0) goto L5;
        String r2 = r8.minRomVersion;
    L7:
        if ((r16 & 2) == 0) goto L9;
        String r3 = r8.maxRomVersion;
    L11:
        if ((r16 & 4) == 0) goto L14;
        r1 = r8.romVersionBlackList;
    L14:
        if ((r16 & 8) == 0) goto L16;
        long r4 = r8.minRomReleaseDate;
    L18:
        if ((r16 & 16) == 0) goto L20;
        long r6 = r8.maxRomReleaseDate;
    L22:
        return r8.copy(r2, r3, r1, r4, r6);
    L20:
        r6 = r14;
        goto L22
    L16:
        r4 = r12;
        goto L18
    L9:
        r3 = r10;
        goto L11
    L5:
        r2 = r9;
        goto L7
    }

    public final String component1() {
        return this.minRomVersion;
    }

    public final String component2() {
        return this.maxRomVersion;
    }

    public final List<String> component3() {
        return this.romVersionBlackList;
    }

    public final long component4() {
        return this.minRomReleaseDate;
    }

    public final long component5() {
        return this.maxRomReleaseDate;
    }

    public final ProductSpecialConfig copy(String r9, String r10, List<String> r11, long r12, long r14) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        o.e(r9, "minRomVersion");
        o.e(r10, "maxRomVersion");
        o.e(r3, "romVersionBlackList");
        return new ProductSpecialConfig(r9, r10, r3, r12, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProductSpecialConfig.class) == true) goto L8;
        return false;
    L8:
        ProductSpecialConfig r10 = (ProductSpecialConfig) ZeusTransformUtils.preCheckCast(r9, ProductSpecialConfig.class, "com.obric.aiagent.plugin");
        if (o.a(this.minRomVersion, r10.minRomVersion) == true) goto L12;
        return false;
    L12:
        if (o.a(this.maxRomVersion, r10.maxRomVersion) == true) goto L15;
        return false;
    L15:
        if (o.a(this.romVersionBlackList, r10.romVersionBlackList) == true) goto L18;
        return false;
    L18:
        if (this.minRomReleaseDate == r10.minRomReleaseDate) goto L21;
        return false;
    L21:
        if (this.maxRomReleaseDate == r10.maxRomReleaseDate) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.minRomVersion.hashCode() * 31) + this.maxRomVersion.hashCode()) * 31) + this.romVersionBlackList.hashCode()) * 31) + Long.hashCode(this.minRomReleaseDate)) * 31) + Long.hashCode(this.maxRomReleaseDate);
    }

    public String toString() {
        return "ProductSpecialConfig(minRomVersion=" + this.minRomVersion + ", maxRomVersion=" + this.maxRomVersion + ", romVersionBlackList=" + this.romVersionBlackList + ", minRomReleaseDate=" + this.minRomReleaseDate + ", maxRomReleaseDate=" + this.maxRomReleaseDate + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeString(this.minRomVersion);
        r3.writeString(this.maxRomVersion);
        r3.writeStringList(this.romVersionBlackList);
        r3.writeLong(this.minRomReleaseDate);
        r3.writeLong(this.maxRomReleaseDate);
    }

    public ProductSpecialConfig(String r3, String r4, List<String> r5, long r6, long r8) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "minRomVersion");
        o.e(r4, "maxRomVersion");
        o.e(r7, "romVersionBlackList");
        this.minRomVersion = r3;
        this.maxRomVersion = r4;
        this.romVersionBlackList = r7;
        this.minRomReleaseDate = r6;
        this.maxRomReleaseDate = r8;
    }

    public final String getMinRomVersion() {
        return this.minRomVersion;
    }

    public final String getMaxRomVersion() {
        return this.maxRomVersion;
    }

    public final List<String> getRomVersionBlackList() {
        return this.romVersionBlackList;
    }

    public /* synthetic */ ProductSpecialConfig(String r9, String r10, List r11, long r12, long r14, int r16, h r17) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        String r2 = "";
        if ((r16 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r16 & 2) != 0) goto L11;
        r2 = r10;
    L11:
        if ((r16 & 4) == 0) goto L13;
        r0 = p.b();
    L13:
        long r4 = 0;
        if ((r16 & 8) == 0) goto L16;
        long r6 = 0;
    L18:
        if ((r16 & 16) != 0) goto L21;
        r4 = r14;
    L21:
        this(r1, r2, r0, r6, r4);
        return;
    L16:
        r6 = r12;
        goto L18
    L5:
        r1 = r9;
        goto L7
    }

    public final long getMinRomReleaseDate() {
        return this.minRomReleaseDate;
    }

    public final long getMaxRomReleaseDate() {
        return this.maxRomReleaseDate;
    }
}
