package androidx.appfunctions.internal;

import C7.f;
import D6.i;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import androidx.appfunctions.metadata.AppFunctionSchemaMetadata;
import androidx.appfunctions.metadata.CompileTimeAppFunctionMetadata;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.builders.MapBuilder;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Landroidx/appfunctions/internal/SchemaAppFunctionInventory;", "Landroidx/appfunctions/internal/AppFunctionInventory;", AppAgent.CONSTRUCT, "()V", "", "Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", "Landroidx/appfunctions/metadata/CompileTimeAppFunctionMetadata;", "schemaFunctionsMap$delegate", "LC7/f;", "getSchemaFunctionsMap", "()Ljava/util/Map;", "schemaFunctionsMap", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class SchemaAppFunctionInventory implements AppFunctionInventory {

    /* renamed from: schemaFunctionsMap$delegate, reason: from kotlin metadata */
    private final f schemaFunctionsMap = kotlin.a.a(new i(this, 9));

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map schemaFunctionsMap_delegate$lambda$0(SchemaAppFunctionInventory schemaAppFunctionInventory) {
        MapBuilder mapBuilder = new MapBuilder();
        for (CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata : schemaAppFunctionInventory.getFunctionIdToMetadataMap().values()) {
            AppFunctionSchemaMetadata schema = compileTimeAppFunctionMetadata.getSchema();
            if (schema != null) {
                mapBuilder.put(schema, compileTimeAppFunctionMetadata);
            }
        }
        return mapBuilder.b();
    }

    public final Map<AppFunctionSchemaMetadata, CompileTimeAppFunctionMetadata> getSchemaFunctionsMap() {
        return (Map) this.schemaFunctionsMap.getF4884a();
    }
}
