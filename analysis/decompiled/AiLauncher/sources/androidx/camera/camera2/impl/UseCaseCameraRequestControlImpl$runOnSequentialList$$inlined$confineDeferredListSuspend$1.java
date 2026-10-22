package androidx.camera.camera2.impl;

import Ua.InterfaceC1083u;
import Ua.M;
import Ua.Q;
import Y8.t;
import Z8.C1173v;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$runOnSequentialList$$inlined$confineDeferredListSuspend$1", f = "UseCaseCameraRequestControl.kt", l = {179}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class UseCaseCameraRequestControlImpl$runOnSequentialList$$inlined$confineDeferredListSuspend$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9926a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC5074l f9927b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f9928c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseCameraRequestControlImpl$runOnSequentialList$$inlined$confineDeferredListSuspend$1(InterfaceC5074l interfaceC5074l, List list, InterfaceC4014c interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9927b = interfaceC5074l;
        this.f9928c = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new UseCaseCameraRequestControlImpl$runOnSequentialList$$inlined$confineDeferredListSuspend$1(this.f9927b, this.f9928c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((UseCaseCameraRequestControlImpl$runOnSequentialList$$inlined$confineDeferredListSuspend$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9926a;
        if (i10 == 0) {
            C4849c.b(obj);
            InterfaceC5074l interfaceC5074l = this.f9927b;
            this.f9926a = 1;
            obj = interfaceC5074l.invoke(this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        List list = this.f9928c;
        int i11 = 0;
        for (Object obj2 : (Iterable) obj) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            CoroutineAdaptersKt.s((Q) obj2, (InterfaceC1083u) list.get(i11));
            i11 = i12;
        }
        return t.f7040a;
    }
}
