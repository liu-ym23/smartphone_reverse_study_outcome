package androidx.camera.camera2.pipe.graph;

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
import p9.p;
import z.z;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lz/z;", "it", "LUa/Q;", "<anonymous>", "(Lz/z;)LUa/Q;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.graph.CameraGraphImpl$withSessionLockAsync$1", f = "CameraGraphImpl.kt", l = {344}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CameraGraphImpl$withSessionLockAsync$1<T> extends SuspendLambda implements p<z, InterfaceC4014c<? super Q<? extends T>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10805a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p<M, InterfaceC4014c<? super Q<? extends T>>, Object> f10806b;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "LUa/Q;", "<anonymous>", "(LUa/M;)LUa/Q;"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.camera.camera2.pipe.graph.CameraGraphImpl$withSessionLockAsync$1$1", f = "CameraGraphImpl.kt", l = {344}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.camera.camera2.pipe.graph.CameraGraphImpl$withSessionLockAsync$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Q<? extends T>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f10807a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f10808b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ p<M, InterfaceC4014c<? super Q<? extends T>>, Object> f10809c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(p<? super M, ? super InterfaceC4014c<? super Q<? extends T>>, ? extends Object> pVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f10809c = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f10809c, interfaceC4014c);
            anonymousClass1.f10808b = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Q<? extends T>> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f10807a;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            M m10 = (M) this.f10808b;
            p<M, InterfaceC4014c<? super Q<? extends T>>, Object> pVar = this.f10809c;
            this.f10807a = 1;
            Object objInvoke = pVar.invoke(m10, this);
            return objInvoke == objG ? objG : objInvoke;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CameraGraphImpl$withSessionLockAsync$1(p<? super M, ? super InterfaceC4014c<? super Q<? extends T>>, ? extends Object> pVar, InterfaceC4014c<? super CameraGraphImpl$withSessionLockAsync$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10806b = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CameraGraphImpl$withSessionLockAsync$1(this.f10806b, interfaceC4014c);
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(z zVar, InterfaceC4014c<? super Q<? extends T>> interfaceC4014c) {
        return ((CameraGraphImpl$withSessionLockAsync$1) create(zVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10805a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f10806b, null);
        this.f10805a = 1;
        Object objF = kotlinx.coroutines.d.f(anonymousClass1, this);
        return objF == objG ? objG : objF;
    }
}
