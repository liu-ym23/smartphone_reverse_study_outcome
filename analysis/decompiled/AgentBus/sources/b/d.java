package b;

import com.stepos.cloud.securedata.StepOSCloudSecureDataSdk;

/* loaded from: classes.dex */
public final class d extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public StepOSCloudSecureDataSdk f1063f;

    /* renamed from: g, reason: collision with root package name */
    public String f1064g;

    /* renamed from: h, reason: collision with root package name */
    public String f1065h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f1066i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ StepOSCloudSecureDataSdk f1067j;

    /* renamed from: k, reason: collision with root package name */
    public int f1068k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(StepOSCloudSecureDataSdk stepOSCloudSecureDataSdk, g7.d dVar) {
        super(dVar);
        this.f1067j = stepOSCloudSecureDataSdk;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f1066i = obj;
        this.f1068k |= Integer.MIN_VALUE;
        return this.f1067j.encrypt(null, null, this);
    }
}
