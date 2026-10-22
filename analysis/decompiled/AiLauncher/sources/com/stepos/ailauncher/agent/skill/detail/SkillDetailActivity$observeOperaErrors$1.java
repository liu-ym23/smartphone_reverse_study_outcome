package com.stepos.ailauncher.agent.skill.detail;

import X4.OperaError;
import android.view.Lifecycle;
import android.view.RepeatOnLifecycleKt;
import android.widget.Toast;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.contract.OperaErrorKind;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity$observeOperaErrors$1", f = "SkillDetailActivity.kt", l = {420}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillDetailActivity$observeOperaErrors$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ X4.a $svc;
    int label;
    final /* synthetic */ SkillDetailActivity this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity$observeOperaErrors$1$1", f = "SkillDetailActivity.kt", l = {421}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity$observeOperaErrors$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ X4.a $svc;
        int label;
        final /* synthetic */ SkillDetailActivity this$0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity$observeOperaErrors$1$1$a */
        public static final class a<T> implements Xa.c {
            final /* synthetic */ SkillDetailActivity this$0;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.agent.skill.detail.SkillDetailActivity$observeOperaErrors$1$1$a$a, reason: collision with other inner class name */
            public static final /* synthetic */ class C0264a {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[OperaErrorKind.values().length];
                    try {
                        iArr[OperaErrorKind.INSTALL.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[OperaErrorKind.CANCEL.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[OperaErrorKind.UNINSTALL.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[OperaErrorKind.ENABLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[OperaErrorKind.DISABLE.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[OperaErrorKind.UPDATE.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public a(SkillDetailActivity skillDetailActivity) {
                this.this$0 = skillDetailActivity;
            }

            @Override // Xa.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(OperaError operaError, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                String string;
                String identifier = operaError.getIdentifier();
                String str = this.this$0.slug;
                if (str == null) {
                    kotlin.jvm.internal.p.A("slug");
                    str = null;
                }
                if (!kotlin.jvm.internal.p.d(identifier, str)) {
                    return Y8.t.f7040a;
                }
                switch (C0264a.$EnumSwitchMapping$0[operaError.getKind().ordinal()]) {
                    case 1:
                        string = this.this$0.getString(R$string.skill_detail_op_failed_install);
                        break;
                    case 2:
                        string = this.this$0.getString(R$string.skill_detail_op_failed_cancel);
                        break;
                    case 3:
                        string = this.this$0.getString(R$string.skill_detail_op_failed_uninstall);
                        break;
                    case 4:
                        string = this.this$0.getString(R$string.skill_detail_op_failed_enable);
                        break;
                    case 5:
                        string = this.this$0.getString(R$string.skill_detail_op_failed_disable);
                        break;
                    case 6:
                        string = this.this$0.getString(R$string.skill_detail_op_failed_update);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                kotlin.jvm.internal.p.f(string);
                String msg = operaError.getMsg();
                if (msg != null) {
                    String str2 = La.H.x0(msg) ? null : msg;
                    if (str2 != null) {
                        String str3 = string + ": " + str2;
                        if (str3 != null) {
                            string = str3;
                        }
                    }
                }
                Toast.makeText(this.this$0, string, 0).show();
                return Y8.t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(X4.a aVar, SkillDetailActivity skillDetailActivity, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$svc = aVar;
            this.this$0 = skillDetailActivity;
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
                Xa.o<OperaError> oVarM = this.$svc.m();
                a aVar = new a(this.this$0);
                this.label = 1;
                if (oVarM.collect(aVar, this) == objG) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillDetailActivity$observeOperaErrors$1(SkillDetailActivity skillDetailActivity, X4.a aVar, InterfaceC4014c<? super SkillDetailActivity$observeOperaErrors$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = skillDetailActivity;
        this.$svc = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SkillDetailActivity$observeOperaErrors$1(this.this$0, this.$svc, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SkillDetailActivity$observeOperaErrors$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            SkillDetailActivity skillDetailActivity = this.this$0;
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$svc, skillDetailActivity, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(skillDetailActivity, state, anonymousClass1, this) == objG) {
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
