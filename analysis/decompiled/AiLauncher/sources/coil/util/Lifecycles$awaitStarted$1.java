package coil.util;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "coil.util.-Lifecycles", f = "Lifecycles.kt", l = {44}, m = "awaitStarted")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* renamed from: coil.util.-Lifecycles$awaitStarted$1, reason: invalid class name */
/* loaded from: classes.dex */
public final class Lifecycles$awaitStarted$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f15814a;

    /* renamed from: b, reason: collision with root package name */
    public Object f15815b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f15816c;

    /* renamed from: d, reason: collision with root package name */
    public int f15817d;

    public Lifecycles$awaitStarted$1(InterfaceC4014c<? super Lifecycles$awaitStarted$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f15816c = obj;
        this.f15817d |= Integer.MIN_VALUE;
        return Lifecycles.a(null, this);
    }
}
