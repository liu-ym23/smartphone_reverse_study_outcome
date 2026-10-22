package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OTaskTimeoutConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OTaskTimeoutConfig implements Parcelable {
    public static final Parcelable.Creator<OTaskTimeoutConfig> CREATOR = null;
    private final long complexTaskTimeout;
    private final long oAutoTaskTimeout;
    private final long simpleTaskTimeout;

    /* JADX INFO: compiled from: OTaskTimeoutConfig.kt */
    public static final class Creator implements Parcelable.Creator<OTaskTimeoutConfig> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OTaskTimeoutConfig createFromParcel(Parcel r8) {
            o.e(r8, "parcel");
            return new OTaskTimeoutConfig(r8.readLong(), r8.readLong(), r8.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OTaskTimeoutConfig createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OTaskTimeoutConfig[] newArray(int r1) {
            return new OTaskTimeoutConfig[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OTaskTimeoutConfig[] newArray(int r1) {
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
        r3.writeLong(this.oAutoTaskTimeout);
        r3.writeLong(this.complexTaskTimeout);
        r3.writeLong(this.simpleTaskTimeout);
    }

    public OTaskTimeoutConfig(long r1, long r3, long r5) {
        this.oAutoTaskTimeout = r1;
        this.complexTaskTimeout = r3;
        this.simpleTaskTimeout = r5;
    }

    public final long getOAutoTaskTimeout() {
        return this.oAutoTaskTimeout;
    }

    public final long getComplexTaskTimeout() {
        return this.complexTaskTimeout;
    }

    public final long getSimpleTaskTimeout() {
        return this.simpleTaskTimeout;
    }
}
