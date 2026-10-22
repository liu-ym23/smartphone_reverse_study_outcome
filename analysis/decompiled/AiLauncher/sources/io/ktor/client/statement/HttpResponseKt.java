package io.ktor.client.statement;

import La.C0953c;
import Ua.C1086v0;
import Ua.InterfaceC1089x;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.request.HttpRequest;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.InternalAPI;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\"\u0010\b\u001a\u00020\u0007*\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0086@¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000e\u0010\f\"\u001e\u0010\u0012\u001a\u00020\n*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0016\u001a\u00020\u0013*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "LY8/t;", "complete", "(Lio/ktor/client/statement/HttpResponse;)V", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "fallbackCharset", "", "bodyAsText", "(Lio/ktor/client/statement/HttpResponse;Ljava/nio/charset/Charset;Le9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "bodyAsChannel", "(Lio/ktor/client/statement/HttpResponse;Le9/c;)Ljava/lang/Object;", "", "bodyAsBytes", "getContent", "(Lio/ktor/client/statement/HttpResponse;)Lio/ktor/utils/io/ByteReadChannel;", "getContent$annotations", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lio/ktor/client/request/HttpRequest;", "getRequest", "(Lio/ktor/client/statement/HttpResponse;)Lio/ktor/client/request/HttpRequest;", "request", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpResponseKt {

    @InterfaceC4112d(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", l = {147}, m = "bodyAsBytes")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.statement.HttpResponseKt$bodyAsBytes$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpResponseKt.bodyAsBytes(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", l = {147}, m = "bodyAsChannel")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.statement.HttpResponseKt$bodyAsChannel$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42701 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C42701(InterfaceC4014c<? super C42701> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpResponseKt.bodyAsChannel(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", l = {147}, m = "bodyAsText")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.statement.HttpResponseKt$bodyAsText$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42711 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C42711(InterfaceC4014c<? super C42711> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpResponseKt.bodyAsText(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object bodyAsBytes(io.ktor.client.statement.HttpResponse r6, e9.InterfaceC4014c<? super byte[]> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.client.statement.HttpResponseKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.client.statement.HttpResponseKt$bodyAsBytes$1 r0 = (io.ktor.client.statement.HttpResponseKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpResponseKt$bodyAsBytes$1 r0 = new io.ktor.client.statement.HttpResponseKt$bodyAsBytes$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$1
            io.ktor.client.statement.HttpResponse r6 = (io.ktor.client.statement.HttpResponse) r6
            java.lang.Object r6 = r0.L$0
            io.ktor.client.statement.HttpResponse r6 = (io.ktor.client.statement.HttpResponse) r6
            kotlin.C4849c.b(r7)
            goto L69
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.C4849c.b(r7)
            io.ktor.client.call.HttpClientCall r7 = r6.getCall()
            java.lang.Class<byte[]> r2 = byte[].class
            w9.d r4 = kotlin.jvm.internal.t.b(r2)
            w9.n r2 = kotlin.jvm.internal.t.m(r2)     // Catch: java.lang.Throwable -> L4b
            goto L4c
        L4b:
            r2 = 0
        L4c:
            io.ktor.util.reflect.TypeInfo r5 = new io.ktor.util.reflect.TypeInfo
            r5.<init>(r4, r2)
            java.lang.Object r2 = g9.h.a(r6)
            r0.L$0 = r2
            java.lang.Object r6 = g9.h.a(r6)
            r0.L$1 = r6
            r6 = 0
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.bodyNullable(r5, r0)
            if (r7 != r1) goto L69
            return r1
        L69:
            if (r7 == 0) goto L6e
            byte[] r7 = (byte[]) r7
            return r7
        L6e:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.ByteArray"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpResponseKt.bodyAsBytes(io.ktor.client.statement.HttpResponse, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object bodyAsChannel(io.ktor.client.statement.HttpResponse r6, e9.InterfaceC4014c<? super io.ktor.utils.io.ByteReadChannel> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.client.statement.HttpResponseKt.C42701
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.client.statement.HttpResponseKt$bodyAsChannel$1 r0 = (io.ktor.client.statement.HttpResponseKt.C42701) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpResponseKt$bodyAsChannel$1 r0 = new io.ktor.client.statement.HttpResponseKt$bodyAsChannel$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$1
            io.ktor.client.statement.HttpResponse r6 = (io.ktor.client.statement.HttpResponse) r6
            java.lang.Object r6 = r0.L$0
            io.ktor.client.statement.HttpResponse r6 = (io.ktor.client.statement.HttpResponse) r6
            kotlin.C4849c.b(r7)
            goto L69
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.C4849c.b(r7)
            io.ktor.client.call.HttpClientCall r7 = r6.getCall()
            java.lang.Class<io.ktor.utils.io.ByteReadChannel> r2 = io.ktor.utils.io.ByteReadChannel.class
            w9.d r4 = kotlin.jvm.internal.t.b(r2)
            w9.n r2 = kotlin.jvm.internal.t.m(r2)     // Catch: java.lang.Throwable -> L4b
            goto L4c
        L4b:
            r2 = 0
        L4c:
            io.ktor.util.reflect.TypeInfo r5 = new io.ktor.util.reflect.TypeInfo
            r5.<init>(r4, r2)
            java.lang.Object r2 = g9.h.a(r6)
            r0.L$0 = r2
            java.lang.Object r6 = g9.h.a(r6)
            r0.L$1 = r6
            r6 = 0
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.bodyNullable(r5, r0)
            if (r7 != r1) goto L69
            return r1
        L69:
            if (r7 == 0) goto L6e
            io.ktor.utils.io.ByteReadChannel r7 = (io.ktor.utils.io.ByteReadChannel) r7
            return r7
        L6e:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type io.ktor.utils.io.ByteReadChannel"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpResponseKt.bodyAsChannel(io.ktor.client.statement.HttpResponse, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object bodyAsText(io.ktor.client.statement.HttpResponse r10, java.nio.charset.Charset r11, e9.InterfaceC4014c<? super java.lang.String> r12) throws java.lang.Throwable {
        /*
            boolean r0 = r12 instanceof io.ktor.client.statement.HttpResponseKt.C42711
            if (r0 == 0) goto L13
            r0 = r12
            io.ktor.client.statement.HttpResponseKt$bodyAsText$1 r0 = (io.ktor.client.statement.HttpResponseKt.C42711) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpResponseKt$bodyAsText$1 r0 = new io.ktor.client.statement.HttpResponseKt$bodyAsText$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 != r5) goto L3f
            java.lang.Object r10 = r0.L$4
            io.ktor.client.statement.HttpResponse r10 = (io.ktor.client.statement.HttpResponse) r10
            java.lang.Object r10 = r0.L$3
            java.nio.charset.CharsetDecoder r10 = (java.nio.charset.CharsetDecoder) r10
            java.lang.Object r11 = r0.L$2
            java.nio.charset.Charset r11 = (java.nio.charset.Charset) r11
            java.lang.Object r11 = r0.L$1
            java.nio.charset.Charset r11 = (java.nio.charset.Charset) r11
            java.lang.Object r11 = r0.L$0
            io.ktor.client.statement.HttpResponse r11 = (io.ktor.client.statement.HttpResponse) r11
            kotlin.C4849c.b(r12)
            goto L90
        L3f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L47:
            kotlin.C4849c.b(r12)
            java.nio.charset.Charset r12 = io.ktor.http.HttpMessagePropertiesKt.charset(r10)
            if (r12 != 0) goto L51
            r12 = r11
        L51:
            java.nio.charset.CharsetDecoder r2 = r12.newDecoder()
            io.ktor.client.call.HttpClientCall r6 = r10.getCall()
            java.lang.Class<fb.v> r7 = fb.v.class
            w9.d r8 = kotlin.jvm.internal.t.b(r7)
            w9.n r7 = kotlin.jvm.internal.t.m(r7)     // Catch: java.lang.Throwable -> L64
            goto L65
        L64:
            r7 = r3
        L65:
            io.ktor.util.reflect.TypeInfo r9 = new io.ktor.util.reflect.TypeInfo
            r9.<init>(r8, r7)
            java.lang.Object r7 = g9.h.a(r10)
            r0.L$0 = r7
            java.lang.Object r11 = g9.h.a(r11)
            r0.L$1 = r11
            java.lang.Object r11 = g9.h.a(r12)
            r0.L$2 = r11
            r0.L$3 = r2
            java.lang.Object r10 = g9.h.a(r10)
            r0.L$4 = r10
            r0.I$0 = r4
            r0.label = r5
            java.lang.Object r12 = r6.bodyNullable(r9, r0)
            if (r12 != r1) goto L8f
            return r1
        L8f:
            r10 = r2
        L90:
            if (r12 == 0) goto L9d
            fb.v r12 = (fb.v) r12
            kotlin.jvm.internal.p.f(r10)
            r11 = 2
            java.lang.String r10 = io.ktor.utils.io.charsets.EncodingKt.decode$default(r10, r12, r4, r11, r3)
            return r10
        L9d:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException
            java.lang.String r11 = "null cannot be cast to non-null type kotlinx.io.Source"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpResponseKt.bodyAsText(io.ktor.client.statement.HttpResponse, java.nio.charset.Charset, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object bodyAsText$default(HttpResponse httpResponse, Charset charset, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = C0953c.UTF_8;
        }
        return bodyAsText(httpResponse, charset, interfaceC4014c);
    }

    @InternalAPI
    public static final void complete(HttpResponse httpResponse) {
        p.i(httpResponse, "<this>");
        g gVarO = C1086v0.o(httpResponse.getCoroutineContext());
        p.g(gVarO, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        ((InterfaceC1089x) gVarO).complete();
    }

    public static final ByteReadChannel getContent(HttpResponse httpResponse) {
        p.i(httpResponse, "<this>");
        return httpResponse.getRawContent();
    }

    @InternalAPI
    public static /* synthetic */ void getContent$annotations(HttpResponse httpResponse) {
    }

    public static final HttpRequest getRequest(HttpResponse httpResponse) {
        p.i(httpResponse, "<this>");
        return httpResponse.getCall().getRequest();
    }
}
