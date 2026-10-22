package com.obric.autoaction.app.launcherpage.detail.shortcut.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.autogui.common.api.presentation.AssistRemoteCardUIParams;
import com.obric.eventkit.task.model.EventTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.Serializable;

/* JADX INFO: compiled from: DetailParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DetailParams implements Parcelable {
    public static final Parcelable.Creator<DetailParams> CREATOR = null;
    private final AssistRemoteCardUIParams doubaoCardUIParams;
    private final String enterFrom;
    private final EventTask initEventTask;
    private final boolean isDialogMode;
    private final boolean navigateToListAfterSave;
    private final String taskId;

    /* JADX INFO: compiled from: DetailParams.kt */
    public static final class Creator implements Parcelable.Creator<DetailParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DetailParams createFromParcel(Parcel r9) {
            o.e(r9, "parcel");
            String r1 = r9.readString();
            String r2 = r9.readString();
            EventTask r3 = (EventTask) ZeusTransformUtils.preCheckCast(r9.readParcelable(DetailParams.class.getClassLoader()), EventTask.class, "com.obric.aiagent.plugin");
            AssistRemoteCardUIParams r4 = (AssistRemoteCardUIParams) ZeusTransformUtils.preCheckCast(r9.readSerializable(), AssistRemoteCardUIParams.class, "com.obric.aiagent.plugin");
            boolean r6 = false;
            if (r9.readInt() == 0) goto L5;
            boolean r7 = true;
        L7:
            if (r9.readInt() == 0) goto L10;
            r6 = true;
        L10:
            return new DetailParams(r1, r2, r3, r4, r7, r6);
        L5:
            r7 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DetailParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DetailParams[] newArray(int r1) {
            return new DetailParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DetailParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public DetailParams() {
        this(null, null, null, null, false, false, 63, null);
    }

    public static /* synthetic */ DetailParams copy$default(DetailParams r4, String r5, String r6, EventTask r7, AssistRemoteCardUIParams r8, boolean r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.taskId;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.enterFrom;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.initEventTask;
    L11:
        EventTask r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.doubaoCardUIParams;
    L14:
        AssistRemoteCardUIParams r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.isDialogMode;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.navigateToListAfterSave;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component2() {
        return this.enterFrom;
    }

    public final EventTask component3() {
        return this.initEventTask;
    }

    public final AssistRemoteCardUIParams component4() {
        return this.doubaoCardUIParams;
    }

    public final boolean component5() {
        return this.isDialogMode;
    }

    public final boolean component6() {
        return this.navigateToListAfterSave;
    }

    public final DetailParams copy(String r8, String r9, EventTask r10, AssistRemoteCardUIParams r11, boolean r12, boolean r13) {
        return new DetailParams(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DetailParams.class) == true) goto L8;
        return false;
    L8:
        DetailParams r6 = (DetailParams) ZeusTransformUtils.preCheckCast(r5, DetailParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.taskId, r6.taskId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.enterFrom, r6.enterFrom) == true) goto L15;
        return false;
    L15:
        if (o.a(this.initEventTask, r6.initEventTask) == true) goto L18;
        return false;
    L18:
        if (o.a(this.doubaoCardUIParams, r6.doubaoCardUIParams) == true) goto L21;
        return false;
    L21:
        if (this.isDialogMode == r6.isDialogMode) goto L24;
        return false;
    L24:
        if (this.navigateToListAfterSave == r6.navigateToListAfterSave) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.taskId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.enterFrom;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        EventTask r7 = this.initEventTask;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        AssistRemoteCardUIParams r10 = this.doubaoCardUIParams;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return ((((r9 + r1) * 31) + Boolean.hashCode(this.isDialogMode)) * 31) + Boolean.hashCode(this.navigateToListAfterSave);
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
        return "DetailParams(taskId=" + this.taskId + ", enterFrom=" + this.enterFrom + ", initEventTask=" + this.initEventTask + ", doubaoCardUIParams=" + this.doubaoCardUIParams + ", isDialogMode=" + this.isDialogMode + ", navigateToListAfterSave=" + this.navigateToListAfterSave + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "dest");
        r4.writeString(this.taskId);
        r4.writeString(this.enterFrom);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.initEventTask, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeSerializable((Serializable) ZeusTransformUtils.preCheckCast(this.doubaoCardUIParams, Serializable.class, "com.obric.aiagent.plugin"));
        r4.writeInt(this.isDialogMode ? 1 : 0);
        r4.writeInt(this.navigateToListAfterSave ? 1 : 0);
    }

    public DetailParams(String r1, String r2, EventTask r3, AssistRemoteCardUIParams r4, boolean r5, boolean r6) {
        this.taskId = r1;
        this.enterFrom = r2;
        this.initEventTask = r3;
        this.doubaoCardUIParams = r4;
        this.isDialogMode = r5;
        this.navigateToListAfterSave = r6;
    }

    public /* synthetic */ DetailParams(String r2, String r3, EventTask r4, AssistRemoteCardUIParams r5, boolean r6, boolean r7, int r8, h r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = false;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = true;
    L20:
        this(r2, r3, r4, r5, r6, r7);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final EventTask getInitEventTask() {
        return this.initEventTask;
    }

    public final AssistRemoteCardUIParams getDoubaoCardUIParams() {
        return this.doubaoCardUIParams;
    }

    public final boolean isDialogMode() {
        return this.isDialogMode;
    }

    public final boolean getNavigateToListAfterSave() {
        return this.navigateToListAfterSave;
    }
}
