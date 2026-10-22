package androidx.work;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes17.dex */
public final class WorkQuery {
    private final List<UUID> mIds;
    private final List<WorkInfo.State> mStates;
    private final List<String> mTags;
    private final List<String> mUniqueWorkNames;

    public static final class Builder {
        List<UUID> mIds;
        List<WorkInfo.State> mStates;
        List<String> mTags;
        List<String> mUniqueWorkNames;

        public WorkQuery build() {
            if (this.mIds.isEmpty() == false) goto L14;
            if (this.mUniqueWorkNames.isEmpty() == false) goto L14;
            if (this.mTags.isEmpty() == false) goto L14;
            if (this.mStates.isEmpty() == false) goto L14;
            throw new IllegalArgumentException("Must specify ids, uniqueNames, tags or states when building a WorkQuery");
        L14:
            return new WorkQuery(this);
        }

        private Builder() {
            this.mIds = new ArrayList();
            this.mUniqueWorkNames = new ArrayList();
            this.mTags = new ArrayList();
            this.mStates = new ArrayList();
        }

        public static Builder fromIds(List<UUID> r100) {
            Builder r101 = new Builder();
            r101.addIds(r100);
            return r101;
        }

        public static Builder fromStates(List<WorkInfo.State> r100) {
            Builder r101 = new Builder();
            r101.addStates(r100);
            return r101;
        }

        public static Builder fromTags(List<String> r100) {
            Builder r101 = new Builder();
            r101.addTags(r100);
            return r101;
        }

        public static Builder fromUniqueWorkNames(List<String> r100) {
            Builder r101 = new Builder();
            r101.addUniqueWorkNames(r100);
            return r101;
        }

        public Builder addIds(List<UUID> r100) {
            this.mIds.addAll(r100);
            return this;
        }

        public Builder addStates(List<WorkInfo.State> r100) {
            this.mStates.addAll(r100);
            return this;
        }

        public Builder addTags(List<String> r100) {
            this.mTags.addAll(r100);
            return this;
        }

        public Builder addUniqueWorkNames(List<String> r100) {
            this.mUniqueWorkNames.addAll(r100);
            return this;
        }
    }

    public List<UUID> getIds() {
        return this.mIds;
    }

    public List<WorkInfo.State> getStates() {
        return this.mStates;
    }

    public List<String> getTags() {
        return this.mTags;
    }

    public List<String> getUniqueWorkNames() {
        return this.mUniqueWorkNames;
    }

    public WorkQuery(Builder r100) {
        this.mIds = r100.mIds;
        this.mUniqueWorkNames = r100.mUniqueWorkNames;
        this.mTags = r100.mTags;
        this.mStates = r100.mStates;
    }
}
