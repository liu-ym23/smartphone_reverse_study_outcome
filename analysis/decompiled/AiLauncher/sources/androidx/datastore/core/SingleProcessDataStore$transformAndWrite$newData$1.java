package androidx.datastore.core;

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
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@InterfaceC4112d(c = "androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1", f = "SingleProcessDataStore.kt", l = {402}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SingleProcessDataStore$transformAndWrite$newData$1<T> extends SuspendLambda implements p<M, InterfaceC4014c<? super T>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f13373a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p<T, InterfaceC4014c<? super T>, Object> f13374b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ T f13375c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SingleProcessDataStore$transformAndWrite$newData$1(p<? super T, ? super InterfaceC4014c<? super T>, ? extends Object> pVar, T t10, InterfaceC4014c<? super SingleProcessDataStore$transformAndWrite$newData$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f13374b = pVar;
        this.f13375c = t10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SingleProcessDataStore$transformAndWrite$newData$1(this.f13374b, this.f13375c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super T> interfaceC4014c) {
        return ((SingleProcessDataStore$transformAndWrite$newData$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f13373a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        p<T, InterfaceC4014c<? super T>, Object> pVar = this.f13374b;
        T t10 = this.f13375c;
        this.f13373a = 1;
        Object objInvoke = pVar.invoke(t10, this);
        return objInvoke == objG ? objG : objInvoke;
    }
}
