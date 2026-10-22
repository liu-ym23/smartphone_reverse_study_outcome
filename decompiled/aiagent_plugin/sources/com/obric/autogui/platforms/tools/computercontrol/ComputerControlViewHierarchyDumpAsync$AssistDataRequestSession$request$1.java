package com.obric.autogui.platforms.tools.computercontrol;

import com.obric.capabilitykit.common.Ext;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;

/* JADX INFO: compiled from: ComputerControlViewHierarchyDumpAsync.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "ComputerControlViewHierarchyDumpAsync.kt", c = {OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP, 82, 178}, d = Ext.KEY_REQUEST, e = "com.obric.autogui.platforms.tools.computercontrol.ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession")
final class ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$1 extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ComputerControlViewHierarchyDumpAsync.AssistDataRequestSession this$0;

    ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$1(ComputerControlViewHierarchyDumpAsync.AssistDataRequestSession r3, d.c.d<? super ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$1> r4) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.request((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
    }
}
