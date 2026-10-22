package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import com.bytedance.android.livesdkapi.app.AppConstants;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import st1.a;
import tt1.d;

/* JADX INFO: loaded from: classes8.dex */
public final class DislikeProxy extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f122258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> f122259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Function1<Object, Unit>> f122260c;

    @Override // st1.a
    public final void c() {
        this.f122258a.getClass();
    }

    public DislikeProxy() {
        this.f122258a = new d();
        this.f122259b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(AppConstants.BUNDLE_DISLIKE, new DislikeProxy$funcMap$1(this))});
        this.f122260c = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("LiveRoomLogger", new DislikeProxy$injectObjMap$1(this)), TuplesKt.to("FragmentBundle", new DislikeProxy$injectObjMap$2(this)), TuplesKt.to("enterRoomTimeStamp", new DislikeProxy$injectObjMap$3(this))});
    }

    @Override // st1.a
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> a() {
        return this.f122259b;
    }

    @Override // st1.a
    public final Map<String, Function1<Object, Unit>> b() {
        return this.f122260c;
    }
}
