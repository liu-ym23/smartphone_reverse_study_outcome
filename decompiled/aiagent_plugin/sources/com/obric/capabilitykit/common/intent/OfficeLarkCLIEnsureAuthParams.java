package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: OfficeLarkCLIEnsureAuthParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OfficeLarkCLIEnsureAuthParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<OfficeLarkCLIEnsureAuthParams> CREATOR = null;
    private String reason;
    private String[] scopes;

    /* JADX INFO: compiled from: OfficeLarkCLIEnsureAuthParams.kt */
    public static final class Creator implements Parcelable.Creator<OfficeLarkCLIEnsureAuthParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeLarkCLIEnsureAuthParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            o.e(r5, "parcel");
            OfficeLarkCLIEnsureAuthParams r1 = new OfficeLarkCLIEnsureAuthParams(r5.readString(), r5.createStringArray());
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
        public /* bridge */ /* synthetic */ OfficeLarkCLIEnsureAuthParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeLarkCLIEnsureAuthParams[] newArray(int r1) {
            return new OfficeLarkCLIEnsureAuthParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeLarkCLIEnsureAuthParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeLarkCLIEnsureAuthParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OfficeLarkCLIEnsureAuthParams copy$default(OfficeLarkCLIEnsureAuthParams r0, String r1, String[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.reason;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.scopes;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.reason;
    }

    public final String[] component2() {
        return this.scopes;
    }

    public final OfficeLarkCLIEnsureAuthParams copy(String r1, String[] r2) {
        return new OfficeLarkCLIEnsureAuthParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OfficeLarkCLIEnsureAuthParams.class) == true) goto L8;
        return false;
    L8:
        OfficeLarkCLIEnsureAuthParams r6 = (OfficeLarkCLIEnsureAuthParams) ZeusTransformUtils.preCheckCast(r5, OfficeLarkCLIEnsureAuthParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.reason, r6.reason) == true) goto L12;
        return false;
    L12:
        if (o.a(this.scopes, r6.scopes) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.reason;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String[] r4 = this.scopes;
        if (r4 == null) goto L11;
        r1 = Arrays.hashCode(r4);
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OfficeLarkCLIEnsureAuthParams(reason=" + this.reason + ", scopes=" + Arrays.toString(this.scopes) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.reason);
        r1.writeStringArray(this.scopes);
    }

    public OfficeLarkCLIEnsureAuthParams(String r1, String[] r2) {
        this.reason = r1;
        this.scopes = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ OfficeLarkCLIEnsureAuthParams(String r2, String[] r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getReason() {
        return this.reason;
    }

    public final void setReason(String r1) {
        this.reason = r1;
    }

    public final String[] getScopes() {
        return this.scopes;
    }

    public final void setScopes(String[] r1) {
        this.scopes = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, OfficeLarkCLIEnsureAuthParams.class) == false) goto L5;
        String r1 = this.reason;
        if (r1 != null) goto L9;
        r1 = ((OfficeLarkCLIEnsureAuthParams) ZeusTransformUtils.preCheckCast(r4, OfficeLarkCLIEnsureAuthParams.class, "com.obric.aiagent.plugin")).reason;
    L9:
        String[] r3 = this.scopes;
        if (r3 != null) goto L13;
        r3 = ((OfficeLarkCLIEnsureAuthParams) ZeusTransformUtils.preCheckCast(r4, OfficeLarkCLIEnsureAuthParams.class, "com.obric.aiagent.plugin")).scopes;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new OfficeLarkCLIEnsureAuthParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
