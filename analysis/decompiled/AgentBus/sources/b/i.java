package b;

import com.stepos.cloud.securedata.StepOSCloudSecureDataSdk;

/* loaded from: classes.dex */
public final class i extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public StepOSCloudSecureDataSdk f1087f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f1088g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ StepOSCloudSecureDataSdk f1089h;

    /* renamed from: i, reason: collision with root package name */
    public int f1090i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(StepOSCloudSecureDataSdk stepOSCloudSecureDataSdk, g7.d dVar) {
        super(dVar);
        this.f1089h = stepOSCloudSecureDataSdk;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f1088g = obj;
        this.f1090i |= Integer.MIN_VALUE;
        return this.f1089h.b(this);
    }
}
