package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1", f = "TimePicker.kt", l = {1456}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/PointerInputScope;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ClockDialNode$pointerInputDragNode$1 extends SuspendLambda implements n {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ClockDialNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClockDialNode$pointerInputDragNode$1(ClockDialNode clockDialNode, H7.c<? super ClockDialNode$pointerInputDragNode$1> cVar) {
        super(2, cVar);
        this.this$0 = clockDialNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        ClockDialNode$pointerInputDragNode$1 clockDialNode$pointerInputDragNode$1 = new ClockDialNode$pointerInputDragNode$1(this.this$0, cVar);
        clockDialNode$pointerInputDragNode$1.L$0 = obj;
        return clockDialNode$pointerInputDragNode$1;
    }

    @Override // S7.n
    public final Object invoke(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
        return ((ClockDialNode$pointerInputDragNode$1) create(pointerInputScope, cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            final ClockDialNode clockDialNode = this.this$0;
            S7.a aVar = new S7.a() { // from class: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1.1

                @J7.c(c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$1$1", f = "TimePicker.kt", l = {1462}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
                /* renamed from: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$1$1, reason: invalid class name and collision with other inner class name */
                public static final class C00691 extends SuspendLambda implements n {
                    int label;
                    final /* synthetic */ ClockDialNode this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C00691(ClockDialNode clockDialNode, H7.c<? super C00691> cVar) {
                        super(2, cVar);
                        this.this$0 = clockDialNode;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                        return new C00691(this.this$0, cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                        int i = this.label;
                        if (i == 0) {
                            kotlin.b.b(obj);
                            if (this.this$0.autoSwitchToMinute) {
                                this.this$0.state.mo1502setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m2526getMinuteyecRtBI());
                            }
                            AnalogTimePickerState analogTimePickerState = this.this$0.state;
                            this.label = 1;
                            if (analogTimePickerState.onGestureEnd(this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            kotlin.b.b(obj);
                        }
                        return r.f317a;
                    }

                    @Override // S7.n
                    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                        return ((C00691) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                    }
                }

                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1628invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1628invoke() {
                    AbstractC1683A.n(clockDialNode.getCoroutineScope(), null, new C00691(clockDialNode, null), 3);
                }
            };
            final ClockDialNode clockDialNode2 = this.this$0;
            n nVar = new n() { // from class: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1.2

                @J7.c(c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$2$1", f = "TimePicker.kt", l = {1469}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
                /* renamed from: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends SuspendLambda implements n {
                    final /* synthetic */ long $dragAmount;
                    int label;
                    final /* synthetic */ ClockDialNode this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(ClockDialNode clockDialNode, long j5, H7.c<? super AnonymousClass1> cVar) {
                        super(2, cVar);
                        this.this$0 = clockDialNode;
                        this.$dragAmount = j5;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                        return new AnonymousClass1(this.this$0, this.$dragAmount, cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                        int i = this.label;
                        if (i == 0) {
                            kotlin.b.b(obj);
                            ClockDialNode clockDialNode = this.this$0;
                            clockDialNode.offsetX = Offset.m3895getXimpl(this.$dragAmount) + clockDialNode.offsetX;
                            ClockDialNode clockDialNode2 = this.this$0;
                            clockDialNode2.offsetY = Offset.m3896getYimpl(this.$dragAmount) + clockDialNode2.offsetY;
                            AnalogTimePickerState analogTimePickerState = this.this$0.state;
                            float fAtan = TimePickerKt.atan(this.this$0.offsetY - IntOffset.m6973getYimpl(this.this$0.center), this.this$0.offsetX - IntOffset.m6972getXimpl(this.this$0.center));
                            this.label = 1;
                            if (AnalogTimePickerState.rotateTo$default(analogTimePickerState, fAtan, false, this, 2, null) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            kotlin.b.b(obj);
                        }
                        return r.f317a;
                    }

                    @Override // S7.n
                    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                        return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                    }
                }

                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    m1629invokeUv8p0NA((PointerInputChange) obj2, ((Offset) obj3).m3905unboximpl());
                    return r.f317a;
                }

                /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m1629invokeUv8p0NA(PointerInputChange pointerInputChange, long j5) {
                    AbstractC1683A.n(clockDialNode2.getCoroutineScope(), null, new AnonymousClass1(clockDialNode2, j5, null), 3);
                    TimePickerKt.m2500moveSelectord3b8Pxo(clockDialNode2.state, clockDialNode2.offsetX, clockDialNode2.offsetY, clockDialNode2.getMaxDist(), clockDialNode2.center);
                }
            };
            this.label = 1;
            if (DragGestureDetectorKt.detectDragGestures$default(pointerInputScope, null, aVar, null, nVar, this, 5, null) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return r.f317a;
    }
}
