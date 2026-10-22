package androidx.appfunctions.internal;

import androidx.annotation.RestrictTo;
import androidx.appfunctions.AppFunctionSearchSpec;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH¦@¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionReader;", "", "Landroidx/appfunctions/AppFunctionSearchSpec;", "searchFunctionSpec", "Lp9/c;", "", "Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;", "searchAppFunctions", "(Landroidx/appfunctions/AppFunctionSearchSpec;)Lp9/c;", "", "functionId", "packageName", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "getAppFunctionMetadata", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public interface AppFunctionReader {
    Object getAppFunctionMetadata(String str, String str2, H7.c<? super AppFunctionMetadata> cVar);

    p9.c searchAppFunctions(AppFunctionSearchSpec searchFunctionSpec);
}
