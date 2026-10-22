package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a@\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\u0010\u0004\u001a\u0018\u0012\t\u0012\u0007H\u0003¢\u0006\u0002\b\u0006\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u00060\u0005¨\u0006\u0007"}, d2 = {"mapToInsMediatorLiveData", "Landroidx/lifecycle/LiveData;", "Y", "X", "transform", "Lkotlin/Function1;", "Lkotlin/jvm/JvmSuppressWildcards;", "ec-shopping-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class MapToInsMediatorLiveDataKt {
    public static final <X, Y> LiveData<Y> mapToInsMediatorLiveData(LiveData<X> r100, final Function1<X, Y> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$mapToInsMediatorLiveData");
        Intrinsics.checkNotNullParameter(r101, "transform");
        int r102 = r100.getVersion();
        Object r103 = LiveData.NOT_SET;
        if ((r103 instanceof Integer) == true) goto L6;
    L7:
        InsMediatorLiveData r104 = new InsMediatorLiveData(r101.invoke(r100.getValue()));
    L9:
        r104.setSource(r100, new AnonymousClass1(r101));
        return r104;
    L6:
        if (r102 != ((Integer) r103).intValue()) goto L7;
        r104 = new InsMediatorLiveData();
        goto L9
    }
}
