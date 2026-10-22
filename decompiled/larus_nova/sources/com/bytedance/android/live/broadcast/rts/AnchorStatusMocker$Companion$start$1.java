package com.bytedance.android.live.broadcast.rts;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.rts.foundation.m;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AnchorStatusMocker$Companion$start$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function2 $onStatusPanelMessage;

    public AnchorStatusMocker$Companion$start$1(Function2 r100) {
        this.$onStatusPanelMessage = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        LinkedHashMap r100 = new LinkedHashMap();
        m.e(r100, "tab_key", "some_tab_key_panel_msg");
        m.e(r100, "content", "some_content_panel_msg");
        this.$onStatusPanelMessage.invoke("tab-1", r100);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
