package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.versionedparcelable.AddField;
import com.obric.versionedparcelable.VersionedParcelable;
import com.ttnet.org.chromium.net.PrivateKeyType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001eJn\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00103J\t\u00104\u001a\u000205HÖ\u0001J\u0013\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\n\u00109\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010:\u001a\u000205HÖ\u0001J\u0012\u0010;\u001a\u00020\u00012\b\u0010<\u001a\u0004\u0018\u000108H\u0016J\t\u0010=\u001a\u00020\u0004HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u000205HÖ\u0001R&\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R&\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R(\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R&\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u000f\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemAutoActionParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", ServerElements.GAME_GIFT_INSTUCTION, "", "taskId", "taskScenario", "sourceFrom", "assistantHistory", "executionMode", "meta", "requestAuth", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAssistantHistory$annotations", "()V", "getAssistantHistory", "()Ljava/lang/String;", "setAssistantHistory", "(Ljava/lang/String;)V", "getExecutionMode$annotations", "getExecutionMode", "setExecutionMode", "getInstruction", "setInstruction", "getMeta$annotations", "getMeta", "setMeta", "getRequestAuth$annotations", "getRequestAuth", "()Ljava/lang/Boolean;", "setRequestAuth", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSourceFrom$annotations", "getSourceFrom", "setSourceFrom", "getTaskId", "setTaskId", "getTaskScenario$annotations", "getTaskScenario", "setTaskScenario", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/SystemAutoActionParams;", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getSubActionValue", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class SystemAutoActionParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<SystemAutoActionParams> CREATOR = null;

    @AddField
    @Nullable
    String assistantHistory;

    @AddField
    @Nullable
    String executionMode;

    @Nullable
    private String instruction;

    @AddField
    @Nullable
    String meta;

    @AddField
    @Nullable
    Boolean requestAuth;

    @AddField
    @Nullable
    String sourceFrom;

    @Nullable
    private String taskId;

    @AddField
    @Nullable
    String taskScenario;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemAutoActionParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemAutoActionParams createFromParcel(@NotNull Parcel r13) {
            int r12 = r13.readInt();
            q.g(r13, "parcel");
            SystemAutoActionParams r10 = new SystemAutoActionParams(r13.readString(), r13.readString(), null, null, null, null, null, null, 252, null);
            int r11 = Math.min(r12, 6);
            ClassLoader r14 = Creator.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r11) goto L33;
            if (r15 != 1) goto L9;
            Object r16 = a.c(r13, r14);
            if (r16 == null) goto L32;
            r10.taskScenario = (String) r16;
        L32:
            r15 = r15 + 1;
            goto L3
        L9:
            if (r15 != 2) goto L14;
            Object r17 = a.c(r13, r14);
            if (r17 == null) goto L32;
            r10.sourceFrom = (String) r17;
            goto L32
        L14:
            if (r15 != 3) goto L19;
            Object r18 = a.c(r13, r14);
            if (r18 == null) goto L32;
            r10.assistantHistory = (String) r18;
            goto L32
        L19:
            if (r15 != 4) goto L24;
            Object r19 = a.c(r13, r14);
            if (r19 == null) goto L32;
            r10.executionMode = (String) r19;
            goto L32
        L24:
            if (r15 != 5) goto L28;
            Object r20 = a.c(r13, r14);
            if (r20 == null) goto L32;
            r10.meta = (String) r20;
            goto L32
        L28:
            if (r15 != 6) goto L32;
            Object r21 = a.c(r13, r14);
            if (r21 == null) goto L32;
            r10.requestAuth = (Boolean) r21;
        L33:
            if (r15 > r12) goto L35;
            a.d(r13, r14);
            r15 = r15 + 1;
            goto L33
        L35:
            return r10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemAutoActionParams[] newArray(int r10) {
            return new SystemAutoActionParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemAutoActionParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemAutoActionParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SystemAutoActionParams() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        String r16 = null;
        Boolean r17 = null;
        this(r10, r11, r12, r13, r14, r15, r16, r17, PrivateKeyType.INVALID, null);
    }

    public static /* synthetic */ SystemAutoActionParams copy$default(SystemAutoActionParams r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, Boolean r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r20 = r10.instruction;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r21 = r10.taskId;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r22 = r10.taskScenario;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r23 = r10.sourceFrom;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r24 = r10.assistantHistory;
    L23:
        if ((r19 & 32) == 0) goto L25;
        String r25 = r10.executionMode;
    L27:
        if ((r19 & 64) == 0) goto L29;
        String r26 = r10.meta;
    L31:
        if ((r19 & 128) == 0) goto L33;
        Boolean r27 = r10.requestAuth;
    L35:
        return r10.copy(r20, r21, r22, r23, r24, r25, r26, r27);
    L33:
        r27 = r18;
        goto L35
    L29:
        r26 = r17;
        goto L31
    L25:
        r25 = r16;
        goto L27
    L21:
        r24 = r15;
        goto L23
    L17:
        r23 = r14;
        goto L19
    L13:
        r22 = r13;
        goto L15
    L9:
        r21 = r12;
        goto L11
    L5:
        r20 = r11;
        goto L7
    }

    public static /* synthetic */ void getAssistantHistory$annotations() {
    }

    public static /* synthetic */ void getExecutionMode$annotations() {
    }

    public static /* synthetic */ void getMeta$annotations() {
    }

    public static /* synthetic */ void getRequestAuth$annotations() {
    }

    public static /* synthetic */ void getSourceFrom$annotations() {
    }

    public static /* synthetic */ void getTaskScenario$annotations() {
    }

    @Nullable
    public final String component1() {
        return this.instruction;
    }

    @Nullable
    public final String component2() {
        return this.taskId;
    }

    @Nullable
    public final String component3() {
        return this.taskScenario;
    }

    @Nullable
    public final String component4() {
        return this.sourceFrom;
    }

    @Nullable
    public final String component5() {
        return this.assistantHistory;
    }

    @Nullable
    public final String component6() {
        return this.executionMode;
    }

    @Nullable
    public final String component7() {
        return this.meta;
    }

    @Nullable
    public final Boolean component8() {
        return this.requestAuth;
    }

    @NotNull
    public final SystemAutoActionParams copy(@Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable String r14, @Nullable String r15, @Nullable String r16, @Nullable String r17, @Nullable Boolean r18) {
        return new SystemAutoActionParams(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemAutoActionParams) == true) goto L8;
        return false;
    L8:
        SystemAutoActionParams r11 = (SystemAutoActionParams) r10;
        if (q.b(this.instruction, r11.instruction) == true) goto L12;
        return false;
    L12:
        if (q.b(this.taskId, r11.taskId) == true) goto L15;
        return false;
    L15:
        if (q.b(this.taskScenario, r11.taskScenario) == true) goto L18;
        return false;
    L18:
        if (q.b(this.sourceFrom, r11.sourceFrom) == true) goto L21;
        return false;
    L21:
        if (q.b(this.assistantHistory, r11.assistantHistory) == true) goto L24;
        return false;
    L24:
        if (q.b(this.executionMode, r11.executionMode) == true) goto L27;
        return false;
    L27:
        if (q.b(this.meta, r11.meta) == true) goto L30;
        return false;
    L30:
        if (q.b(this.requestAuth, r11.requestAuth) == true) goto L32;
        return false;
    L32:
        return true;
    }

    @Nullable
    public final String getAssistantHistory() {
        return this.assistantHistory;
    }

    @Nullable
    public final String getExecutionMode() {
        return this.executionMode;
    }

    @Nullable
    public final String getInstruction() {
        return this.instruction;
    }

    @Nullable
    public final String getMeta() {
        return this.meta;
    }

    @Nullable
    public final Boolean getRequestAuth() {
        return this.requestAuth;
    }

    @Nullable
    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        Boolean r10 = this.requestAuth;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.toString();
    }

    @Nullable
    public final String getTaskId() {
        return this.taskId;
    }

    @Nullable
    public final String getTaskScenario() {
        return this.taskScenario;
    }

    public int hashCode() {
        String r10 = this.instruction;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.taskId;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.taskScenario;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.sourceFrom;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.assistantHistory;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.executionMode;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        String r29 = this.meta;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        Boolean r32 = this.requestAuth;
        if (r32 == null) goto L35;
        r11 = r32.hashCode();
    L35:
        return r31 + r11;
    L29:
        r30 = r29.hashCode();
        goto L30
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
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
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r11) {
        if ((r11 instanceof SystemAutoActionParams) == true) goto L5;
        return this;
    L5:
        String r10 = this.instruction;
        if (r10 != null) goto L8;
        r10 = ((SystemAutoActionParams) r11).instruction;
    L8:
        String r12 = r10;
        String r13 = this.taskId;
        if (r13 != null) goto L11;
        r13 = ((SystemAutoActionParams) r11).taskId;
    L11:
        String r14 = r13;
        String r15 = this.taskScenario;
        if (r15 != null) goto L14;
        r15 = ((SystemAutoActionParams) r11).taskScenario;
    L14:
        String r16 = r15;
        String r17 = this.sourceFrom;
        if (r17 != null) goto L17;
        r17 = ((SystemAutoActionParams) r11).sourceFrom;
    L17:
        String r18 = r17;
        String r19 = this.assistantHistory;
        if (r19 != null) goto L20;
        r19 = ((SystemAutoActionParams) r11).assistantHistory;
    L20:
        String r20 = r19;
        String r21 = this.executionMode;
        if (r21 != null) goto L23;
        r21 = ((SystemAutoActionParams) r11).executionMode;
    L23:
        String r22 = r21;
        String r23 = this.meta;
        if (r23 != null) goto L26;
        r23 = ((SystemAutoActionParams) r11).meta;
    L26:
        String r24 = r23;
        Boolean r110 = this.requestAuth;
        if (r110 != null) goto L30;
        r110 = ((SystemAutoActionParams) r11).requestAuth;
    L30:
        return new SystemAutoActionParams(r12, r14, r16, r18, r20, r22, r24, r110);
    }

    public final void setAssistantHistory(@Nullable String r10) {
        this.assistantHistory = r10;
    }

    public final void setExecutionMode(@Nullable String r10) {
        this.executionMode = r10;
    }

    public final void setInstruction(@Nullable String r10) {
        this.instruction = r10;
    }

    public final void setMeta(@Nullable String r10) {
        this.meta = r10;
    }

    public final void setRequestAuth(@Nullable Boolean r10) {
        this.requestAuth = r10;
    }

    public final void setSourceFrom(@Nullable String r10) {
        this.sourceFrom = r10;
    }

    public final void setTaskId(@Nullable String r10) {
        this.taskId = r10;
    }

    public final void setTaskScenario(@Nullable String r10) {
        this.taskScenario = r10;
    }

    @NotNull
    public String toString() {
        return "SystemAutoActionParams(instruction=" + this.instruction + ", taskId=" + this.taskId + ", taskScenario=" + this.taskScenario + ", sourceFrom=" + this.sourceFrom + ", assistantHistory=" + this.assistantHistory + ", executionMode=" + this.executionMode + ", meta=" + this.meta + ", requestAuth=" + this.requestAuth + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(6);
        q.g(r10, "out");
        r10.writeString(this.instruction);
        r10.writeString(this.taskId);
        r10.writeValue(this.taskScenario);
        r10.writeValue(this.sourceFrom);
        r10.writeValue(this.assistantHistory);
        r10.writeValue(this.executionMode);
        r10.writeValue(this.meta);
        r10.writeValue(this.requestAuth);
    }

    public SystemAutoActionParams(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable String r14, @Nullable String r15, @Nullable String r16, @Nullable Boolean r17) {
        this.instruction = r10;
        this.taskId = r11;
        this.taskScenario = r12;
        this.sourceFrom = r13;
        this.assistantHistory = r14;
        this.executionMode = r15;
        this.meta = r16;
        this.requestAuth = r17;
    }

    public /* synthetic */ SystemAutoActionParams(String r10, String r11, String r12, String r13, String r14, String r15, String r16, Boolean r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r18 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r18 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r18 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r18 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r18 & 32) == 0) goto L21;
        r15 = null;
    L21:
        if ((r18 & 64) == 0) goto L24;
        r16 = null;
    L24:
        if ((r18 & 128) == 0) goto L26;
        r17 = null;
    L26:
        this(r10, r11, r12, r13, r14, r15, r16, r17);
    }
}
