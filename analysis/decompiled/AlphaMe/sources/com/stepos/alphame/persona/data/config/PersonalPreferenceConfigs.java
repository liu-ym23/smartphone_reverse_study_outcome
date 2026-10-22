package com.stepos.alphame.persona.data.config;

import F1.n;
import android.content.Intent;
import android.util.Log;
import b3.InterfaceC0379h;
import ch.qos.logback.core.joran.action.Action;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.EngineContract;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import com.stepos.alphame.common.data.DataStoreManager;
import com.stepos.alphame.common.data.DataStorePreferences;
import com.stepos.alphame.persona.PersonalContract;
import com.stepos.alphame.persona.address.data.AddressInfo;
import com.stepos.alphame.persona.common.time.bean.TimeInfo;
import com.stepos.alphame.persona.common.time.bean.TimeInfoResponse;
import com.stepos.alphame.persona.data.PersonalResponseCode;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\be\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\nJ\u001d\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\bJ\u0015\u0010\u001e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u000eJ\u001d\u0010!\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0002¢\u0006\u0004\b$\u0010\u0015J-\u0010*\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J%\u0010.\u001a\u00028\u0000\"\u0004\b\u0000\u0010,2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010-\u001a\u00028\u0000H\u0016¢\u0006\u0004\b.\u0010/J%\u00101\u001a\u00020\u0006\"\u0004\b\u0000\u0010,2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u00100\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00102J&\u00103\u001a\u00020\u0006\"\u0004\b\u0000\u0010,2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u00100\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b3\u00104J+\u00106\u001a\b\u0012\u0004\u0012\u00028\u000005\"\u0004\b\u0000\u0010,2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010-\u001a\u00028\u0000H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\b8\u0010\u0010J\u001d\u00109\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u0006¢\u0006\u0004\b;\u0010\u0010R\u0017\u0010<\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u0010=R'\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u00020Aj\b\u0012\u0004\u0012\u00020\u0002`B8\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010=R\u0014\u0010H\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u0010=R\u0014\u0010I\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bI\u0010=R\u0014\u0010J\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bJ\u0010=R\u0014\u0010K\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bK\u0010=R\u0014\u0010L\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bL\u0010=R\u0014\u0010M\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u0010=R\u0014\u0010N\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bN\u0010=R\u0014\u0010O\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u0010=R\u0014\u0010P\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bP\u0010=R\u0014\u0010Q\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bQ\u0010=R\u0014\u0010R\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bR\u0010=R\u0014\u0010S\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bS\u0010=R\u0014\u0010T\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bT\u0010=R\u0014\u0010U\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bU\u0010=R\u0014\u0010V\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bV\u0010=R\u0014\u0010W\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bW\u0010=R\u0014\u0010X\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bX\u0010=R\u0014\u0010Y\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bY\u0010=R\u0014\u0010Z\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bZ\u0010=R\u0014\u0010[\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b[\u0010=R\u0014\u0010\\\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\\\u0010=R\u0014\u0010]\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b]\u0010=R\u0014\u0010^\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b^\u0010=R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010d¨\u0006f"}, d2 = {"Lcom/stepos/alphame/persona/data/config/PersonalPreferenceConfigs;", "Lcom/stepos/alphame/persona/data/config/IConfigRepository;", "", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "", "status", "", "sendAuthorizationStatusChangedBroadcast", "(Ljava/lang/String;Z)V", "sendAutoLearningStatusChangedBroadcast", "(Z)V", "", "mode", "sendCommutingModeChangedBroadcast", "(J)V", "sendAddressInfoChangedBroadcast", "()V", "sendCarBluetoothChangedBroadcast", "setPersonalAuthorizationFalse", Action.KEY_ATTRIBUTE, "addToWhitelist", "(Ljava/lang/String;)V", "removeFromWhitelist", "isInWhitelist", "(Ljava/lang/String;)Z", PersonalContract.FUN_GET_AUTO_LEARNING_STATE, "()Z", PersonalContract.FUN_SET_AUTO_LEARNING_STATUS, "isChecked", "setAuthorizationStatus", PersonalContract.FUN_SET_COMMUTING_MODE, "Lcom/stepos/alphame/persona/address/data/AddressInfo;", "addressInfo", "setAddressInfo", "(Ljava/lang/String;Lcom/stepos/alphame/persona/address/data/AddressInfo;)V", "carBluetooth", PersonalContract.FUN_SET_CAR_BLUETOOTH, "Lcom/stepos/alphame/persona/domain/event/EventId;", "eventId", "result", "Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;", "timeInfo", "setTimeInfo", "(Lcom/stepos/alphame/persona/domain/event/EventId;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;)V", "Value", "defaultValue", "getData", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "value", "setData", "(Ljava/lang/String;Ljava/lang/Object;)V", "saveData", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lb3/h;", "readData", "(Ljava/lang/String;Ljava/lang/Object;)Lb3/h;", "clearData", PersonalContract.FUN_SEND_TIME_INFO_CHANGED_BROADCAST, "(Lcom/stepos/alphame/persona/domain/event/EventId;Lcom/stepos/alphame/persona/common/time/bean/TimeInfo;)V", "clearDataWhenUserRevocation", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "KEY_IS_AUTO_LEARNING", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "keyList", "Ljava/util/ArrayList;", "getKeyList", "()Ljava/util/ArrayList;", "KEY_HOME_ADDRESS", "KEY_COMPANY_ADDRESS", "KEY_HOME_WIFI", "KEY_COMPANY_WIFI", "KEY_TIME_AWAY_FROM_HOME", "KEY_OFF_DUTY_TIME", "KEY_SLEEP_TIME", "KEY_WAKE_UP_TIME", "KEY_COMMUTING_MODE", "KEY_CAR_BLUETOOTH", "EXTRA_TIME_INFO", "EXTRA_TIME_INFO_TYPE", "PERMISSION_AUTHORIZATION_STATUS_CHANGED", "ACTION_AUTHORIZATION_STATUS_CHANGED", "KEY_AUTHORIZATION_STATUS", "ACTION_AUTO_LEARNING_STATUS_CHANGED", "KEY_AUTO_LEARNING_STATUS", "ACTION_COMMUTING_MODE_CHANGED", "KEY_COMMUTING_MODE_VALUE", "ACTION_CAR_BLUETOOTH_CHANGED", "ACTION_TIME_INFO_CHANGED", "KEY_IS_CTA_AGREE", "KEY_IS_CTA_RE_GRANT", "ACTION_ROUTE_ADDRESS_SETTING_CHANGED", "Lcom/stepos/alphame/common/data/DataStorePreferences;", "dataStore", "Lcom/stepos/alphame/common/data/DataStorePreferences;", "", "authorizationWhiteList", "Ljava/util/Set;", "<init>", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class PersonalPreferenceConfigs implements IConfigRepository {

    @NotNull
    public static final String ACTION_AUTHORIZATION_STATUS_CHANGED = "com.stepos.alphame.action_authorization_changed";

    @NotNull
    public static final String ACTION_AUTO_LEARNING_STATUS_CHANGED = "com.stepos.alphame.action_auto_learning_changed";

    @NotNull
    public static final String ACTION_CAR_BLUETOOTH_CHANGED = "com.stepos.alphame.action_car_bluetooth_changed";

    @NotNull
    public static final String ACTION_COMMUTING_MODE_CHANGED = "com.stepos.alphame.action_commuting_mode_changed";

    @NotNull
    public static final String ACTION_ROUTE_ADDRESS_SETTING_CHANGED = "com.stepos.alphame.action_ROUTE_ADDRESS_SETTING_CHANGED";

    @NotNull
    public static final String ACTION_TIME_INFO_CHANGED = "com.stepos.alphame.action_time_info_changed";

    @NotNull
    public static final String EXTRA_TIME_INFO = "time_info";

    @NotNull
    public static final String EXTRA_TIME_INFO_TYPE = "time_info_type";

    @NotNull
    public static final PersonalPreferenceConfigs INSTANCE;

    @NotNull
    public static final String KEY_AUTHORIZATION_STATUS = "authorization_status";

    @NotNull
    public static final String KEY_AUTO_LEARNING_STATUS = "auto_learning_status";

    @NotNull
    public static final String KEY_CAR_BLUETOOTH = "CAR_BLUETOOTH";

    @NotNull
    public static final String KEY_COMMUTING_MODE = "COMMUTING_MODE";

    @NotNull
    public static final String KEY_COMMUTING_MODE_VALUE = "commuting_mode_value";

    @NotNull
    public static final String KEY_COMPANY_ADDRESS = "COMPANY_ADDRESS";

    @NotNull
    public static final String KEY_COMPANY_WIFI = "COMPANY_WIFI";

    @NotNull
    public static final String KEY_HOME_ADDRESS = "HOME_ADDRESS";

    @NotNull
    public static final String KEY_HOME_WIFI = "HOME_WIFI";

    @NotNull
    public static final String KEY_IS_AUTO_LEARNING = "IS_AUTO_LEARNING";

    @NotNull
    public static final String KEY_IS_CTA_AGREE = "is_cta_agree";

    @NotNull
    public static final String KEY_IS_CTA_RE_GRANT = "is_cta_re_grant";

    @NotNull
    public static final String KEY_OFF_DUTY_TIME = "OFF_DUTY_TIME";

    @NotNull
    public static final String KEY_SLEEP_TIME = "SLEEP_TIME";

    @NotNull
    public static final String KEY_TIME_AWAY_FROM_HOME = "TIME_AWAY_FROM_HOME";

    @NotNull
    public static final String KEY_WAKE_UP_TIME = "WAKE_UP_TIME";

    @NotNull
    public static final String PERMISSION_AUTHORIZATION_STATUS_CHANGED = "com.stepos.alphame.authorization_changed_permission";

    @NotNull
    private static final String TAG;

    @NotNull
    private static final Set<String> authorizationWhiteList;

    @NotNull
    private static final DataStorePreferences dataStore;

    @NotNull
    private static final ArrayList<String> keyList;

    static {
        PersonalPreferenceConfigs personalPreferenceConfigs = new PersonalPreferenceConfigs();
        INSTANCE = personalPreferenceConfigs;
        String name = personalPreferenceConfigs.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        TAG = name;
        ArrayList<String> arrayListArrayListOf = CollectionsKt.arrayListOf(EngineContract.VOICE_ASSISTANT_PACKAGE_NAME, EngineContract.NOTE_PAPER_PACKAGE_NAME, EngineContract.SETTING_PACKAGE_NAME, EngineContract.SYSTEM_UI_TOOL_PACKAGE_NAME, EngineContract.AICY_Butler, EngineContract.WEATHER);
        keyList = arrayListArrayListOf;
        dataStore = DataStoreManager.INSTANCE.getDataStore("personalPreference");
        authorizationWhiteList = new LinkedHashSet();
        Iterator<String> it = arrayListArrayListOf.iterator();
        while (it.hasNext()) {
            String next = it.next();
            PersonalPreferenceConfigs personalPreferenceConfigs2 = INSTANCE;
            Intrinsics.checkNotNull(next);
            if (((Boolean) personalPreferenceConfigs2.getData(next, Boolean.TRUE)).booleanValue()) {
                authorizationWhiteList.add(next);
            }
        }
    }

    private PersonalPreferenceConfigs() {
    }

    private final void sendAddressInfoChangedBroadcast() {
        Intent intent = new Intent(ACTION_ROUTE_ADDRESS_SETTING_CHANGED);
        intent.addFlags(32);
        ApplicationImpl.getApplication().sendBroadcast(intent);
    }

    private final void sendAuthorizationStatusChangedBroadcast(String packageName, boolean status) {
        Intent intent = new Intent(ACTION_AUTHORIZATION_STATUS_CHANGED);
        intent.setPackage(packageName);
        intent.addFlags(32);
        intent.putExtra(KEY_AUTHORIZATION_STATUS, status);
        ApplicationImpl.getApplication().sendBroadcast(intent);
    }

    private final void sendAutoLearningStatusChangedBroadcast(boolean status) {
        Intent intent = new Intent(ACTION_AUTO_LEARNING_STATUS_CHANGED);
        intent.addFlags(32);
        intent.putExtra(KEY_AUTO_LEARNING_STATUS, status);
        ApplicationImpl.getApplication().sendBroadcast(intent);
    }

    private final void sendCarBluetoothChangedBroadcast() {
        Intent intent = new Intent(ACTION_CAR_BLUETOOTH_CHANGED);
        intent.addFlags(32);
        ApplicationImpl.getApplication().sendBroadcast(intent);
    }

    private final void sendCommutingModeChangedBroadcast(long mode) {
        Intent intent = new Intent(ACTION_COMMUTING_MODE_CHANGED);
        intent.addFlags(32);
        intent.putExtra(KEY_COMMUTING_MODE_VALUE, mode);
        ApplicationImpl.getApplication().sendBroadcast(intent);
    }

    private final void setPersonalAuthorizationFalse() {
        Iterator<String> it = keyList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            Intrinsics.checkNotNull(next);
            setAuthorizationStatus(next, false);
        }
    }

    public final void addToWhitelist(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        authorizationWhiteList.add(key);
    }

    @Override // com.stepos.alphame.persona.data.config.IConfigRepository
    public void clearData() {
        dataStore.clear();
    }

    public final void clearDataWhenUserRevocation() {
        clearData();
        setPersonalAuthorizationFalse();
        setAutoLearningStatus(false);
    }

    public final boolean getAutoLearningState() {
        boolean zBooleanValue = ((Boolean) getData(KEY_IS_AUTO_LEARNING, Boolean.TRUE)).booleanValue();
        AlphaMeLogger.debugLog(TAG, "getAutoLearningState " + zBooleanValue);
        return zBooleanValue;
    }

    @Override // com.stepos.alphame.persona.data.config.IConfigRepository
    public <Value> Value getData(@NotNull String key, Value defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        AlphaMeLogger.debugLog(TAG, "getData2" + Log.getStackTraceString(new Throwable()));
        return (Value) dataStore.getData(key, defaultValue);
    }

    @NotNull
    public final ArrayList<String> getKeyList() {
        return keyList;
    }

    @NotNull
    public final String getTAG() {
        return TAG;
    }

    public final boolean isInWhitelist(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return authorizationWhiteList.contains(key);
    }

    @Override // com.stepos.alphame.persona.data.config.IConfigRepository
    @NotNull
    public <Value> InterfaceC0379h readData(@NotNull String key, Value defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return dataStore.readFlowData(key, defaultValue);
    }

    public final void removeFromWhitelist(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        authorizationWhiteList.remove(key);
    }

    @Override // com.stepos.alphame.persona.data.config.IConfigRepository
    @Nullable
    public <Value> Object saveData(@NotNull String str, Value value, @NotNull Continuation<? super Unit> continuation) {
        AlphaMeLogger.debugLog(TAG, "saveData2" + Log.getStackTraceString(new Throwable()));
        dataStore.putData(str, value);
        return Unit.INSTANCE;
    }

    public final void sendTimeInfoChangedBroadcast(@NotNull EventId eventId, @NotNull TimeInfo timeInfo) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(timeInfo, "timeInfo");
        Intent intent = new Intent(ACTION_TIME_INFO_CHANGED);
        intent.addFlags(32);
        intent.putExtra(EXTRA_TIME_INFO_TYPE, eventId.getId());
        String strG = new n().g(new TimeInfoResponse(PersonalResponseCode.SUCCESS.getCode(), timeInfo));
        AlphaMeLogger.debugLog(TAG, "send timeInfo changed broadcast, type " + eventId.getId() + " timeInfo " + strG);
        intent.putExtra(EXTRA_TIME_INFO, strG);
        ApplicationImpl.getApplication().sendBroadcast(intent);
    }

    public final void setAddressInfo(@NotNull String key, @NotNull AddressInfo addressInfo) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(addressInfo, "addressInfo");
        setData(key, new n().g(addressInfo));
        sendAddressInfoChangedBroadcast();
    }

    public final void setAuthorizationStatus(@NotNull String key, boolean isChecked) {
        Intrinsics.checkNotNullParameter(key, "key");
        setData(key, Boolean.valueOf(isChecked));
        sendAuthorizationStatusChangedBroadcast(key, isChecked);
        if (isChecked) {
            addToWhitelist(key);
        } else {
            removeFromWhitelist(key);
        }
        AlphaMeLogger.debugLog(TAG, "white list " + authorizationWhiteList);
    }

    public final void setAutoLearningStatus(boolean status) {
        setData(KEY_IS_AUTO_LEARNING, Boolean.valueOf(status));
        sendAutoLearningStatusChangedBroadcast(status);
    }

    public final void setCarBluetooth(@NotNull String carBluetooth) {
        Intrinsics.checkNotNullParameter(carBluetooth, "carBluetooth");
        setData(KEY_CAR_BLUETOOTH, carBluetooth);
        sendCarBluetoothChangedBroadcast();
    }

    public final void setCommutingMode(long mode) {
        setData(KEY_COMMUTING_MODE, Long.valueOf(mode));
        sendCommutingModeChangedBroadcast(mode);
        AlphaMeLogger.debugLog(TAG, "send broadcast with commuting mode " + mode);
    }

    @Override // com.stepos.alphame.persona.data.config.IConfigRepository
    public <Value> void setData(@NotNull String key, Value value) {
        Intrinsics.checkNotNullParameter(key, "key");
        AlphaMeLogger.debugLog(TAG, "setData2" + Log.getStackTraceString(new Throwable()));
        dataStore.putData(key, value);
    }

    public final void setTimeInfo(@NotNull EventId eventId, @NotNull String key, @NotNull String result, @NotNull TimeInfo timeInfo) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(timeInfo, "timeInfo");
        setData(key, result);
        sendTimeInfoChangedBroadcast(eventId, timeInfo);
    }
}
