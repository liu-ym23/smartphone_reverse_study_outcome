package com.bytedance.android.shopping.anchorv4.dto.business;

import com.bytedance.android.shopping.anchorv4.dto.ConfigModel;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/VO;", "Ljava/io/Serializable;", "display", "Lcom/google/gson/JsonObject;", "meta", "displayMd5", "", "config", "Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;", "(Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;)V", "getConfig", "()Lcom/bytedance/android/shopping/anchorv4/dto/ConfigModel;", "getDisplay", "()Lcom/google/gson/JsonObject;", "getDisplayMd5", "()Ljava/lang/String;", "getMeta", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VO implements Serializable {

    @SerializedName("config")
    private final ConfigModel config;

    @SerializedName("display")
    private final JsonObject display;

    @SerializedName("display_md5")
    private final String displayMd5;

    @SerializedName("meta")
    private final JsonObject meta;

    public VO() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ VO copy$default(VO r100, JsonObject r101, JsonObject r102, String r103, ConfigModel r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.display;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.meta;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.displayMd5;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.config;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final JsonObject component1() {
        return this.display;
    }

    public final JsonObject component2() {
        return this.meta;
    }

    public final String component3() {
        return this.displayMd5;
    }

    public final ConfigModel component4() {
        return this.config;
    }

    public final VO copy(JsonObject r100, JsonObject r101, String r102, ConfigModel r103) {
        return new VO(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof VO) == false) goto L14;
        VO r101 = (VO) r100;
        if (Intrinsics.areEqual(this.display, r101.display) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.meta, r101.meta) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.displayMd5, r101.displayMd5) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        JsonObject r100 = this.display;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JsonObject r104 = this.meta;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.displayMd5;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ConfigModel r110 = this.config;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "VO(display=" + this.display + ", meta=" + this.meta + ", displayMd5=" + this.displayMd5 + ", config=" + this.config + ")";
    }

    public final ConfigModel getConfig() {
        return this.config;
    }

    public final JsonObject getDisplay() {
        return this.display;
    }

    public final String getDisplayMd5() {
        return this.displayMd5;
    }

    public final JsonObject getMeta() {
        return this.meta;
    }

    public VO(JsonObject r100, JsonObject r101, String r102, ConfigModel r103) {
        this.display = r100;
        this.meta = r101;
        this.displayMd5 = r102;
        this.config = r103;
    }

    public /* synthetic */ VO(JsonObject r100, JsonObject r101, String r102, ConfigModel r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
