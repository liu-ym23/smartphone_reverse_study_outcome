package com.obric.funcall_api.bean;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IntentAppAction.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AppAction {

    @SerializedName("OperationId")
    private final String action;

    @SerializedName("Intent")
    private final String intent;

    @SerializedName("Package")
    private final String packageName;

    @SerializedName("Params")
    private final String params;

    @SerializedName("ShortcutId")
    private final String shortcutId;

    @SerializedName("LocalToolType")
    private final int type;

    public AppAction() {
        this(null, null, null, null, 0, null, 63, null);
    }

    public static /* synthetic */ AppAction copy$default(AppAction r4, String r5, String r6, String r7, String r8, int r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.packageName;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.action;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.params;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.intent;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.type;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.shortcutId;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.action;
    }

    public final String component3() {
        return this.params;
    }

    public final String component4() {
        return this.intent;
    }

    public final int component5() {
        return this.type;
    }

    public final String component6() {
        return this.shortcutId;
    }

    public final AppAction copy(String r8, String r9, String r10, String r11, int r12, String r13) {
        return new AppAction(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppAction.class) == true) goto L8;
        return false;
    L8:
        AppAction r6 = (AppAction) ZeusTransformUtils.preCheckCast(r5, AppAction.class, "com.obric.aiagent.plugin");
        if (o.a(this.packageName, r6.packageName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.action, r6.action) == true) goto L15;
        return false;
    L15:
        if (o.a(this.params, r6.params) == true) goto L18;
        return false;
    L18:
        if (o.a(this.intent, r6.intent) == true) goto L21;
        return false;
    L21:
        if (this.type == r6.type) goto L24;
        return false;
    L24:
        if (o.a(this.shortcutId, r6.shortcutId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.packageName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.action;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.params;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.intent;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + Integer.hashCode(this.type)) * 31;
        String r13 = this.shortcutId;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppAction(packageName=" + this.packageName + ", action=" + this.action + ", params=" + this.params + ", intent=" + this.intent + ", type=" + this.type + ", shortcutId=" + this.shortcutId + ')';
    }

    public AppAction(String r1, String r2, String r3, String r4, int r5, String r6) {
        this.packageName = r1;
        this.action = r2;
        this.params = r3;
        this.intent = r4;
        this.type = r5;
        this.shortcutId = r6;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getParams() {
        return this.params;
    }

    public final String getIntent() {
        return this.intent;
    }

    public final int getType() {
        return this.type;
    }

    public /* synthetic */ AppAction(String r2, String r3, String r4, String r5, int r6, String r7, int r8, h r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = ToolType.APP.ordinal();
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        this(r2, r3, r4, r5, r6, r7);
    }

    public final String getShortcutId() {
        return this.shortcutId;
    }
}
