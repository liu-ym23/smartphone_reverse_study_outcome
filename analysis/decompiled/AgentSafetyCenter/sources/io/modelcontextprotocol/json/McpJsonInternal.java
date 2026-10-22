package io.modelcontextprotocol.json;

import java.lang.invoke.VarHandle;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class McpJsonInternal {
    private static McpJsonMapper defaultJsonMapper;

    private static void addException(AtomicReference<IllegalStateException> atomicReference, Exception exc) {
        d dVar = new d();
        dVar.f6235a = exc;
        VarHandle.storeStoreFence();
        atomicReference.updateAndGet(dVar);
    }

    public static McpJsonMapper createDefaultMapper() {
        AtomicReference atomicReference = new AtomicReference();
        Stream stream = ServiceLoader.load(McpJsonMapperSupplier.class).stream();
        a aVar = new a();
        aVar.f6232a = atomicReference;
        VarHandle.storeStoreFence();
        Stream streamFlatMap = stream.flatMap(aVar);
        b bVar = new b();
        bVar.f6233a = atomicReference;
        VarHandle.storeStoreFence();
        Optional optionalFindFirst = streamFlatMap.flatMap(bVar).findFirst();
        c cVar = new c();
        cVar.f6234c = atomicReference;
        VarHandle.storeStoreFence();
        return (McpJsonMapper) optionalFindFirst.orElseThrow(cVar);
    }

    public static McpJsonMapper getDefaultMapper() {
        if (defaultJsonMapper == null) {
            defaultJsonMapper = createDefaultMapper();
        }
        return defaultJsonMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IllegalStateException lambda$addException$3(Exception exc, IllegalStateException illegalStateException) {
        if (illegalStateException == null) {
            return new IllegalStateException("Failed to initialize default McpJsonMapper", exc);
        }
        illegalStateException.addSuppressed(exc);
        return illegalStateException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$createDefaultMapper$0(AtomicReference atomicReference, ServiceLoader.Provider provider) {
        try {
            McpJsonMapperSupplier mcpJsonMapperSupplier = (McpJsonMapperSupplier) provider.get();
            return mcpJsonMapperSupplier == null ? Stream.empty() : Stream.of(mcpJsonMapperSupplier);
        } catch (Exception e10) {
            addException(atomicReference, e10);
            return Stream.empty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$createDefaultMapper$1(AtomicReference atomicReference, McpJsonMapperSupplier mcpJsonMapperSupplier) {
        try {
            McpJsonMapper mcpJsonMapper = mcpJsonMapperSupplier.get();
            return mcpJsonMapper == null ? Stream.empty() : Stream.of(mcpJsonMapper);
        } catch (Exception e10) {
            addException(atomicReference, e10);
            return Stream.empty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IllegalStateException lambda$createDefaultMapper$2(AtomicReference atomicReference) {
        return atomicReference.get() != null ? (IllegalStateException) atomicReference.get() : new IllegalStateException("No default McpJsonMapper implementation found");
    }
}
