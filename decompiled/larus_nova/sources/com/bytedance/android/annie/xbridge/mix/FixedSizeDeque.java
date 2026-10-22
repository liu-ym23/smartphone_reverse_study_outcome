package com.bytedance.android.annie.xbridge.mix;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/annie/xbridge/mix/FixedSizeDeque;", ExifInterface.LONGITUDE_EAST, "Ljava/util/LinkedList;", "maxSize", "", "removeAction", "Lkotlin/Function1;", "", "(ILkotlin/jvm/functions/Function1;)V", "add", "", "element", "(Ljava/lang/Object;)Z", "addLast", "(Ljava/lang/Object;)V", "annie_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class FixedSizeDeque<E> extends LinkedList<E> {
    private final int maxSize;
    private final Function1<E, Unit> removeAction;

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(E r100) {
        if (size() < this.maxSize) goto L8;
        E r101 = removeFirst();
        Function1<E, Unit> r102 = this.removeAction;
        if (r102 == null) goto L8;
        r102.invoke(r101);
    L8:
        return super.add(r100);
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void addLast(E r100) {
        if (size() < this.maxSize) goto L7;
        E r101 = removeFirst();
        Function1<E, Unit> r102 = this.removeAction;
        if (r102 == null) goto L7;
        r102.invoke(r101);
    L7:
        super.addLast(r100);
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int r100) {
        return (E) removeAt(r100);
    }

    public /* bridge */ Object removeAt(int r100) {
        return super.remove(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FixedSizeDeque(int r100, Function1<? super E, Unit> r101) {
        this.maxSize = r100;
        this.removeAction = r101;
    }
}
