package com.bytedance.android.latch.internal.jsb;

import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f58301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f58302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<JSONObject, Unit> f58303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f58304d;

    public final void a() {
        this.f58304d = this.f58301a.d().subscribe(new C0927a(this), new b(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(c r100, Function0<Unit> r101, Function1<? super JSONObject, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "stateHolder");
        Intrinsics.checkNotNullParameter(r101, "onCall");
        Intrinsics.checkNotNullParameter(r102, "finishWithResult");
        this.f58301a = r100;
        this.f58302b = r101;
        this.f58303c = r102;
    }
}
