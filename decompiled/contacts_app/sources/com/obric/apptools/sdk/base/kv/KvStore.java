package com.obric.apptools.sdk.base.kv;

import com.obric.apptools.sdk.base.log.L;
import com.obric.apptools.sdk.base.utils.KtExt;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KvStore.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/apptools/sdk/base/kv/KvStore;", "", "()V", "TAG", "", "impl", "Lcom/obric/apptools/sdk/base/kv/IKvStore;", "acquire", "dump", "", "()Lkotlin/Unit;", "setImpl", "tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KvStore {
    public static final KvStore INSTANCE = null;
    private static final String TAG = "KvStore";
    private static IKvStore impl;

    static {
        INSTANCE = new KvStore();
    }

    private KvStore() {
    }

    public static final /* synthetic */ IKvStore access$getImpl$p() {
        return impl;
    }

    public final void setImpl(IKvStore r3) {
        Intrinsics.checkNotNullParameter(r3, "impl");
        impl = r3;
        L.d(TAG, "init kvStore, record count: " + r3.count());
        if (r3.isDebug() == false) goto L6;
        dump();
        return;
    }

    private final Unit dump() {
        KtExt r7 = KtExt.INSTANCE;
        L.d(TAG, "dump kvStore >>>");
        long r1 = System.currentTimeMillis();
        IKvStore r8 = access$getImpl$p();
        Unit r3 = null;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("impl");
        r8 = null;
    L5:
        Map<String, ?> r9 = r8.all();
        if (r9 == null) goto L14;
        Intrinsics.checkNotNullExpressionValue(r9, "all()");
        SortedMap r10 = MapsKt.toSortedMap(r9);
        if (r10 == null) goto L14;
        Iterator r11 = r10.entrySet().iterator();
    L11:
        if (r11.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) r11.next();
        L.d(TAG, "dump, " + ((String) r4.getKey()) + ": " + KtExt.INSTANCE.dumpStr(r4.getValue()));
        goto L11
    L13:
        r3 = Unit.INSTANCE;
    L14:
        L.d(TAG, "dump kvStore <<< cost: " + (System.currentTimeMillis() - r1) + " ms");
        return r3;
    }

    @JvmStatic
    public static final IKvStore acquire() {
        IKvStore r0 = impl;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("impl");
        return null;
    L6:
        return r0;
    }
}
