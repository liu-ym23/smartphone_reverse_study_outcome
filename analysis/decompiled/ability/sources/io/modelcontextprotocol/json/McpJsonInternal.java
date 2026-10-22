package io.modelcontextprotocol.json;

import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* loaded from: classes2.dex */
final class McpJsonInternal {
    private static McpJsonMapper defaultJsonMapper;

    private static void addException(AtomicReference<IllegalStateException> atomicReference, final Exception exc) {
        atomicReference.updateAndGet(new UnaryOperator() { // from class: io.modelcontextprotocol.json.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpJsonInternal.lambda$addException$3(exc, (IllegalStateException) obj);
            }
        });
    }

    public static McpJsonMapper createDefaultMapper() {
        final AtomicReference atomicReference = new AtomicReference();
        return (McpJsonMapper) ServiceLoader.load(McpJsonMapperSupplier.class).stream().flatMap(new Function() { // from class: io.modelcontextprotocol.json.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpJsonInternal.lambda$createDefaultMapper$0(atomicReference, (ServiceLoader.Provider) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.json.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpJsonInternal.lambda$createDefaultMapper$1(atomicReference, (McpJsonMapperSupplier) obj);
            }
        }).findFirst().orElseThrow(new Supplier() { // from class: io.modelcontextprotocol.json.c
            @Override // java.util.function.Supplier
            public final Object get() {
                return McpJsonInternal.lambda$createDefaultMapper$2(atomicReference);
            }
        });
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
        } catch (Exception e) {
            addException(atomicReference, e);
            return Stream.empty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$createDefaultMapper$1(AtomicReference atomicReference, McpJsonMapperSupplier mcpJsonMapperSupplier) {
        try {
            McpJsonMapper mcpJsonMapper = mcpJsonMapperSupplier.get();
            return mcpJsonMapper == null ? Stream.empty() : Stream.of(mcpJsonMapper);
        } catch (Exception e) {
            addException(atomicReference, e);
            return Stream.empty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IllegalStateException lambda$createDefaultMapper$2(AtomicReference atomicReference) {
        return atomicReference.get() != null ? (IllegalStateException) atomicReference.get() : new IllegalStateException("No default McpJsonMapper implementation found");
    }
}
