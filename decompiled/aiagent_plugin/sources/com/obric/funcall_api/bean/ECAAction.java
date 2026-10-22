package com.obric.funcall_api.bean;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IntentAppAction.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ECAAction {

    @SerializedName("actionName")
    private final String actionName;

    @SerializedName(DbHelper.COL_ID)
    private final int id;

    /* JADX WARN: Multi-variable type inference failed */
    public ECAAction() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ECAAction copy$default(ECAAction r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.actionName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.id;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.actionName;
    }

    public final int component2() {
        return this.id;
    }

    public final ECAAction copy(String r1, int r2) {
        return new ECAAction(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ECAAction.class) == true) goto L8;
        return false;
    L8:
        ECAAction r6 = (ECAAction) ZeusTransformUtils.preCheckCast(r5, ECAAction.class, "com.obric.aiagent.plugin");
        if (o.a(this.actionName, r6.actionName) == true) goto L12;
        return false;
    L12:
        if (this.id == r6.id) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.actionName;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + Integer.hashCode(this.id);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "ECAAction(actionName=" + this.actionName + ", id=" + this.id + ')';
    }

    public ECAAction(String r1, int r2) {
        this.actionName = r1;
        this.id = r2;
    }

    public /* synthetic */ ECAAction(String r1, int r2, int r3, h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = -1;
    L8:
        this(r1, r2);
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final int getId() {
        return this.id;
    }
}
