package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
class FragmentLifecycleCallbacksDispatcher {
    private final FragmentManager mFragmentManager;
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> mLifecycleCallbacks;

    /* JADX INFO: loaded from: classes17.dex */
    public static final class FragmentLifecycleCallbacksHolder {
        final FragmentManager.FragmentLifecycleCallbacks mCallback;
        final boolean mRecursive;

        public FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks r100, boolean r101) {
            this.mCallback = r100;
            this.mRecursive = r101;
        }
    }

    public FragmentLifecycleCallbacksDispatcher(FragmentManager r100) {
        this.mLifecycleCallbacks = new CopyOnWriteArrayList();
        this.mFragmentManager = r100;
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks r100) {
        CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> r101 = this.mLifecycleCallbacks;
        monitor-enter(r101);
        int r102 = this.mLifecycleCallbacks.size();     // Catch: Throwable -> L12
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        if (this.mLifecycleCallbacks.get(r103).mCallback == r100) goto L8;
        r103 = r103 + 1;     // Catch: Throwable -> L12
        goto L5
    L8:
        this.mLifecycleCallbacks.remove(r103);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void dispatchOnFragmentAttached(Fragment r100, boolean r101) {
        Context r102 = this.mFragmentManager.getHost().getContext();
        Fragment r103 = this.mFragmentManager.getParent();
        if (r103 == null) goto L5;
        r103.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentAttached(r100, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r104 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r104.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r105 = r104.next();
        if (r101 == false) goto L12;
        if (r105.mRecursive == false) goto L7;
    L12:
        r105.mCallback.onFragmentAttached(this.mFragmentManager, r100, r102);
        goto L7
    }

    public void dispatchOnFragmentDestroyed(Fragment r100, boolean r101) {
        Fragment r102 = this.mFragmentManager.getParent();
        if (r102 == null) goto L5;
        r102.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDestroyed(r100, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r103 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r104 = r103.next();
        if (r101 == false) goto L12;
        if (r104.mRecursive == false) goto L7;
    L12:
        r104.mCallback.onFragmentDestroyed(this.mFragmentManager, r100);
        goto L7
    }

    public void dispatchOnFragmentDetached(Fragment r100, boolean r101) {
        Fragment r102 = this.mFragmentManager.getParent();
        if (r102 == null) goto L5;
        r102.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDetached(r100, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r103 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r104 = r103.next();
        if (r101 == false) goto L12;
        if (r104.mRecursive == false) goto L7;
    L12:
        r104.mCallback.onFragmentDetached(this.mFragmentManager, r100);
        goto L7
    }

    public void dispatchOnFragmentPaused(Fragment r100, boolean r101) {
        Fragment r102 = this.mFragmentManager.getParent();
        if (r102 == null) goto L5;
        r102.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPaused(r100, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r103 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r104 = r103.next();
        if (r101 == false) goto L12;
        if (r104.mRecursive == false) goto L7;
    L12:
        r104.mCallback.onFragmentPaused(this.mFragmentManager, r100);
        goto L7
    }

    public void dispatchOnFragmentPreAttached(Fragment r100, boolean r101) {
        Context r102 = this.mFragmentManager.getHost().getContext();
        Fragment r103 = this.mFragmentManager.getParent();
        if (r103 == null) goto L5;
        r103.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreAttached(r100, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r104 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r104.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r105 = r104.next();
        if (r101 == false) goto L12;
        if (r105.mRecursive == false) goto L7;
    L12:
        r105.mCallback.onFragmentPreAttached(this.mFragmentManager, r100, r102);
        goto L7
    }

    public void dispatchOnFragmentResumed(Fragment r100, boolean r101) {
        Fragment r102 = this.mFragmentManager.getParent();
        if (r102 == null) goto L5;
        r102.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentResumed(r100, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r103 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r104 = r103.next();
        if (r101 == false) goto L12;
        if (r104.mRecursive == false) goto L7;
    L12:
        r104.mCallback.onFragmentResumed(this.mFragmentManager, r100);
        goto L7
    }

    public void dispatchOnFragmentStarted(Fragment r100, boolean r101) {
        Fragment r102 = this.mFragmentManager.getParent();
        if (r102 == null) goto L5;
        r102.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStarted(r100, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r103 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r104 = r103.next();
        if (r101 == false) goto L12;
        if (r104.mRecursive == false) goto L7;
    L12:
        r104.mCallback.onFragmentStarted(this.mFragmentManager, r100);
        goto L7
    }

    public void dispatchOnFragmentStopped(Fragment r100, boolean r101) {
        Fragment r102 = this.mFragmentManager.getParent();
        if (r102 == null) goto L5;
        r102.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStopped(r100, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r103 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r104 = r103.next();
        if (r101 == false) goto L12;
        if (r104.mRecursive == false) goto L7;
    L12:
        r104.mCallback.onFragmentStopped(this.mFragmentManager, r100);
        goto L7
    }

    public void dispatchOnFragmentViewDestroyed(Fragment r100, boolean r101) {
        Fragment r102 = this.mFragmentManager.getParent();
        if (r102 == null) goto L5;
        r102.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewDestroyed(r100, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r103 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r104 = r103.next();
        if (r101 == false) goto L12;
        if (r104.mRecursive == false) goto L7;
    L12:
        r104.mCallback.onFragmentViewDestroyed(this.mFragmentManager, r100);
        goto L7
    }

    public void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks r100, boolean r101) {
        this.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(r100, r101));
    }

    public void dispatchOnFragmentActivityCreated(Fragment r100, Bundle r101, boolean r102) {
        Fragment r103 = this.mFragmentManager.getParent();
        if (r103 == null) goto L5;
        r103.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentActivityCreated(r100, r101, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r104 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r104.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r105 = r104.next();
        if (r102 == false) goto L12;
        if (r105.mRecursive == false) goto L7;
    L12:
        r105.mCallback.onFragmentActivityCreated(this.mFragmentManager, r100, r101);
        goto L7
    }

    public void dispatchOnFragmentCreated(Fragment r100, Bundle r101, boolean r102) {
        Fragment r103 = this.mFragmentManager.getParent();
        if (r103 == null) goto L5;
        r103.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentCreated(r100, r101, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r104 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r104.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r105 = r104.next();
        if (r102 == false) goto L12;
        if (r105.mRecursive == false) goto L7;
    L12:
        r105.mCallback.onFragmentCreated(this.mFragmentManager, r100, r101);
        goto L7
    }

    public void dispatchOnFragmentPreCreated(Fragment r100, Bundle r101, boolean r102) {
        Fragment r103 = this.mFragmentManager.getParent();
        if (r103 == null) goto L5;
        r103.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreCreated(r100, r101, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r104 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r104.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r105 = r104.next();
        if (r102 == false) goto L12;
        if (r105.mRecursive == false) goto L7;
    L12:
        r105.mCallback.onFragmentPreCreated(this.mFragmentManager, r100, r101);
        goto L7
    }

    public void dispatchOnFragmentSaveInstanceState(Fragment r100, Bundle r101, boolean r102) {
        Fragment r103 = this.mFragmentManager.getParent();
        if (r103 == null) goto L5;
        r103.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentSaveInstanceState(r100, r101, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r104 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r104.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r105 = r104.next();
        if (r102 == false) goto L12;
        if (r105.mRecursive == false) goto L7;
    L12:
        r105.mCallback.onFragmentSaveInstanceState(this.mFragmentManager, r100, r101);
        goto L7
    }

    public void dispatchOnFragmentViewCreated(Fragment r100, View r101, Bundle r102, boolean r103) {
        Fragment r104 = this.mFragmentManager.getParent();
        if (r104 == null) goto L5;
        r104.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewCreated(r100, r101, r102, true);
    L5:
        Iterator<FragmentLifecycleCallbacksHolder> r105 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r105.hasNext() == false) goto L13;
        FragmentLifecycleCallbacksHolder r106 = r105.next();
        if (r103 == false) goto L12;
        if (r106.mRecursive == false) goto L7;
    L12:
        r106.mCallback.onFragmentViewCreated(this.mFragmentManager, r100, r101, r102);
        goto L7
    }
}
