package com.bytedance.android.live.broadcastgame.opengame;

import android.util.Log;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f60744a = 0;

    public q() {
    }

    static {
    }

    public static /* synthetic */ void h(String r100) {
        g(r100, "");
    }

    public static void a(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        ALogger.d("OpenPlatformLog", "是否可以显示调试悬浮球: " + r100 + "，原因: " + r101);
    }

    public static void b(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        ALogger.d("OpenPlatformLog", "是否可调试当前小插件: " + r100 + "，原因: " + r101);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "url");
        ALogger.d("OpenPlatformLog", r100 + " 刷新: " + r101);
    }

    public static void e(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r101, "messages");
        d(6, r100, r101);
    }

    public static void f(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r101, "messages");
        d(4, r100, r101);
    }

    public static void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "log");
        Intrinsics.checkNotNullParameter(r101, "subTag");
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        String r103 = "OpenPlatformLog/".concat(r101);
    L9:
        ALogger.d(r103, r100);
        return;
    L8:
        r103 = "OpenPlatformLog";
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    public static void k(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r101, "messages");
        d(5, r100, r101);
    }

    public static void d(int r110, String r111, Object[] r112) {
        if (r111 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        String r113 = "OpenPlatformLog";
    L13:
        if (r112.length != 0) goto L15;
        boolean r101 = true;
    L16:
        String r102 = "";
        if (r101 == true) goto L56;
        if (r112.length != 1) goto L27;
        Object r114 = r112[0];
        if (r114 == null) goto L56;
        String r115 = r114.toString();
        if (r115 == null) goto L56;
        r102 = r115;
        goto L56
    L27:
        StringBuilder r103 = new StringBuilder();
        Object r104 = ArraysKt.lastOrNull(r112);
        if (r104 != null) goto L30;
    L36:
        int r105 = r112.length;
        int r106 = 0;
        int r107 = 0;
    L37:
        if (r106 >= r105) goto L54;
        Object r108 = r112[r106];
        int r109 = r107 + 1;
        if (r102.length() <= 0) goto L41;
        boolean r116 = true;
    L42:
        if (r116 == true) goto L44;
    L47:
        if (r108 != null) goto L49;
        r103.append("null");
    L53:
        r106 = r106 + 1;
        r107 = r109;
        goto L37
    L49:
        if ((r108 instanceof Throwable) == false) goto L51;
        r103.append(Log.getStackTraceString((Throwable) r108));
        goto L53
    L51:
        r103.append(r108);
        goto L53
    L44:
        if (r107 == (r112.length - 1)) goto L53;
        if (r107 == 0) goto L47;
        r103.append(r102);
        goto L47
    L41:
        r116 = false;
        goto L42
    L54:
        r102 = r103.toString();
        goto L56
    L30:
        if ((r104 instanceof Delimiter) == false) goto L32;
        String r117 = ((Delimiter) r104).getValue();
    L33:
        if (r117 == null) goto L36;
        r102 = r117;
        goto L36
    L32:
        r117 = "";
    L56:
        if (r110 != 4) goto L58;
        ALogger.i(r113, r102);
        return;
    L58:
        if (r110 != 5) goto L60;
        ALogger.w(r113, r102);
        return;
    L60:
        if (r110 != 6) goto L73;
        ALogger.e(r113, r102);
        return;
    L73:
        return;
    L15:
        r101 = false;
        goto L16
    L11:
        r113 = "OpenPlatformLog/" + r111;
        goto L13
    L5:
        if (r111.length() == 0) goto L8;
        r100 = false;
        goto L9
    }

    public static void i(Throwable r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, "subTag");
        Intrinsics.checkNotNullParameter(r102, "info");
        if ((r100 instanceof CustomApiServerException) == false) goto L6;
        g(r102 + " Api Error. LogId: " + ((CustomApiServerException) r100).getXTtLogId() + " Msg: " + r100.getMessage() + " StatusCode: " + r100 + '.', r101);
        return;
    L6:
        if ((r100 instanceof NetworkErrorException) == false) goto L8;
        g(r102 + ' ' + r100 + ", statusCode: " + ((NetworkErrorException) r100).statusCode + " msg: " + r100.getMessage(), r101);
        return;
    L8:
        g(r102 + ' ' + r100 + " msg: " + r100.getMessage(), r101);
    }

    public static /* synthetic */ void j(Throwable r100, String r101, int r102) {
        String r103 = "";
        if ((r102 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r102 & 4) != 0) goto L9;
        r103 = null;
    L9:
        i(r100, r101, r103);
    }
}
