package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PCPersonalContextSearchParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PCPersonalContextSearchParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<PCPersonalContextSearchParams> CREATOR = null;
    private String interactionType;
    String memoryScene;
    private String originQuery;
    private String searchParams;

    /* JADX INFO: compiled from: PCPersonalContextSearchParams.kt */
    public static final class Creator implements Parcelable.Creator<PCPersonalContextSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCPersonalContextSearchParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            PCPersonalContextSearchParams r1 = new PCPersonalContextSearchParams(r10.readString(), r10.readString(), r10.readString(), null, 8, null);
            int r3 = Math.min(r0, 1);
            ClassLoader r9 = getClass().getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r3) goto L9;
            if (r4 != 1) goto L8;
            Object r5 = a.b(r10, r9);
            if (r5 == null) goto L8;
            r1.memoryScene = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        L8:
            r4 = r4 + 1;
        L9:
            if (r4 > r0) goto L11;
            a.a(r10, r9);
            r4 = r4 + 1;
            goto L9
        L11:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCPersonalContextSearchParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCPersonalContextSearchParams[] newArray(int r1) {
            return new PCPersonalContextSearchParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCPersonalContextSearchParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public PCPersonalContextSearchParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PCPersonalContextSearchParams copy$default(PCPersonalContextSearchParams r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.originQuery;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.searchParams;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.interactionType;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.memoryScene;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public static /* synthetic */ void getMemoryScene$annotations() {
    }

    public final String component1() {
        return this.originQuery;
    }

    public final String component2() {
        return this.searchParams;
    }

    public final String component3() {
        return this.interactionType;
    }

    public final String component4() {
        return this.memoryScene;
    }

    public final PCPersonalContextSearchParams copy(String r1, String r2, String r3, String r4) {
        return new PCPersonalContextSearchParams(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PCPersonalContextSearchParams.class) == true) goto L8;
        return false;
    L8:
        PCPersonalContextSearchParams r6 = (PCPersonalContextSearchParams) ZeusTransformUtils.preCheckCast(r5, PCPersonalContextSearchParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.originQuery, r6.originQuery) == true) goto L12;
        return false;
    L12:
        if (o.a(this.searchParams, r6.searchParams) == true) goto L15;
        return false;
    L15:
        if (o.a(this.interactionType, r6.interactionType) == true) goto L18;
        return false;
    L18:
        if (o.a(this.memoryScene, r6.memoryScene) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.originQuery;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.searchParams;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.interactionType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.memoryScene;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PCPersonalContextSearchParams(originQuery=" + this.originQuery + ", searchParams=" + this.searchParams + ", interactionType=" + this.interactionType + ", memoryScene=" + this.memoryScene + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(1);
        o.e(r1, "out");
        r1.writeString(this.originQuery);
        r1.writeString(this.searchParams);
        r1.writeString(this.interactionType);
        r1.writeValue(this.memoryScene);
    }

    public PCPersonalContextSearchParams(String r1, String r2, String r3, String r4) {
        this.originQuery = r1;
        this.searchParams = r2;
        this.interactionType = r3;
        this.memoryScene = r4;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ PCPersonalContextSearchParams(String r2, String r3, String r4, String r5, int r6, h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final String getOriginQuery() {
        return this.originQuery;
    }

    public final void setOriginQuery(String r1) {
        this.originQuery = r1;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public final void setSearchParams(String r1) {
        this.searchParams = r1;
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final void setInteractionType(String r1) {
        this.interactionType = r1;
    }

    public final String getMemoryScene() {
        return this.memoryScene;
    }

    public final void setMemoryScene(String r1) {
        this.memoryScene = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.originQuery != null) goto L5;
    L7:
        return false;
    L5:
        if (this.searchParams == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, PCPersonalContextSearchParams.class) == false) goto L5;
        String r1 = this.originQuery;
        if (r1 != null) goto L9;
        r1 = ((PCPersonalContextSearchParams) ZeusTransformUtils.preCheckCast(r6, PCPersonalContextSearchParams.class, "com.obric.aiagent.plugin")).originQuery;
    L9:
        String r3 = this.searchParams;
        if (r3 != null) goto L12;
        r3 = ((PCPersonalContextSearchParams) ZeusTransformUtils.preCheckCast(r6, PCPersonalContextSearchParams.class, "com.obric.aiagent.plugin")).searchParams;
    L12:
        String r4 = this.interactionType;
        if (r4 != null) goto L15;
        r4 = ((PCPersonalContextSearchParams) ZeusTransformUtils.preCheckCast(r6, PCPersonalContextSearchParams.class, "com.obric.aiagent.plugin")).interactionType;
    L15:
        String r5 = this.memoryScene;
        if (r5 != null) goto L19;
        r5 = ((PCPersonalContextSearchParams) ZeusTransformUtils.preCheckCast(r6, PCPersonalContextSearchParams.class, "com.obric.aiagent.plugin")).memoryScene;
    L19:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PCPersonalContextSearchParams(r1, r3, r4, r5), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
