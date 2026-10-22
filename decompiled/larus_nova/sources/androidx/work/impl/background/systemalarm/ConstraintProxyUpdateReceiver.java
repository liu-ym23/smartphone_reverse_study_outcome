package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;

/* JADX INFO: loaded from: classes17.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    static final String ACTION = "androidx.work.impl.background.systemalarm.UpdateProxies";
    static final String KEY_BATTERY_CHARGING_PROXY_ENABLED = "KEY_BATTERY_CHARGING_PROXY_ENABLED";
    static final String KEY_BATTERY_NOT_LOW_PROXY_ENABLED = "KEY_BATTERY_NOT_LOW_PROXY_ENABLED";
    static final String KEY_NETWORK_STATE_PROXY_ENABLED = "KEY_NETWORK_STATE_PROXY_ENABLED";
    static final String KEY_STORAGE_NOT_LOW_PROXY_ENABLED = "KEY_STORAGE_NOT_LOW_PROXY_ENABLED";
    static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("ConstrntProxyUpdtRecvr");
    }

    public ConstraintProxyUpdateReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context r100, final Intent r101) {
        if (r101 == null) goto L4;
        String r102 = r101.getAction();
    L6:
        if (ACTION.equals(r102) == true) goto L8;
        Logger.get().debug(TAG, String.format("Ignoring unknown action %s", new Object[]{r102}), new Throwable[0]);
        return;
    L8:
        final BroadcastReceiver.PendingResult r103 = goAsync();
        WorkManagerImpl.getInstance(r100).getWorkTaskExecutor().executeOnBackgroundThread(new AnonymousClass1(this, r101, r100, r103));
        return;
    L4:
        r102 = null;
        goto L6
    }

    public static Intent newConstraintProxyUpdateIntent(Context r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        Intent r105 = new Intent(ACTION);
        r105.setComponent(new ComponentName(r100, ConstraintProxyUpdateReceiver.class));
        r105.putExtra(KEY_BATTERY_NOT_LOW_PROXY_ENABLED, r101).putExtra(KEY_BATTERY_CHARGING_PROXY_ENABLED, r102).putExtra(KEY_STORAGE_NOT_LOW_PROXY_ENABLED, r103).putExtra(KEY_NETWORK_STATE_PROXY_ENABLED, r104);
        return r105;
    }
}
