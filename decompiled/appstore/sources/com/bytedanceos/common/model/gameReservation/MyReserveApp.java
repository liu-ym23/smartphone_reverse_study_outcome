package com.bytedanceos.common.model.gameReservation;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.networkv2.entity.BaseInfo;

/* JADX INFO: loaded from: classes2.dex */
public class MyReserveApp extends GameReservationData implements BaseInfo {
    public static final Parcelable.Creator<MyReserveApp> CREATOR = null;
    public String mGameCategory;
    public String mGameName;
    public String mGameOnlineTime;
    public int mGameState;
    public String mUrl;

    static {
        CREATOR = new AnonymousClass1();
    }

    public MyReserveApp() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.bytedanceos.common.networkv2.entity.BaseInfo
    public String getCategory() {
        return this.mGameCategory;
    }

    @Override // com.bytedanceos.common.networkv2.entity.BaseInfo
    public String getId() {
        return this.mAppId;
    }

    @Override // com.bytedanceos.common.networkv2.entity.BaseInfo
    public String getName() {
        return this.mGameName;
    }

    @Override // com.bytedanceos.common.networkv2.entity.BaseInfo
    public String getOnline_time() {
        return this.mGameOnlineTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.mDataType);
        r10.writeString(this.mAppId);
        r10.writeString(this.mUrl);
        r10.writeString(this.mGameName);
        r10.writeString(this.mGameOnlineTime);
        r10.writeString(this.mGameCategory);
        r10.writeInt(this.mGameState);
    }

    public MyReserveApp(Parcel r10) {
        this.mDataType = r10.readInt();
        this.mAppId = r10.readString();
        this.mUrl = r10.readString();
        this.mGameName = r10.readString();
        this.mGameOnlineTime = r10.readString();
        this.mGameCategory = r10.readString();
        this.mGameState = r10.readInt();
    }
}
