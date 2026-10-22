package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import androidx.collection.LongSparseArray;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/collection/LongSparseArray;", "Lcom/bytedance/android/livesdk/gift/platform/core/model/o;", "sa", "Lkotlin/sequences/Sequence;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "(Landroidx/collection/LongSparseArray;)Lkotlin/sequences/Sequence;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class FastGiftRecommendService$handleMsg$strategyContextData$1 extends Lambda implements Function1<LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o>, Sequence<? extends com.bytedance.android.livesdk.gift.platform.core.model.o>> {
    public static final FastGiftRecommendService$handleMsg$strategyContextData$1 INSTANCE = null;

    public static final class a implements Sequence<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LongSparseArray f131255a;

        @Override // kotlin.sequences.Sequence
        public final Iterator<Integer> iterator() {
            return RangesKt.until(0, this.f131255a.size()).iterator2();
        }

        public a(LongSparseArray r100) {
            this.f131255a = r100;
        }
    }

    static {
        INSTANCE = new FastGiftRecommendService$handleMsg$strategyContextData$1();
    }

    public FastGiftRecommendService$handleMsg$strategyContextData$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Sequence<com.bytedance.android.livesdk.gift.platform.core.model.o> invoke2(final LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o> r100) {
        Intrinsics.checkNotNullParameter(r100, "sa");
        return SequencesKt.map(new a(r100), new AnonymousClass2(r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Sequence<? extends com.bytedance.android.livesdk.gift.platform.core.model.o> invoke(LongSparseArray<com.bytedance.android.livesdk.gift.platform.core.model.o> r100) {
        return invoke2(r100);
    }
}
