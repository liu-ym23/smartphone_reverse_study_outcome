package io.ktor.server.engine;

import Ua.C1056g;
import Ua.M;
import Ua.Y;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.LinkHeader;
import io.ktor.http.content.OutgoingContent;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.http.LinkHeaderKt;
import io.ktor.server.response.ApplicationResponsePropertiesKt;
import io.ktor.server.response.ApplicationSendPipeline;
import io.ktor.server.response.PipelineResponse;
import io.ktor.server.response.ResponseCookies;
import io.ktor.server.response.ResponseHeaders;
import io.ktor.server.response.ResponsePushBuilder;
import io.ktor.server.response.UseHttp2Push;
import io.ktor.util.AttributeKey;
import io.ktor.util.internal.ExceptionUtilsJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.InterfaceC5063a;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 G2\u00020\u0001:\u0005HIJKGB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0094@¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0017H\u0094@¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u001aH\u0094@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0094@¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!H\u0094@¢\u0006\u0004\b#\u0010$J\u0018\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H¤@¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)H¤@¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020\fH$¢\u0006\u0004\b-\u0010\u0010J\u0017\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020.H\u0017¢\u0006\u0004\b0\u00101R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00102\u001a\u0004\b3\u00104R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00105R$\u00107\u001a\u0002062\u0006\u0010\u000f\u001a\u0002068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b7\u00109R\u001b\u0010?\u001a\u00020:8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0016\u0010@\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00108R\u0017\u0010B\u001a\u00020A8\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\u0002068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u00109¨\u0006L"}, d2 = {"Lio/ktor/server/engine/BaseApplicationResponse;", "Lio/ktor/server/response/PipelineResponse;", "Lio/ktor/server/application/PipelineCall;", "call", "<init>", "(Lio/ktor/server/application/PipelineCall;)V", "", "expected", "actual", "LY8/t;", "ensureLength", "(JJ)V", "Lio/ktor/http/HttpStatusCode;", "status", "()Lio/ktor/http/HttpStatusCode;", UxipConstants.f30680s, "(Lio/ktor/http/HttpStatusCode;)V", "Lio/ktor/http/content/OutgoingContent;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "commitHeaders", "(Lio/ktor/http/content/OutgoingContent;)V", "respondOutgoingContent", "(Lio/ktor/http/content/OutgoingContent;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/content/OutgoingContent$NoContent;", "respondNoContent", "(Lio/ktor/http/content/OutgoingContent$NoContent;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "respondWriteChannelContent", "(Lio/ktor/http/content/OutgoingContent$WriteChannelContent;Le9/c;)Ljava/lang/Object;", "", SingleFileBundle.KEY_BYTES, "respondFromBytes", "([BLe9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "readChannel", "respondFromChannel", "(Lio/ktor/utils/io/ByteReadChannel;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/content/OutgoingContent$ProtocolUpgrade;", "upgrade", "respondUpgrade", "(Lio/ktor/http/content/OutgoingContent$ProtocolUpgrade;Le9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "responseChannel", "(Le9/c;)Ljava/lang/Object;", "statusCode", "setStatus", "Lio/ktor/server/response/ResponsePushBuilder;", "builder", "push", "(Lio/ktor/server/response/ResponsePushBuilder;)V", "Lio/ktor/server/application/PipelineCall;", "getCall", "()Lio/ktor/server/application/PipelineCall;", "Lio/ktor/http/HttpStatusCode;", "", "isSent", "Z", "()Z", "Lio/ktor/server/response/ResponseCookies;", "cookies$delegate", "LY8/h;", "getCookies", "()Lio/ktor/server/response/ResponseCookies;", "cookies", "responded", "Lio/ktor/server/response/ApplicationSendPipeline;", "pipeline", "Lio/ktor/server/response/ApplicationSendPipeline;", "getPipeline", "()Lio/ktor/server/response/ApplicationSendPipeline;", "isCommitted", "Companion", "ResponseAlreadySentException", "InvalidHeaderForContent", "BodyLengthIsTooSmall", "BodyLengthIsTooLong", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseApplicationResponse implements PipelineResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final AttributeKey<BaseApplicationResponse> EngineResponseAttributeKey;
    private final PipelineCall call;

    /* renamed from: cookies$delegate, reason: from kotlin metadata */
    private final Y8.h cookies;
    private boolean isSent;
    private final ApplicationSendPipeline pipeline;
    private boolean responded;
    private HttpStatusCode status;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/server/engine/BaseApplicationResponse$BodyLengthIsTooLong;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "LUa/C;", "", "expected", "<init>", "(J)V", "createCopy", "()Lio/ktor/server/engine/BaseApplicationResponse$BodyLengthIsTooLong;", "J", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BodyLengthIsTooLong extends IllegalStateException implements Ua.C<BodyLengthIsTooLong> {
        private final long expected;

        public BodyLengthIsTooLong(long j10) {
            super("Body.size is too long. Expected " + j10);
            this.expected = j10;
        }

        @Override // Ua.C
        public BodyLengthIsTooLong createCopy() {
            BodyLengthIsTooLong bodyLengthIsTooLong = new BodyLengthIsTooLong(this.expected);
            ExceptionUtilsJvmKt.initCauseBridge(bodyLengthIsTooLong, this);
            return bodyLengthIsTooLong;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/server/engine/BaseApplicationResponse$BodyLengthIsTooSmall;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "LUa/C;", "", "expected", "actual", "<init>", "(JJ)V", "createCopy", "()Lio/ktor/server/engine/BaseApplicationResponse$BodyLengthIsTooSmall;", "J", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BodyLengthIsTooSmall extends IllegalStateException implements Ua.C<BodyLengthIsTooSmall> {
        private final long actual;
        private final long expected;

        public BodyLengthIsTooSmall(long j10, long j11) {
            super("Body.size is too small. Body: " + j11 + ", Content-Length: " + j10);
            this.expected = j10;
            this.actual = j11;
        }

        @Override // Ua.C
        public BodyLengthIsTooSmall createCopy() {
            BodyLengthIsTooSmall bodyLengthIsTooSmall = new BodyLengthIsTooSmall(this.expected, this.actual);
            ExceptionUtilsJvmKt.initCauseBridge(bodyLengthIsTooSmall, this);
            return bodyLengthIsTooSmall;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/server/engine/BaseApplicationResponse$Companion;", "", "<init>", "()V", "Lio/ktor/server/response/ApplicationSendPipeline;", "sendPipeline", "LY8/t;", "setupSendPipeline", "(Lio/ktor/server/response/ApplicationSendPipeline;)V", "Lio/ktor/server/engine/EnginePipeline;", ContentType.Application.TYPE, "Lvc/c;", "Lio/ktor/util/logging/Logger;", "logger", "setupFallbackResponse$ktor_server_core", "(Lio/ktor/server/engine/EnginePipeline;Lvc/c;)V", "setupFallbackResponse", "Lio/ktor/util/AttributeKey;", "Lio/ktor/server/engine/BaseApplicationResponse;", "EngineResponseAttributeKey", "Lio/ktor/util/AttributeKey;", "getEngineResponseAttributeKey", "()Lio/ktor/util/AttributeKey;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AttributeKey<BaseApplicationResponse> getEngineResponseAttributeKey() {
            return BaseApplicationResponse.EngineResponseAttributeKey;
        }

        public final void setupFallbackResponse$ktor_server_core(EnginePipeline application, vc.c logger) {
            kotlin.jvm.internal.p.i(application, "application");
            kotlin.jvm.internal.p.i(logger, "logger");
            application.intercept(EnginePipeline.INSTANCE.getBefore(), new BaseApplicationResponse$Companion$setupFallbackResponse$1(logger, application.getDevelopmentMode(), null));
        }

        public final void setupSendPipeline(ApplicationSendPipeline sendPipeline) {
            kotlin.jvm.internal.p.i(sendPipeline, "sendPipeline");
            sendPipeline.intercept(ApplicationSendPipeline.INSTANCE.getEngine(), new BaseApplicationResponse$Companion$setupSendPipeline$1(null));
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/server/engine/BaseApplicationResponse$InvalidHeaderForContent;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "LUa/C;", "", "name", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "createCopy", "()Lio/ktor/server/engine/BaseApplicationResponse$InvalidHeaderForContent;", "Ljava/lang/String;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvalidHeaderForContent extends IllegalStateException implements Ua.C<InvalidHeaderForContent> {
        private final String content;
        private final String name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidHeaderForContent(String name, String content) {
            super("Header " + name + " is not allowed for " + content);
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(content, "content");
            this.name = name;
            this.content = content;
        }

        @Override // Ua.C
        public InvalidHeaderForContent createCopy() {
            InvalidHeaderForContent invalidHeaderForContent = new InvalidHeaderForContent(this.name, this.content);
            ExceptionUtilsJvmKt.initCauseBridge(invalidHeaderForContent, this);
            return invalidHeaderForContent;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/server/engine/BaseApplicationResponse$ResponseAlreadySentException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "<init>", "()V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResponseAlreadySentException extends IllegalStateException {
        public ResponseAlreadySentException() {
            super("Response has already been sent");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.BaseApplicationResponse$respondFromBytes$3", f = "BaseApplicationResponse.kt", l = {210, 211}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.BaseApplicationResponse$respondFromBytes$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ byte[] $bytes;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(byte[] bArr, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$bytes = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return BaseApplicationResponse.this.new AnonymousClass3(this.$bytes, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ByteWriteChannel byteWriteChannel;
            byte[] bArr;
            Throwable th;
            ByteWriteChannel byteWriteChannel2;
            Object objG = C4063a.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    C4849c.b(obj);
                    BaseApplicationResponse baseApplicationResponse = BaseApplicationResponse.this;
                    this.label = 1;
                    obj = baseApplicationResponse.responseChannel(this);
                    if (obj != objG) {
                    }
                    return objG;
                }
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    byteWriteChannel2 = (ByteWriteChannel) this.L$0;
                    try {
                        C4849c.b(obj);
                        ByteWriteChannelKt.close(byteWriteChannel2);
                        return Y8.t.f7040a;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            ByteWriteChannelOperationsKt.close(byteWriteChannel2, th);
                            throw th;
                        } catch (Throwable th3) {
                            ByteWriteChannelKt.close(byteWriteChannel2);
                            throw th3;
                        }
                    }
                }
                C4849c.b(obj);
                this.L$0 = byteWriteChannel;
                this.label = 2;
                if (ByteWriteChannelOperationsKt.writeFully$default(byteWriteChannel, bArr, 0, 0, this, 6, null) != objG) {
                    byteWriteChannel2 = byteWriteChannel;
                    ByteWriteChannelKt.close(byteWriteChannel2);
                    return Y8.t.f7040a;
                }
                return objG;
            } catch (Throwable th4) {
                th = th4;
                byteWriteChannel2 = byteWriteChannel;
                ByteWriteChannelOperationsKt.close(byteWriteChannel2, th);
                throw th;
            }
            byteWriteChannel = (ByteWriteChannel) obj;
            bArr = this.$bytes;
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.engine.BaseApplicationResponse", f = "BaseApplicationResponse.kt", l = {220, 222, 227}, m = "respondFromChannel$suspendImpl")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.engine.BaseApplicationResponse$respondFromChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseApplicationResponse.respondFromChannel$suspendImpl(BaseApplicationResponse.this, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.engine.BaseApplicationResponse", f = "BaseApplicationResponse.kt", l = {125, 134, 142, 152, 161, 164}, m = "respondOutgoingContent$suspendImpl")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.engine.BaseApplicationResponse$respondOutgoingContent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C43421(InterfaceC4014c<? super C43421> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseApplicationResponse.respondOutgoingContent$suspendImpl(BaseApplicationResponse.this, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.engine.BaseApplicationResponse", f = "BaseApplicationResponse.kt", l = {181, 185}, m = "respondWriteChannelContent$suspendImpl")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.engine.BaseApplicationResponse$respondWriteChannelContent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43431 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C43431(InterfaceC4014c<? super C43431> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseApplicationResponse.respondWriteChannelContent$suspendImpl(BaseApplicationResponse.this, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        InterfaceC5755n interfaceC5755nM = null;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(BaseApplicationResponse.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(BaseApplicationResponse.class);
        } catch (Throwable unused) {
        }
        EngineResponseAttributeKey = new AttributeKey<>("EngineResponse", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
    }

    public BaseApplicationResponse(PipelineCall call) {
        kotlin.jvm.internal.p.i(call, "call");
        this.call = call;
        this.cookies = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.engine.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return BaseApplicationResponse.cookies_delegate$lambda$0(this.f33377a);
            }
        });
        ApplicationSendPipeline applicationSendPipeline = new ApplicationSendPipeline(call.getApplication().getDevelopmentMode());
        applicationSendPipeline.resetFrom(call.getApplication().getSendPipeline());
        this.pipeline = applicationSendPipeline;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t commitHeaders$lambda$3(Ref$BooleanRef ref$BooleanRef, OutgoingContent outgoingContent, BaseApplicationResponse baseApplicationResponse, String name, List values) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(values, "values");
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        if (kotlin.jvm.internal.p.d(name, httpHeaders.getTransferEncoding())) {
            ref$BooleanRef.f34815a = true;
        } else if (kotlin.jvm.internal.p.d(name, httpHeaders.getUpgrade())) {
            if (!(outgoingContent instanceof OutgoingContent.ProtocolUpgrade)) {
                throw new InvalidHeaderForContent(httpHeaders.getUpgrade(), "non-upgrading response");
            }
            Iterator it = values.iterator();
            while (it.hasNext()) {
                baseApplicationResponse.getHeaders().append(name, (String) it.next(), false);
            }
            return Y8.t.f7040a;
        }
        Iterator it2 = values.iterator();
        while (it2.hasNext()) {
            ResponseHeaders.append$default(baseApplicationResponse.getHeaders(), name, (String) it2.next(), false, 4, null);
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ResponseCookies cookies_delegate$lambda$0(BaseApplicationResponse baseApplicationResponse) {
        return new ResponseCookies(baseApplicationResponse);
    }

    private final void ensureLength(long expected, long actual) {
        if (expected < actual) {
            throw new BodyLengthIsTooLong(expected);
        }
        if (expected > actual) {
            throw new BodyLengthIsTooSmall(expected, actual);
        }
    }

    public static /* synthetic */ Object respondFromBytes$suspendImpl(BaseApplicationResponse baseApplicationResponse, byte[] bArr, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        String str = baseApplicationResponse.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
        if (str != null) {
            baseApplicationResponse.ensureLength(Long.parseLong(str), bArr.length);
        }
        Object objJ = C1056g.j(Y.d(), baseApplicationResponse.new AnonymousClass3(bArr, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c3 A[Catch: all -> 0x00ec, TRY_LEAVE, TryCatch #1 {all -> 0x00ec, blocks: (B:37:0x00bb, B:39:0x00c3), top: B:56:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object respondFromChannel$suspendImpl(io.ktor.server.engine.BaseApplicationResponse r10, io.ktor.utils.io.ByteReadChannel r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.BaseApplicationResponse.respondFromChannel$suspendImpl(io.ktor.server.engine.BaseApplicationResponse, io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object respondNoContent$suspendImpl(BaseApplicationResponse baseApplicationResponse, OutgoingContent.NoContent noContent, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return Y8.t.f7040a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
    
        if (r4.respondUpgrade((io.ktor.http.content.OutgoingContent.ProtocolUpgrade) r5, r0) == r1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
    
        if (r4.respondFromBytes(r6, r0) == r1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
    
        if (r4.respondWriteChannelContent((io.ktor.http.content.OutgoingContent.WriteChannelContent) r5, r0) == r1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c8, code lost:
    
        if (r4.respondNoContent((io.ktor.http.content.OutgoingContent.NoContent) r5, r0) == r1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00de, code lost:
    
        if (r4.respondOutgoingContent(r5, r0) == r1) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object respondOutgoingContent$suspendImpl(io.ktor.server.engine.BaseApplicationResponse r4, io.ktor.http.content.OutgoingContent r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.BaseApplicationResponse.respondOutgoingContent$suspendImpl(io.ktor.server.engine.BaseApplicationResponse, io.ktor.http.content.OutgoingContent, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        if (Ua.C1056g.j(r8, r2, r0) == r1) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0, types: [io.ktor.server.engine.BaseApplicationResponse] */
    /* JADX WARN: Type inference failed for: r6v1, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r6v5, types: [Y8.t, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object respondWriteChannelContent$suspendImpl(io.ktor.server.engine.BaseApplicationResponse r6, io.ktor.http.content.OutgoingContent.WriteChannelContent r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.server.engine.BaseApplicationResponse.C43431
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.server.engine.BaseApplicationResponse$respondWriteChannelContent$1 r0 = (io.ktor.server.engine.BaseApplicationResponse.C43431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.engine.BaseApplicationResponse$respondWriteChannelContent$1 r0 = new io.ktor.server.engine.BaseApplicationResponse$respondWriteChannelContent$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L46
            if (r2 == r5) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L31 io.ktor.utils.io.ClosedWriteChannelException -> L33
            goto L6d
        L31:
            r7 = move-exception
            goto L79
        L33:
            r7 = move-exception
            goto L73
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            java.lang.Object r6 = r0.L$0
            r7 = r6
            io.ktor.http.content.OutgoingContent$WriteChannelContent r7 = (io.ktor.http.content.OutgoingContent.WriteChannelContent) r7
            kotlin.C4849c.b(r8)
            goto L54
        L46:
            kotlin.C4849c.b(r8)
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r6.responseChannel(r0)
            if (r8 != r1) goto L54
            goto L6c
        L54:
            r6 = r8
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            Ua.Y r8 = Ua.Y.f6353a     // Catch: java.lang.Throwable -> L31 io.ktor.utils.io.ClosedWriteChannelException -> L33
            Ua.I r8 = io.ktor.server.engine.internal.ApplicationUtilsJvmKt.getIOBridge(r8)     // Catch: java.lang.Throwable -> L31 io.ktor.utils.io.ClosedWriteChannelException -> L33
            io.ktor.server.engine.BaseApplicationResponse$respondWriteChannelContent$2$1 r2 = new io.ktor.server.engine.BaseApplicationResponse$respondWriteChannelContent$2$1     // Catch: java.lang.Throwable -> L31 io.ktor.utils.io.ClosedWriteChannelException -> L33
            r2.<init>(r7, r6, r4)     // Catch: java.lang.Throwable -> L31 io.ktor.utils.io.ClosedWriteChannelException -> L33
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L31 io.ktor.utils.io.ClosedWriteChannelException -> L33
            r0.label = r3     // Catch: java.lang.Throwable -> L31 io.ktor.utils.io.ClosedWriteChannelException -> L33
            java.lang.Object r7 = Ua.C1056g.j(r8, r2, r0)     // Catch: java.lang.Throwable -> L31 io.ktor.utils.io.ClosedWriteChannelException -> L33
            if (r7 != r1) goto L6d
        L6c:
            return r1
        L6d:
            io.ktor.utils.io.ByteWriteChannelKt.close(r6)
            Y8.t r6 = Y8.t.f7040a
            return r6
        L73:
            io.ktor.util.cio.ChannelWriteException r8 = new io.ktor.util.cio.ChannelWriteException     // Catch: java.lang.Throwable -> L31
            r8.<init>(r4, r7, r5, r4)     // Catch: java.lang.Throwable -> L31
            throw r8     // Catch: java.lang.Throwable -> L31
        L79:
            io.ktor.utils.io.ByteWriteChannelOperationsKt.close(r6, r7)     // Catch: java.lang.Throwable -> L7d
            throw r7     // Catch: java.lang.Throwable -> L7d
        L7d:
            r7 = move-exception
            io.ktor.utils.io.ByteWriteChannelKt.close(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.BaseApplicationResponse.respondWriteChannelContent$suspendImpl(io.ktor.server.engine.BaseApplicationResponse, io.ktor.http.content.OutgoingContent$WriteChannelContent, e9.c):java.lang.Object");
    }

    public final void commitHeaders(final OutgoingContent content) {
        ContentType contentType;
        kotlin.jvm.internal.p.i(content, "content");
        if (this.responded) {
            throw new ResponseAlreadySentException();
        }
        this.responded = true;
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        HttpStatusCode status = content.getValue();
        if (status != null) {
            status(status);
            Y8.t tVar = Y8.t.f7040a;
        } else if (getStatus() == null) {
            status = HttpStatusCode.INSTANCE.getOK();
            status(status);
            Y8.t tVar2 = Y8.t.f7040a;
        }
        content.getHeaders().forEach(new p9.p() { // from class: io.ktor.server.engine.e
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return BaseApplicationResponse.commitHeaders$lambda$3(ref$BooleanRef, content, this, (String) obj, (List) obj2);
            }
        });
        Long contentLength = content.getContentLength();
        if (contentLength != null) {
            getHeaders().append(HttpHeaders.INSTANCE.getContentLength(), LongKt.toStringFast(contentLength.longValue()), false);
        } else if (!ref$BooleanRef.f34815a && !(content instanceof OutgoingContent.ProtocolUpgrade)) {
            if (content instanceof OutgoingContent.NoContent) {
                getHeaders().append(HttpHeaders.INSTANCE.getContentLength(), "0", false);
            } else {
                getHeaders().append(HttpHeaders.INSTANCE.getTransferEncoding(), com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30859r, false);
            }
        }
        ResponseHeaders headers = getHeaders();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        if (!headers.contains(httpHeaders.getContentType()) && (contentType = content.getContentType()) != null) {
            getHeaders().append(httpHeaders.getContentType(), contentType.toString(), false);
        }
        String str = this.call.getRequest().getHeaders().get(httpHeaders.getConnection());
        if (str == null || this.call.getResponse().getHeaders().contains(httpHeaders.getConnection())) {
            return;
        }
        if (La.D.L(str, "close", true)) {
            ApplicationResponsePropertiesKt.header(this, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j, "close");
        } else if (La.D.L(str, "keep-alive", true)) {
            ApplicationResponsePropertiesKt.header(this, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j, "keep-alive");
        }
    }

    @Override // io.ktor.server.response.ApplicationResponse
    public /* bridge */ /* synthetic */ ApplicationCall getCall() {
        return this.call;
    }

    @Override // io.ktor.server.response.ApplicationResponse
    public ResponseCookies getCookies() {
        return (ResponseCookies) this.cookies.getValue();
    }

    @Override // io.ktor.server.response.PipelineResponse
    public final ApplicationSendPipeline getPipeline() {
        return this.pipeline;
    }

    @Override // io.ktor.server.response.ApplicationResponse
    /* renamed from: isCommitted, reason: from getter */
    public boolean getResponded() {
        return this.responded;
    }

    @Override // io.ktor.server.response.ApplicationResponse
    /* renamed from: isSent, reason: from getter */
    public final boolean getIsSent() {
        return this.isSent;
    }

    @Override // io.ktor.server.response.ApplicationResponse
    @UseHttp2Push
    public void push(ResponsePushBuilder builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        LinkHeaderKt.link(this, builder.getUrl().buildString(), LinkHeader.Rel.Prefetch);
    }

    public Object respondFromBytes(byte[] bArr, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return respondFromBytes$suspendImpl(this, bArr, interfaceC4014c);
    }

    public Object respondFromChannel(ByteReadChannel byteReadChannel, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return respondFromChannel$suspendImpl(this, byteReadChannel, interfaceC4014c);
    }

    public Object respondNoContent(OutgoingContent.NoContent noContent, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return respondNoContent$suspendImpl(this, noContent, interfaceC4014c);
    }

    public Object respondOutgoingContent(OutgoingContent outgoingContent, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return respondOutgoingContent$suspendImpl(this, outgoingContent, interfaceC4014c);
    }

    public abstract Object respondUpgrade(OutgoingContent.ProtocolUpgrade protocolUpgrade, InterfaceC4014c<? super Y8.t> interfaceC4014c);

    public Object respondWriteChannelContent(OutgoingContent.WriteChannelContent writeChannelContent, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return respondWriteChannelContent$suspendImpl(this, writeChannelContent, interfaceC4014c);
    }

    public abstract Object responseChannel(InterfaceC4014c<? super ByteWriteChannel> interfaceC4014c);

    public abstract void setStatus(HttpStatusCode statusCode);

    @Override // io.ktor.server.response.ApplicationResponse
    /* renamed from: status, reason: from getter */
    public HttpStatusCode getStatus() {
        return this.status;
    }

    @Override // io.ktor.server.response.PipelineResponse, io.ktor.server.response.ApplicationResponse
    public final PipelineCall getCall() {
        return this.call;
    }

    @Override // io.ktor.server.response.ApplicationResponse
    public void status(HttpStatusCode value) {
        kotlin.jvm.internal.p.i(value, "value");
        this.status = value;
        setStatus(value);
    }
}
