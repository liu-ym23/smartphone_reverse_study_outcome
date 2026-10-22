package com.android.volley;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface Cache {

    public static class Entry {
        public byte[] data;
        public String etag;
        public long lastModified;
        public Map<String, String> responseHeaders;
        public long serverDate;
        public long softTtl;
        public long ttl;

        public Entry() {
            this.responseHeaders = Collections.emptyMap();
        }

        public boolean isExpired() {
            if (this.ttl >= System.currentTimeMillis()) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean refreshNeeded() {
            if (this.softTtl >= System.currentTimeMillis()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    void clear();

    Entry get(String r10);

    void initialize();

    void invalidate(String r10, boolean r11);

    void put(String r10, Entry r11);

    void remove(String r10);
}
