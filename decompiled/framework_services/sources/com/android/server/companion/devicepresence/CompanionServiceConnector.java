package com.android.server.companion.devicepresence;

import android.companion.AssociationInfo;
import android.companion.DevicePresenceEvent;
import android.companion.ICompanionDeviceService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Slog;
import com.android.internal.infra.ServiceConnector;
import com.android.server.ServiceThread;
import com.android.server.companion.CompanionDeviceManagerService;

/* JADX INFO: loaded from: classes.dex */
public class CompanionServiceConnector extends ServiceConnector.Impl<ICompanionDeviceService> {
    private static final String TAG = "CDM_CompanionServiceConnector";
    private static final long UNBIND_POST_DELAY_MS = 5000;
    private static volatile ServiceThread sServiceThread;
    private final ComponentName mComponentName;
    private final boolean mIsPrimary;
    private Listener mListener;
    private final int mUserId;

    public interface Listener {
        void onBindingDied(int r1, String r2, CompanionServiceConnector r3);
    }

    public static /* synthetic */ void $r8$lambda$6ghL_L70pPCSGZnz5TR7_OwMlgI(AssociationInfo r0, ICompanionDeviceService r1) {
        lambda$postOnDeviceDisappeared$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$F9-2n99wLId0e8HpWCVQAUufEOU, reason: not valid java name */
    public static /* synthetic */ void m2957$r8$lambda$F92n99wLId0e8HpWCVQAUufEOU(AssociationInfo r0, ICompanionDeviceService r1) {
        lambda$postOnDeviceAppeared$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$h-XHC4o4z88gn0VW2ITaOxxOuWw, reason: not valid java name */
    public static /* synthetic */ void m2958$r8$lambda$hXHC4o4z88gn0VW2ITaOxxOuWw(DevicePresenceEvent r0, ICompanionDeviceService r1) {
        lambda$postOnDevicePresenceEvent$2(r0, r1);
    }

    /* JADX INFO: renamed from: binderAsInterface, reason: collision with other method in class */
    protected /* bridge */ /* synthetic */ IInterface m2959binderAsInterface(IBinder r1) {
        return binderAsInterface(r1);
    }

    protected /* bridge */ /* synthetic */ void onServiceConnectionStatusChanged(IInterface r1, boolean r2) {
        onServiceConnectionStatusChanged((ICompanionDeviceService) r1, r2);
    }

    static CompanionServiceConnector newInstance(Context context, int userId, ComponentName componentName, boolean isSelfManaged, boolean isPrimary) {
        if (isSelfManaged == false) goto L4;
        int r0 = 268435456;
    L5:
        int bindingFlags = r0;
        return new CompanionServiceConnector(context, userId, componentName, bindingFlags, isPrimary);
    L4:
        r0 = 65536;
        goto L5
    }

    private CompanionServiceConnector(Context context, int userId, ComponentName componentName, int bindingFlags, boolean isPrimary) {
        super(context, buildIntent(componentName), bindingFlags, userId, null);
        this.mUserId = userId;
        this.mComponentName = componentName;
        this.mIsPrimary = isPrimary;
    }

    void setListener(Listener listener) {
        this.mListener = listener;
    }

    private static /* synthetic */ void lambda$postOnDeviceAppeared$0(AssociationInfo associationInfo, ICompanionDeviceService companionService) throws Exception {
        companionService.onDeviceAppeared(associationInfo);
    }

    void postOnDeviceAppeared(final AssociationInfo associationInfo) {
        post(new CompanionServiceConnector$$ExternalSyntheticLambda2(associationInfo));
    }

    private static /* synthetic */ void lambda$postOnDeviceDisappeared$1(AssociationInfo associationInfo, ICompanionDeviceService companionService) throws Exception {
        companionService.onDeviceDisappeared(associationInfo);
    }

    void postOnDeviceDisappeared(final AssociationInfo associationInfo) {
        post(new CompanionServiceConnector$$ExternalSyntheticLambda3(associationInfo));
    }

    private static /* synthetic */ void lambda$postOnDevicePresenceEvent$2(DevicePresenceEvent event, ICompanionDeviceService companionService) throws Exception {
        companionService.onDevicePresenceEvent(event);
    }

    void postOnDevicePresenceEvent(final DevicePresenceEvent event) {
        post(new CompanionServiceConnector$$ExternalSyntheticLambda1(event));
    }

    void postUnbind() {
        getJobHandler().postDelayed(new CompanionServiceConnector$$ExternalSyntheticLambda0(this), UNBIND_POST_DELAY_MS);
    }

    boolean isPrimary() {
        return this.mIsPrimary;
    }

    ComponentName getComponentName() {
        return this.mComponentName;
    }

    protected void onServiceConnectionStatusChanged(ICompanionDeviceService service, boolean isConnected) {
        Slog.d(TAG, "onServiceConnectionStatusChanged() " + this.mComponentName.toShortString() + " connected=" + isConnected);
    }

    public void binderDied() {
        super.binderDied();
        Slog.d(TAG, "binderDied() " + this.mComponentName.toShortString());
        if (this.mListener == null) goto L6;
        this.mListener.onBindingDied(this.mUserId, this.mComponentName.getPackageName(), this);
        return;
    }

    protected ICompanionDeviceService binderAsInterface(IBinder service) {
        return ICompanionDeviceService.Stub.asInterface(service);
    }

    protected Handler getJobHandler() {
        return getServiceThread().getThreadHandler();
    }

    protected long getAutoDisconnectTimeoutMs() {
        return -1;
    }

    private static Intent buildIntent(ComponentName componentName) {
        return new Intent("android.companion.CompanionDeviceService").setComponent(componentName);
    }

    private static ServiceThread getServiceThread() {
        if (sServiceThread != null) goto L16;
        monitor-enter(CompanionDeviceManagerService.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sServiceThread != null) goto L11;
        sServiceThread = new ServiceThread("companion-device-service-connector", 0, false);     // Catch: Throwable -> L9
        sServiceThread.start();     // Catch: Throwable -> L9
    L11:
        monitor-exit(CompanionDeviceManagerService.class);     // Catch: Throwable -> L9
    L16:
        return sServiceThread;
    }
}
