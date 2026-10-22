package androidx.compose.ui.input.nestedscroll;

import S7.a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u001bH\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010!\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u001bH\u0096@¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010\u000eJ\u000f\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010\u000eJ!\u0010%\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b$\u0010\bR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00104\u001a\u0002038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u00109\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u0010(R\u001a\u0010>\u001a\u00020:8BX\u0082\u0004¢\u0006\f\u0012\u0004\b=\u0010\u000e\u001a\u0004\b;\u0010<R\u0016\u0010@\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b?\u00100¨\u0006A"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/Modifier$Node;", "connection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "dispatcher", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "newDispatcher", "LC7/r;", "updateDispatcher", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "updateDispatcherFields", "()V", "resetDispatcherFields", "Landroidx/compose/ui/geometry/Offset;", "available", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", AgentBusWakeContract.EXTRA_SOURCE, "onPreScroll-OzD1aCk", "(JI)J", "onPreScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPostScroll", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLH7/c;)Ljava/lang/Object;", "onPreFling", "onPostFling-RZ2iAVY", "(JJLH7/c;)Ljava/lang/Object;", "onPostFling", "onAttach", "onDetach", "updateNode$ui_release", "updateNode", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "resolvedDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "lastKnownParentNode", "Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "getLastKnownParentNode$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setLastKnownParentNode$ui_release", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "", "traverseKey", "Ljava/lang/Object;", "getTraverseKey", "()Ljava/lang/Object;", "getParentConnection", "parentConnection", "Lm9/z;", "getNestedCoroutineScope", "()Lm9/z;", "getNestedCoroutineScope$annotations", "nestedCoroutineScope", "getParentNestedScrollNode$ui_release", "parentNestedScrollNode", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {
    public static final int $stable = 8;
    private NestedScrollConnection connection;
    private NestedScrollNode lastKnownParentNode;
    private NestedScrollDispatcher resolvedDispatcher;
    private final Object traverseKey;

    public NestedScrollNode(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC1733z getNestedCoroutineScope() {
        InterfaceC1733z nestedCoroutineScope;
        if (!ComposeUiFlags.isNestedScrollDispatcherNodeFixEnabled) {
            NestedScrollNode parentNestedScrollNode$ui_release = getParentNestedScrollNode$ui_release();
            if (parentNestedScrollNode$ui_release != null && (nestedCoroutineScope = parentNestedScrollNode$ui_release.getNestedCoroutineScope()) != null) {
                return nestedCoroutineScope;
            }
            InterfaceC1733z scope$ui_release = this.resolvedDispatcher.getScope();
            if (scope$ui_release != null) {
                return scope$ui_release;
            }
            throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        NestedScrollNode parentNestedScrollNode$ui_release2 = getParentNestedScrollNode$ui_release();
        InterfaceC1733z nestedCoroutineScope2 = parentNestedScrollNode$ui_release2 != null ? parentNestedScrollNode$ui_release2.getNestedCoroutineScope() : null;
        if (nestedCoroutineScope2 != null && AbstractC1683A.l(nestedCoroutineScope2)) {
            return nestedCoroutineScope2;
        }
        InterfaceC1733z scope$ui_release2 = this.resolvedDispatcher.getScope();
        if (scope$ui_release2 != null) {
            return scope$ui_release2;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    private static /* synthetic */ void getNestedCoroutineScope$annotations() {
    }

    private final NestedScrollConnection getParentConnection() {
        if (getIsAttached()) {
            return getParentNestedScrollNode$ui_release();
        }
        return null;
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getNestedScrollNode() == this) {
            this.resolvedDispatcher.setNestedScrollNode$ui_release(null);
        }
    }

    private final void updateDispatcher(NestedScrollDispatcher newDispatcher) {
        resetDispatcherFields();
        if (newDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!newDispatcher.equals(this.resolvedDispatcher)) {
            this.resolvedDispatcher = newDispatcher;
        }
        if (getIsAttached()) {
            updateDispatcherFields();
        }
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setNestedScrollNode$ui_release(this);
        this.resolvedDispatcher.setLastKnownParentNode$ui_release(null);
        this.lastKnownParentNode = null;
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new a() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode.updateDispatcherFields.1
            {
                super(0);
            }

            @Override // S7.a
            public final InterfaceC1733z invoke() {
                return NestedScrollNode.this.getNestedCoroutineScope();
            }
        });
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    /* renamed from: getLastKnownParentNode$ui_release, reason: from getter */
    public final NestedScrollNode getLastKnownParentNode() {
        return this.lastKnownParentNode;
    }

    public final NestedScrollNode getParentNestedScrollNode$ui_release() {
        if (getIsAttached()) {
            return (NestedScrollNode) TraversableNodeKt.findNearestAncestor(this);
        }
        return null;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDispatcherFields();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        NestedScrollNode nestedScrollNode = (NestedScrollNode) NestedScrollNodeKt.findNearestAttachedAncestor(this);
        this.lastKnownParentNode = nestedScrollNode;
        this.resolvedDispatcher.setLastKnownParentNode$ui_release(nestedScrollNode);
        resetDispatcherFields();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo500onPostFlingRZ2iAVY(long r12, long r14, H7.c<? super androidx.compose.ui.unit.Velocity> r16) {
        /*
            r11 = this;
            r0 = r16
            boolean r1 = r0 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            if (r1 == 0) goto L16
            r1 = r0
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r1 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r7 = r1
            goto L1c
        L16:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r1 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            r1.<init>(r11, r0)
            goto L14
        L1c:
            java.lang.Object r0 = r7.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r7.label
            r8 = 2
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 == r3) goto L38
            if (r2 != r8) goto L30
            long r11 = r7.J$0
            kotlin.b.b(r0)
            goto L84
        L30:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L38:
            long r12 = r7.J$1
            long r2 = r7.J$0
            kotlin.b.b(r0)
            r9 = r2
            r2 = r12
            r12 = r9
            goto L58
        L43:
            kotlin.b.b(r0)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r2 = r11.connection
            r7.J$0 = r12
            r7.J$1 = r14
            r7.label = r3
            r3 = r12
            r5 = r14
            java.lang.Object r0 = r2.mo500onPostFlingRZ2iAVY(r3, r5, r7)
            if (r0 != r1) goto L57
            goto L82
        L57:
            r2 = r14
        L58:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r4 = r0.getPackedValue()
            boolean r0 = r11.getIsAttached()
            if (r0 == 0) goto L69
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r11 = r11.getParentConnection()
            goto L6b
        L69:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r11 = r11.lastKnownParentNode
        L6b:
            if (r11 == 0) goto L8c
            long r12 = androidx.compose.ui.unit.Velocity.m7086plusAH228Gc(r12, r4)
            long r2 = androidx.compose.ui.unit.Velocity.m7085minusAH228Gc(r2, r4)
            r7.J$0 = r4
            r7.label = r8
            r14 = r2
            r16 = r7
            java.lang.Object r0 = r11.mo500onPostFlingRZ2iAVY(r12, r14, r16)
            if (r0 != r1) goto L83
        L82:
            return r1
        L83:
            r11 = r4
        L84:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r0 = r0.getPackedValue()
            r4 = r11
            goto L92
        L8c:
            androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r0 = r11.m7093getZero9UxMQ8M()
        L92:
            long r11 = androidx.compose.ui.unit.Velocity.m7086plusAH228Gc(r4, r0)
            androidx.compose.ui.unit.Velocity r11 = androidx.compose.ui.unit.Velocity.m7073boximpl(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.mo500onPostFlingRZ2iAVY(long, long, H7.c):java.lang.Object");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo501onPostScrollDzOQY0M(long consumed, long available, int source) {
        long jMo501onPostScrollDzOQY0M = this.connection.mo501onPostScrollDzOQY0M(consumed, available, source);
        NestedScrollConnection parentConnection = getParentConnection();
        return Offset.m3900plusMKHz9U(jMo501onPostScrollDzOQY0M, parentConnection != null ? parentConnection.mo501onPostScrollDzOQY0M(Offset.m3900plusMKHz9U(consumed, jMo501onPostScrollDzOQY0M), Offset.m3899minusMKHz9U(available, jMo501onPostScrollDzOQY0M), source) : Offset.INSTANCE.m3911getZeroF1C5BW0());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        if (r9 == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo775onPreFlingQWom1Mo(long r7, H7.c<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            long r6 = r0.J$0
            kotlin.b.b(r9)
            goto L6d
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            long r7 = r0.J$0
            kotlin.b.b(r9)
            goto L4e
        L3a:
            kotlin.b.b(r9)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r9 = r6.getParentConnection()
            if (r9 == 0) goto L55
            r0.J$0 = r7
            r0.label = r4
            java.lang.Object r9 = r9.mo775onPreFlingQWom1Mo(r7, r0)
            if (r9 != r1) goto L4e
            goto L6b
        L4e:
            androidx.compose.ui.unit.Velocity r9 = (androidx.compose.ui.unit.Velocity) r9
            long r4 = r9.getPackedValue()
            goto L5b
        L55:
            androidx.compose.ui.unit.Velocity$Companion r9 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r4 = r9.m7093getZero9UxMQ8M()
        L5b:
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r6 = r6.connection
            long r7 = androidx.compose.ui.unit.Velocity.m7085minusAH228Gc(r7, r4)
            r0.J$0 = r4
            r0.label = r3
            java.lang.Object r9 = r6.mo775onPreFlingQWom1Mo(r7, r0)
            if (r9 != r1) goto L6c
        L6b:
            return r1
        L6c:
            r6 = r4
        L6d:
            androidx.compose.ui.unit.Velocity r9 = (androidx.compose.ui.unit.Velocity) r9
            long r8 = r9.getPackedValue()
            long r6 = androidx.compose.ui.unit.Velocity.m7086plusAH228Gc(r6, r8)
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m7073boximpl(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.mo775onPreFlingQWom1Mo(long, H7.c):java.lang.Object");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo776onPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parentConnection = getParentConnection();
        long jMo776onPreScrollOzD1aCk = parentConnection != null ? parentConnection.mo776onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m3911getZeroF1C5BW0();
        return Offset.m3900plusMKHz9U(jMo776onPreScrollOzD1aCk, this.connection.mo776onPreScrollOzD1aCk(Offset.m3899minusMKHz9U(available, jMo776onPreScrollOzD1aCk), source));
    }

    public final void setConnection(NestedScrollConnection nestedScrollConnection) {
        this.connection = nestedScrollConnection;
    }

    public final void setLastKnownParentNode$ui_release(NestedScrollNode nestedScrollNode) {
        this.lastKnownParentNode = nestedScrollNode;
    }

    public final void updateNode$ui_release(NestedScrollConnection connection, NestedScrollDispatcher dispatcher) {
        this.connection = connection;
        updateDispatcher(dispatcher);
    }
}
