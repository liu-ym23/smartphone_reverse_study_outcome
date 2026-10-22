package com.stepos.alphame.persona;

import F1.n;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.persona.address.data.AddressInfo;
import com.stepos.alphame.persona.address.data.AddressInfoResponse;
import com.stepos.alphame.persona.carbluetooth.bean.BluetoothInfo;
import com.stepos.alphame.persona.carbluetooth.bean.BluetoothInfoResponse;
import com.stepos.alphame.persona.common.time.bean.TimeInfo;
import com.stepos.alphame.persona.common.time.bean.TimeInfoResponse;
import com.stepos.alphame.persona.data.PersonalResponseCode;
import com.stepos.alphame.persona.data.bean.CommutingModeResponse;
import com.stepos.alphame.persona.data.config.PersonalPreferenceConfigs;
import com.stepos.alphame.persona.data.repo.PersonalRepo;
import com.stepos.alphame.persona.domain.event.EventId;
import com.stepos.alphame.persona.privacy.PolicyManager;
import com.stepos.alphame.persona.wifi.bean.WifiInfo;
import com.stepos.alphame.persona.wifi.bean.WifiInfoResponse;
import com.stepos.alphame.utils.AlphaMeLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0014;<=>?@ABCDEFGHIJKLMNB\u0007¢\u0006\u0004\b:\u0010\u0013J'\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\nJ'\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u0018\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u001a\u0010\u0015J\u001f\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u001b\u0010\u0015J\u001f\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u001c\u0010\u0015J\u001f\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u001d\u0010\u0015J\u001f\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u001e\u0010\u0015J\u001f\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\u001f\u0010\u0015J\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010\u0015J\u001f\u0010(\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0017J\u0017\u0010*\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b,\u0010+J\u001f\u0010.\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010-\u001a\u00020)H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\f2\u0006\u0010-\u001a\u00020)H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006O"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine;", "Lcom/stepos/alphame/engine/EngineBase;", "Lcom/stepos/alphame/persona/IPersonalEngine;", "Lcom/stepos/alphame/persona/domain/event/EventId;", "eventId", "", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "", "type", "getAddressInfo", "(Lcom/stepos/alphame/persona/domain/event/EventId;Ljava/lang/String;I)Ljava/lang/String;", "data", "", "setAddressInfo", "(Lcom/stepos/alphame/persona/domain/event/EventId;Ljava/lang/String;Ljava/lang/String;)V", "getWifiInfo", "getTimeInfo", "(Ljava/lang/String;ILcom/stepos/alphame/persona/domain/event/EventId;)Ljava/lang/String;", "onStart", "()V", PersonalContract.FUN_GET_HOME_ADDRESS, "(Ljava/lang/String;I)Ljava/lang/String;", PersonalContract.FUN_SET_HOME_ADDRESS, "(Ljava/lang/String;Ljava/lang/String;)V", PersonalContract.FUN_GET_COMPANY_ADDRESS, PersonalContract.FUN_SET_COMPANY_ADDRESS, PersonalContract.FUN_GET_HOME_WIFI, PersonalContract.FUN_GET_COMPANY_WIFI, PersonalContract.FUN_GET_TIME_AWAY_FROM_HOME, PersonalContract.FUN_GET_OFF_DUTY_TIME, PersonalContract.FUN_GET_SLEEP_TIME, PersonalContract.FUN_GET_WAKEUP_TIME, PersonalContract.FUN_GET_COMMUTING_MODE, "(Ljava/lang/String;)Ljava/lang/String;", "", "mode", PersonalContract.FUN_SET_COMMUTING_MODE, "(Ljava/lang/String;J)V", PersonalContract.FUN_GET_CAR_BLUETOOTH, "bluetoothInfo", PersonalContract.FUN_SET_CAR_BLUETOOTH, "", PersonalContract.FUN_GET_AUTO_LEARNING_STATE, "(Ljava/lang/String;)Z", PersonalContract.FUN_GET_APPLICATION_AUTHORIZATION_STATUS, "status", PersonalContract.FUN_SET_APPLICATION_AUTHORIZATION_STATUS, "(Ljava/lang/String;Z)V", PersonalContract.FUN_SET_AUTO_LEARNING_STATUS, "(Z)V", PersonalContract.FUN_SEND_TIME_INFO_CHANGED_BROADCAST, "(I)V", "Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "repo", "Lcom/stepos/alphame/persona/data/repo/PersonalRepo;", "LF1/n;", "gson", "LF1/n;", "<init>", "Companion", "GetApplicationAuthorizationStatus", "GetAutoLearningState", "GetCarBluetooth", "GetCommutingMode", "GetCompanyAddress", "GetCompanyWifi", "GetHomeAddress", "GetHomeWifi", "GetOffDutyTime", "GetSleepTime", "GetTimeAwayFromHome", "GetWakeupTime", "SendTimeInfoChangedBroadcast", "SetApplicationAuthorizationStatus", "SetAutoLearningStatus", "SetCarBluetooth", "SetCommutingMode", "SetCompanyAddress", "SetHomeAddress", "app_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class PersonalEngine extends EngineBase implements IPersonalEngine {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<PersonalEngine> INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<PersonalEngine>() { // from class: com.stepos.alphame.persona.PersonalEngine$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PersonalEngine invoke() {
            return new PersonalEngine();
        }
    });

    @NotNull
    public static final String TAG = "PersonalEngine";

    @NotNull
    private final n gson = new n();
    private PersonalRepo repo;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$Companion;", "", "()V", "INSTANCE", "Lcom/stepos/alphame/persona/PersonalEngine;", "getINSTANCE", "()Lcom/stepos/alphame/persona/PersonalEngine;", "INSTANCE$delegate", "Lkotlin/Lazy;", "TAG", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PersonalEngine getINSTANCE() {
            return (PersonalEngine) PersonalEngine.INSTANCE$delegate.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$GetApplicationAuthorizationStatus;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetApplicationAuthorizationStatus extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetApplicationAuthorizationStatus(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_GET_APPLICATION_AUTHORIZATION_STATUS;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME};
            this.returnType = (byte) 2;
            this.annotation = new String[]{"获取应用授权获取个人信息状态", "@params packageName 应用名称"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$GetAutoLearningState;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetAutoLearningState extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAutoLearningState(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_GET_AUTO_LEARNING_STATE;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME};
            this.returnType = (byte) 2;
            this.annotation = new String[]{"获取自动学习的开关状态", "@return void"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$GetCarBluetooth;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetCarBluetooth extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCarBluetooth(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_GET_CAR_BLUETOOTH;
            this.argsType = new byte[]{6, 4};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "type"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取车载蓝牙", "@param type 0: 自动 1：手动", "@return 蓝牙名称：\"m2481 日常\", 蓝牙mac地址：\"90:F0:52:BC:4B:4D\" "};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$GetCommutingMode;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetCommutingMode extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCommutingMode(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_GET_COMMUTING_MODE;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取通勤方式", "@params packageName 应用名称", "@return Long"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$GetCompanyAddress;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetCompanyAddress extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCompanyAddress(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_GET_COMPANY_ADDRESS;
            this.argsType = new byte[]{6, 4};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "type"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取公司地址", "@param type 0: 自动 1：手动", "@return 地址：“广东省珠海市香洲区港湾大道27号靠近阶跃科技大楼”，区域：“香洲区”，经纬度：“22.372296,113.569253”"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$GetCompanyWifi;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetCompanyWifi extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCompanyWifi(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_GET_COMPANY_WIFI;
            this.argsType = new byte[]{6, 4};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "type"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取公司wifi", "@param type 0: 自动 1：手动", "@return wifi名称：“STEPOS-5G”，wifi mac地址：\"90:F0:52:BC:4B:4D\" "};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$GetHomeAddress;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetHomeAddress extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetHomeAddress(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_GET_HOME_ADDRESS;
            this.argsType = new byte[]{6, 4};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "type"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取家庭地址", "@param type 0: 自动 1：手动", "@return 地址：“广东省珠海市香洲区港湾大道27号靠近阶跃科技大楼”，区域：“香洲区”，经纬度：“22.372296,113.569253”"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$GetHomeWifi;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetHomeWifi extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetHomeWifi(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_GET_HOME_WIFI;
            this.argsType = new byte[]{6, 4};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "type"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取家庭wifi", "@param type 0: 自动 1：手动", "@return wifi名称：“STEPOS-5G”，wifi mac地址：\"90:F0:52:BC:4B:4D\" "};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$GetOffDutyTime;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetOffDutyTime extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetOffDutyTime(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_GET_OFF_DUTY_TIME;
            this.argsType = new byte[]{6, 4};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "type"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取下班时间", "@params packageName 应用名称", "@param type 0: 自动 1：手动", "@return String"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$GetSleepTime;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetSleepTime extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetSleepTime(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_GET_SLEEP_TIME;
            this.argsType = new byte[]{6, 4};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "type"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取入睡时间", "@params packageName 应用名称", "@param type 0: 自动 1：手动", "@return String"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$GetTimeAwayFromHome;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetTimeAwayFromHome extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetTimeAwayFromHome(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_GET_TIME_AWAY_FROM_HOME;
            this.argsType = new byte[]{6, 4};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "type"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取离家时间", "@params packageName 应用名称", "@param type 0: 自动 1：手动", "@return String"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$GetWakeupTime;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GetWakeupTime extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetWakeupTime(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_GET_WAKEUP_TIME;
            this.argsType = new byte[]{6, 4};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "type"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取起床时间", "@params packageName 应用名称", "@param type 0: 自动 1：手动", "@return String"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$SendTimeInfoChangedBroadcast;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SendTimeInfoChangedBroadcast extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendTimeInfoChangedBroadcast(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_SEND_TIME_INFO_CHANGED_BROADCAST;
            this.argsType = new byte[]{4};
            this.argsName = new String[]{"type"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"发送时间变化广播", " @param type 时间类型"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$SetApplicationAuthorizationStatus;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SetApplicationAuthorizationStatus extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetApplicationAuthorizationStatus(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_SET_APPLICATION_AUTHORIZATION_STATUS;
            this.argsType = new byte[]{6, 2};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "status"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"设置应用授权获取个人信息状态", "@params packageName 应用名称", " @param status 授权状态"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$SetAutoLearningStatus;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SetAutoLearningStatus extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetAutoLearningStatus(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_SET_AUTO_LEARNING_STATUS;
            this.argsType = new byte[]{2};
            this.argsName = new String[]{"status"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"设置自动学习的开关状态", " @param status 授权状态"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$SetCarBluetooth;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SetCarBluetooth extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetCarBluetooth(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_SET_CAR_BLUETOOTH;
            this.argsType = new byte[]{6, 6};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "bluetoothInfo"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"设置车载蓝牙", "@param 字符串数组 蓝牙名称：\"m2481 日常\", 蓝牙mac地址：\"90:F0:52:BC:4B:4D\"", "@return void"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$SetCommutingMode;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SetCommutingMode extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetCommutingMode(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_SET_COMMUTING_MODE;
            this.argsType = new byte[]{6, 5};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "type"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"设置通勤方式", "@params packageName 应用名称", "@params type 通勤方式", "@return Long"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$SetCompanyAddress;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SetCompanyAddress extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetCompanyAddress(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_SET_COMPANY_ADDRESS;
            this.argsType = new byte[]{6, 6};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "data"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"设置公司地址", "@param 地址：“广东省珠海市香洲区港湾大道27号靠近阶跃科技大楼”，区域：“香洲区”，经纬度：“22.372296,113.569253” ", "@return void"};
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/alphame/persona/PersonalEngine$SetHomeAddress;", "Lcom/stepos/alphame/engine/EngineFunc;", "owner", "Lcom/stepos/alphame/engine/EngineBase;", "(Lcom/stepos/alphame/engine/EngineBase;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SetHomeAddress extends EngineFunc {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetHomeAddress(@NotNull EngineBase owner) {
            super(owner);
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.name = PersonalContract.FUN_SET_HOME_ADDRESS;
            this.argsType = new byte[]{6, 6};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, "data"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"设置家庭地址", "@param 地址：“广东省珠海市香洲区港湾大道27号靠近阶跃科技大楼”，区域：“香洲区”，经纬度：“22.372296,113.569253” ", "@return void"};
        }
    }

    private final String getAddressInfo(EventId eventId, String packageName, int type) {
        AddressInfo autoAddress;
        if (!PersonalPreferenceConfigs.INSTANCE.isInWhitelist(packageName)) {
            AlphaMeLogger.debugLog(TAG, "name " + packageName + " is not in whitelist");
            String strG = this.gson.g(new AddressInfoResponse(PersonalResponseCode.NO_AUTHORIZATION.getCode(), new AddressInfo()));
            Intrinsics.checkNotNullExpressionValue(strG, "toJson(...)");
            return strG;
        }
        PersonalRepo personalRepo = null;
        if (type == 0) {
            PersonalRepo personalRepo2 = this.repo;
            if (personalRepo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                personalRepo = personalRepo2;
            }
            autoAddress = personalRepo.getAutoAddress(eventId);
        } else if (type != 1) {
            autoAddress = new AddressInfo();
        } else {
            PersonalRepo personalRepo3 = this.repo;
            if (personalRepo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                personalRepo = personalRepo3;
            }
            autoAddress = personalRepo.getAddressInfo(eventId);
        }
        String strG2 = this.gson.g(new AddressInfoResponse(PersonalResponseCode.SUCCESS.getCode(), autoAddress));
        Intrinsics.checkNotNullExpressionValue(strG2, "toJson(...)");
        return strG2;
    }

    private final String getTimeInfo(String packageName, int type, EventId eventId) {
        TimeInfo autoTimeInfo;
        if (!PersonalPreferenceConfigs.INSTANCE.isInWhitelist(packageName)) {
            AlphaMeLogger.debugLog(TAG, "name " + packageName + " is not in whitelist");
            String strG = this.gson.g(new TimeInfoResponse(PersonalResponseCode.NO_AUTHORIZATION.getCode(), new TimeInfo()));
            Intrinsics.checkNotNullExpressionValue(strG, "toJson(...)");
            return strG;
        }
        PersonalRepo personalRepo = null;
        if (type == 0) {
            PersonalRepo personalRepo2 = this.repo;
            if (personalRepo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                personalRepo = personalRepo2;
            }
            autoTimeInfo = personalRepo.getAutoTimeInfo(eventId);
        } else if (type != 1) {
            autoTimeInfo = new TimeInfo();
        } else {
            PersonalRepo personalRepo3 = this.repo;
            if (personalRepo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                personalRepo = personalRepo3;
            }
            autoTimeInfo = personalRepo.getTimeInfo(eventId);
        }
        String strG2 = this.gson.g(new TimeInfoResponse(PersonalResponseCode.SUCCESS.getCode(), autoTimeInfo));
        Intrinsics.checkNotNullExpressionValue(strG2, "toJson(...)");
        return strG2;
    }

    private final String getWifiInfo(EventId eventId, String packageName, int type) {
        WifiInfo autoWifi;
        if (!PersonalPreferenceConfigs.INSTANCE.isInWhitelist(packageName)) {
            AlphaMeLogger.debugLog(TAG, "name " + packageName + " is not in whitelist");
            String strG = this.gson.g(new WifiInfoResponse(PersonalResponseCode.NO_AUTHORIZATION.getCode(), new WifiInfo()));
            Intrinsics.checkNotNullExpressionValue(strG, "toJson(...)");
            return strG;
        }
        PersonalRepo personalRepo = null;
        if (type == 0) {
            PersonalRepo personalRepo2 = this.repo;
            if (personalRepo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                personalRepo = personalRepo2;
            }
            autoWifi = personalRepo.getAutoWifi(eventId);
        } else if (type != 1) {
            autoWifi = new WifiInfo();
        } else {
            PersonalRepo personalRepo3 = this.repo;
            if (personalRepo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                personalRepo = personalRepo3;
            }
            autoWifi = personalRepo.getWifiInfo(eventId);
        }
        String strG2 = this.gson.g(new WifiInfoResponse(PersonalResponseCode.SUCCESS.getCode(), autoWifi));
        Intrinsics.checkNotNullExpressionValue(strG2, "toJson(...)");
        return strG2;
    }

    private final void setAddressInfo(EventId eventId, String packageName, String data) {
        try {
            if (!PersonalPreferenceConfigs.INSTANCE.isInWhitelist(packageName)) {
                AlphaMeLogger.debugLog(TAG, "name " + packageName + " is not in whitelist");
                return;
            }
            Object objB = this.gson.b(AddressInfoResponse.class, data);
            Intrinsics.checkNotNull(objB, "null cannot be cast to non-null type com.stepos.alphame.persona.address.data.AddressInfoResponse");
            AddressInfoResponse addressInfoResponse = (AddressInfoResponse) objB;
            if (addressInfoResponse.getCode() == PersonalResponseCode.SUCCESS.getCode()) {
                PersonalRepo personalRepo = this.repo;
                if (personalRepo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("repo");
                    personalRepo = null;
                }
                personalRepo.setAddressInfo(eventId, addressInfoResponse.getAddressInfo());
            }
        } catch (Exception e4) {
            AlphaMeLogger.debugLog(TAG, "e " + e4);
        }
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    public boolean getApplicationAuthorizationStatus(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return ((Boolean) PersonalPreferenceConfigs.INSTANCE.getData(packageName, Boolean.TRUE)).booleanValue();
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    public boolean getAutoLearningState(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return PersonalPreferenceConfigs.INSTANCE.getAutoLearningState();
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    @NotNull
    public String getCarBluetooth(@NotNull String packageName, int type) {
        BluetoothInfo autoCarBluetooth;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (!PersonalPreferenceConfigs.INSTANCE.isInWhitelist(packageName)) {
            AlphaMeLogger.debugLog(TAG, "name " + packageName + " is not in whitelist");
            String strG = this.gson.g(new BluetoothInfoResponse(PersonalResponseCode.NO_AUTHORIZATION.getCode(), new BluetoothInfo()));
            Intrinsics.checkNotNullExpressionValue(strG, "toJson(...)");
            return strG;
        }
        PersonalRepo personalRepo = null;
        if (type == 0) {
            PersonalRepo personalRepo2 = this.repo;
            if (personalRepo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                personalRepo = personalRepo2;
            }
            autoCarBluetooth = personalRepo.getAutoCarBluetooth();
        } else if (type != 1) {
            autoCarBluetooth = new BluetoothInfo();
        } else {
            PersonalRepo personalRepo3 = this.repo;
            if (personalRepo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                personalRepo = personalRepo3;
            }
            autoCarBluetooth = personalRepo.getCarBluetoothInfo(EventId.CAR_BLUETOOTH);
        }
        String strG2 = this.gson.g(new BluetoothInfoResponse(PersonalResponseCode.SUCCESS.getCode(), autoCarBluetooth));
        Intrinsics.checkNotNullExpressionValue(strG2, "toJson(...)");
        return strG2;
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    @NotNull
    public String getCommutingMode(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (!PersonalPreferenceConfigs.INSTANCE.isInWhitelist(packageName)) {
            AlphaMeLogger.debugLog(TAG, "name " + packageName + " is not in whitelist");
            String strG = this.gson.g(new CommutingModeResponse(PersonalResponseCode.NO_AUTHORIZATION.getCode(), -1L));
            Intrinsics.checkNotNullExpressionValue(strG, "toJson(...)");
            return strG;
        }
        PersonalRepo personalRepo = this.repo;
        if (personalRepo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
            personalRepo = null;
        }
        String strG2 = this.gson.g(new CommutingModeResponse(PersonalResponseCode.SUCCESS.getCode(), personalRepo.getCommutingMode()));
        Intrinsics.checkNotNullExpressionValue(strG2, "toJson(...)");
        return strG2;
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    @NotProguard
    @NotNull
    public String getCompanyAddress(@NotNull String packageName, int type) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return getAddressInfo(EventId.COMPANY_ADDRESS, packageName, type);
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    @NotProguard
    @NotNull
    public String getCompanyWifi(@NotNull String packageName, int type) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return getWifiInfo(EventId.COMPANY_WIFI, packageName, type);
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    @NotProguard
    @NotNull
    public String getHomeAddress(@NotNull String packageName, int type) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return getAddressInfo(EventId.HOME_ADDRESS, packageName, type);
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    @NotProguard
    @NotNull
    public String getHomeWifi(@NotNull String packageName, int type) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return getWifiInfo(EventId.HOME_WIFI, packageName, type);
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    @NotProguard
    @NotNull
    public String getOffDutyTime(@NotNull String packageName, int type) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return getTimeInfo(packageName, type, EventId.OFF_DUTY_TIME);
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    @NotProguard
    @NotNull
    public String getSleepTime(@NotNull String packageName, int type) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return getTimeInfo(packageName, type, EventId.SLEEP_TIME);
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    @NotProguard
    @NotNull
    public String getTimeAwayFromHome(@NotNull String packageName, int type) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return getTimeInfo(packageName, type, EventId.TIME_AWAY_FROM_HOME);
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    @NotProguard
    @NotNull
    public String getWakeupTime(@NotNull String packageName, int type) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return getTimeInfo(packageName, type, EventId.WAKE_UP_TIME);
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        AlphaMeLogger.debugLog("Personal", "Engine onStart");
        super.onStart();
        PolicyManager instance = PolicyManager.INSTANCE.getINSTANCE();
        ApplicationImpl application = ApplicationImpl.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        instance.initPolicy(application);
        this.repo = PersonalRepo.INSTANCE.getINSTANCE();
        EngineBase.addFunc(new GetHomeAddress(this));
        EngineBase.addFunc(new SetHomeAddress(this));
        EngineBase.addFunc(new GetCompanyAddress(this));
        EngineBase.addFunc(new SetCompanyAddress(this));
        EngineBase.addFunc(new GetHomeWifi(this));
        EngineBase.addFunc(new GetCompanyWifi(this));
        EngineBase.addFunc(new GetTimeAwayFromHome(this));
        EngineBase.addFunc(new GetOffDutyTime(this));
        EngineBase.addFunc(new GetSleepTime(this));
        EngineBase.addFunc(new GetWakeupTime(this));
        EngineBase.addFunc(new GetCommutingMode(this));
        EngineBase.addFunc(new SetCommutingMode(this));
        EngineBase.addFunc(new GetCarBluetooth(this));
        EngineBase.addFunc(new SetCarBluetooth(this));
        EngineBase.addFunc(new GetAutoLearningState(this));
        EngineBase.addFunc(new GetApplicationAuthorizationStatus(this));
        EngineBase.addFunc(new SetApplicationAuthorizationStatus(this));
        EngineBase.addFunc(new SendTimeInfoChangedBroadcast(this));
        EngineBase.addFunc(new SetAutoLearningStatus(this));
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    @NotProguard
    public void sendTimeInfoChangedBroadcast(int type) {
        PersonalRepo personalRepo = this.repo;
        PersonalRepo personalRepo2 = null;
        if (personalRepo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
            personalRepo = null;
        }
        EventId eventId = personalRepo.getEventId(type);
        PersonalRepo personalRepo3 = this.repo;
        if (personalRepo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        } else {
            personalRepo2 = personalRepo3;
        }
        PersonalPreferenceConfigs.INSTANCE.sendTimeInfoChangedBroadcast(eventId, personalRepo2.getTimeInfo(eventId));
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    public void setApplicationAuthorizationStatus(@NotNull String packageName, boolean status) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        PersonalPreferenceConfigs.INSTANCE.setAuthorizationStatus(packageName, status);
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    public void setAutoLearningStatus(boolean status) {
        PersonalPreferenceConfigs.INSTANCE.setAutoLearningStatus(status);
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    public void setCarBluetooth(@NotNull String packageName, @NotNull String bluetoothInfo) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(bluetoothInfo, "bluetoothInfo");
        try {
            if (!PersonalPreferenceConfigs.INSTANCE.isInWhitelist(packageName)) {
                AlphaMeLogger.debugLog(TAG, "name " + packageName + " is not in whitelist");
                return;
            }
            AlphaMeLogger.debugLog(TAG, "setCarBluetooth size " + bluetoothInfo);
            Object objB = this.gson.b(BluetoothInfoResponse.class, bluetoothInfo);
            Intrinsics.checkNotNull(objB, "null cannot be cast to non-null type com.stepos.alphame.persona.carbluetooth.bean.BluetoothInfoResponse");
            BluetoothInfoResponse bluetoothInfoResponse = (BluetoothInfoResponse) objB;
            if (bluetoothInfoResponse.getCode() == PersonalResponseCode.SUCCESS.getCode()) {
                PersonalRepo personalRepo = this.repo;
                if (personalRepo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("repo");
                    personalRepo = null;
                }
                personalRepo.setCarBluetoothInfo(EventId.CAR_BLUETOOTH, bluetoothInfoResponse.getBluetoothInfo());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    public void setCommutingMode(@NotNull String packageName, long mode) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (!PersonalPreferenceConfigs.INSTANCE.isInWhitelist(packageName)) {
            AlphaMeLogger.debugLog(TAG, "name " + packageName + " is not in whitelist");
            return;
        }
        PersonalRepo personalRepo = this.repo;
        if (personalRepo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
            personalRepo = null;
        }
        personalRepo.setCommutingMode(mode);
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    public void setCompanyAddress(@NotNull String packageName, @NotNull String data) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(data, "data");
        setAddressInfo(EventId.COMPANY_ADDRESS, packageName, data);
    }

    @Override // com.stepos.alphame.persona.IPersonalEngine
    @NotProguard
    public void setHomeAddress(@NotNull String packageName, @NotNull String data) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(data, "data");
        setAddressInfo(EventId.HOME_ADDRESS, packageName, data);
    }
}
