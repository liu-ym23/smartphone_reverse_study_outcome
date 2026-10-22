package stepai.android.mindx.client.inner;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.stepos.taskrobot.llmapi.stepfun.g;
import java.util.Iterator;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import stepai.android.llm.base.log.ILLMLogger;
import stepai.android.mindx.base.LLMInterface;
import stepai.android.mindx.client.config.ConfigsKt;

/* loaded from: classes4.dex */
public final class a implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f6207a;

    public a(c cVar) {
        this.f6207a = cVar;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) throws JSONException {
        c cVar = this.f6207a;
        ILLMLogger.DefaultImpls.printI(cVar, "onBindingDied", ConfigsKt.TAG);
        cVar.d = null;
        cVar.f6209a.invoke(null);
        Iterator it = cVar.e.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) throws JSONException, RemoteException {
        IBinder iBinderAsBinder;
        c cVar = this.f6207a;
        g gVar = cVar.f6209a;
        LLMInterface lLMInterfaceAsInterface = LLMInterface.Stub.asInterface(iBinder);
        cVar.d = lLMInterfaceAsInterface;
        if (lLMInterfaceAsInterface == null) {
            ILLMLogger.DefaultImpls.printE(cVar, "connected is err, interface is null", ConfigsKt.TAG);
            gVar.invoke(null);
            return;
        }
        ILLMLogger.DefaultImpls.printI(cVar, "connected", ConfigsKt.TAG);
        try {
            LLMInterface lLMInterface = cVar.d;
            if (lLMInterface != null && (iBinderAsBinder = lLMInterface.asBinder()) != null) {
                iBinderAsBinder.linkToDeath(cVar.g, 0);
            }
        } catch (Exception e) {
            ILLMLogger.DefaultImpls.printE(cVar, "exception, " + e, ConfigsKt.TAG);
        }
        LLMInterface lLMInterface2 = cVar.d;
        if (lLMInterface2 != null) {
            lLMInterface2.init(cVar.b, "0.0.9-dev.1");
        }
        gVar.invoke(cVar.d);
        Iterator it = cVar.e.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            k.c(cVar.d);
            throw null;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) throws JSONException {
        c cVar = this.f6207a;
        ILLMLogger.DefaultImpls.printI(cVar, "disconnected", ConfigsKt.TAG);
        cVar.d = null;
        cVar.f6209a.invoke(null);
        Iterator it = cVar.e.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
    }
}
