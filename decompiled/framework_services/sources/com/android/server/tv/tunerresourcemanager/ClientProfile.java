package com.android.server.tv.tunerresourcemanager;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class ClientProfile {
    public static final int INVALID_GROUP_ID = -1;
    public static final int INVALID_RESOURCE_ID = -1;
    private int mGroupId;
    private final int mId;
    private boolean mIsPriorityOverwritten;
    private int mNiceValue;
    private long mPrimaryUsingFrontendHandle;
    private int mPriority;
    private final int mProcessId;
    private boolean mResourceOwnershipRetention;
    private Set<Integer> mShareFeClientIds;
    private Integer mShareeFeClientId;
    private final String mTvInputSessionId;
    private final int mUseCase;
    private int mUsingCasSystemId;
    private int mUsingCiCamId;
    private Set<Long> mUsingDemuxHandles;
    private Set<Long> mUsingFrontendHandles;
    private Set<Long> mUsingLnbHandles;

    public static class Builder {
        private final int mId;
        private int mProcessId;
        private boolean mResourceOwnershipRetention;
        private String mTvInputSessionId;
        private int mUseCase;

        /* JADX INFO: renamed from: -$$Nest$fgetmId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8996$$Nest$fgetmId(Builder r0) {
            return r0.mId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmProcessId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8997$$Nest$fgetmProcessId(Builder r0) {
            return r0.mProcessId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmResourceOwnershipRetention, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8998$$Nest$fgetmResourceOwnershipRetention(Builder r0) {
            return r0.mResourceOwnershipRetention;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTvInputSessionId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8999$$Nest$fgetmTvInputSessionId(Builder r0) {
            return r0.mTvInputSessionId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUseCase, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9000$$Nest$fgetmUseCase(Builder r0) {
            return r0.mUseCase;
        }

        Builder(int id) {
            this.mResourceOwnershipRetention = false;
            this.mId = id;
        }

        public Builder useCase(int useCase) {
            this.mUseCase = useCase;
            return this;
        }

        public Builder tvInputSessionId(String tvInputSessionId) {
            this.mTvInputSessionId = tvInputSessionId;
            return this;
        }

        public Builder processId(int processId) {
            this.mProcessId = processId;
            return this;
        }

        public Builder resourceOwnershipRetention(boolean enabled) {
            this.mResourceOwnershipRetention = enabled;
            return this;
        }

        public ClientProfile build() {
            ClientProfile clientProfile = new ClientProfile(this, null);
            return clientProfile;
        }
    }

    /* synthetic */ ClientProfile(Builder r1, ClientProfileIA r2) {
        this(r1);
    }

    private ClientProfile(Builder builder) {
        this.mGroupId = -1;
        this.mPrimaryUsingFrontendHandle = -1;
        this.mUsingFrontendHandles = new HashSet();
        this.mShareFeClientIds = new HashSet();
        this.mUsingDemuxHandles = new HashSet();
        this.mShareeFeClientId = -1;
        this.mUsingLnbHandles = new HashSet();
        this.mUsingCasSystemId = -1;
        this.mUsingCiCamId = -1;
        this.mIsPriorityOverwritten = false;
        this.mId = Builder.m8996$$Nest$fgetmId(builder);
        this.mTvInputSessionId = Builder.m8999$$Nest$fgetmTvInputSessionId(builder);
        this.mUseCase = Builder.m9000$$Nest$fgetmUseCase(builder);
        this.mProcessId = Builder.m8997$$Nest$fgetmProcessId(builder);
        this.mResourceOwnershipRetention = Builder.m8998$$Nest$fgetmResourceOwnershipRetention(builder);
    }

    public int getId() {
        return this.mId;
    }

    public String getTvInputSessionId() {
        return this.mTvInputSessionId;
    }

    public int getUseCase() {
        return this.mUseCase;
    }

    public int getProcessId() {
        return this.mProcessId;
    }

    public boolean resourceOwnershipRetentionEnabled() {
        return this.mResourceOwnershipRetention;
    }

    public boolean isPriorityOverwritten() {
        return this.mIsPriorityOverwritten;
    }

    public int getGroupId() {
        return this.mGroupId;
    }

    public int getPriority() {
        return this.mPriority - this.mNiceValue;
    }

    public void setGroupId(int groupId) {
        this.mGroupId = groupId;
    }

    public void setPriority(int priority) {
        if (priority >= 0) goto L4;
        return;
    L4:
        this.mPriority = priority;
    }

    public void overwritePriority(int priority) {
        if (priority >= 0) goto L4;
        return;
    L4:
        this.mIsPriorityOverwritten = true;
        this.mPriority = priority;
    }

    public void setNiceValue(int niceValue) {
        this.mNiceValue = niceValue;
    }

    public void setResourceOwnershipRetention(boolean enabled) {
        this.mResourceOwnershipRetention = enabled;
    }

    public void useFrontend(long frontendHandle) {
        this.mUsingFrontendHandles.add(Long.valueOf(frontendHandle));
    }

    public void setPrimaryFrontend(long frontendHandle) {
        this.mPrimaryUsingFrontendHandle = frontendHandle;
    }

    public long getPrimaryFrontend() {
        return this.mPrimaryUsingFrontendHandle;
    }

    public void shareFrontend(int clientId) {
        this.mShareFeClientIds.add(Integer.valueOf(clientId));
    }

    public void stopSharingFrontend(int clientId) {
        this.mShareFeClientIds.remove(Integer.valueOf(clientId));
    }

    public Set<Long> getInUseFrontendHandles() {
        return this.mUsingFrontendHandles;
    }

    public Set<Integer> getShareFeClientIds() {
        return this.mShareFeClientIds;
    }

    public Integer getShareeFeClientId() {
        return this.mShareeFeClientId;
    }

    public void setShareeFeClientId(Integer shareeFeClientId) {
        this.mShareeFeClientId = shareeFeClientId;
    }

    public void releaseFrontend() {
        this.mUsingFrontendHandles.clear();
        this.mShareFeClientIds.clear();
        this.mShareeFeClientId = -1;
        this.mPrimaryUsingFrontendHandle = -1;
    }

    public void useDemux(long demuxHandle) {
        this.mUsingDemuxHandles.add(Long.valueOf(demuxHandle));
    }

    public Set<Long> getInUseDemuxHandles() {
        return this.mUsingDemuxHandles;
    }

    public void releaseDemux(long demuxHandle) {
        this.mUsingDemuxHandles.remove(Long.valueOf(demuxHandle));
    }

    public void useLnb(long lnbHandle) {
        this.mUsingLnbHandles.add(Long.valueOf(lnbHandle));
    }

    public Set<Long> getInUseLnbHandles() {
        return this.mUsingLnbHandles;
    }

    public void releaseLnb(long lnbHandle) {
        this.mUsingLnbHandles.remove(Long.valueOf(lnbHandle));
    }

    public void useCas(int casSystemId) {
        this.mUsingCasSystemId = casSystemId;
    }

    public int getInUseCasSystemId() {
        return this.mUsingCasSystemId;
    }

    public void releaseCas() {
        this.mUsingCasSystemId = -1;
    }

    public void useCiCam(int ciCamId) {
        this.mUsingCiCamId = ciCamId;
    }

    public int getInUseCiCamId() {
        return this.mUsingCiCamId;
    }

    public void releaseCiCam() {
        this.mUsingCiCamId = -1;
    }

    public void reclaimAllResources() {
        this.mUsingFrontendHandles.clear();
        this.mShareFeClientIds.clear();
        this.mPrimaryUsingFrontendHandle = -1;
        this.mUsingLnbHandles.clear();
        this.mUsingCasSystemId = -1;
        this.mUsingCiCamId = -1;
    }

    public String toString() {
        return "ClientProfile[id=" + this.mId + ", tvInputSessionId=" + this.mTvInputSessionId + ", useCase=" + this.mUseCase + ", processId=" + this.mProcessId + "]";
    }
}
