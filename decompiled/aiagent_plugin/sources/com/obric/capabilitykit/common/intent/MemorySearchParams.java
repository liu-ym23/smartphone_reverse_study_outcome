package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: MemorySearchParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MemorySearchParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<MemorySearchParams> CREATOR = null;
    private String extras;
    private String toolParams;

    /* JADX INFO: compiled from: MemorySearchParams.kt */
    public static final class Creator implements Parcelable.Creator<MemorySearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MemorySearchParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            MemorySearchParams r1 = new MemorySearchParams(r5.readString(), r5.readString());
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
        public /* bridge */ /* synthetic */ MemorySearchParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MemorySearchParams[] newArray(int r1) {
            return new MemorySearchParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemorySearchParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MemorySearchParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MemorySearchParams copy$default(MemorySearchParams r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.toolParams;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.extras;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.toolParams;
    }

    public final String component2() {
        return this.extras;
    }

    public final MemorySearchParams copy(String r1, String r2) {
        return new MemorySearchParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MemorySearchParams.class) == true) goto L8;
        return false;
    L8:
        MemorySearchParams r6 = (MemorySearchParams) ZeusTransformUtils.preCheckCast(r5, MemorySearchParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.toolParams, r6.toolParams) == true) goto L12;
        return false;
    L12:
        if (o.a(this.extras, r6.extras) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.toolParams;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.extras;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MemorySearchParams(toolParams=" + this.toolParams + ", extras=" + this.extras + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.toolParams);
        r1.writeString(this.extras);
    }

    public MemorySearchParams(String r1, String r2) {
        this.toolParams = r1;
        this.extras = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ MemorySearchParams(String r2, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getToolParams() {
        return this.toolParams;
    }

    public final void setToolParams(String r1) {
        this.toolParams = r1;
    }

    public final String getExtras() {
        return this.extras;
    }

    public final void setExtras(String r1) {
        this.extras = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.toolParams == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, MemorySearchParams.class) == false) goto L5;
        String r1 = this.toolParams;
        if (r1 != null) goto L9;
        r1 = ((MemorySearchParams) ZeusTransformUtils.preCheckCast(r4, MemorySearchParams.class, "com.obric.aiagent.plugin")).toolParams;
    L9:
        String r3 = this.extras;
        if (r3 != null) goto L13;
        r3 = ((MemorySearchParams) ZeusTransformUtils.preCheckCast(r4, MemorySearchParams.class, "com.obric.aiagent.plugin")).extras;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new MemorySearchParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
