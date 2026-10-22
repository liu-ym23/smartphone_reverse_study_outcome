package io.ktor.http.cio;

import Y8.t;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.ContentDisposition;
import io.ktor.http.cio.internals.CharArrayBuilder;
import io.ktor.http.cio.internals.CharsKt;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0015H\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b2\u0006\u0010\u0011\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ?\u0010&\u001a\u00020\r2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0007¢\u0006\u0004\b&\u0010'J-\u0010&\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t¢\u0006\u0004\b&\u0010(J\u0017\u0010)\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b+\u0010*J\u0015\u0010,\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b,\u0010*J\u0015\u0010-\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b-\u0010*J\r\u0010.\u001a\u00020\r¢\u0006\u0004\b.\u0010\u000fJ\u000f\u0010/\u001a\u00020\u0015H\u0016¢\u0006\u0004\b/\u00100R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R$\u00103\u001a\u00020\t2\u0006\u00102\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00104R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lio/ktor/http/cio/HttpHeadersMap;", "", "Lio/ktor/http/cio/internals/CharArrayBuilder;", "builder", "<init>", "(Lio/ktor/http/cio/internals/CharArrayBuilder;)V", "", "thresholdReached", "()Z", "", "idx", "idxToOffset", "(I)I", "LY8/t;", "resize", "()V", "", "name", "headerOffset", "headerHasName", "(Ljava/lang/CharSequence;I)Z", "", "fromIndex", "find", "(Ljava/lang/String;I)I", "get", "(Ljava/lang/String;)Ljava/lang/CharSequence;", "LKa/j;", "getAll", "(Ljava/lang/String;)LKa/j;", "offsets", "()LKa/j;", "nameHash", "valueHash", "nameStartIndex", "nameEndIndex", "valueStartIndex", "valueEndIndex", "put", "(IIIIII)V", "(IIII)V", "nameAt", "(I)Ljava/lang/CharSequence;", "valueAt", "nameAtOffset", "valueAtOffset", "release", "toString", "()Ljava/lang/String;", "Lio/ktor/http/cio/internals/CharArrayBuilder;", UxipConstants.f30680s, ContentDisposition.Parameters.Size, "I", "getSize", "()I", "headerCapacity", "Lio/ktor/http/cio/HeadersData;", "headersData", "Lio/ktor/http/cio/HeadersData;", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpHeadersMap {
    private final CharArrayBuilder builder;
    private int headerCapacity;
    private HeadersData headersData;
    private int size;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LKa/l;", "", "LY8/t;", "<anonymous>", "(LKa/l;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.http.cio.HttpHeadersMap$getAll$1", f = "HttpHeadersMap.kt", l = {90}, m = "invokeSuspend")
    /* renamed from: io.ktor.http.cio.HttpHeadersMap$getAll$1, reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements p<Ka.l<? super CharSequence>, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ String $name;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$name = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = HttpHeadersMap.this.new AnonymousClass1(this.$name, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(Ka.l<? super CharSequence> lVar, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(lVar, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        
            r9 = r8.this$0.valueAtOffset(r6);
            r8.L$0 = r0;
            r8.I$0 = r5;
            r8.I$1 = r2;
            r8.label = 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x006e, code lost:
        
            if (r0.a(r9, r8) != r1) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
        
            return r1;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x008c A[EDGE_INSN: B:27:0x008c->B:24:0x008c BREAK  A[LOOP:0: B:13:0x0044->B:23:0x0082], SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x006e -> B:20:0x0071). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.Object r0 = r8.L$0
                Ka.l r0 = (Ka.l) r0
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r8.label
                r3 = -1
                r4 = 1
                if (r2 == 0) goto L20
                if (r2 != r4) goto L18
                int r2 = r8.I$1
                int r5 = r8.I$0
                kotlin.C4849c.b(r9)
                goto L71
            L18:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L20:
                kotlin.C4849c.b(r9)
                io.ktor.http.cio.HttpHeadersMap r9 = io.ktor.http.cio.HttpHeadersMap.this
                int r9 = r9.getSize()
                if (r9 != 0) goto L2e
                Y8.t r8 = Y8.t.f7040a
                return r8
            L2e:
                java.lang.String r9 = r8.$name
                r2 = 3
                r5 = 0
                r6 = 0
                int r9 = io.ktor.http.cio.internals.CharsKt.hashCodeLowerCase$default(r9, r6, r6, r2, r5)
                int r9 = java.lang.Math.abs(r9)
                io.ktor.http.cio.HttpHeadersMap r2 = io.ktor.http.cio.HttpHeadersMap.this
                int r2 = io.ktor.http.cio.HttpHeadersMap.access$getHeaderCapacity$p(r2)
                int r2 = r9 % r2
                r5 = r9
            L44:
                io.ktor.http.cio.HttpHeadersMap r9 = io.ktor.http.cio.HttpHeadersMap.this
                io.ktor.http.cio.HeadersData r9 = io.ktor.http.cio.HttpHeadersMap.access$getHeadersData$p(r9)
                int r6 = r2 * 6
                int r9 = r9.at(r6)
                if (r9 == r3) goto L8c
                io.ktor.http.cio.HttpHeadersMap r9 = io.ktor.http.cio.HttpHeadersMap.this
                java.lang.String r7 = r8.$name
                boolean r9 = io.ktor.http.cio.HttpHeadersMap.access$headerHasName(r9, r7, r6)
                if (r9 == 0) goto L82
                io.ktor.http.cio.HttpHeadersMap r9 = io.ktor.http.cio.HttpHeadersMap.this
                java.lang.CharSequence r9 = r9.valueAtOffset(r6)
                r8.L$0 = r0
                r8.I$0 = r5
                r8.I$1 = r2
                r8.label = r4
                java.lang.Object r9 = r0.a(r9, r8)
                if (r9 != r1) goto L71
                return r1
            L71:
                io.ktor.http.cio.HttpHeadersMap r9 = io.ktor.http.cio.HttpHeadersMap.this
                io.ktor.http.cio.HeadersData r9 = io.ktor.http.cio.HttpHeadersMap.access$getHeadersData$p(r9)
                int r2 = r2 * 6
                int r2 = r2 + 5
                int r2 = r9.at(r2)
                if (r2 == r3) goto L8c
                goto L44
            L82:
                int r2 = r2 + 1
                io.ktor.http.cio.HttpHeadersMap r9 = io.ktor.http.cio.HttpHeadersMap.this
                int r9 = io.ktor.http.cio.HttpHeadersMap.access$getHeaderCapacity$p(r9)
                int r2 = r2 % r9
                goto L44
            L8c:
                Y8.t r8 = Y8.t.f7040a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpHeadersMap.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public HttpHeadersMap(CharArrayBuilder builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        this.builder = builder;
        this.headersData = (HeadersData) HttpHeadersMapKt.HeadersDataPool.borrow();
    }

    public static /* synthetic */ int find$default(HttpHeadersMap httpHeadersMap, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return httpHeadersMap.find(str, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean headerHasName(CharSequence name, int headerOffset) {
        return CharsKt.equalsLowerCase(this.builder, this.headersData.at(headerOffset + 1), this.headersData.at(headerOffset + 2), name);
    }

    private final int idxToOffset(int idx) {
        if (idx < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (idx < this.size) {
            return ((Number) SequencesKt___SequencesKt.P(SequencesKt___SequencesKt.Z(offsets(), idx + 1))).intValue();
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    private final void resize() {
        int i10 = this.size;
        HeadersData headersData = this.headersData;
        this.size = 0;
        this.headerCapacity = (this.headerCapacity * 2) | 128;
        HeadersData headersData2 = (HeadersData) HttpHeadersMapKt.HeadersDataPool.borrow();
        headersData2.prepare((headersData.arraysCount() * 2) | 1);
        this.headersData = headersData2;
        Iterator<Integer> it = headersData.headersStarts().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            put(headersData.at(iIntValue + 1), headersData.at(iIntValue + 2), headersData.at(iIntValue + 3), headersData.at(iIntValue + 4));
        }
        HttpHeadersMapKt.HeadersDataPool.recycle(headersData);
        if (i10 != this.size) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    private final boolean thresholdReached() {
        return ((double) this.size) >= ((double) this.headerCapacity) * 0.75d;
    }

    public final int find(String name, int fromIndex) {
        kotlin.jvm.internal.p.i(name, "name");
        if (this.size == 0) {
            return -1;
        }
        int iIdxToOffset = idxToOffset(fromIndex);
        while (this.headersData.at(iIdxToOffset) != -1) {
            if (headerHasName(name, iIdxToOffset)) {
                return fromIndex;
            }
            fromIndex++;
            iIdxToOffset = (iIdxToOffset / 6) % this.headerCapacity;
        }
        return -1;
    }

    public final CharSequence get(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        if (this.size == 0) {
            return null;
        }
        int iAbs = Math.abs(CharsKt.hashCodeLowerCase$default(name, 0, 0, 3, null));
        int i10 = this.headerCapacity;
        while (true) {
            int i11 = iAbs % i10;
            int i12 = i11 * 6;
            if (this.headersData.at(i12) == -1) {
                return null;
            }
            if (headerHasName(name, i12)) {
                return valueAtOffset(i12);
            }
            iAbs = i11 + 1;
            i10 = this.headerCapacity;
        }
    }

    public final Ka.j<CharSequence> getAll(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return Ka.m.b(new AnonymousClass1(name, null));
    }

    public final int getSize() {
        return this.size;
    }

    public final CharSequence nameAt(int idx) {
        return nameAtOffset(idxToOffset(idx));
    }

    public final CharSequence nameAtOffset(int headerOffset) {
        return this.builder.subSequence(this.headersData.at(headerOffset + 1), this.headersData.at(headerOffset + 2));
    }

    public final Ka.j<Integer> offsets() {
        return this.headersData.headersStarts();
    }

    public final void put(int nameHash, int valueHash, int nameStartIndex, int nameEndIndex, int valueStartIndex, int valueEndIndex) {
        put(nameStartIndex, nameEndIndex, valueStartIndex, valueEndIndex);
    }

    public final void release() {
        this.size = 0;
        this.headerCapacity = 0;
        HttpHeadersMapKt.HeadersDataPool.recycle(this.headersData);
        this.headersData = (HeadersData) HttpHeadersMapKt.HeadersDataPool.borrow();
    }

    public String toString() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        HttpHeadersMapKt.dumpTo(this, "", sb2);
        return sb2.toString();
    }

    public final CharSequence valueAt(int idx) {
        return valueAtOffset(idxToOffset(idx));
    }

    public final CharSequence valueAtOffset(int headerOffset) {
        return this.builder.subSequence(this.headersData.at(headerOffset + 3), this.headersData.at(headerOffset + 4));
    }

    public final void put(int nameStartIndex, int nameEndIndex, int valueStartIndex, int valueEndIndex) {
        int i10;
        if (thresholdReached()) {
            resize();
        }
        int iAbs = Math.abs(CharsKt.hashCodeLowerCase(this.builder, nameStartIndex, nameEndIndex));
        CharSequence charSequenceSubSequence = this.builder.subSequence(nameStartIndex, nameEndIndex);
        int i11 = iAbs % this.headerCapacity;
        int i12 = -1;
        while (true) {
            i10 = i11 * 6;
            if (this.headersData.at(i10) == -1) {
                break;
            }
            if (headerHasName(charSequenceSubSequence, i10)) {
                i12 = i11;
            }
            i11 = (i11 + 1) % this.headerCapacity;
        }
        this.headersData.set(i10, iAbs);
        this.headersData.set(i10 + 1, nameStartIndex);
        this.headersData.set(i10 + 2, nameEndIndex);
        this.headersData.set(i10 + 3, valueStartIndex);
        this.headersData.set(i10 + 4, valueEndIndex);
        this.headersData.set(i10 + 5, -1);
        if (i12 != -1) {
            this.headersData.set((i12 * 6) + 5, i11);
        }
        this.size++;
    }
}
