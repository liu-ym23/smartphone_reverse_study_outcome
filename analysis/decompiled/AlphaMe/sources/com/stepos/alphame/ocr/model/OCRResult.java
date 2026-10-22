package com.stepos.alphame.ocr.model;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.JSON;
import java.util.List;

/* loaded from: classes.dex */
public class OCRResult implements Parcelable {
    public static final Parcelable.Creator<OCRResult> CREATOR = new Parcelable.Creator<OCRResult>() { // from class: com.stepos.alphame.ocr.model.OCRResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OCRResult createFromParcel(Parcel parcel) {
            return new OCRResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OCRResult[] newArray(int i4) {
            return new OCRResult[i4];
        }
    };
    public int bitmapHeight;
    private String bitmapPath;
    public String bitmapType;
    public int bitmapWidth;
    public long contentVersion;
    private List<LineResult> lineResults;
    private String recognizedText;
    private List<LineResult> sectionResults;

    public OCRResult() {
    }

    public static OCRResult fromJsonString(String str) {
        return (OCRResult) JSON.parseObject(str).toJavaObject(OCRResult.class);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBitmapHeight() {
        return this.bitmapHeight;
    }

    public String getBitmapPath() {
        return this.bitmapPath;
    }

    public String getBitmapType() {
        return this.bitmapType;
    }

    public int getBitmapWidth() {
        return this.bitmapWidth;
    }

    public long getContentVersion() {
        return this.contentVersion;
    }

    public List<LineResult> getLineResults() {
        return this.lineResults;
    }

    public String getRecognizedText() {
        return this.recognizedText;
    }

    public List<LineResult> getSectionResults() {
        return this.sectionResults;
    }

    public void setBitmapHeight(int i4) {
        this.bitmapHeight = i4;
    }

    public void setBitmapPath(String str) {
        this.bitmapPath = str;
    }

    public void setBitmapType(String str) {
        this.bitmapType = str;
    }

    public void setBitmapWidth(int i4) {
        this.bitmapWidth = i4;
    }

    public void setContentVersion(long j4) {
        this.contentVersion = j4;
    }

    public void setLineResults(List<LineResult> list) {
        this.lineResults = list;
    }

    public void setRecognizedText(String str) {
        this.recognizedText = str;
    }

    public void setResult(String str, List<LineResult> list, List<LineResult> list2, String str2, String str3, long j4, int i4, int i5) {
        this.bitmapPath = str;
        this.lineResults = list;
        this.sectionResults = list2;
        this.recognizedText = str2;
        this.bitmapType = str3;
        this.contentVersion = j4;
        this.bitmapWidth = i4;
        this.bitmapHeight = i5;
    }

    public void setSectionResults(List<LineResult> list) {
        this.sectionResults = list;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OCRResult{bitmapPath='");
        sb.append(this.bitmapPath);
        sb.append("', recognizedText='");
        sb.append(this.recognizedText);
        sb.append("', lineResults=");
        sb.append(this.lineResults);
        sb.append(", sectionResults=");
        sb.append(this.sectionResults);
        sb.append(", bitmapWidth=");
        sb.append(this.bitmapWidth);
        sb.append(", bitmapHeight=");
        sb.append(this.bitmapHeight);
        sb.append(", contentVersion=");
        sb.append(this.contentVersion);
        sb.append(", bitmapType='");
        return g.r(sb, this.bitmapType, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.bitmapPath);
        parcel.writeString(this.bitmapType);
        parcel.writeInt(this.bitmapWidth);
        parcel.writeInt(this.bitmapHeight);
        parcel.writeLong(this.contentVersion);
        parcel.writeString(this.recognizedText);
        parcel.writeTypedList(this.lineResults);
        parcel.writeTypedList(this.sectionResults);
    }

    public OCRResult(String str, String str2) {
        this.bitmapPath = str;
        this.recognizedText = str2;
    }

    public OCRResult(String str, List<LineResult> list) {
        this.bitmapPath = str;
        this.lineResults = list;
    }

    public OCRResult(Parcel parcel) {
        this.bitmapPath = parcel.readString();
        this.bitmapType = parcel.readString();
        this.bitmapWidth = parcel.readInt();
        this.bitmapHeight = parcel.readInt();
        this.contentVersion = parcel.readLong();
        this.recognizedText = parcel.readString();
        Parcelable.Creator<LineResult> creator = LineResult.CREATOR;
        this.lineResults = parcel.createTypedArrayList(creator);
        this.sectionResults = parcel.createTypedArrayList(creator);
    }
}
