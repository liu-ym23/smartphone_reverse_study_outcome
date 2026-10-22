package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"androidx/compose/material3/EnterAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EnterAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ EnterAlwaysScrollBehavior this$0;

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public final /* synthetic */ Object mo498onPreFlingQWom1Mo(long r100, Continuation r101) {
        return NestedScrollConnection.CC.m5987$default$onPreFlingQWom1Mo(this, r100, r101);
    }

    public EnterAlwaysScrollBehavior$nestedScrollConnection$1(EnterAlwaysScrollBehavior r100) {
        this.this$0 = r100;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo499onPreScrollOzD1aCk(long r100, int r101) {
        if (this.this$0.getCanScroll().invoke().booleanValue() == false) goto L5;
        float r102 = this.this$0.getState().getHeightOffset();
        TopAppBarState r103 = this.this$0.getState();
        r103.setHeightOffset(r103.getHeightOffset() + Float.intBitsToFloat((int) (BodyPartID.bodyIdMax & r100)));
        if (this.this$0.getReverseLayout() == true) goto L15;
        if (r102 != this.this$0.getState().getHeightOffset()) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L15;
        return Offset.m4576copydBAh8RU$default(r100, 0.0f, 0.0f, 2, null);
    L11:
        r104 = false;
    L15:
        return Offset.Companion.m4598getZeroF1C5BW0();
    L5:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo496onPostFlingRZ2iAVY(long r110, long r111, Continuation<? super Velocity> r112) {
        if ((r112 instanceof EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) == false) goto L7;
        EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 r100 = (EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        long r114 = r100.J$0;
        ResultKt.throwOnFailure(r113);
    L35:
        return Velocity.m7777boximpl(Velocity.m7790plusAH228Gc(r114, ((Velocity) r113).m7795unboximpl()));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r111 = r100.J$0;
        ResultKt.throwOnFailure(r113);
    L31:
        r114 = ((Velocity) r113).m7795unboximpl();
        TopAppBarState r115 = this.this$0.getState();
        float r116 = Velocity.m7787getYimpl(r111);
        DecayAnimationSpec<Float> r117 = this.this$0.getFlingAnimationSpec();
        AnimationSpec<Float> r104 = this.this$0.getSnapAnimationSpec();
        r100.J$0 = r114;
        r100.label = 2;
        r113 = AppBarKt.access$settleAppBar(r115, r116, r117, r104, r100);
        if (r113 != r102) goto L35;
        return r102;
    L16:
        ResultKt.throwOnFailure(r113);
        if (Velocity.m7787getYimpl(r111) <= 0.0f) goto L28;
        boolean r105 = false;
        if (this.this$0.getState().getHeightOffset() != 0.0f) goto L21;
        boolean r118 = true;
    L22:
        if (r118 == false) goto L24;
    L27:
        this.this$0.getState().setContentOffset(0.0f);
        goto L28
    L24:
        if (this.this$0.getState().getHeightOffset() != this.this$0.getState().getHeightOffsetLimit()) goto L26;
        r105 = true;
    L26:
        if (r105 == false) goto L28;
    L21:
        r118 = false;
    L28:
        r100.J$0 = r111;
        r100.label = 1;
        r113 = NestedScrollConnection.CC.m5985$default$onPostFlingRZ2iAVY(this, r110, r111, r100);
        if (r113 != r102) goto L31;
        return r102;
    L7:
        r100 = new EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, r112);
        goto L8
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo497onPostScrollDzOQY0M(long r100, long r101, int r102) {
        if (this.this$0.getCanScroll().invoke().booleanValue() == false) goto L5;
        TopAppBarState r103 = this.this$0.getState();
        float r104 = r103.getContentOffset();
        int r105 = (int) (r100 & BodyPartID.bodyIdMax);
        r103.setContentOffset(r104 + Float.intBitsToFloat(r105));
        if (this.this$0.getReverseLayout() == true) goto L10;
        TopAppBarState r106 = this.this$0.getState();
        r106.setHeightOffset(r106.getHeightOffset() + Float.intBitsToFloat(r105));
    L10:
        return Offset.Companion.m4598getZeroF1C5BW0();
    L5:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }
}
