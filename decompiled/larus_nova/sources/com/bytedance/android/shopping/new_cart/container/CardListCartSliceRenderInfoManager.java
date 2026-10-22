package com.bytedance.android.shopping.new_cart.container;

import android.os.Handler;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListCartSliceRenderInfoManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f178852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f178853b;

    public static final class a extends HandlerExecutorServiceImpl {
        public a(Handler r100) {
            super(r100);
        }

        @Override // com.facebook.common.executors.HandlerExecutorServiceImpl, java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            if (r100 == null) goto L8;
            Lazy r101 = UIUtils.f45548a;
            if (UIUtils.d() == false) goto L6;
            r100.run();
            return;
        L6:
            UIUtils.c().postAtFrontOfQueue(r100);
            return;
        }
    }

    public CardListCartSliceRenderInfoManager() {
        Lazy r100 = UIUtils.f45548a;
        this.f178852a = new a(UIUtils.c());
        this.f178853b = LazyKt.lazy(CardListCartSliceRenderInfoManager$fieldUIExecutor$2.INSTANCE);
    }
}
