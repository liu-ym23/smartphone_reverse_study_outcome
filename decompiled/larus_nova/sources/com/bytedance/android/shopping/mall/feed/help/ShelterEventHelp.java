package com.bytedance.android.shopping.mall.feed.help;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class ShelterEventHelp implements s, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<String, JSONObject>> f176959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f176960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f176961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, List<Pair<String, JSONObject>>> f176962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f176963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<BaseViewHolder> f176964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ShelterEventHelp$attachListener$1 f176965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f176966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f176967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f176968j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q f176969k;

    @Override // com.bytedance.android.shopping.mall.feed.help.g
    public final void j(boolean r100) {
    }

    public final void b() {
        Set<BaseViewHolder> r100 = this.f176964f;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L3:
        Integer r103 = null;
        if (r102.hasNext() == false) goto L15;
        ECHybridListItemVO r104 = ((BaseViewHolder) r102.next()).f47152c;
        if (r104 == null) goto L14;
        com.bytedance.android.ec.hybrid.list.entity.n r105 = r104.f47041o;
        if (r105 == null) goto L14;
        List<com.bytedance.android.ec.hybrid.list.entity.c> r106 = r105.f47141c;
        if (r106 == null) goto L14;
        com.bytedance.android.ec.hybrid.list.entity.c r107 = (com.bytedance.android.ec.hybrid.list.entity.c) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L14;
        r103 = r107.f47078h;
    L14:
        r101.add(r103);
        goto L3
    L15:
        List r108 = CollectionsKt.filterNotNull(r101);
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L41
        Iterator r110 = ((ArrayList) this.f176959a).iterator();     // Catch: Throwable -> L41
    L18:
        if (r110.hasNext() == false) goto L39;
        Pair<String, JSONObject> r111 = (Pair) r110.next();     // Catch: Throwable -> L41
        Object r112 = r111.getSecond().opt("item_data_flag");     // Catch: Throwable -> L41
        if ((r112 instanceof Integer) == true) goto L22;
        r112 = null;
    L22:
        Integer r113 = (Integer) r112;     // Catch: Throwable -> L41
        if (r113 != null) goto L25;
    L33:
        AppLogNewUtils.onEventV3(r111.getFirst(), r111.getSecond());     // Catch: Throwable -> L41
    L35:
        if (this.f176962d.isEmpty() == false) goto L18;
        RecyclerView r114 = this.f176963e;     // Catch: Throwable -> L41
        if (r114 == null) goto L18;
        r114.removeOnChildAttachStateChangeListener(this.f176965g);     // Catch: Throwable -> L41
        goto L18
    L25:
        if (r108.isEmpty() == true) goto L33;
        if (r108.contains(r113) == true) goto L33;
        List<Pair<String, JSONObject>> r115 = (List) ((LinkedHashMap) this.f176962d).get(r113);     // Catch: Throwable -> L41
        if (r115 != null) goto L32;
        r115 = new ArrayList();     // Catch: Throwable -> L41
    L32:
        r115.add(r111);     // Catch: Throwable -> L41
        this.f176962d.put(r113, r115);     // Catch: Throwable -> L41
        goto L35
    L39:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L43:
        ((ArrayList) this.f176959a).clear();
        q r116 = this.f176969k;
        if (r116 == null) goto L46;
        r116.h((ShelterEventHelp$popupListener$2.a) this.f176968j.getValue());
    L46:
        q r117 = this.f176969k;
        if (r117 == null) goto L65;
        r117.a((ShelterEventHelp$halfPageListener$2.a) this.f176967i.getValue());
        return;
    L65:
        return;
    L41:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.bytedance.android.shopping.mall.feed.help.ShelterEventHelp$attachListener$1] */
    public ShelterEventHelp(q r100) {
        this.f176969k = r100;
        this.f176959a = new ArrayList();
        this.f176962d = new LinkedHashMap();
        this.f176964f = new LinkedHashSet();
        this.f176965g = new ShelterEventHelp$attachListener$1(this);
        this.f176966h = true;
        this.f176967i = LazyKt.lazy(new ShelterEventHelp$halfPageListener$2(this));
        this.f176968j = LazyKt.lazy(new ShelterEventHelp$popupListener$2(this));
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.g
    public final void k(boolean r100) {
        this.f176960b = r100;
        if (this.f176961c == true) goto L6;
        b();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.feed.help.s
    public final boolean a(final String r100, final JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "eventParams");
        if (this.f176969k != null) goto L5;
        return false;
    L5:
        if (this.f176966h == false) goto L11;
        t93.a.c(new ShelterEventHelp$checkShelterAndReport$1(this, r100, r101));
        return true;
    L11:
        return false;
    }
}
