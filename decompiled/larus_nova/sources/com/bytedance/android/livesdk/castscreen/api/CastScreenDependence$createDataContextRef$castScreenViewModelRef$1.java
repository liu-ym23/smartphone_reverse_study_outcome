package com.bytedance.android.livesdk.castscreen.api;

import com.bytedance.live.datacontext.d;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/Pair;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class CastScreenDependence$createDataContextRef$castScreenViewModelRef$1 extends Lambda implements Function0<Pair<?, ?>> {
    public static final CastScreenDependence$createDataContextRef$castScreenViewModelRef$1 INSTANCE = null;

    static {
        INSTANCE = new CastScreenDependence$createDataContextRef$castScreenViewModelRef$1();
    }

    public CastScreenDependence$createDataContextRef$castScreenViewModelRef$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<?, ?> invoke2() {
        return d.a(AnonymousClass1.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Pair<?, ?> invoke() {
        return invoke2();
    }
}
