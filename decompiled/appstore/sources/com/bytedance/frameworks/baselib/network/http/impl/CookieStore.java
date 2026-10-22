package com.bytedance.frameworks.baselib.network.http.impl;

import java.net.URI;
import java.util.List;
import r4.c;

/* JADX INFO: loaded from: classes.dex */
public interface CookieStore {
    void add(URI r10, c r11);

    List<c> get(URI r10);

    List<c> getCookies();

    List<URI> getURIs();

    boolean remove(URI r10, c r11);

    boolean removeAll();
}
