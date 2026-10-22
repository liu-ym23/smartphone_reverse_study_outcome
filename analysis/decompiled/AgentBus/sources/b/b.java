package b;

import android.content.Context;
import android.util.Log;
import c7.l;
import c7.m;
import c7.r;
import com.stepos.agentbus.platform.AgentBusApp;
import com.stepos.cloud.securedata.InitResult;
import com.stepos.cloud.securedata.SdkConfig;
import com.stepos.cloud.securedata.SecureDataEnvironment;
import com.stepos.cloud.securedata.StepOSCloudSecureDataSdk;
import s2.w;
import w6.p;
import w7.e0;

/* loaded from: classes.dex */
public final class b extends i7.i implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1053f;

    /* renamed from: g, reason: collision with root package name */
    public int f1054g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1055h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Object obj, g7.d dVar, int i2) {
        super(1, dVar);
        this.f1053f = i2;
        this.f1055h = obj;
    }

    @Override // i7.a
    public final g7.d create(g7.d dVar) {
        switch (this.f1053f) {
            case 0:
                return new b((String) this.f1055h, dVar, 0);
            case 1:
                return new b((w) this.f1055h, dVar, 1);
            default:
                return new b((AgentBusApp) this.f1055h, dVar, 2);
        }
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        g7.d dVar = (g7.d) obj;
        switch (this.f1053f) {
        }
        return ((b) create(dVar)).invokeSuspend(r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        Object objN;
        switch (this.f1053f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f1054g;
                r rVar = r.f1986a;
                if (i2 == 0) {
                    e0.N(obj);
                    w6.j jVar = StepOSCloudSecureDataSdk.f2700g;
                    if (jVar == null) {
                        q7.k.j("publicKeyStore");
                        throw null;
                    }
                    p pVar = StepOSCloudSecureDataSdk.f2698e;
                    if (pVar == null) {
                        q7.k.j("runtimeConfig");
                        throw null;
                    }
                    SecureDataEnvironment secureDataEnvironment = pVar.f10815a;
                    String str = (String) this.f1055h;
                    this.f1054g = 1;
                    Object objH = jVar.f10806a.h(new w2.c(new w6.g(jVar, secureDataEnvironment, str, null), null, 1), this);
                    if (objH != aVar) {
                        objH = rVar;
                    }
                    if (objH == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return rVar;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f1054g;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                w wVar = (w) this.f1055h;
                this.f1054g = 1;
                Object objInvoke = wVar.invoke(this);
                return objInvoke == aVar2 ? aVar2 : objInvoke;
            default:
                h7.a aVar3 = h7.a.f4212f;
                int i11 = this.f1054g;
                try {
                    if (i11 == 0) {
                        e0.N(obj);
                        AgentBusApp agentBusApp = (AgentBusApp) this.f1055h;
                        StepOSCloudSecureDataSdk stepOSCloudSecureDataSdk = StepOSCloudSecureDataSdk.INSTANCE;
                        Context applicationContext = agentBusApp.getApplicationContext();
                        q7.k.d(applicationContext, "getApplicationContext(...)");
                        String strE = e0.E(agentBusApp.getApplicationContext());
                        if (strE == null) {
                            strE = "";
                        }
                        SdkConfig sdkConfig = new SdkConfig("cloud-claw-chat", strE);
                        this.f1054g = 1;
                        obj = stepOSCloudSecureDataSdk.init(applicationContext, sdkConfig, this);
                        if (obj == aVar3) {
                            return aVar3;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e0.N(obj);
                    }
                    objN = (InitResult) obj;
                } catch (Throwable th) {
                    objN = e0.n(th);
                }
                if (!(objN instanceof l)) {
                    InitResult initResult = (InitResult) objN;
                    Log.i("AgentBusApp", "SecureData SDK init ok, publicKey=" + initResult.getPublicKeySource() + ", session=" + initResult.getEncryptedKeySource());
                }
                Throwable thA = m.a(objN);
                if (thA != null) {
                    Log.w("AgentBusApp", "SecureData SDK init failed (business encrypt will retry): " + thA.getMessage(), thA);
                }
                return r.f1986a;
        }
    }
}
