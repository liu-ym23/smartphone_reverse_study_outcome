package com.bytedance.android.live.saas.middleware.base;

import android.app.Application;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0004H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "C", "", "init", "", "app", "Landroid/app/Application;", "params", "(Landroid/app/Application;Ljava/lang/Object;)V", "unInit", "middleware_release"}, k = 1, mv = {1, 4, 3})
public interface ISdkInitTask<C> {
    void init(Application r100, C r101);

    void unInit();
}
