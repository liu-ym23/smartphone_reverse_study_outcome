package androidx.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: ChainRun.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<p> f702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f703b;

    public c(androidx.constraintlayout.a.c.e r1, int r2) {
        super(r1);
        this.f702a = new ArrayList();
        this.h = r2;
        h();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ChainRun ");
        if (this.h != 0) goto L5;
        String r1 = "horizontal : ";
    L6:
        r0.append(r1);
        Iterator<p> r4 = this.f702a.iterator();
    L8:
        if (r4.hasNext() == false) goto L11;
        p r2 = (p) ZeusTransformUtils.preCheckCast(r4.next(), p.class, "com.obric.aiagent.plugin");
        r0.append("<");
        r0.append(r2);
        r0.append("> ");
        goto L8
    L11:
        return r0.toString();
    L5:
        r1 = "vertical : ";
        goto L6
    }

    @Override // androidx.constraintlayout.a.c.a.p
    boolean a() {
        int r0 = this.f702a.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (((p) ZeusTransformUtils.preCheckCast(this.f702a.get(r2), p.class, "com.obric.aiagent.plugin")).a() == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @Override // androidx.constraintlayout.a.c.a.p
    public long b() {
        int r0 = this.f702a.size();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        p r4 = (p) ZeusTransformUtils.preCheckCast(this.f702a.get(r3), p.class, "com.obric.aiagent.plugin");
        r1 = ((r1 + ((long) r4.j.f)) + r4.b()) + ((long) r4.k.f);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    private void h() {
        androidx.constraintlayout.a.c.e r0 = this.f743d;
        androidx.constraintlayout.a.c.e r1 = r0.y(this.h);
    L3:
        androidx.constraintlayout.a.c.e r5 = r1;
        androidx.constraintlayout.a.c.e r2 = r0;
        r0 = r5;
        if (r0 == null) goto L6;
        r1 = r0.y(this.h);
        goto L3
    L6:
        this.f743d = r2;
        this.f702a.add(r2.c(this.h));
        androidx.constraintlayout.a.c.e r3 = r2.z(this.h);
    L7:
        if (r3 == null) goto L9;
        this.f702a.add(r3.c(this.h));
        r3 = r3.z(this.h);
        goto L7
    L9:
        Iterator<p> r4 = this.f702a.iterator();
    L11:
        if (r4.hasNext() == false) goto L19;
        p r6 = (p) ZeusTransformUtils.preCheckCast(r4.next(), p.class, "com.obric.aiagent.plugin");
        if (this.h == 0) goto L14;
        if (this.h != 1) goto L11;
        r6.f743d.f772e = this;
        goto L11
    L14:
        r6.f743d.f771d = this;
        goto L11
    L19:
        if (this.h == 0) goto L21;
    L23:
        boolean r7 = false;
    L24:
        if (r7 == false) goto L29;
        if (this.f702a.size() <= 1) goto L29;
        ArrayList<p> r8 = this.f702a;
        this.f743d = ((p) ZeusTransformUtils.preCheckCast(r8.get(r8.size() - 1), p.class, "com.obric.aiagent.plugin")).f743d;
    L29:
        if (this.h != 0) goto L31;
        int r9 = this.f743d.W();
    L32:
        this.f703b = r9;
        return;
    L31:
        r9 = this.f743d.X();
        goto L32
    L21:
        if (((androidx.constraintlayout.a.c.f) ZeusTransformUtils.preCheckCast(this.f743d.A(), androidx.constraintlayout.a.c.f.class, "com.obric.aiagent.plugin")).ag() == false) goto L23;
        r7 = true;
        goto L24
    }

    @Override // androidx.constraintlayout.a.c.a.p
    void c() {
        this.f744e = null;
        Iterator<p> r3 = this.f702a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((p) ZeusTransformUtils.preCheckCast(r3.next(), p.class, "com.obric.aiagent.plugin")).c();
        goto L4
    }

    @Override // androidx.constraintlayout.a.c.a.p
    void d() {
        this.j.j = false;
        this.k.j = false;
    }

    @Override // androidx.constraintlayout.a.c.a.p, androidx.constraintlayout.a.c.a.d
    public void update(d r25) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r25, d.class, "com.obric.aiagent.plugin");
        if (this.j.j == true) goto L5;
        return;
    L5:
        if (this.k.j == false) goto L319;
        androidx.constraintlayout.a.c.e r2 = this.f743d.A();
        if (ZeusTransformUtils.instanceOf(r2, androidx.constraintlayout.a.c.f.class) == false) goto L10;
        boolean r3 = ((androidx.constraintlayout.a.c.f) ZeusTransformUtils.preCheckCast(r2, androidx.constraintlayout.a.c.f.class, "com.obric.aiagent.plugin")).ag();
    L11:
        int r4 = this.k.g - this.j.g;
        int r5 = this.f702a.size();
        int r6 = 0;
    L12:
        int r7 = -1;
        int r8 = 8;
        if (r6 >= r5) goto L17;
        if (((p) ZeusTransformUtils.preCheckCast(this.f702a.get(r6), p.class, "com.obric.aiagent.plugin")).f743d.B() != 8) goto L18;
        r6 = r6 + 1;
    L18:
        int r9 = r5 - 1;
        int r10 = r9;
    L19:
        if (r10 < 0) goto L24;
        if (((p) ZeusTransformUtils.preCheckCast(this.f702a.get(r10), p.class, "com.obric.aiagent.plugin")).f743d.B() != 8) goto L23;
        r10 = r10 - 1;
        goto L19
    L23:
        r7 = r10;
    L24:
        int r11 = 0;
    L26:
        if (r11 >= 2) goto L72;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        float r18 = 0.0f;
    L28:
        if (r14 >= r5) goto L67;
        p r12 = (p) ZeusTransformUtils.preCheckCast(this.f702a.get(r14), p.class, "com.obric.aiagent.plugin");
        if (r12.f743d.B() == r8) goto L66;
        r17 = r17 + 1;
        if (r14 <= 0) goto L36;
        if (r14 < r6) goto L36;
        r15 = r15 + r12.j.f;
    L36:
        int r13 = r12.g.g;
        if (r12.f == androidx.constraintlayout.a.c.e.a.f777c) goto L39;
        boolean r19 = true;
    L40:
        if (r19 == false) goto L52;
        if (this.h != 0) goto L47;
        if (r12.f743d.f.g.j == true) goto L47;
        return;
    L47:
        if (this.h == 1) goto L49;
    L58:
        if (r19 == true) goto L62;
        r16 = r16 + 1;
        float r20 = r12.f743d.ar[this.h];
        if (r20 < 0.0f) goto L63;
        r18 = r18 + r20;
    L63:
        if (r14 >= r9) goto L66;
        if (r14 >= r7) goto L66;
        r15 = r15 + (-r12.k.f);
        goto L66
    L62:
        r15 = r15 + r13;
        goto L63
    L49:
        if (r12.f743d.g.g.j == true) goto L58;
        return;
    L52:
        if (r12.f742c != 1) goto L56;
        if (r11 != 0) goto L56;
        r13 = r12.g.m;
        r16 = r16 + 1;
    L57:
        r19 = true;
    L56:
        if (r12.g.j == false) goto L58;
    L39:
        r19 = false;
    L66:
        r14 = r14 + 1;
        r8 = 8;
        goto L28
    L67:
        if (r15 < r4) goto L71;
        if (r16 == 0) goto L71;
        r11 = r11 + 1;
        r8 = 8;
    L71:
        int r21 = r16;
        int r22 = r17;
    L73:
        int r110 = this.j.g;
        if (r3 == false) goto L77;
        r110 = this.k.g;
    L77:
        if (r15 > r4) goto L79;
    L82:
        if (r21 <= 0) goto L134;
        float r111 = r4 - r15;
        int r112 = (int) ((r111 / r21) + 0.5f);
        int r113 = 0;
        int r114 = 0;
    L84:
        if (r113 >= r5) goto L112;
        int r115 = r112;
        p r116 = (p) ZeusTransformUtils.preCheckCast(this.f702a.get(r113), p.class, "com.obric.aiagent.plugin");
        int r23 = r15;
        if (r116.f743d.B() != 8) goto L89;
    L110:
        r111 = r111;
    L111:
        r113 = r113 + 1;
        r112 = r115;
        r15 = r23;
        r111 = r111;
        r110 = r110;
        r3 = r3;
        goto L84
    L89:
        if (r116.f != androidx.constraintlayout.a.c.e.a.f777c) goto L110;
        if (r116.g.j == true) goto L110;
        if (r18 <= 0.0f) goto L95;
        int r117 = (int) (((r116.f743d.ar[this.h] * r111) / r18) + 0.5f);
    L97:
        if (this.h != 0) goto L99;
        int r118 = r116.f743d.r;
        int r119 = r116.f743d.q;
    L101:
        if (r116.f742c != 1) goto L103;
        int r24 = Math.min(r117, r116.g.m);
    L104:
        int r26 = Math.max(r119, r24);
        if (r118 <= 0) goto L107;
        r26 = Math.min(r118, r26);
    L107:
        if (r26 == r117) goto L109;
        r114 = r114 + 1;
        r117 = r26;
    L109:
        r116.g.a(r117);
        goto L111
    L103:
        r24 = r117;
        goto L104
    L99:
        r118 = r116.f743d.u;
        r119 = r116.f743d.t;
        goto L101
    L95:
        r117 = r115;
        goto L97
    L112:
        boolean r27 = r3;
        int r28 = r110;
        int r29 = r15;
        if (r114 <= 0) goto L128;
        r21 = r21 - r114;
        int r30 = 0;
        int r120 = 0;
    L115:
        if (r30 >= r5) goto L127;
        p r121 = (p) ZeusTransformUtils.preCheckCast(this.f702a.get(r30), p.class, "com.obric.aiagent.plugin");
        if (r121.f743d.B() == 8) goto L126;
        if (r30 <= 0) goto L122;
        if (r30 < r6) goto L122;
        r120 = r120 + r121.j.f;
    L122:
        r120 = r120 + r121.g.g;
        if (r30 >= r9) goto L126;
        if (r30 >= r7) goto L126;
        r120 = r120 + (-r121.k.f);
    L126:
        r30 = r30 + 1;
        goto L115
    L127:
        r15 = r120;
    L129:
        int r122 = 2;
        if (this.f703b != 2) goto L133;
        if (r114 != 0) goto L133;
        int r31 = 0;
        this.f703b = 0;
    L135:
        if (r15 <= r4) goto L137;
        this.f703b = r122;
    L137:
        if (r22 <= 0) goto L141;
        if (r21 != 0) goto L141;
        if (r6 != r7) goto L141;
        this.f703b = r122;
    L141:
        int r123 = this.f703b;
        if (r123 != 1) goto L188;
        if (r22 <= 1) goto L145;
        int r32 = (r4 - r15) / (r22 - 1);
    L148:
        if (r21 <= 0) goto L150;
        r32 = r31;
    L150:
        int r33 = r31;
        int r124 = r28;
    L151:
        if (r33 >= r5) goto L320;
        if (r27 == false) goto L154;
        int r34 = r5 - (r33 + 1);
    L155:
        p r35 = (p) ZeusTransformUtils.preCheckCast(this.f702a.get(r34), p.class, "com.obric.aiagent.plugin");
        if (r35.f743d.B() != 8) goto L158;
        r35.j.a(r124);
        r35.k.a(r124);
    L187:
        r33 = r33 + 1;
        goto L151
    L158:
        if (r33 <= 0) goto L162;
        if (r27 == false) goto L161;
        r124 = r124 - r32;
        goto L162
    L161:
        r124 = r124 + r32;
    L162:
        if (r33 <= 0) goto L167;
        if (r33 < r6) goto L167;
        if (r27 == false) goto L166;
        r124 = r124 - r35.j.f;
        goto L167
    L166:
        r124 = r124 + r35.j.f;
    L167:
        if (r27 == false) goto L169;
        r35.k.a(r124);
    L170:
        int r36 = r35.g.g;
        if (r35.f == androidx.constraintlayout.a.c.e.a.f777c) goto L173;
    L175:
        if (r27 == false) goto L177;
        r124 = r124 - r36;
    L178:
        if (r27 == false) goto L180;
        r35.j.a(r124);
    L181:
        r35.i = true;
        if (r33 >= r9) goto L187;
        if (r33 >= r7) goto L187;
        if (r27 == false) goto L186;
        r124 = r124 - (-r35.k.f);
        goto L187
    L186:
        r124 = r124 + (-r35.k.f);
        goto L187
    L180:
        r35.k.a(r124);
        goto L181
    L177:
        r124 = r124 + r36;
        goto L178
    L173:
        if (r35.f742c != 1) goto L175;
        r36 = r35.g.m;
        goto L175
    L169:
        r35.j.a(r124);
        goto L170
    L154:
        r34 = r33;
        goto L155
    L320:
        return;
    L145:
        if (r22 != 1) goto L147;
        r32 = (r4 - r15) / 2;
        goto L148
    L147:
        r32 = r31;
        goto L148
    L188:
        if (r123 != 0) goto L229;
        int r37 = (r4 - r15) / (r22 + 1);
        if (r21 <= 0) goto L192;
        r37 = r31;
    L192:
        int r38 = r31;
        int r125 = r28;
    L193:
        if (r38 >= r5) goto L321;
        if (r27 == false) goto L196;
        int r39 = r5 - (r38 + 1);
    L197:
        p r40 = (p) ZeusTransformUtils.preCheckCast(this.f702a.get(r39), p.class, "com.obric.aiagent.plugin");
        if (r40.f743d.B() != 8) goto L200;
        r40.j.a(r125);
        r40.k.a(r125);
    L227:
        r38 = r38 + 1;
        goto L193
    L200:
        if (r27 == false) goto L202;
        int r126 = r125 - r37;
    L203:
        if (r38 <= 0) goto L208;
        if (r38 < r6) goto L208;
        if (r27 == false) goto L207;
        r126 = r126 - r40.j.f;
        goto L208
    L207:
        r126 = r126 + r40.j.f;
    L208:
        if (r27 == false) goto L210;
        r40.k.a(r126);
    L211:
        int r41 = r40.g.g;
        if (r40.f == androidx.constraintlayout.a.c.e.a.f777c) goto L214;
    L216:
        if (r27 == false) goto L218;
        r125 = r126 - r41;
    L219:
        if (r27 == false) goto L221;
        r40.j.a(r125);
    L222:
        if (r38 >= r9) goto L227;
        if (r38 >= r7) goto L227;
        if (r27 == false) goto L226;
        r125 = r125 - (-r40.k.f);
        goto L227
    L226:
        r125 = r125 + (-r40.k.f);
        goto L227
    L221:
        r40.k.a(r125);
        goto L222
    L218:
        r125 = r126 + r41;
        goto L219
    L214:
        if (r40.f742c != 1) goto L216;
        r41 = Math.min(r41, r40.g.m);
        goto L216
    L210:
        r40.j.a(r126);
        goto L211
    L202:
        r126 = r125 + r37;
        goto L203
    L196:
        r39 = r38;
        goto L197
    L321:
        return;
    L229:
        if (r123 == 2) goto L231;
        return;
    L231:
        if (this.h != 0) goto L233;
        float r42 = this.f743d.P();
    L234:
        if (r27 == false) goto L236;
        r42 = 1.0f - r42;
    L236:
        int r43 = (int) (((r4 - r15) * r42) + 0.5f);
        if (r43 < 0) goto L239;
        if (r21 > 0) goto L239;
    L240:
        if (r27 == false) goto L242;
        int r127 = r28 - r43;
    L243:
        int r44 = r31;
    L244:
        if (r44 >= r5) goto L322;
        if (r27 == false) goto L247;
        int r45 = r5 - (r44 + 1);
    L248:
        p r46 = (p) ZeusTransformUtils.preCheckCast(this.f702a.get(r45), p.class, "com.obric.aiagent.plugin");
        if (r46.f743d.B() != 8) goto L251;
        r46.j.a(r127);
        r46.k.a(r127);
    L276:
        r44 = r44 + 1;
        goto L244
    L251:
        if (r44 <= 0) goto L256;
        if (r44 < r6) goto L256;
        if (r27 == false) goto L255;
        r127 = r127 - r46.j.f;
        goto L256
    L255:
        r127 = r127 + r46.j.f;
    L256:
        if (r27 == false) goto L258;
        r46.k.a(r127);
    L259:
        int r47 = r46.g.g;
        if (r46.f != androidx.constraintlayout.a.c.e.a.f777c) goto L265;
        if (r46.f742c != 1) goto L265;
        r47 = r46.g.m;
    L265:
        if (r27 == false) goto L267;
        r127 = r127 - r47;
    L268:
        if (r27 == false) goto L270;
        r46.j.a(r127);
    L271:
        if (r44 >= r9) goto L276;
        if (r44 >= r7) goto L276;
        if (r27 == false) goto L275;
        r127 = r127 - (-r46.k.f);
        goto L276
    L275:
        r127 = r127 + (-r46.k.f);
        goto L276
    L270:
        r46.k.a(r127);
        goto L271
    L267:
        r127 = r127 + r47;
        goto L268
    L258:
        r46.j.a(r127);
        goto L259
    L247:
        r45 = r44;
        goto L248
    L322:
        return;
    L242:
        r127 = r28 + r43;
    L239:
        r43 = r31;
        goto L240
    L233:
        r42 = this.f743d.Q();
    L133:
        r31 = 0;
        goto L135
    L128:
        r15 = r29;
        goto L129
    L134:
        r27 = r3;
        r28 = r110;
        r31 = 0;
        r122 = 2;
        goto L135
    L79:
        if (r3 == false) goto L81;
        r110 = r110 + ((int) (((r15 - r4) / 2.0f) + 0.5f));
        goto L82
    L81:
        r110 = r110 - ((int) (((r15 - r4) / 2.0f) + 0.5f));
        goto L82
    L72:
        r21 = 0;
        r22 = 0;
        r15 = 0;
        r18 = 0.0f;
        goto L73
    L17:
        r6 = -1;
        goto L18
    L10:
        r3 = false;
        goto L11
    }

    @Override // androidx.constraintlayout.a.c.a.p
    public void e() {
        int r0 = 0;
    L4:
        if (r0 >= this.f702a.size()) goto L6;
        ((p) ZeusTransformUtils.preCheckCast(this.f702a.get(r0), p.class, "com.obric.aiagent.plugin")).e();
        r0 = r0 + 1;
        goto L4
    }

    private androidx.constraintlayout.a.c.e i() {
        int r0 = 0;
    L4:
        if (r0 >= this.f702a.size()) goto L10;
        p r1 = (p) ZeusTransformUtils.preCheckCast(this.f702a.get(r0), p.class, "com.obric.aiagent.plugin");
        if (r1.f743d.B() != 8) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r1.f743d;
    L10:
        return null;
    }

    private androidx.constraintlayout.a.c.e j() {
        int r0 = this.f702a.size() - 1;
    L3:
        if (r0 < 0) goto L9;
        p r1 = (p) ZeusTransformUtils.preCheckCast(this.f702a.get(r0), p.class, "com.obric.aiagent.plugin");
        if (r1.f743d.B() != 8) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        return r1.f743d;
    L9:
        return null;
    }

    @Override // androidx.constraintlayout.a.c.a.p
    void f() {
        Iterator<p> r0 = this.f702a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((p) ZeusTransformUtils.preCheckCast(r0.next(), p.class, "com.obric.aiagent.plugin")).f();
        goto L4
    L6:
        int r1 = this.f702a.size();
        if (r1 >= 1) goto L9;
        return;
    L9:
        androidx.constraintlayout.a.c.e r3 = ((p) ZeusTransformUtils.preCheckCast(this.f702a.get(0), p.class, "com.obric.aiagent.plugin")).f743d;
        androidx.constraintlayout.a.c.e r2 = ((p) ZeusTransformUtils.preCheckCast(this.f702a.get(r1 - 1), p.class, "com.obric.aiagent.plugin")).f743d;
        if (this.h != 0) goto L21;
        androidx.constraintlayout.a.c.d r4 = r3.A;
        androidx.constraintlayout.a.c.d r5 = r2.C;
        f r6 = a(r4, 0);
        int r7 = r4.i();
        androidx.constraintlayout.a.c.e r8 = i();
        if (r8 == null) goto L14;
        r7 = r8.A.i();
    L14:
        if (r6 == null) goto L16;
        a(this.j, r6, r7);
    L16:
        f r9 = a(r5, 0);
        int r10 = r5.i();
        androidx.constraintlayout.a.c.e r11 = j();
        if (r11 == null) goto L19;
        r10 = r11.C.i();
    L19:
        if (r9 == null) goto L31;
        a(this.k, r9, -r10);
    L31:
        this.j.f709a = this;
        this.k.f709a = this;
        return;
    L21:
        androidx.constraintlayout.a.c.d r12 = r3.B;
        androidx.constraintlayout.a.c.d r13 = r2.D;
        f r14 = a(r12, 1);
        int r15 = r12.i();
        androidx.constraintlayout.a.c.e r16 = i();
        if (r16 == null) goto L24;
        r15 = r16.B.i();
    L24:
        if (r14 == null) goto L26;
        a(this.j, r14, r15);
    L26:
        f r17 = a(r13, 1);
        int r18 = r13.i();
        androidx.constraintlayout.a.c.e r19 = j();
        if (r19 == null) goto L29;
        r18 = r19.D.i();
    L29:
        if (r17 == null) goto L31;
        a(this.k, r17, -r18);
        goto L31
    }
}
