package io.ktor.client.engine;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.client.engine.HttpClientEngineConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003J%\u0010\b\u001a\u00020\u00072\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineFactory;", "Lio/ktor/client/engine/HttpClientEngineConfig;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/Function1;", "LY8/t;", "block", "Lio/ktor/client/engine/HttpClientEngine;", "create", "(Lp9/l;)Lio/ktor/client/engine/HttpClientEngine;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface HttpClientEngineFactory<T extends HttpClientEngineConfig> {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ HttpClientEngine create$default(HttpClientEngineFactory httpClientEngineFactory, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
        }
        if ((i10 & 1) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.engine.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return HttpClientEngineFactory.create$lambda$0((HttpClientEngineConfig) obj2);
                }
            };
        }
        return httpClientEngineFactory.create(interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static t create$lambda$0(HttpClientEngineConfig httpClientEngineConfig) {
        p.i(httpClientEngineConfig, "<this>");
        return t.f7040a;
    }

    HttpClientEngine create(InterfaceC5074l<? super T, t> block);
}
