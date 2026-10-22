package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes39.dex */
public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    private volatile Request error;
    private RequestCoordinator.RequestState errorState;
    private final RequestCoordinator parent;
    private volatile Request primary;
    private RequestCoordinator.RequestState primaryState;
    private final Object requestLock;

    private boolean parentCanNotifyCleared() {
        RequestCoordinator r100 = this.parent;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.canNotifyCleared(this) == true) goto L8;
        return false;
    }

    private boolean parentCanNotifyStatusChanged() {
        RequestCoordinator r100 = this.parent;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.canNotifyStatusChanged(this) == true) goto L8;
        return false;
    }

    private boolean parentCanSetImage() {
        RequestCoordinator r100 = this.parent;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.canSetImage(this) == true) goto L8;
        return false;
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        Object r100 = this.requestLock;
        monitor-enter(r100);
        RequestCoordinator.RequestState r101 = this.primaryState;     // Catch: Throwable -> L9
        RequestCoordinator.RequestState r102 = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L9
        if (r101 == r102) goto L7;
        this.primaryState = r102;     // Catch: Throwable -> L9
        this.primary.begin();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        Object r100 = this.requestLock;
        monitor-enter(r100);
        RequestCoordinator.RequestState r101 = RequestCoordinator.RequestState.CLEARED;     // Catch: Throwable -> L9
        this.primaryState = r101;     // Catch: Throwable -> L9
        this.primary.clear();     // Catch: Throwable -> L9
        if (this.errorState == r101) goto L7;
        this.errorState = r101;     // Catch: Throwable -> L9
        this.error.clear();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        Object r100 = this.requestLock;
        monitor-enter(r100);
        RequestCoordinator r101 = this.parent;     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        RequestCoordinator r102 = r101.getRoot();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r102;
    L7:
        r102 = this;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        Object r100 = this.requestLock;
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.primary.isAnyResourceSet() == false) goto L7;
    L10:
        boolean r101 = true;
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return r101;
    L7:
        if (this.error.isAnyResourceSet() == true) goto L10;
        r101 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        Object r100 = this.requestLock;
        monitor-enter(r100);
        RequestCoordinator.RequestState r101 = this.primaryState;     // Catch: Throwable -> L12
        RequestCoordinator.RequestState r102 = RequestCoordinator.RequestState.CLEARED;     // Catch: Throwable -> L12
        if (r101 == r102) goto L7;
    L9:
        boolean r103 = false;
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r103;
    L7:
        if (this.errorState != r102) goto L9;
        r103 = true;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        Object r100 = this.requestLock;
        monitor-enter(r100);
        RequestCoordinator.RequestState r101 = this.primaryState;     // Catch: Throwable -> L13
        RequestCoordinator.RequestState r102 = RequestCoordinator.RequestState.SUCCESS;     // Catch: Throwable -> L13
        if (r101 != r102) goto L7;
    L10:
        boolean r103 = true;
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return r103;
    L7:
        if (this.errorState == r102) goto L10;
        r103 = false;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        Object r100 = this.requestLock;
        monitor-enter(r100);
        RequestCoordinator.RequestState r101 = this.primaryState;     // Catch: Throwable -> L13
        RequestCoordinator.RequestState r102 = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L13
        if (r101 != r102) goto L7;
    L10:
        boolean r103 = true;
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return r103;
    L7:
        if (this.errorState == r102) goto L10;
        r103 = false;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        Object r100 = this.requestLock;
        monitor-enter(r100);
        RequestCoordinator.RequestState r101 = this.primaryState;     // Catch: Throwable -> L12
        RequestCoordinator.RequestState r102 = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L12
        if (r101 != r102) goto L8;
        this.primaryState = RequestCoordinator.RequestState.PAUSED;     // Catch: Throwable -> L12
        this.primary.pause();     // Catch: Throwable -> L12
    L8:
        if (this.errorState != r102) goto L10;
        this.errorState = RequestCoordinator.RequestState.PAUSED;     // Catch: Throwable -> L12
        this.error.pause();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private boolean isValidRequest(Request r100) {
        if (r100.equals(this.primary) == false) goto L5;
    L10:
        return true;
    L5:
        if (this.primaryState == RequestCoordinator.RequestState.FAILED) goto L7;
    L9:
        return false;
    L7:
        if (r100.equals(this.error) == false) goto L9;
        goto L9
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request r100) {
        Object r101 = this.requestLock;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (parentCanNotifyCleared() == true) goto L7;
    L9:
        boolean r102 = false;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L7:
        if (isValidRequest(r100) == false) goto L9;
        r102 = true;
        goto L10
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request r100) {
        Object r101 = this.requestLock;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (parentCanNotifyStatusChanged() == true) goto L7;
    L9:
        boolean r102 = false;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L7:
        if (isValidRequest(r100) == false) goto L9;
        r102 = true;
        goto L10
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request r100) {
        Object r101 = this.requestLock;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (parentCanSetImage() == true) goto L7;
    L9:
        boolean r102 = false;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L7:
        if (isValidRequest(r100) == false) goto L9;
        r102 = true;
        goto L10
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request r100) {
        if ((r100 instanceof ErrorRequestCoordinator) == false) goto L10;
        ErrorRequestCoordinator r101 = (ErrorRequestCoordinator) r100;
        if (this.primary.isEquivalentTo(r101.primary) == true) goto L7;
        return false;
    L7:
        if (this.error.isEquivalentTo(r101.error) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request r100) {
        Object r101 = this.requestLock;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r100.equals(this.error) == true) goto L11;
        this.primaryState = RequestCoordinator.RequestState.FAILED;     // Catch: Throwable -> L16
        RequestCoordinator.RequestState r102 = this.errorState;     // Catch: Throwable -> L16
        RequestCoordinator.RequestState r103 = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L16
        if (r102 == r103) goto L9;
        this.errorState = r103;     // Catch: Throwable -> L16
        this.error.begin();     // Catch: Throwable -> L16
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L11:
        this.errorState = RequestCoordinator.RequestState.FAILED;     // Catch: Throwable -> L16
        RequestCoordinator r104 = this.parent;     // Catch: Throwable -> L16
        if (r104 == null) goto L14;
        r104.onRequestFailed(this);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request r100) {
        Object r101 = this.requestLock;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r100.equals(this.primary) == false) goto L8;
        this.primaryState = RequestCoordinator.RequestState.SUCCESS;     // Catch: Throwable -> L15
    L10:
        RequestCoordinator r102 = this.parent;     // Catch: Throwable -> L15
        if (r102 == null) goto L13;
        r102.onRequestSuccess(this);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L8:
        if (r100.equals(this.error) == false) goto L10;
        this.errorState = RequestCoordinator.RequestState.SUCCESS;     // Catch: Throwable -> L15
        goto L10
    }

    public ErrorRequestCoordinator(Object r100, RequestCoordinator r101) {
        RequestCoordinator.RequestState r102 = RequestCoordinator.RequestState.CLEARED;
        this.primaryState = r102;
        this.errorState = r102;
        this.requestLock = r100;
        this.parent = r101;
    }

    public void setRequests(Request r100, Request r101) {
        this.primary = r100;
        this.error = r101;
    }
}
