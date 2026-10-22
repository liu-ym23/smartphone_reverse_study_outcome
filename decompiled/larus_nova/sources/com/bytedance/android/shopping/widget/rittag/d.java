package com.bytedance.android.shopping.widget.rittag;

import android.content.Context;
import androidx.collection.LruCache;
import com.bytedance.android.ec.model.response.RitTagUI;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LruCache<Integer, d> f187454e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f187455f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<RitTagUI.RitTagUIItem.UIItemType, Function1<Context, b>> f187456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<RitTagUI.RitTagUIItem.UIItemType, Function3<b, RitTagUI.RitTagUIItem, RitTagUI, Unit>> f187457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f187458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f187459d;

    public static final class a {
        public a() {
        }
    }

    static {
        f187455f = new a();
        f187454e = new LruCache(20);
    }

    public d() {
        this.f187458c = 14;
        this.f187459d = 10;
        RitTagUI.RitTagUIItem.UIItemType r100 = RitTagUI.RitTagUIItem.UIItemType.TEXT;
        RitTagUI.RitTagUIItem.UIItemType r101 = RitTagUI.RitTagUIItem.UIItemType.IMAGE;
        RitTagUI.RitTagUIItem.UIItemType r102 = RitTagUI.RitTagUIItem.UIItemType.SPLIT;
        this.f187456a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, RitTagViewFactory$elementGenerators$1.INSTANCE), TuplesKt.to(r101, RitTagViewFactory$elementGenerators$2.INSTANCE), TuplesKt.to(r102, RitTagViewFactory$elementGenerators$3.INSTANCE)});
        this.f187457b = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, new RitTagViewFactory$elementStyleBinders$1(this)), TuplesKt.to(r101, new RitTagViewFactory$elementStyleBinders$2(this)), TuplesKt.to(r102, RitTagViewFactory$elementStyleBinders$3.INSTANCE)});
    }
}
