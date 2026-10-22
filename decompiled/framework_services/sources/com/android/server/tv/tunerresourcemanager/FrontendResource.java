package com.android.server.tv.tunerresourcemanager;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class FrontendResource extends TunerResourceBasic {
    private final int mExclusiveGroupId;
    private Set<Long> mExclusiveGroupMemberHandles;
    private final int mType;

    public static class Builder extends TunerResourceBasic.Builder {
        private int mExclusiveGroupId;
        private int mType;

        /* JADX INFO: renamed from: -$$Nest$fgetmExclusiveGroupId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9002$$Nest$fgetmExclusiveGroupId(Builder r0) {
            return r0.mExclusiveGroupId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmType, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9003$$Nest$fgetmType(Builder r0) {
            return r0.mType;
        }

        @Override // com.android.server.tv.tunerresourcemanager.TunerResourceBasic.Builder
        public /* bridge */ /* synthetic */ TunerResourceBasic build() {
            return build();
        }

        Builder(long handle) {
            super(handle);
        }

        public Builder type(int type) {
            this.mType = type;
            return this;
        }

        public Builder exclusiveGroupId(int exclusiveGroupId) {
            this.mExclusiveGroupId = exclusiveGroupId;
            return this;
        }

        @Override // com.android.server.tv.tunerresourcemanager.TunerResourceBasic.Builder
        public FrontendResource build() {
            FrontendResource frontendResource = new FrontendResource(this, null);
            return frontendResource;
        }
    }

    /* synthetic */ FrontendResource(Builder r1, FrontendResourceIA r2) {
        this(r1);
    }

    private FrontendResource(Builder builder) {
        super(builder);
        this.mExclusiveGroupMemberHandles = new HashSet();
        this.mType = Builder.m9003$$Nest$fgetmType(builder);
        this.mExclusiveGroupId = Builder.m9002$$Nest$fgetmExclusiveGroupId(builder);
    }

    public int getType() {
        return this.mType;
    }

    public int getExclusiveGroupId() {
        return this.mExclusiveGroupId;
    }

    public Set<Long> getExclusiveGroupMemberFeHandles() {
        return this.mExclusiveGroupMemberHandles;
    }

    public void addExclusiveGroupMemberFeHandle(long handle) {
        this.mExclusiveGroupMemberHandles.add(Long.valueOf(handle));
    }

    public void addExclusiveGroupMemberFeHandles(Collection<Long> handles) {
        this.mExclusiveGroupMemberHandles.addAll(handles);
    }

    public void removeExclusiveGroupMemberFeId(long handle) {
        this.mExclusiveGroupMemberHandles.remove(Long.valueOf(handle));
    }

    public String toString() {
        return "FrontendResource[handle=" + this.mHandle + ", type=" + this.mType + ", exclusiveGId=" + this.mExclusiveGroupId + ", exclusiveGMemeberHandles=" + this.mExclusiveGroupMemberHandles + ", isInUse=" + this.mIsInUse + ", ownerClientId=" + this.mOwnerClientId + "]";
    }
}
