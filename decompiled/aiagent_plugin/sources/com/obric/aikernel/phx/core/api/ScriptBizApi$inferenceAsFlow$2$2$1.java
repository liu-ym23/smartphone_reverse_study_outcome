package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.h.b.p;

/* JADX INFO: compiled from: ScriptBizApi.kt */
/* JADX INFO: loaded from: classes3.dex */
final class ScriptBizApi$inferenceAsFlow$2$2$1 extends p implements m<Bundle, String, Object> {
    public static final ScriptBizApi$inferenceAsFlow$2$2$1 INSTANCE = null;

    static {
        INSTANCE = new ScriptBizApi$inferenceAsFlow$2$2$1();
    }

    ScriptBizApi$inferenceAsFlow$2$2$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Bundle r1, String r2) {
        o.e(r1, "b");
        o.e(r2, "k");
        return r1.get(r2);
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(Bundle r3, String r4) {
        return invoke2((Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
    }
}
