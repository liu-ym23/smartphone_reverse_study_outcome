package com.bytedance.android.livesdkapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001cH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000b¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LinkMediaModel;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "fileLocalUriPath", "", "getFileLocalUriPath", "()Ljava/lang/String;", "setFileLocalUriPath", "(Ljava/lang/String;)V", "fileName", "getFileName", "setFileName", "fileSize", "", "getFileSize", "()J", "setFileSize", "(J)V", "relativePath", "getRelativePath", "setRelativePath", DocCallbackImpl.KEY_THUMBNAIL, "getThumbnail", "setThumbnail", "describeContents", "", "writeToParcel", "", "dest", "flags", "CREATOR", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkMediaModel implements Parcelable {
    public static final CREATOR CREATOR = null;
    public static final String KEY_CHOOSE_MEDIA_LIVE_LINK_DATA = "key_choose_media_live_link_data";
    public static final int LIVE_LINK_OPEN_ALBUM_REQUEST_CODE = 100200;
    private String fileLocalUriPath;
    private String fileName;
    private long fileSize;
    private String relativePath;
    private String thumbnail;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LinkMediaModel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/bytedance/android/livesdkapi/model/LinkMediaModel;", "()V", "KEY_CHOOSE_MEDIA_LIVE_LINK_DATA", "", "LIVE_LINK_OPEN_ALBUM_REQUEST_CODE", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/bytedance/android/livesdkapi/model/LinkMediaModel;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CREATOR implements Parcelable.Creator<LinkMediaModel> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkMediaModel createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new LinkMediaModel(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LinkMediaModel[] newArray(int r100) {
            return newArray(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LinkMediaModel createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkMediaModel[] newArray(int r100) {
            return new LinkMediaModel[r100];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public LinkMediaModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getFileLocalUriPath() {
        return this.fileLocalUriPath;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public LinkMediaModel(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.fileLocalUriPath = r100.readString();
        this.relativePath = r100.readString();
        this.fileName = r100.readString();
        this.fileSize = r100.readLong();
        this.thumbnail = r100.readString();
    }

    public final void setFileLocalUriPath(String r100) {
        this.fileLocalUriPath = r100;
    }

    public final void setFileName(String r100) {
        this.fileName = r100;
    }

    public final void setFileSize(long r100) {
        this.fileSize = r100;
    }

    public final void setRelativePath(String r100) {
        this.relativePath = r100;
    }

    public final void setThumbnail(String r100) {
        this.thumbnail = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.fileLocalUriPath);
        r100.writeString(this.relativePath);
        r100.writeString(this.fileName);
        r100.writeLong(this.fileSize);
        r100.writeString(this.thumbnail);
    }
}
