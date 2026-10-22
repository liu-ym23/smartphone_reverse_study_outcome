package androidx.appfunctions.metadata;

import androidx.annotation.RestrictTo;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.exceptions.AppSearchException;
import java.util.Collections;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: androidx.appfunctions.metadata.$$__AppSearch__AppFunctionDeprecationMetadataDocument, reason: invalid class name */
/* loaded from: classes.dex */
public final class C$$__AppSearch__AppFunctionDeprecationMetadataDocument implements DocumentClassFactory<AppFunctionDeprecationMetadataDocument> {
    public static final String SCHEMA_NAME = "AppFunctionDeprecationMetadataDocument";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() throws AppSearchException {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() throws AppSearchException {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(B7.a.d("message", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppFunctionDeprecationMetadataDocument fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) throws AppSearchException {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("message");
        return new AppFunctionDeprecationMetadataDocument(namespace, id, (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0]);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(AppFunctionDeprecationMetadataDocument appFunctionDeprecationMetadataDocument) throws AppSearchException, IllegalArgumentException {
        GenericDocument.Builder builder = new GenericDocument.Builder(appFunctionDeprecationMetadataDocument.getNamespace(), appFunctionDeprecationMetadataDocument.getId(), SCHEMA_NAME);
        String message = appFunctionDeprecationMetadataDocument.getMessage();
        if (message != null) {
            builder.setPropertyString("message", message);
        }
        return builder.build();
    }
}
