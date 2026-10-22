package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.Velocity;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J'\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0004\b*\u0010+J\u0018\u0010,\u001a\u00020-2\u0006\u0010#\u001a\u00020-H\u0096@¢\u0006\u0004\b.\u0010/J \u00100\u001a\u00020-2\u0006\u0010)\u001a\u00020-2\u0006\u0010#\u001a\u00020-H\u0096@¢\u0006\u0004\b1\u00102J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u00106\u001a\u000204H\u0016J\b\u00107\u001a\u000204H\u0016J\b\u00108\u001a\u000204H\u0002J\b\u00109\u001a\u000204H\u0002J\u001f\u0010:\u001a\u0002042\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b;R\u001a\u0010\u0004\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006<"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/Modifier$Node;", WsConstants.KEY_CONNECTION, "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "<init>", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "resolvedDispatcher", "lastKnownParentNode", "getLastKnownParentNode$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setLastKnownParentNode$ui_release", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "parentNestedScrollNode", "getParentNestedScrollNode$ui_release", "parentConnection", "getParentConnection", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope$annotations", "()V", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDispatcher", "", "newDispatcher", "onAttach", "onDetach", "updateDispatcherFields", "resetDispatcherFields", "updateNode", "updateNode$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {
    public static final int $stable = 8;
    private NestedScrollConnection connection;
    private NestedScrollNode lastKnownParentNode;
    private NestedScrollDispatcher resolvedDispatcher;
    private final Object traverseKey;

    private static /* synthetic */ void getNestedCoroutineScope$annotations() {
    }

    private final CoroutineScope getNestedCoroutineScope() {
        if (ComposeUiFlags.isNestedScrollDispatcherNodeFixEnabled == false) goto L20;
        NestedScrollNode r100 = getParentNestedScrollNode$ui_release();
        if (r100 == null) goto L7;
        CoroutineScope r101 = r100.getNestedCoroutineScope();
    L8:
        boolean r102 = false;
        if (r101 != null) goto L11;
    L13:
        if (r102 == true) goto L26;
        r101 = this.resolvedDispatcher.getScope$ui_release();
        if (r101 != null) goto L26;
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    L26:
        return r101;
    L11:
        if (CoroutineScopeKt.isActive(r101) != true) goto L13;
        r102 = true;
        goto L13
    L7:
        r101 = null;
        goto L8
    L20:
        NestedScrollNode r103 = getParentNestedScrollNode$ui_release();
        if (r103 == null) goto L24;
        r101 = r103.getNestedCoroutineScope();
        if (r101 != null) goto L26;
    L24:
        r101 = this.resolvedDispatcher.getScope$ui_release();
        if (r101 != null) goto L26;
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getNestedScrollNode$ui_release() != this) goto L6;
        this.resolvedDispatcher.setNestedScrollNode$ui_release(null);
        return;
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setNestedScrollNode$ui_release(this);
        this.resolvedDispatcher.setLastKnownParentNode$ui_release(null);
        this.lastKnownParentNode = null;
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new AnonymousClass1(this));
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    private final NestedScrollConnection getParentConnection() {
        if (isAttached() == true) goto L7;
        return null;
    L7:
        return getParentNestedScrollNode$ui_release();
    }

    public final NestedScrollNode getParentNestedScrollNode$ui_release() {
        if (isAttached() == true) goto L7;
        return null;
    L7:
        return (NestedScrollNode) TraversableNodeKt.findNearestAncestor(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        NestedScrollNode r100 = (NestedScrollNode) NestedScrollNodeKt.access$findNearestAttachedAncestor(this);
        this.lastKnownParentNode = r100;
        this.resolvedDispatcher.setLastKnownParentNode$ui_release(r100);
        resetDispatcherFields();
    }

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    public final NestedScrollNode getLastKnownParentNode$ui_release() {
        return this.lastKnownParentNode;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDispatcherFields();
    }

    public static final /* synthetic */ CoroutineScope access$getNestedCoroutineScope(NestedScrollNode r100) {
        return r100.getNestedCoroutineScope();
    }

    private final void updateDispatcher(NestedScrollDispatcher r100) {
        resetDispatcherFields();
        if (r100 != null) goto L6;
        this.resolvedDispatcher = new NestedScrollDispatcher();
    L9:
        if (isAttached() == false) goto L12;
        updateDispatcherFields();
        return;
    L12:
        return;
    L6:
        if (Intrinsics.areEqual(r100, this.resolvedDispatcher) == true) goto L9;
        this.resolvedDispatcher = r100;
        goto L9
    }

    public final void setConnection(NestedScrollConnection r100) {
        this.connection = r100;
    }

    public final void setLastKnownParentNode$ui_release(NestedScrollNode r100) {
        this.lastKnownParentNode = r100;
    }

    public NestedScrollNode(NestedScrollConnection r100, NestedScrollDispatcher r101) {
        this.connection = r100;
        if (r101 != null) goto L5;
        r101 = new NestedScrollDispatcher();
    L5:
        this.resolvedDispatcher = r101;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo498onPreFlingQWom1Mo(long r100, Continuation<? super Velocity> r110) {
        if ((r110 instanceof NestedScrollNode$onPreFling$1) == false) goto L7;
        NestedScrollNode$onPreFling$1 r101 = (NestedScrollNode$onPreFling$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        long r105 = r101.J$0;
        ResultKt.throwOnFailure(r111);
    L27:
        return Velocity.m7777boximpl(Velocity.m7790plusAH228Gc(r105, ((Velocity) r111).m7795unboximpl()));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = r101.J$0;
        ResultKt.throwOnFailure(r111);
    L21:
        long r106 = ((Velocity) r111).m7795unboximpl();
    L23:
        long r107 = r100;
        r105 = r106;
        NestedScrollConnection r112 = this.connection;
        long r108 = Velocity.m7789minusAH228Gc(r107, r105);
        r101.J$0 = r105;
        r101.label = 2;
        r111 = r112.mo498onPreFlingQWom1Mo(r108, r101);
        if (r111 != r103) goto L27;
        return r103;
    L16:
        ResultKt.throwOnFailure(r111);
        NestedScrollConnection r113 = getParentConnection();
        if (r113 == null) goto L22;
        r101.J$0 = r100;
        r101.label = 1;
        r111 = r113.mo498onPreFlingQWom1Mo(r100, r101);
        if (r111 != r103) goto L21;
        return r103;
    L22:
        r106 = Velocity.Companion.m7797getZero9UxMQ8M();
    L7:
        r101 = new NestedScrollNode$onPreFling$1(this, r110);
        goto L8
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo499onPreScrollOzD1aCk(long r100, int r101) {
        NestedScrollConnection r102 = getParentConnection();
        if (r102 == null) goto L5;
        long r103 = r102.mo499onPreScrollOzD1aCk(r100, r101);
    L7:
        return Offset.m4587plusMKHz9U(r103, this.connection.mo499onPreScrollOzD1aCk(Offset.m4586minusMKHz9U(r100, r103), r101));
    L5:
        r103 = Offset.Companion.m4598getZeroF1C5BW0();
        goto L7
    }

    public final void updateNode$ui_release(NestedScrollConnection r100, NestedScrollDispatcher r101) {
        this.connection = r100;
        updateDispatcher(r101);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo496onPostFlingRZ2iAVY(long r110, long r111, Continuation<? super Velocity> r210) {
        if ((r210 instanceof NestedScrollNode$onPostFling$1) == false) goto L7;
        NestedScrollNode$onPostFling$1 r100 = (NestedScrollNode$onPostFling$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        long r105 = r100.J$0;
        ResultKt.throwOnFailure(r102);
    L29:
        long r106 = ((Velocity) r102).m7795unboximpl();
        long r107 = r105;
    L32:
        return Velocity.m7777boximpl(Velocity.m7790plusAH228Gc(r107, r106));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r108 = r100.J$1;
        long r109 = r100.J$0;
        ResultKt.throwOnFailure(r102);
        long r112 = r108;
        long r113 = r109;
    L19:
        r107 = ((Velocity) r102).m7795unboximpl();
        if (isAttached() == false) goto L22;
        NestedScrollConnection r114 = getParentConnection();
    L23:
        NestedScrollConnection r115 = r114;
        if (r115 == null) goto L30;
        long r116 = Velocity.m7790plusAH228Gc(r113, r107);
        long r117 = Velocity.m7789minusAH228Gc(r112, r107);
        r100.J$0 = r107;
        r100.label = 2;
        r102 = r115.mo496onPostFlingRZ2iAVY(r116, r117, r100);
        if (r102 != r103) goto L28;
        return r103;
    L28:
        r105 = r107;
        goto L29
    L30:
        r106 = Velocity.Companion.m7797getZero9UxMQ8M();
        goto L32
    L22:
        r114 = this.lastKnownParentNode;
        goto L23
    L16:
        ResultKt.throwOnFailure(r102);
        NestedScrollConnection r118 = this.connection;
        r113 = r110;
        r100.J$0 = r113;
        r112 = r111;
        r100.J$1 = r112;
        r100.label = 1;
        r102 = r118.mo496onPostFlingRZ2iAVY(r110, r111, r100);
        if (r102 != r103) goto L19;
        return r103;
    L7:
        r100 = new NestedScrollNode$onPostFling$1(this, r210);
        goto L8
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo497onPostScrollDzOQY0M(long r100, long r110, int r111) {
        long r101 = this.connection.mo497onPostScrollDzOQY0M(r100, r110, r111);
        NestedScrollConnection r102 = getParentConnection();
        if (r102 == null) goto L5;
        long r103 = r102.mo497onPostScrollDzOQY0M(Offset.m4587plusMKHz9U(r100, r101), Offset.m4586minusMKHz9U(r110, r101), r111);
    L7:
        return Offset.m4587plusMKHz9U(r101, r103);
    L5:
        r103 = Offset.Companion.m4598getZeroF1C5BW0();
        goto L7
    }
}
