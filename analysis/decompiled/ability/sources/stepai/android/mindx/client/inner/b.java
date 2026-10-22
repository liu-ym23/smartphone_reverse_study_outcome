package stepai.android.mindx.client.inner;

import android.app.Application;
import android.os.IBinder;
import org.json.JSONException;
import stepai.android.llm.base.log.ILLMLogger;
import stepai.android.mindx.base.LLMInterface;
import stepai.android.mindx.client.config.ConfigsKt;

/* loaded from: classes4.dex */
public final class b implements IBinder.DeathRecipient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f6208a;

    public b(c cVar) {
        this.f6208a = cVar;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() throws JSONException {
        c cVar = this.f6208a;
        ILLMLogger.DefaultImpls.printI(cVar, "died", ConfigsKt.TAG);
        LLMInterface lLMInterface = cVar.d;
        if (lLMInterface != null) {
            try {
                IBinder iBinderAsBinder = lLMInterface.asBinder();
                if (iBinderAsBinder != null) {
                    iBinderAsBinder.unlinkToDeath(this, 0);
                }
            } catch (Exception unused) {
                ILLMLogger.DefaultImpls.printE(cVar, "disconnected", ConfigsKt.TAG);
            }
            cVar.d = null;
            cVar.f6209a.invoke(null);
        }
        ILLMLogger.DefaultImpls.printI(cVar, "restart service", ConfigsKt.TAG);
        Application application = cVar.c;
        if (application != null) {
            cVar.a(application);
        }
    }
}
