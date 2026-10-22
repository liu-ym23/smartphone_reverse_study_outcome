package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import st1.a;
import tt1.c;

/* JADX INFO: loaded from: classes8.dex */
public final class StatusPanelProxy extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f122263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> f122264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Function1<Object, Unit>> f122265c;

    @Override // st1.a
    public final void c() {
        this.f122263a.f547521a = null;
    }

    public StatusPanelProxy() {
        this.f122263a = new c();
        this.f122264b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("open", new StatusPanelProxy$funcMap$1(this))});
        this.f122265c = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("AnchorStatusPanel", new StatusPanelProxy$injectObjMap$1(this))});
    }

    @Override // st1.a
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> a() {
        return this.f122264b;
    }

    @Override // st1.a
    public final Map<String, Function1<Object, Unit>> b() {
        return this.f122265c;
    }
}
