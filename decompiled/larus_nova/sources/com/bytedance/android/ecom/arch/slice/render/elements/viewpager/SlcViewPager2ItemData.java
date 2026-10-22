package com.bytedance.android.ecom.arch.slice.render.elements.viewpager;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcViewPager2ItemData {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f50555f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f50557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f50558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SlcElement f50559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f50560e;

    static {
        f50555f = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcViewPager2ItemData.class), "itemDataCtx", "getItemDataCtx()Ljava/util/Map;"))};
    }

    public SlcViewPager2ItemData(Object r100, SlcElement r101, Map<String, ? extends Object> r102) {
        this.f50558c = r100;
        this.f50559d = r101;
        this.f50560e = r102;
        if (r100 == null) goto L5;
        int r103 = r100.hashCode();
    L6:
        this.f50556a = r103;
        this.f50557b = LazyKt.lazy(new SlcViewPager2ItemData$itemDataCtx$2(this));
        return;
    L5:
        r103 = (int) r101.itemKey;
        goto L6
    }
}
