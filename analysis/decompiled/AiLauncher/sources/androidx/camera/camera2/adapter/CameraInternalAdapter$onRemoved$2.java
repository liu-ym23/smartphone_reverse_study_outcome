package androidx.camera.camera2.adapter;

import Ua.M;
import Y8.t;
import androidx.camera.camera2.impl.g;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.adapter.CameraInternalAdapter$onRemoved$2", f = "CameraInternalAdapter.kt", l = {161}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CameraInternalAdapter$onRemoved$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9316a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraInternalAdapter f9317b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraInternalAdapter$onRemoved$2(CameraInternalAdapter cameraInternalAdapter, InterfaceC4014c<? super CameraInternalAdapter$onRemoved$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9317b = cameraInternalAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CameraInternalAdapter$onRemoved$2(this.f9317b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((CameraInternalAdapter$onRemoved$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9316a;
        if (i10 == 0) {
            C4849c.b(obj);
            this.f9317b.cameraStateAdapter.i();
            g gVar = this.f9317b.useCaseManager;
            this.f9316a = 1;
            if (gVar.k(this) == objG) {
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
