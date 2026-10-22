package com.stepos.alphame.ocr.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class OcrBoundResult implements Parcelable {
    public static final Parcelable.Creator<OcrBoundResult> CREATOR = new Parcelable.Creator<OcrBoundResult>() { // from class: com.stepos.alphame.ocr.model.OcrBoundResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OcrBoundResult createFromParcel(Parcel parcel) {
            return new OcrBoundResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OcrBoundResult[] newArray(int i4) {
            return new OcrBoundResult[i4];
        }
    };
    private int imageHeight;
    private int imageWidth;
    private List<PointResult> points;

    public OcrBoundResult() {
        this.points = new ArrayList();
    }

    public static OcrBoundResult fromJsonString(String str) {
        return (OcrBoundResult) JSON.parseObject(str).toJavaObject(OcrBoundResult.class);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public List<PointResult> getPoints() {
        return this.points;
    }

    public void setImageHeight(int i4) {
        this.imageHeight = i4;
    }

    public void setImageWidth(int i4) {
        this.imageWidth = i4;
    }

    public void setPoints(List<PointResult> list) {
        this.points = list;
    }

    public void setResult(List<PointResult> list) {
        this.points = list;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public String toString() {
        return "DetectResult {points=" + this.points + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeTypedList(this.points);
        parcel.writeInt(this.imageWidth);
        parcel.writeInt(this.imageHeight);
    }

    public OcrBoundResult(Parcel parcel) {
        this.points = new ArrayList();
        this.points = parcel.createTypedArrayList(PointResult.CREATOR);
        this.imageWidth = parcel.readInt();
        this.imageHeight = parcel.readInt();
    }
}
