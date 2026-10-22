package androidx.compose.material;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0003*\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0015*\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"androidx/compose/material/SwipeableKt$PreUpPostDownNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toOffset", "", "(F)J", "toFloat", "(J)F", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwipeableKt$PreUpPostDownNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ SwipeableState<T> $this_PreUpPostDownNestedScrollConnection;

    public SwipeableKt$PreUpPostDownNestedScrollConnection$1(SwipeableState<T> r100) {
        this.$this_PreUpPostDownNestedScrollConnection = r100;
    }

    private final float toFloat(long r100) {
        return Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
    }

    private final long toOffset(float r100) {
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (((long) Float.floatToRawIntBits(r100)) & BodyPartID.bodyIdMax));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo498onPreFlingQWom1Mo(long r110, Continuation<? super Velocity> r111) {
        if ((r111 instanceof SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1) == false) goto L7;
        SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 r100 = (SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = r100.J$0;
        ResultKt.throwOnFailure(r112);
    L23:
        return Velocity.m7777boximpl(r110);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        float r113 = Velocity.m7786getXimpl(r110);
        float r104 = Velocity.m7787getYimpl(r110);
        float r114 = toFloat(Offset.m4574constructorimpl((Float.floatToRawIntBits(r113) << 32) | (((long) Float.floatToRawIntBits(r104)) & BodyPartID.bodyIdMax)));
        if (r114 < 0.0f) goto L17;
    L21:
        r110 = Velocity.Companion.m7797getZero9UxMQ8M();
        goto L23
    L17:
        if (this.$this_PreUpPostDownNestedScrollConnection.getOffset().getValue().floatValue() <= this.$this_PreUpPostDownNestedScrollConnection.getMinBound$material()) goto L21;
        SwipeableState<T> r105 = this.$this_PreUpPostDownNestedScrollConnection;
        r100.J$0 = r110;
        r100.label = 1;
        if (r105.performFling(r114, r100) != r102) goto L23;
        return r102;
    L7:
        r100 = new SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1(this, r111);
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo499onPreScrollOzD1aCk(long r100, int r101) {
        float r102 = toFloat(r100);
        if (r102 >= 0.0f) goto L8;
        if (NestedScrollSource.m6006equalsimpl0(r101, NestedScrollSource.Companion.m6018getUserInputWNlRxjI()) == false) goto L8;
        return toOffset(this.$this_PreUpPostDownNestedScrollConnection.performDrag(r102));
    L8:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo496onPostFlingRZ2iAVY(long r110, long r111, Continuation<? super Velocity> r112) {
        if ((r112 instanceof SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1) == false) goto L7;
        SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 r113 = (SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1) r112;
        int r114 = r113.label;
        if ((r114 & Integer.MIN_VALUE) == 0) goto L7;
        r113.label = r114 - Integer.MIN_VALUE;
    L8:
        Object r115 = r113.result;
        Object r116 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r100 = r113.label;
        if (r100 == 0) goto L14;
        if (r100 != 1) goto L13;
        r111 = r113.J$0;
        ResultKt.throwOnFailure(r115);
    L18:
        return Velocity.m7777boximpl(r111);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r115);
        SwipeableState<T> r117 = this.$this_PreUpPostDownNestedScrollConnection;
        float r101 = Velocity.m7786getXimpl(r111);
        float r102 = Velocity.m7787getYimpl(r111);
        float r103 = toFloat(Offset.m4574constructorimpl((Float.floatToRawIntBits(r101) << 32) | (Float.floatToRawIntBits(r102) & BodyPartID.bodyIdMax)));
        r113.J$0 = r111;
        r113.label = 1;
        if (r117.performFling(r103, r113) != r116) goto L18;
        return r116;
    L7:
        r113 = new SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1(this, r112);
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo497onPostScrollDzOQY0M(long r100, long r101, int r102) {
        if (NestedScrollSource.m6006equalsimpl0(r102, NestedScrollSource.Companion.m6018getUserInputWNlRxjI()) == false) goto L6;
        return toOffset(this.$this_PreUpPostDownNestedScrollConnection.performDrag(toFloat(r101)));
    L6:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }
}
