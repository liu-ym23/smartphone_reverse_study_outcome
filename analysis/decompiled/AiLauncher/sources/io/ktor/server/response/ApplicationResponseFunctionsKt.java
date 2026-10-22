package io.ktor.server.response;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import e9.InterfaceC4014c;
import f9.C4063a;
import fb.InterfaceC4084k;
import g9.InterfaceC4112d;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLBuilder;
import io.ktor.http.Url;
import io.ktor.http.content.ByteArrayContent;
import io.ktor.http.content.ChannelWriterContent;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.util.URLBuilderKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.n;
import p9.InterfaceC5074l;
import p9.p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000|\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\u0005\u0010\u0006\u001a$\u0010\u0007\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\u0007\u0010\u0006\u001a0\u0010\u0005\u001a\u00020\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u0000H\u0087H¢\u0006\u0004\b\n\u0010\u000b\u001a.\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00002\u0006\u0010\r\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u0005\u0010\u000e\u001a,\u0010\u0007\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u0000H\u0086H¢\u0006\u0004\b\u0007\u0010\u000b\u001a&\u0010\u0013\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001a&\u0010\u0013\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00152\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0013\u0010\u0016\u001a2\u0010\u0013\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040\u0017H\u0086H¢\u0006\u0004\b\u0013\u0010\u001a\u001aJ\u0010 \u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\u0017H\u0086@¢\u0006\u0004\b \u0010!\u001aJ\u0010 \u001a\u00020\u0004*\u00020\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u001c\u0010#\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\"\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0017H\u0086@¢\u0006\u0004\b \u0010$\u001aJ\u0010&\u001a\u00020\u0004*\u00020\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u001c\u0010#\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\"\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0017H\u0086@¢\u0006\u0004\b&\u0010$\u001aJ\u0010&\u001a\u00020\u0004*\u00020\u00022\u0006\u0010'\u001a\u00020%2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\u0017H\u0086@¢\u0006\u0004\b&\u0010(\u001a@\u0010-\u001a\u00020\u0004*\u00020\u00022\u0006\u0010*\u001a\u00020)2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+H\u0086@¢\u0006\u0004\b-\u0010.\u001a\\\u00102\u001a\u00020\u0004*\u00020\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\"\u00101\u001a\u001e\b\u0001\u0012\u0004\u0012\u000200\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\"\u0012\u0006\u0012\u0004\u0018\u00010\u00000/H\u0086@¢\u0006\u0004\b2\u00103\u001a\u001b\u00104\u001a\u00020\u001c*\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b4\u00105¨\u00066"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/server/application/ApplicationCall;", "message", "LY8/t;", "respond", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "respondNullable", "Lio/ktor/http/HttpStatusCode;", "status", "respondWithType", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/http/HttpStatusCode;Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "messageType", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/http/HttpStatusCode;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Le9/c;)Ljava/lang/Object;", "", "url", "", "permanent", "respondRedirect", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/String;ZLe9/c;)Ljava/lang/Object;", "Lio/ktor/http/Url;", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/http/Url;ZLe9/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lio/ktor/http/URLBuilder;", "block", "(Lio/ktor/server/application/ApplicationCall;ZLp9/l;Le9/c;)Ljava/lang/Object;", "text", "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/content/OutgoingContent;", "configure", "respondText", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/String;Lio/ktor/http/ContentType;Lio/ktor/http/HttpStatusCode;Lp9/l;Le9/c;)Ljava/lang/Object;", "Le9/c;", Const.JSON_KEY_PROVIDER, "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/http/ContentType;Lio/ktor/http/HttpStatusCode;Lp9/l;Le9/c;)Ljava/lang/Object;", "", "respondBytes", SingleFileBundle.KEY_BYTES, "(Lio/ktor/server/application/ApplicationCall;[BLio/ktor/http/ContentType;Lio/ktor/http/HttpStatusCode;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lfb/k;", "source", "", "contentLength", "respondSource", "(Lio/ktor/server/application/ApplicationCall;Lfb/k;Lio/ktor/http/ContentType;Lio/ktor/http/HttpStatusCode;Ljava/lang/Long;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lio/ktor/utils/io/ByteWriteChannel;", "producer", "respondBytesWriter", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/http/ContentType;Lio/ktor/http/HttpStatusCode;Ljava/lang/Long;Lp9/p;Le9/c;)Ljava/lang/Object;", "defaultTextContentType", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/http/ContentType;)Lio/ktor/http/ContentType;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationResponseFunctionsKt {

    @InterfaceC4112d(c = "io.ktor.server.response.ApplicationResponseFunctionsKt", f = "ApplicationResponseFunctions.kt", l = {169, 261}, m = "respondBytes")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.response.ApplicationResponseFunctionsKt$respondBytes$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApplicationResponseFunctionsKt.respondBytes(null, null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/ByteWriteChannel;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.response.ApplicationResponseFunctionsKt$respondSource$2", f = "ApplicationResponseFunctions.kt", l = {207}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.response.ApplicationResponseFunctionsKt$respondSource$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<ByteWriteChannel, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ InterfaceC4084k $source;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC4084k interfaceC4084k, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$source = interfaceC4084k;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$source, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(byteWriteChannel, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ByteWriteChannel byteWriteChannel = (ByteWriteChannel) this.L$0;
                InterfaceC4084k interfaceC4084k = this.$source;
                this.label = 1;
                if (ByteWriteChannelOperationsKt.writeBuffer(byteWriteChannel, interfaceC4084k, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.response.ApplicationResponseFunctionsKt", f = "ApplicationResponseFunctions.kt", l = {151, 261}, m = "respondText")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.response.ApplicationResponseFunctionsKt$respondText$3, reason: invalid class name */
    public static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApplicationResponseFunctionsKt.respondText(null, null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final io.ktor.http.ContentType defaultTextContentType(io.ktor.server.application.ApplicationCall r1, io.ktor.http.ContentType r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.p.i(r1, r0)
            if (r2 != 0) goto L2d
            io.ktor.server.response.ApplicationResponse r1 = r1.getResponse()
            io.ktor.server.response.ResponseHeaders r1 = r1.getHeaders()
            io.ktor.http.HttpHeaders r2 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r2 = r2.getContentType()
            java.lang.String r1 = r1.get(r2)
            if (r1 == 0) goto L27
            io.ktor.http.ContentType$Companion r2 = io.ktor.http.ContentType.INSTANCE     // Catch: io.ktor.http.BadContentTypeFormatException -> L23
            io.ktor.http.ContentType r1 = r2.parse(r1)     // Catch: io.ktor.http.BadContentTypeFormatException -> L23
        L21:
            r2 = r1
            goto L25
        L23:
            r1 = 0
            goto L21
        L25:
            if (r2 != 0) goto L2d
        L27:
            io.ktor.http.ContentType$Text r1 = io.ktor.http.ContentType.Text.INSTANCE
            io.ktor.http.ContentType r2 = r1.getPlain()
        L2d:
            java.nio.charset.Charset r1 = io.ktor.http.ContentTypesKt.charset(r2)
            if (r1 != 0) goto L45
            io.ktor.http.ContentType$Text r1 = io.ktor.http.ContentType.Text.INSTANCE
            io.ktor.http.ContentType r1 = r1.getAny()
            boolean r1 = r2.match(r1)
            if (r1 == 0) goto L45
            java.nio.charset.Charset r1 = La.C0953c.UTF_8
            io.ktor.http.ContentType r2 = io.ktor.http.ContentTypesKt.withCharset(r2, r1)
        L45:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.response.ApplicationResponseFunctionsKt.defaultTextContentType(io.ktor.server.application.ApplicationCall, io.ktor.http.ContentType):io.ktor.http.ContentType");
    }

    public static final Object respond(ApplicationCall applicationCall, HttpStatusCode httpStatusCode, Object obj, TypeInfo typeInfo, InterfaceC4014c<? super t> interfaceC4014c) {
        applicationCall.getResponse().status(httpStatusCode);
        Object objRespond = applicationCall.respond(obj, typeInfo, interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(3:12|26|27)(2:13|14))(1:15))(3:16|(0)|25)|19|28|20|23) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
    
        if (r5.respond(r8, r2, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object respondBytes(io.ktor.server.application.ApplicationCall r5, io.ktor.http.ContentType r6, io.ktor.http.HttpStatusCode r7, p9.InterfaceC5074l<? super e9.InterfaceC4014c<? super byte[]>, ? extends java.lang.Object> r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.server.response.ApplicationResponseFunctionsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.server.response.ApplicationResponseFunctionsKt$respondBytes$1 r0 = (io.ktor.server.response.ApplicationResponseFunctionsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.response.ApplicationResponseFunctionsKt$respondBytes$1 r0 = new io.ktor.server.response.ApplicationResponseFunctionsKt$respondBytes$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r9)
            goto L7f
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$2
            io.ktor.server.application.ApplicationCall r5 = (io.ktor.server.application.ApplicationCall) r5
            java.lang.Object r6 = r0.L$1
            r7 = r6
            io.ktor.http.HttpStatusCode r7 = (io.ktor.http.HttpStatusCode) r7
            java.lang.Object r6 = r0.L$0
            io.ktor.http.ContentType r6 = (io.ktor.http.ContentType) r6
            kotlin.C4849c.b(r9)
            goto L57
        L45:
            kotlin.C4849c.b(r9)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r5
            r0.label = r4
            java.lang.Object r9 = r8.invoke(r0)
            if (r9 != r1) goto L57
            goto L7e
        L57:
            byte[] r9 = (byte[]) r9
            io.ktor.http.content.ByteArrayContent r8 = new io.ktor.http.content.ByteArrayContent
            r8.<init>(r9, r6, r7)
            java.lang.Class<io.ktor.http.content.ByteArrayContent> r6 = io.ktor.http.content.ByteArrayContent.class
            w9.d r7 = kotlin.jvm.internal.t.b(r6)
            r9 = 0
            w9.n r6 = kotlin.jvm.internal.t.m(r6)     // Catch: java.lang.Throwable -> L6a
            goto L6b
        L6a:
            r6 = r9
        L6b:
            io.ktor.util.reflect.TypeInfo r2 = new io.ktor.util.reflect.TypeInfo
            r2.<init>(r7, r6)
            r0.L$0 = r9
            r0.L$1 = r9
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r5 = r5.respond(r8, r2, r0)
            if (r5 != r1) goto L7f
        L7e:
            return r1
        L7f:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.response.ApplicationResponseFunctionsKt.respondBytes(io.ktor.server.application.ApplicationCall, io.ktor.http.ContentType, io.ktor.http.HttpStatusCode, p9.l, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object respondBytes$default(ApplicationCall applicationCall, ContentType contentType, HttpStatusCode httpStatusCode, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            contentType = null;
        }
        if ((i10 & 2) != 0) {
            httpStatusCode = null;
        }
        return respondBytes(applicationCall, contentType, httpStatusCode, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t respondBytes$lambda$1(OutgoingContent outgoingContent) {
        kotlin.jvm.internal.p.i(outgoingContent, "<this>");
        return t.f7040a;
    }

    public static final Object respondBytesWriter(ApplicationCall applicationCall, ContentType contentType, HttpStatusCode httpStatusCode, Long l10, p<? super ByteWriteChannel, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM;
        if (contentType == null) {
            contentType = ContentType.Application.INSTANCE.getOctetStream();
        }
        ChannelWriterContent channelWriterContent = new ChannelWriterContent(pVar, contentType, httpStatusCode, l10);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(ChannelWriterContent.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(ChannelWriterContent.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        Object objRespond = applicationCall.respond(channelWriterContent, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    public static /* synthetic */ Object respondBytesWriter$default(ApplicationCall applicationCall, ContentType contentType, HttpStatusCode httpStatusCode, Long l10, p pVar, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            contentType = null;
        }
        if ((i10 & 2) != 0) {
            httpStatusCode = null;
        }
        if ((i10 & 4) != 0) {
            l10 = null;
        }
        return respondBytesWriter(applicationCall, contentType, httpStatusCode, l10, pVar, interfaceC4014c);
    }

    public static final /* synthetic */ <T> Object respondNullable(ApplicationCall applicationCall, HttpStatusCode httpStatusCode, T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        applicationCall.getResponse().status(httpStatusCode);
        kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
        try {
            kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        applicationCall.respond(t10, typeInfo, interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }

    public static final Object respondRedirect(ApplicationCall applicationCall, String str, boolean z10, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM;
        ResponseHeaders.append$default(applicationCall.getResponse().getHeaders(), HttpHeaders.INSTANCE.getLocation(), str, false, 4, null);
        HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
        HttpStatusCode movedPermanently = z10 ? companion.getMovedPermanently() : companion.getFound();
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(HttpStatusCode.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(HttpStatusCode.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        Object objRespond = applicationCall.respond(movedPermanently, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    private static final Object respondRedirect$$forInline(ApplicationCall applicationCall, boolean z10, InterfaceC5074l<? super URLBuilder, t> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        URLBuilder uRLBuilderCreateFromCall = URLBuilderKt.createFromCall(URLBuilder.INSTANCE, applicationCall);
        interfaceC5074l.invoke(uRLBuilderCreateFromCall);
        String strBuildString = uRLBuilderCreateFromCall.buildString();
        n.c(0);
        respondRedirect(applicationCall, strBuildString, z10, interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }

    public static /* synthetic */ Object respondRedirect$default(ApplicationCall applicationCall, String str, boolean z10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return respondRedirect(applicationCall, str, z10, (InterfaceC4014c<? super t>) interfaceC4014c);
    }

    public static final Object respondSource(ApplicationCall applicationCall, InterfaceC4084k interfaceC4084k, ContentType contentType, HttpStatusCode httpStatusCode, Long l10, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM = null;
        ChannelWriterContent channelWriterContent = new ChannelWriterContent(new AnonymousClass2(interfaceC4084k, null), contentType, httpStatusCode, l10);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(ChannelWriterContent.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(ChannelWriterContent.class);
        } catch (Throwable unused) {
        }
        Object objRespond = applicationCall.respond(channelWriterContent, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    public static /* synthetic */ Object respondSource$default(ApplicationCall applicationCall, InterfaceC4084k interfaceC4084k, ContentType contentType, HttpStatusCode httpStatusCode, Long l10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            contentType = null;
        }
        if ((i10 & 4) != 0) {
            httpStatusCode = null;
        }
        if ((i10 & 8) != 0) {
            l10 = null;
        }
        return respondSource(applicationCall, interfaceC4084k, contentType, httpStatusCode, l10, interfaceC4014c);
    }

    public static final Object respondText(ApplicationCall applicationCall, String str, ContentType contentType, HttpStatusCode httpStatusCode, InterfaceC5074l<? super OutgoingContent, t> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM;
        TextContent textContent = new TextContent(str, defaultTextContentType(applicationCall, contentType), httpStatusCode);
        interfaceC5074l.invoke(textContent);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(TextContent.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(TextContent.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        Object objRespond = applicationCall.respond(textContent, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    public static /* synthetic */ Object respondText$default(ApplicationCall applicationCall, String str, ContentType contentType, HttpStatusCode httpStatusCode, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            contentType = null;
        }
        if ((i10 & 4) != 0) {
            httpStatusCode = null;
        }
        if ((i10 & 8) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.response.f
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ApplicationResponseFunctionsKt.respondText$lambda$0((OutgoingContent) obj2);
                }
            };
        }
        return respondText(applicationCall, str, contentType, httpStatusCode, interfaceC5074l, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t respondText$lambda$0(OutgoingContent outgoingContent) {
        kotlin.jvm.internal.p.i(outgoingContent, "<this>");
        return t.f7040a;
    }

    public static final /* synthetic */ <T> Object respondWithType(ApplicationCall applicationCall, HttpStatusCode httpStatusCode, T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        applicationCall.getResponse().status(httpStatusCode);
        kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
        try {
            kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        applicationCall.respond(t10, typeInfo, interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }

    public static /* synthetic */ Object respondBytes$default(ApplicationCall applicationCall, byte[] bArr, ContentType contentType, HttpStatusCode httpStatusCode, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            contentType = null;
        }
        if ((i10 & 4) != 0) {
            httpStatusCode = null;
        }
        if ((i10 & 8) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.server.response.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return ApplicationResponseFunctionsKt.respondBytes$lambda$1((OutgoingContent) obj2);
                }
            };
        }
        return respondBytes(applicationCall, bArr, contentType, httpStatusCode, interfaceC5074l, interfaceC4014c);
    }

    public static /* synthetic */ Object respondRedirect$default(ApplicationCall applicationCall, Url url, boolean z10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return respondRedirect(applicationCall, url, z10, (InterfaceC4014c<? super t>) interfaceC4014c);
    }

    public static final /* synthetic */ <T> Object respond(ApplicationCall applicationCall, T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
        try {
            kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        applicationCall.respond(t10, typeInfo, interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }

    public static /* synthetic */ Object respondRedirect$default(ApplicationCall applicationCall, boolean z10, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        URLBuilder uRLBuilderCreateFromCall = URLBuilderKt.createFromCall(URLBuilder.INSTANCE, applicationCall);
        interfaceC5074l.invoke(uRLBuilderCreateFromCall);
        String strBuildString = uRLBuilderCreateFromCall.buildString();
        n.c(0);
        respondRedirect(applicationCall, strBuildString, z10, (InterfaceC4014c<? super t>) interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }

    public static /* synthetic */ Object respondText$default(ApplicationCall applicationCall, ContentType contentType, HttpStatusCode httpStatusCode, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            contentType = null;
        }
        if ((i10 & 2) != 0) {
            httpStatusCode = null;
        }
        return respondText(applicationCall, contentType, httpStatusCode, interfaceC5074l, interfaceC4014c);
    }

    public static final /* synthetic */ <T> Object respondNullable(ApplicationCall applicationCall, T t10, InterfaceC4014c<? super t> interfaceC4014c) {
        kotlin.jvm.internal.p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Object.class);
        try {
            kotlin.jvm.internal.p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
        } catch (Throwable unused) {
        }
        TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
        n.c(0);
        applicationCall.respond(t10, typeInfo, interfaceC4014c);
        n.c(1);
        return t.f7040a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(3:12|26|27)(2:13|14))(1:15))(3:16|(0)|25)|19|28|20|23) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006f, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0081, code lost:
    
        if (r5.respond(r8, r2, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object respondText(io.ktor.server.application.ApplicationCall r5, io.ktor.http.ContentType r6, io.ktor.http.HttpStatusCode r7, p9.InterfaceC5074l<? super e9.InterfaceC4014c<? super java.lang.String>, ? extends java.lang.Object> r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.server.response.ApplicationResponseFunctionsKt.AnonymousClass3
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.server.response.ApplicationResponseFunctionsKt$respondText$3 r0 = (io.ktor.server.response.ApplicationResponseFunctionsKt.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.response.ApplicationResponseFunctionsKt$respondText$3 r0 = new io.ktor.server.response.ApplicationResponseFunctionsKt$respondText$3
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r9)
            goto L84
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$2
            r7 = r5
            io.ktor.http.HttpStatusCode r7 = (io.ktor.http.HttpStatusCode) r7
            java.lang.Object r5 = r0.L$1
            r6 = r5
            io.ktor.http.ContentType r6 = (io.ktor.http.ContentType) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.server.application.ApplicationCall r5 = (io.ktor.server.application.ApplicationCall) r5
            kotlin.C4849c.b(r9)
            goto L58
        L46:
            kotlin.C4849c.b(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r9 = r8.invoke(r0)
            if (r9 != r1) goto L58
            goto L83
        L58:
            java.lang.String r9 = (java.lang.String) r9
            io.ktor.http.ContentType r6 = defaultTextContentType(r5, r6)
            io.ktor.http.content.TextContent r8 = new io.ktor.http.content.TextContent
            r8.<init>(r9, r6, r7)
            java.lang.Class<io.ktor.http.content.TextContent> r6 = io.ktor.http.content.TextContent.class
            w9.d r7 = kotlin.jvm.internal.t.b(r6)
            r9 = 0
            w9.n r6 = kotlin.jvm.internal.t.m(r6)     // Catch: java.lang.Throwable -> L6f
            goto L70
        L6f:
            r6 = r9
        L70:
            io.ktor.util.reflect.TypeInfo r2 = new io.ktor.util.reflect.TypeInfo
            r2.<init>(r7, r6)
            r0.L$0 = r9
            r0.L$1 = r9
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r5 = r5.respond(r8, r2, r0)
            if (r5 != r1) goto L84
        L83:
            return r1
        L84:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.response.ApplicationResponseFunctionsKt.respondText(io.ktor.server.application.ApplicationCall, io.ktor.http.ContentType, io.ktor.http.HttpStatusCode, p9.l, e9.c):java.lang.Object");
    }

    public static final Object respondBytes(ApplicationCall applicationCall, byte[] bArr, ContentType contentType, HttpStatusCode httpStatusCode, InterfaceC5074l<? super OutgoingContent, t> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        InterfaceC5755n interfaceC5755nM;
        ByteArrayContent byteArrayContent = new ByteArrayContent(bArr, contentType, httpStatusCode);
        interfaceC5074l.invoke(byteArrayContent);
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(ByteArrayContent.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(ByteArrayContent.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        Object objRespond = applicationCall.respond(byteArrayContent, new TypeInfo(interfaceC5745dB, interfaceC5755nM), interfaceC4014c);
        return objRespond == C4063a.g() ? objRespond : t.f7040a;
    }

    public static final Object respondRedirect(ApplicationCall applicationCall, Url url, boolean z10, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objRespondRedirect = respondRedirect(applicationCall, url.getUrlString(), z10, interfaceC4014c);
        return objRespondRedirect == C4063a.g() ? objRespondRedirect : t.f7040a;
    }

    public static final Object respondRedirect(ApplicationCall applicationCall, boolean z10, InterfaceC5074l<? super URLBuilder, t> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        URLBuilder uRLBuilderCreateFromCall = URLBuilderKt.createFromCall(URLBuilder.INSTANCE, applicationCall);
        interfaceC5074l.invoke(uRLBuilderCreateFromCall);
        Object objRespondRedirect = respondRedirect(applicationCall, uRLBuilderCreateFromCall.buildString(), z10, interfaceC4014c);
        return objRespondRedirect == C4063a.g() ? objRespondRedirect : t.f7040a;
    }
}
