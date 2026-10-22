package com.obric.memorydata.sdk.entity.search.oauto;

import android.os.Parcel;
import android.os.Parcelable;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OAutoSearchResult.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OAutoSearchResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final String entitiesJson;
    private final int errorCode;
    private final String errorMsg;

    /* JADX INFO: compiled from: OAutoSearchResult.kt */
    public static final class CREATOR implements Parcelable.Creator<OAutoSearchResult> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OAutoSearchResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OAutoSearchResult[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OAutoSearchResult createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new OAutoSearchResult(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OAutoSearchResult[] newArray(int r1) {
            return new OAutoSearchResult[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public OAutoSearchResult(int r1, String r2, String r3) {
        this.errorCode = r1;
        this.errorMsg = r2;
        this.entitiesJson = r3;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getEntitiesJson() {
        return this.entitiesJson;
    }

    public final boolean isSuccess() {
        if (this.errorCode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public OAutoSearchResult(Parcel r3) {
        o.e(r3, "parcel");
        this(r3.readInt(), r3.readString(), r3.readString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeInt(this.errorCode);
        r1.writeString(this.errorMsg);
        r1.writeString(this.entitiesJson);
    }
}
