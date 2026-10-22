package com.android.server.tv.tunerresourcemanager;

/* JADX INFO: loaded from: classes3.dex */
public final class CiCamResource extends CasResource {

    public static class Builder extends CasResource.Builder {
        @Override // com.android.server.tv.tunerresourcemanager.CasResource.Builder
        public /* bridge */ /* synthetic */ CasResource build() {
            return build();
        }

        @Override // com.android.server.tv.tunerresourcemanager.CasResource.Builder
        public /* bridge */ /* synthetic */ CasResource.Builder maxSessionNum(int r1) {
            return maxSessionNum(r1);
        }

        Builder(long handle, int systemId) {
            super(handle, systemId);
        }

        @Override // com.android.server.tv.tunerresourcemanager.CasResource.Builder
        public Builder maxSessionNum(int maxSessionNum) {
            this.mMaxSessionNum = maxSessionNum;
            return this;
        }

        @Override // com.android.server.tv.tunerresourcemanager.CasResource.Builder
        public CiCamResource build() {
            CiCamResource ciCam = new CiCamResource(this, null);
            return ciCam;
        }
    }

    /* synthetic */ CiCamResource(Builder r1, CiCamResourceIA r2) {
        this(r1);
    }

    private CiCamResource(Builder builder) {
        super(builder);
    }

    @Override // com.android.server.tv.tunerresourcemanager.CasResource
    public String toString() {
        return "CiCamResource[systemId=" + getSystemId() + ", isFullyUsed=" + isFullyUsed() + ", maxSessionNum=" + getMaxSessionNum() + ", ownerClients=" + ownersMapToString() + "]";
    }

    public int getCiCamId() {
        return getSystemId();
    }
}
