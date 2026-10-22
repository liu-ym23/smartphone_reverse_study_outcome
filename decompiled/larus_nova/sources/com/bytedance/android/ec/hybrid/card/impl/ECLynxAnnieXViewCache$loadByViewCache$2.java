package com.bytedance.android.ec.hybrid.card.impl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECLynxAnnieXViewCache$loadByViewCache$2 extends Lambda implements Function0<JSONObject> {
    final /* synthetic */ com.bytedance.android.ec.hybrid.anniex.h $annieXLifeCycle;

    public ECLynxAnnieXViewCache$loadByViewCache$2(com.bytedance.android.ec.hybrid.anniex.h r100) {
        this.$annieXLifeCycle = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ JSONObject invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final JSONObject invoke2() {
        return this.$annieXLifeCycle.f46283b;
    }
}
