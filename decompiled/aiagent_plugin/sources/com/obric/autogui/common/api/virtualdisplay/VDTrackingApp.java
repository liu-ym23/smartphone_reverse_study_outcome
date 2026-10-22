package com.obric.autogui.common.api.virtualdisplay;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: VDTrackingApp.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VDTrackingApp {
    private String packageName;
    private int taskId;

    /* JADX WARN: Multi-variable type inference failed */
    public VDTrackingApp() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ VDTrackingApp copy$default(VDTrackingApp r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.taskId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.packageName;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.taskId;
    }

    public final String component2() {
        return this.packageName;
    }

    public final VDTrackingApp copy(int r1, String r2) {
        return new VDTrackingApp(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, VDTrackingApp.class) == true) goto L8;
        return false;
    L8:
        VDTrackingApp r6 = (VDTrackingApp) ZeusTransformUtils.preCheckCast(r5, VDTrackingApp.class, "com.obric.aiagent.plugin");
        if (this.taskId == r6.taskId) goto L12;
        return false;
    L12:
        if (o.a(this.packageName, r6.packageName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.taskId) * 31;
        String r1 = this.packageName;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "VDTrackingApp(taskId=" + this.taskId + ", packageName=" + this.packageName + ')';
    }

    public VDTrackingApp(int r1, String r2) {
        this.taskId = r1;
        this.packageName = r2;
    }

    public /* synthetic */ VDTrackingApp(int r1, String r2, int r3, h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = -1;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }

    public final int getTaskId() {
        return this.taskId;
    }

    public final void setTaskId(int r1) {
        this.taskId = r1;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final void setPackageName(String r1) {
        this.packageName = r1;
    }

    public final boolean isSameAs(VDTrackingApp r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (o.a(this.packageName, r4.packageName) == true) goto L8;
        return false;
    L8:
        if (this.taskId != r4.taskId) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean isSameTaskAs(VDTrackingApp r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (this.taskId != r2.taskId) goto L9;
        return true;
    L9:
        return false;
    }
}
