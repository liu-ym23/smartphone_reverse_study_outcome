package com.stepos.alphame.ocr.model;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public class WordResult implements Parcelable {
    public static final Parcelable.Creator<WordResult> CREATOR = new Parcelable.Creator<WordResult>() { // from class: com.stepos.alphame.ocr.model.WordResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WordResult createFromParcel(Parcel parcel) {
            return new WordResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WordResult[] newArray(int i4) {
            return new WordResult[i4];
        }
    };
    private String text;
    private List<Integer> wordPosition;

    public WordResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Integer> getPosition() {
        return this.wordPosition;
    }

    public String getText() {
        return this.text;
    }

    public void setPosition(List<Integer> list) {
        this.wordPosition = list;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WordResult{position=");
        sb.append(this.wordPosition);
        sb.append(", text='");
        return g.r(sb, this.text, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeList(this.wordPosition);
        parcel.writeString(this.text);
    }

    public WordResult(Parcel parcel) {
        this.wordPosition = parcel.readArrayList(Integer.class.getClassLoader());
        this.text = parcel.readString();
    }
}
