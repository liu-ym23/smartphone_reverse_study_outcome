package com.stepos.alphame.persona.data.repo;

import B0.f;
import F1.n;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.joran.action.Action;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.bluetooth.BlueToothEngine;
import com.stepos.alphame.bluetooth.BluetoothRecord;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.alphame.location.FrequentLocation;
import com.stepos.alphame.location.FrequentLocationManager;
import com.stepos.alphame.location.FrequentWifi;
import com.stepos.alphame.persona.PersonaDataItem;
import com.stepos.alphame.persona.PersonaStorable;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.alphame.persona.address.data.AddressInfo;
import com.stepos.alphame.persona.address.data.AddressTipBean;
import com.stepos.alphame.persona.address.data.AddressTipResponse;
import com.stepos.alphame.persona.carbluetooth.bean.BluetoothInfo;
import com.stepos.alphame.persona.common.time.bean.TimeInfo;
import com.stepos.alphame.persona.data.PersonalDataType;
import com.stepos.alphame.persona.data.bean.CommutingMode;
import com.stepos.alphame.persona.data.config.PersonalPreferenceConfigs;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.persona.wifi.bean.WifiInfo;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.DateTimeKt;
import com.stepos.alphame.utils.LongKt;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.net.EngineHttpClient;
import com.stepos.alphame.utils.net.HttpRequest;
import com.stepos.alphame.utils.net.HttpRequestBody;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 82\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00062\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018J\u0014\u0010\u0019\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018J\u0014\u0010\u001a\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0014\u0010\u001d\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010!\u001a\u00020\u0016J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u0018J\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010(\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010)\u001a\u00020\u0004H\u0002J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00182\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%J\u0016\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\rJ\u0016\u00100\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0012J\u000e\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0016J\u0016\u00104\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u001cJ\u0016\u00106\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u001f¨\u00069"}, d2 = {"Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "", "()V", "addToMultiMap", "", "map", "", "", "", "Lcom/stepos/alphame/persona/PersonaDataItem;", Action.KEY_ATTRIBUTE, "value", "getAddressInfo", "Lcom/stepos/alphame/persona/address/data/AddressInfo;", "eventId", "Lcom/stepos/alphame/persona/domain/event/EventId;", "getAutoAddress", "getAutoCarBluetooth", "Lcom/stepos/alphame/persona/carbluetooth/bean/BluetoothInfo;", PersonalContract.FUN_GET_AUTO_LEARNING_STATE, "", "getAutoOffDutyTime", "", "personalDataList", "", "getAutoSleepTime", "getAutoTimeAwayFromHome", "getAutoTimeInfo", "Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;", "getAutoWakeupTime", "getAutoWifi", "Lcom/stepos/alphame/persona/wifi/bean/WifiInfo;", "getCarBluetoothInfo", PersonalContract.FUN_GET_COMMUTING_MODE, "getEventId", "type", "getKey", "", "getPersonaList", "getTimeInfo", "getWifiInfo", "mergeOldDataWhenUpgrade", "requestAddressTipsV1", "Lcom/stepos/alphame/persona/address/data/AddressTipBean;", "tip", "city", "setAddressInfo", "addressInfo", "setCarBluetoothInfo", "bluetoothInfo", PersonalContract.FUN_SET_COMMUTING_MODE, "mode", "setTimeInfo", "timeInfo", "setWifiInfo", "wifiInfo", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPersonalRepo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersonalRepo.kt\ncom/stepos/alphame/persona/data/repo/PersonalRepo\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,566:1\n494#2,7:567\n494#2,7:574\n494#2,7:581\n494#2,7:588\n*S KotlinDebug\n*F\n+ 1 PersonalRepo.kt\ncom/stepos/alphame/persona/data/repo/PersonalRepo\n*L\n296#1:567,7\n344#1:574,7\n392#1:581,7\n440#1:588,7\n*E\n"})
/* loaded from: classes.dex */
public final class PersonalRepo {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<PersonalRepo> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<PersonalRepo>() { // from class: com.stepos.alphame.persona.data.repo.PersonalRepo$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PersonalRepo invoke() {
            return new PersonalRepo();
        }
    });

    @NotNull
    public static final String TAG = "Personal";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stepos/alphame/persona/data/repo/PersonalRepo$Companion;", "", "()V", "INSTANCE", "Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "getINSTANCE", "()Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "INSTANCE$delegate", "Lkotlin/Lazy;", "TAG", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PersonalRepo getINSTANCE() {
            return (PersonalRepo) PersonalRepo.INSTANCE$delegate.getValue();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventId.values().length];
            try {
                iArr[EventId.TIME_AWAY_FROM_HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventId.OFF_DUTY_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventId.SLEEP_TIME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EventId.WAKE_UP_TIME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EventId.HOME_ADDRESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EventId.COMPANY_ADDRESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EventId.HOME_WIFI.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EventId.COMPANY_WIFI.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EventId.COMMUTING_MODE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[EventId.CAR_BLUETOOTH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PersonalRepo() {
        mergeOldDataWhenUpgrade();
    }

    private final void addToMultiMap(Map<Integer, List<PersonaDataItem>> map, int key, PersonaDataItem value) {
        if (!map.containsKey(Integer.valueOf(key))) {
            map.put(Integer.valueOf(key), CollectionsKt.mutableListOf(value));
            return;
        }
        List<PersonaDataItem> list = map.get(Integer.valueOf(key));
        if (list != null) {
            list.add(value);
        }
    }

    private final String getKey(EventId eventId) {
        switch (WhenMappings.$EnumSwitchMapping$0[eventId.ordinal()]) {
            case 1:
                return PersonalPreferenceConfigs.KEY_TIME_AWAY_FROM_HOME;
            case 2:
                return PersonalPreferenceConfigs.KEY_OFF_DUTY_TIME;
            case 3:
                return PersonalPreferenceConfigs.KEY_SLEEP_TIME;
            case 4:
                return PersonalPreferenceConfigs.KEY_WAKE_UP_TIME;
            case 5:
                return PersonalPreferenceConfigs.KEY_HOME_ADDRESS;
            case 6:
                return PersonalPreferenceConfigs.KEY_COMPANY_ADDRESS;
            case 7:
                return PersonalPreferenceConfigs.KEY_HOME_WIFI;
            case 8:
                return PersonalPreferenceConfigs.KEY_COMPANY_WIFI;
            case 9:
                return PersonalPreferenceConfigs.KEY_COMMUTING_MODE;
            case 10:
                return PersonalPreferenceConfigs.KEY_CAR_BLUETOOTH;
            default:
                return "";
        }
    }

    private final void mergeOldDataWhenUpgrade() {
        if (ApplicationImpl.getApplication() == null || f.i(ApplicationImpl.getApplication(), "android.permission.BLUETOOTH_CONNECT") == 0) {
            try {
                String chosenVehicleBluetooth = Property.getChosenVehicleBluetooth(ApplicationImpl.getApplication().getContentResolver());
                BluetoothInfo bluetoothInfo = new BluetoothInfo();
                if (TextUtils.isEmpty(chosenVehicleBluetooth)) {
                    return;
                }
                BluetoothRecord byAddress = VehicleBluetoothManager.getInstance(ApplicationImpl.getApplication()).getByAddress(chosenVehicleBluetooth);
                if (byAddress == null) {
                    byAddress = new BluetoothRecord();
                    byAddress.setAddress(chosenVehicleBluetooth);
                    for (BluetoothDevice bluetoothDevice : BluetoothAdapter.getDefaultAdapter().getBondedDevices()) {
                        if (Intrinsics.areEqual(chosenVehicleBluetooth, bluetoothDevice.getAddress())) {
                            byAddress.setName(bluetoothDevice.getName());
                        }
                    }
                }
                if (TextUtils.isEmpty(byAddress.getAddress()) || TextUtils.isEmpty(byAddress.getName())) {
                    return;
                }
                String name = byAddress.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                bluetoothInfo.setBluetoothName(name);
                String address = byAddress.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                bluetoothInfo.setBluetoothAddress(address);
                setCarBluetoothInfo(EventId.CAR_BLUETOOTH, bluetoothInfo);
            } catch (Exception unused) {
            }
        }
    }

    @NotNull
    public final AddressInfo getAddressInfo(@NotNull EventId eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        try {
            AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, "getAddressInfo id " + eventId);
            String key = getKey(eventId);
            if (!TextUtils.isEmpty(key)) {
                String str = (String) PersonalPreferenceConfigs.INSTANCE.getData(key, "");
                AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, "getAddressInfo json " + str);
                if (!TextUtils.isEmpty(str)) {
                    AddressInfo addressInfo = (AddressInfo) new n().b(AddressInfo.class, str);
                    AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, "getAddressInfo result " + addressInfo);
                    Intrinsics.checkNotNull(addressInfo);
                    return addressInfo;
                }
            }
        } catch (Exception unused) {
        }
        return new AddressInfo();
    }

    @NotNull
    public final AddressInfo getAutoAddress(@NotNull EventId eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        FrequentLocationManager frequentLocationManager = FrequentLocationManager.getInstance(ApplicationImpl.getApplication());
        FrequentLocation home = eventId == EventId.HOME_ADDRESS ? frequentLocationManager.getHome() : frequentLocationManager.getCompany();
        if (home == null || TextUtils.isEmpty(home.getAddress())) {
            AddressInfo addressInfo = new AddressInfo();
            addressInfo.setType(PersonalDataType.AUTO.getType());
            return addressInfo;
        }
        long type = PersonalDataType.AUTO.getType();
        String address = home.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
        String district = home.getDistrict();
        Intrinsics.checkNotNullExpressionValue(district, "getDistrict(...)");
        return new AddressInfo(type, address, district, AbstractC0351g.q(home.getLongitude(), ",", home.getLatitude()));
    }

    @NotNull
    public final BluetoothInfo getAutoCarBluetooth() {
        String[] vehicleBluetoothInfo = BlueToothEngine.getInstance(ApplicationImpl.getApplication()).getVehicleBluetoothInfo(false);
        if (vehicleBluetoothInfo == null) {
            return new BluetoothInfo();
        }
        long type = PersonalDataType.AUTO.getType();
        String str = vehicleBluetoothInfo[0];
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String str2 = vehicleBluetoothInfo[1];
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        return new BluetoothInfo(type, str, str2);
    }

    public final boolean getAutoLearningState() {
        boolean zBooleanValue = ((Boolean) PersonalPreferenceConfigs.INSTANCE.getData(PersonalPreferenceConfigs.KEY_IS_AUTO_LEARNING, Boolean.TRUE)).booleanValue();
        AlphaMeLogger.debugLog("Personal", "getAutoLearningState result " + zBooleanValue);
        return zBooleanValue;
    }

    public final long getAutoOffDutyTime(@NotNull List<? extends PersonaDataItem> personalDataList) {
        Intrinsics.checkNotNullParameter(personalDataList, "personalDataList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (PersonaDataItem personaDataItem : personalDataList) {
            long j4 = personaDataItem.off_duty_time;
            if (j4 > 0) {
                int hour = LongKt.getHour(j4);
                AlphaMeLogger.debugLog("Personal", "off_duty_time hour " + hour);
                linkedHashMap.put(Integer.valueOf(hour), Integer.valueOf(((Number) linkedHashMap.getOrDefault(Integer.valueOf(hour), 0)).intValue() + 1));
                addToMultiMap(linkedHashMap2, hour, personaDataItem);
            }
        }
        Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) linkedHashMap.values());
        int iIntValue = num != null ? num.intValue() : 0;
        AlphaMeLogger.debugLog("Personal", "maxFrequency " + iIntValue);
        if (iIntValue != 0) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (((Number) entry.getValue()).intValue() == iIntValue) {
                    linkedHashMap3.put(entry.getKey(), entry.getValue());
                }
            }
            List list = CollectionsKt.toList(linkedHashMap3.keySet());
            AlphaMeLogger.debugLog("Personal", "modes " + list);
            if (!list.isEmpty()) {
                List<PersonaDataItem> list2 = linkedHashMap2.get(list.get(0));
                AlphaMeLogger.debugLog("Personal", "targetList " + list2);
                if (list2 != null && (!list2.isEmpty())) {
                    Iterator<PersonaDataItem> it = list2.iterator();
                    int i4 = 0;
                    int i5 = 0;
                    while (it.hasNext()) {
                        long j5 = it.next().off_duty_time;
                        if (j5 > 0) {
                            AlphaMeLogger.debugLog("Personal", "off_duty_time " + LongKt.formatDateYear(j5));
                            int min = LongKt.getMin(j5);
                            AlphaMeLogger.debugLog("Personal", "off_duty_time min " + min);
                            i5++;
                            i4 += min;
                        }
                    }
                    if (i4 > 0) {
                        long customTimestamp = DateTimeKt.getCustomTimestamp(((Number) list.get(0)).intValue(), i4 / i5);
                        AlphaMeLogger.debugLog("Personal", "average off_duty_time " + LongKt.formatDateYear(customTimestamp));
                        return customTimestamp;
                    }
                }
            }
        }
        return 0L;
    }

    public final long getAutoSleepTime(@NotNull List<? extends PersonaDataItem> personalDataList) {
        Intrinsics.checkNotNullParameter(personalDataList, "personalDataList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (PersonaDataItem personaDataItem : personalDataList) {
            long j4 = personaDataItem.sleep_time;
            if (j4 > 0) {
                int hour = LongKt.getHour(j4);
                AlphaMeLogger.debugLog("Personal", "sleep_time hour " + hour);
                linkedHashMap.put(Integer.valueOf(hour), Integer.valueOf(((Number) linkedHashMap.getOrDefault(Integer.valueOf(hour), 0)).intValue() + 1));
                addToMultiMap(linkedHashMap2, hour, personaDataItem);
            }
        }
        Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) linkedHashMap.values());
        int iIntValue = num != null ? num.intValue() : 0;
        AlphaMeLogger.debugLog("Personal", "maxFrequency " + iIntValue);
        if (iIntValue != 0) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (((Number) entry.getValue()).intValue() == iIntValue) {
                    linkedHashMap3.put(entry.getKey(), entry.getValue());
                }
            }
            List list = CollectionsKt.toList(linkedHashMap3.keySet());
            AlphaMeLogger.debugLog("Personal", "modes " + list);
            if (!list.isEmpty()) {
                List<PersonaDataItem> list2 = linkedHashMap2.get(list.get(0));
                AlphaMeLogger.debugLog("Personal", "targetList " + list2);
                if (list2 != null && (!list2.isEmpty())) {
                    Iterator<PersonaDataItem> it = list2.iterator();
                    int i4 = 0;
                    int i5 = 0;
                    while (it.hasNext()) {
                        long j5 = it.next().sleep_time;
                        if (j5 > 0) {
                            AlphaMeLogger.debugLog("Personal", "sleep_time " + LongKt.formatDateYear(j5));
                            int min = LongKt.getMin(j5);
                            AlphaMeLogger.debugLog("Personal", "sleep min " + min);
                            i5++;
                            i4 += min;
                        }
                    }
                    if (i4 > 0) {
                        long customTimestamp = DateTimeKt.getCustomTimestamp(((Number) list.get(0)).intValue(), i4 / i5);
                        AlphaMeLogger.debugLog("Personal", "average sleep_time " + LongKt.formatDateYear(customTimestamp));
                        return customTimestamp;
                    }
                }
            }
        }
        return 0L;
    }

    public final long getAutoTimeAwayFromHome(@NotNull List<? extends PersonaDataItem> personalDataList) {
        Intrinsics.checkNotNullParameter(personalDataList, "personalDataList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (PersonaDataItem personaDataItem : personalDataList) {
            long j4 = personaDataItem.on_duty_time;
            if (j4 > 0) {
                int hour = LongKt.getHour(j4);
                AlphaMeLogger.debugLog("Personal", "leave_home_time hour " + hour);
                linkedHashMap.put(Integer.valueOf(hour), Integer.valueOf(((Number) linkedHashMap.getOrDefault(Integer.valueOf(hour), 0)).intValue() + 1));
                addToMultiMap(linkedHashMap2, hour, personaDataItem);
            }
        }
        Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) linkedHashMap.values());
        int iIntValue = num != null ? num.intValue() : 0;
        AlphaMeLogger.debugLog("Personal", "maxFrequency " + iIntValue);
        if (iIntValue != 0) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (((Number) entry.getValue()).intValue() == iIntValue) {
                    linkedHashMap3.put(entry.getKey(), entry.getValue());
                }
            }
            List list = CollectionsKt.toList(linkedHashMap3.keySet());
            AlphaMeLogger.debugLog("Personal", "modes " + list);
            if (!list.isEmpty()) {
                List<PersonaDataItem> list2 = linkedHashMap2.get(list.get(0));
                AlphaMeLogger.debugLog("Personal", "targetList " + list2);
                if (list2 != null && (!list2.isEmpty())) {
                    Iterator<PersonaDataItem> it = list2.iterator();
                    int i4 = 0;
                    int i5 = 0;
                    while (it.hasNext()) {
                        long j5 = it.next().on_duty_time;
                        if (j5 > 0) {
                            AlphaMeLogger.debugLog("Personal", "leave_home_time " + LongKt.formatDateYear(j5));
                            int min = LongKt.getMin(j5);
                            AlphaMeLogger.debugLog("Personal", "leave_home_time min " + min);
                            i5++;
                            i4 += min;
                        }
                    }
                    if (i4 > 0) {
                        long customTimestamp = DateTimeKt.getCustomTimestamp(((Number) list.get(0)).intValue(), i4 / i5);
                        AlphaMeLogger.debugLog("Personal", "average leave_home_time " + LongKt.formatDateYear(customTimestamp));
                        return customTimestamp;
                    }
                }
            }
        }
        return 0L;
    }

    @NotNull
    public final TimeInfo getAutoTimeInfo(@NotNull EventId eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        List<PersonaDataItem> personaList = getPersonaList();
        int i4 = WhenMappings.$EnumSwitchMapping$0[eventId.ordinal()];
        return new TimeInfo(PersonalDataType.AUTO.getType(), i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? 0L : getAutoWakeupTime(personaList) : getAutoSleepTime(personaList) : getAutoOffDutyTime(personaList) : getAutoTimeAwayFromHome(personaList));
    }

    public final long getAutoWakeupTime(@NotNull List<? extends PersonaDataItem> personalDataList) {
        Intrinsics.checkNotNullParameter(personalDataList, "personalDataList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (PersonaDataItem personaDataItem : personalDataList) {
            long j4 = personaDataItem.rise_time;
            if (j4 > 0) {
                int hour = LongKt.getHour(j4);
                AlphaMeLogger.debugLog("Personal", "rise_time hour " + hour);
                linkedHashMap.put(Integer.valueOf(hour), Integer.valueOf(((Number) linkedHashMap.getOrDefault(Integer.valueOf(hour), 0)).intValue() + 1));
                addToMultiMap(linkedHashMap2, hour, personaDataItem);
            }
        }
        Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) linkedHashMap.values());
        int iIntValue = num != null ? num.intValue() : 0;
        AlphaMeLogger.debugLog("Personal", "maxFrequency " + iIntValue);
        if (iIntValue != 0) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (((Number) entry.getValue()).intValue() == iIntValue) {
                    linkedHashMap3.put(entry.getKey(), entry.getValue());
                }
            }
            List list = CollectionsKt.toList(linkedHashMap3.keySet());
            AlphaMeLogger.debugLog("Personal", "modes " + list);
            if (!list.isEmpty()) {
                List<PersonaDataItem> list2 = linkedHashMap2.get(list.get(0));
                AlphaMeLogger.debugLog("Personal", "targetList " + list2);
                if (list2 != null && (!list2.isEmpty())) {
                    Iterator<PersonaDataItem> it = list2.iterator();
                    int i4 = 0;
                    int i5 = 0;
                    while (it.hasNext()) {
                        long j5 = it.next().rise_time;
                        if (j5 > 0) {
                            AlphaMeLogger.debugLog("Personal", "rise_time " + LongKt.formatDateYear(j5));
                            int min = LongKt.getMin(j5);
                            AlphaMeLogger.debugLog("Personal", "rise_time min " + min);
                            i5++;
                            i4 += min;
                        }
                    }
                    if (i4 > 0) {
                        long customTimestamp = DateTimeKt.getCustomTimestamp(((Number) list.get(0)).intValue(), i4 / i5);
                        AlphaMeLogger.debugLog("Personal", "average rise_time " + LongKt.formatDateYear(customTimestamp));
                        return customTimestamp;
                    }
                }
            }
        }
        return 0L;
    }

    @NotNull
    public final WifiInfo getAutoWifi(@NotNull EventId eventId) {
        FrequentWifi mostFrequentWifi;
        FrequentWifi mostFrequentWifi2;
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        FrequentLocationManager frequentLocationManager = FrequentLocationManager.getInstance(ApplicationImpl.getApplication());
        if (eventId == EventId.HOME_WIFI) {
            if (frequentLocationManager.getHome() != null && (mostFrequentWifi2 = frequentLocationManager.getHome().getMostFrequentWifi()) != null) {
                return new WifiInfo(PersonalDataType.AUTO.getType(), StringsKt.s(mostFrequentWifi2.getSsid(), String.valueOf('\"'), ""), mostFrequentWifi2.getBssid());
            }
        } else if (frequentLocationManager.getCompany() != null && (mostFrequentWifi = frequentLocationManager.getCompany().getMostFrequentWifi()) != null) {
            return new WifiInfo(PersonalDataType.AUTO.getType(), StringsKt.s(mostFrequentWifi.getSsid(), String.valueOf('\"'), ""), mostFrequentWifi.getBssid());
        }
        return new WifiInfo();
    }

    @NotNull
    public final BluetoothInfo getCarBluetoothInfo(@NotNull EventId eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        try {
            AlphaMeLogger.debugLog("Personal", "getCarBluetoothInfo id " + eventId);
            String key = getKey(eventId);
            if (!TextUtils.isEmpty(key)) {
                String str = (String) PersonalPreferenceConfigs.INSTANCE.getData(key, "");
                AlphaMeLogger.debugLog("Personal", "getCarBluetoothInfo json " + str);
                if (!TextUtils.isEmpty(str)) {
                    BluetoothInfo bluetoothInfo = (BluetoothInfo) new n().b(BluetoothInfo.class, str);
                    AlphaMeLogger.debugLog("Personal", "getCarBluetoothInfo result " + bluetoothInfo);
                    Intrinsics.checkNotNull(bluetoothInfo);
                    return bluetoothInfo;
                }
            }
        } catch (Exception unused) {
        }
        return new BluetoothInfo();
    }

    public final long getCommutingMode() {
        return ((Number) PersonalPreferenceConfigs.INSTANCE.getData(PersonalPreferenceConfigs.KEY_COMMUTING_MODE, Long.valueOf(CommutingMode.DRIVE.getMode()))).longValue();
    }

    @NotNull
    public final EventId getEventId(int type) {
        EventId eventId = EventId.HOME_ADDRESS;
        if (type == eventId.getId()) {
            return eventId;
        }
        EventId eventId2 = EventId.COMPANY_ADDRESS;
        if (type == eventId2.getId()) {
            return eventId2;
        }
        EventId eventId3 = EventId.HOME_WIFI;
        if (type == eventId3.getId()) {
            return eventId3;
        }
        EventId eventId4 = EventId.COMPANY_WIFI;
        if (type == eventId4.getId()) {
            return eventId4;
        }
        EventId eventId5 = EventId.TIME_AWAY_FROM_HOME;
        if (type == eventId5.getId()) {
            return eventId5;
        }
        EventId eventId6 = EventId.OFF_DUTY_TIME;
        if (type == eventId6.getId()) {
            return eventId6;
        }
        EventId eventId7 = EventId.SLEEP_TIME;
        if (type == eventId7.getId()) {
            return eventId7;
        }
        EventId eventId8 = EventId.WAKE_UP_TIME;
        if (type == eventId8.getId()) {
            return eventId8;
        }
        EventId eventId9 = EventId.COMMUTING_MODE;
        if (type == eventId9.getId()) {
            return eventId9;
        }
        EventId eventId10 = EventId.CAR_BLUETOOTH;
        return type == eventId10.getId() ? eventId10 : EventId.INVALID;
    }

    @NotNull
    public final List<PersonaDataItem> getPersonaList() {
        LocalDate localDateWith = LocalDate.now().minusWeeks(1L).with((TemporalAdjuster) DayOfWeek.MONDAY);
        LocalDate localDatePlusDays = localDateWith.plusDays(7L);
        LocalTime localTime = LocalTime.MIN;
        LocalDateTime localDateTimeOf = LocalDateTime.of(localDateWith, localTime);
        Intrinsics.checkNotNullExpressionValue(localDateTimeOf, "of(...)");
        ZoneOffset UTC = ZoneOffset.UTC;
        Intrinsics.checkNotNullExpressionValue(UTC, "UTC");
        long dayZero = LongKt.getDayZero(DateTimeKt.toEpochMilli(localDateTimeOf, UTC));
        LocalDateTime localDateTimeOf2 = LocalDateTime.of(localDatePlusDays, localTime);
        Intrinsics.checkNotNullExpressionValue(localDateTimeOf2, "of(...)");
        Intrinsics.checkNotNullExpressionValue(UTC, "UTC");
        long dayZero2 = LongKt.getDayZero(DateTimeKt.toEpochMilli(localDateTimeOf2, UTC));
        AlphaMeLogger.debugLog("Personal", "last week first day " + LongKt.formatDateFull(dayZero, "yyyy/MM/dd HH:mm:ss") + " last day " + LongKt.formatDateFull(dayZero2, "yyyy/MM/dd HH:mm:ss"));
        List<PersonaDataItem> personaList = new PersonaStorable().getPersonaList(dayZero, dayZero2);
        AlphaMeLogger.debugLog("Personal", "list size " + personaList.size());
        Intrinsics.checkNotNull(personaList);
        return personaList;
    }

    @NotNull
    public final TimeInfo getTimeInfo(@NotNull EventId eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        try {
            AlphaMeLogger.debugLog("Personal", "getTimeInfo id " + eventId);
            String key = getKey(eventId);
            if (!TextUtils.isEmpty(key)) {
                AlphaMeLogger.debugLog("Personal", "getTimeInfo key " + key);
                String str = (String) PersonalPreferenceConfigs.INSTANCE.getData(key, "");
                AlphaMeLogger.debugLog("Personal", "getTimeInfo json " + str);
                if (!TextUtils.isEmpty(str)) {
                    TimeInfo timeInfo = (TimeInfo) new n().b(TimeInfo.class, str);
                    AlphaMeLogger.debugLog("Personal", "getTimeInfo result " + timeInfo);
                    Intrinsics.checkNotNull(timeInfo);
                    return timeInfo;
                }
            }
        } catch (Exception unused) {
        }
        return new TimeInfo();
    }

    @NotNull
    public final WifiInfo getWifiInfo(@NotNull EventId eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        try {
            AlphaMeLogger.debugLog("Personal", "getWifiInfo id " + eventId);
            String key = getKey(eventId);
            if (!TextUtils.isEmpty(key)) {
                String str = (String) PersonalPreferenceConfigs.INSTANCE.getData(key, "");
                AlphaMeLogger.debugLog("Personal", "getWifiInfo json " + str);
                if (!TextUtils.isEmpty(str)) {
                    WifiInfo wifiInfo = (WifiInfo) new n().b(WifiInfo.class, str);
                    AlphaMeLogger.debugLog("Personal", "getWifiInfo result " + wifiInfo);
                    Intrinsics.checkNotNull(wifiInfo);
                    return wifiInfo;
                }
            }
        } catch (Exception unused) {
        }
        return new WifiInfo();
    }

    @NotNull
    public final List<AddressTipBean> requestAddressTipsV1(@NotNull String tip, @NotNull String city) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        Intrinsics.checkNotNullParameter(city, "city");
        ArrayList arrayList = new ArrayList();
        try {
            HttpRequestBody httpRequestBodyForm = HttpRequestBody.form();
            httpRequestBodyForm.add("keywords", tip);
            httpRequestBodyForm.add("city", city);
            String str = (String) EngineHttpClient.getInstance().requestSync(new HttpRequest.Builder().url("").requestBody(httpRequestBodyForm).build(), String.class);
            AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, "resp " + str);
            AddressTipResponse addressTipResponse = (AddressTipResponse) new n().b(AddressTipResponse.class, str);
            if (addressTipResponse != null) {
                arrayList.addAll(addressTipResponse.getValue());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        AlphaMeLogger.debugLog(PersonalContract.ADDRESS_TAG, "list " + arrayList.size() + AwarenessDataItem.PERMISSION_SPLITTER + arrayList);
        return arrayList;
    }

    public final void setAddressInfo(@NotNull EventId eventId, @NotNull AddressInfo addressInfo) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(addressInfo, "addressInfo");
        try {
            AlphaMeLogger.debugLog("Personal", "id " + eventId + " setAddressInfo " + addressInfo);
            String key = getKey(eventId);
            if (TextUtils.isEmpty(key)) {
                return;
            }
            PersonalPreferenceConfigs.INSTANCE.setAddressInfo(key, addressInfo);
        } catch (Exception unused) {
        }
    }

    public final void setCarBluetoothInfo(@NotNull EventId eventId, @NotNull BluetoothInfo bluetoothInfo) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(bluetoothInfo, "bluetoothInfo");
        try {
            AlphaMeLogger.debugLog("Personal", "id " + eventId + " setCarBluetoothInfo " + bluetoothInfo);
            if (TextUtils.isEmpty(getKey(eventId))) {
                return;
            }
            String strG = new n().g(bluetoothInfo);
            AlphaMeLogger.debugLog("Personal", "id " + eventId + " setCarBluetoothInfo result " + strG);
            PersonalPreferenceConfigs personalPreferenceConfigs = PersonalPreferenceConfigs.INSTANCE;
            Intrinsics.checkNotNull(strG);
            personalPreferenceConfigs.setCarBluetooth(strG);
        } catch (Exception unused) {
        }
    }

    public final void setCommutingMode(long mode) {
        PersonalPreferenceConfigs.INSTANCE.setCommutingMode(mode);
    }

    public final void setTimeInfo(@NotNull EventId eventId, @NotNull TimeInfo timeInfo) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(timeInfo, "timeInfo");
        try {
            AlphaMeLogger.debugLog("Personal", "id " + eventId + " setTimeInfo " + timeInfo);
            String key = getKey(eventId);
            if (TextUtils.isEmpty(key)) {
                return;
            }
            String strG = new n().g(timeInfo);
            AlphaMeLogger.debugLog("Personal", "id " + eventId + " setTimeInfo result " + strG);
            PersonalPreferenceConfigs personalPreferenceConfigs = PersonalPreferenceConfigs.INSTANCE;
            Intrinsics.checkNotNull(strG);
            personalPreferenceConfigs.setTimeInfo(eventId, key, strG, timeInfo);
        } catch (Exception unused) {
        }
    }

    public final void setWifiInfo(@NotNull EventId eventId, @NotNull WifiInfo wifiInfo) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(wifiInfo, "wifiInfo");
        try {
            AlphaMeLogger.debugLog("Personal", "id " + eventId + " setWifiInfo " + wifiInfo);
            String key = getKey(eventId);
            if (TextUtils.isEmpty(key)) {
                return;
            }
            String strG = new n().g(wifiInfo);
            AlphaMeLogger.debugLog("Personal", "id " + eventId + " setWifiInfo result " + strG);
            PersonalPreferenceConfigs.INSTANCE.setData(key, strG);
        } catch (Exception unused) {
        }
    }
}
