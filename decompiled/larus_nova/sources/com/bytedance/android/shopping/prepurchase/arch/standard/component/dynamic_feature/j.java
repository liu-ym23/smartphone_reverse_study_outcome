package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f180950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ecom.arch.slice.slices.template.d f180951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f180952c;

    public j(l r100, com.bytedance.android.ecom.arch.slice.slices.template.d r101, String r102) {
        this.f180950a = r100;
        this.f180951b = r101;
        this.f180952c = r102;
    }

    public final void a() {
        l r100 = this.f180950a;
        JSONObject r101 = new JSONObject();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        Map<String, Object> r103 = this.f180951b.getData();     // Catch: Throwable -> L10
        if (r103 == null) goto L7;
        Object r104 = r103.get("product_status");     // Catch: Throwable -> L10
    L8:
        r101.put("product_status", r104);     // Catch: Throwable -> L10
        Result.m9449constructorimpl(r101.put("schema", this.f180952c));     // Catch: Throwable -> L10
    L12:
        Unit r105 = Unit.INSTANCE;
        r100.sendJsEvent("refresh_market_cart", r101);
        return;
    L7:
        r104 = null;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
