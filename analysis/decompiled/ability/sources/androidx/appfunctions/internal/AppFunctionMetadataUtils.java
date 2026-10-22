package androidx.appfunctions.internal;

import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import androidx.appfunctions.metadata.CompileTimeAppFunctionMetadata;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@RequiresApi(34)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionMetadataUtils;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", "functionIdentifier", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "getAppFunctionMetadata", "(Landroid/content/Context;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppFunctionMetadataUtils {
    public static final AppFunctionMetadataUtils INSTANCE = new AppFunctionMetadataUtils();

    private AppFunctionMetadataUtils() {
    }

    public final Object getAppFunctionMetadata(Context context, String str, H7.c<? super AppFunctionMetadata> cVar) {
        Dependencies dependencies = Dependencies.INSTANCE;
        AppFunctionInventory appFunctionInventory$appfunctions = dependencies.getAppFunctionInventory$appfunctions();
        if (appFunctionInventory$appfunctions == null) {
            AppSearchAppFunctionReader appSearchAppFunctionReader = new AppSearchAppFunctionReader(context, dependencies.getSchemaAppFunctionInventory$appfunctions());
            String packageName = context.getPackageName();
            k.e(packageName, "getPackageName(...)");
            return appSearchAppFunctionReader.getAppFunctionMetadata(str, packageName, cVar);
        }
        CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata = appFunctionInventory$appfunctions.getFunctionIdToMetadataMap().get(str);
        if (compileTimeAppFunctionMetadata == null) {
            return null;
        }
        String id = compileTimeAppFunctionMetadata.getId();
        String packageName2 = context.getPackageName();
        k.e(packageName2, "getPackageName(...)");
        return new AppFunctionMetadata(id, packageName2, compileTimeAppFunctionMetadata.isEnabledByDefault(), compileTimeAppFunctionMetadata.getSchema(), compileTimeAppFunctionMetadata.getParameters(), compileTimeAppFunctionMetadata.getResponse(), appFunctionInventory$appfunctions.getComponentsMetadata(), compileTimeAppFunctionMetadata.getDescription(), null, 256, null);
    }
}
