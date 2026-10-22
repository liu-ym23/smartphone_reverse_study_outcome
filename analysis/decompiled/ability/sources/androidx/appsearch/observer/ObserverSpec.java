package androidx.appsearch.observer;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.app.DocumentClassFactoryRegistry;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.SafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.safeparcel.stub.StubCreators;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SafeParcelable.Class(creator = "ObserverSpecCreator")
/* loaded from: classes.dex */
public final class ObserverSpec extends AbstractSafeParcelable {

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Parcelable.Creator<ObserverSpec> CREATOR = new StubCreators.ObserverSpecCreator();

    @AbstractSafeParcelable.Field(id = 1)
    final List<String> mFilterSchemas;

    @Nullable
    private volatile Set<String> mFilterSchemasCached;

    @AbstractSafeParcelable.Constructor
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ObserverSpec(@NonNull @AbstractSafeParcelable.Param(id = 1) List<String> list) {
        this.mFilterSchemas = (List) Preconditions.checkNotNull(list);
    }

    @NonNull
    public Set<String> getFilterSchemas() {
        if (this.mFilterSchemasCached == null) {
            List<String> list = this.mFilterSchemas;
            if (list == null) {
                this.mFilterSchemasCached = Collections.EMPTY_SET;
            } else {
                this.mFilterSchemasCached = Collections.unmodifiableSet(new ArraySet(list));
            }
        }
        return this.mFilterSchemasCached;
    }

    @Override // androidx.appsearch.safeparcel.AbstractSafeParcelable
    @FlaggedApi(Flags.FLAG_ENABLE_SAFE_PARCELABLE_2)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        AbstractCreator.writeToParcel(this, parcel, i);
    }

    public static final class Builder {
        private ArrayList<String> mFilterSchemas = new ArrayList<>();
        private boolean mBuilt = false;

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mFilterSchemas = new ArrayList<>(this.mFilterSchemas);
                this.mBuilt = false;
            }
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder addFilterDocumentClasses(@NonNull Class<?>... clsArr) throws AppSearchException {
            Preconditions.checkNotNull(clsArr);
            resetIfBuilt();
            return addFilterDocumentClasses(Arrays.asList(clsArr));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addFilterSchemas(@NonNull String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterSchemas(Arrays.asList(strArr));
        }

        @NonNull
        public ObserverSpec build() {
            this.mBuilt = true;
            return new ObserverSpec(this.mFilterSchemas);
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder addFilterDocumentClasses(@NonNull Collection<? extends Class<?>> collection) throws AppSearchException {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList arrayList = new ArrayList(collection.size());
            DocumentClassFactoryRegistry documentClassFactoryRegistry = DocumentClassFactoryRegistry.getInstance();
            Iterator<? extends Class<?>> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(documentClassFactoryRegistry.getOrCreateFactory((Class) it.next()).getSchemaName());
            }
            addFilterSchemas(arrayList);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addFilterSchemas(@NonNull Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mFilterSchemas.addAll(collection);
            return this;
        }
    }
}
