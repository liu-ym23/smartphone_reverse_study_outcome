package com.stepos.stepclaw.memory.storage.index;

import java.io.File;
import java.io.FileFilter;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return MemoryIndexManager.scanLegacyMemoryFiles$lambda$0(file);
    }
}
