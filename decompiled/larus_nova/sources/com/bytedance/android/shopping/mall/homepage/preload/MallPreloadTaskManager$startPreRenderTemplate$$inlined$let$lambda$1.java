package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.shopping.api.mall.q;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/shopping/mall/homepage/preload/MallPreloadTaskManager$startPreRenderTemplate$1$1"}, k = 3, mv = {1, 4, 3})
final class MallPreloadTaskManager$startPreRenderTemplate$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List $cardList$inlined;
    final /* synthetic */ q $taskContext$inlined;
    final /* synthetic */ MallPreloadTaskManager this$0;

    public MallPreloadTaskManager$startPreRenderTemplate$$inlined$let$lambda$1(MallPreloadTaskManager r100, q r101, List r102) {
        this.this$0 = r100;
        this.$taskContext$inlined = r101;
        this.$cardList$inlined = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        MallPreloadTaskManager r100 = this.this$0;
        r100.f178379f = Boolean.FALSE;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
