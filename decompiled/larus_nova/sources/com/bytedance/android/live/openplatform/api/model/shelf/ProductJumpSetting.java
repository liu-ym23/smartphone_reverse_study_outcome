package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.JumpSetting")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductJumpSetting;", "Landroid/os/Parcelable;", "", "isJumpToOtherPage", "Z", "", "jumpToOtherPageAppId", "Ljava/lang/String;", "jumpToOtherPagePath", "", "jumpToOtherPageQuery", "Ljava/util/Map;", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductJumpSetting implements Parcelable, h {
    public static final Parcelable.Creator<ProductJumpSetting> CREATOR = null;

    @SerializedName("is_jump_other_page")
    public boolean isJumpToOtherPage;

    @SerializedName("jump_other_appid")
    public String jumpToOtherPageAppId;

    @SerializedName("jump_other_page")
    public String jumpToOtherPagePath;

    @SerializedName("jump_other_query")
    public Map<String, String> jumpToOtherPageQuery;

    public static class a implements Parcelable.Creator<ProductJumpSetting> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProductJumpSetting createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L6:
            String r102 = r100.readString();
            String r103 = r100.readString();
            if (r100.readInt() == 0) goto L11;
            int r104 = r100.readInt();
            LinkedHashMap r105 = new LinkedHashMap(r104);
        L9:
            if (r104 == 0) goto L13;
            r105.put(r100.readString(), r100.readString());
            r104 = r104 - 1;
        L13:
            return new ProductJumpSetting(r101, r102, r103, r105);
        L11:
            r105 = null;
            goto L13
        L5:
            r101 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ProductJumpSetting[] newArray(int r100) {
            return new ProductJumpSetting[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ProductJumpSetting(boolean r100, String r101, String r102, Map<String, String> r103) {
        this.isJumpToOtherPage = r100;
        this.jumpToOtherPageAppId = r101;
        this.jumpToOtherPagePath = r102;
        this.jumpToOtherPageQuery = r103;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ProductJumpSetting) == false) goto L14;
        ProductJumpSetting r101 = (ProductJumpSetting) r100;
        if (this.isJumpToOtherPage == r101.isJumpToOtherPage) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.jumpToOtherPageAppId, r101.jumpToOtherPageAppId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpToOtherPagePath, r101.jumpToOtherPagePath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpToOtherPageQuery, r101.jumpToOtherPageQuery) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.isJumpToOtherPage;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.jumpToOtherPageAppId;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.jumpToOtherPagePath;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.jumpToOtherPageQuery;
        if (r110 == null) goto L17;
        r104 = r110.hashCode();
    L17:
        return r109 + r104;
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "ProductJumpSetting(isJumpToOtherPage=" + this.isJumpToOtherPage + ", jumpToOtherPageAppId=" + this.jumpToOtherPageAppId + ", jumpToOtherPagePath=" + this.jumpToOtherPagePath + ", jumpToOtherPageQuery=" + this.jumpToOtherPageQuery + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.isJumpToOtherPage ? 1 : 0);
        r100.writeString(this.jumpToOtherPageAppId);
        r100.writeString(this.jumpToOtherPagePath);
        Map<String, String> r102 = this.jumpToOtherPageQuery;
        if (r102 == null) goto L8;
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<String, String> r104 = r103.next();
        r100.writeString(r104.getKey());
        r100.writeString(r104.getValue());
        goto L6
    L11:
        return;
    L8:
        r100.writeInt(0);
    }

    public ProductJumpSetting() {
        this.isJumpToOtherPage = false;
        this.jumpToOtherPageAppId = null;
        this.jumpToOtherPagePath = null;
        this.jumpToOtherPageQuery = null;
    }

    public ProductJumpSetting(am3.g r110) {
        this.jumpToOtherPageQuery = new HashMap();
        long r100 = r110.c();
        boolean r101 = false;
    L3:
        int r102 = r110.f();
        String r103 = null;
        if (r102 == (-1)) goto L32;
        if (r102 != 1) goto L7;
        this.isJumpToOtherPage = am3.h.a(r110);
        r101 = r101 | true;
        goto L3
    L7:
        if (r102 != 2) goto L9;
        this.jumpToOtherPageAppId = am3.h.c(r110);
        goto L3
    L9:
        if (r102 != 3) goto L11;
        this.jumpToOtherPagePath = am3.h.c(r110);
        goto L3
    L11:
        if (r102 != 4) goto L12;
        long r104 = r110.c();
        String r105 = null;
    L14:
        int r111 = r110.f();
        if (r111 == (-1)) goto L21;
        if (r111 != 1) goto L17;
        r103 = am3.h.c(r110);
        goto L14
    L17:
        if (r111 != 2) goto L18;
        r105 = am3.h.c(r110);
        goto L14
    L18:
        am3.h.e(r110);
        goto L14
    L21:
        r110.d(r104);
        Map<String, String> r106 = this.jumpToOtherPageQuery;
        if (r103 == null) goto L28;
        if (r105 == null) goto L26;
        r106.put(r103, r105);
        goto L3
    L26:
        throw new IllegalStateException("Value must not be null");
    L28:
        throw new IllegalStateException("Key must not be null");
    L12:
        am3.h.e(r110);
        goto L3
    L32:
        r110.d(r100);
        if ((r101 & true) == true) goto L36;
        this.isJumpToOtherPage = false;
    L36:
        if (this.jumpToOtherPageAppId != null) goto L39;
        this.jumpToOtherPageAppId = null;
    L39:
        if (this.jumpToOtherPagePath != null) goto L42;
        this.jumpToOtherPagePath = null;
    L42:
        if (this.jumpToOtherPageQuery != null) goto L71;
        this.jumpToOtherPageQuery = null;
        return;
    }
}
