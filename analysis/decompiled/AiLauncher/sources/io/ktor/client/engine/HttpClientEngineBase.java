package io.ktor.client.engine;

import Ua.CoroutineName;
import Ua.I;
import Ua.InterfaceC1089x;
import Y8.h;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import io.ktor.client.HttpClient;
import io.ktor.util.CoroutinesUtilsKt;
import io.ktor.utils.io.IODispatcher_jvmKt;
import io.ktor.utils.io.InternalAPI;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineBase;", "Lio/ktor/client/engine/HttpClientEngine;", "", "engineName", "<init>", "(Ljava/lang/String;)V", "LY8/t;", "close", "()V", "Ljava/lang/String;", "LUa/I;", "dispatcher$delegate", "LY8/h;", "getDispatcher", "()LUa/I;", "dispatcher", "Lkotlin/coroutines/d;", "coroutineContext$delegate", "getCoroutineContext", "()Lkotlin/coroutines/d;", "coroutineContext", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class HttpClientEngineBase implements HttpClientEngine {
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientEngineBase.class, AlipayXuiIsland.REASON_CLOSED);
    private volatile /* synthetic */ int closed;

    /* renamed from: coroutineContext$delegate, reason: from kotlin metadata */
    private final h coroutineContext;

    /* renamed from: dispatcher$delegate, reason: from kotlin metadata */
    private final h dispatcher;
    private final String engineName;

    public HttpClientEngineBase(String engineName) {
        p.i(engineName, "engineName");
        this.engineName = engineName;
        this.closed = 0;
        this.dispatcher = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.client.engine.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HttpClientEngineBase.dispatcher_delegate$lambda$0(this.f33152a);
            }
        });
        this.coroutineContext = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.client.engine.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HttpClientEngineBase.coroutineContext_delegate$lambda$1(this.f33153a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.coroutines.d coroutineContext_delegate$lambda$1(HttpClientEngineBase httpClientEngineBase) {
        return CoroutinesUtilsKt.SilentSupervisor$default(null, 1, null).plus(httpClientEngineBase.getDispatcher()).plus(new CoroutineName(httpClientEngineBase.engineName + "-context"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final I dispatcher_delegate$lambda$0(HttpClientEngineBase httpClientEngineBase) {
        I dispatcher = httpClientEngineBase.getConfig().getDispatcher();
        return dispatcher == null ? IODispatcher_jvmKt.ioDispatcher() : dispatcher;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (closed$FU.compareAndSet(this, 0, 1)) {
            d.b bVar = getCoroutineContext().get(kotlinx.coroutines.g.INSTANCE);
            InterfaceC1089x interfaceC1089x = bVar instanceof InterfaceC1089x ? (InterfaceC1089x) bVar : null;
            if (interfaceC1089x == null) {
                return;
            }
            interfaceC1089x.complete();
        }
    }

    @Override // io.ktor.client.engine.HttpClientEngine, Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return (kotlin.coroutines.d) this.coroutineContext.getValue();
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public I getDispatcher() {
        return (I) this.dispatcher.getValue();
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return super.getSupportedCapabilities();
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    @InternalAPI
    public void install(HttpClient httpClient) {
        super.install(httpClient);
    }
}
