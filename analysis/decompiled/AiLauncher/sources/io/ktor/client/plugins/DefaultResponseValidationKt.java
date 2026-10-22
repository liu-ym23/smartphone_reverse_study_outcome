package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0018\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r\"\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "LY8/t;", "addDefaultResponseValidation", "(Lio/ktor/client/HttpClientConfig;)V", "Lio/ktor/util/AttributeKey;", "ValidateMark", "Lio/ktor/util/AttributeKey;", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "", "NO_RESPONSE_TEXT", "Ljava/lang/String;", "BODY_FAILED_DECODING", "DEPRECATED_EXCEPTION_CTOR", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultResponseValidationKt {
    private static final String BODY_FAILED_DECODING = "<body failed decoding>";
    private static final String DEPRECATED_EXCEPTION_CTOR = "Please, provide response text in constructor";
    private static final vc.c LOGGER;
    private static final String NO_RESPONSE_TEXT = "<no response text provided>";
    private static final AttributeKey<Y8.t> ValidateMark;

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Y8.t.class);
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(Y8.t.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        ValidateMark = new AttributeKey<>("ValidateMark", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
        LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.DefaultResponseValidation");
    }

    public static final void addDefaultResponseValidation(final HttpClientConfig<?> httpClientConfig) {
        kotlin.jvm.internal.p.i(httpClientConfig, "<this>");
        HttpCallValidatorKt.HttpResponseValidator(httpClientConfig, new InterfaceC5074l() { // from class: io.ktor.client.plugins.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return DefaultResponseValidationKt.addDefaultResponseValidation$lambda$0(httpClientConfig, (HttpCallValidatorConfig) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t addDefaultResponseValidation$lambda$0(HttpClientConfig httpClientConfig, HttpCallValidatorConfig HttpResponseValidator) {
        kotlin.jvm.internal.p.i(HttpResponseValidator, "$this$HttpResponseValidator");
        HttpResponseValidator.setExpectSuccess$ktor_client_core(httpClientConfig.getExpectSuccess());
        HttpResponseValidator.validateResponse(new DefaultResponseValidationKt$addDefaultResponseValidation$1$1(null));
        return Y8.t.f7040a;
    }
}
