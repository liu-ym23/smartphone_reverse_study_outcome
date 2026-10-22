package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.VersionedParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00012\b\u0010!\u001a\u0004\u0018\u00010\u001dH\u0016J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006("}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemStopActionParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "questionId", "", "intentName", "actionId", "reason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionId", "()Ljava/lang/String;", "setActionId", "(Ljava/lang/String;)V", "getIntentName", "setIntentName", "getQuestionId", "setQuestionId", "getReason", "setReason", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class SystemStopActionParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<SystemStopActionParams> CREATOR = null;

    @Nullable
    private String actionId;

    @Nullable
    private String intentName;

    @Nullable
    private String questionId;

    @Nullable
    private String reason;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemStopActionParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemStopActionParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            SystemStopActionParams r12 = new SystemStopActionParams(r10.readString(), r10.readString(), r10.readString(), r10.readString());
            int r13 = Math.min(r11, 0);
            ClassLoader r14 = Creator.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r13) goto L5;
            r15 = r15 + 1;
        L5:
            if (r15 > r11) goto L7;
            a.d(r10, r14);
            r15 = r15 + 1;
            goto L5
        L7:
            return r12;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemStopActionParams[] newArray(int r10) {
            return new SystemStopActionParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemStopActionParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemStopActionParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SystemStopActionParams() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        this(r10, r11, r12, r13, 15, null);
    }

    public static /* synthetic */ SystemStopActionParams copy$default(SystemStopActionParams r10, String r11, String r12, String r13, String r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.questionId;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.intentName;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.actionId;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.reason;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @Nullable
    public final String component1() {
        return this.questionId;
    }

    @Nullable
    public final String component2() {
        return this.intentName;
    }

    @Nullable
    public final String component3() {
        return this.actionId;
    }

    @Nullable
    public final String component4() {
        return this.reason;
    }

    @NotNull
    public final SystemStopActionParams copy(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13) {
        return new SystemStopActionParams(r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemStopActionParams) == true) goto L8;
        return false;
    L8:
        SystemStopActionParams r11 = (SystemStopActionParams) r10;
        if (q.b(this.questionId, r11.questionId) == true) goto L12;
        return false;
    L12:
        if (q.b(this.intentName, r11.intentName) == true) goto L15;
        return false;
    L15:
        if (q.b(this.actionId, r11.actionId) == true) goto L18;
        return false;
    L18:
        if (q.b(this.reason, r11.reason) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final String getActionId() {
        return this.actionId;
    }

    @Nullable
    public final String getIntentName() {
        return this.intentName;
    }

    @Nullable
    public final String getQuestionId() {
        return this.questionId;
    }

    @Nullable
    public final String getReason() {
        return this.reason;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        String r10 = this.questionId;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.intentName;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.actionId;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.reason;
        if (r20 == null) goto L19;
        r11 = r20.hashCode();
    L19:
        return r19 + r11;
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.reason == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof SystemStopActionParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.questionId;
        if (r11 != null) goto L8;
        r11 = ((SystemStopActionParams) r10).questionId;
    L8:
        String r12 = this.intentName;
        if (r12 != null) goto L11;
        r12 = ((SystemStopActionParams) r10).intentName;
    L11:
        String r13 = this.actionId;
        if (r13 != null) goto L14;
        r13 = ((SystemStopActionParams) r10).actionId;
    L14:
        String r14 = this.reason;
        if (r14 != null) goto L18;
        r14 = ((SystemStopActionParams) r10).reason;
    L18:
        return new SystemStopActionParams(r11, r12, r13, r14);
    }

    public final void setActionId(@Nullable String r10) {
        this.actionId = r10;
    }

    public final void setIntentName(@Nullable String r10) {
        this.intentName = r10;
    }

    public final void setQuestionId(@Nullable String r10) {
        this.questionId = r10;
    }

    public final void setReason(@Nullable String r10) {
        this.reason = r10;
    }

    @NotNull
    public String toString() {
        return "SystemStopActionParams(questionId=" + this.questionId + ", intentName=" + this.intentName + ", actionId=" + this.actionId + ", reason=" + this.reason + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.questionId);
        r10.writeString(this.intentName);
        r10.writeString(this.actionId);
        r10.writeString(this.reason);
    }

    public SystemStopActionParams(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13) {
        this.questionId = r10;
        this.intentName = r11;
        this.actionId = r12;
        this.reason = r13;
    }

    public /* synthetic */ SystemStopActionParams(String r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
