package org.apache.http.protocol;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.SAFE)
public class UriPatternMatcher<T> {
    private final Map<String, T> map;

    public UriPatternMatcher() {
        this.map = new LinkedHashMap();
    }

    public synchronized Set<Map.Entry<String, T>> entrySet() {
        monitor-enter(this);
        HashSet r10 = new HashSet(this.map.entrySet());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized Map<String, T> getObjects() {
        monitor-enter(this);
        Map<String, T> r10 = this.map;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized T lookup(String r10) {
        monitor-enter(this);
        Args.notNull(r10, "Request path");     // Catch: Throwable -> L18
        T r11 = this.map.get(r10);     // Catch: Throwable -> L18
        if (r11 != null) goto L22;
        Iterator<String> r12 = this.map.keySet().iterator();     // Catch: Throwable -> L18
        String r13 = null;
    L6:
        if (r12.hasNext() == false) goto L22;
        String r14 = r12.next();     // Catch: Throwable -> L18
        if (matchUriRequestPattern(r14, r10) == false) goto L6;
        if (r13 == null) goto L20;
        if (r13.length() < r14.length()) goto L20;
        if (r13.length() != r14.length()) goto L6;
        if (r14.endsWith("*") == false) goto L6;
    L20:
        r11 = this.map.get(r14);     // Catch: Throwable -> L18
        r13 = r14;
    L22:
        monitor-exit(this);
        return r11;
    L18:
        th = move-exception;
        throw th;
    }

    public boolean matchUriRequestPattern(String r10, String r11) {
        if (r10.equals("*") == false) goto L6;
        return true;
    L6:
        if (r10.endsWith("*") == false) goto L10;
        if (r11.startsWith(r10.substring(0, r10.length() - 1)) == false) goto L10;
        return true;
    L10:
        if (r10.startsWith("*") == false) goto L15;
        if (r11.endsWith(r10.substring(1, r10.length())) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public synchronized void register(String r10, T r11) {
        monitor-enter(this);
        Args.notNull(r10, "URI request pattern");     // Catch: Throwable -> L6
        this.map.put(r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized void setHandlers(Map<String, T> r10) {
        monitor-enter(this);
        Args.notNull(r10, "Map of handlers");     // Catch: Throwable -> L6
        this.map.clear();     // Catch: Throwable -> L6
        this.map.putAll(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized void setObjects(Map<String, T> r10) {
        monitor-enter(this);
        Args.notNull(r10, "Map of handlers");     // Catch: Throwable -> L6
        this.map.clear();     // Catch: Throwable -> L6
        this.map.putAll(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return this.map.toString();
    }

    public synchronized void unregister(String r10) {
        monitor-enter(this);
        if (r10 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.map.remove(r10);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
