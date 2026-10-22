package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.datacenter.api.DispatchKt", f = "Dispatch.kt", l = {16}, m = "dispatch")
/* loaded from: classes3.dex */
public final class DispatchKt$dispatch$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29844a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29845b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f29846c;

    /* renamed from: d, reason: collision with root package name */
    public int f29847d;

    public DispatchKt$dispatch$1(InterfaceC4014c<? super DispatchKt$dispatch$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29846c = obj;
        this.f29847d |= Integer.MIN_VALUE;
        return DispatchKt.a(null, null, null, this);
    }
}
