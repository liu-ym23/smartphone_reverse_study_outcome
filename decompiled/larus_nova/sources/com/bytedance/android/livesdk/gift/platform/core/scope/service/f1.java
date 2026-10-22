package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class f1 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.configmodel.e2 f131538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f131539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o>> f131540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LongSparseArray<Integer> f131541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f131542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f131543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.gift.model.a2> f131544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<Long> f131545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Integer> f131546i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final yz0.k f131547j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b2 f131548k;

    public static final class a {
    }

    public static final class b implements wp2.l {
        public b() {
        }
    }

    static {
    }

    public final String d() {
        LinkedHashSet r100 = new LinkedHashSet();
        List<com.bytedance.android.livesdk.gift.model.a2> r101 = this.f131544g;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(((com.bytedance.android.livesdk.gift.model.a2) r103.next()).getScene());
        goto L4
    L6:
        r100.addAll(r102);
        if (r100.isEmpty() == false) goto L10;
        return null;
    L10:
        return TextUtils.join("-", r100);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (this.f131538a.b() == true) goto L5;
        return;
    L5:
        ((rq2.a) vh6.c.b(rq2.a.class)).tc(new b());
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        if (this.f131538a.b() == true) goto L5;
        return;
    L5:
        ((rq2.a) vh6.c.b(rq2.a.class)).removeGiftAsyncSortCallback();
    }

    public final String c(long r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        Iterator<T> r102 = this.f131544g.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        com.bytedance.android.livesdk.gift.model.a2 r103 = (com.bytedance.android.livesdk.gift.model.a2) r102.next();
        if (r103.getEffectedGiftIds().contains(Long.valueOf(r100)) == false) goto L4;
        r101.add(r103.getScene());
        goto L4
    L9:
        if (r101.isEmpty() == false) goto L12;
        return null;
    L12:
        return TextUtils.join("-", r101);
    }

    public final boolean f(long r100) {
        Iterator<T> r101 = this.f131544g.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (((com.bytedance.android.livesdk.gift.model.a2) r101.next()).getEffectedGiftIds().contains(Long.valueOf(r100)) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final void g(List<? extends com.bytedance.android.livesdk.gift.model.a2> r100) {
        Intrinsics.checkNotNullParameter(r100, "giftSortStrategyList");
        JSONObject r101 = new JSONObject();
        r101.putOpt("version", 2);     // Catch: JSONException -> L6
        r101.putOpt("room_id", Long.valueOf(this.f131547j.getRoom().getRoomId()));     // Catch: JSONException -> L6
        r101.putOpt("gift_sort_strategy", new JSONArray(GsonProtectorUtils.toJson(GsonHelper.get(), r100)));     // Catch: JSONException -> L6
    L4:
        ((rq2.a) vh6.c.b(rq2.a.class)).triggerGiftAsyncSort(r101);
    }

    public f1(yz0.k r100, b2 r101) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "giftRecommendLogService");
        this.f131547j = r100;
        this.f131548k = r101;
        com.bytedance.android.livesdk.gift.configmodel.e2 r102 = (com.bytedance.android.livesdk.gift.configmodel.e2) com.bytedance.android.livesdk.gift.platform.core.h.f130654h0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.f130639a[58]);
        this.f131538a = r102;
        this.f131539b = r102.a();
        this.f131540c = new ConcurrentHashMap();
        this.f131541d = new LongSparseArray();
        this.f131543f = "";
        this.f131544g = new ArrayList();
        this.f131545h = new LinkedHashSet();
        this.f131546i = new ArrayList();
    }

    public final String a(int r100, long r101) {
        LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o> r102 = this.f131540c.get(Integer.valueOf(r100));
        if (r102 == null) goto L7;
        com.bytedance.android.livesdk.gift.platform.core.model.o r103 = r102.get(r101);
        if (r103 == null) goto L7;
        return r103.e();
    L7:
        return null;
    }
}
