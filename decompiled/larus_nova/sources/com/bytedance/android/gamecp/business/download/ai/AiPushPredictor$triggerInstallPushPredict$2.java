package com.bytedance.android.gamecp.business.download.ai;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "code", "", "msg", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class AiPushPredictor$triggerInstallPushPredict$2 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ Function2 $onResult;
    final /* synthetic */ JSONObject $params;
    final /* synthetic */ int $sense;

    public AiPushPredictor$triggerInstallPushPredict$2(int r100, JSONObject r101, Function2 r102) {
        this.$sense = r100;
        this.$params = r101;
        this.$onResult = r102;
        super(2);
    }

    public final void invoke(int r100, String r101) {
        yr.c.e("push_calculate_trigger_predict", "用户画像数据获取失败,code=" + r100 + ",msg=" + r101);
        int r102 = AiPushPredictor.f52455b;
        AiPushPredictor.a(this.$sense, this.$params, this.$onResult);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, String r101) {
        invoke(r100.intValue(), r101);
        return Unit.INSTANCE;
    }
}
