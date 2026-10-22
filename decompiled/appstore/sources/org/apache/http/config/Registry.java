package org.apache.http.config;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.SAFE)
public final class Registry<I> implements Lookup<I> {
    private final Map<String, I> map;

    public Registry(Map<String, I> r10) {
        this.map = new ConcurrentHashMap(r10);
    }

    @Override // org.apache.http.config.Lookup
    public I lookup(String r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return this.map.get(r10.toLowerCase(Locale.ROOT));
    }

    public String toString() {
        return this.map.toString();
    }
}
