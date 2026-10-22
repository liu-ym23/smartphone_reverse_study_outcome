package io.ktor.serialization;

import La.C0953c;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\u0006\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002*\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0006\u0010\u0005\u001a6\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u00060\u0001j\u0002`\u0002H\u0087@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/http/Headers;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "defaultCharset", "suitableCharset", "(Lio/ktor/http/Headers;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "suitableCharsetOrNull", "", "Lio/ktor/serialization/ContentConverter;", "Lio/ktor/utils/io/ByteReadChannel;", "body", "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", HttpAuthHeader.Parameters.Charset, "", "deserialize", "(Ljava/util/List;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/util/reflect/TypeInfo;Ljava/nio/charset/Charset;Le9/c;)Ljava/lang/Object;", "ktor-serialization"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ContentConverterKt {

    @InterfaceC4112d(c = "io.ktor.serialization.ContentConverterKt", f = "ContentConverter.kt", l = {113}, m = "deserialize")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.serialization.ContentConverterKt$deserialize$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return ContentConverterKt.deserialize(null, null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @io.ktor.utils.io.InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object deserialize(java.util.List<? extends io.ktor.serialization.ContentConverter> r5, final io.ktor.utils.io.ByteReadChannel r6, final io.ktor.util.reflect.TypeInfo r7, final java.nio.charset.Charset r8, e9.InterfaceC4014c<java.lang.Object> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.serialization.ContentConverterKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.serialization.ContentConverterKt$deserialize$1 r0 = (io.ktor.serialization.ContentConverterKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.serialization.ContentConverterKt$deserialize$1 r0 = new io.ktor.serialization.ContentConverterKt$deserialize$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 != r4) goto L3c
            java.lang.Object r5 = r0.L$3
            java.nio.charset.Charset r5 = (java.nio.charset.Charset) r5
            java.lang.Object r5 = r0.L$2
            r7 = r5
            io.ktor.util.reflect.TypeInfo r7 = (io.ktor.util.reflect.TypeInfo) r7
            java.lang.Object r5 = r0.L$1
            r6 = r5
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.C4849c.b(r9)
            goto L71
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            kotlin.C4849c.b(r9)
            r9 = r5
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            Xa.b r9 = Xa.d.a(r9)
            io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1 r2 = new io.ktor.serialization.ContentConverterKt$deserialize$$inlined$map$1
            r2.<init>()
            io.ktor.serialization.ContentConverterKt$deserialize$result$2 r9 = new io.ktor.serialization.ContentConverterKt$deserialize$result$2
            r9.<init>(r6, r3)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            java.lang.Object r5 = g9.h.a(r8)
            r0.L$3 = r5
            r0.label = r4
            java.lang.Object r9 = Xa.d.A(r2, r9, r0)
            if (r9 != r1) goto L71
            return r1
        L71:
            if (r9 != 0) goto La1
            boolean r5 = r6.isClosedForRead()
            if (r5 != 0) goto L7a
            return r6
        L7a:
            w9.n r5 = r7.getKotlinType()
            if (r5 == 0) goto L89
            boolean r5 = r5.e()
            if (r5 != r4) goto L89
            io.ktor.http.content.NullBody r5 = io.ktor.http.content.NullBody.INSTANCE
            return r5
        L89:
            io.ktor.serialization.ContentConvertException r5 = new io.ktor.serialization.ContentConvertException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "No suitable converter found for "
            r6.append(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r7 = 2
            r5.<init>(r6, r3, r7, r3)
            throw r5
        La1:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.ContentConverterKt.deserialize(java.util.List, io.ktor.utils.io.ByteReadChannel, io.ktor.util.reflect.TypeInfo, java.nio.charset.Charset, e9.c):java.lang.Object");
    }

    public static final Charset suitableCharset(Headers headers, Charset defaultCharset) {
        p.i(headers, "<this>");
        p.i(defaultCharset, "defaultCharset");
        Charset charsetSuitableCharsetOrNull = suitableCharsetOrNull(headers, defaultCharset);
        return charsetSuitableCharsetOrNull == null ? defaultCharset : charsetSuitableCharsetOrNull;
    }

    public static /* synthetic */ Charset suitableCharset$default(Headers headers, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = C0953c.UTF_8;
        }
        return suitableCharset(headers, charset);
    }

    public static final Charset suitableCharsetOrNull(Headers headers, Charset defaultCharset) {
        p.i(headers, "<this>");
        p.i(defaultCharset, "defaultCharset");
        Iterator<HeaderValue> it = HttpHeaderValueParserKt.parseAndSortHeader(headers.get(HttpHeaders.INSTANCE.getAcceptCharset())).iterator();
        while (it.hasNext()) {
            String value = it.next().getValue();
            if (p.d(value, "*")) {
                return defaultCharset;
            }
            C0953c c0953c = C0953c.f4336a;
            if (CharsetJVMKt.isSupported(c0953c, value)) {
                return CharsetJVMKt.forName(c0953c, value);
            }
        }
        return null;
    }

    public static /* synthetic */ Charset suitableCharsetOrNull$default(Headers headers, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = C0953c.UTF_8;
        }
        return suitableCharsetOrNull(headers, charset);
    }
}
