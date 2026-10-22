package io.ktor.client.engine;

import Ua.C1086v0;
import Ua.CoroutineName;
import Ua.InterfaceC1089x;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.engine.HttpClientEngineKt;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.HttpHeaders;
import io.ktor.http.UnsafeHeaderException;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\f\u001a\u00020\u000b*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0080@¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0013\u001a\u00020\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"$\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineConfig;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/engine/HttpClientEngineFactory;", "Lkotlin/Function1;", "LY8/t;", "nested", "config", "(Lio/ktor/client/engine/HttpClientEngineFactory;Lp9/l;)Lio/ktor/client/engine/HttpClientEngineFactory;", "Lio/ktor/client/engine/HttpClientEngine;", "Lkotlinx/coroutines/g;", "parentJob", "Lkotlin/coroutines/d;", "createCallContext", "(Lio/ktor/client/engine/HttpClientEngine;Lkotlinx/coroutines/g;Le9/c;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestData;", "request", "validateHeaders", "(Lio/ktor/client/request/HttpRequestData;)V", "LUa/L;", "CALL_COROUTINE", "LUa/L;", "getCALL_COROUTINE", "()LUa/L;", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/HttpClientConfig;", "CLIENT_CONFIG", "Lio/ktor/util/AttributeKey;", "getCLIENT_CONFIG", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpClientEngineKt {
    private static final CoroutineName CALL_COROUTINE = new CoroutineName("call-context");
    private static final AttributeKey<HttpClientConfig<?>> CLIENT_CONFIG;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"io/ktor/client/engine/HttpClientEngineKt$config$1", "Lio/ktor/client/engine/HttpClientEngineFactory;", "Lkotlin/Function1;", "LY8/t;", "block", "Lio/ktor/client/engine/HttpClientEngine;", "create", "(Lp9/l;)Lio/ktor/client/engine/HttpClientEngine;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.engine.HttpClientEngineKt$config$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements HttpClientEngineFactory<T> {
        final /* synthetic */ InterfaceC5074l<T, t> $nested;
        final /* synthetic */ HttpClientEngineFactory<T> $parent;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(HttpClientEngineFactory<? extends T> httpClientEngineFactory, InterfaceC5074l<? super T, t> interfaceC5074l) {
            this.$parent = httpClientEngineFactory;
            this.$nested = interfaceC5074l;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final t create$lambda$0(InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, HttpClientEngineConfig create) {
            p.i(create, "$this$create");
            interfaceC5074l.invoke(create);
            interfaceC5074l2.invoke(create);
            return t.f7040a;
        }

        @Override // io.ktor.client.engine.HttpClientEngineFactory
        public HttpClientEngine create(final InterfaceC5074l<? super T, t> block) {
            p.i(block, "block");
            HttpClientEngineFactory<T> httpClientEngineFactory = this.$parent;
            final InterfaceC5074l<T, t> interfaceC5074l = this.$nested;
            return httpClientEngineFactory.create(new InterfaceC5074l() { // from class: io.ktor.client.engine.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return HttpClientEngineKt.AnonymousClass1.create$lambda$0(interfaceC5074l, block, (HttpClientEngineConfig) obj);
                }
            });
        }
    }

    static {
        InterfaceC5755n interfaceC5755nN;
        InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(HttpClientConfig.class);
        try {
            interfaceC5755nN = kotlin.jvm.internal.t.n(HttpClientConfig.class, C5757p.INSTANCE.c());
        } catch (Throwable unused) {
            interfaceC5755nN = null;
        }
        CLIENT_CONFIG = new AttributeKey<>("client-config", new TypeInfo(interfaceC5745dB, interfaceC5755nN));
    }

    public static final <T extends HttpClientEngineConfig> HttpClientEngineFactory<T> config(HttpClientEngineFactory<? extends T> httpClientEngineFactory, InterfaceC5074l<? super T, t> nested) {
        p.i(httpClientEngineFactory, "<this>");
        p.i(nested, "nested");
        return new AnonymousClass1(httpClientEngineFactory, nested);
    }

    public static final Object createCallContext(HttpClientEngine httpClientEngine, kotlinx.coroutines.g gVar, InterfaceC4014c<? super kotlin.coroutines.d> interfaceC4014c) {
        InterfaceC1089x interfaceC1089xA = C1086v0.a(gVar);
        kotlin.coroutines.d dVarPlus = httpClientEngine.getCoroutineContext().plus(interfaceC1089xA).plus(CALL_COROUTINE);
        kotlinx.coroutines.g gVar2 = (kotlinx.coroutines.g) interfaceC4014c.getContext().get(kotlinx.coroutines.g.INSTANCE);
        if (gVar2 == null) {
            return dVarPlus;
        }
        interfaceC1089xA.J(new UtilsKt.AnonymousClass2(kotlinx.coroutines.g.b1(gVar2, true, false, new UtilsKt$attachToUserJob$cleanupHandler$1(interfaceC1089xA), 2, null)));
        return dVarPlus;
    }

    public static final CoroutineName getCALL_COROUTINE() {
        return CALL_COROUTINE;
    }

    public static final AttributeKey<HttpClientConfig<?>> getCLIENT_CONFIG() {
        return CLIENT_CONFIG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateHeaders(HttpRequestData httpRequestData) {
        Set<String> setNames = httpRequestData.getHeaders().names();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setNames) {
            if (HttpHeaders.INSTANCE.getUnsafeHeadersList().contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new UnsafeHeaderException(arrayList.toString());
        }
    }
}
