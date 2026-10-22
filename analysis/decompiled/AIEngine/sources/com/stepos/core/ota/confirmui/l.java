package com.stepos.core.ota.confirmui;

import com.stepos.core.download.IDownloadCallback;
import com.stepos.core.ota.confirmui.ModelConfirmFlow;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements zb.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7514a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7515b;

    public /* synthetic */ l(Object obj, int i10) {
        this.f7514a = i10;
        this.f7515b = obj;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        int i10 = this.f7514a;
        Object obj2 = this.f7515b;
        switch (i10) {
            case 0:
                return Boolean.valueOf(ModelConfirmFlow.Companion.detachCallback$lambda$4$lambda$3$lambda$2((e6.a) obj2, (ModelConfirmFlow.Follower) obj));
            case 1:
                return ModelConfirmFlow.start$lambda$5((ModelConfirmFlow) obj2, (Throwable) obj);
            default:
                return ModelConfirmFlow$internalCb$1.onComplete$lambda$2((String) obj2, (IDownloadCallback) obj);
        }
    }
}
