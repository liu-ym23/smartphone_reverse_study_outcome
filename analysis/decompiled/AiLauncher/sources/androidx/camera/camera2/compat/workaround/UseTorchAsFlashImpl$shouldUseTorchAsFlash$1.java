package androidx.camera.camera2.compat.workaround;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.compat.workaround.UseTorchAsFlashImpl", f = "UseTorchAsFlash.kt", l = {113}, m = "shouldUseTorchAsFlash", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UseTorchAsFlashImpl$shouldUseTorchAsFlash$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9526a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UseTorchAsFlashImpl f9527b;

    /* renamed from: c, reason: collision with root package name */
    public int f9528c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseTorchAsFlashImpl$shouldUseTorchAsFlash$1(UseTorchAsFlashImpl useTorchAsFlashImpl, InterfaceC4014c<? super UseTorchAsFlashImpl$shouldUseTorchAsFlash$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9527b = useTorchAsFlashImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9526a = obj;
        this.f9528c |= Integer.MIN_VALUE;
        return this.f9527b.b(null, this);
    }
}
