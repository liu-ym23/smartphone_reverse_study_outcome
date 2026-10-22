package com.bytedance.android.ec.core.utils.font;

import android.content.Context;
import android.graphics.Typeface;
import com.android.ttcjpaysdk.base.utils.CJFontServiceUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements e {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.android.ec.core.utils.font.e
    public final Typeface a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return com.bytedance.android.ec.sdk.helper.d.f48119b.getIECHostUIService().a(r100, CJFontServiceUtils.DOUYIN_SANS_BOLD_FONT);
    }
}
