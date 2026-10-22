package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"androidx/compose/material3/ExitAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", AgentBusWakeContract.EXTRA_SOURCE, "onPostScroll-DzOQY0M", "(JJI)J", "onPostScroll", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLH7/c;)Ljava/lang/Object;", "onPostFling", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExitAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ ExitAlwaysScrollBehavior this$0;

    public ExitAlwaysScrollBehavior$nestedScrollConnection$1(ExitAlwaysScrollBehavior exitAlwaysScrollBehavior) {
        this.this$0 = exitAlwaysScrollBehavior;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo500onPostFlingRZ2iAVY(long r6, long r8, H7.c<? super androidx.compose.ui.unit.Velocity> r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof androidx.compose.material3.ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.material3.ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = (androidx.compose.material3.ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r10 = r0
            goto L1a
        L14:
            androidx.compose.material3.ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = new androidx.compose.material3.ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1
            r0.<init>(r5, r10)
            goto L12
        L1a:
            java.lang.Object r0 = r10.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r10.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            long r5 = r10.J$0
            kotlin.b.b(r0)
            goto L7b
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            long r8 = r10.J$0
            java.lang.Object r5 = r10.L$0
            androidx.compose.material3.ExitAlwaysScrollBehavior$nestedScrollConnection$1 r5 = (androidx.compose.material3.ExitAlwaysScrollBehavior$nestedScrollConnection$1) r5
            kotlin.b.b(r0)
            goto L50
        L40:
            kotlin.b.b(r0)
            r10.L$0 = r5
            r10.J$0 = r8
            r10.label = r4
            java.lang.Object r0 = super.mo500onPostFlingRZ2iAVY(r6, r8, r10)
            if (r0 != r1) goto L50
            goto L79
        L50:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r6 = r0.getPackedValue()
            androidx.compose.material3.ExitAlwaysScrollBehavior r0 = r5.this$0
            androidx.compose.material3.BottomAppBarState r0 = r0.getState()
            float r8 = androidx.compose.ui.unit.Velocity.m7083getYimpl(r8)
            androidx.compose.material3.ExitAlwaysScrollBehavior r9 = r5.this$0
            androidx.compose.animation.core.DecayAnimationSpec r9 = r9.getFlingAnimationSpec()
            androidx.compose.material3.ExitAlwaysScrollBehavior r5 = r5.this$0
            androidx.compose.animation.core.AnimationSpec r5 = r5.getSnapAnimationSpec()
            r2 = 0
            r10.L$0 = r2
            r10.J$0 = r6
            r10.label = r3
            java.lang.Object r0 = androidx.compose.material3.AppBarKt.access$settleAppBarBottom(r0, r8, r9, r5, r10)
            if (r0 != r1) goto L7a
        L79:
            return r1
        L7a:
            r5 = r6
        L7b:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r7 = r0.getPackedValue()
            long r5 = androidx.compose.ui.unit.Velocity.m7086plusAH228Gc(r5, r7)
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m7073boximpl(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExitAlwaysScrollBehavior$nestedScrollConnection$1.mo500onPostFlingRZ2iAVY(long, long, H7.c):java.lang.Object");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo501onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!((Boolean) this.this$0.getCanScroll().invoke()).booleanValue()) {
            return Offset.INSTANCE.m3911getZeroF1C5BW0();
        }
        BottomAppBarState state = this.this$0.getState();
        state.setContentOffset(Offset.m3896getYimpl(consumed) + state.getContentOffset());
        if ((this.this$0.getState().getHeightOffset() == 0.0f || this.this$0.getState().getHeightOffset() == this.this$0.getState().getHeightOffsetLimit()) && Offset.m3896getYimpl(consumed) == 0.0f && Offset.m3896getYimpl(available) > 0.0f) {
            this.this$0.getState().setContentOffset(0.0f);
        }
        this.this$0.getState().setHeightOffset(Offset.m3896getYimpl(consumed) + this.this$0.getState().getHeightOffset());
        return Offset.INSTANCE.m3911getZeroF1C5BW0();
    }
}
