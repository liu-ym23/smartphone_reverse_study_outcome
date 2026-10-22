package com.obric.autoaction.vdplayer.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f25492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f25493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f25494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f25495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Integer, String> f25496e;

    public i() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ i a(i r6, l r7, String r8, List r9, String r10, Map r11, int r12, Object r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Map<Integer, String> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.f25492a;
    L5:
        l r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.f25493b;
    L8:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r14 = r6.f25494c;
    L11:
        List<String> r3 = r14;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.f25495d;
    L14:
        String r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r15 = r6.f25496e;
    L18:
        return r6.a(r1, r2, r3, r4, r15);
    }

    public final i a(l r8, String r9, List<String> r10, String r11, Map<Integer, String> r12) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "panelStatus");
        return new i(r8, r9, r4, r11, r6);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (this.f25492a == r6.f25492a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f25493b, r6.f25493b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f25494c, r6.f25494c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f25495d, r6.f25495d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f25496e, r6.f25496e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.f25492a.hashCode() * 31;
        String r1 = this.f25493b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<String> r5 = this.f25494c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f25495d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Map<Integer, String> r11 = this.f25496e;
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
        return "PanelData(panelStatus=" + this.f25492a + ", content=" + this.f25493b + ", selectOptions=" + this.f25494c + ", securityLevel=" + this.f25495d + ", selectOptionSpecialStyles=" + this.f25496e + ')';
    }

    public i(l r3, String r4, List<String> r5, String r6, Map<Integer, String> r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Map<Integer, String> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "panelStatus");
        this.f25492a = r3;
        this.f25493b = r4;
        this.f25494c = r8;
        this.f25495d = r6;
        this.f25496e = r9;
    }

    public /* synthetic */ i(l r7, String r8, List r9, String r10, Map r11, int r12, d.h.b.h r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = l.f25507a;
    L5:
        l r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        String r2 = null;
    L10:
        if ((r12 & 4) == 0) goto L12;
        List r3 = null;
    L14:
        if ((r12 & 8) == 0) goto L16;
        String r4 = null;
    L18:
        if ((r12 & 16) == 0) goto L20;
        Map r5 = null;
    L21:
        this(r1, r2, r3, r4, r5);
        return;
    L20:
        r5 = r15;
        goto L21
    L16:
        r4 = r10;
        goto L18
    L12:
        r3 = r14;
        goto L14
    L8:
        r2 = r8;
        goto L10
    }

    public final l a() {
        return this.f25492a;
    }

    public final String b() {
        return this.f25493b;
    }

    public final List<String> c() {
        return this.f25494c;
    }

    public final String d() {
        return this.f25495d;
    }

    public final Map<Integer, String> e() {
        return this.f25496e;
    }
}
