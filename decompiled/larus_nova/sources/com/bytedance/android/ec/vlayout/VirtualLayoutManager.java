package com.bytedance.android.ec.vlayout;

import android.content.Context;
import android.graphics.Rect;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import un.g;

/* JADX INFO: loaded from: classes44.dex */
public class VirtualLayoutManager extends ExposeLinearLayoutManagerEx implements com.bytedance.android.ec.vlayout.b {
    public static final vn.b H = null;
    public final c A;
    public int B;
    public final e C;
    public final List<Pair<un.f<Integer>, Integer>> D;
    public final vn.b E;
    public un.b F;
    public final Rect G;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public un.e f49079q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final un.e f49080r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f49081s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f49082t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f49083u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a f49084v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public un.a f49085w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final vn.c f49086x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final HashMap<Integer, com.bytedance.android.ec.vlayout.a> f49087y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final HashMap<Integer, com.bytedance.android.ec.vlayout.a> f49088z;

    public static class InflateLayoutParams extends LayoutParams {
        public InflateLayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f49089a;

        public LayoutParams(int r100) {
            super(r100, -2);
            this.f49089a = Float.NaN;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.f49089a = Float.NaN;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.f49089a = Float.NaN;
        }

        public LayoutParams(RecyclerView.LayoutParams r100) {
            super(r100);
            this.f49089a = Float.NaN;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f49089a = Float.NaN;
        }
    }

    public class a implements Comparator<Pair<un.f<Integer>, Integer>> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Pair<un.f<Integer>, Integer> r100, Pair<un.f<Integer>, Integer> r101) {
            Pair<un.f<Integer>, Integer> r102 = r100;
            Pair<un.f<Integer>, Integer> r103 = r101;
            if (r102 != null) goto L6;
            if (r103 != null) goto L6;
            return 0;
        L6:
            if (r102 != null) goto L8;
            return -1;
        L8:
            if (r103 != null) goto L10;
            return 1;
        L10:
            un.f r104 = (un.f) r102.first;
            un.f r105 = (un.f) r103.first;
            return ((Integer) r104.f550757a).intValue() - ((Integer) r105.f550757a).intValue();
        }
    }

    public class b implements un.b {
        public b() {
        }

        @Override // un.b
        public final View a(Context r100) {
            return new LayoutView(r100);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f49090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f49091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f49092c;

        public c() {
        }
    }

    public interface d {
        boolean a();
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExposeLinearLayoutManagerEx.d f49093a;

        public e() {
        }

        public final boolean a(RecyclerView.State r100) {
            int r101 = this.f49093a.f49067f;
            if (r101 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r101 >= r100.getItemCount()) goto L7;
            return true;
        }
    }

    public static class f extends RecyclerView.ViewHolder {
        public f(View r100) {
            super(r100);
            setIsRecyclable(false);
        }
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        return false;
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx
    public final void y() {
    }

    static {
        H = new vn.b();
    }

    public final View N() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
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
            */
        /*
            this = this;
            androidx.recyclerview.widget.RecyclerView r0 = r10.f49081s
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            un.b r1 = r10.F
            android.content.Context r0 = r0.getContext()
            android.view.View r0 = r1.a(r0)
            com.bytedance.android.ec.vlayout.VirtualLayoutManager$LayoutParams r1 = new com.bytedance.android.ec.vlayout.VirtualLayoutManager$LayoutParams
            r2 = -2
            r1.<init>(r2)
            com.bytedance.android.ec.vlayout.VirtualLayoutManager$f r2 = new com.bytedance.android.ec.vlayout.VirtualLayoutManager$f
            r2.<init>(r0)
            java.lang.reflect.Field r3 = com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx.f49028o     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            if (r3 != 0) goto L29
            java.lang.Class<androidx.recyclerview.widget.RecyclerView$LayoutParams> r3 = androidx.recyclerview.widget.RecyclerView.LayoutParams.class
            java.lang.String r4 = "mViewHolder"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx.f49028o = r3     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
        L29:
            java.lang.reflect.Field r3 = com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx.f49028o     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            java.lang.reflect.Field r3 = com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx.f49028o     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            r3.set(r1, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            java.lang.reflect.Method r3 = com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx.f49029p     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            r5 = 0
            r6 = 2
            if (r3 != 0) goto L4f
            java.lang.Class<androidx.recyclerview.widget.RecyclerView$ViewHolder> r3 = androidx.recyclerview.widget.RecyclerView.ViewHolder.class
            java.lang.String r7 = "setFlags"
            java.lang.Class[] r8 = new java.lang.Class[r6]     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            r8[r5] = r9     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            r8[r4] = r9     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r7, r8)     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx.f49029p = r3     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            r3.setAccessible(r4)     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
        L4f:
            java.lang.reflect.Method r3 = com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx.f49029p     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            r7 = 4
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            r6[r5] = r8     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            r6[r4] = r5     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            r3.invoke(r2, r6)     // Catch: java.lang.reflect.InvocationTargetException -> L64 java.lang.NoSuchMethodException -> L69 java.lang.IllegalAccessException -> L6e java.lang.NoSuchFieldException -> L73
            goto L77
        L64:
            r2 = move-exception
            r2.printStackTrace()
            goto L77
        L69:
            r2 = move-exception
            r2.printStackTrace()
            goto L77
        L6e:
            r2 = move-exception
            r2.printStackTrace()
            goto L77
        L73:
            r2 = move-exception
            r2.printStackTrace()
        L77:
            r0.setLayoutParams(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.ec.vlayout.VirtualLayoutManager.N():android.view.View");
    }

    public List<View> Q() {
        if (this.f49081s == null) goto L5;
        LinkedList r100 = new LinkedList();
        Iterator<com.bytedance.android.ec.vlayout.a> r101 = ((g) this.f49085w).f550760b.iterator();
    L8:
        if (r101.hasNext() == false) goto L12;
        View r102 = r101.next().g();
        if (r102 == null) goto L8;
        r100.add(r102);
        goto L8
    L12:
        return r100;
    L5:
        return Collections.emptyList();
    }

    public final List<com.bytedance.android.ec.vlayout.a> R() {
        return ((g) this.f49085w).f550760b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        if (this.f49082t == false) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        if (this.f49083u == false) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2);
    }

    public final int O() {
        return super.getHeight();
    }

    public final int P() {
        return super.getWidth();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, com.bytedance.android.ec.vlayout.b
    public final int getOrientation() {
        return super.getOrientation();
    }

    public final com.bytedance.android.ec.vlayout.a M(int r100) {
        return this.f49085w.a(r100);
    }

    public final void U(List<com.bytedance.android.ec.vlayout.a> r100) {
        Iterator<com.bytedance.android.ec.vlayout.a> r101 = ((g) this.f49085w).f550760b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        com.bytedance.android.ec.vlayout.a r102 = r101.next();
        this.f49088z.put(Integer.valueOf(System.identityHashCode(r102)), r102);
        goto L4
    L6:
        Iterator r103 = ((ArrayList) r100).iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L17;
        com.bytedance.android.ec.vlayout.a r105 = (com.bytedance.android.ec.vlayout.a) r103.next();
        if ((r105 instanceof vn.d) == false) goto L12;
        ((vn.d) r105).f556368n = this.f49086x;
    L12:
        boolean r106 = r105 instanceof vn.a;
        if (r105.h() <= 0) goto L15;
        r105.s(r104, (r105.h() + r104) - 1);
    L16:
        r104 = r104 + r105.h();
        goto L8
    L15:
        r105.s(-1, -1);
        goto L16
    L17:
        this.f49085w.b(r100);
        Iterator<com.bytedance.android.ec.vlayout.a> r107 = ((g) this.f49085w).f550760b.iterator();
    L19:
        if (r107.hasNext() == false) goto L21;
        com.bytedance.android.ec.vlayout.a r108 = r107.next();
        this.f49087y.put(Integer.valueOf(System.identityHashCode(r108)), r108);
        goto L19
    L21:
        Iterator<Map.Entry<Integer, com.bytedance.android.ec.vlayout.a>> r109 = this.f49088z.entrySet().iterator();
    L23:
        if (r109.hasNext() == false) goto L27;
        Integer r110 = r109.next().getKey();
        if (this.f49087y.containsKey(r110) == false) goto L23;
        this.f49087y.remove(r110);
        r109.remove();
        goto L23
    L27:
        Iterator<com.bytedance.android.ec.vlayout.a> r111 = this.f49088z.values().iterator();
    L29:
        if (r111.hasNext() == false) goto L32;
        r111.next().d(this);
        goto L29
    L32:
        if (this.f49088z.isEmpty() == false) goto L34;
        this.f49087y.isEmpty();
    L34:
        this.f49088z.clear();
        this.f49087y.clear();
        requestLayout();
    }

    public final void V(View r100) {
        ExposeLinearLayoutManagerEx.c r101 = this.f49038i;
        r101.getClass();
        r101.a();     // Catch: Exception -> L7
        int r102 = r101.f49061j.f49041l.indexOfChild(r100);     // Catch: Exception -> L7
        r101.f49060i[0] = Integer.valueOf(r102);     // Catch: Exception -> L7
        r101.f49056e.invoke(r101.f49055d, r101.f49060i);     // Catch: Exception -> L7
        List r103 = r101.f49058g;     // Catch: Exception -> L7
        if (r103 == null) goto L12;
        r103.remove(r100);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean checkLayoutParams(RecyclerView.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void detachAndScrapAttachedViews(RecyclerView.Recycler r100) {
        int r101 = getChildCount();
    L3:
        r101 = r101 - 1;
        if (r101 < 0) goto L14;
        View r102 = getChildAt(r101);
        RecyclerView r103 = this.f49081s;
        if (r103 == null) goto L8;
        RecyclerView.ViewHolder r104 = r103.getChildViewHolder(r102);
    L10:
        if ((r104 instanceof d) == false) goto L3;
        if (((d) r104).a() == false) goto L3;
        ExposeLinearLayoutManagerEx.e.a(r104, 6);
        goto L3
    L8:
        r104 = null;
        goto L10
    L14:
        super.detachAndScrapAttachedViews(r100);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final View findViewByPosition(int r100) {
        View r101 = super.findViewByPosition(r100);
        if (r101 != null) goto L5;
    L7:
        int r102 = 0;
    L9:
        if (r102 >= getChildCount()) goto L16;
        View r103 = getChildAt(r102);
        if (r103 == null) goto L15;
        if (getPosition(r103) != r100) goto L15;
        return r103;
    L15:
        r102 = r102 + 1;
        goto L9
    L16:
        return null;
    L5:
        if (getPosition(r101) != r100) goto L7;
        return r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r100);
    L7:
        if ((r100 instanceof RecyclerView.LayoutParams) == false) goto L11;
        return new LayoutParams((RecyclerView.LayoutParams) r100);
    L11:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L15:
        return new LayoutParams(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void offsetChildrenHorizontal(int r100) {
        super.offsetChildrenHorizontal(r100);
        Iterator<com.bytedance.android.ec.vlayout.a> r101 = ((g) this.f49085w).f550760b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().m(r100, this);
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void offsetChildrenVertical(int r100) {
        super.offsetChildrenVertical(r100);
        Iterator<com.bytedance.android.ec.vlayout.a> r101 = ((g) this.f49085w).f550760b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().n(r100, this);
        goto L4
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAttachedToWindow(RecyclerView r100) {
        super.onAttachedToWindow(r100);
        this.f49081s = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView r100) {
        Iterator<com.bytedance.android.ec.vlayout.a> r101 = ((g) this.f49085w).f550760b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().l();
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onScrollStateChanged(int r100) {
        super.onScrollStateChanged(r100);
        int r101 = findFirstVisibleItemPosition();
        int r102 = findLastVisibleItemPosition();
        Iterator<com.bytedance.android.ec.vlayout.a> r103 = ((g) this.f49085w).f550760b.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().q(r100, r101, r102);
        goto L4
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r100) {
        super.scrollToPosition(r100);
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public final void setOrientation(int r100) {
        this.f49079q = un.e.a(this, r100);
        super.setOrientation(r100);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void setReverseLayout(boolean r100) {
        if (r100 == true) goto L6;
        super.setReverseLayout(false);
        return;
    L6:
        throw new UnsupportedOperationException("VirtualLayoutManager does not support reverse layout in current version.");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void setStackFromEnd(boolean r100) {
        if (r100 == true) goto L6;
        super.setStackFromEnd(false);
        return;
    L6:
        throw new UnsupportedOperationException("VirtualLayoutManager does not support stack from end.");
    }

    public VirtualLayoutManager(Context r100, int r101) {
        super(r100);
        this.f49084v = new a();
        this.f49086x = vn.c.f556367a;
        this.f49087y = new HashMap();
        this.f49088z = new HashMap();
        this.A = new c();
        this.B = 0;
        this.C = new e();
        this.D = new ArrayList();
        this.E = H;
        this.F = new b();
        this.G = new Rect();
        this.f49079q = un.e.a(this, 1);
        this.f49080r = un.e.a(this, 0);
        this.f49083u = super.canScrollVertically();
        this.f49082t = super.canScrollHorizontally();
        g r102 = new g();
        LinkedList r103 = new LinkedList();
        un.a r104 = this.f49085w;
        if (r104 == null) goto L8;
        Iterator<com.bytedance.android.ec.vlayout.a> r105 = ((g) r104).f550760b.iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        r103.add(r105.next());
    L8:
        this.f49085w = r102;
        if (r103.size() <= 0) goto L11;
        this.f49085w.b(r103);
    L11:
        requestLayout();
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx
    public final void D(RecyclerView.State r100, ExposeLinearLayoutManagerEx.a r101) {
        boolean r102 = true;
    L3:
        if (r102 == false) goto L12;
        c r103 = this.A;
        int r104 = r101.f49044a;
        r103.f49090a = r104;
        r103.f49091b = r101.f49045b;
        r103.f49092c = r101.f49046c;
        com.bytedance.android.ec.vlayout.a r105 = this.f49085w.a(r104);
        if (r105 == null) goto L7;
        r105.c(r100, this.A, this);
    L7:
        c r106 = this.A;
        int r107 = r106.f49090a;
        if (r107 != r101.f49044a) goto L10;
        r102 = false;
    L11:
        r101.f49045b = r106.f49091b;
        r106.f49090a = -1;
        goto L3
    L10:
        r101.f49044a = r107;
        goto L11
    L12:
        c r108 = this.A;
        r108.f49090a = r101.f49044a;
        r108.f49091b = r101.f49045b;
        Iterator<com.bytedance.android.ec.vlayout.a> r109 = ((g) this.f49085w).f550760b.iterator();
    L14:
        if (r109.hasNext() == false) goto L16;
        r109.next().p(this.A);
        goto L14
    }

    public final void K(View r100, int r101) {
        super.addView(r100, r101);
    }

    public final void L(View r100, boolean r101) {
        V(r100);
        if (r101 == false) goto L5;
        int r102 = 0;
    L6:
        addView(r100, r102);
        this.f49038i.b(r100);
        return;
    L5:
        r102 = -1;
        goto L6
    }

    public final void T(RecyclerView.Recycler r100, RecyclerView.State r101) {
        if (this.B != 0) goto L8;
        Iterator<com.bytedance.android.ec.vlayout.a> r102 = ((g) this.f49085w).f550761c.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r102.next().b(r100, r101, this);
    L8:
        this.B++;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void detachAndScrapView(View r100, RecyclerView.Recycler r101) {
        super.detachAndScrapView(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void detachAndScrapViewAt(int r100, RecyclerView.Recycler r101) {
        View r102 = getChildAt(r100);
        RecyclerView r103 = this.f49081s;
        if (r103 == null) goto L5;
        RecyclerView.ViewHolder r104 = r103.getChildViewHolder(r102);
    L7:
        if ((r104 instanceof d) == true) goto L9;
    L11:
        super.detachAndScrapViewAt(r100, r101);
        return;
    L9:
        if (((d) r104).a() == false) goto L11;
        ExposeLinearLayoutManagerEx.e.a(r104, 4);
        goto L11
    L5:
        r104 = null;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(Context r100, AttributeSet r101) {
        return new InflateLayoutParams(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void moveView(int r100, int r101) {
        super.moveView(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAdapterChanged(RecyclerView.Adapter r100, RecyclerView.Adapter r101) {
        super.onAdapterChanged(r100, r101);
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView r100, RecyclerView.Recycler r101) {
        super.onDetachedFromWindow(r100, r101);
        Iterator<com.bytedance.android.ec.vlayout.a> r102 = ((g) this.f49085w).f550760b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().d(this);
        goto L4
    L6:
        this.f49081s = null;
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        Trace.beginSection("VLM onLayoutChildren");
        T(r100, r101);
        super.onLayoutChildren(r100, r101);     // Catch: Throwable -> L6 Exception -> L8
        S(r100, r101, Integer.MAX_VALUE);
        Trace.endSection();
        return;
    L6:
        th = move-exception;
        S(r100, r101, Integer.MAX_VALUE);
        throw th;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public final void scrollToPositionWithOffset(int r100, int r101) {
        super.scrollToPositionWithOffset(r100, r101);
    }

    public static int W(int r100, int r101, int r102) {
        if (r101 != 0) goto L5;
        if (r102 != 0) goto L5;
        return r100;
    L5:
        int r103 = View.MeasureSpec.getMode(r100);
        if (r103 == Integer.MIN_VALUE) goto L12;
        if (r103 == 1073741824) goto L12;
        return r100;
    L12:
        if (((View.MeasureSpec.getSize(r100) - r101) - r102) >= 0) goto L16;
        return View.MeasureSpec.makeMeasureSpec(0, r103);
    L16:
        return View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(r100) - r101) - r102, r103);
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx
    public int F(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        Trace.beginSection("VLM scroll");
        T(r101, r102);
        int r103 = 0;
        r103 = super.F(r100, r101, r102);     // Catch: Throwable -> L5 Exception -> L7
    L4:
        S(r101, r102, r103);
        Trace.endSection();
        return r103;
    L5:
        th = move-exception;
        S(r101, r102, r103);
        throw th;
    L7:
        e = move-exception;
        Log.getStackTraceString(e);     // Catch: Throwable -> L5
        goto L4
    }

    public final void S(RecyclerView.Recycler r110, RecyclerView.State r111, int r112) {
        int r100 = this.B - 1;
        this.B = r100;
        if (r100 > 0) goto L11;
        this.B = 0;
        int r101 = findFirstVisibleItemPosition();
        int r102 = findLastVisibleItemPosition();
        Iterator<com.bytedance.android.ec.vlayout.a> r103 = ((g) this.f49085w).f550760b.iterator();
    L6:
        if (r103.hasNext() == false) goto L18;
        r103.next().a(r110, r111, r101, r102, r112, this);     // Catch: Exception -> L10
        goto L6
    L18:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void measureChild(View r100, int r101, int r102) {
        calculateItemDecorationsForChild(r100, this.G);
        Rect r103 = this.G;
        int r104 = W(r101, r103.left, r103.right);
        Rect r105 = this.G;
        r100.measure(r104, W(r102, r105.top, r105.bottom));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, com.bytedance.android.ec.vlayout.b
    public final void measureChildWithMargins(View r100, int r101, int r102) {
        calculateItemDecorationsForChild(r100, this.G);
        RecyclerView.LayoutParams r103 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        if (getOrientation() != 1) goto L6;
        int r104 = ((ViewGroup.MarginLayoutParams) r103).leftMargin;
        Rect r105 = this.G;
        r101 = W(r101, r104 + r105.left, ((ViewGroup.MarginLayoutParams) r103).rightMargin + r105.right);
    L6:
        if (getOrientation() != 0) goto L8;
        Rect r106 = this.G;
        r102 = W(r102, r106.top, r106.bottom);
    L8:
        r100.measure(r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsAdded(RecyclerView r100, int r101, int r102) {
        onItemsChanged(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView r100, int r101, int r102) {
        onItemsChanged(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsUpdated(RecyclerView r100, int r101, int r102) {
        onItemsChanged(r100);
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx
    public final int p(View r100, boolean r101, boolean r102) {
        int r103 = getPosition(r100);
        if (r103 == (-1)) goto L7;
        com.bytedance.android.ec.vlayout.a r104 = this.f49085w.a(r103);
        if (r104 == null) goto L7;
        return r104.e(r103 - ((Integer) r104.f49095a.f550757a).intValue(), r101, r102, this);
    L7:
        return 0;
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx
    public final void recycleChildren(RecyclerView.Recycler r100, int r101, int r102) {
        if (r101 != r102) goto L5;
        return;
    L5:
        if (r102 <= r101) goto L16;
        View r103 = getChildAt(r102 - 1);
        getPosition(getChildAt(r101));
        getPosition(r103);
        int r104 = r101;
    L7:
        if (r104 >= r102) goto L26;
        int r105 = getPosition(getChildAt(r101));
        if (r105 == (-1)) goto L14;
        com.bytedance.android.ec.vlayout.a r106 = this.f49085w.a(r105);
        if (r106 == null) goto L13;
        r106.k(r105, this, true);
    L13:
        removeAndRecycleViewAt(r101, r100);
    L15:
        r104 = r104 + 1;
        goto L7
    L14:
        removeAndRecycleViewAt(r101, r100);
        goto L15
    L26:
        return;
    L16:
        View r107 = getChildAt(r101);
        getPosition(getChildAt(r102 + 1));
        getPosition(r107);
    L17:
        if (r101 <= r102) goto L33;
        int r108 = getPosition(getChildAt(r101));
        if (r108 == (-1)) goto L24;
        com.bytedance.android.ec.vlayout.a r109 = this.f49085w.a(r108);
        if (r109 == null) goto L23;
        r109.k(r108, this, false);
    L23:
        removeAndRecycleViewAt(r101, r100);
    L25:
        r101 = r101 - 1;
        goto L17
    L24:
        removeAndRecycleViewAt(r101, r100);
        goto L25
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        super.smoothScrollToPosition(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsMoved(RecyclerView r100, int r101, int r102, int r103) {
        onItemsChanged(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onMeasure(RecyclerView.Recycler r100, RecyclerView.State r101, int r102, int r103) {
        super.onMeasure(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ec.vlayout.ExposeLinearLayoutManagerEx
    public final void z(RecyclerView.Recycler r110, RecyclerView.State r111, ExposeLinearLayoutManagerEx.d r112, vn.g r113) {
        int r100 = r112.f49067f;
        this.C.f49093a = r112;
        un.a r101 = this.f49085w;
        Pair r102 = null;
        if (r101 != null) goto L5;
        com.bytedance.android.ec.vlayout.a r103 = null;
    L6:
        if (r103 != null) goto L8;
        r103 = this.E;
    L8:
        com.bytedance.android.ec.vlayout.a r104 = r103;
        Objects.toString(r104.f49095a);
        r104.f(r110, r111, this.C, r113, this);
        this.C.f49093a = null;
        int r114 = r112.f49067f;
        if (r114 != r100) goto L11;
        r113.f556370b = true;
    L61:
        int r115 = r113.f556369a;
        return;
    L11:
        int r116 = r114 - r112.f49068g;
        if (r113.f556371c == false) goto L14;
        int r117 = 0;
    L15:
        un.f r105 = new un.f(Integer.valueOf(Math.min(r100, r116)), Integer.valueOf(Math.max(r100, r116)));
        int r118 = ((ArrayList) this.D).size();
        int r106 = -1;
        if (r118 == 0) goto L51;
        int r119 = r118 - 1;
        int r107 = 0;
        int r108 = -1;
    L19:
        if (r107 > r119) goto L48;
        r108 = (r107 + r119) / 2;
        Pair r109 = (Pair) ListProtector.get(this.D, r108);
        un.f r120 = (un.f) r109.first;
        if (r120 == null) goto L48;
        if (r120.a(r105.f550757a) == true) goto L47;
        if (r120.a(r105.f550758b) == true) goto L47;
        if (r120.f550757a.compareTo(r105.f550757a) < 0) goto L30;
        boolean r121 = true;
    L32:
        if (r120.f550758b.compareTo(r105.f550758b) > 0) goto L34;
        boolean r122 = true;
    L35:
        if (r121 == false) goto L38;
        if (r122 == false) goto L38;
        boolean r123 = true;
    L39:
        if (r123 == true) goto L47;
        if (((Integer) r120.f550757a).intValue() > ((Integer) r105.f550758b).intValue()) goto L43;
        if (((Integer) r120.f550758b).intValue() >= ((Integer) r105.f550757a).intValue()) goto L19;
        r107 = r108 + 1;
        goto L19
    L43:
        r119 = r108 - 1;
    L38:
        r123 = false;
        goto L39
    L34:
        r122 = false;
        goto L35
    L30:
        r121 = false;
    L47:
        r102 = r109;
    L48:
        if (r102 == null) goto L51;
        r106 = r108;
    L51:
        if (r106 < 0) goto L60;
        Pair r124 = (Pair) ListProtector.get(this.D, r106);
        if (r124 != null) goto L55;
    L59:
        ListProtector.remove(this.D, r106);
        goto L60
    L55:
        if (((un.f) r124.first).equals(r105) == false) goto L59;
        if (((Integer) r124.second).intValue() != r117) goto L59;
        return;
    L60:
        ((ArrayList) this.D).add(Pair.create(r105, Integer.valueOf(r117)));
        Collections.sort(this.D, this.f49084v);
        goto L61
    L14:
        r117 = r113.f556369a;
        goto L15
    L5:
        r103 = r101.a(r100);
        goto L6
    }
}
