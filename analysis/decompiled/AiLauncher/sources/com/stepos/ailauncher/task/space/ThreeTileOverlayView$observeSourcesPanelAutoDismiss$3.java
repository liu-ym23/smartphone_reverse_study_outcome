package com.stepos.ailauncher.task.space;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3", f = "ThreeTileOverlayView.kt", l = {3224}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ ThreeTileOverlayView this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ ThreeTileOverlayView this$0;

        public a(ThreeTileOverlayView threeTileOverlayView) {
            this.this$0 = threeTileOverlayView;
        }

        public final Object b(boolean z10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            if (z10) {
                this.this$0.f3("progress<1");
            }
            return Y8.t.f7040a;
        }

        @Override // Xa.c
        public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
            return b(((Boolean) obj).booleanValue(), interfaceC4014c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3(ThreeTileOverlayView threeTileOverlayView, InterfaceC4014c<? super ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = threeTileOverlayView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            final Xa.t<Float> tVarE = com.stepos.ailauncher.container.m0.INSTANCE.e();
            Xa.b bVarQ = Xa.d.q(new Xa.b<Boolean>() { // from class: com.stepos.ailauncher.task.space.ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3$invokeSuspend$$inlined$map$1

                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: com.stepos.ailauncher.task.space.ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements Xa.c {
                    final /* synthetic */ Xa.c $this_unsafeFlow;

                    @InterfaceC4112d(c = "com.stepos.ailauncher.task.space.ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3$invokeSuspend$$inlined$map$1$2", f = "ThreeTileOverlayView.kt", l = {217}, m = "emit", v = 1)
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    /* renamed from: com.stepos.ailauncher.task.space.ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
                            super(interfaceC4014c);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(Xa.c cVar) {
                        this.$this_unsafeFlow = cVar;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // Xa.c
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r6, e9.InterfaceC4014c r7) throws java.lang.Throwable {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof com.stepos.ailauncher.task.space.ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r7
                            com.stepos.ailauncher.task.space.ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3$invokeSuspend$$inlined$map$1$2$1 r0 = (com.stepos.ailauncher.task.space.ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.stepos.ailauncher.task.space.ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3$invokeSuspend$$inlined$map$1$2$1 r0 = new com.stepos.ailauncher.task.space.ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.result
                            java.lang.Object r1 = f9.C4063a.g()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L39
                            if (r2 != r3) goto L31
                            java.lang.Object r5 = r0.L$3
                            Xa.c r5 = (Xa.c) r5
                            java.lang.Object r5 = r0.L$1
                            com.stepos.ailauncher.task.space.ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3$invokeSuspend$$inlined$map$1$2$1 r5 = (com.stepos.ailauncher.task.space.ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r5
                            kotlin.C4849c.b(r7)
                            goto L76
                        L31:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L39:
                            kotlin.C4849c.b(r7)
                            Xa.c r5 = r5.$this_unsafeFlow
                            r7 = r6
                            java.lang.Number r7 = (java.lang.Number) r7
                            float r7 = r7.floatValue()
                            r2 = 1065353216(0x3f800000, float:1.0)
                            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                            r2 = 0
                            if (r7 >= 0) goto L4e
                            r7 = r3
                            goto L4f
                        L4e:
                            r7 = r2
                        L4f:
                            java.lang.Boolean r7 = g9.C4109a.a(r7)
                            java.lang.Object r4 = g9.h.a(r6)
                            r0.L$0 = r4
                            java.lang.Object r4 = g9.h.a(r0)
                            r0.L$1 = r4
                            java.lang.Object r6 = g9.h.a(r6)
                            r0.L$2 = r6
                            java.lang.Object r6 = g9.h.a(r5)
                            r0.L$3 = r6
                            r0.I$0 = r2
                            r0.label = r3
                            java.lang.Object r5 = r5.emit(r7, r0)
                            if (r5 != r1) goto L76
                            return r1
                        L76:
                            Y8.t r5 = Y8.t.f7040a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.ThreeTileOverlayView$observeSourcesPanelAutoDismiss$3$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                    }
                }

                @Override // Xa.b
                public Object collect(Xa.c<? super Boolean> cVar, InterfaceC4014c interfaceC4014c) {
                    Object objCollect = tVarE.collect(new AnonymousClass2(cVar), interfaceC4014c);
                    return objCollect == C4063a.g() ? objCollect : Y8.t.f7040a;
                }
            });
            a aVar = new a(this.this$0);
            this.label = 1;
            if (bVarQ.collect(aVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
