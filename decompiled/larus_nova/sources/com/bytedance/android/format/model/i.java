package com.bytedance.android.format.model;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/format/model/i;", "", "", "downloadUrl", "Ljava/lang/String;", "getDownloadUrl", "()Ljava/lang/String;", "setDownloadUrl", "(Ljava/lang/String;)V", "id", "getId", "setId", "innerResourceId", "getInnerResourceId", "setInnerResourceId", "localPath", "getLocalPath", "setLocalPath", "type", "getType", "setType", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("download_url")
    private String downloadUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f51351id;

    @SerializedName("resource_id")
    private String innerResourceId;

    @SerializedName("local_path")
    private String localPath;

    @SerializedName("type")
    private String type;

    public i() {
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("AvatarRes(downloadUrl=");
        r100.append(this.downloadUrl);
        r100.append(", id=");
        r100.append(this.f51351id);
        r100.append(", innerResourceId=");
        r100.append(this.innerResourceId);
        r100.append(", resourceId=");
        String r101 = this.innerResourceId;
        if (r101 == null) goto L5;
        String r102 = StringsKt.replace$default(r101, HTTP.URL_DEFAULT, "#_#", false, 4, null);
    L6:
        r100.append(r102);
        r100.append(", localPath=");
        r100.append(this.localPath);
        r100.append(", localFileMd5=null, type=");
        r100.append(this.type);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public final String getType() {
        return this.type;
    }
}
