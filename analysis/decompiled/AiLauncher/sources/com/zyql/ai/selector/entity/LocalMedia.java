package com.zyql.ai.selector.entity;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.tools.DateUtils;
import com.zyql.ai.selector.tools.MediaUtils;
import com.zyql.ai.selector.tools.PictureFileUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import com.zyql.ai.selector.tools.ValueOf;
import java.io.File;

/* loaded from: classes4.dex */
public class LocalMedia implements Parcelable {
    public static final Parcelable.Creator<LocalMedia> CREATOR = new Parcelable.Creator<LocalMedia>() { // from class: com.zyql.ai.selector.entity.LocalMedia.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalMedia createFromParcel(Parcel parcel) {
            return new LocalMedia(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalMedia[] newArray(int i10) {
            return new LocalMedia[i10];
        }
    };
    private String androidQToPath;
    private long bucketId;
    private int chooseModel;
    private String compressPath;
    private boolean compressed;
    private int cropImageHeight;
    private int cropImageWidth;
    private int cropOffsetX;
    private int cropOffsetY;
    private float cropResultAspectRatio;
    private String cutPath;
    private long dateAddedTime;
    private long duration;
    private String fileName;
    private int height;
    private long id;
    private boolean isChecked;
    private boolean isCut;
    public boolean isLongImage;
    private boolean isMaxSelectEnabledMask;
    private boolean isOriginal;
    public int loadLongImageStatus;
    private String mimeType;
    private int num;

    @Deprecated
    private int orientation;
    private String originalPath;
    private String parentFolderName;
    private String path;
    public int position;
    private String realPath;
    private long size;
    private int width;

    public LocalMedia() {
        this.orientation = -1;
        this.loadLongImageStatus = -1;
        this.bucketId = -1L;
    }

    public static LocalMedia createLocalMedia(Context context, String str) {
        LocalMedia localMedia = new LocalMedia();
        String path = PictureFileUtils.getPath(context, Uri.parse(str));
        File file = new File(path);
        String imageMimeType = PictureMimeType.getImageMimeType(str);
        localMedia.setSize(file.length());
        localMedia.setFileName(file.getName());
        if (PictureMimeType.isHasImage(imageMimeType)) {
            MediaExtraInfo imageSize = MediaUtils.getImageSize(context, str);
            localMedia.setWidth(imageSize.getWidth());
            localMedia.setHeight(imageSize.getHeight());
        } else if (PictureMimeType.isHasVideo(imageMimeType)) {
            MediaExtraInfo videoSize = MediaUtils.getVideoSize(context, str);
            localMedia.setWidth(videoSize.getWidth());
            localMedia.setHeight(videoSize.getHeight());
            localMedia.setDuration(videoSize.getDuration());
        } else if (PictureMimeType.isHasAudio(imageMimeType)) {
            localMedia.setDuration(MediaUtils.getAudioSize(context, str).getDuration());
        }
        int iLastIndexOf = str.lastIndexOf("/") + 1;
        localMedia.setId(iLastIndexOf > 0 ? ValueOf.toLong(str.substring(iLastIndexOf)) : -1L);
        localMedia.setRealPath(path);
        localMedia.setPath(str);
        localMedia.setMimeType(imageMimeType);
        if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isHasVideo(localMedia.getMimeType())) {
            localMedia.setParentFolderName(Environment.DIRECTORY_MOVIES);
        } else {
            localMedia.setParentFolderName(PictureMimeType.CAMERA);
        }
        localMedia.setBucketId(MediaUtils.getCameraFirstBucketId(context));
        localMedia.setDateAddedTime(DateUtils.getCurrentTimeMillis());
        return localMedia;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAndroidQToPath() {
        return this.androidQToPath;
    }

    public long getBucketId() {
        return this.bucketId;
    }

    public int getChooseModel() {
        return this.chooseModel;
    }

    public String getCompressPath() {
        return this.compressPath;
    }

    public int getCropImageHeight() {
        return this.cropImageHeight;
    }

    public int getCropImageWidth() {
        return this.cropImageWidth;
    }

    public int getCropOffsetX() {
        return this.cropOffsetX;
    }

    public int getCropOffsetY() {
        return this.cropOffsetY;
    }

    public float getCropResultAspectRatio() {
        return this.cropResultAspectRatio;
    }

    public String getCutPath() {
        return this.cutPath;
    }

    public long getDateAddedTime() {
        return this.dateAddedTime;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getHeight() {
        return this.height;
    }

    public long getId() {
        return this.id;
    }

    public String getMimeType() {
        return TextUtils.isEmpty(this.mimeType) ? "image/jpeg" : this.mimeType;
    }

    public int getNum() {
        return this.num;
    }

    @Deprecated
    public int getOrientation() {
        return this.orientation;
    }

    public String getOriginalPath() {
        return this.originalPath;
    }

    public String getParentFolderName() {
        return this.parentFolderName;
    }

    public String getPath() {
        return this.path;
    }

    public int getPosition() {
        return this.position;
    }

    public String getRealPath() {
        return this.realPath;
    }

    public long getSize() {
        return this.size;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isCompressed() {
        return this.compressed;
    }

    public boolean isCut() {
        return this.isCut;
    }

    public boolean isMaxSelectEnabledMask() {
        return this.isMaxSelectEnabledMask;
    }

    public boolean isOriginal() {
        return this.isOriginal;
    }

    public void setAndroidQToPath(String str) {
        this.androidQToPath = str;
    }

    public void setBucketId(long j10) {
        this.bucketId = j10;
    }

    public void setChecked(boolean z10) {
        this.isChecked = z10;
    }

    public void setChooseModel(int i10) {
        this.chooseModel = i10;
    }

    public void setCompressPath(String str) {
        this.compressPath = str;
    }

    public void setCompressed(boolean z10) {
        this.compressed = z10;
    }

    public void setCropImageHeight(int i10) {
        this.cropImageHeight = i10;
    }

    public void setCropImageWidth(int i10) {
        this.cropImageWidth = i10;
    }

    public void setCropOffsetX(int i10) {
        this.cropOffsetX = i10;
    }

    public void setCropOffsetY(int i10) {
        this.cropOffsetY = i10;
    }

    public void setCropResultAspectRatio(float f10) {
        this.cropResultAspectRatio = f10;
    }

    public void setCut(boolean z10) {
        this.isCut = z10;
    }

    public void setCutPath(String str) {
        this.cutPath = str;
    }

    public void setDateAddedTime(long j10) {
        this.dateAddedTime = j10;
    }

    public void setDuration(long j10) {
        this.duration = j10;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setHeight(int i10) {
        this.height = i10;
    }

    public void setId(long j10) {
        this.id = j10;
    }

    public void setMaxSelectEnabledMask(boolean z10) {
        this.isMaxSelectEnabledMask = z10;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setNum(int i10) {
        this.num = i10;
    }

    @Deprecated
    public void setOrientation(int i10) {
        this.orientation = i10;
    }

    public void setOriginal(boolean z10) {
        this.isOriginal = z10;
    }

    public void setOriginalPath(String str) {
        this.originalPath = str;
    }

    public void setParentFolderName(String str) {
        this.parentFolderName = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPosition(int i10) {
        this.position = i10;
    }

    public void setRealPath(String str) {
        this.realPath = str;
    }

    public void setSize(long j10) {
        this.size = j10;
    }

    public void setWidth(int i10) {
        this.width = i10;
    }

    public String toString() {
        return "LocalMedia{id=" + this.id + ", path='" + this.path + "', realPath='" + this.realPath + "', originalPath='" + this.originalPath + "', compressPath='" + this.compressPath + "', cutPath='" + this.cutPath + "', androidQToPath='" + this.androidQToPath + "', duration=" + this.duration + ", isChecked=" + this.isChecked + ", isCut=" + this.isCut + ", position=" + this.position + ", num=" + this.num + ", mimeType='" + this.mimeType + "', chooseModel=" + this.chooseModel + ", compressed=" + this.compressed + ", width=" + this.width + ", height=" + this.height + ", cropImageWidth=" + this.cropImageWidth + ", cropImageHeight=" + this.cropImageHeight + ", cropOffsetX=" + this.cropOffsetX + ", cropOffsetY=" + this.cropOffsetY + ", cropResultAspectRatio=" + this.cropResultAspectRatio + ", size=" + this.size + ", isOriginal=" + this.isOriginal + ", fileName='" + this.fileName + "', parentFolderName='" + this.parentFolderName + "', orientation=" + this.orientation + ", loadLongImageStatus=" + this.loadLongImageStatus + ", isLongImage=" + this.isLongImage + ", bucketId=" + this.bucketId + ", isMaxSelectEnabledMask=" + this.isMaxSelectEnabledMask + ", dateAddedTime=" + this.dateAddedTime + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.id);
        parcel.writeString(this.path);
        parcel.writeString(this.realPath);
        parcel.writeString(this.originalPath);
        parcel.writeString(this.compressPath);
        parcel.writeString(this.cutPath);
        parcel.writeString(this.androidQToPath);
        parcel.writeLong(this.duration);
        parcel.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCut ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.position);
        parcel.writeInt(this.num);
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.chooseModel);
        parcel.writeByte(this.compressed ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.cropImageWidth);
        parcel.writeInt(this.cropImageHeight);
        parcel.writeInt(this.cropOffsetX);
        parcel.writeInt(this.cropOffsetY);
        parcel.writeFloat(this.cropResultAspectRatio);
        parcel.writeLong(this.size);
        parcel.writeByte(this.isOriginal ? (byte) 1 : (byte) 0);
        parcel.writeString(this.fileName);
        parcel.writeString(this.parentFolderName);
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.loadLongImageStatus);
        parcel.writeByte(this.isLongImage ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.bucketId);
        parcel.writeByte(this.isMaxSelectEnabledMask ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.dateAddedTime);
    }

    public LocalMedia(long j10, String str, String str2, String str3, String str4, long j11, int i10, String str5, int i11, int i12, long j12, long j13, long j14) {
        this.orientation = -1;
        this.loadLongImageStatus = -1;
        this.id = j10;
        this.path = str;
        this.realPath = str2;
        this.fileName = str3;
        this.parentFolderName = str4;
        this.duration = j11;
        this.chooseModel = i10;
        this.mimeType = str5;
        this.width = i11;
        this.height = i12;
        this.size = j12;
        this.bucketId = j13;
        this.dateAddedTime = j14;
    }

    public LocalMedia(String str, long j10, boolean z10, int i10, int i11, int i12) {
        this.orientation = -1;
        this.loadLongImageStatus = -1;
        this.bucketId = -1L;
        this.path = str;
        this.duration = j10;
        this.isChecked = z10;
        this.position = i10;
        this.num = i11;
        this.chooseModel = i12;
    }

    public LocalMedia(Parcel parcel) {
        this.orientation = -1;
        this.loadLongImageStatus = -1;
        this.bucketId = -1L;
        this.id = parcel.readLong();
        this.path = parcel.readString();
        this.realPath = parcel.readString();
        this.originalPath = parcel.readString();
        this.compressPath = parcel.readString();
        this.cutPath = parcel.readString();
        this.androidQToPath = parcel.readString();
        this.duration = parcel.readLong();
        this.isChecked = parcel.readByte() != 0;
        this.isCut = parcel.readByte() != 0;
        this.position = parcel.readInt();
        this.num = parcel.readInt();
        this.mimeType = parcel.readString();
        this.chooseModel = parcel.readInt();
        this.compressed = parcel.readByte() != 0;
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.cropImageWidth = parcel.readInt();
        this.cropImageHeight = parcel.readInt();
        this.cropOffsetX = parcel.readInt();
        this.cropOffsetY = parcel.readInt();
        this.cropResultAspectRatio = parcel.readFloat();
        this.size = parcel.readLong();
        this.isOriginal = parcel.readByte() != 0;
        this.fileName = parcel.readString();
        this.parentFolderName = parcel.readString();
        this.orientation = parcel.readInt();
        this.loadLongImageStatus = parcel.readInt();
        this.isLongImage = parcel.readByte() != 0;
        this.bucketId = parcel.readLong();
        this.isMaxSelectEnabledMask = parcel.readByte() != 0;
        this.dateAddedTime = parcel.readLong();
    }
}
