package com.obric.eventkit.task.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: TaskKnowledge.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TaskKnowledge implements Parcelable {
    public static final Parcelable.Creator<TaskKnowledge> CREATOR = null;
    private final int clarifyCount;
    private final String content;
    private String evolutionInfo;
    private final boolean isEnable;
    private boolean learningSwitch;
    private final String sessionId;

    /* JADX INFO: compiled from: TaskKnowledge.kt */
    public static final class Creator implements Parcelable.Creator<TaskKnowledge> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskKnowledge createFromParcel(Parcel r9) {
            o.e(r9, "parcel");
            if (r9.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            String r4 = r9.readString();
            String r5 = r9.readString();
            int r6 = r9.readInt();
            if (r9.readInt() == 0) goto L9;
            boolean r7 = true;
        L11:
            return new TaskKnowledge(r3, r4, r5, r6, r7, r9.readString());
        L9:
            r7 = false;
            goto L11
        L5:
            r3 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TaskKnowledge createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskKnowledge[] newArray(int r1) {
            return new TaskKnowledge[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TaskKnowledge[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ TaskKnowledge copy$default(TaskKnowledge r4, boolean r5, String r6, String r7, int r8, boolean r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.isEnable;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.sessionId;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.content;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.clarifyCount;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.learningSwitch;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.evolutionInfo;
    L20:
        boolean r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final boolean component1() {
        return this.isEnable;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final String component3() {
        return this.content;
    }

    public final int component4() {
        return this.clarifyCount;
    }

    public final boolean component5() {
        return this.learningSwitch;
    }

    public final String component6() {
        return this.evolutionInfo;
    }

    public final TaskKnowledge copy(boolean r8, String r9, String r10, int r11, boolean r12, String r13) {
        return new TaskKnowledge(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TaskKnowledge.class) == true) goto L8;
        return false;
    L8:
        TaskKnowledge r6 = (TaskKnowledge) ZeusTransformUtils.preCheckCast(r5, TaskKnowledge.class, "com.obric.aiagent.plugin");
        if (this.isEnable == r6.isEnable) goto L12;
        return false;
    L12:
        if (o.a(this.sessionId, r6.sessionId) == true) goto L15;
        return false;
    L15:
        if (o.a(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (this.clarifyCount == r6.clarifyCount) goto L21;
        return false;
    L21:
        if (this.learningSwitch == r6.learningSwitch) goto L24;
        return false;
    L24:
        if (o.a(this.evolutionInfo, r6.evolutionInfo) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.isEnable) * 31;
        String r1 = this.sessionId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.content;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((r4 + r6) * 31) + Integer.hashCode(this.clarifyCount)) * 31) + Boolean.hashCode(this.learningSwitch)) * 31;
        String r8 = this.evolutionInfo;
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

    public String toString() {
        return "TaskKnowledge(isEnable=" + this.isEnable + ", sessionId=" + this.sessionId + ", content=" + this.content + ", clarifyCount=" + this.clarifyCount + ", learningSwitch=" + this.learningSwitch + ", evolutionInfo=" + this.evolutionInfo + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeInt(this.isEnable ? 1 : 0);
        r1.writeString(this.sessionId);
        r1.writeString(this.content);
        r1.writeInt(this.clarifyCount);
        r1.writeInt(this.learningSwitch ? 1 : 0);
        r1.writeString(this.evolutionInfo);
    }

    public TaskKnowledge(boolean r1, String r2, String r3, int r4, boolean r5, String r6) {
        this.isEnable = r1;
        this.sessionId = r2;
        this.content = r3;
        this.clarifyCount = r4;
        this.learningSwitch = r5;
        this.evolutionInfo = r6;
    }

    public /* synthetic */ TaskKnowledge(boolean r8, String r9, String r10, int r11, boolean r12, String r13, int r14, h r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = 0;
    L5:
        int r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        r12 = true;
    L8:
        boolean r5 = r12;
        if ((r14 & 32) == 0) goto L11;
        r13 = null;
    L11:
        this(r8, r9, r10, r4, r5, r13);
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getClarifyCount() {
        return this.clarifyCount;
    }

    public final boolean getLearningSwitch() {
        return this.learningSwitch;
    }

    public final void setLearningSwitch(boolean r1) {
        this.learningSwitch = r1;
    }

    public final String getEvolutionInfo() {
        return this.evolutionInfo;
    }

    public final void setEvolutionInfo(String r1) {
        this.evolutionInfo = r1;
    }
}
