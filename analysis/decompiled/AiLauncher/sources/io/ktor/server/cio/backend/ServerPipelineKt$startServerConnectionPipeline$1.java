package io.ktor.server.cio.backend;

import Ua.InterfaceC1083u;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import io.ktor.http.cio.Request;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.cio.backend.ServerPipelineKt$startServerConnectionPipeline$1", f = "ServerPipeline.kt", l = {65, 67, 76, 93, 118, 153, 155, 164, 174}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ServerPipelineKt$startServerConnectionPipeline$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ ServerIncomingConnection $connection;
    final /* synthetic */ q<ServerRequestScope, Request, InterfaceC4014c<? super t>, Object> $handler;
    final /* synthetic */ long $timeout;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    boolean Z$0;
    int label;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.cio.backend.ServerPipelineKt$startServerConnectionPipeline$1$1", f = "ServerPipeline.kt", l = {52}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.cio.backend.ServerPipelineKt$startServerConnectionPipeline$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ Wa.g<ByteReadChannel> $actorChannel;
        final /* synthetic */ ServerIncomingConnection $connection;
        final /* synthetic */ long $timeout;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Wa.g<ByteReadChannel> gVar, long j10, ServerIncomingConnection serverIncomingConnection, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$actorChannel = gVar;
            this.$timeout = j10;
            this.$connection = serverIncomingConnection;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$actorChannel, this.$timeout, this.$connection, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    C4849c.b(obj);
                    Wa.g<ByteReadChannel> gVar = this.$actorChannel;
                    long j10 = this.$timeout;
                    ServerIncomingConnection serverIncomingConnection = this.$connection;
                    this.label = 1;
                    if (ServerPipelineKt.m170pipelineWriterLoopdWUq8MI(gVar, j10, serverIncomingConnection, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
            } finally {
                try {
                    return t.f7040a;
                } finally {
                }
            }
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.cio.backend.ServerPipelineKt$startServerConnectionPipeline$1$2", f = "ServerPipeline.kt", l = {142}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.cio.backend.ServerPipelineKt$startServerConnectionPipeline$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ ServerIncomingConnection $connection;
        final /* synthetic */ q<ServerRequestScope, Request, InterfaceC4014c<? super t>, Object> $handler;
        final /* synthetic */ Request $request;
        final /* synthetic */ ByteReadChannel $requestBody;
        final /* synthetic */ ByteChannel $response;
        final /* synthetic */ InterfaceC1083u<Boolean> $upgraded;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(ByteReadChannel byteReadChannel, ByteChannel byteChannel, ServerIncomingConnection serverIncomingConnection, InterfaceC1083u<Boolean> interfaceC1083u, q<? super ServerRequestScope, ? super Request, ? super InterfaceC4014c<? super t>, ? extends Object> qVar, Request request, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$requestBody = byteReadChannel;
            this.$response = byteChannel;
            this.$connection = serverIncomingConnection;
            this.$upgraded = interfaceC1083u;
            this.$handler = qVar;
            this.$request = request;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$requestBody, this.$response, this.$connection, this.$upgraded, this.$handler, this.$request, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v8, types: [Ua.u<java.lang.Boolean>] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC1083u<Boolean> interfaceC1083u;
            Object objG = C4063a.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    C4849c.b(obj);
                    ServerRequestScope serverRequestScope = new ServerRequestScope(((M) this.L$0).getCoroutineContext(), this.$requestBody, this.$response, this.$connection.getRemoteAddress(), this.$connection.getLocalAddress(), this.$upgraded);
                    q<ServerRequestScope, Request, InterfaceC4014c<? super t>, Object> qVar = this.$handler;
                    Request request = this.$request;
                    this.label = 1;
                    if (qVar.invoke(serverRequestScope, request, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
            } catch (Throwable th) {
                try {
                    ByteWriteChannelOperationsKt.close(this.$response, th);
                    InterfaceC1083u<Boolean> interfaceC1083u2 = this.$upgraded;
                    if (interfaceC1083u2 != null) {
                        C4109a.a(interfaceC1083u2.e(th));
                    }
                    this.$response.close();
                    InterfaceC1083u<Boolean> interfaceC1083u3 = this.$upgraded;
                    interfaceC1083u = interfaceC1083u3;
                    if (interfaceC1083u3 != null) {
                    }
                } finally {
                    this.$response.close();
                    InterfaceC1083u<Boolean> interfaceC1083u4 = this.$upgraded;
                    if (interfaceC1083u4 != null) {
                        C4109a.a(interfaceC1083u4.complete(C4109a.a(false)));
                    }
                    throw th;
                }
            }
            if (this != 0) {
                C4109a.a(interfaceC1083u.complete(C4109a.a(false)));
            }
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ServerPipelineKt$startServerConnectionPipeline$1(ServerIncomingConnection serverIncomingConnection, long j10, q<? super ServerRequestScope, ? super Request, ? super InterfaceC4014c<? super t>, ? extends Object> qVar, InterfaceC4014c<? super ServerPipelineKt$startServerConnectionPipeline$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$connection = serverIncomingConnection;
        this.$timeout = j10;
        this.$handler = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ServerPipelineKt$startServerConnectionPipeline$1 serverPipelineKt$startServerConnectionPipeline$1 = new ServerPipelineKt$startServerConnectionPipeline$1(this.$connection, this.$timeout, this.$handler, interfaceC4014c);
        serverPipelineKt$startServerConnectionPipeline$1.L$0 = obj;
        return serverPipelineKt$startServerConnectionPipeline$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ServerPipelineKt$startServerConnectionPipeline$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:172:0x0466, code lost:
    
        if (r0 == r8) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x03ae, code lost:
    
        r1 = r9;
        r2 = r11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x03bc: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:140:0x03bc */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x039c: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:130:0x039c */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x039f: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:131:0x039f */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x03bd: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:140:0x03bc */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x03a0: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:131:0x039f */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02f0 A[Catch: IOException -> 0x0255, all -> 0x02ea, TryCatch #5 {all -> 0x02ea, blocks: (B:87:0x026a, B:89:0x0288, B:93:0x02ae, B:95:0x02b6, B:104:0x02f0, B:106:0x02f4, B:110:0x030e, B:81:0x0258, B:144:0x03ca), top: B:192:0x026a }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0416 A[Catch: all -> 0x039b, IOException -> 0x03bc, TryCatch #16 {IOException -> 0x03bc, blocks: (B:136:0x03ae, B:56:0x0198, B:153:0x03ff, B:154:0x0402, B:162:0x040c, B:164:0x0416, B:165:0x042a, B:169:0x044a, B:170:0x044b), top: B:191:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x030e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018f A[Catch: all -> 0x0403, CancellationException -> 0x0405, IOException -> 0x0407, TooLongLineException -> 0x0409, PHI: r0 r1 r2 r3 r13
      0x018f: PHI (r0v70 kotlin.coroutines.d) = (r0v19 kotlin.coroutines.d), (r0v73 kotlin.coroutines.d) binds: [B:41:0x011b, B:51:0x018b] A[DONT_GENERATE, DONT_INLINE]
      0x018f: PHI (r1v73 Ua.M) = (r1v20 Ua.M), (r1v74 Ua.M) binds: [B:41:0x011b, B:51:0x018b] A[DONT_GENERATE, DONT_INLINE]
      0x018f: PHI (r2v40 Wa.g) = (r2v9 Wa.g), (r2v41 Wa.g) binds: [B:41:0x011b, B:51:0x018b] A[DONT_GENERATE, DONT_INLINE]
      0x018f: PHI (r3v20 java.lang.Object) = (r3v4 java.lang.Object), (r3v26 java.lang.Object) binds: [B:41:0x011b, B:51:0x018b] A[DONT_GENERATE, DONT_INLINE]
      0x018f: PHI (r13v10 kotlin.jvm.internal.i) = (r13v17 kotlin.jvm.internal.i), (r13v20 kotlin.jvm.internal.i) binds: [B:41:0x011b, B:51:0x018b] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #24 {TooLongLineException -> 0x0409, IOException -> 0x0407, CancellationException -> 0x0405, all -> 0x0403, blocks: (B:50:0x016c, B:53:0x018f), top: B:218:0x016c }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0198 A[Catch: all -> 0x039b, IOException -> 0x03bc, TRY_ENTER, TRY_LEAVE, TryCatch #16 {IOException -> 0x03bc, blocks: (B:136:0x03ae, B:56:0x0198, B:153:0x03ff, B:154:0x0402, B:162:0x040c, B:164:0x0416, B:165:0x042a, B:169:0x044a, B:170:0x044b), top: B:191:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0211 A[Catch: all -> 0x0223, TryCatch #2 {all -> 0x0223, blocks: (B:61:0x01ec, B:63:0x0211, B:65:0x0217, B:68:0x022a, B:70:0x0238), top: B:189:0x01ec }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02b6 A[Catch: IOException -> 0x0255, all -> 0x02ea, TryCatch #5 {all -> 0x02ea, blocks: (B:87:0x026a, B:89:0x0288, B:93:0x02ae, B:95:0x02b6, B:104:0x02f0, B:106:0x02f4, B:110:0x030e, B:81:0x0258, B:144:0x03ca), top: B:192:0x026a }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [Ua.M] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v66, types: [Ua.M, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v72 */
    /* JADX WARN: Type inference failed for: r0v83 */
    /* JADX WARN: Type inference failed for: r0v95 */
    /* JADX WARN: Type inference failed for: r0v96 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v18, types: [java.lang.Object, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.lang.Object, kotlinx.coroutines.g] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x033f -> B:214:0x0345). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1178
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.backend.ServerPipelineKt$startServerConnectionPipeline$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
