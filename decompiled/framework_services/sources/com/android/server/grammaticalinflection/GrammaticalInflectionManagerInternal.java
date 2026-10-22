package com.android.server.grammaticalinflection;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GrammaticalInflectionManagerInternal {
    public abstract void applyRestoredSystemPayload(byte[] r1, int r2);

    public abstract boolean canGetSystemGrammaticalGender(int r1);

    public abstract byte[] getBackupPayload(int r1);

    public abstract int getGrammaticalGenderFromDeveloperSettings();

    public abstract byte[] getSystemBackupPayload(int r1);

    public abstract int getSystemGrammaticalGender(int r1);

    public abstract int mergedFinalSystemGrammaticalGender();

    public abstract void stageAndApplyRestoredPayload(byte[] r1, int r2);

    public GrammaticalInflectionManagerInternal() {
    }
}
