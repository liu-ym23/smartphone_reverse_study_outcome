package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import st1.a;

/* JADX INFO: loaded from: classes8.dex */
public final class AnchorAnnouncementProxy extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tt1.a f122254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> f122255b;

    @Override // st1.a
    public final void c() {
    }

    public AnchorAnnouncementProxy() {
        this.f122254a = new tt1.a();
        this.f122255b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("open", new AnchorAnnouncementProxy$funcMap$1(this))});
    }

    @Override // st1.a
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> a() {
        return this.f122255b;
    }
}
