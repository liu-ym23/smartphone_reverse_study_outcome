package com.obric.init.task.comon;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.api.IObricProduct;
import d.h.b.h;

/* JADX INFO: compiled from: InitProductTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitProductTask implements IInitTask {
    public static final a Companion = null;
    public static final String ID = "INIT_PRODUCT_TASK";

    /* JADX INFO: compiled from: InitProductTask.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public InitProductTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        ILogDepend.Companion.i(ID, "run");
        IObricProduct r2 = IObricProduct.Companion.a();
        if (r2 == null) goto L6;
        r2.initProductSdk();
        return;
    }
}
