package com.bytedance.android.live.profit.livepet.instance;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/google/gson/JsonObject;", "Lcom/bytedance/revenue/platform/api/core/JsonObject;", "p1", "Lqu0/a$c;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/google/gson/JsonObject;)Lqu0/a$c;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class LivePetInstance$appendUrlParams$petConfig$1 extends FunctionReferenceImpl implements Function1<JsonObject, qu0.a.c> {
    public static final LivePetInstance$appendUrlParams$petConfig$1 INSTANCE = null;

    static {
        INSTANCE = new LivePetInstance$appendUrlParams$petConfig$1();
    }

    public LivePetInstance$appendUrlParams$petConfig$1() {
        super(1, qu0.a.c.class, "<init>", "<init>(Lcom/google/gson/JsonObject;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final qu0.a.c invoke2(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return new qu0.a.c(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ qu0.a.c invoke(JsonObject r100) {
        return invoke2(r100);
    }
}
