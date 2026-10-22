package com.android.server.net;

import android.content.Context;
import android.os.DebugSmtEx;
import com.android.internal.util.IndentingPrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface INetworkPolicyManagerServiceOptEx {
    default void init(Context context, NetworkPolicyManagerService policyManagerService) {
    }

    default int getOldBgUidRule(int oldUidRules) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default int getNewBgUidRule(int uidPolicy, boolean isForeground) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default int getNewUidRules(int newRule, int oldUidRules, int newBgUidRule) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void dump(IndentingPrintWriter fout) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
