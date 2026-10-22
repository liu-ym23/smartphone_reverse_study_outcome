package stepai.android.mindx.client.inner;

import C7.r;
import S7.n;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.C1724q;
import m9.InterfaceC1723p;
import m9.InterfaceC1733z;
import stepai.android.mindx.client.config.ChatData;

@J7.c(c = "stepai.android.mindx.client.inner.StepInnerClient$iCallback$1$onChatReceive$1", f = "StepInnerClient.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class StepInnerClient$iCallback$1$onChatReceive$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f6202a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepInnerClient$iCallback$1$onChatReceive$1(e eVar, String str, int i, String str2, H7.c cVar) {
        super(2, cVar);
        this.f6202a = eVar;
        this.b = str;
        this.c = i;
        this.d = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new StepInnerClient$iCallback$1$onChatReceive$1(this.f6202a, this.b, this.c, this.d, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        StepInnerClient$iCallback$1$onChatReceive$1 stepInnerClient$iCallback$1$onChatReceive$1 = (StepInnerClient$iCallback$1$onChatReceive$1) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        stepInnerClient$iCallback$1$onChatReceive$1.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        InterfaceC1723p interfaceC1723p = (InterfaceC1723p) this.f6202a.b.remove(this.b);
        if (interfaceC1723p != null) {
            ((C1724q) interfaceC1723p).U(new ChatData(1, this.c, this.d, this.b));
        }
        int i = this.c;
        if (i != 0) {
            e eVar = this.f6202a;
            ArrayList arrayList = eVar.d;
            String str = this.d;
            synchronized (arrayList) {
                Iterator it = eVar.d.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).invoke(new Integer(i), str);
                }
            }
        }
        return r.f317a;
    }
}
