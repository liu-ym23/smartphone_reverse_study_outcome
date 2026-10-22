package androidx.appsearch.app;

import android.annotation.SuppressLint;
import androidx.appsearch.annotation.CanIgnoreReturnValue;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
/* loaded from: classes.dex */
public class SetBlobVisibilityRequest {
    private final Set<String> mNamespacesNotDisplayedBySystem;
    private final Map<String, Set<SchemaVisibilityConfig>> mNamespacesVisibleToConfigs;

    public static final class Builder {
        private final ArrayMap<String, Set<SchemaVisibilityConfig>> mNamespacesVisibleToConfigs = new ArrayMap<>();
        private final ArraySet<String> mNamespacesNotDisplayedBySystem = new ArraySet<>();

        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addNamespaceVisibleToConfig(String str, SchemaVisibilityConfig schemaVisibilityConfig) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(schemaVisibilityConfig);
            Set<SchemaVisibilityConfig> arraySet = this.mNamespacesVisibleToConfigs.get(str);
            if (arraySet == null) {
                arraySet = new ArraySet<>();
                this.mNamespacesVisibleToConfigs.put(str, arraySet);
            }
            arraySet.add(schemaVisibilityConfig);
            return this;
        }

        public SetBlobVisibilityRequest build() {
            return new SetBlobVisibilityRequest(new ArraySet((ArraySet) this.mNamespacesNotDisplayedBySystem), new ArrayMap(this.mNamespacesVisibleToConfigs));
        }

        @CanIgnoreReturnValue
        public Builder clearNamespaceVisibleToConfigs(String str) {
            Preconditions.checkNotNull(str);
            this.mNamespacesVisibleToConfigs.remove(str);
            return this;
        }

        @CanIgnoreReturnValue
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setNamespaceDisplayedBySystem(String str, boolean z10) {
            Preconditions.checkNotNull(str);
            if (z10) {
                this.mNamespacesNotDisplayedBySystem.remove(str);
                return this;
            }
            this.mNamespacesNotDisplayedBySystem.add(str);
            return this;
        }
    }

    public SetBlobVisibilityRequest(Set<String> set, Map<String, Set<SchemaVisibilityConfig>> map) {
        this.mNamespacesNotDisplayedBySystem = (Set) Preconditions.checkNotNull(set);
        this.mNamespacesVisibleToConfigs = (Map) Preconditions.checkNotNull(map);
    }

    public Set<String> getNamespacesNotDisplayedBySystem() {
        return Collections.unmodifiableSet(this.mNamespacesNotDisplayedBySystem);
    }

    public Map<String, Set<SchemaVisibilityConfig>> getNamespacesVisibleToConfigs() {
        return Collections.unmodifiableMap(this.mNamespacesVisibleToConfigs);
    }
}
