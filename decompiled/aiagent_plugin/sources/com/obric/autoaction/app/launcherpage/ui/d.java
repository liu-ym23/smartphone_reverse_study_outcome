package com.obric.autoaction.app.launcherpage.ui;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PowerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public class d<T extends h> extends RecyclerView.a<f<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RecyclerView f24436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Field f24437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f24438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Integer, Class<? extends f<?>>> f24439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Type, Integer> f24440e;
    private final List<T> f;
    private List<? extends T> g;
    private final Handler h;
    private final com.obric.oui.orecyclerview.widget.c<T> i;
    private int j;
    private final g k;

    /* JADX INFO: compiled from: PowerAdapter.kt */
    public static final class a extends com.obric.oui.orecyclerview.widget.j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<T> f24441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<T> f24442b;

        a(List<? extends T> r3, List<? extends T> r4) {
            List<T> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<T> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f24441a = r5;
            this.f24442b = r6;
        }

        @Override // com.obric.oui.orecyclerview.widget.j.a
        public int a() {
            return this.f24441a.size();
        }

        @Override // com.obric.oui.orecyclerview.widget.j.a
        public int b() {
            return this.f24442b.size();
        }

        @Override // com.obric.oui.orecyclerview.widget.j.a
        public boolean a(int r3, int r4) {
            return ((h) ZeusTransformUtils.preCheckCast(this.f24441a.get(r3), h.class, "com.obric.aiagent.plugin")).a((h) ZeusTransformUtils.preCheckCast(this.f24442b.get(r4), h.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.oui.orecyclerview.widget.j.a
        public boolean b(int r3, int r4) {
            return ((h) ZeusTransformUtils.preCheckCast(this.f24441a.get(r3), h.class, "com.obric.aiagent.plugin")).b((h) ZeusTransformUtils.preCheckCast(this.f24442b.get(r4), h.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.oui.orecyclerview.widget.j.a
        public Object c(int r3, int r4) {
            return ((h) ZeusTransformUtils.preCheckCast(this.f24441a.get(r3), h.class, "com.obric.aiagent.plugin")).c((h) ZeusTransformUtils.preCheckCast(this.f24442b.get(r4), h.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ void lambda$FjVLQQQXXaeZ_wWHmaLQVRKp72c(int r0, d r1, List r2, com.obric.oui.orecyclerview.widget.j.d r3, d.h.a.a r4) {
        a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$ef4Nj5wKsIQIr3s5KM94S5WLJis(boolean r0, d r1, List r2, List r3, int r4, d.h.a.a r5) {
        a(r0, r1, r2, r3, r4, r5);
    }

    public /* synthetic */ d(RecyclerView r1, boolean r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        this(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.v r3, int r4, List r5) {
        List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        a((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin"), r4, r6);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.v b(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(a(r1, r2), RecyclerView.v.class, "com.obric.aiagent.plugin");
    }

    public d(RecyclerView r5, boolean r6) {
        d.h.b.o.e(r5, "recyclerView");
        this.f24436a = r5;
        this.f24439d = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f24440e = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        List<? extends T> r0 = Collections.emptyList();
        d.h.b.o.c(r0, "emptyList(...)");
        this.g = r0;
        this.h = new Handler(Looper.getMainLooper());
        com.obric.oui.orecyclerview.widget.c<T> r1 = new com.obric.oui.orecyclerview.widget.c.a((com.obric.oui.orecyclerview.widget.j.e) ZeusTransformUtils.preCheckCast(new i(), com.obric.oui.orecyclerview.widget.j.e.class, "com.obric.aiagent.plugin")).a();
        d.h.b.o.c(r1, "build(...)");
        this.i = r1;
        this.k = new g();
        if (r6 == false) goto L10;
        r5.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(this, RecyclerView.a.class, "com.obric.aiagent.plugin"));
    L10:
        Field r7 = RecyclerView.v.class.getDeclaredField("b");     // Catch: NoSuchFieldException -> L7
        this.f24437b = r7;     // Catch: NoSuchFieldException -> L7
        r7.setAccessible(true);     // Catch: NoSuchFieldException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public final g b() {
        return this.k;
    }

    public final void a(com.obric.autoaction.app.launcherpage.module.a.i r4) {
        com.obric.autoaction.app.launcherpage.module.a.i r5 = (com.obric.autoaction.app.launcherpage.module.a.i) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autoaction.app.launcherpage.module.a.i.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "control");
        g r3 = this.k;
        if (r3.a().containsKey(com.obric.autoaction.app.launcherpage.module.a.i.class) == true) goto L7;
        r3.a().put(com.obric.autoaction.app.launcherpage.module.a.i.class, (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        throw new RuntimeException("already contains control type :" + com.obric.autoaction.app.launcherpage.module.a.i.class);
    }

    public final void a(Class<? extends f<?>>... r14) {
        d.h.b.o.e(r14, "classes");
        Map<Type, Integer> r0 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
        Map<Integer, ? extends Class<? extends f<?>>> r1 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
        int r3 = r14.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L11;
        Class<? extends f<?>> r6 = r14[r5];
        Type r7 = r6.getGenericSuperclass();
        d.h.b.o.a(r7, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type[] r8 = ((ParameterizedType) ZeusTransformUtils.preCheckCast(r7, ParameterizedType.class, "com.obric.aiagent.plugin")).getActualTypeArguments();
        d.h.b.o.c(r8, "getActualTypeArguments(...)");
        int r9 = r8.length;
        int r10 = 0;
    L5:
        if (r10 >= r9) goto L10;
        Type r11 = r8[r10];
        if (this.f24440e.get(r11) != null) goto L9;
        int r12 = this.f24438c;
        this.f24438c = r12 + 1;
        r0.put(r11, Integer.valueOf(r12));
        r1.put(Integer.valueOf(r12), r6);
    L9:
        r10 = r10 + 1;
        goto L5
    L10:
        r5 = r5 + 1;
        goto L3
    L11:
        a(r0, r1);
    }

    private final void a(Map<Type, Integer> r3, Map<Integer, ? extends Class<? extends f<?>>> r4) {
        Map<? extends Type, ? extends Integer> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map<? extends Integer, ? extends Class<? extends f<?>>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.f24440e.putAll(r5);
        this.f24439d.putAll(r6);
    }

    public f<T> a(ViewGroup r3, int r4) {
        d.h.b.o.e(r3, "parent");
        Class r5 = (Class) ZeusTransformUtils.preCheckCast(this.f24439d.get(Integer.valueOf(r4)), Class.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L10;
        Object r6 = r5.newInstance();
        d.h.b.o.a(r6, "null cannot be cast to non-null type com.obric.autoaction.app.launcherpage.ui.PowerCell<T of com.obric.autoaction.app.launcherpage.ui.PowerAdapter>");
        f<T> r7 = (f) ZeusTransformUtils.preCheckCast(r6, f.class, "com.obric.aiagent.plugin");
        r7.a(this);
        View r8 = r7.a(r3);
        Field r2 = this.f24437b;
        if (r2 == null) goto L7;
        r2.set(r7, r8);
    L7:
        r7.c();
        return r7;
    L10:
        throw new RuntimeException("onCreateViewHolder itemToType error!!");
    }

    public void a(f<T> r2, int r3) {
        d.h.b.o.e(r2, "holder");
        h r1 = b(r3);
        r2.b(r1);
        r2.b(r1, null);
    }

    public void a(f<T> r3, int r4, List<Object> r5) {
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "holder");
        d.h.b.o.e(r6, "payloads");
        h r0 = b(r4);
        r3.b(r0);
        if (r6.isEmpty() == false) goto L5;
        a(r3, r4);
        return;
    L5:
        r3.b(r0, r6);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a(int r4) {
        h r5 = b(r4);
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(this.f24440e.get((Type) ZeusTransformUtils.preCheckCast(r5.getClass(), Type.class, "com.obric.aiagent.plugin")), Integer.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        return r3.intValue();
    L7:
        throw new RuntimeException("not registerCells for: " + r5.getClass());
    }

    public T b(int r2) {
        return (T) ZeusTransformUtils.preCheckCast(this.f.get(r2), h.class, "com.obric.aiagent.plugin");
    }

    public final List<T> c() {
        return this.g;
    }

    public static /* synthetic */ void a(d r2, List r3, d.h.a.a r4, int r5, Object r6) {
        List<? extends T> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r8 = null;
    L7:
        r2.a(r7, r8);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: submitList");
    }

    public void a(List<? extends T> r3, d.h.a.a<x> r4) {
        a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), true, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public final void a(List<? extends T> r10, final boolean r11, d.h.a.a<x> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        final d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L6;
        List r14 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin"));
        if (r14 == null) goto L6;
    L7:
        final List r6 = r14;
        final int r7 = this.j + 1;
        this.j = r7;
        final List r5 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.aiagent.plugin"));
        if (r5 != r6) goto L13;
        if (r8 == null) goto L26;
        r8.invoke();
        return;
    L26:
        return;
    L13:
        if (r5.isEmpty() == false) goto L19;
        this.f.clear();
        this.f.addAll((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin"));
        List<? extends T> r15 = Collections.unmodifiableList(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.aiagent.plugin")));
        d.h.b.o.c(r15, "unmodifiableList(...)");
        this.g = r15;
        c(0, r6.size());
        if (r8 == null) goto L27;
        r8.invoke();
        return;
    L27:
        return;
    L19:
        if (r6.isEmpty() == false) goto L24;
        int r16 = this.f.size();
        this.f.clear();
        List<? extends T> r17 = Collections.emptyList();
        d.h.b.o.c(r17, "emptyList(...)");
        this.g = r17;
        d(0, r16);
        if (r8 == null) goto L28;
        r8.invoke();
        return;
    L28:
        return;
    L24:
        this.i.b().execute(new $$Lambda$d$ef4Nj5wKsIQIr3s5KM94S5WLJis(r11, this, r5, r6, r7, r8));
        return;
    L6:
        r14 = d.a.p.b();
        goto L7
    }

    private static final void a(boolean r8, final d r9, List r10, List r11, final int r12, d.h.a.a r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        final List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        final d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        final com.obric.oui.orecyclerview.widget.j.d r6 = com.obric.oui.orecyclerview.widget.j.a((com.obric.oui.orecyclerview.widget.j.a) ZeusTransformUtils.preCheckCast(new a(r14, r5), com.obric.oui.orecyclerview.widget.j.a.class, "com.obric.aiagent.plugin"), r8);
        d.h.b.o.c(r6, "calculateDiff(...)");
        r9.h.post(new $$Lambda$d$FjVLQQQXXaeZ_wWHmaLQVRKp72c(r12, r9, r5, r6, r7));
    }

    private static final void a(int r2, d r3, List r4, com.obric.oui.orecyclerview.widget.j.d r5, d.h.a.a r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r2 == r3.j) goto L5;
        return;
    L5:
        r3.f.clear();
        r3.f.addAll((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin"));
        List<? extends T> r9 = Collections.unmodifiableList(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r3.f, Iterable.class, "com.obric.aiagent.plugin")));
        d.h.b.o.c(r9, "unmodifiableList(...)");
        r3.g = r9;
        r5.a((RecyclerView.a) ZeusTransformUtils.preCheckCast(r3, RecyclerView.a.class, "com.obric.aiagent.plugin"));
        if (r8 == null) goto L9;
        r8.invoke();
        return;
    }

    public final void a(List<? extends T> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "list");
        this.j++;
        this.f.clear();
        this.f.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
        List<? extends T> r6 = Collections.unmodifiableList(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.aiagent.plugin")));
        d.h.b.o.c(r6, "unmodifiableList(...)");
        this.g = r6;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a() {
        return this.f.size();
    }
}
