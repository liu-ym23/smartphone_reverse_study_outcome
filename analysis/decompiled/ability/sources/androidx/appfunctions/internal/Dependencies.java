package androidx.appfunctions.internal;

import C7.f;
import P3.d;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@RequiresApi(31)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/appfunctions/internal/Dependencies;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/appfunctions/internal/TranslatorSelector;", "translatorSelector$delegate", "LC7/f;", "getTranslatorSelector", "()Landroidx/appfunctions/internal/TranslatorSelector;", "translatorSelector", "Landroidx/appfunctions/internal/SchemaAppFunctionInventory;", "schemaAppFunctionInventory$delegate", "getSchemaAppFunctionInventory$appfunctions", "()Landroidx/appfunctions/internal/SchemaAppFunctionInventory;", "schemaAppFunctionInventory", "Landroidx/appfunctions/internal/AggregatedAppFunctionInventory;", "aggregatedAppFunctionInventory$delegate", "getAggregatedAppFunctionInventory", "()Landroidx/appfunctions/internal/AggregatedAppFunctionInventory;", "aggregatedAppFunctionInventory", "Landroidx/appfunctions/internal/AppFunctionInventory;", "appFunctionInventory$delegate", "getAppFunctionInventory$appfunctions", "()Landroidx/appfunctions/internal/AppFunctionInventory;", "appFunctionInventory", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class Dependencies {
    public static final Dependencies INSTANCE = new Dependencies();

    /* renamed from: translatorSelector$delegate, reason: from kotlin metadata */
    private static final f translatorSelector = kotlin.a.a(new d(5));

    /* renamed from: schemaAppFunctionInventory$delegate, reason: from kotlin metadata */
    private static final f schemaAppFunctionInventory = kotlin.a.a(new d(6));

    /* renamed from: aggregatedAppFunctionInventory$delegate, reason: from kotlin metadata */
    private static final f aggregatedAppFunctionInventory = kotlin.a.a(new d(7));

    /* renamed from: appFunctionInventory$delegate, reason: from kotlin metadata */
    private static final f appFunctionInventory = kotlin.a.a(new d(8));

    private Dependencies() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AggregatedAppFunctionInventory aggregatedAppFunctionInventory_delegate$lambda$0() {
        try {
            return (AggregatedAppFunctionInventory) ClassUtilsKt.findImpl(AggregatedAppFunctionInventory.class, "$", "_Impl");
        } catch (Exception e) {
            Log.d(Constants.APP_FUNCTIONS_TAG, "Cannot find AggregatedAppFunctionInventory implementation", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctionInventory appFunctionInventory_delegate$lambda$0() {
        Dependencies dependencies = INSTANCE;
        return dependencies.getAggregatedAppFunctionInventory() != null ? dependencies.getAggregatedAppFunctionInventory() : dependencies.getSchemaAppFunctionInventory$appfunctions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SchemaAppFunctionInventory schemaAppFunctionInventory_delegate$lambda$0() {
        try {
            return (SchemaAppFunctionInventory) ClassUtilsKt.findImpl(SchemaAppFunctionInventory.class, "$", "_Impl");
        } catch (Exception unused) {
            Log.d(Constants.APP_FUNCTIONS_TAG, "Cannot find SchemaAppFunctionInventory implementation");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TranslatorSelector translatorSelector_delegate$lambda$0() {
        try {
            return (TranslatorSelector) ClassUtilsKt.findImpl(TranslatorSelector.class, "", "Impl");
        } catch (Exception unused) {
            Log.d(Constants.APP_FUNCTIONS_TAG, "Cannot find TranslatorSelectorImpl");
            return new NullTranslatorSelector();
        }
    }

    public final AggregatedAppFunctionInventory getAggregatedAppFunctionInventory() {
        return (AggregatedAppFunctionInventory) aggregatedAppFunctionInventory.getF4884a();
    }

    public final AppFunctionInventory getAppFunctionInventory$appfunctions() {
        return (AppFunctionInventory) appFunctionInventory.getF4884a();
    }

    public final SchemaAppFunctionInventory getSchemaAppFunctionInventory$appfunctions() {
        return (SchemaAppFunctionInventory) schemaAppFunctionInventory.getF4884a();
    }

    public final TranslatorSelector getTranslatorSelector() {
        return (TranslatorSelector) translatorSelector.getF4884a();
    }
}
