package androidx.appsearch.app;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.usagereporting.TakenAction;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PutDocumentsRequest {
    private final List<GenericDocument> mDocuments;
    private final List<GenericDocument> mTakenActions;

    public PutDocumentsRequest(List<GenericDocument> list, List<GenericDocument> list2) {
        this.mDocuments = list;
        this.mTakenActions = list2;
    }

    @NonNull
    public List<GenericDocument> getGenericDocuments() {
        return Collections.unmodifiableList(this.mDocuments);
    }

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_PUT_DOCUMENTS_REQUEST_ADD_TAKEN_ACTIONS)
    public List<GenericDocument> getTakenActionGenericDocuments() {
        return Collections.unmodifiableList(this.mTakenActions);
    }

    public static final class Builder {
        private ArrayList<GenericDocument> mDocuments = new ArrayList<>();
        private ArrayList<GenericDocument> mTakenActions = new ArrayList<>();
        private boolean mBuilt = false;

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mDocuments = new ArrayList<>(this.mDocuments);
                this.mTakenActions = new ArrayList<>(this.mTakenActions);
                this.mBuilt = false;
            }
        }

        @NonNull
        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addDocuments(@NonNull Object... objArr) throws AppSearchException {
            Preconditions.checkNotNull(objArr);
            resetIfBuilt();
            return addDocuments(Arrays.asList(objArr));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addGenericDocuments(@NonNull GenericDocument... genericDocumentArr) {
            Preconditions.checkNotNull(genericDocumentArr);
            resetIfBuilt();
            return addGenericDocuments(Arrays.asList(genericDocumentArr));
        }

        @NonNull
        @FlaggedApi(Flags.FLAG_ENABLE_PUT_DOCUMENTS_REQUEST_ADD_TAKEN_ACTIONS)
        @CanIgnoreReturnValue
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder addTakenActionGenericDocuments(@NonNull GenericDocument... genericDocumentArr) throws AppSearchException {
            Preconditions.checkNotNull(genericDocumentArr);
            resetIfBuilt();
            return addTakenActionGenericDocuments(Arrays.asList(genericDocumentArr));
        }

        @NonNull
        @CanIgnoreReturnValue
        @ExperimentalAppSearchApi
        public Builder addTakenActions(@NonNull TakenAction... takenActionArr) throws AppSearchException {
            Preconditions.checkNotNull(takenActionArr);
            resetIfBuilt();
            return addTakenActions(Arrays.asList(takenActionArr));
        }

        @NonNull
        public PutDocumentsRequest build() {
            this.mBuilt = true;
            ArraySet arraySet = new ArraySet();
            for (int i = 0; i < this.mDocuments.size(); i++) {
                arraySet.add(this.mDocuments.get(i).getId());
            }
            for (int i6 = 0; i6 < this.mTakenActions.size(); i6++) {
                GenericDocument genericDocument = this.mTakenActions.get(i6);
                if (arraySet.contains(genericDocument.getId())) {
                    throw new IllegalArgumentException("Document id " + genericDocument.getId() + " cannot exist in both taken action and normal document");
                }
            }
            return new PutDocumentsRequest(this.mDocuments, this.mTakenActions);
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        @CanIgnoreReturnValue
        public Builder addDocuments(@NonNull Collection<?> collection) throws AppSearchException {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(GenericDocument.fromDocumentClass(it.next()));
            }
            return addGenericDocuments(arrayList);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addGenericDocuments(@NonNull Collection<? extends GenericDocument> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mDocuments.addAll(collection);
            return this;
        }

        @NonNull
        @FlaggedApi(Flags.FLAG_ENABLE_PUT_DOCUMENTS_REQUEST_ADD_TAKEN_ACTIONS)
        @CanIgnoreReturnValue
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder addTakenActionGenericDocuments(@NonNull Collection<? extends GenericDocument> collection) throws AppSearchException {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mTakenActions.addAll(collection);
            return this;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @CanIgnoreReturnValue
        public Builder addTakenActions(@NonNull Collection<? extends TakenAction> collection) throws AppSearchException {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<? extends TakenAction> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(GenericDocument.fromDocumentClass(it.next()));
            }
            this.mTakenActions.addAll(arrayList);
            return this;
        }
    }
}
