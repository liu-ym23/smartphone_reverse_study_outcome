package kotlinx.coroutines.flow;

import Xa.c;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.q;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"LXa/c;", "Lkotlinx/coroutines/flow/SharingCommand;", "", "count", "LY8/t;", "<anonymous>", "(LXa/c;I)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", l = {175, 177, 179, 180, 182}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class StartedWhileSubscribed$command$1 extends SuspendLambda implements q<c<? super SharingCommand>, Integer, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f36647a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f36648b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f36649c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ StartedWhileSubscribed f36650d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, InterfaceC4014c<? super StartedWhileSubscribed$command$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.f36650d = startedWhileSubscribed;
    }

    public final Object f(c<? super SharingCommand> cVar, int i10, InterfaceC4014c<? super t> interfaceC4014c) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.f36650d, interfaceC4014c);
        startedWhileSubscribed$command$1.f36648b = cVar;
        startedWhileSubscribed$command$1.f36649c = i10;
        return startedWhileSubscribed$command$1.invokeSuspend(t.f7040a);
    }

    @Override // p9.q
    public /* bridge */ /* synthetic */ Object invoke(c<? super SharingCommand> cVar, Integer num, InterfaceC4014c<? super t> interfaceC4014c) {
        return f(cVar, num.intValue(), interfaceC4014c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        if (r0.emit(r12, r11) == r2) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009f, code lost:
    
        if (r0.emit(r12, r11) != r2) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f36648b
            Xa.c r0 = (Xa.c) r0
            int r1 = r11.f36649c
            java.lang.Object r2 = f9.C4063a.g()
            int r3 = r11.f36647a
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            if (r3 == 0) goto L36
            if (r3 == r8) goto L32
            if (r3 == r7) goto L2e
            if (r3 == r6) goto L2a
            if (r3 == r5) goto L26
            if (r3 != r4) goto L1e
            goto L32
        L1e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L26:
            kotlin.C4849c.b(r12)
            goto L8f
        L2a:
            kotlin.C4849c.b(r12)
            goto L7c
        L2e:
            kotlin.C4849c.b(r12)
            goto L61
        L32:
            kotlin.C4849c.b(r12)
            goto La2
        L36:
            kotlin.C4849c.b(r12)
            if (r1 <= 0) goto L4e
            kotlinx.coroutines.flow.SharingCommand r12 = kotlinx.coroutines.flow.SharingCommand.START
            java.lang.Object r3 = g9.h.a(r0)
            r11.f36648b = r3
            r11.f36649c = r1
            r11.f36647a = r8
            java.lang.Object r11 = r0.emit(r12, r11)
            if (r11 != r2) goto La2
            goto La1
        L4e:
            kotlinx.coroutines.flow.StartedWhileSubscribed r12 = r11.f36650d
            long r8 = kotlinx.coroutines.flow.StartedWhileSubscribed.c(r12)
            r11.f36648b = r0
            r11.f36649c = r1
            r11.f36647a = r7
            java.lang.Object r12 = Ua.U.a(r8, r11)
            if (r12 != r2) goto L61
            goto La1
        L61:
            kotlinx.coroutines.flow.StartedWhileSubscribed r12 = r11.f36650d
            long r7 = kotlinx.coroutines.flow.StartedWhileSubscribed.b(r12)
            r9 = 0
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 <= 0) goto L8f
            kotlinx.coroutines.flow.SharingCommand r12 = kotlinx.coroutines.flow.SharingCommand.STOP
            r11.f36648b = r0
            r11.f36649c = r1
            r11.f36647a = r6
            java.lang.Object r12 = r0.emit(r12, r11)
            if (r12 != r2) goto L7c
            goto La1
        L7c:
            kotlinx.coroutines.flow.StartedWhileSubscribed r12 = r11.f36650d
            long r6 = kotlinx.coroutines.flow.StartedWhileSubscribed.b(r12)
            r11.f36648b = r0
            r11.f36649c = r1
            r11.f36647a = r5
            java.lang.Object r12 = Ua.U.a(r6, r11)
            if (r12 != r2) goto L8f
            goto La1
        L8f:
            kotlinx.coroutines.flow.SharingCommand r12 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
            java.lang.Object r3 = g9.h.a(r0)
            r11.f36648b = r3
            r11.f36649c = r1
            r11.f36647a = r4
            java.lang.Object r11 = r0.emit(r12, r11)
            if (r11 != r2) goto La2
        La1:
            return r2
        La2:
            Y8.t r11 = Y8.t.f7040a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
