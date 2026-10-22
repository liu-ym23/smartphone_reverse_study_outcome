package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.core.util.Preconditions;
import java.util.Arrays;
import java.util.Objects;

@FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
@SafeParcelable.Class(creator = "EmbeddingVectorCreator")
/* loaded from: classes.dex */
public final class EmbeddingVector extends AbstractSafeParcelable {

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<EmbeddingVector> CREATOR = new StubCreators.EmbeddingVectorCreator();

    @Nullable
    private Integer mHashCode;

    @NonNull
    @AbstractSafeParcelable.Field(getter = "getModelSignature", id = 2)
    private final String mModelSignature;

    @NonNull
    @AbstractSafeParcelable.Field(getter = "getValues", id = 1)
    private final float[] mValues;

    @AbstractSafeParcelable.Constructor
    public EmbeddingVector(@NonNull @AbstractSafeParcelable.Param(id = 1) float[] fArr, @NonNull @AbstractSafeParcelable.Param(id = 2) String str) {
        float[] fArr2 = (float[]) Preconditions.checkNotNull(fArr);
        this.mValues = fArr2;
        if (fArr2.length == 0) {
            throw new IllegalArgumentException("Embedding values cannot be empty.");
        }
        this.mModelSignature = (String) Preconditions.checkNotNull(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EmbeddingVector)) {
            return false;
        }
        EmbeddingVector embeddingVector = (EmbeddingVector) obj;
        return Arrays.equals(this.mValues, embeddingVector.mValues) && this.mModelSignature.equals(embeddingVector.mModelSignature);
    }

    @NonNull
    public String getModelSignature() {
        return this.mModelSignature;
    }

    @NonNull
    public float[] getValues() {
        return this.mValues;
    }

    public int hashCode() {
        if (this.mHashCode == null) {
            this.mHashCode = Integer.valueOf(Objects.hash(Integer.valueOf(Arrays.hashCode(this.mValues)), this.mModelSignature));
        }
        return this.mHashCode.intValue();
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }
}
