package com.android.ttcjpaysdk.base.ktextension;

import android.util.Log;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.lynx.tasm.LynxError;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import ve4.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u001e\u0010\u0007\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "", "CJTag", "", "d", "", "content", "e", LynxError.LYNX_THROWABLE, "", RXScreenCaptureService.KEY_INDEX, "w", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJTag {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void d(ICJTag r100, String r101) {
            ALogService r102 = (ALogService) b.b(ALogService.class);
            if (r102 == null) goto L9;
            String r103 = r100.CJTag();
            if (r103 != null) goto L7;
            r103 = "";
        L7:
            r102.d(r103, r101);
            return;
        }

        public static void i(ICJTag r100, String r101) {
            ALogService r102 = (ALogService) b.b(ALogService.class);
            if (r102 == null) goto L9;
            String r103 = r100.CJTag();
            if (r103 != null) goto L7;
            r103 = "";
        L7:
            r102.i(r103, r101);
            return;
        }

        public static void w(ICJTag r100, String r101) {
            ALogService r102 = (ALogService) b.b(ALogService.class);
            if (r102 == null) goto L9;
            String r103 = r100.CJTag();
            if (r103 != null) goto L7;
            r103 = "";
        L7:
            r102.w(r103, r101);
            return;
        }

        public static void e(ICJTag r100, String r101, Throwable r102) {
            String r103 = r101 + '\n' + Log.getStackTraceString(r102);
            ALogService r104 = (ALogService) b.b(ALogService.class);
            if (r104 == null) goto L9;
            String r105 = r100.CJTag();
            if (r105 != null) goto L7;
            r105 = "";
        L7:
            r104.e(r105, r103);
            return;
        }

        public static /* synthetic */ void e$default(ICJTag r100, String r101, Throwable r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.e(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
        }
    }

    String CJTag();

    void d(String r100);

    void e(String r100, Throwable r101);

    void i(String r100);

    void w(String r100);
}
