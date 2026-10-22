package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SystemLocationRequestParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemLocationRequestParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemLocationRequestParams> CREATOR = null;
    private Boolean needHighPrecision;
    private Long timeout;

    /* JADX INFO: compiled from: SystemLocationRequestParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemLocationRequestParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemLocationRequestParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            o.e(r9, "parcel");
            Long r4 = null;
            int r5 = 1;
            if (r9.readInt() != 0) goto L6;
            Boolean r2 = null;
        L11:
            if (r9.readInt() == 0) goto L14;
            r4 = Long.valueOf(r9.readLong());
        L14:
            SystemLocationRequestParams r1 = new SystemLocationRequestParams(r2, r4);
            int r3 = Math.min(r0, 0);
            ClassLoader r8 = getClass().getClassLoader();
        L15:
            if (r5 > r3) goto L17;
            r5 = r5 + 1;
        L17:
            if (r5 > r0) goto L19;
            a.a(r9, r8);
            r5 = r5 + 1;
            goto L17
        L19:
            return r1;
        L6:
            if (r9.readInt() == 0) goto L8;
            boolean r6 = true;
        L9:
            r2 = Boolean.valueOf(r6);
            goto L11
        L8:
            r6 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemLocationRequestParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemLocationRequestParams[] newArray(int r1) {
            return new SystemLocationRequestParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemLocationRequestParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemLocationRequestParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemLocationRequestParams copy$default(SystemLocationRequestParams r0, Boolean r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.needHighPrecision;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.timeout;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.needHighPrecision;
    }

    public final Long component2() {
        return this.timeout;
    }

    public final SystemLocationRequestParams copy(Boolean r1, Long r2) {
        return new SystemLocationRequestParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemLocationRequestParams.class) == true) goto L8;
        return false;
    L8:
        SystemLocationRequestParams r6 = (SystemLocationRequestParams) ZeusTransformUtils.preCheckCast(r5, SystemLocationRequestParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.needHighPrecision, r6.needHighPrecision) == true) goto L12;
        return false;
    L12:
        if (o.a(this.timeout, r6.timeout) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.needHighPrecision;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.timeout;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemLocationRequestParams(needHighPrecision=" + this.needHighPrecision + ", timeout=" + this.timeout + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        o.e(r3, "out");
        Boolean r0 = this.needHighPrecision;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        Long r2 = this.timeout;
        if (r2 != null) goto L9;
        r3.writeInt(0);
        return;
    L9:
        r3.writeInt(1);
        r3.writeLong(r2.longValue());
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.booleanValue() ? 1 : 0);
        goto L6
    }

    public SystemLocationRequestParams(Boolean r1, Long r2) {
        this.needHighPrecision = r1;
        this.timeout = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ SystemLocationRequestParams(Boolean r2, Long r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final Boolean getNeedHighPrecision() {
        return this.needHighPrecision;
    }

    public final void setNeedHighPrecision(Boolean r1) {
        this.needHighPrecision = r1;
    }

    public final Long getTimeout() {
        return this.timeout;
    }

    public final void setTimeout(Long r1) {
        this.timeout = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SystemLocationRequestParams.class) == false) goto L5;
        Boolean r1 = this.needHighPrecision;
        if (r1 != null) goto L9;
        r1 = ((SystemLocationRequestParams) ZeusTransformUtils.preCheckCast(r4, SystemLocationRequestParams.class, "com.obric.aiagent.plugin")).needHighPrecision;
    L9:
        Long r3 = this.timeout;
        if (r3 != null) goto L13;
        r3 = ((SystemLocationRequestParams) ZeusTransformUtils.preCheckCast(r4, SystemLocationRequestParams.class, "com.obric.aiagent.plugin")).timeout;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemLocationRequestParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
