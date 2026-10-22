package com.android.server.audio;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.UserHandle;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes.dex */
public class SystemServerAdapter {
    protected final Context mContext;

    /* JADX INFO: renamed from: -$$Nest$mbroadcastProfileParentStickyIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2222$$Nest$mbroadcastProfileParentStickyIntent(SystemServerAdapter r0, Context r1, String r2, int r3, int r4) {
        r0.broadcastProfileParentStickyIntent(r1, r2, r3, r4);
    }

    protected SystemServerAdapter(Context context) {
        this.mContext = context;
    }

    static final SystemServerAdapter getDefaultAdapter(Context context) {
        context.getClass();
        return new SystemServerAdapter(context);
    }

    public boolean isPrivileged() {
        return true;
    }

    public void sendMicrophoneMuteChangedIntent() {
        this.mContext.sendBroadcastAsUser(new Intent("android.media.action.MICROPHONE_MUTE_CHANGED").setFlags(1073741824), UserHandle.ALL);
    }

    public void sendDeviceBecomingNoisyIntent() {
        if (this.mContext != null) goto L5;
        return;
    L5:
        Intent intent = new Intent("android.media.AUDIO_BECOMING_NOISY");
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        long ident = Binder.clearCallingIdentity();
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(ident);
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void broadcastStickyIntentToCurrentProfileGroup(Intent intent) {
        int[] profileIds = ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getCurrentProfileIds();
        int r1 = profileIds.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int userId = profileIds[r2];
        ActivityManager.broadcastStickyIntent(intent, userId);
        r2 = r2 + 1;
        goto L3
    }

    void registerUserStartedReceiver(Context context) {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.USER_STARTED");
        context.registerReceiverAsUser(new AnonymousClass1(this), UserHandle.ALL, filter, null, null);
    }

    private void broadcastProfileParentStickyIntent(Context context, String intentAction, int profileId, int parentId) {
        Intent intent = context.registerReceiverAsUser(null, UserHandle.of(parentId), new IntentFilter(intentAction), null, null);
        if (intent == null) goto L6;
        ActivityManager.broadcastStickyIntent(intent, profileId);
        return;
    }

    void broadcastMasterMuteStatus(boolean muted) {
        Intent intent = new Intent("android.media.MASTER_MUTE_CHANGED_ACTION");
        intent.putExtra("android.media.EXTRA_MASTER_VOLUME_MUTED", muted);
        intent.addFlags(872415232);
        long ident = Binder.clearCallingIdentity();
        this.mContext.sendStickyBroadcastAsUser(intent, UserHandle.ALL);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }
}
