package com.obric.autogui.common.api.platform.display.capture;

import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ScreenshotResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ScreenshotResult {
    private int flags;
    private final HeifScreenshotAttachment heifAttachment;
    private final IScreenshot pic;
    private Status status;
    private final ScreenshotTaskInfo taskInfo;
    private final ComponentName topComponent;

    /* JADX INFO: compiled from: ScreenshotResult.kt */
    public static final class Flags {
        public static final Flags INSTANCE = null;
        public static final int NONE = 0;
        public static final int POLICY_RESTRICTED = 1;

        static {
            INSTANCE = new Flags();
        }

        private Flags() {
        }
    }

    /* JADX INFO: compiled from: ScreenshotResult.kt */
    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ApiError = null;
        public static final Status ContainsSecure = null;
        public static final Status KeyguardLocked = null;
        public static final Status NoScreenFound = null;
        public static final Status NotSupported = null;
        public static final Status Ok = null;
        public static final Status ScreenClosed = null;

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{Ok, NotSupported, NoScreenFound, ScreenClosed, ApiError, ContainsSecure, KeyguardLocked};
        }

        public static a<Status> getEntries() {
            return $ENTRIES;
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Ok = new Status("Ok", 0);
            NotSupported = new Status("NotSupported", 1);
            NoScreenFound = new Status("NoScreenFound", 2);
            ScreenClosed = new Status("ScreenClosed", 3);
            ApiError = new Status("ApiError", 4);
            ContainsSecure = new Status("ContainsSecure", 5);
            KeyguardLocked = new Status("KeyguardLocked", 6);
            Status[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static Status valueOf(String r2) {
            return (Status) ZeusTransformUtils.preCheckCast(Enum.valueOf(Status.class, r2), Status.class, "com.obric.aiagent.plugin");
        }

        public static Status[] values() {
            return (Status[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Status[].class, "com.obric.aiagent.plugin");
        }
    }

    public ScreenshotResult() {
        this(null, null, null, 0, null, null, 63, null);
    }

    public static /* synthetic */ ScreenshotResult copy$default(ScreenshotResult r7, Status r8, IScreenshot r9, HeifScreenshotAttachment r10, int r11, ComponentName r12, ScreenshotTaskInfo r13, int r14, Object r15) {
        IScreenshot r16 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r9, IScreenshot.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.status;
    L5:
        Status r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r16 = r7.pic;
    L8:
        IScreenshot r2 = r16;
        if ((r14 & 4) == 0) goto L11;
        r10 = r7.heifAttachment;
    L11:
        HeifScreenshotAttachment r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r11 = r7.flags;
    L14:
        int r4 = r11;
        if ((r14 & 16) == 0) goto L17;
        r12 = r7.topComponent;
    L17:
        ComponentName r5 = r12;
        if ((r14 & 32) == 0) goto L21;
        r13 = r7.taskInfo;
    L21:
        return r7.copy(r1, r2, r3, r4, r5, r13);
    }

    public final Status component1() {
        return this.status;
    }

    public final IScreenshot component2() {
        return this.pic;
    }

    public final HeifScreenshotAttachment component3() {
        return this.heifAttachment;
    }

    public final int component4() {
        return this.flags;
    }

    public final ComponentName component5() {
        return this.topComponent;
    }

    public final ScreenshotTaskInfo component6() {
        return this.taskInfo;
    }

    public final ScreenshotResult copy(Status r8, IScreenshot r9, HeifScreenshotAttachment r10, int r11, ComponentName r12, ScreenshotTaskInfo r13) {
        IScreenshot r2 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r9, IScreenshot.class, "com.obric.aiagent.plugin");
        o.e(r8, "status");
        return new ScreenshotResult(r8, r2, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenshotResult.class) == true) goto L8;
        return false;
    L8:
        ScreenshotResult r6 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r5, ScreenshotResult.class, "com.obric.aiagent.plugin");
        if (this.status == r6.status) goto L12;
        return false;
    L12:
        if (o.a(this.pic, r6.pic) == true) goto L15;
        return false;
    L15:
        if (o.a(this.heifAttachment, r6.heifAttachment) == true) goto L18;
        return false;
    L18:
        if (this.flags == r6.flags) goto L21;
        return false;
    L21:
        if (o.a(this.topComponent, r6.topComponent) == true) goto L24;
        return false;
    L24:
        if (o.a(this.taskInfo, r6.taskInfo) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = this.status.hashCode() * 31;
        IScreenshot r1 = this.pic;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        HeifScreenshotAttachment r5 = this.heifAttachment;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + Integer.hashCode(this.flags)) * 31;
        ComponentName r8 = this.topComponent;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        ScreenshotTaskInfo r11 = this.taskInfo;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
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
        return "ScreenshotResult(status=" + this.status + ", pic=" + this.pic + ", heifAttachment=" + this.heifAttachment + ", flags=" + this.flags + ", topComponent=" + this.topComponent + ", taskInfo=" + this.taskInfo + ')';
    }

    public ScreenshotResult(Status r3, IScreenshot r4, HeifScreenshotAttachment r5, int r6, ComponentName r7, ScreenshotTaskInfo r8) {
        IScreenshot r9 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r4, IScreenshot.class, "com.obric.aiagent.plugin");
        o.e(r3, "status");
        this.status = r3;
        this.pic = r9;
        this.heifAttachment = r5;
        this.flags = r6;
        this.topComponent = r7;
        this.taskInfo = r8;
    }

    public /* synthetic */ ScreenshotResult(Status r8, IScreenshot r9, HeifScreenshotAttachment r10, int r11, ComponentName r12, ScreenshotTaskInfo r13, int r14, h r15) {
        IScreenshot r16 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r9, IScreenshot.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = Status.Ok;
    L5:
        Status r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        IScreenshot r2 = null;
    L10:
        if ((r14 & 4) == 0) goto L12;
        HeifScreenshotAttachment r3 = null;
    L14:
        if ((r14 & 8) == 0) goto L16;
        r11 = 0;
    L16:
        int r4 = r11;
        if ((r14 & 16) == 0) goto L19;
        ComponentName r5 = null;
    L21:
        if ((r14 & 32) == 0) goto L23;
        ScreenshotTaskInfo r6 = null;
    L24:
        this(r1, r2, r3, r4, r5, r6);
        return;
    L23:
        r6 = r13;
        goto L24
    L19:
        r5 = r12;
        goto L21
    L12:
        r3 = r10;
        goto L14
    L8:
        r2 = r16;
        goto L10
    }

    public final Status getStatus() {
        return this.status;
    }

    public final void setStatus(Status r2) {
        o.e(r2, "<set-?>");
        this.status = r2;
    }

    public final IScreenshot getPic() {
        return this.pic;
    }

    public final HeifScreenshotAttachment getHeifAttachment() {
        return this.heifAttachment;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final void setFlags(int r1) {
        this.flags = r1;
    }

    public final ComponentName getTopComponent() {
        return this.topComponent;
    }

    public final ScreenshotTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public final boolean ok() {
        if (this.status != Status.Ok) goto L5;
        return true;
    L5:
        return false;
    }
}
