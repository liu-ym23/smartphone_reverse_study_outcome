package Wa;

import ab.C1278a;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BG\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012(\u0010\f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00142\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"LWa/n;", ExifInterface.LONGITUDE_EAST, "LWa/a;", "Lkotlin/coroutines/d;", "parentContext", "LWa/g;", "channel", "Lkotlin/Function2;", "LWa/c;", "Le9/c;", "LY8/t;", "", "block", "<init>", "(Lkotlin/coroutines/d;LWa/g;Lp9/p;)V", "z0", "()V", "element", "send", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/a;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "e", "Le9/c;", "continuation", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class n<E> extends a<E> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public InterfaceC4014c<? super Y8.t> continuation;

    public n(kotlin.coroutines.d dVar, g<E> gVar, p9.p<? super c<E>, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar) {
        super(dVar, gVar, false);
        this.continuation = IntrinsicsKt__IntrinsicsJvmKt.b(pVar, this, this);
    }

    @Override // Wa.h, Wa.s
    public boolean close(Throwable cause) {
        boolean zClose = super.close(cause);
        start();
        return zClose;
    }

    @Override // Wa.h, Wa.s
    public Object send(E e10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        start();
        Object objSend = super.send(e10, interfaceC4014c);
        return objSend == C4063a.g() ? objSend : Y8.t.f7040a;
    }

    @Override // Wa.h, Wa.s
    /* renamed from: trySend-JP2dKIU */
    public Object mo0trySendJP2dKIU(E element) {
        start();
        return super.mo0trySendJP2dKIU(element);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void z0() throws Throwable {
        C1278a.b(this.continuation, this);
    }
}
