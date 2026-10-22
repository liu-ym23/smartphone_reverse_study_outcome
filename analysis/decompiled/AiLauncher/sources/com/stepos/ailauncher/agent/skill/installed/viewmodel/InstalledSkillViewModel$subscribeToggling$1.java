package com.stepos.ailauncher.agent.skill.installed.viewmodel;

import Ua.M;
import Xa.k;
import Y8.t;
import com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.installed.viewmodel.InstalledSkillViewModel$subscribeToggling$1", f = "InstalledSkillViewModel.kt", l = {271}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class InstalledSkillViewModel$subscribeToggling$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ X4.a $s;
    int label;
    final /* synthetic */ InstalledSkillViewModel this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ InstalledSkillViewModel this$0;

        public a(InstalledSkillViewModel installedSkillViewModel) {
            this.this$0 = installedSkillViewModel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(Set<String> set, InterfaceC4014c<? super t> interfaceC4014c) {
            k kVar = this.this$0._uiState;
            while (true) {
                Object value = kVar.getValue();
                Set<String> set2 = set;
                if (kVar.d(value, InstalledSkillViewModel.InstalledSkillUiState.b((InstalledSkillViewModel.InstalledSkillUiState) value, null, null, null, null, false, false, false, set2, null, false, 895, null))) {
                    return t.f7040a;
                }
                set = set2;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstalledSkillViewModel$subscribeToggling$1(X4.a aVar, InstalledSkillViewModel installedSkillViewModel, InterfaceC4014c<? super InstalledSkillViewModel$subscribeToggling$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$s = aVar;
        this.this$0 = installedSkillViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new InstalledSkillViewModel$subscribeToggling$1(this.$s, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((InstalledSkillViewModel$subscribeToggling$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.t<Set<String>> tVarL = this.$s.l();
            a aVar = new a(this.this$0);
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
