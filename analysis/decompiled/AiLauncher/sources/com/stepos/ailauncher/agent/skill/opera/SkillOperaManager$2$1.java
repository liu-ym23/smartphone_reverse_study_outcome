package com.stepos.ailauncher.agent.skill.opera;

import Ua.M;
import Xa.c;
import Xa.o;
import Y8.t;
import com.stepos.ailauncher.agent.skill.SkillItem;
import com.stepos.ailauncher.agent.skill.installer.SkillInstaller;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.opera.SkillOperaManager$2$1", f = "SkillOperaManager.kt", l = {152}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillOperaManager$2$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ SkillInstaller $installer;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements c {
        public static final a<T> INSTANCE = new a<>();

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(Map<String, SkillItem> map, InterfaceC4014c<? super t> interfaceC4014c) {
            Object objI;
            return (!map.isEmpty() && (objI = SkillOperaManager.INSTANCE.I(map, interfaceC4014c)) == C4063a.g()) ? objI : t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillOperaManager$2$1(SkillInstaller skillInstaller, InterfaceC4014c<? super SkillOperaManager$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$installer = skillInstaller;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SkillOperaManager$2$1(this.$installer, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SkillOperaManager$2$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            o<Map<String, SkillItem>> oVarD = this.$installer.d();
            c<? super Map<String, SkillItem>> cVar = a.INSTANCE;
            this.label = 1;
            if (oVarD.collect(cVar, this) == objG) {
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
