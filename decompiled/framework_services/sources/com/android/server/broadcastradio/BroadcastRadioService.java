package com.android.server.broadcastradio;

import android.content.Context;
import android.hardware.radio.IRadioService;
import com.android.server.SystemService;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class BroadcastRadioService extends SystemService {
    private final IRadioService mServiceImpl;

    public BroadcastRadioService(Context context) {
        super(context);
        ArrayList<String> serviceNameList = IRadioServiceAidlImpl.getServicesNames();
        RadioServiceUserController userController = new RadioServiceUserControllerImpl();
        if (serviceNameList.isEmpty() == false) goto L5;
        IRadioService r2 = new IRadioServiceHidlImpl(this, userController);
    L6:
        this.mServiceImpl = r2;
        return;
    L5:
        r2 = new IRadioServiceAidlImpl(this, serviceNameList, userController);
        goto L6
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("broadcastradio", this.mServiceImpl.asBinder());
    }

    void enforcePolicyAccess() {
        if (getContext().checkCallingPermission("android.permission.ACCESS_BROADCAST_RADIO") != 0) goto L6;
        return;
    L6:
        throw new SecurityException("ACCESS_BROADCAST_RADIO permission not granted");
    }
}
