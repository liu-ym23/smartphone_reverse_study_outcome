package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes39.dex */
public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    private volatile Request full;
    private RequestCoordinator.RequestState fullState;
    private boolean isRunningDuringBegin;
    private final RequestCoordinator parent;
    private final Object requestLock;
    private volatile Request thumb;
    private RequestCoordinator.RequestState thumbState;

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
        this.isRunningDuringBegin = true;     // Catch: Throwable -> L23
    L20:
        th = move-exception;
        this.isRunningDuringBegin = false;     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L8:
        if (this.fullState == RequestCoordinator.RequestState.SUCCESS) goto L13;
        RequestCoordinator.RequestState r101 = this.thumbState;     // Catch: Throwable -> L20
        RequestCoordinator.RequestState r102 = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L20
        if (r101 == r102) goto L13;
        this.thumbState = r102;     // Catch: Throwable -> L20
        this.thumb.begin();     // Catch: Throwable -> L20
    L13:
        if (this.isRunningDuringBegin == false) goto L17;
        RequestCoordinator.RequestState r103 = this.fullState;     // Catch: Throwable -> L20
        RequestCoordinator.RequestState r104 = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L20
        if (r103 == r104) goto L17;
        this.fullState = r104;     // Catch: Throwable -> L20
        this.full.begin();     // Catch: Throwable -> L20
    L17:
        this.isRunningDuringBegin = false;     // Catch: Throwable -> L23
        monitor-exit(r100);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        Object r100 = this.requestLock;
        monitor-enter(r100);
        this.isRunningDuringBegin = false;     // Catch: Throwable -> L8
        RequestCoordinator.RequestState r101 = RequestCoordinator.RequestState.CLEARED;     // Catch: Throwable -> L8
        this.fullState = r101;     // Catch: Throwable -> L8
        this.thumbState = r101;     // Catch: Throwable -> L8
        this.thumb.clear();     // Catch: Throwable -> L8
        this.full.clear();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
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
        if (this.thumb.isAnyResourceSet() == false) goto L7;
    L10:
        boolean r101 = true;
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return r101;
    L7:
        if (this.full.isAnyResourceSet() == true) goto L10;
        r101 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        Object r100 = this.requestLock;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.fullState != RequestCoordinator.RequestState.CLEARED) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        Object r100 = this.requestLock;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.fullState != RequestCoordinator.RequestState.SUCCESS) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        Object r100 = this.requestLock;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.fullState != RequestCoordinator.RequestState.RUNNING) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        Object r100 = this.requestLock;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.thumbState.isComplete() == true) goto L8;
        this.thumbState = RequestCoordinator.RequestState.PAUSED;     // Catch: Throwable -> L12
        this.thumb.pause();     // Catch: Throwable -> L12
    L8:
        if (this.fullState.isComplete() == true) goto L10;
        this.fullState = RequestCoordinator.RequestState.PAUSED;     // Catch: Throwable -> L12
        this.full.pause();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyCleared(Request r100) {
        Object r101 = this.requestLock;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (parentCanNotifyCleared() == true) goto L7;
    L11:
        boolean r102 = false;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return r102;
    L7:
        if (r100.equals(this.full) == false) goto L11;
        if (this.fullState == RequestCoordinator.RequestState.PAUSED) goto L11;
        r102 = true;
        goto L12
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canNotifyStatusChanged(Request r100) {
        Object r101 = this.requestLock;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (parentCanNotifyStatusChanged() == true) goto L7;
    L11:
        boolean r102 = false;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return r102;
    L7:
        if (r100.equals(this.full) == false) goto L11;
        if (isAnyResourceSet() == true) goto L11;
        r102 = true;
        goto L12
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean canSetImage(Request r100) {
        Object r101 = this.requestLock;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (parentCanSetImage() == true) goto L7;
    L11:
        boolean r102 = false;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return r102;
    L7:
        if (r100.equals(this.full) == false) goto L9;
    L10:
        r102 = true;
        goto L12
    L9:
        if (this.fullState == RequestCoordinator.RequestState.SUCCESS) goto L11;
        goto L10
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request r100) {
        if ((r100 instanceof ThumbnailRequestCoordinator) == false) goto L20;
        ThumbnailRequestCoordinator r101 = (ThumbnailRequestCoordinator) r100;
        if (this.full != null) goto L10;
        if (r101.full == null) goto L12;
        return false;
    L12:
        if (this.thumb != null) goto L17;
        if (r101.thumb != null) goto L23;
    L18:
        return true;
    L23:
        return false;
    L17:
        if (this.thumb.isEquivalentTo(r101.thumb) == true) goto L18;
        return false;
    L10:
        if (this.full.isEquivalentTo(r101.full) == true) goto L12;
        return false;
    L20:
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestFailed(Request r100) {
        Object r101 = this.requestLock;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r100.equals(this.full) == true) goto L9;
        this.thumbState = RequestCoordinator.RequestState.FAILED;     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L9:
        this.fullState = RequestCoordinator.RequestState.FAILED;     // Catch: Throwable -> L14
        RequestCoordinator r102 = this.parent;     // Catch: Throwable -> L14
        if (r102 == null) goto L12;
        r102.onRequestFailed(this);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void onRequestSuccess(Request r100) {
        Object r101 = this.requestLock;
        monitor-enter(r101);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r100.equals(this.thumb) == false) goto L9;
        this.thumbState = RequestCoordinator.RequestState.SUCCESS;     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return;
    L9:
        this.fullState = RequestCoordinator.RequestState.SUCCESS;     // Catch: Throwable -> L17
        RequestCoordinator r102 = this.parent;     // Catch: Throwable -> L17
        if (r102 == null) goto L13;
        r102.onRequestSuccess(this);     // Catch: Throwable -> L17
    L13:
        if (this.thumbState.isComplete() == true) goto L15;
        this.thumb.clear();     // Catch: Throwable -> L17
    L15:
        monitor-exit(r101);     // Catch: Throwable -> L17
    }

    public ThumbnailRequestCoordinator(Object r100, RequestCoordinator r101) {
        RequestCoordinator.RequestState r102 = RequestCoordinator.RequestState.CLEARED;
        this.fullState = r102;
        this.thumbState = r102;
        this.requestLock = r100;
        this.parent = r101;
    }

    public void setRequests(Request r100, Request r101) {
        this.full = r100;
        this.thumb = r101;
    }
}
