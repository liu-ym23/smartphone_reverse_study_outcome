package com.obric.autoaction.app.launcherpage.condition.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.utils.j;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TimeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final String a(int r4) {
        switch(r4) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_week_day_7, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_week_day_7"));
        o.c(r5, "getString(...)");
        return r5;
    L6:
        String r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_week_day_6, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_week_day_6"));
        o.c(r6, "getString(...)");
        return r6;
    L7:
        String r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_week_day_5, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_week_day_5"));
        o.c(r7, "getString(...)");
        return r7;
    L8:
        String r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_week_day_4, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_week_day_4"));
        o.c(r8, "getString(...)");
        return r8;
    L9:
        String r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_week_day_3, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_week_day_3"));
        o.c(r9, "getString(...)");
        return r9;
    L10:
        String r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_week_day_2, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_week_day_2"));
        o.c(r10, "getString(...)");
        return r10;
    L11:
        String r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_week_day_1, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_week_day_1"));
        o.c(r11, "getString(...)");
        return r11;
    }

    public static final List<j<Integer>> a(int[] r15) {
        if (r15 != null) goto L5;
        r15 = new int[]{LocalDate.now().getDayOfWeek().getValue()};
    L5:
        List<j<Integer>> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        int r5 = 0;
    L6:
        if (r5 >= 7) goto L8;
        r5 = r5 + 1;
        String r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.condition_week_full_format, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_week_full_format"), new Object[]{a(r5)});
        o.c(r7, "getString(...)");
        r2.add(new j(r7, false, Integer.valueOf(r5), null, null, 26, null));
        goto L6
    L8:
        int r3 = r15.length;
        int r6 = 0;
    L9:
        if (r6 >= r3) goto L24;
        int r8 = r15[r6];
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r9.hasNext() == false) goto L19;
        Object r10 = r9.next();
        if (((Number) ZeusTransformUtils.preCheckCast(((j) ZeusTransformUtils.preCheckCast(r10, j.class, "com.obric.aiagent.plugin")).c(), Number.class, "com.obric.aiagent.plugin")).intValue() != r8) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == false) goto L12;
    L20:
        j r12 = (j) ZeusTransformUtils.preCheckCast(r10, j.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L23;
        r12.a(true);
    L23:
        r6 = r6 + 1;
        goto L9
    L16:
        r11 = false;
        goto L17
    L19:
        r10 = null;
        goto L20
    L24:
        return r2;
    }
}
