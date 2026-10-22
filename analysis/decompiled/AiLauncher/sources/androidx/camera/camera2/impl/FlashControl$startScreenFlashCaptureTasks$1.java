package androidx.camera.camera2.impl;

import com.stepos.ailauncher.chat.wake.circle.F;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.FlashControl", f = "FlashControl.kt", l = {149, F.LOOP_END_FRAME}, m = "startScreenFlashCaptureTasks", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlashControl$startScreenFlashCaptureTasks$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f9785a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9786b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f9787c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FlashControl f9788d;

    /* renamed from: e, reason: collision with root package name */
    public int f9789e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashControl$startScreenFlashCaptureTasks$1(FlashControl flashControl, InterfaceC4014c<? super FlashControl$startScreenFlashCaptureTasks$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9788d = flashControl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9787c = obj;
        this.f9789e |= Integer.MIN_VALUE;
        return this.f9788d.t(this);
    }
}
