package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#¢\u0006\u0004\b$\u0010%J%\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#¢\u0006\u0004\b(\u0010)J\u0018\u0010*\u001a\u00020+2\u0006\u0010!\u001a\u00020+H\u0086@¢\u0006\u0004\b,\u0010-J \u0010.\u001a\u00020+2\u0006\u0010'\u001a\u00020+2\u0006\u0010!\u001a\u00020+H\u0086@¢\u0006\u0004\b/\u00100R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u00061"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "", "<init>", "()V", "nestedScrollNode", "Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "getNestedScrollNode$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setNestedScrollNode$ui_release", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "lastKnownParentNode", "getLastKnownParentNode$ui_release", "setLastKnownParentNode$ui_release", "calculateNestedScrollScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "getCalculateNestedScrollScope$ui_release", "()Lkotlin/jvm/functions/Function0;", "setCalculateNestedScrollScope$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "scope", "getScope$ui_release", "()Lkotlinx/coroutines/CoroutineScope;", "setScope$ui_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "coroutineScope", "getCoroutineScope", "parent", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getParent$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatchPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchPreScroll-OzD1aCk", "(JI)J", "dispatchPostScroll", "consumed", "dispatchPostScroll-DzOQY0M", "(JJI)J", "dispatchPreFling", "Landroidx/compose/ui/unit/Velocity;", "dispatchPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPostFling", "dispatchPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NestedScrollDispatcher {
    public static final int $stable = 8;
    private Function0<? extends CoroutineScope> calculateNestedScrollScope;
    private NestedScrollNode lastKnownParentNode;
    private NestedScrollNode nestedScrollNode;
    private CoroutineScope scope;

    public final CoroutineScope getCoroutineScope() {
        CoroutineScope r100 = this.calculateNestedScrollScope.invoke();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    public final NestedScrollConnection getParent$ui_release() {
        NestedScrollNode r100 = this.nestedScrollNode;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getParentNestedScrollNode$ui_release();
    }

    public NestedScrollDispatcher() {
        this.calculateNestedScrollScope = new NestedScrollDispatcher$calculateNestedScrollScope$1(this);
    }

    public final Function0<CoroutineScope> getCalculateNestedScrollScope$ui_release() {
        return this.calculateNestedScrollScope;
    }

    public final NestedScrollNode getLastKnownParentNode$ui_release() {
        return this.lastKnownParentNode;
    }

    public final NestedScrollNode getNestedScrollNode$ui_release() {
        return this.nestedScrollNode;
    }

    public final CoroutineScope getScope$ui_release() {
        return this.scope;
    }

    public final void setCalculateNestedScrollScope$ui_release(Function0<? extends CoroutineScope> r100) {
        this.calculateNestedScrollScope = r100;
    }

    public final void setLastKnownParentNode$ui_release(NestedScrollNode r100) {
        this.lastKnownParentNode = r100;
    }

    public final void setNestedScrollNode$ui_release(NestedScrollNode r100) {
        this.nestedScrollNode = r100;
    }

    public final void setScope$ui_release(CoroutineScope r100) {
        this.scope = r100;
    }

    /* JADX INFO: renamed from: dispatchPreFling-QWom1Mo, reason: not valid java name */
    public final Object m6001dispatchPreFlingQWom1Mo(long r100, Continuation<? super Velocity> r101) {
        if ((r101 instanceof NestedScrollDispatcher$dispatchPreFling$1) == false) goto L7;
        NestedScrollDispatcher$dispatchPreFling$1 r102 = (NestedScrollDispatcher$dispatchPreFling$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L19:
        long r107 = ((Velocity) r104).m7795unboximpl();
    L22:
        return Velocity.m7777boximpl(r107);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        NestedScrollConnection r108 = getParent$ui_release();
        if (r108 == null) goto L20;
        r102.label = 1;
        r104 = r108.mo498onPreFlingQWom1Mo(r100, r102);
        if (r104 != r105) goto L19;
        return r105;
    L20:
        r107 = Velocity.Companion.m7797getZero9UxMQ8M();
    L7:
        r102 = new NestedScrollDispatcher$dispatchPreFling$1(this, r101);
        goto L8
    }

    /* JADX INFO: renamed from: dispatchPreScroll-OzD1aCk, reason: not valid java name */
    public final long m6002dispatchPreScrollOzD1aCk(long r100, int r101) {
        NestedScrollConnection r102 = getParent$ui_release();
        if (r102 == null) goto L6;
        return r102.mo499onPreScrollOzD1aCk(r100, r101);
    L6:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }

    /* JADX INFO: renamed from: dispatchPostFling-RZ2iAVY, reason: not valid java name */
    public final Object m5999dispatchPostFlingRZ2iAVY(long r100, long r110, Continuation<? super Velocity> r111) {
        if ((r111 instanceof NestedScrollDispatcher$dispatchPostFling$1) == false) goto L7;
        NestedScrollDispatcher$dispatchPostFling$1 r101 = (NestedScrollDispatcher$dispatchPostFling$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        NestedScrollDispatcher$dispatchPostFling$1 r103 = r101;
        Object r112 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r112);
    L30:
        long r106 = ((Velocity) r112).m7795unboximpl();
    L33:
        return Velocity.m7777boximpl(r106);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r112);
    L23:
        r106 = ((Velocity) r112).m7795unboximpl();
        goto L33
    L16:
        ResultKt.throwOnFailure(r112);
        if (getParent$ui_release() != null) goto L25;
        NestedScrollNode r107 = this.lastKnownParentNode;
        if (r107 == null) goto L24;
        r103.label = 1;
        r112 = r107.mo496onPostFlingRZ2iAVY(r100, r110, r103);
        if (r112 != r104) goto L23;
        return r104;
    L24:
        r106 = Velocity.Companion.m7797getZero9UxMQ8M();
        goto L33
    L25:
        NestedScrollConnection r108 = getParent$ui_release();
        if (r108 == null) goto L31;
        r103.label = 2;
        r112 = r108.mo496onPostFlingRZ2iAVY(r100, r110, r103);
        if (r112 != r104) goto L30;
        return r104;
    L31:
        r106 = Velocity.Companion.m7797getZero9UxMQ8M();
    L7:
        r101 = new NestedScrollDispatcher$dispatchPostFling$1(this, r111);
        goto L8
    }

    /* JADX INFO: renamed from: dispatchPostScroll-DzOQY0M, reason: not valid java name */
    public final long m6000dispatchPostScrollDzOQY0M(long r100, long r101, int r110) {
        NestedScrollConnection r102 = getParent$ui_release();
        if (r102 == null) goto L6;
        return r102.mo497onPostScrollDzOQY0M(r100, r101, r110);
    L6:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }
}
