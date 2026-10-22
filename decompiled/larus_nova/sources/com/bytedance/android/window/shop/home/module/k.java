package com.bytedance.android.window.shop.home.module;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public interface k {

    public static final class a {
        public static View a(k r100, int r101) {
            com.bytedance.android.window.shop.home.module.a r102 = (com.bytedance.android.window.shop.home.module.a) r100;
            r102.getClass();
            ShoppingAsyncInflater.a r103 = ShoppingAsyncInflater.f45268e;
            Context r104 = r102.a().f450907b;
            if (r104 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        L5:
            Context r105 = th.a.e(r104, true);
            r103.getClass();
            return ShoppingAsyncInflater.a.a(r105).aU(r101, null, false);
        }
    }
}
