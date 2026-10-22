package com.android.server.textclassifier;

import com.android.internal.util.Preconditions;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public final class FixedSizeQueue<E> {
    private final Queue<E> mDelegate;
    private final int mMaxSize;
    private final OnEntryEvictedListener<E> mOnEntryEvictedListener;

    public interface OnEntryEvictedListener<E> {
        void onEntryEvicted(E r1);
    }

    public FixedSizeQueue(int maxSize, OnEntryEvictedListener<E> onEntryEvictedListener) {
        if (maxSize <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "maxSize (%s) must > 0", new Object[]{Integer.valueOf(maxSize)});
        this.mDelegate = new ArrayDeque(maxSize);
        this.mMaxSize = maxSize;
        this.mOnEntryEvictedListener = onEntryEvictedListener;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public int size() {
        return this.mDelegate.size();
    }

    public boolean add(E element) {
        element.getClass();
        if (size() != this.mMaxSize) goto L7;
        E removed = this.mDelegate.remove();
        if (this.mOnEntryEvictedListener == null) goto L7;
        this.mOnEntryEvictedListener.onEntryEvicted(removed);
    L7:
        this.mDelegate.add(element);
        return true;
    }

    public E poll() {
        return this.mDelegate.poll();
    }

    public boolean remove(E element) {
        element.getClass();
        return this.mDelegate.remove(element);
    }

    public boolean isEmpty() {
        return this.mDelegate.isEmpty();
    }
}
