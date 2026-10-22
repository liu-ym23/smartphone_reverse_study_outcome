package androidx.appfunctions;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.AppFunctionData;
import androidx.appfunctions.internal.AppFunctionSerializableFactory;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@RequiresApi(33)
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"androidx/appfunctions/$AppFunctionTextResourceFactory", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "Landroidx/appfunctions/AppFunctionTextResource;", AppAgent.CONSTRUCT, "()V", "fromAppFunctionData", "appFunctionData", "Landroidx/appfunctions/AppFunctionData;", "toAppFunctionData", "appFunctionSerializable", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: androidx.appfunctions.$AppFunctionTextResourceFactory, reason: invalid class name */
/* loaded from: classes.dex */
public final class C$AppFunctionTextResourceFactory implements AppFunctionSerializableFactory<AppFunctionTextResource> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory
    public AppFunctionTextResource fromAppFunctionData(AppFunctionData appFunctionData) {
        k.f(appFunctionData, "appFunctionData");
        AppFunctionData appFunctionDataWithSpec = getAppFunctionDataWithSpec(appFunctionData, "androidx.appfunctions.AppFunctionTextResource");
        String string = appFunctionDataWithSpec.getString("mimeType");
        if (string == null) {
            throw new IllegalStateException("Required value was null.");
        }
        String string2 = appFunctionDataWithSpec.getString("content");
        if (string2 != null) {
            return new AppFunctionTextResource(string, string2);
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory
    public AppFunctionData toAppFunctionData(AppFunctionTextResource appFunctionSerializable) {
        k.f(appFunctionSerializable, "appFunctionSerializable");
        AppFunctionData.Builder appFunctionDataBuilder = getAppFunctionDataBuilder("androidx.appfunctions.AppFunctionTextResource");
        appFunctionDataBuilder.setString("mimeType", appFunctionSerializable.getMimeType());
        appFunctionDataBuilder.setString("content", appFunctionSerializable.getContent());
        return appFunctionDataBuilder.build();
    }
}
