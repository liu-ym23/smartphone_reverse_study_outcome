package com.android.server.tv.tunerresourcemanager;

/* JADX INFO: loaded from: classes3.dex */
public final class LnbResource extends TunerResourceBasic {

    public static class Builder extends TunerResourceBasic.Builder {
        @Override // com.android.server.tv.tunerresourcemanager.TunerResourceBasic.Builder
        public /* bridge */ /* synthetic */ TunerResourceBasic build() {
            return build();
        }

        Builder(long handle) {
            super(handle);
        }

        @Override // com.android.server.tv.tunerresourcemanager.TunerResourceBasic.Builder
        public LnbResource build() {
            LnbResource lnb = new LnbResource(this, null);
            return lnb;
        }
    }

    /* synthetic */ LnbResource(Builder r1, LnbResourceIA r2) {
        this(r1);
    }

    private LnbResource(Builder builder) {
        super(builder);
    }

    public String toString() {
        return "LnbResource[handle=" + this.mHandle + ", isInUse=" + this.mIsInUse + ", ownerClientId=" + this.mOwnerClientId + "]";
    }
}
