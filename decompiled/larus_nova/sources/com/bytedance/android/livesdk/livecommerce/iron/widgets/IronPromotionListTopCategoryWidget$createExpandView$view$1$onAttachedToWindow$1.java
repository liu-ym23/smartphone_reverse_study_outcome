package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import com.bytedance.android.livesdk.livecommerce.event.a1;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class IronPromotionListTopCategoryWidget$createExpandView$view$1$onAttachedToWindow$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IronPromotionListTopCategoryWidget$createExpandView$view$1 this$0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IronPromotionListTopCategoryWidget$createExpandView$view$1$onAttachedToWindow$1 f149153a;

        public a(IronPromotionListTopCategoryWidget$createExpandView$view$1$onAttachedToWindow$1 r100) {
            this.f149153a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            new a1(true, this.f149153a.this$0.f149152d.f149147m).k();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public IronPromotionListTopCategoryWidget$createExpandView$view$1$onAttachedToWindow$1(IronPromotionListTopCategoryWidget$createExpandView$view$1 r100) {
        this.this$0 = r100;
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
