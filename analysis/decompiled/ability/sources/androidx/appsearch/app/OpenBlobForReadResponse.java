package androidx.appsearch.app;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.appsearch.app.aidl.AppSearchBatchResultParcelV2;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.core.util.Preconditions;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;

@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
@SafeParcelable.Class(creator = "OpenBlobForReadResponseCreator")
/* loaded from: classes.dex */
public final class OpenBlobForReadResponse extends AbstractSafeParcelable implements Closeable {

    @NonNull
    public static final Parcelable.Creator<OpenBlobForReadResponse> CREATOR = new StubCreators.OpenBlobForReadResponseCreator();

    @AbstractSafeParcelable.Field(id = 1)
    final AppSearchBatchResultParcelV2<AppSearchBlobHandle, ParcelFileDescriptor> mResultParcel;

    public OpenBlobForReadResponse(@NonNull AppSearchBatchResult<AppSearchBlobHandle, ParcelFileDescriptor> appSearchBatchResult) {
        this(AppSearchBatchResultParcelV2.fromBlobHandleToPfd(appSearchBatchResult));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator<ParcelFileDescriptor> it = this.mResultParcel.getResult().getSuccesses().values().iterator();
        while (it.hasNext()) {
            try {
                it.next().close();
            } catch (IOException unused) {
            }
        }
    }

    @NonNull
    public AppSearchBatchResult<AppSearchBlobHandle, ParcelFileDescriptor> getResult() {
        return this.mResultParcel.getResult();
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    @AbstractSafeParcelable.Constructor
    public OpenBlobForReadResponse(@NonNull @AbstractSafeParcelable.Param(id = 1) AppSearchBatchResultParcelV2<AppSearchBlobHandle, ParcelFileDescriptor> appSearchBatchResultParcelV2) {
        this.mResultParcel = (AppSearchBatchResultParcelV2) Preconditions.checkNotNull(appSearchBatchResultParcelV2);
    }
}
