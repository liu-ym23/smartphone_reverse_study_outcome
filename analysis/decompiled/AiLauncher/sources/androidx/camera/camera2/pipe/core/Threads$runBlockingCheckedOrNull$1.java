package androidx.camera.camera2.pipe.core;

import Ua.M;
import Ua.Q;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.TimeoutKt;
import p9.InterfaceC5074l;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.core.Threads$runBlockingCheckedOrNull$1", f = "Threads.kt", l = {85}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class Threads$runBlockingCheckedOrNull$1<T> extends SuspendLambda implements p<M, InterfaceC4014c<? super T>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10747a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Threads f10748b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC5074l<InterfaceC4014c<? super T>, Object> f10749c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f10750d;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.camera.camera2.pipe.core.Threads$runBlockingCheckedOrNull$1$1", f = "Threads.kt", l = {85}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.camera.camera2.pipe.core.Threads$runBlockingCheckedOrNull$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super T>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f10751a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Q<T> f10752b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Q<? extends T> q10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f10752b = q10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.f10752b, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super T> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f10751a;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            Q<T> q10 = this.f10752b;
            this.f10751a = 1;
            Object objA1 = q10.a1(this);
            return objA1 == objG ? objG : objA1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Threads$runBlockingCheckedOrNull$1(Threads threads, InterfaceC5074l<? super InterfaceC4014c<? super T>, ? extends Object> interfaceC5074l, long j10, InterfaceC4014c<? super Threads$runBlockingCheckedOrNull$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10748b = threads;
        this.f10749c = interfaceC5074l;
        this.f10750d = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new Threads$runBlockingCheckedOrNull$1(this.f10748b, this.f10749c, this.f10750d, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super T> interfaceC4014c) {
        return ((Threads$runBlockingCheckedOrNull$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10747a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        Threads threads = this.f10748b;
        Q qM = threads.m(threads.getBackgroundDispatcher(), this.f10749c);
        long j10 = this.f10750d;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(qM, null);
        this.f10747a = 1;
        Object objE = TimeoutKt.e(j10, anonymousClass1, this);
        return objE == objG ? objG : objE;
    }
}
