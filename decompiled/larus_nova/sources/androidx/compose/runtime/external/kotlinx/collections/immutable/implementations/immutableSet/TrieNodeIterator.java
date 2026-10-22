package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u000b\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0014\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0016R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNodeIterator;", ExifInterface.LONGITUDE_EAST, "", "<init>", "()V", "buffer", "", "[Ljava/lang/Object;", "index", "", BasicTestActionHandler.TEST_ACTION_RESET, "", "([Ljava/lang/Object;I)V", "hasNextCell", "", "moveToNextCell", "hasNextElement", "currentElement", "()Ljava/lang/Object;", "nextElement", "hasNextNode", "currentNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TrieNodeIterator<E> {
    public static final int $stable = 8;
    private Object[] buffer;
    private int index;

    public final boolean hasNextCell() {
        if (this.index >= this.buffer.length) goto L5;
        return true;
    L5:
        return false;
    }

    public TrieNodeIterator() {
        this.buffer = TrieNode.Companion.getEMPTY$runtime().getBuffer();
    }

    public final E currentElement() {
        CommonFunctionsKt.m4281assert(hasNextElement());
        return (E) this.buffer[this.index];
    }

    public final TrieNode<? extends E> currentNode() {
        CommonFunctionsKt.m4281assert(hasNextNode());
        Object r100 = this.buffer[this.index];
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeIterator>");
        return (TrieNode) r100;
    }

    public final boolean hasNextElement() {
        if (hasNextCell() == true) goto L5;
    L7:
        return false;
    L5:
        if ((this.buffer[this.index] instanceof TrieNode) == true) goto L7;
        return true;
    }

    public final boolean hasNextNode() {
        if (hasNextCell() == true) goto L5;
    L7:
        return false;
    L5:
        if ((this.buffer[this.index] instanceof TrieNode) == false) goto L7;
        return true;
    }

    public final void moveToNextCell() {
        CommonFunctionsKt.m4281assert(hasNextCell());
        this.index++;
    }

    public final E nextElement() {
        CommonFunctionsKt.m4281assert(hasNextElement());
        Object[] r100 = this.buffer;
        int r101 = this.index;
        this.index = r101 + 1;
        return (E) r100[r101];
    }

    public final void reset(Object[] r100, int r101) {
        this.buffer = r100;
        this.index = r101;
    }

    public static /* synthetic */ void reset$default(TrieNodeIterator r100, Object[] r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 0;
    L5:
        r100.reset(r101, r102);
    }
}
