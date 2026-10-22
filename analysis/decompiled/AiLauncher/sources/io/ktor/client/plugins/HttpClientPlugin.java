package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001J%\u0010\u0007\u001a\u00028\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/HttpClientPlugin;", "", "TConfig", "TPlugin", "Lkotlin/Function1;", "LY8/t;", "block", "prepare", "(Lp9/l;)Ljava/lang/Object;", "plugin", "Lio/ktor/client/HttpClient;", "scope", W4.b.STEP_INSTALL, "(Ljava/lang/Object;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "key", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface HttpClientPlugin<TConfig, TPlugin> {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object prepare$default(HttpClientPlugin httpClientPlugin, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepare");
        }
        if ((i10 & 1) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.plugins.m
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return HttpClientPlugin.prepare$lambda$0(obj2);
                }
            };
        }
        return httpClientPlugin.prepare(interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Y8.t prepare$lambda$0(Object obj) {
        kotlin.jvm.internal.p.i(obj, "<this>");
        return Y8.t.f7040a;
    }

    AttributeKey<TPlugin> getKey();

    void install(TPlugin plugin, HttpClient scope);

    TPlugin prepare(InterfaceC5074l<? super TConfig, Y8.t> block);
}
