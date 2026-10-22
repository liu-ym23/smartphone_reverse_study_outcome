package com.bytedance.android.window.shop;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CategoryTabStruct> f187769a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f187770b = null;

    static {
        new ConcurrentHashMap();
        f187769a = new ConcurrentHashMap();
        f187770b = SetsKt.setOf(new Integer[]{0, Integer.valueOf(AVMDLDataLoader.KeyIsPreconnectNum), 3003, 2505, 2506, 2503, Integer.valueOf(AVMDLDataLoader.KeyIsEnablePreconnect), Integer.valueOf(AVMDLDataLoader.KeyIsNextDownloadThreshold), Integer.valueOf(AVMDLDataLoader.KeyIsEnableLoaderPreempt), 3004, 2507, 301, 302, 999});
    }
}
