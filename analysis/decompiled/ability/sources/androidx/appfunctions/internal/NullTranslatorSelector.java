package androidx.appfunctions.internal;

import androidx.annotation.RestrictTo;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import androidx.appfunctions.metadata.AppFunctionSchemaMetadata;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Landroidx/appfunctions/internal/NullTranslatorSelector;", "Landroidx/appfunctions/internal/TranslatorSelector;", AppAgent.CONSTRUCT, "()V", "getTranslator", "Landroidx/appfunctions/internal/Translator;", "schemaMetadata", "Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class NullTranslatorSelector implements TranslatorSelector {
    @Override // androidx.appfunctions.internal.TranslatorSelector
    public Translator getTranslator(AppFunctionSchemaMetadata schemaMetadata) {
        k.f(schemaMetadata, "schemaMetadata");
        return null;
    }
}
