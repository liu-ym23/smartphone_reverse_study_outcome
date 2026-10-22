package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0001\u0018\u0000 `*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001`B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0004\b\t\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u001dJ\u0015\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J#\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010$J+\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010#\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\bH\u0002¢\u0006\u0002\u0010'J$\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010)\u001a\u00020\u00042\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J,\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010)\u001a\u00020\u00042\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010&\u001a\u00020\bH\u0002J=\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u00101J3\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u0004H\u0002¢\u0006\u0002\u00103J;\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\bH\u0002¢\u0006\u0002\u00101JE\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00028\u00002\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010:J\u001e\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J&\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\bH\u0002J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010?\u001a\u00020\u0004H\u0002J\u001e\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010?\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\bH\u0002J\u0015\u0010A\u001a\u00020\u001a2\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010BJ\u001b\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010DJ'\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010#\u001a\u00028\u00002\n\u0010F\u001a\u0006\u0012\u0002\b\u00030GH\u0002¢\u0006\u0002\u0010HJ\u001b\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010DJ'\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010#\u001a\u00028\u00002\n\u0010F\u001a\u0006\u0012\u0002\b\u00030GH\u0002¢\u0006\u0002\u0010HJ,\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010M\u001a\u00020N2\u0006\u0010&\u001a\u00020\bH\u0002J(\u0010O\u001a\u0004\u0018\u00010\u00022\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010M\u001a\u00020N2\u0006\u0010&\u001a\u00020\bH\u0002J(\u0010P\u001a\u0004\u0018\u00010\u00022\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010M\u001a\u00020N2\u0006\u0010&\u001a\u00020\bH\u0002J\b\u0010Q\u001a\u00020\u0004H\u0002J\u0016\u0010R\u001a\u00020\u001a2\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J#\u0010S\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010#\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u0004¢\u0006\u0002\u0010UJ6\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00100\u001a\u00020\u00042\u0006\u0010M\u001a\u00020N2\n\u0010F\u001a\u0006\u0012\u0002\b\u00030GJ2\u0010W\u001a\u0004\u0018\u00010\u00022\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00100\u001a\u00020\u00042\u0006\u0010M\u001a\u00020N2\n\u0010F\u001a\u0006\u0012\u0002\b\u00030GJ2\u0010X\u001a\u0004\u0018\u00010\u00022\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00100\u001a\u00020\u00042\u0006\u0010M\u001a\u00020N2\n\u0010F\u001a\u0006\u0012\u0002\b\u00030GJ\u001c\u0010Y\u001a\u00020\u001a2\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00100\u001a\u00020\u0004J)\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010T\u001a\u00020\u00042\u0006\u0010#\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u0004¢\u0006\u0002\u0010[J5\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010T\u001a\u00020\u00042\u0006\u0010#\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u00042\n\u0010F\u001a\u0006\u0012\u0002\b\u00030G¢\u0006\u0002\u0010]J)\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010T\u001a\u00020\u00042\u0006\u0010#\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u0004¢\u0006\u0002\u0010[J5\u0010_\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010T\u001a\u00020\u00042\u0006\u0010#\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u00042\n\u0010F\u001a\u0006\u0012\u0002\b\u00030G¢\u0006\u0002\u0010]R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006a"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", ExifInterface.LONGITUDE_EAST, "", SimplayerImageStrategy.RESULT_BITMAP, "", "buffer", "", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "<init>", "(I[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "(I[Ljava/lang/Object;)V", "getBitmap", "()I", "setBitmap", "(I)V", "getBuffer", "()[Ljava/lang/Object;", "setBuffer", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getOwnedBy", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnedBy", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "hasNoCellAt", "", "positionMask", "indexOfCellAt", "indexOfCellAt$runtime", "elementAtIndex", "index", "(I)Ljava/lang/Object;", "nodeAtIndex", "addElementAt", "element", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAddElementAt", "owner", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "updateNodeAtIndex", "nodeIndex", "newNode", "mutableUpdateNodeAtIndex", "makeNodeAtIndex", "elementIndex", "newElementHash", "newElement", "shift", "(IILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "moveElementToNode", "(IILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableMoveElementToNode", "makeNode", "elementHash1", "element1", "elementHash2", "element2", "(ILjava/lang/Object;ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "removeCellAtIndex", "cellIndex", "mutableRemoveCellAtIndex", "collisionRemoveElementAtIndex", RXScreenCaptureService.KEY_INDEX, "mutableCollisionRemoveElementAtIndex", "collisionContainsElement", "(Ljava/lang/Object;)Z", "collisionAdd", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAdd", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "collisionRemove", "mutableCollisionRemove", "mutableCollisionAddAll", "otherNode", "intersectionSizeRef", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableCollisionRetainAll", "mutableCollisionRemoveAll", "calculateSize", "elementsIdentityEquals", "contains", "elementHash", "(ILjava/lang/Object;I)Z", "mutableAddAll", "mutableRetainAll", "mutableRemoveAll", "containsAll", "add", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAdd", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "remove", "mutableRemove", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TrieNode<E> {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final TrieNode EMPTY = null;
    private int bitmap;
    private Object[] buffer;
    private MutabilityOwnership ownedBy;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode$Companion;", "", "<init>", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "", "getEMPTY$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final TrieNode getEMPTY$runtime() {
            return TrieNode.access$getEMPTY$cp();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        EMPTY = new TrieNode(0, new Object[0]);
    }

    private final int calculateSize() {
        if (this.bitmap == 0) goto L5;
        Object[] r100 = this.buffer;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L7:
        if (r102 >= r101) goto L13;
        Object r104 = r100[r102];
        if ((r104 instanceof TrieNode) == false) goto L11;
        int r105 = ((TrieNode) r104).calculateSize();
    L12:
        r103 = r103 + r105;
        r102 = r102 + 1;
        goto L7
    L11:
        r105 = 1;
        goto L12
    L13:
        return r103;
    L5:
        return this.buffer.length;
    }

    public static final /* synthetic */ TrieNode access$getEMPTY$cp() {
        return EMPTY;
    }

    public final int getBitmap() {
        return this.bitmap;
    }

    public final Object[] getBuffer() {
        return this.buffer;
    }

    public final MutabilityOwnership getOwnedBy() {
        return this.ownedBy;
    }

    private final TrieNode<E> collisionAdd(E r100) {
        if (collisionContainsElement(r100) == false) goto L6;
        return this;
    L6:
        return new TrieNode(0, TrieNodeKt.access$addElementAtIndex(this.buffer, 0, r100));
    }

    private final boolean collisionContainsElement(E r100) {
        return ArraysKt.contains(this.buffer, r100);
    }

    private final TrieNode<E> collisionRemove(E r100) {
        int r101 = ArraysKt.indexOf(this.buffer, r100);
        if (r101 != (-1)) goto L5;
        return this;
    L5:
        return collisionRemoveElementAtIndex(r101);
    }

    private final TrieNode<E> collisionRemoveElementAtIndex(int r100) {
        return new TrieNode(0, TrieNodeKt.access$removeCellAtIndex(this.buffer, r100));
    }

    private final E elementAtIndex(int r100) {
        return (E) this.buffer[r100];
    }

    private final boolean elementsIdentityEquals(TrieNode<E> r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (this.bitmap == r100.bitmap) goto L8;
        return false;
    L8:
        int r101 = this.buffer.length;
        int r102 = 0;
    L9:
        if (r102 >= r101) goto L14;
        if (this.buffer[r102] != r100.buffer[r102]) goto L12;
        r102 = r102 + 1;
        goto L9
    L12:
        return false;
    L14:
        return true;
    }

    private final boolean hasNoCellAt(int r100) {
        if ((r100 & this.bitmap) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final TrieNode<E> nodeAtIndex(int r100) {
        Object r101 = this.buffer[r100];
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        return (TrieNode) r101;
    }

    public final int indexOfCellAt$runtime(int r100) {
        return Integer.bitCount((r100 - 1) & this.bitmap);
    }

    public final void setBitmap(int r100) {
        this.bitmap = r100;
    }

    public final void setBuffer(Object[] r100) {
        this.buffer = r100;
    }

    public final void setOwnedBy(MutabilityOwnership r100) {
        this.ownedBy = r100;
    }

    public TrieNode(int r100, Object[] r101) {
        this(r100, r101, null);
    }

    private final TrieNode<E> addElementAt(int r100, E r101) {
        int r102 = indexOfCellAt$runtime(r100);
        Object[] r103 = TrieNodeKt.access$addElementAtIndex(this.buffer, r102, r101);
        return new TrieNode(r100 | this.bitmap, r103);
    }

    private final TrieNode<E> mutableCollisionAdd(E r100, PersistentHashSetBuilder<?> r101) {
        if (collisionContainsElement(r100) == false) goto L5;
        return this;
    L5:
        r101.setSize(r101.size() + 1);
        if (this.ownedBy != r101.getOwnership$runtime()) goto L10;
        this.buffer = TrieNodeKt.access$addElementAtIndex(this.buffer, 0, r100);
        return this;
    L10:
        return new TrieNode(0, TrieNodeKt.access$addElementAtIndex(this.buffer, 0, r100), r101.getOwnership$runtime());
    }

    private final TrieNode<E> mutableCollisionRemove(E r100, PersistentHashSetBuilder<?> r101) {
        int r102 = ArraysKt.indexOf(this.buffer, r100);
        if (r102 == (-1)) goto L6;
        r101.setSize(r101.size() - 1);
        return mutableCollisionRemoveElementAtIndex(r102, r101.getOwnership$runtime());
    L6:
        return this;
    }

    private final TrieNode<E> mutableCollisionRemoveElementAtIndex(int r100, MutabilityOwnership r101) {
        if (this.ownedBy != r101) goto L7;
        this.buffer = TrieNodeKt.access$removeCellAtIndex(this.buffer, r100);
        return this;
    L7:
        return new TrieNode(0, TrieNodeKt.access$removeCellAtIndex(this.buffer, r100), r101);
    }

    private final TrieNode<E> removeCellAtIndex(int r100, int r101) {
        Object[] r102 = TrieNodeKt.access$removeCellAtIndex(this.buffer, r100);
        return new TrieNode(r101 ^ this.bitmap, r102);
    }

    private final TrieNode<E> updateNodeAtIndex(int r100, TrieNode<E> r101) {
        Object[] r102 = r101.buffer;
        if (r102.length != 1) goto L11;
        Object r103 = r102[0];
        if ((r103 instanceof TrieNode) == true) goto L11;
        if (this.buffer.length != 1) goto L10;
        r101.bitmap = this.bitmap;
        return r101;
    L10:
        r101 = (TrieNode<E>) r103;
    L11:
        Object[] r104 = this.buffer;
        Object[] r105 = Arrays.copyOf(r104, r104.length);
        r105[r100] = r101;
        return new TrieNode(this.bitmap, r105);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(TrieNode<E> r110, int r111) {
        if (this != r110) goto L6;
        return true;
    L6:
        if (r111 <= 30) goto L14;
        Object[] r112 = r110.buffer;
        int r113 = r112.length;
        int r100 = 0;
    L8:
        if (r100 >= r113) goto L49;
        Object r101 = r112[r100];
        if (ArraysKt.contains(this.buffer, r101) == false) goto L11;
        r100 = r100 + 1;
        goto L8
    L11:
        return false;
    L49:
        return true;
    L14:
        int r102 = this.bitmap;
        int r103 = r110.bitmap;
        int r104 = r102 & r103;
        if (r104 == r103) goto L17;
        return false;
    L17:
        if (r104 == 0) goto L38;
        int r105 = Integer.lowestOneBit(r104);
        int r106 = indexOfCellAt$runtime(r105);
        int r107 = r110.indexOfCellAt$runtime(r105);
        Object r108 = this.buffer[r106];
        Object r109 = r110.buffer[r107];
        boolean r114 = r108 instanceof TrieNode;
        boolean r115 = r109 instanceof TrieNode;
        if (r114 == false) goto L24;
        if (r115 == false) goto L24;
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        if (((TrieNode) r108).containsAll((TrieNode) r109, r111 + 5) == true) goto L37;
        return false;
    L37:
        r104 = r104 ^ r105;
    L24:
        if (r114 == false) goto L32;
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        TrieNode r116 = (TrieNode) r108;
        if (r109 == null) goto L28;
        int r117 = r109.hashCode();
    L30:
        if (r116.contains(r117, r109, r111 + 5) == true) goto L37;
        return false;
    L28:
        r117 = 0;
        goto L30
    L32:
        if (r115 == true) goto L33;
        if (Intrinsics.areEqual(r108, r109) == true) goto L37;
        return false;
    L33:
        return false;
    L38:
        return true;
    }

    public TrieNode(int r100, Object[] r101, MutabilityOwnership r102) {
        this.bitmap = r100;
        this.buffer = r101;
        this.ownedBy = r102;
    }

    private final TrieNode<E> mutableAddElementAt(int r100, E r101, MutabilityOwnership r102) {
        int r103 = indexOfCellAt$runtime(r100);
        if (this.ownedBy != r102) goto L6;
        this.buffer = TrieNodeKt.access$addElementAtIndex(this.buffer, r103, r101);
        this.bitmap = r100 | this.bitmap;
        return this;
    L6:
        Object[] r104 = TrieNodeKt.access$addElementAtIndex(this.buffer, r103, r101);
        return new TrieNode(r100 | this.bitmap, r104, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TrieNode<E> mutableCollisionAddAll(TrieNode<E> r110, DeltaCounter r111, MutabilityOwnership r112) {
        if (this != r110) goto L5;
        r111.plusAssign(this.buffer.length);
        return this;
    L5:
        Object[] r100 = this.buffer;
        Object[] r101 = Arrays.copyOf(r100, r100.length + r110.buffer.length);
        Object[] r102 = r110.buffer;
        int r103 = this.buffer.length;
        int r104 = 0;
        int r105 = 0;
    L7:
        if (r104 >= r102.length) goto L20;
        boolean r106 = true;
        if (r105 > r104) goto L11;
        boolean r107 = true;
    L12:
        CommonFunctionsKt.m4281assert(r107);
        if ((!collisionContainsElement(r102[r104])) == false) goto L19;
        r101[r103 + r105] = r102[r104];
        r105 = r105 + 1;
        if ((r103 + r105) <= r101.length) goto L18;
        r106 = false;
    L18:
        CommonFunctionsKt.m4281assert(r106);
    L19:
        r104 = r104 + 1;
        goto L7
    L11:
        r107 = false;
        goto L12
    L20:
        int r108 = r105 + this.buffer.length;
        r111.plusAssign(r101.length - r108);
        if (r108 != this.buffer.length) goto L24;
        return this;
    L24:
        if (r108 != r110.buffer.length) goto L27;
        return r110;
    L27:
        if (r108 == r101.length) goto L31;
        r101 = Arrays.copyOf(r101, r108);
    L31:
        if (Intrinsics.areEqual(this.ownedBy, r112) == false) goto L34;
        this.buffer = r101;
        return this;
    L34:
        return new TrieNode(0, r101, r112);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object mutableCollisionRemoveAll(TrieNode<E> r100, DeltaCounter r110, MutabilityOwnership r111) {
        if (this != r100) goto L6;
        r110.plusAssign(this.buffer.length);
        return EMPTY;
    L6:
        if (Intrinsics.areEqual(r111, this.ownedBy) == false) goto L8;
        Object[] r101 = this.buffer;
    L9:
        Object[] r102 = this.buffer;
        int r103 = 0;
        int r104 = 0;
    L10:
        boolean r105 = true;
        if (r103 >= r102.length) goto L23;
        if (r104 > r103) goto L14;
        boolean r106 = true;
    L15:
        CommonFunctionsKt.m4281assert(r106);
        if ((!r100.collisionContainsElement(r102[r103])) == false) goto L22;
        r101[0 + r104] = r102[r103];
        r104 = r104 + 1;
        if ((0 + r104) <= r101.length) goto L21;
        r105 = false;
    L21:
        CommonFunctionsKt.m4281assert(r105);
    L22:
        r103 = r103 + 1;
        goto L10
    L14:
        r106 = false;
        goto L15
    L23:
        r110.plusAssign(this.buffer.length - r104);
        if (r104 == 0) goto L39;
        if (r104 != 1) goto L29;
        return r101[0];
    L29:
        if (r104 != this.buffer.length) goto L32;
        return this;
    L32:
        if (r104 != r101.length) goto L35;
        return new TrieNode(0, r101, r111);
    L35:
        return new TrieNode(0, Arrays.copyOf(r101, r104), r111);
    L39:
        return EMPTY;
    L8:
        r101 = new Object[this.buffer.length];
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object mutableCollisionRetainAll(TrieNode<E> r100, DeltaCounter r110, MutabilityOwnership r111) {
        if (this != r100) goto L6;
        r110.plusAssign(this.buffer.length);
        return this;
    L6:
        if (Intrinsics.areEqual(r111, this.ownedBy) == false) goto L8;
        Object[] r101 = this.buffer;
    L9:
        Object[] r102 = this.buffer;
        int r103 = 0;
        int r104 = 0;
    L10:
        boolean r105 = true;
        if (r103 >= r102.length) goto L23;
        if (r104 > r103) goto L14;
        boolean r106 = true;
    L15:
        CommonFunctionsKt.m4281assert(r106);
        if (r100.collisionContainsElement(r102[r103]) == false) goto L22;
        r101[0 + r104] = r102[r103];
        r104 = r104 + 1;
        if ((0 + r104) <= r101.length) goto L21;
        r105 = false;
    L21:
        CommonFunctionsKt.m4281assert(r105);
    L22:
        r103 = r103 + 1;
        goto L10
    L14:
        r106 = false;
        goto L15
    L23:
        r110.plusAssign(r104);
        if (r104 == 0) goto L42;
        if (r104 != 1) goto L29;
        return r101[0];
    L29:
        if (r104 != this.buffer.length) goto L32;
        return this;
    L32:
        if (r104 != r100.buffer.length) goto L35;
        return r100;
    L35:
        if (r104 != r101.length) goto L38;
        return new TrieNode(0, r101, r111);
    L38:
        return new TrieNode(0, Arrays.copyOf(r101, r104), r111);
    L42:
        return EMPTY;
    L8:
        r101 = new Object[Math.min(this.buffer.length, r100.buffer.length)];
        goto L9
    }

    private final TrieNode<E> mutableRemoveCellAtIndex(int r100, int r101, MutabilityOwnership r102) {
        if (this.ownedBy != r102) goto L7;
        this.buffer = TrieNodeKt.access$removeCellAtIndex(this.buffer, r100);
        this.bitmap ^= r101;
        return this;
    L7:
        return new TrieNode(r101 ^ this.bitmap, TrieNodeKt.access$removeCellAtIndex(this.buffer, r100), r102);
    }

    private final TrieNode<E> mutableUpdateNodeAtIndex(int r100, TrieNode<E> r101, MutabilityOwnership r102) {
        Object[] r103 = r101.buffer;
        if (r103.length != 1) goto L12;
        Object r104 = r103[0];
        if ((r104 instanceof TrieNode) == true) goto L12;
        if (this.buffer.length != 1) goto L10;
        r101.bitmap = this.bitmap;
        return r101;
    L10:
        r101 = (TrieNode<E>) r104;
    L12:
        if (this.ownedBy != r102) goto L15;
        this.buffer[r100] = r101;
        return this;
    L15:
        Object[] r105 = this.buffer;
        Object[] r106 = Arrays.copyOf(r105, r105.length);
        r106[r100] = r101;
        return new TrieNode(this.bitmap, r106, r102);
    }

    public final TrieNode<E> add(int r100, E r101, int r102) {
        int r103 = 1 << TrieNodeKt.indexSegment(r100, r102);
        if (hasNoCellAt(r103) == true) goto L5;
        int r104 = indexOfCellAt$runtime(r103);
        Object r105 = this.buffer[r104];
        if ((r105 instanceof TrieNode) == false) goto L17;
        TrieNode<E> r106 = nodeAtIndex(r104);
        if (r102 != 30) goto L11;
        TrieNode<E> r107 = r106.collisionAdd(r101);
    L12:
        if (r106 != r107) goto L15;
        return this;
    L15:
        return updateNodeAtIndex(r104, r107);
    L11:
        r107 = r106.add(r100, r101, r102 + 5);
        goto L12
    L17:
        if (Intrinsics.areEqual(r101, r105) == false) goto L20;
        return this;
    L20:
        return moveElementToNode(r104, r100, r101, r102);
    L5:
        return addElementAt(r103, r101);
    }

    public final boolean contains(int r100, E r101, int r102) {
        int r103 = 1 << TrieNodeKt.indexSegment(r100, r102);
        if (hasNoCellAt(r103) == false) goto L6;
        return false;
    L6:
        int r104 = indexOfCellAt$runtime(r103);
        Object r105 = this.buffer[r104];
        if ((r105 instanceof TrieNode) == false) goto L15;
        TrieNode<E> r106 = nodeAtIndex(r104);
        if (r102 != 30) goto L13;
        return r106.collisionContainsElement(r101);
    L13:
        return r106.contains(r100, r101, r102 + 5);
    L15:
        return Intrinsics.areEqual(r101, r105);
    }

    public final TrieNode<E> remove(int r100, E r101, int r102) {
        int r103 = 1 << TrieNodeKt.indexSegment(r100, r102);
        if (hasNoCellAt(r103) == false) goto L5;
        return this;
    L5:
        int r104 = indexOfCellAt$runtime(r103);
        Object r105 = this.buffer[r104];
        if ((r105 instanceof TrieNode) == false) goto L16;
        TrieNode<E> r106 = nodeAtIndex(r104);
        if (r102 != 30) goto L10;
        TrieNode<E> r107 = r106.collisionRemove(r101);
    L11:
        if (r106 != r107) goto L14;
        return this;
    L14:
        return updateNodeAtIndex(r104, r107);
    L10:
        r107 = r106.remove(r100, r101, r102 + 5);
        goto L11
    L16:
        if (Intrinsics.areEqual(r101, r105) == true) goto L18;
        return this;
    L18:
        return removeCellAtIndex(r104, r103);
    }

    private final TrieNode<E> moveElementToNode(int r100, int r101, E r110, int r111) {
        Object[] r102 = this.buffer;
        Object[] r103 = Arrays.copyOf(r102, r102.length);
        r103[r100] = makeNodeAtIndex(r100, r101, r110, r111, null);
        return new TrieNode(this.bitmap, r103);
    }

    public final TrieNode<E> mutableAdd(int r100, E r101, int r102, PersistentHashSetBuilder<?> r110) {
        int r103 = 1 << TrieNodeKt.indexSegment(r100, r102);
        if (hasNoCellAt(r103) == false) goto L6;
        r110.setSize(r110.size() + 1);
        return mutableAddElementAt(r103, r101, r110.getOwnership$runtime());
    L6:
        int r104 = indexOfCellAt$runtime(r103);
        Object r105 = this.buffer[r104];
        if ((r105 instanceof TrieNode) == false) goto L17;
        TrieNode<E> r106 = nodeAtIndex(r104);
        if (r102 != 30) goto L11;
        TrieNode<E> r107 = r106.mutableCollisionAdd(r101, r110);
    L12:
        if (r106 != r107) goto L15;
        return this;
    L15:
        return mutableUpdateNodeAtIndex(r104, r107, r110.getOwnership$runtime());
    L11:
        r107 = r106.mutableAdd(r100, r101, r102 + 5, r110);
        goto L12
    L17:
        if (Intrinsics.areEqual(r101, r105) == false) goto L19;
        return this;
    L19:
        r110.setSize(r110.size() + 1);
        return mutableMoveElementToNode(r104, r100, r101, r102, r110.getOwnership$runtime());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TrieNode<E> mutableAddAll(TrieNode<E> r210, int r211, DeltaCounter r212, PersistentHashSetBuilder<?> r213) {
        if (this != r210) goto L7;
        r212.setCount(r212.getCount() + calculateSize());
        return this;
    L7:
        if (r211 > 30) goto L9;
        int r100 = this.bitmap;
        int r101 = r210.bitmap | r100;
        if (r101 == r100) goto L13;
    L15:
        TrieNode<E> r110 = new TrieNode(r101, new Object[Integer.bitCount(r101)], r213.getOwnership$runtime());
    L16:
        int r111 = r101;
        int r112 = 0;
    L17:
        if (r111 == 0) goto L60;
        int r102 = Integer.lowestOneBit(r111);
        int r103 = indexOfCellAt$runtime(r102);
        int r104 = r210.indexOfCellAt$runtime(r102);
        Object[] r105 = r110.buffer;
        if (hasNoCellAt(r102) == false) goto L23;
        Object r106 = r210.buffer[r104];
    L58:
        r105[r112] = r106;
        r112 = r112 + 1;
        r111 = r111 ^ r102;
        goto L17
    L23:
        if (r210.hasNoCellAt(r102) == false) goto L25;
        r106 = this.buffer[r103];
        goto L58
    L25:
        Object r107 = this.buffer[r103];
        Object r108 = r210.buffer[r104];
        boolean r109 = r107 instanceof TrieNode;
        boolean r113 = r108 instanceof TrieNode;
        if (r109 == false) goto L29;
        if (r113 == false) goto L29;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        r106 = ((TrieNode) r107).mutableAddAll((TrieNode) r108, r211 + 5, r212, r213);
    L29:
        if (r109 == false) goto L39;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        TrieNode r114 = (TrieNode) r107;
        int r115 = r213.size();
        if (r108 == null) goto L33;
        int r116 = r108.hashCode();
    L34:
        TrieNode r117 = r114.mutableAdd(r116, r108, r211 + 5, r213);
        if (r213.size() != r115) goto L37;
        r212.setCount(r212.getCount() + 1);
    L37:
        Unit r118 = Unit.INSTANCE;
    L38:
        r106 = r117;
        goto L58
    L33:
        r116 = 0;
        goto L34
    L39:
        if (r113 == false) goto L49;
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        TrieNode r119 = (TrieNode) r108;
        int r120 = r213.size();
        if (r107 == null) goto L43;
        int r121 = r107.hashCode();
    L44:
        r117 = r119.mutableAdd(r121, r107, r211 + 5, r213);
        if (r213.size() != r120) goto L47;
        r212.setCount(r212.getCount() + 1);
    L47:
        Unit r122 = Unit.INSTANCE;
        goto L38
    L43:
        r121 = 0;
        goto L44
    L49:
        if (Intrinsics.areEqual(r107, r108) == false) goto L51;
        r212.setCount(r212.getCount() + 1);
        Unit r123 = Unit.INSTANCE;
        r106 = r107;
        goto L58
    L51:
        if (r107 == null) goto L53;
        int r124 = r107.hashCode();
    L54:
        if (r108 == null) goto L56;
        int r125 = r108.hashCode();
    L57:
        r106 = makeNode(r124, r107, r125, r108, r211 + 5, r213.getOwnership$runtime());
        goto L58
    L56:
        r125 = 0;
        goto L57
    L53:
        r124 = 0;
        goto L54
    L60:
        if (elementsIdentityEquals(r110) == false) goto L63;
        return this;
    L63:
        if (r210.elementsIdentityEquals(r110) == true) goto L65;
        return r110;
    L65:
        return r210;
    L13:
        if (Intrinsics.areEqual(this.ownedBy, r213.getOwnership$runtime()) == false) goto L15;
        r110 = this;
        goto L16
    L9:
        return mutableCollisionAddAll(r210, r212, r213.getOwnership$runtime());
    }

    public final TrieNode<E> mutableRemove(int r100, E r101, int r102, PersistentHashSetBuilder<?> r103) {
        int r104 = 1 << TrieNodeKt.indexSegment(r100, r102);
        if (hasNoCellAt(r104) == false) goto L5;
        return this;
    L5:
        int r105 = indexOfCellAt$runtime(r104);
        Object r106 = this.buffer[r105];
        if ((r106 instanceof TrieNode) == false) goto L19;
        TrieNode<E> r107 = nodeAtIndex(r105);
        if (r102 != 30) goto L10;
        TrieNode<E> r108 = r107.mutableCollisionRemove(r101, r103);
    L12:
        if (this.ownedBy == r103.getOwnership$runtime()) goto L17;
        if (r107 != r108) goto L17;
        return this;
    L17:
        return mutableUpdateNodeAtIndex(r105, r108, r103.getOwnership$runtime());
    L10:
        r108 = r107.mutableRemove(r100, r101, r102 + 5, r103);
        goto L12
    L19:
        if (Intrinsics.areEqual(r101, r106) == false) goto L22;
        r103.setSize(r103.size() - 1);
        return mutableRemoveCellAtIndex(r105, r104, r103.getOwnership$runtime());
    L22:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object mutableRemoveAll(TrieNode<E> r110, int r111, DeltaCounter r112, PersistentHashSetBuilder<?> r210) {
        if (this != r110) goto L7;
        r112.plusAssign(calculateSize());
        return EMPTY;
    L7:
        if (r111 > 30) goto L9;
        int r100 = this.bitmap & r110.bitmap;
        if (r100 != 0) goto L14;
        return this;
    L14:
        if (Intrinsics.areEqual(this.ownedBy, r210.getOwnership$runtime()) == false) goto L16;
        TrieNode<E> r101 = this;
    L17:
        int r102 = this.bitmap;
    L18:
        if (r100 == 0) goto L51;
        int r113 = Integer.lowestOneBit(r100);
        int r114 = indexOfCellAt$runtime(r113);
        int r115 = r110.indexOfCellAt$runtime(r113);
        Object r116 = this.buffer[r114];
        Object r117 = r110.buffer[r115];
        boolean r118 = r116 instanceof TrieNode;
        boolean r119 = r117 instanceof TrieNode;
        if (r118 == false) goto L23;
        if (r119 == false) goto L23;
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        r116 = ((TrieNode) r116).mutableRemoveAll((TrieNode) r117, r111 + 5, r112, r210);
    L48:
        if (r116 != EMPTY) goto L50;
        r102 = r102 ^ r113;
    L50:
        r101.buffer[r114] = r116;
        r100 = r100 ^ r113;
    L23:
        if (r118 == false) goto L36;
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        TrieNode r103 = (TrieNode) r116;
        int r120 = r210.size();
        if (r117 == null) goto L27;
        int r121 = r117.hashCode();
    L28:
        TrieNode r104 = r103.mutableRemove(r121, r117, r111 + 5, r210);
        if (r120 == r210.size()) goto L48;
        r112.plusAssign(1);
        Object[] r122 = r104.buffer;
        if (r122.length != 1) goto L35;
        r116 = r122[0];
        if ((r116 instanceof TrieNode) == false) goto L48;
    L35:
        r116 = r104;
        goto L48
    L27:
        r121 = 0;
        goto L28
    L36:
        if (r119 == false) goto L45;
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        TrieNode r123 = (TrieNode) r117;
        if (r116 == null) goto L40;
        int r105 = r116.hashCode();
    L42:
        if (r123.contains(r105, r116, r111 + 5) == false) goto L48;
        r112.plusAssign(1);
        r116 = EMPTY;
        goto L48
    L40:
        r105 = 0;
        goto L42
    L45:
        if (Intrinsics.areEqual(r116, r117) == false) goto L48;
        r112.plusAssign(1);
        r116 = EMPTY;
        goto L48
    L51:
        int r106 = Integer.bitCount(r102);
        if (r102 != 0) goto L55;
        return EMPTY;
    L55:
        if (r102 != this.bitmap) goto L60;
        if (r101.elementsIdentityEquals(this) == true) goto L93;
        return r101;
    L93:
        return this;
    L60:
        if (r106 != 1) goto L65;
        if (r111 == 0) goto L65;
        Object r107 = r101.buffer[r101.indexOfCellAt$runtime(r102)];
        if ((r107 instanceof TrieNode) == true) goto L95;
        return r107;
    L95:
        return new TrieNode(r102, new Object[]{r107}, r210.getOwnership$runtime());
    L65:
        Object[] r108 = new Object[r106];
        Object[] r109 = r101.buffer;
        int r124 = 0;
        int r125 = 0;
    L67:
        if (r124 >= r109.length) goto L84;
        if (r125 > r124) goto L70;
        boolean r126 = true;
    L71:
        CommonFunctionsKt.m4281assert(r126);
        if (r109[r124] == Companion.getEMPTY$runtime()) goto L74;
        boolean r127 = true;
    L75:
        if (r127 == false) goto L82;
        r108[0 + r125] = r109[r124];
        r125 = r125 + 1;
        if ((0 + r125) > r106) goto L79;
        boolean r128 = true;
    L80:
        CommonFunctionsKt.m4281assert(r128);
        goto L82
    L79:
        r128 = false;
    L82:
        r124 = r124 + 1;
        goto L67
    L74:
        r127 = false;
        goto L75
    L70:
        r126 = false;
        goto L71
    L84:
        return new TrieNode(r102, r108, r210.getOwnership$runtime());
    L16:
        int r129 = this.bitmap;
        Object[] r130 = this.buffer;
        r101 = new TrieNode(r129, Arrays.copyOf(r130, r130.length), r210.getOwnership$runtime());
        goto L17
    L9:
        return mutableCollisionRemoveAll(r110, r112, r210.getOwnership$runtime());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object mutableRetainAll(TrieNode<E> r110, int r111, DeltaCounter r112, PersistentHashSetBuilder<?> r210) {
        if (this != r110) goto L7;
        r112.plusAssign(calculateSize());
        return this;
    L7:
        if (r111 > 30) goto L9;
        int r100 = this.bitmap & r110.bitmap;
        if (r100 != 0) goto L15;
        return EMPTY;
    L15:
        if (Intrinsics.areEqual(this.ownedBy, r210.getOwnership$runtime()) == true) goto L17;
    L19:
        TrieNode<E> r101 = new TrieNode(r100, new Object[Integer.bitCount(r100)], r210.getOwnership$runtime());
    L20:
        int r102 = r100;
        int r103 = 0;
        int r104 = 0;
    L22:
        if (r102 == 0) goto L53;
        int r113 = Integer.lowestOneBit(r102);
        int r114 = indexOfCellAt$runtime(r113);
        int r115 = r110.indexOfCellAt$runtime(r113);
        Object r116 = this.buffer[r114];
        Object r117 = r110.buffer[r115];
        boolean r118 = r116 instanceof TrieNode;
        boolean r119 = r117 instanceof TrieNode;
        if (r118 == false) goto L27;
        if (r119 == false) goto L27;
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        r116 = ((TrieNode) r116).mutableRetainAll((TrieNode) r117, r111 + 5, r112, r210);
    L50:
        if (r116 == EMPTY) goto L52;
        r103 = r103 | r113;
    L52:
        r101.buffer[r104] = r116;
        r104 = r104 + 1;
        r102 = r102 ^ r113;
    L27:
        if (r118 == false) goto L36;
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        TrieNode r120 = (TrieNode) r116;
        if (r117 == null) goto L31;
        int r105 = r117.hashCode();
    L33:
        if (r120.contains(r105, r117, r111 + 5) == false) goto L35;
        r112.plusAssign(1);
        r116 = r117;
        goto L50
    L35:
        r116 = EMPTY;
        goto L50
    L31:
        r105 = 0;
        goto L33
    L36:
        if (r119 == false) goto L46;
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        TrieNode r121 = (TrieNode) r117;
        if (r116 == null) goto L40;
        int r106 = r116.hashCode();
    L42:
        if (r121.contains(r106, r116, r111 + 5) == false) goto L44;
        r112.plusAssign(1);
        goto L50
    L44:
        r116 = EMPTY;
        goto L50
    L40:
        r106 = 0;
        goto L42
    L46:
        if (Intrinsics.areEqual(r116, r117) == false) goto L48;
        r112.plusAssign(1);
        goto L50
    L48:
        r116 = EMPTY;
        goto L50
    L53:
        int r107 = Integer.bitCount(r103);
        if (r103 == 0) goto L96;
        if (r103 == r100) goto L58;
        if (r107 != 1) goto L69;
        if (r111 == 0) goto L69;
        Object r108 = r101.buffer[r101.indexOfCellAt$runtime(r103)];
        if ((r108 instanceof TrieNode) == false) goto L99;
        TrieNode r109 = new TrieNode(r103, new Object[]{r108}, r210.getOwnership$runtime());
    L89:
        return r109;
    L99:
        return r108;
    L69:
        Object[] r122 = new Object[r107];
        Object[] r123 = r101.buffer;
        int r124 = 0;
        int r125 = 0;
    L71:
        if (r124 >= r123.length) goto L87;
        if (r125 > r124) goto L74;
        boolean r126 = true;
    L75:
        CommonFunctionsKt.m4281assert(r126);
        if (r123[r124] == Companion.getEMPTY$runtime()) goto L78;
        boolean r127 = true;
    L79:
        if (r127 == false) goto L86;
        r122[0 + r125] = r123[r124];
        r125 = r125 + 1;
        if ((0 + r125) > r107) goto L83;
        boolean r128 = true;
    L84:
        CommonFunctionsKt.m4281assert(r128);
        goto L86
    L83:
        r128 = false;
    L86:
        r124 = r124 + 1;
        goto L71
    L78:
        r127 = false;
        goto L79
    L74:
        r126 = false;
        goto L75
    L87:
        r109 = new TrieNode(r103, r122, r210.getOwnership$runtime());
        goto L89
    L58:
        if (r101.elementsIdentityEquals(this) == false) goto L61;
        return this;
    L61:
        if (r101.elementsIdentityEquals(r110) == false) goto L98;
        return r110;
    L98:
        return r101;
    L96:
        return EMPTY;
    L17:
        if (r100 != this.bitmap) goto L19;
        r101 = this;
        goto L20
    L9:
        return mutableCollisionRetainAll(r110, r112, r210.getOwnership$runtime());
    }

    private final TrieNode<E> makeNodeAtIndex(int r100, int r101, E r110, int r111, MutabilityOwnership r112) {
        E r102 = elementAtIndex(r100);
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return makeNode(r103, r102, r101, r110, r111 + 5, r112);
    L5:
        r103 = 0;
        goto L7
    }

    private final TrieNode<E> mutableMoveElementToNode(int r100, int r101, E r102, int r103, MutabilityOwnership r104) {
        if (this.ownedBy != r104) goto L6;
        this.buffer[r100] = makeNodeAtIndex(r100, r101, r102, r103, r104);
        return this;
    L6:
        Object[] r105 = this.buffer;
        Object[] r106 = Arrays.copyOf(r105, r105.length);
        r106[r100] = makeNodeAtIndex(r100, r101, r102, r103, r104);
        return new TrieNode(this.bitmap, r106, r104);
    }

    private final TrieNode<E> makeNode(int r110, E r111, int r112, E r113, int r114, MutabilityOwnership r115) {
        if (r114 > 30) goto L5;
        int r116 = TrieNodeKt.indexSegment(r110, r114);
        int r100 = TrieNodeKt.indexSegment(r112, r114);
        if (r116 == r100) goto L14;
        if (r116 >= r100) goto L10;
        Object[] r101 = {r111, r113};
    L12:
        return new TrieNode((1 << r116) | (1 << r100), r101, r115);
    L10:
        r101 = new Object[]{r113, r111};
        goto L12
    L14:
        return new TrieNode(1 << r116, new Object[]{makeNode(r110, r111, r112, r113, r114 + 5, r115)}, r115);
    L5:
        return new TrieNode(0, new Object[]{r111, r113}, r115);
    }
}
