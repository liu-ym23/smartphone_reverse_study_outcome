package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import d.h.b.o;

/* JADX INFO: loaded from: classes3.dex */
public final class Empty implements Parcelable, IntentParams {
    public static final Parcelable.Creator<Empty> CREATOR = null;

    public static final class a implements Parcelable.Creator<Empty> {
        public a() {
        }

        public final Empty a(Parcel r1) {
            o.e(r1, "parcel");
            r1.readInt();
            return new Empty();
        }

        public final Empty[] a(int r1) {
            return new Empty[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ Empty createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ Empty[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public Empty() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r1) {
        return IntentParams.a.a(this, r1);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "out");
        r1.writeInt(1);
    }
}
