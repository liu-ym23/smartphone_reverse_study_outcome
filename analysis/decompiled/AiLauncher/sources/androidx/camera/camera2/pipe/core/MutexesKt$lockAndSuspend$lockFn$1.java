package androidx.camera.camera2.pipe.core;

import Y8.t;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.p;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class MutexesKt$lockAndSuspend$lockFn$1 extends FunctionReferenceImpl implements p<InterfaceC4021a, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final MutexesKt$lockAndSuspend$lockFn$1 f10694a = new MutexesKt$lockAndSuspend$lockFn$1();

    public MutexesKt$lockAndSuspend$lockFn$1() {
        super(2, MutexesKt.class, "lockWithoutOwner", "lockWithoutOwner(Lkotlinx/coroutines/sync/Mutex;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
    }

    @Override // p9.p
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Object invoke(InterfaceC4021a interfaceC4021a, InterfaceC4014c<? super t> interfaceC4014c) {
        return MutexesKt.d(interfaceC4021a, interfaceC4014c);
    }
}
