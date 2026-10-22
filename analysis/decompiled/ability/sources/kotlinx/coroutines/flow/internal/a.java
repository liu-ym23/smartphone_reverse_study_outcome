package kotlinx.coroutines.flow.internal;

import C7.r;
import D7.v;
import Z6.k;
import java.util.ArrayList;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import o9.C1785k;
import o9.InterfaceC1786l;
import o9.n;

/* loaded from: classes4.dex */
public abstract class a implements q9.g {

    /* renamed from: a, reason: collision with root package name */
    public final H7.h f5244a;
    public final int b;
    public final BufferOverflow c;

    public a(H7.h hVar, int i, BufferOverflow bufferOverflow) {
        this.f5244a = hVar;
        this.b = i;
        this.c = bufferOverflow;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    @Override // q9.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final p9.c c(H7.h r5, int r6, kotlinx.coroutines.channels.BufferOverflow r7) {
        /*
            r4 = this;
            H7.h r0 = r4.f5244a
            H7.h r5 = r5.plus(r0)
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.f5184a
            kotlinx.coroutines.channels.BufferOverflow r2 = r4.c
            int r3 = r4.b
            if (r7 == r1) goto Lf
            goto L26
        Lf:
            r7 = -3
            if (r3 != r7) goto L13
            goto L25
        L13:
            if (r6 != r7) goto L17
        L15:
            r6 = r3
            goto L25
        L17:
            r7 = -2
            if (r3 != r7) goto L1b
            goto L25
        L1b:
            if (r6 != r7) goto L1e
            goto L15
        L1e:
            int r6 = r6 + r3
            if (r6 < 0) goto L22
            goto L25
        L22:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L25:
            r7 = r2
        L26:
            boolean r0 = kotlin.jvm.internal.k.b(r5, r0)
            if (r0 == 0) goto L31
            if (r6 != r3) goto L31
            if (r7 != r2) goto L31
            return r4
        L31:
            kotlinx.coroutines.flow.internal.a r4 = r4.f(r5, r6, r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.a.c(H7.h, int, kotlinx.coroutines.channels.BufferOverflow):p9.c");
    }

    @Override // p9.c
    public Object collect(p9.d dVar, H7.c cVar) {
        Object objF = AbstractC1683A.f(new ChannelFlow$collect$2(dVar, this, null), cVar);
        return objF == CoroutineSingletons.f4909a ? objF : r.f317a;
    }

    public String d() {
        return null;
    }

    public abstract Object e(InterfaceC1786l interfaceC1786l, H7.c cVar);

    public abstract a f(H7.h hVar, int i, BufferOverflow bufferOverflow);

    public p9.c g() {
        return null;
    }

    public n h(InterfaceC1733z interfaceC1733z) {
        int i = this.b;
        if (i == -3) {
            i = -2;
        }
        CoroutineStart coroutineStart = CoroutineStart.c;
        S7.n channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this, null);
        C1785k c1785k = new C1785k(AbstractC1683A.o(interfaceC1733z, this.f5244a), k.b(i, 4, this.c));
        c1785k.i0(coroutineStart, c1785k, channelFlow$collectToFun$1);
        return c1785k;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strD = d();
        if (strD != null) {
            arrayList.add(strD);
        }
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f4908a;
        H7.h hVar = this.f5244a;
        if (hVar != emptyCoroutineContext) {
            arrayList.add("context=" + hVar);
        }
        int i = this.b;
        if (i != -3) {
            arrayList.add("capacity=" + i);
        }
        BufferOverflow bufferOverflow = BufferOverflow.f5184a;
        BufferOverflow bufferOverflow2 = this.c;
        if (bufferOverflow2 != bufferOverflow) {
            arrayList.add("onBufferOverflow=" + bufferOverflow2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return B7.a.g(']', v.I0(arrayList, ", ", null, null, null, 62), sb);
    }
}
