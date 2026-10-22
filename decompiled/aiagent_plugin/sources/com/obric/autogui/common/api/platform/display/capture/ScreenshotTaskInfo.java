package com.obric.autogui.common.api.platform.display.capture;

import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ScreenshotResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ScreenshotTaskInfo {
    private final ComponentName baseComponent;
    private final boolean isVisible;
    private final ComponentName realComponent;
    private final int taskId;
    private final ComponentName topComponent;

    public static /* synthetic */ ScreenshotTaskInfo copy$default(ScreenshotTaskInfo r3, int r4, boolean r5, ComponentName r6, ComponentName r7, ComponentName r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.taskId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.isVisible;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.topComponent;
    L11:
        ComponentName r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.baseComponent;
    L14:
        ComponentName r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.realComponent;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.taskId;
    }

    public final boolean component2() {
        return this.isVisible;
    }

    public final ComponentName component3() {
        return this.topComponent;
    }

    public final ComponentName component4() {
        return this.baseComponent;
    }

    public final ComponentName component5() {
        return this.realComponent;
    }

    public final ScreenshotTaskInfo copy(int r7, boolean r8, ComponentName r9, ComponentName r10, ComponentName r11) {
        return new ScreenshotTaskInfo(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenshotTaskInfo.class) == true) goto L8;
        return false;
    L8:
        ScreenshotTaskInfo r6 = (ScreenshotTaskInfo) ZeusTransformUtils.preCheckCast(r5, ScreenshotTaskInfo.class, "com.obric.aiagent.plugin");
        if (this.taskId == r6.taskId) goto L12;
        return false;
    L12:
        if (this.isVisible == r6.isVisible) goto L15;
        return false;
    L15:
        if (o.a(this.topComponent, r6.topComponent) == true) goto L18;
        return false;
    L18:
        if (o.a(this.baseComponent, r6.baseComponent) == true) goto L21;
        return false;
    L21:
        if (o.a(this.realComponent, r6.realComponent) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.taskId) * 31) + Boolean.hashCode(this.isVisible)) * 31;
        ComponentName r1 = this.topComponent;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ComponentName r5 = this.baseComponent;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        ComponentName r8 = this.realComponent;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public ScreenshotTaskInfo(int r1, boolean r2, ComponentName r3, ComponentName r4, ComponentName r5) {
        this.taskId = r1;
        this.isVisible = r2;
        this.topComponent = r3;
        this.baseComponent = r4;
        this.realComponent = r5;
    }

    public final int getTaskId() {
        return this.taskId;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final ComponentName getTopComponent() {
        return this.topComponent;
    }

    public final ComponentName getBaseComponent() {
        return this.baseComponent;
    }

    public final ComponentName getRealComponent() {
        return this.realComponent;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("ScreenshotTaskInfo(visible=").append(this.isVisible).append(", top_available=");
        boolean r2 = true;
        if (this.topComponent == null) goto L5;
        boolean r1 = true;
    L6:
        StringBuilder r3 = r0.append(r1).append(", base_available=");
        if (this.baseComponent == null) goto L9;
        boolean r4 = true;
    L10:
        StringBuilder r5 = r3.append(r4).append(", real_available=");
        if (this.realComponent != null) goto L15;
        r2 = false;
    L15:
        return r5.append(r2).append(')').toString();
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }
}
