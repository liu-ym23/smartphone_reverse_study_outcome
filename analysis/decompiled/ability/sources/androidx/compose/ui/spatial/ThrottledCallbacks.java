package androidx.compose.ui.spatial;

import S7.k;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.IntOffset;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b&\b\u0001\u0018\u00002\u00020\u0001:\u0001gB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJA\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0004\b\u001b\u0010\u001cJA\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ-\u0010!\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011¢\u0006\u0004\b!\u0010\"J(\u0010$\u001a\u00020\u00182\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060#R\u00020\u0000\u0012\u0004\u0012\u00020\u00180\u0016H\u0086\b¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0011¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0011¢\u0006\u0004\b(\u0010'J\u0015\u0010)\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0011¢\u0006\u0004\b)\u0010'J3\u0010-\u001a\u00020\u00182\n\u0010*\u001a\u00060#R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0000¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0011H\u0002¢\u0006\u0004\b/\u00100J=\u00106\u001a\u00020\u00182\n\u0010*\u001a\u00060#R\u00020\u00002\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u0011H\u0002¢\u0006\u0004\b4\u00105JE\u0010:\u001a\u00020\u00112\n\u0010*\u001a\u00060#R\u00020\u00002\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u00112\u0006\u00107\u001a\u00020\u0011H\u0002¢\u0006\u0004\b8\u00109J\u001b\u0010;\u001a\u00020\u00182\n\u0010*\u001a\u00060#R\u00020\u0000H\u0002¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u00020\f2\n\u0010*\u001a\u00060#R\u00020\u0000H\u0002¢\u0006\u0004\b=\u0010>J0\u0010@\u001a\u00020\u0018*\u00060#R\u00020\u00002\u0016\u0010?\u001a\u0012\u0012\b\u0012\u00060#R\u00020\u0000\u0012\u0004\u0012\u00020\u00180\u0016H\u0082\b¢\u0006\u0004\b@\u0010AJ6\u0010C\u001a\u00020\u0018*\f\u0012\b\u0012\u00060#R\u00020\u00000B2\u0016\u0010?\u001a\u0012\u0012\b\u0012\u00060#R\u00020\u0000\u0012\u0004\u0012\u00020\u00180\u0016H\u0082\b¢\u0006\u0004\bC\u0010DJ>\u0010E\u001a\u00020\u0018*\f\u0012\b\u0012\u00060#R\u00020\u00000B2\u0006\u0010\u0010\u001a\u00020\t2\u0016\u0010?\u001a\u0012\u0012\b\u0012\u00060#R\u00020\u0000\u0012\u0004\u0012\u00020\u00180\u0016H\u0082\b¢\u0006\u0004\bE\u0010FJ5\u0010I\u001a\u00060#R\u00020\u0000*\f\u0012\b\u0012\u00060#R\u00020\u00000B2\u0006\u0010G\u001a\u00020\t2\n\u0010H\u001a\u00060#R\u00020\u0000H\u0002¢\u0006\u0004\bI\u0010JJ1\u0010K\u001a\u00020\f*\f\u0012\b\u0012\u00060#R\u00020\u00000B2\u0006\u0010G\u001a\u00020\t2\n\u0010H\u001a\u00060#R\u00020\u0000H\u0002¢\u0006\u0004\bK\u0010LR!\u0010M\u001a\f\u0012\b\u0012\u00060#R\u00020\u00000B8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR(\u0010Q\u001a\b\u0018\u00010#R\u00020\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010<R\"\u0010V\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010'R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010W\u001a\u0004\b[\u0010Y\"\u0004\b\\\u0010'R\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010W\u001a\u0004\b]\u0010Y\"\u0004\b^\u0010'R\"\u0010_\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010W\u001a\u0004\b`\u0010Y\"\u0004\ba\u0010'R$\u00103\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010f¨\u0006h"}, d2 = {"Landroidx/compose/ui/spatial/ThrottledCallbacks;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/unit/IntOffset;", "screen", "window", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "", "windowWidth", "windowHeight", "", "updateOffsets-LDcG7Xg", "(JJ[FII)Z", "updateOffsets", "id", "", "throttleMillis", "debounceMillis", "Landroidx/compose/ui/node/DelegatableNode;", "node", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "LC7/r;", "callback", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "registerOnRectChanged", "(IJJLandroidx/compose/ui/node/DelegatableNode;LS7/k;)Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "registerOnGlobalChange", "topLeft", "bottomRight", "currentMillis", "fireOnUpdatedRect", "(IJJJ)V", "Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "forEachNewCallbackNeverInvoked", "(LS7/k;)V", "fireOnRectChangedEntries", "(J)V", "fireGlobalChangeEntries", "triggerDebounced", "entry", "fireWithUpdatedRect$ui_release", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;JJJ)V", "fireWithUpdatedRect", "x", "roundDownToMultipleOf8", "(J)J", "windowOffset", "screenOffset", "viewToWindowMatrix", "fire-WY9HvpM", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;JJ[FJ)V", "fire", "minDeadline", "debounceEntry-b8qMvQI", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;JJ[FJJ)J", "debounceEntry", "addToGlobalEntries", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;)V", "removeFromGlobalEntries", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;)Z", "block", "linkedForEach", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;LS7/k;)V", "Landroidx/collection/MutableIntObjectMap;", "multiForEach", "(Landroidx/collection/MutableIntObjectMap;LS7/k;)V", "runFor", "(Landroidx/collection/MutableIntObjectMap;ILS7/k;)V", "key", "value", "multiPut", "(Landroidx/collection/MutableIntObjectMap;ILandroidx/compose/ui/spatial/ThrottledCallbacks$Entry;)Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "multiRemove", "(Landroidx/collection/MutableIntObjectMap;ILandroidx/compose/ui/spatial/ThrottledCallbacks$Entry;)Z", "rectChangedMap", "Landroidx/collection/MutableIntObjectMap;", "getRectChangedMap", "()Landroidx/collection/MutableIntObjectMap;", "globalChangeEntries", "Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "getGlobalChangeEntries", "()Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "setGlobalChangeEntries", "minDebounceDeadline", "J", "getMinDebounceDeadline", "()J", "setMinDebounceDeadline", "getWindowOffset-nOcc-ac", "setWindowOffset--gyyYBs", "getScreenOffset-nOcc-ac", "setScreenOffset--gyyYBs", "windowSize", "getWindowSize", "setWindowSize", "[F", "getViewToWindowMatrix-3i98HWw", "()[F", "setViewToWindowMatrix-Q8lPUPs", "([F)V", "Entry", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ThrottledCallbacks {
    public static final int $stable = 8;
    private Entry globalChangeEntries;
    private long screenOffset;
    private float[] viewToWindowMatrix;
    private long windowOffset;
    private long windowSize;
    private final MutableIntObjectMap<Entry> rectChangedMap = IntObjectMapKt.mutableIntObjectMapOf();
    private long minDebounceDeadline = -1;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b!\u0010 R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$R#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010'R(\u0010)\u001a\b\u0018\u00010\u0000R\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b/\u0010 \"\u0004\b0\u00101R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b2\u0010 \"\u0004\b3\u00101R\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u001e\u001a\u0004\b5\u0010 \"\u0004\b6\u00101R\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u001e\u001a\u0004\b8\u0010 \"\u0004\b9\u00101¨\u0006:"}, d2 = {"Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "", "id", "", "throttleMillis", "debounceMillis", "Landroidx/compose/ui/node/DelegatableNode;", "node", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "LC7/r;", "callback", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/spatial/ThrottledCallbacks;IJJLandroidx/compose/ui/node/DelegatableNode;LS7/k;)V", "unregister", "()V", "topLeft", "bottomRight", "Landroidx/compose/ui/unit/IntOffset;", "windowOffset", "screenOffset", "Landroidx/compose/ui/graphics/Matrix;", "viewToWindowMatrix", "fire-9b-9wPM", "(JJJJ[F)V", "fire", "I", "getId", "()I", "J", "getThrottleMillis", "()J", "getDebounceMillis", "Landroidx/compose/ui/node/DelegatableNode;", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "LS7/k;", "getCallback", "()LS7/k;", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "next", "Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "getNext", "()Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "setNext", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;)V", "getTopLeft", "setTopLeft", "(J)V", "getBottomRight", "setBottomRight", "lastInvokeMillis", "getLastInvokeMillis", "setLastInvokeMillis", "lastUninvokedFireMillis", "getLastUninvokedFireMillis", "setLastUninvokedFireMillis", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class Entry implements DelegatableNode.RegistrationHandle {
        private long bottomRight;
        private final k callback;
        private final long debounceMillis;
        private final int id;
        private long lastInvokeMillis = Long.MIN_VALUE;
        private long lastUninvokedFireMillis = -1;
        private Entry next;
        private final DelegatableNode node;
        private final long throttleMillis;
        private long topLeft;

        public Entry(int i, long j5, long j6, DelegatableNode delegatableNode, k kVar) {
            this.id = i;
            this.throttleMillis = j5;
            this.debounceMillis = j6;
            this.node = delegatableNode;
            this.callback = kVar;
        }

        /* renamed from: fire-9b-9wPM, reason: not valid java name */
        public final void m6123fire9b9wPM(long topLeft, long bottomRight, long windowOffset, long screenOffset, float[] viewToWindowMatrix) {
            RelativeLayoutBounds relativeLayoutBoundsM6124rectInfoForDg36KO4 = ThrottledCallbacksKt.m6124rectInfoForDg36KO4(this.node, topLeft, bottomRight, windowOffset, screenOffset, ThrottledCallbacks.this.getWindowSize(), viewToWindowMatrix);
            if (relativeLayoutBoundsM6124rectInfoForDg36KO4 == null) {
                return;
            }
            this.callback.invoke(relativeLayoutBoundsM6124rectInfoForDg36KO4);
        }

        public final long getBottomRight() {
            return this.bottomRight;
        }

        public final k getCallback() {
            return this.callback;
        }

        public final long getDebounceMillis() {
            return this.debounceMillis;
        }

        public final int getId() {
            return this.id;
        }

        public final long getLastInvokeMillis() {
            return this.lastInvokeMillis;
        }

        public final long getLastUninvokedFireMillis() {
            return this.lastUninvokedFireMillis;
        }

        public final Entry getNext() {
            return this.next;
        }

        public final DelegatableNode getNode() {
            return this.node;
        }

        public final long getThrottleMillis() {
            return this.throttleMillis;
        }

        public final long getTopLeft() {
            return this.topLeft;
        }

        public final void setBottomRight(long j5) {
            this.bottomRight = j5;
        }

        public final void setLastInvokeMillis(long j5) {
            this.lastInvokeMillis = j5;
        }

        public final void setLastUninvokedFireMillis(long j5) {
            this.lastUninvokedFireMillis = j5;
        }

        public final void setNext(Entry entry) {
            this.next = entry;
        }

        public final void setTopLeft(long j5) {
            this.topLeft = j5;
        }

        @Override // androidx.compose.ui.node.DelegatableNode.RegistrationHandle
        public void unregister() {
            ThrottledCallbacks throttledCallbacks = ThrottledCallbacks.this;
            if (throttledCallbacks.multiRemove(throttledCallbacks.getRectChangedMap(), this.id, this)) {
                return;
            }
            ThrottledCallbacks.this.removeFromGlobalEntries(this);
        }
    }

    public ThrottledCallbacks() {
        IntOffset.Companion companion = IntOffset.INSTANCE;
        this.windowOffset = companion.m6983getZeronOccac();
        this.screenOffset = companion.m6983getZeronOccac();
    }

    private final void addToGlobalEntries(Entry entry) {
        entry.setNext(this.globalChangeEntries);
        this.globalChangeEntries = entry;
    }

    /* renamed from: debounceEntry-b8qMvQI, reason: not valid java name */
    private final long m6114debounceEntryb8qMvQI(Entry entry, long windowOffset, long screenOffset, float[] viewToWindowMatrix, long currentMillis, long minDeadline) {
        if (entry.getDebounceMillis() <= 0 || entry.getLastUninvokedFireMillis() <= 0) {
            return minDeadline;
        }
        if (currentMillis - entry.getLastUninvokedFireMillis() <= entry.getDebounceMillis()) {
            return Math.min(minDeadline, entry.getDebounceMillis() + entry.getLastUninvokedFireMillis());
        }
        entry.setLastInvokeMillis(currentMillis);
        entry.setLastUninvokedFireMillis(-1L);
        entry.m6123fire9b9wPM(entry.getTopLeft(), entry.getBottomRight(), windowOffset, screenOffset, viewToWindowMatrix);
        return minDeadline;
    }

    /* renamed from: fire-WY9HvpM, reason: not valid java name */
    private final void m6115fireWY9HvpM(Entry entry, long windowOffset, long screenOffset, float[] viewToWindowMatrix, long currentMillis) {
        long lastInvokeMillis = entry.getLastInvokeMillis();
        boolean z10 = currentMillis - lastInvokeMillis > entry.getThrottleMillis() || lastInvokeMillis == Long.MIN_VALUE;
        boolean z11 = entry.getDebounceMillis() == 0;
        entry.setLastUninvokedFireMillis(currentMillis);
        if (z10 && z11) {
            entry.setLastInvokeMillis(currentMillis);
            entry.m6123fire9b9wPM(entry.getTopLeft(), entry.getBottomRight(), windowOffset, screenOffset, viewToWindowMatrix);
        }
        if (z11) {
            return;
        }
        long j5 = this.minDebounceDeadline;
        long debounceMillis = entry.getDebounceMillis() + currentMillis;
        if (j5 <= 0 || debounceMillis >= j5) {
            return;
        }
        this.minDebounceDeadline = j5;
    }

    private final void linkedForEach(Entry entry, k kVar) {
        while (entry != null) {
            kVar.invoke(entry);
            entry = entry.getNext();
        }
    }

    private final void multiForEach(MutableIntObjectMap<Entry> mutableIntObjectMap, k kVar) {
        Object[] objArr = mutableIntObjectMap.values;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        for (Entry next = (Entry) objArr[(i << 3) + i10]; next != null; next = next.getNext()) {
                            kVar.invoke(next);
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final Entry multiPut(MutableIntObjectMap<Entry> mutableIntObjectMap, int i, Entry entry) {
        Entry entry2 = mutableIntObjectMap.get(i);
        if (entry2 == null) {
            mutableIntObjectMap.set(i, entry);
            entry2 = entry;
        }
        Entry next = entry2;
        if (next != entry) {
            while (next.getNext() != null) {
                next = next.getNext();
                kotlin.jvm.internal.k.c(next);
            }
            next.setNext(entry);
        }
        return entry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean multiRemove(androidx.collection.MutableIntObjectMap<androidx.compose.ui.spatial.ThrottledCallbacks.Entry> r5, int r6, androidx.compose.ui.spatial.ThrottledCallbacks.Entry r7) {
        /*
            r4 = this;
            java.lang.Object r4 = r5.remove(r6)
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r4 = (androidx.compose.ui.spatial.ThrottledCallbacks.Entry) r4
            r0 = 0
            if (r4 != 0) goto La
            return r0
        La:
            boolean r1 = r4.equals(r7)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1f
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r4 = r7.getNext()
            r7.setNext(r3)
            if (r4 == 0) goto L1e
            r5.put(r6, r4)
        L1e:
            return r2
        L1f:
            r5.put(r6, r4)
        L22:
            if (r4 == 0) goto L3d
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r5 = r4.getNext()
            if (r5 != 0) goto L2b
            return r0
        L2b:
            if (r5 != r7) goto L38
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r5 = r7.getNext()
            r4.setNext(r5)
            r7.setNext(r3)
            goto L3d
        L38:
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r4 = r4.getNext()
            goto L22
        L3d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.spatial.ThrottledCallbacks.multiRemove(androidx.collection.MutableIntObjectMap, int, androidx.compose.ui.spatial.ThrottledCallbacks$Entry):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeFromGlobalEntries(Entry entry) {
        Entry entry2 = this.globalChangeEntries;
        if (entry2 == entry) {
            this.globalChangeEntries = entry2.getNext();
            entry.setNext(null);
            return true;
        }
        Entry next = entry2 != null ? entry2.getNext() : null;
        while (true) {
            Entry entry3 = entry2;
            entry2 = next;
            if (entry2 == null) {
                return false;
            }
            if (entry2 == entry) {
                if (entry3 != null) {
                    entry3.setNext(entry2.getNext());
                }
                entry.setNext(null);
                return true;
            }
            next = entry2.getNext();
        }
    }

    private final long roundDownToMultipleOf8(long x10) {
        return (x10 >> 3) << 3;
    }

    private final void runFor(MutableIntObjectMap<Entry> mutableIntObjectMap, int i, k kVar) {
        for (Entry next = mutableIntObjectMap.get(i); next != null; next = next.getNext()) {
            kVar.invoke(next);
        }
    }

    public final void fireGlobalChangeEntries(long currentMillis) {
        long j5 = this.windowOffset;
        long j6 = this.screenOffset;
        float[] fArr = this.viewToWindowMatrix;
        Entry entry = this.globalChangeEntries;
        if (entry != null) {
            for (Entry next = entry; next != null; next = next.getNext()) {
                LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(next.getNode());
                long offsetFromRoot = layoutNodeRequireLayoutNode.getOffsetFromRoot();
                long lastSize = layoutNodeRequireLayoutNode.getLastSize();
                next.setTopLeft(offsetFromRoot);
                next.setBottomRight(((IntOffset.m6972getXimpl(offsetFromRoot) + ((int) (lastSize >> 32))) << 32) | ((IntOffset.m6973getYimpl(offsetFromRoot) + ((int) (lastSize & 4294967295L))) & 4294967295L));
                m6115fireWY9HvpM(next, j5, j6, fArr, currentMillis);
            }
        }
    }

    public final void fireOnRectChangedEntries(long currentMillis) {
        ThrottledCallbacks throttledCallbacks = this;
        long j5 = throttledCallbacks.windowOffset;
        long j6 = throttledCallbacks.screenOffset;
        float[] fArr = throttledCallbacks.viewToWindowMatrix;
        MutableIntObjectMap<Entry> mutableIntObjectMap = throttledCallbacks.rectChangedMap;
        Object[] objArr = mutableIntObjectMap.values;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j10 = jArr[i];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                long j11 = j10;
                int i10 = 0;
                while (i10 < i6) {
                    if ((j11 & 255) < 128) {
                        Entry next = (Entry) objArr[(i << 3) + i10];
                        while (next != null) {
                            int i11 = i10;
                            Entry entry = next;
                            throttledCallbacks.m6115fireWY9HvpM(entry, j5, j6, fArr, currentMillis);
                            next = entry.getNext();
                            throttledCallbacks = this;
                            i10 = i11;
                        }
                    }
                    j11 >>= 8;
                    i10++;
                    throttledCallbacks = this;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
            throttledCallbacks = this;
        }
    }

    public final void fireOnUpdatedRect(int id, long topLeft, long bottomRight, long currentMillis) {
        for (Entry next = this.rectChangedMap.get(id); next != null; next = next.getNext()) {
            fireWithUpdatedRect$ui_release(next, topLeft, bottomRight, currentMillis);
        }
    }

    public final void fireWithUpdatedRect$ui_release(Entry entry, long topLeft, long bottomRight, long currentMillis) {
        long lastInvokeMillis = entry.getLastInvokeMillis();
        long throttleMillis = entry.getThrottleMillis();
        long debounceMillis = entry.getDebounceMillis();
        boolean z10 = currentMillis - lastInvokeMillis >= throttleMillis || lastInvokeMillis == Long.MIN_VALUE;
        boolean z11 = debounceMillis == 0;
        boolean z12 = throttleMillis == 0;
        entry.setTopLeft(topLeft);
        entry.setBottomRight(bottomRight);
        boolean z13 = !(z11 || z12) || z11;
        if (z10 && z13) {
            entry.setLastUninvokedFireMillis(-1L);
            entry.setLastInvokeMillis(currentMillis);
            entry.m6123fire9b9wPM(topLeft, bottomRight, this.windowOffset, this.screenOffset, this.viewToWindowMatrix);
        } else {
            if (z11) {
                return;
            }
            entry.setLastUninvokedFireMillis(currentMillis);
            long j5 = this.minDebounceDeadline;
            long j6 = currentMillis + debounceMillis;
            if (j5 <= 0 || j6 >= j5) {
                return;
            }
            this.minDebounceDeadline = j5;
        }
    }

    public final void forEachNewCallbackNeverInvoked(k callback) {
        MutableIntObjectMap<Entry> rectChangedMap = getRectChangedMap();
        Object[] objArr = rectChangedMap.values;
        long[] jArr = rectChangedMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        Entry entry = (Entry) objArr[(i << 3) + i10];
                        for (Entry next = entry; next != null; next = next.getNext()) {
                            if (entry.getLastInvokeMillis() == Long.MIN_VALUE) {
                                callback.invoke(entry);
                            }
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final Entry getGlobalChangeEntries() {
        return this.globalChangeEntries;
    }

    public final long getMinDebounceDeadline() {
        return this.minDebounceDeadline;
    }

    public final MutableIntObjectMap<Entry> getRectChangedMap() {
        return this.rectChangedMap;
    }

    /* renamed from: getScreenOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getScreenOffset() {
        return this.screenOffset;
    }

    /* renamed from: getViewToWindowMatrix-3i98HWw, reason: not valid java name and from getter */
    public final float[] getViewToWindowMatrix() {
        return this.viewToWindowMatrix;
    }

    /* renamed from: getWindowOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getWindowOffset() {
        return this.windowOffset;
    }

    public final long getWindowSize() {
        return this.windowSize;
    }

    public final DelegatableNode.RegistrationHandle registerOnGlobalChange(int id, long throttleMillis, long debounceMillis, DelegatableNode node, k callback) {
        Entry entry = new Entry(id, throttleMillis, debounceMillis == 0 ? throttleMillis : debounceMillis, node, callback);
        addToGlobalEntries(entry);
        return entry;
    }

    public final DelegatableNode.RegistrationHandle registerOnRectChanged(int id, long throttleMillis, long debounceMillis, DelegatableNode node, k callback) {
        return multiPut(this.rectChangedMap, id, new Entry(id, throttleMillis, debounceMillis == 0 ? throttleMillis : debounceMillis, node, callback));
    }

    public final void setGlobalChangeEntries(Entry entry) {
        this.globalChangeEntries = entry;
    }

    public final void setMinDebounceDeadline(long j5) {
        this.minDebounceDeadline = j5;
    }

    /* renamed from: setScreenOffset--gyyYBs, reason: not valid java name */
    public final void m6119setScreenOffsetgyyYBs(long j5) {
        this.screenOffset = j5;
    }

    /* renamed from: setViewToWindowMatrix-Q8lPUPs, reason: not valid java name */
    public final void m6120setViewToWindowMatrixQ8lPUPs(float[] fArr) {
        this.viewToWindowMatrix = fArr;
    }

    /* renamed from: setWindowOffset--gyyYBs, reason: not valid java name */
    public final void m6121setWindowOffsetgyyYBs(long j5) {
        this.windowOffset = j5;
    }

    public final void setWindowSize(long j5) {
        this.windowSize = j5;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008c A[LOOP:0: B:8:0x0023->B:25:0x008c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0096 A[EDGE_INSN: B:39:0x0096->B:27:0x0096 BREAK  A[LOOP:0: B:8:0x0023->B:25:0x008c], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void triggerDebounced(long r27) {
        /*
            r26 = this;
            r0 = r26
            long r1 = r0.minDebounceDeadline
            int r1 = (r1 > r27 ? 1 : (r1 == r27 ? 0 : -1))
            if (r1 <= 0) goto L9
            return
        L9:
            long r2 = r0.windowOffset
            long r4 = r0.screenOffset
            float[] r6 = r0.viewToWindowMatrix
            androidx.collection.MutableIntObjectMap<androidx.compose.ui.spatial.ThrottledCallbacks$Entry> r1 = r0.rectChangedMap
            java.lang.Object[] r11 = r1.values
            long[] r12 = r1.metadata
            int r1 = r12.length
            int r13 = r1 + (-2)
            if (r13 < 0) goto L8f
            r16 = 0
            r1 = r16
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L23:
            r9 = r12[r1]
            r17 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r14 = ~r9
            r19 = 7
            long r14 = r14 << r19
            long r14 = r14 & r9
            r19 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r14 = r14 & r19
            int r14 = (r14 > r19 ? 1 : (r14 == r19 ? 0 : -1))
            if (r14 == 0) goto L8a
            int r14 = r1 - r13
            int r14 = ~r14
            int r14 = r14 >>> 31
            r15 = 8
            int r14 = 8 - r14
            r19 = r9
            r9 = r16
        L48:
            if (r9 >= r14) goto L84
            r21 = 255(0xff, double:1.26E-321)
            long r21 = r19 & r21
            r23 = 128(0x80, double:6.3E-322)
            int r10 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r10 >= 0) goto L7a
            int r10 = r1 << 3
            int r10 = r10 + r9
            r10 = r11[r10]
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r10 = (androidx.compose.ui.spatial.ThrottledCallbacks.Entry) r10
        L5b:
            if (r10 == 0) goto L74
            r25 = r1
            r21 = r9
            r1 = r10
            r9 = r7
            r7 = r27
            long r9 = r0.m6114debounceEntryb8qMvQI(r1, r2, r4, r6, r7, r9)
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r1 = r1.getNext()
            r7 = r9
            r9 = r21
            r10 = r1
            r1 = r25
            goto L5b
        L74:
            r21 = r9
            r9 = r7
        L77:
            r25 = r1
            goto L7d
        L7a:
            r21 = r9
            goto L77
        L7d:
            long r19 = r19 >> r15
            int r9 = r21 + 1
            r1 = r25
            goto L48
        L84:
            r25 = r1
            if (r14 != r15) goto L96
            r1 = r25
        L8a:
            if (r1 == r13) goto L96
            int r1 = r1 + 1
            goto L23
        L8f:
            r17 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r7 = r17
        L96:
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r1 = r0.globalChangeEntries
            if (r1 == 0) goto La9
            r9 = r7
        L9b:
            if (r1 == 0) goto La8
            r7 = r27
            long r9 = r0.m6114debounceEntryb8qMvQI(r1, r2, r4, r6, r7, r9)
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r1 = r1.getNext()
            goto L9b
        La8:
            r7 = r9
        La9:
            int r1 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r1 != 0) goto Laf
            r7 = -1
        Laf:
            r0.minDebounceDeadline = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.spatial.ThrottledCallbacks.triggerDebounced(long):void");
    }

    /* renamed from: updateOffsets-LDcG7Xg, reason: not valid java name */
    public final boolean m6122updateOffsetsLDcG7Xg(long screen, long window, float[] matrix, int windowWidth, int windowHeight) {
        boolean z10;
        if (IntOffset.m6971equalsimpl0(window, this.windowOffset)) {
            z10 = false;
        } else {
            this.windowOffset = window;
            z10 = true;
        }
        if (!IntOffset.m6971equalsimpl0(screen, this.screenOffset)) {
            this.screenOffset = screen;
            z10 = true;
        }
        if (matrix != null) {
            this.viewToWindowMatrix = matrix;
            z10 = true;
        }
        long j5 = (windowWidth << 32) | (windowHeight & 4294967295L);
        if (j5 == this.windowSize) {
            return z10;
        }
        this.windowSize = j5;
        return true;
    }
}
