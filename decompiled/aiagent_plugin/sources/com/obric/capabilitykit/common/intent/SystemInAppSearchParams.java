package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SystemInAppSearchParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SystemInAppSearchParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemInAppSearchParams> CREATOR = null;
    private String quResult;
    private String query;
    private String searchIntent;

    /* JADX INFO: compiled from: SystemInAppSearchParams.kt */
    public static final class Creator implements Parcelable.Creator<SystemInAppSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemInAppSearchParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
            SystemInAppSearchParams r1 = new SystemInAppSearchParams(r6.readString(), r6.readString(), r6.readString());
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
        public /* bridge */ /* synthetic */ SystemInAppSearchParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemInAppSearchParams[] newArray(int r1) {
            return new SystemInAppSearchParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemInAppSearchParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public SystemInAppSearchParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SystemInAppSearchParams copy$default(SystemInAppSearchParams r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.searchIntent;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.query;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.quResult;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.searchIntent;
    }

    public final String component2() {
        return this.query;
    }

    public final String component3() {
        return this.quResult;
    }

    public final SystemInAppSearchParams copy(String r1, String r2, String r3) {
        return new SystemInAppSearchParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemInAppSearchParams.class) == true) goto L8;
        return false;
    L8:
        SystemInAppSearchParams r6 = (SystemInAppSearchParams) ZeusTransformUtils.preCheckCast(r5, SystemInAppSearchParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.searchIntent, r6.searchIntent) == true) goto L12;
        return false;
    L12:
        if (o.a(this.query, r6.query) == true) goto L15;
        return false;
    L15:
        if (o.a(this.quResult, r6.quResult) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.searchIntent;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.query;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.quResult;
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
        return "SystemInAppSearchParams(searchIntent=" + this.searchIntent + ", query=" + this.query + ", quResult=" + this.quResult + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.searchIntent);
        r1.writeString(this.query);
        r1.writeString(this.quResult);
    }

    public SystemInAppSearchParams(String r1, String r2, String r3) {
        this.searchIntent = r1;
        this.query = r2;
        this.quResult = r3;
    }

    public /* synthetic */ SystemInAppSearchParams(String r2, String r3, String r4, int r5, h r6) {
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

    public final String getSearchIntent() {
        return this.searchIntent;
    }

    public final void setSearchIntent(String r1) {
        this.searchIntent = r1;
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    public final String getQuResult() {
        return this.quResult;
    }

    public final void setQuResult(String r1) {
        this.quResult = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.searchIntent != null) goto L5;
    L9:
        return false;
    L5:
        if (this.query == null) goto L9;
        if (this.quResult == null) goto L9;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, SystemInAppSearchParams.class) == false) goto L5;
        String r1 = this.searchIntent;
        if (r1 != null) goto L9;
        r1 = ((SystemInAppSearchParams) ZeusTransformUtils.preCheckCast(r5, SystemInAppSearchParams.class, "com.obric.aiagent.plugin")).searchIntent;
    L9:
        String r3 = this.query;
        if (r3 != null) goto L12;
        r3 = ((SystemInAppSearchParams) ZeusTransformUtils.preCheckCast(r5, SystemInAppSearchParams.class, "com.obric.aiagent.plugin")).query;
    L12:
        String r4 = this.quResult;
        if (r4 != null) goto L16;
        r4 = ((SystemInAppSearchParams) ZeusTransformUtils.preCheckCast(r5, SystemInAppSearchParams.class, "com.obric.aiagent.plugin")).quResult;
    L16:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new SystemInAppSearchParams(r1, r3, r4), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        String r0 = this.searchIntent;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }
}
