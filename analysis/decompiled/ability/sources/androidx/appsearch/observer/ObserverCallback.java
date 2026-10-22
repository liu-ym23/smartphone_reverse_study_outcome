package androidx.appsearch.observer;

/* loaded from: classes.dex */
public interface ObserverCallback {
    void onDocumentChanged(DocumentChangeInfo documentChangeInfo);

    void onSchemaChanged(SchemaChangeInfo schemaChangeInfo);
}
