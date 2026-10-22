package com.bytedanceos.common.networkv2.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class Head implements Parcelable {
    public static final Parcelable.Creator<Head> CREATOR = null;
    private String code;
    private boolean first_yyb;
    private boolean has_more;
    private String message;

    static {
        CREATOR = new AnonymousClass1();
    }

    public Head() {
        this.code = "";
        this.message = "";
        this.has_more = false;
        this.first_yyb = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean hasMore() {
        return this.has_more;
    }

    public boolean isFirstYyb() {
        return this.first_yyb;
    }

    public void setCode(String r10) {
        this.code = r10;
    }

    public void setFirstYyb(boolean r10) {
        this.first_yyb = r10;
    }

    public void setHasMore(boolean r10) {
        this.has_more = r10;
    }

    public void setMessage(String r10) {
        this.message = r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeString(this.code);
        r10.writeString(this.message);
        r10.writeByte(this.has_more ? 1 : 0);
        r10.writeByte(this.first_yyb ? 1 : 0);
    }

    public Head(Parcel r10) {
        this.code = "";
        this.message = "";
        boolean r11 = false;
        this.has_more = false;
        this.first_yyb = false;
        this.code = r10.readString();
        this.message = r10.readString();
        if (r10.readByte() == 0) goto L5;
        boolean r12 = true;
    L6:
        this.has_more = r12;
        if (r10.readByte() == 0) goto L9;
        r11 = true;
    L9:
        this.first_yyb = r11;
        return;
    L5:
        r12 = false;
        goto L6
    }
}
