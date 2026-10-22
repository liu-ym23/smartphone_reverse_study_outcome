package androidx.room.coroutines;

import Ua.C1056g;
import Ua.C1073o0;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.M;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineStart;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1", f = "RunBlockingUninterruptible.android.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1<T> extends SuspendLambda implements p<M, InterfaceC4014c<? super T>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f14784a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f14785b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p<M, InterfaceC4014c<? super T>, Object> f14786c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1", f = "RunBlockingUninterruptible.android.kt", l = {52}, m = "invokeSuspend")
    /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f14787a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f14788b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1083u<T> f14789c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p<M, InterfaceC4014c<? super T>, Object> f14790d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC1083u<T> interfaceC1083u, p<? super M, ? super InterfaceC4014c<? super T>, ? extends Object> pVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f14789c = interfaceC1083u;
            this.f14790d = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f14789c, this.f14790d, interfaceC4014c);
            anonymousClass1.f14788b = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC1083u<T> interfaceC1083u;
            Object objB;
            Object objG = C4063a.g();
            int i10 = this.f14787a;
            if (i10 == 0) {
                C4849c.b(obj);
                M m10 = (M) this.f14788b;
                InterfaceC1083u<T> interfaceC1083u2 = this.f14789c;
                p<M, InterfaceC4014c<? super T>, Object> pVar = this.f14790d;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    this.f14788b = interfaceC1083u2;
                    this.f14787a = 1;
                    obj = pVar.invoke(m10, this);
                    if (obj == objG) {
                        return objG;
                    }
                    interfaceC1083u = interfaceC1083u2;
                } catch (Throwable th) {
                    th = th;
                    interfaceC1083u = interfaceC1083u2;
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                    C1087w.d(interfaceC1083u, objB);
                    return t.f7040a;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC1083u = (InterfaceC1083u) this.f14788b;
                try {
                    C4849c.b(obj);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion22 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                    C1087w.d(interfaceC1083u, objB);
                    return t.f7040a;
                }
            }
            objB = Result.b(obj);
            C1087w.d(interfaceC1083u, objB);
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2", f = "RunBlockingUninterruptible.android.kt", l = {58}, m = "invokeSuspend")
    /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super T>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f14791a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1083u<T> f14792b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC1083u<T> interfaceC1083u, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f14792b = interfaceC1083u;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.f14792b, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super T> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f14791a;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            InterfaceC1083u<T> interfaceC1083u = this.f14792b;
            this.f14791a = 1;
            Object objA1 = interfaceC1083u.a1(this);
            return objA1 == objG ? objG : objA1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(p<? super M, ? super InterfaceC4014c<? super T>, ? extends Object> pVar, InterfaceC4014c<? super RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f14786c = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1 runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1 = new RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(this.f14786c, interfaceC4014c);
        runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1.f14785b = obj;
        return runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super T> interfaceC4014c) {
        return ((RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f14784a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        d.b bVar = ((M) this.f14785b).getCoroutineContext().get(c.INSTANCE);
        kotlin.jvm.internal.p.f(bVar);
        c cVar = (c) bVar;
        InterfaceC1083u interfaceC1083uC = C1087w.c(null, 1, null);
        C1056g.c(C1073o0.f6391a, cVar, CoroutineStart.UNDISPATCHED, new AnonymousClass1(interfaceC1083uC, this.f14786c, null));
        while (!interfaceC1083uC.g()) {
            try {
                return C1056g.e(cVar, new AnonymousClass2(interfaceC1083uC, null));
            } catch (InterruptedException unused) {
            }
        }
        return interfaceC1083uC.m();
    }
}
