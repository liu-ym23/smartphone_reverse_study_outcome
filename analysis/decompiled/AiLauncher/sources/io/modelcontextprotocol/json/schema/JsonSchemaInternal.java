package io.modelcontextprotocol.json.schema;

import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* loaded from: classes4.dex */
final class JsonSchemaInternal {
    private static JsonSchemaValidator defaultValidator;

    public static /* synthetic */ Stream a(AtomicReference atomicReference, ServiceLoader.Provider provider) {
        try {
            return Stream.ofNullable((JsonSchemaValidatorSupplier) provider.get());
        } catch (Exception e10) {
            addException(atomicReference, e10);
            return Stream.empty();
        }
    }

    private static void addException(AtomicReference<IllegalStateException> atomicReference, final Exception exc) {
        atomicReference.updateAndGet(new UnaryOperator() { // from class: io.modelcontextprotocol.json.schema.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return JsonSchemaInternal.b(exc, (IllegalStateException) obj);
            }
        });
    }

    public static /* synthetic */ IllegalStateException b(Exception exc, IllegalStateException illegalStateException) {
        if (illegalStateException == null) {
            return new IllegalStateException("Failed to initialize default JsonSchemaValidatorSupplier", exc);
        }
        illegalStateException.addSuppressed(exc);
        return illegalStateException;
    }

    public static /* synthetic */ IllegalStateException c(AtomicReference atomicReference) {
        return atomicReference.get() != null ? (IllegalStateException) atomicReference.get() : new IllegalStateException("No default JsonSchemaValidatorSupplier implementation found");
    }

    public static JsonSchemaValidator createDefaultValidator() {
        final AtomicReference atomicReference = new AtomicReference();
        return (JsonSchemaValidator) ServiceLoader.load(JsonSchemaValidatorSupplier.class).stream().flatMap(new Function() { // from class: io.modelcontextprotocol.json.schema.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return JsonSchemaInternal.a(atomicReference, (ServiceLoader.Provider) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.json.schema.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return JsonSchemaInternal.d(atomicReference, (JsonSchemaValidatorSupplier) obj);
            }
        }).findFirst().orElseThrow(new Supplier() { // from class: io.modelcontextprotocol.json.schema.c
            @Override // java.util.function.Supplier
            public final Object get() {
                return JsonSchemaInternal.c(atomicReference);
            }
        });
    }

    public static /* synthetic */ Stream d(AtomicReference atomicReference, JsonSchemaValidatorSupplier jsonSchemaValidatorSupplier) {
        try {
            return Stream.of(jsonSchemaValidatorSupplier.get());
        } catch (Exception e10) {
            addException(atomicReference, e10);
            return Stream.empty();
        }
    }

    public static JsonSchemaValidator getDefaultValidator() {
        if (defaultValidator == null) {
            defaultValidator = createDefaultValidator();
        }
        return defaultValidator;
    }
}
