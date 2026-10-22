package com.facebook.rebound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationQueue {
    private final Queue<Double> mAnimationQueue;
    private final List<Callback> mCallbacks;
    private final ChoreographerCompat mChoreographer;
    private final ChoreographerCompat.FrameCallback mChoreographerCallback;
    private final Queue<Double> mPendingQueue;
    private boolean mRunning;
    private final ArrayList<Double> mTempValues;

    public interface Callback {
        void onFrame(Double r10);
    }

    public AnimationQueue() {
        this.mPendingQueue = new LinkedList();
        this.mAnimationQueue = new LinkedList();
        this.mCallbacks = new ArrayList();
        this.mTempValues = new ArrayList();
        this.mChoreographer = ChoreographerCompat.getInstance();
        this.mChoreographerCallback = new AnonymousClass1(this);
    }

    public static /* synthetic */ void access$000(AnimationQueue r10, long r11) {
        r10.onFrame(r11);
    }

    private void onFrame(long r10) {
        Double r11 = this.mPendingQueue.poll();
        if (r11 == null) goto L5;
        this.mAnimationQueue.offer(r11);
        int r12 = 0;
    L6:
        this.mTempValues.addAll(this.mAnimationQueue);
        int r13 = this.mTempValues.size();
    L7:
        r13 = r13 - 1;
        if (r13 <= (-1)) goto L13;
        Double r14 = this.mTempValues.get(r13);
        int r15 = ((this.mTempValues.size() - 1) - r13) + r12;
        if (this.mCallbacks.size() <= r15) goto L7;
        this.mCallbacks.get(r15).onFrame(r14);
        goto L7
    L13:
        this.mTempValues.clear();
    L15:
        if ((this.mAnimationQueue.size() + r12) < this.mCallbacks.size()) goto L18;
        this.mAnimationQueue.poll();
        goto L15
    L18:
        if (this.mAnimationQueue.isEmpty() == true) goto L20;
    L22:
        this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        return;
    L20:
        if (this.mPendingQueue.isEmpty() == false) goto L22;
        this.mRunning = false;
        return;
    L5:
        r12 = Math.max(this.mCallbacks.size() - this.mAnimationQueue.size(), 0);
        goto L6
    }

    private void runIfIdle() {
        if (this.mRunning == true) goto L6;
        this.mRunning = true;
        this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        return;
    }

    public void addAllValues(Collection<Double> r10) {
        this.mPendingQueue.addAll(r10);
        runIfIdle();
    }

    public void addCallback(Callback r10) {
        this.mCallbacks.add(r10);
    }

    public void addValue(Double r10) {
        this.mPendingQueue.add(r10);
        runIfIdle();
    }

    public void clearCallbacks() {
        this.mCallbacks.clear();
    }

    public void clearValues() {
        this.mPendingQueue.clear();
    }

    public void removeCallback(Callback r10) {
        this.mCallbacks.remove(r10);
    }
}
