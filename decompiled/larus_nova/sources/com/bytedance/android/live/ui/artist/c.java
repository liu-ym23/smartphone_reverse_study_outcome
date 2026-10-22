package com.bytedance.android.live.ui.artist;

import android.util.LruCache;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<Float, HashMap<Character, Float>> f102045a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f102046b = null;

    public c() {
    }

    static {
        f102046b = new c();
        f102045a = new LruCache(5);
    }
}
