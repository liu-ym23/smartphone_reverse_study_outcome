package b;

import com.stepos.cloud.securedata.StepOSCloudSecureDataSdk;

/* loaded from: classes.dex */
public final class e extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public ra.b f1069f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f1070g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ StepOSCloudSecureDataSdk f1071h;

    /* renamed from: i, reason: collision with root package name */
    public int f1072i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(StepOSCloudSecureDataSdk stepOSCloudSecureDataSdk, g7.d dVar) {
        super(dVar);
        this.f1071h = stepOSCloudSecureDataSdk;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f1070g = obj;
        this.f1072i |= Integer.MIN_VALUE;
        return this.f1071h.a(this);
    }
}
