package androidx.camera.camera2.pipe.core;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.d;
import p9.p;
import z.C6047e;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.core.MutexesKt$withLockLaunch$1", f = "Mutexes.kt", l = {177, 90}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class MutexesKt$withLockLaunch$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f10695a;

    /* renamed from: b, reason: collision with root package name */
    public int f10696b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f10697c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C6047e f10698d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p<M, InterfaceC4014c<? super t>, Object> f10699e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MutexesKt$withLockLaunch$1(C6047e c6047e, p<? super M, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super MutexesKt$withLockLaunch$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10698d = c6047e;
        this.f10699e = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        MutexesKt$withLockLaunch$1 mutexesKt$withLockLaunch$1 = new MutexesKt$withLockLaunch$1(this.f10698d, this.f10699e, interfaceC4014c);
        mutexesKt$withLockLaunch$1.f10697c = obj;
        return mutexesKt$withLockLaunch$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((MutexesKt$withLockLaunch$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        InterfaceC4021a mutex;
        p<M, InterfaceC4014c<? super t>, Object> pVar;
        Throwable th;
        InterfaceC4021a interfaceC4021a;
        Object objG = C4063a.g();
        int i10 = this.f10696b;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                d.g((M) this.f10697c);
                mutex = this.f10698d.getMutex();
                pVar = this.f10699e;
                this.f10697c = mutex;
                this.f10695a = pVar;
                this.f10696b = 1;
                if (MutexesKt.c(mutex, this) != objG) {
                }
                return objG;
            }
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC4021a = (InterfaceC4021a) this.f10697c;
                try {
                    C4849c.b(obj);
                    t tVar = t.f7040a;
                    InterfaceC4021a.i(interfaceC4021a, null, 1, null);
                    return t.f7040a;
                } catch (Throwable th2) {
                    th = th2;
                    InterfaceC4021a.i(interfaceC4021a, null, 1, null);
                    throw th;
                }
            }
            pVar = (p) this.f10695a;
            InterfaceC4021a interfaceC4021a2 = (InterfaceC4021a) this.f10697c;
            C4849c.b(obj);
            mutex = interfaceC4021a2;
            this.f10697c = mutex;
            this.f10695a = null;
            this.f10696b = 2;
            if (d.f(pVar, this) != objG) {
                interfaceC4021a = mutex;
                t tVar2 = t.f7040a;
                InterfaceC4021a.i(interfaceC4021a, null, 1, null);
                return t.f7040a;
            }
            return objG;
        } catch (Throwable th3) {
            InterfaceC4021a interfaceC4021a3 = mutex;
            th = th3;
            interfaceC4021a = interfaceC4021a3;
            InterfaceC4021a.i(interfaceC4021a, null, 1, null);
            throw th;
        }
    }
}
