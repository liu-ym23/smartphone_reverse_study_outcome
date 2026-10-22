package com.danikula.videocache.sourcestorage;

import com.danikula.videocache.SourceInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface SourceInfoStorage {
    SourceInfo get(String r10);

    void put(String r10, SourceInfo r11);

    void release();
}
