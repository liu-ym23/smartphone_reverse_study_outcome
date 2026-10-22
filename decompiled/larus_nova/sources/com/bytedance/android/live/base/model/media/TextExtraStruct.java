package com.bytedance.android.live.base.model.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class TextExtraStruct implements Parcelable {
    public static final Parcelable.Creator<TextExtraStruct> CREATOR = null;

    @SerializedName("end")
    private int end;
    private transient boolean isAddPosition;

    @SerializedName("start")
    private int start;

    @SerializedName("user_id")
    private long userId;

    public class a implements Parcelable.Creator<TextExtraStruct> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TextExtraStruct createFromParcel(Parcel r100) {
            return new TextExtraStruct(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final TextExtraStruct[] newArray(int r100) {
            return new TextExtraStruct[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public TextExtraStruct() {
    }

    public int getEnd() {
        return this.end;
    }

    public int getStart() {
        return this.start;
    }

    public long getUserId() {
        return this.userId;
    }

    public boolean isAddPosition() {
        return this.isAddPosition;
    }

    public TextExtraStruct(Parcel r100) {
        this.start = r100.readInt();
        this.end = r100.readInt();
        this.userId = r100.readLong();
    }

    public void setAddPosition(boolean r100) {
        this.isAddPosition = r100;
    }

    public void setEnd(int r100) {
        this.end = r100;
    }

    public void setStart(int r100) {
        this.start = r100;
    }

    public void setUserId(long r100) {
        this.userId = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.start);
        r100.writeInt(this.end);
        r100.writeLong(this.userId);
    }
}
