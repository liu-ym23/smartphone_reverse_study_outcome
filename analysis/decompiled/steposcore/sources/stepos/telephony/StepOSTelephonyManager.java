package stepos.telephony;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.CellIdentity;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.UiccCardInfo;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.telephony.OperatorInfo;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;
import stepos.telephony.IStepOSAsyncCallback;
import stepos.telephony.ITelephonyExt;

/* loaded from: classes.dex */
public class StepOSTelephonyManager {
    private static final boolean DEBUG = true;
    public static final int ERR_INTERNAL = 3;
    public static final int ERR_INVALID_REQUEST = 2;
    public static final int ERR_OK = 0;
    public static final int ERR_REMOTE_DEAD = 1;
    public static final int SLOT_ID_1 = 0;
    public static final int SLOT_ID_2 = 1;
    public static final int SLOT_ID_DEFAULT = 0;
    private static final String TAG = "StepOSTelephonyManager";
    public static final int UNDEFINED_SLOT_ID = -1;

    public interface AsyncCallback {
        void onError(int i, String str);

        void onResult(Bundle bundle);
    }

    public enum CardState {
        Unknown,
        Off,
        Disable,
        On
    }

    private static ITelephonyExt getITelephonyExt() {
        return ITelephonyExt.Stub.asInterface(ServiceManager.getService("phone_ext"));
    }

    public static String getScAddress(Context context, int slotId) {
        logd("getScAddress slotId = " + slotId);
        try {
            return getITelephonyExt().getScAddress(slotId);
        } catch (RemoteException ex1) {
            ex1.printStackTrace();
            return null;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return null;
        }
    }

    public static void setScAddress(Context context, String address, int slotId) {
        logd("setScAddress address = " + address + ", slotId = " + slotId);
        try {
            getITelephonyExt().setScAddress(address, slotId);
        } catch (RemoteException ex1) {
            ex1.printStackTrace();
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
        }
    }

    public static boolean getIccLockEnabledBySlotId(int slotId) {
        logd("getIccLockEnabledBySlotId slotId = " + slotId);
        try {
            return getITelephonyExt().getIccLockEnabledBySlotId(slotId);
        } catch (RemoteException ex1) {
            ex1.printStackTrace();
            return false;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return false;
        }
    }

    public static boolean setIccLockEnabledBySlotId(boolean enabled, String password, int slotId) {
        logd("setIccLockEnabledBySlotId enabled = " + enabled + ", slotId = " + slotId);
        try {
            return getITelephonyExt().setIccLockEnabledBySlotId(enabled, password, slotId);
        } catch (RemoteException ex1) {
            ex1.printStackTrace();
            return false;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return false;
        }
    }

    public static boolean changeIccLockPasswordBySlotId(String oldPassword, String newPassword, int slotId) {
        logd("changeIccLockPasswordBySlotId slotId = " + slotId);
        try {
            return getITelephonyExt().changeIccLockPasswordBySlotId(oldPassword, newPassword, slotId);
        } catch (RemoteException ex1) {
            ex1.printStackTrace();
            return false;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return false;
        }
    }

    public static boolean setVoiceMailNumber(String num, int slotId) {
        logd("setVoiceMailNumber slotId = " + slotId);
        int simState = TelephonyManager.getDefault().getSimState(slotId);
        if (simState != 5) {
            return false;
        }
        try {
            return getITelephonyExt().setVoiceMailNumber(num, slotId);
        } catch (RemoteException ex1) {
            ex1.printStackTrace();
            return false;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return false;
        }
    }

    public static CardState getCardState(Context context, int subId) {
        CardState cardState;
        int slotId = SubscriptionManager.getSlotIndex(subId);
        CardState cardState2 = CardState.Unknown;
        boolean slotState = TelephonyManager.getDefault().hasIccCard(slotId);
        if (slotState) {
            int simState = TelephonyManager.getDefault().getSimState(slotId);
            if (simState == 5) {
                cardState = CardState.On;
            } else {
                cardState = CardState.Disable;
            }
        } else {
            cardState = CardState.Off;
        }
        logd("getCardState cardState = " + cardState.name());
        return cardState;
    }

    public static String getCardName(Context context, int subId) {
        String cardName = null;
        SubscriptionInfo subInfo = SubscriptionManager.from(context).getActiveSubscriptionInfo(subId);
        if (subInfo != null) {
            cardName = subInfo.getDisplayName().toString();
        }
        logd("getCardName subId = " + subId + ", cardName = " + cardName);
        return cardName;
    }

    public static String getLocalizedCarrierName(Context context, int subId, CharSequence fallbackName) {
        String fallback = fallbackName == null ? "" : fallbackName.toString();
        if (context == null || !SubscriptionManager.isValidSubscriptionId(subId)) {
            return fallback;
        }
        try {
            SubscriptionInfo subInfo = getSubscriptionInfo(context, subId);
            if (subInfo != null) {
                CharSequence displayName = subInfo.getDisplayName();
                if (!TextUtils.isEmpty(displayName)) {
                    fallback = displayName.toString();
                }
                if (subInfo.getDisplayNameSource() == 2) {
                    return fallback;
                }
                CharSequence carrierName = subInfo.getCarrierName();
                logd("getLocalizedCarrierName, carrierName = " + ((Object) carrierName));
                if (!TextUtils.isEmpty(carrierName)) {
                    fallback = carrierName.toString();
                }
            }
            TelephonyManager telephonyManager = TelephonyManager.from(context).createForSubscriptionId(subId);
            String numeric = telephonyManager.getSimOperatorNumeric();
            if (TextUtils.isEmpty(numeric)) {
                numeric = getOperatorNumericFromIccId(subInfo);
                logd("getLocalizedCarrierName, numeric from iccId is: " + numeric);
            }
            Locale locale = Locale.getDefault();
            String language = locale.getLanguage() + "_r" + locale.getCountry();
            String localizedName = null;
            if (!TextUtils.isEmpty(numeric)) {
                localizedName = getOperatorAlphaLong(numeric, language);
            }
            logd("getLocalizedCarrierName, subId = " + subId + ", numeric = " + numeric + ", language = " + language + ", localizedName = " + localizedName);
            return TextUtils.isEmpty(localizedName) ? fallback : localizedName;
        } catch (Exception e) {
            logd("getLocalizedCarrierName failed subId = " + subId + ", e = " + e);
            return fallback;
        }
    }

    private static String getOperatorNumericFromIccId(SubscriptionInfo subInfo) {
        if (subInfo == null) {
            return null;
        }
        String iccId = subInfo.getIccId();
        logd("getOperatorNumericFromIccId, iccId getIccId = " + iccId);
        if (TextUtils.isEmpty(iccId)) {
            iccId = subInfo.getCardString();
            logd("getOperatorNumericFromIccId, iccId getCardString = " + iccId);
        }
        if (TextUtils.isEmpty(iccId) || !iccId.startsWith("8986") || iccId.length() < 6) {
            return null;
        }
        return "460" + iccId.substring(4, 6);
    }

    private static SubscriptionInfo getSubscriptionInfo(Context context, int subId) {
        SubscriptionManager sm = SubscriptionManager.from(context);
        SubscriptionInfo subInfo = sm.getActiveSubscriptionInfo(subId);
        if (subInfo != null && subInfo.isActive()) {
            logd("getSubscriptionInfo from active, subId = " + subId);
            return subInfo;
        }
        SubscriptionInfo availableSubInfo = findSubscriptionInfoFromAvailableList(sm, subId);
        if (availableSubInfo != null) {
            logd("getSubscriptionInfo from available list, subId = " + subId);
            return availableSubInfo;
        }
        int slotId = SubscriptionManager.getSlotIndex(subId);
        TelephonyManager tm = TelephonyManager.from(context);
        if (SubscriptionManager.isValidSlotIndex(slotId) && tm.hasIccCard(slotId)) {
            String iccId = getIccIdForSlot(tm, slotId);
            SubscriptionInfo matchedSubInfo = findSubscriptionInfoByIccId(sm, iccId);
            if (matchedSubInfo != null) {
                logd("getSubscriptionInfo from iccId match, subId = " + subId + ", slotId = " + slotId);
                return matchedSubInfo;
            }
        }
        logd("getSubscriptionInfo fallback to active/inactive subInfo, subId = " + subId + ", subInfo = " + subInfo);
        return subInfo;
    }

    private static SubscriptionInfo findSubscriptionInfoFromAvailableList(SubscriptionManager sm, int subId) {
        List<SubscriptionInfo> subInfos = sm.getAvailableSubscriptionInfoList();
        if (subInfos == null) {
            return null;
        }
        for (SubscriptionInfo info : subInfos) {
            if (info.getSubscriptionId() == subId) {
                return info;
            }
        }
        return null;
    }

    private static SubscriptionInfo findSubscriptionInfoByIccId(SubscriptionManager sm, String iccId) {
        List<SubscriptionInfo> subInfos;
        if (TextUtils.isEmpty(iccId) || (subInfos = sm.getAvailableSubscriptionInfoList()) == null) {
            return null;
        }
        for (SubscriptionInfo info : subInfos) {
            if (iccId.equals(info.getIccId()) || iccId.equals(info.getCardString())) {
                return info;
            }
        }
        return null;
    }

    private static String getIccIdForSlot(TelephonyManager tm, int slotId) {
        List<UiccCardInfo> uiccCardsInfos = tm.getUiccCardsInfo();
        if (uiccCardsInfos == null) {
            return "";
        }
        for (UiccCardInfo uiccCardInfo : uiccCardsInfos) {
            if (uiccCardInfo.getPhysicalSlotIndex() == slotId) {
                return uiccCardInfo.getIccId();
            }
        }
        return "";
    }

    public static String getLocalizedCarrierName(Context context, int subId) {
        SubscriptionInfo subInfo;
        CharSequence fallback = "";
        if (context != null && SubscriptionManager.isValidSubscriptionId(subId) && (subInfo = getSubscriptionInfo(context, subId)) != null && subInfo.getDisplayName() != null) {
            fallback = subInfo.getDisplayName();
        }
        return getLocalizedCarrierName(context, subId, fallback);
    }

    public static String getDeviceId() {
        return TelephonyManager.getTelephonyProperty(0, "ril.gsm.imei", "");
    }

    public static CellLocation getCellLocation(int slotId) {
        logd("getCellLocation slotId = " + slotId);
        try {
            CellIdentity cellIdentity = getITelephonyExt().getCellLocation(slotId);
            CellLocation cl = cellIdentity.asCellLocation();
            if (cl != null && !cl.isEmpty()) {
                return cl;
            }
            logd("getCellLocation returning null because CellLocation is empty or phone type doesn't match CellLocation type");
            return null;
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return null;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return null;
        }
    }

    public static List<CellInfo> getAllCellInfo(int slotId) {
        logd("getAllCellInfo slotId = " + slotId);
        try {
            return getITelephonyExt().getAllCellInfo(slotId);
        } catch (RemoteException ex1) {
            ex1.printStackTrace();
            return null;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return null;
        }
    }

    public static boolean canSaveAdn(int subId) {
        logd("canSaveAdn subId = " + subId);
        try {
            return getITelephonyExt().canSaveAdn(subId);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return false;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return false;
        }
    }

    public static String getOperatorAlphaLong(String numeric, String language) {
        return getOperator(numeric, language, "long");
    }

    public static String getOperatorAlphaShort(String numeric, String language) {
        return getOperator(numeric, language, "short");
    }

    public static String getOperatorExtraShort(String numeric, String language) {
        String operator = getOperator(numeric, language, "xshort");
        if (operator == null) {
            operator = getOperatorAlphaShort(numeric, language);
        }
        if (operator == null) {
            return getOperatorAlphaLong(numeric, language);
        }
        return operator;
    }

    private static String getOperator(String numeric, String language, String nameType) {
        logd("getOperator numeric = " + numeric + ", language = " + language + ", nameType = " + nameType);
        try {
            return getITelephonyExt().getOperator(numeric, language, nameType);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void cancelMissedRecordsNotification() {
        logd("cancelMissedRecordsNotification");
        try {
            getITelephonyExt().cancelMissedRecordsNotification();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
        }
    }

    public static boolean selectNetworkManually(OperatorInfo network) {
        logd("selectNetworkManually");
        try {
            return getITelephonyExt().selectNetworkManually(network);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return false;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return false;
        }
    }

    public static ServiceState getServiceState() {
        logd("getServiceState");
        try {
            return getITelephonyExt().getServiceState();
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return null;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return null;
        }
    }

    public static ServiceState getServiceStateBySlot(int slotId) {
        logd("getServiceStateBySlot slotId = " + slotId);
        try {
            return getITelephonyExt().getServiceStateBySlot(slotId);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return null;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return null;
        }
    }

    public static boolean setNetworkSelectionModeAutomaticBySlotId(int slotId) {
        logd("setNetworkSelectionModeAutomaticBySlotId slotId = " + slotId);
        try {
            return getITelephonyExt().setNetworkSelectionModeAutomaticBySlotId(slotId);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return false;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return false;
        }
    }

    public static int updateSafePaySetting(boolean enable) {
        logd("updateSafePaySetting enable = " + enable);
        try {
            return getITelephonyExt().updateSafePaySetting(enable);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return 0;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return 0;
        }
    }

    public static int updateSafePayByPackage(String packageName, boolean install) {
        logd("updateSafePayByPackage packageName = " + packageName + ", install = " + install);
        try {
            return getITelephonyExt().updateSafePayByPackage(packageName, install);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return 0;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return 0;
        }
    }

    public static void updateMobileDataAlwaysOnSwitch(boolean changed) {
        logd("updateMobileDataAlwaysOnSwitch changed = " + changed);
        try {
            getITelephonyExt().updateMobileDataAlwaysOnSwitch(changed);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
        }
    }

    public static void updatePayProtectOnSwitch(boolean changed) {
        logd("updatePayProtectOnSwitch changed = " + changed);
        try {
            getITelephonyExt().updatePayProtectOnSwitch(changed);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
        }
    }

    public static void sendToFramework(String req, Bundle params) {
        try {
            getITelephonyExt().sendToFramework(req, params);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    public static Bundle getFromFramework(String req, Bundle inMsg) {
        logd("getFromFramework req = " + req + ", inMsg = " + inMsg);
        try {
            return getITelephonyExt().getFromFramework(req, inMsg);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return null;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return null;
        }
    }

    private static void logd(String msg) {
        Log.d(TAG, msg);
    }

    public static void sendAsyncRequest(String req, Bundle params, AsyncCallback cb) {
        sendAsyncRequest(req, params, null, cb);
    }

    public static void sendAsyncRequest(String req, Bundle params, final Executor executor, final AsyncCallback cb) {
        Objects.requireNonNull(cb, "callback");
        logd("sendAsyncRequest req=" + req);
        ITelephonyExt svc = getITelephonyExt();
        if (svc == null) {
            dispatch(executor, cb, null, 1, "phone_ext not available");
            return;
        }
        IStepOSAsyncCallback binderCb = new IStepOSAsyncCallback.Stub() { // from class: stepos.telephony.StepOSTelephonyManager.1
            @Override // stepos.telephony.IStepOSAsyncCallback
            public void onResult(Bundle result) {
                StepOSTelephonyManager.dispatch(executor, cb, result != null ? result : new Bundle(), 0, null);
            }

            @Override // stepos.telephony.IStepOSAsyncCallback
            public void onError(int errorCode, String message) {
                StepOSTelephonyManager.dispatch(executor, cb, null, errorCode, message);
            }
        };
        try {
            svc.sendAsyncRequest(req, params, binderCb);
        } catch (RemoteException e) {
            dispatch(executor, cb, null, 1, String.valueOf(e.getMessage()));
        } catch (NullPointerException e2) {
            dispatch(executor, cb, null, 1, String.valueOf(e2.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatch(Executor executor, final AsyncCallback cb, final Bundle result, final int errorCode, final String message) {
        Runnable r;
        if (result != null) {
            r = new Runnable() { // from class: stepos.telephony.StepOSTelephonyManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    cb.onResult(result);
                }
            };
        } else {
            r = new Runnable() { // from class: stepos.telephony.StepOSTelephonyManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    cb.onError(errorCode, message);
                }
            };
        }
        if (executor != null) {
            executor.execute(r);
        } else {
            r.run();
        }
    }

    public static void setDataRoamingEnabled(boolean enabled, int slotId) {
        logd("setDataRoamingEnabled enabled = " + enabled + " ,slotId = " + slotId);
        try {
            getITelephonyExt().setDataRoamingEnabled(enabled, slotId);
        } catch (RemoteException ex1) {
            ex1.printStackTrace();
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
        }
    }

    public static void set5GMode(int mode, int slotId) {
        logd("set5GMode mode = " + mode + " ,slotId = " + slotId);
        try {
            getITelephonyExt().set5GMode(mode, slotId);
        } catch (RemoteException ex1) {
            ex1.printStackTrace();
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
        }
    }

    public static int get5GMode(int slotId) {
        logd("get5GMode slotId = " + slotId);
        try {
            return getITelephonyExt().get5GMode(slotId);
        } catch (RemoteException ex1) {
            ex1.printStackTrace();
            return 0;
        } catch (NullPointerException ex2) {
            ex2.printStackTrace();
            return 0;
        }
    }
}
