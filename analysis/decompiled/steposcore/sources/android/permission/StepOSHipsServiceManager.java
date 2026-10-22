package android.permission;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.permission.IStepOSHipsService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class StepOSHipsServiceManager {
    private static volatile StepOSHipsServiceManager mHipsServiceManager = null;
    private static IStepOSHipsService mStepOSHipsService = null;

    private StepOSHipsServiceManager() {
    }

    public static StepOSHipsServiceManager getInstance() {
        if (mHipsServiceManager == null) {
            synchronized (StepOSHipsServiceManager.class) {
                if (mHipsServiceManager == null) {
                    mHipsServiceManager = new StepOSHipsServiceManager();
                }
            }
        }
        return mHipsServiceManager;
    }

    private IStepOSHipsService getHipsService() {
        if (mStepOSHipsService == null) {
            IBinder remote = ServiceManager.getService("hips_service");
            mStepOSHipsService = IStepOSHipsService.Stub.asInterface(remote);
        }
        return mStepOSHipsService;
    }

    public int isStopUsbInstall(String apkFilePath) throws RemoteException {
        return getHipsService().isStopUsbInstall(apkFilePath);
    }

    public void setUsbInstallSwitchState(boolean isOn) throws RemoteException {
        getHipsService().setUsbInstallSwitchState(isOn);
    }

    public int getUsbInstallSwitchState() throws RemoteException {
        return getHipsService().getUsbInstallSwitchState();
    }

    public void setUsbInstallItemState(int type, String pkgName, String apkName, int mode) throws RemoteException {
        getHipsService().setUsbInstallItemState(type, pkgName, apkName, mode);
    }

    public Map<?, ?> getUsbInstallInfo() throws RemoteException {
        Map<?, ?> map = getHipsService().getUsbInstallInfo();
        if (map == null) {
            return new HashMap();
        }
        return map;
    }

    public boolean isInPasswordMode() throws RemoteException {
        IStepOSHipsService service = getHipsService();
        if (service == null) {
            return false;
        }
        return service.isInPasswordMode();
    }

    public boolean isSecurityKBSwitchOn() throws RemoteException {
        return getHipsService().isSecurityKBSwitchOn();
    }

    public void setPasswordModeSwitchState(boolean isOn) throws RemoteException {
        getHipsService().setPasswordModeSwitchState(isOn);
    }

    public boolean getPasswordModeSwitchState() throws RemoteException {
        return getHipsService().getPasswordModeSwitchState();
    }

    public boolean isInSecurityMargin() throws RemoteException {
        return getHipsService().isInSecurityMargin();
    }

    public void setSecurityMarginSwitchState(boolean isOn) throws RemoteException {
        getHipsService().setSecurityMarginSwitchState(isOn);
    }

    public boolean getSecurityMarginSwitchState() throws RemoteException {
        return getHipsService().getSecurityMarginSwitchState();
    }

    public int getSecurityMarginVersion() throws RemoteException {
        return getHipsService().getSecurityMarginVersion();
    }

    public void setSecurityMarginTimeStamp(long timeStamp) throws RemoteException {
        getHipsService().setSecurityMarginTimeStamp(timeStamp);
    }

    public long getSecurityMarginTimeStamp() throws RemoteException {
        return getHipsService().getSecurityMarginTimeStamp();
    }

    public int setSecurityMarginList(List<String> list) throws RemoteException {
        return getHipsService().setSecurityMarginList(list);
    }

    public Map<?, ?> getSecurityMarginItems() throws RemoteException {
        Map<?, ?> map = getHipsService().getSecurityMarginItems();
        if (map == null) {
            return new HashMap();
        }
        return map;
    }

    public void reportIfwEvent(int type, String caller, int callerUid, String callee, int calleeUid, String action, String component, String providerName, boolean foreground, boolean running, int query, String reason, boolean intercept, boolean custom) throws RemoteException {
        getHipsService().reportIfwEvent(type, caller, callerUid, callee, calleeUid, action, component, providerName, foreground, running, query, reason, intercept, custom);
    }

    public void reportProcessStartEvent(int runType, String callerPackage, int callerUid, String receivingPackage, int receivingUid, boolean callerForeground, String reason, boolean intercepted, boolean custom) {
        try {
            reportIfwEvent(runType, callerPackage, callerUid, receivingPackage, receivingUid, null, null, null, callerForeground, false, 0, reason, intercepted, custom);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<String> queryIfwStats(String packageName, long startTime, long endTime) throws RemoteException {
        return getHipsService().queryIfwStats(packageName, startTime, endTime);
    }

    public void updateIfwRuleByUser(int type, int mode, String caller, String callee, boolean isFg) {
        Exception e;
        try {
        } catch (Exception e2) {
            e = e2;
        }
        try {
            getHipsService().updateIfwRuleByUser(type, mode, caller, callee, isFg);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
    }

    public int checkIfwRuleByUser(int type, String sender, String receiver, boolean isFg) {
        try {
            return getHipsService().checkIfwRuleByUser(type, sender, receiver, isFg);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getIfwVersion() {
        try {
            return getHipsService().getIfwVersion();
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
}
