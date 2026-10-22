package com.bytedance.android.livesdk.interactivity.common.utils;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0014J\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/utils/LimitQueue;", ExifInterface.LONGITUDE_EAST, "Ljava/util/LinkedList;", "limitSize", "", "(I)V", "getLimitSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "checkLimit", "", "offer", "e", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LimitQueue<E> extends LinkedList<E> {
    private final int limitSize;

    public void checkLimit() {
        if (size() <= this.limitSize) goto L6;
        poll();
        return;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }

    public final int getLimitSize() {
        return this.limitSize;
    }

    public LimitQueue(int r100) {
        this.limitSize = r100;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(E r100) {
        if (super.add(r100) == false) goto L6;
        checkLimit();
        return true;
    L6:
        return false;
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public boolean offer(E r100) {
        return add(r100);
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int r100) {
        return (E) removeAt(r100);
    }

    public /* bridge */ Object removeAt(int r100) {
        return super.remove(r100);
    }
}
