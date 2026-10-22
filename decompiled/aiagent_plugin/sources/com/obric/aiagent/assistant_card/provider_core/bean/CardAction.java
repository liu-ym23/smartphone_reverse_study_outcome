package com.obric.aiagent.assistant_card.provider_core.bean;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: CardAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CardAction {

    @SerializedName("actionName")
    private final String actionName;

    @SerializedName("actionParams")
    private final String actionParams;

    @SerializedName("type")
    private final String type;

    @SerializedName("viewId")
    private final int viewId;

    public static /* synthetic */ CardAction copy$default(CardAction r0, String r1, int r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.viewId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.actionName;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.actionParams;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.type;
    }

    public final int component2() {
        return this.viewId;
    }

    public final String component3() {
        return this.actionName;
    }

    public final String component4() {
        return this.actionParams;
    }

    public final CardAction copy(String r1, int r2, String r3, String r4) {
        o.e(r1, "type");
        o.e(r3, "actionName");
        return new CardAction(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CardAction.class) == true) goto L8;
        return false;
    L8:
        CardAction r6 = (CardAction) ZeusTransformUtils.preCheckCast(r5, CardAction.class, "com.obric.aiagent.plugin");
        if (o.a(this.type, r6.type) == true) goto L12;
        return false;
    L12:
        if (this.viewId == r6.viewId) goto L15;
        return false;
    L15:
        if (o.a(this.actionName, r6.actionName) == true) goto L18;
        return false;
    L18:
        if (o.a(this.actionParams, r6.actionParams) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.type.hashCode() * 31) + Integer.hashCode(this.viewId)) * 31) + this.actionName.hashCode()) * 31;
        String r2 = this.actionParams;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "CardAction(type=" + this.type + ", viewId=" + this.viewId + ", actionName=" + this.actionName + ", actionParams=" + this.actionParams + ')';
    }

    public CardAction(String r2, int r3, String r4, String r5) {
        o.e(r2, "type");
        o.e(r4, "actionName");
        this.type = r2;
        this.viewId = r3;
        this.actionName = r4;
        this.actionParams = r5;
    }

    public final String getType() {
        return this.type;
    }

    public final int getViewId() {
        return this.viewId;
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final String getActionParams() {
        return this.actionParams;
    }
}
