package androidx.appfunctions.internal.serializableproxies;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.AppFunctionData;
import androidx.appfunctions.internal.AppFunctionSerializableFactory;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.time.LocalDateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@RequiresApi(33)
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"androidx/appfunctions/internal/serializableproxies/$LocalDateTimeFactory", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "Ljava/time/LocalDateTime;", AppAgent.CONSTRUCT, "()V", "fromAppFunctionData", "appFunctionData", "Landroidx/appfunctions/AppFunctionData;", "toAppFunctionData", "appFunctionSerializable", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: androidx.appfunctions.internal.serializableproxies.$LocalDateTimeFactory, reason: invalid class name */
/* loaded from: classes.dex */
public final class C$LocalDateTimeFactory implements AppFunctionSerializableFactory<LocalDateTime> {
    @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory
    public LocalDateTime fromAppFunctionData(AppFunctionData appFunctionData) {
        k.f(appFunctionData, "appFunctionData");
        AppFunctionData appFunctionDataWithSpec = getAppFunctionDataWithSpec(appFunctionData, "java.time.LocalDateTime");
        Integer intOrNull = appFunctionDataWithSpec.getIntOrNull("year");
        if (intOrNull == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int iIntValue = intOrNull.intValue();
        Integer intOrNull2 = appFunctionDataWithSpec.getIntOrNull("month");
        if (intOrNull2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int iIntValue2 = intOrNull2.intValue();
        Integer intOrNull3 = appFunctionDataWithSpec.getIntOrNull("dayOfMonth");
        if (intOrNull3 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int iIntValue3 = intOrNull3.intValue();
        Integer intOrNull4 = appFunctionDataWithSpec.getIntOrNull("hour");
        if (intOrNull4 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int iIntValue4 = intOrNull4.intValue();
        Integer intOrNull5 = appFunctionDataWithSpec.getIntOrNull("minute");
        if (intOrNull5 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int iIntValue5 = intOrNull5.intValue();
        Integer intOrNull6 = appFunctionDataWithSpec.getIntOrNull("second");
        if (intOrNull6 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int iIntValue6 = intOrNull6.intValue();
        Integer intOrNull7 = appFunctionDataWithSpec.getIntOrNull("nanoOfSecond");
        if (intOrNull7 != null) {
            return new AppFunctionLocalDateTime(iIntValue, iIntValue2, iIntValue3, iIntValue4, iIntValue5, iIntValue6, intOrNull7.intValue()).toLocalDateTime();
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory
    public AppFunctionData toAppFunctionData(LocalDateTime appFunctionSerializable) {
        k.f(appFunctionSerializable, "appFunctionSerializable");
        AppFunctionLocalDateTime appFunctionLocalDateTimeFromLocalDateTime = AppFunctionLocalDateTime.INSTANCE.fromLocalDateTime(appFunctionSerializable);
        AppFunctionData.Builder appFunctionDataBuilder = getAppFunctionDataBuilder("java.time.LocalDateTime");
        appFunctionDataBuilder.setInt("year", appFunctionLocalDateTimeFromLocalDateTime.getYear());
        appFunctionDataBuilder.setInt("month", appFunctionLocalDateTimeFromLocalDateTime.getMonth());
        appFunctionDataBuilder.setInt("dayOfMonth", appFunctionLocalDateTimeFromLocalDateTime.getDayOfMonth());
        appFunctionDataBuilder.setInt("hour", appFunctionLocalDateTimeFromLocalDateTime.getHour());
        appFunctionDataBuilder.setInt("minute", appFunctionLocalDateTimeFromLocalDateTime.getMinute());
        appFunctionDataBuilder.setInt("second", appFunctionLocalDateTimeFromLocalDateTime.getSecond());
        appFunctionDataBuilder.setInt("nanoOfSecond", appFunctionLocalDateTimeFromLocalDateTime.getNanoOfSecond());
        return appFunctionDataBuilder.build();
    }
}
