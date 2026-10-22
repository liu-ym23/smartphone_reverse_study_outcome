package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JV\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantModel;", "Ljava/io/Serializable;", "pendantType", "", "id", "", "config", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;", "slice", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "native", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantNative;", "lynx", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantLynx;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantNative;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantLynx;)V", "getConfig", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;", "getId", "()Ljava/lang/String;", "getLynx", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantLynx;", "getNative", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantNative;", "getPendantType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSlice", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ConfigMode;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantNative;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantLynx;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantModel;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderPendantModel implements Serializable {

    @SerializedName("config")
    private final ConfigMode config;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f169030id;

    @SerializedName("lynx")
    private final HeaderPendantLynx lynx;

    /* JADX INFO: renamed from: native, reason: not valid java name */
    @SerializedName("native")
    private final HeaderPendantNative f94native;

    @SerializedName("pendant_type")
    private final Integer pendantType;

    @SerializedName("slice")
    private final HeaderSliceModel slice;

    public HeaderPendantModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ HeaderPendantModel copy$default(HeaderPendantModel r100, Integer r101, String r102, ConfigMode r103, HeaderSliceModel r104, HeaderPendantNative r105, HeaderPendantLynx r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.pendantType;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f169030id;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.config;
    L11:
        ConfigMode r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.slice;
    L14:
        HeaderSliceModel r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.f94native;
    L17:
        HeaderPendantNative r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.lynx;
    L20:
        Integer r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Integer component1() {
        return this.pendantType;
    }

    public final String component2() {
        return this.f169030id;
    }

    public final ConfigMode component3() {
        return this.config;
    }

    public final HeaderSliceModel component4() {
        return this.slice;
    }

    public final HeaderPendantNative component5() {
        return this.f94native;
    }

    public final HeaderPendantLynx component6() {
        return this.lynx;
    }

    public final HeaderPendantModel copy(Integer r100, String r110, ConfigMode r111, HeaderSliceModel r112, HeaderPendantNative r113, HeaderPendantLynx r114) {
        return new HeaderPendantModel(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HeaderPendantModel) == false) goto L18;
        HeaderPendantModel r101 = (HeaderPendantModel) r100;
        if (Intrinsics.areEqual(this.pendantType, r101.pendantType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f169030id, r101.f169030id) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.slice, r101.slice) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f94native, r101.f94native) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.lynx, r101.lynx) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.pendantType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f169030id;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ConfigMode r107 = this.config;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        HeaderSliceModel r110 = this.slice;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        HeaderPendantNative r113 = this.f94native;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        HeaderPendantLynx r116 = this.lynx;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "HeaderPendantModel(pendantType=" + this.pendantType + ", id=" + this.f169030id + ", config=" + this.config + ", slice=" + this.slice + ", native=" + this.f94native + ", lynx=" + this.lynx + ")";
    }

    public final ConfigMode getConfig() {
        return this.config;
    }

    public final String getId() {
        return this.f169030id;
    }

    public final HeaderPendantLynx getLynx() {
        return this.lynx;
    }

    public final HeaderPendantNative getNative() {
        return this.f94native;
    }

    public final Integer getPendantType() {
        return this.pendantType;
    }

    public final HeaderSliceModel getSlice() {
        return this.slice;
    }

    public HeaderPendantModel(Integer r100, String r101, ConfigMode r102, HeaderSliceModel r103, HeaderPendantNative r104, HeaderPendantLynx r105) {
        this.pendantType = r100;
        this.f169030id = r101;
        this.config = r102;
        this.slice = r103;
        this.f94native = r104;
        this.lynx = r105;
    }

    public /* synthetic */ HeaderPendantModel(Integer r100, String r101, ConfigMode r102, HeaderSliceModel r103, HeaderPendantNative r110, HeaderPendantLynx r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Integer r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        ConfigMode r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        HeaderSliceModel r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        HeaderPendantNative r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        HeaderPendantLynx r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
