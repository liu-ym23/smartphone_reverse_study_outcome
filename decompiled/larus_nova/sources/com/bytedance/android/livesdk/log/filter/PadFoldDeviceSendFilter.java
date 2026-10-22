package com.bytedance.android.livesdk.log.filter;

import android.app.Activity;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes10.dex */
public final class PadFoldDeviceSendFilter implements v, z81.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f153289a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PadFoldDeviceSendFilter f153290b = null;

    public PadFoldDeviceSendFilter() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f153290b = new PadFoldDeviceSendFilter();
        f153289a = LazyKt.lazy(PadFoldDeviceSendFilter$enable$2.INSTANCE);
    }

    public static String b() {
        Activity r100 = com.bytedance.android.live.core.utils.a.d();
        if (r100 != null) goto L6;
        return "";
    L6:
        if (FoldScreenUtils.f66393a != null) goto L8;
        FoldScreenUtils.f66393a = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
    L8:
        IMiddleWareHostContext r101 = FoldScreenUtils.f66393a;
        if (r101 == null) goto L11;
        int r102 = r101.getFoldStatusV3(r100);
    L12:
        if (r102 != (-1)) goto L15;
        return "";
    L15:
        return String.valueOf(r102);
    L11:
        r102 = -1;
        goto L12
    }

    public static boolean c(String r100) {
        if (((Boolean) f153289a.getValue()).booleanValue() == true) goto L6;
        return false;
    L6:
        switch(r100.hashCode()) {
            case -1122536402: goto L54;
            case -1115849514: goto L51;
            case -1103263308: goto L48;
            case -804282046: goto L45;
            case -597919004: goto L42;
            case -546689387: goto L39;
            case -505186085: goto L36;
            case 479193863: goto L33;
            case 516631638: goto L30;
            case 963627730: goto L27;
            case 1059589542: goto L24;
            case 1499179894: goto L21;
            case 1499265855: goto L18;
            case 1763681274: goto L15;
            case 2022034541: goto L12;
            case 2041791848: goto L9;
            default: goto L57;
        };
    L57:
        return false;
    L9:
        if (r100.equals("livesdk_like") == false) goto L57;
        return true;
    L12:
        if (r100.equals("livesdk_watch_onemin") == false) goto L57;
        return true;
    L15:
        if (r100.equals("livesdk_live_window_duration_v2") == false) goto L57;
        return true;
    L18:
        if (r100.equals("livesdk_live_show") == false) goto L57;
        return true;
    L21:
        if (r100.equals("livesdk_live_play") == false) goto L57;
        return true;
    L24:
        if (r100.equals("livesdk_live_user_report") == false) goto L57;
        return true;
    L27:
        if (r100.equals("livesdk_report_submit") == false) goto L57;
        return true;
    L30:
        if (r100.equals("livesdk_send_gift") == false) goto L57;
        return true;
    L33:
        if (r100.equals("livesdk_rec_live_play") == false) goto L57;
        return true;
    L36:
        if (r100.equals("livesdk_unfollow") == false) goto L57;
        return true;
    L39:
        if (r100.equals("livesdk_live_user_report_submit_success") == false) goto L57;
        return true;
    L42:
        if (r100.equals("livesdk_live_click_user") == false) goto L57;
        return true;
    L45:
        if (r100.equals("livesdk_follow") == false) goto L57;
        return true;
    L48:
        if (r100.equals("livesdk_dislike") == false) goto L57;
        return true;
    L51:
        if (r100.equals("livesdk_live_duration") == false) goto L57;
        return true;
    L54:
        if (r100.equals("livesdk_share") == false) goto L57;
        return true;
    }

    public static String a(int r100, int r101) {
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L4
        return String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r100 / r101)}, 1));
    L4:
        return "";
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        if (c(r100) == false) goto L12;
        ce1.d r102 = ce1.e.f23443a;
        if (r102 != null) goto L7;
    L9:
        String r103 = "0";
    L10:
        r101.put("is_pad_landscape", r103);
        r101.put("fold_position", b());
        int r104 = s1.y();
        int r105 = s1.w();
        StringBuilder r106 = new StringBuilder();
        r106.append(r104);
        r106.append(Permission.EXECUTE);
        r106.append(r105);
        r101.put("app_available_size", r106.toString());
        r101.put("app_aspect_ratio", a(r104, r105));
        return;
    L7:
        if (r102.e() != true) goto L9;
        r103 = "1";
        goto L10
    }
}
