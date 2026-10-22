package kotlinx.coroutines.flow.internal;

import Xa.c;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "it", "LY8/t;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", l = {208}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class UndispatchedContextCollector$emitRef$1<T> extends SuspendLambda implements p<T, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f36766a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36767b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c<T> f36768c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UndispatchedContextCollector$emitRef$1(c<? super T> cVar, InterfaceC4014c<? super UndispatchedContextCollector$emitRef$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f36768c = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        UndispatchedContextCollector$emitRef$1 undispatchedContextCollector$emitRef$1 = new UndispatchedContextCollector$emitRef$1(this.f36768c, interfaceC4014c);
        undispatchedContextCollector$emitRef$1.f36767b = obj;
        return undispatchedContextCollector$emitRef$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((UndispatchedContextCollector$emitRef$1) create(t10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object obj2 = this.f36767b;
        Object objG = C4063a.g();
        int i10 = this.f36766a;
        if (i10 == 0) {
            C4849c.b(obj);
            c<T> cVar = this.f36768c;
            this.f36767b = h.a(obj2);
            this.f36766a = 1;
            if (cVar.emit(obj2, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
        return invoke2((UndispatchedContextCollector$emitRef$1<T>) obj, interfaceC4014c);
    }
}
