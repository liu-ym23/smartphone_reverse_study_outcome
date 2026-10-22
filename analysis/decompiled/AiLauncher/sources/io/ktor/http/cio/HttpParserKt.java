package io.ktor.http.cio;

import La.H;
import Z8.C1173v;
import Z8.F;
import Z8.Y;
import com.fasterxml.jackson.core.JsonPointer;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.HttpMethod;
import io.ktor.http.cio.internals.AsciiCharTree;
import io.ktor.http.cio.internals.CharArrayBuilder;
import io.ktor.http.cio.internals.CharsKt;
import io.ktor.http.cio.internals.MutableRange;
import io.ktor.http.cio.internals.TokenizerKt;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.LineEndingMode;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0011\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\b\u0010\u0004\u001a,\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\b\u0010\r\u001a\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0016\u001a\u001f\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002¢\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\"\u0010#\u001a/\u0010)\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b)\u0010*\u001a\u001f\u0010+\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010-\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010/\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b/\u00100\u001a\u0017\u00101\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b1\u00102\u001a\u0017\u00104\u001a\u00020(2\u0006\u00103\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u00105\"\u0014\u00106\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107\"\u0014\u00108\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00107\"\u0014\u00109\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00107\"\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020&0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<\" \u0010>\u001a\u00020=8\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b>\u00107\u0012\u0004\bA\u0010B\u001a\u0004\b?\u0010@\"\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/http/cio/Request;", "parseRequest", "(Lio/ktor/utils/io/ByteReadChannel;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/cio/Response;", "parseResponse", "Lio/ktor/http/cio/HttpHeadersMap;", "parseHeaders", "Lio/ktor/http/cio/internals/CharArrayBuilder;", "builder", "Lio/ktor/http/cio/internals/MutableRange;", "range", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/cio/internals/CharArrayBuilder;Lio/ktor/http/cio/internals/MutableRange;Le9/c;)Ljava/lang/Object;", "", "host", "LY8/t;", "validateHostHeader", "(Ljava/lang/CharSequence;)V", "text", "Lio/ktor/http/HttpMethod;", "parseHttpMethod", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)Lio/ktor/http/HttpMethod;", "parseHttpMethodFull", "parseUri", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)Ljava/lang/CharSequence;", "parseVersion", "", "parseStatusCode", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)I", "code", "", "statusOutOfRange", "(I)Z", "parseHeaderName", "(Lio/ktor/http/cio/internals/CharArrayBuilder;Lio/ktor/http/cio/internals/MutableRange;)I", "index", "start", "", "ch", "", "parseHeaderNameFailed", "(Lio/ktor/http/cio/internals/CharArrayBuilder;IIC)Ljava/lang/Void;", "parseHeaderValue", "(Lio/ktor/http/cio/internals/CharArrayBuilder;Lio/ktor/http/cio/internals/MutableRange;)V", "noColonFound", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)Ljava/lang/Void;", "characterIsNotAllowed", "(Ljava/lang/CharSequence;C)Ljava/lang/Void;", "isDelimiter", "(C)Z", "result", "unsupportedHttpVersion", "(Ljava/lang/CharSequence;)Ljava/lang/Void;", "HTTP_LINE_LIMIT", "I", "HTTP_STATUS_CODE_MIN_RANGE", "HTTP_STATUS_CODE_MAX_RANGE", "", "hostForbiddenSymbols", "Ljava/util/Set;", "Lio/ktor/utils/io/LineEndingMode;", "httpLineEndings", "getHttpLineEndings", "()I", "getHttpLineEndings$annotations", "()V", "Lio/ktor/http/cio/internals/AsciiCharTree;", "", "versions", "Lio/ktor/http/cio/internals/AsciiCharTree;", "ktor-http-cio"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpParserKt {
    private static final int HTTP_LINE_LIMIT = 8192;
    private static final int HTTP_STATUS_CODE_MAX_RANGE = 999;
    private static final int HTTP_STATUS_CODE_MIN_RANGE = 100;
    private static final Set<Character> hostForbiddenSymbols = Y.j(Character.valueOf(JsonPointer.SEPARATOR), '?', '#', '@');
    private static final int httpLineEndings;
    private static final AsciiCharTree<String> versions;

    @InterfaceC4112d(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", l = {106}, m = "parseHeaders")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.HttpParserKt$parseHeaders$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return HttpParserKt.parseHeaders(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", l = {122}, m = "parseHeaders")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.HttpParserKt$parseHeaders$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseHeaders(null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", l = {45, 60}, m = "parseRequest")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.HttpParserKt$parseRequest$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42881 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C42881(InterfaceC4014c<? super C42881> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseRequest(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", l = {81, 90}, m = "parseResponse")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.http.cio.HttpParserKt$parseResponse$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42891 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C42891(InterfaceC4014c<? super C42891> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseResponse(null, this);
        }
    }

    static {
        LineEndingMode.Companion companion = LineEndingMode.INSTANCE;
        httpLineEndings = LineEndingMode.m208plus1TerO4(companion.m213getCRLFf0jXZW8(), companion.m214getLFf0jXZW8());
        versions = AsciiCharTree.INSTANCE.build(C1173v.p("HTTP/1.0", "HTTP/1.1"));
    }

    private static final Void characterIsNotAllowed(CharSequence charSequence, char c10) {
        throw new ParserException("Character with code " + (c10 & 255) + " is not allowed in header names, \n" + ((Object) charSequence));
    }

    public static final int getHttpLineEndings() {
        return httpLineEndings;
    }

    public static /* synthetic */ void getHttpLineEndings$annotations() {
    }

    private static final boolean isDelimiter(char c10) {
        return p.k(c10, 32) <= 0 || H.f0("\"(),/:;<=>?@[\\]{}", c10, false, 2, null);
    }

    private static final Void noColonFound(CharSequence charSequence, MutableRange mutableRange) {
        throw new ParserException("No colon in HTTP header in " + charSequence.subSequence(mutableRange.getStart(), mutableRange.getEnd()).toString() + " in builder: \n" + ((Object) charSequence));
    }

    public static final int parseHeaderName(CharArrayBuilder text, MutableRange range) {
        p.i(text, "text");
        p.i(range, "range");
        int end = range.getEnd();
        for (int start = range.getStart(); start < end; start++) {
            char cCharAt = text.charAt(start);
            if (cCharAt == ':' && start != range.getStart()) {
                range.setStart(start + 1);
                return start;
            }
            if (isDelimiter(cCharAt)) {
                parseHeaderNameFailed(text, start, range.getStart(), cCharAt);
                throw new KotlinNothingValueException();
            }
        }
        noColonFound(text, range);
        throw new KotlinNothingValueException();
    }

    private static final Void parseHeaderNameFailed(CharArrayBuilder charArrayBuilder, int i10, int i11, char c10) {
        if (c10 == ':') {
            throw new ParserException("Empty header names are not allowed as per RFC7230.");
        }
        if (i10 == i11) {
            throw new ParserException("Multiline headers via line folding is not supported since it is deprecated as per RFC7230.");
        }
        characterIsNotAllowed(charArrayBuilder, c10);
        throw new KotlinNothingValueException();
    }

    public static final void parseHeaderValue(CharArrayBuilder text, MutableRange range) {
        p.i(text, "text");
        p.i(range, "range");
        int start = range.getStart();
        int end = range.getEnd();
        int iSkipSpacesAndHorizontalTabs = TokenizerKt.skipSpacesAndHorizontalTabs(text, start, end);
        if (iSkipSpacesAndHorizontalTabs >= end) {
            range.setStart(end);
            return;
        }
        int i10 = iSkipSpacesAndHorizontalTabs;
        int i11 = i10;
        while (i10 < end) {
            char cCharAt = text.charAt(i10);
            if (cCharAt != '\t') {
                if (cCharAt == '\n' || cCharAt == '\r') {
                    characterIsNotAllowed(text, cCharAt);
                    throw new KotlinNothingValueException();
                }
                if (cCharAt != ' ') {
                    i11 = i10;
                }
            }
            i10++;
        }
        range.setStart(iSkipSpacesAndHorizontalTabs);
        range.setEnd(i11 + 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object parseHeaders(io.ktor.utils.io.ByteReadChannel r7, e9.InterfaceC4014c<? super io.ktor.http.cio.HttpHeadersMap> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.http.cio.HttpParserKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.http.cio.HttpParserKt$parseHeaders$1 r0 = (io.ktor.http.cio.HttpParserKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            io.ktor.http.cio.HttpParserKt$parseHeaders$1 r0 = new io.ktor.http.cio.HttpParserKt$parseHeaders$1
            r0.<init>(r8)
            goto L12
        L1a:
            java.lang.Object r8 = r4.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r7 = r4.L$1
            io.ktor.http.cio.internals.CharArrayBuilder r7 = (io.ktor.http.cio.internals.CharArrayBuilder) r7
            java.lang.Object r0 = r4.L$0
            io.ktor.utils.io.ByteReadChannel r0 = (io.ktor.utils.io.ByteReadChannel) r0
            kotlin.C4849c.b(r8)
            goto L5b
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            kotlin.C4849c.b(r8)
            r8 = r2
            io.ktor.http.cio.internals.CharArrayBuilder r2 = new io.ktor.http.cio.internals.CharArrayBuilder
            r1 = 0
            r2.<init>(r1, r8, r1)
            java.lang.Object r1 = g9.h.a(r7)
            r4.L$0 = r1
            r4.L$1 = r2
            r4.label = r8
            r3 = 0
            r5 = 4
            r6 = 0
            r1 = r7
            java.lang.Object r8 = parseHeaders$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L5a
            return r0
        L5a:
            r7 = r2
        L5b:
            io.ktor.http.cio.HttpHeadersMap r8 = (io.ktor.http.cio.HttpHeadersMap) r8
            if (r8 != 0) goto L64
            io.ktor.http.cio.HttpHeadersMap r8 = new io.ktor.http.cio.HttpHeadersMap
            r8.<init>(r7)
        L64:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseHeaders(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object parseHeaders$default(ByteReadChannel byteReadChannel, CharArrayBuilder charArrayBuilder, MutableRange mutableRange, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            mutableRange = new MutableRange(0, 0);
        }
        return parseHeaders(byteReadChannel, charArrayBuilder, mutableRange, interfaceC4014c);
    }

    private static final HttpMethod parseHttpMethod(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        HttpMethod httpMethod = (HttpMethod) F.Z0(AsciiCharTree.search$default(CharsKt.getDefaultHttpMethods(), charSequence, mutableRange.getStart(), mutableRange.getEnd(), false, new p9.p() { // from class: io.ktor.http.cio.k
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(HttpParserKt.parseHttpMethod$lambda$1(((Character) obj).charValue(), ((Integer) obj2).intValue()));
            }
        }, 8, null));
        if (httpMethod == null) {
            return parseHttpMethodFull(charSequence, mutableRange);
        }
        mutableRange.setStart(mutableRange.getStart() + httpMethod.getValue().length());
        return httpMethod;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseHttpMethod$lambda$1(char c10, int i10) {
        return c10 == ' ';
    }

    private static final HttpMethod parseHttpMethodFull(CharSequence charSequence, MutableRange mutableRange) {
        return new HttpMethod(TokenizerKt.nextToken(charSequence, mutableRange).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098 A[Catch: all -> 0x0065, TryCatch #0 {all -> 0x0065, blocks: (B:20:0x0061, B:29:0x008f, B:32:0x0098, B:34:0x00a9, B:36:0x00c2, B:38:0x00c8, B:40:0x00ce, B:51:0x00ff, B:52:0x0106, B:53:0x0107, B:54:0x010e, B:55:0x010f, B:56:0x0135, B:25:0x0079), top: B:60:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6 A[Catch: all -> 0x00fc, TRY_LEAVE, TryCatch #2 {all -> 0x00fc, blocks: (B:44:0x00f0, B:47:0x00f6), top: B:63:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x008c -> B:29:0x008f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object parseRequest(io.ktor.utils.io.ByteReadChannel r14, e9.InterfaceC4014c<? super io.ktor.http.cio.Request> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseRequest(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #1 {all -> 0x0064, blocks: (B:20:0x0060, B:29:0x008f, B:32:0x0098), top: B:50:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e3 A[Catch: all -> 0x00ea, TryCatch #3 {all -> 0x00ea, blocks: (B:36:0x00df, B:38:0x00e3, B:42:0x00ee), top: B:54:0x00df }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object parseResponse(io.ktor.utils.io.ByteReadChannel r14, e9.InterfaceC4014c<? super io.ktor.http.cio.Response> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseResponse(io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007d, code lost:
    
        r7.setStart(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0080, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int parseStatusCode(java.lang.CharSequence r6, io.ktor.http.cio.internals.MutableRange r7) {
        /*
            io.ktor.http.cio.internals.TokenizerKt.skipSpaces(r6, r7)
            int r0 = r7.getEnd()
            int r1 = r7.getStart()
            int r2 = r7.getEnd()
            r3 = 0
        L10:
            if (r1 >= r2) goto L7d
            char r4 = r6.charAt(r1)
            r5 = 32
            if (r4 != r5) goto L3e
            boolean r6 = statusOutOfRange(r3)
            if (r6 != 0) goto L22
            r0 = r1
            goto L7d
        L22:
            io.ktor.http.cio.ParserException r6 = new io.ktor.http.cio.ParserException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Status-code must be 3-digit. Status received: "
            r7.append(r0)
            r7.append(r3)
            r0 = 46
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L3e:
            r5 = 48
            if (r5 > r4) goto L4e
            r5 = 58
            if (r4 >= r5) goto L4e
            int r3 = r3 * 10
            int r4 = r4 + (-48)
            int r3 = r3 + r4
            int r1 = r1 + 1
            goto L10
        L4e:
            int r0 = r7.getStart()
            int r7 = io.ktor.http.cio.internals.TokenizerKt.findSpaceOrEnd(r6, r7)
            java.lang.CharSequence r6 = r6.subSequence(r0, r7)
            java.lang.String r6 = r6.toString()
            java.lang.NumberFormatException r7 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Illegal digit "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = " in status code "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6)
            throw r7
        L7d:
            r7.setStart(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseStatusCode(java.lang.CharSequence, io.ktor.http.cio.internals.MutableRange):int");
    }

    private static final CharSequence parseUri(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        int start = mutableRange.getStart();
        int iFindSpaceOrEnd = TokenizerKt.findSpaceOrEnd(charSequence, mutableRange);
        int i10 = iFindSpaceOrEnd - start;
        if (i10 <= 0) {
            return "";
        }
        if (i10 == 1 && charSequence.charAt(start) == '/') {
            mutableRange.setStart(iFindSpaceOrEnd);
            return "/";
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(start, iFindSpaceOrEnd);
        mutableRange.setStart(iFindSpaceOrEnd);
        return charSequenceSubSequence;
    }

    private static final CharSequence parseVersion(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        if (mutableRange.getStart() >= mutableRange.getEnd()) {
            throw new IllegalStateException(("Failed to parse version: " + ((Object) charSequence)).toString());
        }
        String str = (String) F.Z0(AsciiCharTree.search$default(versions, charSequence, mutableRange.getStart(), mutableRange.getEnd(), false, new p9.p() { // from class: io.ktor.http.cio.l
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(HttpParserKt.parseVersion$lambda$3(((Character) obj).charValue(), ((Integer) obj2).intValue()));
            }
        }, 8, null));
        if (str != null) {
            mutableRange.setStart(mutableRange.getStart() + str.length());
            return str;
        }
        unsupportedHttpVersion(TokenizerKt.nextToken(charSequence, mutableRange));
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseVersion$lambda$3(char c10, int i10) {
        return c10 == ' ';
    }

    private static final boolean statusOutOfRange(int i10) {
        return i10 < 100 || i10 > 999;
    }

    private static final Void unsupportedHttpVersion(CharSequence charSequence) {
        throw new ParserException("Unsupported HTTP version: " + ((Object) charSequence));
    }

    private static final void validateHostHeader(CharSequence charSequence) {
        if (H.k0(charSequence, ServerSentEventKt.COLON, false, 2, null)) {
            throw new ParserException("Host header with ':' should contains port: " + ((Object) charSequence));
        }
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            Set<Character> set = hostForbiddenSymbols;
            if (set.contains(Character.valueOf(cCharAt))) {
                throw new ParserException("Host cannot contain any of the following symbols: " + set);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074 A[Catch: all -> 0x0079, TryCatch #2 {all -> 0x0079, blocks: (B:23:0x006c, B:25:0x0074, B:29:0x007c, B:32:0x0090, B:33:0x00b0, B:34:0x00b7, B:35:0x00b8, B:37:0x00c4), top: B:47:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c A[Catch: all -> 0x0079, TryCatch #2 {all -> 0x0079, blocks: (B:23:0x006c, B:25:0x0074, B:29:0x007c, B:32:0x0090, B:33:0x00b0, B:34:0x00b7, B:35:0x00b8, B:37:0x00c4), top: B:47:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0068 -> B:47:0x006c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object parseHeaders(io.ktor.utils.io.ByteReadChannel r10, io.ktor.http.cio.internals.CharArrayBuilder r11, io.ktor.http.cio.internals.MutableRange r12, e9.InterfaceC4014c<? super io.ktor.http.cio.HttpHeadersMap> r13) throws java.lang.Throwable {
        /*
            boolean r0 = r13 instanceof io.ktor.http.cio.HttpParserKt.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r13
            io.ktor.http.cio.HttpParserKt$parseHeaders$2 r0 = (io.ktor.http.cio.HttpParserKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.http.cio.HttpParserKt$parseHeaders$2 r0 = new io.ktor.http.cio.HttpParserKt$parseHeaders$2
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 8192(0x2000, float:1.148E-41)
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 != r4) goto L45
            java.lang.Object r10 = r0.L$3
            io.ktor.http.cio.HttpHeadersMap r10 = (io.ktor.http.cio.HttpHeadersMap) r10
            java.lang.Object r11 = r0.L$2
            io.ktor.http.cio.internals.MutableRange r11 = (io.ktor.http.cio.internals.MutableRange) r11
            java.lang.Object r12 = r0.L$1
            io.ktor.http.cio.internals.CharArrayBuilder r12 = (io.ktor.http.cio.internals.CharArrayBuilder) r12
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L42
            r9 = r0
            r0 = r10
            r10 = r2
            r2 = r9
            r9 = r12
            r12 = r11
            r11 = r9
            goto L6c
        L42:
            r11 = move-exception
            goto Lca
        L45:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L4d:
            kotlin.C4849c.b(r13)
            io.ktor.http.cio.HttpHeadersMap r13 = new io.ktor.http.cio.HttpHeadersMap
            r13.<init>(r11)
        L55:
            int r2 = io.ktor.http.cio.HttpParserKt.httpLineEndings     // Catch: java.lang.Throwable -> Lc8
            r0.L$0 = r10     // Catch: java.lang.Throwable -> Lc8
            r0.L$1 = r11     // Catch: java.lang.Throwable -> Lc8
            r0.L$2 = r12     // Catch: java.lang.Throwable -> Lc8
            r0.L$3 = r13     // Catch: java.lang.Throwable -> Lc8
            r0.label = r4     // Catch: java.lang.Throwable -> Lc8
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannelOperationsKt.m200readUTF8LineToRRvyBJ8(r10, r11, r3, r2, r0)     // Catch: java.lang.Throwable -> Lc8
            if (r2 != r1) goto L68
            return r1
        L68:
            r9 = r0
            r0 = r13
            r13 = r2
            r2 = r9
        L6c:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch: java.lang.Throwable -> L79
            boolean r13 = r13.booleanValue()     // Catch: java.lang.Throwable -> L79
            if (r13 != 0) goto L7c
            r0.release()     // Catch: java.lang.Throwable -> L79
            r10 = 0
            return r10
        L79:
            r11 = move-exception
            r10 = r0
            goto Lca
        L7c:
            int r13 = r11.length()     // Catch: java.lang.Throwable -> L79
            r12.setEnd(r13)     // Catch: java.lang.Throwable -> L79
            int r13 = r12.getEnd()     // Catch: java.lang.Throwable -> L79
            int r5 = r12.getStart()     // Catch: java.lang.Throwable -> L79
            int r13 = r13 - r5
            if (r13 == 0) goto Lb8
            if (r13 >= r3) goto Lb0
            int r13 = r12.getStart()     // Catch: java.lang.Throwable -> L79
            int r5 = parseHeaderName(r11, r12)     // Catch: java.lang.Throwable -> L79
            int r6 = r12.getEnd()     // Catch: java.lang.Throwable -> L79
            parseHeaderValue(r11, r12)     // Catch: java.lang.Throwable -> L79
            int r7 = r12.getStart()     // Catch: java.lang.Throwable -> L79
            int r8 = r12.getEnd()     // Catch: java.lang.Throwable -> L79
            r12.setStart(r6)     // Catch: java.lang.Throwable -> L79
            r0.put(r13, r5, r7, r8)     // Catch: java.lang.Throwable -> L79
            r13 = r0
            r0 = r2
            goto L55
        Lb0:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L79
            java.lang.String r11 = "Header line length limit exceeded"
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L79
            throw r10     // Catch: java.lang.Throwable -> L79
        Lb8:
            io.ktor.http.HttpHeaders r10 = io.ktor.http.HttpHeaders.INSTANCE     // Catch: java.lang.Throwable -> L79
            java.lang.String r10 = r10.getHost()     // Catch: java.lang.Throwable -> L79
            java.lang.CharSequence r10 = r0.get(r10)     // Catch: java.lang.Throwable -> L79
            if (r10 == 0) goto Lc7
            validateHostHeader(r10)     // Catch: java.lang.Throwable -> L79
        Lc7:
            return r0
        Lc8:
            r11 = move-exception
            r10 = r13
        Lca:
            r10.release()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseHeaders(io.ktor.utils.io.ByteReadChannel, io.ktor.http.cio.internals.CharArrayBuilder, io.ktor.http.cio.internals.MutableRange, e9.c):java.lang.Object");
    }
}
