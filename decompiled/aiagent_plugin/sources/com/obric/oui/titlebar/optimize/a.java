package com.obric.oui.titlebar.optimize;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OCTitleBarExt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final OButton a(OCTitleBar r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        o.e(r5, "context");
        return a(r3, r5, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_trans_icon_button, "layout", "o_widget_titlebar_trans_icon_button"));
    }

    public static final OButton a(OCTitleBar r2, Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "<this>");
        o.e(r5, "context");
        View r6 = ZeusTransformUtils.inflate(LayoutInflater.from(r5), r4, (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r6, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        return (OButton) ZeusTransformUtils.preCheckCast(r6, OButton.class, "com.obric.aiagent.plugin");
    }
}
