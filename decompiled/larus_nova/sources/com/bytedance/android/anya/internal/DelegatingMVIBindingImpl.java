package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.DiffContext;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.a0;
import com.bytedance.android.anya.d0;
import com.bytedance.android.anya.p;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class DelegatingMVIBindingImpl<STATE extends MVIState<?>, ACTION extends com.bytedance.android.anya.p, VIEW extends BaseMVIView<STATE, ACTION>> implements m<STATE, ACTION> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f41619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f41620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m<?, ACTION> f41621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VIEW f41622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public STATE f41623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<DelegatingMVIBindingImpl<STATE, ACTION, VIEW>, Unit> f41624f;

    @Override // com.bytedance.android.anya.q
    public final void a() {
        if (this.f41620b == false) goto L5;
        return;
    L5:
        this.f41624f.invoke(this);
        VIEW r100 = this.f41622d;
        STATE r101 = this.f41623e;
        if (r101 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        r100.h(r101, this);
        this.f41619a.add(this.f41621c.d(new DelegatingMVIBindingImpl$bind$1(this.f41622d)));
        this.f41620b = true;
    }

    @Override // com.bytedance.android.anya.internal.m
    public final DiffContext f() {
        return this.f41621c.f();
    }

    @Override // com.bytedance.android.anya.q
    public final void unbind() {
        if (this.f41620b == true) goto L5;
        return;
    L5:
        this.f41620b = false;
        this.f41622d.j();
        this.f41623e = null;
        this.f41619a.clear();
    }

    @Override // com.bytedance.android.anya.internal.m
    public final void b(ACTION r100) {
        this.f41621c.b(r100);
    }

    @Override // com.bytedance.android.anya.internal.m
    public final void c(Map<q<?, ?>, ? extends d0<?, ?>> r100) {
        this.f41621c.c(r100);
    }

    @Override // com.bytedance.android.anya.internal.m
    public final Disposable d(Function1<? super a0, Boolean> r100) {
        Disposable r101 = this.f41621c.d(r100);
        this.f41619a.add(r101);
        return r101;
    }

    @Override // com.bytedance.android.anya.internal.m
    public final void e(Map<q<?, ?>, ? extends d0<?, ?>> r100) {
        this.f41621c.e(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelegatingMVIBindingImpl(m<?, ACTION> r100, VIEW r101, STATE r102, Function1<? super DelegatingMVIBindingImpl<STATE, ACTION, VIEW>, Unit> r103) {
        this.f41621c = r100;
        this.f41622d = r101;
        this.f41623e = r102;
        this.f41624f = r103;
        this.f41619a = new CompositeDisposable();
    }
}
