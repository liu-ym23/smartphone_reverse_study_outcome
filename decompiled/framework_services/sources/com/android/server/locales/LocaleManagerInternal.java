package com.android.server.locales;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LocaleManagerInternal {
    public abstract byte[] getBackupPayload(int r1);

    public abstract void stageAndApplyRestoredPayload(byte[] r1, int r2);

    public LocaleManagerInternal() {
    }
}
