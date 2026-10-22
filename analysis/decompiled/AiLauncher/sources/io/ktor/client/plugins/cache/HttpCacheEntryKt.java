package io.ktor.client.plugins.cache;

import La.C;
import La.D;
import La.H;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000@\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\u000e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"", "isShared", "Lio/ktor/client/statement/HttpResponse;", UxipConstants.f30685x, "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "HttpCacheEntry", "(ZLio/ktor/client/statement/HttpResponse;Le9/c;)Ljava/lang/Object;", "", "", "varyKeys", "(Lio/ktor/client/statement/HttpResponse;)Ljava/util/Map;", "Lkotlin/Function0;", "Lio/ktor/util/date/GMTDate;", "fallback", "cacheExpires", "(Lio/ktor/client/statement/HttpResponse;ZLp9/a;)Lio/ktor/util/date/GMTDate;", "Lio/ktor/http/Headers;", "responseHeaders", "Lio/ktor/client/request/HttpRequestBuilder;", "request", "Lio/ktor/client/plugins/cache/ValidateStatus;", "shouldValidate", "(Lio/ktor/util/date/GMTDate;Lio/ktor/http/Headers;Lio/ktor/client/request/HttpRequestBuilder;)Lio/ktor/client/plugins/cache/ValidateStatus;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpCacheEntryKt {

    @InterfaceC4112d(c = "io.ktor.client.plugins.cache.HttpCacheEntryKt", f = "HttpCacheEntry.kt", l = {17}, m = "HttpCacheEntry")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCacheEntryKt.HttpCacheEntry(false, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object HttpCacheEntry(boolean r4, io.ktor.client.statement.HttpResponse r5, e9.InterfaceC4014c<? super io.ktor.client.plugins.cache.HttpCacheEntry> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.client.plugins.cache.HttpCacheEntryKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1 r0 = (io.ktor.client.plugins.cache.HttpCacheEntryKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1 r0 = new io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            boolean r4 = r0.Z$0
            java.lang.Object r5 = r0.L$0
            io.ktor.client.statement.HttpResponse r5 = (io.ktor.client.statement.HttpResponse) r5
            kotlin.C4849c.b(r6)
            goto L4b
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.C4849c.b(r6)
            io.ktor.utils.io.ByteReadChannel r6 = r5.getRawContent()
            r0.L$0 = r5
            r0.Z$0 = r4
            r0.label = r3
            java.lang.Object r6 = io.ktor.utils.io.ByteReadChannelOperationsKt.readRemaining(r6, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            fb.v r6 = (fb.v) r6
            byte[] r6 = fb.x.c(r6)
            io.ktor.client.plugins.cache.HttpCacheEntry r0 = new io.ktor.client.plugins.cache.HttpCacheEntry
            r1 = 2
            r2 = 0
            io.ktor.util.date.GMTDate r4 = cacheExpires$default(r5, r4, r2, r1, r2)
            java.util.Map r1 = varyKeys(r5)
            r0.<init>(r4, r1, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheEntryKt.HttpCacheEntry(boolean, io.ktor.client.statement.HttpResponse, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final io.ktor.util.date.GMTDate cacheExpires(io.ktor.client.statement.HttpResponse r10, boolean r11, p9.InterfaceC5063a<io.ktor.util.date.GMTDate> r12) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.p.i(r10, r0)
            java.lang.String r0 = "fallback"
            kotlin.jvm.internal.p.i(r12, r0)
            java.util.List r0 = io.ktor.http.HttpMessagePropertiesKt.cacheControl(r10)
            r1 = 2
            r2 = 0
            r3 = 0
            if (r11 == 0) goto L41
            r11 = r0
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            boolean r4 = r11 instanceof java.util.Collection
            if (r4 == 0) goto L24
            r4 = r11
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L24
            goto L41
        L24:
            java.util.Iterator r11 = r11.iterator()
        L28:
            boolean r4 = r11.hasNext()
            if (r4 == 0) goto L41
            java.lang.Object r4 = r11.next()
            io.ktor.http.HeaderValue r4 = (io.ktor.http.HeaderValue) r4
            java.lang.String r4 = r4.getValue()
            java.lang.String r5 = "s-maxage"
            boolean r4 = La.D.X(r4, r5, r2, r1, r3)
            if (r4 == 0) goto L28
            goto L43
        L41:
            java.lang.String r5 = "max-age"
        L43:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r11 = r0.iterator()
        L49:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L61
            java.lang.Object r0 = r11.next()
            r4 = r0
            io.ktor.http.HeaderValue r4 = (io.ktor.http.HeaderValue) r4
            java.lang.String r4 = r4.getValue()
            boolean r4 = La.D.X(r4, r5, r2, r1, r3)
            if (r4 == 0) goto L49
            goto L62
        L61:
            r0 = r3
        L62:
            io.ktor.http.HeaderValue r0 = (io.ktor.http.HeaderValue) r0
            if (r0 == 0) goto L89
            java.lang.String r4 = r0.getValue()
            if (r4 == 0) goto L89
            java.lang.String r11 = "="
            java.lang.String[] r5 = new java.lang.String[]{r11}
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            java.util.List r11 = La.H.b1(r4, r5, r6, r7, r8, r9)
            if (r11 == 0) goto L89
            r0 = 1
            java.lang.Object r11 = Z8.F.t0(r11, r0)
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L89
            java.lang.Long r3 = La.C.y(r11)
        L89:
            if (r3 == 0) goto L9b
            io.ktor.util.date.GMTDate r10 = r10.getRequestTime()
            long r11 = r3.longValue()
            r0 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r0
            io.ktor.util.date.GMTDate r10 = io.ktor.util.date.DateKt.plus(r10, r11)
            return r10
        L9b:
            io.ktor.http.Headers r10 = r10.getHeaders()
            io.ktor.http.HttpHeaders r11 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r11 = r11.getExpires()
            java.lang.String r10 = r10.get(r11)
            if (r10 == 0) goto Lcd
            java.lang.String r11 = "0"
            boolean r11 = kotlin.jvm.internal.p.d(r10, r11)
            if (r11 != 0) goto Lc6
            boolean r11 = La.H.x0(r10)
            if (r11 == 0) goto Lba
            goto Lc6
        Lba:
            io.ktor.util.date.GMTDate r10 = io.ktor.http.DateUtilsKt.fromHttpToGmtDate(r10)     // Catch: java.lang.Throwable -> Lbf
            return r10
        Lbf:
            java.lang.Object r10 = r12.invoke()
            io.ktor.util.date.GMTDate r10 = (io.ktor.util.date.GMTDate) r10
            return r10
        Lc6:
            java.lang.Object r10 = r12.invoke()
            io.ktor.util.date.GMTDate r10 = (io.ktor.util.date.GMTDate) r10
            return r10
        Lcd:
            java.lang.Object r10 = r12.invoke()
            io.ktor.util.date.GMTDate r10 = (io.ktor.util.date.GMTDate) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheEntryKt.cacheExpires(io.ktor.client.statement.HttpResponse, boolean, p9.a):io.ktor.util.date.GMTDate");
    }

    public static /* synthetic */ GMTDate cacheExpires$default(HttpResponse httpResponse, boolean z10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5063a = new InterfaceC5063a() { // from class: io.ktor.client.plugins.cache.a
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return HttpCacheEntryKt.cacheExpires$lambda$0();
                }
            };
        }
        return cacheExpires(httpResponse, z10, interfaceC5063a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GMTDate cacheExpires$lambda$0() {
        return DateJvmKt.GMTDate$default(null, 1, null);
    }

    public static final ValidateStatus shouldValidate(GMTDate cacheExpires, Headers responseHeaders, HttpRequestBuilder request) {
        int iIntValue;
        Object next;
        Integer numValueOf;
        String value;
        Integer numW;
        String value2;
        List listB1;
        String str;
        p.i(cacheExpires, "cacheExpires");
        p.i(responseHeaders, "responseHeaders");
        p.i(request, "request");
        HeadersBuilder headers = request.getHeaders();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        List<String> all = responseHeaders.getAll(httpHeaders.getCacheControl());
        Object obj = null;
        List<HeaderValue> headerValue = HttpHeaderValueParserKt.parseHeaderValue(all != null ? F.A0(all, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null) : null);
        List<String> all2 = headers.getAll(httpHeaders.getCacheControl());
        List<HeaderValue> headerValue2 = HttpHeaderValueParserKt.parseHeaderValue(all2 != null ? F.A0(all2, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null) : null);
        if (headerValue2.contains(CacheControl.INSTANCE.getNO_CACHE$ktor_client_core())) {
            HttpCacheKt.getLOGGER().trace("\"no-cache\" is set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        }
        List<HeaderValue> list = headerValue2;
        Iterator<T> it = list.iterator();
        while (true) {
            iIntValue = 0;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (D.X(((HeaderValue) next).getValue(), "max-age=", false, 2, null)) {
                break;
            }
        }
        HeaderValue headerValue3 = (HeaderValue) next;
        if (headerValue3 == null || (value2 = headerValue3.getValue()) == null || (listB1 = H.b1(value2, new String[]{"="}, false, 0, 6, null)) == null || (str = (String) listB1.get(1)) == null) {
            numValueOf = null;
        } else {
            Integer numW2 = C.w(str);
            numValueOf = Integer.valueOf(numW2 != null ? numW2.intValue() : 0);
        }
        if (numValueOf != null && numValueOf.intValue() == 0) {
            HttpCacheKt.getLOGGER().trace("\"max-age\" is not set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        }
        CacheControl cacheControl = CacheControl.INSTANCE;
        if (headerValue.contains(cacheControl.getNO_CACHE$ktor_client_core())) {
            HttpCacheKt.getLOGGER().trace("\"no-cache\" is set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        }
        long timestamp = cacheExpires.getTimestamp() - DateJvmKt.getTimeMillis();
        if (timestamp > 0) {
            HttpCacheKt.getLOGGER().trace("Cached response is valid for " + request.getUrl() + ", should not validate");
            return ValidateStatus.ShouldNotValidate;
        }
        if (headerValue.contains(cacheControl.getMUST_REVALIDATE$ktor_client_core())) {
            HttpCacheKt.getLOGGER().trace("\"must-revalidate\" is set for " + request.getUrl() + ", should validate cached response");
            return ValidateStatus.ShouldValidate;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (D.X(((HeaderValue) next2).getValue(), "max-stale=", false, 2, null)) {
                obj = next2;
                break;
            }
        }
        HeaderValue headerValue4 = (HeaderValue) obj;
        if (headerValue4 != null && (value = headerValue4.getValue()) != null) {
            String strSubstring = value.substring(10);
            p.h(strSubstring, "substring(...)");
            if (strSubstring != null && (numW = C.w(strSubstring)) != null) {
                iIntValue = numW.intValue();
            }
        }
        if (timestamp + (iIntValue * 1000) > 0) {
            HttpCacheKt.getLOGGER().trace("Cached response is stale for " + request.getUrl() + " but less than max-stale, should warn");
            return ValidateStatus.ShouldWarn;
        }
        HttpCacheKt.getLOGGER().trace("Cached response is stale for " + request.getUrl() + ", should validate cached response");
        return ValidateStatus.ShouldValidate;
    }

    public static final Map<String, String> varyKeys(HttpResponse httpResponse) {
        String strA0;
        p.i(httpResponse, "<this>");
        List<String> listVary = HttpMessagePropertiesKt.vary(httpResponse);
        if (listVary == null) {
            return kotlin.collections.a.i();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Headers headers = httpResponse.getCall().getRequest().getHeaders();
        for (String str : listVary) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            List<String> all = headers.getAll(str);
            if (all == null || (strA0 = F.A0(all, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null)) == null) {
                strA0 = "";
            }
            linkedHashMap.put(lowerCase, strA0);
        }
        return linkedHashMap;
    }
}
