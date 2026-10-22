package com.stepos.alphame.ocr.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DetectResult implements Parcelable {
    public static final Parcelable.Creator<DetectResult> CREATOR = new Parcelable.Creator<DetectResult>() { // from class: com.stepos.alphame.ocr.model.DetectResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DetectResult createFromParcel(Parcel parcel) {
            return new DetectResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DetectResult[] newArray(int i4) {
            return new DetectResult[i4];
        }
    };
    private List<PointResult> points;

    public DetectResult() {
        this.points = new ArrayList();
    }

    public static DetectResult fromJsonString(String str) {
        return (DetectResult) JSON.parseObject(str).toJavaObject(DetectResult.class);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PointResult> getPoints() {
        return this.points;
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
    }

    public DetectResult(Parcel parcel) {
        this.points = new ArrayList();
        this.points = parcel.createTypedArrayList(PointResult.CREATOR);
    }
}
