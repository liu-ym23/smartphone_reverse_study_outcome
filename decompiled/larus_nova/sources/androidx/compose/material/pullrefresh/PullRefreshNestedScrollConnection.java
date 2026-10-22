package androidx.compose.material.pullrefresh;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001Be\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00040\u0003\u00121\u0010\b\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b\u001f\u0010 R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R;\u0010\b\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/material/pullrefresh/PullRefreshNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPull", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pullDelta", "onRelease", "Lkotlin/Function2;", "flingVelocity", "Lkotlin/coroutines/Continuation;", "", "enabled", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Z)V", "Lkotlin/jvm/functions/Function2;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PullRefreshNestedScrollConnection implements NestedScrollConnection {
    private final boolean enabled;
    private final Function1<Float, Float> onPull;
    private final Function2<Float, Continuation<? super Float>, Object> onRelease;

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public final /* synthetic */ Object mo496onPostFlingRZ2iAVY(long r100, long r101, Continuation r102) {
        return NestedScrollConnection.CC.m5985$default$onPostFlingRZ2iAVY(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo498onPreFlingQWom1Mo(long r100, Continuation<? super Velocity> r101) {
        if ((r101 instanceof PullRefreshNestedScrollConnection$onPreFling$1) == false) goto L7;
        PullRefreshNestedScrollConnection$onPreFling$1 r102 = (PullRefreshNestedScrollConnection$onPreFling$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        float r107 = r102.F$0;
        ResultKt.throwOnFailure(r104);
    L19:
        return Velocity.m7777boximpl(VelocityKt.Velocity(r107, ((Number) r104).floatValue()));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Function2<Float, Continuation<? super Float>, Object> r108 = this.onRelease;
        Float r109 = Boxing.boxFloat(Velocity.m7787getYimpl(r100));
        r102.F$0 = 0.0f;
        r102.label = 1;
        r104 = r108.invoke(r109, r102);
        if (r104 != r105) goto L17;
        return r105;
    L17:
        r107 = 0.0f;
    L7:
        r102 = new PullRefreshNestedScrollConnection$onPreFling$1(this, r101);
        goto L8
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo499onPreScrollOzD1aCk(long r100, int r101) {
        if (this.enabled == true) goto L6;
        return Offset.Companion.m4598getZeroF1C5BW0();
    L6:
        if (NestedScrollSource.m6006equalsimpl0(r101, NestedScrollSource.Companion.m6018getUserInputWNlRxjI()) == false) goto L11;
        int r102 = (int) (r100 & BodyPartID.bodyIdMax);
        if (Float.intBitsToFloat(r102) >= 0.0f) goto L11;
        float r103 = this.onPull.invoke(Float.valueOf(Float.intBitsToFloat(r102))).floatValue();
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (BodyPartID.bodyIdMax & Float.floatToRawIntBits(r103)));
    L11:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PullRefreshNestedScrollConnection(Function1<? super Float, Float> r100, Function2<? super Float, ? super Continuation<? super Float>, ? extends Object> r101, boolean r102) {
        this.onPull = r100;
        this.onRelease = r101;
        this.enabled = r102;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo497onPostScrollDzOQY0M(long r100, long r101, int r102) {
        if (this.enabled == true) goto L6;
        return Offset.Companion.m4598getZeroF1C5BW0();
    L6:
        if (NestedScrollSource.m6006equalsimpl0(r102, NestedScrollSource.Companion.m6018getUserInputWNlRxjI()) == false) goto L11;
        int r103 = (int) (r101 & BodyPartID.bodyIdMax);
        if (Float.intBitsToFloat(r103) <= 0.0f) goto L11;
        float r104 = this.onPull.invoke(Float.valueOf(Float.intBitsToFloat(r103))).floatValue();
        long r105 = Float.floatToRawIntBits(0.0f);
        return Offset.m4574constructorimpl((BodyPartID.bodyIdMax & Float.floatToRawIntBits(r104)) | (r105 << 32));
    L11:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }
}
