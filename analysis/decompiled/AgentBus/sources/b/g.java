package b;

import c7.r;
import com.stepos.cloud.securedata.SdkException;
import com.stepos.cloud.securedata.StepOSCloudSecureDataSdk;
import w6.x;
import w7.e0;

/* loaded from: classes.dex */
public final class g extends i7.i implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public int f1077f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f1078g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f1079h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f1080i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String str, String str2, boolean z4, g7.d dVar) {
        super(1, dVar);
        this.f1078g = str;
        this.f1079h = str2;
        this.f1080i = z4;
    }

    @Override // i7.a
    public final g7.d create(g7.d dVar) {
        return new g(this.f1078g, this.f1079h, this.f1080i, dVar);
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        return ((g) create((g7.d) obj)).invokeSuspend(r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws SdkException {
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f1077f;
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
        this.f1077f = 1;
        Object objD = xVar.d(this.f1078g, this.f1079h, this.f1080i, this);
        return objD == aVar ? aVar : objD;
    }
}
