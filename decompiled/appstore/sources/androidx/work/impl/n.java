package androidx.work.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public class n implements Operation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData f5748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.a f5749b;

    public n() {
        this.f5748a = new MutableLiveData();
        this.f5749b = androidx.work.impl.utils.futures.a.t();
        a(Operation.IN_PROGRESS);
    }

    public void a(Operation.b r10) {
        this.f5748a.m(r10);
        if ((r10 instanceof Operation.b.c) == false) goto L6;
        this.f5749b.p((Operation.b.c) r10);
        return;
    L6:
        if ((r10 instanceof Operation.b.a) == false) goto L10;
        this.f5749b.q(((Operation.b.a) r10).a());
        return;
    }

    @Override // androidx.work.Operation
    public ListenableFuture getResult() {
        return this.f5749b;
    }

    @Override // androidx.work.Operation
    public LiveData getState() {
        return this.f5748a;
    }
}
