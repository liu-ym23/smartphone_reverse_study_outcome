package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.versionedparcelable.VersionedParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\r\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J?\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\f\b\u0002\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\"HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/execution/IntentExecutionRecord;", "Landroid/os/Parcelable;", "intentName", "", "implPackage", "implClassName", "result", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "requiresAuthorization", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/IntentResult;Z)V", "getImplClassName", "()Ljava/lang/String;", "setImplClassName", "(Ljava/lang/String;)V", "getImplPackage", "setImplPackage", "getIntentName", "setIntentName", "getRequiresAuthorization", "()Z", "setRequiresAuthorization", "(Z)V", "getResult", "()Lcom/obric/capabilitykit/common/intent/IntentResult;", "setResult", "(Lcom/obric/capabilitykit/common/intent/IntentResult;)V", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class IntentExecutionRecord implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<IntentExecutionRecord> CREATOR = null;

    @NotNull
    private String implClassName;

    @NotNull
    private String implPackage;

    @NotNull
    private String intentName;
    private boolean requiresAuthorization;

    @NotNull
    private IntentResult<?> result;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<IntentExecutionRecord> {
        public a() {
        }

        @NotNull
        public final IntentExecutionRecord a(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            String r12 = r10.readString();
            String r13 = r10.readString();
            String r14 = r10.readString();
            IntentResult r15 = (IntentResult) r10.readParcelable(IntentExecutionRecord.class.getClassLoader());
            int r16 = 1;
            if (r10.readInt() == 0) goto L5;
            boolean r17 = true;
        L6:
            IntentExecutionRecord r18 = new IntentExecutionRecord(r12, r13, r14, r15, r17);
            int r19 = Math.min(r11, 0);
            ClassLoader r20 = a.class.getClassLoader();
        L7:
            if (r16 > r19) goto L9;
            r16 = r16 + 1;
        L9:
            if (r16 > r11) goto L11;
            be.a.d(r10, r20);
            r16 = r16 + 1;
            goto L9
        L11:
            return r18;
        L5:
            r17 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentExecutionRecord createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentExecutionRecord[] newArray(int r10) {
            return a(r10);
        }

        @NotNull
        public final IntentExecutionRecord[] a(int r10) {
            return new IntentExecutionRecord[r10];
        }
    }

    static {
        CREATOR = new a();
    }

    public IntentExecutionRecord(@NotNull String r10, @NotNull String r11, @NotNull String r12, @NotNull IntentResult<?> r13, boolean r14) {
        q.g(r10, "intentName");
        q.g(r11, "implPackage");
        q.g(r12, "implClassName");
        q.g(r13, "result");
        this.intentName = r10;
        this.implPackage = r11;
        this.implClassName = r12;
        this.result = r13;
        this.requiresAuthorization = r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IntentExecutionRecord copy$default(IntentExecutionRecord r10, String r11, String r12, String r13, IntentResult r14, boolean r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.intentName;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.implPackage;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.implClassName;
    L11:
        String r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.result;
    L14:
        IntentResult r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.requiresAuthorization;
    L17:
        String r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    @NotNull
    public final String component1() {
        return this.intentName;
    }

    @NotNull
    public final String component2() {
        return this.implPackage;
    }

    @NotNull
    public final String component3() {
        return this.implClassName;
    }

    @NotNull
    public final IntentResult<?> component4() {
        return this.result;
    }

    public final boolean component5() {
        return this.requiresAuthorization;
    }

    @NotNull
    public final IntentExecutionRecord copy(@NotNull String r10, @NotNull String r11, @NotNull String r12, @NotNull IntentResult<?> r13, boolean r14) {
        q.g(r10, "intentName");
        q.g(r11, "implPackage");
        q.g(r12, "implClassName");
        q.g(r13, "result");
        return new IntentExecutionRecord(r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof IntentExecutionRecord) == true) goto L8;
        return false;
    L8:
        IntentExecutionRecord r11 = (IntentExecutionRecord) r10;
        if (q.b(this.intentName, r11.intentName) == true) goto L12;
        return false;
    L12:
        if (q.b(this.implPackage, r11.implPackage) == true) goto L15;
        return false;
    L15:
        if (q.b(this.implClassName, r11.implClassName) == true) goto L18;
        return false;
    L18:
        if (q.b(this.result, r11.result) == true) goto L21;
        return false;
    L21:
        if (this.requiresAuthorization == r11.requiresAuthorization) goto L23;
        return false;
    L23:
        return true;
    }

    @NotNull
    public final String getImplClassName() {
        return this.implClassName;
    }

    @NotNull
    public final String getImplPackage() {
        return this.implPackage;
    }

    @NotNull
    public final String getIntentName() {
        return this.intentName;
    }

    public final boolean getRequiresAuthorization() {
        return this.requiresAuthorization;
    }

    @NotNull
    public final IntentResult<?> getResult() {
        return this.result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r10 = ((((((this.intentName.hashCode() * 31) + this.implPackage.hashCode()) * 31) + this.implClassName.hashCode()) * 31) + this.result.hashCode()) * 31;
        boolean r11 = this.requiresAuthorization;
        ?? r12 = r11;
        if (r11 == false) goto L6;
        r12 = 1;
    L6:
        return r10 + r12;
    }

    public final void setImplClassName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.implClassName = r10;
    }

    public final void setImplPackage(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.implPackage = r10;
    }

    public final void setIntentName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.intentName = r10;
    }

    public final void setRequiresAuthorization(boolean r10) {
        this.requiresAuthorization = r10;
    }

    public final void setResult(@NotNull IntentResult<?> r10) {
        q.g(r10, "<set-?>");
        this.result = r10;
    }

    @NotNull
    public String toString() {
        return "IntentExecutionRecord(intentName=" + this.intentName + ", implPackage=" + this.implPackage + ", implClassName=" + this.implClassName + ", result=" + this.result + ", requiresAuthorization=" + this.requiresAuthorization + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.intentName);
        r10.writeString(this.implPackage);
        r10.writeString(this.implClassName);
        r10.writeParcelable(this.result, r11);
        r10.writeInt(this.requiresAuthorization ? 1 : 0);
    }
}
