package com.stepos.ailauncher.express.screenops;

import Ua.M;
import W3.SetTextTarget;
import W3.f;
import W3.g;
import Y8.t;
import Z8.C1173v;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.Collection;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)I"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.express.screenops.ScreenOpsRepository$setEditTexts$2", f = "ScreenOpsRepository.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ScreenOpsRepository$setEditTexts$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Integer>, Object> {
    final /* synthetic */ List<SetTextTarget> $targets;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenOpsRepository$setEditTexts$2(List<SetTextTarget> list, InterfaceC4014c<? super ScreenOpsRepository$setEditTexts$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$targets = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ScreenOpsRepository$setEditTexts$2(this.$targets, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return ((ScreenOpsRepository$setEditTexts$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        int i10 = 0;
        if (this.$targets.isEmpty()) {
            return C4109a.f(0);
        }
        List<g> listD = f.f6652a.d(this.$targets);
        if (!(listD instanceof Collection) || !listD.isEmpty()) {
            for (g gVar : listD) {
                if (gVar instanceof g.Failure) {
                    g.Failure failure = (g.Failure) gVar;
                    Log.w("ScreenOpsRepo", "setEditContent fail code=" + failure.getCode() + " msg=" + failure.getMessage());
                }
                if ((gVar instanceof g.b) && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        return C4109a.f(i10);
    }
}
