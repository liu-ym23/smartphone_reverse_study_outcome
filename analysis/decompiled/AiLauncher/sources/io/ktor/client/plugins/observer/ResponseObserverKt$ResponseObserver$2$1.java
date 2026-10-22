package io.ktor.client.plugins.observer;

import Ua.M;
import Y8.t;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.observer.AfterReceiveHook;
import io.ktor.client.statement.HttpResponse;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/client/plugins/observer/AfterReceiveHook$Context;", "Lio/ktor/client/statement/HttpResponse;", UxipConstants.f30685x, "LY8/t;", "<anonymous>", "(Lio/ktor/client/plugins/observer/AfterReceiveHook$Context;Lio/ktor/client/statement/HttpResponse;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1", f = "ResponseObserver.kt", l = {69, 69, 72, 82, 87}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ResponseObserverKt$ResponseObserver$2$1 extends SuspendLambda implements q<AfterReceiveHook.Context, HttpResponse, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ InterfaceC5074l<HttpClientCall, Boolean> $filter;
    final /* synthetic */ p<HttpResponse, InterfaceC4014c<? super t>, Object> $responseHandler;
    final /* synthetic */ ClientPluginBuilder<ResponseObserverConfig> $this_createClientPlugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lkotlin/Result;", "LY8/t;", "<anonymous>", "(LUa/M;)Lkotlin/Result;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$1", f = "ResponseObserver.kt", l = {70}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Result<? extends t>>, Object> {
        final /* synthetic */ HttpResponse $response;
        final /* synthetic */ p<HttpResponse, InterfaceC4014c<? super t>, Object> $responseHandler;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(p<? super HttpResponse, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, HttpResponse httpResponse, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$responseHandler = pVar;
            this.$response = httpResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$responseHandler, this.$response, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super Result<t>> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            M m10 = (M) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    C4849c.b(obj);
                    p<HttpResponse, InterfaceC4014c<? super t>, Object> pVar = this.$responseHandler;
                    HttpResponse httpResponse = this.$response;
                    Result.Companion companion = Result.INSTANCE;
                    this.L$0 = h.a(m10);
                    this.L$1 = h.a(m10);
                    this.I$0 = 0;
                    this.label = 1;
                    if (pVar.invoke(httpResponse, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            return Result.a(objB);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Result<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super Result<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$2", f = "ResponseObserver.kt", l = {83, 84}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ p<HttpResponse, InterfaceC4014c<? super t>, Object> $responseHandler;
        final /* synthetic */ HttpResponse $sideResponse;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(p<? super HttpResponse, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, HttpResponse httpResponse, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$responseHandler = pVar;
            this.$sideResponse = httpResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$responseHandler, this.$sideResponse, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
        
            if (r12 == r2) goto L26;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                r11 = this;
                java.lang.Object r0 = r11.L$0
                r1 = r0
                Ua.M r1 = (Ua.M) r1
                java.lang.Object r2 = f9.C4063a.g()
                int r0 = r11.label
                r3 = 0
                r4 = 2
                r5 = 1
                if (r0 == 0) goto L2f
                if (r0 == r5) goto L24
                if (r0 != r4) goto L1c
                java.lang.Object r11 = r11.L$1
                Ua.M r11 = (Ua.M) r11
                kotlin.C4849c.b(r12)     // Catch: java.lang.Throwable -> L8a
                goto L7c
            L1c:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L24:
                java.lang.Object r0 = r11.L$1
                Ua.M r0 = (Ua.M) r0
                kotlin.C4849c.b(r12)     // Catch: java.lang.Throwable -> L2c
                goto L4b
            L2c:
                r0 = move-exception
                r12 = r0
                goto L51
            L2f:
                kotlin.C4849c.b(r12)
                p9.p<io.ktor.client.statement.HttpResponse, e9.c<? super Y8.t>, java.lang.Object> r12 = r11.$responseHandler
                io.ktor.client.statement.HttpResponse r0 = r11.$sideResponse
                kotlin.Result$a r6 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2c
                r11.L$0 = r1     // Catch: java.lang.Throwable -> L2c
                java.lang.Object r6 = g9.h.a(r1)     // Catch: java.lang.Throwable -> L2c
                r11.L$1 = r6     // Catch: java.lang.Throwable -> L2c
                r11.I$0 = r3     // Catch: java.lang.Throwable -> L2c
                r11.label = r5     // Catch: java.lang.Throwable -> L2c
                java.lang.Object r12 = r12.invoke(r0, r11)     // Catch: java.lang.Throwable -> L2c
                if (r12 != r2) goto L4b
                goto L7b
            L4b:
                Y8.t r12 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L2c
                kotlin.Result.b(r12)     // Catch: java.lang.Throwable -> L2c
                goto L5a
            L51:
                kotlin.Result$a r0 = kotlin.Result.INSTANCE
                java.lang.Object r12 = kotlin.C4849c.a(r12)
                kotlin.Result.b(r12)
            L5a:
                io.ktor.client.statement.HttpResponse r12 = r11.$sideResponse
                io.ktor.utils.io.ByteReadChannel r5 = r12.getRawContent()     // Catch: java.lang.Throwable -> L8a
                java.lang.Object r12 = g9.h.a(r1)     // Catch: java.lang.Throwable -> L8a
                r11.L$0 = r12     // Catch: java.lang.Throwable -> L8a
                java.lang.Object r12 = g9.h.a(r1)     // Catch: java.lang.Throwable -> L8a
                r11.L$1 = r12     // Catch: java.lang.Throwable -> L8a
                r11.I$0 = r3     // Catch: java.lang.Throwable -> L8a
                r11.label = r4     // Catch: java.lang.Throwable -> L8a
                r6 = 0
                r9 = 1
                r10 = 0
                r8 = r11
                java.lang.Object r12 = io.ktor.utils.io.ByteReadChannelOperationsKt.discard$default(r5, r6, r8, r9, r10)     // Catch: java.lang.Throwable -> L8a
                if (r12 != r2) goto L7c
            L7b:
                return r2
            L7c:
                java.lang.Number r12 = (java.lang.Number) r12     // Catch: java.lang.Throwable -> L8a
                long r11 = r12.longValue()     // Catch: java.lang.Throwable -> L8a
                java.lang.Long r11 = g9.C4109a.g(r11)     // Catch: java.lang.Throwable -> L8a
                kotlin.Result.b(r11)     // Catch: java.lang.Throwable -> L8a
                goto L95
            L8a:
                r0 = move-exception
                r11 = r0
                kotlin.Result$a r12 = kotlin.Result.INSTANCE
                java.lang.Object r11 = kotlin.C4849c.a(r11)
                kotlin.Result.b(r11)
            L95:
                Y8.t r11 = Y8.t.f7040a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ResponseObserverKt$ResponseObserver$2$1(InterfaceC5074l<? super HttpClientCall, Boolean> interfaceC5074l, ClientPluginBuilder<ResponseObserverConfig> clientPluginBuilder, p<? super HttpResponse, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super ResponseObserverKt$ResponseObserver$2$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$filter = interfaceC5074l;
        this.$this_createClientPlugin = clientPluginBuilder;
        this.$responseHandler = pVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel invokeSuspend$lambda$0(ByteReadChannel byteReadChannel, HttpResponse httpResponse) {
        return byteReadChannel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel invokeSuspend$lambda$1(ByteReadChannel byteReadChannel, HttpResponse httpResponse) {
        return byteReadChannel;
    }

    @Override // p9.q
    public final Object invoke(AfterReceiveHook.Context context, HttpResponse httpResponse, InterfaceC4014c<? super t> interfaceC4014c) {
        ResponseObserverKt$ResponseObserver$2$1 responseObserverKt$ResponseObserver$2$1 = new ResponseObserverKt$ResponseObserver$2$1(this.$filter, this.$this_createClientPlugin, this.$responseHandler, interfaceC4014c);
        responseObserverKt$ResponseObserver$2$1.L$0 = context;
        responseObserverKt$ResponseObserver$2$1.L$1 = httpResponse;
        return responseObserverKt$ResponseObserver$2$1.invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c2, code lost:
    
        if (r1.proceedWith(r2, r18) != r3) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x016b, code lost:
    
        if (r1.proceedWith(r7, r18) != r3) goto L42;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b0  */
    /* JADX WARN: Type inference failed for: r4v22, types: [Ua.M] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
