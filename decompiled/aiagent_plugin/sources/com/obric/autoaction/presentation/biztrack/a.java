package com.obric.autoaction.presentation.biztrack;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PlayerActionTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f24832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f24833e;
    private List<Long> f;
    private long g;

    public a() {
        this(0, 0, 0, 0, 0, null, 0, 127, null);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
        return false;
    L8:
        a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
        if (this.f24829a == r8.f24829a) goto L12;
        return false;
    L12:
        if (this.f24830b == r8.f24830b) goto L15;
        return false;
    L15:
        if (this.f24831c == r8.f24831c) goto L18;
        return false;
    L18:
        if (this.f24832d == r8.f24832d) goto L21;
        return false;
    L21:
        if (this.f24833e == r8.f24833e) goto L24;
        return false;
    L24:
        if (o.a(this.f, r8.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r8.g) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.f24829a) * 31) + Integer.hashCode(this.f24830b)) * 31) + Integer.hashCode(this.f24831c)) * 31) + Integer.hashCode(this.f24832d)) * 31) + Integer.hashCode(this.f24833e)) * 31) + this.f.hashCode()) * 31) + Long.hashCode(this.g);
    }

    public String toString() {
        return "ActionRecord(tapCount=" + this.f24829a + ", doubleTapCount=" + this.f24830b + ", longPressCount=" + this.f24831c + ", scrollStartCount=" + this.f24832d + ", scrollEndCount=" + this.f24833e + ", actionTimeIntervals=" + this.f + ", lastRecordTimeStamp=" + this.g + ')';
    }

    public a(int r3, int r4, int r5, int r6, int r7, List<Long> r8, long r9) {
        List<Long> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        o.e(r10, "actionTimeIntervals");
        this.f24829a = r3;
        this.f24830b = r4;
        this.f24831c = r5;
        this.f24832d = r6;
        this.f24833e = r7;
        this.f = r10;
        this.g = r9;
    }

    public final int a() {
        return this.f24829a;
    }

    public final void a(int r1) {
        this.f24829a = r1;
    }

    public final int b() {
        return this.f24830b;
    }

    public final void b(int r1) {
        this.f24830b = r1;
    }

    public final int c() {
        return this.f24831c;
    }

    public final void c(int r1) {
        this.f24831c = r1;
    }

    public final int d() {
        return this.f24832d;
    }

    public final void d(int r1) {
        this.f24832d = r1;
    }

    public final int e() {
        return this.f24833e;
    }

    public final void e(int r1) {
        this.f24833e = r1;
    }

    public /* synthetic */ a(int r10, int r11, int r12, int r13, int r14, List r15, long r16, int r18, h r19) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        int r3 = 0;
        if ((r18 & 1) == 0) goto L5;
        int r2 = 0;
    L7:
        if ((r18 & 2) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r5 = 0;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r6 = 0;
    L19:
        if ((r18 & 16) != 0) goto L23;
        r3 = r14;
    L23:
        if ((r18 & 32) == 0) goto L26;
        r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L26:
        if ((r18 & 64) == 0) goto L28;
        long r7 = 0;
    L29:
        this(r2, r4, r5, r6, r3, r0, r7);
        return;
    L28:
        r7 = r16;
        goto L29
    L17:
        r6 = r13;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final List<Long> f() {
        return this.f;
    }

    public final void a(long r1) {
        this.g = r1;
    }

    public final long g() {
        return this.g;
    }

    public final int h() {
        return (((this.f24829a + this.f24830b) + this.f24831c) + this.f24832d) + this.f24833e;
    }

    public final long i() {
        if (this.f.isEmpty() == false) goto L7;
        return 0;
    L7:
        return p.C((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.aiagent.plugin")) / ((long) this.f.size());
    }
}
