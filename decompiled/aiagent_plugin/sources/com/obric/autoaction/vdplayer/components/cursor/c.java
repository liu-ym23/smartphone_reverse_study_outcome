package com.obric.autoaction.vdplayer.components.cursor;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: VDPlayerEffectEventBus.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Float> f25389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Float> f25390c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f25388a, r6.f25388a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f25389b, r6.f25389b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f25390c, r6.f25390c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.f25388a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<Float> r4 = this.f25389b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<Float> r7 = this.f25390c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "VDPlayerCursorEffect(thought=" + this.f25388a + ", clickPos=" + this.f25389b + ", swipePos=" + this.f25390c + ')';
    }

    public c(String r3, List<Float> r4, List<Float> r5) {
        List<Float> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<Float> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f25388a = r3;
        this.f25389b = r6;
        this.f25390c = r7;
    }

    public final String a() {
        return this.f25388a;
    }

    public final List<Float> b() {
        return this.f25389b;
    }

    public final List<Float> c() {
        return this.f25390c;
    }

    public final boolean a(int r6, int r7) {
        if (r6 <= 0) goto L31;
        if (r7 <= 0) goto L39;
        List<Float> r1 = this.f25389b;
        if (r1 != null) goto L9;
        boolean r3 = true;
    L10:
        List<Float> r5 = this.f25390c;
        if (r5 != null) goto L13;
        boolean r4 = true;
    L14:
        if (r3 != r4) goto L17;
        return false;
    L17:
        if (r1 != null) goto L19;
        if (r5 != null) goto L25;
        return false;
    L25:
        if (r5.size() == 4) goto L27;
        return false;
    L27:
        if (a(r5, r6, r7, 0) == true) goto L29;
        return false;
    L29:
        if (a(r5, r6, r7, 2) == true) goto L34;
        return false;
    L34:
        return true;
    L19:
        if (r1.size() == 2) goto L21;
        return false;
    L21:
        if (a(r1, r6, r7, 0) == true) goto L34;
        return false;
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
        goto L10
    L39:
        return false;
    L31:
        return false;
    }

    private static final boolean a(List<Float> r4, int r5, int r6, int r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Float r0 = (Float) ZeusTransformUtils.preCheckCast(p.d(r8, r7), Float.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L22;
        float r1 = r0.floatValue();
        Float r9 = (Float) ZeusTransformUtils.preCheckCast(p.d(r8, r7 + 1), Float.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L23;
        float r10 = r9.floatValue();
        if (0.0f <= r1) goto L9;
    L11:
        boolean r11 = false;
    L12:
        if (r11 == true) goto L14;
        return false;
    L14:
        if (0.0f <= r10) goto L16;
    L18:
        boolean r12 = false;
    L19:
        if (r12 == true) goto L21;
        return false;
    L21:
        return true;
    L16:
        if (r10 > r6) goto L18;
        r12 = true;
        goto L19
    L9:
        if (r1 > r5) goto L11;
        r11 = true;
        goto L12
    L23:
        return false;
    L22:
        return false;
    }
}
