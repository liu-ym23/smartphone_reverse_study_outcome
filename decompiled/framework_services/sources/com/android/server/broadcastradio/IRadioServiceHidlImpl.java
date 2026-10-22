package com.android.server.broadcastradio;

import android.hardware.radio.IAnnouncementListener;
import android.hardware.radio.ICloseHandle;
import android.hardware.radio.IRadioService;
import android.hardware.radio.ITuner;
import android.hardware.radio.ITunerCallback;
import android.hardware.radio.RadioManager;
import android.os.Binder;
import android.os.RemoteException;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import com.android.server.broadcastradio.hal2.AnnouncementAggregator;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;

/* JADX INFO: loaded from: classes.dex */
final class IRadioServiceHidlImpl extends IRadioService.Stub {
    private static final String TAG = "BcRadioSrvHidl";
    private final com.android.server.broadcastradio.hal1.BroadcastRadioService mHal1Client;
    private final com.android.server.broadcastradio.hal2.BroadcastRadioService mHal2Client;
    private final Object mLock;
    private final BroadcastRadioService mService;
    private final List<RadioManager.ModuleProperties> mV1Modules;

    IRadioServiceHidlImpl(BroadcastRadioService service, RadioServiceUserController userController) {
        this.mLock = new Object();
        service.getClass();
        this.mService = service;
        userController.getClass();
        this.mHal1Client = new com.android.server.broadcastradio.hal1.BroadcastRadioService(userController);
        this.mV1Modules = this.mHal1Client.loadModules();
        OptionalInt max = this.mV1Modules.stream().mapToInt(new IRadioServiceHidlImpl$$ExternalSyntheticLambda0()).max();
        if (max.isPresent() == false) goto L5;
        int r2 = max.getAsInt() + 1;
    L6:
        this.mHal2Client = new com.android.server.broadcastradio.hal2.BroadcastRadioService(r2, userController);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    IRadioServiceHidlImpl(BroadcastRadioService service, com.android.server.broadcastradio.hal1.BroadcastRadioService hal1, com.android.server.broadcastradio.hal2.BroadcastRadioService hal2) {
        this.mLock = new Object();
        service.getClass();
        this.mService = service;
        hal1.getClass();
        this.mHal1Client = hal1;
        this.mV1Modules = this.mHal1Client.loadModules();
        hal2.getClass();
        this.mHal2Client = hal2;
    }

    public List<RadioManager.ModuleProperties> listModules() {
        this.mService.enforcePolicyAccess();
        Collection<RadioManager.ModuleProperties> v2Modules = this.mHal2Client.listModules();
        Object r1 = this.mLock;
        monitor-enter(r1);
        List<RadioManager.ModuleProperties> modules = new ArrayList(this.mV1Modules.size() + v2Modules.size());     // Catch: Throwable -> L8
        modules.addAll(this.mV1Modules);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        modules.addAll(v2Modules);
        return modules;
    L8:
        th = move-exception;
        throw th;
    }

    public ITuner openTuner(int moduleId, RadioManager.BandConfig bandConfig, boolean withAudio, ITunerCallback callback) throws RemoteException {
        if (isDebugEnabled() == false) goto L5;
        Slog.d(TAG, "Opening module " + moduleId);
    L5:
        this.mService.enforcePolicyAccess();
        callback.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mHal2Client.hasModule(moduleId) == false) goto L14;
        ITuner r1 = this.mHal2Client.openSession(moduleId, bandConfig, withAudio, callback);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L14:
        ITuner r2 = this.mHal1Client.openTuner(moduleId, bandConfig, withAudio, callback);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    }

    public ICloseHandle addAnnouncementListener(int[] enabledTypes, IAnnouncementListener listener) {
        if (isDebugEnabled() == false) goto L5;
        Slog.d(TAG, "Adding announcement listener for " + Arrays.toString(enabledTypes));
    L5:
        enabledTypes.getClass();
        listener.getClass();
        this.mService.enforcePolicyAccess();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mHal2Client.hasAnyModules() == true) goto L14;
        Slog.w(TAG, "There are no HAL 2.0 modules registered");     // Catch: Throwable -> L12
        AnnouncementAggregator r1 = new AnnouncementAggregator(listener, this.mLock);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L14:
        ICloseHandle r2 = this.mHal2Client.addAnnouncementListener(enabledTypes, listener);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (this.mService.getContext().checkCallingOrSelfPermission("android.permission.DUMP") == 0) goto L6;
        pw.println("Permission Denial: can't dump HIDL BroadcastRadioService from from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " without permission android.permission.DUMP");
        return;
    L6:
        IndentingPrintWriter radioPw = new IndentingPrintWriter(pw);
        radioPw.printf("BroadcastRadioService\n", new Object[0]);
        radioPw.increaseIndent();
        radioPw.printf("HAL1 client: %s\n", new Object[]{this.mHal1Client});
        radioPw.increaseIndent();
        Object r1 = this.mLock;
        monitor-enter(r1);
        radioPw.printf("Modules of HAL1 client: %s\n", new Object[]{this.mV1Modules});     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        radioPw.decreaseIndent();
        radioPw.printf("HAL2 client:\n", new Object[0]);
        radioPw.increaseIndent();
        this.mHal2Client.dumpInfo(radioPw);
        radioPw.decreaseIndent();
        radioPw.decreaseIndent();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static boolean isDebugEnabled() {
        return Log.isLoggable(TAG, 3);
    }
}
