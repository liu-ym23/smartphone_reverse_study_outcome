package com.bytedanceos.common.networkv2.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedanceos.common.ad.param.AdReportParam;

/* JADX INFO: loaded from: classes2.dex */
public class BaseEntity extends RepBaseEntity implements Parcelable {
    public static final Parcelable.Creator<BaseEntity> CREATOR = null;
    private Head head;

    static {
        CREATOR = new AnonymousClass1();
    }

    public BaseEntity() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        Head r10 = this.head;
        if (r10 != null) goto L5;
        return "";
    L5:
        return r10.getCode();
    }

    public Head getHead() {
        return this.head;
    }

    public String getMessage() {
        Head r10 = this.head;
        if (r10 != null) goto L5;
        return "";
    L5:
        return r10.getMessage();
    }

    public boolean hasMore() {
        Head r10 = this.head;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.hasMore();
    }

    public boolean isExpired() {
        Head r10 = this.head;
        if (r10 != null) goto L5;
        return false;
    L5:
        return TextUtils.equals("410", r10.getCode());
    }

    public boolean isOk() {
        Head r10 = this.head;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (TextUtils.equals(AdReportParam.ClickPosType.SKIP, r10.getCode()) == false) goto L7;
    L8:
        return true;
    L7:
        if (TextUtils.equals("200", this.head.getCode()) == true) goto L8;
        return false;
    }

    public void setHasMore(boolean r10) {
        Head r11 = this.head;
        if (r11 == null) goto L6;
        r11.setHasMore(r10);
        return;
    }

    public void setHead(Head r10) {
        this.head = r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeParcelable(this.head, 0);
    }

    public BaseEntity(Parcel r10) {
        this.head = (Head) r10.readParcelable(Head.class.getClassLoader());
    }
}
