package com.android.server.people.data;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.people.ConversationStatus;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Binder;
import android.os.CancellationSignal;
import com.android.server.LocalServices;
import com.android.server.people.PeopleServiceInternal;
import com.android.server.pm.PackageManagerService;

/* JADX INFO: loaded from: classes2.dex */
public class ConversationStatusExpirationBroadcastReceiver extends BroadcastReceiver {
    static final String ACTION = "ConversationStatusExpiration";
    static final String EXTRA_USER_ID = "userId";
    static final int REQUEST_CODE = 10;
    static final String SCHEME = "expStatus";

    public static /* synthetic */ void $r8$lambda$y6jPOypwCciWpFkL4KIHDphDgEs(Intent r0) {
        lambda$onReceive$0(r0);
    }

    public ConversationStatusExpirationBroadcastReceiver() {
    }

    void scheduleExpiration(Context context, int userId, String pkg, String conversationId, ConversationStatus status) {
        long identity = Binder.clearCallingIdentity();
        PendingIntent pi = PendingIntent.getBroadcast(context, 10, new Intent(ACTION).setPackage(PackageManagerService.PLATFORM_PACKAGE_NAME).setData(new Uri.Builder().scheme(SCHEME).appendPath(getKey(userId, pkg, conversationId, status)).build()).addFlags(268435456).putExtra("userId", userId), AudioFormat.DTS_HD);     // Catch: Throwable -> L6
        ((AlarmManager) context.getSystemService(AlarmManager.class)).setExactAndAllowWhileIdle(0, status.getEndTimeMillis(), pi);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private static String getKey(int userId, String pkg, String conversationId, ConversationStatus status) {
        return userId + pkg + conversationId + status.getId();
    }

    static IntentFilter getFilter() {
        IntentFilter conversationStatusFilter = new IntentFilter(ACTION);
        conversationStatusFilter.addDataScheme(SCHEME);
        return conversationStatusFilter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        String action = intent.getAction();
        if (action != null) goto L6;
        return;
    L6:
        if (ACTION.equals(action) == false) goto L9;
        new Thread(new ConversationStatusExpirationBroadcastReceiver$$ExternalSyntheticLambda0(intent)).start();
        return;
    }

    private static /* synthetic */ void lambda$onReceive$0(Intent intent) {
        PeopleServiceInternal peopleServiceInternal = (PeopleServiceInternal) LocalServices.getService(PeopleServiceInternal.class);
        peopleServiceInternal.pruneDataForUser(intent.getIntExtra("userId", ActivityManager.getCurrentUser()), new CancellationSignal());
    }
}
