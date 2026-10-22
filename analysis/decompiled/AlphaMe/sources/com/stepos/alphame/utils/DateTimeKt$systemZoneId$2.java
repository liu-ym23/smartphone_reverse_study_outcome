package com.stepos.alphame.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.stepos.alphame.ApplicationImpl;
import java.time.ZoneId;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u001f\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0096\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"com/stepos/alphame/utils/DateTimeKt$systemZoneId$2", "Lkotlin/properties/ReadOnlyProperty;", "", "Ljava/time/ZoneId;", "zoneId", "getValue", "thisRef", Property.SHARED_PREFERENCES_NAME, "Lkotlin/reflect/KProperty;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateTimeKt$systemZoneId$2 implements ReadOnlyProperty<Object, ZoneId> {
    private ZoneId zoneId;

    @Override // kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ ZoneId getValue(Object obj, KProperty kProperty) {
        return getValue2(obj, (KProperty<?>) kProperty);
    }

    @Override // kotlin.properties.ReadOnlyProperty
    @NotNull
    /* renamed from: getValue, reason: avoid collision after fix types in other method */
    public ZoneId getValue2(@Nullable Object thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (this.zoneId == null) {
            ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneIdSystemDefault, "systemDefault(...)");
            this.zoneId = zoneIdSystemDefault;
            ApplicationImpl.getApplication().registerReceiver(new BroadcastReceiver() { // from class: com.stepos.alphame.utils.DateTimeKt$systemZoneId$2$getValue$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(@NotNull Context context, @Nullable Intent intent) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.intent.action.TIMEZONE_CHANGED")) {
                        TimeZone.setDefault(null);
                        DateTimeKt$systemZoneId$2 dateTimeKt$systemZoneId$2 = this.this$0;
                        ZoneId zoneIdSystemDefault2 = ZoneId.systemDefault();
                        Intrinsics.checkNotNullExpressionValue(zoneIdSystemDefault2, "systemDefault(...)");
                        dateTimeKt$systemZoneId$2.zoneId = zoneIdSystemDefault2;
                    }
                }
            }, new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
        }
        ZoneId zoneId = this.zoneId;
        if (zoneId != null) {
            return zoneId;
        }
        Intrinsics.throwUninitializedPropertyAccessException("zoneId");
        return null;
    }
}
