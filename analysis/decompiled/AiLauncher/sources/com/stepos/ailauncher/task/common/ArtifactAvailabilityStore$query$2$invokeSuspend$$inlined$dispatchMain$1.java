package com.stepos.ailauncher.task.common;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.common.ArtifactAvailabilityStore$query$2$invokeSuspend$$inlined$dispatchMain$1", f = "ArtifactAvailabilityStore.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactAvailabilityStore$query$2$invokeSuspend$$inlined$dispatchMain$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ InterfaceC5074l $onResult$inlined;
    final /* synthetic */ Map $resolved$inlined;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactAvailabilityStore$query$2$invokeSuspend$$inlined$dispatchMain$1(InterfaceC4014c interfaceC4014c, InterfaceC5074l interfaceC5074l, Map map) {
        super(2, interfaceC4014c);
        this.$onResult$inlined = interfaceC5074l;
        this.$resolved$inlined = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactAvailabilityStore$query$2$invokeSuspend$$inlined$dispatchMain$1(interfaceC4014c, this.$onResult$inlined, this.$resolved$inlined);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ArtifactAvailabilityStore$query$2$invokeSuspend$$inlined$dispatchMain$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.$onResult$inlined.invoke(this.$resolved$inlined);
        return t.f7040a;
    }
}
