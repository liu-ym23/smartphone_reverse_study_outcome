package com.stepos.backend.llama;

import com.stepos.backend.onnx.TenVadOnnxModel;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5942a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f5943b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Serializable f5944c;

    public /* synthetic */ a(long j10, Serializable serializable, int i10) {
        this.f5942a = i10;
        this.f5943b = j10;
        this.f5944c = serializable;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f5942a) {
            case 0:
                return PrivacyClassifyJni.nativeClassify(this.f5943b, (String) this.f5944c);
            case 1:
                return ScpRiskModel.classifyOnce$lambda$9$lambda$8$lambda$7(this.f5943b, (String) this.f5944c);
            default:
                return Float.valueOf(TenVadOnnxModel.processInternal$lambda$10(this.f5943b, (short[]) this.f5944c));
        }
    }
}
