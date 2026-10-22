package com.tmall.wireless.tangram.dataparser.concrete;

import com.tmall.wireless.tangram.TangramBuilder;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ComponentLifecycle {
    public boolean mIsActivated;

    public ComponentLifecycle() {
        this.mIsActivated = false;
    }

    public void added() {
        if (this.mIsActivated == true) goto L5;
    L9:
        this.mIsActivated = true;
        onAdded();
        return;
    L5:
        if (TangramBuilder.isPrintLog() == false) goto L9;
        throw new IllegalStateException("Component can not be added more than once");
    }

    public void onAdded() {
    }

    public void onRemoved() {
    }

    public void removed() {
        if (this.mIsActivated == false) goto L5;
    L9:
        this.mIsActivated = false;
        onRemoved();
        return;
    L5:
        if (TangramBuilder.isPrintLog() == false) goto L9;
        throw new IllegalStateException("Component can not be removed more than once");
    }
}
