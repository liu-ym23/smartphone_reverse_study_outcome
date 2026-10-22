package com.danikula.videocache.sourcestorage;

import com.danikula.videocache.SourceInfo;

/* JADX INFO: loaded from: classes2.dex */
public class NoSourceInfoStorage implements SourceInfoStorage {
    public NoSourceInfoStorage() {
    }

    @Override // com.danikula.videocache.sourcestorage.SourceInfoStorage
    public SourceInfo get(String r10) {
        return null;
    }

    @Override // com.danikula.videocache.sourcestorage.SourceInfoStorage
    public void put(String r10, SourceInfo r11) {
    }

    @Override // com.danikula.videocache.sourcestorage.SourceInfoStorage
    public void release() {
    }
}
