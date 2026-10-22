package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PdpRecyclerViewPoolTrimManager$trimTo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $cacheSize;

    public PdpRecyclerViewPoolTrimManager$trimTo$1(int r100) {
        this.$cacheSize = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        List<WeakReference<RecyclerView>> r100 = p.f181787a;
        p.f181788b = Integer.valueOf(this.$cacheSize);
        List<WeakReference<RecyclerView>> r101 = p.f181787a;
        CollectionsKt.removeAll(r101, AnonymousClass1.INSTANCE);
        Iterator r102 = ((ArrayList) r101).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        RecyclerView r103 = (RecyclerView) ((WeakReference) r102.next()).get();
        if (r103 == null) goto L4;
        List<WeakReference<RecyclerView>> r104 = p.f181787a;
        p.a(r103, this.$cacheSize);
        goto L4
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
