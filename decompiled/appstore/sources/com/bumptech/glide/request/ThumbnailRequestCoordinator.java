package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    private Request full;
    private boolean isRunning;

    @Nullable
    private final RequestCoordinator parent;
    private Request thumb;

    @VisibleForTesting
    public ThumbnailRequestCoordinator() {
        this(null);
    }

    private boolean parentCanNotifyCleared() {
        RequestCoordinator r10 = this.parent;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.canNotifyCleared(this) == true) goto L8;
        return false;
    }

    private boolean parentCanNotifyStatusChanged() {
        RequestCoordinator r10 = this.parent;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.canNotifyStatusChanged(this) == true) goto L8;
        return false;
    }

    private boolean parentCanSetImage() {
        RequestCoordinator r10 = this.parent;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.canSetImage(this) == true) goto L8;
        return false;
    }

    private boolean parentIsAnyResourceSet() {
        RequestCoordinator r10 = this.parent;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isAnyResourceSet() == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        this.isRunning = true;
        if (this.full.isComplete() == true) goto L8;
        if (this.thumb.isRunning() == true) goto L8;
        this.thumb.begin();
    L8:
        if (this.isRunning == true) goto L10;
        return;
    L10:
        if (this.full.isRunning() == true) goto L14;
        this.full.begin();
        return;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request r10) {
        if (parentCanNotifyCleared() == true) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(this.full) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request r10) {
        if (parentCanNotifyStatusChanged() == true) goto L5;
    L9:
        return false;
    L5:
        if (r10.equals(this.full) == false) goto L9;
        if (isAnyResourceSet() == true) goto L9;
        return true;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request r10) {
        if (parentCanSetImage() == true) goto L5;
    L9:
        return false;
    L5:
        if (r10.equals(this.full) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.full.isResourceSet() == true) goto L9;
        goto L8
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        this.isRunning = false;
        this.thumb.clear();
        this.full.clear();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean isAnyResourceSet() {
        if (parentIsAnyResourceSet() == false) goto L5;
    L8:
        return true;
    L5:
        if (isResourceSet() == true) goto L8;
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        return this.full.isCleared();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        if (this.full.isComplete() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.thumb.isComplete() == true) goto L8;
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request r10) {
        if ((r10 instanceof ThumbnailRequestCoordinator) == false) goto L20;
        ThumbnailRequestCoordinator r11 = (ThumbnailRequestCoordinator) r10;
        Request r12 = this.full;
        if (r12 != null) goto L10;
        if (r11.full != null) goto L21;
    L11:
        Request r13 = this.thumb;
        if (r13 != null) goto L17;
        if (r11.thumb != null) goto L23;
    L18:
        return true;
    L23:
        return false;
    L17:
        if (r13.isEquivalentTo(r11.thumb) == true) goto L18;
        return false;
    L21:
        return false;
    L10:
        if (r12.isEquivalentTo(r11.full) == true) goto L11;
        return false;
    L20:
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isFailed() {
        return this.full.isFailed();
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isResourceSet() {
        if (this.full.isResourceSet() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.thumb.isResourceSet() == true) goto L8;
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        return this.full.isRunning();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request r10) {
        if (r10.equals(this.full) == true) goto L5;
        return;
    L5:
        RequestCoordinator r11 = this.parent;
        if (r11 == null) goto L9;
        r11.onRequestFailed(this);
        return;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request r10) {
        if (r10.equals(this.thumb) == false) goto L5;
        return;
    L5:
        RequestCoordinator r11 = this.parent;
        if (r11 == null) goto L9;
        r11.onRequestSuccess(this);
    L9:
        if (this.thumb.isComplete() == true) goto L12;
        this.thumb.clear();
        return;
    }

    @Override // com.bumptech.glide.request.Request
    public void recycle() {
        this.full.recycle();
        this.thumb.recycle();
    }

    public void setRequests(Request r10, Request r11) {
        this.full = r10;
        this.thumb = r11;
    }

    public ThumbnailRequestCoordinator(@Nullable RequestCoordinator r10) {
        this.parent = r10;
    }
}
