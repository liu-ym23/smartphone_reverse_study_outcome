package androidx.core.content;

import Z2.I;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Process;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class c {
    @DoNotInline
    public static Intent a(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i4) {
        if ((i4 & 4) == 0 || str != null) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i4 & 1);
        }
        String str2 = context.getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if (I.f(context, str2, Process.myPid(), Process.myUid(), context.getPackageName()) == 0) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str2, handler);
        }
        throw new RuntimeException(B0.g.n("Permission ", str2, " is required by your application to receive broadcasts, please add it to your manifest"));
    }

    @DoNotInline
    public static ComponentName b(Context context, Intent intent) {
        return context.startForegroundService(intent);
    }
}
