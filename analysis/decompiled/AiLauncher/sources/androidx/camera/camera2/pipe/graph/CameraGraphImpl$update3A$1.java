package androidx.camera.camera2.pipe.graph;

import Ua.M;
import Ua.Q;
import Y8.t;
import android.hardware.camera2.params.MeteringRectangle;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import w.C5695a;
import w.C5696b;
import w.C5697c;
import w.Result3A;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "LUa/Q;", "Lw/N;", "<anonymous>", "(LUa/M;)LUa/Q;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.graph.CameraGraphImpl$update3A$1", f = "CameraGraphImpl.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CameraGraphImpl$update3A$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Q<? extends Result3A>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10797a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraGraphImpl f10798b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C5695a f10799c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C5696b f10800d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C5697c f10801e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List<MeteringRectangle> f10802f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ List<MeteringRectangle> f10803g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ List<MeteringRectangle> f10804h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraGraphImpl$update3A$1(CameraGraphImpl cameraGraphImpl, C5695a c5695a, C5696b c5696b, C5697c c5697c, List<MeteringRectangle> list, List<MeteringRectangle> list2, List<MeteringRectangle> list3, InterfaceC4014c<? super CameraGraphImpl$update3A$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10798b = cameraGraphImpl;
        this.f10799c = c5695a;
        this.f10800d = c5696b;
        this.f10801e = c5697c;
        this.f10802f = list;
        this.f10803g = list2;
        this.f10804h = list3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CameraGraphImpl$update3A$1(this.f10798b, this.f10799c, this.f10800d, this.f10801e, this.f10802f, this.f10803g, this.f10804h, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super Q<Result3A>> interfaceC4014c) {
        return ((CameraGraphImpl$update3A$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f10797a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return Controller3A.s(this.f10798b.controller3A, this.f10799c, this.f10800d, this.f10801e, null, this.f10802f, this.f10803g, this.f10804h, 8, null);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Q<? extends Result3A>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Q<Result3A>>) interfaceC4014c);
    }
}
