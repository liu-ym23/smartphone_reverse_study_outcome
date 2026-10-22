package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import androidx.collection.LruCache;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f167974a;

    public o(List r100) {
        this.f167974a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Object[] r101 = (Object[]) r100;
        Intrinsics.checkNotNullParameter(r101, "rets");
        Iterator<T> r102 = CollectionsKt.sortedWith(ArraysKt.filterIsInstance(r101, w.b.class), new n()).iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L13;
        T r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        w.b r106 = (w.b) r104;
        h r107 = new h(r106.f167992b, r106.f167995e, r106.f167996f);
        this.f167974a.add(r107);
        LruCache<String, h> r108 = InlineLongTitleComponentView.f167943d;
        String r109 = r106.f167994d;
        if (r109 != null) goto L11;
        r109 = "";
    L11:
        r108.put(r109, r107);
        r103 = r105;
        goto L4
    L13:
        return Unit.INSTANCE;
    }
}
