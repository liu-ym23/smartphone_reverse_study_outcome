package com.obric.autoaction.app.launcherpage.module.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.module.a.a.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

/* JADX INFO: compiled from: AutoActionTaskListItemDateView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionTaskListItemDateView extends RelativeLayout {
    private final DateTimeFormatter mDateFormatter;
    private final TextView mTxtDate;
    private final View mView;

    public AutoActionTaskListItemDateView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public AutoActionTaskListItemDateView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ AutoActionTaskListItemDateView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public AutoActionTaskListItemDateView(Context r4, AttributeSet r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r6);
        View r9 = ZeusTransformUtils.inflate(LayoutInflater.from(r7), ZeusTransformUtils.mapRes(R.layout.autoaction_task_list_date, "layout", "autoaction_task_list_date"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        o.c(r9, "inflate(...)");
        this.mView = r9;
        this.mTxtDate = (TextView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.txt_tli_date, DbHelper.COL_ID, "txt_tli_date")), TextView.class, "com.obric.aiagent.plugin");
        DateTimeFormatter r10 = DateTimeFormatter.ofPattern(ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.tli_task_date_format, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_date_format")));
        o.c(r10, "ofPattern(...)");
        this.mDateFormatter = r10;
    }

    public final void fitData(g r3) {
        o.e(r3, "data");
        TextView r0 = this.mTxtDate;
        if (r0 == null) goto L6;
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(getDateStr(r3.a()), CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final String getDateStr(LocalDate r8) {
        LocalDate r0 = LocalDate.now();
        if (o.a(r8, r0) == false) goto L7;
        String r7 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.tli_task_date_today, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_date_today"));
        o.c(r7, "getString(...)");
        return r7;
    L7:
        if (o.a(r8, r0.minusDays(1)) == false) goto L11;
        String r9 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.tli_task_date_yesterday, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_date_yesterday"));
        o.c(r9, "getString(...)");
        return r9;
    L11:
        if (o.a(r8, r0.plusDays(1)) == false) goto L15;
        String r10 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.tli_task_date_tomorrow, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_date_tomorrow"));
        o.c(r10, "getString(...)");
        return r10;
    L15:
        if (r8.isAfter((ChronoLocalDate) ZeusTransformUtils.preCheckCast(r0.plusDays(1), ChronoLocalDate.class, "com.obric.aiagent.plugin")) == false) goto L18;
        String r11 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.tli_task_date_future, WsChannelMultiProcessSharedProvider.STRING_TYPE, "tli_task_date_future"));
        o.c(r11, "getString(...)");
        return r11;
    L18:
        String r12 = r8.format(this.mDateFormatter);
        o.c(r12, "format(...)");
        return r12;
    }
}
