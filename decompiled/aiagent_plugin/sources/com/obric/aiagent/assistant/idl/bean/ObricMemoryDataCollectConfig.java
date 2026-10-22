package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ObricMemoryDataCollectConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricMemoryDataCollectConfig implements Parcelable {
    public static final Parcelable.Creator<ObricMemoryDataCollectConfig> CREATOR = null;
    private final Boolean enable;

    /* JADX INFO: compiled from: ObricMemoryDataCollectConfig.kt */
    public static final class Creator implements Parcelable.Creator<ObricMemoryDataCollectConfig> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ObricMemoryDataCollectConfig createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            if (r2.readInt() != 0) goto L6;
            Boolean r3 = null;
        L11:
            return new ObricMemoryDataCollectConfig(r3);
        L6:
            if (r2.readInt() == 0) goto L8;
            boolean r4 = true;
        L9:
            r3 = Boolean.valueOf(r4);
            goto L11
        L8:
            r4 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ObricMemoryDataCollectConfig createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ObricMemoryDataCollectConfig[] newArray(int r1) {
            return new ObricMemoryDataCollectConfig[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ObricMemoryDataCollectConfig[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricMemoryDataCollectConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcel, java.lang.Object] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        Boolean r0 = this.enable;
        if (r0 != null) goto L6;
        ?? r3 = 0;
    L5:
        r1.writeInt(r3);
        return;
    L6:
        r1.writeInt(1);
        r3 = r0.booleanValue();
        goto L5
    }

    public ObricMemoryDataCollectConfig(Boolean r1) {
        this.enable = r1;
    }

    public /* synthetic */ ObricMemoryDataCollectConfig(Boolean r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }

    public final Boolean getEnable() {
        return this.enable;
    }
}
