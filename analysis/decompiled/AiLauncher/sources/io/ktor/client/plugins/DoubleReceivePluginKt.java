package io.ktor.client.plugins;

import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0003\"\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007\"\u001f\u0010\u000f\u001a\u00060\tj\u0002`\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00108\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\"&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00108\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u0012\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u0019\u0010\u0014\"\u0015\u0010\u001d\u001a\u00020\u001c*\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "LY8/t;", "skipSaveBody", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "skipSavingBody", "Lio/ktor/util/AttributeKey;", "SKIP_SAVE_BODY", "Lio/ktor/util/AttributeKey;", "RESPONSE_BODY_SAVED", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER$delegate", "LY8/h;", "getLOGGER", "()Lvc/c;", "LOGGER", "Lio/ktor/client/plugins/api/ClientPlugin;", "SaveBody", "Lio/ktor/client/plugins/api/ClientPlugin;", "getSaveBody", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getSaveBody$annotations", "()V", "Lio/ktor/client/plugins/SaveBodyPluginConfig;", "SaveBodyPlugin", "getSaveBodyPlugin", "getSaveBodyPlugin$annotations", "Lio/ktor/client/statement/HttpResponse;", "", "isSaved", "(Lio/ktor/client/statement/HttpResponse;)Z", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DoubleReceivePluginKt {
    private static final Y8.h LOGGER$delegate;
    private static final AttributeKey<Y8.t> RESPONSE_BODY_SAVED;
    private static final AttributeKey<Y8.t> SKIP_SAVE_BODY;
    private static final ClientPlugin<Y8.t> SaveBody;
    private static final ClientPlugin<SaveBodyPluginConfig> SaveBodyPlugin;

    static {
        InterfaceC5755n interfaceC5755nM;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(Y8.t.class);
        InterfaceC5755n interfaceC5755nM2 = null;
        try {
            interfaceC5755nM = kotlin.jvm.internal.t.m(Y8.t.class);
        } catch (Throwable unused) {
            interfaceC5755nM = null;
        }
        SKIP_SAVE_BODY = new AttributeKey<>("SkipSaveBody", new TypeInfo(interfaceC5745dB, interfaceC5755nM));
        InterfaceC5745d interfaceC5745dB2 = kotlin.jvm.internal.t.b(Y8.t.class);
        try {
            interfaceC5755nM2 = kotlin.jvm.internal.t.m(Y8.t.class);
        } catch (Throwable unused2) {
        }
        RESPONSE_BODY_SAVED = new AttributeKey<>("ResponseBodySaved", new TypeInfo(interfaceC5745dB2, interfaceC5755nM2));
        LOGGER$delegate = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.client.plugins.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DoubleReceivePluginKt.LOGGER_delegate$lambda$0();
            }
        });
        SaveBody = CreatePluginUtilsKt.createClientPlugin("SaveBody", new InterfaceC5074l() { // from class: io.ktor.client.plugins.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return DoubleReceivePluginKt.SaveBody$lambda$1((ClientPluginBuilder) obj);
            }
        });
        SaveBodyPlugin = CreatePluginUtilsKt.createClientPlugin("DoubleReceivePlugin", DoubleReceivePluginKt$SaveBodyPlugin$1.INSTANCE, new InterfaceC5074l() { // from class: io.ktor.client.plugins.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return DoubleReceivePluginKt.SaveBodyPlugin$lambda$2((ClientPluginBuilder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vc.c LOGGER_delegate$lambda$0() {
        return KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.SaveBody");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t SaveBody$lambda$1(ClientPluginBuilder createClientPlugin) {
        kotlin.jvm.internal.p.i(createClientPlugin, "$this$createClientPlugin");
        createClientPlugin.getClient().getReceivePipeline().intercept(HttpReceivePipeline.INSTANCE.getBefore(), new DoubleReceivePluginKt$SaveBody$1$1(null));
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t SaveBodyPlugin$lambda$2(ClientPluginBuilder createClientPlugin) {
        kotlin.jvm.internal.p.i(createClientPlugin, "$this$createClientPlugin");
        if (((SaveBodyPluginConfig) createClientPlugin.getPluginConfig()).getDisabled()) {
            getLOGGER().warn(Messages.SAVE_BODY_DISABLED_MESSAGE);
        } else {
            getLOGGER().warn(Messages.SAVE_BODY_ENABLED_MESSAGE);
        }
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vc.c getLOGGER() {
        return (vc.c) LOGGER$delegate.getValue();
    }

    public static final ClientPlugin<Y8.t> getSaveBody() {
        return SaveBody;
    }

    public static /* synthetic */ void getSaveBody$annotations() {
    }

    public static final ClientPlugin<SaveBodyPluginConfig> getSaveBodyPlugin() {
        return SaveBodyPlugin;
    }

    public static /* synthetic */ void getSaveBodyPlugin$annotations() {
    }

    public static final boolean isSaved(HttpResponse httpResponse) {
        kotlin.jvm.internal.p.i(httpResponse, "<this>");
        return httpResponse.getCall().getAttributes().contains(RESPONSE_BODY_SAVED);
    }

    public static final void skipSaveBody(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        httpRequestBuilder.getAttributes().put(SKIP_SAVE_BODY, Y8.t.f7040a);
    }

    public static final void skipSavingBody(HttpRequestBuilder httpRequestBuilder) {
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<this>");
        getLOGGER().warn(Messages.SKIP_SAVING_BODY_MESSAGE);
    }
}
