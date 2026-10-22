package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.internal.InlineClassHelperKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\fJ\r\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u0015\u001a\u00020\r2\u0014\b\u0004\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u0013H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/compose/ui/node/DepthSortedSet;", "", "", "extraAssertions", AppAgent.CONSTRUCT, "(Z)V", "Landroidx/collection/MutableObjectIntMap;", "Landroidx/compose/ui/node/LayoutNode;", "safeMapOfOriginalDepth", "()Landroidx/collection/MutableObjectIntMap;", "node", "contains", "(Landroidx/compose/ui/node/LayoutNode;)Z", "LC7/r;", "add", "(Landroidx/compose/ui/node/LayoutNode;)V", "remove", "pop", "()Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/Function1;", "block", "popEach", "(LS7/k;)V", "isEmpty", "()Z", "isNotEmpty", "", "toString", "()Ljava/lang/String;", "Z", "mapOfOriginalDepth", "Landroidx/collection/MutableObjectIntMap;", "Landroidx/compose/ui/node/SortedSet;", "set", "Landroidx/compose/ui/node/SortedSet;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DepthSortedSet {
    public static final int $stable = 8;
    private final boolean extraAssertions;
    private MutableObjectIntMap<LayoutNode> mapOfOriginalDepth;
    private final SortedSet<LayoutNode> set = new SortedSet<>(DepthSortedSetKt.DepthComparator);

    public DepthSortedSet(boolean z10) {
        this.extraAssertions = z10;
    }

    private final MutableObjectIntMap<LayoutNode> safeMapOfOriginalDepth() {
        if (this.mapOfOriginalDepth == null) {
            this.mapOfOriginalDepth = ObjectIntMapKt.mutableObjectIntMapOf();
        }
        MutableObjectIntMap<LayoutNode> mutableObjectIntMap = this.mapOfOriginalDepth;
        k.c(mutableObjectIntMap);
        return mutableObjectIntMap;
    }

    public final void add(LayoutNode node) {
        if (!node.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.add called on an unattached node");
        }
        if (this.extraAssertions) {
            MutableObjectIntMap<LayoutNode> mutableObjectIntMapSafeMapOfOriginalDepth = safeMapOfOriginalDepth();
            int orDefault = mutableObjectIntMapSafeMapOfOriginalDepth.getOrDefault(node, Integer.MAX_VALUE);
            if (orDefault == Integer.MAX_VALUE) {
                mutableObjectIntMapSafeMapOfOriginalDepth.set(node, node.getDepth());
            } else {
                if (!(orDefault == node.getDepth())) {
                    InlineClassHelperKt.throwIllegalStateException("invalid node depth");
                }
            }
        }
        this.set.add(node);
    }

    public final boolean contains(LayoutNode node) {
        boolean zContains = this.set.contains(node);
        if (this.extraAssertions) {
            if (!(zContains == safeMapOfOriginalDepth().containsKey(node))) {
                InlineClassHelperKt.throwIllegalStateException("inconsistency in TreeSet");
            }
        }
        return zContains;
    }

    public final boolean isEmpty() {
        return this.set.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public final LayoutNode pop() {
        LayoutNode layoutNodeFirst = this.set.first();
        remove(layoutNodeFirst);
        return layoutNodeFirst;
    }

    public final void popEach(S7.k block) {
        while (!isEmpty()) {
            block.invoke(pop());
        }
    }

    public final boolean remove(LayoutNode node) {
        if (!node.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("DepthSortedSet.remove called on an unattached node");
        }
        boolean zRemove = this.set.remove(node);
        if (this.extraAssertions) {
            MutableObjectIntMap<LayoutNode> mutableObjectIntMapSafeMapOfOriginalDepth = safeMapOfOriginalDepth();
            if (mutableObjectIntMapSafeMapOfOriginalDepth.containsKey(node)) {
                int i = mutableObjectIntMapSafeMapOfOriginalDepth.get(node);
                mutableObjectIntMapSafeMapOfOriginalDepth.remove(node);
                if (!(i == (zRemove ? node.getDepth() : Integer.MAX_VALUE))) {
                    InlineClassHelperKt.throwIllegalStateException("invalid node depth");
                }
            }
        }
        return zRemove;
    }

    public String toString() {
        return this.set.toString();
    }
}
