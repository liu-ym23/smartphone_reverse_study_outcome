package com.bytedance.android.shopping.ligo.strategy.eventprocess.plugin;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LigoEventProcessPluginV3$appendParamsWithPattern$2 extends Lambda implements Function0<String> {
    final /* synthetic */ List $paramsPattern;
    final /* synthetic */ JSONObject $result;
    final /* synthetic */ c this$0;

    public LigoEventProcessPluginV3$appendParamsWithPattern$2(c r100, JSONObject r101, List r102) {
        this.$result = r101;
        this.$paramsPattern = r102;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        StringBuilder r100 = new StringBuilder("..append params with pattern: params result=");
        r100.append(this.$result);
        r100.append(", ruleName=");
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
