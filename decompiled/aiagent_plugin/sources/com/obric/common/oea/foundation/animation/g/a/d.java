package com.obric.common.oea.foundation.animation.g.a;

import android.graphics.Color;
import com.obric.common.oea.foundation.animation.b.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: IntSpringSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements com.obric.common.oea.foundation.animation.g.a<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f32399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f32400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f32401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f32402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f32403e;
    private final int f;
    private final float g;
    private boolean h;

    public d() {
        this(0.0f, 0.0f, 0, 0.0f, false, 31, null);
    }

    public d(float r1, float r2, int r3, float r4, boolean r5) {
        this.f32402d = r1;
        this.f32403e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.f32399a = "IntSpringSpec";
        e r6 = new e(1.0f);
        r6.b(r1);
        r6.a(r2);
        x r7 = x.f38692a;
        this.f32400b = r6;
        this.f32401c = 1.0f;
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public /* synthetic */ long a(Integer r3, Integer r4, float r5) {
        return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue(), r5);
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public /* synthetic */ Integer a(long r9, Integer r11, Integer r12, float r13) {
        return a(r9, ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue(), r13);
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public /* synthetic */ float b(long r9, Integer r11, Integer r12, float r13) {
        return b(r9, ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue(), r13);
    }

    public /* synthetic */ d(float r2, float r3, int r4, float r5, boolean r6, int r7, h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = 1.0f;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = 1.0f;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = 0.01f;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = false;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public String a() {
        return "IntSpringSpec(dampingRatio: " + this.f32402d + ", stiffness: " + this.f32403e + ", delay: " + this.f + ", visibilityThreshold: " + this.g + ", delta: " + this.f32401c + ')';
    }

    public Integer a(long r8, int r10, int r11, float r12) {
        long r9 = c(r8, r10, r11, r12) / 1000000;
        if (this.h == false) goto L5;
        int r0 = Color.alpha(r10);
        int r1 = Color.red(r10);
        int r2 = Color.green(r10);
        int r13 = Color.blue(r10);
        int r3 = Color.alpha(r11);
        int r4 = Color.red(r11);
        int r5 = Color.green(r11);
        int r14 = Color.blue(r11);
        this.f32400b.c(r3);
        int r6 = (int) this.f32400b.a(r0, r12, r9).a();
        this.f32400b.c(r4);
        int r7 = (int) this.f32400b.a(r1, r12, r9).a();
        this.f32400b.c(r5);
        int r15 = (int) this.f32400b.a(r2, r12, r9).a();
        this.f32400b.c(r14);
        int r16 = Color.argb(r6, r7, r15, (int) this.f32400b.a(r13, r12, r9).a());
    L7:
        return Integer.valueOf(r16);
    L5:
        this.f32400b.c(r11);
        r16 = (int) this.f32400b.a(r10, r12, r9).a();
        goto L7
    }

    public float b(long r8, int r10, int r11, float r12) {
        long r9 = c(r8, r10, r11, r12) / 1000000;
        if (this.h == false) goto L6;
        float r0 = Color.alpha(r10);
        float r1 = Color.red(r10);
        float r2 = Color.green(r10);
        float r13 = Color.blue(r10);
        float r3 = Color.alpha(r11);
        float r4 = Color.red(r11);
        float r5 = Color.green(r11);
        float r14 = Color.blue(r11);
        this.f32400b.c(r3);
        float r6 = this.f32400b.a(r0, r12, r9).b();
        this.f32400b.c(r4);
        float r7 = this.f32400b.a(r1, r12, r9).b();
        this.f32400b.c(r5);
        float r15 = this.f32400b.a(r2, r12, r9).b();
        this.f32400b.c(r14);
        float r16 = this.f32400b.a(r13, r12, r9).b();
        return (float) Math.sqrt((((r6 * r6) + (r7 * r7)) + (r15 * r15)) + (r16 * r16));
    L6:
        this.f32400b.c(r11);
        return this.f32400b.a(r10, r12, r9).b();
    }

    public long a(int r10, int r11, float r12) {
        float r0 = Color.alpha(r10);
        float r1 = Color.alpha(r11);
        float r2 = Color.red(r10);
        float r3 = Color.red(r11);
        float r4 = Color.green(r10);
        float r5 = Color.green(r11);
        float r13 = Color.blue(r10);
        float r14 = Color.blue(r11);
        float r6 = this.f32400b.a();
        float r7 = this.f32400b.b();
        float r8 = r0 - r1;
        float r9 = this.g;
        long r15 = c.a(r6, r7, r12 / r9, r8 / r9, this.f32401c);
        float r16 = this.f32400b.a();
        float r17 = this.f32400b.b();
        float r18 = r2 - r3;
        float r19 = this.g;
        long r20 = c.a(r16, r17, r12 / r19, r18 / r19, this.f32401c);
        float r21 = this.f32400b.a();
        float r22 = this.f32400b.b();
        float r23 = r4 - r5;
        float r24 = this.g;
        long r25 = c.a(r21, r22, r12 / r24, r23 / r24, this.f32401c);
        float r26 = this.f32400b.a();
        float r27 = this.f32400b.b();
        float r110 = r13 - r14;
        float r111 = this.g;
        return d.b.a.a(r15, new long[]{r20, r25, c.a(r26, r27, r12 / r111, r110 / r111, this.f32401c)}) * 1000000;
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public boolean a(long r5, long r7) {
        if (r5 < (r7 + (((long) this.f) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }

    private final long c(long r9, int r11, int r12, float r13) {
        long r14 = a(r11, r12, r13);
        long r2 = r9 - (((long) this.f) * 1000000);
        if (r14 < 0) goto L5;
        long r6 = r14;
    L7:
        return n.a(r2, 0, r6);
    L5:
        r6 = 0;
        goto L7
    }
}
