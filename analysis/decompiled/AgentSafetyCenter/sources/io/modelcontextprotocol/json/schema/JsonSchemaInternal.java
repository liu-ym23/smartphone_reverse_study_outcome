package io.modelcontextprotocol.json.schema;

import java.lang.invoke.VarHandle;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class JsonSchemaInternal {
    private static JsonSchemaValidator defaultValidator;

    private static void addException(AtomicReference<IllegalStateException> atomicReference, Exception exc) {
        d dVar = new d();
        dVar.f6239a = exc;
        VarHandle.storeStoreFence();
        atomicReference.updateAndGet(dVar);
    }

    public static JsonSchemaValidator createDefaultValidator() {
        AtomicReference atomicReference = new AtomicReference();
        Stream stream = ServiceLoader.load(JsonSchemaValidatorSupplier.class).stream();
        a aVar = new a();
        aVar.f6236a = atomicReference;
        VarHandle.storeStoreFence();
        Stream streamFlatMap = stream.flatMap(aVar);
        b bVar = new b();
        bVar.f6237a = atomicReference;
        VarHandle.storeStoreFence();
        Optional optionalFindFirst = streamFlatMap.flatMap(bVar).findFirst();
        c cVar = new c();
        cVar.f6238c = atomicReference;
        VarHandle.storeStoreFence();
        return (JsonSchemaValidator) optionalFindFirst.orElseThrow(cVar);
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
        } catch (Exception e10) {
            addException(atomicReference, e10);
            return Stream.empty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$createDefaultValidator$1(AtomicReference atomicReference, JsonSchemaValidatorSupplier jsonSchemaValidatorSupplier) {
        try {
            return Stream.of(jsonSchemaValidatorSupplier.get());
        } catch (Exception e10) {
            addException(atomicReference, e10);
            return Stream.empty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IllegalStateException lambda$createDefaultValidator$2(AtomicReference atomicReference) {
        return atomicReference.get() != null ? (IllegalStateException) atomicReference.get() : new IllegalStateException("No default JsonSchemaValidatorSupplier implementation found");
    }
}
