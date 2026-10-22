package androidx.appsearch.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.safeparcel.PackageIdentifierParcel;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public class PackageIdentifier {

    @NonNull
    private final PackageIdentifierParcel mPackageIdentifierParcel;

    public PackageIdentifier(@NonNull String str, @NonNull byte[] bArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(bArr);
        this.mPackageIdentifierParcel = new PackageIdentifierParcel(str, bArr);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PackageIdentifier) {
            return this.mPackageIdentifierParcel.equals(((PackageIdentifier) obj).getPackageIdentifierParcel());
        }
        return false;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PackageIdentifierParcel getPackageIdentifierParcel() {
        return this.mPackageIdentifierParcel;
    }

    @NonNull
    public String getPackageName() {
        return this.mPackageIdentifierParcel.getPackageName();
    }

    @NonNull
    public byte[] getSha256Certificate() {
        return this.mPackageIdentifierParcel.getSha256Certificate();
    }

    public int hashCode() {
        return this.mPackageIdentifierParcel.hashCode();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PackageIdentifier(@NonNull PackageIdentifierParcel packageIdentifierParcel) {
        this.mPackageIdentifierParcel = (PackageIdentifierParcel) Preconditions.checkNotNull(packageIdentifierParcel);
    }
}
