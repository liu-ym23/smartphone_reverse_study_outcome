package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ProductTag;", "", "Lpy/k;", "icon", "Lpy/k;", "", "content", "Ljava/lang/String;", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductTag implements h {

    @SerializedName("content")
    public String content;

    @SerializedName("icon")
    public k icon;

    public ProductTag() {
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public ProductTag(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.icon = f.a(r100, k.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.content = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
