package com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvJsbHandler$actionUpdateHandlers$17 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public KtvJsbHandler$actionUpdateHandlers$17(b r100) {
        super(1, r100, b.class, "downloadTuningEffect", "downloadTuningEffect(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final JsonObject invoke2(JsonObject r100) {
        b r101 = (b) this.receiver;
        int r102 = b.f143784g;
        r101.getClass();
        JsonObject r103 = new JsonObject();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvJsbHandler", "downloadTuningEffect, extraData: " + r100);
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b r104 = r101.c();
        if (r104 == null) goto L5;
        r104.k(r100);
    L5:
        return r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ JsonObject invoke(JsonObject r100) {
        return invoke2(r100);
    }
}
