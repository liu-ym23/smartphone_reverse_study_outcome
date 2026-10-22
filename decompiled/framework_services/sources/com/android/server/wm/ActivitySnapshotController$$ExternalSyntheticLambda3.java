package com.android.server.wm;

import android.os.Environment;
import java.io.File;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ActivitySnapshotController$$ExternalSyntheticLambda3 implements BaseAppSnapshotPersister.DirectoryResolver {
    public /* synthetic */ ActivitySnapshotController$$ExternalSyntheticLambda3() {
    }

    @Override // com.android.server.wm.BaseAppSnapshotPersister.DirectoryResolver
    public final File getSystemDirectoryForUser(int r1) {
        return Environment.getDataSystemCeDirectory(r1);
    }
}
