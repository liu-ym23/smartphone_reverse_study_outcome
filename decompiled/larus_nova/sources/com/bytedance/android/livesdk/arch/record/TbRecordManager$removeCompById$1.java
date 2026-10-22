package com.bytedance.android.livesdk.arch.record;

import com.bytedance.android.livesdk.arch.comp.b;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/arch/comp/b;", "kotlin.jvm.PlatformType", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/arch/comp/b;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class TbRecordManager$removeCompById$1 extends Lambda implements Function1<b, Boolean> {
    final /* synthetic */ b $comp;

    public TbRecordManager$removeCompById$1(b r100) {
        this.$comp = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(b r100) {
        ToolbarMatchInterface r101 = r100.d();
        if (r101 == null) goto L11;
        int r102 = r101.getComponentId();
        ToolbarMatchInterface r103 = this.$comp.d();
        if (r103 == null) goto L7;
        Integer r104 = Integer.valueOf(r103.getComponentId());
    L9:
        if (r102 != r104.intValue()) goto L11;
        return true;
    L7:
        r104 = null;
    L11:
        return false;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(b r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
