package com.obric.aiagent.product.feature;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.crypto.platform.PlatformConst;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ProductInfoConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ProductInfoConfig implements Parcelable {
    public static final Parcelable.Creator<ProductInfoConfig> CREATOR = null;

    @SerializedName(PlatformConst.PROP_BRAND)
    private final List<String> brand;

    @SerializedName("ro.product.device")
    private final List<String> device;

    @SerializedName(PlatformConst.PROP_MANUFACTURER)
    private final List<String> manufacturer;

    @SerializedName("ro.product.model")
    private final List<String> model;

    @SerializedName("ro.product.name")
    private final List<String> name;

    @SerializedName("policy")
    private final String policy;

    /* JADX INFO: compiled from: ProductInfoConfig.kt */
    public static final class Creator implements Parcelable.Creator<ProductInfoConfig> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProductInfoConfig createFromParcel(Parcel r8) {
            o.e(r8, "parcel");
            return new ProductInfoConfig((List) ZeusTransformUtils.preCheckCast(r8.createStringArrayList(), List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r8.createStringArrayList(), List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r8.createStringArrayList(), List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r8.createStringArrayList(), List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r8.createStringArrayList(), List.class, "com.obric.aiagent.plugin"), r8.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProductInfoConfig createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProductInfoConfig[] newArray(int r1) {
            return new ProductInfoConfig[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProductInfoConfig[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public ProductInfoConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ProductInfoConfig copy$default(ProductInfoConfig r7, List r8, List r9, List r10, List r11, List r12, String r13, int r14, Object r15) {
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List<String> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List<String> r18 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List<String> r19 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List<String> r110 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r16 = r7.manufacturer;
    L5:
        List<String> r1 = r16;
        if ((r14 & 2) == 0) goto L8;
        r17 = r7.brand;
    L8:
        List<String> r2 = r17;
        if ((r14 & 4) == 0) goto L11;
        r18 = r7.model;
    L11:
        List<String> r3 = r18;
        if ((r14 & 8) == 0) goto L14;
        r19 = r7.name;
    L14:
        List<String> r4 = r19;
        if ((r14 & 16) == 0) goto L17;
        r110 = r7.device;
    L17:
        List<String> r5 = r110;
        if ((r14 & 32) == 0) goto L21;
        r13 = r7.policy;
    L21:
        return r7.copy(r1, r2, r3, r4, r5, r13);
    }

    public final List<String> component1() {
        return this.manufacturer;
    }

    public final List<String> component2() {
        return this.brand;
    }

    public final List<String> component3() {
        return this.model;
    }

    public final List<String> component4() {
        return this.name;
    }

    public final List<String> component5() {
        return this.device;
    }

    public final String component6() {
        return this.policy;
    }

    public final ProductInfoConfig copy(List<String> r9, List<String> r10, List<String> r11, List<String> r12, List<String> r13, String r14) {
        return new ProductInfoConfig((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin"), r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ProductInfoConfig.class) == true) goto L8;
        return false;
    L8:
        ProductInfoConfig r6 = (ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5, ProductInfoConfig.class, "com.obric.aiagent.plugin");
        if (o.a(this.manufacturer, r6.manufacturer) == true) goto L12;
        return false;
    L12:
        if (o.a(this.brand, r6.brand) == true) goto L15;
        return false;
    L15:
        if (o.a(this.model, r6.model) == true) goto L18;
        return false;
    L18:
        if (o.a(this.name, r6.name) == true) goto L21;
        return false;
    L21:
        if (o.a(this.device, r6.device) == true) goto L24;
        return false;
    L24:
        if (o.a(this.policy, r6.policy) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.manufacturer;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.brand;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.model;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.name;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.device;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.policy;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ProductInfoConfig(manufacturer=" + this.manufacturer + ", brand=" + this.brand + ", model=" + this.model + ", name=" + this.name + ", device=" + this.device + ", policy=" + this.policy + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeStringList(this.manufacturer);
        r1.writeStringList(this.brand);
        r1.writeStringList(this.model);
        r1.writeStringList(this.name);
        r1.writeStringList(this.device);
        r1.writeString(this.policy);
    }

    public ProductInfoConfig(List<String> r3, List<String> r4, List<String> r5, List<String> r6, List<String> r7, String r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        this.manufacturer = r9;
        this.brand = r10;
        this.model = r11;
        this.name = r12;
        this.device = r13;
        this.policy = r8;
    }

    public final List<String> getManufacturer() {
        return this.manufacturer;
    }

    public /* synthetic */ ProductInfoConfig(List r8, List r9, List r10, List r11, List r12, String r13, int r14, h r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List r18 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List r19 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List r110 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r16 = p.b();
    L5:
        List r1 = r16;
        if ((r14 & 2) == 0) goto L8;
        r17 = p.b();
    L8:
        List r2 = r17;
        if ((r14 & 4) == 0) goto L11;
        r18 = p.b();
    L11:
        List r3 = r18;
        if ((r14 & 8) == 0) goto L14;
        r19 = p.b();
    L14:
        List r4 = r19;
        if ((r14 & 16) == 0) goto L17;
        r110 = p.b();
    L17:
        List r5 = r110;
        if ((r14 & 32) == 0) goto L20;
        r13 = "and";
    L20:
        this(r1, r2, r3, r4, r5, r13);
    }

    public final List<String> getBrand() {
        return this.brand;
    }

    public final List<String> getModel() {
        return this.model;
    }

    public final List<String> getName() {
        return this.name;
    }

    public final List<String> getDevice() {
        return this.device;
    }

    public final String getPolicy() {
        return this.policy;
    }
}
