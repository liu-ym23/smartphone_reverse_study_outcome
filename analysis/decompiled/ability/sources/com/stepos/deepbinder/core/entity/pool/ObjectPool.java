package com.stepos.deepbinder.core.entity.pool;

import S7.a;
import S7.k;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0016\u0018\u0000  *\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001 B7\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\"\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001d¨\u0006!"}, d2 = {"Lcom/stepos/deepbinder/core/entity/pool/ObjectPool;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "maxSize", "Lkotlin/Function0;", "creator", "Lkotlin/Function1;", "LC7/r;", "reset", AppAgent.CONSTRUCT, "(ILS7/a;LS7/k;)V", "borrowObject", "()Ljava/lang/Object;", "obj", "returnObject", "(Ljava/lang/Object;)V", "clear", "()V", "size", "()I", "I", "LS7/a;", "LS7/k;", "Ljava/util/ArrayDeque;", "availableObjects", "Ljava/util/ArrayDeque;", "", "borrowCount", "J", "returnCount", "createCount", "Companion", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ObjectPool<T> {
    public static final int DEFAULT_MAX_SIZE = 100;
    private final ArrayDeque<T> availableObjects;
    private volatile long borrowCount;
    private volatile long createCount;
    private final a creator;
    private final int maxSize;
    private final k reset;
    private volatile long returnCount;

    public ObjectPool(int i, a creator, k kVar) {
        kotlin.jvm.internal.k.f(creator, "creator");
        this.maxSize = i;
        this.creator = creator;
        this.reset = kVar;
        this.availableObjects = new ArrayDeque<>(i);
    }

    public final T borrowObject() {
        T tRemoveLast;
        synchronized (this.availableObjects) {
            tRemoveLast = this.availableObjects.isEmpty() ? null : this.availableObjects.removeLast();
        }
        this.borrowCount++;
        if (tRemoveLast != null) {
            return tRemoveLast;
        }
        this.createCount++;
        return (T) this.creator.invoke();
    }

    public final void clear() {
        synchronized (this.availableObjects) {
            this.availableObjects.clear();
        }
    }

    public final void returnObject(T obj) {
        if (obj == null) {
            return;
        }
        k kVar = this.reset;
        if (kVar != null) {
            kVar.invoke(obj);
        }
        synchronized (this.availableObjects) {
            if (this.availableObjects.size() < this.maxSize) {
                this.availableObjects.addLast(obj);
                this.returnCount++;
            }
        }
    }

    public final int size() {
        int size;
        synchronized (this.availableObjects) {
            size = this.availableObjects.size();
        }
        return size;
    }

    public /* synthetic */ ObjectPool(int i, a aVar, k kVar, int i6, e eVar) {
        this((i6 & 1) != 0 ? 100 : i, aVar, (i6 & 4) != 0 ? null : kVar);
    }
}
