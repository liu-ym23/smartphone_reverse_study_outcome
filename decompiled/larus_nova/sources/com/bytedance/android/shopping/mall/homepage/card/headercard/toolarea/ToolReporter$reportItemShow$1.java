package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ToolReporter$reportItemShow$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Map $globalProps;
    final /* synthetic */ ToolVO $item;
    final /* synthetic */ int $position;
    final /* synthetic */ h this$0;

    public ToolReporter$reportItemShow$1(h r100, ToolVO r101, int r102, Map r103) {
        this.this$0 = r100;
        this.$item = r101;
        this.$position = r102;
        this.$globalProps = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ToolVO r100 = this.$item;
        if (r100 == null) goto L6;
        String r101 = r100.getComponentId();
        if (r101 == null) goto L6;
    L8:
        if (r101.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
        return;
    L13:
        if (this.this$0.f177875a.contains(r101) == true) goto L17;
        this.this$0.f177875a.add(r101);
        h.a(this.this$0, this.$position, this.$item, this.$globalProps);
        return;
    L17:
        return;
    L10:
        r102 = false;
    L6:
        r101 = "";
        goto L8
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
