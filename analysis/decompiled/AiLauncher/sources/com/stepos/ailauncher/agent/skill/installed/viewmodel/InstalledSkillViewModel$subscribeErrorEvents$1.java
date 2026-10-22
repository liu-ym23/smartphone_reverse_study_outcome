package com.stepos.ailauncher.agent.skill.installed.viewmodel;

import Ua.M;
import X4.OperaError;
import Xa.o;
import Y8.t;
import com.stepos.ailauncher.agent.contract.OperaErrorKind;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AbstractC3297l;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$subscribeErrorEvents$1", f = "InstalledSkillViewModel.kt", l = {254}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class InstalledSkillViewModel$subscribeErrorEvents$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ X4.a $s;
    int label;
    final /* synthetic */ InstalledSkillViewModel this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ InstalledSkillViewModel this$0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$subscribeErrorEvents$1$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0268a {
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
                    iArr[OperaErrorKind.ENABLE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[OperaErrorKind.DISABLE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[OperaErrorKind.UNINSTALL.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[OperaErrorKind.UPDATE.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public a(InstalledSkillViewModel installedSkillViewModel) {
            this.this$0 = installedSkillViewModel;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(OperaError operaError, InterfaceC4014c<? super t> interfaceC4014c) {
            String str;
            switch (C0268a.$EnumSwitchMapping$0[operaError.getKind().ordinal()]) {
                case 1:
                    str = "安装";
                    break;
                case 2:
                    str = AbstractC3297l.LABEL_DIALOG_CANCEL;
                    break;
                case 3:
                    str = "启用";
                    break;
                case 4:
                    str = "禁用";
                    break;
                case 5:
                    str = "卸载";
                    break;
                case 6:
                    str = "更新";
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            this.this$0._operaError.a(operaError.getDisplayName() + str + "失败");
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstalledSkillViewModel$subscribeErrorEvents$1(X4.a aVar, InstalledSkillViewModel installedSkillViewModel, InterfaceC4014c<? super InstalledSkillViewModel$subscribeErrorEvents$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$s = aVar;
        this.this$0 = installedSkillViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new InstalledSkillViewModel$subscribeErrorEvents$1(this.$s, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((InstalledSkillViewModel$subscribeErrorEvents$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            o<OperaError> oVarM = this.$s.m();
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
