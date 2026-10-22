package com.bytedance.android.shopping.buynow.yata.abilities;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonToast;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements v96.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f171304a;

    public static final class a {
    }

    static {
    }

    public m(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f171304a = r100;
    }

    @Override // v96.g
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        int r101 = SkuCommonToast.f182777a;
        SkuCommonToast.b(this.f171304a, r100);
    }
}
