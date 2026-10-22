package com.bytedance.android.shopping.buynow.yata.abilities;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class BuyNowYataToastImpl implements v96.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f171279a;

    public static final class a {
    }

    static {
    }

    public BuyNowYataToastImpl(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f171279a = r100;
    }

    @Override // v96.g
    public final void a(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.buynow.utils.i.a r101 = com.bytedance.android.shopping.buynow.utils.i.f171212a;
        com.bytedance.android.shopping.buynow.utils.i.a(new BuyNowYataToastImpl$toast$1(this, r100));
    }
}
