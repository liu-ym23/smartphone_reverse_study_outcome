package com.bytedance.android.ec.hybrid.xelement.ecomgiftlist;

import com.bytedance.android.ec.host.api.ui.xelement.LynxEcomHorizonListCardData;
import com.lynx.react.bridge.ReadableArray;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECLynxGiftListView f47753a;

    public a(ECLynxGiftListView r100) {
        this.f47753a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        ReadableArray r101 = (ReadableArray) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        ECLynxGiftListView r102 = this.f47753a;
        int r103 = ECLynxGiftListView.f47745b;
        r102.getClass();
        ArrayList<Object> r104 = r101.toArrayList();
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L8;
        T r107 = r106.next();
        if ((r107 instanceof HashMap) == false) goto L4;
        r105.add(r107);
        goto L4
    L8:
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r109 = r105.iterator();
    L10:
        if (r109.hasNext() == false) goto L12;
        r108.add((LynxEcomHorizonListCardData) ECLynxGiftListView.O((HashMap) r109.next(), LynxEcomHorizonListCardData.class));
        goto L10
    L12:
        return r108;
    }
}
