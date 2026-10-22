package com.bytedance.android.shopping.buynow.eventcenter.common;

import com.bytedance.android.shopping.buynow.utils.n;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.Comparator;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f170924a;

    public a(String r100) {
        this.f170924a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r110) {
        Object r111 = n.a(((c) r110).s(), CollectionsKt.listOf(new String[]{this.f170924a, "validate_priority"}), 0);
        Double r101 = null;
        if ((r111 instanceof Number) == true) goto L5;
        r111 = null;
    L5:
        Number r112 = (Number) r111;
        if (r112 == null) goto L8;
        Double r113 = Double.valueOf(r112.doubleValue());
    L9:
        Object r102 = n.a(((c) r100).s(), CollectionsKt.listOf(new String[]{this.f170924a, "validate_priority"}), 0);
        if ((r102 instanceof Number) == true) goto L12;
        r102 = null;
    L12:
        Number r103 = (Number) r102;
        if (r103 == null) goto L16;
        r101 = Double.valueOf(r103.doubleValue());
    L16:
        return ComparisonsKt.compareValues(r113, r101);
    L8:
        r113 = null;
        goto L9
    }
}
