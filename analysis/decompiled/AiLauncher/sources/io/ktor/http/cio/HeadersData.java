package io.ktor.http.cio;

import Y8.t;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import p9.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0003R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/http/cio/HeadersData;", "", "<init>", "()V", "", "arraysCount", "()I", "subArraysCount", "LY8/t;", "prepare", "(I)V", "index", "at", "(I)I", UxipConstants.f30680s, "set", "(II)V", "LKa/j;", "headersStarts", "()LKa/j;", "release", "", "", "arrays", "Ljava/util/List;", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class HeadersData {
    private List<int[]> arrays = new ArrayList();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LKa/l;", "", "LY8/t;", "<anonymous>", "(LKa/l;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.http.cio.HeadersData$headersStarts$1", f = "HttpHeadersMap.kt", l = {264}, m = "invokeSuspend")
    /* renamed from: io.ktor.http.cio.HeadersData$headersStarts$1, reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements p<Ka.l<? super Integer>, InterfaceC4014c<? super t>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = HeadersData.this.new AnonymousClass1(interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(Ka.l<? super Integer> lVar, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(lVar, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003c -> B:12:0x0045). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004f -> B:21:0x006a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0068 -> B:20:0x0069). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r0 = r9.L$0
                Ka.l r0 = (Ka.l) r0
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r9.label
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L28
                if (r2 != r4) goto L20
                int r2 = r9.I$1
                int r5 = r9.I$0
                java.lang.Object r6 = r9.L$2
                int[] r6 = (int[]) r6
                java.lang.Object r7 = r9.L$1
                java.util.Iterator r7 = (java.util.Iterator) r7
                kotlin.C4849c.b(r10)
                goto L69
            L20:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L28:
                kotlin.C4849c.b(r10)
                io.ktor.http.cio.HeadersData r10 = io.ktor.http.cio.HeadersData.this
                java.util.List r10 = io.ktor.http.cio.HeadersData.access$getArrays$p(r10)
                java.util.Iterator r10 = r10.iterator()
                r2 = r3
            L36:
                boolean r5 = r10.hasNext()
                if (r5 == 0) goto L71
                java.lang.Object r5 = r10.next()
                int[] r5 = (int[]) r5
                r6 = r5
                r5 = r2
                r2 = r3
            L45:
                int r7 = r6.length
                if (r2 >= r7) goto L6f
                io.ktor.http.cio.HeadersData r7 = io.ktor.http.cio.HeadersData.this
                int r7 = r7.at(r5)
                r8 = -1
                if (r7 == r8) goto L6a
                java.lang.Integer r7 = g9.C4109a.f(r5)
                r9.L$0 = r0
                r9.L$1 = r10
                r9.L$2 = r6
                r9.I$0 = r5
                r9.I$1 = r2
                r9.label = r4
                java.lang.Object r7 = r0.a(r7, r9)
                if (r7 != r1) goto L68
                return r1
            L68:
                r7 = r10
            L69:
                r10 = r7
            L6a:
                int r2 = r2 + 6
                int r5 = r5 + 6
                goto L45
            L6f:
                r2 = r5
                goto L36
            L71:
                Y8.t r9 = Y8.t.f7040a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HeadersData.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final int arraysCount() {
        return this.arrays.size();
    }

    public final int at(int index) {
        return this.arrays.get(index / 768)[index % 768];
    }

    public final Ka.j<Integer> headersStarts() {
        return Ka.m.b(new AnonymousClass1(null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void prepare(int subArraysCount) {
        for (int i10 = 0; i10 < subArraysCount; i10++) {
            this.arrays.add(HttpHeadersMapKt.IntArrayPool.borrow());
        }
    }

    public final void release() {
        Iterator<int[]> it = this.arrays.iterator();
        while (it.hasNext()) {
            HttpHeadersMapKt.IntArrayPool.recycle(it.next());
        }
        this.arrays.clear();
    }

    public final void set(int index, int value) {
        this.arrays.get(index / 768)[index % 768] = value;
    }
}
