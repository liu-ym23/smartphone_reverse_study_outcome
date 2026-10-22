package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import com.ttnet.org.chromium.base.lifetime.DestroyChecker;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class UnownedUserDataHost {
    private final DestroyChecker mDestroyChecker;
    private Handler mHandler;
    private final ThreadUtils.ThreadChecker mThreadChecker;
    private HashMap<UnownedUserDataKey<?>, WeakReference<? extends UnownedUserData>> mUnownedUserDataMap;

    private static Looper retrieveNonNullLooperOrThrow() {
        Looper r0 = Looper.myLooper();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException();
    }

    public UnownedUserDataHost() {
        this(new Handler(retrieveNonNullLooperOrThrow()));
    }

    UnownedUserDataHost(Handler r2) {
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
        this.mDestroyChecker = new DestroyChecker();
        this.mUnownedUserDataMap = new HashMap();
        this.mHandler = r2;
    }

    <T extends UnownedUserData> void set(UnownedUserDataKey<T> r2, T r3) {
        checkState();
        if (this.mUnownedUserDataMap.containsKey(r2) == true) goto L5;
    L7:
        this.mUnownedUserDataMap.put(r2, new WeakReference(r3));
        return;
    L5:
        if (r3.equals(get(r2)) == true) goto L7;
        r2.detachFromHost(this);
        goto L7
    }

    <T extends UnownedUserData> T get(UnownedUserDataKey<T> r3) {
        checkState();
        WeakReference<? extends UnownedUserData> r0 = this.mUnownedUserDataMap.get(r3);
        if (r0 != null) goto L5;
        return null;
    L5:
        UnownedUserData r1 = r0.get();
        if (r1 != null) goto L10;
        r3.detachFromHost(this);
        return null;
    L10:
        return r3.getValueClass().cast(r1);
    }

    <T extends UnownedUserData> void remove(UnownedUserDataKey<T> r3) {
        checkState();
        WeakReference<? extends UnownedUserData> r4 = this.mUnownedUserDataMap.remove(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        final UnownedUserData r5 = r4.get();
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.informOnDetachmentFromHost() == false) goto L12;
        this.mHandler.post(new UnownedUserDataHost$$ExternalSyntheticLambda0(this, r5));
        return;
    }

    /* JADX INFO: renamed from: lambda$remove$0$com-ttnet-org-chromium-base-UnownedUserDataHost, reason: not valid java name */
    /* synthetic */ void m792lambda$remove$0$comttnetorgchromiumbaseUnownedUserDataHost(UnownedUserData r1) {
        r1.onDetachedFromHost(this);
    }

    public void destroy() {
        this.mThreadChecker.assertOnValidThread();
        if (this.mDestroyChecker.isDestroyed() == false) goto L5;
        return;
    L5:
        Iterator r0 = new HashSet(this.mUnownedUserDataMap.keySet()).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((UnownedUserDataKey) r0.next()).detachFromHost(this);
        goto L7
    L9:
        this.mUnownedUserDataMap = null;
        this.mHandler = null;
        this.mDestroyChecker.destroy();
    }

    int getMapSize() {
        checkState();
        return this.mUnownedUserDataMap.size();
    }

    boolean isDestroyed() {
        return this.mDestroyChecker.isDestroyed();
    }

    private void checkState() {
        this.mThreadChecker.assertOnValidThread();
        this.mDestroyChecker.checkNotDestroyed();
    }
}
