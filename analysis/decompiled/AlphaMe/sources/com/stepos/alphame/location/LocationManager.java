package com.stepos.alphame.location;

import android.content.Context;
import android.util.Log;
import ch.qos.logback.core.CoreConstants;
import com.baidu.platform.comapi.map.MapController;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.location.LocationManager;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.CorountinesUtilsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J3\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2#\u0010\t\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stepos/alphame/location/LocationManager;", "", "()V", "mapLocationClient", "Lcom/stepos/alphame/location/MapLocationClient;", "getCurLocation", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "invoke", "Lkotlin/Function1;", "Lcom/stepos/alphame/location/MapLocation;", "Lkotlin/ParameterName;", "name", MapController.LOCATION_LAYER_TAG, "getLocationClient", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LocationManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<LocationManager> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<LocationManager>() { // from class: com.stepos.alphame.location.LocationManager$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final LocationManager invoke() {
            return new LocationManager();
        }
    });
    public static final int LOCATION_SUCCESS_CODE = 0;

    @NotNull
    public static final String TAG = "LocationManager";

    @Nullable
    private MapLocationClient mapLocationClient;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/alphame/location/LocationManager$Companion;", "", "()V", "INSTANCE", "Lcom/stepos/alphame/location/LocationManager;", "getINSTANCE", "()Lcom/stepos/alphame/location/LocationManager;", "INSTANCE$delegate", "Lkotlin/Lazy;", "LOCATION_SUCCESS_CODE", "", "TAG", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LocationManager getINSTANCE() {
            return (LocationManager) LocationManager.INSTANCE$delegate.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.stepos.alphame.location.LocationManager$getCurLocation$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Function1<MapLocation, Unit> $invoke;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Context context, Function1<? super MapLocation, Unit> function1) {
            super(0);
            this.$context = context;
            this.$invoke = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(Function1 invoke, MapLocation mapLocation) {
            Intrinsics.checkNotNullParameter(invoke, "$invoke");
            invoke.invoke(mapLocation);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AlphaMeLogger.debugLog(LocationManager.TAG, "start location inner");
            MapLocationClient locationClient = LocationManager.this.getLocationClient(this.$context);
            final Function1<MapLocation, Unit> function1 = this.$invoke;
            locationClient.setLocationListener(new MapLocationListener() { // from class: com.stepos.alphame.location.a
                @Override // com.stepos.alphame.location.MapLocationListener
                public final void onLocationChanged(MapLocation mapLocation) {
                    LocationManager.AnonymousClass1.invoke$lambda$0(function1, mapLocation);
                }
            });
            locationClient.stopLocation();
            locationClient.startLocation();
        }
    }

    public LocationManager() {
        ApplicationImpl application = ApplicationImpl.getApplication();
        MapLocationClient.initPrivacyAndSdk(application);
        Log.d("initMap", "context = " + application);
    }

    public final void getCurLocation(@NotNull Context context, @NotNull Function1<? super MapLocation, Unit> invoke) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        CorountinesUtilsKt.launchInSingleLocationDispatcher(new AnonymousClass1(context, invoke));
    }

    @NotNull
    public final MapLocationClient getLocationClient(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MapLocationClient mapLocationClient = this.mapLocationClient;
        if (mapLocationClient != null) {
            return mapLocationClient;
        }
        MapLocationClient mapLocationClient2 = new MapLocationClient(context);
        this.mapLocationClient = mapLocationClient2;
        return mapLocationClient2;
    }
}
