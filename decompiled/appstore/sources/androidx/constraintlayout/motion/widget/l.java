package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public ArrayList A;
    public HashMap B;
    public HashMap C;
    public HashMap D;
    public j[] E;
    public int F;
    public int G;
    public View H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f1899J;
    public Interpolator K;
    public boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f1900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f1901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n f1906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f1907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f1908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k f1909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p001j.b[] f1910k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public p001j.b f1911l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f1912m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f1913n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f1914o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f1915p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f1916q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int[] f1917r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double[] f1918s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public double[] f1919t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String[] f1920u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f1921v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1922w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float[] f1923x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayList f1924y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float[] f1925z;

    public class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p001j.c f1926a;

        public a(p001j.c r10) {
            this.f1926a = r10;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            return (float) this.f1926a.a(r10);
        }
    }

    public l(View r10) {
        this.f1900a = new Rect();
        this.f1903d = false;
        this.f1905f = -1;
        this.f1906g = new n();
        this.f1907h = new n();
        this.f1908i = new k();
        this.f1909j = new k();
        this.f1912m = Float.NaN;
        this.f1913n = 0.0f;
        this.f1914o = 1.0f;
        this.f1922w = 4;
        this.f1923x = new float[4];
        this.f1924y = new ArrayList();
        this.f1925z = new float[1];
        this.A = new ArrayList();
        int r11 = c.f1833f;
        this.F = r11;
        this.G = r11;
        this.H = null;
        this.I = r11;
        this.f1899J = Float.NaN;
        this.K = null;
        this.L = false;
        L(r10);
    }

    public static Interpolator q(Context r10, int r11, String r12, int r13) {
        if (r11 == (-2)) goto L30;
        if (r11 == (-1)) goto L28;
        if (r11 == 0) goto L26;
        if (r11 == 1) goto L24;
        if (r11 == 2) goto L22;
        if (r11 == 4) goto L20;
        if (r11 == 5) goto L18;
        return null;
    L18:
        return new OvershootInterpolator();
    L20:
        return new BounceInterpolator();
    L22:
        return new DecelerateInterpolator();
    L24:
        return new AccelerateInterpolator();
    L26:
        return new AccelerateDecelerateInterpolator();
    L28:
        return new a(p001j.c.c(r12));
    L30:
        return AnimationUtils.loadInterpolator(r10, r13);
    }

    /* JADX WARN: Failed to calculate best type for var: r3v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v7 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v1 ??, new type: char
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public boolean A(android.view.View r21, float r22, long r23, p001j.d r25) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ef: INVOKE (r1v52 ?? I:android.view.ViewParent) = (r21v0 android.view.View) VIRTUAL call: android.view.View.getParent():android.view.ViewParent A[DECLARE_VAR, MD:():android.view.ViewParent (c)] in method: androidx.constraintlayout.motion.widget.l.A(android.view.View, float, long, j.d):boolean, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.l.A(android.view.View, float, long, j.d):boolean");
    }

    public void B(View r10, h r11, float r12, float r13, String[] r14, float[] r15) {
        RectF r16 = new RectF();
        n r17 = this.f1906g;
        float r18 = r17.f1932e;
        r16.left = r18;
        float r19 = r17.f1933f;
        r16.top = r19;
        r16.right = r18 + r17.f1934g;
        r16.bottom = r19 + r17.f1935h;
        RectF r20 = new RectF();
        n r21 = this.f1907h;
        float r22 = r21.f1932e;
        r20.left = r22;
        float r23 = r21.f1933f;
        r20.top = r23;
        r20.right = r22 + r21.f1934g;
        r20.bottom = r23 + r21.f1935h;
        r11.n(r10, r16, r20, r12, r13, r14, r15);
    }

    public final void C(n r10) {
        r10.p((int) this.f1901b.getX(), (int) this.f1901b.getY(), this.f1901b.getWidth(), this.f1901b.getHeight());
    }

    public void D() {
        this.f1903d = true;
    }

    public void E(Rect r10, Rect r11, int r12, int r13, int r14) {
        if (r12 == 1) goto L13;
        if (r12 != 2) goto L6;
        int r15 = r10.left + r10.right;
        r11.left = r13 - (((r10.top + r10.bottom) + r10.width()) / 2);
        r11.top = (r15 - r10.height()) / 2;
        r11.right = r11.left + r10.width();
        r11.bottom = r11.top + r10.height();
        return;
    L6:
        if (r12 != 3) goto L8;
        int r16 = r10.left + r10.right;
        r11.left = ((r10.height() / 2) + r10.top) - (r16 / 2);
        r11.top = r14 - ((r16 + r10.height()) / 2);
        r11.right = r11.left + r10.width();
        r11.bottom = r11.top + r10.height();
        return;
    L8:
        if (r12 != 4) goto L18;
        int r17 = r10.left + r10.right;
        r11.left = r13 - (((r10.bottom + r10.top) + r10.width()) / 2);
        r11.top = (r17 - r10.height()) / 2;
        r11.right = r11.left + r10.width();
        r11.bottom = r11.top + r10.height();
        return;
    L18:
        return;
    L13:
        int r18 = r10.left + r10.right;
        r11.left = ((r10.top + r10.bottom) - r10.width()) / 2;
        r11.top = r14 - ((r18 + r10.height()) / 2);
        r11.right = r11.left + r10.width();
        r11.bottom = r11.top + r10.height();
    }

    public void F(View r10) {
        n r11 = this.f1906g;
        r11.f1930c = 0.0f;
        r11.f1931d = 0.0f;
        this.L = true;
        r11.p(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        this.f1907h.p(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        this.f1908i.i(r10);
        this.f1909j.i(r10);
    }

    public void G(Rect r10, ConstraintSet r11, int r12, int r13) {
        int r14 = r11.f2269d;
        if (r14 == 0) goto L5;
        E(r10, this.f1900a, r14, r12, r13);
        r10 = this.f1900a;
    L5:
        n r15 = this.f1907h;
        r15.f1930c = 1.0f;
        r15.f1931d = 1.0f;
        C(r15);
        this.f1907h.p(r10.left, r10.top, r10.width(), r10.height());
        this.f1907h.a(r11.E(this.f1902c));
        this.f1909j.h(r10, r11, r14, this.f1902c);
    }

    public void H(int r10) {
        this.F = r10;
    }

    public void I(View r10) {
        n r11 = this.f1906g;
        r11.f1930c = 0.0f;
        r11.f1931d = 0.0f;
        r11.p(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        this.f1908i.i(r10);
    }

    public void J(Rect r10, ConstraintSet r11, int r12, int r13) {
        int r14 = r11.f2269d;
        if (r14 == 0) goto L5;
        E(r10, this.f1900a, r14, r12, r13);
    L5:
        n r15 = this.f1906g;
        r15.f1930c = 0.0f;
        r15.f1931d = 0.0f;
        C(r15);
        this.f1906g.p(r10.left, r10.top, r10.width(), r10.height());
        ConstraintSet.a r16 = r11.E(this.f1902c);
        this.f1906g.a(r16);
        this.f1912m = r16.f2276d.f2345g;
        this.f1908i.h(r10, r11, r14, this.f1902c);
        this.G = r16.f2278f.f2367i;
        ConstraintSet.c r17 = r16.f2276d;
        this.I = r17.f2349k;
        this.f1899J = r17.f2348j;
        Context r18 = this.f1901b.getContext();
        ConstraintSet.c r19 = r16.f2276d;
        this.K = q(r18, r19.f2351m, r19.f2350l, r19.f2352n);
    }

    public void K(m.e r10, View r11, int r12, int r13, int r14) {
        n r15 = this.f1906g;
        r15.f1930c = 0.0f;
        r15.f1931d = 0.0f;
        Rect r16 = new Rect();
        if (r12 != 1) goto L5;
        throw null;
    L5:
        if (r12 == 2) goto L8;
        this.f1906g.p(r16.left, r16.top, r16.width(), r16.height());
        throw null;
    L8:
        throw null;
    }

    public void L(View r10) {
        this.f1901b = r10;
        this.f1902c = r10.getId();
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        this.f1904e = ((ConstraintLayout.LayoutParams) r11).a();
        return;
    }

    public void M(int r17, int r18, float r19, long r20) {
        new HashSet();
        HashSet r10 = new HashSet();
        HashSet r11 = new HashSet();
        HashSet r12 = new HashSet();
        HashMap r13 = new HashMap();
        int r14 = this.F;
        if (r14 == c.f1833f) goto L5;
        this.f1906g.f1938k = r14;
    L5:
        this.f1908i.f(this.f1909j, r11);
        ArrayList r15 = this.A;
        if (r15 == null) goto L16;
        Iterator r16 = r15.iterator();
    L9:
        if (r16.hasNext() == false) goto L16;
        c r21 = (c) r16.next();
        if ((r21 instanceof g) == true) goto L12;
        r21.h(r13);
        r21.d(r11);
        goto L9
    L12:
        g r22 = (g) r21;
        z(new n(r17, r18, r22, this.f1906g, this.f1907h));
        int r23 = r22.f1872g;
        if (r23 == c.f1833f) goto L9;
        this.f1905f = r23;
    L16:
        char r24 = 1;
        if (r11.isEmpty() == true) goto L58;
        this.C = new HashMap();
        Iterator r25 = r11.iterator();
    L20:
        if (r25.hasNext() == false) goto L37;
        String r110 = (String) r25.next();
        if (r110.startsWith("CUSTOM,") == false) goto L33;
        SparseArray r111 = new SparseArray();
        String r112 = r110.split(",")[1];
        Iterator r113 = this.A.iterator();
    L25:
        if (r113.hasNext() == false) goto L32;
        c r114 = (c) r113.next();
        HashMap r115 = r114.f1838e;
        if (r115 == null) goto L25;
        ConstraintAttribute r116 = (ConstraintAttribute) r115.get(r112);
        if (r116 == null) goto L25;
        r111.append(r114.f1834a, r116);
        goto L25
    L32:
        m.d r117 = m.d.f(r110, r111);
    L34:
        if (r117 == null) goto L20;
        r117.d(r110);
        this.C.put(r110, r117);
        goto L20
    L33:
        r117 = m.d.g(r110);
        goto L34
    L37:
        ArrayList r26 = this.A;
        if (r26 == null) goto L45;
        Iterator r27 = r26.iterator();
    L41:
        if (r27.hasNext() == false) goto L45;
        c r118 = (c) r27.next();
        if ((r118 instanceof d) == false) goto L41;
        r118.a(this.C);
    L45:
        this.f1908i.a(this.C, 0);
        this.f1909j.a(this.C, 100);
        Iterator r28 = this.C.keySet().iterator();
    L47:
        if (r28.hasNext() == false) goto L58;
        String r119 = (String) r28.next();
        if (r13.containsKey(r119) == false) goto L53;
        Integer r120 = (Integer) r13.get(r119);
        if (r120 == null) goto L53;
        int r121 = r120.intValue();
    L54:
        androidx.constraintlayout.core.motion.utils.b r122 = (androidx.constraintlayout.core.motion.utils.b) this.C.get(r119);
        if (r122 == null) goto L47;
        r122.e(r121);
    L53:
        r121 = 0;
    L58:
        if (r10.isEmpty() == false) goto L60;
    L98:
        int r29 = this.f1924y.size();
        int r30 = r29 + 2;
        n[] r31 = new n[r30];
        r31[0] = this.f1906g;
        r31[r29 + 1] = this.f1907h;
        if (this.f1924y.size() > 0) goto L101;
    L103:
        Iterator r32 = this.f1924y.iterator();
        int r33 = 1;
    L105:
        if (r32.hasNext() == false) goto L107;
        r31[r33] = (n) r32.next();
        r33 = r33 + 1;
        goto L105
    L107:
        HashSet r34 = new HashSet();
        Iterator r35 = this.f1907h.f1942o.keySet().iterator();
    L109:
        if (r35.hasNext() == false) goto L115;
        String r123 = (String) r35.next();
        if (this.f1906g.f1942o.containsKey(r123) == false) goto L109;
        if (r11.contains("CUSTOM," + r123) == true) goto L109;
        r34.add(r123);
        goto L109
    L115:
        String[] r36 = (String[]) r34.toArray(new String[0]);
        this.f1920u = r36;
        this.f1921v = new int[r36.length];
        int r37 = 0;
    L116:
        String[] r38 = this.f1920u;
        if (r37 >= r38.length) goto L128;
        String r39 = r38[r37];
        this.f1921v[r37] = 0;
        int r40 = 0;
    L119:
        if (r40 >= r30) goto L126;
        if (r31[r40].f1942o.containsKey(r39) == false) goto L125;
        ConstraintAttribute r41 = (ConstraintAttribute) r31[r40].f1942o.get(r39);
        if (r41 == null) goto L125;
        int[] r42 = this.f1921v;
        r42[r37] = r42[r37] + r41.g();
    L125:
        r40 = r40 + 1;
    L126:
        r37 = r37 + 1;
        goto L116
    L128:
        if (r31[0].f1938k == c.f1833f) goto L130;
        boolean r43 = true;
    L131:
        int r44 = 18 + r38.length;
        boolean[] r45 = new boolean[r44];
        int r46 = 1;
    L132:
        if (r46 >= r30) goto L134;
        r31[r46].d(r31[r46 - 1], r45, this.f1920u, r43);
        r46 = r46 + 1;
        goto L132
    L134:
        int r47 = 0;
        int r48 = 1;
    L135:
        if (r48 >= r44) goto L140;
        if (r45[r48] == false) goto L139;
        r47 = r47 + 1;
    L139:
        r48 = r48 + 1;
        goto L135
    L140:
        this.f1917r = new int[r47];
        int r49 = 2;
        int r50 = Math.max(2, r47);
        this.f1918s = new double[r50];
        this.f1919t = new double[r50];
        int r124 = 0;
        int r51 = 1;
    L141:
        if (r51 >= r44) goto L146;
        if (r45[r51] == false) goto L145;
        this.f1917r[r124] = r51;
        r124 = r124 + 1;
    L145:
        r51 = r51 + 1;
        goto L141
    L146:
        double[][] r52 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r30, this.f1917r.length});
        double[] r53 = new double[r30];
        int r54 = 0;
    L147:
        if (r54 >= r30) goto L149;
        r31[r54].e(r52[r54], this.f1917r);
        r53[r54] = r31[r54].f1930c;
        r54 = r54 + 1;
        goto L147
    L149:
        int r55 = 0;
    L150:
        int[] r125 = this.f1917r;
        if (r55 >= r125.length) goto L158;
        if (r125[r55] >= n.f1927t.length) goto L157;
        String r126 = n.f1927t[this.f1917r[r55]] + " [";
        int r127 = 0;
    L155:
        if (r127 >= r30) goto L157;
        r126 = r126 + r52[r127][r55];
        r127 = r127 + 1;
    L157:
        r55 = r55 + 1;
        goto L150
    L158:
        this.f1910k = new p001j.b[this.f1920u.length + 1];
        int r56 = 0;
    L159:
        String[] r128 = this.f1920u;
        if (r56 >= r128.length) goto L171;
        String r129 = r128[r56];
        double[] r130 = null;
        int r131 = 0;
        int r132 = 0;
        double[][] r133 = null;
    L162:
        if (r131 >= r30) goto L170;
        if (r31[r131].k(r129) == false) goto L169;
        if (r133 != null) goto L167;
        r130 = new double[r30];
        int[] r134 = new int[r49];
        r134[r24] = r31[r131].i(r129);
        r134[0] = r30;
        r133 = (double[][]) Array.newInstance(Double.TYPE, r134);
    L167:
        n r135 = r31[r131];
        r130[r132] = r135.f1930c;
        r135.h(r129, r133[r132], 0);
        r132 = r132 + 1;
    L169:
        r131 = r131 + 1;
        r52 = r52;
        r49 = 2;
        r24 = 1;
        goto L162
    L170:
        r56 = r56 + 1;
        this.f1910k[r56] = p001j.b.a(this.f1905f, Arrays.copyOf(r130, r132), (double[][]) Arrays.copyOf(r133, r132));
        r52 = r52;
        r49 = 2;
        r24 = 1;
        goto L159
    L171:
        this.f1910k[0] = p001j.b.a(this.f1905f, r53, r52);
        if (r31[0].f1938k == c.f1833f) goto L177;
        int[] r57 = new int[r30];
        double[] r58 = new double[r30];
        double[][] r59 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r30, 2});
        int r60 = 0;
    L174:
        if (r60 >= r30) goto L176;
        n r61 = r31[r60];
        r57[r60] = r61.f1938k;
        r58[r60] = r61.f1930c;
        double[] r136 = r59[r60];
        r136[0] = r61.f1932e;
        r136[1] = r61.f1933f;
        r60 = r60 + 1;
        goto L174
    L176:
        this.f1911l = p001j.b.b(r57, r58, r59);
    L177:
        this.D = new HashMap();
        if (this.A == null) goto L199;
        Iterator r62 = r12.iterator();
        float r63 = Float.NaN;
    L181:
        if (r62.hasNext() == false) goto L191;
        String r64 = (String) r62.next();
        m.c r65 = m.c.f(r64);
        if (r65 == null) goto L181;
        if (r65.e() == true) goto L188;
    L190:
        r65.c(r64);
        this.D.put(r64, r65);
        goto L181
    L188:
        if (Float.isNaN(r63) == false) goto L190;
        r63 = v();
        goto L190
    L191:
        Iterator r66 = this.A.iterator();
    L193:
        if (r66.hasNext() == false) goto L195;
        c r67 = (c) r66.next();
        goto L193
    L195:
        Iterator r68 = this.D.values().iterator();
    L197:
        if (r68.hasNext() == false) goto L285;
        ((m.c) r68.next()).d(r63);
        goto L197
    L285:
        return;
    L199:
        return;
    L130:
        r43 = false;
        goto L131
    L101:
        if (this.f1905f != (-1)) goto L103;
        this.f1905f = 0;
        goto L103
    L60:
        if (this.B != null) goto L62;
        this.B = new HashMap();
    L62:
        Iterator r69 = r10.iterator();
    L64:
        if (r69.hasNext() == false) goto L84;
        String r70 = (String) r69.next();
        if (this.B.containsKey(r70) == true) goto L64;
        if (r70.startsWith("CUSTOM,") == false) goto L80;
        SparseArray r137 = new SparseArray();
        String r138 = r70.split(",")[1];
        Iterator r139 = this.A.iterator();
    L72:
        if (r139.hasNext() == false) goto L79;
        c r140 = (c) r139.next();
        HashMap r141 = r140.f1838e;
        if (r141 == null) goto L72;
        ConstraintAttribute r142 = (ConstraintAttribute) r141.get(r138);
        if (r142 == null) goto L72;
        r137.append(r140.f1834a, r142);
        goto L72
    L79:
        m.f r143 = m.f.f(r70, r137);
    L81:
        if (r143 == null) goto L64;
        r143.c(r70);
        this.B.put(r70, r143);
        goto L64
    L80:
        r143 = m.f.g(r70, r20);
        goto L81
    L84:
        ArrayList r71 = this.A;
        if (r71 == null) goto L90;
        Iterator r72 = r71.iterator();
    L88:
        if (r72.hasNext() == false) goto L90;
        c r73 = (c) r72.next();
    L90:
        Iterator r74 = this.B.keySet().iterator();
    L92:
        if (r74.hasNext() == false) goto L98;
        String r75 = (String) r74.next();
        if (r13.containsKey(r75) == false) goto L96;
        int r76 = ((Integer) r13.get(r75)).intValue();
    L97:
        ((m.f) this.B.get(r75)).d(r76);
        goto L92
    L96:
        r76 = 0;
        goto L97
    }

    public void N(l r10) {
        this.f1906g.s(r10, r10.f1906g);
        this.f1907h.s(r10, r10.f1907h);
    }

    public void a(c r10) {
        this.A.add(r10);
    }

    public void b(ArrayList r10) {
        this.A.addAll(r10);
    }

    public int c(float[] r11, int[] r12) {
        if (r11 == null) goto L16;
        double[] r10 = this.f1910k[0].h();
        if (r12 == null) goto L10;
        Iterator r13 = this.f1924y.iterator();
        int r14 = 0;
    L8:
        if (r13.hasNext() == false) goto L10;
        r12[r14] = ((n) r13.next()).f1943p;
        r14 = r14 + 1;
    L10:
        int r15 = 0;
        int r16 = 0;
    L12:
        if (r15 >= r10.length) goto L15;
        this.f1910k[0].d(r10[r15], this.f1918s);
        this.f1906g.f(r10[r15], this.f1917r, this.f1918s, r11, r16);
        r16 = r16 + 2;
        r15 = r15 + 1;
        goto L12
    L15:
        return r16 / 2;
    L16:
        return 0;
    }

    public void d(float[] r21, int r22) {
        float r10 = 1.0f;
        float r11 = 1.0f / (r22 - 1);
        HashMap r12 = this.C;
        m.c r13 = null;
        if (r12 != null) goto L5;
        androidx.constraintlayout.core.motion.utils.b r14 = null;
    L6:
        HashMap r15 = this.C;
        if (r15 != null) goto L9;
        androidx.constraintlayout.core.motion.utils.b r16 = null;
    L10:
        HashMap r17 = this.D;
        if (r17 != null) goto L13;
        m.c r18 = null;
    L14:
        HashMap r19 = this.D;
        if (r19 != null) goto L17;
    L16:
        m.c r110 = r13;
        int r20 = 0;
    L19:
        if (r20 >= r22) goto L64;
        float r23 = r20 * r11;
        float r24 = this.f1914o;
        float r25 = 0.0f;
        if (r24 == r10) goto L30;
        float r26 = this.f1913n;
        if (r23 >= r26) goto L26;
        r23 = 0.0f;
    L26:
        if (r23 <= r26) goto L30;
        if (r23 >= 1.0d) goto L30;
        r23 = Math.min((r23 - r26) * r24, r10);
    L30:
        float r27 = r23;
        double r28 = r27;
        p001j.c r29 = this.f1906g.f1928a;
        Iterator r30 = this.f1924y.iterator();
        float r111 = Float.NaN;
    L32:
        if (r30.hasNext() == false) goto L42;
        n r31 = (n) r30.next();
        p001j.c r112 = r31.f1928a;
        double r113 = r28;
        if (r112 == null) goto L41;
        float r32 = r31.f1930c;
        if (r32 >= r27) goto L39;
        r25 = r32;
        r29 = r112;
        goto L41
    L39:
        if (Float.isNaN(r111) == false) goto L41;
        r111 = r31.f1930c;
    L41:
        r28 = r113;
        goto L32
    L42:
        double r114 = r28;
        if (r29 != null) goto L45;
        double r33 = r114;
    L49:
        this.f1910k[0].d(r33, this.f1918s);
        p001j.b r34 = this.f1911l;
        if (r34 == null) goto L54;
        double[] r35 = this.f1918s;
        if (r35.length <= 0) goto L54;
        r34.d(r33, r35);
    L54:
        int r115 = r20 * 2;
        int r116 = r20;
        this.f1906g.f(r33, this.f1917r, this.f1918s, r21, r115);
        if (r18 == null) goto L57;
        r21[r115] = r21[r115] + r18.a(r27);
    L59:
        if (r110 == null) goto L61;
        int r117 = r115 + 1;
        r21[r117] = r21[r117] + r110.a(r27);
    L63:
        r20 = r116 + 1;
        r10 = 1.0f;
        goto L19
    L61:
        if (r16 == null) goto L63;
        int r118 = r115 + 1;
        r21[r118] = r21[r118] + r16.a(r27);
        goto L63
    L57:
        if (r14 == null) goto L59;
        r21[r115] = r21[r115] + r14.a(r27);
        goto L59
    L45:
        if (Float.isNaN(r111) == false) goto L47;
        r111 = 1.0f;
    L47:
        float r119 = r111 - r25;
        r33 = (((float) r29.a((r27 - r25) / r119)) * r119) + r25;
        goto L49
    L64:
        return;
    L17:
        r13 = (m.c) r19.get("translationY");
        goto L16
    L13:
        r18 = (m.c) r17.get("translationX");
        goto L14
    L9:
        r16 = (androidx.constraintlayout.core.motion.utils.b) r15.get("translationY");
        goto L10
    L5:
        r14 = (androidx.constraintlayout.core.motion.utils.b) r12.get("translationX");
        goto L6
    }

    public void e(float r10, float[] r11, int r12) {
        this.f1910k[0].d(g(r10, null), this.f1918s);
        this.f1906g.j(this.f1917r, this.f1918s, r11, r12);
    }

    public void f(boolean r10) {
        if ("button".equals(androidx.constraintlayout.motion.widget.a.d(this.f1901b)) == false) goto L11;
        j[] r11 = this.E;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.length <= 0) goto L13;
        j r12 = r11[0];
        throw null;
    L13:
        return;
    }

    public final float g(float r11, float[] r12) {
        float r10 = 0.0f;
        float r13 = 1.0f;
        if (r12 == null) goto L5;
        r12[0] = 1.0f;
    L15:
        p001j.c r14 = this.f1906g.f1928a;
        Iterator r15 = this.f1924y.iterator();
        float r16 = Float.NaN;
    L17:
        if (r15.hasNext() == false) goto L26;
        n r17 = (n) r15.next();
        p001j.c r18 = r17.f1928a;
        if (r18 == null) goto L17;
        float r19 = r17.f1930c;
        if (r19 < r11) goto L22;
        if (Float.isNaN(r16) == false) goto L17;
        r16 = r17.f1930c;
        goto L17
    L22:
        r14 = r18;
        r10 = r19;
        goto L17
    L26:
        if (r14 != null) goto L28;
        return r11;
    L28:
        if (Float.isNaN(r16) == true) goto L31;
        r13 = r16;
    L31:
        float r20 = r13 - r10;
        double r110 = (r11 - r10) / r20;
        float r21 = r10 + (((float) r14.a(r110)) * r20);
        if (r12 == null) goto L35;
        r12[0] = (float) r14.b(r110);
    L35:
        return r21;
    L5:
        float r22 = this.f1914o;
        if (r22 == 1.0d) goto L15;
        float r23 = this.f1913n;
        if (r11 >= r23) goto L11;
        r11 = 0.0f;
    L11:
        if (r11 <= r23) goto L15;
        if (r11 >= 1.0d) goto L15;
        r11 = Math.min((r11 - r23) * r22, 1.0f);
        goto L15
    }

    public int h() {
        return this.f1906g.f1939l;
    }

    public int i(String r10, float[] r11, int r12) {
        androidx.constraintlayout.core.motion.utils.b r13 = (androidx.constraintlayout.core.motion.utils.b) this.C.get(r10);
        if (r13 != null) goto L6;
        return -1;
    L6:
        int r14 = 0;
    L8:
        if (r14 >= r11.length) goto L11;
        r11[r14] = r13.a(r14 / (r11.length - 1));
        r14 = r14 + 1;
        goto L8
    L11:
        return r11.length;
    }

    public void j(double r10, float[] r12, float[] r13) {
        double[] r11 = new double[4];
        double[] r14 = new double[4];
        this.f1910k[0].d(r10, r11);
        this.f1910k[0].g(r10, r14);
        Arrays.fill(r13, 0.0f);
        this.f1906g.g(r10, this.f1917r, r11, r12, r14, r13);
    }

    public float k() {
        return this.f1915p;
    }

    public float l() {
        return this.f1916q;
    }

    public void m(float r12, float r13, float r14, float[] r15) {
        float r16 = g(r12, this.f1925z);
        p001j.b[] r10 = this.f1910k;
        int r11 = 0;
        if (r10 == null) goto L16;
        double r17 = r16;
        r10[0].g(r17, this.f1919t);
        this.f1910k[0].d(r17, this.f1918s);
        float r18 = this.f1925z[0];
    L5:
        double[] r19 = this.f1919t;
        if (r11 >= r19.length) goto L8;
        r19[r11] = r19[r11] * ((double) r18);
        r11 = r11 + 1;
        goto L5
    L8:
        p001j.b r110 = this.f1911l;
        if (r110 == null) goto L14;
        double[] r20 = this.f1918s;
        if (r20.length <= 0) goto L19;
        r110.d(r17, r20);
        this.f1911l.g(r17, this.f1919t);
        this.f1906g.q(r13, r14, r15, this.f1917r, this.f1919t, this.f1918s);
        return;
    L19:
        return;
    L14:
        this.f1906g.q(r13, r14, r15, this.f1917r, r19, this.f1918s);
        return;
    L16:
        n r111 = this.f1907h;
        float r21 = r111.f1932e;
        n r112 = this.f1906g;
        float r22 = r21 - r112.f1932e;
        float r23 = r111.f1933f - r112.f1933f;
        float r24 = (r111.f1934g - r112.f1934g) + r22;
        float r113 = (r111.f1935h - r112.f1935h) + r23;
        r15[0] = (r22 * (1.0f - r13)) + (r24 * r13);
        r15[1] = (r23 * (1.0f - r14)) + (r113 * r14);
    }

    public int n() {
        int r10 = this.f1906g.f1929b;
        Iterator r11 = this.f1924y.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r10 = Math.max(r10, ((n) r11.next()).f1929b);
        goto L4
    L7:
        return Math.max(r10, this.f1907h.f1929b);
    }

    public float o() {
        return this.f1907h.f1932e;
    }

    public float p() {
        return this.f1907h.f1933f;
    }

    public n r(int r10) {
        return (n) this.f1924y.get(r10);
    }

    public float s(int r10, float r11, float r12) {
        n r13 = this.f1907h;
        float r14 = r13.f1932e;
        n r15 = this.f1906g;
        float r16 = r15.f1932e;
        float r17 = r14 - r16;
        float r18 = r13.f1933f;
        float r19 = r15.f1933f;
        float r20 = r18 - r19;
        float r21 = r16 + (r15.f1934g / 2.0f);
        float r22 = r19 + (r15.f1935h / 2.0f);
        float r23 = (float) Math.hypot(r17, r20);
        if (r23 >= 1.0E-7d) goto L6;
        return Float.NaN;
    L6:
        float r110 = r11 - r21;
        float r111 = r12 - r22;
        if (((float) Math.hypot(r110, r111)) != 0.0f) goto L9;
        return 0.0f;
    L9:
        float r24 = (r110 * r17) + (r111 * r20);
        if (r10 == 0) goto L33;
        if (r10 == 1) goto L31;
        if (r10 == 2) goto L29;
        if (r10 == 3) goto L27;
        if (r10 == 4) goto L25;
        if (r10 == 5) goto L23;
        return 0.0f;
    L23:
        return r111 / r20;
    L25:
        return r110 / r20;
    L27:
        return r111 / r17;
    L29:
        return r110 / r17;
    L31:
        return (float) Math.sqrt((r23 * r23) - (r24 * r24));
    L33:
        return r24 / r23;
    }

    public h t(int r11, int r12, float r13, float r14) {
        RectF r10 = new RectF();
        n r15 = this.f1906g;
        float r16 = r15.f1932e;
        r10.left = r16;
        float r17 = r15.f1933f;
        r10.top = r17;
        r10.right = r16 + r15.f1934g;
        r10.bottom = r17 + r15.f1935h;
        RectF r18 = new RectF();
        n r19 = this.f1907h;
        float r20 = r19.f1932e;
        r18.left = r20;
        float r21 = r19.f1933f;
        r18.top = r21;
        r18.right = r20 + r19.f1934g;
        r18.bottom = r21 + r19.f1935h;
        Iterator r110 = this.A.iterator();
    L4:
        if (r110.hasNext() == false) goto L10;
        c r22 = (c) r110.next();
        if ((r22 instanceof h) == false) goto L4;
        h r23 = (h) r22;
        if (r23.m(r11, r12, r10, r18, r13, r14) == false) goto L4;
        return r23;
    L10:
        return null;
    }

    public String toString() {
        return " start: x: " + this.f1906g.f1932e + " y: " + this.f1906g.f1933f + " end: x: " + this.f1907h.f1932e + " y: " + this.f1907h.f1933f;
    }

    public void u(float r19, int r20, int r21, float r22, float r23, float[] r24) {
        float r10 = g(r19, this.f1925z);
        HashMap r11 = this.C;
        m.c r12 = null;
        if (r11 != null) goto L5;
        androidx.constraintlayout.core.motion.utils.b r13 = null;
    L6:
        HashMap r14 = this.C;
        if (r14 != null) goto L9;
        androidx.constraintlayout.core.motion.utils.b r15 = null;
    L10:
        HashMap r16 = this.C;
        if (r16 != null) goto L13;
        androidx.constraintlayout.core.motion.utils.b r17 = null;
    L14:
        HashMap r18 = this.C;
        if (r18 != null) goto L17;
        androidx.constraintlayout.core.motion.utils.b r25 = null;
    L18:
        HashMap r110 = this.C;
        if (r110 != null) goto L21;
        androidx.constraintlayout.core.motion.utils.b r111 = null;
    L22:
        HashMap r112 = this.D;
        if (r112 != null) goto L25;
        m.c r26 = null;
    L26:
        HashMap r113 = this.D;
        if (r113 != null) goto L29;
        m.c r27 = null;
    L30:
        HashMap r114 = this.D;
        if (r114 != null) goto L33;
        m.c r28 = null;
    L34:
        HashMap r115 = this.D;
        if (r115 != null) goto L37;
        m.c r116 = null;
    L38:
        HashMap r117 = this.D;
        if (r117 == null) goto L42;
        r12 = (m.c) r117.get("scaleY");
    L42:
        p001j.m r118 = new p001j.m();
        r118.b();
        r118.d(r17, r10);
        r118.h(r13, r15, r10);
        r118.f(r25, r111, r10);
        r118.c(r28, r10);
        r118.g(r26, r27, r10);
        r118.e(r116, r12, r10);
        p001j.b r119 = this.f1911l;
        if (r119 == null) goto L49;
        double[] r29 = this.f1918s;
        if (r29.length <= 0) goto L47;
        double r30 = r10;
        r119.d(r30, r29);
        this.f1911l.g(r30, this.f1919t);
        this.f1906g.q(r22, r23, r24, this.f1917r, this.f1919t, this.f1918s);
    L47:
        r118.a(r22, r23, r20, r21, r24);
        return;
    L49:
        int r120 = 0;
        if (this.f1910k == null) goto L57;
        double r31 = g(r10, this.f1925z);
        this.f1910k[0].g(r31, this.f1919t);
        this.f1910k[0].d(r31, this.f1918s);
        float r32 = this.f1925z[0];
    L52:
        double[] r33 = this.f1919t;
        if (r120 >= r33.length) goto L55;
        r33[r120] = r33[r120] * ((double) r32);
        r120 = r120 + 1;
        goto L52
    L55:
        this.f1906g.q(r22, r23, r24, this.f1917r, r33, this.f1918s);
        r118.a(r22, r23, r20, r21, r24);
        return;
    L57:
        n r121 = this.f1907h;
        float r122 = r121.f1932e;
        n r34 = this.f1906g;
        float r123 = r122 - r34.f1932e;
        m.c r124 = r12;
        float r125 = r121.f1933f - r34.f1933f;
        m.c r126 = r116;
        float r35 = (r121.f1934g - r34.f1934g) + r123;
        float r127 = (r121.f1935h - r34.f1935h) + r125;
        r24[0] = (r123 * (1.0f - r22)) + (r35 * r22);
        r24[1] = (r125 * (1.0f - r23)) + (r127 * r23);
        r118.b();
        r118.d(r17, r10);
        r118.h(r13, r15, r10);
        r118.f(r25, r111, r10);
        r118.c(r28, r10);
        r118.g(r26, r27, r10);
        r118.e(r126, r124, r10);
        r118.a(r22, r23, r20, r21, r24);
        return;
    L37:
        r116 = (m.c) r115.get("scaleX");
        goto L38
    L33:
        r28 = (m.c) r114.get("rotation");
        goto L34
    L29:
        r27 = (m.c) r113.get("translationY");
        goto L30
    L25:
        r26 = (m.c) r112.get("translationX");
        goto L26
    L21:
        r111 = (androidx.constraintlayout.core.motion.utils.b) r110.get("scaleY");
        goto L22
    L17:
        r25 = (androidx.constraintlayout.core.motion.utils.b) r18.get("scaleX");
        goto L18
    L13:
        r17 = (androidx.constraintlayout.core.motion.utils.b) r16.get("rotation");
        goto L14
    L9:
        r15 = (androidx.constraintlayout.core.motion.utils.b) r14.get("translationY");
        goto L10
    L5:
        r13 = (androidx.constraintlayout.core.motion.utils.b) r11.get("translationX");
        goto L6
    }

    public final float v() {
        float[] r10 = new float[2];
        float r11 = 1.0f / 99;
        double r13 = 0.0d;
        double r15 = 0.0d;
        float r12 = 0.0f;
        int r14 = 0;
    L4:
        if (r14 >= 100) goto L28;
        float r16 = r14 * r11;
        double r17 = r16;
        p001j.c r18 = this.f1906g.f1928a;
        Iterator r19 = this.f1924y.iterator();
        float r110 = Float.NaN;
        float r111 = 0.0f;
    L7:
        if (r19.hasNext() == false) goto L17;
        n r20 = (n) r19.next();
        p001j.c r112 = r20.f1928a;
        if (r112 == null) goto L7;
        float r113 = r20.f1930c;
        if (r113 >= r16) goto L14;
        r18 = r112;
        r111 = r113;
        goto L7
    L14:
        if (Float.isNaN(r110) == false) goto L7;
        r110 = r20.f1930c;
        goto L7
    L17:
        if (r18 != null) goto L19;
    L22:
        this.f1910k[0].d(r17, this.f1918s);
        float r114 = r12;
        int r115 = r14;
        this.f1906g.f(r17, this.f1917r, this.f1918s, r10, 0);
        if (r115 <= 0) goto L25;
        char r21 = 0;
        float r22 = (float) (((double) r114) + Math.hypot(r15 - ((double) r10[1]), r13 - ((double) r10[0])));
    L26:
        r13 = r10[r21];
        r14 = r115 + 1;
        r12 = r22;
        r15 = r10[1];
        goto L4
    L25:
        r21 = 0;
        r22 = r114;
        goto L26
    L19:
        if (Float.isNaN(r110) == false) goto L21;
        r110 = 1.0f;
    L21:
        float r116 = r110 - r111;
        r17 = (((float) r18.a((r16 - r111) / r116)) * r116) + r111;
        goto L22
    L28:
        return r12;
    }

    public float w() {
        return this.f1906g.f1932e;
    }

    public float x() {
        return this.f1906g.f1933f;
    }

    public View y() {
        return this.f1901b;
    }

    public final void z(n r10) {
        int r11 = Collections.binarySearch(this.f1924y, r10);
        if (r11 != 0) goto L5;
        Log.e("MotionController", " KeyPath position \"" + r10.f1931d + "\" outside of range");
    L5:
        this.f1924y.add((-r11) - 1, r10);
    }
}
