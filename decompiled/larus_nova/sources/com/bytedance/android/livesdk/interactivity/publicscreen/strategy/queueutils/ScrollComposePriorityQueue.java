package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import android.os.Build;
import com.bytedance.android.live.base.model.message.i4;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.v3;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PersonalizedDisplayInfo;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ScrollComposePriorityQueue implements h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f139548g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> f139549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> f139550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> f139551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> f139552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f139553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ja2.a f139554f;

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f139555a = null;

        static {
            f139555a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            Queue r102 = (Queue) r100;
            Queue r103 = (Queue) r101;
            if (((com.bytedance.android.livesdk.interactivity.api.entity.f) r102.peek()) != null) goto L6;
            return 1;
        L6:
            if (((com.bytedance.android.livesdk.interactivity.api.entity.f) r103.peek()) != null) goto L9;
            return -1;
        L9:
            return (int) (((com.bytedance.android.livesdk.interactivity.api.entity.f) r102.peek()).p().longValue() - ((com.bytedance.android.livesdk.interactivity.api.entity.f) r103.peek()).p().longValue());
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f139556a = null;

        static {
            f139556a = new b();
        }

        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            com.bytedance.android.livesdk.interactivity.api.entity.f r102 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r100;
            com.bytedance.android.livesdk.interactivity.api.entity.f r103 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r101;
            if (r102 != null) goto L5;
            return 1;
        L5:
            if (r103 != null) goto L7;
            return -1;
        L7:
            IPublicAreaCommon r104 = r103.v();
            Long r105 = null;
            if (r104 == null) goto L10;
            Long r106 = r104.getForceInsertionPriority();
        L11:
            IPublicAreaCommon r107 = r102.v();
            if (r107 == null) goto L15;
            r105 = r107.getForceInsertionPriority();
        L15:
            if (Intrinsics.areEqual(r106, r105) == true) goto L32;
            IPublicAreaCommon r108 = r103.v();
            long r109 = 0;
            if (r108 == null) goto L22;
            Long r110 = r108.getForceInsertionPriority();
            if (r110 == null) goto L22;
            long r111 = r110.longValue();
        L23:
            IPublicAreaCommon r112 = r102.v();
            if (r112 == null) goto L29;
            Long r113 = r112.getForceInsertionPriority();
            if (r113 == null) goto L29;
            r109 = r113.longValue();
        L29:
            return (int) (r111 - r109);
        L22:
            r111 = 0;
            goto L23
        L32:
            return (int) (r102.p().longValue() - r103.p().longValue());
        L10:
            r106 = null;
            goto L11
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f139557a = null;

        static {
            f139557a = new c();
        }

        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            com.bytedance.android.livesdk.interactivity.api.entity.f r102 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r100;
            com.bytedance.android.livesdk.interactivity.api.entity.f r103 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r101;
            if (r102 != null) goto L5;
            return 1;
        L5:
            if (r103 != null) goto L8;
            return -1;
        L8:
            return (int) (r102.p().longValue() - r103.p().longValue());
        }
    }

    public static final class d {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final void clear() {
        this.f139549a.clear();
        ((ArrayDeque) this.f139550b).clear();
        ((ArrayDeque) this.f139551c).clear();
        ((ArrayDeque) this.f139552d).clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final int size() {
        return ((this.f139549a.size() + ((ArrayDeque) this.f139550b).size()) + ((ArrayDeque) this.f139551c).size()) + ((ArrayDeque) this.f139552d).size();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> a(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Iterator<T> r101 = this.f139549a.iterator();
    L3:
        Object r102 = null;
        if (r101.hasNext() == false) goto L8;
        Object r103 = r101.next();
        if (r100.invoke(r103).booleanValue() == false) goto L3;
    L9:
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r104 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r103;
        if (r104 != null) goto L19;
        Iterator r105 = ((ArrayDeque) this.f139550b).iterator();
    L13:
        if (r105.hasNext() == false) goto L17;
        Object r106 = r105.next();
        if (r100.invoke(r106).booleanValue() == false) goto L13;
    L18:
        r104 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r106;
        goto L19
    L17:
        r106 = null;
    L19:
        if (r104 != null) goto L28;
        Iterator r107 = ((ArrayDeque) this.f139551c).iterator();
    L22:
        if (r107.hasNext() == false) goto L26;
        Object r108 = r107.next();
        if (r100.invoke(r108).booleanValue() == false) goto L22;
    L27:
        r104 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r108;
        goto L28
    L26:
        r108 = null;
    L28:
        if (r104 != null) goto L49;
        Iterator r109 = ((ArrayDeque) this.f139552d).iterator();
    L31:
        if (r109.hasNext() == false) goto L36;
        Object r110 = r109.next();
        if (r100.invoke(r110).booleanValue() == false) goto L31;
        r102 = r110;
    L36:
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) r102;
    L49:
        return r104;
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> b(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        ArrayList r101 = new ArrayList();
        f(this.f139549a.iterator(), r101, r100);
        f(((ArrayDeque) this.f139550b).iterator(), r101, r100);
        f(((ArrayDeque) this.f139551c).iterator(), r101, r100);
        f(((ArrayDeque) this.f139552d).iterator(), r101, r100);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> e(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        ArrayList r101 = new ArrayList();
        g(this.f139549a.iterator(), r101, r100);
        g(((ArrayDeque) this.f139550b).iterator(), r101, r100);
        g(((ArrayDeque) this.f139551c).iterator(), r101, r100);
        g(((ArrayDeque) this.f139552d).iterator(), r101, r100);
        return r101;
    }

    public ScrollComposePriorityQueue(boolean r100, ja2.a r101) {
        this.f139553e = r100;
        this.f139554f = r101;
        if (r100 == false) goto L8;
        int r102 = Build.VERSION.SDK_INT;
        b r103 = b.f139556a;
        if (r102 < 24) goto L7;
        Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r104 = new PriorityQueue(r103);
    L9:
        this.f139549a = r104;
        this.f139550b = new ArrayDeque();
        this.f139551c = new ArrayDeque();
        this.f139552d = new ArrayDeque(5);
        return;
    L7:
        r104 = new PriorityQueue(100, r103);
        goto L9
    L8:
        r104 = new ArrayDeque();
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> c(k r100, boolean r101) {
        if (r101 == false) goto L4;
        boolean r102 = this.f139553e;
        a r103 = a.f139555a;
        if (r102 == false) goto L52;
        Iterator<T> r104 = this.f139549a.iterator();
        if (r104.hasNext() == true) goto L19;
        Object r105 = null;
    L29:
        final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r106 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r105;
        Queue r107 = (Queue) ComparisonsKt.minOf(this.f139550b, this.f139551c, r103);
        long r108 = Long.MAX_VALUE;
        if (r106 == null) goto L34;
        Long r109 = r106.p();
        if (r109 == null) goto L34;
        long r110 = r109.longValue();
    L35:
        com.bytedance.android.livesdk.interactivity.api.entity.f r111 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r107.peek();
        if (r111 == null) goto L41;
        Long r112 = r111.p();
        if (r112 == null) goto L41;
        r108 = r112.longValue();
    L41:
        if (r110 >= r108) goto L46;
        if (r106 == null) goto L44;
        n.b(new ScrollComposePriorityQueue$poll$1$1(r106));
    L44:
        this.f139549a.remove(r106);
        return r106;
    L46:
        final com.bytedance.android.livesdk.interactivity.api.entity.f r113 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r107.peek();
        if (r113 == null) goto L50;
        n.b(new ScrollComposePriorityQueue$poll$2$1(r113));
    L50:
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) r107.poll();
    L34:
        r110 = Long.MAX_VALUE;
        goto L35
    L19:
        Object r114 = r104.next();
        if (r104.hasNext() == true) goto L22;
    L21:
        r105 = r114;
        goto L29
    L22:
        Long r115 = ((com.bytedance.android.livesdk.interactivity.api.entity.f) r114).p();
    L23:
        Object r116 = r104.next();
        Long r117 = ((com.bytedance.android.livesdk.interactivity.api.entity.f) r116).p();
        if (r115.compareTo(r117) <= 0) goto L27;
        r114 = r116;
        r115 = r117;
    L27:
        if (r104.hasNext() == true) goto L23;
    L52:
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) ((Queue) ComparisonsKt.minOf(this.f139549a, this.f139550b, this.f139551c, r103)).poll();
    L4:
        if (((ArrayDeque) this.f139552d).isEmpty() == false) goto L7;
        if (r100 == null) goto L7;
        r100.a(this.f139549a, this.f139550b, this.f139551c, this.f139552d);
    L7:
        ja2.a r118 = this.f139554f;
        if (r118 == null) goto L13;
        if ((!r118.f497840d) != true) goto L13;
        Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r119 = this.f139552d;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r119, "scrollQueue");
        return r118.a(r119);
    L13:
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) ((ArrayDeque) this.f139552d).poll();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final void d(int r100, final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r101, Function2<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, ? super List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>>, Unit> r110) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r110, "callback");
        int r102 = 0;
        if (this.f139553e == false) goto L13;
        IPublicAreaCommon r103 = r101.v();
        if (r103 == null) goto L9;
        PersonalizedDisplayInfo r104 = r103.getPersonalizedInfo();
        if (r104 == null) goto L9;
        Boolean r105 = r104.isPersonalized();
    L11:
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L13;
        n.b(new ScrollComposePriorityQueue$add$1(r101));
        this.f139549a.add(r101);
        r101.f133140a = "高优消息";
    L57:
        if (size() <= r100) goto L66;
        ArrayList r106 = new ArrayList();
        int r107 = size() - r100;
        if (r107 <= 0) goto L65;
    L60:
        if (r102 >= r107) goto L65;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r108 = c(null, true);
        if (r108 == null) goto L64;
        r106.add(r108);
    L64:
        r102 = r102 + 1;
    L65:
        r110.invoke(r101, r106);
        return;
    L66:
        r110.invoke(r101, null);
        return;
    L9:
        r105 = null;
    L13:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.i r109 = r101.s();
        if (r109 == null) goto L43;
        PublicScreenConfig$MessageModelType r111 = r109.getType();
        if (r111 == null) goto L43;
        if (r111.equals(PublicScreenConfig$MessageModelType.SECRET_CHAT) != true) goto L43;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.i r112 = r101.s();
        if ((r112 instanceof com.bytedance.android.livesdk.interactivity.publicscreen.plugin.e) == true) goto L22;
        r112 = null;
    L22:
        com.bytedance.android.livesdk.interactivity.publicscreen.plugin.e r113 = (com.bytedance.android.livesdk.interactivity.publicscreen.plugin.e) r112;
        if (r113 == null) goto L43;
        i4 r114 = r113.f139144l;
        if (r114 == null) goto L43;
        IPublicAreaCommon r115 = v3.a(r114);
        if (r115 == null) goto L30;
        Integer r116 = Integer.valueOf(r115.getIndividualPriority());
    L31:
        if (r116 != null) goto L34;
    L36:
        if (r116 != null) goto L39;
    L41:
        ((ArrayDeque) this.f139550b).add(r101);
    L42:
        boolean r117 = true;
    L44:
        if (r117 == true) goto L57;
        if ((r101 instanceof com.bytedance.android.livesdk.interactivity.textmessage.model.d) == false) goto L55;
        k0 r118 = (k0) ((com.bytedance.android.livesdk.interactivity.textmessage.model.d) r101).f133141b;
        if (r118.isHighPriority() == false) goto L52;
        this.f139549a.add(r101);
        n.b(new ScrollComposePriorityQueue$add$2(r101));
        r101.f133140a = "高优消息";
        goto L57
    L52:
        if (r118.isLowPriority() == false) goto L54;
        n.b(new ScrollComposePriorityQueue$add$3(r101));
        ((ArrayDeque) this.f139551c).add(r101);
        r101.f133140a = "低优消息";
        goto L57
    L54:
        n.b(new ScrollComposePriorityQueue$add$4(r101));
        ((ArrayDeque) this.f139550b).add(r101);
        r101.f133140a = "中优消息";
        goto L57
    L55:
        n.b(new ScrollComposePriorityQueue$add$5(r101));
        ((ArrayDeque) this.f139550b).add(r101);
        r101.f133140a = "中优消息";
        goto L57
    L39:
        if (r116.intValue() != 30) goto L41;
        ((ArrayDeque) this.f139551c).add(r101);
        goto L42
    L34:
        if (r116.intValue() != 80) goto L36;
        this.f139549a.add(r101);
        goto L42
    L30:
        r116 = null;
    L43:
        r117 = false;
        goto L44
    }

    public final void f(Iterator<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r100, List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r101, Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r102) {
    L3:
        if (r100.hasNext() == false) goto L8;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r103 = r100.next();
        if (r102.invoke(r103).booleanValue() == true) goto L11;
        r100.remove();
        ((ArrayList) r101).add(r103);
        goto L3
    L11:
        return;
    }

    public final void g(Iterator<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r100, List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r101, Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r102) {
    L3:
        if (r100.hasNext() == false) goto L7;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r103 = r100.next();
        if (r102.invoke(r103).booleanValue() == false) goto L3;
        r100.remove();
        ((ArrayList) r101).add(r103);
        goto L3
    }
}
