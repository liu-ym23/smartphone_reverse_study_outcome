package androidx.appsearch.app;

import androidx.appsearch.exceptions.AppSearchException;
import java.util.List;

/* loaded from: classes.dex */
public interface DocumentClassFactory<T> {
    @ExperimentalAppSearchApi
    T fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) throws AppSearchException;

    List<Class<?>> getDependencyDocumentClasses() throws AppSearchException;

    AppSearchSchema getSchema() throws AppSearchException;

    String getSchemaName();

    GenericDocument toGenericDocument(T t9) throws AppSearchException;
}
