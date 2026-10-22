package com.obric.autogui.agents.vlm.models.omni.upload;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OmniDataFeedbackUploadRecord.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f28783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final t f28784e;
    private final com.obric.autogui.agents.vlm.models.omni.upload.b.e f;
    private final com.obric.autogui.agents.vlm.models.omni.upload.a.g g;
    private final long h;
    private final long i;
    private final List<File> j;

    public static /* synthetic */ h a(h r5, String r6, String r7, String r8, Integer r9, t r10, com.obric.autogui.agents.vlm.models.omni.upload.b.e r11, com.obric.autogui.agents.vlm.models.omni.upload.a.g r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.f28780a;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.f28781b;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.f28782c;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.f28783d;
    L14:
        Integer r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.f28784e;
    L17:
        t r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.f;
    L20:
        com.obric.autogui.agents.vlm.models.omni.upload.b.e r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.g;
    L23:
        String r16 = r6;
        return r5.a(r16, r15, r0, r1, r2, r3, r12);
    }

    /* JADX INFO: renamed from: lambda$_Yoh3yl8AWDwzMIGUriUHNP2-Qg, reason: not valid java name */
    public static /* synthetic */ CharSequence m788lambda$_Yoh3yl8AWDwzMIGUriUHNP2Qg(File r0) {
        return a(r0);
    }

    public final h a(String r9, String r10, String r11, Integer r12, t r13, com.obric.autogui.agents.vlm.models.omni.upload.b.e r14, com.obric.autogui.agents.vlm.models.omni.upload.a.g r15) {
        d.h.b.o.e(r9, DBDefinition.TASK_ID);
        d.h.b.o.e(r10, "toolId");
        d.h.b.o.e(r11, "stepId");
        return new h(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f28780a, r6.f28780a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28781b, r6.f28781b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f28782c, r6.f28782c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f28783d, r6.f28783d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f28784e, r6.f28784e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f28780a.hashCode() * 31) + this.f28781b.hashCode()) * 31) + this.f28782c.hashCode()) * 31;
        Integer r1 = this.f28783d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        t r5 = this.f28784e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        com.obric.autogui.agents.vlm.models.omni.upload.b.e r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        com.obric.autogui.agents.vlm.models.omni.upload.a.g r11 = this.g;
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
        return "OmniDataFeedbackUploadRecord(taskId=" + this.f28780a + ", toolId=" + this.f28781b + ", stepId=" + this.f28782c + ", stepIndex=" + this.f28783d + ", image=" + this.f28784e + ", viewTree=" + this.f + ", reactViewTree=" + this.g + ')';
    }

    public h(String r7, String r8, String r9, Integer r10, t r11, com.obric.autogui.agents.vlm.models.omni.upload.b.e r12, com.obric.autogui.agents.vlm.models.omni.upload.a.g r13) {
        d.h.b.o.e(r7, DBDefinition.TASK_ID);
        d.h.b.o.e(r8, "toolId");
        d.h.b.o.e(r9, "stepId");
        this.f28780a = r7;
        this.f28781b = r8;
        this.f28782c = r9;
        this.f28783d = r10;
        this.f28784e = r11;
        this.f = r12;
        this.g = r13;
        Long[] r14 = new Long[3];
        File r15 = null;
        if (r11 == null) goto L5;
        Long r16 = Long.valueOf(r11.d());
    L6:
        r14[0] = r16;
        if (r12 == null) goto L9;
        Long r17 = Long.valueOf(r12.d());
    L10:
        r14[1] = r17;
        if (r13 == null) goto L13;
        Long r18 = Long.valueOf(r13.d());
    L14:
        r14[2] = r18;
        Long r19 = (Long) ZeusTransformUtils.preCheckCast(d.a.p.w((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.e(r14), Iterable.class, "com.obric.aiagent.plugin")), Long.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L17;
        long r4 = r19.longValue();
    L18:
        this.h = r4;
        Long[] r20 = new Long[3];
        if (r11 == null) goto L21;
        Long r110 = Long.valueOf(r11.g());
    L22:
        r20[0] = r110;
        if (r12 == null) goto L25;
        Long r111 = Long.valueOf(r12.g());
    L26:
        r20[1] = r111;
        if (r13 == null) goto L29;
        Long r112 = Long.valueOf(r13.g());
    L30:
        r20[2] = r112;
        this.i = d.a.p.C((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.e(r20), Iterable.class, "com.obric.aiagent.plugin"));
        File[] r21 = new File[3];
        if (r11 == null) goto L33;
        File r22 = r11.a();
    L34:
        r21[0] = r22;
        if (r12 == null) goto L37;
        File r23 = r12.a();
    L38:
        r21[1] = r23;
        if (r13 == null) goto L41;
        r15 = r13.a();
    L41:
        r21[2] = r15;
        this.j = d.a.p.e(r21);
        return;
    L37:
        r23 = null;
        goto L38
    L33:
        r22 = null;
        goto L34
    L29:
        r112 = null;
        goto L30
    L25:
        r111 = null;
        goto L26
    L21:
        r110 = null;
        goto L22
    L17:
        r4 = 0;
        goto L18
    L13:
        r18 = null;
        goto L14
    L9:
        r17 = null;
        goto L10
    L5:
        r16 = null;
        goto L6
    }

    public final String a() {
        return this.f28780a;
    }

    public final String b() {
        return this.f28781b;
    }

    public final String c() {
        return this.f28782c;
    }

    public final Integer d() {
        return this.f28783d;
    }

    public final t e() {
        return this.f28784e;
    }

    public final com.obric.autogui.agents.vlm.models.omni.upload.b.e f() {
        return this.f;
    }

    public final com.obric.autogui.agents.vlm.models.omni.upload.a.g g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public final long i() {
        return this.i;
    }

    public final List<File> j() {
        return this.j;
    }

    public final boolean k() {
        return !((Collection) ZeusTransformUtils.preCheckCast(this.j, Collection.class, "com.obric.aiagent.plugin")).isEmpty();
    }

    public final boolean l() {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(this.j, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L12;
        if ((!((File) ZeusTransformUtils.preCheckCast(r6.next(), File.class, "com.obric.aiagent.plugin")).isFile()) == false) goto L9;
        return true;
    L12:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public final String m() {
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(this.j, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r2 = r12.next();
        if (((File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.aiagent.plugin")).isFile() == true) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$h$_Yoh3yl8AWDwzMIGUriUHNP2Qg.INSTANCE, 30, null);
    }

    private static final CharSequence a(File r2) {
        d.h.b.o.e(r2, "it");
        String r3 = r2.getName();
        d.h.b.o.c(r3, "getName(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final String n() {
        String[] r0 = new String[3];
        t r1 = this.f28784e;
        String r2 = null;
        if (r1 == null) goto L9;
        File r3 = r1.a();
        if (r3 == null) goto L9;
        String r4 = r3.getName();
        if (r4 == null) goto L9;
        String r5 = "image=" + r4;
    L10:
        r0[0] = r5;
        com.obric.autogui.agents.vlm.models.omni.upload.b.e r6 = this.f;
        if (r6 == null) goto L17;
        File r7 = r6.a();
        if (r7 == null) goto L17;
        String r8 = r7.getName();
        if (r8 == null) goto L17;
        String r9 = "viewTree=" + r8;
    L18:
        r0[1] = r9;
        com.obric.autogui.agents.vlm.models.omni.upload.a.g r11 = this.g;
        if (r11 == null) goto L25;
        File r12 = r11.a();
        if (r12 == null) goto L25;
        String r13 = r12.getName();
        if (r13 == null) goto L25;
        r2 = "reactViewTree=" + r13;
    L25:
        r0[2] = r2;
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.e(r0), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L17:
        r9 = null;
    L9:
        r5 = null;
        goto L10
    }
}
