package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import st1.a;
import tt1.f;

/* JADX INFO: loaded from: classes8.dex */
public final class StableModeContextProxy extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f122261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> f122262b;

    @Override // st1.a
    public final void c() {
    }

    public StableModeContextProxy() {
        this.f122261a = new f();
        this.f122262b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("updateSwitch", new StableModeContextProxy$funcMap$1(this))});
    }

    @Override // st1.a
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> a() {
        return this.f122262b;
    }
}
