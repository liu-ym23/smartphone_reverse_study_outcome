package com.obric.agent.appintent;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: Intent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentAction {

    @SerializedName("actionName")
    private final String actionName;

    @SerializedName(DbHelper.COL_ID)
    private final int id;

    @SerializedName("impls")
    private final List<a> impls;

    @SerializedName("inputParams")
    private final JsonObject inputParams;

    @SerializedName("outParams")
    private final JsonObject outParams;

    public IntentAction() {
        this(null, 0, null, null, null, 31, null);
    }

    public static /* synthetic */ IntentAction copy$default(IntentAction r6, String r7, int r8, JsonObject r9, JsonObject r10, List r11, int r12, Object r13) {
        List<a> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.actionName;
    L5:
        String r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.id;
    L8:
        int r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = r6.inputParams;
    L11:
        JsonObject r3 = r9;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.outParams;
    L14:
        JsonObject r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r14 = r6.impls;
    L18:
        return r6.copy(r1, r2, r3, r4, r14);
    }

    public final String component1() {
        return this.actionName;
    }

    public final int component2() {
        return this.id;
    }

    public final JsonObject component3() {
        return this.inputParams;
    }

    public final JsonObject component4() {
        return this.outParams;
    }

    public final List<a> component5() {
        return this.impls;
    }

    public final IntentAction copy(String r7, int r8, JsonObject r9, JsonObject r10, List<a> r11) {
        return new IntentAction(r7, r8, r9, r10, (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IntentAction.class) == true) goto L8;
        return false;
    L8:
        IntentAction r6 = (IntentAction) ZeusTransformUtils.preCheckCast(r5, IntentAction.class, "com.obric.aiagent.plugin");
        if (o.a(this.actionName, r6.actionName) == true) goto L12;
        return false;
    L12:
        if (this.id == r6.id) goto L15;
        return false;
    L15:
        if (o.a(this.inputParams, r6.inputParams) == true) goto L18;
        return false;
    L18:
        if (o.a(this.outParams, r6.outParams) == true) goto L21;
        return false;
    L21:
        if (o.a(this.impls, r6.impls) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.actionName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + Integer.hashCode(this.id)) * 31;
        JsonObject r4 = this.inputParams;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        JsonObject r7 = this.outParams;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<a> r10 = this.impls;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "IntentAction(actionName=" + this.actionName + ", id=" + this.id + ", inputParams=" + this.inputParams + ", outParams=" + this.outParams + ", impls=" + this.impls + ')';
    }

    public IntentAction(String r3, int r4, JsonObject r5, JsonObject r6, List<a> r7) {
        List<a> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        this.actionName = r3;
        this.id = r4;
        this.inputParams = r5;
        this.outParams = r6;
        this.impls = r8;
    }

    public /* synthetic */ IntentAction(String r8, int r9, JsonObject r10, JsonObject r11, List r12, int r13, h r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if ((r13 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        r9 = -1;
    L9:
        int r3 = r9;
        if ((r13 & 4) == 0) goto L12;
        JsonObject r4 = null;
    L14:
        if ((r13 & 8) == 0) goto L16;
        JsonObject r5 = null;
    L18:
        if ((r13 & 16) == 0) goto L20;
        List r6 = null;
    L21:
        this(r2, r3, r4, r5, r6);
        return;
    L20:
        r6 = r15;
        goto L21
    L16:
        r5 = r11;
        goto L18
    L12:
        r4 = r10;
        goto L14
    L5:
        r2 = r8;
        goto L7
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final int getId() {
        return this.id;
    }

    public final JsonObject getInputParams() {
        return this.inputParams;
    }

    public final JsonObject getOutParams() {
        return this.outParams;
    }

    public final List<a> getImpls() {
        return this.impls;
    }
}
