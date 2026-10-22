package com.stepos.backend.qnn;

import com.stepos.backend.qnn.QnnImageInpaintAigcModel;
import com.stepos.backend.qnn.QnnTTSModel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6075a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f6076b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f6077c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f6078d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f6079e;

    public /* synthetic */ m(QnnTTSModel qnnTTSModel, String str, String str2, boolean z) {
        this.f6079e = qnnTTSModel;
        this.f6076b = str;
        this.f6077c = str2;
        this.f6078d = z;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f6075a) {
            case 0:
                return Integer.valueOf(QnnImageInpaintAigcModel.AnonymousClass2.invokeSuspend$lambda$0(this.f6076b, this.f6077c, (String) this.f6079e, this.f6078d));
            default:
                return QnnTTSModel.AnonymousClass2.invokeSuspend$lambda$0((QnnTTSModel) this.f6079e, this.f6076b, this.f6077c, this.f6078d);
        }
    }

    public /* synthetic */ m(String str, String str2, String str3, boolean z) {
        this.f6076b = str;
        this.f6077c = str2;
        this.f6079e = str3;
        this.f6078d = z;
    }
}
