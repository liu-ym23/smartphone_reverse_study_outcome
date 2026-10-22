package androidx.compose.ui.graphics;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.ClosedFloatingPointRange;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\f\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011J6\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\u0015J:\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\u0015J6\u0010\u0017\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0018\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00020\f0\u0019H\u0080\b¢\u0006\u0002\b\u001aJ:\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\u0018\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0004\u0012\u00020\f0\u0019H\u0080\b¢\u0006\u0002\b\u001aJ\u0011\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011H\u0086\u0002J\u0017\u0010\u001b\u001a\u00020\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086\u0002J\u0015\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\u001fH\u0086\u0002J\u0017\u0010 \u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086\u0002J%\u0010!\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010#J\u001a\u0010$\u001a\u00020\f2\u0010\u0010%\u001a\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u001a\u0010&\u001a\u00020\f2\u0010\u0010'\u001a\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u001a\u0010(\u001a\u00020\f2\u0010\u0010'\u001a\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u001a\u0010)\u001a\u00020\f2\u0010\u0010'\u001a\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002R\u001a\u0010\u0005\u001a\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u00008\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u00008\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R4\u0010\b\u001a&\u0012\u000e\u0012\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u00000\tj\u0012\u0012\u000e\u0012\f0\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0000`\n8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/compose/ui/graphics/IntervalTree;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "terminator", "Landroidx/compose/ui/graphics/IntervalTree$Node;", RootDescription.ROOT_ELEMENT, "stack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clear", "", "findFirstOverlap", "Landroidx/compose/ui/graphics/Interval;", VideoThumbInfo.KEY_INTERVAL, "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "end", "findOverlaps", "", "results", "forEach", "block", "Lkotlin/Function1;", "forEach$ui_graphics_release", "contains", "", "value", "iterator", "", "plusAssign", "addInterval", "data", "(FFLjava/lang/Object;)V", "rebalance", PickerReporterConstants.KEY.TARGET, "rotateLeft", "node", "rotateRight", "updateNodeData", "Node", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IntervalTree<T> {
    public IntervalTree<T>.Node root;
    public final ArrayList<IntervalTree<T>.Node> stack;
    public final IntervalTree<T>.Node terminator;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0080\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010#\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0010\u0010$\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u0018R\u001e\u0010\u0006\u001a\u00060\u0007j\u0002`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u0010\u0017\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\f0\u0000R\b\u0012\u0004\u0012\u00028\u00000\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001c¨\u0006%"}, d2 = {"Landroidx/compose/ui/graphics/IntervalTree$Node;", "Landroidx/compose/ui/graphics/Interval;", "start", "", "end", "data", "color", "", "Landroidx/compose/ui/graphics/TreeColor;", "<init>", "(Landroidx/compose/ui/graphics/IntervalTree;FFLjava/lang/Object;I)V", "getColor", "()I", "setColor", "(I)V", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "getMin", "()F", "setMin", "(F)V", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "getMax", "setMax", "left", "Landroidx/compose/ui/graphics/IntervalTree;", "getLeft", "()Landroidx/compose/ui/graphics/IntervalTree$Node;", "setLeft", "(Landroidx/compose/ui/graphics/IntervalTree$Node;)V", "right", "getRight", "setRight", "parent", "getParent", "setParent", "lowestNode", TeaEventTrack.ACTION_DRAMA_NEXT, "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class Node extends Interval<T> {
        private int color;
        private IntervalTree<T>.Node left;
        private float max;
        private float min;
        private IntervalTree<T>.Node parent;
        private IntervalTree<T>.Node right;
        final /* synthetic */ IntervalTree<T> this$0;

        public final IntervalTree<T>.Node lowestNode() {
            Node r100 = this;
        L3:
            IntervalTree<T>.Node r101 = r100.left;
            if (r101 == this.this$0.terminator) goto L6;
            r100 = r101;
            goto L3
        L6:
            return r100;
        }

        public final IntervalTree<T>.Node next() {
            IntervalTree<T>.Node r100 = this.right;
            if (r100 != this.this$0.terminator) goto L5;
            IntervalTree<T>.Node r101 = this.parent;
            Node r102 = this;
        L8:
            if (r101 == this.this$0.terminator) goto L12;
            if (r102 != r101.right) goto L12;
            r102 = r101;
            r101 = r101.parent;
        L12:
            return r101;
        L5:
            return r100.lowestNode();
        }

        public final int getColor() {
            return this.color;
        }

        public final IntervalTree<T>.Node getLeft() {
            return this.left;
        }

        public final float getMax() {
            return this.max;
        }

        public final float getMin() {
            return this.min;
        }

        public final IntervalTree<T>.Node getParent() {
            return this.parent;
        }

        public final IntervalTree<T>.Node getRight() {
            return this.right;
        }

        public final void setColor(int r100) {
            this.color = r100;
        }

        public final void setLeft(IntervalTree<T>.Node r100) {
            this.left = r100;
        }

        public final void setMax(float r100) {
            this.max = r100;
        }

        public final void setMin(float r100) {
            this.min = r100;
        }

        public final void setParent(IntervalTree<T>.Node r100) {
            this.parent = r100;
        }

        public final void setRight(IntervalTree<T>.Node r100) {
            this.right = r100;
        }

        public Node(IntervalTree r100, float r101, float r102, T r103, int r104) {
            this.this$0 = r100;
            super(r101, r102, r103);
            this.color = r104;
            this.min = r101;
            this.max = r102;
            IntervalTree<T>.Node r105 = r100.terminator;
            this.left = r105;
            this.right = r105;
            this.parent = r105;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.IntervalTree$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002R\u0018\u0010\u0003\u001a\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"androidx/compose/ui/graphics/IntervalTree$iterator$1", "", "Landroidx/compose/ui/graphics/Interval;", TeaEventTrack.ACTION_DRAMA_NEXT, "Landroidx/compose/ui/graphics/IntervalTree$Node;", "Landroidx/compose/ui/graphics/IntervalTree;", "hasNext", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<Interval<T>>, KMappedMarker {
        private IntervalTree<T>.Node next;
        final /* synthetic */ IntervalTree<T> this$0;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next == this.this$0.terminator) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public Interval<T> next() {
            IntervalTree<T>.Node r100 = this.next;
            this.next = r100.next();
            return r100;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        public AnonymousClass1(IntervalTree<T> r100) {
            this.this$0 = r100;
            this.next = r100.root.lowestNode();
        }
    }

    public final void clear() {
        this.root = this.terminator;
    }

    public final Iterator<Interval<T>> iterator() {
        return new AnonymousClass1(this);
    }

    public IntervalTree() {
        IntervalTree<T>.Node r100 = new Node(this, Float.MAX_VALUE, Float.MIN_VALUE, null, 1);
        this.terminator = r100;
        this.root = r100;
        this.stack = new ArrayList();
    }

    private final void rebalance(IntervalTree<T>.Node r100) {
    L3:
        if (r100 == this.root) goto L23;
        if (r100.getParent().getColor() != 0) goto L23;
        IntervalTree<T>.Node r101 = r100.getParent().getParent();
        if (r100.getParent() == r101.getLeft()) goto L8;
        IntervalTree<T>.Node r102 = r101.getLeft();
        if (r102.getColor() == 0) goto L17;
        if (r100 != r100.getParent().getLeft()) goto L22;
        r100 = r100.getParent();
        rotateRight(r100);
    L22:
        r100.getParent().setColor(1);
        r101.setColor(0);
        rotateLeft(r101);
        goto L3
    L17:
        r102.setColor(1);
        r100.getParent().setColor(1);
        r101.setColor(0);
    L18:
        r100 = r101;
        goto L3
    L8:
        IntervalTree<T>.Node r103 = r101.getRight();
        if (r103.getColor() == 0) goto L10;
        if (r100 != r100.getParent().getRight()) goto L14;
        r100 = r100.getParent();
        rotateLeft(r100);
    L14:
        r100.getParent().setColor(1);
        r101.setColor(0);
        rotateRight(r101);
        goto L3
    L10:
        r103.setColor(1);
        r100.getParent().setColor(1);
        r101.setColor(0);
    L23:
        this.root.setColor(1);
    }

    private final void rotateLeft(IntervalTree<T>.Node r100) {
        IntervalTree<T>.Node r101 = r100.getRight();
        r100.setRight(r101.getLeft());
        if (r101.getLeft() == this.terminator) goto L5;
        r101.getLeft().setParent(r100);
    L5:
        r101.setParent(r100.getParent());
        if (r100.getParent() != this.terminator) goto L9;
        this.root = r101;
    L12:
        r101.setLeft(r100);
        r100.setParent(r101);
        updateNodeData(r100);
        return;
    L9:
        if (r100.getParent().getLeft() != r100) goto L11;
        r100.getParent().setLeft(r101);
        goto L12
    L11:
        r100.getParent().setRight(r101);
        goto L12
    }

    private final void rotateRight(IntervalTree<T>.Node r100) {
        IntervalTree<T>.Node r101 = r100.getLeft();
        r100.setLeft(r101.getRight());
        if (r101.getRight() == this.terminator) goto L5;
        r101.getRight().setParent(r100);
    L5:
        r101.setParent(r100.getParent());
        if (r100.getParent() != this.terminator) goto L9;
        this.root = r101;
    L12:
        r101.setRight(r100);
        r100.setParent(r101);
        updateNodeData(r100);
        return;
    L9:
        if (r100.getParent().getRight() != r100) goto L11;
        r100.getParent().setRight(r101);
        goto L12
    L11:
        r100.getParent().setLeft(r101);
        goto L12
    }

    private final void updateNodeData(IntervalTree<T>.Node r100) {
    L3:
        if (r100 == this.terminator) goto L5;
        r100.setMin(Math.min(r100.getStart(), Math.min(r100.getLeft().getMin(), r100.getRight().getMin())));
        r100.setMax(Math.max(r100.getEnd(), Math.max(r100.getLeft().getMax(), r100.getRight().getMax())));
        r100 = r100.getParent();
        goto L3
    }

    public final boolean contains(ClosedFloatingPointRange<Float> r100) {
        if (findFirstOverlap(r100.getStart().floatValue(), r100.getEndInclusive().floatValue()) == IntervalTreeKt.getEmptyInterval()) goto L5;
        return true;
    L5:
        return false;
    }

    public final Interval<T> findFirstOverlap(ClosedFloatingPointRange<Float> r100) {
        return findFirstOverlap(r100.getStart().floatValue(), r100.getEndInclusive().floatValue());
    }

    public final void plusAssign(Interval<T> r100) {
        addInterval(r100.getStart(), r100.getEnd(), r100.getData());
    }

    public final boolean contains(float r100) {
        if (findFirstOverlap(r100, r100) == IntervalTreeKt.getEmptyInterval()) goto L5;
        return true;
    L5:
        return false;
    }

    public final Interval<T> findFirstOverlap(float r100, float r101) {
        IntervalTree<T>.Node r102 = this.root;
        IntervalTree<T>.Node r103 = this.terminator;
        if (r102 == r103) goto L22;
        if (r102 == r103) goto L22;
        ArrayList<IntervalTree<T>.Node> r104 = this.stack;
        r104.add(r102);
    L7:
        if (r104.size() <= 0) goto L21;
        Node r105 = (Node) ListProtector.remove(r104, r104.size() - 1);
        if (r105.overlaps(r100, r101) == true) goto L10;
        if (r105.getLeft() == this.terminator) goto L17;
        if (r105.getLeft().getMax() < r100) goto L17;
        r104.add(r105.getLeft());
    L17:
        if (r105.getRight() == this.terminator) goto L7;
        if (r105.getRight().getMin() > r101) goto L7;
        r104.add(r105.getRight());
        goto L7
    L10:
        return r105;
    L21:
        r104.clear();
    L22:
        Interval<T> r106 = (Interval<T>) IntervalTreeKt.getEmptyInterval();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.compose.ui.graphics.Interval<T of androidx.compose.ui.graphics.IntervalTree>");
        return r106;
    }

    public final List<Interval<T>> findOverlaps(ClosedFloatingPointRange<Float> r100, List<Interval<T>> r101) {
        return findOverlaps(r100.getStart().floatValue(), r100.getEndInclusive().floatValue(), r101);
    }

    public final void forEach$ui_graphics_release(ClosedFloatingPointRange<Float> r100, Function1<? super Interval<T>, Unit> r101) {
        float r102 = r100.getStart().floatValue();
        float r103 = r100.getEndInclusive().floatValue();
        IntervalTree<T>.Node r104 = this.root;
        if (r104 == this.terminator) goto L29;
        ArrayList<IntervalTree<T>.Node> r105 = this.stack;
        r105.add(r104);
    L6:
        if (r105.size() <= 0) goto L20;
        Node r106 = (Node) ListProtector.remove(r105, r105.size() - 1);
        if (r106.overlaps(r102, r103) == false) goto L11;
        r101.invoke(r106);
    L11:
        if (r106.getLeft() == this.terminator) goto L16;
        if (r106.getLeft().getMax() < r102) goto L16;
        r105.add(r106.getLeft());
    L16:
        if (r106.getRight() == this.terminator) goto L6;
        if (r106.getRight().getMin() > r103) goto L6;
        r105.add(r106.getRight());
        goto L6
    L20:
        r105.clear();
        return;
    }

    public final void addInterval(float r100, float r110, T r111) {
        IntervalTree<T>.Node r101 = new Node(this, r100, r110, r111, 0);
        IntervalTree<T>.Node r102 = this.root;
        IntervalTree<T>.Node r112 = this.terminator;
    L4:
        if (r102 == this.terminator) goto L10;
        if (r101.getStart() > r102.getStart()) goto L8;
        IntervalTree<T>.Node r113 = r102.getLeft();
    L9:
        IntervalTree<T>.Node r103 = r113;
        r112 = r102;
        r102 = r103;
        goto L4
    L8:
        r113 = r102.getRight();
        goto L9
    L10:
        r101.setParent(r112);
        if (r112 != this.terminator) goto L14;
        this.root = r101;
    L17:
        updateNodeData(r101);
        rebalance(r101);
        return;
    L14:
        if (r101.getStart() > r112.getStart()) goto L16;
        r112.setLeft(r101);
        goto L17
    L16:
        r112.setRight(r101);
        goto L17
    }

    public final List<Interval<T>> findOverlaps(float r100, float r101, List<Interval<T>> r102) {
        IntervalTree<T>.Node r103 = this.root;
        if (r103 == this.terminator) goto L21;
        ArrayList<IntervalTree<T>.Node> r104 = this.stack;
        r104.add(r103);
    L6:
        if (r104.size() <= 0) goto L20;
        Node r105 = (Node) ListProtector.remove(r104, r104.size() - 1);
        if (r105.overlaps(r100, r101) == false) goto L11;
        r102.add(r105);
    L11:
        if (r105.getLeft() == this.terminator) goto L16;
        if (r105.getLeft().getMax() < r100) goto L16;
        r104.add(r105.getLeft());
    L16:
        if (r105.getRight() == this.terminator) goto L6;
        if (r105.getRight().getMin() > r101) goto L6;
        r104.add(r105.getRight());
        goto L6
    L20:
        r104.clear();
    L21:
        return r102;
    }

    public final void forEach$ui_graphics_release(float r100, float r101, Function1<? super Interval<T>, Unit> r102) {
        IntervalTree<T>.Node r103 = this.root;
        if (r103 == this.terminator) goto L29;
        ArrayList<IntervalTree<T>.Node> r104 = this.stack;
        r104.add(r103);
    L6:
        if (r104.size() <= 0) goto L20;
        Node r105 = (Node) ListProtector.remove(r104, r104.size() - 1);
        if (r105.overlaps(r100, r101) == false) goto L11;
        r102.invoke(r105);
    L11:
        if (r105.getLeft() == this.terminator) goto L16;
        if (r105.getLeft().getMax() < r100) goto L16;
        r104.add(r105.getLeft());
    L16:
        if (r105.getRight() == this.terminator) goto L6;
        if (r105.getRight().getMin() > r101) goto L6;
        r104.add(r105.getRight());
        goto L6
    L20:
        r104.clear();
        return;
    }

    public static /* synthetic */ Interval findFirstOverlap$default(IntervalTree r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r101;
    L6:
        return r100.findFirstOverlap(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List findOverlaps$default(IntervalTree r100, ClosedFloatingPointRange r101, List r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = new ArrayList();
    L6:
        return r100.findOverlaps(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List findOverlaps$default(IntervalTree r100, float r101, float r102, List r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = r101;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = new ArrayList();
    L9:
        return r100.findOverlaps(r101, r102, r103);
    }

    public static /* synthetic */ void forEach$ui_graphics_release$default(IntervalTree r100, float r101, float r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L5;
        r102 = r101;
    L5:
        IntervalTree<T>.Node r106 = r100.root;
        if (r106 == r100.terminator) goto L32;
        ArrayList<IntervalTree<T>.Node> r107 = r100.stack;
        r107.add(r106);
    L9:
        if (r107.size() <= 0) goto L23;
        Node r108 = (Node) ListProtector.remove(r107, r107.size() - 1);
        if (r108.overlaps(r101, r102) == false) goto L14;
        r103.invoke(r108);
    L14:
        if (r108.getLeft() == r100.terminator) goto L19;
        if (r108.getLeft().getMax() < r101) goto L19;
        r107.add(r108.getLeft());
    L19:
        if (r108.getRight() == r100.terminator) goto L9;
        if (r108.getRight().getMin() > r102) goto L9;
        r107.add(r108.getRight());
        goto L9
    L23:
        r107.clear();
        return;
    }
}
