package com.bytedance.android.shopping.anchorv4.schemav2;

import com.bytedance.android.shopping.anchorv4.data.SchemaDiffResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes12.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpSchemaOld2NewConverter f167437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f167438b;

    public m(PdpSchemaOld2NewConverter r100, String r101) {
        this.f167437a = r100;
        this.f167438b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SchemaDiffResult r101 = (SchemaDiffResult) r100;
        this.f167437a.b(r101.getOldPackReq(), r101.getNewPackReq(), "schemaDiffServerParam", this.f167438b);
        this.f167437a.b(r101.getOnLineV2PackReq(), r101.getNewPackReq(), "onlineDiffServerParam", this.f167438b);
    }
}
