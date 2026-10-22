package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: PCSearchAppEntityParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PCSearchAppEntityParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<PCSearchAppEntityParams> CREATOR = null;
    String[] domains;
    private String interactionType;
    private String quResult;

    /* JADX INFO: compiled from: PCSearchAppEntityParams.kt */
    public static final class Creator implements Parcelable.Creator<PCSearchAppEntityParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCSearchAppEntityParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            o.e(r9, "parcel");
            PCSearchAppEntityParams r1 = new PCSearchAppEntityParams(r9.readString(), r9.readString(), null, 4, null);
            int r3 = Math.min(r0, 1);
            ClassLoader r8 = getClass().getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r3) goto L9;
            if (r4 != 1) goto L8;
            Object r5 = a.b(r9, r8);
            if (r5 == null) goto L8;
            r1.domains = (String[]) ZeusTransformUtils.preCheckCast(r5, String[].class, "com.obric.aiagent.plugin");
        L8:
            r4 = r4 + 1;
        L9:
            if (r4 > r0) goto L11;
            a.a(r9, r8);
            r4 = r4 + 1;
            goto L9
        L11:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCSearchAppEntityParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCSearchAppEntityParams[] newArray(int r1) {
            return new PCSearchAppEntityParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCSearchAppEntityParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public PCSearchAppEntityParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PCSearchAppEntityParams copy$default(PCSearchAppEntityParams r0, String r1, String r2, String[] r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.quResult;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.interactionType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.domains;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public static /* synthetic */ void getDomains$annotations() {
    }

    public final String component1() {
        return this.quResult;
    }

    public final String component2() {
        return this.interactionType;
    }

    public final String[] component3() {
        return this.domains;
    }

    public final PCSearchAppEntityParams copy(String r1, String r2, String[] r3) {
        return new PCSearchAppEntityParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PCSearchAppEntityParams.class) == true) goto L8;
        return false;
    L8:
        PCSearchAppEntityParams r6 = (PCSearchAppEntityParams) ZeusTransformUtils.preCheckCast(r5, PCSearchAppEntityParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.quResult, r6.quResult) == true) goto L12;
        return false;
    L12:
        if (o.a(this.interactionType, r6.interactionType) == true) goto L15;
        return false;
    L15:
        if (o.a(this.domains, r6.domains) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.quResult;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.interactionType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String[] r7 = this.domains;
        if (r7 == null) goto L15;
        r1 = Arrays.hashCode(r7);
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
        return "PCSearchAppEntityParams(quResult=" + this.quResult + ", interactionType=" + this.interactionType + ", domains=" + Arrays.toString(this.domains) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(1);
        o.e(r1, "out");
        r1.writeString(this.quResult);
        r1.writeString(this.interactionType);
        r1.writeValue(this.domains);
    }

    public PCSearchAppEntityParams(String r1, String r2, String[] r3) {
        this.quResult = r1;
        this.interactionType = r2;
        this.domains = r3;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ PCSearchAppEntityParams(String r2, String r3, String[] r4, int r5, h r6) {
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

    public final String getQuResult() {
        return this.quResult;
    }

    public final void setQuResult(String r1) {
        this.quResult = r1;
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final void setInteractionType(String r1) {
        this.interactionType = r1;
    }

    public final String[] getDomains() {
        return this.domains;
    }

    public final void setDomains(String[] r1) {
        this.domains = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, PCSearchAppEntityParams.class) == false) goto L5;
        String r1 = this.quResult;
        if (r1 != null) goto L9;
        r1 = ((PCSearchAppEntityParams) ZeusTransformUtils.preCheckCast(r5, PCSearchAppEntityParams.class, "com.obric.aiagent.plugin")).quResult;
    L9:
        String r3 = this.interactionType;
        if (r3 != null) goto L12;
        r3 = ((PCSearchAppEntityParams) ZeusTransformUtils.preCheckCast(r5, PCSearchAppEntityParams.class, "com.obric.aiagent.plugin")).interactionType;
    L12:
        String[] r4 = this.domains;
        if (r4 != null) goto L16;
        r4 = ((PCSearchAppEntityParams) ZeusTransformUtils.preCheckCast(r5, PCSearchAppEntityParams.class, "com.obric.aiagent.plugin")).domains;
    L16:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PCSearchAppEntityParams(r1, r3, r4), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        String[] r0 = this.domains;
        if (r0 != null) goto L7;
        return null;
    L7:
        return i.a(r0, null, null, null, 0, null, null, 63, null);
    }
}
