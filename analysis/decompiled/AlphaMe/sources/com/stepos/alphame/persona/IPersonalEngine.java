package com.stepos.alphame.persona;

import com.stepos.alphame.appinfo.AppInfoDbHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H&J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H&J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H&J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H&¨\u0006 "}, d2 = {"Lcom/stepos/alphame/persona/IPersonalEngine;", "", PersonalContract.FUN_GET_APPLICATION_AUTHORIZATION_STATUS, "", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "", PersonalContract.FUN_GET_AUTO_LEARNING_STATE, PersonalContract.FUN_GET_CAR_BLUETOOTH, "type", "", PersonalContract.FUN_GET_COMMUTING_MODE, PersonalContract.FUN_GET_COMPANY_ADDRESS, PersonalContract.FUN_GET_COMPANY_WIFI, PersonalContract.FUN_GET_HOME_ADDRESS, PersonalContract.FUN_GET_HOME_WIFI, PersonalContract.FUN_GET_OFF_DUTY_TIME, PersonalContract.FUN_GET_SLEEP_TIME, PersonalContract.FUN_GET_TIME_AWAY_FROM_HOME, PersonalContract.FUN_GET_WAKEUP_TIME, PersonalContract.FUN_SEND_TIME_INFO_CHANGED_BROADCAST, "", PersonalContract.FUN_SET_APPLICATION_AUTHORIZATION_STATUS, "status", PersonalContract.FUN_SET_AUTO_LEARNING_STATUS, PersonalContract.FUN_SET_CAR_BLUETOOTH, "bluetoothInfo", PersonalContract.FUN_SET_COMMUTING_MODE, "mode", "", PersonalContract.FUN_SET_COMPANY_ADDRESS, "data", PersonalContract.FUN_SET_HOME_ADDRESS, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface IPersonalEngine {
    boolean getApplicationAuthorizationStatus(@NotNull String packageName);

    boolean getAutoLearningState(@NotNull String packageName);

    @NotNull
    String getCarBluetooth(@NotNull String packageName, int type);

    @NotNull
    String getCommutingMode(@NotNull String packageName);

    @NotNull
    String getCompanyAddress(@NotNull String packageName, int type);

    @NotNull
    String getCompanyWifi(@NotNull String packageName, int type);

    @NotNull
    String getHomeAddress(@NotNull String packageName, int type);

    @NotNull
    String getHomeWifi(@NotNull String packageName, int type);

    @NotNull
    String getOffDutyTime(@NotNull String packageName, int type);

    @NotNull
    String getSleepTime(@NotNull String packageName, int type);

    @NotNull
    String getTimeAwayFromHome(@NotNull String packageName, int type);

    @NotNull
    String getWakeupTime(@NotNull String packageName, int type);

    void sendTimeInfoChangedBroadcast(int type);

    void setApplicationAuthorizationStatus(@NotNull String packageName, boolean status);

    void setAutoLearningStatus(boolean status);

    void setCarBluetooth(@NotNull String packageName, @NotNull String bluetoothInfo);

    void setCommutingMode(@NotNull String packageName, long mode);

    void setCompanyAddress(@NotNull String packageName, @NotNull String data);

    void setHomeAddress(@NotNull String packageName, @NotNull String data);
}
