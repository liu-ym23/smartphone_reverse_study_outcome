package com.obric.common.oea.foundation.animation.g.b;

import android.graphics.Color;
import com.obric.common.oea.foundation.animation.h.e;
import com.obric.common.oea.foundation.animation.h.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: IntTweenSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements com.obric.common.oea.foundation.animation.g.a<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f32408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.d f32410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f32411d;

    private final float a(float r1, float r2, float r3) {
        return r1 + ((r2 - r1) * r3);
    }

    public b(int r2, int r3, e.d r4, boolean r5) {
        o.e(r4, "easing");
        this.f32408a = r2;
        this.f32409b = r3;
        this.f32410c = r4;
        this.f32411d = r5;
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

    public /* synthetic */ b(int r2, int r3, e.d r4, boolean r5, int r6, h r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = e.d.f32444b;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r2, r3, r4, r5);
    }

    public final void a(boolean r1) {
        this.f32411d = r1;
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public String a() {
        return "IntTweenSpec(durationMillis: " + this.f32408a + ", delay: " + this.f32409b + ", easing: " + this.f32410c + ", isColor: " + this.f32411d + ')';
    }

    public Integer a(long r6, int r8, int r9, float r10) {
        long r7 = a(r6);
        int r11 = this.f32408a;
        float r0 = 1.0f;
        if (r11 != 0) goto L5;
        float r12 = 1.0f;
    L7:
        if (this.f32410c != e.d.f32443a) goto L9;
        float r13 = f.b(this.f32410c).a(r12);
    L18:
        if (this.f32411d == false) goto L20;
        float r14 = Color.alpha(r8);
        float r15 = Color.red(r8);
        float r1 = Color.green(r8);
        float r16 = Color.blue(r8);
        int r5 = Color.argb((int) a(r14, Color.alpha(r9), r13), (int) a(r15, Color.red(r9), r13), (int) a(r1, Color.green(r9), r13), (int) a(r16, Color.blue(r9), r13));
    L22:
        return Integer.valueOf(r5);
    L20:
        r5 = (int) a(r8, r9, r13);
        goto L22
    L9:
        com.obric.common.oea.foundation.animation.h.b r17 = f.a(this.f32410c);
        if (r12 >= 0.0f) goto L13;
        r12 = 0.0f;
    L13:
        if (r12 > 1.0f) goto L16;
        r0 = r12;
    L16:
        r13 = r17.a(r0);
        goto L18
    L5:
        r12 = r7 / (((long) r11) * 1000000);
        goto L7
    }

    public float b(long r10, int r12, int r13, float r14) {
        long r1 = a(r10);
        if (r1 >= 0) goto L6;
        return 0.0f;
    L6:
        if (r1 != 0) goto L8;
        return r14;
    L8:
        int r11 = a(r1 - 1000000, r12, r13, r14).intValue();
        int r15 = a(r1, r12, r13, r14).intValue();
        if (this.f32411d == false) goto L12;
        float r9 = Color.alpha(r11);
        float r16 = Color.red(r11);
        float r17 = Color.green(r11);
        float r18 = Color.blue(r11);
        float r0 = Color.alpha(r15);
        float r2 = Color.red(r15);
        float r3 = (r0 - r9) * 1000.0f;
        float r4 = (r2 - r16) * 1000.0f;
        float r5 = (Color.green(r15) - r17) * 1000.0f;
        float r19 = (Color.blue(r15) - r18) * 1000.0f;
        return (float) Math.sqrt((((r3 * r3) + (r4 * r4)) + (r5 * r5)) + (r19 * r19));
    L12:
        return (r15 - r11) * 1000.0f;
    }

    private final long a(long r11) {
        return n.a(r11 - (((long) this.f32409b) * 1000000), 0, ((long) this.f32408a) * 1000000);
    }

    public long a(int r1, int r2, float r3) {
        return ((long) this.f32408a) * 1000000;
    }

    @Override // com.obric.common.oea.foundation.animation.g.a
    public boolean a(long r5, long r7) {
        if (r5 < (r7 + (((long) this.f32409b) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }
}
