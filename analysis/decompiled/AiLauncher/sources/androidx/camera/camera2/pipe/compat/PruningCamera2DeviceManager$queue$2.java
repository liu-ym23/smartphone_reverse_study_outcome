package androidx.camera.camera2.pipe.compat;

import com.stepos.ailauncher.chat.wake.circle.F;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import x.AbstractC5822j0;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lx/j0;", "it", "LY8/t;", "<anonymous>", "(Lx/j0;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager$queue$2", f = "Camera2DeviceManager.kt", l = {F.GESTURE_WIDTH_DP}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class PruningCamera2DeviceManager$queue$2 extends SuspendLambda implements p9.p<AbstractC5822j0, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10563a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10564b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PruningCamera2DeviceManager f10565c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PruningCamera2DeviceManager$queue$2(PruningCamera2DeviceManager pruningCamera2DeviceManager, InterfaceC4014c<? super PruningCamera2DeviceManager$queue$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10565c = pruningCamera2DeviceManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        PruningCamera2DeviceManager$queue$2 pruningCamera2DeviceManager$queue$2 = new PruningCamera2DeviceManager$queue$2(this.f10565c, interfaceC4014c);
        pruningCamera2DeviceManager$queue$2.f10564b = obj;
        return pruningCamera2DeviceManager$queue$2;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AbstractC5822j0 abstractC5822j0, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((PruningCamera2DeviceManager$queue$2) create(abstractC5822j0, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10563a;
        if (i10 == 0) {
            C4849c.b(obj);
            AbstractC5822j0 abstractC5822j0 = (AbstractC5822j0) this.f10564b;
            PruningCamera2DeviceManager pruningCamera2DeviceManager = this.f10565c;
            this.f10563a = 1;
            if (pruningCamera2DeviceManager.t(abstractC5822j0, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
