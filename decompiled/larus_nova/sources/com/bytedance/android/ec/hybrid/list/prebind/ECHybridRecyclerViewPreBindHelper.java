package com.bytedance.android.ec.hybrid.list.prebind;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.ECHybridSettings;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.common.utility.Logger;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridRecyclerViewPreBindHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, RecyclerView.ViewHolder> f47254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VirtualLayoutManager f47255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView.RecycledViewPool f47256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView.Recycler f47257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends RecyclerView.ViewHolder> f47258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<Integer> f47259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Field f47260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Field f47261h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Field f47262i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f47263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f47264k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f47265l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f47266m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f47267n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f47268o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Boolean f47269p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ECHybridRecyclerView f47270q;

    public ECHybridRecyclerViewPreBindHelper(ECHybridRecyclerView r100) {
        this.f47270q = r100;
        this.f47254a = new HashMap();
        this.f47263j = true;
        this.f47266m = true;
        this.f47268o = 2;
    }

    public final void a(boolean r100) {
        Logger.d("NaMallPreBind", "#preBind#: isClearing = " + this.f47265l);
        if (this.f47265l == false) goto L5;
        return;
    L5:
        this.f47265l = true;
        if (r100 == false) goto L13;
        ECHybridRecyclerView r101 = this.f47270q;
        if (r101 == null) goto L13;
        ECHybridListAdapter r102 = r101.getAdapter();
        if (r102 == null) goto L13;
        int r103 = ECHybridListAdapter.f46839w;
        r102.H2(null);
    L13:
        if (ECHybridSettings.a() == false) goto L25;
        ECHybridRecyclerView r104 = this.f47270q;
        if (r104 == null) goto L25;
        ECHybridListAdapter r105 = r104.getAdapter();
        if (r105 == null) goto L25;
        Set r106 = CollectionsKt.toSet(((HashMap) this.f47254a).values());
        Intrinsics.checkNotNullParameter(r106, "holders");
        LinkedHashSet r107 = new LinkedHashSet();
        Iterator r108 = r106.iterator();
    L20:
        if (r108.hasNext() == false) goto L24;
        RecyclerView.ViewHolder r109 = (RecyclerView.ViewHolder) r108.next();
        if ((r109 instanceof BaseViewHolder) == false) goto L20;
        r107.add(r109);
        ((BaseViewHolder) r109).onRelease();
        goto L20
    L24:
        r105.f46843d.removeAll(r107);
    L25:
        ((HashMap) this.f47254a).clear();
        this.f47265l = false;
    }

    public final void b(final ECHybridListAdapter r100, final int r101) {
        if (this.f47270q != null) goto L6;
        return;
    L6:
        if (this.f47263j == true) goto L10;
        Logger.d("NaMallPreBind", "#preBind#: disabled, pos=" + r101);
        return;
    L10:
        if (this.f47264k == false) goto L16;
        if (this.f47266m == false) goto L16;
        Logger.e("NaMallPreBind", "#preBind#: return interrupt, pos=" + r101);
        return;
    L16:
        if (((HashMap) this.f47254a).containsKey(Integer.valueOf(r101)) == true) goto L27;
        List<Integer> r102 = this.f47259f;
        if (r102 != null) goto L20;
    L22:
        final int r103 = r100.getItemViewType(r101);
        if (r103 != ECHybridListItemType.INVALID.getType()) goto L25;
        return;
    L25:
        kk.d.c(new ECHybridRecyclerViewPreBindHelper$handlePreBindInternal$1(this, r103, r100, r101));
        return;
    L20:
        if (((ArrayList) r102).contains(Integer.valueOf(r101)) != true) goto L22;
    L27:
        Logger.d("NaMallPreBind", "#preBind#: continue=" + r101);
    }

    public static /* synthetic */ void d(ECHybridRecyclerViewPreBindHelper r100, boolean r101, Integer r110, Boolean r111, int r112) {
        if ((r112 & 2) == 0) goto L5;
        Integer r102 = null;
    L7:
        if ((r112 & 4) == 0) goto L9;
        Boolean r103 = null;
    L10:
        r100.c(r101, r102, r103, null, null);
        return;
    L9:
        r103 = r111;
        goto L10
    L5:
        r102 = r110;
        goto L7
    }

    public final void c(boolean r100, Integer r110, Boolean r111, Long r112, Integer r113) {
        Logger.d("NaMallPreBind", "#preBind#: start preBind");
        if (this.f47255b != null) goto L31;
        ECHybridRecyclerView r101 = this.f47270q;
        Integer r102 = null;
        if (r101 == null) goto L7;
        VirtualLayoutManager r103 = r101.getLayoutManager();
    L9:
        if ((r103 instanceof VirtualLayoutManager) == true) goto L11;
        r103 = null;
    L11:
        this.f47255b = r103;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L28
        Field r105 = RecyclerView.class.getDeclaredField("mRecycler");     // Catch: Throwable -> L28
        r105.setAccessible(true);     // Catch: Throwable -> L28
        Object r106 = r105.get(this.f47270q);     // Catch: Throwable -> L28
        if ((r106 instanceof RecyclerView.Recycler) == true) goto L15;
        r106 = null;
    L15:
        this.f47257d = (RecyclerView.Recycler) r106;     // Catch: Throwable -> L28
        Field r107 = RecyclerView.Recycler.class.getDeclaredField("mCachedViews");     // Catch: Throwable -> L28
        r107.setAccessible(true);     // Catch: Throwable -> L28
        Object r108 = r107.get(this.f47257d);     // Catch: Throwable -> L28
        if ((r108 instanceof List) == true) goto L18;
        r108 = null;
    L18:
        this.f47258e = (List) r108;     // Catch: Throwable -> L28
        StringBuilder r109 = new StringBuilder("#preBind#:initSuccess recycler=");     // Catch: Throwable -> L28
        r109.append(this.f47257d);     // Catch: Throwable -> L28
        r109.append(", cachedViews=");     // Catch: Throwable -> L28
        List<? extends RecyclerView.ViewHolder> r114 = this.f47258e;     // Catch: Throwable -> L28
        if (r114 == null) goto L21;
        r102 = Integer.valueOf(r114.size());     // Catch: Throwable -> L28
    L21:
        r109.append(r102);     // Catch: Throwable -> L28
        Logger.d("NaMallPreBind", r109.toString());     // Catch: Throwable -> L28
        this.f47259f = new ArrayList();     // Catch: Throwable -> L28
        ECHybridRecyclerView r115 = this.f47270q;     // Catch: Throwable -> L28
        if (r115 == null) goto L26;
        ECHybridListAdapter r116 = r115.getAdapter();     // Catch: Throwable -> L28
        if (r116 == null) goto L26;
        r116.registerAdapterDataObserver(new ECHybridRecyclerViewPreBindHelper$initAdapter$1(this));     // Catch: Throwable -> L28
    L26:
        this.f47267n = true;     // Catch: Throwable -> L28
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    L7:
        r103 = null;
    L31:
        if (this.f47267n == true) goto L33;
        return;
    L33:
        List<Integer> r118 = this.f47259f;
        if (r118 == null) goto L36;
        ((ArrayList) r118).clear();
    L36:
        List<? extends RecyclerView.ViewHolder> r119 = this.f47258e;
        if (r119 == null) goto L45;
        Iterator<? extends RecyclerView.ViewHolder> r120 = r119.iterator();
    L40:
        if (r120.hasNext() == false) goto L45;
        RecyclerView.ViewHolder r121 = r120.next();
        List<Integer> r122 = this.f47259f;
        if (r122 == null) goto L40;
        ((ArrayList) r122).add(Integer.valueOf(r121.getLayoutPosition()));
    L45:
        if (ECHybridSettings.a() == false) goto L56;
        Boolean r123 = this.f47269p;
        if (r123 == null) goto L56;
        if ((!Intrinsics.areEqual(r123, Boolean.valueOf(r100))) == false) goto L56;
        ECHybridRecyclerView r124 = this.f47270q;
        if (r124 == null) goto L56;
        ECHybridListAdapter r125 = r124.getAdapter();
        if (r125 == null) goto L56;
        r125.H2(new ECHybridRecyclerViewPreBindHelper$preBind$2(this));
    L56:
        if (r111 == null) goto L58;
        boolean r126 = r111.booleanValue();
    L59:
        if (r112 == null) goto L61;
        long r127 = r112.longValue();
    L62:
        if (r113 == null) goto L64;
        int r128 = r113.intValue();
    L65:
        if (r110 == null) goto L67;
        int r129 = r110.intValue();
    L68:
        VirtualLayoutManager r130 = this.f47255b;
        if (r130 == null) goto L71;
        int r131 = r130.findFirstVisibleItemPosition();
    L72:
        int r132 = r131 + r128;
        VirtualLayoutManager r133 = this.f47255b;
        if (r133 == null) goto L75;
        int r134 = r133.findLastVisibleItemPosition();
    L76:
        int r135 = r134 + r128;
        VirtualLayoutManager r136 = this.f47255b;
        if (r136 == null) goto L79;
        int r137 = r136.getItemCount();
    L80:
        Logger.d("NaMallPreBind", "#preBind#: first=" + r132 + ", last=" + r135 + ", count=" + r137);
        ECHybridRecyclerView r138 = this.f47270q;
        if (r138 == null) goto L99;
        ECHybridListAdapter r139 = r138.getAdapter();
        if (r139 == null) goto L99;
        if (r100 == false) goto L92;
        if (r126 == false) goto L89;
        int r140 = r135 + 1;
        int r141 = RangesKt.coerceAtMost((r135 + r129) + 1, r137);
        int r142 = r140;
    L87:
        if (r142 >= r141) goto L99;
        this.f47270q.postDelayed(new b(r139, r142, this), ((long) (r142 - r140)) * r127);
        r142 = r142 + 1;
        goto L87
    L89:
        int r143 = r135 + 1;
        int r144 = RangesKt.coerceAtMost((r135 + r129) + 1, r137);
    L90:
        if (r143 >= r144) goto L99;
        b(r139, r143);
        r143 = r143 + 1;
        goto L90
    L92:
        if (r126 == false) goto L96;
        int r145 = r132 - r129;
        int r146 = RangesKt.coerceAtLeast(r145, 0);
        int r147 = RangesKt.coerceAtLeast(r132, 0);
    L94:
        if (r146 >= r147) goto L99;
        b(r139, r146);
        this.f47270q.postDelayed(new c(r139, r146, this), ((long) (r146 - RangesKt.coerceAtLeast(r145, 0))) * r127);
        r146 = r146 + 1;
        goto L94
    L96:
        int r148 = RangesKt.coerceAtLeast(r132 - r129, 0);
        int r149 = RangesKt.coerceAtLeast(r132, 0);
    L97:
        if (r148 >= r149) goto L99;
        b(r139, r148);
        r148 = r148 + 1;
    L99:
        this.f47269p = Boolean.valueOf(r100);
        return;
    L79:
        r137 = 0;
        goto L80
    L75:
        r134 = 0;
        goto L76
    L71:
        r131 = 0;
        goto L72
    L67:
        r129 = this.f47268o;
        goto L68
    L64:
        r128 = 0;
        goto L65
    L61:
        r127 = 20;
        goto L62
    L58:
        r126 = false;
        goto L59
    }
}
