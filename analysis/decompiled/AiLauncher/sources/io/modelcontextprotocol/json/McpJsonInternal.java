package io.modelcontextprotocol.json;

import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* loaded from: classes4.dex */
final class McpJsonInternal {
    private static McpJsonMapper defaultJsonMapper;

    public static /* synthetic */ Stream a(AtomicReference atomicReference, ServiceLoader.Provider provider) {
        try {
            return Stream.ofNullable((McpJsonMapperSupplier) provider.get());
        } catch (Exception e10) {
            addException(atomicReference, e10);
            return Stream.empty();
        }
    }

    private static void addException(AtomicReference<IllegalStateException> atomicReference, final Exception exc) {
        atomicReference.updateAndGet(new UnaryOperator() { // from class: io.modelcontextprotocol.json.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpJsonInternal.b(exc, (IllegalStateException) obj);
            }
        });
    }

    public static /* synthetic */ IllegalStateException b(Exception exc, IllegalStateException illegalStateException) {
        if (illegalStateException == null) {
            return new IllegalStateException("Failed to initialize default McpJsonMapper", exc);
        }
        illegalStateException.addSuppressed(exc);
        return illegalStateException;
    }

    public static /* synthetic */ Stream c(AtomicReference atomicReference, McpJsonMapperSupplier mcpJsonMapperSupplier) {
        try {
            return Stream.ofNullable(mcpJsonMapperSupplier.get());
        } catch (Exception e10) {
            addException(atomicReference, e10);
            return Stream.empty();
        }
    }

    public static McpJsonMapper createDefaultMapper() {
        final AtomicReference atomicReference = new AtomicReference();
        return (McpJsonMapper) ServiceLoader.load(McpJsonMapperSupplier.class).stream().flatMap(new Function() { // from class: io.modelcontextprotocol.json.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpJsonInternal.a(atomicReference, (ServiceLoader.Provider) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.json.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpJsonInternal.c(atomicReference, (McpJsonMapperSupplier) obj);
            }
        }).findFirst().orElseThrow(new Supplier() { // from class: io.modelcontextprotocol.json.e
            @Override // java.util.function.Supplier
            public final Object get() {
                return McpJsonInternal.d(atomicReference);
            }
        });
    }

    public static /* synthetic */ IllegalStateException d(AtomicReference atomicReference) {
        return atomicReference.get() != null ? (IllegalStateException) atomicReference.get() : new IllegalStateException("No default McpJsonMapper implementation found");
    }

    public static McpJsonMapper getDefaultMapper() {
        if (defaultJsonMapper == null) {
            defaultJsonMapper = createDefaultMapper();
        }
        return defaultJsonMapper;
    }
}
