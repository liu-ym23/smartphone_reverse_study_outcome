package androidx.appfunctions.internal.serializableproxies;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.AppFunctionData;
import androidx.appfunctions.internal.AppFunctionSerializableFactory;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@RequiresApi(33)
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"androidx/appfunctions/internal/serializableproxies/$InstantFactory", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "Ljava/time/Instant;", AppAgent.CONSTRUCT, "()V", "fromAppFunctionData", "appFunctionData", "Landroidx/appfunctions/AppFunctionData;", "toAppFunctionData", "appFunctionSerializable", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: androidx.appfunctions.internal.serializableproxies.$InstantFactory, reason: invalid class name */
/* loaded from: classes.dex */
public final class C$InstantFactory implements AppFunctionSerializableFactory<Instant> {
    @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory
    public Instant fromAppFunctionData(AppFunctionData appFunctionData) {
        k.f(appFunctionData, "appFunctionData");
        AppFunctionData appFunctionDataWithSpec = getAppFunctionDataWithSpec(appFunctionData, "java.time.Instant");
        Long longOrNull = appFunctionDataWithSpec.getLongOrNull("epochSecond");
        if (longOrNull == null) {
            throw new IllegalStateException("Required value was null.");
        }
        long jLongValue = longOrNull.longValue();
        Integer intOrNull = appFunctionDataWithSpec.getIntOrNull("nanoAdjustment");
        if (intOrNull != null) {
            return new AppFunctionInstant(jLongValue, intOrNull.intValue()).toInstant();
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory
    public AppFunctionData toAppFunctionData(Instant appFunctionSerializable) {
        k.f(appFunctionSerializable, "appFunctionSerializable");
        AppFunctionInstant appFunctionInstantFromInstant = AppFunctionInstant.INSTANCE.fromInstant(appFunctionSerializable);
        AppFunctionData.Builder appFunctionDataBuilder = getAppFunctionDataBuilder("java.time.Instant");
        appFunctionDataBuilder.setLong("epochSecond", appFunctionInstantFromInstant.getEpochSecond());
        appFunctionDataBuilder.setInt("nanoAdjustment", appFunctionInstantFromInstant.getNanoAdjustment());
        return appFunctionDataBuilder.build();
    }
}
