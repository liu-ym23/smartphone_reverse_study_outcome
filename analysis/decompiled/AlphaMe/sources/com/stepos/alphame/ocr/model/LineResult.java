package com.stepos.alphame.ocr.model;

import B0.g;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class LineResult implements Parcelable {
    public static final Parcelable.Creator<LineResult> CREATOR = new Parcelable.Creator<LineResult>() { // from class: com.stepos.alphame.ocr.model.LineResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LineResult createFromParcel(Parcel parcel) {
            return new LineResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LineResult[] newArray(int i4) {
            return new LineResult[i4];
        }
    };
    private int angle;
    private List<Integer> backgroundColor;
    private float confidence;
    private ArrayList<Integer> lineIndex;
    private List<Integer> mergeRelations;
    private List<Point> points;
    private Rect position;
    private String text;
    private List<Integer> textColor;
    private List<WordResult> wordResults;

    public LineResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAngle() {
        return this.angle;
    }

    public List<Integer> getBackgroundColor() {
        return this.backgroundColor;
    }

    public float getConfidence() {
        return this.confidence;
    }

    public List<Integer> getLineIndex() {
        return this.lineIndex;
    }

    public List<Integer> getMergeRelations() {
        return this.mergeRelations;
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public Rect getPosition() {
        return this.position;
    }

    public String getText() {
        return this.text;
    }

    public List<Integer> getTextColor() {
        return this.textColor;
    }

    public List<WordResult> getWordResults() {
        return this.wordResults;
    }

    public void setAngle(int i4) {
        this.angle = i4;
    }

    public void setBackgroundColor(List<Integer> list) {
        this.backgroundColor = list;
    }

    public void setConfidence(float f4) {
        this.confidence = f4;
    }

    public void setLineIndex(ArrayList<Integer> arrayList) {
        this.lineIndex = arrayList;
    }

    public void setMergeRelations(List<Integer> list) {
        this.mergeRelations = list;
    }

    public void setPoints(List<Point> list) {
        this.points = list;
    }

    public void setPosition(Rect rect) {
        this.position = rect;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTextColor(List<Integer> list) {
        this.textColor = list;
    }

    public void setWordResults(List<WordResult> list) {
        this.wordResults = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LineResult{points=");
        sb.append(this.points);
        sb.append(", position=");
        sb.append(this.position);
        sb.append(", text='");
        sb.append(this.text);
        sb.append("', confidence=");
        sb.append(this.confidence);
        sb.append(", wordResults=");
        sb.append(this.wordResults);
        sb.append(", angle=");
        return g.o(sb, this.angle, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeTypedList(this.points);
        parcel.writeParcelable(this.position, i4);
        parcel.writeString(this.text);
        parcel.writeFloat(this.confidence);
        parcel.writeTypedList(this.wordResults);
        parcel.writeInt(this.angle);
        parcel.writeList(this.lineIndex);
        parcel.writeList(this.textColor);
        parcel.writeList(this.backgroundColor);
        parcel.writeList(this.mergeRelations);
    }

    public LineResult(Parcel parcel) {
        this.points = parcel.createTypedArrayList(Point.CREATOR);
        this.position = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.text = parcel.readString();
        this.confidence = parcel.readFloat();
        this.wordResults = parcel.createTypedArrayList(WordResult.CREATOR);
        this.angle = parcel.readInt();
        this.lineIndex = parcel.readArrayList(ArrayList.class.getClassLoader(), Integer.class);
        this.textColor = parcel.readArrayList(ArrayList.class.getClassLoader(), Integer.class);
        this.backgroundColor = parcel.readArrayList(ArrayList.class.getClassLoader(), Integer.class);
        this.mergeRelations = parcel.readArrayList(ArrayList.class.getClassLoader(), Integer.class);
    }
}
