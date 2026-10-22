package com.bytedance.android.shopping.widget.rittag;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.model.response.RitTagUI;
import com.bytedance.android.shopping.widget.rittag.viewimpl.RitTagSplitView;
import com.bytedance.android.shopping.widget.rittag.viewimpl.RitTagTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/widget/rittag/RitTagViewCache;", "Landroidx/lifecycle/LifecycleEventObserver;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RitTagViewCache implements LifecycleEventObserver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<? extends Class<? extends Object>, RitTagUI.RitTagUIItem.UIItemType> f187447d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<LifecycleOwner, RitTagViewCache> f187448e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f187449f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<RitTagUI.RitTagUIItem.UIItemType, LinkedBlockingQueue<b>> f187450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<com.bytedance.android.shopping.widget.rittag.viewimpl.d> f187451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleOwner f187452c;

    public static final class a {
        public a() {
        }
    }

    static {
        f187449f = new a();
        f187447d = MapsKt.mapOf(new Pair[]{TuplesKt.to(RitTagTextView.class, RitTagUI.RitTagUIItem.UIItemType.TEXT), TuplesKt.to(com.bytedance.android.shopping.widget.rittag.viewimpl.a.class, RitTagUI.RitTagUIItem.UIItemType.IMAGE), TuplesKt.to(RitTagSplitView.class, RitTagUI.RitTagUIItem.UIItemType.SPLIT)});
        f187448e = new ConcurrentHashMap();
    }

    public RitTagViewCache(LifecycleOwner r100) {
        this.f187452c = r100;
        r100.getLifecycle().addObserver(this);
        this.f187450a = new ConcurrentHashMap();
        this.f187451b = new LinkedBlockingQueue();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
        this.f187450a.clear();
        this.f187451b.clear();
        return;
    }
}
