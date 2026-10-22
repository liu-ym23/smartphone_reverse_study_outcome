package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: MemoryOperateNewParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MemoryOperateNewParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<MemoryOperateNewParams> CREATOR = null;
    private String extras;
    private String sources;
    private String toolParams;

    /* JADX INFO: compiled from: MemoryOperateNewParams.kt */
    public static final class Creator implements Parcelable.Creator<MemoryOperateNewParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MemoryOperateNewParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
            MemoryOperateNewParams r1 = new MemoryOperateNewParams(r6.readString(), r6.readString(), r6.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r5 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r6, r5);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryOperateNewParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MemoryOperateNewParams[] newArray(int r1) {
            return new MemoryOperateNewParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryOperateNewParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public MemoryOperateNewParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MemoryOperateNewParams copy$default(MemoryOperateNewParams r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.toolParams;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.sources;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.extras;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.toolParams;
    }

    public final String component2() {
        return this.sources;
    }

    public final String component3() {
        return this.extras;
    }

    public final MemoryOperateNewParams copy(String r1, String r2, String r3) {
        return new MemoryOperateNewParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MemoryOperateNewParams.class) == true) goto L8;
        return false;
    L8:
        MemoryOperateNewParams r6 = (MemoryOperateNewParams) ZeusTransformUtils.preCheckCast(r5, MemoryOperateNewParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.toolParams, r6.toolParams) == true) goto L12;
        return false;
    L12:
        if (o.a(this.sources, r6.sources) == true) goto L15;
        return false;
    L15:
        if (o.a(this.extras, r6.extras) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.toolParams;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.sources;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.extras;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MemoryOperateNewParams(toolParams=" + this.toolParams + ", sources=" + this.sources + ", extras=" + this.extras + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.toolParams);
        r1.writeString(this.sources);
        r1.writeString(this.extras);
    }

    public MemoryOperateNewParams(String r1, String r2, String r3) {
        this.toolParams = r1;
        this.sources = r2;
        this.extras = r3;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ MemoryOperateNewParams(String r2, String r3, String r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String getToolParams() {
        return this.toolParams;
    }

    public final void setToolParams(String r1) {
        this.toolParams = r1;
    }

    public final String getSources() {
        return this.sources;
    }

    public final void setSources(String r1) {
        this.sources = r1;
    }

    public final String getExtras() {
        return this.extras;
    }

    public final void setExtras(String r1) {
        this.extras = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.toolParams != null) goto L5;
    L7:
        return false;
    L5:
        if (this.sources == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, MemoryOperateNewParams.class) == false) goto L5;
        String r1 = this.toolParams;
        if (r1 != null) goto L9;
        r1 = ((MemoryOperateNewParams) ZeusTransformUtils.preCheckCast(r5, MemoryOperateNewParams.class, "com.obric.aiagent.plugin")).toolParams;
    L9:
        String r3 = this.sources;
        if (r3 != null) goto L12;
        r3 = ((MemoryOperateNewParams) ZeusTransformUtils.preCheckCast(r5, MemoryOperateNewParams.class, "com.obric.aiagent.plugin")).sources;
    L12:
        String r4 = this.extras;
        if (r4 != null) goto L16;
        r4 = ((MemoryOperateNewParams) ZeusTransformUtils.preCheckCast(r5, MemoryOperateNewParams.class, "com.obric.aiagent.plugin")).extras;
    L16:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new MemoryOperateNewParams(r1, r3, r4), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
