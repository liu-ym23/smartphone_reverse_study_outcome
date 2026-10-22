package com.stepos.core.ota.confirmui;

import android.content.Context;
import com.stepos.core.download.IDownloadCallback;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements zb.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7502a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e6.a f7503b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IDownloadCallback f7504c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ModelConfirmFlow f7505d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f7506e;
    public final /* synthetic */ String h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f7507j;

    public /* synthetic */ h(e6.a aVar, IDownloadCallback iDownloadCallback, ModelConfirmFlow modelConfirmFlow, Context context, String str, CoroutineScope coroutineScope, int i10) {
        this.f7502a = i10;
        this.f7503b = aVar;
        this.f7504c = iDownloadCallback;
        this.f7505d = modelConfirmFlow;
        this.f7506e = context;
        this.h = str;
        this.f7507j = coroutineScope;
    }

    @Override // zb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f7502a) {
            case 0:
                return ModelConfirmFlow.startResume$lambda$11(this.f7503b, this.f7504c, this.f7505d, this.f7506e, this.h, this.f7507j, (String) obj, (ModelConfirmFlow) obj2);
            default:
                return ModelConfirmFlow.start$lambda$3(this.f7503b, this.f7504c, this.f7505d, this.f7506e, this.h, this.f7507j, (String) obj, (ModelConfirmFlow) obj2);
        }
    }
}
