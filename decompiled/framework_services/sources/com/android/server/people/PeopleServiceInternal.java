package com.android.server.people;

import android.os.CancellationSignal;
import android.service.appprediction.IPredictionService;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PeopleServiceInternal extends IPredictionService.Stub {
    public abstract byte[] getBackupPayload(int r1);

    public abstract void pruneDataForUser(int r1, CancellationSignal r2);

    public abstract void restore(int r1, byte[] r2);

    public PeopleServiceInternal() {
    }
}
