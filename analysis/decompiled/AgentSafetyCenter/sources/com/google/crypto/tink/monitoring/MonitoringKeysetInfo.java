package com.google.crypto.tink.monitoring;

import b8.z;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.annotations.Alpha;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Alpha
/* loaded from: classes.dex */
public final class MonitoringKeysetInfo {
    private final MonitoringAnnotations annotations;
    private final List<Entry> entries;

    @Nullable
    private final Integer primaryKeyId;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Builder {

        @Nullable
        private ArrayList<Entry> builderEntries = new ArrayList<>();
        private MonitoringAnnotations builderAnnotations = MonitoringAnnotations.EMPTY;

        @Nullable
        private Integer builderPrimaryKeyId = null;

        private boolean isKeyIdInEntries(int i) {
            ArrayList<Entry> arrayList = this.builderEntries;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Entry entry = arrayList.get(i3);
                i3++;
                if (entry.getKeyId() == i) {
                    return true;
                }
            }
            return false;
        }

        public Builder addEntry(KeyStatus keyStatus, int i, String str, String str2) {
            ArrayList<Entry> arrayList = this.builderEntries;
            if (arrayList != null) {
                arrayList.add(new Entry(keyStatus, i, str, str2));
                return this;
            }
            f.e("addEntry cannot be called after build()");
            return null;
        }

        public MonitoringKeysetInfo build() throws GeneralSecurityException {
            if (this.builderEntries == null) {
                f.e("cannot call build() twice");
                return null;
            }
            Integer num = this.builderPrimaryKeyId;
            if (num != null && !isKeyIdInEntries(num.intValue())) {
                z.l("primary key ID is not present in entries");
                return null;
            }
            MonitoringKeysetInfo monitoringKeysetInfo = new MonitoringKeysetInfo(this.builderAnnotations, Collections.unmodifiableList(this.builderEntries), this.builderPrimaryKeyId);
            this.builderEntries = null;
            return monitoringKeysetInfo;
        }

        public Builder setAnnotations(MonitoringAnnotations monitoringAnnotations) {
            if (this.builderEntries != null) {
                this.builderAnnotations = monitoringAnnotations;
                return this;
            }
            f.e("setAnnotations cannot be called after build()");
            return null;
        }

        public Builder setPrimaryKeyId(int i) {
            if (this.builderEntries != null) {
                this.builderPrimaryKeyId = Integer.valueOf(i);
                return this;
            }
            f.e("setPrimaryKeyId cannot be called after build()");
            return null;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Entry {
        private final int keyId;
        private final String keyPrefix;
        private final String keyType;
        private final KeyStatus status;

        private Entry(KeyStatus keyStatus, int i, String str, String str2) {
            this.status = keyStatus;
            this.keyId = i;
            this.keyType = str;
            this.keyPrefix = str2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.status == entry.status && this.keyId == entry.keyId && this.keyType.equals(entry.keyType) && this.keyPrefix.equals(entry.keyPrefix);
        }

        public int getKeyId() {
            return this.keyId;
        }

        public String getKeyPrefix() {
            return this.keyPrefix;
        }

        public String getKeyType() {
            return this.keyType;
        }

        public KeyStatus getStatus() {
            return this.status;
        }

        public int hashCode() {
            return Objects.hash(this.status, Integer.valueOf(this.keyId), this.keyType, this.keyPrefix);
        }

        public String toString() {
            return "(status=" + this.status + ", keyId=" + this.keyId + ", keyType='" + this.keyType + "', keyPrefix='" + this.keyPrefix + "')";
        }
    }

    private MonitoringKeysetInfo(MonitoringAnnotations monitoringAnnotations, List<Entry> list, Integer num) {
        this.annotations = monitoringAnnotations;
        this.entries = list;
        this.primaryKeyId = num;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MonitoringKeysetInfo)) {
            return false;
        }
        MonitoringKeysetInfo monitoringKeysetInfo = (MonitoringKeysetInfo) obj;
        return this.annotations.equals(monitoringKeysetInfo.annotations) && this.entries.equals(monitoringKeysetInfo.entries) && Objects.equals(this.primaryKeyId, monitoringKeysetInfo.primaryKeyId);
    }

    public MonitoringAnnotations getAnnotations() {
        return this.annotations;
    }

    public List<Entry> getEntries() {
        return this.entries;
    }

    @Nullable
    public Integer getPrimaryKeyId() {
        return this.primaryKeyId;
    }

    public int hashCode() {
        return Objects.hash(this.annotations, this.entries);
    }

    public String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", this.annotations, this.entries, this.primaryKeyId);
    }
}
