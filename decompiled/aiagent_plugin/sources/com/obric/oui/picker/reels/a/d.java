package com.obric.oui.picker.reels.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f35945a = null;

    static {
        f35945a = new d();
    }

    private d() {
    }

    public static /* synthetic */ List a(d r0, int r1, int r2, String r3, int r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = 2;
    L9:
        return r0.a(r1, r2, r3, r4);
    }

    public final List<String> a(int r4, int r5, String r6, int r7) {
        o.e(r6, "suffix");
        List<String> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        if (r4 > r5) goto L8;
    L4:
        int r0 = r4 + 1;
        r3.add(o.a(d.o.o.a(String.valueOf(r4), r7, '0'), r6));
        if (r4 == r5) goto L8;
        r4 = r0;
    L8:
        return r3;
    }

    public final List<String> a(Context r5, int r6, int r7) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        List<String> r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        if (r6 > r7) goto L23;
    L4:
        int r0 = r6 + 1;
        switch(r6) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L6:
        int r1 = ZeusTransformUtils.mapRes(R.string.oui_reel_picker_month_def, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_month_def");
    L19:
        String r2 = r4.getString(r1);
        o.c(r2, "context.getString(monthRes)");
        r8.add(r2);
        if (r6 == r7) goto L23;
        r6 = r0;
        goto L4
    L7:
        r1 = ZeusTransformUtils.mapRes(R.string.oui_reel_picker_month_dec, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_month_dec");
        goto L19
    L8:
        r1 = ZeusTransformUtils.mapRes(R.string.oui_reel_picker_month_nov, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_month_nov");
        goto L19
    L9:
        r1 = ZeusTransformUtils.mapRes(R.string.oui_reel_picker_month_oct, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_month_oct");
        goto L19
    L10:
        r1 = ZeusTransformUtils.mapRes(R.string.oui_reel_picker_month_sep, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_month_sep");
        goto L19
    L11:
        r1 = ZeusTransformUtils.mapRes(R.string.oui_reel_picker_month_aug, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_month_aug");
        goto L19
    L12:
        r1 = ZeusTransformUtils.mapRes(R.string.oui_reel_picker_month_jul, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_month_jul");
        goto L19
    L13:
        r1 = ZeusTransformUtils.mapRes(R.string.oui_reel_picker_month_jun, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_month_jun");
        goto L19
    L14:
        r1 = ZeusTransformUtils.mapRes(R.string.oui_reel_picker_month_may, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_month_may");
        goto L19
    L15:
        r1 = ZeusTransformUtils.mapRes(R.string.oui_reel_picker_month_apr, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_month_apr");
        goto L19
    L16:
        r1 = ZeusTransformUtils.mapRes(R.string.oui_reel_picker_month_mar, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_month_mar");
        goto L19
    L17:
        r1 = ZeusTransformUtils.mapRes(R.string.oui_reel_picker_month_feb, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_month_feb");
        goto L19
    L18:
        r1 = ZeusTransformUtils.mapRes(R.string.oui_reel_picker_month_jan, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_month_jan");
    L23:
        return r8;
    }
}
