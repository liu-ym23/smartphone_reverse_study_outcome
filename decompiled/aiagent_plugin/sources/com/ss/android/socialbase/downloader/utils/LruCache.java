package com.ss.android.socialbase.downloader.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class LruCache<K, T> extends LinkedHashMap<K, T> {
    private static final int DEFAULT_SIZE = 4;
    private int mMaxSize;

    public LruCache() {
        this(4, 4);
    }

    public LruCache(int r2, int r3) {
        this(r2, r3, true);
    }

    public LruCache(int r2, int r3, boolean r4) {
        super(r2, 0.75f, r4);
        setMaxSize(r3);
    }

    public void setMaxSize(int r1) {
        this.mMaxSize = r1;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        if (size() <= this.mMaxSize) goto L5;
        return true;
    L5:
        return false;
    }
}
