package com.stepos.alphame;

import com.stepos.alphame.persona.PersonalContract;
import com.stepos.alphame.utils.LocalConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R,\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/alphame/EngineContract;", "", "()V", "AICY_Butler", "", "GAME_MODE", "NOTE_PAPER_PACKAGE_NAME", "SETTING_PACKAGE_NAME", "SYSTEM_UI_TOOL_PACKAGE_NAME", "VOICE_ASSISTANT_PACKAGE_NAME", "WEATHER", "authorizationAppList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAuthorizationAppList$annotations", "getAuthorizationAppList", "()Ljava/util/ArrayList;", "authorizationFunList", "", "getAuthorizationFunList$annotations", "getAuthorizationFunList", "()Ljava/util/List;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EngineContract {

    @NotNull
    public static final String GAME_MODE = "game_mode";

    @NotNull
    public static final EngineContract INSTANCE = new EngineContract();

    @NotNull
    public static final String VOICE_ASSISTANT_PACKAGE_NAME = "com.stepos.voiceassistant";

    @NotNull
    public static final String NOTE_PAPER_PACKAGE_NAME = "com.stepos.notepaper";

    @NotNull
    public static final String SETTING_PACKAGE_NAME = "com.android.settings";

    @NotNull
    public static final String SYSTEM_UI_TOOL_PACKAGE_NAME = "com.stepos.systemuitools";

    @NotNull
    public static final String AICY_Butler = "com.stepos.aicymanager";

    @NotNull
    public static final String WEATHER = "com.stepos.weather";

    @NotNull
    private static final ArrayList<String> authorizationAppList = CollectionsKt.arrayListOf(VOICE_ASSISTANT_PACKAGE_NAME, NOTE_PAPER_PACKAGE_NAME, SETTING_PACKAGE_NAME, SYSTEM_UI_TOOL_PACKAGE_NAME, AICY_Butler, WEATHER);

    @NotNull
    private static final List<String> authorizationFunList = CollectionsKt.arrayListOf(PersonalContract.FUN_GET_HOME_ADDRESS, PersonalContract.FUN_SET_HOME_ADDRESS, PersonalContract.FUN_GET_HOME_WIFI, PersonalContract.FUN_GET_COMPANY_ADDRESS, PersonalContract.FUN_SET_COMPANY_ADDRESS, PersonalContract.FUN_GET_COMPANY_WIFI, PersonalContract.FUN_GET_TIME_AWAY_FROM_HOME, PersonalContract.FUN_GET_OFF_DUTY_TIME, PersonalContract.FUN_GET_SLEEP_TIME, PersonalContract.FUN_GET_WAKEUP_TIME, PersonalContract.FUN_GET_COMMUTING_MODE, PersonalContract.FUN_GET_CAR_BLUETOOTH, PersonalContract.FUN_SET_CAR_BLUETOOTH, LocalConsts.FUNC_CHOOSE_HOME, LocalConsts.FUNC_GET_CHOSEN_HOME, LocalConsts.FUNC_CHOOSE_COMPANY, LocalConsts.FUNC_GET_CHOSEN_COMPANY, LocalConsts.FUNC_GET_ALL_WIFI, LocalConsts.FUNC_GET_HOME_WIFI_LIST, LocalConsts.FUNC_GET_COMPANY_WIFI_LIST, LocalConsts.FUNC_MAKE_LOCATION, LocalConsts.FUNC_GET_LOCATION_INFO_BY_ID, LocalConsts.FUNC_GET_VEHICLE_BLUETOOTH_INFO, LocalConsts.FUNC_GET_VEHICLE_BLUETOOTHES, LocalConsts.FUNC_GET_VEHICLES, LocalConsts.FUNC_CHOOSE_VEHICLE_BLUETOOTH);

    private EngineContract() {
    }

    @NotNull
    public static final ArrayList<String> getAuthorizationAppList() {
        return authorizationAppList;
    }

    @JvmStatic
    public static /* synthetic */ void getAuthorizationAppList$annotations() {
    }

    @NotNull
    public static final List<String> getAuthorizationFunList() {
        return authorizationFunList;
    }

    @JvmStatic
    public static /* synthetic */ void getAuthorizationFunList$annotations() {
    }
}
