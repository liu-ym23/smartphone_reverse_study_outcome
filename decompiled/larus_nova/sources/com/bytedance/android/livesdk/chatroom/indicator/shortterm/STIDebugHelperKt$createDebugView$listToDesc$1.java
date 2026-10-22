package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import com.bytedance.android.livesdkapi.sti.ShortTermIcon;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "list", "", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class STIDebugHelperKt$createDebugView$listToDesc$1 extends Lambda implements Function1<List<? extends ShortTermIcon>, String> {
    final /* synthetic */ ShortTermIndicatorManager $manager;

    public STIDebugHelperKt$createDebugView$listToDesc$1(ShortTermIndicatorManager r100) {
        this.$manager = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(List<? extends ShortTermIcon> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(List<ShortTermIcon> r110) {
        Intrinsics.checkNotNullParameter(r110, "list");
        return "详情：" + CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, new STIDebugHelperKt$createDebugView$listToDesc$1$desc$1(this), 30, null);
    }
}
