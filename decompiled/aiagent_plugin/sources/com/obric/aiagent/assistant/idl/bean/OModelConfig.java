package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OModelConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OModelConfig implements Parcelable {
    public static final Parcelable.Creator<OModelConfig> CREATOR = null;
    private final String intentModel;
    private final String pcSearchModel;
    private final long queryWithPicTimeout;

    /* JADX INFO: compiled from: OModelConfig.kt */
    public static final class Creator implements Parcelable.Creator<OModelConfig> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OModelConfig createFromParcel(Parcel r5) {
            o.e(r5, "parcel");
            return new OModelConfig(r5.readString(), r5.readString(), r5.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OModelConfig createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OModelConfig[] newArray(int r1) {
            return new OModelConfig[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OModelConfig[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeString(this.intentModel);
        r3.writeString(this.pcSearchModel);
        r3.writeLong(this.queryWithPicTimeout);
    }

    public OModelConfig(String r2, String r3, long r4) {
        o.e(r2, "intentModel");
        o.e(r3, "pcSearchModel");
        this.intentModel = r2;
        this.pcSearchModel = r3;
        this.queryWithPicTimeout = r4;
    }

    public final String getIntentModel() {
        return this.intentModel;
    }

    public final String getPcSearchModel() {
        return this.pcSearchModel;
    }

    public final long getQueryWithPicTimeout() {
        return this.queryWithPicTimeout;
    }
}
