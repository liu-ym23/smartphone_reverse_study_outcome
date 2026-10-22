package com.danikula.videocache.sourcestorage;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class SourceInfoStorageFactory {
    public SourceInfoStorageFactory() {
    }

    public static SourceInfoStorage newEmptySourceInfoStorage() {
        return new NoSourceInfoStorage();
    }

    public static SourceInfoStorage newSourceInfoStorage(Context r10) {
        return new DatabaseSourceInfoStorage(r10);
    }
}
