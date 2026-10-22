package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.model.HttpResponse;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007¨\u0006\t"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "p1", "Lcom/bytedance/android/livesdkapi/model/HttpResponse;", "Lkotlin/ParameterName;", "name", "httpResponse", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/live/browser/jsbridge/newmethods/FetchV3Method$modifyHeadersAndGetResponseDecoder$decoder$2$channel$2$1", "com/bytedance/android/live/browser/jsbridge/newmethods/FetchV3Method$$special$$inlined$run$lambda$1"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class FetchV3Method$modifyHeadersAndGetResponseDecoder$$inlined$run$lambda$2 extends FunctionReferenceImpl implements Function1<HttpResponse, JSONObject> {
    final /* synthetic */ String $dataMessageName$inlined;
    final /* synthetic */ boolean $dynamic$inlined;
    final /* synthetic */ String $extraMessageName$inlined;
    final /* synthetic */ FetchV3Method$modifyHeadersAndGetResponseDecoder$1 $fromJsonResponse$1$inlined;
    final /* synthetic */ String $pageUrl$inlined;
    final /* synthetic */ JSONObject $pbExtras$inlined;
    final /* synthetic */ boolean $reportMetric$inlined;
    final /* synthetic */ long $startCreateDecodeTs$inlined;

    public FetchV3Method$modifyHeadersAndGetResponseDecoder$$inlined$run$lambda$2(JSONObject r100, String r101, boolean r102, FetchV3Method$modifyHeadersAndGetResponseDecoder$1 r103, String r104, String r105, boolean r106, long r107) {
        this.$pbExtras$inlined = r100;
        this.$pageUrl$inlined = r101;
        this.$dynamic$inlined = r102;
        this.$fromJsonResponse$1$inlined = r103;
        this.$dataMessageName$inlined = r104;
        this.$extraMessageName$inlined = r105;
        this.$reportMetric$inlined = r106;
        this.$startCreateDecodeTs$inlined = r107;
        super(1, null, "fromJsonResponse", "invoke(Lcom/bytedance/android/livesdkapi/model/HttpResponse;)Lorg/json/JSONObject;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final JSONObject invoke2(HttpResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return this.$fromJsonResponse$1$inlined.invoke2(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ JSONObject invoke(HttpResponse r100) {
        return invoke2(r100);
    }
}
