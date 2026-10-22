package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class NetworkRequestMethod$onResponseSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $data;
    final /* synthetic */ JSONObject $header;
    final /* synthetic */ int $statusCode;
    final /* synthetic */ NetworkRequestMethod this$0;

    public NetworkRequestMethod$onResponseSuccess$1(NetworkRequestMethod r100, int r101, JSONObject r102, String r103) {
        this.this$0 = r100;
        this.$statusCode = r101;
        this.$header = r102;
        this.$data = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        JSONObject r100 = new JSONObject();
        r100.put("statusCode", this.$statusCode);
        r100.put("header", this.$header);
        NetworkRequestMethod r101 = this.this$0;
        r100.put("data", this.$data);
        Unit r102 = Unit.INSTANCE;
        r101.r(r100);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
