package com.obric.agent.permission.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: Permission.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Permission {
    private final String appletId;
    private final Integer confirmMode;
    private final Boolean granted;
    private final String type;

    public Permission() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Permission copy$default(Permission r0, String r1, Boolean r2, String r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.granted;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.appletId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.confirmMode;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.type;
    }

    public final Boolean component2() {
        return this.granted;
    }

    public final String component3() {
        return this.appletId;
    }

    public final Integer component4() {
        return this.confirmMode;
    }

    public final Permission copy(String r1, Boolean r2, String r3, Integer r4) {
        return new Permission(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Permission.class) == true) goto L8;
        return false;
    L8:
        Permission r6 = (Permission) ZeusTransformUtils.preCheckCast(r5, Permission.class, "com.obric.aiagent.plugin");
        if (o.a(this.type, r6.type) == true) goto L12;
        return false;
    L12:
        if (o.a(this.granted, r6.granted) == true) goto L15;
        return false;
    L15:
        if (o.a(this.appletId, r6.appletId) == true) goto L18;
        return false;
    L18:
        if (o.a(this.confirmMode, r6.confirmMode) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.type;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.granted;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.appletId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.confirmMode;
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
        return "Permission(type=" + this.type + ", granted=" + this.granted + ", appletId=" + this.appletId + ", confirmMode=" + this.confirmMode + ')';
    }

    public Permission(String r1, Boolean r2, String r3, Integer r4) {
        this.type = r1;
        this.granted = r2;
        this.appletId = r3;
        this.confirmMode = r4;
    }

    public /* synthetic */ Permission(String r2, Boolean r3, String r4, Integer r5, int r6, h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final String getType() {
        return this.type;
    }

    public final Boolean getGranted() {
        return this.granted;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final Integer getConfirmMode() {
        return this.confirmMode;
    }
}
