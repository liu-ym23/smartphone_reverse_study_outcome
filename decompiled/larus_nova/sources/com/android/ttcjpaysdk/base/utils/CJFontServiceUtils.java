package com.android.ttcjpaysdk.base.utils;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.api.font.CJFontService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ud4.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJFontServiceUtils;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "fontName", "Lud4/a;", "callback", "", "setDouyinTextFont", "DOUYIN_SANS_BOLD_FONT", "Ljava/lang/String;", "Lcom/bytedance/caijing/sdk/infra/base/api/font/CJFontService;", "fontService$delegate", "Lkotlin/Lazy;", "getFontService", "()Lcom/bytedance/caijing/sdk/infra/base/api/font/CJFontService;", "fontService", "<init>", "()V", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class CJFontServiceUtils {
    public static final String DOUYIN_SANS_BOLD_FONT = "DouyinSansBold.otf";
    public static final CJFontServiceUtils INSTANCE = null;
    private static final Lazy fontService$delegate = null;

    private CJFontServiceUtils() {
    }

    static {
        INSTANCE = new CJFontServiceUtils();
        fontService$delegate = LazyKt.lazy(CJFontServiceUtils$fontService$2.INSTANCE);
    }

    private final CJFontService getFontService() {
        return (CJFontService) fontService$delegate.getValue();
    }

    public final void setDouyinTextFont(Context r100, String r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fontName");
        Intrinsics.checkNotNullParameter(r102, "callback");
        CJFontService r103 = getFontService();
        if (r103 == null) goto L6;
        r103.setDouyinTextFont(r100, r101, r102);
        return;
    }
}
