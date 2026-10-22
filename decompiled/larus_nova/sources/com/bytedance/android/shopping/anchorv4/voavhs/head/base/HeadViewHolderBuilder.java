package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import android.content.Context;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.holder.FindSameHolderBuilder;
import com.bytedance.android.shopping.anchorv4.voavhs.head.holder.r;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class HeadViewHolderBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f168500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<com.bytedance.android.shopping.anchorv4.voavhs.head.c> f168501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f168502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<n, List<String>> f168503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, ? extends n> f168504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f168505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> f168506g;

    public final CommonFindSameElement a() {
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.c> r100 = this.f168501b;
        if (r100 == null) goto L18;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.anchorv4.voavhs.head.c) r102).getType(), HeadViewType.FIND_SAME.getType()) == false) goto L6;
    L11:
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r103 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r102;
        if (r103 != null) goto L14;
        return null;
    L14:
        return r103.f168545r;
    L10:
        r102 = null;
        goto L11
    L18:
        return null;
    }

    public final List<a> b() {
        ArrayList r100 = new ArrayList();
        Iterator<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r101 = this.f168506g.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.addAll(r101.next().f168486c);
        goto L4
    L6:
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<n, List<String>>> r103 = this.f168503d.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        Map.Entry<n, List<String>> r104 = r103.next();
        n r105 = r104.getKey();
        Iterator<String> r106 = r104.getValue().iterator();
    L11:
        if (r106.hasNext() == false) goto L8;
        r102.put(r106.next(), r105);
        goto L11
    L13:
        this.f168504e = r102;
        this.f168501b = r100;
        if (com.bytedance.android.ec.core.opt.ab.c.d() == false) goto L38;
        Iterator r107 = ((ArrayList) com.bytedance.android.shopping.anchorv4.voavhs.head.d.a(this.f168506g)).iterator();
    L17:
        if (r107.hasNext() == false) goto L21;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.anchorv4.voavhs.head.c) r108).getType(), HeadViewType.GOOD_COMMENT.getType()) == false) goto L17;
    L22:
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r109 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r108;
        if (r109 == null) goto L38;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r110 = r109.f168536i;
        if (r110 == null) goto L27;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b.d(r110);
    L27:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r111 = r109.f168536i;
        if (r111 == null) goto L30;
        r111.i();
    L30:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r112 = r109.f168536i;
        if (r112 == null) goto L33;
        r112.g();
    L33:
        String r113 = r109.G;
        if (r113 == null) goto L38;
        u83.a r114 = g33.b.f479797b.j();
        if (r114 == null) goto L38;
        r114.d(r113, HeadViewHolderBuilder$getHeadViewHolders$2$1$1.INSTANCE);
        goto L38
    L21:
        r108 = null;
    L38:
        ArrayList r115 = new ArrayList();
        Iterator r116 = r100.iterator();
        int r117 = 0;
    L40:
        if (r116.hasNext() == false) goto L56;
        Object r118 = r116.next();
        int r119 = r117 + 1;
        if (r117 >= 0) goto L44;
        CollectionsKt.throwIndexOverflow();
    L44:
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r120 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r118;
        if (com.bytedance.android.shopping.anchorv4.voavhs.head.j.a() == false) goto L49;
        n r121 = this.f168504e.get(r120.getType());
        if (r121 == null) goto L52;
        com.bytedance.android.shopping.anchorv3.detail.widget.l r122 = r121.h(r120, r117);
    L53:
        if (r122 == null) goto L55;
        r115.add(r122);
    L55:
        r117 = r119;
    L52:
        r122 = null;
        goto L53
    L49:
        n r123 = this.f168504e.get(r120.getType());
        if (r123 == null) goto L52;
        r122 = r123.o(r120, r117);
        goto L53
    L56:
        return r115;
    }

    public final int c() {
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.c> r100 = com.bytedance.android.shopping.anchorv4.voavhs.head.d.a(this.f168506g);
        if (r100.isEmpty() == true) goto L28;
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L7:
        if (r101.hasNext() == false) goto L20;
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r103 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r101.next();
        if (Intrinsics.areEqual(r103.getType(), HeadViewType.VIDEO.getType()) == false) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L7;
        r102 = r102 + 1;
        if (r102 >= 0) goto L7;
        CollectionsKt.throwCountOverflow();
        goto L7
    L11:
        if (Intrinsics.areEqual(r103.getType(), HeadViewType.GOOD_COMMENT.getType()) == true) goto L14;
        r104 = false;
        goto L15
    L20:
        return r102;
    L28:
        return 0;
    }

    public final void d() {
        Iterator<T> r100 = com.bytedance.android.shopping.anchorv4.voavhs.head.d.a(this.f168506g).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.anchorv4.voavhs.head.c) r101).getType(), HeadViewType.GOOD_COMMENT.getType()) == false) goto L4;
    L9:
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r102 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r101;
        if (r102 == null) goto L16;
        String r103 = r102.G;
        if (r103 == null) goto L16;
        u83.a r104 = g33.b.f479797b.j();
        if (r104 == null) goto L16;
        r104.a(r103);
    L16:
        e83.a r105 = e83.a.f471296d;
        r105.getClass();
        e83.a.f471294b.clear();
        e83.a.f471295c = null;
        r105.f471297a.a();
        Iterator<n> r106 = this.f168503d.keySet().iterator();
    L18:
        if (r106.hasNext() == false) goto L25;
        n r107 = r106.next();
        if ((r107 instanceof h) == true) goto L22;
        r107 = null;
    L22:
        h r108 = (h) r107;
        if (r108 == null) goto L18;
        r108.onDestroy();
        goto L18
    L25:
        return;
    L8:
        r101 = null;
        goto L9
    }

    public final void e() {
        Iterator<n> r100 = this.f168503d.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        n r101 = r100.next();
        if ((r101 instanceof h) == true) goto L8;
        r101 = null;
    L8:
        h r102 = (h) r101;
        if (r102 == null) goto L4;
        r102.onPause();
        goto L4
    }

    public final void f() {
        Iterator<n> r100 = this.f168503d.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        n r101 = r100.next();
        if ((r101 instanceof h) == true) goto L8;
        r101 = null;
    L8:
        h r102 = (h) r101;
        if (r102 == null) goto L4;
        r102.onResume();
        goto L4
    }

    public final void g(float r100) {
        Iterator<n> r101 = this.f168503d.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        n r102 = r101.next();
        if ((r102 instanceof h) == true) goto L8;
        r102 = null;
    L8:
        h r103 = (h) r102;
        if (r103 == null) goto L4;
        r103.i(r100);
        goto L4
    }

    public final void h(List<Float> r100) {
        Intrinsics.checkNotNullParameter(r100, "progresses");
        r r101 = this.f168500a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "progresses");
        Iterator<T> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L17;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        float r106 = ((Number) r104).floatValue();
        if (r103 >= ((ArrayList) r101.f168705j).size()) goto L23;
        if (r106 <= 0.0f) goto L16;
        if (r106 >= 100.0f) goto L16;
        ((com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.b) ListProtector.get(r101.f168705j, r103)).c(r106);
    L16:
        r103 = r105;
        goto L4
    L23:
        return;
    }

    public final void update(List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "newList");
        ArrayList r101 = new ArrayList();
        Iterator<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.addAll(r102.next().f168486c);
        goto L4
    L6:
        Unit r103 = Unit.INSTANCE;
        this.f168501b = r101;
        ArrayList r104 = new ArrayList();
        Iterator r105 = r101.iterator();
    L8:
        if (r105.hasNext() == false) goto L15;
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r106 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r105.next();
        n r107 = this.f168504e.get(r106.getType());
        if (r107 == null) goto L12;
        r107.m(r106);
        Unit r108 = Unit.INSTANCE;
    L13:
        if (r108 == null) goto L8;
        r104.add(r108);
        goto L8
    L12:
        r108 = null;
        goto L13
    }

    public HeadViewHolderBuilder(Context r100, e r101, List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r102, l53.b r103, d r104, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "headNodeGroupList");
        this.f168505f = r101;
        this.f168506g = r102;
        r r105 = new r(r100, r104, r103, r110);
        this.f168500a = r105;
        Function0<Boolean> r106 = new HeadViewHolderBuilder$queryIfShownInSmallScreenMode$1(this);
        this.f168502c = r106;
        HashMap<n, List<String>> r107 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(r105, CollectionsKt.listOf(new String[]{HeadViewType.VIDEO.getType(), HeadViewType.GOOD_COMMENT.getType()})), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.h(r100, r104), CollectionsKt.listOf(HeadViewType.PICTURE.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.n(r100, r104), CollectionsKt.listOf(HeadViewType.SIMPLE_LINK.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.a(r100, r104), CollectionsKt.listOf(HeadViewType.COMMENT.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.c(r100, r104), CollectionsKt.listOf(HeadViewType.SHOW.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.j(r100, r104), CollectionsKt.listOf(HeadViewType.COMBINATION.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.m(r100, r104, r106), CollectionsKt.listOf(HeadViewType.SIZE.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.p(r100, r104), CollectionsKt.listOf(HeadViewType.SKU.getType())), TuplesKt.to(new FindSameHolderBuilder(r100, r104), CollectionsKt.listOf(HeadViewType.FIND_SAME.getType())), TuplesKt.to(new com.bytedance.android.shopping.anchorv4.voavhs.head.holder.k(r100, r104), CollectionsKt.listOf(HeadViewType.PIONEER.getType()))});
        this.f168503d = r107;
        this.f168504e = MapsKt.emptyMap();
        e83.a r108 = e83.a.f471296d;
        List r109 = CollectionsKt.toList(r107.keySet());
        Function0<List<? extends com.bytedance.android.shopping.anchorv4.voavhs.head.c>> r111 = new AnonymousClass1(this);
        r108.getClass();
        e83.a.b(r109, r111);
    }
}
