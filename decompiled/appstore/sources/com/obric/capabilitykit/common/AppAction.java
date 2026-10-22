package com.obric.capabilitykit.common;

import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jy\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\bHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/AppAction;", "", "packageName", "", "action", "params", MemorySourceLinkType.INTENT, "type", "", "shortcutId", "interfaceName", "targetPkgName", "logPb", "implClassName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getImplClassName", "getIntent", "getInterfaceName", "getLogPb", "getPackageName", "getParams", "setParams", "(Ljava/lang/String;)V", "getShortcutId", "getTargetPkgName", "getType", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppAction {

    @SerializedName("OperationId")
    @NotNull
    private final String action;

    @Nullable
    private final String implClassName;

    @SerializedName("Intent")
    @Nullable
    private final String intent;

    @Nullable
    private final String interfaceName;

    @Nullable
    private final String logPb;

    @SerializedName("Package")
    @NotNull
    private final String packageName;

    @SerializedName("Params")
    @NotNull
    private String params;

    @SerializedName("ShortcutId")
    @Nullable
    private final String shortcutId;

    @Nullable
    private final String targetPkgName;

    @SerializedName("LocalToolType")
    private final int type;

    public AppAction(@NotNull String r10, @NotNull String r11, @NotNull String r12, @Nullable String r13, int r14, @Nullable String r15, @Nullable String r16, @Nullable String r17, @Nullable String r18, @Nullable String r19) {
        kotlin.jvm.internal.q.g(r10, "packageName");
        kotlin.jvm.internal.q.g(r11, "action");
        kotlin.jvm.internal.q.g(r12, "params");
        this.packageName = r10;
        this.action = r11;
        this.params = r12;
        this.intent = r13;
        this.type = r14;
        this.shortcutId = r15;
        this.interfaceName = r16;
        this.targetPkgName = r17;
        this.logPb = r18;
        this.implClassName = r19;
    }

    public static /* synthetic */ AppAction copy$default(AppAction r11, String r12, String r13, String r14, String r15, int r16, String r17, String r18, String r19, String r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r10 = r11.packageName;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r24 = r11.action;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r25 = r11.params;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r26 = r11.intent;
    L19:
        if ((r22 & 16) == 0) goto L21;
        int r27 = r11.type;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r28 = r11.shortcutId;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r29 = r11.interfaceName;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r30 = r11.targetPkgName;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r110 = r11.logPb;
    L39:
        if ((r22 & 512) == 0) goto L41;
        String r31 = r11.implClassName;
    L43:
        return r11.copy(r10, r24, r25, r26, r27, r28, r29, r30, r110, r31);
    L41:
        r31 = r21;
        goto L43
    L37:
        r110 = r20;
        goto L39
    L33:
        r30 = r19;
        goto L35
    L29:
        r29 = r18;
        goto L31
    L25:
        r28 = r17;
        goto L27
    L21:
        r27 = r16;
        goto L23
    L17:
        r26 = r15;
        goto L19
    L13:
        r25 = r14;
        goto L15
    L9:
        r24 = r13;
        goto L11
    L5:
        r10 = r12;
        goto L7
    }

    @NotNull
    public final String component1() {
        return this.packageName;
    }

    @Nullable
    public final String component10() {
        return this.implClassName;
    }

    @NotNull
    public final String component2() {
        return this.action;
    }

    @NotNull
    public final String component3() {
        return this.params;
    }

    @Nullable
    public final String component4() {
        return this.intent;
    }

    public final int component5() {
        return this.type;
    }

    @Nullable
    public final String component6() {
        return this.shortcutId;
    }

    @Nullable
    public final String component7() {
        return this.interfaceName;
    }

    @Nullable
    public final String component8() {
        return this.targetPkgName;
    }

    @Nullable
    public final String component9() {
        return this.logPb;
    }

    @NotNull
    public final AppAction copy(@NotNull String r13, @NotNull String r14, @NotNull String r15, @Nullable String r16, int r17, @Nullable String r18, @Nullable String r19, @Nullable String r20, @Nullable String r21, @Nullable String r22) {
        kotlin.jvm.internal.q.g(r13, "packageName");
        kotlin.jvm.internal.q.g(r14, "action");
        kotlin.jvm.internal.q.g(r15, "params");
        return new AppAction(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppAction) == true) goto L8;
        return false;
    L8:
        AppAction r11 = (AppAction) r10;
        if (kotlin.jvm.internal.q.b(this.packageName, r11.packageName) == true) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.action, r11.action) == true) goto L15;
        return false;
    L15:
        if (kotlin.jvm.internal.q.b(this.params, r11.params) == true) goto L18;
        return false;
    L18:
        if (kotlin.jvm.internal.q.b(this.intent, r11.intent) == true) goto L21;
        return false;
    L21:
        if (this.type == r11.type) goto L24;
        return false;
    L24:
        if (kotlin.jvm.internal.q.b(this.shortcutId, r11.shortcutId) == true) goto L27;
        return false;
    L27:
        if (kotlin.jvm.internal.q.b(this.interfaceName, r11.interfaceName) == true) goto L30;
        return false;
    L30:
        if (kotlin.jvm.internal.q.b(this.targetPkgName, r11.targetPkgName) == true) goto L33;
        return false;
    L33:
        if (kotlin.jvm.internal.q.b(this.logPb, r11.logPb) == true) goto L36;
        return false;
    L36:
        if (kotlin.jvm.internal.q.b(this.implClassName, r11.implClassName) == true) goto L38;
        return false;
    L38:
        return true;
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @Nullable
    public final String getImplClassName() {
        return this.implClassName;
    }

    @Nullable
    public final String getIntent() {
        return this.intent;
    }

    @Nullable
    public final String getInterfaceName() {
        return this.interfaceName;
    }

    @Nullable
    public final String getLogPb() {
        return this.logPb;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getParams() {
        return this.params;
    }

    @Nullable
    public final String getShortcutId() {
        return this.shortcutId;
    }

    @Nullable
    public final String getTargetPkgName() {
        return this.targetPkgName;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int r10 = ((((this.packageName.hashCode() * 31) + this.action.hashCode()) * 31) + this.params.hashCode()) * 31;
        String r11 = this.intent;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (((r10 + r13) * 31) + Integer.hashCode(this.type)) * 31;
        String r15 = this.shortcutId;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r14 + r16) * 31;
        String r18 = this.interfaceName;
        if (r18 != null) goto L13;
        int r19 = 0;
    L14:
        int r20 = (r17 + r19) * 31;
        String r21 = this.targetPkgName;
        if (r21 != null) goto L17;
        int r22 = 0;
    L18:
        int r23 = (r20 + r22) * 31;
        String r24 = this.logPb;
        if (r24 != null) goto L21;
        int r25 = 0;
    L22:
        int r26 = (r23 + r25) * 31;
        String r27 = this.implClassName;
        if (r27 == null) goto L27;
        r12 = r27.hashCode();
    L27:
        return r26 + r12;
    L21:
        r25 = r24.hashCode();
        goto L22
    L17:
        r22 = r21.hashCode();
        goto L18
    L13:
        r19 = r18.hashCode();
        goto L14
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final void setParams(@NotNull String r10) {
        kotlin.jvm.internal.q.g(r10, "<set-?>");
        this.params = r10;
    }

    @NotNull
    public String toString() {
        return "AppAction(packageName=" + this.packageName + ", action=" + this.action + ", params=" + this.params + ", intent=" + this.intent + ", type=" + this.type + ", shortcutId=" + this.shortcutId + ", interfaceName=" + this.interfaceName + ", targetPkgName=" + this.targetPkgName + ", logPb=" + this.logPb + ", implClassName=" + this.implClassName + ')';
    }

    public /* synthetic */ AppAction(String r15, String r16, String r17, String r18, int r19, String r20, String r21, String r22, String r23, String r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 8) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r25 & 16) == 0) goto L9;
        ToolType r11 = ToolType.UNDEF;
        int r12 = 1;
    L11:
        if ((r25 & 32) == 0) goto L13;
        String r13 = null;
    L15:
        if ((r25 & 64) == 0) goto L17;
        String r14 = null;
    L19:
        if ((r25 & 128) == 0) goto L21;
        String r110 = null;
    L23:
        if ((r25 & 256) == 0) goto L25;
        String r111 = null;
    L27:
        if ((r25 & 512) == 0) goto L29;
        String r112 = null;
    L30:
        this(r15, r16, r17, r10, r12, r13, r14, r110, r111, r112);
        return;
    L29:
        r112 = r24;
        goto L30
    L25:
        r111 = r23;
        goto L27
    L21:
        r110 = r22;
        goto L23
    L17:
        r14 = r21;
        goto L19
    L13:
        r13 = r20;
        goto L15
    L9:
        r12 = r19;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }
}
