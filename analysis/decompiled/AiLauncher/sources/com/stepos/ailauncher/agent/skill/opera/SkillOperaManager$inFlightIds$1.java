package com.stepos.ailauncher.agent.skill.opera;

import Y8.t;
import Z8.Z;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.r;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.skill.opera.SkillOperaManager$inFlightIds$1", f = "SkillOperaManager.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SkillOperaManager$inFlightIds$1 extends SuspendLambda implements r<Set<? extends String>, Set<? extends String>, Set<? extends String>, InterfaceC4014c<? super Set<? extends String>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    public SkillOperaManager$inFlightIds$1(InterfaceC4014c<? super SkillOperaManager$inFlightIds$1> interfaceC4014c) {
        super(4, interfaceC4014c);
    }

    @Override // p9.r
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Set<String> set, Set<String> set2, Set<String> set3, InterfaceC4014c<? super Set<String>> interfaceC4014c) {
        SkillOperaManager$inFlightIds$1 skillOperaManager$inFlightIds$1 = new SkillOperaManager$inFlightIds$1(interfaceC4014c);
        skillOperaManager$inFlightIds$1.L$0 = set;
        skillOperaManager$inFlightIds$1.L$1 = set2;
        skillOperaManager$inFlightIds$1.L$2 = set3;
        return skillOperaManager$inFlightIds$1.invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Set set = (Set) this.L$0;
        Set set2 = (Set) this.L$1;
        Set set3 = (Set) this.L$2;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return Z.o(Z.o(set, set2), set3);
    }
}
