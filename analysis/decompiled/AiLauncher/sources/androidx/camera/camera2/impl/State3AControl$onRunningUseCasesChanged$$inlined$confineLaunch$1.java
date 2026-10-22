package androidx.camera.camera2.impl;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.State3AControl$onRunningUseCasesChanged$$inlined$confineLaunch$1", f = "State3AControl.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class State3AControl$onRunningUseCasesChanged$$inlined$confineLaunch$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9829a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f9830b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ State3AControl f9831c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public State3AControl$onRunningUseCasesChanged$$inlined$confineLaunch$1(InterfaceC4014c interfaceC4014c, Set set, State3AControl state3AControl) {
        super(2, interfaceC4014c);
        this.f9830b = set;
        this.f9831c = state3AControl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new State3AControl$onRunningUseCasesChanged$$inlined$confineLaunch$1(interfaceC4014c, this.f9830b, this.f9831c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((State3AControl$onRunningUseCasesChanged$$inlined$confineLaunch$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean z10;
        C4063a.g();
        if (this.f9829a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (!this.f9830b.isEmpty()) {
            int iL = this.f9831c.l(this.f9830b);
            synchronized (this.f9831c.lock) {
                if (this.f9831c._template != iL) {
                    this.f9831c._template = iL;
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                this.f9831c.v();
            }
        }
        return t.f7040a;
    }
}
