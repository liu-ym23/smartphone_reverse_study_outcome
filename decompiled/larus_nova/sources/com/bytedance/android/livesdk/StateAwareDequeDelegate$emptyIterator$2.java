package com.bytedance.android.livesdk;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004*\u0001\u0003\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Deque;", "C", "com/bytedance/android/livesdk/StateAwareDequeDelegate$emptyIterator$2$a", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/livesdk/StateAwareDequeDelegate$emptyIterator$2$a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class StateAwareDequeDelegate$emptyIterator$2 extends Lambda implements Function0<a> {
    public static final StateAwareDequeDelegate$emptyIterator$2 INSTANCE = null;

    public static final class a implements Iterator<Object>, KMutableIterator {
        public a() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
        }

        @Override // java.util.Iterator
        public final Object next() {
            throw new NoSuchElementException();
        }
    }

    static {
        INSTANCE = new StateAwareDequeDelegate$emptyIterator$2();
    }

    public StateAwareDequeDelegate$emptyIterator$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a invoke() {
        return new a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a invoke() {
        return invoke();
    }
}
