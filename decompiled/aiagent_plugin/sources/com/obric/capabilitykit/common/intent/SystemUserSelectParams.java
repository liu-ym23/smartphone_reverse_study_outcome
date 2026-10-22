package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: SystemUserSelectParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemUserSelectParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemUserSelectParams> CREATOR = null;
    private String[] candidate;
    String sourceIntent;
    private String type;

    /* JADX INFO: compiled from: SystemUserSelectParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemUserSelectParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserSelectParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            o.e(r9, "parcel");
            SystemUserSelectParams r1 = new SystemUserSelectParams(r9.createStringArray(), r9.readString(), null, 4, null);
            int r3 = Math.min(r0, 1);
            ClassLoader r8 = getClass().getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r3) goto L9;
            if (r4 != 1) goto L8;
            Object r5 = a.b(r9, r8);
            if (r5 == null) goto L8;
            r1.sourceIntent = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
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
        public /* bridge */ /* synthetic */ SystemUserSelectParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserSelectParams[] newArray(int r1) {
            return new SystemUserSelectParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserSelectParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public SystemUserSelectParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SystemUserSelectParams copy$default(SystemUserSelectParams r0, String[] r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.candidate;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.sourceIntent;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public static /* synthetic */ void getSourceIntent$annotations() {
    }

    public final String[] component1() {
        return this.candidate;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.sourceIntent;
    }

    public final SystemUserSelectParams copy(String[] r1, String r2, String r3) {
        return new SystemUserSelectParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemUserSelectParams.class) == true) goto L8;
        return false;
    L8:
        SystemUserSelectParams r6 = (SystemUserSelectParams) ZeusTransformUtils.preCheckCast(r5, SystemUserSelectParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.candidate, r6.candidate) == true) goto L12;
        return false;
    L12:
        if (o.a(this.type, r6.type) == true) goto L15;
        return false;
    L15:
        if (o.a(this.sourceIntent, r6.sourceIntent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String[] r0 = this.candidate;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.type;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.sourceIntent;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
    }

    public String toString() {
        return "SystemUserSelectParams(candidate=" + Arrays.toString(this.candidate) + ", type=" + this.type + ", sourceIntent=" + this.sourceIntent + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(1);
        o.e(r1, "out");
        r1.writeStringArray(this.candidate);
        r1.writeString(this.type);
        r1.writeValue(this.sourceIntent);
    }

    public SystemUserSelectParams(String[] r1, String r2, String r3) {
        this.candidate = r1;
        this.type = r2;
        this.sourceIntent = r3;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ SystemUserSelectParams(String[] r2, String r3, String r4, int r5, h r6) {
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

    public final String[] getCandidate() {
        return this.candidate;
    }

    public final void setCandidate(String[] r1) {
        this.candidate = r1;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    public final String getSourceIntent() {
        return this.sourceIntent;
    }

    public final void setSourceIntent(String r1) {
        this.sourceIntent = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.candidate != null) goto L5;
    L9:
        return false;
    L5:
        if (this.type == null) goto L9;
        if (this.sourceIntent == null) goto L9;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, SystemUserSelectParams.class) == false) goto L5;
        String[] r1 = this.candidate;
        if (r1 != null) goto L9;
        r1 = ((SystemUserSelectParams) ZeusTransformUtils.preCheckCast(r5, SystemUserSelectParams.class, "com.obric.aiagent.plugin")).candidate;
    L9:
        String r3 = this.type;
        if (r3 != null) goto L12;
        r3 = ((SystemUserSelectParams) ZeusTransformUtils.preCheckCast(r5, SystemUserSelectParams.class, "com.obric.aiagent.plugin")).type;
    L12:
        String r4 = this.sourceIntent;
        if (r4 != null) goto L16;
        r4 = ((SystemUserSelectParams) ZeusTransformUtils.preCheckCast(r5, SystemUserSelectParams.class, "com.obric.aiagent.plugin")).sourceIntent;
    L16:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemUserSelectParams(r1, r3, r4), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
