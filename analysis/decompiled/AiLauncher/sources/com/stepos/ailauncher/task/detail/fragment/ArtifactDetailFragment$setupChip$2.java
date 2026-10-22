package com.stepos.ailauncher.task.detail.fragment;

import Ua.C1060i;
import Ua.M;
import Z8.C1173v;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.RepeatOnLifecycleKt;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.ailauncher.chat.fragment.I0;
import com.stepos.ailauncher.chat.manager.Q0;
import com.stepos.ailauncher.contract.api.livenotification.IRiskLiveNotificationService;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.task.detail.ArtifactDetailActivity;
import com.stepos.ailauncher.task.detail.chip.TaskChipController;
import com.stepos.ailauncher.task.detail.version.ArtifactVersions;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2", f = "ArtifactDetailFragment.kt", l = {803}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactDetailFragment$setupChip$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ TaskChipController $chip;
    int label;
    final /* synthetic */ ArtifactDetailFragment this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1", f = "ArtifactDetailFragment.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ TaskChipController $chip;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ArtifactDetailFragment this$0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$1", f = "ArtifactDetailFragment.kt", l = {805}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03331 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
            final /* synthetic */ TaskChipController $chip;
            int label;
            final /* synthetic */ ArtifactDetailFragment this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$1$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ TaskChipController $chip;
                final /* synthetic */ ArtifactDetailFragment this$0;

                public a(ArtifactDetailFragment artifactDetailFragment, TaskChipController taskChipController) {
                    this.this$0 = artifactDetailFragment;
                    this.$chip = taskChipController;
                }

                public static final Y8.t g(ArtifactDetailFragment artifactDetailFragment, String str, DisplayMessage m10) {
                    kotlin.jvm.internal.p.i(m10, "m");
                    if (m10.getRole() == AgentRole.ASSISTANT && m10.getStatus().isTerminal() && artifactDetailFragment.roundActive) {
                        artifactDetailFragment.roundActive = false;
                        androidx.fragment.app.r activity = artifactDetailFragment.getActivity();
                        ArtifactDetailActivity artifactDetailActivity = activity instanceof ArtifactDetailActivity ? (ArtifactDetailActivity) activity : null;
                        List<String> listT4 = artifactDetailActivity != null ? artifactDetailActivity.T4() : null;
                        if (listT4 == null) {
                            listT4 = C1173v.m();
                        }
                        List<String> listQ = listT4;
                        if (listQ.isEmpty()) {
                            if (str.length() <= 0) {
                                str = null;
                            }
                            listQ = C1173v.q(str);
                        }
                        Q0.n(listQ);
                        ArtifactVersions artifactVersions = artifactDetailFragment.versions;
                        if (artifactVersions != null) {
                            artifactVersions.l();
                        }
                    }
                    return Y8.t.f7040a;
                }

                /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
                @Override // Xa.c
                /* renamed from: f, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(com.stepos.ailauncher.chat.fragment.I0.ChatCoreHandle r4, e9.InterfaceC4014c<? super Y8.t> r5) {
                    /*
                        r3 = this;
                        if (r4 != 0) goto L5
                        Y8.t r3 = Y8.t.f7040a
                        return r3
                    L5:
                        com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment r5 = r3.this$0
                        com.stepos.ailauncher.contract.model.SessionArtifact r5 = com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment.m0(r5)
                        r0 = 0
                        if (r5 == 0) goto L1e
                        java.lang.String r5 = r5.getSessionId()
                        if (r5 == 0) goto L1e
                        int r1 = r5.length()
                        if (r1 <= 0) goto L1b
                        goto L1c
                    L1b:
                        r5 = r0
                    L1c:
                        if (r5 != 0) goto L32
                    L1e:
                        com.stepos.agentframework.chatcore.SessionHandler r5 = r4.getHandler()
                        com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r5 = r5.R1()
                        if (r5 == 0) goto L2c
                        java.lang.String r0 = r5.B()
                    L2c:
                        if (r0 != 0) goto L31
                        java.lang.String r5 = ""
                        goto L32
                    L31:
                        r5 = r0
                    L32:
                        com.stepos.ailauncher.task.detail.chip.TaskChipController r0 = r3.$chip
                        com.stepos.agentframework.chatcore.SessionHandler r1 = r4.getHandler()
                        com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment r2 = r3.this$0
                        java.lang.String r2 = com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment.j0(r2)
                        boolean r0 = r0.p(r1, r5, r2)
                        if (r0 == 0) goto L4a
                        com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment r0 = r3.this$0
                        r1 = 1
                        com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment.r0(r0, r1)
                    L4a:
                        com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment r0 = r3.this$0
                        com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment.q0(r0, r4)
                        com.stepos.ailauncher.chat.view.LauncherChatLayout r4 = r4.getChatLayout()
                        com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment r3 = r3.this$0
                        com.stepos.ailauncher.task.detail.fragment.L r0 = new com.stepos.ailauncher.task.detail.fragment.L
                        r0.<init>()
                        r4.setOnReceiveMessage(r0)
                        Y8.t r3 = Y8.t.f7040a
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2.AnonymousClass1.C03331.a.emit(com.stepos.ailauncher.chat.fragment.I0$a, e9.c):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03331(ArtifactDetailFragment artifactDetailFragment, TaskChipController taskChipController, InterfaceC4014c<? super C03331> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = artifactDetailFragment;
                this.$chip = taskChipController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new C03331(this.this$0, this.$chip, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((C03331) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    Xa.t<I0.ChatCoreHandle> tVarL = this.this$0.I0().l();
                    a aVar = new a(this.this$0, this.$chip);
                    this.label = 1;
                    if (tVarL.collect(aVar, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$2", f = "ArtifactDetailFragment.kt", l = {837}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
            final /* synthetic */ TaskChipController $chip;
            int label;
            final /* synthetic */ ArtifactDetailFragment this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$2$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ TaskChipController $chip;
                final /* synthetic */ ArtifactDetailFragment this$0;

                public a(TaskChipController taskChipController, ArtifactDetailFragment artifactDetailFragment) {
                    this.$chip = taskChipController;
                    this.this$0 = artifactDetailFragment;
                }

                public final Object b(int i10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    SessionArtifact sessionArtifactE;
                    this.$chip.y(this.this$0.B0());
                    this.this$0.roundActive = true;
                    ArtifactVersions artifactVersions = this.this$0.versions;
                    if (artifactVersions != null && (sessionArtifactE = artifactVersions.e()) != null) {
                        M5.c.INSTANCE.B(sessionArtifactE, this.this$0.E1(), M5.c.REEDIT_INSTRUCTION);
                    }
                    return Y8.t.f7040a;
                }

                @Override // Xa.c
                public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
                    return b(((Number) obj).intValue(), interfaceC4014c);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(ArtifactDetailFragment artifactDetailFragment, TaskChipController taskChipController, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = artifactDetailFragment;
                this.$chip = taskChipController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass2(this.this$0, this.$chip, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    Xa.b bVarS = Xa.d.s(this.this$0.I0().r(), 1);
                    a aVar = new a(this.$chip, this.this$0);
                    this.label = 1;
                    if (bVarS.collect(aVar, this) == objG) {
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

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$3", f = "ArtifactDetailFragment.kt", l = {852}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
            final /* synthetic */ TaskChipController $chip;
            int label;
            final /* synthetic */ ArtifactDetailFragment this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$3$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ TaskChipController $chip;
                final /* synthetic */ ArtifactDetailFragment this$0;

                public a(ArtifactDetailFragment artifactDetailFragment, TaskChipController taskChipController) {
                    this.this$0 = artifactDetailFragment;
                    this.$chip = taskChipController;
                }

                public final Object b(boolean z10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    if (z10) {
                        this.this$0.roundActive = false;
                        this.$chip.z();
                    }
                    return Y8.t.f7040a;
                }

                @Override // Xa.c
                public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
                    return b(((Boolean) obj).booleanValue(), interfaceC4014c);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(ArtifactDetailFragment artifactDetailFragment, TaskChipController taskChipController, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = artifactDetailFragment;
                this.$chip = taskChipController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass3(this.this$0, this.$chip, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    Xa.t<Boolean> tVarU = this.this$0.I0().u();
                    a aVar = new a(this.this$0, this.$chip);
                    this.label = 1;
                    if (tVarU.collect(aVar, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$4", f = "ArtifactDetailFragment.kt", l = {860}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$4, reason: invalid class name */
        public static final class AnonymousClass4 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
            final /* synthetic */ TaskChipController $chip;
            int label;
            final /* synthetic */ ArtifactDetailFragment this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$4$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ TaskChipController $chip;

                public a(TaskChipController taskChipController) {
                    this.$chip = taskChipController;
                }

                public final Object b(boolean z10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    this.$chip.H(z10);
                    return Y8.t.f7040a;
                }

                @Override // Xa.c
                public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
                    return b(((Boolean) obj).booleanValue(), interfaceC4014c);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(ArtifactDetailFragment artifactDetailFragment, TaskChipController taskChipController, InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = artifactDetailFragment;
                this.$chip = taskChipController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass4(this.this$0, this.$chip, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass4) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    Xa.t<Boolean> tVarO = this.this$0.I0().o();
                    a aVar = new a(this.$chip);
                    this.label = 1;
                    if (tVarO.collect(aVar, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$5", f = "ArtifactDetailFragment.kt", l = {876}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$5, reason: invalid class name */
        public static final class AnonymousClass5 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
            final /* synthetic */ TaskChipController $chip;
            Object L$0;
            int label;
            final /* synthetic */ ArtifactDetailFragment this$0;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "sessions", "Lcom/stepos/ailauncher/chat/fragment/I0$a;", "handle", "", "<anonymous>", "(Ljava/util/Set;Lcom/stepos/ailauncher/chat/fragment/I0$a;)Z"}, k = 3, mv = {2, 2, 0})
            @InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$5$1", f = "ArtifactDetailFragment.kt", l = {}, m = "invokeSuspend", v = 1)
            /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$5$1, reason: invalid class name and collision with other inner class name */
            public static final class C03341 extends SuspendLambda implements p9.q<Set<? extends String>, I0.ChatCoreHandle, InterfaceC4014c<? super Boolean>, Object> {
                /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;
                final /* synthetic */ ArtifactDetailFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C03341(ArtifactDetailFragment artifactDetailFragment, InterfaceC4014c<? super C03341> interfaceC4014c) {
                    super(3, interfaceC4014c);
                    this.this$0 = artifactDetailFragment;
                }

                @Override // p9.q
                /* renamed from: f, reason: merged with bridge method [inline-methods] */
                public final Object invoke(Set<String> set, I0.ChatCoreHandle chatCoreHandle, InterfaceC4014c<? super Boolean> interfaceC4014c) {
                    C03341 c03341 = new C03341(this.this$0, interfaceC4014c);
                    c03341.L$0 = set;
                    c03341.L$1 = chatCoreHandle;
                    return c03341.invokeSuspend(Y8.t.f7040a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    String sessionId;
                    SessionHandler handler;
                    AgentSession.AgentConversation agentConversationR1;
                    Set set = (Set) this.L$0;
                    I0.ChatCoreHandle chatCoreHandle = (I0.ChatCoreHandle) this.L$1;
                    C4063a.g();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4849c.b(obj);
                    androidx.fragment.app.r activity = this.this$0.getActivity();
                    String strB = null;
                    ArtifactDetailActivity artifactDetailActivity = activity instanceof ArtifactDetailActivity ? (ArtifactDetailActivity) activity : null;
                    List<String> listT4 = artifactDetailActivity != null ? artifactDetailActivity.T4() : null;
                    if (listT4 == null) {
                        listT4 = C1173v.m();
                    }
                    List<String> listR = listT4;
                    ArtifactDetailFragment artifactDetailFragment = this.this$0;
                    if (listR.isEmpty()) {
                        SessionArtifact sessionArtifactK0 = artifactDetailFragment.K0();
                        if (sessionArtifactK0 == null || (sessionId = sessionArtifactK0.getSessionId()) == null || sessionId.length() <= 0) {
                            sessionId = null;
                        }
                        if (chatCoreHandle != null && (handler = chatCoreHandle.getHandler()) != null && (agentConversationR1 = handler.R1()) != null) {
                            strB = agentConversationR1.B();
                        }
                        listR = C1173v.r(sessionId, strB);
                    }
                    Set setR1 = Z8.F.r1(listR);
                    Set set2 = set;
                    boolean z10 = false;
                    if (!(set2 instanceof Collection) || !set2.isEmpty()) {
                        Iterator it = set2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (setR1.contains((String) it.next())) {
                                z10 = true;
                                break;
                            }
                        }
                    }
                    return C4109a.a(z10);
                }
            }

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.task.detail.fragment.ArtifactDetailFragment$setupChip$2$1$5$a */
            public static final class a<T> implements Xa.c {
                final /* synthetic */ TaskChipController $chip;

                public a(TaskChipController taskChipController) {
                    this.$chip = taskChipController;
                }

                public final Object b(boolean z10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                    this.$chip.E(z10);
                    return Y8.t.f7040a;
                }

                @Override // Xa.c
                public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC4014c interfaceC4014c) {
                    return b(((Boolean) obj).booleanValue(), interfaceC4014c);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass5(ArtifactDetailFragment artifactDetailFragment, TaskChipController taskChipController, InterfaceC4014c<? super AnonymousClass5> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = artifactDetailFragment;
                this.$chip = taskChipController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass5(this.this$0, this.$chip, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((AnonymousClass5) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    IRiskLiveNotificationService iRiskLiveNotificationService = (IRiskLiveNotificationService) D5.a.INSTANCE.a(IRiskLiveNotificationService.class);
                    if (iRiskLiveNotificationService == null) {
                        return Y8.t.f7040a;
                    }
                    Xa.b bVarN = Xa.d.n(iRiskLiveNotificationService.pendingRiskSessions(), this.this$0.I0().l(), new C03341(this.this$0, null));
                    a aVar = new a(this.$chip);
                    this.L$0 = g9.h.a(iRiskLiveNotificationService);
                    this.label = 1;
                    if (bVarN.collect(aVar, this) == objG) {
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
        public AnonymousClass1(ArtifactDetailFragment artifactDetailFragment, TaskChipController taskChipController, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = artifactDetailFragment;
            this.$chip = taskChipController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$chip, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            M m10 = (M) this.L$0;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            C1060i.d(m10, null, null, new C03331(this.this$0, this.$chip, null), 3, null);
            C1060i.d(m10, null, null, new AnonymousClass2(this.this$0, this.$chip, null), 3, null);
            C1060i.d(m10, null, null, new AnonymousClass3(this.this$0, this.$chip, null), 3, null);
            C1060i.d(m10, null, null, new AnonymousClass4(this.this$0, this.$chip, null), 3, null);
            C1060i.d(m10, null, null, new AnonymousClass5(this.this$0, this.$chip, null), 3, null);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactDetailFragment$setupChip$2(ArtifactDetailFragment artifactDetailFragment, TaskChipController taskChipController, InterfaceC4014c<? super ArtifactDetailFragment$setupChip$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = artifactDetailFragment;
        this.$chip = taskChipController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactDetailFragment$setupChip$2(this.this$0, this.$chip, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ArtifactDetailFragment$setupChip$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$chip, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(viewLifecycleOwner, state, anonymousClass1, this) == objG) {
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
