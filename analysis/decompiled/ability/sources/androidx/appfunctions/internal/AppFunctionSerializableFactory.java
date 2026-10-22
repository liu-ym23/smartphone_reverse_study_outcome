package androidx.appfunctions.internal;

import D7.w;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.AppFunctionData;
import androidx.appfunctions.metadata.AppFunctionAllOfTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionComponentsMetadata;
import androidx.appfunctions.metadata.AppFunctionDataTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import androidx.appfunctions.metadata.AppFunctionObjectTypeMetadata;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0011J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", ExifInterface.GPS_DIRECTION_TRUE, "", "fromAppFunctionData", "appFunctionData", "Landroidx/appfunctions/AppFunctionData;", "(Landroidx/appfunctions/AppFunctionData;)Ljava/lang/Object;", "toAppFunctionData", "appFunctionSerializable", "(Ljava/lang/Object;)Landroidx/appfunctions/AppFunctionData;", "getAppFunctionComponentsMetadata", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "getAppFunctionDataBuilder", "Landroidx/appfunctions/AppFunctionData$Builder;", "qualifiedName", "", "getAppFunctionDataWithSpec", "TypeParameter", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RequiresApi(33)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public interface AppFunctionSerializableFactory<T> {

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0004\u000f\u0010\u0011\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0001H'¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\r\u0010\u000e\u0082\u0001\u0004\u0013\u0014\u0015\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/appfunctions/AppFunctionData$Builder;", "appFunctionDataBuilder", "", "key", "value", "LC7/r;", "setValueInAppFunctionData", "(Landroidx/appfunctions/AppFunctionData$Builder;Ljava/lang/String;Ljava/lang/Object;)V", "Landroidx/appfunctions/AppFunctionData;", "appFunctionData", "getFromAppFunctionData", "(Landroidx/appfunctions/AppFunctionData;Ljava/lang/String;)Ljava/lang/Object;", "PrimitiveTypeParameter", "PrimitiveListTypeParameter", "SerializableTypeParameter", "SerializableListTypeParameter", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$PrimitiveListTypeParameter;", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$PrimitiveTypeParameter;", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$SerializableListTypeParameter;", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$SerializableTypeParameter;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface TypeParameter<T> {

        @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u000e\b\u0003\u0010\u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0012\u0004\u0012\u00028\u00030\u0004B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u0003H\u0017¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010\u0016¨\u0006%"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$PrimitiveListTypeParameter;", "I", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter;", "Ljava/lang/Class;", "itemClazz", AppAgent.CONSTRUCT, "(Ljava/lang/Class;)V", "Landroidx/appfunctions/AppFunctionData$Builder;", "appFunctionDataBuilder", "", "key", "value", "LC7/r;", "setValueInAppFunctionData", "(Landroidx/appfunctions/AppFunctionData$Builder;Ljava/lang/String;Ljava/util/List;)V", "Landroidx/appfunctions/AppFunctionData;", "appFunctionData", "getFromAppFunctionData", "(Landroidx/appfunctions/AppFunctionData;Ljava/lang/String;)Ljava/util/List;", "component1", "()Ljava/lang/Class;", "copy", "(Ljava/lang/Class;)Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$PrimitiveListTypeParameter;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Class;", "getItemClazz", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class PrimitiveListTypeParameter<I, T extends List<?>> implements TypeParameter<T> {
            private final Class<I> itemClazz;

            public PrimitiveListTypeParameter(Class<I> itemClazz) {
                k.f(itemClazz, "itemClazz");
                this.itemClazz = itemClazz;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ PrimitiveListTypeParameter copy$default(PrimitiveListTypeParameter primitiveListTypeParameter, Class cls, int i, Object obj) {
                if ((i & 1) != 0) {
                    cls = primitiveListTypeParameter.itemClazz;
                }
                return primitiveListTypeParameter.copy(cls);
            }

            public final Class<I> component1() {
                return this.itemClazz;
            }

            public final PrimitiveListTypeParameter<I, T> copy(Class<I> itemClazz) {
                k.f(itemClazz, "itemClazz");
                return new PrimitiveListTypeParameter<>(itemClazz);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PrimitiveListTypeParameter) && k.b(this.itemClazz, ((PrimitiveListTypeParameter) other).itemClazz);
            }

            public final Class<I> getItemClazz() {
                return this.itemClazz;
            }

            public int hashCode() {
                return this.itemClazz.hashCode();
            }

            public String toString() {
                return "PrimitiveListTypeParameter(itemClazz=" + this.itemClazz + ')';
            }

            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            @RequiresApi(33)
            public T getFromAppFunctionData(AppFunctionData appFunctionData, String key) {
                k.f(appFunctionData, "appFunctionData");
                k.f(key, "key");
                if (k.b(this.itemClazz, String.class)) {
                    return appFunctionData.getStringList(key);
                }
                throw new IllegalStateException("Unsupported item type for primitive list: " + this.itemClazz + '.');
            }

            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            @RequiresApi(33)
            public void setValueInAppFunctionData(AppFunctionData.Builder appFunctionDataBuilder, String key, T value) {
                k.f(appFunctionDataBuilder, "appFunctionDataBuilder");
                k.f(key, "key");
                if (value == null) {
                    return;
                }
                if (k.b(this.itemClazz, String.class)) {
                    appFunctionDataBuilder.setStringList(key, value);
                    return;
                }
                throw new IllegalStateException("Unsupported item type for primitive list: " + this.itemClazz + '.');
            }
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0002H\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00028\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b\"\u0010\u0014¨\u0006#"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$PrimitiveTypeParameter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter;", "Ljava/lang/Class;", "clazz", AppAgent.CONSTRUCT, "(Ljava/lang/Class;)V", "Landroidx/appfunctions/AppFunctionData$Builder;", "appFunctionDataBuilder", "", "key", "value", "LC7/r;", "setValueInAppFunctionData", "(Landroidx/appfunctions/AppFunctionData$Builder;Ljava/lang/String;Ljava/lang/Object;)V", "Landroidx/appfunctions/AppFunctionData;", "appFunctionData", "getFromAppFunctionData", "(Landroidx/appfunctions/AppFunctionData;Ljava/lang/String;)Ljava/lang/Object;", "component1", "()Ljava/lang/Class;", "copy", "(Ljava/lang/Class;)Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$PrimitiveTypeParameter;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Class;", "getClazz", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class PrimitiveTypeParameter<T> implements TypeParameter<T> {
            private final Class<T> clazz;

            public PrimitiveTypeParameter(Class<T> clazz) {
                k.f(clazz, "clazz");
                this.clazz = clazz;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ PrimitiveTypeParameter copy$default(PrimitiveTypeParameter primitiveTypeParameter, Class cls, int i, Object obj) {
                if ((i & 1) != 0) {
                    cls = primitiveTypeParameter.clazz;
                }
                return primitiveTypeParameter.copy(cls);
            }

            public final Class<T> component1() {
                return this.clazz;
            }

            public final PrimitiveTypeParameter<T> copy(Class<T> clazz) {
                k.f(clazz, "clazz");
                return new PrimitiveTypeParameter<>(clazz);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PrimitiveTypeParameter) && k.b(this.clazz, ((PrimitiveTypeParameter) other).clazz);
            }

            public final Class<T> getClazz() {
                return this.clazz;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            @RequiresApi(33)
            public T getFromAppFunctionData(AppFunctionData appFunctionData, String key) {
                k.f(appFunctionData, "appFunctionData");
                k.f(key, "key");
                Class<T> cls = this.clazz;
                if (k.b(cls, Integer.TYPE)) {
                    return (T) Integer.valueOf(appFunctionData.getInt(key));
                }
                if (k.b(cls, Long.TYPE)) {
                    return (T) Long.valueOf(appFunctionData.getLong(key));
                }
                if (k.b(cls, Float.TYPE)) {
                    return (T) Float.valueOf(appFunctionData.getFloat(key));
                }
                if (k.b(cls, Double.TYPE)) {
                    return (T) Double.valueOf(appFunctionData.getDouble(key));
                }
                if (k.b(cls, Boolean.TYPE)) {
                    return (T) Boolean.valueOf(appFunctionData.getBoolean(key));
                }
                if (k.b(cls, String.class)) {
                    return (T) appFunctionData.getString(key);
                }
                if (k.b(cls, int[].class)) {
                    return (T) appFunctionData.getIntArray(key);
                }
                if (k.b(cls, long[].class)) {
                    return (T) appFunctionData.getLongArray(key);
                }
                if (k.b(cls, float[].class)) {
                    return (T) appFunctionData.getFloatArray(key);
                }
                if (k.b(cls, double[].class)) {
                    return (T) appFunctionData.getDoubleArray(key);
                }
                if (k.b(cls, boolean[].class)) {
                    return (T) appFunctionData.getBooleanArray(key);
                }
                if (k.b(cls, byte[].class)) {
                    return (T) appFunctionData.getByteArray(key);
                }
                throw new IllegalStateException("Unsupported primitive type: " + this.clazz + '.');
            }

            public int hashCode() {
                return this.clazz.hashCode();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            @RequiresApi(33)
            public void setValueInAppFunctionData(AppFunctionData.Builder appFunctionDataBuilder, String key, T value) {
                k.f(appFunctionDataBuilder, "appFunctionDataBuilder");
                k.f(key, "key");
                if (value == 0) {
                    return;
                }
                Class<T> cls = this.clazz;
                if (k.b(cls, Integer.TYPE)) {
                    appFunctionDataBuilder.setInt(key, ((Integer) value).intValue());
                    return;
                }
                if (k.b(cls, Long.TYPE)) {
                    appFunctionDataBuilder.setLong(key, ((Long) value).longValue());
                    return;
                }
                if (k.b(cls, Float.TYPE)) {
                    appFunctionDataBuilder.setFloat(key, ((Float) value).floatValue());
                    return;
                }
                if (k.b(cls, Double.TYPE)) {
                    appFunctionDataBuilder.setDouble(key, ((Double) value).doubleValue());
                    return;
                }
                if (k.b(cls, Boolean.TYPE)) {
                    appFunctionDataBuilder.setBoolean(key, ((Boolean) value).booleanValue());
                    return;
                }
                if (k.b(cls, String.class)) {
                    appFunctionDataBuilder.setString(key, (String) value);
                    return;
                }
                if (k.b(cls, int[].class)) {
                    appFunctionDataBuilder.setIntArray(key, (int[]) value);
                    return;
                }
                if (k.b(cls, long[].class)) {
                    appFunctionDataBuilder.setLongArray(key, (long[]) value);
                    return;
                }
                if (k.b(cls, float[].class)) {
                    appFunctionDataBuilder.setFloatArray(key, (float[]) value);
                    return;
                }
                if (k.b(cls, double[].class)) {
                    appFunctionDataBuilder.setDoubleArray(key, (double[]) value);
                    return;
                }
                if (k.b(cls, boolean[].class)) {
                    appFunctionDataBuilder.setBooleanArray(key, (boolean[]) value);
                } else {
                    if (k.b(cls, byte[].class)) {
                        appFunctionDataBuilder.setByteArray(key, (byte[]) value);
                        return;
                    }
                    throw new IllegalStateException("Unsupported primitive type: " + this.clazz + '.');
                }
            }

            public String toString() {
                return "PrimitiveTypeParameter(clazz=" + this.clazz + ')';
            }
        }

        @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\u000e\b\u0003\u0010\u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00032\b\u0012\u0004\u0012\u00028\u00030\u0005B#\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0003H\u0017¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00028\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00020\bHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ<\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\bHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010\u0019R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b*\u0010\u001b¨\u0006+"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$SerializableListTypeParameter;", "", "I", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter;", "Ljava/lang/Class;", "itemClazz", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "serializableFactory", AppAgent.CONSTRUCT, "(Ljava/lang/Class;Landroidx/appfunctions/internal/AppFunctionSerializableFactory;)V", "Landroidx/appfunctions/AppFunctionData$Builder;", "appFunctionDataBuilder", "", "key", "value", "LC7/r;", "setValueInAppFunctionData", "(Landroidx/appfunctions/AppFunctionData$Builder;Ljava/lang/String;Ljava/util/List;)V", "Landroidx/appfunctions/AppFunctionData;", "appFunctionData", "getFromAppFunctionData", "(Landroidx/appfunctions/AppFunctionData;Ljava/lang/String;)Ljava/util/List;", "component1", "()Ljava/lang/Class;", "component2", "()Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "copy", "(Ljava/lang/Class;Landroidx/appfunctions/internal/AppFunctionSerializableFactory;)Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$SerializableListTypeParameter;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Class;", "getItemClazz", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "getSerializableFactory", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class SerializableListTypeParameter<I, T extends List<?>> implements TypeParameter<T> {
            private final Class<I> itemClazz;
            private final AppFunctionSerializableFactory<I> serializableFactory;

            public SerializableListTypeParameter(Class<I> itemClazz, AppFunctionSerializableFactory<I> serializableFactory) {
                k.f(itemClazz, "itemClazz");
                k.f(serializableFactory, "serializableFactory");
                this.itemClazz = itemClazz;
                this.serializableFactory = serializableFactory;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SerializableListTypeParameter copy$default(SerializableListTypeParameter serializableListTypeParameter, Class cls, AppFunctionSerializableFactory appFunctionSerializableFactory, int i, Object obj) {
                if ((i & 1) != 0) {
                    cls = serializableListTypeParameter.itemClazz;
                }
                if ((i & 2) != 0) {
                    appFunctionSerializableFactory = serializableListTypeParameter.serializableFactory;
                }
                return serializableListTypeParameter.copy(cls, appFunctionSerializableFactory);
            }

            public final Class<I> component1() {
                return this.itemClazz;
            }

            public final AppFunctionSerializableFactory<I> component2() {
                return this.serializableFactory;
            }

            public final SerializableListTypeParameter<I, T> copy(Class<I> itemClazz, AppFunctionSerializableFactory<I> serializableFactory) {
                k.f(itemClazz, "itemClazz");
                k.f(serializableFactory, "serializableFactory");
                return new SerializableListTypeParameter<>(itemClazz, serializableFactory);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SerializableListTypeParameter)) {
                    return false;
                }
                SerializableListTypeParameter serializableListTypeParameter = (SerializableListTypeParameter) other;
                return k.b(this.itemClazz, serializableListTypeParameter.itemClazz) && k.b(this.serializableFactory, serializableListTypeParameter.serializableFactory);
            }

            public final Class<I> getItemClazz() {
                return this.itemClazz;
            }

            public final AppFunctionSerializableFactory<I> getSerializableFactory() {
                return this.serializableFactory;
            }

            public int hashCode() {
                return this.serializableFactory.hashCode() + (this.itemClazz.hashCode() * 31);
            }

            public String toString() {
                return "SerializableListTypeParameter(itemClazz=" + this.itemClazz + ", serializableFactory=" + this.serializableFactory + ')';
            }

            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            @RequiresApi(33)
            public T getFromAppFunctionData(AppFunctionData appFunctionData, String key) {
                k.f(appFunctionData, "appFunctionData");
                k.f(key, "key");
                List<AppFunctionData> appFunctionDataList = appFunctionData.getAppFunctionDataList(key);
                if (appFunctionDataList == null) {
                    return null;
                }
                List<AppFunctionData> list = appFunctionDataList;
                ArrayList arrayList = new ArrayList(w.c0(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(this.serializableFactory.fromAppFunctionData((AppFunctionData) it.next()));
                }
                return arrayList;
            }

            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            @RequiresApi(33)
            public void setValueInAppFunctionData(AppFunctionData.Builder appFunctionDataBuilder, String key, T value) {
                k.f(appFunctionDataBuilder, "appFunctionDataBuilder");
                k.f(key, "key");
                if (value == null) {
                    return;
                }
                T t9 = value;
                ArrayList arrayList = new ArrayList(w.c0(t9, 10));
                for (T t10 : t9) {
                    AppFunctionSerializableFactory<I> appFunctionSerializableFactory = this.serializableFactory;
                    k.d(t10, "null cannot be cast to non-null type I of androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter.SerializableListTypeParameter");
                    arrayList.add(appFunctionSerializableFactory.toAppFunctionData(t10));
                }
                appFunctionDataBuilder.setAppFunctionDataList(key, arrayList);
            }
        }

        @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\n\b\u0003\u0010\u0003*\u0004\u0018\u00018\u00022\b\u0012\u0004\u0012\u00028\u00030\u0004B#\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00028\u0003H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ<\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00030\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00030\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010\u0018R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010\u001a¨\u0006*"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$SerializableTypeParameter;", "", "I", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter;", "Ljava/lang/Class;", "clazz", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "serializableFactory", AppAgent.CONSTRUCT, "(Ljava/lang/Class;Landroidx/appfunctions/internal/AppFunctionSerializableFactory;)V", "Landroidx/appfunctions/AppFunctionData$Builder;", "appFunctionDataBuilder", "", "key", "value", "LC7/r;", "setValueInAppFunctionData", "(Landroidx/appfunctions/AppFunctionData$Builder;Ljava/lang/String;Ljava/lang/Object;)V", "Landroidx/appfunctions/AppFunctionData;", "appFunctionData", "getFromAppFunctionData", "(Landroidx/appfunctions/AppFunctionData;Ljava/lang/String;)Ljava/lang/Object;", "component1", "()Ljava/lang/Class;", "component2", "()Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "copy", "(Ljava/lang/Class;Landroidx/appfunctions/internal/AppFunctionSerializableFactory;)Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$SerializableTypeParameter;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Class;", "getClazz", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "getSerializableFactory", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class SerializableTypeParameter<I, T extends I> implements TypeParameter<T> {
            private final Class<T> clazz;
            private final AppFunctionSerializableFactory<I> serializableFactory;

            public SerializableTypeParameter(Class<T> clazz, AppFunctionSerializableFactory<I> serializableFactory) {
                k.f(clazz, "clazz");
                k.f(serializableFactory, "serializableFactory");
                this.clazz = clazz;
                this.serializableFactory = serializableFactory;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SerializableTypeParameter copy$default(SerializableTypeParameter serializableTypeParameter, Class cls, AppFunctionSerializableFactory appFunctionSerializableFactory, int i, Object obj) {
                if ((i & 1) != 0) {
                    cls = serializableTypeParameter.clazz;
                }
                if ((i & 2) != 0) {
                    appFunctionSerializableFactory = serializableTypeParameter.serializableFactory;
                }
                return serializableTypeParameter.copy(cls, appFunctionSerializableFactory);
            }

            public final Class<T> component1() {
                return this.clazz;
            }

            public final AppFunctionSerializableFactory<I> component2() {
                return this.serializableFactory;
            }

            public final SerializableTypeParameter<I, T> copy(Class<T> clazz, AppFunctionSerializableFactory<I> serializableFactory) {
                k.f(clazz, "clazz");
                k.f(serializableFactory, "serializableFactory");
                return new SerializableTypeParameter<>(clazz, serializableFactory);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SerializableTypeParameter)) {
                    return false;
                }
                SerializableTypeParameter serializableTypeParameter = (SerializableTypeParameter) other;
                return k.b(this.clazz, serializableTypeParameter.clazz) && k.b(this.serializableFactory, serializableTypeParameter.serializableFactory);
            }

            public final Class<T> getClazz() {
                return this.clazz;
            }

            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            @RequiresApi(33)
            public T getFromAppFunctionData(AppFunctionData appFunctionData, String key) {
                k.f(appFunctionData, "appFunctionData");
                k.f(key, "key");
                AppFunctionData appFunctionData2 = appFunctionData.getAppFunctionData(key);
                if (appFunctionData2 != null) {
                    return this.serializableFactory.fromAppFunctionData(appFunctionData2);
                }
                return null;
            }

            public final AppFunctionSerializableFactory<I> getSerializableFactory() {
                return this.serializableFactory;
            }

            public int hashCode() {
                return this.serializableFactory.hashCode() + (this.clazz.hashCode() * 31);
            }

            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            @RequiresApi(33)
            public void setValueInAppFunctionData(AppFunctionData.Builder appFunctionDataBuilder, String key, T value) {
                k.f(appFunctionDataBuilder, "appFunctionDataBuilder");
                k.f(key, "key");
                if (value == null) {
                    return;
                }
                appFunctionDataBuilder.setAppFunctionData(key, this.serializableFactory.toAppFunctionData(value));
            }

            public String toString() {
                return "SerializableTypeParameter(clazz=" + this.clazz + ", serializableFactory=" + this.serializableFactory + ')';
            }
        }

        @RequiresApi(33)
        T getFromAppFunctionData(AppFunctionData appFunctionData, String key);

        @RequiresApi(33)
        void setValueInAppFunctionData(AppFunctionData.Builder appFunctionDataBuilder, String key, T value);
    }

    private default AppFunctionComponentsMetadata getAppFunctionComponentsMetadata() {
        AppFunctionComponentsMetadata componentsMetadata;
        AppFunctionInventory appFunctionInventory$appfunctions = Dependencies.INSTANCE.getAppFunctionInventory$appfunctions();
        return (appFunctionInventory$appfunctions == null || (componentsMetadata = appFunctionInventory$appfunctions.getComponentsMetadata()) == null) ? new AppFunctionComponentsMetadata(null, 1, null) : componentsMetadata;
    }

    T fromAppFunctionData(AppFunctionData appFunctionData);

    default AppFunctionData.Builder getAppFunctionDataBuilder(String qualifiedName) {
        k.f(qualifiedName, "qualifiedName");
        AppFunctionComponentsMetadata appFunctionComponentsMetadata = getAppFunctionComponentsMetadata();
        AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = appFunctionComponentsMetadata.getDataTypes().get(qualifiedName);
        if (appFunctionDataTypeMetadata == null) {
            return new AppFunctionData.Builder(qualifiedName, null, 2, null);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata) {
            return new AppFunctionData.Builder((AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata, appFunctionComponentsMetadata);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionAllOfTypeMetadata) {
            return new AppFunctionData.Builder((AppFunctionAllOfTypeMetadata) appFunctionDataTypeMetadata, appFunctionComponentsMetadata);
        }
        throw new IllegalStateException("Unable to serialize " + qualifiedName + " with " + appFunctionDataTypeMetadata);
    }

    default AppFunctionData getAppFunctionDataWithSpec(AppFunctionData appFunctionData, String qualifiedName) {
        k.f(appFunctionData, "appFunctionData");
        k.f(qualifiedName, "qualifiedName");
        AppFunctionComponentsMetadata appFunctionComponentsMetadata = getAppFunctionComponentsMetadata();
        AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = appFunctionComponentsMetadata.getDataTypes().get(qualifiedName);
        AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata = appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata ? (AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata : null;
        return appFunctionObjectTypeMetadata == null ? appFunctionData : appFunctionData.replaceSpecWith$appfunctions(appFunctionObjectTypeMetadata, appFunctionComponentsMetadata);
    }

    AppFunctionData toAppFunctionData(T appFunctionSerializable);
}
