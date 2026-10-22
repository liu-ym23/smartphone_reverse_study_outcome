package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appsearch.app.aidl.AppSearchBatchResultParcelV2;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.core.util.Preconditions;

@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
@SafeParcelable.Class(creator = "CommitBlobResponseCreator")
/* loaded from: classes.dex */
public final class CommitBlobResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<CommitBlobResponse> CREATOR = new StubCreators.CommitBlobResponseCreator();

    @AbstractSafeParcelable.Field(getter = "getResponseParcel", id = 1)
    private final AppSearchBatchResultParcelV2<AppSearchBlobHandle, Void> mResultParcel;

    public CommitBlobResponse(@NonNull AppSearchBatchResult<AppSearchBlobHandle, Void> appSearchBatchResult) {
        this(AppSearchBatchResultParcelV2.fromBlobHandleToVoid(appSearchBatchResult));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public AppSearchBatchResultParcelV2<AppSearchBlobHandle, Void> getResponseParcel() {
        return this.mResultParcel;
    }

    @NonNull
    public AppSearchBatchResult<AppSearchBlobHandle, Void> getResult() {
        return this.mResultParcel.getResult();
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    @AbstractSafeParcelable.Constructor
    public CommitBlobResponse(@NonNull @AbstractSafeParcelable.Param(id = 1) AppSearchBatchResultParcelV2<AppSearchBlobHandle, Void> appSearchBatchResultParcelV2) {
        this.mResultParcel = (AppSearchBatchResultParcelV2) Preconditions.checkNotNull(appSearchBatchResultParcelV2);
    }
}
