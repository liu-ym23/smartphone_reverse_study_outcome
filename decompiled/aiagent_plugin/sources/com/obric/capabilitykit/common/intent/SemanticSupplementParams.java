package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SemanticSupplementParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SemanticSupplementParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SemanticSupplementParams> CREATOR = null;
    private String queryId;
    private Integer type;

    /* JADX INFO: compiled from: SemanticSupplementParams.kt */
    public static final class Creator implements Parcelable.Creator<SemanticSupplementParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SemanticSupplementParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            String r2 = r5.readString();
            if (r5.readInt() != 0) goto L5;
            Integer r3 = null;
        L6:
            SemanticSupplementParams r1 = new SemanticSupplementParams(r2, r3);
            int r4 = Math.min(r0, 0);
            ClassLoader r6 = getClass().getClassLoader();
            int r7 = 1;
        L7:
            if (r7 > r4) goto L9;
            r7 = r7 + 1;
        L9:
            if (r7 > r0) goto L11;
            a.a(r5, r6);
            r7 = r7 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r3 = Integer.valueOf(r5.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SemanticSupplementParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SemanticSupplementParams[] newArray(int r1) {
            return new SemanticSupplementParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SemanticSupplementParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SemanticSupplementParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SemanticSupplementParams copy$default(SemanticSupplementParams r0, String r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.queryId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.queryId;
    }

    public final Integer component2() {
        return this.type;
    }

    public final SemanticSupplementParams copy(String r1, Integer r2) {
        return new SemanticSupplementParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SemanticSupplementParams.class) == true) goto L8;
        return false;
    L8:
        SemanticSupplementParams r6 = (SemanticSupplementParams) ZeusTransformUtils.preCheckCast(r5, SemanticSupplementParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.queryId, r6.queryId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.type, r6.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.queryId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.type;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SemanticSupplementParams(queryId=" + this.queryId + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        o.e(r2, "out");
        r2.writeString(this.queryId);
        Integer r1 = this.type;
        if (r1 != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        r2.writeInt(1);
        r2.writeInt(r1.intValue());
    }

    public SemanticSupplementParams(String r1, Integer r2) {
        this.queryId = r1;
        this.type = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ SemanticSupplementParams(String r2, Integer r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public final void setQueryId(String r1) {
        this.queryId = r1;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer r1) {
        this.type = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SemanticSupplementParams.class) == false) goto L5;
        String r1 = this.queryId;
        if (r1 != null) goto L9;
        r1 = ((SemanticSupplementParams) ZeusTransformUtils.preCheckCast(r4, SemanticSupplementParams.class, "com.obric.aiagent.plugin")).queryId;
    L9:
        Integer r3 = this.type;
        if (r3 != null) goto L13;
        r3 = ((SemanticSupplementParams) ZeusTransformUtils.preCheckCast(r4, SemanticSupplementParams.class, "com.obric.aiagent.plugin")).type;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SemanticSupplementParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
