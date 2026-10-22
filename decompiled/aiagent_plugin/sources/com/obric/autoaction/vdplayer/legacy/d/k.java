package com.obric.autoaction.vdplayer.legacy.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f25909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f25910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f25911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f25912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f25913e;
    private final boolean f;

    public k() {
        this(null, null, null, null, null, false, 63, null);
    }

    public static /* synthetic */ k a(k r7, i r8, List r9, j r10, Long r11, Long r12, boolean r13, int r14, Object r15) {
        List<a> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.f25909a;
    L5:
        i r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r16 = r7.f25910b;
    L8:
        List<a> r2 = r16;
        if ((r14 & 4) == 0) goto L11;
        r10 = r7.f25911c;
    L11:
        j r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r11 = r7.f25912d;
    L14:
        Long r4 = r11;
        if ((r14 & 16) == 0) goto L17;
        r12 = r7.f25913e;
    L17:
        Long r5 = r12;
        if ((r14 & 32) == 0) goto L21;
        r13 = r7.f;
    L21:
        return r7.a(r1, r2, r3, r4, r5, r13);
    }

    public final k a(i r8, List<a> r9, j r10, Long r11, Long r12, boolean r13) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "panelData");
        d.h.b.o.e(r2, "actionButtons");
        d.h.b.o.e(r10, "panelMode");
        return new k(r8, r2, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f25909a, r6.f25909a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f25910b, r6.f25910b) == true) goto L15;
        return false;
    L15:
        if (this.f25911c == r6.f25911c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f25912d, r6.f25912d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f25913e, r6.f25913e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f25909a.hashCode() * 31) + this.f25910b.hashCode()) * 31) + this.f25911c.hashCode()) * 31;
        Long r1 = this.f25912d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.f25913e;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + Boolean.hashCode(this.f);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "PanelState(panelData=" + this.f25909a + ", actionButtons=" + this.f25910b + ", panelMode=" + this.f25911c + ", userOperatingCountDown=" + this.f25912d + ", autoExitCountDown=" + this.f25913e + ", isAssistInputShowing=" + this.f + ')';
    }

    public k(i r3, List<a> r4, j r5, Long r6, Long r7, boolean r8) {
        List<a> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "panelData");
        d.h.b.o.e(r9, "actionButtons");
        d.h.b.o.e(r5, "panelMode");
        this.f25909a = r3;
        this.f25910b = r9;
        this.f25911c = r5;
        this.f25912d = r6;
        this.f25913e = r7;
        this.f = r8;
    }

    public /* synthetic */ k(i r11, List r12, j r13, Long r14, Long r15, boolean r16, int r17, d.h.b.h r18) {
        List<a> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        if ((r17 & 1) == 0) goto L5;
        i r1 = new i(null, null, null, null, null, 31, null);
    L7:
        if ((r17 & 2) == 0) goto L10;
        r0 = c.f25876a.b();
    L10:
        if ((r17 & 4) == 0) goto L12;
        j r2 = j.f25904a;
    L13:
        Long r4 = null;
        if ((r17 & 8) == 0) goto L16;
        Long r3 = null;
    L18:
        if ((r17 & 16) != 0) goto L22;
        r4 = r15;
    L22:
        if ((r17 & 32) == 0) goto L24;
        boolean r5 = false;
    L25:
        this(r1, r0, r2, r3, r4, r5);
        return;
    L24:
        r5 = r16;
        goto L25
    L16:
        r3 = r14;
        goto L18
    L12:
        r2 = r13;
        goto L13
    L5:
        r1 = r11;
        goto L7
    }

    public final i a() {
        return this.f25909a;
    }

    public final List<a> b() {
        return this.f25910b;
    }

    public final j c() {
        return this.f25911c;
    }

    public final Long d() {
        return this.f25912d;
    }

    public final Long e() {
        return this.f25913e;
    }

    public final boolean f() {
        return this.f;
    }
}
