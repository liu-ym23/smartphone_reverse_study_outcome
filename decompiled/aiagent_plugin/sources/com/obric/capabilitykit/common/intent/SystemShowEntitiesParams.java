package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: SystemShowEntitiesParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemShowEntitiesParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemShowEntitiesParams> CREATOR = null;
    private String[] entities;
    private String message;

    /* JADX INFO: compiled from: SystemShowEntitiesParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemShowEntitiesParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemShowEntitiesParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            SystemShowEntitiesParams r1 = new SystemShowEntitiesParams(r5.readString(), r5.createStringArray());
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
        public /* bridge */ /* synthetic */ SystemShowEntitiesParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemShowEntitiesParams[] newArray(int r1) {
            return new SystemShowEntitiesParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemShowEntitiesParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemShowEntitiesParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemShowEntitiesParams copy$default(SystemShowEntitiesParams r0, String r1, String[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.message;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.entities;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.message;
    }

    public final String[] component2() {
        return this.entities;
    }

    public final SystemShowEntitiesParams copy(String r1, String[] r2) {
        return new SystemShowEntitiesParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemShowEntitiesParams.class) == true) goto L8;
        return false;
    L8:
        SystemShowEntitiesParams r6 = (SystemShowEntitiesParams) ZeusTransformUtils.preCheckCast(r5, SystemShowEntitiesParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.message, r6.message) == true) goto L12;
        return false;
    L12:
        if (o.a(this.entities, r6.entities) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.message;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String[] r4 = this.entities;
        if (r4 == null) goto L11;
        r1 = Arrays.hashCode(r4);
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemShowEntitiesParams(message=" + this.message + ", entities=" + Arrays.toString(this.entities) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.message);
        r1.writeStringArray(this.entities);
    }

    public SystemShowEntitiesParams(String r1, String[] r2) {
        this.message = r1;
        this.entities = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ SystemShowEntitiesParams(String r2, String[] r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public final String[] getEntities() {
        return this.entities;
    }

    public final void setEntities(String[] r1) {
        this.entities = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.message == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SystemShowEntitiesParams.class) == false) goto L5;
        String r1 = this.message;
        if (r1 != null) goto L9;
        r1 = ((SystemShowEntitiesParams) ZeusTransformUtils.preCheckCast(r4, SystemShowEntitiesParams.class, "com.obric.aiagent.plugin")).message;
    L9:
        String[] r3 = this.entities;
        if (r3 != null) goto L13;
        r3 = ((SystemShowEntitiesParams) ZeusTransformUtils.preCheckCast(r4, SystemShowEntitiesParams.class, "com.obric.aiagent.plugin")).entities;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemShowEntitiesParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
