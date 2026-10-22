package androidx.camera.camera2.pipe.internal;

import Ua.Q;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import z.z;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lz/z;", M5.b.CREDENTIAL_TOKEN, "LUa/Q;", "<anonymous>", "(Lz/z;)LUa/Q;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.internal.GraphSessionLock$withTokenInAsync$1$deferred$1", f = "GraphSessionLock.kt", l = {64}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class GraphSessionLock$withTokenInAsync$1$deferred$1<T> extends SuspendLambda implements p<z, InterfaceC4014c<? super Q<? extends T>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f11005a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f11006b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p<z, InterfaceC4014c<? super Q<? extends T>>, Object> f11007c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GraphSessionLock$withTokenInAsync$1$deferred$1(p<? super z, ? super InterfaceC4014c<? super Q<? extends T>>, ? extends Object> pVar, InterfaceC4014c<? super GraphSessionLock$withTokenInAsync$1$deferred$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f11007c = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        GraphSessionLock$withTokenInAsync$1$deferred$1 graphSessionLock$withTokenInAsync$1$deferred$1 = new GraphSessionLock$withTokenInAsync$1$deferred$1(this.f11007c, interfaceC4014c);
        graphSessionLock$withTokenInAsync$1$deferred$1.f11006b = obj;
        return graphSessionLock$withTokenInAsync$1$deferred$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(z zVar, InterfaceC4014c<? super Q<? extends T>> interfaceC4014c) {
        return ((GraphSessionLock$withTokenInAsync$1$deferred$1) create(zVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f11005a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        z zVar = (z) this.f11006b;
        p<z, InterfaceC4014c<? super Q<? extends T>>, Object> pVar = this.f11007c;
        this.f11005a = 1;
        Object objInvoke = pVar.invoke(zVar, this);
        return objInvoke == objG ? objG : objInvoke;
    }
}
