package com.android.server.rollback;

import android.os.UserHandle;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface RollbackManagerInternal {
    int notifyStagedSession(int r1);

    void snapshotAndRestoreUserData(String r1, List<UserHandle> r2, int r3, long r4, String r6, int r7);
}
