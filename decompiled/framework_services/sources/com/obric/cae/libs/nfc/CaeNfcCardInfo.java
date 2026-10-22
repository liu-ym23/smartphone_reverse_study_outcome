package com.obric.cae.libs.nfc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class CaeNfcCardInfo implements Parcelable {
    public static final Parcelable.Creator<CaeNfcCardInfo> CREATOR = null;
    public static final int LIFE_CYCLE_ACTIVE = 3841;
    public static final int LIFE_CYCLE_INACTIVE = 3840;
    public static final int LIFE_CYCLE_UNKNOWN = -1;
    private final String mCardIdentifier;
    private final int mLifeCycleState;

    public class a implements Parcelable.Creator<CaeNfcCardInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CaeNfcCardInfo createFromParcel(Parcel r2) {
            return new CaeNfcCardInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final CaeNfcCardInfo[] newArray(int r1) {
            return new CaeNfcCardInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CaeNfcCardInfo(String r1, int r2) {
        this.mCardIdentifier = r1;
        this.mLifeCycleState = r2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCardIdentifier() {
        return this.mCardIdentifier;
    }

    public int getLifeCycleState() {
        return this.mLifeCycleState;
    }

    public boolean isActive() {
        if (this.mLifeCycleState != 3841) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSwitchable() {
        int r0 = this.mLifeCycleState;
        if (r0 != 3841) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 3840) goto L8;
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mCardIdentifier);
        r1.writeInt(this.mLifeCycleState);
    }

    public CaeNfcCardInfo(Parcel r2) {
        this.mCardIdentifier = r2.readString();
        this.mLifeCycleState = r2.readInt();
    }
}
