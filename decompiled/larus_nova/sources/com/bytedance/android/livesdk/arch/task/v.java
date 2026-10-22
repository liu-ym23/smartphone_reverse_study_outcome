package com.bytedance.android.livesdk.arch.task;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes7.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TbTaskFlower f103928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f103929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f103930c;

    public v(TbTaskFlower r100, x r101, Ref.ObjectRef r102) {
        this.f103928a = r100;
        this.f103929b = r101;
        this.f103930c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        TbTaskFlower r101 = this.f103928a;
        e r102 = this.f103929b;
        TbTaskFlower.b(r101, r102, (Throwable) r100);
        Disposable r103 = (Disposable) this.f103930c.element;
        if (r103 == null) goto L6;
        this.f103928a.f103875b.remove(r103);
        return;
    }
}
