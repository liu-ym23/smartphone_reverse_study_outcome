package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import st1.a;
import tt1.l;

/* JADX INFO: loaded from: classes8.dex */
public final class TestProxy extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f122269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> f122270b;

    @Override // st1.a
    public final void c() {
    }

    public TestProxy() {
        this.f122269a = new l();
        this.f122270b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(EffectConstants.CHANNEL_TEST, new TestProxy$funcMap$1(this))});
    }

    @Override // st1.a
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> a() {
        return this.f122270b;
    }
}
