package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ToolbarComponentCheckManager$removeDelayTaskByRemoveMsg$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ s $model;

    public ToolbarComponentCheckManager$removeDelayTaskByRemoveMsg$1(s r100) {
        this.$model = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Lazy r100 = ToolbarComponentCheckManager.f115947a;
        Iterator<T> r101 = ToolbarComponentCheckManager.f115951e.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        NewToolbarButtonConstants r102 = (NewToolbarButtonConstants) r101.next();
        if (r102.getId() != this.$model.f116191a) goto L4;
        Lazy r103 = ToolbarComponentCheckManager.f115947a;
        ToolbarComponentCheckManager.f115951e.remove(r102);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
