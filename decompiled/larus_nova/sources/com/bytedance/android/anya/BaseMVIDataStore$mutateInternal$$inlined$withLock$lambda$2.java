package com.bytedance.android.anya;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "STORE", "Lcom/bytedance/android/anya/BaseMVIDataStore;", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/anya/BaseMVIDataStore$mutateInternal$1$1"}, k = 3, mv = {1, 1, 16})
final class BaseMVIDataStore$mutateInternal$$inlined$withLock$lambda$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $action$inlined;
    final /* synthetic */ com.bytedance.android.anya.internal.f $mutator$inlined;
    final /* synthetic */ com.bytedance.android.anya.internal.l $this_mutateInternal$inlined;
    final /* synthetic */ BaseMVIDataStore this$0;

    public BaseMVIDataStore$mutateInternal$$inlined$withLock$lambda$2(BaseMVIDataStore r100, com.bytedance.android.anya.internal.l r101, Function1 r102, com.bytedance.android.anya.internal.f r103) {
        this.this$0 = r100;
        this.$this_mutateInternal$inlined = r101;
        this.$action$inlined = r102;
        this.$mutator$inlined = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        com.bytedance.android.anya.internal.f r100 = this.$mutator$inlined;
        Map<com.bytedance.android.anya.internal.n<?, ?>, Object> r101 = r100.f41689a;
        LinkedHashMap r102 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator r103 = ((LinkedHashMap) r101).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        Object r105 = r104.getKey();
        com.bytedance.android.anya.internal.n r106 = (com.bytedance.android.anya.internal.n) r104.getKey();
        r102.put(r105, new j(r104.getValue(), r106.a(), true));
        goto L4
    L6:
        Iterator<T> r107 = this.this$0.f41529b.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        ((Function2) r107.next()).invoke(r102, this.$this_mutateInternal$inlined.f41695a);
        goto L8
    L10:
        ((LinkedHashMap) r100.f41689a).clear();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
