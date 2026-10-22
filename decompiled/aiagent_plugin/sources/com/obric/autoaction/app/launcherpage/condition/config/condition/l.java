package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.util.TypedValue;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.condition.config.condition.ui.RoundBackgroundSpan;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: Span.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static /* synthetic */ SpannableStringBuilder a(Context r1, String r2, int r3, Integer r4, Integer r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 16) == 0) goto L9;
        r5 = null;
    L9:
        return a(r8, r2, r3, r4, r5);
    }

    public static final SpannableStringBuilder a(Context r9, String r10, int r11, Integer r12, Integer r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r10, "text");
        SpannableStringBuilder r2 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin")).append((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).append((CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.aiagent.plugin"));
        o.a(r2);
        return a(r2, r3, r11, r12, 1, r10.length() + 1, r13);
    }

    private static final SpannableStringBuilder a(SpannableStringBuilder r18, Context r19, int r20, Integer r21, int r22, int r23, Integer r24) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        Float r3 = null;
        int r6 = p.b(ZeusTransformUtils.mapRes(R.color.oui_basic_fill_element_2, "color", "oui_basic_fill_element_2"), r1, null, 2, null);
        int r7 = p.b(r20, r1, null, 2, null);
        float r2 = 12;
        float r9 = TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics());
        float r10 = TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics());
        float r4 = 7;
        float r11 = TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics());
        float r12 = TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics());
        float r5 = TypedValue.applyDimension(2, 14, Resources.getSystem().getDisplayMetrics());
        if (r24 == null) goto L5;
        r3 = Float.valueOf(r24.intValue());
    L5:
        r18.setSpan(new RoundBackgroundSpan(r6, r7, null, r9, r10, r11, r12, r3, Float.valueOf(r5), r21, 4, null), r22, r23, 17);
        return r18;
    }
}
