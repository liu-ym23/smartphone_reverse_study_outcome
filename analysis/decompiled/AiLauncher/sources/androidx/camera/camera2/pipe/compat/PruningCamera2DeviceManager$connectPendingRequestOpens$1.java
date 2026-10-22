package androidx.camera.camera2.pipe.compat;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.PruningCamera2DeviceManager", f = "Camera2DeviceManager.kt", l = {606}, m = "connectPendingRequestOpens", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PruningCamera2DeviceManager$connectPendingRequestOpens$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f10532a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10533b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f10534c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PruningCamera2DeviceManager f10535d;

    /* renamed from: e, reason: collision with root package name */
    public int f10536e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PruningCamera2DeviceManager$connectPendingRequestOpens$1(PruningCamera2DeviceManager pruningCamera2DeviceManager, InterfaceC4014c<? super PruningCamera2DeviceManager$connectPendingRequestOpens$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10535d = pruningCamera2DeviceManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10534c = obj;
        this.f10536e |= Integer.MIN_VALUE;
        return this.f10535d.o(null, this);
    }
}
