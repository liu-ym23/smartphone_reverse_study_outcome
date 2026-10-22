package com.stepos.alphame.ocr.model;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PointResult implements Parcelable {
    public static final Parcelable.Creator<PointResult> CREATOR = new Parcelable.Creator<PointResult>() { // from class: com.stepos.alphame.ocr.model.PointResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointResult createFromParcel(Parcel parcel) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PointResult[] newArray(int i4) {
            return new PointResult[0];
        }
    };
    private List<Point> list;

    public PointResult() {
        this.list = new ArrayList();
    }

    public static PointResult fromJsonString(String str) {
        return (PointResult) JSON.parseObject(str).toJavaObject(PointResult.class);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Point> getList() {
        return this.list;
    }

    public void setList(List<Point> list) {
        this.list = list;
    }

    public void setResult(List<Point> list) {
        this.list = list;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public String toString() {
        return "PointResult {list=" + this.list + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeTypedList(this.list);
    }

    public PointResult(Parcel parcel) {
        this.list = new ArrayList();
        this.list = parcel.createTypedArrayList(Point.CREATOR);
    }
}
