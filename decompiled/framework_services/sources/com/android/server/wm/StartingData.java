package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StartingData {
    static final int AFTER_TRANSACTION_COPY_TO_CLIENT = 2;
    static final int AFTER_TRANSACTION_IDLE = 0;
    static final int AFTER_TRANSACTION_REMOVE_DIRECTLY = 1;
    static final int AFTER_TRANSITION_FINISH = 3;
    Task mAssociatedTask;
    boolean mIsDisplayed;
    boolean mIsTransitionForward;
    boolean mPrepareRemoveAnimation;
    int mRemoveAfterTransaction;
    boolean mResizedFromTransfer;
    protected final WindowManagerService mService;
    int mTransitionId;
    protected final int mTypeParams;

    @interface AfterTransaction {
    }

    abstract StartingSurfaceController.StartingSurface createStartingSurface(ActivityRecord r1);

    abstract boolean needRevealAnimation();

    protected StartingData(WindowManagerService service, int typeParams) {
        this.mRemoveAfterTransaction = 0;
        this.mService = service;
        this.mTypeParams = typeParams;
    }

    boolean hasImeSurface() {
        return false;
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + Integer.toHexString(System.identityHashCode(this)) + " removeAfterTransaction= " + this.mRemoveAfterTransaction + "}";
    }
}
