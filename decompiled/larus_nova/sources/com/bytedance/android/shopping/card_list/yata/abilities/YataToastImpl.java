package com.bytedance.android.shopping.card_list.yata.abilities;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import v96.g;

/* JADX INFO: loaded from: classes13.dex */
public final class YataToastImpl implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f172049a;

    public static final class a {
    }

    static {
    }

    public YataToastImpl(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f172049a = r100;
    }

    @Override // v96.g
    public final void a(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.card_list.utils.a.HandlerC2575a r101 = com.bytedance.android.shopping.card_list.utils.a.f171911a;
        com.bytedance.android.shopping.card_list.utils.a.b(new YataToastImpl$toast$1(this, r100));
    }
}
