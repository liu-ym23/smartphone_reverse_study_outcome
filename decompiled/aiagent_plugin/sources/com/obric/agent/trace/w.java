package com.obric.agent.trace;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.dm.api.statemachine.core.TaskId;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: TaskStateData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(KnowledgeActivity.KEY_TASK_ID)
    private final TaskId f15958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("message_id")
    private final String f15959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("message_text_content")
    private final String f15960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("task_state_list")
    private final List<v> f15961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("omni_report")
    private final r f15962e;

    public w() {
        this(null, null, null, null, null, 31, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, w.class) == true) goto L8;
        return false;
    L8:
        w r6 = (w) ZeusTransformUtils.preCheckCast(r5, w.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f15958a, r6.f15958a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15959b, r6.f15959b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15960c, r6.f15960c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f15961d, r6.f15961d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f15962e, r6.f15962e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        TaskId r0 = this.f15958a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f15959b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f15960c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + this.f15961d.hashCode()) * 31;
        r r10 = this.f15962e;
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
        return "TaskStateReport(taskID=" + this.f15958a + ", messageID=" + this.f15959b + ", messageTextContent=" + this.f15960c + ", taskStateList=" + this.f15961d + ", omniReport=" + this.f15962e + ')';
    }

    public w(TaskId r3, String r4, String r5, List<v> r6, r r7) {
        List<v> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "taskStateList");
        this.f15958a = r3;
        this.f15959b = r4;
        this.f15960c = r5;
        this.f15961d = r8;
        this.f15962e = r7;
    }

    public final TaskId a() {
        return this.f15958a;
    }

    public final String b() {
        return this.f15959b;
    }

    public final String c() {
        return this.f15960c;
    }

    public final List<v> d() {
        return this.f15961d;
    }

    public /* synthetic */ w(TaskId r8, String r9, String r10, List r11, r r12, int r13, d.h.b.h r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r13 & 1) == 0) goto L5;
        TaskId r2 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        r15 = d.a.p.b();
    L17:
        List r5 = r15;
        if ((r13 & 16) == 0) goto L20;
        r r6 = null;
    L21:
        this(r2, r3, r4, r5, r6);
        return;
    L20:
        r6 = r12;
        goto L21
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }

    public final r e() {
        return this.f15962e;
    }
}
