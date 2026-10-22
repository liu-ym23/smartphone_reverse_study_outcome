package com.android.server.resmng;

import android.content.Context;
import com.android.server.am.ActivityManagerService;
import com.android.server.am.ProcessRecord;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public interface IDecisionMaker {

    @FunctionalInterface
    public interface GetPackageNameFunc {
        String from(ProcessRecord r1);
    }

    @FunctionalInterface
    public interface GetProcessNameFunc {
        String from(ProcessRecord r1);
    }

    @FunctionalInterface
    public interface GetUidFunc {
        int from(ProcessRecord r1);
    }

    default void systemReady(ActivityManagerService ams, Context context, GetPackageNameFunc getPackageNameFunc, GetProcessNameFunc getProcessNameFunc, GetUidFunc getUidFunc) {
    }

    default void dumpLocked(FileDescriptor fd, PrintWriter pw, String[] args) {
    }

    default DecisionEnums.DecisionOutput decideAndSyncExecute(DecisionEnums.DecisionInput input) {
        return null;
    }

    default DecisionEnums.DecisionOutput getModuleAction(DecisionEnums.DecisionInput input) {
        return new DecisionEnums.DecisionOutput();
    }
}
