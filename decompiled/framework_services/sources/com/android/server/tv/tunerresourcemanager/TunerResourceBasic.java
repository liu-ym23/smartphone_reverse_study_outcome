package com.android.server.tv.tunerresourcemanager;

/* JADX INFO: loaded from: classes3.dex */
public class TunerResourceBasic {
    final long mHandle;
    boolean mIsInUse;
    int mOwnerClientId;

    public static class Builder {
        private final long mHandle;

        /* JADX INFO: renamed from: -$$Nest$fgetmHandle, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m9004$$Nest$fgetmHandle(Builder r2) {
            return r2.mHandle;
        }

        Builder(long handle) {
            this.mHandle = handle;
        }

        public TunerResourceBasic build() {
            TunerResourceBasic resource = new TunerResourceBasic(this);
            return resource;
        }
    }

    TunerResourceBasic(Builder builder) {
        this.mOwnerClientId = -1;
        this.mHandle = Builder.m9004$$Nest$fgetmHandle(builder);
    }

    public long getHandle() {
        return this.mHandle;
    }

    public boolean isInUse() {
        return this.mIsInUse;
    }

    public int getOwnerClientId() {
        return this.mOwnerClientId;
    }

    public void setOwner(int ownerClientId) {
        this.mIsInUse = true;
        this.mOwnerClientId = ownerClientId;
    }

    public void removeOwner() {
        this.mIsInUse = false;
        this.mOwnerClientId = -1;
    }
}
