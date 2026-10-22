package androidx.appfunctions;

import D7.v;
import D7.w;
import H4.o;
import android.os.Parcelable;
import androidx.appfunctions.ExecuteAppFunctionResponse;
import androidx.appfunctions.metadata.AppFunctionAllOfTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionArrayTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionBooleanTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionBytesTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionComponentsMetadata;
import androidx.appfunctions.metadata.AppFunctionDataTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionDoubleTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionFloatTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionIntTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionLongTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import androidx.appfunctions.metadata.AppFunctionObjectTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionOneOfTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionParameterMetadata;
import androidx.appfunctions.metadata.AppFunctionParcelableTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionReferenceTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionResponseMetadata;
import androidx.appfunctions.metadata.AppFunctionStringTypeMetadata;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u0000 ?2\u00020\u0001:\u0003@A?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ%\u0010\r\u001a\u00020\f*\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0010\u001a\u00020\f*\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u0014*\u00020\u000f2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0015\u001a\u00020\u0014*\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0019J\u001f\u0010\u0015\u001a\u00020\u0014*\u00020\u001a2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u001bJ\u001f\u0010\u0015\u001a\u00020\u0014*\u00020\u001c2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u001dJ\u001f\u0010\u0015\u001a\u00020\u0014*\u00020\u001e2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u001fJ\u0019\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u0006H ¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0006H ¢\u0006\u0004\b$\u0010%J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060'H ¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b+\u0010%J\u001d\u0010\b\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010,J\u0015\u0010/\u001a\u00020\f2\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J1\u00103\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\n\u00101\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u00102\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b3\u00104J5\u00105\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\n\u00101\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u00102\u001a\u00020\u00142\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b5\u00104J%\u0010\u0015\u001a\u00020\u0014*\u00020\u00042\n\u00106\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u00102\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u00107R\u0014\u0010:\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8&X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006B"}, d2 = {"Landroidx/appfunctions/AppFunctionDataSpec;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "type", "", "qualifiedName", "getPropertyObjectSpec", "(Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;Ljava/lang/String;)Landroidx/appfunctions/AppFunctionDataSpec;", "targetKey", "targetValue", "LC7/r;", "requireConstraintsConformance", "(Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;Ljava/lang/String;Ljava/lang/Object;)V", "Landroidx/appfunctions/metadata/AppFunctionArrayTypeMetadata;", "requireItemTypeConstraintsConformance", "(Landroidx/appfunctions/metadata/AppFunctionArrayTypeMetadata;Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/Class;", "itemTypeClass", "", "conform", "(Landroidx/appfunctions/metadata/AppFunctionArrayTypeMetadata;Ljava/lang/Class;)Z", "Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;", "typeClass", "(Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;Ljava/lang/Class;)Z", "Landroidx/appfunctions/metadata/AppFunctionAllOfTypeMetadata;", "(Landroidx/appfunctions/metadata/AppFunctionAllOfTypeMetadata;Ljava/lang/Class;)Z", "Landroidx/appfunctions/metadata/AppFunctionOneOfTypeMetadata;", "(Landroidx/appfunctions/metadata/AppFunctionOneOfTypeMetadata;Ljava/lang/Class;)Z", "Landroidx/appfunctions/metadata/AppFunctionReferenceTypeMetadata;", "(Landroidx/appfunctions/metadata/AppFunctionReferenceTypeMetadata;Ljava/lang/Class;)Z", "key", "getDataType$appfunctions", "(Ljava/lang/String;)Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "getDataType", "isRequired$appfunctions", "(Ljava/lang/String;)Z", "isRequired", "", "getAllPropertyKeys$appfunctions", "()Ljava/util/Set;", "getAllPropertyKeys", "containsMetadata", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/appfunctions/AppFunctionDataSpec;", "Landroidx/appfunctions/AppFunctionData;", SettingsConfig.KEY_DATA, "validateDataSpecMatches", "(Landroidx/appfunctions/AppFunctionData;)V", "targetClass", "isCollection", "validateWriteRequest", "(Ljava/lang/String;Ljava/lang/Class;ZLjava/lang/Object;)V", "validateReadRequest", "typeClazz", "(Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;Ljava/lang/Class;Z)Z", "getObjectQualifiedName", "()Ljava/lang/String;", "objectQualifiedName", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "getComponentMetadata", "()Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "componentMetadata", "Companion", "ObjectSpec", "ParametersSpec", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AppFunctionDataSpec {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010\u0004\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t¨\u0006\u000f"}, d2 = {"Landroidx/appfunctions/AppFunctionDataSpec$Companion;", "", AppAgent.CONSTRUCT, "()V", "create", "Landroidx/appfunctions/AppFunctionDataSpec;", "objectType", "Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;", "componentMetadata", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "parameterMetadataList", "", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "responseMetadata", "Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final AppFunctionDataSpec create(AppFunctionObjectTypeMetadata objectType, AppFunctionComponentsMetadata componentMetadata) {
            k.f(objectType, "objectType");
            k.f(componentMetadata, "componentMetadata");
            return new ObjectSpec(objectType, componentMetadata);
        }

        private Companion() {
        }

        public final AppFunctionDataSpec create(List<AppFunctionParameterMetadata> parameterMetadataList, AppFunctionComponentsMetadata componentMetadata) {
            k.f(parameterMetadataList, "parameterMetadataList");
            k.f(componentMetadata, "componentMetadata");
            return new ParametersSpec(parameterMetadataList, componentMetadata);
        }

        public final AppFunctionDataSpec create(AppFunctionResponseMetadata responseMetadata, AppFunctionComponentsMetadata componentMetadata) {
            k.f(responseMetadata, "responseMetadata");
            k.f(componentMetadata, "componentMetadata");
            return new ObjectSpec(new AppFunctionObjectTypeMetadata(kotlin.collections.a.Q(new Pair(ExecuteAppFunctionResponse.Success.PROPERTY_RETURN_VALUE, responseMetadata.getValueType())), o.M(ExecuteAppFunctionResponse.Success.PROPERTY_RETURN_VALUE), null, false, null, 16, null), componentMetadata);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0010¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0011H\u0010¢\u0006\u0002\b\u0019J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u001bH\u0010¢\u0006\u0002\b\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÂ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\n\u0010 \u001a\u00020\u0011HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Landroidx/appfunctions/AppFunctionDataSpec$ObjectSpec;", "Landroidx/appfunctions/AppFunctionDataSpec;", "objectTypeMetadata", "Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;", "componentMetadata", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", AppAgent.CONSTRUCT, "(Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)V", "getComponentMetadata", "()Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "equals", "", "other", "", "hashCode", "", "objectQualifiedName", "", "getObjectQualifiedName", "()Ljava/lang/String;", "getDataType", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "key", "getDataType$appfunctions", "isRequired", "isRequired$appfunctions", "getAllPropertyKeys", "", "getAllPropertyKeys$appfunctions", "component1", "component2", "copy", "toString", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ObjectSpec extends AppFunctionDataSpec {
        private final AppFunctionComponentsMetadata componentMetadata;
        private final AppFunctionObjectTypeMetadata objectTypeMetadata;

        public ObjectSpec(AppFunctionObjectTypeMetadata objectTypeMetadata, AppFunctionComponentsMetadata componentMetadata) {
            k.f(objectTypeMetadata, "objectTypeMetadata");
            k.f(componentMetadata, "componentMetadata");
            this.objectTypeMetadata = objectTypeMetadata;
            this.componentMetadata = componentMetadata;
        }

        /* renamed from: component1, reason: from getter */
        private final AppFunctionObjectTypeMetadata getObjectTypeMetadata() {
            return this.objectTypeMetadata;
        }

        public static /* synthetic */ ObjectSpec copy$default(ObjectSpec objectSpec, AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata, int i, Object obj) {
            if ((i & 1) != 0) {
                appFunctionObjectTypeMetadata = objectSpec.objectTypeMetadata;
            }
            if ((i & 2) != 0) {
                appFunctionComponentsMetadata = objectSpec.componentMetadata;
            }
            return objectSpec.copy(appFunctionObjectTypeMetadata, appFunctionComponentsMetadata);
        }

        /* renamed from: component2, reason: from getter */
        public final AppFunctionComponentsMetadata getComponentMetadata() {
            return this.componentMetadata;
        }

        public final ObjectSpec copy(AppFunctionObjectTypeMetadata objectTypeMetadata, AppFunctionComponentsMetadata componentMetadata) {
            k.f(objectTypeMetadata, "objectTypeMetadata");
            k.f(componentMetadata, "componentMetadata");
            return new ObjectSpec(objectTypeMetadata, componentMetadata);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof ObjectSpec) {
                return k.b(this.objectTypeMetadata, ((ObjectSpec) other).objectTypeMetadata);
            }
            return false;
        }

        @Override // androidx.appfunctions.AppFunctionDataSpec
        public Set<String> getAllPropertyKeys$appfunctions() {
            return this.objectTypeMetadata.getProperties().keySet();
        }

        @Override // androidx.appfunctions.AppFunctionDataSpec
        public AppFunctionComponentsMetadata getComponentMetadata() {
            return this.componentMetadata;
        }

        @Override // androidx.appfunctions.AppFunctionDataSpec
        public AppFunctionDataTypeMetadata getDataType$appfunctions(String key) {
            k.f(key, "key");
            return this.objectTypeMetadata.getProperties().get(key);
        }

        @Override // androidx.appfunctions.AppFunctionDataSpec
        public String getObjectQualifiedName() {
            String qualifiedName = this.objectTypeMetadata.getQualifiedName();
            return qualifiedName == null ? "" : qualifiedName;
        }

        public int hashCode() {
            return Objects.hash(this.objectTypeMetadata);
        }

        @Override // androidx.appfunctions.AppFunctionDataSpec
        public boolean isRequired$appfunctions(String key) {
            k.f(key, "key");
            boolean zContains = this.objectTypeMetadata.getRequired().contains(key);
            AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = this.objectTypeMetadata.getProperties().get(key);
            return zContains && !(appFunctionDataTypeMetadata != null ? appFunctionDataTypeMetadata.getIsNullable() : true);
        }

        public String toString() {
            return "ObjectSpec(objectTypeMetadata=" + this.objectTypeMetadata + ", componentMetadata=" + this.componentMetadata + ')';
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0010¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0012H\u0010¢\u0006\u0002\b\u001aJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cH\u0010¢\u0006\u0002\b\u001dJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J#\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\n\u0010!\u001a\u00020\u0012HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Landroidx/appfunctions/AppFunctionDataSpec$ParametersSpec;", "Landroidx/appfunctions/AppFunctionDataSpec;", "parameterMetadataList", "", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "componentMetadata", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", AppAgent.CONSTRUCT, "(Ljava/util/List;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)V", "getComponentMetadata", "()Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "equals", "", "other", "", "hashCode", "", "objectQualifiedName", "", "getObjectQualifiedName", "()Ljava/lang/String;", "getDataType", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "key", "getDataType$appfunctions", "isRequired", "isRequired$appfunctions", "getAllPropertyKeys", "", "getAllPropertyKeys$appfunctions", "component1", "component2", "copy", "toString", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ParametersSpec extends AppFunctionDataSpec {
        private final AppFunctionComponentsMetadata componentMetadata;
        private final List<AppFunctionParameterMetadata> parameterMetadataList;

        public ParametersSpec(List<AppFunctionParameterMetadata> parameterMetadataList, AppFunctionComponentsMetadata componentMetadata) {
            k.f(parameterMetadataList, "parameterMetadataList");
            k.f(componentMetadata, "componentMetadata");
            this.parameterMetadataList = parameterMetadataList;
            this.componentMetadata = componentMetadata;
        }

        private final List<AppFunctionParameterMetadata> component1() {
            return this.parameterMetadataList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ParametersSpec copy$default(ParametersSpec parametersSpec, List list, AppFunctionComponentsMetadata appFunctionComponentsMetadata, int i, Object obj) {
            if ((i & 1) != 0) {
                list = parametersSpec.parameterMetadataList;
            }
            if ((i & 2) != 0) {
                appFunctionComponentsMetadata = parametersSpec.componentMetadata;
            }
            return parametersSpec.copy(list, appFunctionComponentsMetadata);
        }

        /* renamed from: component2, reason: from getter */
        public final AppFunctionComponentsMetadata getComponentMetadata() {
            return this.componentMetadata;
        }

        public final ParametersSpec copy(List<AppFunctionParameterMetadata> parameterMetadataList, AppFunctionComponentsMetadata componentMetadata) {
            k.f(parameterMetadataList, "parameterMetadataList");
            k.f(componentMetadata, "componentMetadata");
            return new ParametersSpec(parameterMetadataList, componentMetadata);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof ParametersSpec) {
                return k.b(this.parameterMetadataList, ((ParametersSpec) other).parameterMetadataList);
            }
            return false;
        }

        @Override // androidx.appfunctions.AppFunctionDataSpec
        public Set<String> getAllPropertyKeys$appfunctions() {
            List<AppFunctionParameterMetadata> list = this.parameterMetadataList;
            ArrayList arrayList = new ArrayList(w.c0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((AppFunctionParameterMetadata) it.next()).getName());
            }
            return v.j1(arrayList);
        }

        @Override // androidx.appfunctions.AppFunctionDataSpec
        public AppFunctionComponentsMetadata getComponentMetadata() {
            return this.componentMetadata;
        }

        @Override // androidx.appfunctions.AppFunctionDataSpec
        public AppFunctionDataTypeMetadata getDataType$appfunctions(String key) {
            Object next;
            k.f(key, "key");
            Iterator<T> it = this.parameterMetadataList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (k.b(((AppFunctionParameterMetadata) next).getName(), key)) {
                    break;
                }
            }
            AppFunctionParameterMetadata appFunctionParameterMetadata = (AppFunctionParameterMetadata) next;
            if (appFunctionParameterMetadata != null) {
                return appFunctionParameterMetadata.getDataType();
            }
            return null;
        }

        @Override // androidx.appfunctions.AppFunctionDataSpec
        public String getObjectQualifiedName() {
            return "";
        }

        public int hashCode() {
            return Objects.hash(this.parameterMetadataList);
        }

        @Override // androidx.appfunctions.AppFunctionDataSpec
        public boolean isRequired$appfunctions(String key) {
            Object obj;
            Object next;
            AppFunctionDataTypeMetadata dataType;
            k.f(key, "key");
            Iterator<T> it = this.parameterMetadataList.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (k.b(((AppFunctionParameterMetadata) next).getName(), key)) {
                    break;
                }
            }
            AppFunctionParameterMetadata appFunctionParameterMetadata = (AppFunctionParameterMetadata) next;
            boolean isRequired = appFunctionParameterMetadata != null ? appFunctionParameterMetadata.getIsRequired() : false;
            Iterator<T> it2 = this.parameterMetadataList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                if (k.b(((AppFunctionParameterMetadata) next2).getName(), key)) {
                    obj = next2;
                    break;
                }
            }
            AppFunctionParameterMetadata appFunctionParameterMetadata2 = (AppFunctionParameterMetadata) obj;
            return isRequired && !((appFunctionParameterMetadata2 == null || (dataType = appFunctionParameterMetadata2.getDataType()) == null) ? true : dataType.getIsNullable());
        }

        public String toString() {
            return "ParametersSpec(parameterMetadataList=" + this.parameterMetadataList + ", componentMetadata=" + this.componentMetadata + ')';
        }
    }

    private final void requireConstraintsConformance(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, String str, Object obj) {
        if (obj == null && isRequired$appfunctions(str)) {
            throw new IllegalArgumentException(B7.a.m("\"", str, "\" cannot be set to a null value.").toString());
        }
        if (obj == null) {
            return;
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionIntTypeMetadata) {
            AppFunctionIntTypeMetadata appFunctionIntTypeMetadata = (AppFunctionIntTypeMetadata) appFunctionDataTypeMetadata;
            if (appFunctionIntTypeMetadata.getEnumValues() == null || v.u0(appFunctionIntTypeMetadata.getEnumValues(), obj)) {
                return;
            }
            throw new IllegalArgumentException(("Invalid value for \"" + str + "\" got \"" + obj + "\", expecting one of " + appFunctionIntTypeMetadata.getEnumValues()).toString());
        }
        if (!(appFunctionDataTypeMetadata instanceof AppFunctionStringTypeMetadata)) {
            if (appFunctionDataTypeMetadata instanceof AppFunctionArrayTypeMetadata) {
                requireItemTypeConstraintsConformance((AppFunctionArrayTypeMetadata) appFunctionDataTypeMetadata, str, obj);
                return;
            }
            return;
        }
        AppFunctionStringTypeMetadata appFunctionStringTypeMetadata = (AppFunctionStringTypeMetadata) appFunctionDataTypeMetadata;
        if (appFunctionStringTypeMetadata.getEnumValues() == null || v.u0(appFunctionStringTypeMetadata.getEnumValues(), obj)) {
            return;
        }
        throw new IllegalArgumentException(("Invalid value for \"" + str + "\" got \"" + obj + "\", expecting one of " + appFunctionStringTypeMetadata.getEnumValues()).toString());
    }

    private final void requireItemTypeConstraintsConformance(AppFunctionArrayTypeMetadata appFunctionArrayTypeMetadata, String str, Object obj) {
        AppFunctionDataTypeMetadata itemType = appFunctionArrayTypeMetadata.getItemType();
        if (itemType instanceof AppFunctionIntTypeMetadata) {
            int[] iArr = obj instanceof int[] ? (int[]) obj : null;
            if (iArr == null) {
                iArr = new int[0];
            }
            for (int i : iArr) {
                requireConstraintsConformance(appFunctionArrayTypeMetadata.getItemType(), str, Integer.valueOf(i));
            }
            return;
        }
        if (itemType instanceof AppFunctionStringTypeMetadata) {
            List list = obj instanceof List ? (List) obj : null;
            if (list == null) {
                list = EmptyList.f4893a;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                requireConstraintsConformance(appFunctionArrayTypeMetadata.getItemType(), str, (String) it.next());
            }
        }
    }

    public static /* synthetic */ void validateReadRequest$default(AppFunctionDataSpec appFunctionDataSpec, String str, Class cls, boolean z10, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validateReadRequest");
        }
        if ((i & 8) != 0) {
            obj = null;
        }
        appFunctionDataSpec.validateReadRequest(str, cls, z10, obj);
    }

    public final boolean conform(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, Class<?> typeClazz, boolean z10) {
        k.f(appFunctionDataTypeMetadata, "<this>");
        k.f(typeClazz, "typeClazz");
        if (appFunctionDataTypeMetadata instanceof AppFunctionIntTypeMetadata) {
            return !z10 && typeClazz.equals(Integer.TYPE);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionLongTypeMetadata) {
            return !z10 && typeClazz.equals(Long.TYPE);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionFloatTypeMetadata) {
            return !z10 && typeClazz.equals(Float.TYPE);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionDoubleTypeMetadata) {
            return !z10 && typeClazz.equals(Double.TYPE);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionBooleanTypeMetadata) {
            return !z10 && typeClazz.equals(Boolean.TYPE);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionStringTypeMetadata) {
            return !z10 && typeClazz.equals(String.class);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionBytesTypeMetadata) {
            return z10 && typeClazz.equals(Byte.TYPE);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionParcelableTypeMetadata) {
            return !z10 && Parcelable.class.isAssignableFrom(typeClazz) && typeClazz.getName().equals(((AppFunctionParcelableTypeMetadata) appFunctionDataTypeMetadata).getQualifiedName());
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionArrayTypeMetadata) {
            return z10 && conform((AppFunctionArrayTypeMetadata) appFunctionDataTypeMetadata, typeClazz);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata) {
            return !z10 && conform((AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata, typeClazz);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionAllOfTypeMetadata) {
            return !z10 && conform((AppFunctionAllOfTypeMetadata) appFunctionDataTypeMetadata, typeClazz);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionReferenceTypeMetadata) {
            return !z10 && conform((AppFunctionReferenceTypeMetadata) appFunctionDataTypeMetadata, typeClazz);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionOneOfTypeMetadata) {
            return !z10 && conform((AppFunctionOneOfTypeMetadata) appFunctionDataTypeMetadata, typeClazz);
        }
        throw new IllegalStateException("Unexpected data type " + appFunctionDataTypeMetadata.getClass());
    }

    public final boolean containsMetadata(String key) {
        k.f(key, "key");
        return getDataType$appfunctions(key) != null;
    }

    public abstract Set<String> getAllPropertyKeys$appfunctions();

    public abstract AppFunctionComponentsMetadata getComponentMetadata();

    public abstract AppFunctionDataTypeMetadata getDataType$appfunctions(String key);

    public abstract String getObjectQualifiedName();

    public final AppFunctionDataSpec getPropertyObjectSpec(String key, String qualifiedName) {
        k.f(key, "key");
        k.f(qualifiedName, "qualifiedName");
        AppFunctionDataTypeMetadata dataType$appfunctions = getDataType$appfunctions(key);
        if (dataType$appfunctions != null) {
            return getPropertyObjectSpec(dataType$appfunctions, qualifiedName);
        }
        throw new IllegalArgumentException(B7.a.m("Value associated with ", key, " is not an object"));
    }

    public abstract boolean isRequired$appfunctions(String key);

    public final void validateDataSpecMatches(AppFunctionData data) {
        k.f(data, "data");
        data.getSpec();
    }

    public final void validateReadRequest(String targetKey, Class<?> targetClass, boolean isCollection, Object targetValue) {
        String str;
        k.f(targetKey, "targetKey");
        k.f(targetClass, "targetClass");
        AppFunctionDataTypeMetadata dataType$appfunctions = getDataType$appfunctions(targetKey);
        if (dataType$appfunctions == null) {
            throw new IllegalArgumentException("No value should be set at ".concat(targetKey));
        }
        if (conform(dataType$appfunctions, targetClass, isCollection)) {
            requireConstraintsConformance(dataType$appfunctions, targetKey, targetValue);
            return;
        }
        if (isCollection) {
            str = "Unexpected read for " + targetKey + ": expecting collection of " + targetClass + ", the actual value should be " + dataType$appfunctions;
        } else {
            str = "Unexpected read for " + targetKey + ": expecting " + targetClass + ", the actual value should be " + dataType$appfunctions;
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final void validateWriteRequest(String targetKey, Class<?> targetClass, boolean isCollection, Object targetValue) {
        String str;
        k.f(targetKey, "targetKey");
        k.f(targetClass, "targetClass");
        k.f(targetValue, "targetValue");
        AppFunctionDataTypeMetadata dataType$appfunctions = getDataType$appfunctions(targetKey);
        if (dataType$appfunctions == null) {
            throw new IllegalArgumentException("No value should be set at ".concat(targetKey));
        }
        if (conform(dataType$appfunctions, targetClass, isCollection)) {
            requireConstraintsConformance(dataType$appfunctions, targetKey, targetValue);
            return;
        }
        if (isCollection) {
            str = "Invalid value for " + targetKey + ": got collection of " + targetClass + ", expecting a value matching " + dataType$appfunctions;
        } else {
            str = "Invalid value for " + targetKey + ": got " + targetClass + ", expecting a value matching " + dataType$appfunctions;
        }
        throw new IllegalArgumentException(str.toString());
    }

    private final AppFunctionDataSpec getPropertyObjectSpec(AppFunctionDataTypeMetadata type, String qualifiedName) {
        if (type instanceof AppFunctionArrayTypeMetadata) {
            return getPropertyObjectSpec(((AppFunctionArrayTypeMetadata) type).getItemType(), qualifiedName);
        }
        if (type instanceof AppFunctionObjectTypeMetadata) {
            return new ObjectSpec((AppFunctionObjectTypeMetadata) type, getComponentMetadata());
        }
        if (type instanceof AppFunctionReferenceTypeMetadata) {
            AppFunctionReferenceTypeMetadata appFunctionReferenceTypeMetadata = (AppFunctionReferenceTypeMetadata) type;
            AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = getComponentMetadata().getDataTypes().get(appFunctionReferenceTypeMetadata.getReferenceDataType());
            if (appFunctionDataTypeMetadata != null) {
                return getPropertyObjectSpec(appFunctionDataTypeMetadata, qualifiedName);
            }
            throw new IllegalStateException("Unable to resolve data type for " + appFunctionReferenceTypeMetadata.getReferenceDataType());
        }
        if (type instanceof AppFunctionAllOfTypeMetadata) {
            return new ObjectSpec(((AppFunctionAllOfTypeMetadata) type).getPseudoObjectTypeMetadata$appfunctions(getComponentMetadata()), getComponentMetadata());
        }
        if (type instanceof AppFunctionOneOfTypeMetadata) {
            return getPropertyObjectSpec(((AppFunctionOneOfTypeMetadata) type).getObjectMetadataForOneOfType$appfunctions(qualifiedName), qualifiedName);
        }
        throw new IllegalStateException("Unexpected data type " + type);
    }

    private final boolean conform(AppFunctionArrayTypeMetadata appFunctionArrayTypeMetadata, Class<?> cls) {
        return conform(appFunctionArrayTypeMetadata.getItemType(), cls, false);
    }

    private final boolean conform(AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata, Class<?> cls) {
        return k.b(cls, AppFunctionData.class);
    }

    private final boolean conform(AppFunctionAllOfTypeMetadata appFunctionAllOfTypeMetadata, Class<?> cls) {
        return k.b(cls, AppFunctionData.class);
    }

    private final boolean conform(AppFunctionOneOfTypeMetadata appFunctionOneOfTypeMetadata, Class<?> cls) {
        return k.b(cls, AppFunctionData.class);
    }

    private final boolean conform(AppFunctionReferenceTypeMetadata appFunctionReferenceTypeMetadata, Class<?> cls) {
        return k.b(cls, AppFunctionData.class);
    }
}
