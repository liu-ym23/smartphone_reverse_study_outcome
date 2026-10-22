package androidx.camera.camera2.pipe.internal;

import Ua.C1086v0;
import Ua.M;
import Y8.t;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.g;
import p9.p;
import z.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.internal.CameraPipeLifetime$shutdownScope$1$2", f = "CameraPipeLifetime.kt", l = {119}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CameraPipeLifetime$shutdownScope$1$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10964a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraPipeLifetime f10965b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "androidx.camera.camera2.pipe.internal.CameraPipeLifetime$shutdownScope$1$2$1", f = "CameraPipeLifetime.kt", l = {121}, m = "invokeSuspend", v = 1)
    /* renamed from: androidx.camera.camera2.pipe.internal.CameraPipeLifetime$shutdownScope$1$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f10966a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CameraPipeLifetime f10967b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CameraPipeLifetime cameraPipeLifetime, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.f10967b = cameraPipeLifetime;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.f10967b, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.f10966a;
            if (i10 == 0) {
                C4849c.b(obj);
                if (k.f44508a.a()) {
                    Log.d("CXCP", "Cancelling CameraPipe root Job...");
                }
                g gVar = this.f10967b.cameraPipeJob;
                this.f10966a = 1;
                if (C1086v0.g(gVar, this) == objG) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraPipeLifetime$shutdownScope$1$2(CameraPipeLifetime cameraPipeLifetime, InterfaceC4014c<? super CameraPipeLifetime$shutdownScope$1$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10965b = cameraPipeLifetime;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CameraPipeLifetime$shutdownScope$1$2(this.f10965b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((CameraPipeLifetime$shutdownScope$1$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10964a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f10965b, null);
        this.f10964a = 1;
        Object objE = TimeoutKt.e(3000L, anonymousClass1, this);
        return objE == objG ? objG : objE;
    }
}
