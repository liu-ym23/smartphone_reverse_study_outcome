package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import st1.a;
import tt1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class SubscribeAnchorProxy extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f122266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> f122267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Function1<Object, Unit>> f122268c;

    @Override // st1.a
    public final void c() {
        this.f122266a.f547531a.clear();
    }

    public SubscribeAnchorProxy() {
        this.f122266a = new k();
        this.f122267b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("subscribePlay", new SubscribeAnchorProxy$funcMap$1(this)), TuplesKt.to("unsubscribePlay", new SubscribeAnchorProxy$funcMap$2(this))});
        this.f122268c = new LinkedHashMap();
    }

    @Override // st1.a
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> a() {
        return this.f122267b;
    }

    @Override // st1.a
    public final Map<String, Function1<Object, Unit>> b() {
        return this.f122268c;
    }
}
