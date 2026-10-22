package com.ttnet.org.chromium.base.supplier;

import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.Promise;
import com.ttnet.org.chromium.base.ThreadUtils;

/* JADX INFO: loaded from: classes4.dex */
public class OneshotSupplierImpl<T> implements OneshotSupplier<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Promise<T> mPromise;
    private final ThreadUtils.ThreadChecker mThreadChecker;

    static {
    }

    public OneshotSupplierImpl() {
        this.mPromise = new Promise();
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
    }

    @Override // com.ttnet.org.chromium.base.supplier.OneshotSupplier
    public T onAvailable(Callback<T> r2) {
        this.mThreadChecker.assertOnValidThread();
        this.mPromise.then(r2);
        return get();
    }

    @Override // com.ttnet.org.chromium.base.supplier.Supplier
    public T get() {
        this.mThreadChecker.assertOnValidThread();
        if (this.mPromise.isFulfilled() == true) goto L7;
        return null;
    L7:
        return this.mPromise.getResult();
    }

    public void set(T r2) {
        this.mThreadChecker.assertOnValidThread();
        this.mPromise.fulfill(r2);
    }
}
