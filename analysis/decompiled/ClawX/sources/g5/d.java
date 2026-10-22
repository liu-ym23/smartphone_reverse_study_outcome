package g5;

import f5.h;
import kotlin.jvm.internal.d0;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public int f2991a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f2992b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f5.c f2993c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f5.c cVar, h hVar, p pVar, f5.c cVar2) {
        super(cVar, hVar);
        this.f2992b = pVar;
        this.f2993c = cVar2;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        int i8 = this.f2991a;
        if (i8 != 0) {
            if (i8 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f2991a = 2;
            a.a.c0(obj);
            return obj;
        }
        this.f2991a = 1;
        a.a.c0(obj);
        p pVar = this.f2992b;
        kotlin.jvm.internal.p.c(pVar, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
        d0.a(2, pVar);
        return pVar.invoke(this.f2993c, this);
    }
}
