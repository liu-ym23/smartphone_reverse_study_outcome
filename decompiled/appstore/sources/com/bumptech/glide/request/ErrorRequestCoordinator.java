package com.bumptech.glide.request;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    private Request error;

    @Nullable
    private final RequestCoordinator parent;
    private Request primary;

    public ErrorRequestCoordinator(@Nullable RequestCoordinator r10) {
        this.parent = r10;
    }

    private boolean isValidRequest(Request r10) {
        if (r10.equals(this.primary) == false) goto L5;
    L10:
        return true;
    L5:
        if (this.primary.isFailed() == true) goto L7;
    L9:
        return false;
    L7:
        if (r10.equals(this.error) == false) goto L9;
        goto L9
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
        if (this.primary.isRunning() == true) goto L6;
        this.primary.begin();
        return;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request r10) {
        if (parentCanNotifyCleared() == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidRequest(r10) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request r10) {
        if (parentCanNotifyStatusChanged() == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidRequest(r10) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request r10) {
        if (parentCanSetImage() == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidRequest(r10) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        this.primary.clear();
        if (this.error.isRunning() == false) goto L6;
        this.error.clear();
        return;
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
        if (this.primary.isFailed() == false) goto L6;
        Request r10 = this.error;
    L7:
        return r10.isCleared();
    L6:
        r10 = this.primary;
        goto L7
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        if (this.primary.isFailed() == false) goto L6;
        Request r10 = this.error;
    L7:
        return r10.isComplete();
    L6:
        r10 = this.primary;
        goto L7
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request r10) {
        if ((r10 instanceof ErrorRequestCoordinator) == false) goto L10;
        ErrorRequestCoordinator r11 = (ErrorRequestCoordinator) r10;
        if (this.primary.isEquivalentTo(r11.primary) == true) goto L7;
        return false;
    L7:
        if (this.error.isEquivalentTo(r11.error) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isFailed() {
        if (this.primary.isFailed() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.error.isFailed() == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isResourceSet() {
        if (this.primary.isFailed() == false) goto L6;
        Request r10 = this.error;
    L7:
        return r10.isResourceSet();
    L6:
        r10 = this.primary;
        goto L7
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        if (this.primary.isFailed() == false) goto L6;
        Request r10 = this.error;
    L7:
        return r10.isRunning();
    L6:
        r10 = this.primary;
        goto L7
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request r10) {
        if (r10.equals(this.error) == false) goto L5;
        RequestCoordinator r11 = this.parent;
        if (r11 == null) goto L13;
        r11.onRequestFailed(this);
        return;
    L13:
        return;
    L5:
        if (this.error.isRunning() == true) goto L12;
        this.error.begin();
        return;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request r10) {
        RequestCoordinator r11 = this.parent;
        if (r11 == null) goto L6;
        r11.onRequestSuccess(this);
        return;
    }

    @Override // com.bumptech.glide.request.Request
    public void recycle() {
        this.primary.recycle();
        this.error.recycle();
    }

    public void setRequests(Request r10, Request r11) {
        this.primary = r10;
        this.error = r11;
    }
}
