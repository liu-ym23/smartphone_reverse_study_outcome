package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.FlashControl", f = "FlashControl.kt", l = {260}, m = "stopScreenFlashCaptureTasks", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlashControl$stopScreenFlashCaptureTasks$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9790a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlashControl f9791b;

    /* renamed from: c, reason: collision with root package name */
    public int f9792c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashControl$stopScreenFlashCaptureTasks$1(FlashControl flashControl, InterfaceC4014c<? super FlashControl$stopScreenFlashCaptureTasks$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9791b = flashControl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9790a = obj;
        this.f9792c |= Integer.MIN_VALUE;
        return this.f9791b.v(this);
    }
}
