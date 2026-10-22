package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u00012\b\u0012\u0004\u0012\u0002H\u00030\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u0015\u001a\u00020\u00162\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0017J#\u0010\u0015\u001a\u00020\u00162\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000b\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0016J\u0006\u0010\u001e\u001a\u00020\u001aJ\u0016\u0010\u001f\u001a\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010 J\u0006\u0010!\u001a\u00020\u0016J\t\u0010\"\u001a\u00020\u001aH\u0096\u0002R0\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b@BX\u0084\u000e¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "K", "V", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "value", "", "", "buffer", "getBuffer", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "dataSize", "", "index", "getIndex", "()I", "setIndex", "(I)V", BasicTestActionHandler.TEST_ACTION_RESET, "", "([Ljava/lang/Object;II)V", "([Ljava/lang/Object;I)V", "hasNextKey", "", "currentKey", "()Ljava/lang/Object;", "moveToNextKey", "hasNextNode", "currentNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "moveToNextNode", "hasNext", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class TrieNodeBaseIterator<K, V, T> implements Iterator<T>, KMappedMarker {
    public static final int $stable = 8;
    private Object[] buffer;
    private int dataSize;
    private int index;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean hasNextKey() {
        if (this.index >= this.dataSize) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean hasNextNode() {
        if (this.index < this.dataSize) goto L5;
        boolean r100 = true;
    L6:
        CommonFunctionsKt.m4281assert(r100);
        if (this.index < this.buffer.length) goto L11;
        return false;
    L11:
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public TrieNodeBaseIterator() {
        this.buffer = TrieNode.Companion.getEMPTY$runtime().getBuffer$runtime();
    }

    public final K currentKey() {
        CommonFunctionsKt.m4281assert(hasNextKey());
        return (K) this.buffer[this.index];
    }

    public final TrieNode<? extends K, ? extends V> currentNode() {
        CommonFunctionsKt.m4281assert(hasNextNode());
        Object r100 = this.buffer[this.index];
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        return (TrieNode) r100;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return hasNextKey();
    }

    public final void moveToNextKey() {
        CommonFunctionsKt.m4281assert(hasNextKey());
        this.index += 2;
    }

    public final void moveToNextNode() {
        CommonFunctionsKt.m4281assert(hasNextNode());
        this.index++;
    }

    public final Object[] getBuffer() {
        return this.buffer;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public final void reset(Object[] r100, int r101) {
        reset(r100, r101, 0);
    }

    public final void reset(Object[] r100, int r101, int r102) {
        this.buffer = r100;
        this.dataSize = r101;
        this.index = r102;
    }
}
