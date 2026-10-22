package b;

import com.stepos.cloud.securedata.StepOSCloudSecureDataSdk;

/* loaded from: classes.dex */
public final class c extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public StepOSCloudSecureDataSdk f1056f;

    /* renamed from: g, reason: collision with root package name */
    public String f1057g;

    /* renamed from: h, reason: collision with root package name */
    public String f1058h;

    /* renamed from: i, reason: collision with root package name */
    public String f1059i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f1060j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ StepOSCloudSecureDataSdk f1061k;

    /* renamed from: l, reason: collision with root package name */
    public int f1062l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(StepOSCloudSecureDataSdk stepOSCloudSecureDataSdk, g7.d dVar) {
        super(dVar);
        this.f1061k = stepOSCloudSecureDataSdk;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f1060j = obj;
        this.f1062l |= Integer.MIN_VALUE;
        return this.f1061k.decrypt(null, null, null, this);
    }
}
