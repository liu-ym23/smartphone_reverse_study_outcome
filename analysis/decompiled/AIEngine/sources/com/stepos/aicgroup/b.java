package com.stepos.aicgroup;

import com.stepos.core.ota.crypto.OtaAtRestDecryptor;
import com.stepos.cpuset.internal.CpuSetNativeKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5687a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5688b;

    public /* synthetic */ b(int i10, int i11) {
        this.f5687a = i11;
        this.f5688b = i10;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f5687a) {
            case 0:
                return AiCGroupManager.f5593a.getCGroup(this.f5688b, CpuSetNativeKt.LIBRARY_NAME_CPU_SET);
            default:
                return OtaAtRestDecryptor.resolveViaMemfd$lambda$10(this.f5688b);
        }
    }
}
