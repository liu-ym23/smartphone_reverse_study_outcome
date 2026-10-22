package com.android.server.tv.tunerresourcemanager;

/* JADX INFO: loaded from: classes3.dex */
public final class DemuxResource extends TunerResourceBasic {
    private final int mFilterTypes;

    public static class Builder extends TunerResourceBasic.Builder {
        private int mFilterTypes;

        /* JADX INFO: renamed from: -$$Nest$fgetmFilterTypes, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9001$$Nest$fgetmFilterTypes(Builder r0) {
            return r0.mFilterTypes;
        }

        @Override // com.android.server.tv.tunerresourcemanager.TunerResourceBasic.Builder
        public /* bridge */ /* synthetic */ TunerResourceBasic build() {
            return build();
        }

        Builder(long handle) {
            super(handle);
        }

        public Builder filterTypes(int filterTypes) {
            this.mFilterTypes = filterTypes;
            return this;
        }

        @Override // com.android.server.tv.tunerresourcemanager.TunerResourceBasic.Builder
        public DemuxResource build() {
            DemuxResource demux = new DemuxResource(this, null);
            return demux;
        }
    }

    /* synthetic */ DemuxResource(Builder r1, DemuxResourceIA r2) {
        this(r1);
    }

    private DemuxResource(Builder builder) {
        super(builder);
        this.mFilterTypes = Builder.m9001$$Nest$fgetmFilterTypes(builder);
    }

    public int getFilterTypes() {
        return this.mFilterTypes;
    }

    public String toString() {
        return "DemuxResource[handle=" + this.mHandle + ", filterTypes=" + this.mFilterTypes + ", isInUse=" + this.mIsInUse + ", ownerClientId=" + this.mOwnerClientId + "]";
    }

    public boolean hasSufficientCaps(int desiredCaps) {
        if (desiredCaps != (this.mFilterTypes & desiredCaps)) goto L5;
        return true;
    L5:
        return false;
    }

    public int getNumOfCaps() {
        int mask = 1;
        int numOfCaps = 0;
        int i = 0;
    L4:
        if (i >= 32) goto L10;
        if ((this.mFilterTypes & mask) != mask) goto L8;
        numOfCaps = numOfCaps + 1;
    L8:
        mask = mask << 1;
        i = i + 1;
        goto L4
    L10:
        return numOfCaps;
    }
}
