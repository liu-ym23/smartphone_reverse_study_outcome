package kotlinx.coroutines.flow;

import Xa.c;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartedLazily$command$1$1<T> implements c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref$BooleanRef f36639a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c<SharingCommand> f36640b;

    /* JADX WARN: Multi-variable type inference failed */
    public StartedLazily$command$1$1(Ref$BooleanRef ref$BooleanRef, c<? super SharingCommand> cVar) {
        this.f36639a = ref$BooleanRef;
        this.f36640b = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(int r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1 r0 = (kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1) r0
            int r1 = r0.f36644d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36644d = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1 r0 = new kotlinx.coroutines.flow.StartedLazily$command$1$1$emit$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f36642b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f36644d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r6)
            goto L4d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r6)
            if (r5 <= 0) goto L50
            kotlin.jvm.internal.Ref$BooleanRef r6 = r4.f36639a
            boolean r2 = r6.f34815a
            if (r2 != 0) goto L50
            r6.f34815a = r3
            Xa.c<kotlinx.coroutines.flow.SharingCommand> r4 = r4.f36640b
            kotlinx.coroutines.flow.SharingCommand r6 = kotlinx.coroutines.flow.SharingCommand.START
            r0.f36641a = r5
            r0.f36644d = r3
            java.lang.Object r4 = r4.emit(r6, r0)
            if (r4 != r1) goto L4d
            return r1
        L4d:
            Y8.t r4 = Y8.t.f7040a
            return r4
        L50:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedLazily$command$1$1.b(int, e9.c):java.lang.Object");
    }

    @Override // Xa.c
    public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
        return b(((Number) obj).intValue(), interfaceC4014c);
    }
}
