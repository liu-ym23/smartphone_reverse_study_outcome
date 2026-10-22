package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.ShelfMicroAppInfo")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfMicroAppInfo;", "Landroid/os/Parcelable;", "", "appId", "Ljava/lang/String;", "name", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "schema", "", "anchorLiveStatus", "I", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/MicroAppLabel;", "label", "Ljava/util/List;", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfMicroAppInfo implements Parcelable, h {
    public static final Parcelable.Creator<ShelfMicroAppInfo> CREATOR = null;

    @IgnoreProtoFieldCheck
    @SerializedName("anchor_live_status")
    public final int anchorLiveStatus;

    @SerializedName("app_id")
    public String appId;

    @SerializedName("icon")
    public ImageModel icon;

    @SerializedName("label")
    public List<MicroAppLabel> label;

    @SerializedName("name")
    public String name;

    @SerializedName("schema")
    public String schema;

    public static class a implements Parcelable.Creator<ShelfMicroAppInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShelfMicroAppInfo createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            String r100 = r110.readString();
            String r101 = r110.readString();
            ImageModel r102 = (ImageModel) r110.readParcelable(ShelfMicroAppInfo.class.getClassLoader());
            String r103 = r110.readString();
            int r104 = r110.readInt();
            if (r110.readInt() == 0) goto L7;
            int r105 = r110.readInt();
            ArrayList r106 = new ArrayList(r105);
        L5:
            if (r105 == 0) goto L9;
            r106.add(MicroAppLabel.CREATOR.createFromParcel(r110));
            r105 = r105 - 1;
        L9:
            return new ShelfMicroAppInfo(r100, r101, r102, r103, r104, r106);
        L7:
            r106 = null;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final ShelfMicroAppInfo[] newArray(int r100) {
            return new ShelfMicroAppInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ShelfMicroAppInfo(String r100, String r101, ImageModel r102, String r103, int r104, List<MicroAppLabel> r105) {
        this.appId = r100;
        this.name = r101;
        this.icon = r102;
        this.schema = r103;
        this.anchorLiveStatus = r104;
        this.label = r105;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShelfMicroAppInfo) == false) goto L18;
        ShelfMicroAppInfo r101 = (ShelfMicroAppInfo) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L14;
        return false;
    L14:
        if (this.anchorLiveStatus == r101.anchorLiveStatus) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.label, r101.label) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.appId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ImageModel r107 = this.icon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.schema;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((r109 + r111) * 31) + this.anchorLiveStatus) * 31;
        List<MicroAppLabel> r113 = this.label;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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

    public final String toString() {
        return "ShelfMicroAppInfo(appId=" + this.appId + ", name=" + this.name + ", icon=" + this.icon + ", schema=" + this.schema + ", anchorLiveStatus=" + this.anchorLiveStatus + ", label=" + this.label + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.appId);
        r100.writeString(this.name);
        r100.writeParcelable(this.icon, r101);
        r100.writeString(this.schema);
        r100.writeInt(this.anchorLiveStatus);
        List<MicroAppLabel> r102 = this.label;
        if (r102 == null) goto L8;
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<MicroAppLabel> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        r103.next().writeToParcel(r100, 0);
        goto L6
    L11:
        return;
    L8:
        r100.writeInt(0);
    }

    public ShelfMicroAppInfo() {
        this.appId = null;
        this.name = null;
        this.icon = null;
        this.schema = null;
        this.label = null;
    }

    public ShelfMicroAppInfo(am3.g r100) {
        this.label = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.appId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.name = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.icon = x.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.schema = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.label.add(new MicroAppLabel(r100));
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.appId != null) goto L25;
        this.appId = null;
    L25:
        if (this.name != null) goto L28;
        this.name = null;
    L28:
        if (this.icon != null) goto L31;
        this.icon = null;
    L31:
        if (this.schema != null) goto L34;
        this.schema = null;
    L34:
        if (this.label.isEmpty() == false) goto L55;
        this.label = null;
        return;
    }

    public static ShelfMicroAppInfo a(ShelfMicroAppInfo r100, String r110, int r111, int r112) {
        List<MicroAppLabel> r101 = null;
        if ((r112 & 1) == 0) goto L5;
        String r102 = r100.appId;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r103 = r100.name;
    L11:
        if ((r112 & 4) == 0) goto L13;
        ImageModel r104 = r100.icon;
    L15:
        if ((r112 & 8) == 0) goto L17;
        r110 = r100.schema;
    L17:
        String r105 = r110;
        if ((r112 & 16) == 0) goto L20;
        r111 = r100.anchorLiveStatus;
    L20:
        int r106 = r111;
        if ((r112 & 32) == 0) goto L24;
        r101 = r100.label;
    L24:
        return new ShelfMicroAppInfo(r102, r103, r104, r105, r106, r101);
    L13:
        r104 = null;
        goto L15
    L9:
        r103 = null;
        goto L11
    L5:
        r102 = null;
        goto L7
    }

    public /* synthetic */ ShelfMicroAppInfo(String r110, String r111, ImageModel r112, String r113, int r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r115 & 4) == 0) goto L13;
        ImageModel r102 = null;
    L15:
        if ((r115 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r115 & 16) == 0) goto L21;
        int r104 = -1;
    L22:
        this(r100, r101, r102, r103, r104, null);
        return;
    L21:
        r104 = r114;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
