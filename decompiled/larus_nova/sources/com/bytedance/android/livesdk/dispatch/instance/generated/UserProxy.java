package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import st1.a;
import tt1.o;

/* JADX INFO: loaded from: classes8.dex */
public final class UserProxy extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f122271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> f122272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Function1<Object, Unit>> f122273c;

    @Override // st1.a
    public final void c() {
        o r100 = this.f122271a;
        Disposable r101 = r100.f547536a;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        Disposable r102 = r100.f547537b;
        if (r102 == null) goto L9;
        r102.dispose();
        return;
    }

    public UserProxy() {
        this.f122271a = new o();
        this.f122272b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("follow", new UserProxy$funcMap$1(this)), TuplesKt.to("unfollow", new UserProxy$funcMap$2(this))});
        this.f122273c = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("LiveActivity", new UserProxy$injectObjMap$1(this))});
    }

    @Override // st1.a
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> a() {
        return this.f122272b;
    }

    @Override // st1.a
    public final Map<String, Function1<Object, Unit>> b() {
        return this.f122273c;
    }
}
