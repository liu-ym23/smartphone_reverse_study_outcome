package com.android.server.job.controllers.idle;

import android.content.Context;
import android.provider.DeviceConfig;
import android.util.IndentingPrintWriter;
import android.util.proto.ProtoOutputStream;
import com.android.server.job.JobSchedulerService;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface IdlenessTracker {
    void dump(ProtoOutputStream r1, long r2);

    void dump(PrintWriter r1);

    void dumpConstants(IndentingPrintWriter r1);

    boolean isIdle();

    void onBatteryStateChanged(boolean r1, boolean r2);

    void processConstant(DeviceConfig.Properties r1, String r2);

    void startTracking(Context r1, JobSchedulerService r2, IdlenessListener r3);
}
