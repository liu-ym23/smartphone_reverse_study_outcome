package android.accounts;

import android.content.Context;
import android.os.RemoteException;
import com.stepos.account.IStepOSAccountService;

/* loaded from: classes.dex */
public class StepOSAccountManager {
    private final Context mContext;
    private final IStepOSAccountService mService;

    public StepOSAccountManager(Context context, IStepOSAccountService service) {
        this.mContext = context;
        this.mService = service;
    }

    public String getUserData(String key) {
        try {
            return this.mService.getUserData(key);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void setUserData(String key, String value) {
        try {
            this.mService.setUserData(key, value);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }
}
