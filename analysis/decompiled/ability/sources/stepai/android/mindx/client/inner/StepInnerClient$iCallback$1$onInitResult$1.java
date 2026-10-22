package stepai.android.mindx.client.inner;

import C7.r;
import S7.n;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import stepai.android.llm.base.log.ILLMLogger;
import stepai.android.mindx.client.config.ConfigsKt;

@J7.c(c = "stepai.android.mindx.client.inner.StepInnerClient$iCallback$1$onInitResult$1", f = "StepInnerClient.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class StepInnerClient$iCallback$1$onInitResult$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6203a;
    public final /* synthetic */ e b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepInnerClient$iCallback$1$onInitResult$1(int i, e eVar, String str, H7.c cVar) {
        super(2, cVar);
        this.f6203a = i;
        this.b = eVar;
        this.c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new StepInnerClient$iCallback$1$onInitResult$1(this.f6203a, this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        StepInnerClient$iCallback$1$onInitResult$1 stepInnerClient$iCallback$1$onInitResult$1 = (StepInnerClient$iCallback$1$onInitResult$1) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        stepInnerClient$iCallback$1$onInitResult$1.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        int i = this.f6203a;
        if (i == 0) {
            e eVar = this.b;
            String str = "Init successful: " + this.c;
            eVar.getClass();
            ILLMLogger.DefaultImpls.printI(eVar, str, ConfigsKt.TAG);
        } else if (i == -4) {
            String str2 = this.c;
            if (str2 == null) {
                str2 = "Version mismatch";
            }
            if (m.h0("0.0.9-dev.1", "dev", false)) {
                throw new RuntimeException(androidx.constraintlayout.core.dsl.a.c(this.f6203a, "Init failed (code:", "): ", str2));
            }
            e eVar2 = this.b;
            String str3 = "Init failed (code:" + this.f6203a + "): " + str2;
            eVar2.getClass();
            ILLMLogger.DefaultImpls.printE(eVar2, str3, ConfigsKt.TAG);
            e eVar3 = this.b;
            ArrayList arrayList = eVar3.d;
            int i6 = this.f6203a;
            synchronized (arrayList) {
                Iterator it = eVar3.d.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).invoke(new Integer(i6), str2);
                }
            }
        } else {
            String str4 = this.c;
            if (str4 == null) {
                str4 = "Init failed";
            }
            e eVar4 = this.b;
            eVar4.getClass();
            ILLMLogger.DefaultImpls.printE(eVar4, "Init failed (code:" + i + "): " + str4, ConfigsKt.TAG);
            e eVar5 = this.b;
            ArrayList arrayList2 = eVar5.d;
            int i10 = this.f6203a;
            synchronized (arrayList2) {
                Iterator it2 = eVar5.d.iterator();
                while (it2.hasNext()) {
                    ((n) it2.next()).invoke(new Integer(i10), str4);
                }
            }
        }
        return r.f317a;
    }
}
