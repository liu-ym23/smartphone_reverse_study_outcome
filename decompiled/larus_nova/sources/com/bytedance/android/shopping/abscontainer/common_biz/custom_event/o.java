package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class o<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f164263a;

    public o(String r100) {
        this.f164263a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        b43.c r102 = b43.c.f17507a;
        return ComparisonsKt.compareValues((Integer) m43.a.a(((z33.a) r101).e(), this.f164263a + ".validate_priority"), (Integer) m43.a.a(((z33.a) r100).e(), this.f164263a + ".validate_priority"));
    }
}
