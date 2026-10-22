package com.bytedance.android.ecom.arch.slice.adapter;

import com.baidu.platform.comapi.map.MapController;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class a implements b, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient long f50007a;
    private ConcurrentHashMap<String, Object> tags;

    public a() {
        this(0, 1, null);
    }

    public a clone() {
        Object r100 = super.clone();
        if (r100 == null) goto L7;
        a r101 = (a) r100;
        r101.tags = new ConcurrentHashMap(this.tags);
        return r101;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ecom.arch.slice.adapter.BaseSlcAdapterItem");
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.b
    public long getItemKey() {
        return this.f50007a;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return clone();
    }

    public a(long r100) {
        this.f50007a = r100;
        this.tags = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.b
    public boolean areContentsTheSame(b r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        Intrinsics.checkNotNullParameter(r100, "newItem");
        if (this != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.b
    public boolean areItemsTheSame(b r100) {
        Intrinsics.checkNotNullParameter(r100, "newItem");
        Intrinsics.checkNotNullParameter(r100, "newItem");
        if (getItemKey() != r100.getItemKey()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.b
    public void setItemKey(long r100) {
        this.f50007a = r100;
    }

    public void willReplace(b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        setItemKey(r100.getItemKey());
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.b
    public <T> T getTag(Class<T> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100.isInstance(this.tags.get(r101)) == false) goto L9;
        T r102 = (T) this.tags.get(r101);
        if ((r102 instanceof Object) == true) goto L8;
        return null;
    L8:
        return r102;
    L9:
        return null;
    }

    @Override // com.bytedance.android.ecom.arch.slice.adapter.b
    public void setTag(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == null) goto L5;
        this.tags.put(r100, r101);
        return;
    L5:
        this.tags.remove(r100);
    }

    public a(long r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        AtomicLong r103 = g.f50014a;
        r100 = g.f50014a.addAndGet(1);
    L5:
        this(r100);
    }
}
