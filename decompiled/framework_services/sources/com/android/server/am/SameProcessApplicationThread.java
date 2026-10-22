package com.android.server.am;

import android.app.IApplicationThread;
import android.app.ReceiverInfo;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.CompatibilityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteCallback;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SameProcessApplicationThread extends IApplicationThread.Default {
    private final Handler mHandler;
    private final IApplicationThread mWrapped;

    public static /* synthetic */ void $r8$lambda$30wFUSGfb92ROcaDhzRGaDhM0Kc(SameProcessApplicationThread r0, Intent r1, ActivityInfo r2, CompatibilityInfo r3, int r4, String r5, Bundle r6, boolean r7, boolean r8, int r9, int r10, int r11, String r12) {
        r0.lambda$scheduleReceiver$0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ void $r8$lambda$T10F33W428xJvDMVID4LfAZYOho(SameProcessApplicationThread r0, RemoteCallback r1) {
        r0.lambda$schedulePing$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$ktjy8NKvnU9AoAuPRkAnHObQCdU(SameProcessApplicationThread r0, List r1) {
        r0.lambda$scheduleReceiverList$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$xSNZcV-izZZ4vzJCToJP1hgj54U, reason: not valid java name */
    public static /* synthetic */ void m1575$r8$lambda$xSNZcVizZZ4vzJCToJP1hgj54U(SameProcessApplicationThread r0, IIntentReceiver r1, Intent r2, int r3, String r4, Bundle r5, boolean r6, boolean r7, boolean r8, int r9, int r10, int r11, String r12) {
        r0.lambda$scheduleRegisteredReceiver$1(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public SameProcessApplicationThread(IApplicationThread wrapped, Handler handler) {
        wrapped.getClass();
        this.mWrapped = wrapped;
        handler.getClass();
        this.mHandler = handler;
    }

    public void scheduleReceiver(final Intent intent, final ActivityInfo info, final CompatibilityInfo compatInfo, final int resultCode, final String data, final Bundle extras, final boolean ordered, final boolean assumeDelivered, final int sendingUser, final int processState, final int sendingUid, final String sendingPackage) {
        this.mHandler.post(new SameProcessApplicationThread$$ExternalSyntheticLambda0(this, intent, info, compatInfo, resultCode, data, extras, ordered, assumeDelivered, sendingUser, processState, sendingUid, sendingPackage));
    }

    private /* synthetic */ void lambda$scheduleReceiver$0(Intent intent, ActivityInfo info, CompatibilityInfo compatInfo, int resultCode, String data, Bundle extras, boolean ordered, boolean assumeDelivered, int sendingUser, int processState, int sendingUid, String sendingPackage) {
        this.mWrapped.scheduleReceiver(intent, info, compatInfo, resultCode, data, extras, ordered, assumeDelivered, sendingUser, processState, sendingUid, sendingPackage);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void scheduleRegisteredReceiver(final IIntentReceiver receiver, final Intent intent, final int resultCode, final String data, final Bundle extras, final boolean ordered, final boolean sticky, final boolean assumeDelivered, final int sendingUser, final int processState, final int sendingUid, final String sendingPackage) {
        this.mHandler.post(new SameProcessApplicationThread$$ExternalSyntheticLambda1(this, receiver, intent, resultCode, data, extras, ordered, sticky, assumeDelivered, sendingUser, processState, sendingUid, sendingPackage));
    }

    private /* synthetic */ void lambda$scheduleRegisteredReceiver$1(IIntentReceiver receiver, Intent intent, int resultCode, String data, Bundle extras, boolean ordered, boolean sticky, boolean assumeDelivered, int sendingUser, int processState, int sendingUid, String sendingPackage) {
        this.mWrapped.scheduleRegisteredReceiver(receiver, intent, resultCode, data, extras, ordered, sticky, assumeDelivered, sendingUser, processState, sendingUid, sendingPackage);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void scheduleReceiverList(final List<ReceiverInfo> info) {
        this.mHandler.post(new SameProcessApplicationThread$$ExternalSyntheticLambda3(this, info));
    }

    private /* synthetic */ void lambda$scheduleReceiverList$2(List info) {
        this.mWrapped.scheduleReceiverList(info);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void schedulePing(final RemoteCallback pong) {
        this.mHandler.post(new SameProcessApplicationThread$$ExternalSyntheticLambda2(this, pong));
    }

    private /* synthetic */ void lambda$schedulePing$3(RemoteCallback pong) {
        this.mWrapped.schedulePing(pong);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
