package com.mdisdk.capability.model;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class ActionExtra implements Parcelable {
    public static final Parcelable.Creator<ActionExtra> CREATOR = new Parcelable.Creator<ActionExtra>() { // from class: com.mdisdk.capability.model.ActionExtra.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActionExtra createFromParcel(Parcel parcel) {
            return new ActionExtra(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActionExtra[] newArray(int i) {
            return new ActionExtra[i];
        }
    };
    public static final int TEXT_END = -1;

    @Nullable
    private final String content;
    private final long duration;
    private final int toX;
    private final int toY;

    /* renamed from: x, reason: collision with root package name */
    private final int f2997x;
    private final int y;

    public static class Builder {
        private String content;
        private long duration;
        private int toX;
        private int toY;

        /* renamed from: x, reason: collision with root package name */
        private int f2998x;
        private int y;

        public ActionExtra build() {
            return new ActionExtra(this.f2998x, this.y, this.toX, this.toY, this.duration, this.content);
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public Builder duration(long j5) {
            this.duration = j5;
            return this;
        }

        public Builder position(int i, int i6) {
            this.f2998x = i;
            this.y = i6;
            this.toX = i;
            this.toY = i6;
            return this;
        }

        public Builder toPosition(int i, int i6) {
            this.toX = i;
            this.toY = i6;
            return this;
        }
    }

    public ActionExtra(int i, int i6) {
        this(i, i6, i, i6, 0L, null);
    }

    public static ActionExtra click(int i, int i6) {
        return new ActionExtra(i, i6);
    }

    public static ActionExtra doubleClick(int i, int i6) {
        return new ActionExtra(i, i6);
    }

    public static ActionExtra longClick(int i, int i6, long j5) {
        return new ActionExtra(i, i6, j5);
    }

    public static ActionExtra replaceText(int i, int i6, int i10, int i11, String str, long j5) {
        return new ActionExtra(i, i6, i10, i11, j5, str);
    }

    public static ActionExtra setText(int i, int i6, String str) {
        return new ActionExtra(i, i6, str);
    }

    public static ActionExtra swipe(int i, int i6, int i10, int i11, long j5) {
        return new ActionExtra(i, i6, i10, i11, j5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getContent() {
        return this.content;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getTextEnd() {
        return this.toY;
    }

    public long getTextNodeId() {
        return this.duration;
    }

    public int getTextStart() {
        return this.toX;
    }

    public int getToX() {
        return this.toX;
    }

    public int getToY() {
        return this.toY;
    }

    public int getX() {
        return this.f2997x;
    }

    public int getY() {
        return this.y;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ActionExtra{x=");
        sb.append(this.f2997x);
        sb.append(", y=");
        sb.append(this.y);
        sb.append(", toX=");
        sb.append(this.toX);
        sb.append(", toY=");
        sb.append(this.toY);
        sb.append(", duration=");
        sb.append(this.duration);
        sb.append(", content='");
        return a.q(sb, this.content, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2997x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.toX);
        parcel.writeInt(this.toY);
        parcel.writeLong(this.duration);
        parcel.writeString(this.content);
    }

    public ActionExtra(int i, int i6, long j5) {
        this(i, i6, i, i6, j5, null);
    }

    public ActionExtra(int i, int i6, int i10, int i11, long j5) {
        this(i, i6, i10, i11, j5, null);
    }

    public ActionExtra(int i, int i6, @Nullable String str) {
        this(i, i6, i, i6, 0L, str);
    }

    public ActionExtra(int i, int i6, int i10, int i11, long j5, @Nullable String str) {
        this.f2997x = i;
        this.y = i6;
        this.toX = i10;
        this.toY = i11;
        this.duration = j5;
        this.content = str;
    }

    public ActionExtra(Parcel parcel) {
        this.f2997x = parcel.readInt();
        this.y = parcel.readInt();
        this.toX = parcel.readInt();
        this.toY = parcel.readInt();
        this.duration = parcel.readLong();
        this.content = parcel.readString();
    }
}
