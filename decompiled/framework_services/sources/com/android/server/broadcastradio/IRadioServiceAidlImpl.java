package com.android.server.broadcastradio;

import android.hardware.broadcastradio.IBroadcastRadio;
import android.hardware.radio.IAnnouncementListener;
import android.hardware.radio.ICloseHandle;
import android.hardware.radio.IRadioService;
import android.hardware.radio.ITuner;
import android.hardware.radio.ITunerCallback;
import android.hardware.radio.RadioManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.IndentingPrintWriter;
import android.util.Log;
import com.android.server.broadcastradio.aidl.BroadcastRadioServiceImpl;
import com.android.server.utils.Slogf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class IRadioServiceAidlImpl extends IRadioService.Stub {
    private static final List<String> SERVICE_NAMES = null;
    private static final String TAG = "BcRadioSrvAidl";
    private final BroadcastRadioServiceImpl mAidlHalClient;
    private final BroadcastRadioService mService;

    static {
        SERVICE_NAMES = Arrays.asList(new String[]{IBroadcastRadio.DESCRIPTOR + "/amfm", IBroadcastRadio.DESCRIPTOR + "/dab"});
    }

    public static ArrayList<String> getServicesNames() {
        ArrayList<String> serviceList = new ArrayList();
        int i = 0;
    L4:
        if (i >= SERVICE_NAMES.size()) goto L10;
        IBinder serviceBinder = ServiceManager.waitForDeclaredService(SERVICE_NAMES.get(i));
        if (serviceBinder == null) goto L8;
        serviceList.add(SERVICE_NAMES.get(i));
    L8:
        i = i + 1;
        goto L4
    L10:
        return serviceList;
    }

    IRadioServiceAidlImpl(BroadcastRadioService service, List<String> serviceList, RadioServiceUserController userController) {
        this(service, new BroadcastRadioServiceImpl(serviceList, userController));
        Slogf.i(TAG, "Initialize BroadcastRadioServiceAidl(%s)", new Object[]{service});
    }

    IRadioServiceAidlImpl(BroadcastRadioService service, BroadcastRadioServiceImpl halAidl) {
        service.getClass();
        this.mService = service;
        halAidl.getClass();
        this.mAidlHalClient = halAidl;
    }

    public List<RadioManager.ModuleProperties> listModules() {
        this.mService.enforcePolicyAccess();
        return this.mAidlHalClient.listModules();
    }

    public ITuner openTuner(int moduleId, RadioManager.BandConfig bandConfig, boolean withAudio, ITunerCallback callback) throws RemoteException {
        if (isDebugEnabled() == false) goto L5;
        Slogf.d(TAG, "Opening module %d", new Object[]{Integer.valueOf(moduleId)});
    L5:
        this.mService.enforcePolicyAccess();
        if (callback == null) goto L10;
        return this.mAidlHalClient.openSession(moduleId, bandConfig, withAudio, callback);
    L10:
        throw new IllegalArgumentException("Callback must not be null");
    }

    public ICloseHandle addAnnouncementListener(int[] enabledTypes, IAnnouncementListener listener) {
        if (isDebugEnabled() == false) goto L5;
        Slogf.d(TAG, "Adding announcement listener for %s", new Object[]{Arrays.toString(enabledTypes)});
    L5:
        enabledTypes.getClass();
        listener.getClass();
        this.mService.enforcePolicyAccess();
        return this.mAidlHalClient.addAnnouncementListener(enabledTypes, listener);
    }

    protected void dump(FileDescriptor fd, PrintWriter printWriter, String[] args) {
        if (this.mService.getContext().checkCallingOrSelfPermission("android.permission.DUMP") == 0) goto L6;
        printWriter.println("Permission Denial: can't dump AIDL BroadcastRadioService from from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " without permission android.permission.DUMP");
        return;
    L6:
        IndentingPrintWriter radioPrintWriter = new IndentingPrintWriter(printWriter);
        radioPrintWriter.printf("BroadcastRadioService\n", new Object[0]);
        radioPrintWriter.increaseIndent();
        radioPrintWriter.printf("AIDL HAL client:\n", new Object[0]);
        radioPrintWriter.increaseIndent();
        this.mAidlHalClient.dumpInfo(radioPrintWriter);
        radioPrintWriter.decreaseIndent();
        radioPrintWriter.decreaseIndent();
    }

    private static boolean isDebugEnabled() {
        return Log.isLoggable(TAG, 3);
    }
}
