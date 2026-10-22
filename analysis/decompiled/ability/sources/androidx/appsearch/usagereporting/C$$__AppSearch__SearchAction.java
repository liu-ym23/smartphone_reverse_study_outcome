package androidx.appsearch.usagereporting;

import B7.a;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.usagereporting.SearchAction;
import java.util.Collections;
import java.util.List;

/* renamed from: androidx.appsearch.usagereporting.$$__AppSearch__SearchAction, reason: invalid class name */
/* loaded from: classes.dex */
public final class C$$__AppSearch__SearchAction implements DocumentClassFactory<SearchAction> {
    public static final String SCHEMA_NAME = "builtin:SearchAction";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() throws AppSearchException {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() throws AppSearchException {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(new AppSearchSchema.LongPropertyConfig.Builder("actionType").setCardinality(2).setIndexingType(0).build()).addProperty(a.d("query", 2, 1, 2, 0)).addProperty(new AppSearchSchema.LongPropertyConfig.Builder("fetchedResultCount").setCardinality(2).setIndexingType(0).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public SearchAction fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) throws AppSearchException {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        long ttlMillis = genericDocument.getTtlMillis();
        long creationTimestampMillis = genericDocument.getCreationTimestampMillis();
        int propertyLong = (int) genericDocument.getPropertyLong("actionType");
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        int propertyLong2 = (int) genericDocument.getPropertyLong("fetchedResultCount");
        SearchAction.Builder builder = new SearchAction.Builder(namespace, id, creationTimestampMillis, propertyLong);
        builder.setDocumentTtlMillis(ttlMillis);
        builder.setQuery(str);
        builder.setFetchedResultCount(propertyLong2);
        return builder.build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(SearchAction searchAction) throws AppSearchException, IllegalArgumentException {
        GenericDocument.Builder builder = new GenericDocument.Builder(searchAction.getNamespace(), searchAction.getId(), SCHEMA_NAME);
        builder.setTtlMillis(searchAction.getDocumentTtlMillis());
        builder.setCreationTimestampMillis(searchAction.getActionTimestampMillis());
        builder.setPropertyLong("actionType", searchAction.getActionType());
        String query = searchAction.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        builder.setPropertyLong("fetchedResultCount", searchAction.getFetchedResultCount());
        return builder.build();
    }
}
