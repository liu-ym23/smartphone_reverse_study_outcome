package com.stepos.ailauncher.agent.skill.detail;

import android.view.Lifecycle;
import android.view.RepeatOnLifecycleKt;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1", f = "SkillDetailFragment.kt", l = {388}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillDetailFragment$observeOperaState$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ X4.a $svc;
    int label;
    final /* synthetic */ SkillDetailFragment this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1", f = "SkillDetailFragment.kt", l = {402}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ X4.a $svc;
        int label;
        final /* synthetic */ SkillDetailFragment this$0;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/SkillItem;", "item", "", "isToggling", "isUninstalling", "Lcom/stepos/ailauncher/agent/skill/detail/F;", "dto", "", "", "<anonymous>", "(Lcom/stepos/ailauncher/agent/skill/SkillItem;ZZLcom/stepos/ailauncher/agent/skill/detail/F;)Lkotlin/Array;"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$4", f = "SkillDetailFragment.kt", l = {}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$4, reason: invalid class name */
        public static final class AnonymousClass4 extends SuspendLambda implements p9.s<SkillItem, Boolean, Boolean, SkillDetailDto, InterfaceC4014c<? super Object[]>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            /* synthetic */ boolean Z$0;
            /* synthetic */ boolean Z$1;
            int label;

            public AnonymousClass4(InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
                super(5, interfaceC4014c);
            }

            public final Object f(SkillItem skillItem, boolean z10, boolean z11, SkillDetailDto skillDetailDto, InterfaceC4014c<? super Object[]> interfaceC4014c) {
                AnonymousClass4 anonymousClass4 = new AnonymousClass4(interfaceC4014c);
                anonymousClass4.L$0 = skillItem;
                anonymousClass4.Z$0 = z10;
                anonymousClass4.Z$1 = z11;
                anonymousClass4.L$1 = skillDetailDto;
                return anonymousClass4.invokeSuspend(Y8.t.f7040a);
            }

            @Override // p9.s
            public /* bridge */ /* synthetic */ Object invoke(SkillItem skillItem, Boolean bool, Boolean bool2, SkillDetailDto skillDetailDto, InterfaceC4014c<? super Object[]> interfaceC4014c) {
                return f(skillItem, bool.booleanValue(), bool2.booleanValue(), skillDetailDto, interfaceC4014c);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                SkillItem skillItem = (SkillItem) this.L$0;
                boolean z10 = this.Z$0;
                boolean z11 = this.Z$1;
                SkillDetailDto skillDetailDto = (SkillDetailDto) this.L$1;
                C4063a.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return new Object[]{skillItem, C4109a.a(z10), C4109a.a(z11), skillDetailDto};
            }
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$6, reason: invalid class name */
        public static final class AnonymousClass6<T> implements Xa.c {
            final /* synthetic */ SkillDetailFragment this$0;

            public AnonymousClass6(SkillDetailFragment skillDetailFragment) {
                this.this$0 = skillDetailFragment;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // Xa.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(java.lang.Object[] r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
                /*
                    r8 = this;
                    boolean r0 = r10 instanceof com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$6$emit$1
                    if (r0 == 0) goto L13
                    r0 = r10
                    com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$6$emit$1 r0 = (com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$6$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L18
                L13:
                    com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$6$emit$1 r0 = new com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$6$emit$1
                    r0.<init>(r8, r10)
                L18:
                    java.lang.Object r10 = r0.result
                    java.lang.Object r1 = f9.C4063a.g()
                    int r2 = r0.label
                    r3 = 0
                    r4 = 1
                    if (r2 == 0) goto L3e
                    if (r2 != r4) goto L36
                    boolean r9 = r0.Z$1
                    boolean r1 = r0.Z$0
                    java.lang.Object r2 = r0.L$1
                    com.stepos.ailauncher.agent.skill.SkillItem r2 = (com.stepos.ailauncher.agent.skill.SkillItem) r2
                    java.lang.Object r0 = r0.L$0
                    java.lang.Object[] r0 = (java.lang.Object[]) r0
                    kotlin.C4849c.b(r10)
                    goto L81
                L36:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L3e:
                    kotlin.C4849c.b(r10)
                    r10 = 0
                    r10 = r9[r10]
                    r2 = r10
                    com.stepos.ailauncher.agent.skill.SkillItem r2 = (com.stepos.ailauncher.agent.skill.SkillItem) r2
                    r10 = r9[r4]
                    java.lang.String r5 = "null cannot be cast to non-null type kotlin.Boolean"
                    kotlin.jvm.internal.p.g(r10, r5)
                    java.lang.Boolean r10 = (java.lang.Boolean) r10
                    boolean r10 = r10.booleanValue()
                    r6 = 2
                    r6 = r9[r6]
                    kotlin.jvm.internal.p.g(r6, r5)
                    java.lang.Boolean r6 = (java.lang.Boolean) r6
                    boolean r5 = r6.booleanValue()
                    com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment r6 = r8.this$0
                    if (r2 == 0) goto L69
                    com.stepos.ailauncher.agent.skill.SkillStatus r7 = r2.getStatus()
                    goto L6a
                L69:
                    r7 = r3
                L6a:
                    java.lang.Object r9 = g9.h.a(r9)
                    r0.L$0 = r9
                    r0.L$1 = r2
                    r0.Z$0 = r10
                    r0.Z$1 = r5
                    r0.label = r4
                    java.lang.Object r9 = com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment.e0(r6, r7, r0)
                    if (r9 != r1) goto L7f
                    return r1
                L7f:
                    r1 = r10
                    r9 = r5
                L81:
                    com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment r10 = r8.this$0
                    com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment.l0(r10, r2)
                    com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment r10 = r8.this$0
                    if (r2 != 0) goto L8f
                    com.stepos.ailauncher.agent.skill.SkillItem r0 = com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment.Z(r10)
                    goto L90
                L8f:
                    r0 = r2
                L90:
                    com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment.h0(r10, r0, r1, r9)
                    com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment r8 = r8.this$0
                    if (r2 == 0) goto L9b
                    com.stepos.ailauncher.agent.skill.SkillStatus r3 = r2.getStatus()
                L9b:
                    com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment.f0(r8, r3, r1)
                    Y8.t r8 = Y8.t.f7040a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1.AnonymousClass1.AnonymousClass6.emit(java.lang.Object[], e9.c):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(X4.a aVar, SkillDetailFragment skillDetailFragment, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$svc = aVar;
            this.this$0 = skillDetailFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean h(Object[] objArr, Object[] objArr2) {
            return kotlin.jvm.internal.p.d(objArr[0], objArr2[0]) && kotlin.jvm.internal.p.d(objArr[1], objArr2[1]) && kotlin.jvm.internal.p.d(objArr[2], objArr2[2]) && kotlin.jvm.internal.p.d(objArr[3], objArr2[3]);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$svc, this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                final Xa.t<Map<String, SkillItem>> tVarJ = this.$svc.j();
                final SkillDetailFragment skillDetailFragment = this.this$0;
                Xa.b<SkillItem> bVar = new Xa.b<SkillItem>() { // from class: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$1

                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements Xa.c {
                        final /* synthetic */ Xa.c $this_unsafeFlow;
                        final /* synthetic */ SkillDetailFragment this$0;

                        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$1$2", f = "SkillDetailFragment.kt", l = {217}, m = "emit", v = 1)
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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

                        public AnonymousClass2(Xa.c cVar, SkillDetailFragment skillDetailFragment) {
                            this.$this_unsafeFlow = cVar;
                            this.this$0 = skillDetailFragment;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // Xa.c
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, e9.InterfaceC4014c r6) throws java.lang.Throwable {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = f9.C4063a.g()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L39
                                if (r2 != r3) goto L31
                                java.lang.Object r4 = r0.L$3
                                Xa.c r4 = (Xa.c) r4
                                java.lang.Object r4 = r0.L$1
                                com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$1$2$1 r4 = (com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r4
                                kotlin.C4849c.b(r6)
                                goto L78
                            L31:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L39:
                                kotlin.C4849c.b(r6)
                                Xa.c r6 = r4.$this_unsafeFlow
                                r2 = r5
                                java.util.Map r2 = (java.util.Map) r2
                                com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment r4 = r4.this$0
                                java.lang.String r4 = com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment.b0(r4)
                                if (r4 != 0) goto L50
                                java.lang.String r4 = "slug"
                                kotlin.jvm.internal.p.A(r4)
                                r4 = 0
                            L50:
                                java.lang.Object r4 = r2.get(r4)
                                java.lang.Object r2 = g9.h.a(r5)
                                r0.L$0 = r2
                                java.lang.Object r2 = g9.h.a(r0)
                                r0.L$1 = r2
                                java.lang.Object r5 = g9.h.a(r5)
                                r0.L$2 = r5
                                java.lang.Object r5 = g9.h.a(r6)
                                r0.L$3 = r5
                                r5 = 0
                                r0.I$0 = r5
                                r0.label = r3
                                java.lang.Object r4 = r6.emit(r4, r0)
                                if (r4 != r1) goto L78
                                return r1
                            L78:
                                Y8.t r4 = Y8.t.f7040a
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                        }
                    }

                    @Override // Xa.b
                    public Object collect(Xa.c<? super SkillItem> cVar, InterfaceC4014c interfaceC4014c) {
                        Object objCollect = tVarJ.collect(new AnonymousClass2(cVar, skillDetailFragment), interfaceC4014c);
                        return objCollect == C4063a.g() ? objCollect : Y8.t.f7040a;
                    }
                };
                final Xa.t<Set<String>> tVarL = this.$svc.l();
                final SkillDetailFragment skillDetailFragment2 = this.this$0;
                Xa.b<Boolean> bVar2 = new Xa.b<Boolean>() { // from class: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$2

                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$2$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements Xa.c {
                        final /* synthetic */ Xa.c $this_unsafeFlow;
                        final /* synthetic */ SkillDetailFragment this$0;

                        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$2$2", f = "SkillDetailFragment.kt", l = {217}, m = "emit", v = 1)
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$2$2$1, reason: invalid class name */
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

                        public AnonymousClass2(Xa.c cVar, SkillDetailFragment skillDetailFragment) {
                            this.$this_unsafeFlow = cVar;
                            this.this$0 = skillDetailFragment;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // Xa.c
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, e9.InterfaceC4014c r6) throws java.lang.Throwable {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$2.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$2$2$1 r0 = (com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$2$2$1 r0 = new com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$2$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = f9.C4063a.g()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L39
                                if (r2 != r3) goto L31
                                java.lang.Object r4 = r0.L$3
                                Xa.c r4 = (Xa.c) r4
                                java.lang.Object r4 = r0.L$1
                                com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$2$2$1 r4 = (com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$2.AnonymousClass2.AnonymousClass1) r4
                                kotlin.C4849c.b(r6)
                                goto L7c
                            L31:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L39:
                                kotlin.C4849c.b(r6)
                                Xa.c r6 = r4.$this_unsafeFlow
                                r2 = r5
                                java.util.Set r2 = (java.util.Set) r2
                                com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment r4 = r4.this$0
                                java.lang.String r4 = com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment.b0(r4)
                                if (r4 != 0) goto L50
                                java.lang.String r4 = "slug"
                                kotlin.jvm.internal.p.A(r4)
                                r4 = 0
                            L50:
                                boolean r4 = r2.contains(r4)
                                java.lang.Boolean r4 = g9.C4109a.a(r4)
                                java.lang.Object r2 = g9.h.a(r5)
                                r0.L$0 = r2
                                java.lang.Object r2 = g9.h.a(r0)
                                r0.L$1 = r2
                                java.lang.Object r5 = g9.h.a(r5)
                                r0.L$2 = r5
                                java.lang.Object r5 = g9.h.a(r6)
                                r0.L$3 = r5
                                r5 = 0
                                r0.I$0 = r5
                                r0.label = r3
                                java.lang.Object r4 = r6.emit(r4, r0)
                                if (r4 != r1) goto L7c
                                return r1
                            L7c:
                                Y8.t r4 = Y8.t.f7040a
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                        }
                    }

                    @Override // Xa.b
                    public Object collect(Xa.c<? super Boolean> cVar, InterfaceC4014c interfaceC4014c) {
                        Object objCollect = tVarL.collect(new AnonymousClass2(cVar, skillDetailFragment2), interfaceC4014c);
                        return objCollect == C4063a.g() ? objCollect : Y8.t.f7040a;
                    }
                };
                final Xa.t<Set<String>> tVarD = this.$svc.d();
                final SkillDetailFragment skillDetailFragment3 = this.this$0;
                Xa.b bVarR = Xa.d.r(Xa.d.l(bVar, bVar2, new Xa.b<Boolean>() { // from class: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$3

                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$3$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements Xa.c {
                        final /* synthetic */ Xa.c $this_unsafeFlow;
                        final /* synthetic */ SkillDetailFragment this$0;

                        @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$3$2", f = "SkillDetailFragment.kt", l = {217}, m = "emit", v = 1)
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$3$2$1, reason: invalid class name */
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

                        public AnonymousClass2(Xa.c cVar, SkillDetailFragment skillDetailFragment) {
                            this.$this_unsafeFlow = cVar;
                            this.this$0 = skillDetailFragment;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // Xa.c
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r5, e9.InterfaceC4014c r6) throws java.lang.Throwable {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$3.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$3$2$1 r0 = (com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$3.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$3$2$1 r0 = new com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$3$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = f9.C4063a.g()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L39
                                if (r2 != r3) goto L31
                                java.lang.Object r4 = r0.L$3
                                Xa.c r4 = (Xa.c) r4
                                java.lang.Object r4 = r0.L$1
                                com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$3$2$1 r4 = (com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$3.AnonymousClass2.AnonymousClass1) r4
                                kotlin.C4849c.b(r6)
                                goto L7c
                            L31:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L39:
                                kotlin.C4849c.b(r6)
                                Xa.c r6 = r4.$this_unsafeFlow
                                r2 = r5
                                java.util.Set r2 = (java.util.Set) r2
                                com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment r4 = r4.this$0
                                java.lang.String r4 = com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment.b0(r4)
                                if (r4 != 0) goto L50
                                java.lang.String r4 = "slug"
                                kotlin.jvm.internal.p.A(r4)
                                r4 = 0
                            L50:
                                boolean r4 = r2.contains(r4)
                                java.lang.Boolean r4 = g9.C4109a.a(r4)
                                java.lang.Object r2 = g9.h.a(r5)
                                r0.L$0 = r2
                                java.lang.Object r2 = g9.h.a(r0)
                                r0.L$1 = r2
                                java.lang.Object r5 = g9.h.a(r5)
                                r0.L$2 = r5
                                java.lang.Object r5 = g9.h.a(r6)
                                r0.L$3 = r5
                                r5 = 0
                                r0.I$0 = r5
                                r0.label = r3
                                java.lang.Object r4 = r6.emit(r4, r0)
                                if (r4 != r1) goto L7c
                                return r1
                            L7c:
                                Y8.t r4 = Y8.t.f7040a
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.skill.detail.SkillDetailFragment$observeOperaState$1$1$invokeSuspend$$inlined$map$3.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                        }
                    }

                    @Override // Xa.b
                    public Object collect(Xa.c<? super Boolean> cVar, InterfaceC4014c interfaceC4014c) {
                        Object objCollect = tVarD.collect(new AnonymousClass2(cVar, skillDetailFragment3), interfaceC4014c);
                        return objCollect == C4063a.g() ? objCollect : Y8.t.f7040a;
                    }
                }, this.this$0.currentDtoFlow, new AnonymousClass4(null)), new p9.p() { // from class: com.stepos.ailauncher.agent.skill.detail.g0
                    @Override // p9.p
                    public final Object invoke(Object obj2, Object obj3) {
                        return Boolean.valueOf(SkillDetailFragment$observeOperaState$1.AnonymousClass1.h((Object[]) obj2, (Object[]) obj3));
                    }
                });
                AnonymousClass6 anonymousClass6 = new AnonymousClass6(this.this$0);
                this.label = 1;
                if (bVarR.collect(anonymousClass6, this) == objG) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillDetailFragment$observeOperaState$1(SkillDetailFragment skillDetailFragment, X4.a aVar, InterfaceC4014c<? super SkillDetailFragment$observeOperaState$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = skillDetailFragment;
        this.$svc = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SkillDetailFragment$observeOperaState$1(this.this$0, this.$svc, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SkillDetailFragment$observeOperaState$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            SkillDetailFragment skillDetailFragment = this.this$0;
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$svc, skillDetailFragment, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(skillDetailFragment, state, anonymousClass1, this) == objG) {
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
