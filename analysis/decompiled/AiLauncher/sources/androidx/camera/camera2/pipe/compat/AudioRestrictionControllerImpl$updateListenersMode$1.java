package androidx.camera.camera2.pipe.compat;

import Ua.M;
import androidx.camera.camera2.pipe.compat.j;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Iterator;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.AudioRestrictionControllerImpl$updateListenersMode$1", f = "AudioRestrictionController.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class AudioRestrictionControllerImpl$updateListenersMode$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10222a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudioRestrictionControllerImpl f10223b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ androidx.camera.camera2.pipe.a f10224c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRestrictionControllerImpl$updateListenersMode$1(AudioRestrictionControllerImpl audioRestrictionControllerImpl, androidx.camera.camera2.pipe.a aVar, InterfaceC4014c<? super AudioRestrictionControllerImpl$updateListenersMode$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10223b = audioRestrictionControllerImpl;
        this.f10224c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AudioRestrictionControllerImpl$updateListenersMode$1(this.f10223b, this.f10224c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AudioRestrictionControllerImpl$updateListenersMode$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f10222a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        Iterator it = this.f10223b.activeListeners.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            ((j.a) it.next()).a(this.f10224c.getValue());
        }
        return Y8.t.f7040a;
    }
}
