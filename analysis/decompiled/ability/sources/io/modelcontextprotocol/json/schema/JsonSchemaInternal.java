package io.modelcontextprotocol.json.schema;

import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* loaded from: classes2.dex */
final class JsonSchemaInternal {
    private static JsonSchemaValidator defaultValidator;

    private static void addException(AtomicReference<IllegalStateException> atomicReference, final Exception exc) {
        atomicReference.updateAndGet(new UnaryOperator() { // from class: io.modelcontextprotocol.json.schema.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return JsonSchemaInternal.lambda$addException$3(exc, (IllegalStateException) obj);
            }
        });
    }

    public static JsonSchemaValidator createDefaultValidator() {
        final AtomicReference atomicReference = new AtomicReference();
        return (JsonSchemaValidator) ServiceLoader.load(JsonSchemaValidatorSupplier.class).stream().flatMap(new Function() { // from class: io.modelcontextprotocol.json.schema.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return JsonSchemaInternal.lambda$createDefaultValidator$0(atomicReference, (ServiceLoader.Provider) obj);
            }
        }).flatMap(new Function() { // from class: io.modelcontextprotocol.json.schema.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return JsonSchemaInternal.lambda$createDefaultValidator$1(atomicReference, (JsonSchemaValidatorSupplier) obj);
            }
        }).findFirst().orElseThrow(new Supplier() { // from class: io.modelcontextprotocol.json.schema.c
            @Override // java.util.function.Supplier
            public final Object get() {
                return JsonSchemaInternal.lambda$createDefaultValidator$2(atomicReference);
            }
        });
    }

    public static JsonSchemaValidator getDefaultValidator() {
        if (defaultValidator == null) {
            defaultValidator = createDefaultValidator();
        }
        return defaultValidator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IllegalStateException lambda$addException$3(Exception exc, IllegalStateException illegalStateException) {
        if (illegalStateException == null) {
            return new IllegalStateException("Failed to initialize default JsonSchemaValidatorSupplier", exc);
        }
        illegalStateException.addSuppressed(exc);
        return illegalStateException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$createDefaultValidator$0(AtomicReference atomicReference, ServiceLoader.Provider provider) {
        try {
            JsonSchemaValidatorSupplier jsonSchemaValidatorSupplier = (JsonSchemaValidatorSupplier) provider.get();
            return jsonSchemaValidatorSupplier == null ? Stream.empty() : Stream.of(jsonSchemaValidatorSupplier);
        } catch (Exception e) {
            addException(atomicReference, e);
            return Stream.empty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$createDefaultValidator$1(AtomicReference atomicReference, JsonSchemaValidatorSupplier jsonSchemaValidatorSupplier) {
        try {
            return Stream.of(jsonSchemaValidatorSupplier.get());
        } catch (Exception e) {
            addException(atomicReference, e);
            return Stream.empty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IllegalStateException lambda$createDefaultValidator$2(AtomicReference atomicReference) {
        return atomicReference.get() != null ? (IllegalStateException) atomicReference.get() : new IllegalStateException("No default JsonSchemaValidatorSupplier implementation found");
    }
}
