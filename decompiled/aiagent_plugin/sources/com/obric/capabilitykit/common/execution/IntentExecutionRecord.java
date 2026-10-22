package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: loaded from: classes3.dex */
public final class IntentExecutionRecord implements Parcelable {
    public static final Parcelable.Creator<IntentExecutionRecord> CREATOR = null;
    private String implClassName;
    private String implPackage;
    private String intentName;
    private boolean requiresAuthorization;
    private IntentResult<?> result;

    public static final class a implements Parcelable.Creator<IntentExecutionRecord> {
        public a() {
        }

        public final IntentExecutionRecord a(Parcel r10) {
            int r9 = r10.readInt();
            o.e(r10, "parcel");
            String r2 = r10.readString();
            String r3 = r10.readString();
            String r4 = r10.readString();
            IntentResult r5 = (IntentResult) ZeusTransformUtils.preCheckCast(r10.readParcelable(IntentExecutionRecord.class.getClassLoader()), IntentResult.class, "com.obric.aiagent.plugin");
            int r8 = 1;
            if (r10.readInt() == 0) goto L5;
            boolean r6 = true;
        L6:
            IntentExecutionRecord r0 = new IntentExecutionRecord(r2, r3, r4, r5, r6);
            int r1 = Math.min(r9, 0);
            ClassLoader r7 = a.class.getClassLoader();
        L7:
            if (r8 > r1) goto L9;
            r8 = r8 + 1;
        L9:
            if (r8 > r9) goto L11;
            com.obric.a.a.a(r10, r7);
            r8 = r8 + 1;
            goto L9
        L11:
            return r0;
        L5:
            r6 = false;
            goto L6
        }

        public final IntentExecutionRecord[] a(int r1) {
            return new IntentExecutionRecord[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ IntentExecutionRecord createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ IntentExecutionRecord[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public IntentExecutionRecord(String r2, String r3, String r4, IntentResult<?> r5, boolean r6) {
        o.e(r2, "intentName");
        o.e(r3, "implPackage");
        o.e(r4, "implClassName");
        o.e(r5, "result");
        this.intentName = r2;
        this.implPackage = r3;
        this.implClassName = r4;
        this.result = r5;
        this.requiresAuthorization = r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IntentExecutionRecord copy$default(IntentExecutionRecord r3, String r4, String r5, String r6, IntentResult r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.intentName;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.implPackage;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.implClassName;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.result;
    L14:
        IntentResult r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.requiresAuthorization;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.intentName;
    }

    public final String component2() {
        return this.implPackage;
    }

    public final String component3() {
        return this.implClassName;
    }

    public final IntentResult<?> component4() {
        return this.result;
    }

    public final boolean component5() {
        return this.requiresAuthorization;
    }

    public final IntentExecutionRecord copy(String r7, String r8, String r9, IntentResult<?> r10, boolean r11) {
        o.e(r7, "intentName");
        o.e(r8, "implPackage");
        o.e(r9, "implClassName");
        o.e(r10, "result");
        return new IntentExecutionRecord(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IntentExecutionRecord.class) == true) goto L8;
        return false;
    L8:
        IntentExecutionRecord r6 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r5, IntentExecutionRecord.class, "com.obric.aiagent.plugin");
        if (o.a(this.intentName, r6.intentName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.implPackage, r6.implPackage) == true) goto L15;
        return false;
    L15:
        if (o.a(this.implClassName, r6.implClassName) == true) goto L18;
        return false;
    L18:
        if (o.a(this.result, r6.result) == true) goto L21;
        return false;
    L21:
        if (this.requiresAuthorization == r6.requiresAuthorization) goto L23;
        return false;
    L23:
        return true;
    }

    public final String getImplClassName() {
        return this.implClassName;
    }

    public final String getImplPackage() {
        return this.implPackage;
    }

    public final String getIntentName() {
        return this.intentName;
    }

    public final boolean getRequiresAuthorization() {
        return this.requiresAuthorization;
    }

    public final IntentResult<?> getResult() {
        return this.result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r0 = ((((((this.intentName.hashCode() * 31) + this.implPackage.hashCode()) * 31) + this.implClassName.hashCode()) * 31) + this.result.hashCode()) * 31;
        boolean r2 = this.requiresAuthorization;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r0 + r3;
    }

    public final void setImplClassName(String r2) {
        o.e(r2, "<set-?>");
        this.implClassName = r2;
    }

    public final void setImplPackage(String r2) {
        o.e(r2, "<set-?>");
        this.implPackage = r2;
    }

    public final void setIntentName(String r2) {
        o.e(r2, "<set-?>");
        this.intentName = r2;
    }

    public final void setRequiresAuthorization(boolean r1) {
        this.requiresAuthorization = r1;
    }

    public final void setResult(IntentResult<?> r2) {
        o.e(r2, "<set-?>");
        this.result = r2;
    }

    public String toString() {
        return "IntentExecutionRecord(intentName=" + this.intentName + ", implPackage=" + this.implPackage + ", implClassName=" + this.implClassName + ", result=" + this.result + ", requiresAuthorization=" + this.requiresAuthorization + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        o.e(r2, "out");
        r2.writeString(this.intentName);
        r2.writeString(this.implPackage);
        r2.writeString(this.implClassName);
        r2.writeParcelable(this.result, r3);
        r2.writeInt(this.requiresAuthorization ? 1 : 0);
    }
}
