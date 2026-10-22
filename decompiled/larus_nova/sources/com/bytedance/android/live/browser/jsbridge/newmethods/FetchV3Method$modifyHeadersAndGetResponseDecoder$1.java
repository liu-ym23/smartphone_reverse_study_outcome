package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.SystemClock;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"fromJsonResponse", "Lorg/json/JSONObject;", "httpResponse", "Lcom/bytedance/android/livesdkapi/model/HttpResponse;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class FetchV3Method$modifyHeadersAndGetResponseDecoder$1 extends Lambda implements Function1<HttpResponse, JSONObject> {
    final /* synthetic */ String $pageUrl;
    final /* synthetic */ boolean $reportMetric;
    final /* synthetic */ FetchV3Method this$0;

    public FetchV3Method$modifyHeadersAndGetResponseDecoder$1(FetchV3Method r100, String r101, boolean r102) {
        this.this$0 = r100;
        this.$pageUrl = r101;
        this.$reportMetric = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final JSONObject invoke2(HttpResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "httpResponse");
        long r101 = SystemClock.elapsedRealtime();
        String r102 = new String(r100.getBody(), Charsets.UTF_8);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
        JSONObject r104 = new JSONObject(r102);     // Catch: Throwable -> L10
        String r105 = this.$pageUrl;     // Catch: Throwable -> L10
        if (r105 != null) goto L6;
    L8:
        Object r106 = Result.m9449constructorimpl(FetchV3Method.j(this.this$0, r104, r100));     // Catch: Throwable -> L10
    L13:
        if (Result.m9456isSuccessimpl(r106) == false) goto L17;
        return (JSONObject) r106;
    L17:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L24;
        String r107 = r100.header(NetResponse.HEADER_KEY_LOG_ID);
        if (r107 != null) goto L22;
        r107 = "";
    L22:
        throw new RawNotJsonException(r102, r107);
    L24:
        return new JSONObject();
    L6:
        if (this.$reportMetric == false) goto L8;
        FetchV3Method r108 = this.this$0;     // Catch: Throwable -> L10
        long r109 = SystemClock.elapsedRealtime() - r101;     // Catch: Throwable -> L10
        int r110 = FetchV3Method.f63239e;     // Catch: Throwable -> L10
        r108.getClass();     // Catch: Throwable -> L10
        FetchV3Method.l(0, r105, r109);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ JSONObject invoke(HttpResponse r100) {
        return invoke2(r100);
    }
}
