package com.bytedance.android.ec.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/model/BuyNowServiceTag;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "text", "", "icon", "color", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getIcon", "setIcon", "(Ljava/lang/String;)V", "getText", "asJSONDescription", "Lorg/json/JSONObject;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class BuyNowServiceTag implements Parcelable, Serializable {
    public static final Parcelable.Creator<BuyNowServiceTag> CREATOR = null;
    private final String color;
    private String icon;
    private final String text;

    public static class a implements Parcelable.Creator<BuyNowServiceTag> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BuyNowServiceTag createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new BuyNowServiceTag(r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final BuyNowServiceTag[] newArray(int r100) {
            return new BuyNowServiceTag[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BuyNowServiceTag() {
        this(null, null, null, 7, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.text);
        r100.writeString(this.icon);
        r100.writeString(this.color);
    }

    public final JSONObject asJSONDescription() {
        JSONObject r100 = new JSONObject();
        r100.put("text", this.text);
        r100.put("icon", this.icon);
        r100.put("color", this.color);
        return r100;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getText() {
        return this.text;
    }

    public final void setIcon(String r100) {
        this.icon = r100;
    }

    public BuyNowServiceTag(String r100, String r101, String r102) {
        this.text = r100;
        this.icon = r101;
        this.color = r102;
    }

    public /* synthetic */ BuyNowServiceTag(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
