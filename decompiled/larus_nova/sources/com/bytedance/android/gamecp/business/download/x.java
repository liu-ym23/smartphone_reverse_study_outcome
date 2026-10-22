package com.bytedance.android.gamecp.business.download;

import android.content.Context;
import com.bytedance.bpea.cert.token.TokenCert;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f52959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f52960b;

    public x(Context r100, p r101) {
        this.f52959a = r100;
        this.f52960b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        TokenCert r102 = ms.i.f515456a;
        ms.i.c(this.f52959a, this.f52960b);
    }
}
