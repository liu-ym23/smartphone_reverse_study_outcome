package androidx.appfunctions.metadata;

import androidx.annotation.RestrictTo;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.exceptions.AppSearchException;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: androidx.appfunctions.metadata.$$__AppSearch__AppFunctionResponseMetadataDocument, reason: invalid class name */
/* loaded from: classes.dex */
public final class C$$__AppSearch__AppFunctionResponseMetadataDocument implements DocumentClassFactory<AppFunctionResponseMetadataDocument> {
    public static final String SCHEMA_NAME = "AppFunctionResponseMetadataDocument";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() throws AppSearchException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AppFunctionDataTypeMetadataDocument.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() throws AppSearchException {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(new AppSearchSchema.DocumentPropertyConfig.Builder("valueType", C$$__AppSearch__AppFunctionDataTypeMetadataDocument.SCHEMA_NAME).setCardinality(2).setShouldIndexNestedProperties(false).build()).addProperty(B7.a.d("description", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppFunctionResponseMetadataDocument fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) throws AppSearchException {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("valueType");
        String str = null;
        AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument = propertyDocument != null ? (AppFunctionDataTypeMetadataDocument) propertyDocument.toDocumentClass(AppFunctionDataTypeMetadataDocument.class, documentClassMappingContext) : null;
        String[] propertyStringArray = genericDocument.getPropertyStringArray("description");
        if (propertyStringArray != null && propertyStringArray.length != 0) {
            str = propertyStringArray[0];
        }
        return new AppFunctionResponseMetadataDocument(namespace, id, appFunctionDataTypeMetadataDocument, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument) throws AppSearchException, IllegalArgumentException {
        GenericDocument.Builder builder = new GenericDocument.Builder(appFunctionResponseMetadataDocument.getNamespace(), appFunctionResponseMetadataDocument.getId(), SCHEMA_NAME);
        AppFunctionDataTypeMetadataDocument valueType = appFunctionResponseMetadataDocument.getValueType();
        if (valueType != null) {
            builder.setPropertyDocument("valueType", GenericDocument.fromDocumentClass(valueType));
        }
        String description = appFunctionResponseMetadataDocument.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        return builder.build();
    }
}
