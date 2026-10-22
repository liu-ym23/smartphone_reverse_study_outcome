package com.android.ttcjpaysdk.base.ktextension;

import android.util.Log;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.lynx.tasm.LynxError;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\b"}, d2 = {"e", "", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "content", "", LynxError.LYNX_THROWABLE, "", RXScreenCaptureService.KEY_INDEX, "cj-host-service-api_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ICJTagKt {
    public static final void i(ICJTag r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        a.f554342a.getClass();
        ALogService r102 = (ALogService) a.a(ALogService.class);
        if (r102 == null) goto L9;
        String r103 = r100.CJTag();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r102.i(r103, r101);
        return;
    }

    public static final void e(ICJTag r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r103 = r101 + '\n' + Log.getStackTraceString(r102);
        a.f554342a.getClass();
        ALogService r104 = (ALogService) a.a(ALogService.class);
        if (r104 == null) goto L9;
        String r105 = r100.CJTag();
        if (r105 != null) goto L7;
        r105 = "";
    L7:
        r104.e(r105, r103);
        return;
    }

    public static /* synthetic */ void e$default(ICJTag r100, String r101, Throwable r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        e(r100, r101, r102);
    }
}
