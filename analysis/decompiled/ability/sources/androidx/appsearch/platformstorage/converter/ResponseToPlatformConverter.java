package androidx.appsearch.platformstorage.converter;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.StorageInfo;
import androidx.core.util.Preconditions;

@RequiresApi(31)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class ResponseToPlatformConverter {
    private ResponseToPlatformConverter() {
    }

    public static StorageInfo toJetpackStorageInfo(android.app.appsearch.StorageInfo storageInfo) {
        Preconditions.checkNotNull(storageInfo);
        return new StorageInfo.Builder().setAliveNamespacesCount(storageInfo.getAliveNamespacesCount()).setAliveDocumentsCount(storageInfo.getAliveDocumentsCount()).setSizeBytes(storageInfo.getSizeBytes()).build();
    }
}
