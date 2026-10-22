package io.ktor.server.application;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.content.NullBody;
import io.ktor.server.request.PipelineRequest;
import io.ktor.server.response.ApplicationSendPipeline;
import io.ktor.server.response.PipelineResponse;
import io.ktor.server.response.ResponseTypeKt;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096@¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lio/ktor/server/application/PipelineCall;", "Lio/ktor/server/application/ApplicationCall;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "receiveNullable", "(Lio/ktor/util/reflect/TypeInfo;Le9/c;)Ljava/lang/Object;", "", "message", "LY8/t;", "respond", "(Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Le9/c;)Ljava/lang/Object;", "Lio/ktor/server/request/PipelineRequest;", "getRequest", "()Lio/ktor/server/request/PipelineRequest;", "request", "Lio/ktor/server/response/PipelineResponse;", "getResponse", "()Lio/ktor/server/response/PipelineResponse;", UxipConstants.f30685x, "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PipelineCall extends ApplicationCall {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static <T> java.lang.Object receiveNullable(io.ktor.server.application.PipelineCall r6, io.ktor.util.reflect.TypeInfo r7, e9.InterfaceC4014c<? super T> r8) throws java.lang.Throwable {
            /*
                boolean r0 = r8 instanceof io.ktor.server.application.PipelineCall.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r8
                io.ktor.server.application.PipelineCall$receiveNullable$1 r0 = (io.ktor.server.application.PipelineCall.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                io.ktor.server.application.PipelineCall$receiveNullable$1 r0 = new io.ktor.server.application.PipelineCall$receiveNullable$1
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L36
                if (r2 != r3) goto L2e
                java.lang.Object r6 = r0.L$0
                r7 = r6
                io.ktor.util.reflect.TypeInfo r7 = (io.ktor.util.reflect.TypeInfo) r7
                kotlin.C4849c.b(r8)
                goto L76
            L2e:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L36:
                kotlin.C4849c.b(r8)
                io.ktor.util.Attributes r8 = r6.getAttributes()
                io.ktor.util.AttributeKey r2 = io.ktor.server.request.ApplicationReceiveFunctionsKt.getDoubleReceivePreventionTokenKey()
                java.lang.Object r8 = r8.getOrNull(r2)
                io.ktor.server.request.DoubleReceivePreventionToken r8 = (io.ktor.server.request.DoubleReceivePreventionToken) r8
                if (r8 != 0) goto L56
                io.ktor.util.Attributes r2 = r6.getAttributes()
                io.ktor.util.AttributeKey r4 = io.ktor.server.request.ApplicationReceiveFunctionsKt.getDoubleReceivePreventionTokenKey()
                io.ktor.server.request.DoubleReceivePreventionToken r5 = io.ktor.server.request.DoubleReceivePreventionToken.INSTANCE
                r2.put(r4, r5)
            L56:
                io.ktor.server.application.PipelineCallKt.setReceiveType(r6, r7)
                if (r8 != 0) goto L63
                io.ktor.server.request.PipelineRequest r8 = r6.getRequest()
                io.ktor.utils.io.ByteReadChannel r8 = r8.receiveChannel()
            L63:
                io.ktor.server.request.PipelineRequest r2 = r6.getRequest()
                io.ktor.server.request.ApplicationReceivePipeline r2 = r2.getPipeline()
                r0.L$0 = r7
                r0.label = r3
                java.lang.Object r8 = r2.execute(r6, r8, r0)
                if (r8 != r1) goto L76
                return r1
            L76:
                io.ktor.http.content.NullBody r6 = io.ktor.http.content.NullBody.INSTANCE
                boolean r6 = kotlin.jvm.internal.p.d(r8, r6)
                if (r6 == 0) goto L80
                r6 = 0
                return r6
            L80:
                io.ktor.server.request.DoubleReceivePreventionToken r6 = io.ktor.server.request.DoubleReceivePreventionToken.INSTANCE
                if (r8 == r6) goto L9c
                w9.d r6 = r7.getType()
                boolean r6 = r6.k(r8)
                if (r6 == 0) goto L8f
                return r8
            L8f:
                io.ktor.server.plugins.CannotTransformContentToTypeException r6 = new io.ktor.server.plugins.CannotTransformContentToTypeException
                w9.n r7 = r7.getKotlinType()
                kotlin.jvm.internal.p.f(r7)
                r6.<init>(r7)
                throw r6
            L9c:
                io.ktor.server.request.RequestAlreadyConsumedException r6 = new io.ktor.server.request.RequestAlreadyConsumedException
                r6.<init>()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.application.PipelineCall.DefaultImpls.receiveNullable(io.ktor.server.application.PipelineCall, io.ktor.util.reflect.TypeInfo, e9.c):java.lang.Object");
        }

        public static Object respond(PipelineCall pipelineCall, Object obj, TypeInfo typeInfo, InterfaceC4014c<? super t> interfaceC4014c) {
            ResponseTypeKt.setResponseType(pipelineCall.getResponse(), typeInfo);
            ApplicationSendPipeline pipeline = pipelineCall.getResponse().getPipeline();
            if (obj == null) {
                obj = NullBody.INSTANCE;
            }
            Object objExecute = pipeline.execute(pipelineCall, obj, interfaceC4014c);
            return objExecute == C4063a.g() ? objExecute : t.f7040a;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @InterfaceC4112d(c = "io.ktor.server.application.PipelineCall$DefaultImpls", f = "PipelineCall.kt", l = {118}, m = "receiveNullable")
    /* renamed from: io.ktor.server.application.PipelineCall$receiveNullable$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultImpls.receiveNullable(null, null, this);
        }
    }

    @Override // io.ktor.server.application.ApplicationCall, Ua.M
    /* synthetic */ kotlin.coroutines.d getCoroutineContext();

    @Override // io.ktor.server.application.ApplicationCall
    PipelineRequest getRequest();

    @Override // io.ktor.server.application.ApplicationCall
    PipelineResponse getResponse();

    @Override // io.ktor.server.application.ApplicationCall
    <T> Object receiveNullable(TypeInfo typeInfo, InterfaceC4014c<? super T> interfaceC4014c);

    @Override // io.ktor.server.application.ApplicationCall
    Object respond(Object obj, TypeInfo typeInfo, InterfaceC4014c<? super t> interfaceC4014c);
}
