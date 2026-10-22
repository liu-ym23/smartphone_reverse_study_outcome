package androidx.appsearch.app;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcel;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.annotation.SystemApi;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.safeparcel.GenericDocumentParcel;
import androidx.appsearch.util.IndentingStringBuilder;
import androidx.collection.SieveCacheKt;
import androidx.core.os.ParcelCompat;
import androidx.core.util.Preconditions;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class GenericDocument {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final GenericDocument EMPTY = new Builder("", "", "").build();
    private static final int MAX_INDEXED_PROPERTIES = 16;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String PARENT_TYPES_SYNTHETIC_PROPERTY = "$$__AppSearch__parentTypes";
    private static final String TAG = "AppSearchGenericDocumen";
    private final GenericDocumentParcel mDocumentParcel;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public GenericDocument(@NonNull GenericDocumentParcel genericDocumentParcel) {
        Objects.requireNonNull(genericDocumentParcel);
        this.mDocumentParcel = genericDocumentParcel;
    }

    private void appendPropertyString(@NonNull String str, @NonNull Object obj, @NonNull IndentingStringBuilder indentingStringBuilder) throws IllegalStateException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(indentingStringBuilder);
        indentingStringBuilder.append("\"").append(str).append("\": [");
        int i = 0;
        if (obj instanceof GenericDocument[]) {
            GenericDocument[] genericDocumentArr = (GenericDocument[]) obj;
            while (i < genericDocumentArr.length) {
                indentingStringBuilder.append("\n");
                indentingStringBuilder.increaseIndentLevel();
                genericDocumentArr[i].appendGenericDocumentString(indentingStringBuilder);
                if (i != genericDocumentArr.length - 1) {
                    indentingStringBuilder.append(",");
                }
                indentingStringBuilder.append("\n");
                indentingStringBuilder.decreaseIndentLevel();
                i++;
            }
        } else {
            int length = Array.getLength(obj);
            while (i < length) {
                Object obj2 = Array.get(obj, i);
                if (obj2 instanceof String) {
                    indentingStringBuilder.append("\"").append((String) obj2).append("\"");
                } else if (obj2 instanceof byte[]) {
                    indentingStringBuilder.append(Arrays.toString((byte[]) obj2));
                } else if (obj2 != null) {
                    indentingStringBuilder.append(obj2.toString());
                }
                if (i != length - 1) {
                    indentingStringBuilder.append(", ");
                }
                i++;
            }
        }
        indentingStringBuilder.append("]");
    }

    @NonNull
    @FlaggedApi(Flags.FLAG_ENABLE_GENERIC_DOCUMENT_OVER_IPC)
    @SystemApi(client = SystemApi.Client.MODULE_LIBRARIES)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static GenericDocument createFromParcel(@NonNull Parcel parcel) {
        Objects.requireNonNull(parcel);
        if (AppSearchEnvironmentFactory.getEnvironmentInstance().getEnvironment() != 2) {
            return new GenericDocument((GenericDocumentParcel) ParcelCompat.readParcelable(parcel, GenericDocumentParcel.class.getClassLoader(), GenericDocumentParcel.class));
        }
        return new GenericDocument(Build.VERSION.SDK_INT >= 34 ? (GenericDocumentParcel) parcel.readParcelable(GenericDocumentParcel.class.getClassLoader(), GenericDocumentParcel.class) : (GenericDocumentParcel) parcel.readParcelable(GenericDocumentParcel.class.getClassLoader()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private <T> Class<? extends T> findTargetClassToDeserialize(@NonNull Class<T> cls, @NonNull Map<String, List<String>> map, @NonNull Map<String, List<String>> map2) {
        if (map.isEmpty()) {
            return cls;
        }
        Class<? extends T> assignableClassBySchemaName = AppSearchDocumentClassMap.getAssignableClassBySchemaName(map, getSchemaType(), cls);
        if (assignableClassBySchemaName != null) {
            return assignableClassBySchemaName;
        }
        List<String> parentTypes = map2.containsKey(getSchemaType()) ? map2.get(getSchemaType()) : getParentTypes();
        if (parentTypes != null) {
            for (int i = 0; i < parentTypes.size(); i++) {
                Class<? extends T> assignableClassBySchemaName2 = AppSearchDocumentClassMap.getAssignableClassBySchemaName(map, parentTypes.get(i), cls);
                if (assignableClassBySchemaName2 != null) {
                    return assignableClassBySchemaName2;
                }
            }
        }
        Log.w(TAG, "Cannot find any compatible target class to deserialize. Perhaps the annotation processor was not run or the generated document class map was proguarded out?\nTry to deserialize to " + cls.getCanonicalName() + " directly.");
        return cls;
    }

    @Nullable
    private static Object flattenAccumulator(@NonNull List<Object> list) {
        if (list.isEmpty()) {
            return null;
        }
        Object obj = list.get(0);
        if (obj instanceof String[]) {
            int length = 0;
            for (int i = 0; i < list.size(); i++) {
                length += ((String[]) list.get(i)).length;
            }
            String[] strArr = new String[length];
            int length2 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                String[] strArr2 = (String[]) list.get(i6);
                System.arraycopy(strArr2, 0, strArr, length2, strArr2.length);
                length2 += strArr2.length;
            }
            return strArr;
        }
        if (obj instanceof long[]) {
            int length3 = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                length3 += ((long[]) list.get(i10)).length;
            }
            long[] jArr = new long[length3];
            int length4 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                long[] jArr2 = (long[]) list.get(i11);
                System.arraycopy(jArr2, 0, jArr, length4, jArr2.length);
                length4 += jArr2.length;
            }
            return jArr;
        }
        if (obj instanceof double[]) {
            int length5 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                length5 += ((double[]) list.get(i12)).length;
            }
            double[] dArr = new double[length5];
            int length6 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                double[] dArr2 = (double[]) list.get(i13);
                System.arraycopy(dArr2, 0, dArr, length6, dArr2.length);
                length6 += dArr2.length;
            }
            return dArr;
        }
        if (obj instanceof boolean[]) {
            int length7 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                length7 += ((boolean[]) list.get(i14)).length;
            }
            boolean[] zArr = new boolean[length7];
            int length8 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                boolean[] zArr2 = (boolean[]) list.get(i15);
                System.arraycopy(zArr2, 0, zArr, length8, zArr2.length);
                length8 += zArr2.length;
            }
            return zArr;
        }
        if (obj instanceof byte[][]) {
            int length9 = 0;
            for (int i16 = 0; i16 < list.size(); i16++) {
                length9 += ((byte[][]) list.get(i16)).length;
            }
            byte[][] bArr = new byte[length9][];
            int length10 = 0;
            for (int i17 = 0; i17 < list.size(); i17++) {
                byte[][] bArr2 = (byte[][]) list.get(i17);
                System.arraycopy(bArr2, 0, bArr, length10, bArr2.length);
                length10 += bArr2.length;
            }
            return bArr;
        }
        if (!(obj instanceof GenericDocumentParcel[])) {
            throw new IllegalStateException(androidx.appfunctions.metadata.a.j(obj, "Unexpected property type: "));
        }
        int length11 = 0;
        for (int i18 = 0; i18 < list.size(); i18++) {
            length11 += ((GenericDocumentParcel[]) list.get(i18)).length;
        }
        GenericDocumentParcel[] genericDocumentParcelArr = new GenericDocumentParcel[length11];
        int length12 = 0;
        for (int i19 = 0; i19 < list.size(); i19++) {
            GenericDocumentParcel[] genericDocumentParcelArr2 = (GenericDocumentParcel[]) list.get(i19);
            System.arraycopy(genericDocumentParcelArr2, 0, genericDocumentParcelArr, length12, genericDocumentParcelArr2.length);
            length12 += genericDocumentParcelArr2.length;
        }
        return genericDocumentParcelArr;
    }

    @NonNull
    public static GenericDocument fromDocumentClass(@NonNull Object obj) throws AppSearchException {
        Preconditions.checkNotNull(obj);
        return DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((DocumentClassFactoryRegistry) obj).toGenericDocument(obj);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Deprecated
    public static int getMaxIndexedProperties() {
        return 16;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    @androidx.annotation.Nullable
    @androidx.annotation.OptIn(markerClass = {androidx.appsearch.app.ExperimentalAppSearchApi.class})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object getRawPropertyFromRawDocument(@androidx.annotation.NonNull androidx.appsearch.app.PropertyPath r6, int r7, @androidx.annotation.NonNull java.util.Map<java.lang.String, androidx.appsearch.safeparcel.PropertyParcel> r8) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appsearch.app.GenericDocument.getRawPropertyFromRawDocument(androidx.appsearch.app.PropertyPath, int, java.util.Map):java.lang.Object");
    }

    @Nullable
    private static <T> T safeCastProperty(@NonNull String str, @Nullable Object obj, @NonNull Class<T> cls) {
        if (obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            Log.w(TAG, "Error casting to requested type for path \"" + str + "\"", e);
            return null;
        }
    }

    private static void warnIfSinglePropertyTooLong(@NonNull String str, @NonNull String str2, int i) {
        if (i > 1) {
            Log.w(TAG, androidx.appfunctions.metadata.a.p(androidx.appfunctions.metadata.a.t(i, "The value for \"", str2, "\" contains ", " elements. Only the first one will be returned from getProperty"), str, "(). Try getProperty", str, "Array()."));
        }
    }

    public void appendGenericDocumentString(@NonNull IndentingStringBuilder indentingStringBuilder) throws IllegalStateException {
        Preconditions.checkNotNull(indentingStringBuilder);
        indentingStringBuilder.append("{\n");
        indentingStringBuilder.increaseIndentLevel();
        indentingStringBuilder.append("namespace: \"").append(getNamespace()).append("\",\n");
        indentingStringBuilder.append("id: \"").append(getId()).append("\",\n");
        indentingStringBuilder.append("score: ").append(Integer.valueOf(getScore())).append(",\n");
        indentingStringBuilder.append("schemaType: \"").append(getSchemaType()).append("\",\n");
        List<String> parentTypes = getParentTypes();
        if (parentTypes != null) {
            indentingStringBuilder.append("parentTypes: ").append(parentTypes).append("\n");
        }
        indentingStringBuilder.append("creationTimestampMillis: ").append(Long.valueOf(getCreationTimestampMillis())).append(",\n");
        indentingStringBuilder.append("timeToLiveMillis: ").append(Long.valueOf(getTtlMillis())).append(",\n");
        indentingStringBuilder.append("properties: {\n");
        String[] strArr = (String[]) getPropertyNames().toArray(new String[0]);
        Arrays.sort(strArr);
        for (int i = 0; i < strArr.length; i++) {
            Object objCheckNotNull = Preconditions.checkNotNull(getProperty(strArr[i]));
            indentingStringBuilder.increaseIndentLevel();
            appendPropertyString(strArr[i], objCheckNotNull, indentingStringBuilder);
            if (i != strArr.length - 1) {
                indentingStringBuilder.append(",\n");
            }
            indentingStringBuilder.decreaseIndentLevel();
        }
        indentingStringBuilder.append("\n");
        indentingStringBuilder.append("}");
        indentingStringBuilder.decreaseIndentLevel();
        indentingStringBuilder.append("\n");
        indentingStringBuilder.append("}");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GenericDocument) {
            return this.mDocumentParcel.equals(((GenericDocument) obj).mDocumentParcel);
        }
        return false;
    }

    public long getCreationTimestampMillis() {
        return this.mDocumentParcel.getCreationTimestampMillis();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public GenericDocumentParcel getDocumentParcel() {
        return this.mDocumentParcel;
    }

    @NonNull
    public String getId() {
        return this.mDocumentParcel.getId();
    }

    @NonNull
    public String getNamespace() {
        return this.mDocumentParcel.getNamespace();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Deprecated
    public List<String> getParentTypes() {
        List<String> parentTypes = this.mDocumentParcel.getParentTypes();
        if (parentTypes == null) {
            return null;
        }
        return Collections.unmodifiableList(parentTypes);
    }

    @Nullable
    public Object getProperty(@NonNull String str) {
        Objects.requireNonNull(str);
        Object rawPropertyFromRawDocument = getRawPropertyFromRawDocument(new PropertyPath(str), 0, this.mDocumentParcel.getPropertyMap());
        if (rawPropertyFromRawDocument instanceof GenericDocumentParcel) {
            return new GenericDocument[]{new GenericDocument((GenericDocumentParcel) rawPropertyFromRawDocument)};
        }
        if (!(rawPropertyFromRawDocument instanceof GenericDocumentParcel[])) {
            return rawPropertyFromRawDocument;
        }
        GenericDocumentParcel[] genericDocumentParcelArr = (GenericDocumentParcel[]) rawPropertyFromRawDocument;
        GenericDocument[] genericDocumentArr = new GenericDocument[genericDocumentParcelArr.length];
        for (int i = 0; i < genericDocumentParcelArr.length; i++) {
            GenericDocumentParcel genericDocumentParcel = genericDocumentParcelArr[i];
            if (genericDocumentParcel == null) {
                Log.e(TAG, "The inner parcel is null at " + i + ", for path: " + str);
            } else {
                genericDocumentArr[i] = new GenericDocument(genericDocumentParcel);
            }
        }
        return genericDocumentArr;
    }

    @Nullable
    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    public AppSearchBlobHandle getPropertyBlobHandle(@NonNull String str) {
        Preconditions.checkNotNull(str);
        AppSearchBlobHandle[] propertyBlobHandleArray = getPropertyBlobHandleArray(str);
        if (propertyBlobHandleArray == null || propertyBlobHandleArray.length == 0) {
            return null;
        }
        warnIfSinglePropertyTooLong("BlobHandle", str, propertyBlobHandleArray.length);
        return propertyBlobHandleArray[0];
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    @Nullable
    public AppSearchBlobHandle[] getPropertyBlobHandleArray(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return (AppSearchBlobHandle[]) safeCastProperty(str, getProperty(str), AppSearchBlobHandle[].class);
    }

    public boolean getPropertyBoolean(@NonNull String str) {
        Preconditions.checkNotNull(str);
        boolean[] propertyBooleanArray = getPropertyBooleanArray(str);
        if (propertyBooleanArray == null || propertyBooleanArray.length == 0) {
            return false;
        }
        warnIfSinglePropertyTooLong("Boolean", str, propertyBooleanArray.length);
        return propertyBooleanArray[0];
    }

    @Nullable
    public boolean[] getPropertyBooleanArray(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return (boolean[]) safeCastProperty(str, getProperty(str), boolean[].class);
    }

    @Nullable
    public byte[] getPropertyBytes(@NonNull String str) {
        Preconditions.checkNotNull(str);
        byte[][] propertyBytesArray = getPropertyBytesArray(str);
        if (propertyBytesArray == null || propertyBytesArray.length == 0) {
            return null;
        }
        warnIfSinglePropertyTooLong("ByteArray", str, propertyBytesArray.length);
        return propertyBytesArray[0];
    }

    @Nullable
    @SuppressLint({"ArrayReturn"})
    public byte[][] getPropertyBytesArray(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return (byte[][]) safeCastProperty(str, getProperty(str), byte[][].class);
    }

    @Nullable
    public GenericDocument getPropertyDocument(@NonNull String str) {
        Preconditions.checkNotNull(str);
        GenericDocument[] propertyDocumentArray = getPropertyDocumentArray(str);
        if (propertyDocumentArray == null || propertyDocumentArray.length == 0) {
            return null;
        }
        warnIfSinglePropertyTooLong("Document", str, propertyDocumentArray.length);
        return propertyDocumentArray[0];
    }

    @Nullable
    @SuppressLint({"ArrayReturn"})
    public GenericDocument[] getPropertyDocumentArray(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return (GenericDocument[]) safeCastProperty(str, getProperty(str), GenericDocument[].class);
    }

    public double getPropertyDouble(@NonNull String str) {
        Preconditions.checkNotNull(str);
        double[] propertyDoubleArray = getPropertyDoubleArray(str);
        if (propertyDoubleArray == null || propertyDoubleArray.length == 0) {
            return 0.0d;
        }
        warnIfSinglePropertyTooLong("Double", str, propertyDoubleArray.length);
        return propertyDoubleArray[0];
    }

    @Nullable
    public double[] getPropertyDoubleArray(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return (double[]) safeCastProperty(str, getProperty(str), double[].class);
    }

    @Nullable
    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    public EmbeddingVector getPropertyEmbedding(@NonNull String str) {
        Preconditions.checkNotNull(str);
        EmbeddingVector[] propertyEmbeddingArray = getPropertyEmbeddingArray(str);
        if (propertyEmbeddingArray == null || propertyEmbeddingArray.length == 0) {
            return null;
        }
        warnIfSinglePropertyTooLong("Embedding", str, propertyEmbeddingArray.length);
        return propertyEmbeddingArray[0];
    }

    @Nullable
    @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public EmbeddingVector[] getPropertyEmbeddingArray(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return (EmbeddingVector[]) safeCastProperty(str, getProperty(str), EmbeddingVector[].class);
    }

    public long getPropertyLong(@NonNull String str) {
        Preconditions.checkNotNull(str);
        long[] propertyLongArray = getPropertyLongArray(str);
        if (propertyLongArray == null || propertyLongArray.length == 0) {
            return 0L;
        }
        warnIfSinglePropertyTooLong("Long", str, propertyLongArray.length);
        return propertyLongArray[0];
    }

    @Nullable
    public long[] getPropertyLongArray(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return (long[]) safeCastProperty(str, getProperty(str), long[].class);
    }

    @NonNull
    public Set<String> getPropertyNames() {
        return Collections.unmodifiableSet(this.mDocumentParcel.getPropertyNames());
    }

    @Nullable
    public String getPropertyString(@NonNull String str) {
        Preconditions.checkNotNull(str);
        String[] propertyStringArray = getPropertyStringArray(str);
        if (propertyStringArray == null || propertyStringArray.length == 0) {
            return null;
        }
        warnIfSinglePropertyTooLong("String", str, propertyStringArray.length);
        return propertyStringArray[0];
    }

    @Nullable
    public String[] getPropertyStringArray(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return (String[]) safeCastProperty(str, getProperty(str), String[].class);
    }

    @NonNull
    public String getSchemaType() {
        return this.mDocumentParcel.getSchemaType();
    }

    public int getScore() {
        return this.mDocumentParcel.getScore();
    }

    public long getTtlMillis() {
        return this.mDocumentParcel.getTtlMillis();
    }

    public int hashCode() {
        return this.mDocumentParcel.hashCode();
    }

    @NonNull
    @OptIn(markerClass = {ExperimentalAppSearchApi.class})
    public <T> T toDocumentClass(@NonNull Class<T> cls) throws AppSearchException {
        return (T) toDocumentClass(cls, DocumentClassMappingContext.EMPTY);
    }

    @NonNull
    public String toString() throws IllegalStateException {
        IndentingStringBuilder indentingStringBuilder = new IndentingStringBuilder();
        appendGenericDocumentString(indentingStringBuilder);
        return indentingStringBuilder.toString();
    }

    @SystemApi(client = SystemApi.Client.MODULE_LIBRARIES)
    @FlaggedApi(Flags.FLAG_ENABLE_GENERIC_DOCUMENT_OVER_IPC)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        Objects.requireNonNull(parcel);
        parcel.writeParcelable(this.mDocumentParcel, i);
    }

    @NonNull
    @ExperimentalAppSearchApi
    public <T> T toDocumentClass(@NonNull Class<T> cls, @NonNull DocumentClassMappingContext documentClassMappingContext) throws AppSearchException {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(documentClassMappingContext);
        return DocumentClassFactoryRegistry.getInstance().getOrCreateFactory((Class) findTargetClassToDeserialize(cls, documentClassMappingContext.getDocumentClassMap(), documentClassMappingContext.getParentTypeMap())).fromGenericDocument(this, documentClassMappingContext);
    }

    public GenericDocument(@NonNull GenericDocument genericDocument) {
        this(genericDocument.mDocumentParcel);
    }

    @SuppressLint({"StaticFinalBuilder"})
    public static class Builder<BuilderType extends Builder> {
        private final BuilderType mBuilderTypeInstance;
        private final GenericDocumentParcel.Builder mDocumentParcelBuilder;

        public Builder(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(str2);
            Preconditions.checkNotNull(str3);
            this.mBuilderTypeInstance = this;
            this.mDocumentParcelBuilder = new GenericDocumentParcel.Builder(str, str2, str3);
        }

        private void validatePropertyName(@NonNull String str) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Property name cannot be blank.");
            }
        }

        @NonNull
        public GenericDocument build() {
            return new GenericDocument(this.mDocumentParcelBuilder.build());
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_GENERIC_DOCUMENT_BUILDER_HIDDEN_METHODS)
        public BuilderType clearProperty(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.mDocumentParcelBuilder.clearProperty(str);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @CanIgnoreReturnValue
        public BuilderType setCreationTimestampMillis(long j5) {
            this.mDocumentParcelBuilder.setCreationTimestampMillis(j5);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_GENERIC_DOCUMENT_BUILDER_HIDDEN_METHODS)
        public BuilderType setId(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.mDocumentParcelBuilder.setId(str);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_GENERIC_DOCUMENT_BUILDER_HIDDEN_METHODS)
        public BuilderType setNamespace(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.mDocumentParcelBuilder.setNamespace(str);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @Deprecated
        @CanIgnoreReturnValue
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public BuilderType setParentTypes(@Nullable List<String> list) {
            this.mDocumentParcelBuilder.setParentTypes(list);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @ExperimentalAppSearchApi
        @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
        @CanIgnoreReturnValue
        public BuilderType setPropertyBlobHandle(@NonNull String str, @NonNull AppSearchBlobHandle... appSearchBlobHandleArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(appSearchBlobHandleArr);
            validatePropertyName(str);
            for (int i = 0; i < appSearchBlobHandleArr.length; i++) {
                if (appSearchBlobHandleArr[i] == null) {
                    throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "The BlobHandle at ", " is null."));
                }
            }
            this.mDocumentParcelBuilder.putInPropertyMap(str, appSearchBlobHandleArr);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @CanIgnoreReturnValue
        public BuilderType setPropertyBoolean(@NonNull String str, @NonNull boolean... zArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(zArr);
            validatePropertyName(str);
            this.mDocumentParcelBuilder.putInPropertyMap(str, zArr);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @CanIgnoreReturnValue
        public BuilderType setPropertyBytes(@NonNull String str, @NonNull byte[]... bArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(bArr);
            validatePropertyName(str);
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] == null) {
                    throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "The byte[] at ", " is null."));
                }
            }
            this.mDocumentParcelBuilder.putInPropertyMap(str, bArr);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @CanIgnoreReturnValue
        public BuilderType setPropertyDocument(@NonNull String str, @NonNull GenericDocument... genericDocumentArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(genericDocumentArr);
            validatePropertyName(str);
            GenericDocumentParcel[] genericDocumentParcelArr = new GenericDocumentParcel[genericDocumentArr.length];
            for (int i = 0; i < genericDocumentArr.length; i++) {
                GenericDocument genericDocument = genericDocumentArr[i];
                if (genericDocument == null) {
                    throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "The document at ", " is null."));
                }
                genericDocumentParcelArr[i] = genericDocument.getDocumentParcel();
            }
            this.mDocumentParcelBuilder.putInPropertyMap(str, genericDocumentParcelArr);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @CanIgnoreReturnValue
        public BuilderType setPropertyDouble(@NonNull String str, @NonNull double... dArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(dArr);
            validatePropertyName(str);
            this.mDocumentParcelBuilder.putInPropertyMap(str, dArr);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_SCHEMA_EMBEDDING_PROPERTY_CONFIG)
        public BuilderType setPropertyEmbedding(@NonNull String str, @NonNull EmbeddingVector... embeddingVectorArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(embeddingVectorArr);
            validatePropertyName(str);
            for (int i = 0; i < embeddingVectorArr.length; i++) {
                if (embeddingVectorArr[i] == null) {
                    throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "The EmbeddingVector at ", " is null."));
                }
            }
            this.mDocumentParcelBuilder.putInPropertyMap(str, embeddingVectorArr);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @CanIgnoreReturnValue
        public BuilderType setPropertyLong(@NonNull String str, @NonNull long... jArr) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(jArr);
            validatePropertyName(str);
            this.mDocumentParcelBuilder.putInPropertyMap(str, jArr);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @CanIgnoreReturnValue
        public BuilderType setPropertyString(@NonNull String str, @NonNull String... strArr) throws IllegalArgumentException {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(strArr);
            validatePropertyName(str);
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i] == null) {
                    throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "The String at ", " is null."));
                }
            }
            this.mDocumentParcelBuilder.putInPropertyMap(str, strArr);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @CanIgnoreReturnValue
        @FlaggedApi(Flags.FLAG_ENABLE_GENERIC_DOCUMENT_BUILDER_HIDDEN_METHODS)
        public BuilderType setSchemaType(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.mDocumentParcelBuilder.setSchemaType(str);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @CanIgnoreReturnValue
        public BuilderType setScore(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT, to = SieveCacheKt.NodeLinkMask) int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Document score cannot be negative.");
            }
            this.mDocumentParcelBuilder.setScore(i);
            return this.mBuilderTypeInstance;
        }

        @NonNull
        @CanIgnoreReturnValue
        public BuilderType setTtlMillis(long j5) {
            if (j5 < 0) {
                throw new IllegalArgumentException("Document ttlMillis cannot be negative.");
            }
            this.mDocumentParcelBuilder.setTtlMillis(j5);
            return this.mBuilderTypeInstance;
        }

        public Builder(@NonNull GenericDocumentParcel.Builder builder) {
            Objects.requireNonNull(builder);
            this.mDocumentParcelBuilder = builder;
            this.mBuilderTypeInstance = this;
        }

        @FlaggedApi(Flags.FLAG_ENABLE_GENERIC_DOCUMENT_COPY_CONSTRUCTOR)
        public Builder(@NonNull GenericDocument genericDocument) {
            this(new GenericDocumentParcel.Builder(genericDocument.mDocumentParcel));
        }
    }
}
