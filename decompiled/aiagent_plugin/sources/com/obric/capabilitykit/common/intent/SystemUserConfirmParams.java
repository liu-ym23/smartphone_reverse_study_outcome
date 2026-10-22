package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: SystemUserConfirmParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemUserConfirmParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemUserConfirmParams> CREATOR = null;
    private String[] candidates;
    private String confirmIntent;

    /* JADX INFO: compiled from: SystemUserConfirmParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemUserConfirmParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserConfirmParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            SystemUserConfirmParams r1 = new SystemUserConfirmParams(r5.createStringArray(), r5.readString());
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
        public /* bridge */ /* synthetic */ SystemUserConfirmParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemUserConfirmParams[] newArray(int r1) {
            return new SystemUserConfirmParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserConfirmParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemUserConfirmParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemUserConfirmParams copy$default(SystemUserConfirmParams r0, String[] r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.candidates;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.confirmIntent;
    L9:
        return r0.copy(r1, r2);
    }

    public final String[] component1() {
        return this.candidates;
    }

    public final String component2() {
        return this.confirmIntent;
    }

    public final SystemUserConfirmParams copy(String[] r1, String r2) {
        return new SystemUserConfirmParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemUserConfirmParams.class) == true) goto L8;
        return false;
    L8:
        SystemUserConfirmParams r6 = (SystemUserConfirmParams) ZeusTransformUtils.preCheckCast(r5, SystemUserConfirmParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.candidates, r6.candidates) == true) goto L12;
        return false;
    L12:
        if (o.a(this.confirmIntent, r6.confirmIntent) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String[] r0 = this.candidates;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.confirmIntent;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
    }

    public String toString() {
        return "SystemUserConfirmParams(candidates=" + Arrays.toString(this.candidates) + ", confirmIntent=" + this.confirmIntent + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeStringArray(this.candidates);
        r1.writeString(this.confirmIntent);
    }

    public SystemUserConfirmParams(String[] r1, String r2) {
        this.candidates = r1;
        this.confirmIntent = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ SystemUserConfirmParams(String[] r2, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String[] getCandidates() {
        return this.candidates;
    }

    public final void setCandidates(String[] r1) {
        this.candidates = r1;
    }

    public final String getConfirmIntent() {
        return this.confirmIntent;
    }

    public final void setConfirmIntent(String r1) {
        this.confirmIntent = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SystemUserConfirmParams.class) == false) goto L5;
        String[] r1 = this.candidates;
        if (r1 != null) goto L9;
        r1 = ((SystemUserConfirmParams) ZeusTransformUtils.preCheckCast(r4, SystemUserConfirmParams.class, "com.obric.aiagent.plugin")).candidates;
    L9:
        String r3 = this.confirmIntent;
        if (r3 != null) goto L13;
        r3 = ((SystemUserConfirmParams) ZeusTransformUtils.preCheckCast(r4, SystemUserConfirmParams.class, "com.obric.aiagent.plugin")).confirmIntent;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemUserConfirmParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
