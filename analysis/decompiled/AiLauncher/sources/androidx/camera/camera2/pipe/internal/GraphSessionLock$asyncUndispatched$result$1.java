package androidx.camera.camera2.pipe.internal;

import Ua.M;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.internal.GraphSessionLock$asyncUndispatched$result$1", f = "GraphSessionLock.kt", l = {90}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class GraphSessionLock$asyncUndispatched$result$1<T> extends SuspendLambda implements p<M, InterfaceC4014c<? super T>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10992a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10993b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p<M, InterfaceC4014c<? super T>, Object> f10994c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GraphSessionLock$asyncUndispatched$result$1(p<? super M, ? super InterfaceC4014c<? super T>, ? extends Object> pVar, InterfaceC4014c<? super GraphSessionLock$asyncUndispatched$result$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10994c = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        GraphSessionLock$asyncUndispatched$result$1 graphSessionLock$asyncUndispatched$result$1 = new GraphSessionLock$asyncUndispatched$result$1(this.f10994c, interfaceC4014c);
        graphSessionLock$asyncUndispatched$result$1.f10993b = obj;
        return graphSessionLock$asyncUndispatched$result$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super T> interfaceC4014c) {
        return ((GraphSessionLock$asyncUndispatched$result$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10992a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        M m10 = (M) this.f10993b;
        kotlinx.coroutines.d.g(m10);
        p<M, InterfaceC4014c<? super T>, Object> pVar = this.f10994c;
        this.f10992a = 1;
        Object objInvoke = pVar.invoke(m10, this);
        return objInvoke == objG ? objG : objInvoke;
    }
}
