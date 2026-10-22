package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/y;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/y;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ToolbarComponentCheckManager$removeDelayTaskByRemoveMsg$2 extends Lambda implements Function1<y, Unit> {
    final /* synthetic */ s $model;

    public ToolbarComponentCheckManager$removeDelayTaskByRemoveMsg$2(s r100) {
        this.$model = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(y r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        s r101 = this.$model;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Iterator<T> r102 = r100.f116219c.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        NewToolbarButtonConstants r103 = (NewToolbarButtonConstants) r102.next();
        if (r103.getId() != r101.f116191a) goto L4;
        r100.f116219c.remove(r103);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(y r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
