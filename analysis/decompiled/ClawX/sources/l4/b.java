package l4;

import b5.a0;
import java.util.Iterator;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends h5.h implements p {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f3797a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f3798b;

    /* renamed from: c, reason: collision with root package name */
    public int f3799c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f3800e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3801f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c f3802g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, f5.c cVar2) {
        super(2, cVar2);
        this.f3802g = cVar;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        b bVar = new b(this.f3802g, cVar);
        bVar.f3801f = obj;
        return bVar;
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        return ((b) create((w5.j) obj, (f5.c) obj2)).invokeSuspend(a0.f883a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0039 -> B:12:0x0043). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0068 -> B:19:0x006c). Please report as a decompilation issue!!! */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            g5.a r0 = g5.a.f2984a
            int r1 = r11.f3800e
            l4.c r2 = r11.f3802g
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 != r4) goto L1d
            int r1 = r11.d
            int r5 = r11.f3799c
            int[] r6 = r11.f3798b
            java.util.Iterator r7 = r11.f3797a
            java.lang.Object r8 = r11.f3801f
            w5.j r8 = (w5.j) r8
            a.a.c0(r12)
            r12 = r8
            goto L6c
        L1d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L25:
            a.a.c0(r12)
            java.lang.Object r12 = r11.f3801f
            w5.j r12 = (w5.j) r12
            java.util.ArrayList r1 = r2.f3803a
            java.util.Iterator r1 = r1.iterator()
            r5 = r3
        L33:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L78
            java.lang.Object r6 = r1.next()
            int[] r6 = (int[]) r6
            r7 = r6
            r6 = r5
            r5 = r1
            r1 = r3
        L43:
            int r8 = r7.length
            if (r1 >= r8) goto L75
            int r8 = r2.a(r6)
            r9 = -1
            if (r8 == r9) goto L68
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r6)
            r11.f3801f = r12
            r11.f3797a = r5
            r11.f3798b = r7
            r11.f3799c = r6
            r11.d = r1
            r11.f3800e = r4
            r12.f6219b = r2
            r1 = 3
            r12.f6218a = r1
            r12.f6220c = r11
            g5.a r11 = g5.a.f2984a
            return r0
        L68:
            r10 = r7
            r7 = r5
            r5 = r6
            r6 = r10
        L6c:
            int r1 = r1 + 6
            int r5 = r5 + 6
            r10 = r6
            r6 = r5
            r5 = r7
            r7 = r10
            goto L43
        L75:
            r1 = r5
            r5 = r6
            goto L33
        L78:
            b5.a0 r11 = b5.a0.f883a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.b.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
