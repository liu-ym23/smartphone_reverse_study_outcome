package android.os.collector;

import android.os.collector.base.StepOSBaseEntity;
import android.os.collector.device.StepOSAppPowerConsumptionData;
import android.os.collector.device.StepOSBatteryData;
import android.os.collector.device.StepOSBluetoothConnectionData;
import android.os.collector.device.StepOSCameraData;
import android.os.collector.device.StepOSCameraLightData;
import android.os.collector.device.StepOSLocationServiceData;
import android.os.collector.device.StepOSNavigationData;
import android.os.collector.device.StepOSStorageData;
import android.os.collector.device.StepOSTelephoneData;
import android.os.collector.device.StepOSTestOnlyData;
import android.os.collector.device.StepOSWifiApData;
import android.os.collector.device.StepOSWifiStateData;
import android.os.collector.scene.StepOSSceneData;
import android.os.collector.sensor.StepOSSensorData;
import android.os.collector.system.StepOSAnrData;
import android.os.collector.system.StepOSAppTagStateData;
import android.os.collector.system.StepOSAudioData;
import android.os.collector.system.StepOSBinderResourceData;
import android.os.collector.system.StepOSCastData;
import android.os.collector.system.StepOSForegroundAppStateData;
import android.os.collector.system.StepOSGcHeapData;
import android.os.collector.system.StepOSMediaData;
import android.os.collector.system.StepOSMediaProjectionData;
import android.os.collector.system.StepOSMemoryPressureData;
import android.os.collector.system.StepOSMicUsageData;
import android.os.collector.system.StepOSPowerConsumptionData;
import android.os.collector.system.StepOSPowerManagerStateData;
import android.os.collector.system.StepOSProcessMemoryStateData;
import android.os.collector.system.StepOSSystemMemoryData;
import android.os.collector.system.StepOSThermalManagerData;
import android.os.collector.system.StepOSWakeLockData;
import android.os.collector.system.StepOSWatchdogData;
import android.os.collector.user.StepOSAlarmClockChangeData;
import android.os.collector.user.StepOSAppUsageStateData;
import android.os.collector.user.StepOSClipboardChangeData;
import android.os.collector.user.StepOSForegroundChangeData;
import android.os.collector.user.StepOSForegroundWindowModeData;
import android.os.collector.user.StepOSInputCommitData;
import android.os.collector.user.StepOSKeyguardChangeData;
import android.os.collector.user.StepOSMediaFileData;
import android.os.collector.user.StepOSMediaMetadataData;
import android.os.collector.user.StepOSNotificationPostData;
import android.os.collector.user.StepOSScreenUsageData;
import android.os.collector.user.StepOSShareData;
import android.os.collector.user.StepOSZenModeChangeData;
import android.util.SparseArray;

/* loaded from: classes.dex */
public final class StepOSEntityRegistry {
    private static final SparseArray<StepOSBaseEntity.EntityFactory<? extends StepOSBaseEntity>> REGISTRY = new SparseArray<>(45);

    private StepOSEntityRegistry() {
    }

    static {
        register(StepOSCollectAtomID.DEVICE_DOMAIN_TAG_BATTERY, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda0
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSBatteryData();
            }
        });
        register(StepOSCollectAtomID.DEVICE_DOMAIN_TAG_STORAGE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda11
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSStorageData();
            }
        });
        register(StepOSCollectAtomID.DEVICE_DOMAIN_TAG_TELEPHONE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda22
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSTelephoneData();
            }
        });
        register(StepOSCollectAtomID.DEVICE_DOMAIN_TAG_CAMERA, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda33
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSCameraData();
            }
        });
        register(StepOSCollectAtomID.DEVICE_DOMAIN_TAG_CAMERA_LIGHT, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda39
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSCameraLightData();
            }
        });
        register(StepOSCollectAtomID.DEVICE_DOMAIN_TAG_WIFI_AP, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda40
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSWifiApData();
            }
        });
        register(StepOSCollectAtomID.DEVICE_DOMAIN_TAG_NAVIGATION, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda41
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSNavigationData();
            }
        });
        register(StepOSCollectAtomID.DEVICE_DOMAIN_TAG_WIFI_STATE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda42
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSWifiStateData();
            }
        });
        register(StepOSCollectAtomID.DEVICE_DOMAIN_TAG_BLUETOOTH_CONNECTION, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda43
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSBluetoothConnectionData();
            }
        });
        register(StepOSCollectAtomID.DEVICE_DOMAIN_TAG_TEST_ONLY, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda44
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSTestOnlyData();
            }
        });
        register(StepOSCollectAtomID.DEVICE_DOMAIN_TAG_LOCATION_SERVICE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda1
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSLocationServiceData();
            }
        });
        register(StepOSCollectAtomID.DEVICE_DOMAIN_TAG_APP_POWER_CONSUMPTION, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda2
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSAppPowerConsumptionData();
            }
        });
        register(StepOSCollectAtomID.SCENE_DOMAIN_TAG_SCENE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda3
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSSceneData();
            }
        });
        register(StepOSCollectAtomID.SENSOR_DOMAIN_TAG_SENSOR, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda4
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSSensorData();
            }
        });
        register(4, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda5
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSWakeLockData();
            }
        });
        register(6, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda6
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSPowerManagerStateData();
            }
        });
        register(7, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda7
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSThermalManagerData();
            }
        });
        register(8, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda8
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSPowerConsumptionData();
            }
        });
        register(9, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda9
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSCastData();
            }
        });
        register(10, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda10
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSMediaData();
            }
        });
        register(11, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda12
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSMediaProjectionData();
            }
        });
        register(12, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda13
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSAudioData();
            }
        });
        register(13, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda14
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSGcHeapData();
            }
        });
        register(14, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda15
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSForegroundAppStateData();
            }
        });
        register(15, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda16
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSAppTagStateData();
            }
        });
        register(16, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda17
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSMemoryPressureData();
            }
        });
        register(17, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda18
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSMicUsageData();
            }
        });
        register(StepOSCollectAtomID.SYSTEM_DOMAIN_TAG_ANR, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda19
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSAnrData();
            }
        });
        register(StepOSCollectAtomID.SYSTEM_DOMAIN_TAG_WATCHDOG, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda20
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSWatchdogData();
            }
        });
        register(StepOSCollectAtomID.SYSTEM_DOMAIN_TAG_SYSTEM_MEMORY, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda21
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSSystemMemoryData();
            }
        });
        register(StepOSCollectAtomID.SYSTEM_DOMAIN_TAG_BINDER_RESOURCE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda23
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSBinderResourceData();
            }
        });
        register(StepOSCollectAtomID.SYSTEM_DOMAIN_TAG_PROCESS_MEMORY_STATE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda24
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSProcessMemoryStateData();
            }
        });
        register(StepOSCollectAtomID.USER_DOMAIN_TAG_FOREGROUND_CHANGE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda25
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSForegroundChangeData();
            }
        });
        register(StepOSCollectAtomID.USER_DOMAIN_TAG_CLIPBOARD_CHANGE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda26
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSClipboardChangeData();
            }
        });
        register(StepOSCollectAtomID.USER_DOMAIN_TAG_SCREEN_USAGE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda27
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSScreenUsageData();
            }
        });
        register(StepOSCollectAtomID.USER_DOMAIN_TAG_NOTIFICATION_POST, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda28
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSNotificationPostData();
            }
        });
        register(StepOSCollectAtomID.USER_DOMAIN_TAG_INPUT_COMMIT, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda29
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSInputCommitData();
            }
        });
        register(StepOSCollectAtomID.USER_DOMAIN_TAG_MEDIA_METADATA, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda30
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSMediaMetadataData();
            }
        });
        register(StepOSCollectAtomID.USER_DOMAIN_TAG_FOREGROUND_WINDOW_MODE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda31
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSForegroundWindowModeData();
            }
        });
        register(StepOSCollectAtomID.USER_DOMAIN_TAG_SHARE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda32
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSShareData();
            }
        });
        register(StepOSCollectAtomID.USER_DOMAIN_TAG_ALARM_CLOCK_CHANGE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda34
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSAlarmClockChangeData();
            }
        });
        register(StepOSCollectAtomID.USER_DOMAIN_TAG_ZEN_MODE_CHANGE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda35
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSZenModeChangeData();
            }
        });
        register(StepOSCollectAtomID.USER_DOMAIN_TAG_KEYGUARD_CHANGE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda36
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSKeyguardChangeData();
            }
        });
        register(StepOSCollectAtomID.USER_DOMAIN_TAG_MEDIA_FILE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda37
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSMediaFileData();
            }
        });
        register(StepOSCollectAtomID.USER_DOMAIN_TAG_APP_USAGE_STATE, new StepOSBaseEntity.EntityFactory() { // from class: android.os.collector.StepOSEntityRegistry$$ExternalSyntheticLambda38
            @Override // android.os.collector.base.StepOSBaseEntity.EntityFactory
            public final StepOSBaseEntity create() {
                return new StepOSAppUsageStateData();
            }
        });
    }

    private static void register(int atomId, StepOSBaseEntity.EntityFactory<? extends StepOSBaseEntity> factory) {
        if (REGISTRY.indexOfKey(atomId) >= 0) {
            throw new IllegalStateException("Duplicate atomId: 0x" + Integer.toHexString(atomId));
        }
        REGISTRY.put(atomId, factory);
    }

    public static StepOSBaseEntity create(int atomId) {
        StepOSBaseEntity.EntityFactory<? extends StepOSBaseEntity> f = REGISTRY.get(atomId);
        if (f == null) {
            return null;
        }
        return f.create();
    }
}
