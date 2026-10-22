package androidx.appsearch.app;

import android.annotation.SuppressLint;
import n3.InterfaceFutureC1739a;

/* loaded from: classes.dex */
public interface EnterpriseGlobalSearchSession {
    InterfaceFutureC1739a getByDocumentIdAsync(String str, String str2, GetByDocumentIdRequest getByDocumentIdRequest);

    Features getFeatures();

    @SuppressLint({"KotlinPropertyAccess"})
    InterfaceFutureC1739a getSchemaAsync(String str, String str2);

    SearchResults search(String str, SearchSpec searchSpec);
}
