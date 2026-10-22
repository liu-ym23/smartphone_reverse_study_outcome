package com.android.server.pdb;

/* JADX INFO: loaded from: classes2.dex */
public interface PersistentDataBlockManagerInternal {
    void clearTestHarnessModeData();

    boolean deactivateFactoryResetProtectionWithoutSecret();

    void forceOemUnlockEnabled(boolean r1);

    int getAllowedUid();

    byte[] getFrpCredentialHandle();

    byte[] getTestHarnessModeData();

    void setFrpCredentialHandle(byte[] r1);

    void setTestHarnessModeData(byte[] r1);
}
