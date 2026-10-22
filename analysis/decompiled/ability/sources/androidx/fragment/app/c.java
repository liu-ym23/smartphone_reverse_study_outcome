package androidx.fragment.app;

import androidx.collection.ArrayMap;
import androidx.fragment.app.SpecialEffectsController;
import com.zyql.agentfront.sdk.client.AgentFrontClient$messageListenerStub$1;

/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1960a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ c(Object obj, Object obj2, boolean z10, Object obj3, int i) {
        this.f1960a = i;
        this.c = obj;
        this.d = obj2;
        this.b = z10;
        this.e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1960a) {
            case 0:
                DefaultSpecialEffectsController.startTransitions$lambda$9((SpecialEffectsController.Operation) this.c, (SpecialEffectsController.Operation) this.d, this.b, (ArrayMap) this.e);
                break;
            default:
                AgentFrontClient$messageListenerStub$1.onMessageSent$lambda$1((com.zyql.agentfront.sdk.client.b) this.c, (String) this.d, this.b, (String) this.e);
                break;
        }
    }
}
