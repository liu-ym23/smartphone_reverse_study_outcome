package com.bytedance.frameworks.baselib.network.http.b;

import android.util.Pair;
import java.net.URI;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: CookieStore.java */
/* JADX INFO: loaded from: classes.dex */
public interface d {

    /* JADX INFO: compiled from: CookieStore.java */
    public interface a {
        void onCookieGet(f r1);
    }

    String a(URI r1);

    boolean a();

    boolean a(f r1);

    boolean a(URI r1, String r2, boolean r3);

    Pair<String, Map<String, Set<f>>> b(URI r1);
}
