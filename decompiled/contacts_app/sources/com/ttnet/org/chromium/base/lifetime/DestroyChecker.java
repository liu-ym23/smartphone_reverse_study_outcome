package com.ttnet.org.chromium.base.lifetime;

/* JADX INFO: loaded from: classes4.dex */
public class DestroyChecker implements Destroyable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean mIsDestroyed;

    static {
    }

    public void checkNotDestroyed() {
    }

    public DestroyChecker() {
    }

    @Override // com.ttnet.org.chromium.base.lifetime.Destroyable
    public void destroy() {
        checkNotDestroyed();
        this.mIsDestroyed = true;
    }

    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }
}
