package com.stepos.agentsprite.internal;

import Ua.M;
import Ua.U;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "com.stepos.agentsprite.internal.OverlayChannel$set$1$1", f = "AgentControllerImpl.kt", l = {412}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class OverlayChannel$set$1$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f23401a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f23402b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OverlayChannel<T> f23403c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayChannel$set$1$1(long j10, OverlayChannel<T> overlayChannel, InterfaceC4014c<? super OverlayChannel$set$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f23402b = j10;
        this.f23403c = overlayChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new OverlayChannel$set$1$1(this.f23402b, this.f23403c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((OverlayChannel$set$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f23401a;
        if (i10 == 0) {
            C4849c.b(obj);
            long j10 = this.f23402b;
            this.f23401a = 1;
            if (U.a(j10, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        Object obj2 = this.f23403c.lock;
        OverlayChannel<T> overlayChannel = this.f23403c;
        synchronized (obj2) {
            if (overlayChannel.transientActive) {
                overlayChannel.transientActive = false;
                if (!kotlin.jvm.internal.p.d(overlayChannel.base, overlayChannel.lastPublished)) {
                    overlayChannel.i(overlayChannel.base);
                }
            }
        }
        return t.f7040a;
    }
}
