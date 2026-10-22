package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.os.Build;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillListActionButtonStyle.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class bj {
    public static final void a(OButton r3) {
        d.h.b.o.e(r3, "<this>");
        r3.setChangeAlphaWhenDisable(true);
        r3.setDisabledTextAlpha(1.0f);
        a(r3, ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, "color", "oui_accent_6_bg"));
    }

    public static final void b(OButton r3) {
        d.h.b.o.e(r3, "<this>");
        r3.setChangeAlphaWhenDisable(false);
        r3.setDisabledTextAlpha(0.3f);
        a(r3, ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1"));
    }

    private static final void a(OButton r0, int r1) {
        r0.setTextColor(b(r0, r1));
    }

    private static final int b(OButton r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r4, "getContext(...)");
        return a(r4, r3);
    }

    private static final int a(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getColor(r4, r5.getTheme());
    L6:
        return ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getColor(r4);
    }
}
