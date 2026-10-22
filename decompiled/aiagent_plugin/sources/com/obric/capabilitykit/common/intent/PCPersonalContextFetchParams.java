package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: PCPersonalContextFetchParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PCPersonalContextFetchParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<PCPersonalContextFetchParams> CREATOR = null;
    private AppEntity[] entities;

    /* JADX INFO: compiled from: PCPersonalContextFetchParams.kt */
    public static final class Creator implements Parcelable.Creator<PCPersonalContextFetchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCPersonalContextFetchParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            o.e(r9, "parcel");
            if (r9.readInt() != 0) goto L5;
            AppEntity[] r1 = null;
        L9:
            PCPersonalContextFetchParams r3 = new PCPersonalContextFetchParams(r1);
            int r2 = Math.min(r0, 0);
            ClassLoader r8 = getClass().getClassLoader();
            int r4 = 1;
        L10:
            if (r4 > r2) goto L12;
            r4 = r4 + 1;
        L12:
            if (r4 > r0) goto L14;
            a.a(r9, r8);
            r4 = r4 + 1;
            goto L12
        L14:
            return r3;
        L5:
            int r5 = r9.readInt();
            AppEntity[] r6 = new AppEntity[r5];
            int r7 = 0;
        L6:
            if (r7 == r5) goto L8;
            r6[r7] = (AppEntity) ZeusTransformUtils.preCheckCast(r9.readParcelable(PCPersonalContextFetchParams.class.getClassLoader()), AppEntity.class, "com.obric.aiagent.plugin");
            r7 = r7 + 1;
            goto L6
        L8:
            r1 = r6;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCPersonalContextFetchParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCPersonalContextFetchParams[] newArray(int r1) {
            return new PCPersonalContextFetchParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCPersonalContextFetchParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PCPersonalContextFetchParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PCPersonalContextFetchParams copy$default(PCPersonalContextFetchParams r0, AppEntity[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.entities;
    L6:
        return r0.copy(r1);
    }

    public final AppEntity[] component1() {
        return this.entities;
    }

    public final PCPersonalContextFetchParams copy(AppEntity[] r1) {
        return new PCPersonalContextFetchParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PCPersonalContextFetchParams.class) == true) goto L8;
        return false;
    L8:
        PCPersonalContextFetchParams r6 = (PCPersonalContextFetchParams) ZeusTransformUtils.preCheckCast(r5, PCPersonalContextFetchParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.entities, r6.entities) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        AppEntity[] r0 = this.entities;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r0);
    }

    public String toString() {
        return "PCPersonalContextFetchParams(entities=" + Arrays.toString(this.entities) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        int r0 = 0;
        r6.writeInt(0);
        o.e(r6, "out");
        AppEntity[] r5 = this.entities;
        if (r5 != null) goto L5;
        r6.writeInt(0);
        return;
    L5:
        r6.writeInt(1);
        int r1 = r5.length;
        r6.writeInt(r1);
    L6:
        if (r0 == r1) goto L10;
        r6.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r5[r0], Parcelable.class, "com.obric.aiagent.plugin"), r7);
        r0 = r0 + 1;
        goto L6
    }

    public PCPersonalContextFetchParams(AppEntity[] r1) {
        this.entities = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ PCPersonalContextFetchParams(AppEntity[] r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final AppEntity[] getEntities() {
        return this.entities;
    }

    public final void setEntities(AppEntity[] r1) {
        this.entities = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.entities == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, PCPersonalContextFetchParams.class) == false) goto L5;
        AppEntity[] r3 = this.entities;
        if (r3 != null) goto L10;
        r3 = ((PCPersonalContextFetchParams) ZeusTransformUtils.preCheckCast(r4, PCPersonalContextFetchParams.class, "com.obric.aiagent.plugin")).entities;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PCPersonalContextFetchParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
