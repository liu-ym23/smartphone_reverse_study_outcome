package com.android.ttcjpaysdk.kmp.base.http;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ouc.e;
import ouc.w;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "json$delegate", "Lkotlin/Lazy;", "cj_base_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CJHttpClientKt {
    private static final Lazy json$delegate = null;

    public static /* synthetic */ Unit a(e r100) {
        return json_delegate$lambda$1$lambda$0(r100);
    }

    public static /* synthetic */ ouc.a b() {
        return json_delegate$lambda$1();
    }

    static {
        json$delegate = LazyKt.lazy(new a());
    }

    public static final ouc.a getJson() {
        return (ouc.a) json$delegate.getValue();
    }

    private static final ouc.a json_delegate$lambda$1() {
        return w.a(new b());
    }

    private static final Unit json_delegate$lambda$1$lambda$0(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$Json");
        r100.f526816c = true;
        r100.f526820g = true;
        return Unit.INSTANCE;
    }
}
