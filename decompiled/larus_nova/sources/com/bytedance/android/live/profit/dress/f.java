package com.bytedance.android.live.profit.dress;

import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f87109a = null;

    static {
        f87109a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Map r101 = (Map) r100;
        Intrinsics.checkNotNullParameter(r101, "list");
        return SequencesKt.toList(SequencesKt.filterNotNull(SequencesKt.map(MapsKt.asSequence(r101), DressKevaUtils$load$2$1$1.INSTANCE)));
    }
}
