package com.obric.memorydata.sdk.screencapture;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.obric.memorydata.sdk.screencapture.rule.ViewTreeOption;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TaskOptions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TaskOptions implements Parcelable {
    public static final Parcelable.Creator<TaskOptions> CREATOR = null;
    private final ScreenshotOption screenshot;
    private final ViewTreeOption viewTree;

    /* JADX INFO: compiled from: TaskOptions.kt */
    public static final class Creator implements Parcelable.Creator<TaskOptions> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskOptions createFromParcel(Parcel r5) {
            o.e(r5, "parcel");
            ViewTreeOption r1 = null;
            if (r5.readInt() != 0) goto L5;
            ScreenshotOption r0 = null;
        L6:
            ScreenshotOption r2 = (ScreenshotOption) ZeusTransformUtils.preCheckCast(r0, ScreenshotOption.class, "com.obric.aiagent.plugin");
            if (r5.readInt() == 0) goto L11;
            r1 = ViewTreeOption.CREATOR.createFromParcel(r5);
        L11:
            return new TaskOptions(r2, (ViewTreeOption) ZeusTransformUtils.preCheckCast(r1, ViewTreeOption.class, "com.obric.aiagent.plugin"));
        L5:
            r0 = ScreenshotOption.CREATOR.createFromParcel(r5);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TaskOptions createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskOptions[] newArray(int r1) {
            return new TaskOptions[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TaskOptions[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TaskOptions() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TaskOptions copy$default(TaskOptions r0, ScreenshotOption r1, ViewTreeOption r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.screenshot;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.viewTree;
    L9:
        return r0.copy(r1, r2);
    }

    public final ScreenshotOption component1() {
        return this.screenshot;
    }

    public final ViewTreeOption component2() {
        return this.viewTree;
    }

    public final TaskOptions copy(ScreenshotOption r1, ViewTreeOption r2) {
        return new TaskOptions(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TaskOptions.class) == true) goto L8;
        return false;
    L8:
        TaskOptions r6 = (TaskOptions) ZeusTransformUtils.preCheckCast(r5, TaskOptions.class, "com.obric.aiagent.plugin");
        if (o.a(this.screenshot, r6.screenshot) == true) goto L12;
        return false;
    L12:
        if (o.a(this.viewTree, r6.viewTree) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        ScreenshotOption r0 = this.screenshot;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ViewTreeOption r4 = this.viewTree;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TaskOptions(screenshot=" + this.screenshot + ", viewTree=" + this.viewTree + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "dest");
        ScreenshotOption r0 = this.screenshot;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        ViewTreeOption r3 = this.viewTree;
        if (r3 != null) goto L9;
        r4.writeInt(0);
        return;
    L9:
        r4.writeInt(1);
        r3.writeToParcel(r4, r5);
        return;
    L5:
        r4.writeInt(1);
        r0.writeToParcel(r4, r5);
        goto L6
    }

    public TaskOptions(ScreenshotOption r1, ViewTreeOption r2) {
        this.screenshot = r1;
        this.viewTree = r2;
    }

    public /* synthetic */ TaskOptions(ScreenshotOption r2, ViewTreeOption r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final ScreenshotOption getScreenshot() {
        return this.screenshot;
    }

    public final ViewTreeOption getViewTree() {
        return this.viewTree;
    }
}
