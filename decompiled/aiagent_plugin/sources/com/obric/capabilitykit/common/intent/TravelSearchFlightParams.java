package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TravelSearchFlightParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TravelSearchFlightParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<TravelSearchFlightParams> CREATOR = null;
    private String query;

    /* JADX INFO: compiled from: TravelSearchFlightParams.kt */
    public static final class Creator implements Parcelable.Creator<TravelSearchFlightParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TravelSearchFlightParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            TravelSearchFlightParams r1 = new TravelSearchFlightParams(r5.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r4 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r5, r4);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TravelSearchFlightParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TravelSearchFlightParams[] newArray(int r1) {
            return new TravelSearchFlightParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TravelSearchFlightParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TravelSearchFlightParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TravelSearchFlightParams copy$default(TravelSearchFlightParams r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.query;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.query;
    }

    public final TravelSearchFlightParams copy(String r1) {
        return new TravelSearchFlightParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TravelSearchFlightParams.class) == true) goto L8;
        return false;
    L8:
        TravelSearchFlightParams r6 = (TravelSearchFlightParams) ZeusTransformUtils.preCheckCast(r5, TravelSearchFlightParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.query, r6.query) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.query;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "TravelSearchFlightParams(query=" + this.query + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.query);
    }

    public TravelSearchFlightParams(String r1) {
        this.query = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ TravelSearchFlightParams(String r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, TravelSearchFlightParams.class) == false) goto L5;
        String r3 = this.query;
        if (r3 != null) goto L10;
        r3 = ((TravelSearchFlightParams) ZeusTransformUtils.preCheckCast(r4, TravelSearchFlightParams.class, "com.obric.aiagent.plugin")).query;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new TravelSearchFlightParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
