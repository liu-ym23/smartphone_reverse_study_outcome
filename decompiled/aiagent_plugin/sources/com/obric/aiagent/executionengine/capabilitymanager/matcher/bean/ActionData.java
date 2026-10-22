package com.obric.aiagent.executionengine.capabilitymanager.matcher.bean;

import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ActionData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ActionData {
    private final String actionName;
    private final ActionParams actionParams;
    private final List<Impl> impls;
    private final JsonObject inputParams;
    private final JsonObject outputParams;
    private final String packageName;

    public static /* synthetic */ ActionData copy$default(ActionData r7, String r8, String r9, JsonObject r10, JsonObject r11, List r12, ActionParams r13, int r14, Object r15) {
        List<Impl> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.actionName;
    L5:
        String r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = r7.packageName;
    L8:
        String r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r10 = r7.inputParams;
    L11:
        JsonObject r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r11 = r7.outputParams;
    L14:
        JsonObject r4 = r11;
        if ((r14 & 16) == 0) goto L17;
        r16 = r7.impls;
    L17:
        List<Impl> r5 = r16;
        if ((r14 & 32) == 0) goto L21;
        r13 = r7.actionParams;
    L21:
        return r7.copy(r1, r2, r3, r4, r5, r13);
    }

    public final String component1() {
        return this.actionName;
    }

    public final String component2() {
        return this.packageName;
    }

    public final JsonObject component3() {
        return this.inputParams;
    }

    public final JsonObject component4() {
        return this.outputParams;
    }

    public final List<Impl> component5() {
        return this.impls;
    }

    public final ActionParams component6() {
        return this.actionParams;
    }

    public final ActionData copy(String r8, String r9, JsonObject r10, JsonObject r11, List<Impl> r12, ActionParams r13) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "actionName");
        return new ActionData(r8, r9, r10, r11, r5, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ActionData.class) == true) goto L8;
        return false;
    L8:
        ActionData r6 = (ActionData) ZeusTransformUtils.preCheckCast(r5, ActionData.class, "com.obric.aiagent.plugin");
        if (o.a(this.actionName, r6.actionName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.packageName, r6.packageName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.inputParams, r6.inputParams) == true) goto L18;
        return false;
    L18:
        if (o.a(this.outputParams, r6.outputParams) == true) goto L21;
        return false;
    L21:
        if (o.a(this.impls, r6.impls) == true) goto L24;
        return false;
    L24:
        if (o.a(this.actionParams, r6.actionParams) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = this.actionName.hashCode() * 31;
        String r1 = this.packageName;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        JsonObject r5 = this.inputParams;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        JsonObject r8 = this.outputParams;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        List<Impl> r11 = this.impls;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        ActionParams r14 = this.actionParams;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionData(actionName=" + this.actionName + ", packageName=" + this.packageName + ", inputParams=" + this.inputParams + ", outputParams=" + this.outputParams + ", impls=" + this.impls + ", actionParams=" + this.actionParams + ')';
    }

    public ActionData(String r3, String r4, JsonObject r5, JsonObject r6, List<Impl> r7, ActionParams r8) {
        List<Impl> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "actionName");
        this.actionName = r3;
        this.packageName = r4;
        this.inputParams = r5;
        this.outputParams = r6;
        this.impls = r9;
        this.actionParams = r8;
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final JsonObject getInputParams() {
        return this.inputParams;
    }

    public final JsonObject getOutputParams() {
        return this.outputParams;
    }

    public final List<Impl> getImpls() {
        return this.impls;
    }

    public final ActionParams getActionParams() {
        return this.actionParams;
    }
}
