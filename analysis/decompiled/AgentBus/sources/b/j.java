package b;

import c7.r;
import com.stepos.cloud.securedata.SdkConfig;
import com.stepos.cloud.securedata.StepOSCloudSecureDataSdk;
import ia.b0;
import ia.d0;
import ia.n0;
import p7.n;
import w5.m;
import w6.x;
import w7.e0;

/* loaded from: classes.dex */
public final class j extends i7.i implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1091f;

    /* renamed from: g, reason: collision with root package name */
    public int f1092g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(int i2, g7.d dVar, int i10) {
        super(i2, dVar);
        this.f1091f = i10;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f1091f) {
            case 0:
                return new j(2, dVar, 0);
            case 1:
                j jVar = new j(2, dVar, 1);
                jVar.f1092g = ((Number) obj).intValue();
                return jVar;
            case 2:
                return new j(2, dVar, 2);
            case 3:
                return new j(2, dVar, 3);
            case 4:
                return new j(2, dVar, 4);
            case 5:
                return new j(2, dVar, 5);
            case 6:
                return new j(2, dVar, 6);
            case 7:
                return new j(2, dVar, 7);
            case 8:
                return new j(2, dVar, 8);
            case 9:
                return new j(2, dVar, 9);
            default:
                return new j(2, dVar, 10);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1091f) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((j) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        g7.d dVar = null;
        switch (this.f1091f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f1092g;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                x xVar = StepOSCloudSecureDataSdk.f2701h;
                if (xVar == null) {
                    q7.k.j("secureKeyManager");
                    throw null;
                }
                SdkConfig sdkConfig = StepOSCloudSecureDataSdk.f2697d;
                if (sdkConfig == null) {
                    q7.k.j("config");
                    throw null;
                }
                String appId = sdkConfig.getAppId();
                SdkConfig sdkConfig2 = StepOSCloudSecureDataSdk.f2697d;
                if (sdkConfig2 == null) {
                    q7.k.j("config");
                    throw null;
                }
                String deviceId = sdkConfig2.getDeviceId();
                this.f1092g = 1;
                Object objE = xVar.e(appId, deviceId, this);
                return objE == aVar ? aVar : objE;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                e0.N(obj);
                return Boolean.valueOf(this.f1092g > 0);
            case 2:
                h7.a aVar3 = h7.a.f4212f;
                int i10 = this.f1092g;
                if (i10 == 0) {
                    e0.N(obj);
                    x5.b bVar = x5.b.f11221a;
                    this.f1092g = 1;
                    if (x5.b.f11221a.a(30000L, this) == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return r.f1986a;
            case 3:
                h7.a aVar4 = h7.a.f4212f;
                int i11 = this.f1092g;
                if (i11 == 0) {
                    e0.N(obj);
                    x5.b bVar2 = x5.b.f11221a;
                    x5.b.f11225e = 0L;
                    this.f1092g = 1;
                    if (x5.b.f11221a.a(30000L, this) == aVar4) {
                        return aVar4;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return r.f1986a;
            case 4:
                h7.a aVar5 = h7.a.f4212f;
                int i12 = this.f1092g;
                if (i12 == 0) {
                    e0.N(obj);
                    x5.b bVar3 = x5.b.f11221a;
                    x5.b.f11225e = 0L;
                    this.f1092g = 1;
                    if (x5.b.f11221a.a(30000L, this) == aVar5) {
                        return aVar5;
                    }
                } else {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return r.f1986a;
            case 5:
                h7.a aVar6 = h7.a.f4212f;
                int i13 = this.f1092g;
                if (i13 != 0) {
                    if (i13 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                pa.e eVar = n0.f4982a;
                pa.d dVar2 = pa.d.f8556h;
                h5.c cVar = new h5.c(2, dVar, 3);
                this.f1092g = 1;
                Object objB = d0.B(dVar2, cVar, this);
                return objB == aVar6 ? aVar6 : objB;
            case 6:
                h7.a aVar7 = h7.a.f4212f;
                int i14 = this.f1092g;
                if (i14 != 0) {
                    if (i14 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                this.f1092g = 1;
                Object objA = m.a("DNS_CLOUD_PROD", "DNS (云端生产)", "claw-connection-socket-mtls.stepaos.com", this);
                return objA == aVar7 ? aVar7 : objA;
            case 7:
                h7.a aVar8 = h7.a.f4212f;
                int i15 = this.f1092g;
                if (i15 != 0) {
                    if (i15 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                this.f1092g = 1;
                Object objA2 = m.a("DNS_CLOUD_NODE", "DNS (节点连接)", "claw-node-connection-socket.stepos.com", this);
                return objA2 == aVar8 ? aVar8 : objA2;
            case 8:
                h7.a aVar9 = h7.a.f4212f;
                int i16 = this.f1092g;
                if (i16 != 0) {
                    if (i16 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                this.f1092g = 1;
                Object objA3 = m.a("DNS_BASELINE", "DNS (基准对照)", "www.baidu.com", this);
                return objA3 == aVar9 ? aVar9 : objA3;
            case 9:
                h7.a aVar10 = h7.a.f4212f;
                int i17 = this.f1092g;
                if (i17 != 0) {
                    if (i17 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                this.f1092g = 1;
                Object objE2 = m.e(this);
                return objE2 == aVar10 ? aVar10 : objE2;
            default:
                h7.a aVar11 = h7.a.f4212f;
                int i18 = this.f1092g;
                if (i18 != 0) {
                    if (i18 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                    return obj;
                }
                e0.N(obj);
                this.f1092g = 1;
                Object objC = m.c(this);
                return objC == aVar11 ? aVar11 : objC;
        }
    }
}
