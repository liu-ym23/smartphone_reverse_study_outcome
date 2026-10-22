package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.core.util.Preconditions;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SafeParcelable.Class(creator = "InternalSetSchemaResponseCreator")
/* loaded from: classes.dex */
public class InternalSetSchemaResponse extends AbstractSafeParcelable {

    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<InternalSetSchemaResponse> CREATOR = new StubCreators.InternalSetSchemaResponseCreator();

    @AbstractSafeParcelable.Field(getter = "getErrorMessage", id = 3)
    private final String mErrorMessage;

    @AbstractSafeParcelable.Field(getter = "isSuccess", id = 1)
    private final boolean mIsSuccess;

    @AbstractSafeParcelable.Field(getter = "getSetSchemaResponse", id = 2)
    private final SetSchemaResponse mSetSchemaResponse;

    @AbstractSafeParcelable.Constructor
    public InternalSetSchemaResponse(@AbstractSafeParcelable.Param(id = 1) boolean z10, @AbstractSafeParcelable.Param(id = 2) SetSchemaResponse setSchemaResponse, @AbstractSafeParcelable.Param(id = 3) String str) {
        Preconditions.checkNotNull(setSchemaResponse);
        this.mIsSuccess = z10;
        this.mSetSchemaResponse = setSchemaResponse;
        this.mErrorMessage = str;
    }

    public static InternalSetSchemaResponse newFailedSetSchemaResponse(SetSchemaResponse setSchemaResponse, String str) {
        return new InternalSetSchemaResponse(false, setSchemaResponse, str);
    }

    public static InternalSetSchemaResponse newSuccessfulSetSchemaResponse(SetSchemaResponse setSchemaResponse) {
        return new InternalSetSchemaResponse(true, setSchemaResponse, null);
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public SetSchemaResponse getSetSchemaResponse() {
        return this.mSetSchemaResponse;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }
}
