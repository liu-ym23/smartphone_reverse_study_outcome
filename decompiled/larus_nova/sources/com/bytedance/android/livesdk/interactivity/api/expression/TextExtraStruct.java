package com.bytedance.android.livesdk.interactivity.api.expression;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public class TextExtraStruct implements Parcelable, Serializable, Cloneable {
    public static final Parcelable.Creator<TextExtraStruct> CREATOR = null;
    boolean boldText;
    int color;
    private Object customSpan;
    int end;
    public HashMap<String, Object> extraParams;
    int start;
    IBaseUser user;
    String userId;
    String webcastUid;

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

    public int hashCode() {
        String r100 = this.userId;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return 0 + r101;
    L5:
        r101 = 0;
        goto L7
    }

    public TextExtraStruct clone() {
        return (TextExtraStruct) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public TextExtraStruct() {
    }

    public int getColor() {
        return this.color;
    }

    public int getEnd() {
        return this.end;
    }

    public int getStart() {
        return this.start;
    }

    public IBaseUser getUser() {
        return this.user;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getWebcastUid() {
        return this.webcastUid;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8238clone() throws CloneNotSupportedException {
        return clone();
    }

    public TextExtraStruct(Parcel r100) {
        this.start = r100.readInt();
        this.end = r100.readInt();
        this.userId = r100.readString();
        this.webcastUid = r100.readString();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextExtraStruct) == true) goto L10;
        return false;
    L10:
        return Objects.equals(this.userId, ((TextExtraStruct) r100).userId);
    }

    public void setEnd(int r100) {
        this.end = r100;
    }

    public void setStart(int r100) {
        this.start = r100;
    }

    public void setUser(IBaseUser r100) {
        this.user = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }

    public void setWebcastUid(String r100) {
        this.webcastUid = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.start);
        r100.writeInt(this.end);
        r100.writeString(this.userId);
        r100.writeString(this.webcastUid);
    }
}
