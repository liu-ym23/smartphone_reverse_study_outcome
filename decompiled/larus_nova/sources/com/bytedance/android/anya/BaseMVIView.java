package com.bytedance.android.anya;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.DelegatingMVIBindingImpl;
import com.bytedance.android.anya.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class BaseMVIView<STATE extends MVIState<?>, ACTION extends p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f41536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.anya.internal.m<?, ACTION> f41537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public STATE f41538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i0<STATE> f41539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f41540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f41541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f41542g;

    public abstract void b(k<STATE> r100, STATE r101);

    public boolean d(a0 r100) {
        return false;
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public void i() {
    }

    public void k(com.bytedance.android.anya.dsl.a<STATE, ACTION> r100) {
    }

    public void l(com.bytedance.android.anya.dsl.c<STATE, ACTION> r100) {
    }

    public final com.bytedance.android.anya.internal.m<?, ACTION> m() {
        com.bytedance.android.anya.internal.m<?, ACTION> r100 = this.f41537b;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final STATE n() {
        STATE r100 = this.f41538c;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("State not available".toString());
    }

    public BaseMVIView() {
        this.f41539d = new i0();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        this.f41540e = LazyKt.lazy(r100, new BaseMVIView$reflexComponents$2(this));
        this.f41541f = LazyKt.lazy(r100, new BaseMVIView$listAdapters$2(this));
        this.f41542g = LazyKt.lazy(new BaseMVIView$pagerAdapters$2(this));
    }

    public final void j() {
        i();
        f();
        this.f41536a = false;
        com.bytedance.android.anya.internal.m<?, ACTION> r100 = this.f41537b;
        if (r100 == null) goto L5;
        r100.e((Map) this.f41540e.getValue());
    L5:
        this.f41537b = null;
        this.f41538c = null;
    }

    public final void c(k<STATE> r210) {
        Iterator r100 = ((Map) this.f41541f.getValue()).entrySet().iterator();
    L3:
        boolean r101 = false;
        if (r100.hasNext() == false) goto L107;
        Map.Entry r102 = (Map.Entry) r100.next();
        String r103 = (String) r102.getKey();
        final MVIRecyclerViewAdapter r104 = (MVIRecyclerViewAdapter) r102.getValue();
        com.bytedance.android.anya.internal.s<STATE> r105 = r210.f41740c;
        STATE r106 = this.f41538c;
        if (r106 == null) goto L10;
        LinkedHashMap<String, com.bytedance.android.anya.internal.c<?, ?>> r107 = r106.properties;
        if (r107 == null) goto L10;
        com.bytedance.android.anya.internal.c<?, ?> r108 = r107.get(r103);
    L11:
        if (r108 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        Object r109 = r105.a(r108);
        if (r109 == null) goto L105;
        if (r104 == null) goto L104;
        final com.bytedance.android.anya.internal.t r110 = (com.bytedance.android.anya.internal.t) r109;
        final boolean r111 = r210.f41740c.f41709d;
        List<com.bytedance.android.anya.internal.t.b> r112 = r110.f41714c;     // Catch: Throwable -> L100
        if (r111 == false) goto L20;
    L88:
        Iterator r113 = r100;
        r104.f41564a = CollectionsKt.toList(r110);     // Catch: Throwable -> L100
        RecyclerView r114 = r104.f41565b;     // Catch: Throwable -> L100
        if (r114 != null) goto L91;
    L97:
        r104.notifyDataSetChanged();     // Catch: Throwable -> L100
    L98:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L100
        r110.f41714c.clear();
    L106:
        r100 = r113;
        goto L3
    L91:
        if (r114.isComputingLayout() != true) goto L97;
        if (q0.f41750e == false) goto L97;
        RecyclerView r116 = r104.f41565b;     // Catch: Throwable -> L100
        if (r116 == null) goto L98;
        r116.post(new w(r104));     // Catch: Throwable -> L100
        goto L98
    L20:
        if (Intrinsics.areEqual((com.bytedance.android.anya.internal.t.b) CollectionsKt.firstOrNull(r112), com.bytedance.android.anya.internal.t.b.a.f41721c) == true) goto L88;
        int r117 = r104.f41564a.size();     // Catch: Throwable -> L100
        ArrayList r118 = new ArrayList(r117);     // Catch: Throwable -> L100
        int r119 = 0;
    L23:
        if (r119 >= r117) goto L25;
        r118.add(TuplesKt.to(Integer.valueOf(r119), Boolean.FALSE));     // Catch: Throwable -> L100
        r119 = r119 + 1;     // Catch: Throwable -> L100
        goto L23
    L25:
        Iterator<T> r120 = r112.iterator();     // Catch: Throwable -> L100
    L27:
        if (r120.hasNext() == false) goto L55;
        com.bytedance.android.anya.internal.t.b r121 = (com.bytedance.android.anya.internal.t.b) r120.next();     // Catch: Throwable -> L100
        if ((r121 instanceof com.bytedance.android.anya.internal.t.b.d) == true) goto L30;
        if ((r121 instanceof com.bytedance.android.anya.internal.t.b.c) == true) goto L33;
        if ((r121 instanceof com.bytedance.android.anya.internal.t.b.C0767b) == false) goto L47;
        int r122 = r121.f41720b;     // Catch: Throwable -> L100
        int r123 = 0;
    L40:
        if (r123 >= r122) goto L46;
        Pair r124 = (Pair) r118.get(r121.f41719a + r123);     // Catch: Throwable -> L100
        if (r124 == null) goto L45;
        r118.set(r121.f41719a + r123, Pair.copy$default(r124, null, Boolean.TRUE, 1, null));     // Catch: Throwable -> L100
    L45:
        r123 = r123 + 1;     // Catch: Throwable -> L100
        r100 = r100;
        goto L40
    L46:
        Iterator r125 = r100;
    L52:
        r100 = r125;
        goto L27
    L47:
        r125 = r100;
        if ((r121 instanceof com.bytedance.android.anya.internal.t.b.e) == false) goto L54;
        int r126 = r121.f41720b;     // Catch: Throwable -> L100
        int r127 = 0;
    L50:
        if (r127 >= r126) goto L52;
        r118.set(r121.f41719a + r127, null);     // Catch: Throwable -> L100
        r127 = r127 + 1;     // Catch: Throwable -> L100
        goto L50
    L54:
        throw new IllegalStateException(("bad type of journal: " + r121).toString());     // Catch: Throwable -> L100
    L33:
        int r128 = r121.f41719a;     // Catch: Throwable -> L100
        int r129 = r121.f41720b;     // Catch: Throwable -> L100
        ArrayList r130 = new ArrayList(r129);     // Catch: Throwable -> L100
        int r131 = 0;
    L34:
        if (r131 >= r129) goto L36;
        r130.add(null);     // Catch: Throwable -> L100
        r131 = r131 + 1;     // Catch: Throwable -> L100
        goto L34
    L36:
        r118.addAll(r128, r130);     // Catch: Throwable -> L100
        goto L27
    L30:
        int r132 = r121.f41719a;     // Catch: Throwable -> L100
        r118.subList(r132, r121.f41720b + r132).clear();     // Catch: Throwable -> L100
        goto L27
    L55:
        r113 = r100;
        final LinkedHashMap r133 = new LinkedHashMap();     // Catch: Throwable -> L100
        ArrayList r134 = new ArrayList();     // Catch: Throwable -> L100
        Iterator r135 = r118.iterator();     // Catch: Throwable -> L100
        int r136 = 0;
    L57:
        if (r135.hasNext() == false) goto L71;
        Object r137 = r135.next();     // Catch: Throwable -> L100
        int r138 = r136 + 1;     // Catch: Throwable -> L100
        if (r136 >= 0) goto L61;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L100
    L61:
        Pair r139 = (Pair) r137;     // Catch: Throwable -> L100
        if (r139 != null) goto L65;
        r134.add(r110.a(r136));     // Catch: Throwable -> L100
    L64:
        Iterator r140 = r135;
        int r141 = r138;
    L70:
        r135 = r140;
        r136 = r141;
        goto L57
    L65:
        int r142 = ((Number) r139.component1()).intValue();     // Catch: Throwable -> L100
        boolean r143 = ((Boolean) r139.component2()).booleanValue();     // Catch: Throwable -> L100
        r134.add(r104.f41564a.get(r142));     // Catch: Throwable -> L100
        if (r143 == false) goto L64;
        MVIState r144 = r110.a(r136);     // Catch: Throwable -> L100
        STATE r145 = r104.f41564a.get(r142);     // Catch: Throwable -> L100
        r140 = r135;
        r141 = r138;
        r133.put(Integer.valueOf(r136), new k(r145, r104.f41566c.m().f(), new com.bytedance.android.anya.internal.s(r145, false, true, r144)));     // Catch: Throwable -> L100
        if (q0.f41746a == false) goto L70;
        r145.clearModifyState$runtime_release();     // Catch: Throwable -> L100
        goto L70
    L71:
        r104.f41564a = r134;     // Catch: Throwable -> L100
        Iterator<T> r146 = r112.iterator();     // Catch: Throwable -> L100
    L73:
        if (r146.hasNext() == false) goto L98;
        final com.bytedance.android.anya.internal.t.b r147 = (com.bytedance.android.anya.internal.t.b) r146.next();     // Catch: Throwable -> L100
        if ((r147 instanceof com.bytedance.android.anya.internal.t.b.C0767b) == true) goto L79;
        if ((r147 instanceof com.bytedance.android.anya.internal.t.b.e) == true) goto L79;
        if ((r147 instanceof com.bytedance.android.anya.internal.t.b.d) == true) goto L82;
        if ((r147 instanceof com.bytedance.android.anya.internal.t.b.c) == false) goto L87;
        r104.z2(new MVIRecyclerViewAdapter$updateList$$inlined$consumeJournalList$runtime_release$lambda$4(r147, r133, r104, r111, r110));     // Catch: Throwable -> L100
        goto L73
    L87:
        throw new IllegalStateException(("Failed to recognize journal: " + r147).toString());     // Catch: Throwable -> L100
    L82:
        r104.z2(new MVIRecyclerViewAdapter$updateList$$inlined$consumeJournalList$runtime_release$lambda$3(r147, r133, r104, r111, r110));     // Catch: Throwable -> L100
    L79:
        r104.z2(new MVIRecyclerViewAdapter$updateList$$inlined$consumeJournalList$runtime_release$lambda$2(r147, r133, r104, r111, r110));     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        r110.f41714c.clear();
        throw th;
    L104:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.MVIRecyclerViewAdapter<com.bytedance.android.anya.MVIState<*>>");
    L105:
        r113 = r100;
    L10:
        r108 = null;
        goto L11
    L107:
        Iterator r148 = ((Map) this.f41542g.getValue()).entrySet().iterator();
    L109:
        if (r148.hasNext() == false) goto L189;
        Map.Entry r149 = (Map.Entry) r148.next();
        com.bytedance.android.anya.internal.u r150 = (com.bytedance.android.anya.internal.u) r149.getKey();
        final MVIViewPagerAdapter r151 = (MVIViewPagerAdapter) r149.getValue();
        s0 r152 = (s0) r210.f41740c.a(r150);
        if (r152 == null) goto L109;
        if (r151 == null) goto L188;
        final com.bytedance.android.anya.internal.t r153 = (com.bytedance.android.anya.internal.t) r152;
        final boolean r154 = r210.f41740c.f41709d;
        List<com.bytedance.android.anya.internal.t.b> r155 = r153.f41714c;     // Catch: Throwable -> L184
        if (r154 == false) goto L117;
    L171:
        Set r156 = CollectionsKt.toSet(r153);     // Catch: Throwable -> L184
        Iterator<T> r157 = r151.f41573a.iterator();     // Catch: Throwable -> L184
    L173:
        if (r157.hasNext() == false) goto L181;
        MVIState r158 = (MVIState) r157.next();     // Catch: Throwable -> L184
        if (r156.contains(r158) == false) goto L173;
        DelegatingMVIBindingImpl r159 = (DelegatingMVIBindingImpl) ((LinkedHashMap) r151.f41574b).get(r158);     // Catch: Throwable -> L184
        if (r159 == null) goto L173;
        c r160 = (c) r159.f41622d;     // Catch: Throwable -> L184
        if (r160 == null) goto L173;
        r160.q(false);     // Catch: Throwable -> L184
        goto L173
    L181:
        r151.f41573a = CollectionsKt.toList(r153);     // Catch: Throwable -> L184
        r151.notifyDataSetChanged();     // Catch: Throwable -> L184
    L182:
        Unit r161 = Unit.INSTANCE;     // Catch: Throwable -> L184
        r153.f41714c.clear();
        r101 = false;
        goto L109
    L117:
        if (Intrinsics.areEqual((com.bytedance.android.anya.internal.t.b) CollectionsKt.firstOrNull(r155), com.bytedance.android.anya.internal.t.b.a.f41721c) == true) goto L171;
        int r162 = r151.f41573a.size();     // Catch: Throwable -> L184
        ArrayList r163 = new ArrayList(r162);     // Catch: Throwable -> L184
        int r164 = 0;
    L120:
        if (r164 >= r162) goto L122;
        r163.add(Integer.valueOf(r164));     // Catch: Throwable -> L184
        r164 = r164 + 1;     // Catch: Throwable -> L184
        goto L120
    L122:
        Iterator<T> r165 = r155.iterator();     // Catch: Throwable -> L184
    L124:
        if (r165.hasNext() == false) goto L139;
        com.bytedance.android.anya.internal.t.b r166 = (com.bytedance.android.anya.internal.t.b) r165.next();     // Catch: Throwable -> L184
        if ((r166 instanceof com.bytedance.android.anya.internal.t.b.d) == true) goto L127;
        if ((r166 instanceof com.bytedance.android.anya.internal.t.b.c) == true) goto L130;
        if ((r166 instanceof com.bytedance.android.anya.internal.t.b.e) == false) goto L124;
        int r167 = r166.f41720b;     // Catch: Throwable -> L184
        int r168 = 0;
    L137:
        if (r168 >= r167) goto L124;
        r163.set(r166.f41719a + r168, r101);     // Catch: Throwable -> L184
        r168 = r168 + 1;     // Catch: Throwable -> L184
        goto L137
    L130:
        int r169 = r166.f41719a;     // Catch: Throwable -> L184
        int r170 = r166.f41720b;     // Catch: Throwable -> L184
        ArrayList r171 = new ArrayList(r170);     // Catch: Throwable -> L184
        int r172 = 0;
    L131:
        if (r172 >= r170) goto L133;
        r171.add(r101);     // Catch: Throwable -> L184
        r172 = r172 + 1;     // Catch: Throwable -> L184
        goto L131
    L133:
        r163.addAll(r169, r171);     // Catch: Throwable -> L184
        goto L124
    L127:
        int r173 = r166.f41719a;     // Catch: Throwable -> L184
        r163.subList(r173, r166.f41720b + r173).clear();     // Catch: Throwable -> L184
        goto L124
    L139:
        final LinkedHashMap r174 = new LinkedHashMap();     // Catch: Throwable -> L184
        LinkedHashMap r175 = new LinkedHashMap();     // Catch: Throwable -> L184
        Iterator r176 = r163.iterator();     // Catch: Throwable -> L184
        int r177 = 0;
    L141:
        if (r176.hasNext() == false) goto L149;
        Object r178 = r176.next();     // Catch: Throwable -> L184
        int r179 = r177 + 1;     // Catch: Throwable -> L184
        if (r177 >= 0) goto L145;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L184
    L145:
        Integer r180 = (Integer) r178;     // Catch: Throwable -> L184
        r174.put(Integer.valueOf(r177), r180);     // Catch: Throwable -> L184
        if (r180 == null) goto L148;
        r175.put(r180, Integer.valueOf(r177));     // Catch: Throwable -> L184
    L148:
        r177 = r179;
        goto L141
    L149:
        Iterator<T> r181 = r151.f41573a.iterator();     // Catch: Throwable -> L184
        int r182 = 0;
    L151:
        if (r181.hasNext() == false) goto L170;
        Object r183 = r181.next();     // Catch: Throwable -> L184
        int r184 = r182 + 1;     // Catch: Throwable -> L184
        if (r182 >= 0) goto L155;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L184
    L155:
        MVIState r185 = (MVIState) r183;     // Catch: Throwable -> L184
        DelegatingMVIBindingImpl r186 = (DelegatingMVIBindingImpl) ((LinkedHashMap) r151.f41574b).get(r185);     // Catch: Throwable -> L184
        if (r186 == null) goto L169;
        Integer r187 = (Integer) r175.get(Integer.valueOf(r182));     // Catch: Throwable -> L184
        if (r187 == null) goto L169;
        int r188 = r187.intValue();     // Catch: Throwable -> L184
        if (r188 < 0) goto L169;
        if (r153.a(r188) != r185) goto L164;
        boolean r189 = true;
    L165:
        if (r189 == false) goto L168;
        ((c) r186.f41622d).q(false);     // Catch: Throwable -> L184
        goto L169
    L168:
        throw new IllegalStateException(("list item should be exactly same, original: " + r185 + '@' + r182 + ", new index: " + r153.a(r188) + '@' + r188).toString());     // Catch: Throwable -> L184
    L164:
        r189 = false;
    L169:
        r182 = r184;
        goto L151
    L170:
        r151.f41573a = SequencesKt.toList(SequencesKt.mapIndexed(CollectionsKt.asSequence(r153), new MVIViewPagerAdapter$updateList$$inlined$consumeJournalList$runtime_release$lambda$1(r174, r151, r154, r153)));     // Catch: Throwable -> L184
        r151.notifyDataSetChanged();     // Catch: Throwable -> L184
    L184:
        th = move-exception;
        r153.f41714c.clear();
        throw th;
    L188:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.MVIViewPagerAdapter<com.bytedance.android.anya.MVIState<*>, com.bytedance.android.anya.MVIAction>");
    L189:
        b(r210, r210.f41738a);
        if (r210.f41740c.f41710e == true) goto L268;
        r210.f41738a.clearModifyState$runtime_release();
        return;
    }

    /* JADX WARN: Incorrect types in method signature: <T::TACTION;>(TT;)V */
    public final void o(p r100) {
        com.bytedance.android.anya.internal.m<?, ACTION> r101 = this.f41537b;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(STATE r100, com.bytedance.android.anya.internal.m<STATE, ACTION> r101) {
        this.f41538c = r100;
        r101.c((Map) this.f41540e.getValue());
        this.f41537b = r101;
        this.f41536a = true;
        e();
        g();
    }
}
