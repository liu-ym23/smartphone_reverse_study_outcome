package stepai.android.mindx.client.inner;

import C7.r;
import S7.n;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import p9.i;
import stepai.android.mindx.client.config.ChatData;

@J7.c(c = "stepai.android.mindx.client.inner.StepInnerClient$iCallback$1$onStreamReceive$1", f = "StepInnerClient.kt", l = {84}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class StepInnerClient$iCallback$1$onStreamReceive$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f6204a;
    public final /* synthetic */ e b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepInnerClient$iCallback$1$onStreamReceive$1(e eVar, String str, int i, String str2, H7.c cVar) {
        super(2, cVar);
        this.b = eVar;
        this.c = str;
        this.d = i;
        this.e = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new StepInnerClient$iCallback$1$onStreamReceive$1(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((StepInnerClient$iCallback$1$onStreamReceive$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f6204a;
        if (i == 0) {
            kotlin.b.b(obj);
            i iVar = (i) this.b.c.get(this.c);
            if (iVar != null) {
                ChatData chatData = new ChatData(0, this.d, this.e, this.c);
                this.f6204a = 1;
                if (iVar.emit(chatData, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        if (this.d != 0) {
            this.b.c.remove(this.c);
            e eVar = this.b;
            ArrayList arrayList = eVar.d;
            int i6 = this.d;
            String str = this.e;
            synchronized (arrayList) {
                Iterator it = eVar.d.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).invoke(new Integer(i6), str);
                }
            }
        }
        return r.f317a;
    }
}
