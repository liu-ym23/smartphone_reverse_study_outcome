package com.android.volley.toolbox;

import com.android.volley.Cache;

/* JADX INFO: loaded from: classes.dex */
public class NoCache implements Cache {
    public NoCache() {
    }

    @Override // com.android.volley.Cache
    public void clear() {
    }

    @Override // com.android.volley.Cache
    public Cache.Entry get(String r10) {
        return null;
    }

    @Override // com.android.volley.Cache
    public void initialize() {
    }

    @Override // com.android.volley.Cache
    public void invalidate(String r10, boolean r11) {
    }

    @Override // com.android.volley.Cache
    public void put(String r10, Cache.Entry r11) {
    }

    @Override // com.android.volley.Cache
    public void remove(String r10) {
    }
}
