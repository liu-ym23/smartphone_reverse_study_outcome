package com.obric.oui.constraintlayout.a;

import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: SolverVariableValues.java */
/* JADX INFO: loaded from: classes4.dex */
public class i implements b.a {
    private static float j = 0.001f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int[] f34798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int[] f34799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int[] f34800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float[] f34801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int[] f34802e;
    int[] f;
    int g;
    int h;
    protected final c i;
    private final int k;
    private int l;
    private int m;
    private final b n;

    static {
    }

    i(b r4, c r5) {
        this.k = -1;
        this.l = 16;
        this.m = 16;
        this.f34798a = new int[16];
        this.f34799b = new int[16];
        this.f34800c = new int[16];
        this.f34801d = new float[16];
        this.f34802e = new int[16];
        this.f = new int[16];
        this.g = 0;
        this.h = -1;
        this.n = r4;
        this.i = r5;
        a();
    }

    @Override // com.obric.oui.constraintlayout.a.b.a
    public int c() {
        return this.g;
    }

    @Override // com.obric.oui.constraintlayout.a.b.a
    public h a(int r7) {
        int r0 = this.g;
        if (r0 != 0) goto L5;
        return null;
    L5:
        int r2 = this.h;
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L16;
        if (r3 != r7) goto L12;
        if (r2 == (-1)) goto L12;
        return this.i.f34673d[this.f34800c[r2]];
    L12:
        r2 = this.f[r2];
        if (r2 == (-1)) goto L16;
        r3 = r3 + 1;
    L16:
        return null;
    }

    @Override // com.obric.oui.constraintlayout.a.b.a
    public float b(int r5) {
        int r0 = this.g;
        int r1 = this.h;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (r2 == r5) goto L6;
        r1 = this.f[r1];
        if (r1 == (-1)) goto L16;
        r2 = r2 + 1;
        goto L3
    L16:
        return 0.0f;
    L6:
        return this.f34801d[r1];
    L11:
        return 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.a.b.a
    public boolean a(h r1) {
        if (c(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int c(h r6) {
        if (this.g == 0) goto L24;
        if (r6 == null) goto L24;
        int r7 = r6.f34789b;
        int r0 = r7 % this.m;
        int r1 = this.f34798a[r0];
        if (r1 != (-1)) goto L10;
        return -1;
    L10:
        if (this.f34800c[r1] != r7) goto L12;
        return r1;
    L12:
        int[] r2 = this.f34799b;
        if (r2[r1] == (-1)) goto L18;
        if (this.f34800c[r2[r1]] == r7) goto L18;
        r1 = r2[r1];
    L18:
        if (r2[r1] != (-1)) goto L21;
        return -1;
    L21:
        if (this.f34800c[r2[r1]] != r7) goto L24;
        return r2[r1];
    L24:
        return -1;
    }

    @Override // com.obric.oui.constraintlayout.a.b.a
    public float b(h r2) {
        int r3 = c(r2);
        if (r3 != (-1)) goto L5;
        return 0.0f;
    L5:
        return this.f34801d[r3];
    }

    public String toString() {
        String r0 = hashCode() + " { ";
        int r1 = this.g;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L18;
        h r3 = a(r2);
        if (r3 == null) goto L16;
        String r4 = r0 + r3 + " = " + b(r2) + " ";
        int r5 = c(r3);
        String r6 = r4 + "[p: ";
        if (this.f34802e[r5] == (-1)) goto L10;
        String r7 = r6 + this.i.f34673d[this.f34800c[this.f34802e[r5]]];
    L11:
        String r8 = r7 + ", n: ";
        if (this.f[r5] == (-1)) goto L14;
        String r9 = r8 + this.i.f34673d[this.f34800c[this.f[r5]]];
    L15:
        r0 = r9 + "]";
        goto L16
    L14:
        r9 = r8 + OProtocolTextEffectTextView.EffectNameNone;
        goto L15
    L10:
        r7 = r6 + OProtocolTextEffectTextView.EffectNameNone;
    L16:
        r2 = r2 + 1;
        goto L3
    L18:
        return r0 + " }";
    }

    @Override // com.obric.oui.constraintlayout.a.b.a
    public void a() {
        int r0 = this.g;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        h r3 = a(r2);
        if (r3 == null) goto L7;
        r3.b(this.n);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        int r1 = 0;
    L10:
        if (r1 >= this.l) goto L12;
        this.f34800c[r1] = -1;
        this.f34799b[r1] = -1;
        r1 = r1 + 1;
        goto L10
    L12:
        int r4 = 0;
    L14:
        if (r4 >= this.m) goto L16;
        this.f34798a[r4] = -1;
        r4 = r4 + 1;
        goto L14
    L16:
        this.g = 0;
        this.h = -1;
    }

    private void d() {
        int r0 = this.l * 2;
        this.f34800c = Arrays.copyOf(this.f34800c, r0);
        this.f34801d = Arrays.copyOf(this.f34801d, r0);
        this.f34802e = Arrays.copyOf(this.f34802e, r0);
        this.f = Arrays.copyOf(this.f, r0);
        this.f34799b = Arrays.copyOf(this.f34799b, r0);
        int r1 = this.l;
    L3:
        if (r1 >= r0) goto L5;
        this.f34800c[r1] = -1;
        this.f34799b[r1] = -1;
        r1 = r1 + 1;
        goto L3
    L5:
        this.l = r0;
    }

    private void a(h r4, int r5) {
        int r6 = r4.f34789b % this.m;
        int[] r0 = this.f34798a;
        int r1 = r0[r6];
        if (r1 != (-1)) goto L5;
        r0[r6] = r5;
    L9:
        this.f34799b[r5] = -1;
        return;
    L5:
        int[] r7 = this.f34799b;
        if (r7[r1] == (-1)) goto L8;
        r1 = r7[r1];
        goto L5
    L8:
        r7[r1] = r5;
        goto L9
    }

    private void d(h r6) {
        int r0 = r6.f34789b % this.m;
        int r1 = this.f34798a[r0];
        if (r1 != (-1)) goto L5;
        return;
    L5:
        int r7 = r6.f34789b;
        if (this.f34800c[r1] != r7) goto L8;
        int[] r8 = this.f34798a;
        int[] r5 = this.f34799b;
        r8[r0] = r5[r1];
        r5[r1] = -1;
        return;
    L8:
        int[] r2 = this.f34799b;
        if (r2[r1] == (-1)) goto L13;
        if (this.f34800c[r2[r1]] == r7) goto L13;
        r1 = r2[r1];
    L13:
        int r3 = r2[r1];
        if (r3 != (-1)) goto L16;
        return;
    L16:
        if (this.f34800c[r3] != r7) goto L23;
        r2[r1] = r2[r3];
        r2[r3] = -1;
        return;
    }

    private void a(int r3, h r4, float r5) {
        this.f34800c[r3] = r4.f34789b;
        this.f34801d[r3] = r5;
        this.f34802e[r3] = -1;
        this.f[r3] = -1;
        r4.a(this.n);
        r4.l++;
        this.g++;
    }

    private int e() {
        int r0 = 0;
    L4:
        if (r0 >= this.l) goto L9;
        if (this.f34800c[r0] == (-1)) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    private void b(int r4, h r5, float r6) {
        int r0 = e();
        a(r0, r5, r6);
        if (r4 == (-1)) goto L5;
        this.f34802e[r0] = r4;
        int[] r1 = this.f;
        r1[r0] = r1[r4];
        r1[r4] = r0;
    L9:
        int[] r7 = this.f;
        if (r7[r0] == (-1)) goto L12;
        this.f34802e[r7[r0]] = r0;
    L12:
        a(r5, r0);
        return;
    L5:
        this.f34802e[r0] = -1;
        if (this.g <= 0) goto L8;
        this.f[r0] = this.h;
        this.h = r0;
        goto L9
    L8:
        this.f[r0] = -1;
        goto L9
    }

    @Override // com.obric.oui.constraintlayout.a.b.a
    public void a(h r8, float r9) {
        float r0 = j;
        if (r9 > (-r0)) goto L5;
    L8:
        int r1 = 0;
        if (this.g != 0) goto L11;
        a(0, r8, r9);
        a(r8, 0);
        this.h = 0;
        return;
    L11:
        int r2 = c(r8);
        if (r2 == (-1)) goto L15;
        this.f34801d[r2] = r9;
        return;
    L15:
        if ((this.g + 1) < this.l) goto L17;
        d();
    L17:
        int r3 = this.g;
        int r4 = this.h;
        int r5 = -1;
    L18:
        if (r1 >= r3) goto L30;
        if (this.f34800c[r4] == r8.f34789b) goto L21;
        if (this.f34800c[r4] >= r8.f34789b) goto L26;
        r5 = r4;
    L26:
        r4 = this.f[r4];
        if (r4 == (-1)) goto L30;
        r1 = r1 + 1;
        goto L18
    L21:
        this.f34801d[r4] = r9;
        return;
    L30:
        b(r5, r8, r9);
        return;
    L5:
        if (r9 >= r0) goto L8;
        a(r8, true);
    }

    @Override // com.obric.oui.constraintlayout.a.b.a
    public float a(h r8, boolean r9) {
        int r0 = c(r8);
        if (r0 != (-1)) goto L6;
        return 0.0f;
    L6:
        d(r8);
        float r2 = this.f34801d[r0];
        if (this.h != r0) goto L9;
        this.h = this.f[r0];
    L9:
        this.f34800c[r0] = -1;
        int[] r3 = this.f34802e;
        if (r3[r0] == (-1)) goto L12;
        int[] r4 = this.f;
        r4[r3[r0]] = r4[r0];
    L12:
        int[] r5 = this.f;
        if (r5[r0] == (-1)) goto L15;
        r3[r5[r0]] = r3[r0];
    L15:
        this.g--;
        r8.l--;
        if (r9 == false) goto L18;
        r8.b(this.n);
    L18:
        return r2;
    }

    @Override // com.obric.oui.constraintlayout.a.b.a
    public void a(h r5, float r6, boolean r7) {
        float r0 = j;
        if (r6 > (-r0)) goto L5;
    L7:
        int r1 = c(r5);
        if (r1 != (-1)) goto L10;
        a(r5, r6);
        return;
    L10:
        float[] r2 = this.f34801d;
        r2[r1] = r2[r1] + r6;
        float r8 = r2[r1];
        float r3 = j;
        if (r8 > (-r3)) goto L13;
        return;
    L13:
        if (r2[r1] >= r3) goto L18;
        r2[r1] = 0.0f;
        a(r5, r7);
        return;
    L18:
        return;
    L5:
        if (r6 >= r0) goto L7;
    }

    @Override // com.obric.oui.constraintlayout.a.b.a
    public float a(b r8, boolean r9) {
        float r0 = b(r8.f34660a);
        a(r8.f34660a, r9);
        i r10 = (i) ZeusTransformUtils.preCheckCast(r8.f34664e, i.class, "com.obric.aiagent.plugin");
        int r1 = r10.c();
        int r2 = r10.h;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (r10.f34800c[r4] == (-1)) goto L7;
        a(this.i.f34673d[r10.f34800c[r4]], r10.f34801d[r4] * r0, r9);
        r3 = r3 + 1;
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r0;
    }

    @Override // com.obric.oui.constraintlayout.a.b.a
    public void b() {
        int r0 = this.g;
        int r1 = this.h;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        float[] r3 = this.f34801d;
        r3[r1] = r3[r1] * (-1.0f);
        r1 = this.f[r1];
        if (r1 == (-1)) goto L11;
        r2 = r2 + 1;
        goto L3
    L11:
        return;
    }

    @Override // com.obric.oui.constraintlayout.a.b.a
    public void a(float r6) {
        int r0 = this.g;
        int r1 = this.h;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        float[] r3 = this.f34801d;
        r3[r1] = r3[r1] / r6;
        r1 = this.f[r1];
        if (r1 == (-1)) goto L11;
        r2 = r2 + 1;
        goto L3
    L11:
        return;
    }
}
