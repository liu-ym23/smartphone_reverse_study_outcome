package io.ktor.http.content;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a8\u0010\n\u001a\u00020\u0007*\u00020\u00002\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u0000H\u0087@¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/http/content/MultiPartData;", "LXa/b;", "Lio/ktor/http/content/PartData;", "asFlow", "(Lio/ktor/http/content/MultiPartData;)LXa/b;", "Lkotlin/Function2;", "Le9/c;", "LY8/t;", "", "partHandler", "forEachPart", "(Lio/ktor/http/content/MultiPartData;Lp9/p;Le9/c;)Ljava/lang/Object;", "", "readAllParts", "(Lio/ktor/http/content/MultiPartData;Le9/c;)Ljava/lang/Object;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MultipartKt {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LXa/c;", "Lio/ktor/http/content/PartData;", "LY8/t;", "<anonymous>", "(LXa/c;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.http.content.MultipartKt$asFlow$1", f = "Multipart.kt", l = {144, 145}, m = "invokeSuspend")
    /* renamed from: io.ktor.http.content.MultipartKt$asFlow$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<Xa.c<? super PartData>, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ MultiPartData $this_asFlow;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MultiPartData multiPartData, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$this_asFlow = multiPartData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(Xa.c<? super PartData> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(cVar, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0036 A[PHI: r6
          0x0036: PHI (r6v3 java.lang.Object) = (r6v2 java.lang.Object), (r6v0 java.lang.Object) binds: [B:12:0x0033, B:9:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004b -> B:11:0x0026). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = r5.L$0
                Xa.c r0 = (Xa.c) r0
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r5.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L23
                if (r2 == r4) goto L1f
                if (r2 != r3) goto L17
                java.lang.Object r2 = r5.L$1
                io.ktor.http.content.PartData r2 = (io.ktor.http.content.PartData) r2
                goto L23
            L17:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1f:
                kotlin.C4849c.b(r6)
                goto L36
            L23:
                kotlin.C4849c.b(r6)
            L26:
                io.ktor.http.content.MultiPartData r6 = r5.$this_asFlow
                r5.L$0 = r0
                r2 = 0
                r5.L$1 = r2
                r5.label = r4
                java.lang.Object r6 = r6.readPart(r5)
                if (r6 != r1) goto L36
                goto L4d
            L36:
                io.ktor.http.content.PartData r6 = (io.ktor.http.content.PartData) r6
                if (r6 != 0) goto L3d
                Y8.t r5 = Y8.t.f7040a
                return r5
            L3d:
                r5.L$0 = r0
                java.lang.Object r2 = g9.h.a(r6)
                r5.L$1 = r2
                r5.label = r3
                java.lang.Object r6 = r0.emit(r6, r5)
                if (r6 != r1) goto L26
            L4d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.content.MultipartKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "io.ktor.http.content.MultipartKt", f = "Multipart.kt", l = {168, 173}, m = "readAllParts")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.content.MultipartKt$readAllParts$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42931 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C42931(InterfaceC4014c<? super C42931> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.readAllParts(null, this);
        }
    }

    public static final Xa.b<PartData> asFlow(MultiPartData multiPartData) {
        kotlin.jvm.internal.p.i(multiPartData, "<this>");
        return Xa.d.B(new AnonymousClass1(multiPartData, null));
    }

    public static final Object forEachPart(MultiPartData multiPartData, p<? super PartData, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objCollect = asFlow(multiPartData).collect(new MultipartKt$sam$kotlinx_coroutines_flow_FlowCollector$0(pVar), interfaceC4014c);
        return objCollect == C4063a.g() ? objCollect : t.f7040a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
    
        if (r7 == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
    
        if (r7 != r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007c, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007a -> B:27:0x007d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readAllParts(io.ktor.http.content.MultiPartData r6, e9.InterfaceC4014c<? super java.util.List<? extends io.ktor.http.content.PartData>> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.http.content.MultipartKt.C42931
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.http.content.MultipartKt$readAllParts$1 r0 = (io.ktor.http.content.MultipartKt.C42931) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.http.content.MultipartKt$readAllParts$1 r0 = new io.ktor.http.content.MultipartKt$readAllParts$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.L$2
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            java.lang.Object r2 = r0.L$1
            io.ktor.http.content.PartData r2 = (io.ktor.http.content.PartData) r2
            java.lang.Object r2 = r0.L$0
            io.ktor.http.content.MultiPartData r2 = (io.ktor.http.content.MultiPartData) r2
            kotlin.C4849c.b(r7)
            goto L7d
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            java.lang.Object r6 = r0.L$0
            io.ktor.http.content.MultiPartData r6 = (io.ktor.http.content.MultiPartData) r6
            kotlin.C4849c.b(r7)
            goto L56
        L48:
            kotlin.C4849c.b(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r6.readPart(r0)
            if (r7 != r1) goto L56
            goto L7c
        L56:
            io.ktor.http.content.PartData r7 = (io.ktor.http.content.PartData) r7
            if (r7 != 0) goto L5f
            java.util.List r6 = Z8.C1173v.m()
            return r6
        L5f:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r2.add(r7)
            r5 = r2
            r2 = r6
            r6 = r5
        L6a:
            r0.L$0 = r2
            java.lang.Object r7 = g9.h.a(r7)
            r0.L$1 = r7
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r7 = r2.readPart(r0)
            if (r7 != r1) goto L7d
        L7c:
            return r1
        L7d:
            io.ktor.http.content.PartData r7 = (io.ktor.http.content.PartData) r7
            if (r7 != 0) goto L82
            return r6
        L82:
            r6.add(r7)
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.content.MultipartKt.readAllParts(io.ktor.http.content.MultiPartData, e9.c):java.lang.Object");
    }
}
