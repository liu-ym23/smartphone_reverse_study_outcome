package com.android.server.policy;

/* JADX INFO: loaded from: classes2.dex */
public interface WindowWakeUpPolicyInternal {

    public interface InputWakeUpDelegate {
        boolean wakeUpFromKey(long r1, int r3, boolean r4);

        boolean wakeUpFromMotion(long r1, int r3, boolean r4, boolean r5);
    }

    void setInputWakeUpDelegate(InputWakeUpDelegate r1);
}
