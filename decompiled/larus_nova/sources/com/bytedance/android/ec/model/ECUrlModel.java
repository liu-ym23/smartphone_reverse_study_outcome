package com.bytedance.android.ec.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0002J\b\u0010*\u001a\u0004\u0018\u00010\u0005J\b\u0010+\u001a\u00020\u000bH\u0016J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000bHÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR&\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000f¨\u00061"}, d2 = {"Lcom/bytedance/android/ec/model/ECUrlModel;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "()V", "fileHash", "", "getFileHash", "()Ljava/lang/String;", "setFileHash", "(Ljava/lang/String;)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "size", "", "getSize", "()J", "setSize", "(J)V", "uri", "getUri", "setUri", "urlKey", "getUrlKey", "setUrlKey", "urlList", "", "getUrlList", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "width", "getWidth", "setWidth", "describeContents", "equals", "", "other", "", "getFirstUrl", "hashCode", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public class ECUrlModel implements Serializable, Parcelable {
    public static final Parcelable.Creator<ECUrlModel> CREATOR = null;

    @SerializedName(BarrageMaskInfo.KEY_MASK_FILE_HASH)
    private String fileHash;

    @SerializedName("height")
    private int height;

    @SerializedName("data_size")
    private long size;

    @SerializedName("uri")
    private String uri;

    @SerializedName("url_key")
    private String urlKey;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private List<String> urlList;

    @SerializedName("width")
    private int width;

    public static class a implements Parcelable.Creator<ECUrlModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ECUrlModel createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            if (r100.readInt() != 0) goto L7;
            return null;
        L7:
            return new ECUrlModel();
        }

        @Override // android.os.Parcelable.Creator
        public final ECUrlModel[] newArray(int r100) {
            return new ECUrlModel[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ECUrlModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(1);
    }

    public final String getFirstUrl() {
        List<String> r100 = this.urlList;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (String) CollectionsKt.firstOrNull(r100);
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.urlKey) == false) goto L5;
        String r100 = this.uri;
    L6:
        int r101 = 0;
        if (r100 == null) goto L9;
        int r102 = r100.hashCode();
    L10:
        int r103 = r102 * 31;
        List<String> r104 = this.urlList;
        if (r104 == null) goto L15;
        if (r104 == null) goto L15;
        r101 = r104.hashCode();
    L15:
        return r103 + r101;
    L9:
        r102 = 0;
        goto L10
    L5:
        r100 = this.urlKey;
        goto L6
    }

    public final String getFileHash() {
        return this.fileHash;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getUrlKey() {
        return this.urlKey;
    }

    public final List<String> getUrlList() {
        return this.urlList;
    }

    public final int getWidth() {
        return this.width;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ECUrlModel) == true) goto L8;
        return false;
    L8:
        String r101 = this.uri;
        if (r101 == null) goto L12;
        boolean r102 = !Intrinsics.areEqual(r101, ((ECUrlModel) r100).uri);
    L15:
        if (r102 == false) goto L17;
        return false;
    L17:
        String r103 = this.urlKey;
        if (r103 == null) goto L21;
        boolean r104 = !Intrinsics.areEqual(r103, ((ECUrlModel) r100).urlKey);
    L24:
        if (r104 == false) goto L26;
        return false;
    L26:
        List<String> r105 = this.urlList;
        List<String> r106 = ((ECUrlModel) r100).urlList;
        if (r105 != null) goto L33;
        if (r106 == null) goto L34;
        return false;
    L34:
        return true;
    L33:
        return Intrinsics.areEqual(r105, r106);
    L21:
        if (((ECUrlModel) r100).urlKey == null) goto L23;
        r104 = true;
        goto L24
    L23:
        r104 = false;
        goto L24
    L12:
        if (((ECUrlModel) r100).uri == null) goto L14;
        r102 = true;
        goto L15
    L14:
        r102 = false;
        goto L15
    }

    public final void setFileHash(String r100) {
        this.fileHash = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setSize(long r100) {
        this.size = r100;
    }

    public final void setUri(String r100) {
        this.uri = r100;
    }

    public final void setUrlKey(String r100) {
        this.urlKey = r100;
    }

    public final void setUrlList(List<String> r100) {
        this.urlList = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }
}
