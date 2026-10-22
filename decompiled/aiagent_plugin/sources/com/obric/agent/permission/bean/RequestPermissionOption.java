package com.obric.agent.permission.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: RequestPermissionOption.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RequestPermissionOption {
    private final String action;
    private final String text;
    private final String uiType;

    public static /* synthetic */ RequestPermissionOption copy$default(RequestPermissionOption r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.action;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.uiType;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.action;
    }

    public final String component3() {
        return this.uiType;
    }

    public final RequestPermissionOption copy(String r1, String r2, String r3) {
        o.e(r1, "text");
        o.e(r2, "action");
        o.e(r3, "uiType");
        return new RequestPermissionOption(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RequestPermissionOption.class) == true) goto L8;
        return false;
    L8:
        RequestPermissionOption r6 = (RequestPermissionOption) ZeusTransformUtils.preCheckCast(r5, RequestPermissionOption.class, "com.obric.aiagent.plugin");
        if (o.a(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (o.a(this.action, r6.action) == true) goto L15;
        return false;
    L15:
        if (o.a(this.uiType, r6.uiType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + this.action.hashCode()) * 31) + this.uiType.hashCode();
    }

    public String toString() {
        return "RequestPermissionOption(text=" + this.text + ", action=" + this.action + ", uiType=" + this.uiType + ')';
    }

    public RequestPermissionOption(String r2, String r3, String r4) {
        o.e(r2, "text");
        o.e(r3, "action");
        o.e(r4, "uiType");
        this.text = r2;
        this.action = r3;
        this.uiType = r4;
    }

    public final String getText() {
        return this.text;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getUiType() {
        return this.uiType;
    }
}
