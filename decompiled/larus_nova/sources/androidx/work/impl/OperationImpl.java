package androidx.work.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes17.dex */
public class OperationImpl implements Operation {
    private final SettableFuture<Operation.State.SUCCESS> mOperationFuture;
    private final MutableLiveData<Operation.State> mOperationState;

    public OperationImpl() {
        this.mOperationState = new MutableLiveData();
        this.mOperationFuture = SettableFuture.create();
        setState(Operation.IN_PROGRESS);
    }

    @Override // androidx.work.Operation
    public ListenableFuture<Operation.State.SUCCESS> getResult() {
        return this.mOperationFuture;
    }

    @Override // androidx.work.Operation
    public LiveData<Operation.State> getState() {
        return this.mOperationState;
    }

    public void setState(Operation.State r100) {
        this.mOperationState.postValue(r100);
        if ((r100 instanceof Operation.State.SUCCESS) == false) goto L6;
        this.mOperationFuture.set((Operation.State.SUCCESS) r100);
        return;
    L6:
        if ((r100 instanceof Operation.State.FAILURE) == false) goto L10;
        this.mOperationFuture.setException(((Operation.State.FAILURE) r100).getThrowable());
        return;
    }
}
