package androidx.compose.ui.spatial;

import C7.r;
import S7.a;
import S7.k;
import S7.n;
import android.os.Trace;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Actual_androidKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.spatial.ThrottledCallbacks;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.p;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u001a\u001a\u00020\b*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001f\u001a\u00020\u001c*\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\b¢\u0006\u0004\b \u0010!J5\u0010*\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0010¢\u0006\u0004\b(\u0010)J\r\u0010+\u001a\u00020\b¢\u0006\u0004\b+\u0010!J\u0015\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020\f¢\u0006\u0004\b-\u0010.J\u001d\u00101\u001a\u0004\u0018\u00010\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u00020\b0/¢\u0006\u0004\b1\u00102JA\u0010<\u001a\u00020;2\u0006\u00103\u001a\u00020\u00102\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002042\u0006\u00108\u001a\u0002072\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\b09¢\u0006\u0004\b<\u0010=JA\u0010>\u001a\u00020;2\u0006\u00103\u001a\u00020\u00102\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002042\u0006\u00108\u001a\u0002072\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\b09¢\u0006\u0004\b>\u0010=J\u0017\u0010@\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b@\u0010AJ\u0015\u0010B\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\bB\u0010\nJ%\u0010E\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f¢\u0006\u0004\bE\u0010FJ\u0015\u0010G\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\bG\u0010\nJ\u001d\u0010H\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\bH\u0010\u000fJ\u0015\u0010I\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\bI\u0010\nJ\u001f\u0010N\u001a\u00020\f2\u0006\u0010J\u001a\u00020\u00102\u0006\u0010K\u001a\u00020\u0010H\u0000¢\u0006\u0004\bL\u0010MR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010OR\u0017\u0010Q\u001a\u00020P8\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR \u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0/0X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010\\R\u0016\u0010^\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020\b0/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010e\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010f¨\u0006g"}, d2 = {"Landroidx/compose/ui/spatial/RectManager;", "", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNodes", AppAgent.CONSTRUCT, "(Landroidx/collection/IntObjectMap;)V", "layoutNode", "LC7/r;", "recalculateOffsetFromRoot", "(Landroidx/compose/ui/node/LayoutNode;)V", "insertOrUpdateTransformedNodeSubhierarchy", "", "firstPlacement", "insertOrUpdateTransformedNode", "(Landroidx/compose/ui/node/LayoutNode;Z)V", "", "l", "t", "r", "b", "insertOrUpdate", "(Landroidx/compose/ui/node/LayoutNode;ZIIII)V", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/geometry/MutableRect;", "rect", "boundingRectInRoot", "(Landroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/geometry/MutableRect;)V", "Landroidx/compose/ui/unit/IntOffset;", "outerToInnerOffset-Bjo55l4", "(Landroidx/compose/ui/node/LayoutNode;)J", "outerToInnerOffset", "invalidate", "()V", "screenOffset", "windowOffset", "Landroidx/compose/ui/graphics/Matrix;", "viewToWindowMatrix", "windowWidth", "windowHeight", "updateOffsets-gTq6Wqs", "(JJ[FII)V", "updateOffsets", "dispatchCallbacks", "ensureSomethingScheduled", "scheduleDebounceCallback", "(Z)V", "Lkotlin/Function0;", "callback", "registerOnChangedCallback", "(LS7/a;)Ljava/lang/Object;", "id", "", "throttleMillis", "debounceMillis", "Landroidx/compose/ui/node/DelegatableNode;", "node", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "registerOnRectChangedCallback", "(IJJLandroidx/compose/ui/node/DelegatableNode;LS7/k;)Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "registerOnGlobalLayoutCallback", "token", "unregisterOnChangedCallback", "(Ljava/lang/Object;)V", "invalidateCallbacksFor", "focusable", "gesturable", "updateFlagsFor", "(Landroidx/compose/ui/node/LayoutNode;ZZ)V", "onLayoutLayerPositionalPropertiesChanged", "onLayoutPositionChanged", "remove", "targetId", "otherId", "isTargetDrawnFirst$ui_release", "(II)Z", "isTargetDrawnFirst", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/spatial/RectList;", "rects", "Landroidx/compose/ui/spatial/RectList;", "getRects", "()Landroidx/compose/ui/spatial/RectList;", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "throttledCallbacks", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "Landroidx/collection/MutableObjectList;", "callbacks", "Landroidx/collection/MutableObjectList;", "isDirty", "Z", "isScreenOrWindowDirty", "isFragmented", "dispatchToken", "Ljava/lang/Object;", "scheduledDispatchDeadline", "J", "dispatchLambda", "LS7/a;", "cachedRect", "Landroidx/compose/ui/geometry/MutableRect;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RectManager {
    public static final int $stable = 8;
    private final MutableRect cachedRect;
    private final MutableObjectList<a> callbacks;
    private final a dispatchLambda;
    private Object dispatchToken;
    private boolean isDirty;
    private boolean isFragmented;
    private boolean isScreenOrWindowDirty;
    private final IntObjectMap<LayoutNode> layoutNodes;
    private final RectList rects;
    private long scheduledDispatchDeadline;
    private final ThrottledCallbacks throttledCallbacks;

    /* JADX WARN: Multi-variable type inference failed */
    public RectManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void boundingRectInRoot(NodeCoordinator nodeCoordinator, MutableRect mutableRect) {
        while (nodeCoordinator != null) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            long position = nodeCoordinator.getPosition();
            float fM6972getXimpl = IntOffset.m6972getXimpl(position);
            float fM6973getYimpl = IntOffset.m6973getYimpl(position);
            mutableRect.m3880translatek4lQ0M(Offset.m3887constructorimpl((Float.floatToRawIntBits(fM6972getXimpl) << 32) | (Float.floatToRawIntBits(fM6973getYimpl) & 4294967295L)));
            nodeCoordinator = nodeCoordinator.getWrappedBy();
            if (layer != null) {
                float[] fArrMo5915getUnderlyingMatrixsQKQjiQ = layer.mo5915getUnderlyingMatrixsQKQjiQ();
                if (!MatrixKt.m4405isIdentity58bKbWc(fArrMo5915getUnderlyingMatrixsQKQjiQ)) {
                    Matrix.m4388mapimpl(fArrMo5915getUnderlyingMatrixsQKQjiQ, mutableRect);
                }
            }
        }
    }

    private final void insertOrUpdate(LayoutNode layoutNode, boolean firstPlacement, int l, int t9, int r5, int b) {
        int i;
        int i6;
        int i10;
        int i11;
        int semanticsId = layoutNode.getSemanticsId();
        if (!firstPlacement) {
            i = l;
            i6 = t9;
            i10 = r5;
            i11 = b;
            if (!this.rects.move(semanticsId, i, i6, i10, i11)) {
            }
            invalidate();
        }
        i = l;
        i6 = t9;
        i10 = r5;
        i11 = b;
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        this.rects.insert(semanticsId, i, i6, i10, i11, parent$ui_release != null ? parent$ui_release.getSemanticsId() : -1, layoutNode.getNodes().m5818hasH91voCI$ui_release(NodeKind.m5862constructorimpl(1024)), layoutNode.getNodes().m5818hasH91voCI$ui_release(NodeKind.m5862constructorimpl(16)));
        invalidate();
    }

    private final void insertOrUpdateTransformedNode(LayoutNode layoutNode, boolean firstPlacement) {
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
        int measuredWidth = measurePassDelegate$ui_release.getMeasuredWidth();
        int measuredHeight = measurePassDelegate$ui_release.getMeasuredHeight();
        MutableRect mutableRect = this.cachedRect;
        mutableRect.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        boundingRectInRoot(outerCoordinator$ui_release, mutableRect);
        int left = (int) mutableRect.getLeft();
        int top = (int) mutableRect.getTop();
        int right = (int) mutableRect.getRight();
        int bottom = (int) mutableRect.getBottom();
        int semanticsId = layoutNode.getSemanticsId();
        if (firstPlacement || !this.rects.update(semanticsId, left, top, right, bottom)) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            this.rects.insert(semanticsId, left, top, right, bottom, parent$ui_release != null ? parent$ui_release.getSemanticsId() : -1, layoutNode.getNodes().m5818hasH91voCI$ui_release(NodeKind.m5862constructorimpl(1024)), layoutNode.getNodes().m5818hasH91voCI$ui_release(NodeKind.m5862constructorimpl(16)));
        }
        invalidate();
    }

    private final void insertOrUpdateTransformedNodeSubhierarchy(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            insertOrUpdateTransformedNode(layoutNode2, false);
            insertOrUpdateTransformedNodeSubhierarchy(layoutNode2);
        }
    }

    /* renamed from: outerToInnerOffset-Bjo55l4, reason: not valid java name */
    private final long m6103outerToInnerOffsetBjo55l4(LayoutNode layoutNode) {
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        long jM3911getZeroF1C5BW0 = Offset.INSTANCE.m3911getZeroF1C5BW0();
        NodeCoordinator innerCoordinator$ui_release = layoutNode.getInnerCoordinator$ui_release();
        while (innerCoordinator$ui_release != null && innerCoordinator$ui_release != outerCoordinator$ui_release) {
            OwnedLayer layer = innerCoordinator$ui_release.getLayer();
            jM3911getZeroF1C5BW0 = IntOffsetKt.m6987plusNvtHpc(jM3911getZeroF1C5BW0, innerCoordinator$ui_release.getPosition());
            innerCoordinator$ui_release = innerCoordinator$ui_release.getWrappedBy();
            if (layer != null) {
                float[] fArrMo5915getUnderlyingMatrixsQKQjiQ = layer.mo5915getUnderlyingMatrixsQKQjiQ();
                int iM6108analyzeComponents58bKbWc = RectManagerKt.m6108analyzeComponents58bKbWc(fArrMo5915getUnderlyingMatrixsQKQjiQ);
                if (iM6108analyzeComponents58bKbWc == 3) {
                    continue;
                } else {
                    if ((iM6108analyzeComponents58bKbWc & 2) == 0) {
                        return IntOffset.INSTANCE.m6982getMaxnOccac();
                    }
                    jM3911getZeroF1C5BW0 = Matrix.m4386mapMKHz9U(fArrMo5915getUnderlyingMatrixsQKQjiQ, jM3911getZeroF1C5BW0);
                }
            }
        }
        return IntOffsetKt.m6989roundk4lQ0M(jM3911getZeroF1C5BW0);
    }

    private final void recalculateOffsetFromRoot(LayoutNode layoutNode) {
        long outerToInnerOffset;
        long position = layoutNode.getOuterCoordinator$ui_release().getPosition();
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            if (!RectManagerKt.m6109isSetgyyYBs(parent$ui_release.getOffsetFromRoot())) {
                recalculateOffsetFromRoot(parent$ui_release);
            }
            long offsetFromRoot = parent$ui_release.getOffsetFromRoot();
            if (RectManagerKt.m6109isSetgyyYBs(offsetFromRoot)) {
                if (parent$ui_release.getOuterToInnerOffsetDirty()) {
                    outerToInnerOffset = m6103outerToInnerOffsetBjo55l4(parent$ui_release);
                    parent$ui_release.m5763setOuterToInnerOffsetgyyYBs$ui_release(outerToInnerOffset);
                    parent$ui_release.setOuterToInnerOffsetDirty$ui_release(false);
                } else {
                    outerToInnerOffset = parent$ui_release.getOuterToInnerOffset();
                }
                position = !RectManagerKt.m6109isSetgyyYBs(outerToInnerOffset) ? IntOffset.INSTANCE.m6982getMaxnOccac() : IntOffset.m6976plusqkQi6aY(IntOffset.m6976plusqkQi6aY(offsetFromRoot, outerToInnerOffset), position);
            } else {
                position = IntOffset.INSTANCE.m6982getMaxnOccac();
            }
        }
        layoutNode.m5762setOffsetFromRootgyyYBs$ui_release(position);
    }

    public final void dispatchCallbacks() {
        long[] jArr;
        long[] jArr2;
        int i;
        final long jCurrentTimeMillis = Actual_androidKt.currentTimeMillis();
        boolean z10 = this.isDirty;
        int i6 = 0;
        boolean z11 = z10 || this.isScreenOrWindowDirty;
        if (z10) {
            this.isDirty = false;
            MutableObjectList<a> mutableObjectList = this.callbacks;
            Object[] objArr = mutableObjectList.content;
            int i10 = mutableObjectList._size;
            for (int i11 = 0; i11 < i10; i11++) {
                ((a) objArr[i11]).invoke();
            }
            RectList rectList = this.rects;
            long[] jArr3 = rectList.items;
            int i12 = rectList.itemsSize;
            for (int i13 = 0; i13 < jArr3.length - 2 && i13 < i12; i13 += 3) {
                long j5 = jArr3[i13 + 2];
                if ((((int) (j5 >> 61)) & 1) != 0) {
                    this.throttledCallbacks.fireOnUpdatedRect(67108863 & ((int) j5), jArr3[i13], jArr3[i13 + 1], jCurrentTimeMillis);
                }
            }
            MutableIntObjectMap<ThrottledCallbacks.Entry> rectChangedMap = this.throttledCallbacks.getRectChangedMap();
            Object[] objArr2 = rectChangedMap.values;
            long[] jArr4 = rectChangedMap.metadata;
            int length = jArr4.length - 2;
            if (length >= 0) {
                int i14 = 0;
                while (true) {
                    long j6 = jArr4[i14];
                    if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i15 = 8;
                        int i16 = 8 - ((~(i14 - length)) >>> 31);
                        int i17 = i6;
                        while (i17 < i16) {
                            if ((255 & j6) < 128) {
                                final ThrottledCallbacks.Entry entry = (ThrottledCallbacks.Entry) objArr2[(i14 << 3) + i17];
                                ThrottledCallbacks.Entry next = entry;
                                while (next != null) {
                                    if (entry.getLastInvokeMillis() == Long.MIN_VALUE) {
                                        i = i15;
                                        jArr2 = jArr4;
                                        this.rects.withTopLeftBottomRight(entry.getId(), new n() { // from class: androidx.compose.ui.spatial.RectManager$dispatchCallbacks$3$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // S7.n
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke(((Number) obj).longValue(), ((Number) obj2).longValue());
                                                return r.f317a;
                                            }

                                            public final void invoke(long j10, long j11) {
                                                this.this$0.throttledCallbacks.fireWithUpdatedRect$ui_release(entry, j10, j11, jCurrentTimeMillis);
                                            }
                                        });
                                    } else {
                                        jArr2 = jArr4;
                                        i = i15;
                                    }
                                    next = next.getNext();
                                    i15 = i;
                                    jArr4 = jArr2;
                                }
                            }
                            int i18 = i15;
                            j6 >>= i18;
                            i17++;
                            i15 = i18;
                            jArr4 = jArr4;
                        }
                        jArr = jArr4;
                        if (i16 != i15) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                    }
                    if (i14 == length) {
                        break;
                    }
                    i14++;
                    jArr4 = jArr;
                    i6 = 0;
                }
            }
            this.rects.clearUpdated();
        }
        if (this.isScreenOrWindowDirty) {
            this.isScreenOrWindowDirty = false;
            this.throttledCallbacks.fireOnRectChangedEntries(jCurrentTimeMillis);
        }
        if (z11) {
            this.throttledCallbacks.fireGlobalChangeEntries(jCurrentTimeMillis);
        }
        if (this.isFragmented) {
            this.isFragmented = false;
            this.rects.defragment();
        }
        this.throttledCallbacks.triggerDebounced(jCurrentTimeMillis);
    }

    public final RectList getRects() {
        return this.rects;
    }

    public final void invalidate() {
        this.isDirty = true;
    }

    public final void invalidateCallbacksFor(LayoutNode layoutNode) {
        this.isDirty = true;
        this.rects.markUpdated(layoutNode.getSemanticsId());
        scheduleDebounceCallback(true);
    }

    public final boolean isTargetDrawnFirst$ui_release(int targetId, int otherId) {
        LayoutNode parent$ui_release;
        LayoutNode parent$ui_release2;
        LayoutNode parent$ui_release3 = this.layoutNodes.get(targetId);
        if (parent$ui_release3 != null && (parent$ui_release = this.layoutNodes.get(otherId)) != null && parent$ui_release3.getDepth() != 0 && parent$ui_release.getDepth() != 0) {
            while (parent$ui_release3.getDepth() > parent$ui_release.getDepth()) {
                parent$ui_release3 = parent$ui_release3.getParent$ui_release();
                if (parent$ui_release3 == null) {
                    return false;
                }
            }
            if (parent$ui_release3 == parent$ui_release) {
                return false;
            }
            while (parent$ui_release.getDepth() > parent$ui_release3.getDepth()) {
                parent$ui_release = parent$ui_release.getParent$ui_release();
                if (parent$ui_release == null) {
                    return false;
                }
            }
            if (parent$ui_release3 == parent$ui_release) {
                return false;
            }
            LayoutNode layoutNode = parent$ui_release3;
            LayoutNode layoutNode2 = layoutNode;
            LayoutNode layoutNode3 = parent$ui_release;
            while (layoutNode != parent$ui_release) {
                LayoutNode parent$ui_release4 = layoutNode.getParent$ui_release();
                if (parent$ui_release4 == null || (parent$ui_release2 = parent$ui_release.getParent$ui_release()) == null) {
                    return false;
                }
                layoutNode3 = parent$ui_release;
                parent$ui_release = parent$ui_release2;
                layoutNode2 = layoutNode;
                layoutNode = parent$ui_release4;
            }
            if (layoutNode2.getMeasurePassDelegate$ui_release().getZIndex() == layoutNode3.getMeasurePassDelegate$ui_release().getZIndex()) {
                return layoutNode2.getPlaceOrder$ui_release() < layoutNode3.getPlaceOrder$ui_release();
            }
            if (layoutNode2.getMeasurePassDelegate$ui_release().getZIndex() < layoutNode3.getMeasurePassDelegate$ui_release().getZIndex()) {
                return true;
            }
        }
        return false;
    }

    public final void onLayoutLayerPositionalPropertiesChanged(LayoutNode layoutNode) {
        if (ComposeUiFlags.isRectTrackingEnabled) {
            long jM6103outerToInnerOffsetBjo55l4 = m6103outerToInnerOffsetBjo55l4(layoutNode);
            if (!RectManagerKt.m6109isSetgyyYBs(jM6103outerToInnerOffsetBjo55l4)) {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
                return;
            }
            layoutNode.m5763setOuterToInnerOffsetgyyYBs$ui_release(jM6103outerToInnerOffsetBjo55l4);
            layoutNode.setOuterToInnerOffsetDirty$ui_release(false);
            MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                onLayoutPositionChanged(layoutNodeArr[i], false);
            }
            invalidateCallbacksFor(layoutNode);
        }
    }

    public final void onLayoutPositionChanged(LayoutNode layoutNode, boolean firstPlacement) {
        if (ComposeUiFlags.isRectTrackingEnabled) {
            MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
            int measuredWidth = measurePassDelegate$ui_release.getMeasuredWidth();
            int measuredHeight = measurePassDelegate$ui_release.getMeasuredHeight();
            long offsetFromRoot = layoutNode.getOffsetFromRoot();
            long lastSize = layoutNode.getLastSize();
            int i = (int) (lastSize >> 32);
            int i6 = (int) (lastSize & 4294967295L);
            recalculateOffsetFromRoot(layoutNode);
            long offsetFromRoot2 = layoutNode.getOffsetFromRoot();
            if (!RectManagerKt.m6109isSetgyyYBs(offsetFromRoot2)) {
                insertOrUpdateTransformedNode(layoutNode, firstPlacement);
                return;
            }
            layoutNode.m5761setLastSizeozmzZPI$ui_release(IntSize.m7010constructorimpl((measuredWidth << 32) | (4294967295L & measuredHeight)));
            int iM6972getXimpl = IntOffset.m6972getXimpl(offsetFromRoot2);
            int iM6973getYimpl = IntOffset.m6973getYimpl(offsetFromRoot2);
            int i10 = iM6972getXimpl + measuredWidth;
            int i11 = iM6973getYimpl + measuredHeight;
            if (!firstPlacement && IntOffset.m6971equalsimpl0(offsetFromRoot2, offsetFromRoot) && i == measuredWidth && i6 == measuredHeight) {
                return;
            }
            insertOrUpdate(layoutNode, firstPlacement, iM6972getXimpl, iM6973getYimpl, i10, i11);
        }
    }

    public final Object registerOnChangedCallback(a callback) {
        this.callbacks.add(callback);
        return callback;
    }

    public final DelegatableNode.RegistrationHandle registerOnGlobalLayoutCallback(int id, long throttleMillis, long debounceMillis, DelegatableNode node, k callback) {
        return this.throttledCallbacks.registerOnGlobalChange(id, throttleMillis, debounceMillis, node, callback);
    }

    public final DelegatableNode.RegistrationHandle registerOnRectChangedCallback(int id, long throttleMillis, long debounceMillis, DelegatableNode node, k callback) {
        DelegatableNode.RegistrationHandle registrationHandleRegisterOnRectChanged = this.throttledCallbacks.registerOnRectChanged(id, throttleMillis, debounceMillis, node, callback);
        invalidate();
        scheduleDebounceCallback(true);
        return registrationHandleRegisterOnRectChanged;
    }

    public final void remove(LayoutNode layoutNode) {
        this.rects.remove(layoutNode.getSemanticsId());
        invalidate();
        this.isFragmented = true;
    }

    public final void scheduleDebounceCallback(boolean ensureSomethingScheduled) {
        boolean z10 = (ensureSomethingScheduled && this.dispatchToken == null) ? false : true;
        long minDebounceDeadline = this.throttledCallbacks.getMinDebounceDeadline();
        if (minDebounceDeadline >= 0 || !z10) {
            if (this.scheduledDispatchDeadline == minDebounceDeadline && z10) {
                return;
            }
            Object obj = this.dispatchToken;
            if (obj != null) {
                Actual_androidKt.removePost(obj);
            }
            long jCurrentTimeMillis = Actual_androidKt.currentTimeMillis();
            long jMax = Math.max(minDebounceDeadline, 16 + jCurrentTimeMillis);
            this.scheduledDispatchDeadline = jMax;
            this.dispatchToken = Actual_androidKt.postDelayed(jMax - jCurrentTimeMillis, this.dispatchLambda);
        }
    }

    public final void unregisterOnChangedCallback(Object token) {
        if ((p.g(0, token) ? (a) token : null) == null) {
            return;
        }
        this.callbacks.remove(token);
    }

    public final void updateFlagsFor(LayoutNode layoutNode, boolean focusable, boolean gesturable) {
        if (layoutNode.isAttached()) {
            this.rects.updateFlagsFor(layoutNode.getSemanticsId(), focusable, gesturable);
        }
    }

    /* renamed from: updateOffsets-gTq6Wqs, reason: not valid java name */
    public final void m6104updateOffsetsgTq6Wqs(long screenOffset, long windowOffset, float[] viewToWindowMatrix, int windowWidth, int windowHeight) {
        int iM6108analyzeComponents58bKbWc = RectManagerKt.m6108analyzeComponents58bKbWc(viewToWindowMatrix);
        ThrottledCallbacks throttledCallbacks = this.throttledCallbacks;
        if ((iM6108analyzeComponents58bKbWc & 2) != 0) {
            viewToWindowMatrix = null;
        }
        this.isScreenOrWindowDirty = throttledCallbacks.m6122updateOffsetsLDcG7Xg(screenOffset, windowOffset, viewToWindowMatrix, windowWidth, windowHeight) || this.isScreenOrWindowDirty;
    }

    public RectManager(IntObjectMap<LayoutNode> intObjectMap) {
        this.layoutNodes = intObjectMap;
        this.rects = new RectList();
        this.throttledCallbacks = new ThrottledCallbacks();
        this.callbacks = new MutableObjectList<>(0, 1, null);
        this.scheduledDispatchDeadline = -1L;
        this.dispatchLambda = new a() { // from class: androidx.compose.ui.spatial.RectManager$dispatchLambda$1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m6105invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m6105invoke() {
                this.this$0.dispatchToken = null;
                RectManager rectManager = this.this$0;
                Trace.beginSection("OnPositionedDispatch");
                try {
                    rectManager.dispatchCallbacks();
                } finally {
                    Trace.endSection();
                }
            }
        };
        this.cachedRect = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public /* synthetic */ RectManager(IntObjectMap intObjectMap, int i, e eVar) {
        this((i & 1) != 0 ? IntObjectMapKt.intObjectMapOf() : intObjectMap);
    }
}
