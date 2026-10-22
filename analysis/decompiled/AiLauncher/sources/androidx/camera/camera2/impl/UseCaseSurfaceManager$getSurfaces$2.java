package androidx.camera.camera2.impl;

import Ua.M;
import Y8.t;
import Z8.C1174w;
import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.concurrent.futures.ListenableFutureKt;
import com.zyql.ai.selector.camera.CustomCameraView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g3.InterfaceFutureC4095a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0005\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"LUa/M;", "", "Landroid/view/Surface;", "kotlin.jvm.PlatformType", "", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseSurfaceManager$getSurfaces$2", f = "UseCaseSurfaceManager.kt", l = {CustomCameraView.BUTTON_STATE_ONLY_RECORDER}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class UseCaseSurfaceManager$getSurfaces$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<Surface>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10016a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<DeferrableSurface> f10017b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UseCaseSurfaceManager$getSurfaces$2(List<? extends DeferrableSurface> list, InterfaceC4014c<? super UseCaseSurfaceManager$getSurfaces$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10017b = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new UseCaseSurfaceManager$getSurfaces$2(this.f10017b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super List<Surface>> interfaceC4014c) {
        return ((UseCaseSurfaceManager$getSurfaces$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10016a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        List<DeferrableSurface> list = this.f10017b;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(O.f.i(((DeferrableSurface) it.next()).j()));
        }
        InterfaceFutureC4095a interfaceFutureC4095aM = O.f.m(arrayList);
        kotlin.jvm.internal.p.h(interfaceFutureC4095aM, "successfulAsList(...)");
        this.f10016a = 1;
        Object objB = ListenableFutureKt.b(interfaceFutureC4095aM, this);
        return objB == objG ? objG : objB;
    }
}
