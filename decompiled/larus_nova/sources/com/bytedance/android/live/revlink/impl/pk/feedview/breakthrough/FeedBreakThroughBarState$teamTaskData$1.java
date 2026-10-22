package com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class FeedBreakThroughBarState$teamTaskData$1 extends Lambda implements Function1<Map<String, Object>, Unit> {
    final /* synthetic */ String $value;

    public FeedBreakThroughBarState$teamTaskData$1(String r100) {
        this.$value = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.put("type", "refresh");
        r100.put("data", this.$value);
        r100.put("show_like_reword", Boolean.FALSE);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
