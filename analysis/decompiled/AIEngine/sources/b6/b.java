package b6;

import com.stepos.aiengine.AIEngineApplication;
import com.stepos.core.common.cloud.BffGatewayBootstrap;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3057a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AIEngineApplication f3058b;

    public /* synthetic */ b(AIEngineApplication aIEngineApplication, int i10) {
        this.f3057a = i10;
        this.f3058b = aIEngineApplication;
    }

    @Override // zb.a
    public final Object invoke() {
        int i10 = this.f3057a;
        AIEngineApplication aIEngineApplication = this.f3058b;
        switch (i10) {
            case 0:
                int i11 = AIEngineApplication.f5748d;
                BffGatewayBootstrap.INSTANCE.setup(aIEngineApplication, new BffGatewayBootstrap.Params("ai-engine-test", "wjxJ8wrwRKUDG62Mc718", "ai-engine-prod", "6PrSFRURhIEplf9XcXCp"));
                return n.f10413a;
            default:
                return Boolean.valueOf(aIEngineApplication.f5750b.f5835d);
        }
    }
}
