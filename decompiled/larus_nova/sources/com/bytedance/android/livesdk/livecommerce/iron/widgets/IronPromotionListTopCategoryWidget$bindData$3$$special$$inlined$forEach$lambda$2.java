package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0005"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/livesdk/livecommerce/iron/widgets/IronPromotionListTopCategoryWidget$bindData$3$1$1$1$1", "com/bytedance/android/livesdk/livecommerce/iron/widgets/IronPromotionListTopCategoryWidget$bindData$3$$special$$inlined$let$lambda$1", "com/bytedance/android/livesdk/livecommerce/iron/widgets/IronPromotionListTopCategoryWidget$bindData$3$$special$$inlined$forEach$lambda$1"}, k = 3, mv = {1, 4, 3})
final class IronPromotionListTopCategoryWidget$bindData$3$$special$$inlined$forEach$lambda$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PromotionCategory $category;
    final /* synthetic */ f this$0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IronPromotionListTopCategoryWidget$bindData$3$$special$$inlined$forEach$lambda$2 f149151a;

        public a(IronPromotionListTopCategoryWidget$bindData$3$$special$$inlined$forEach$lambda$2 r100) {
            this.f149151a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f149151a.getClass();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public IronPromotionListTopCategoryWidget$bindData$3$$special$$inlined$forEach$lambda$2(PromotionCategory r100, f r101) {
        this.$category = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        oh.a.c("livesdk_list_tab_show", new a(this));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
