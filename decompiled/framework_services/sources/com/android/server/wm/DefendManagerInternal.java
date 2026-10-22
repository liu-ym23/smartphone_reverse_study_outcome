package com.android.server.wm;

import android.os.IBinder;
import com.android.server.am.ActivityManagerService;
import com.android.server.am.PendingIntentController;
import com.android.server.am.ProcessRecord;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DefendManagerInternal {
    public abstract void checkMemWhenBackground(int r1);

    public abstract void init(ActivityManagerService r1);

    public abstract void recordTopApp(ProcessRecord r1, String r2);

    public abstract void reportActivityCountChange(WindowProcessController r1);

    public abstract boolean reportActivityRecordCountChange(Task r1);

    public abstract void reportActivityRecordCountChangeForSpecialApp(Task r1);

    public abstract boolean reportAppDied(String r1);

    public abstract void reportAppForeground(int r1);

    public abstract void reportBroadcastCountchange(ArrayList r1);

    public abstract void reportConnectionRecordsExceedsMax(String r1);

    public abstract void reportLowMemPressure(int r1);

    public abstract void reportObserversExceedsMax(int r1);

    public abstract boolean reportOnePixelActivityFind(String r1, IBinder r2);

    public abstract void reportPendingIntentRecordCountchange(PendingIntentController r1);

    public abstract void reportProcBroadcastCountChange(int r1, int r2);

    public abstract void showForbidTipMessage();

    public DefendManagerInternal() {
    }
}
