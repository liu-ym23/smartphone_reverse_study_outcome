package com.google.crypto.tink.monitoring;

import com.google.crypto.tink.annotations.Alpha;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Alpha
/* loaded from: classes.dex */
public final class MonitoringAnnotations {
    public static final MonitoringAnnotations EMPTY = newBuilder().build();
    private final Map<String, String> entries;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Builder {
        private HashMap<String, String> builderEntries = new HashMap<>();

        public Builder add(String str, String str2) {
            HashMap<String, String> map = this.builderEntries;
            if (map != null) {
                map.put(str, str2);
                return this;
            }
            f.e("add cannot be called after build()");
            return null;
        }

        public Builder addAll(Map<String, String> map) {
            HashMap<String, String> map2 = this.builderEntries;
            if (map2 != null) {
                map2.putAll(map);
                return this;
            }
            f.e("addAll cannot be called after build()");
            return null;
        }

        public MonitoringAnnotations build() {
            if (this.builderEntries == null) {
                f.e("cannot call build() twice");
                return null;
            }
            MonitoringAnnotations monitoringAnnotations = new MonitoringAnnotations(Collections.unmodifiableMap(this.builderEntries));
            this.builderEntries = null;
            return monitoringAnnotations;
        }
    }

    private MonitoringAnnotations(Map<String, String> map) {
        this.entries = map;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (obj instanceof MonitoringAnnotations) {
            return this.entries.equals(((MonitoringAnnotations) obj).entries);
        }
        return false;
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public Map<String, String> toMap() {
        return this.entries;
    }

    public String toString() {
        return this.entries.toString();
    }
}
