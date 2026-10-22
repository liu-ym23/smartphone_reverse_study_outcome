package io.ktor.client.utils;

import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.InternalAPI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import p9.InterfaceC5063a;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a-\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\" \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/http/HeadersBuilder;", "Lio/ktor/http/HttpMethod;", "method", "Lio/ktor/util/Attributes;", "attributes", "", "alwaysRemove", "LY8/t;", "dropCompressionHeaders", "(Lio/ktor/http/HeadersBuilder;Lio/ktor/http/HttpMethod;Lio/ktor/util/Attributes;Z)V", "Lio/ktor/util/AttributeKey;", "", "", "DecompressionListAttribute", "Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HeadersUtilsKt {
    private static final AttributeKey<List<String>> DecompressionListAttribute;

    static {
        InterfaceC5755n interfaceC5755nD;
        InterfaceC5745d interfaceC5745dB = t.b(List.class);
        try {
            interfaceC5755nD = t.d(t.n(List.class, C5757p.INSTANCE.d(t.m(String.class))));
        } catch (Throwable unused) {
            interfaceC5755nD = null;
        }
        DecompressionListAttribute = new AttributeKey<>("DecompressionListAttribute", new TypeInfo(interfaceC5745dB, interfaceC5755nD));
    }

    @InternalAPI
    public static final void dropCompressionHeaders(HeadersBuilder headersBuilder, HttpMethod method, Attributes attributes, boolean z10) {
        p.i(headersBuilder, "<this>");
        p.i(method, "method");
        p.i(attributes, "attributes");
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        if (p.d(method, companion.getHead()) || p.d(method, companion.getOptions())) {
            return;
        }
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        String str = headersBuilder.get(httpHeaders.getContentEncoding());
        if (str != null) {
            ((List) attributes.computeIfAbsent(DecompressionListAttribute, new InterfaceC5063a() { // from class: io.ktor.client.utils.b
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return HeadersUtilsKt.dropCompressionHeaders$lambda$0();
                }
            })).add(str);
        } else if (!z10) {
            return;
        }
        headersBuilder.remove(httpHeaders.getContentEncoding());
        headersBuilder.remove(httpHeaders.getContentLength());
    }

    public static /* synthetic */ void dropCompressionHeaders$default(HeadersBuilder headersBuilder, HttpMethod httpMethod, Attributes attributes, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        dropCompressionHeaders(headersBuilder, httpMethod, attributes, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List dropCompressionHeaders$lambda$0() {
        return new ArrayList();
    }
}
