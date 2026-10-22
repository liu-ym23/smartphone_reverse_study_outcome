package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.GenericDocument;
import android.app.appsearch.GetByDocumentIdRequest;
import android.app.appsearch.PutDocumentsRequest;
import android.app.appsearch.RemoveByDocumentIdRequest;
import android.app.appsearch.ReportSystemUsageRequest;
import android.app.appsearch.ReportUsageRequest;
import android.app.appsearch.exceptions.AppSearchException;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class RequestToPlatformConverter {

    @RequiresApi(35)
    public static class ApiHelperForV {
        private ApiHelperForV() {
        }

        @DoNotInline
        public static void addTakenActionGenericDocuments(PutDocumentsRequest.Builder builder, GenericDocument genericDocument) {
            try {
                builder.addTakenActionGenericDocuments(new GenericDocument[]{genericDocument});
            } catch (AppSearchException e) {
                throw new RuntimeException("Unexpected AppSearchException which should not be possible", e);
            }
        }
    }

    private RequestToPlatformConverter() {
    }

    public static GetByDocumentIdRequest toPlatformGetByDocumentIdRequest(androidx.appsearch.app.GetByDocumentIdRequest getByDocumentIdRequest) {
        Preconditions.checkNotNull(getByDocumentIdRequest);
        GetByDocumentIdRequest.Builder builderAddIds = new GetByDocumentIdRequest.Builder(getByDocumentIdRequest.getNamespace()).addIds(getByDocumentIdRequest.getIds());
        for (Map.Entry<String, List<String>> entry : getByDocumentIdRequest.getProjections().entrySet()) {
            builderAddIds.addProjection(entry.getKey(), entry.getValue());
        }
        return builderAddIds.build();
    }

    public static PutDocumentsRequest toPlatformPutDocumentsRequest(androidx.appsearch.app.PutDocumentsRequest putDocumentsRequest) {
        Preconditions.checkNotNull(putDocumentsRequest);
        PutDocumentsRequest.Builder builder = new PutDocumentsRequest.Builder();
        Iterator<androidx.appsearch.app.GenericDocument> it = putDocumentsRequest.getGenericDocuments().iterator();
        while (it.hasNext()) {
            builder.addGenericDocuments(GenericDocumentToPlatformConverter.toPlatformGenericDocument(it.next()));
        }
        for (androidx.appsearch.app.GenericDocument genericDocument : putDocumentsRequest.getTakenActionGenericDocuments()) {
            if (Build.VERSION.SDK_INT >= 35) {
                ApiHelperForV.addTakenActionGenericDocuments(builder, GenericDocumentToPlatformConverter.toPlatformGenericDocument(genericDocument));
            } else {
                builder.addGenericDocuments(GenericDocumentToPlatformConverter.toPlatformGenericDocument(genericDocument));
            }
        }
        return builder.build();
    }

    public static RemoveByDocumentIdRequest toPlatformRemoveByDocumentIdRequest(androidx.appsearch.app.RemoveByDocumentIdRequest removeByDocumentIdRequest) {
        Preconditions.checkNotNull(removeByDocumentIdRequest);
        return new RemoveByDocumentIdRequest.Builder(removeByDocumentIdRequest.getNamespace()).addIds(removeByDocumentIdRequest.getIds()).build();
    }

    public static ReportSystemUsageRequest toPlatformReportSystemUsageRequest(androidx.appsearch.app.ReportSystemUsageRequest reportSystemUsageRequest) {
        Preconditions.checkNotNull(reportSystemUsageRequest);
        return new ReportSystemUsageRequest.Builder(reportSystemUsageRequest.getPackageName(), reportSystemUsageRequest.getDatabaseName(), reportSystemUsageRequest.getNamespace(), reportSystemUsageRequest.getDocumentId()).setUsageTimestampMillis(reportSystemUsageRequest.getUsageTimestampMillis()).build();
    }

    public static ReportUsageRequest toPlatformReportUsageRequest(androidx.appsearch.app.ReportUsageRequest reportUsageRequest) {
        Preconditions.checkNotNull(reportUsageRequest);
        return new ReportUsageRequest.Builder(reportUsageRequest.getNamespace(), reportUsageRequest.getDocumentId()).setUsageTimestampMillis(reportUsageRequest.getUsageTimestampMillis()).build();
    }
}
