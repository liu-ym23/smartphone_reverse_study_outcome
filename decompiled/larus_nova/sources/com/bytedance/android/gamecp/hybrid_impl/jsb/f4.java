package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "getInstalledAppInfo")
public final class f4 extends g0<h4, GetInstalledAppInfoResultModel> {

    public static final class a {
    }

    public static final class b {
        public final Context getContext() {
            return null;
        }

        public static String a(Drawable r100) {
            if (r100 != null) goto L8;
            return null;
        L8:
            Bitmap r101 = Bitmap.createBitmap(r100.getIntrinsicWidth(), r100.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);     // Catch: IOException -> L7
            Canvas r102 = new Canvas(r101);     // Catch: IOException -> L7
            r100.setBounds(0, 0, r102.getWidth(), r102.getHeight());     // Catch: IOException -> L7
            r100.draw(r102);     // Catch: IOException -> L7
            ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: IOException -> L7
            r101.compress(Bitmap.CompressFormat.PNG, 20, r103);     // Catch: IOException -> L7
            return "data:image/png;base64," + Base64.encodeToString(r103.toByteArray(), 2);
        L7:
            return null;
        }
    }

    static {
    }

    public f4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        h4 r102 = (h4) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<String> r103 = r102.b();
        List<String> r104 = r103;
        if (r104 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        finishWithFailure(new Throwable("packages isEmpty"));
        return;
    L11:
        ThreadPoolHelper.d().submit(new g4(this, r101, r103, r102));
        return;
    L5:
        if (r104.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }
}
