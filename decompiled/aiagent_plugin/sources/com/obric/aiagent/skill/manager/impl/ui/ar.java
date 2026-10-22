package com.obric.aiagent.skill.manager.impl.ui;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f20558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f20560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f20561e;
    private final Integer f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final Integer l;
    private final List<Object> m;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ar.class) == true) goto L8;
        return false;
    L8:
        ar r6 = (ar) ZeusTransformUtils.preCheckCast(r5, ar.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20557a, r6.f20557a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20558b, r6.f20558b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f20559c, r6.f20559c) == true) goto L18;
        return false;
    L18:
        if (this.f20560d == r6.f20560d) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f20561e, r6.f20561e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L42;
        return false;
    L42:
        if (d.h.b.o.a(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (d.h.b.o.a(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        int r0 = this.f20557a.hashCode() * 31;
        Integer r1 = this.f20558b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((r0 + r3) * 31) + this.f20559c.hashCode()) * 31) + Boolean.hashCode(this.f20560d)) * 31) + this.f20561e.hashCode()) * 31;
        Integer r5 = this.f;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((((((r4 + r6) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31) + Boolean.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31;
        Integer r8 = this.l;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + this.m.hashCode();
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("SkillFormFilePresentation(title=").append(this.f20557a).append(", titleResId=").append(this.f20558b).append(", subtitle=").append(this.f20559c).append(", subtitleIsError=").append(this.f20560d).append(", action=").append(this.f20561e).append(", actionResId=").append(this.f).append(", rowEnabled=").append(this.g).append(", rowClickable=").append(this.h).append(", showAction=").append(this.i).append(", showChevron=").append(this.j).append(", showDelete=").append(this.k).append(", subtitleResId=");
        r0.append(this.l).append(", subtitleFormatArgs=").append(this.m).append(')');
        return r0.toString();
    }

    public ar(String r3, Integer r4, String r5, boolean r6, String r7, Integer r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, Integer r14, List<? extends Object> r15) {
        List<Object> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, DBDefinition.TITLE);
        d.h.b.o.e(r5, "subtitle");
        d.h.b.o.e(r7, "action");
        d.h.b.o.e(r16, "subtitleFormatArgs");
        this.f20557a = r3;
        this.f20558b = r4;
        this.f20559c = r5;
        this.f20560d = r6;
        this.f20561e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r16;
    }

    public final String a() {
        return this.f20557a;
    }

    public final Integer b() {
        return this.f20558b;
    }

    public final String c() {
        return this.f20559c;
    }

    public final boolean d() {
        return this.f20560d;
    }

    public final String e() {
        return this.f20561e;
    }

    public final Integer f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public final boolean i() {
        return this.i;
    }

    public final boolean j() {
        return this.j;
    }

    public final boolean k() {
        return this.k;
    }

    public final Integer l() {
        return this.l;
    }

    public /* synthetic */ ar(String r19, Integer r20, String r21, boolean r22, String r23, Integer r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29, Integer r30, List r31, int r32, d.h.b.h r33) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
        if ((r32 & 1) == 0) goto L5;
        String r5 = "";
    L7:
        if ((r32 & 2) == 0) goto L9;
        Integer r6 = null;
    L11:
        if ((r32 & 16) == 0) goto L13;
        String r9 = "";
    L15:
        if ((r32 & 32) == 0) goto L17;
        Integer r10 = null;
    L19:
        if ((r32 & 2048) == 0) goto L21;
        Integer r16 = null;
    L23:
        if ((r32 & 4096) == 0) goto L25;
        r1 = d.a.p.b();
    L25:
        this(r5, r6, r21, r22, r9, r10, r25, r26, r27, r28, r29, r16, r1);
        return;
    L21:
        r16 = r30;
        goto L23
    L17:
        r10 = r24;
        goto L19
    L13:
        r9 = r23;
        goto L15
    L9:
        r6 = r20;
        goto L11
    L5:
        r5 = r19;
        goto L7
    }

    public final List<Object> m() {
        return this.m;
    }
}
