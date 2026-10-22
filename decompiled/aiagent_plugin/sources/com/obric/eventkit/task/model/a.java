package com.obric.eventkit.task.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: EventTaskInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("taskType")
    private final int f33222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName(DBDefinition.TASK_ID)
    private String f33223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("instruct")
    private String f33224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("shortInstruct")
    private String f33225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("taskMode")
    private Integer f33226e;

    @SerializedName("omniModel")
    private String f;

    @SerializedName("taskKnowledge")
    private TaskKnowledge g;

    @SerializedName("src")
    private Integer h;

    @SerializedName("isTryRun")
    private Boolean i;

    @SerializedName("ext")
    private Map<String, String> j;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f33222a == r6.f33222a) goto L12;
        return false;
    L12:
        if (o.a(this.f33223b, r6.f33223b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f33224c, r6.f33224c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f33225d, r6.f33225d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f33226e, r6.f33226e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (o.a(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (o.a(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.f33222a) * 31;
        String r1 = this.f33223b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f33224c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f33225d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.f33226e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.f;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        TaskKnowledge r17 = this.g;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.h;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Boolean r23 = this.i;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        Map<String, String> r26 = this.j;
        if (r26 == null) goto L39;
        r2 = r26.hashCode();
    L39:
        return r25 + r2;
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
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
        return "EventTaskInfo(taskType=" + this.f33222a + ", taskId=" + this.f33223b + ", instruct=" + this.f33224c + ", shortInstruct=" + this.f33225d + ", taskMode=" + this.f33226e + ", omniModel=" + this.f + ", taskKnowledge=" + this.g + ", src=" + this.h + ", isTryRun=" + this.i + ", ext=" + this.j + ')';
    }

    public a(int r3, String r4, String r5, String r6, Integer r7, String r8, TaskKnowledge r9, Integer r10, Boolean r11, Map<String, String> r12) {
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        this.f33222a = r3;
        this.f33223b = r4;
        this.f33224c = r5;
        this.f33225d = r6;
        this.f33226e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r13;
    }

    public /* synthetic */ a(int r12, String r13, String r14, String r15, Integer r16, String r17, TaskKnowledge r18, Integer r19, Boolean r20, Map r21, int r22, h r23) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        Map r3 = null;
        if ((r22 & 2) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r22 & 4) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r22 & 8) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r22 & 16) == 0) goto L17;
        Integer r6 = null;
    L19:
        if ((r22 & 32) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r22 & 64) == 0) goto L25;
        TaskKnowledge r8 = null;
    L27:
        if ((r22 & 128) == 0) goto L29;
        Integer r9 = null;
    L31:
        if ((r22 & 256) == 0) goto L33;
        Boolean r10 = null;
    L35:
        if ((r22 & 512) != 0) goto L38;
        r3 = r1;
    L38:
        this(r12, r2, r4, r5, r6, r7, r8, r9, r10, r3);
        return;
    L33:
        r10 = r20;
        goto L35
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final int a() {
        return this.f33222a;
    }

    public final void a(String r1) {
        this.f33223b = r1;
    }

    public final String b() {
        return this.f33223b;
    }

    public final void b(String r1) {
        this.f33224c = r1;
    }

    public final String c() {
        return this.f33224c;
    }

    public final void c(String r1) {
        this.f33225d = r1;
    }

    public final Integer d() {
        return this.f33226e;
    }

    public final void d(String r1) {
        this.f = r1;
    }

    public final String e() {
        return this.f;
    }

    public final void a(TaskKnowledge r1) {
        this.g = r1;
    }

    public final TaskKnowledge f() {
        return this.g;
    }

    public final void a(Integer r1) {
        this.h = r1;
    }

    public final Integer g() {
        return this.h;
    }

    public final Boolean h() {
        return this.i;
    }
}
