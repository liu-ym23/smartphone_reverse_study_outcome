package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\r\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J?\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\f\b\u0002\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\"HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/execution/IntentExecutionRecord;", "Landroid/os/Parcelable;", "intentName", "", "implPackage", "implClassName", "result", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "requiresAuthorization", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/IntentResult;Z)V", "getImplClassName", "()Ljava/lang/String;", "setImplClassName", "(Ljava/lang/String;)V", "getImplPackage", "setImplPackage", "getIntentName", "setIntentName", "getRequiresAuthorization", "()Z", "setRequiresAuthorization", "(Z)V", "getResult", "()Lcom/obric/capabilitykit/common/intent/IntentResult;", "setResult", "(Lcom/obric/capabilitykit/common/intent/IntentResult;)V", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IntentExecutionRecord implements Parcelable {
    public static final Parcelable.Creator<IntentExecutionRecord> CREATOR = null;
    private String implClassName;
    private String implPackage;
    private String intentName;
    private boolean requiresAuthorization;
    private IntentResult<?> result;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<IntentExecutionRecord> {
        public a() {
        }

        public final IntentExecutionRecord a(Parcel r10) {
            int r9 = r10.readInt();
            Intrinsics.checkNotNullParameter(r10, "parcel");
            String r2 = r10.readString();
            String r3 = r10.readString();
            String r4 = r10.readString();
            IntentResult r5 = (IntentResult) r10.readParcelable(IntentExecutionRecord.class.getClassLoader());
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
            ParcelUtils.skipValueSafely(r10, r7);
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
        public /* bridge */ /* synthetic */ IntentExecutionRecord createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentExecutionRecord[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public IntentExecutionRecord(String r2, String r3, String r4, IntentResult<?> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "intentName");
        Intrinsics.checkNotNullParameter(r3, "implPackage");
        Intrinsics.checkNotNullParameter(r4, "implClassName");
        Intrinsics.checkNotNullParameter(r5, "result");
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
        Intrinsics.checkNotNullParameter(r7, "intentName");
        Intrinsics.checkNotNullParameter(r8, "implPackage");
        Intrinsics.checkNotNullParameter(r9, "implClassName");
        Intrinsics.checkNotNullParameter(r10, "result");
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
        if ((r5 instanceof IntentExecutionRecord) == true) goto L8;
        return false;
    L8:
        IntentExecutionRecord r6 = (IntentExecutionRecord) r5;
        if (Intrinsics.areEqual(this.intentName, r6.intentName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.implPackage, r6.implPackage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.implClassName, r6.implClassName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.result, r6.result) == true) goto L21;
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
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.implClassName = r2;
    }

    public final void setImplPackage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.implPackage = r2;
    }

    public final void setIntentName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.intentName = r2;
    }

    public final void setRequiresAuthorization(boolean r1) {
        this.requiresAuthorization = r1;
    }

    public final void setResult(IntentResult<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.result = r2;
    }

    public String toString() {
        return "IntentExecutionRecord(intentName=" + this.intentName + ", implPackage=" + this.implPackage + ", implClassName=" + this.implClassName + ", result=" + this.result + ", requiresAuthorization=" + this.requiresAuthorization + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeString(this.intentName);
        r2.writeString(this.implPackage);
        r2.writeString(this.implClassName);
        r2.writeParcelable(this.result, r3);
        r2.writeInt(this.requiresAuthorization ? 1 : 0);
    }
}
