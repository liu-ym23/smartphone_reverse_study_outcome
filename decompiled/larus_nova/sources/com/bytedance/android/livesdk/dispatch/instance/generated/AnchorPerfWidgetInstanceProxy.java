package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import st1.a;
import tt1.b;

/* JADX INFO: loaded from: classes8.dex */
public final class AnchorPerfWidgetInstanceProxy extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f122256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> f122257b;

    @Override // st1.a
    public final void c() {
    }

    public AnchorPerfWidgetInstanceProxy() {
        this.f122256a = new b();
        this.f122257b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("open", new AnchorPerfWidgetInstanceProxy$funcMap$1(this))});
    }

    @Override // st1.a
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> a() {
        return this.f122257b;
    }
}
