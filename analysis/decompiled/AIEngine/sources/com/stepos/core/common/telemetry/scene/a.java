package com.stepos.core.common.telemetry.scene;

import com.stepos.deepbinder.service.DeepBinderProvider;
import m0.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7395a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7396b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7397c;

    public /* synthetic */ a(int i10, int i11, Object obj) {
        this.f7395a = i11;
        this.f7397c = obj;
        this.f7396b = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7395a) {
            case 0:
                AiStageSceneDonator.scheduleExitRetry$lambda$11(this.f7396b, (String) this.f7397c);
                break;
            case 1:
                DeepBinderProvider.processMethodRecycleRemote$lambda$1((long[]) this.f7397c, this.f7396b);
                break;
            default:
                ((f.c) this.f7397c).b(this.f7396b);
                break;
        }
    }

    public /* synthetic */ a(int i10, String str) {
        this.f7395a = 0;
        this.f7396b = i10;
        this.f7397c = str;
    }
}
